<template>
  <div class="dashboard-container">
    <h1>UserControl</h1>
    <div v-if="userTable !== null">
      <table border="1">
        <tr>
          <td>版本</td>
          <td>名字</td>
          <td>密码</td>
          <td>电话</td>
          <td>邮箱</td>
        </tr>
        <tr v-for="(vt, index) in userTable">
          <td v-if="editorState[index]">{{ vt.version }}</td>
          <td v-if="editorState[index]">{{ vt.name }}</td>
          <td v-if="editorState[index]">{{ vt.pw }}</td>
          <td v-if="editorState[index]">{{ vt.telephone }}</td>
          <td v-if="editorState[index]">{{ vt.email }}</td>

          <td v-if="!editorState[index]"><input v-model="vt.version" /></td>
          <td v-if="!editorState[index]"><input v-model="vt.name" /></td>
          <td v-if="!editorState[index]"><input v-model="vt.pw" /></td>
          <td v-if="!editorState[index]"><input v-model="vt.telephone" /></td>
          <td v-if="!editorState[index]"><input v-model="vt.email" /></td>
          <button @click="changed(index)">修改</button>
          <button>删除</button>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { mapGetters } from "vuex";
import axios from "axios";

export default {
  name: "Dashboard",
  computed: {
    ...mapGetters(["name"]),
  },
  data() {
    return {
      userTable: null,
      editorState: [],
    };
  },
  created() {
    let that = this;
    axios
      .get("/apis/getAllUser")
      .then((response) => {
        that.userTable = response.data;
        for (let i = 0; i < that.userTable.length; i++)
          that.editorState.push(true);
        //console.log(that.editorState);
      })
      .catch((error) => {
        console.log(error);
      });
  },
  methods: {
    changed: function (index) {
      if (!this.editorState[index]) {
        let that = this;
        console.log(that.userTable[index]);
        axios
          .post("/apis/modifyUser", that.userTable[index], {
            headers: {
              'Content-Type': 'application/json'
            },
          })
          .then((respond) => {
            console.log(respond);
          })
          .catch((error) => {
            console.log(error);
          });
      }
      this.editorState[index] = !this.editorState[index];
      this.$forceUpdate(); //强制数据刷新
    },
  },
};
</script>

<style lang="scss" scoped>
.dashboard {
  &-container {
    margin: 30px;
  }
  &-text {
    font-size: 30px;
    line-height: 46px;
  }
}
</style>
