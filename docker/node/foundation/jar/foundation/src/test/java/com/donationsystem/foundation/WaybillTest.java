package com.donationsystem.foundation;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.List;

import com.donationsystem.foundation.constants.AccountConstants;
import com.donationsystem.foundation.constants.GasConstants;
import com.donationsystem.foundation.contract.FoundationMaterialManager;
import com.donationsystem.foundation.contract.Material;
import com.donationsystem.foundation.contract.WayBill;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class WaybillTest extends BaseTest {

    @Autowired private Web3j web3j;
    @Autowired private Credentials credentials;
    static final String WAYBILL_ADDRESS = "0x1f47a20bc026986147f3e514d9542ef0c12917d9";

    @Test
    public void deployAndCallWaybill() throws Exception {
        final WayBill waybill = WayBill.load(WAYBILL_ADDRESS, web3j, credentials, new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        if (waybill != null) {
            System.out.println("waybill address: " + waybill.getContractAddress());
            String reciver = waybill.GetReciver().send();
            System.out.println("reciver: " + reciver);
            final FoundationMaterialManager foundationMaterialManager = FoundationMaterialManager.deploy(
                web3j,
                credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT)
            ).send();
            String mmAddress = foundationMaterialManager.getContractAddress();
            System.out.println("Materialmanager address: " + mmAddress);
            waybill.SetReciverConfirm(mmAddress);
            Boolean reciverConfirm = waybill.GetReciverComfirm().send();
            System.out.println("Confirm: " + reciverConfirm.toString());
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
            assertTrue(holder.equals(AccountConstants.ACCOUNT));
            assertTrue(v.compareTo(new BigInteger("1")) == 0);
            assertTrue(a.compareTo(new BigInteger("1")) == 0);
        } 
    }
}
