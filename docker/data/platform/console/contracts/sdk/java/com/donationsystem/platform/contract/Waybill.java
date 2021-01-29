package com.donationsystem.platform.contract;

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
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
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
public class Waybill extends Contract {
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b506040516200268b3803806200268b8339810180604052810190808051906020019092919080518201929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff0219169083151502179055508060039080519060200190620001109291906200015a565b5081600460016101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550505062000209565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f106200019d57805160ff1916838001178555620001ce565b82800160010185558215620001ce579182015b82811115620001cd578251825591602001919060010190620001b0565b5b509050620001dd9190620001e1565b5090565b6200020691905b8082111562000202576000816000905550600101620001e8565b5090565b90565b61247280620002196000396000f3006080604052600436106100af576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff16806303cbe728146100b457806313af4035146100e35780632e8d268c146101265780635dc35a9b146101d25780637179dbc6146102c1578063893d20e81461034a5780639f826354146103a1578063a9ed9cb8146103fc578063f1f3321e1461043f578063f262af3014610496578063ff9913e814610502575b600080fd5b3480156100c057600080fd5b506100c9610545565b604051808215151515815260200191505060405180910390f35b3480156100ef57600080fd5b50610124600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061055c565b005b34801561013257600080fd5b506101d060048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610663565b005b3480156101de57600080fd5b506102bf6004803603810190808035906020019082018035906020019080806020026020016040519081016040528093929190818152602001838360200280828437820191505050505050919291929080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610951565b005b3480156102cd57600080fd5b50610348600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610d52565b005b34801561035657600080fd5b5061035f6111c7565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156103ad57600080fd5b506103e2600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506111f0565b604051808215151515815260200191505060405180910390f35b34801561040857600080fd5b5061043d600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611246565b005b34801561044b57600080fd5b50610454611365565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156104a257600080fd5b506104ab61138f565b6040518080602001828103825283818151815260200191508051906020019060200280838360005b838110156104ee5780820151818401526020810190506104d3565b505050509050019250505060405180910390f35b34801561050e57600080fd5b50610543600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061141d565b005b6000600460009054906101000a900460ff16905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610620576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610729576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600090505b8251811015610920576002838281518110151561074757fe5b9060200190602002015190806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506002818154811015156107c357fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1662b0fdb86108106111c7565b846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b838110156108ae578082015181840152602081019050610893565b50505050905090810190601f1680156108db5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b1580156108fb57600080fd5b505af115801561090f573d6000803e3d6000fd5b50505050808060010191505061072e565b7f97b4e81eaf5e268de44c747bc2baafc7a17d152e9733b059d40cf789df103aa160405160405180910390a1505050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a18576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b83518551141515610ab7576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602a8152602001807f54686572652061726520736f6d657468696e672077726f6e672077697468206d81526020017f6174657269616c4172720000000000000000000000000000000000000000000081525060400191505060405180910390fd5b600091505b8451821015610d1f57600090505b8382815181101515610ad857fe5b90602001906020020151811015610d125760028583815181101515610af957fe5b906020019060200201516001610b0d61153b565b8083815260200182815260200192505050604051809103906000f080158015610b3a573d6000803e3d6000fd5b5090806001815401808255809150509060018203906000526020600020016000909192909190916101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550506002600160028054905003815481101515610bb557fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1662b0fdb8610c026111c7565b856040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610ca0578082015181840152602081019050610c85565b50505050905090810190601f168015610ccd5780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b158015610ced57600080fd5b505af1158015610d01573d6000803e3d6000fd5b505050508080600101915050610aca565b8180600101925050610abc565b7f70de5c35c615f5c3d7dc9ff18d7e2b3bf035dd1bb31d219f7c3432b49ed84ccb60405160405180910390a15050505050565b6000600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e3f576040517f08c379a0000000000000000000000000000000000000000000000000000000008152600401808060200182810382526022815260200180","7f417574683a206f6e6c792074686520726563697665722063616e20636f6e666981526020017f726d00000000000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b60001515600460009054906101000a900460ff161515141515610eca576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260118152602001807f416c726561647920636f6e6669726d656400000000000000000000000000000081525060200191505060405180910390fd5b6001600460006101000a81548160ff021916908315150217905550600090505b60028054905081101561116a57600281815481101515610f0657fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1662b0fdb884846040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001828103825283818151815260200191508051906020019080838360005b83811015610fea578082015181840152602081019050610fcf565b50505050905090810190601f1680156110175780820380516001836020036101000a031916815260200191505b509350505050600060405180830381600087803b15801561103757600080fd5b505af115801561104b573d6000803e3d6000fd5b5050505060028181548110151561105e57fe5b9060005260206000200160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff166313af4035600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff166040518263ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001915050600060405180830381600087803b15801561114557600080fd5b505af1158015611159573d6000803e3d6000fd5b505050508080600101915050610eea565b7f8baa2b21686383bb8fa4ab9a6df1ffcde416c480ca0ed2972f4a156cbdd9f5b060405160405180910390a17f93a447d1fc306bb0c8e7e142119dc30937df8a6ea6ebf5023ef25c27f168d66660405160405180910390a1505050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561130a576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000600460019054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6060600280548060200260200160405190810160405280929190818152602001828054801561141357602002820191906000526020600020905b8160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190600101908083116113c9575b5050505050905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156114e1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b604051610efb8061154c833901905600608060405234801561001057600080fd5b50604051604080610efb8339810180604052810190808051906020019092919080519060200190929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555081600281905550806003819055506000600460006101000a81548160ff0219169083151502179055505050610dcc8061012f6000396000f3006080604052600436106100c4576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168062b0fdb8146100c957806313af4035146101525780631ab5f03b14610195578063554d0ecf1461027c5780635ee0a920146102d357806379fd18b0146102fe578063893d20e8146103155780639abeb9401461036c5780639f8263541461039b578063a9ed9cb8146103f6578063c1e8028614610439578063d321fe2914610464578063ff9913e81461048f575b600080fd5b3480156100d557600080fd5b50610150600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506104d2565b005b34801561015e57600080fd5b50610193600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061067a565b005b3480156101a157600080fd5b506101c060048036038101908080359060200190929190505050610781565b604051808573ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200180602001848152602001838152602001828103825285818151815260200191508051906020019080838360005b8381101561023e578082015181840152602081019050610223565b50505050905090810190601f16801561026b5780820380516001836020036101000a031916815260200191505b509550505050505060405180910390f35b34801561028857600080fd5b506102916108d6565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b3480156102df57600080fd5b506102e8610926565b6040518082815260200191505060405180910390f35b34801561030a57600080fd5b50610313610933565b005b34801561032157600080fd5b5061032a610a14565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561037857600080fd5b50610381610a3d565b604051808215151515815260200191505060405180910390f35b3480156103a757600080fd5b506103dc600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610a54565b604051808215151515815260200191505060405180910390f35b34801561040257600080fd5b50610437600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610aaa565b005b34801561044557600080fd5b5061044e610bc9565b6040518082815260200191505060405180910390f35b34801561047057600080fd5b50610479610bd3565b6040518082815260200191505060405180910390f35b34801561049b57600080fd5b506104d0600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050610bdd565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610596576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60056080604051908101604052804281526020018381526020018473ffffffffffffffffffffffffffffffffffffffff1681526020014381525090806001815401808255809150509060018203906000526020600020906004020160009091929091909150600082015181600001556020820151816001019080519060200190610621929190610cfb565b5060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff160217905550606082015181600301555050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff1614151561073e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffff","ffffffffffffffffffffffffff16021790555050565b6000606060008060058581548110151561079757fe5b906000526020600020906004020160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff166005868154811015156107d857fe5b90600052602060002090600402016001016005878154811015156107f857fe5b90600052602060002090600402016000015460058881548110151561081957fe5b906000526020600020906004020160030154828054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156108c05780601f10610895576101008083540402835291602001916108c0565b820191906000526020600020905b8154815290600101906020018083116108a357829003601f168201915b5050505050925093509350935093509193509193565b600060056001600580549050038154811015156108ef57fe5b906000526020600020906004020160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600580549050905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156109f7576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6001600460006101000a81548160ff021916908315150217905550565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b6000600460009054906101000a900460ff16905090565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b6e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000600254905090565b6000600354905090565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610ca1576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10610d3c57805160ff1916838001178555610d6a565b82800160010185558215610d6a579182015b82811115610d69578251825591602001919060010190610d4e565b5b509050610d779190610d7b565b5090565b610d9d91905b80821115610d99576000816000905550600101610d81565b5090565b905600a165627a7a7230582088adbac97853f55bda01fcbfd6355491b170c5147a3ee8e13f03c8b6241005520029a165627a7a7230582036b72ca000f4f570f601c9c137e7e0bb8182b32ff5f0937c4b0ea7bc8cd6fe570029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":true,\"inputs\":[],\"name\":\"getReciverComfirm\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_materialArr\",\"type\":\"address[]\"},{\"name\":\"_reciver\",\"type\":\"string\"}],\"name\":\"setMaterialArr\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varietyArr\",\"type\":\"uint256[]\"},{\"name\":\"_amountArr\",\"type\":\"uint256[]\"},{\"name\":\"_reciver\",\"type\":\"string\"}],\"name\":\"setMaterial\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_holder\",\"type\":\"address\"},{\"name\":\"_reciver\",\"type\":\"string\"}],\"name\":\"setReciverConfirm\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"showAllowed\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getReciver\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getMaterialArr\",\"outputs\":[{\"name\":\"\",\"type\":\"address[]\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_reciver\",\"type\":\"address\"},{\"name\":\"_number\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setMaterialEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setMaterialArrEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"i\",\"type\":\"uint256\"}],\"name\":\"resetMaterialEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setReciverConfirmEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[],\"name\":\"setMaterialsOwnerEvent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_GETRECIVERCOMFIRM = "getReciverComfirm";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_SETMATERIALARR = "setMaterialArr";

