pragma solidity >=0.4.24 < 0.5.2;
import "./Material.sol";
import "./Waybill.sol";
import "./Authentication.sol";
import './LocationManager.sol';

contract FoundationMaterialManager is Authentication {

    mapping(uint => address[]) private varietyAmount;
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
    
    //出库，_manager 为 logistic节点的地址
    //后到的物资先出库操作步骤会更少一点(但这里不涉及Gas消耗所以只有存储才是需要考虑的)，但这还涉及到保质期的问题 
    function getMaterials(uint _variety, uint _amount, address _waybill) public onlyOwner returns(address[] memory) {
        address[] memory mid = new address[](_amount);
        require(_amount <= varietyAmount[_variety].length, "amount out");
        uint i;
        //拆分的问题怎么解决？当前只能按一单位压入
        for(i = 0; i < _amount; i++) {
            mid[i] = varietyAmount[_variety][i];
            Material(mid[i]).setOwner(_waybill);
        }
        for(i = 0; i < varietyAmount[_variety].length - _amount; i++) {
            varietyAmount[_variety][i] =  varietyAmount[_variety][i + _amount];
        }
        /*
        for(i = 0; i < _amount; i++) {
            mid.push(varietyAmount[_variety][varietyAmount.length - _amount + i]);
            Material(mid[i]).SetManager(_manager);
        }
        */
        varietyAmount[_variety].length -= _amount;
        return mid;
    }
    
    //从 WayBill 中获取入库
    function setMaterials(address waybill) public onlyOwner {
        Waybill(waybill).setReciverConfirm();
        Waybill(waybill).setMaterialsOwner();
        address[] memory _materials = Waybill(waybill).getMaterialArr();
        for(uint i = 0; i < _materials.length; i++) {
            Material(_materials[i]).setCurHolder(getOwner());
            varietyAmount[Material(_materials[i]).getVariety()].push(_materials[i]);
        }
    }

    function registry(address locationManager) public onlyOwner {
        LocationManager(locationManager).setAddress(address(this), name);
    }
}