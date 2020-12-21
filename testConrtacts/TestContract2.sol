pragma solidity >=0.4.24 < 0.5.2;

import "./TestContract1.sol";

contract TestContract2 {
    string private testfiled;

    function setField(address test1, string memory s) public returns(address, address){
        return (TestContract1(test1).setField(s), msg.sender);
    }

    function getField(address test1) public view returns(string memory) {
        return TestContract1(test1).getField();
    }
}