package com.donationsystem.hospital.contract;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
import org.fisco.bcos.web3j.abi.datatypes.DynamicArray;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
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
public class HospitalMaterialManager extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b50604051620018383803806200183883398101806040528101908080518201929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508060049080519060200190620001069291906200010e565b5050620001bd565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200015157805160ff191683800117855562000182565b8280016001018555821562000182579182015b828111156200018157825182559160200191906001019062000164565b5b50905062000191919062000195565b5090565b620001ba91905b80821115620001b65760008160009055506001016200019c565b5090565b90565b61166b80620001cd6000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063038defd7146100b457806313af4035146100f7578063159c06481461013a578063886a0d28146101bc578063893d20e8146101ff5780639f82635414610256578063a9ed9cb8146102b1578063d3e5d2a9146102f4578063ede68ce714610335578063f9acdbd41461036c578063ff9913e814610449575b600080fd5b3480156100c057600080fd5b506100f5600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061048c565b005b34801561010357600080fd5b50610138600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610691565b005b34801561014657600080fd5b5061016560048036038101908080359060200190929190505050610798565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156101a857808201518184015260208101905061018d565b505050509050019250505060405180910390f35b3480156101c857600080fd5b506101fd600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610839565b005b34801561020b57600080fd5b50610214610d24565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561026257600080fd5b50610297600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610d4d565b604051808215151515815260200191505060405180910390f35b3480156102bd57600080fd5b506102f2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610da3565b005b34801561030057600080fd5b5061031f60048036038101908080359060200190929190505050610ec2565b6040518082815260200191505060405180910390f35b34801561034157600080fd5b5061036a6004803603810190808035906020019092919080359060200190929190505050610ee2565b005b34801561037857600080fd5b506104336004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506112cd565b6040518082815260200191505060405180910390f35b34801561045557600080fd5b5061048a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506114d0565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610550576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1663912000993060046040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018281038252838181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156106555780601f1061062a57610100808354040283529160200191610655565b820191906000526020600020905b81548152906001019060200180831161063857829003601f168201915b50509350505050600060405180830381600087803b15801561067657600080fd5b505af115801561068a573d6000803e3d6000fd5b5050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610755576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60606002600083815260200190815260200160002080548060200260200160405190810160405280929190818152602001828054801561082d57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116107e3575b50505050509050919050565b606060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610901576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8273ffffffffffffffffffffffffffffffffffffffff1663181d32936040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b15801561096557600080fd5b505af1158015610979573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff16636089a92c6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b1580156109e157600080fd5b505af11580156109f5573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff1663f262af306040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b158015610a5d57600080fd5b505af1158015610a71573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052506020811015610a9b57600080fd5b810190808051640100000000811115610ab357600080fd5b82810190506020810184811115610ac957600080fd5b8151856020820283011164010000000082111715610ae657600080fd5b50509291905050509150600090505b8151811015610d1f578181815181101515610b0c57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16632356c933610b39610d24565b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610bb757600080fd5b505af1158015610bcb573d6000803e3d6000fd5b50505050600260008383815181101515610be157fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1663c1e802866040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b158015610c4e57600080fd5b505af1158015610c62573d6000803e3d6000fd5b505050506040513d6020811015610c7857600080fd5b810190808051906020019092919050505081526020019081526020016000208282815181101515610ca557fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550508080600101915050610af5565b505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e67576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252601981526020","01807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b600060026000838152602001908152602001600020805490509050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610fa8576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60026000848152602001908152602001600020805490508211151515611036576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f616d6f756e74206f75742072616e67650000000000000000000000000000000081525060200191505060405180910390fd5b600090505b818110156111b857600160036000600260008781526020019081526020016000208481548110151561106957fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550600260008481526020019081526020016000208181548110151561110557fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166379fd18b06040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b15801561119357600080fd5b505af11580156111a7573d6000803e3d6000fd5b50505050808060010191505061103b565b600090505b8160026000858152602001908152602001600020805490500381101561129f57600260008481526020019081526020016000208282018154811015156111ff57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16600260008581526020019081526020016000208281548110151561124a57fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555080806001019150506111bd565b8160026000858152602001908152602001600020818180549050039150816112c791906115ee565b50505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611393576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8173ffffffffffffffffffffffffffffffffffffffff16639344b8a285856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808060200180602001838103835285818151815260200191508051906020019060200280838360005b83811015611423578082015181840152602081019050611408565b50505050905001838103825284818151815260200191508051906020019060200280838360005b8381101561146557808201518184015260208101905061144a565b50505050905001945050505050602060405180830381600087803b15801561148c57600080fd5b505af11580156114a0573d6000803e3d6000fd5b505050506040513d60208110156114b657600080fd5b810190808051906020019092919050505090509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611594576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b81548183558181111561161557818360005260206000209182019101611614919061161a565b5b505050565b61163c91905b80821115611638576000816000905550600101611620565b5090565b905600a165627a7a723058202a049a2c9b640cb488d4a257ab380beb56a1a3648e5d0588b9e7191ee042934a0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"locationManager\",\"type\":\"address\"}],\"name\":\"registry\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"}],\"name\":\"getVarietyAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"waybill\",\"type\":\"address\"}],\"name\":\"setMaterials\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"showAllowed\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"}],\"name\":\"getVarietyAmount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"},{\"name\":\"_amount\",\"type\":\"uint256\"}],\"name\":\"setUesd\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varieties\",\"type\":\"uint256[]\"},{\"name\":\"_amounts\",\"type\":\"uint256[]\"},{\"name\":\"requestManagerAddress\",\"type\":\"address\"}],\"name\":\"createReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_REGISTRY = "registry";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_GETVARIETYADDRESS = "getVarietyAddress";

