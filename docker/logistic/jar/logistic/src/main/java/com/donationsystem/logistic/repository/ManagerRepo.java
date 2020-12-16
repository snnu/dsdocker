package com.donationsystem.logistic.repository;

import com.donationsystem.logistic.model.WaybillManagerPOJO;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepo extends CrudRepository<WaybillManagerPOJO, String> {
}

