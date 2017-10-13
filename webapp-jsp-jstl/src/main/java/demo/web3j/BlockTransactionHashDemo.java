package demo.web3j;

import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

/**
 * @author Tsikhan Kuprevich
 * @since 9/20/2017
 */
public class BlockTransactionHashDemo {


    public static void main(String[] args) {
        Web3j web3j = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        //todo
        System.out.println("getDefaultKeyDirectory : " + WalletUtils.getDefaultKeyDirectory());

        //To receive all new blocks as they are added to the blockchain:
        Subscription subscription1 = web3j.blockObservable(false).subscribe(blockContainer -> {
            EthBlock.Block block = blockContainer.getBlock();
            System.out.println("Block: " + block.getHash());
            for (EthBlock.TransactionResult transaction : block.getTransactions()) {
                System.out.println("└---- Transaction: " + transaction.get());
            }
        });
    }
}
