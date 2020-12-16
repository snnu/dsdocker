package com.donationsystem.logistic.repository;

import com.donationsystem.logistic.model.NodeAccount;

import org.springframework.data.repository.CrudRepository;

public interface NodeAccountRepo extends CrudRepository<NodeAccount, String> {
    public NodeAccount findByNodeName(String nodeName);
}
