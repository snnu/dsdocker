## platform 

### /v1/platform/address 

#### /allowRegistryAddress

**说明：** 允许某一地址有注册自身的权限，此处由各App自行调用

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
address|Y|String|0x1356943c6b6cfd3ff42aec3a6cb863135108e804|合约或节点的地址值

#### /disallowRegistryAddress

**说明：** 移除某一地址注册自身的权限

**RequestMethod：** POST

**返回值/类型：** 执行成功标志/boolean

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
address|Y|String|0x1356943c6b6cfd3ff42aec3a6cb863135108e804|合约或节点的地址值

#### /getLocationManagerAddress

**说明：** 获取当前 LocationManager 的合约地址

**返回值/类型：** 合约地址/String

**RequestMethod：** GET

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
/|/|/|/|/

### v1/platform/foundation

#### /getVarietiesAmounts

**说明：** 获取目标基金会存有的物资量

**返回值/类型：** 类型与数量的对象/{}

**RequestMethod：** POST

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2,3]|类型列表
foundationMaterialManagerName|Y|String|foundationMaterialManager|foundationMaterialManager 的名称

### v1/platform/hospital

#### /getVarietiesAmounts

**说明：** 获取目标医院存有的物资量

**返回值/类型：** 类型与数量的对象/{}

**RequestMethod：** POST

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
varieties|Y|[]|[1,2,3]|类型列表
hospitalMaterialManagerName|Y|String|hospitalMaterialManager|hospitalMaterialManager 的名称

### v1/platform/waybill

#### /getStatusByNumber

**说明：** 获取目标物流单内物资的状态

**返回值/类型：** 类型与数量及使用状态的对象/{}

**RequestMethod：** POST

变量名|必填|类型|示例值|描述
:--|:--|:--|:--|:--
waybillNumber|Y|String|20201228033427|物流单号
waybillManagerName|Y|String|waybillManager|物流管理合约的名称