    public static final String FUNC_SETMATERIALS = "setMaterials";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_SHOWALLOWED = "showAllowed";

    public static final String FUNC_DISALLOW = "disallow";

    public static final String FUNC_GETVARIETYAMOUNT = "getVarietyAmount";

    public static final String FUNC_SETUESD = "setUesd";

    public static final String FUNC_CREATEREQ = "createReq";

    public static final String FUNC_ALLOW = "allow";

    @Deprecated
    protected HospitalMaterialManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected HospitalMaterialManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected HospitalMaterialManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected HospitalMaterialManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> registry(String locationManager) {
        final Function function = new Function(
                FUNC_REGISTRY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(locationManager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void registry(String locationManager, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_REGISTRY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(locationManager)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String registrySeq(String locationManager) {
        final Function function = new Function(
                FUNC_REGISTRY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(locationManager)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getRegistryInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_REGISTRY, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setOwner(String usr) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setOwner(String usr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setOwnerSeq(String usr) {
        final Function function = new Function(
                FUNC_SETOWNER, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetOwnerInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<List> getVarietyAddress(BigInteger _variety) {
        final Function function = new Function(FUNC_GETVARIETYADDRESS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety)), 
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

    public RemoteCall<TransactionReceipt> setMaterials(String waybill) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(waybill)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterials(String waybill, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(waybill)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialsSeq(String waybill) {
        final Function function = new Function(
                FUNC_SETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(waybill)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetMaterialsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<Boolean> showAllowed(String usr) {
        final Function function = new Function(FUNC_SHOWALLOWED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> disallow(String usr) {
        final Function function = new Function(
                FUNC_DISALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void disallow(String usr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_DISALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String disallowSeq(String usr) {
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

    public RemoteCall<BigInteger> getVarietyAmount(BigInteger _variety) {
        final Function function = new Function(FUNC_GETVARIETYAMOUNT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setUesd(BigInteger _variety, BigInteger _amount) {
        final Function function = new Function(
                FUNC_SETUESD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setUesd(BigInteger _variety, BigInteger _amount, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETUESD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setUesdSeq(BigInteger _variety, BigInteger _amount) {
        final Function function = new Function(
                FUNC_SETUESD, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, BigInteger> getSetUesdInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETUESD, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, BigInteger>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> createReq(List<BigInteger> _varieties, List<BigInteger> _amounts, String requestManagerAddress) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(requestManagerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createReq(List<BigInteger> _varieties, List<BigInteger> _amounts, String requestManagerAddress, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(requestManagerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createReqSeq(List<BigInteger> _varieties, List<BigInteger> _amounts, String requestManagerAddress) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(requestManagerAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<List<BigInteger>, List<BigInteger>, String> getCreateReqInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_CREATEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<List<BigInteger>, List<BigInteger>, String>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue()), 
                (String) results.get(2).getValue()
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

    public RemoteCall<TransactionReceipt> allow(String usr) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void allow(String usr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_ALLOW, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String allowSeq(String usr) {
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

    @Deprecated
    public static HospitalMaterialManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new HospitalMaterialManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static HospitalMaterialManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new HospitalMaterialManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static HospitalMaterialManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new HospitalMaterialManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static HospitalMaterialManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new HospitalMaterialManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<HospitalMaterialManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(HospitalMaterialManager.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<HospitalMaterialManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(HospitalMaterialManager.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<HospitalMaterialManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(HospitalMaterialManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<HospitalMaterialManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(HospitalMaterialManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
