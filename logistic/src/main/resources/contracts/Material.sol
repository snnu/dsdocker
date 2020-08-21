pragma solidity >=0.4.24 < 0.5.2;

contract Material {
    // string private name;
    // string private amount;
    uint private variety;
    uint private amount;
    bool private used;
    // uint private unit; //在固定类别的情况下，无需在合约中指定单位，可在后端系统中指定
    address private curHolder;
    address private manager;

    constructor (uint _variety, uint _amount) public {
        manager = msg.sender;
        variety = _variety;
        amount = _amount;
    }

    modifier onlyManager() {
        require(msg.sender == manager, "Only Manager");
        _;
    }

    function GetVariety() public view returns(uint){
        return variety;
    }
/*
    function SetVariety(uint _variety) public onlyManager {
        variety = _variety;
    }
*/
    function GetAmount() public view returns(uint) {
        return amount;
    }
/*
    function SetAmount(uint _amount) public onlyManager {
        amount = _amount;
    }
*/
    function SetManager(address _manager) public onlyManager {
        manager = _manager;
    }

    function GetCurHolder() public view returns(address) {
        return curHolder;
    }
    
    function SetCurHolder(address _curHolder) public onlyManager {
        curHolder = _curHolder;
    }
    
    function GetManager() public view returns(address) {
        return manager;
    }
}