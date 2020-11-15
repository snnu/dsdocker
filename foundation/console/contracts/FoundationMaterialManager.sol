pragma solidity >=0.4.24 < 0.5.2;
import "./Material.sol";

contract FoundationMaterialManager {
    mapping(uint => address[]) private varietyAmount;
    address private manager;
    
    constructor () public {
        manager = msg.sender;
    }
    
    modifier onlyManager() {
        require(msg.sender == manager);
        _;
    }
    
    function GetVarietyAmount(uint _variety) public view returns(uint){
        return varietyAmount[_variety].length;
    }

    function GetVarietyAddress(uint _variety) public view returns(address[] memory){
        return varietyAmount[_variety];
    }
    
    //出库，_manager 为 Waybill 合约的地址
    function GetMaterials(uint _variety, uint _amount, address _manager) public onlyManager returns(address[] memory) {
        address[] mid;
        uint i;
        for(i = 0; i < _amount; i++) {
            mid.push(varietyAmount[_variety][i]);
            Material(mid[i]).SetManager(_manager);
        }
        for(i = 0; i < varietyAmount[_variety].length - _amount; i++) {
            varietyAmount[_variety][i] =  varietyAmount[_variety][i + _amount];
        }
        varietyAmount[_variety].length -= _amount;
        return mid;
    }
    
    //从 WayBill 中获取入库
    function SetMaterials(address[] memory  _materials) public {
        for(uint i = 0; i < _materials.length; i++) {
            varietyAmount[Material(_materials[i]).GetVariety()].push(_materials[i]);
        }
    }
}