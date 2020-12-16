package com.donationsystem.logistic.repository;

import com.donationsystem.logistic.model.WayBillPOJO;

import org.springframework.data.repository.CrudRepository;

public interface WaybillRepo extends CrudRepository<WayBillPOJO, String>{
    public WayBillPOJO findByNumber(String number);
}
