pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';

contract WaybillManager is Authentication {
    mapping(string => address) waybillMap;
    mapping(string => address[]) materilMap;
    
    constructor() public {
    }
    
    function GetWallbillAddress(string memory _number) public view returns(address) {
        return waybillMap[_number];
    }
    
    function SetWallbillAddress(string memory _number, address _waybillAddress) public onlyOwner {
        waybillMap[_number] = _waybillAddress;
    }
    
    function GetMaterials(string memory number) public view onlyOwner returns(address[] memory){
        return materilMap[number];
    }
    
    function SetMaterials(string memory number, address[] memory _addresses) public onlyAuth {
        for(uint i = 0; i < _addresses.length; i++) {
            materilMap[number].push(_addresses[i]);
        }
    }
}