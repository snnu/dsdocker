package com.donationsystem.platform.repo;



import com.donationsystem.platform.model.Manager;

import org.springframework.data.repository.CrudRepository;

public interface ManagerRepo extends CrudRepository<Manager, String> {
    public Manager findByManagerAddress(String managerAddress);

    public Manager findByManagerName(String managerName);
}
