pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';
import './FoundationMaterialManager.sol';

contract RequestManager is Authentication{
    struct Req {
        uint[] varieties;
        uint[] amounts;
        address reciver;
        //0 未处理 1 同意请求 2 拒绝请求
        uint state;
        string waybillNum;
    }
    
    mapping(uint => Req) reqMap;
    uint private lastNum;
    uint private num;
    uint private lastNum;
    address private materialManager;
    constructor (address _materialManager) public {
        materialManager = _materialManager;
        num = 0;
        lastNum = 0;
    }
    
    event CreateReqEvent(address _a);
    //判断应该交由处理时，不然有限的物资可能对应着多个请求。
    function CreateReq(uint[] memory _varieties, uint[] memory _amounts) public onlyAuth returns(bool) {
        require(_varieties.length == _amounts.length, "Length not equal");
        reqMap[num].reciver = msg.sender;
        reqMap[num].varieties = _varieties;
        reqMap[num].amounts = _amounts;
        emit CreateReqEvent(msg.sender);
        num++;
        return true;
    }
    
    //获取累积处理的请求数量
    function GetNum() public onlyOwner view returns(uint) {
        return num;
    }

    function GetReqState(uint num) public view returns(bool){
        return reqMap[num].state;
    }

    function GetWayBillNum(uint num, string memory ) {
        require(reqMap[num].state == 1, "This waybill hasn't be handled or be refused");
    }

    function SetWayBillNum(uint num, string memory _waybillNum) {
        require(reqMap[num].state == 1, "This waybill hasn't be handled or be refused");
        require(reqMap[num].waybillNum == "", "Set Already");
        reqMap[num].waybillNum = _waybillNum;
    }

    function GetWayBillNum(uint num) {
        require(reqMap[num].state == 1, "This waybill hasn't be handled or be refused");
        require(reqMap[num].waybillNum != "", "There is no waybill for this req");
        return reqMap[num].waybillNum;
    }
    
    //因为不支持多重数组所以只能一个一个请求处理
    function GetReq() public view onlyOwner returns(uint[] memory, uint[] memory, address reciver) {
        return (reqMap[lastNum].varieties, reqMap[lastNum].amounts, reqMap[lastNum].reciver);
    }

    //获取列表头的请求。请求应该按照时间顺序处理
    function HandleReq(uint num, uint state) public onlyOwner returns(bool){
        for(uint i = 0; i < reqMap[lastNum].varieties.length; i++) {
            if(FoundationMaterialManager(materialManager).GetVarietyAmount(reqMap[lastNum].varieties[i]) < reqMap[lastNum].amounts[i]) {
                lastNum++;
                return false;
            }
        }
        reqMap[lastNum].state = state;
        lastNum++;
        return true;
    }
}