## foundation 

### v1/foundation/waybill

#### /recive

**说明：** 获取某一物流订单对应的物资入库

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
number|Y|String|20201217081946|物流合约的编号
waybillManagerName|Y|String|waybillManager|WaybillManager的注册名

#### /delivery

**说明：** 传递某一物流订单所需的物资地址（logistic deployByAddress 调用）

**RequestMethod：** POST

**返回值/类型：** 合约地址列表/[]

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2]|各条物资对应的种类
amounts|Y|[]|[3,4]|各条物资对应给的数量
waybillManagerName|Y|String|waybillManager|WaybillManager 的注册名
number|Y|String|20201217081946|物流合约的编号

#### /requestCreateWaybill

**说明：** 请求创建发给某一医院的物流订单

**RequestMethod：** POST

**返回值/类型：** 物流单号/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
hospitalMaterialManagerName|Y|String|hospitalMaterialManager|医院物资管理合约注册名
logisticName|Y|String|logistic|物流服务商注册名（此处传入的IP固定）
varieties|Y|[]|[1,2]|各条物资对应的种类
amounts|Y|[]|[3,4]|各条物资对应给的数量

### v1/foundation/request

#### /getNextRequest

**说明：** 查看下一个需要处理的请求内容

**RequestMethod：** GET

**返回值/类型：** 请求物资类型与数量/{[], []}

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

#### /setState

**说明：** 给获得的请求进行通过或拒绝

**RequestMethod：** POST

**返回值/类型：** 请求被通过或被拒绝/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
state|Y|int|2|1为拒绝，2为同意

#### /sendMaterial

**说明：** 给已同意的请求的队列中的下一个发送物资

**RequestMethod：** POST

**返回值/类型：** 物流单号/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

### v1/foundation/material

#### /getMaterialAmounts

**说明：** 查询特某些定类的库存

**RequestMethod：** POST

**返回值/类型：** 物资列表/[]

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2]|需要查询的种类的列表

### v1/foundation/address

#### /nodeRegistry 

**说明：** 向 LocationManager 注册当前节点

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

#### /foundationMaterialManagerRegistry

**说明：** 向 LocationManager 注册当前 foundationMaterialManager

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

#### /requestManagerRegistry

**说明：** 向 LocationManager 注册当前 requestManagerRegistry

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

#### /allowHospital

**说明：** 允许某一医院节点有请求的权限

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
address|Y|String|0x1356943c6b6cfd3ff42aec3a6cb863135108e804|合约或节点的地址值

#### /disallowHospital

**说明：** 移除某一医院节点请求的权限

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
address|Y|String|0x1356943c6b6cfd3ff42aec3a6cb863135108e804|合约或节点的地址值