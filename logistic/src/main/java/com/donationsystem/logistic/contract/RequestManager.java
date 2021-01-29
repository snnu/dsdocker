package com.donationsystem.logistic.contract;

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
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
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
    public static final String[] BINARY_ARRAY = {"60806040523480156200001157600080fd5b5060405162002823380380620028238339810180604052810190808051906020019092919080518201929190505050336000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555060018060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555081600860006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055508060049080519060200190620001519291906200016a565b5060006006819055506000600781905550505062000219565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f10620001ad57805160ff1916838001178555620001de565b82800160010185558215620001de579182015b82811115620001dd578251825591602001919060010190620001c0565b5b509050620001ed9190620001f1565b5090565b6200021691905b8082111562000212576000816000905550600101620001f8565b5090565b90565b6125fa80620002296000396000f3006080604052600436106100f1576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff168063038defd7146100f657806313af403514610139578063478c45ca1461017c578063488660121461026a57806367e0badb146102dd5780636ae2be6e14610308578063775a25e3146103355780637fad850e14610360578063893d20e8146103a15780639344b8a2146103f85780639f826354146104b5578063a6c03e9514610510578063a9ed9cb8146105fe578063ac007cea14610641578063f6d29c6914610686578063ff42857a146106c7578063ff9913e81461076d575b600080fd5b34801561010257600080fd5b50610137600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506107b0565b005b34801561014557600080fd5b5061017a600480360381019080803573ffffffffffffffffffffffffffffffffffffffff1690602001909291905050506109b5565b005b34801561018857600080fd5b50610191610abc565b6040518085815260200180602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019060200280838360005b838110156102105780820151818401526020810190506101f5565b50505050905001838103825285818151815260200191508051906020019060200280838360005b83811015610252578082015181840152602081019050610237565b50505050905001965050505050505060405180910390f35b34801561027657600080fd5b506102db60048036038101908080359060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610dcb565b005b3480156102e957600080fd5b506102f2611112565b6040518082815260200191505060405180910390f35b34801561031457600080fd5b506103336004803603810190808035906020019092919050505061111c565b005b34801561034157600080fd5b5061034a6112b2565b6040518082815260200191505060405180910390f35b34801561036c57600080fd5b5061038b600480360381019080803590602001909291905050506112bf565b6040518082815260200191505060405180910390f35b3480156103ad57600080fd5b506103b66113a0565b604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390f35b34801561040457600080fd5b5061049f60048036038101908080359060200190820180359060200190808060200260200160405190810160405280939291908181526020018383602002808284378201915050505050509192919290803590602001908201803590602001908080602002602001604051908101604052809392919081815260200183836020028082843782019150505050505091929192905050506113c9565b6040518082815260200191505060405180910390f35b3480156104c157600080fd5b506104f6600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611724565b604051808215151515815260200191505060405180910390f35b34801561051c57600080fd5b5061052561177a565b6040518085815260200180602001806020018473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001838103835286818151815260200191508051906020019060200280838360005b838110156105a4578082015181840152602081019050610589565b50505050905001838103825285818151815260200191508051906020019060200280838360005b838110156105e65780820151818401526020810190506105cb565b50505050905001965050505050505060405180910390f35b34801561060a57600080fd5b5061063f600480360381019080803573ffffffffffffffffffffffffffffffffffffffff169060200190929190505050611a25565b005b34801561064d57600080fd5b5061066c60048036038101908080359060200190929190505050611b44565b604051808215151515815260200191505060405180910390f35b34801561069257600080fd5b506106b1600480360381019080803590602001909291905050506120c5565b6040518082815260200191505060405180910390f35b3480156106d357600080fd5b506106f2600480360381019080803590602001909291905050506120ef565b6040518080602001828103825283818151815260200191508051906020019080838360005b83811015610732578082015181840152602081019050610717565b50505050905090810190601f16801561075f5780820380516001836020036101000a031916815260200191505b509250505060405180910390f35b34801561077957600080fd5b506107ae600480360381019080803573ffffffffffffffffffffffffffffffffffffffff16906020019092919050505061233e565b005b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610874576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b8073ffffffffffffffffffffffffffffffffffffffff1663912000993060046040518363ffffffff167c0100000000000000000000000000000000000000000000000000000000028152600401808373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff168152602001806020018281038252838181546001816001161561010002031660029004815260200191508054600181600116156101000203166002900480156109795780601f1061094e57610100808354040283529160200191610979565b820191906000526020600020905b81548152906001019060200180831161095c57829003601f168201915b50509350505050600060405180830381600087803b15801561099a57600080fd5b505af11580156109ae573d6000803e3d6000fd5b5050505050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610a79576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b806000806101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff16021790555050565b600060608060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610b87576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600580549050600754101515610c2b576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602e8152602001807f7468657265206973206e6f206167726565642072657175657374206e6565647381526020017f20746f2062652068616e646c656400000000000000000000000000000000000081525060400191505060405180910390fd5b6005600754815481101515610c3c57fe5b906000526020600020015460026005600754815481101515610c5a57fe5b9060005260206000200154815481101515610c7157fe5b906000526020600020906005020160000160026005600754815481101515610c9557fe5b9060005260206000200154815481101515610cac57fe5b906000526020600020906005020160010160026005600754815481101515610cd057fe5b9060005260206000200154815481101515610ce757fe5b906000526020600020906005020160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1682805480602002602001604051908101604052809291908181526020018280548015610d6457602002820191906000526020600020905b815481526020019060010190808311610d50575b5050505050925081805480602002602001604051908101604052809291908181526020018280548015610db657602002820191906000526020600020905b815481526020019060010190808311610da2575b50505050509150935093509350935090919293565b6000809054906101000a90","0473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515610e8f576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60065482101515610f08576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f7468657265206973206e6f20737563682072657165757374000000000000000081525060200191505060405180910390fd5b6001600283815481101515610f1957fe5b906000526020600020906005020160030154141515610fc6576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252602c8152602001807f546869732077617962696c6c206861736e27742062652068616e646c6564206f81526020017f722062652072656675736564000000000000000000000000000000000000000081525060400191505060405180910390fd5b6000600283815481101515610fd757fe5b9060005260206000209060050201600401805460018160011615610100020316600290049050141515611072576040517f08c379a000000000000000000000000000000000000000000000000000000000815260040180806020018281038252600b8152602001807f53657420416c726561647900000000000000000000000000000000000000000081525060200191505060405180910390fd5b8060028381548110151561108257fe5b906000526020600020906005020160040190805190602001906110a692919061245c565b5060036002838154811015156110b857fe5b906000526020600020905050506007600081548092919060010191905055507f1b1abebe9ce1343412b5b6c08572ca16ff138498d1ddbccaac2ac457f7a490cf826040518082815260200191505060405180910390a15050565b6000600654905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161415156111e2576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600090505b6002828154811015156111f657fe5b9060005260206000209060050201600001805490508110156112ae5760028281548110151561122157fe5b90600052602060002090600502016001018181548110151561123f57fe5b90600052602060002001546003600060028581548110151561125d57fe5b90600052602060002090600502016000018481548110151561127b57fe5b906000526020600020015481526020019081526020016000206000828254039250508190555080806001019150506111e7565b5050565b6000600280549050905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611385576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60036000838152602001908152602001600020549050919050565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16905090565b60008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff161480611476575060011515600160003373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff161515145b1515611510576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260268152602001807f4f6e6c79207468652061757468656e746963617465642075736572206973206181526020017f6c6c6f776564000000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b81518351141515611589576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260108152602001807f4c656e677468206e6f7420657175616c0000000000000000000000000000000081525060200191505060405180910390fd5b600260a0604051908101604052808581526020018481526020013373ffffffffffffffffffffffffffffffffffffffff1681526020016000815260200160206040519081016040528060008152508152509080600181540180825580915050906001820390600052602060002090600502016000909192909190915060008201518160000190805190602001906116219291906124dc565b50602082015181600101908051906020019061163e9291906124dc565b5060408201518160020160006101000a81548173ffffffffffffffffffffffffffffffffffffffff021916908373ffffffffffffffffffffffffffffffffffffffff1602179055506060820151816003015560808201518160040190805190602001906116ac929190612529565b505050507f06d5845e5992e4d79ad081eaadafdafa92b3b62e0fe46638d06b5f9e9770455533604051808273ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200191505060405180910390a1600160028054905003905092915050565b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060009054906101000a900460ff169050919050565b600060608060008060009054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611845576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6002805490506006541015156118e9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260278152602001807f7468657265206973206e6f2072657175657374206e6565647320746f2062652081526020017f68616e646c65640000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b60065460026006548154811015156118fd57fe5b9060005260206000209060050201600001600260065481548110151561191f57fe5b9060005260206000209060050201600101600260065481548110151561194157fe5b906000526020600020906005020160020160009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16828054806020026020016040519081016040528092919081815260200182805480156119be57602002820191906000526020600020905b8154815260200190600101908083116119aa575b5050505050925081805480602002602001604051908101604052809291908181526020018280548015611a1057602002820191906000526020600020905b8154815260200190600101908083116119fc575b50505050509150935093509350935090919293565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611ae9576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b6000600160008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b6000806000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515611c0b576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b600280549050600654101515611caf576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260278152602001807f7468657265206973206e6f2072657175657374206e6565647320746f2062652081526020017f68616e646c65640000000000000000000000000000000000000000000000000081525060400191505060405180910390fd5b6002831415611cfa577f9e23420fad8baea24efd03c49f211bfac99433b6895e07c47f026ed06d45d7446006546040518082815260200191505060405180910390a1600091506120bf565b600090505b6002600654815481101515611d1057fe5b906000526020600020906005020160000180549050811015611f47576002600654815481101515611d3d57fe5b906000526020600020906005020160010181815481101515611d5b57fe5b9060005260206000200154600360006002600654815481101515611d7b57fe5b906000526020600020906005020160000184815481101515611d9957fe5b9060005260206000200154815260200190815260200160002054600860009054906101000a900473ffffffffffffffffffffffffffffffffffffffff16","73ffffffffffffffffffffffffffffffffffffffff1663d3e5d2a96002600654815481101515611e0257fe5b906000526020600020906005020160000185815481101515611e2057fe5b90600052602060002001546040518263ffffffff167c010000000000000000000000000000000000000000000000000000000002815260040180828152602001915050602060405180830381600087803b158015611e7d57600080fd5b505af1158015611e91573d6000803e3d6000fd5b505050506040513d6020811015611ea757600080fd5b8101908080519060200190929190505050031015611f3a57600660008154809291906001019190505550600280600654815481101515611ee357fe5b9060005260206000209060050201600301819055507f9e23420fad8baea24efd03c49f211bfac99433b6895e07c47f026ed06d45d7446006546040518082815260200191505060405180910390a1600091506120bf565b8080600101915050611cff565b600090505b6002600654815481101515611f5d57fe5b906000526020600020906005020160000180549050811015612019576002600654815481101515611f8a57fe5b906000526020600020906005020160010181815481101515611fa857fe5b9060005260206000200154600360006002600654815481101515611fc857fe5b906000526020600020906005020160000184815481101515611fe657fe5b90600052602060002001548152602001908152602001600020600082825401925050819055508080600101915050611f4c565b6001600260065481548110151561202c57fe5b906000526020600020906005020160030181905550600560065490806001815401808255809150509060018203906000526020600020016000909192909190915055507f9e23420fad8baea24efd03c49f211bfac99433b6895e07c47f026ed06d45d7446006546040518082815260200191505060405180910390a1600660008154809291906001019190505550600191505b50919050565b60006002828154811015156120d657fe5b9060005260206000209060050201600301549050919050565b60606002805490508210151561216d576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260188152602001807f7468657265206973206e6f20737563682072657165757374000000000000000081525060200191505060405180910390fd5b600654821015156121e6576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f746869732072657175657374206861736e2774206265656e2068616e646c656481525060200191505060405180910390fd5b60036002838154811015156121f757fe5b90600052602060002090600502016003015414151561227e576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260208152602001807f7468657265206973206e6f2077617962696c6c20666f7220746869732072657181525060200191505060405180910390fd5b60028281548110151561228d57fe5b90600052602060002090600502016004018054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156123325780601f1061230757610100808354040283529160200191612332565b820191906000526020600020905b81548152906001019060200180831161231557829003601f168201915b50505050509050919050565b6000809054906101000a900473ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff163373ffffffffffffffffffffffffffffffffffffffff16141515612402576040517f08c379a00000000000000000000000000000000000000000000000000000000081526004018080602001828103825260198152602001807f4f6e6c7920746865206f776e657220697320616c6c6f7765640000000000000081525060200191505060405180910390fd5b60018060008373ffffffffffffffffffffffffffffffffffffffff1673ffffffffffffffffffffffffffffffffffffffff16815260200190815260200160002060006101000a81548160ff02191690831515021790555050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061249d57805160ff19168380011785556124cb565b828001600101855582156124cb579182015b828111156124ca5782518255916020019190600101906124af565b5b5090506124d891906125a9565b5090565b828054828255906000526020600020908101928215612518579160200282015b828111156125175782518255916020019190600101906124fc565b5b50905061252591906125a9565b5090565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061256a57805160ff1916838001178555612598565b82800160010185558215612598579182015b8281111561259757825182559160200191906001019061257c565b5b5090506125a591906125a9565b5090565b6125cb91905b808211156125c75760008160009055506001016125af565b5090565b905600a165627a7a723058207d31daf1ad427c32ae8f01268029e4344e90af97649bb920f09f76c6d6c7e1600029"};

    public static final String BINARY = String.join("", BINARY_ARRAY);

    public static final String[] ABI_ARRAY = {"[{\"constant\":false,\"inputs\":[{\"name\":\"locationManager\",\"type\":\"address\"}],\"name\":\"registry\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"setOwner\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getAgreedReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"reciver\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_num\",\"type\":\"uint256\"},{\"name\":\"_waybillNum\",\"type\":\"string\"}],\"name\":\"setWayBillNum\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_num\",\"type\":\"uint256\"}],\"name\":\"setLockedMaterial\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getTotal\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_variety\",\"type\":\"uint256\"}],\"name\":\"getLockedMaterial\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getOwner\",\"outputs\":[{\"name\":\"\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"_varieties\",\"type\":\"uint256[]\"},{\"name\":\"_amounts\",\"type\":\"uint256[]\"}],\"name\":\"createReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"showAllowed\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[],\"name\":\"getReq\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"\",\"type\":\"uint256[]\"},{\"name\":\"reciver\",\"type\":\"address\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"disallow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"state\",\"type\":\"uint256\"}],\"name\":\"handleReq\",\"outputs\":[{\"name\":\"\",\"type\":\"bool\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_num\",\"type\":\"uint256\"}],\"name\":\"getReqState\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"_num\",\"type\":\"uint256\"}],\"name\":\"getWayBillNum\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"usr\",\"type\":\"address\"}],\"name\":\"allow\",\"outputs\":[],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"inputs\":[{\"name\":\"_materialManager\",\"type\":\"address\"},{\"name\":\"_name\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"constructor\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"_a\",\"type\":\"address\"}],\"name\":\"createReqEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"num\",\"type\":\"uint256\"}],\"name\":\"handledReqEvent\",\"type\":\"event\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"num\",\"type\":\"uint256\"}],\"name\":\"sendedEvent\",\"type\":\"event\"}]"};

    public static final String ABI = String.join("", ABI_ARRAY);

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_REGISTRY = "registry";

    public static final String FUNC_SETOWNER = "setOwner";

    public static final String FUNC_GETAGREEDREQ = "getAgreedReq";

    public static final String FUNC_SETWAYBILLNUM = "setWayBillNum";

    public static final String FUNC_GETNUM = "getNum";

    public static final String FUNC_SETLOCKEDMATERIAL = "setLockedMaterial";

    public static final String FUNC_GETTOTAL = "getTotal";

    public static final String FUNC_GETLOCKEDMATERIAL = "getLockedMaterial";

    public static final String FUNC_GETOWNER = "getOwner";

    public static final String FUNC_CREATEREQ = "createReq";

    public static final String FUNC_SHOWALLOWED = "showAllowed";

    public static final String FUNC_GETREQ = "getReq";

    public static final String FUNC_DISALLOW = "disallow";

    public static final String FUNC_HANDLEREQ = "handleReq";

    public static final String FUNC_GETREQSTATE = "getReqState";

    public static final String FUNC_GETWAYBILLNUM = "getWayBillNum";

    public static final String FUNC_ALLOW = "allow";

    public static final Event CREATEREQEVENT_EVENT = new Event("createReqEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
    ;

    public static final Event HANDLEDREQEVENT_EVENT = new Event("handledReqEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
    ;

    public static final Event SENDEDEVENT_EVENT = new Event("sendedEvent", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
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

    public RemoteCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>> getAgreedReq() {
        final Function function = new Function(FUNC_GETAGREEDREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>>(
                new Callable<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>>() {
                    @Override
                    public Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>(
                                (BigInteger) results.get(0).getValue(), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> setWayBillNum(BigInteger _num, String _waybillNum) {
        final Function function = new Function(
                FUNC_SETWAYBILLNUM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_waybillNum)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setWayBillNum(BigInteger _num, String _waybillNum, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETWAYBILLNUM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_waybillNum)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setWayBillNumSeq(BigInteger _num, String _waybillNum) {
        final Function function = new Function(
                FUNC_SETWAYBILLNUM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_waybillNum)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<BigInteger, String> getSetWayBillNumInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETWAYBILLNUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<BigInteger, String>(

                (BigInteger) results.get(0).getValue(), 
                (String) results.get(1).getValue()
                );
    }

    public RemoteCall<BigInteger> getNum() {
        final Function function = new Function(FUNC_GETNUM, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> setLockedMaterial(BigInteger _num) {
        final Function function = new Function(
                FUNC_SETLOCKEDMATERIAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void setLockedMaterial(BigInteger _num, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_SETLOCKEDMATERIAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String setLockedMaterialSeq(BigInteger _num) {
        final Function function = new Function(
                FUNC_SETLOCKEDMATERIAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<BigInteger> getSetLockedMaterialInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_SETLOCKEDMATERIAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getTotal() {
        final Function function = new Function(FUNC_GETTOTAL, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<BigInteger> getLockedMaterial(BigInteger _variety) {
        final Function function = new Function(FUNC_GETLOCKEDMATERIAL, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_variety)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getOwner() {
        final Function function = new Function(FUNC_GETOWNER, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Address>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
    }

    public RemoteCall<TransactionReceipt> createReq(List<BigInteger> _varieties, List<BigInteger> _amounts) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void createReq(List<BigInteger> _varieties, List<BigInteger> _amounts, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_CREATEREQ, 
                Arrays.<Type>asList(_varieties.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_varieties, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class)), 
                _amounts.isEmpty()?org.fisco.bcos.web3j.abi.datatypes.DynamicArray.empty("uint256[]"):new org.fisco.bcos.web3j.abi.datatypes.DynamicArray<org.fisco.bcos.web3j.abi.datatypes.generated.Uint256>(
                        org.fisco.bcos.web3j.abi.Utils.typeMap(_amounts, org.fisco.bcos.web3j.abi.datatypes.generated.Uint256.class))), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String createReqSeq(List<BigInteger> _varieties, List<BigInteger> _amounts) {
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

    public RemoteCall<Boolean> showAllowed(String usr) {
        final Function function = new Function(FUNC_SHOWALLOWED, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(usr)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        return executeRemoteCallSingleValueReturn(function, Boolean.class);
    }

    public RemoteCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>> getReq() {
        final Function function = new Function(FUNC_GETREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<DynamicArray<Uint256>>() {}, new TypeReference<Address>() {}));
        return new RemoteCall<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>>(
                new Callable<Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>>() {
                    @Override
                    public Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<BigInteger, List<BigInteger>, List<BigInteger>, String>(
                                (BigInteger) results.get(0).getValue(), 
                                convertToNative((List<Uint256>) results.get(1).getValue()), 
                                convertToNative((List<Uint256>) results.get(2).getValue()), 
                                (String) results.get(3).getValue());
                    }
                });
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

    public RemoteCall<TransactionReceipt> handleReq(BigInteger state) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(state)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void handleReq(BigInteger state, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(state)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String handleReqSeq(BigInteger state) {
        final Function function = new Function(
                FUNC_HANDLEREQ, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(state)), 
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

    public Tuple1<Boolean> getHandleReqOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_HANDLEREQ, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Bool>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<Boolean>(

                (Boolean) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> getReqState(BigInteger _num) {
        final Function function = new Function(FUNC_GETREQSTATE, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<String> getWayBillNum(BigInteger _num) {
        final Function function = new Function(FUNC_GETWAYBILLNUM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.generated.Uint256(_num)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        return executeRemoteCallSingleValueReturn(function, String.class);
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

    public void registercreateReqEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATEREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registercreateReqEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(CREATEREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<HandledReqEventEventResponse> getHandledReqEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(HANDLEDREQEVENT_EVENT, transactionReceipt);
        ArrayList<HandledReqEventEventResponse> responses = new ArrayList<HandledReqEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            HandledReqEventEventResponse typedResponse = new HandledReqEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.num = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerhandledReqEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(HANDLEDREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerhandledReqEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(HANDLEDREQEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    public List<SendedEventEventResponse> getSendedEventEvents(TransactionReceipt transactionReceipt) {
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(SENDEDEVENT_EVENT, transactionReceipt);
        ArrayList<SendedEventEventResponse> responses = new ArrayList<SendedEventEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
            SendedEventEventResponse typedResponse = new SendedEventEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.num = (BigInteger) eventValues.getNonIndexedValues().get(0).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registersendedEventEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SENDEDEVENT_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registersendedEventEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(SENDEDEVENT_EVENT);
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

    public static RemoteCall<RequestManager> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider, String _materialManager, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_materialManager), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(RequestManager.class, web3j, credentials, contractGasProvider, BINARY, encodedConstructor);
    }

    public static RemoteCall<RequestManager> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider, String _materialManager, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_materialManager), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(RequestManager.class, web3j, transactionManager, contractGasProvider, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RequestManager> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit, String _materialManager, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_materialManager), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(RequestManager.class, web3j, credentials, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    @Deprecated
    public static RemoteCall<RequestManager> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit, String _materialManager, String _name) {
        String encodedConstructor = FunctionEncoder.encodeConstructor(Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Address(_materialManager), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(_name)));
        return deployRemoteCall(RequestManager.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, encodedConstructor);
    }

    public static class CreateReqEventEventResponse {
        public Log log;

        public String _a;
    }

    public static class HandledReqEventEventResponse {
        public Log log;

        public BigInteger num;
    }

    public static class SendedEventEventResponse {
        public Log log;

        public BigInteger num;
    }
}
