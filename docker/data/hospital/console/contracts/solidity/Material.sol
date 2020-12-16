pragma solidity >=0.4.24 < 0.5.2;

import "./Authentication.sol";

contract Material is Authentication {
    // string private name;
    // string private amount;
    uint private variety;
    uint private amount;
    bool private used;
    // uint private unit; //在固定类别的情况下，无需在合约中指定单位，可在后端系统中指定
    address private curHolder;// Waybill不唯一，为了标识logistic需要添加该标识 

    constructor (uint _variety, uint _amount) public {
        variety = _variety;
        amount = _amount;
        used = false;
    }

    function getVariety() public view returns(uint){
        return variety;
    }

    // function SetVariety(uint _variety) public onlyAuth {
    //     variety = _variety;
    // }

    function getAmount() public view returns(uint) {
        return amount;
    }

    // function SetAmount(uint _amount) public onlyAuth {
    //     amount = _amount;
    // }

    function setUsed() public onlyOwner {
        used = true;
    }

    function getUsed() public view returns(bool) {
        return used;
    }

    function getCurHolder() public view returns(address) {
        return curHolder;
    }
    
    function setCurHolder(address _curHolder) public onlyOwner {
        curHolder = _curHolder;
    }
}