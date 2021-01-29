package com.donationsystem.platform.service;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.donationsystem.platform.constants.GasConstants;
import com.donationsystem.platform.contract.LocationManager;
import com.donationsystem.platform.contract.Material;
import com.donationsystem.platform.contract.Waybill;
import com.donationsystem.platform.contract.WaybillManager;
import com.donationsystem.platform.model.TimelineNode;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaybillService {
    @Autowired
    private ManagerService managerService;

    @Autowired
    private Web3j web3j;

    @Autowired
    private Credentials credentials;

    @Autowired
    private LocationManager locationManager;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    public Map<BigInteger, Map<String, List<TimelineNode>>> getStatusByNumber(String waybillNumber, String waybillManagerName) throws Exception {
        Map<BigInteger, Map<String, List<TimelineNode>>> res = new HashMap<>();
        WaybillManager waybillManager = managerService.getWaybillManager(waybillManagerName);
        String waybillAddress = waybillManager.getWallbillAddress(waybillNumber).send();
        Waybill waybill = Waybill.load(waybillAddress, web3j, credentials,
                new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
        List<String> materialAddresses = waybill.getMaterialArr().send();

        for (String s : materialAddresses) {
            Material m = Material.load(s, web3j, credentials,
                    new StaticGasProvider(GasConstants.GAS_PRICE, GasConstants.GAS_LIMIT));
            BigInteger variety = m.getVariety().send();
            if(!res.containsKey(variety)) {
                res.put(variety, new HashMap<>());
            }
            BigInteger nodeNumber = m.getTimelineLength().send();
            int len = nodeNumber.intValue();
            List<TimelineNode> mid = new ArrayList<>();
            for(int i = 0; i < len; i++) {
                Tuple4 tuple4 = m.getTimeline(new BigInteger(Integer.toString(i))).send();
                String name = locationManager.getName((String)tuple4.getValue1()).send();
                mid.add(new TimelineNode(name, (String)tuple4.getValue2(), simpleDateFormat.format(new Date(((BigInteger)tuple4.getValue3()).longValue())), (BigInteger)tuple4.getValue4()));
            }
            res.get(variety).put(m.getContractAddress(), mid);
        }

        return res;
    }
}
