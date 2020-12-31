<template>
  <div class="dashboard-container">
    <div class="dashboard-text">name: {{ name }}</div>
    <table border="1">
      <tr>
        <td>id</td>
        <td>种类</td>
        <td>数量</td>
        <td>是否被使用</td>
        <td>所有单位</td>
        <td>负责人</td>
        <td>物流</td>
      </tr>
      <tr v-for="(ft,index) in formdata">
        <td>{{ft.id}}</td>
        <td>{{ft.variety}}</td>
        <td>{{ft.amount}}</td>
        <td>{{ft.used}}</td>
        <td>{{ft.curHolder}}</td>
        <td>{{ft.manager}}</td>
        <button @click="getMore(index,ft.id)">详细</button>
      </tr>
    </table>
    <div v-if="moreInformation">
      <h2>{{moreId}}的物流信息</h2>
      <table>
        <tr>
          <td>时间</td>
          <td>地点</td>
          <td>行为</td>
        </tr>
        <tr v-for="tk in thisTrans">
          <td>{{tk.time}}</td>
          <td>{{tk.position}}</td>
          <td>{{tk.action}}</td>
        </tr>
      </table>
    </div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'
import axios from 'axios'

export default {
  name: 'Dashboard',
  computed: {
    ...mapGetters([
      'name'
    ])
  },
  data()
  {
    return {
      formdata:null,
      moreInformation:false,
      moreId:null,
      transportIn:
      [
        [
          {time:"10-9 10:00",position:"东湖车站",action:"发出"},
          {time:"10-10 11:00",position:"南湖小区",action:"接收"},
          {time:"10-10 13:00",position:"南湖小区",action:"发出"},
          {time:"10-11 14:30",position:"西华门医院",action:"接收"},
        ],
        [
        ],
        [
        ],
        [
        ],
      ],
      thisTrans:null,
    }
  },
  created() {
    let that =this;
    axios.get('/apis/getMaterials').then(
      (response)=>{
        that.formdata=response.data;
      }
    ).catch((error)=>{console.log(error)});
  },
  methods:{
    getMore:function (index,id) {
      this.moreId=id;
      this.moreInformation=!this.moreInformation;
      this.thisTrans=this.transportIn[index];
    }
  }
}
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
