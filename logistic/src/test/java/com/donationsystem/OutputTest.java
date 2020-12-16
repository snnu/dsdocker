package com.donationsystem;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;

import com.donationsystem.logistic.constants.GasConstants;
import com.donationsystem.logistic.contract.TestContract;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class OutputTest extends BaseTest {
    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;

    @Test
    public void testContractOutput() {
        try {
            TestContract testContract = TestContract.deploy(web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT), new BigInteger("1")).send();
            BigInteger res = testContract.getGetNewDataOutput(testContract.getNewData(new BigInteger("2")).send()).getValue1();
            assertTrue(res.intValue() == 2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
