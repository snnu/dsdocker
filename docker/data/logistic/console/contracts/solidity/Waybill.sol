pragma solidity >=0.4.24 < 0.5.2;

import "./Material.sol";
import "./Authentication.sol";

contract Waybill is Authentication {

    // 所有物资的合约地址
    address[] private materialArr;
    // 订单号
    string private number;
    // 订单签收确认标志
    bool private reciverConfirm;
    // 接收方账号地址
    address private reciver;
    
    constructor (address _reciver, string memory _number) public {
        number = _number;
        reciver = _reciver;
    }
    
    modifier onlyReciver() {
        require(msg.sender == reciver, "Auth: only the reciver can confirm");
        _;
    }
    
    event setMaterialEvent();
    event setMaterialArrEvent();
    event resetMaterialEvent(uint i);
    event setReciverConfirmEvent();
    event setMaterialsOwnerEvent();

    // 是没有登记在区块链上的物资，通过物资类别和数量为每一条创建对应物资合约
    function setMaterial(uint[] memory _varietyArr, uint[] memory _amountArr) public onlyOwner {
        require(_varietyArr.length == _amountArr.length, "There are something wrong with materialArr");
        for(uint i = 0; i < _varietyArr.length; i++) {
            for(uint j = 0; j < _amountArr[i]; j++) {
                materialArr.push(address(new Material(_varietyArr[i], 1)));
                Material(materialArr[materialArr.length - 1]).setCurHolder(getOwner());
            }
        }
        emit setMaterialEvent();
    }
    
    // 在区块链上登记了的物资，直接传入物资合约地址
    function setMaterialArr(address[] memory _materialArr) public onlyOwner {
        for(uint i = 0; i < _materialArr.length; i++) {
            materialArr.push(_materialArr[i]);
            // 在获取 _materialArr 的时候owner已经变更为该合约地址
            Material(materialArr[i]).setCurHolder(getOwner());
        }
        emit setMaterialArrEvent();
    }

    function getMaterialArr() public view returns(address[] memory) {
        return materialArr;
    }
    
    function getReciver() public view returns(address) {
        return reciver;
    }
    
    function getReciverComfirm() public view returns(bool) {
        return reciverConfirm;
    }

    // 收货节点确认，传入收货节点的管理合约地址
    function setReciverConfirm() public onlyReciver {
        require(reciverConfirm == false, "Already confirmed");
        reciverConfirm = true;
        emit setReciverConfirmEvent();
    }

    function setMaterialsOwner() public onlyReciver {
        for(uint i = 0; i < materialArr.length; i++) {
            Material(materialArr[i]).setOwner(reciver);
        }
        emit setMaterialsOwnerEvent();
    }
}