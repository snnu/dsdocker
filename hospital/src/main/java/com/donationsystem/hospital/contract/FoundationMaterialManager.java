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
public class FoundationMaterialManager extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b50604051620016283803806200162883398101806040528101908080518201929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508060039080519060200190620001069291906200010e565b5050620001bd565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200015157805160ff191683800117855562000182565b8280016001018555821562000182579182015b828111156200018157825182559160200191906001019062000164565b5b50905062000191919062000195565b5090565b620001ba91905b80821115620001b65760008160009055506001016200019c565b5090565b90565b61145b80620001cd6000396000f3006080604052600436106100a4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063038defd7146100a957806312845b30146100ec57806313af403514610198578063159c0648146101db578063886a0d281461025d578063893d20e8146102a05780639f826354146102f7578063a9ed9cb814610352578063d3e5d2a914610395578063ff9913e8146103d6575b600080fd5b3480156100b557600080fd5b506100ea600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610419565b005b3480156100f857600080fd5b506101416004803603810190808035906020019092919080359060200190929190803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061061e565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610184578082015181840152602081019050610169565b505050509050019250505060405180910390f35b3480156101a457600080fd5b506101d9600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a6f565b005b3480156101e757600080fd5b5061020660048036038101908080359060200190929190505050610b76565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561024957808201518184015260208101905061022e565b505050509050019250505060405180910390f35b34801561026957600080fd5b5061029e600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610c17565b005b3480156102ac57600080fd5b506102b5611102565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561030357600080fd5b50610338600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061112b565b604051808215151515815260200191505060405180910390f35b34801561035e57600080fd5b50610393600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611181565b005b3480156103a157600080fd5b506103c0600480360381019080803590602001909291905050506112a0565b6040518082815260200191505060405180910390f35b3480156103e257600080fd5b50610417600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506112c0565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156104dd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1663912000993060036040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018281038252838181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156105e25780601f106105b7576101008083540402835291602001916105e2565b820191906000526020600020905b8154815290600101906020018083116105c557829003601f168201915b50509350505050600060405180830381600087803b15801561060357600080fd5b505af1158015610617573d6000803e3d6000fd5b5050505050565b60608060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106e7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b846040519080825280602002602001820160405280156107165781602001602082028038833980820191505090505b509150600260008781526020019081526020016000208054905085111515156107a7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600a8152602001807f616d6f756e74206f75740000000000000000000000000000000000000000000081525060200191505060405180910390fd5b600090505b848110156109535760026000878152602001908152602001600020818154811015156107d457fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828281518110151561080d57fe5b9060200190602002019073ffffffffffffffffffffffffffffffffffffffff16908173ffffffffffffffffffffffffffffffffffffffff1681525050600260008781526020019081526020016000208181548110151561086957fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166313af4035856040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561092e57600080fd5b505af1158015610942573d6000803e3d6000fd5b5050505080806001019150506107ac565b600090505b84600260008881526020019081526020016000208054905003811015610a3a576002600087815260200190815260200160002085820181548110151561099a57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1660026000888152602001908152602001600020828154811015156109e557fe5b9060005260206000200160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508080600101915050610958565b846002600088815260200190815260200160002081818054905003915081610a6291906113de565b5081925050509392505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b33576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b606060026000838152602001908152602001600020805480602002602001604051908101604052809291908181526020018280548015610c0b57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1681526020019060010190808311610bc1575b50505050509050919050565b606060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610cdf576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8273ffffffffffffffffffffffffffffffffffffffff1663181d32936040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b158015610d4357600080fd5b505af1158015610d57573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff16636089a92c6040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b158015610dbf57600080fd5b505af1158015610dd3573d6000803e3d6000fd5b505050508273ffffffffffffffffffffffffffffffffffffffff1663f262af306040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401600060405180830381600087803b158015","610e3b57600080fd5b505af1158015610e4f573d6000803e3d6000fd5b505050506040513d6000823e3d601f19601f820116820180604052506020811015610e7957600080fd5b810190808051640100000000811115610e9157600080fd5b82810190506020810184811115610ea757600080fd5b8151856020820283011164010000000082111715610ec457600080fd5b50509291905050509150600090505b81518110156110fd578181815181101515610eea57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff16632356c933610f17611102565b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610f9557600080fd5b505af1158015610fa9573d6000803e3d6000fd5b50505050600260008383815181101515610fbf57fe5b9060200190602002015173ffffffffffffffffffffffffffffffffffffffff1663c1e802866040518163ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401602060405180830381600087803b15801561102c57600080fd5b505af1158015611040573d6000803e3d6000fd5b505050506040513d602081101561105657600080fd5b81019080805190602001909291905050508152602001908152602001600020828281518110151561108357fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550508080600101915050610ed3565b505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611245576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b600060026000838152602001908152602001600020805490509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611384576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b81548183558181111561140557818360005260206000209182019101611404919061140a565b5b505050565b61142c91905b80821115611428576000816000905550600101611410565b5090565b905600a165627a7a723058203367ab445608d2b2418866ac50bc4834a4d2b77fd04121fe768d73b9f567242f0029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"locationManager\",\"type\":\"address\"}],\"name\":\"registry\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"},{\"name\":\"_amount\",\"type\":\"uint256\"},{\"name\":\"_waybill\",\"type\":\"address\"}],\"name\":\"getMaterials\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"}],\"name\":\"getVarietyAddress\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"waybill\",\"type\":\"address\"}],\"name\":\"setMaterials\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"showAllowed\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"}],\"name\":\"getVarietyAmount\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_name\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_REGISTRY = "registry";

    public static final String FUNC_GETMATERIALS = "getMaterials";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_GETVARIETYADDRESS = "getVarietyAddress";

    public static final String FUNC_SETMATERIALS = "setMaterials";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_SHOWALLOWED = "showAllowed";

    public static final String FUNC_DISALLOW = "disallow";

    public static final String FUNC_GETVARIETYAMOUNT = "getVarietyAmount";

    public static final String FUNC_ALLOW = "allow";

    @Deprecated
    protected FoundationMaterialManager(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected FoundationMaterialManager(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected FoundationMaterialManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected FoundationMaterialManager(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
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

    public RemoteCall<TransactionReceipt> getMaterials(BigInteger _variety, BigInteger _amount, String _waybill) {
        final Function function = new Function(
                FUNC_GETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybill)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void getMaterials(BigInteger _variety, BigInteger _amount, String _waybill, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_GETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybill)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String getMaterialsSeq(BigInteger _variety, BigInteger _amount, String _waybill) {
        final Function function = new Function(
                FUNC_GETMATERIALS, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_amount), 
                new org.fisco.bcos.web3j.abi.datatypes.Address(_waybill)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<BigInteger, BigInteger, String> getGetMaterialsInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_GETMATERIALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Uint256>() {}, new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<BigInteger, BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (BigInteger) results.get(1).getValue(), 
                (String) results.get(2).getValue()
                );
    }

    public Tuple1<List<String>> getGetMaterialsOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_GETMATERIALS, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<List<String>>(

                convertToNative((List<Address>) results.get(0).getValue())
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
    public static FoundationMaterialManager load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new FoundationMaterialManager(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static FoundationMaterialManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new FoundationMaterialManager(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static FoundationMaterialManager load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new FoundationMaterialManager(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static FoundationMaterialManager load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new FoundationMaterialManager(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<FoundationMaterialManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(FoundationMaterialManager.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<FoundationMaterialManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(FoundationMaterialManager.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FoundationMaterialManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(FoundationMaterialManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<FoundationMaterialManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(FoundationMaterialManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }
}
