package com.donationsystem.logistic.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
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
public class WaybillManager extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550610c19806100606000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806316c61d721461007d5780632254a4d1146100c057806340630f2914610149578063775b4cef1461018c578063c42120a11461024a578063d1306b4b146102f6575b600080fd5b34801561008957600080fd5b506100be600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061039f565b005b3480156100cc57600080fd5b50610147600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104bd565b005b34801561015557600080fd5b5061018a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061062f565b005b34801561019857600080fd5b506101f3600480360381019080803590602001908201803590602001908080601f016020809104026020016040519081016040528093929190818152602001838380828437820191505050505050919291929050505061074e565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561023657808201518184015260208101905061021b565b505050509050019250505060405180910390f35b34801561025657600080fd5b506102f4600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505061090b565b005b34801561030257600080fd5b5061035d600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610b58565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610463576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610581576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806002836040518082805190602001908083835b6020831015156105ba5780518252602082019150602081019050602083039250610595565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106f3576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b60606000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610814576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6003826040518082805190602001908083835b60208310151561084c5780518252602082019150602081019050602083039250610827565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390208054806020026020016040519081016040528092919081815260200182805480156108ff57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116108b5575b50505050509050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614806109b8575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515610a52576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001807f4f6e6c79207468652061757468656e746963617465642075736572206973206181526020017f6c6c6f776564000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600090505b8151811015610b53576003836040518082805190602001908083835b602083101515610a985780518252602082019150602081019050602083039250610a73565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390208282815181101515610ad957fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550508080600101915050610a57565b505050565b60006002826040518082805190602001908083835b602083101515610b925780518252602082019150602081019050602083039250610b6d565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1690509190505600a165627a7a72305820f199bf16275362531841d04a43faba3ba7129ad02b98de07bf5d050f7c8257440029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"Allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_number\",\"type\":\"string\"},{\"name\":\"_waybillAddress\",\"type\":\"address\"}],\"name\":\"SetWallbillAddress\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"Disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"number\",\"type\":\"string\"}],\"name\":\"GetMaterials\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"number\",\"type\":\"string\"},{\"name\":\"_addresses\",\"type\":\"address[]\"}],\"name\":\"SetMaterials\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_number\",\"type\":\"string\"}],\"name\":\"GetWallbillAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"inputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_ALLOW = "Allow";

    public static final String FUNC_SETWALLBILLADDRESS = "SetWallbillAddress";

    public static final String FUNC_DISALLOW = "Disallow";

    public static final String FUNC_GETMATERIALS = "GetMaterials";

    public static final String FUNC_SETMATERIALS = "SetMaterials";

    public static final String FUNC_GETWALLBILLADDRESS = "GetWallbillAddress";

    @Deprecated
    protected WaybillManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WaybillManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected WaybillManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected WaybillManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
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

    public RemoteCall<TransactionReceipt> SetWallbillAddress(String _number, String _waybillAddress) {
        final Function function = new Function(
                FUNC_SETWALLBILLADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybillAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void SetWallbillAddress(String _number, String _waybillAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETWALLBILLADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybillAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String SetWallbillAddressSeq(String _number, String _waybillAddress) {
        final Function function = new Function(
                FUNC_SETWALLBILLADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybillAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getSetWallbillAddressInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETWALLBILLADDRESS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
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

    public RemoteCall<List> GetMaterials(String number) {
        final Function function = new Function(FUNC_GETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(number)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        return new RemoteCall<List>(
                new Callable<List>() {
                    @Override
                    @SuppressWarnings("unchecked")
                    public List call() throws Exception {
                        List<Type> result = (List<Type>) executeCallSingleValueReturn(function, List.class);
                        return convertToNative(result);
                    }
                });
    }

    public RemoteCall<TransactionReceipt> SetMaterials(String number, List<String> _addresses) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(number), 
                _addresses.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_addresses, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void SetMaterials(String number, List<String> _addresses, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(number), 
                _addresses.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_addresses, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String SetMaterialsSeq(String number, List<String> _addresses) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(number), 
                _addresses.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_addresses, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, List<String>> getSetMaterialsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<DynamicArray<Address>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, List<String>>(

                (String) results.get(0).getValue(), 
                convertToNative((List<Address>) results.get(1).getValue())
                );
    }

    public RemoteCall<String> GetWallbillAddress(String _number) {
        final Function function = new Function(FUNC_GETWALLBILLADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    @Deprecated
    public static WaybillManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WaybillManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static WaybillManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WaybillManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static WaybillManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new WaybillManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static WaybillManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new WaybillManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<WaybillManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WaybillManager.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    public static RemoteCall<WaybillManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(WaybillManager.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WaybillManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WaybillManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<WaybillManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(WaybillManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }
}
