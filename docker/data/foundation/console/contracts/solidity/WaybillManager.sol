pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';
import './LocationManager.sol';

// 在实际工作中，订单查询应该是公开功能，订单操作应该是物流公司私有行为

contract WaybillManager is Authentication {
    //订单号到订到合约地址的映射
    mapping(string => address) private waybillMap;
    //订单号到该订单所有物资的合约地址的映射
    mapping(string => address[]) private materilMap;
    string private name;

    
    constructor(string memory _name) public {
        name = _name;
    }
    
    //获取某个订单的合约地址
    function getWallbillAddress(string memory _number) public view returns(address) {
        return waybillMap[_number];
    }
    
    //存储某个订单的合约地址
    function setWallbillAddress(string memory _number, address _waybillAddress) public onlyOwner {
        waybillMap[_number] = _waybillAddress;
    }
    
    //  获取某个订单所有物资的合约地址
    // 如果需要授权，那就必须针对每个物流单号进行授权管理，否则授权后所有订单都可以查看，不如这样实现大众监察
    function getMaterials(string memory number) public view returns(address[] memory){
        return materilMap[number];
    }
    
    //存储某个订单所有物资的合约地址
    // 可以通过Waybill合约直接获取，是否没必要？
    function setMaterials(string memory number, address[] memory _addresses) public onlyOwner {
        for(uint i = 0; i < _addresses.length; i++) {
            materilMap[number].push(_addresses[i]);
        }
    }

    function registry(address locationManager) public onlyOwner {
        LocationManager(locationManager).setAddress(address(this), name);
    }
}