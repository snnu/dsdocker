package com.donationsystem.logistic;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import com.donationsystem.logistic.constants.AccountConstants;
import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.Material;
import com.donationsystem.logistic.contract.WayBill;

import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WaybillTest extends BaseTest {
    @Autowired 
    private Web3j web3j;
    @Autowired 
    private Credentials credentials;

    //@Test
    public void deployAndCallWayBill() throws Exception {
        // deploy contract
        final WayBill waybill =
        WayBill.deploy(
            web3j,
            credentials,
            new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT),
            "0x1356943c6b6cfd3ff42aec3a6cb863135108e804",
            "20200810001"
        ).send();
        if (waybill != null) {
            String waybillAddress = waybill.getContractAddress();
            System.out.println("WayBill address is: " + waybillAddress);
            Boolean reciverConfirm = waybill.GetReciverComfirm().send();
            System.out.println("Confirm: " + reciverConfirm.toString());
            List<BigInteger> _varietyArr = new ArrayList<BigInteger>();
            _varietyArr.add(new BigInteger("1"));
            _varietyArr.add(new BigInteger("2"));
            _varietyArr.add(new BigInteger("3"));
            List<BigInteger> _amountArr = new ArrayList<BigInteger>();
            _amountArr.add(new BigInteger("1"));
            _amountArr.add(new BigInteger("2"));
            _amountArr.add(new BigInteger("3"));
            waybill.SetMaterialArr(_varietyArr, _amountArr).send();
            List<String> materialArr = waybill.GetMaterialArr().send();
            int len = materialArr.size();
            assertTrue(len == 3);
            final Material material = Material.load(materialArr.get(0), web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger v = material.GetVariety().send();
            BigInteger a = material.GetAmount().send();
            String holder = material.GetCurHolder().send();
            String manager = material.GetManager().send();
            System.out.println(manager);
            System.out.println(holder);
            assertTrue(manager.equals(waybillAddress));
            assertTrue(holder.equals(AccountConstants.ACCOUNT));
            assertTrue(v.compareTo(new BigInteger("1")) == 0);
            assertTrue(a.compareTo(new BigInteger("1")) == 0);
        } 
    }

    public static void main(String...args) throws Exception {
        WaybillTest c = new WaybillTest();
        c.deployAndCallWayBill();
    }
}