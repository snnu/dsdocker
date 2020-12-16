package com.donationsystem.logistic.repository;

import com.donationsystem.logistic.model.Manager;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends CrudRepository<Manager, String> {
    public Manager findByManagerName(String name);

    public Manager findByManagerAddress(String address);
}
