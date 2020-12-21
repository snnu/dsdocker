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
public class Waybill extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b50604051620020b4380380620020b48339810180604052810190808051906020019092919080518201929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508060039080519060200190620001109291906200015a565b5081600460016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505062000209565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200019d57805160ff1916838001178555620001ce565b82800160010185558215620001ce579182015b82811115620001cd578251825591602001919060010190620001b0565b5b509050620001dd9190620001e1565b5090565b6200020691905b8082111562000202576000816000905550600101620001e8565b5090565b90565b611e9b80620002196000396000f3006080604052600436106100ba576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806303cbe728146100bf57806313af4035146100ee578063181d3293146101715780631aff24ba146101885780636089a92c146102315780636368d63914610248578063893d20e8146102ae5780639f82635414610305578063a9ed9cb814610360578063f1f3321e146103a3578063f262af30146103fa578063ff9913e814610466575b600080fd5b3480156100cb57600080fd5b506100d46104a9565b604051808215151515815260200191505060405180910390f35b3480156100fa57600080fd5b5061012f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104c0565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561017d57600080fd5b506101866105ce565b005b34801561019457600080fd5b5061022f600480360381019080803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192908035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929050505061078d565b005b34801561023d57600080fd5b50610246610b21565b005b34801561025457600080fd5b506102ac60048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290505050610d62565b005b3480156102ba57600080fd5b506102c3610fe3565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561031157600080fd5b50610346600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061100c565b604051808215151515815260200191505060405180910390f35b34801561036c57600080fd5b506103a1600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611062565b005b3480156103af57600080fd5b506103b8611181565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561040657600080fd5b5061040f6111ab565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b83811015610452578082015181840152602081019050610437565b505050509050019250505060405180910390f35b34801561047257600080fd5b506104a7600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611239565b005b6000600460009054906101000a900460ff16905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610586576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550339050919050565b600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106b9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001807f417574683a206f6e6c792074686520726563697665722063616e20636f6e666981526020017f726d00000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b60001515600460009054906101000a900460ff161515141515610744576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f416c726561647920636f6e6669726d656400000000000000000000000000000081525060200191505060405180910390fd5b6001600460006101000a81548160ff0219169083151502179055507f93a447d1fc306bb0c8e7e142119dc30937df8a6ea6ebf5023ef25c27f168d66660405160405180910390a1565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610854576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b825184511415156108f3576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a8152602001807f54686572652061726520736f6d657468696e672077726f6e672077697468206d81526020017f6174657269616c4172720000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600091505b8351821015610aef57600090505b828281518110151561091457fe5b90602001906020020151811015610ae2576002848381518110151561093557fe5b906020019060200201516001610949611357565b8083815260200182815260200192505050604051809103906000f080158015610976573d6000803e3d6000fd5b5090806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055505060026001600280549050038154811015156109f157fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632356c933610a3f610fe3565b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610abd57600080fd5b505af1158015610ad1573d6000803e3d6000fd5b505050508080600101915050610906565b81806001019250506108f8565b7f97b4e81eaf5e268de44c747bc2baafc7a17d152e9733b059d40cf789df103aa160405160405180910390a150505050565b6000600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610c0e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260228152602001807f417574683a206f6e6c792074686520726563697665722063616e20636f6e666981526020017f726d00000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600090505b600280549050811015610d5f57600281815481101515610c2f57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166313af4035600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050602060405180830381600087803b158015610d1657600080fd5b505af1158015610d2a573d6000803e3d6000fd5b505050506040513d6020811015610d4057600080fd5b8101908080519060200190929190505050508080600101915050610c13565b50565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e28576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060","2001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600090505b8151811015610fb35760028282815181101515610e4657fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050600281815481101515610ec257fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16632356c933610f10610fe3565b6040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b158015610f8e57600080fd5b505af1158015610fa2573d6000803e3d6000fd5b505050508080600101915050610e2d565b7f97b4e81eaf5e268de44c747bc2baafc7a17d152e9733b059d40cf789df103aa160405160405180910390a15050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611126576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6060600280548060200260200160405190810160405280929190818152602001828054801561122f57602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116111e5575b5050505050905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156112fd576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b604051610b0880611368833901905600608060405234801561001057600080fd5b50604051604080610b088339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555081600281905550806003819055506000600460006101000a81548160ff02191690831515021790555050506109d98061012f6000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806313af4035146100b45780632356c93314610137578063554d0ecf1461017a57806379fd18b0146101d1578063893d20e8146101e85780639abeb9401461023f5780639f8263541461026e578063a9ed9cb8146102c9578063c1e802861461030c578063d321fe2914610337578063ff9913e814610362575b600080fd5b3480156100c057600080fd5b506100f5600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506103a5565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561014357600080fd5b50610178600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506104b3565b005b34801561018657600080fd5b5061018f6105bb565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156101dd57600080fd5b506101e66105e5565b005b3480156101f457600080fd5b506101fd6106c6565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561024b57600080fd5b506102546106ef565b604051808215151515815260200191505060405180910390f35b34801561027a57600080fd5b506102af600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610706565b604051808215151515815260200191505060405180910390f35b3480156102d557600080fd5b5061030a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061075c565b005b34801561031857600080fd5b5061032161087b565b6040518082815260200191505060405180910390f35b34801561034357600080fd5b5061034c610885565b6040518082815260200191505060405180910390f35b34801561036e57600080fd5b506103a3600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061088f565b005b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561046b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b816000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550339050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610577576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b80600460016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b6000600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156106a9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6001600460006101000a81548160ff021916908315150217905550565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600460009054906101000a900460ff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610820576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000600254905090565b6000600354905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610953576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f776564000000000000008152506020019150506040518091","0390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff021916908315150217905550505600a165627a7a72305820524e5610a26a1744fdd97070d3a7421bb986f062947f92c516ba3da057e08c4c0029a165627a7a72305820df277272c5a080c1037bfd4a1c6a024ba10bfeab8bc1be22be1c37e016ca58990029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getReciverComfirm\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"setReciverConfirm\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varietyArr\",\"type\":\"uint256[]\"},{\"name\":\"_amountArr\",\"type\":\"uint256[]\"}],\"name\":\"setMaterial\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[],\"name\":\"setMaterialsOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_materialArr\",\"type\":\"address[]\"}],\"name\":\"setMaterialArr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"showAllowed\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getReciver\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMaterialArr\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_reciver\",\"type\":\"address\"},{\"name\":\"_number\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setMaterialArrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"i\",\"type\":\"uint256\"}],\"name\":\"resetMaterialEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setReciverConfirmEvent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETRECIVERCOMFIRM = "getReciverComfirm";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_SETRECIVERCONFIRM = "setReciverConfirm";

    public static final String FUNC_SETMATERIAL = "setMaterial";

    public static final String FUNC_SETMATERIALSOWNER = "setMaterialsOwner";

    public static final String FUNC_SETMATERIALARR = "setMaterialArr";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_SHOWALLOWED = "showAllowed";

    public static final String FUNC_DISALLOW = "disallow";

    public static final String FUNC_GETRECIVER = "getReciver";

    public static final String FUNC_GETMATERIALARR = "getMaterialArr";

    public static final String FUNC_ALLOW = "allow";

    public static final Event SETMATERIALARREVENT_EVENT = new Event("setMaterialArrEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event RESETMATERIALEVENT_EVENT = new Event("resetMaterialEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event SETRECIVERCONFIRMEVENT_EVENT = new Event("setReciverConfirmEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    @Deprecated
    protected Waybill(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Waybill(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Waybill(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Waybill(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<Boolean> getReciverComfirm() {
        final Function function = new Function(FUNC_GETRECIVERCOMFIRM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
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

    public Tuple1<String> getSetOwnerOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_SETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setReciverConfirm() {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setReciverConfirm(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setReciverConfirmSeq() {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> setMaterial(List<BigInteger> _varietyArr, List<BigInteger> _amountArr) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterial(List<BigInteger> _varietyArr, List<BigInteger> _amountArr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialSeq(List<BigInteger> _varietyArr, List<BigInteger> _amountArr) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<List<BigInteger>, List<BigInteger>> getSetMaterialInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<List<BigInteger>, List<BigInteger>>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue())
                );
    }

    public RemoteCall<TransactionReceipt> setMaterialsOwner() {
        final Function function = new Function(
                FUNC_SETMATERIALSOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterialsOwner(TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALSOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialsOwnerSeq() {
        final Function function = new Function(
                FUNC_SETMATERIALSOWNER, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public RemoteCall<TransactionReceipt> setMaterialArr(List<String> _materialArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterialArr(List<String> _materialArr, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialArrSeq(List<String> _materialArr) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class))), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<List<String>> getSetMaterialArrInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<List<String>>(

                convertToNative((List<Address>) results.get(0).getValue())
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

    public RemoteCall<String> getReciver() {
        final Function function = new Function(FUNC_GETRECIVER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<List> getMaterialArr() {
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

    public void registersetMaterialArrEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALARREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registersetMaterialArrEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
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

    public void registerresetMaterialEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(RESETMATERIALEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerresetMaterialEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
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

    public void registersetReciverConfirmEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRECIVERCONFIRMEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registersetReciverConfirmEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETRECIVERCONFIRMEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static Waybill load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Waybill(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Waybill load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Waybill(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Waybill load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Waybill(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Waybill load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Waybill(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Waybill> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(Waybill.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<Waybill> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(Waybill.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Waybill> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(Waybill.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<Waybill> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _reciver, String _number) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_reciver), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_number)));
        return deployRemoteCall(Waybill.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
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
