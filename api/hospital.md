

## hospital 

### v1/hospital/waybill

#### /recive

**说明：** 获取某一物流订单对应的物资入库

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
number|Y|String|20201217081946|物流合约的编号
waybillManagerName|Y|String|waybillManager|WaybillManager的注册名
reciver|Y|String|路人甲|签收人名称

### v1/hospital/request

#### /requestMaterials

**说明：** 向某一基金会请求物资

**RequestMethod：** POST

**返回值/类型：** 请求编号/int

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2]|请求的物资的类型
amounts|Y|[]|[1,1]|请求的物资的数量
requestManagerName|Y|String|requestManager|requestManager的注册名

#### /getRequestStatus

**说明：** 获取某一请求的状态

**RequestMethod：** POST

**返回值/类型：** 当前的状态/int（0：未处理 1：同意待发送物资 2：拒绝 3：已发送物资）

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
num|Y|int|1|请求的编号
requestManagerName|Y|String|requestManager|requestManager的注册名

#### /getWaybillNum

**说明：** 获取某一已发送物资的请求的物流单号

**RequestMethod：** POST

**返回值/类型：** 物流单号/String

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
num|Y|int|1|请求的编号
requestManagerName|Y|String|requestManager|requestManager的注册名

### v1/hospital/material

#### /getMaterialAmounts

**说明：** 查询特某些定类的库存

**RequestMethod：** POST

**返回值/类型：** 物资列表/[]

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2]|需要查询的种类的列表

#### /useMaterial

**说明：** 出库使用物资

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
variety|Y|int|1|物资类别
amount|Y|int|1|物资数量