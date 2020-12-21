pragma solidity >=0.4.24 < 0.5.2;

contract TestContract {
    function getAddress() public view returns(address) {
        return address(this);
    }
}