pragma solidity ^0.4.24;

contract Authentication {
    address private owner;
    mapping(address => bool) private acl;

    constructor () public {
        owner = msg.sender;
    }

    modifier onlyOwner() {
        require(msg.sender == owner, "Only the owner is allowed");
        _;
    }

    modifier onlyAuth() {
        require(msg.sender == owner || acl[msg.sender] == true, "Only the authenticated user is allowed");
        _;
    }

    function Allow(address usr) public onlyOwner {
        acl[usr] = true;
    }

    function Disallow(address usr) public onlyOwner {
        acl[usr] = false;
    }
}