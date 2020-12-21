pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';
import './FoundationMaterialManager.sol';
import './LocationManager.sol';

contract RequestManager is Authentication {
    struct Req {
        uint[] varieties;
        uint[] amounts;
        address reciver;
        //0 未处理 1 同意请求 2 拒绝请求 3 物资已发送
        uint state;
        string waybillNum;
    }

    mapping(uint => Req) private reqMap;
    mapping(uint => uint) private lockedMaterials;
    string private name;
    uint[] private agreedReq;
    uint private lastNum;
    uint private num;
    uint private agreedLastNum;
    address private materialManager;

    constructor (address _materialManager, string memory _name) public {
        materialManager = _materialManager;
        name = _name;
        num = 0;
        lastNum = 0;
    }
    
    event createReqEvent(address _a);
    event handledReqEvent(uint num);
    event sendedEvent(uint num);

    //判断应该交由处理时，不然有限的物资可能对应着多个请求。返回请求编号
    function CreateReq(uint[] memory _varieties, uint[] memory _amounts) public onlyAuth returns(uint) {
        require(_varieties.length == _amounts.length, "Length not equal");
        reqMap[num].reciver = msg.sender;
        reqMap[num].varieties = _varieties;
        reqMap[num].amounts = _amounts;
        emit createReqEvent(msg.sender);
        num++;
        return num - 1;
    }
    
    //获取累积处理的请求数量
    function getNum() public onlyOwner view returns(uint) {
        return lastNum;
    }

    function getReqState(uint _num) public view returns(uint){
        return reqMap[_num].state;
    }

    // 虽然会有不能按顺序处理已同意请求的情况，但这里不考虑，全部按线性流程走
    function setWayBillNum(uint _num, string memory _waybillNum) public onlyOwner {
        require(_num < lastNum, "there is no such reqeust");
        require(reqMap[_num].state == 1, "This waybill hasn't be handled or be refused");
        require(bytes(reqMap[_num].waybillNum).length == 0, "Set Already");
        reqMap[_num].waybillNum = _waybillNum;
        reqMap[_num].state == 3;
        agreedLastNum++;
        emit sendedEvent(_num);
    }

    function getWayBillNum(uint _num) public view returns(string memory) {
        require(_num < num, "there is no such reqeust");
        require(reqMap[_num].state == 1, "This waybill hasn't be handled or be refused");
        require(bytes(reqMap[_num].waybillNum).length != 0, "There is no waybill for this req");
        return reqMap[_num].waybillNum;
    }
    
    //因为不支持多重数组所以只能一个一个请求处理
    function getReq() public view onlyOwner returns(uint[] memory, uint[] memory, address reciver) {
        require(lastNum < num, "there is no request needs to be handled");
        return (reqMap[lastNum].varieties, reqMap[lastNum].amounts, reqMap[lastNum].reciver);
    }

    function getAgreedReq() public view onlyOwner returns(uint, uint[] memory, uint[] memory, address reciver) {
        require(agreedLastNum < agreedReq.length, "there is no request needs to be handled");
        return (agreedReq[agreedLastNum], reqMap[agreedReq[agreedLastNum]].varieties, reqMap[agreedReq[agreedLastNum]].amounts, 
        reqMap[agreedReq[agreedLastNum]].reciver);
    }

    //获取列表头的请求，即getReq所获得的内容。请求应该按照时间顺序处理
    function handleReq(uint state) public onlyOwner returns(bool){
        require(lastNum < num, "there is no request needs to be handled");
        if(state == 2) {
            emit handledReqEvent(lastNum);
            return false;
        }
        for(uint i = 0; i < reqMap[lastNum].varieties.length; i++) {
            if(FoundationMaterialManager(materialManager).getVarietyAmount(reqMap[lastNum].varieties[i]) - lockedMaterials[reqMap[lastNum].varieties[i]] < reqMap[lastNum].amounts[i]) {
                lastNum++;
                reqMap[lastNum].state = 2;
                emit handledReqEvent(lastNum);
                return false;
            }
        }
        reqMap[lastNum].state = 1;
        agreedReq.push(lastNum);
        emit handledReqEvent(lastNum);
        lastNum++;
        return true;
    }

    function registry(address locationManager) public onlyOwner {
        LocationManager(locationManager).setAddress(address(this), name);
    }
}