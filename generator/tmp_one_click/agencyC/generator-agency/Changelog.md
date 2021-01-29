# changelog
## v1.4.0

(2020-04-27)

Add:

1. 适配FISCO BCOS节点2.4.0版本

## v1.3.0

(2020-03-31)

Add:

1. 适配FISCO BCOS节点2.3.0版本

## v1.2.0

(2019-12-26)

Add:

1. 适配FISCO BCOS节点2.2.0版本

## v1.1.0

(2019-09-18)

Add:

1. 适配FISCO BCOS节点2.1.0版本

## v1.0.0

(2019-07-08)

Add:

1. python2.7+版本的download会使用环境变量中的代理进行下载
2. 底层适配版本升级至release-2.0.0
3. download命令会尝试从cdn获取二进制

## v1.0.0-rc3

(2019-06-04)

Add:

1. 增加了一键部署脚本
2. 底层适配版本升级至rc3
3. download_fisco命令目前会获取github release页面最新的二进制

Bugfix：

1. 修复了网络环境较差情况下异常抛出的提示

## v1.0.0-rc2

(2019-04-25)

Add:

1. 调整机构生成创世区块的方式
2. 调整机构生成生成节点的方式
3. 调整私钥导入及节点证书生成方式
4. 修改了配置文件一些字段的名称

Bugfix：

1. 修复了一些异常抛出的问题

## v1.0.0-rc1

(2019-03-18)

Add:

1. 提供快速部署多机构多群组联盟链的功能
2. 提供面向多机构多群组联盟链的轻量级管理服务，包括密钥管理
3. 提供多种监控节点方式和上报手段，可通过微信、网页、企业微信等方式获知节点运行情况