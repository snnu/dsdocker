pragma solidity >=0.4.24 < 0.5.2;

import "./TestContract1.sol";
import "./TestContract2.sol";

contract TestContract3 {
    string private testfiled;

    function setField(address test1, address test2, string memory s) public returns(address, address){
        return TestContract2(test2).setField(test1, s);
    }

    function getField(address test1, address test2) public view returns(string memory) {
        return TestContract2(test2).getField(test1);
    }
}