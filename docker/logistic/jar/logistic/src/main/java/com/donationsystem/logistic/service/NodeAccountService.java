package com.donationsystem.logistic.service;

import com.donationsystem.logistic.model.NodeAccount;
import com.donationsystem.logistic.repository.NodeAccountRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeAccountService {
    
    @Autowired
    private NodeAccountRepo nodeAccountRepo;

    public NodeAccount getNodeAccount(String nodeName) {
        return nodeAccountRepo.findByNodeName(nodeName);
    }
}
