package blocks;

import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterNumber;
import org.web3j.protocol.core.methods.response.EthBlock;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Tsikhan Kuprevich
 * @since 9/22/2017
 */
public class IterateAllTransactionsDemo {


    private static final String DATA_DIR = "\\geth\\datadir1\\keystore\\";

    private static final String A1 = "c35f6334f4064bf33f92f6859da8b66798560d00";
    private static final String A2 = "619b25972a3da326e2f80c3f60d16889c56e80cb";
    private static final String A3 = "c216d6c660020a4dbf4c3961ec7862c3193e14a3";

    private static final String A1_FILENAME = "UTC--2017-09-18T12-19-20.877523800Z--" + A1;
    private static final String A2_FILENAME = "UTC--2017-09-19T09-29-28.701203400Z--" + A2;
    private static final String A3_FILENAME = "UTC--2017-09-19T09-38-28.553431100Z--" + A3;


    public static void main(String[] args) throws IOException, CipherException {

        Web3j web3j = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Credentials credentials = WalletUtils.loadCredentials("rootroot", WalletUtils.getDefaultKeyDirectory() + DATA_DIR + A2_FILENAME);

        //displays only blocks with transactions and subscribes for new
        //todo try to use filters to skip empty blocks?
        Subscription subscription = web3j.catchUpToLatestAndSubscribeToNewBlocksObservable(new DefaultBlockParameterNumber(0), true)
                .subscribe(block -> {
                    List<EthBlock.TransactionResult> transactions = block.getBlock().getTransactions();
                    if (transactions != null && !transactions.isEmpty()) {
                        System.out.println("Block: " + block.getBlock().getNumber() + "\tHash: " + block.getBlock().getHash());
                        for (EthBlock.TransactionResult transaction : transactions) {
                            System.out.println("└---- Transaction: " + ((EthBlock.TransactionObject) transaction).get().getHash());
                        }
                    }
                });

        System.out.println("Start");
        new Scanner(System.in).next();
        subscription.unsubscribe();
        System.out.println("Done");
    }
}
