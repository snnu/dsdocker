pragma solidity >=0.4.24 < 0.5.2;

contract Authentication {
    address private owner;
    mapping(address => bool) private acl;

    constructor () public {
        owner = msg.sender;
        acl[owner] = true;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only the owner is allowed");
        _;
    }

    modifier onlyAuth() {
        require(msg.sender == owner || acl[msg.sender] == true, "Only the authenticated user is allowed");
        _;
    }

    function getOwner() public view returns(address) {
        return owner;
    }

    function setOwner(address usr) public onlyOwner {
        owner = usr;
    }

    function allow(address usr) public onlyOwner {
        acl[usr] = true;
    }

    function disallow(address usr) public onlyOwner {
        acl[usr] = false;
    }

    function showAllowed(address usr) public view returns(bool) {
        return acl[usr];
    }
}