    public static final String FUNC_SETMATERIAL = "setMaterial";

    public static final String FUNC_SETRECIVERCONFIRM = "setReciverConfirm";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_SHOWALLOWED = "showAllowed";

    public static final String FUNC_DISALLOW = "disallow";

    public static final String FUNC_GETRECIVER = "getReciver";

    public static final String FUNC_GETMATERIALARR = "getMaterialArr";

    public static final String FUNC_ALLOW = "allow";

    public static final Event SETMATERIALEVENT_EVENT = new Event("setMaterialEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event SETMATERIALARREVENT_EVENT = new Event("setMaterialArrEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event RESETMATERIALEVENT_EVENT = new Event("resetMaterialEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event SETRECIVERCONFIRMEVENT_EVENT = new Event("setReciverConfirmEvent", 
            Arrays.<TypeReference<?>>asList());
    ;

    public static final Event SETMATERIALSOWNEREVENT_EVENT = new Event("setMaterialsOwnerEvent", 
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

    public RemoteCall<TransactionReceipt> setMaterialArr(List<String> _materialArr, String _reciver) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterialArr(List<String> _materialArr, String _reciver, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialArrSeq(List<String> _materialArr, String _reciver) {
        final Function function = new Function(
                FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(_materialArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("address[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.Address>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_materialArr, org.fisco.bcos.web3j.abi.datatypes.Address.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<List<String>, String> getSetMaterialArrInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIALARR, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Address>>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<List<String>, String>(

                convertToNative((List<Address>) results.get(0).getValue()), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setMaterial(List<BigInteger> _varietyArr, List<BigInteger> _amountArr, String _reciver) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setMaterial(List<BigInteger> _varietyArr, List<BigInteger> _amountArr, String _reciver, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setMaterialSeq(List<BigInteger> _varietyArr, List<BigInteger> _amountArr, String _reciver) {
        final Function function = new Function(
                FUNC_SETMATERIAL, 
                Arrays.<Type>asList(_varietyArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varietyArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amountArr.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amountArr, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<List<BigInteger>, List<BigInteger>, String> getSetMaterialInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETMATERIAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<List<BigInteger>, List<BigInteger>, String>(

                convertToNative((List<Uint256>) results.get(0).getValue()), 
                convertToNative((List<Uint256>) results.get(1).getValue()), 
                (String) results.get(2).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> setReciverConfirm(String _holder, String _reciver) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setReciverConfirm(String _holder, String _reciver, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setReciverConfirmSeq(String _holder, String _reciver) {
        final Function function = new Function(
                FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_holder), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_reciver)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, String> getSetReciverConfirmInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETRECIVERCONFIRM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue()
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

    public List<SetMaterialEventEventResponse> getSetMaterialEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETMATERIALEVENT_EVENT, transactionReceipt);
        ArrayList<SetMaterialEventEventResponse> responses = new ArrayList<SetMaterialEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetMaterialEventEventResponse typedResponse = new SetMaterialEventEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registersetMaterialEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registersetMaterialEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
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

    public List<SetMaterialsOwnerEventEventResponse> getSetMaterialsOwnerEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SETMATERIALSOWNEREVENT_EVENT, transactionReceipt);
        ArrayList<SetMaterialsOwnerEventEventResponse> responses = new ArrayList<SetMaterialsOwnerEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SetMaterialsOwnerEventEventResponse typedResponse = new SetMaterialsOwnerEventEventResponse();
            typedResponse.log = eventValues.getLog();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registersetMaterialsOwnerEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALSOWNEREVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registersetMaterialsOwnerEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SETMATERIALSOWNEREVENT_EVENT);
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

    public static class SetMaterialEventEventResponse {
        public Log log;
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

    public static class SetMaterialsOwnerEventEventResponse {
        public Log log;
    }
}
