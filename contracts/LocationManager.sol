pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';

contract LocationManager is Authentication {

    address private manager;
    mapping(address => string) private addressMap;
    mapping(string => address) private name2address;

    constructor() public {
        manager = msg.sender;
    }

    function SetAddress(address ac, string memory _address) public onlyAuth {
        addressMap[ac] = _address;
    }

    function GetAddress(address ac) public onlyAuth {
        addressMap[ac] = _address;
    }
}