package com.donationsystem.foundation.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class RequestManager extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506000600581905550610ae9806100686000396000f30060806040526004361061006d576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680631633efe21461007257806316c61d721461016f57806340630f29146101b25780638e913138146101f5578063ff16c118146102b2575b600080fd5b34801561007e57600080fd5b5061009d600480360381019080803590602001909291905050506102e4565b6040518080602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019060200280838360005b838110156101165780820151818401526020810190506100fb565b50505050905001838103825285818151815260200191508051906020019060200280838360005b8381101561015857808201518184015260208101905061013d565b505050509050019550505050505060405180910390f35b34801561017b57600080fd5b506101b0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104c1565b005b3480156101be57600080fd5b506101f3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506105df565b005b34801561020157600080fd5b5061029c60048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192905050506106fe565b6040518082815260200191505060405180910390f35b3480156102be57600080fd5b506102c7610976565b604051808381526020018281526020019250505060405180910390f35b60608060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156103ad576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60026000858152602001908152602001600020600001600260008681526020019081526020016000206001016002600087815260200190815260200160002060020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff168280548060200260200160405190810160405280929190818152602001828054801561045b57602002820191906000526020600020905b815481526020019060010190808311610447575b50505050509250818054806020026020016040519081016040528092919081815260200182805480156104ad57602002820191906000526020600020905b815481526020019060010190808311610499575b505050505091509250925092509193909250565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610585576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106a3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806107ab575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610845576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001807f4f6e6c79207468652061757468656e746963617465642075736572206973206181526020017f6c6c6f776564000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b3360026000600554815260200190815260200160002060020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508260026000600554815260200190815260200160002060000190805190602001906108c8929190610a4b565b508160026000600554815260200190815260200160002060010190805190602001906108f5929190610a4b565b507f71aacbd56f85839af3ffd17586cdbc7c84f831363a8bfd55b553a977e583dc5233604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a1600560008154809291906001019190505550600554905092915050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a3d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600454600554915091509091565b828054828255906000526020600020908101928215610a87579160200282015b82811115610a86578251825591602001919060010190610a6b565b5b509050610a949190610a98565b5090565b610aba91905b80821115610ab6576000816000905550600101610a9e565b5090565b905600a165627a7a72305820b5e37f08cb3284498a8036f89a7d2686927c3c45438a1a0fd1479b7311c674a00029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"num\",\"type\":\"uint256\"}],\"name\":\"HandleReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"reciver\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"Allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"Disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varieties\",\"type\":\"uint256[]\"},{\"name\":\"_amounts\",\"type\":\"uint256[]\"}],\"name\":\"CreateReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"GetLastNumAndNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_a\",\"type\":\"address\"}],\"name\":\"CreateReqEvent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_HANDLEREQ = "HandleReq";

    public static final String FUNC_ALLOW = "Allow";

    public static final String FUNC_DISALLOW = "Disallow";

    public static final String FUNC_CREATEREQ = "CreateReq";

    public static final String FUNC_GETLASTNUMANDNUM = "GetLastNumAndNum";

    public static final Event CREATEREQEVENT_EVENT = new Event("CreateReqEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    @Deprecated
    protected RequestManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected RequestManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected RequestManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected RequestManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> HandleReq(BigInteger num) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(num)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void HandleReq(BigInteger num, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(num)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String HandleReqSeq(BigInteger num) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(num)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getHandleReqInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_HANDLEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public Tuple3<List<BigInteger>, List<BigInteger>, String> getHandleReqOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_HANDLEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<List<BigInteger>, List<BigInteger>, String>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue()), 
                (String) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> Allow(String usr) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void Allow(String usr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String AllowSeq(String usr) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getAllowInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_ALLOW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> Disallow(String usr) {
        final Function function = new Function(
                FUNC_DISALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void Disallow(String usr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DISALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String DisallowSeq(String usr) {
        final Function function = new Function(
                FUNC_DISALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getDisallowInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_DISALLOW, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> CreateReq(List<BigInteger> _varieties, List<BigInteger> _amounts) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void CreateReq(List<BigInteger> _varieties, List<BigInteger> _amounts, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String CreateReqSeq(List<BigInteger> _varieties, List<BigInteger> _amounts) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<List<BigInteger>, List<BigInteger>> getCreateReqInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<List<BigInteger>, List<BigInteger>>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue())
                );
    }

    public Tuple1<BigInteger> getCreateReqOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_CREATEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<Tuple2<BigInteger, BigInteger>> GetLastNumAndNum() {
        final Function function = new Function(FUNC_GETLASTNUMANDNUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<BigInteger, BigInteger>>(
                new Callable<Tuple2<BigInteger, BigInteger>>() {
                    @Override
                    public Tuple2<BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<BigInteger, BigInteger>(
                                (BigInteger) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public List<CreateReqEventEventResponse> getCreateReqEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(CREATEREQEVENT_EVENT, transactionReceipt);
        ArrayList<CreateReqEventEventResponse> responses = new ArrayList<CreateReqEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            CreateReqEventEventResponse typedResponse = new CreateReqEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse._a = (String) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerCreateReqEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATEREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerCreateReqEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATEREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static RequestManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static RequestManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new RequestManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static RequestManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new RequestManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static RequestManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new RequestManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<RequestManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RequestManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<RequestManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(RequestManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RequestManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<RequestManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(RequestManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class CreateReqEventEventResponse {
        public Log log;

        public String _a;
    }
}
