pragma solidity >=0.4.24 < 0.5.2;

import "./Material.sol";

contract WayBill{

    address[] private materialArr;
    string private number;
    bool private reciverConfirm;
    
    address private reciver;
    address private logisticCpn;
    
    constructor (address _reciver, string memory _number) public {
        number = _number;
        reciver = _reciver;
        logisticCpn = msg.sender;
    }
    
    modifier onlyLogisticCpn() {
        require(msg.sender == logisticCpn, "Auth: only logisticCpn can operate");
        _;
    }
    
    modifier onlyReciver() {
        require(msg.sender == reciver, "Auth: only the reciver can confirm");
        _;
    }
    
    event SetMaterialArrEvent();
    event ResetMaterialEvent(uint i);
    event SetReciverConfirmEvent();

    function SetMaterialArr(uint[] memory _varietyArr, uint[] memory _amountArr) public onlyLogisticCpn {
        require(_varietyArr.length == _amountArr.length, "There are something wrong with materialArr");
        for(uint i = 0; i < _varietyArr.length; i++) {
            materialArr.push(address(new Material(_varietyArr[i], _amountArr[i])));
            Material(materialArr[materialArr.length - 1]).SetCurHolder(logisticCpn);
        }
        emit SetMaterialArrEvent();
    }
    
    function SetMaterialArr(address[] memory _materialArr) public onlyLogisticCpn {
        for(uint i = 0; i < _materialArr.length; i++) {
            materialArr.push(_materialArr[i]);
            Material(materialArr[materialArr.length - 1]).SetCurHolder(logisticCpn);
        }
        emit SetMaterialArrEvent();
    }
    
    /*
    function ResetMaterial(uint i, uint _variety, uint _amount) public onlyLogisticCpn {
        Material(materialArr[i]).setVariety(_variety);
        Material(materialArr[i]).setAmount(_amount);
        emit ResetMaterialEvent(i);
    }
    */

    function GetMaterialArr() public view returns(address[] memory) {
        return materialArr;
    }
    
    function GetReciver() public view returns(address) {
        return reciver;
    }
    
    function GetReciverComfirm() public view returns(bool) {
        return reciverConfirm;
    }

    function SetReciverConfirm(address _manager) public onlyReciver {
        require(reciverConfirm == false, "Already confirmed");
        reciverConfirm = true;
        for(uint i = 0; i < materialArr.length; i++) {
            Material(materialArr[i]).SetCurHolder(reciver);
            Material(materialArr[i]).SetManager(_manager);
        }
        emit SetReciverConfirmEvent();
    }
}