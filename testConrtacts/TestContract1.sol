pragma solidity >=0.4.24 < 0.5.2;
contract TestContract1 {
    string private testfiled;

    function setField(string memory s) public returns(address){
        testfiled = s;
        return msg.sender;
    }

    function getField() public view returns(string memory) {
        return testfiled;
    }
}