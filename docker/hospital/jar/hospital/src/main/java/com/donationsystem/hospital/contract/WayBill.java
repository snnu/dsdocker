package com.donationsystem.hospital.contract;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Address;
import org.fisco.bcos.web3j.abi.datatypes.Bool;
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
public class WayBill extends Contract {
    public static final String[] BINARY_ARRAY = {"608060405234801561001057600080fd5b50604051611506380380611506833981018060405281019080805190602001909291908051820192919050505080600190805190602001906100539291906100dd565b5081600260016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505050610182565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061011e57805160ff191683800117855561014c565b8280016001018555821561014c579182015b8281111561014b578251825591602001919060010190610130565b5b509050610159919061015d565b5090565b61017f91905b8082111561017b576000816000905550600101610163565b5090565b90565b611375806101916000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680635b1e10a71461007d57806366fbbf2b146100e357806375d336721461014f578063854d8eed146101a6578063b89504cf146101e9578063f452930d14610218575b600080fd5b34801561008957600080fd5b506100e1600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192905050506102c1565b005b3480156100ef57600080fd5b506100f861058c565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b8381101561013b578082015181840152602081019050610120565b505050509050019250505060405180910390f35b34801561015b57600080fd5b5061016461061a565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101b257600080fd5b506101e7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610644565b005b3480156101f557600080fd5b506101fe610a20565b604051808215151515815260200191505060405180910390f35b34801561022457600080fd5b506102bf6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610a37565b005b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156103ae576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001807f417574683a206f6e6c79206c6f67697374696343706e2063616e206f7065726181526020017f746500000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600090505b815181101561055c57600082828151811015156103cc57fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600060016000805490500381548110151561045057fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a347fa76600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561053757600080fd5b505af115801561054b573d6000803e3d6000fd5b5050505080806001019150506103b3565b7f8f3e91d384fe98c49ec240e47f99567372a0e8daf6b6ce6bd3dae7c4e012fcf360405160405180910390a15050565b6060600080548060200260200160405190810160405280929190818152602001828054801561061057602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116105c6575b5050505050905090565b6000600260019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600260019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610731576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001807f417574683a206f6e6c792074686520726563697665722063616e20636f6e666981526020017f726d00000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b60001515600260009054906101000a900460ff1615151415156107bc576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f416c726561647920636f6e6669726d656400000000000000000000000000000081525060200191505060405180910390fd5b6001600260006101000a81548160ff021916908315150217905550600090505b6000805490508110156109f0576000818154811015156107f857fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a347fa76600260019054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156108df57600080fd5b505af11580156108f3573d6000803e3d6000fd5b5050505060008181548110151561090657fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166354a6385a836040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b1580156109cb57600080fd5b505af11580156109df573d6000803e3d6000fd5b5050505080806001019150506107dc565b7f4140f5b9c5e6a4aceb2a9539c201428f6d1f59cd828e347f6bdb3e5916e13e4960405160405180910390a15050565b6000600260009054906101000a900460ff16905090565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b24576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001807f417574683a206f6e6c79206c6f67697374696343706e2063616e206f7065726181526020017f746500000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b81518351141515610bc3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a8152602001807f54686572652061726520736f6d657468696e672077726f6e672077697468206d81526020017f6174657269616c4172720000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600090505b8251811015610dbf5760008382815181101515610be157fe5b906020019060200201518383815181101515610bf957fe5b90602001906020020151610c0b610df0565b8083815260200182815260200192505050604051809103906000f080158015610c38573d6000803e3d6000fd5b5090806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506000600160008054905003815481101515610cb357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1663a347fa76600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610d9a57600080fd5b505af1158015610dae573d6000803e3d6000fd5b505050508080600101915050610bc8565b7f8f3e91d384fe98c49ec240e47f99567372a0e8daf6b6ce6bd3dae7c4e012fcf360405160405180910390a1505050565b60405161054980610e01833901905600608060405234801561001057600080fd5b50604051604080610549833981018060405281019080805190602001909291908051906020019092919050505033600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffff","ffffffffffffffffffffff160217905550816000819055508060018190555050506104ac8061009d6000396000f300608060405260043610610078576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806308bb6aa31461007d57806354a6385a146100d457806380a1bbda14610117578063a347fa7614610142578063b7e231bd14610185578063e5552f4c146101dc575b600080fd5b34801561008957600080fd5b50610092610207565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156100e057600080fd5b50610115600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610231565b005b34801561012357600080fd5b5061012c61033a565b6040518082815260200191505060405180910390f35b34801561014e57600080fd5b50610183600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610344565b005b34801561019157600080fd5b5061019a61044d565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101e857600080fd5b506101f1610477565b6040518082815260200191505060405180910390f35b6000600260019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156102f6576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600c8152602001807f4f6e6c79204d616e61676572000000000000000000000000000000000000000081525060200191505060405180910390fd5b80600360006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600154905090565b600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610409576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600c8152602001807f4f6e6c79204d616e61676572000000000000000000000000000000000000000081525060200191505060405180910390fd5b80600260016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600360009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b600080549050905600a165627a7a7230582065b345e3b33aa8c36bd3b06378b1e680094ff9f8d4da21096143f9bb3087292a0029a165627a7a72305820ed6957494395dcdec5c42ca36141b68ac57c68a1527e37acc6ed572ddd1238820029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"_materialArr\",\"type\":\"address[]\"}],\"name\":\"SetMaterialArr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"GetMaterialArr\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"GetReciver\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_manager\",\"type\":\"address\"}],\"name\":\"SetReciverConfirm\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"GetReciverComfirm\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varietyArr\",\"type\":\"uint256[]\"},{\"name\":\"_amountArr\",\"type\":\"uint256[]\"}],\"name\":\"SetMaterialArr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_reciver\",\"type\":\"address\"},{\"name\":\"_number\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"SetMaterialArrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"i\",\"type\":\"uint256\"}],\"name\":\"ResetMaterialEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"SetReciverConfirmEvent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_SETMATERIALARR = "SetMaterialArr";

    public static final String FUNC_GETMATERIALARR = "GetMaterialArr";

    public static final String FUNC_GETRECIVER = "GetReciver";

    public static final String FUNC_SETRECIVERCONFIRM = "SetReciverConfirm";

    public static final String FUNC_GETRECIVERCOMFIRM = "GetReciverComfirm";

    public static final Event SETMATERIALARREVENT_EVENT = new Event("SetMaterialArrEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event RESETMATERIALEVENT_EVENT = new Event("ResetMaterialEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event SETRECIVERCONFIRMEVENT_EVENT = new Event("SetReciverConfirmEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    @Deprecated
    protected WayBill(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected WayBill(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected WayBill(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected WayBill(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> SetMaterialArr(List<String> _materialArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void SetMaterialArr(List<String> _materialArr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String SetMaterialArrSeq(List<String> _materialArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<List<String>> getSetMaterialArrAddressArrayInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<List<String>>(

                convertToNative((List<Address>) results.get(0).getValue())
                );
    }

    public RemoteCall<List> GetMaterialArr() {
        final Function function = new Function(FUNC_GETMATERIALARR, 
                Arrays.<Type>asList(), 
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

    public RemoteCall<String> GetReciver() {
        final Function function = new Function(FUNC_GETRECIVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> SetReciverConfirm(String _manager) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_manager)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void SetReciverConfirm(String _manager, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_manager)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String SetReciverConfirmSeq(String _manager) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_manager)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getSetReciverConfirmInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<Boolean> GetReciverComfirm() {
        final Function function = new Function(FUNC_GETRECIVERCOMFIRM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<TransactionReceipt> SetMaterialArr(List<BigInteger> _varietyArr, List<BigInteger> _amountArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void SetMaterialArr(List<BigInteger> _varietyArr, List<BigInteger> _amountArr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String SetMaterialArrSeq(List<BigInteger> _varietyArr, List<BigInteger> _amountArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<List<BigInteger>, List<BigInteger>> getSetMaterialArrUint256ArrayUint256ArrayInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<List<BigInteger>, List<BigInteger>>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue())
                );
    }

    public List<SetMaterialArrEventEventResponse> getSetMaterialArrEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETMATERIALARREVENT_EVENT, transactionReceipt);
        ArrayList<SetMaterialArrEventEventResponse> responses = new ArrayList<SetMaterialArrEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetMaterialArrEventEventResponse typedResponse = new SetMaterialArrEventEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerSetMaterialArrEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALARREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerSetMaterialArrEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALARREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<ResetMaterialEventEventResponse> getResetMaterialEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(RESETMATERIALEVENT_EVENT, transactionReceipt);
        ArrayList<ResetMaterialEventEventResponse> responses = new ArrayList<ResetMaterialEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            ResetMaterialEventEventResponse typedResponse = new ResetMaterialEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.i = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerResetMaterialEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(RESETMATERIALEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerResetMaterialEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(RESETMATERIALEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<SetReciverConfirmEventEventResponse> getSetReciverConfirmEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETRECIVERCONFIRMEVENT_EVENT, transactionReceipt);
        ArrayList<SetReciverConfirmEventEventResponse> responses = new ArrayList<SetReciverConfirmEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetReciverConfirmEventEventResponse typedResponse = new SetReciverConfirmEventEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerSetReciverConfirmEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRECIVERCONFIRMEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerSetReciverConfirmEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRECIVERCONFIRMEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static WayBill load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new WayBill(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static WayBill load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new WayBill(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static WayBill load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new WayBill(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static WayBill load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new WayBill(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<WayBill> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(WayBill.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<WayBill> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(WayBill.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<WayBill> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(WayBill.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<WayBill> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(WayBill.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class SetMaterialArrEventEventResponse {
        public Log log;
    }

    public static class ResetMaterialEventEventResponse {
        public Log log;

        public BigInteger i;
    }

    public static class SetReciverConfirmEventEventResponse {
        public Log log;
    }
}
