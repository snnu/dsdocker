pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';

contract LocationManager is Authentication {

    address private manager;
    mapping(address => string) private addressMap;
    mapping(string => address) private name2address;

    //  需要给所有的 Manager 添加一个注册方法
    function setAddress(address ac, string memory name) public onlyAuth {
        require(msg.sender == ac, "can only set address itself");
        addressMap[ac] = name;
        name2address[name] = ac;
    }

    function getName(address ac) public view onlyAuth returns(string memory){
        return addressMap[ac];
    }

    function getAddress(string memory name) public view onlyAuth returns(address){
        return name2address[name];
    }
}