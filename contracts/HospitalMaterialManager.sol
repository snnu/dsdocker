pragma solidity >=0.4.24 < 0.5.2;
import "./Material.sol";
import "./Waybill.sol";
import "./Authentication.sol";
import "./LocationManager.sol";
import "./RequestManager.sol";

contract HospitalMaterialManager is Authentication {
    mapping(uint => address[]) private varietyAmount;
    mapping(address => bool) private usedMaterial;
    string private name;
    
    constructor (string memory _name) public {
        name = _name;
    }
    
    function getVarietyAmount(uint _variety) public view returns(uint){
        return varietyAmount[_variety].length;
    }

    function getVarietyAddress(uint _variety) public view returns(address[] memory){
        return varietyAmount[_variety];
    }
    
    function createReq(uint[] memory _varieties, uint[] memory _amounts, address requestManagerAddress) public onlyOwner returns(uint){
        return RequestManager(requestManagerAddress).createReq(_varieties, _amounts);
    }

    function setMaterials(address waybill) public onlyOwner {
        Waybill(waybill).setReciverConfirm();
        Waybill(waybill).setMaterialsOwner();
        address[] memory _materials = Waybill(waybill).getMaterialArr();
        for(uint i = 0; i < _materials.length; i++) {
            Material(_materials[i]).setCurHolder(getOwner());
            varietyAmount[Material(_materials[i]).getVariety()].push(_materials[i]);
        }
    }
    
    function setUesd(uint _variety, uint _amount) public onlyOwner {
        require(_amount <= varietyAmount[_variety].length, "amount out range");
        uint i;
        for(i = 0; i < _amount; i++) {
            usedMaterial[varietyAmount[_variety][i]] = true;
            Material(varietyAmount[_variety][i]).setUsed();
        }
        for(i = 0; i < varietyAmount[_variety].length - _amount; i++) {
            varietyAmount[_variety][i] = varietyAmount[_variety][i + _amount];
        }
        varietyAmount[_variety].length -= _amount;
    }

    function registry(address locationManager) public onlyOwner {
        LocationManager(locationManager).setAddress(address(this), name);
    }
}