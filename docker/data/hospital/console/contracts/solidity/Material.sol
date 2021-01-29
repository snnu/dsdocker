pragma solidity >=0.4.24 < 0.5.2;

import "./Authentication.sol";

contract Material is Authentication {
    struct Node {
        uint time;
        string reciver;
        address holder;
        uint num;
    }

    uint private variety;
    uint private amount;
    bool private used;
    // uint private unit; //在固定类别的情况下，无需在合约中指定单位，可在后端系统中指定
    Node[] private timeline;

    constructor (uint _variety, uint _amount) public {
        variety = _variety;
        amount = _amount;
        used = false;
    }

    function getVariety() public view returns(uint){
        return variety;
    }

    // function SetVariety(uint _variety) public onlyAuth {
    //     variety = _variety;
    // }

    function getAmount() public view returns(uint) {
        return amount;
    }

    // function SetAmount(uint _amount) public onlyAuth {
    //     amount = _amount;
    // }

    function setUsed() public onlyOwner {
        used = true;
    }

    function getUsed() public view returns(bool) {
        return used;
    }

    function getCurHolder() public view returns(address) {
        return timeline[timeline.length - 1].holder;
    }

    function getTimelineLength() public view returns(uint) {
        return timeline.length;
    }

    function getTimeline(uint i) public view returns(address holder, string memory reciver, uint time, uint num) {
        return (timeline[i].holder, timeline[i].reciver, timeline[i].time, timeline[i].num);
    }
    
    function setCurHolder(address _curHolder, string memory _reciver) public onlyOwner {
        timeline.push(Node(block.timestamp, _reciver, _curHolder, block.number));
    }
}