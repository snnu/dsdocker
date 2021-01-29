pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';
import './FoundationMaterialManager.sol';
import './LocationManager.sol';

contract RequestManager is Authentication {
    struct Req {
        uint[] varieties;
        uint[] amounts;
        address reciver;
        //0 未处理 1 同意请求 2 拒绝请求 3 物资已发送 //拼错了，将错就错吧，懒得改了
        uint state;
        string waybillNum;
    }

    Req[] private reqMap;
    mapping(uint => uint) private lockedMaterials;
    string private name;
    uint[] private agreedReq;
    uint private lastNum;
    uint private agreedLastNum;
    address private materialManager;

    constructor (address _materialManager, string memory _name) public {
        materialManager = _materialManager;
        name = _name;
        lastNum = 0;
        agreedLastNum = 0;
    }
    
    event createReqEvent(address _a);
    event handledReqEvent(uint num);
    event sendedEvent(uint num);

    // 判断应该交由处理时，不然有限的物资可能对应着多个请求。返回请求编号
    function createReq(uint[] memory _varieties, uint[] memory _amounts) public onlyAuth returns(uint) {
        require(_varieties.length == _amounts.length, "Length not equal");
        reqMap.push(Req(_varieties, _amounts, msg.sender, 0, ""));
        // reqMap[num].reciver = msg.sender;
        // reqMap[num].varieties = _varieties;
        // reqMap[num].amounts = _amounts;
        // reqMap[num].state = 0;
        emit createReqEvent(msg.sender);
        // num++;
        return reqMap.length - 1;
    }
    
    //获取累积处理的请求数量
    function getNum() public view returns(uint) {
        return lastNum;
    }

    function getTotal() public view returns(uint) {
        return reqMap.length;
    }

    // 获取某一请求的状态
    function getReqState(uint _num) public view returns(uint){
        return reqMap[_num].state;
    }

    // 向某一请求写入已发送的物流单号
    function setWayBillNum(uint _num, string memory _waybillNum) public onlyOwner {
        require(_num < lastNum, "there is no such reqeust");
        require(reqMap[_num].state == 1, "This waybill hasn't be handled or be refused");
        require(bytes(reqMap[_num].waybillNum).length == 0, "Set Already");
        reqMap[_num].waybillNum = _waybillNum;
        reqMap[_num].state == 3;
        agreedLastNum++;
        emit sendedEvent(_num);
    }

    // 获取某一请求的物流单号
    function getWayBillNum(uint _num) public view returns(string memory) {
        require(_num < reqMap.length, "there is no such reqeust");
        require(_num < lastNum, "this request hasn't been handled");
        require(reqMap[_num].state == 3, "there is no waybill for this req");
        return reqMap[_num].waybillNum;
    }
    
    //因为不支持多重数组所以只能一个一个请求处理
    function getReq() public view onlyOwner returns(uint, uint[] memory, uint[] memory, address reciver) {
        require(lastNum < reqMap.length, "there is no request needs to be handled");
        return (lastNum, reqMap[lastNum].varieties, reqMap[lastNum].amounts, reqMap[lastNum].reciver);
    }

    // 获取下一个已被同意的请求的内容
    function getAgreedReq() public view onlyOwner returns(uint, uint[] memory, uint[] memory, address reciver) {
        require(agreedLastNum < agreedReq.length, "there is no agreed request needs to be handled");
        return (agreedReq[agreedLastNum], reqMap[agreedReq[agreedLastNum]].varieties, reqMap[agreedReq[agreedLastNum]].amounts, 
        reqMap[agreedReq[agreedLastNum]].reciver);
    }

    function getLockedMaterial(uint _variety) public view onlyOwner returns(uint) {
        return lockedMaterials[_variety];
    }

    function setLockedMaterial(uint _num) public onlyOwner {
        uint i;
        for(i = 0; i < reqMap[_num].varieties.length; i++) {
            lockedMaterials[reqMap[_num].varieties[i]] -= reqMap[_num].amounts[i];
        }
    }

    //获取列表头的请求，即getReq所获得的内容。请求应该按照时间顺序处理
    function handleReq(uint state) public onlyOwner returns(bool){
        require(lastNum < reqMap.length, "there is no request needs to be handled");
        if(state == 2) {
            emit handledReqEvent(lastNum);
            return false;
        }
        uint i;
        for(i = 0; i < reqMap[lastNum].varieties.length; i++) {
            // materialManager 看不到被锁的物资的量。在应用层传入被 requestManager 锁定的量
            if(FoundationMaterialManager(materialManager).getVarietyAmount(reqMap[lastNum].varieties[i]) - lockedMaterials[reqMap[lastNum].varieties[i]] < reqMap[lastNum].amounts[i]) {
                lastNum++;
                reqMap[lastNum].state = 2;
                emit handledReqEvent(lastNum);
                return false;
            }
        }
        for(i = 0; i < reqMap[lastNum].varieties.length; i++) {
            lockedMaterials[reqMap[lastNum].varieties[i]] += reqMap[lastNum].amounts[i];
        }
        reqMap[lastNum].state = 1;
        agreedReq.push(lastNum);
        emit handledReqEvent(lastNum);
        lastNum++;
        return true;
    }

    // 注册自身 
    function registry(address locationManager) public onlyOwner {
        LocationManager(locationManager).setAddress(address(this), name);
    }
}