pragma solidity >=0.4.24 < 0.5.2;
import "./Material.sol";

contract HospitalMaterialManager {
    mapping(uint => address[]) private varietyAmount;
    mapping(address => bool) private usedMaterial;
    address private manager;
    
    constructor () public {
        manager = msg.sender;
    }
    
    modifier onlyManager() {
        require(msg.sender == manager);
        _;
    }
    
    function GetVarietyAmount(uint _variety) public view return(uint){
        return varietyAmount[_variety].length;
    }

    function GetVarietyAddress(uint _variety) public view return(uint){
        return varietyAmount[_variety];
    }
    
    function SetMaterials(address[] memory  _materials) public onlyManager {
        for(uint i = 0; i < _materials.length; i++) {
            varietyAmount[Material(_materials[i]).getVariety()].push(_materials[i]);
        }
    }
    
    function SetUesd(uint _amount) public onlyManager {
        for(uint i = 0; i < varietyAmount[_variety].length - _amount; i++) {
            usedMaterial[varietyAmount[_variety][i + _amount]] = true;
            varietyAmount[_variety][i] =  varietyAmount[_variety][i + _amount];
        }
        varietyAmount[_variety].length -= _amount;
    }
}