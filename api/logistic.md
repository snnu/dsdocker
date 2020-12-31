## logistic

### /v1/logistic/waybill

#### /deployByMaterial

**说明：** 通过物资类型和数量创建物流合约，由捐赠者发起捐赠时调用

**RequestMethod：** POST

**返回值/类型：** 订单编号/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
reciverName|Y|String|foundationMaterialManager|节点物资管理合约的注册名
varieties|Y|[]|[1,2]|各条物资对应的种类
amounts|Y|[]|[3,4]|各条物资对应给的数量

#### /deployByAddress

**说明：** 通过已经存在的物资合约创建物流合约，由foundation发起物流时调用，不通过前端直接调用

**RequestMethod：** POST

**返回值/类型：** 订单编号/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
reciverAddress|Y|String|foundationMaterialManager|节点物资管理合约的注册名
varieties|Y|[]|[1,2]|各条物资对应的种类
amounts|Y|[]|[3,4]|各条物资对应给的数量
foundationName|Y|String|foundation|基金会的名称（传入的IP地址是固定的）

### v1/logistic/address

#### /getWaybillAddress

**说明：** 获取对应订单编号获取物流合约地址

**RequestMethod：** GET

**返回值/类型：** 合约地址/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
number|Y|String|20201217081946|物流合约的编号

#### /nodeRegistry 

**说明：** 向 LocationManager 注册当前节点

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

#### /waybillRegistry

**说明：** 向 LocationManager 注册当前 WaybillManager

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/