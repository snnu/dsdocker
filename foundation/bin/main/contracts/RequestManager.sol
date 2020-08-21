pragma solidity >=0.4.24 < 0.5.2;

import './Authentication.sol';

contract RequestManager is Authentication{
    struct Req {
        uint[] varieties;
        uint[] amounts;
        address reciver;
        bool done;
    }
    
    mapping(uint => Req) reqMap;
    mapping(address => bool) authedMap;
    uint private lastNum;
    uint private num;
    
    constructor () public {
        num = 0;
    }
    
    event CreateReqEvent(address _a);
    
    function CreateReq(uint[] memory _varieties, uint[] memory _amounts) public onlyAuth returns(uint) {
        reqMap[num].reciver = msg.sender;
        reqMap[num].varieties = _varieties;
        reqMap[num].amounts = _amounts;
        emit CreateReqEvent(msg.sender);
        num++;
        return num;
    }
    
    function GetLastNumAndNum() public onlyOwner view returns(uint, uint) {
        return(lastNum, num);
    }
    
    function HandleReq(uint num) public onlyOwner returns(uint[] memory, uint[] memory, address reciver){
        return (reqMap[num].varieties, reqMap[num].amounts, reqMap[num].reciver);
    }
}