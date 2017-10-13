import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import rx.Subscription;

import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * @author Tsikhan Kuprevich
 * @since 9/27/2017
 */
public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Web3ClientVersion web3ClientVersion = web3.web3ClientVersion().sendAsync().get();
        String clientVersion = web3ClientVersion.getWeb3ClientVersion();
        System.out.println(clientVersion);

        Subscription subscription1 = web3.blockObservable(false).subscribe(block -> {
            System.out.println("Block Hash: " + block.getBlock().getHash());
            System.out.println("Gas Used: " + block.getBlock().getGasUsed());
        });

        Subscription subscription2 = web3.pendingTransactionObservable().subscribe(tx -> {
            System.out.println("Transaction hash: " + tx.getHash());
            System.out.println("Transaction gasLimit: " + tx.getGas());
            System.out.println("Transaction cost: " + tx.getGas().multiply(tx.getGasPrice()));
            System.out.println("Transaction value: " + tx.getValue());
        });


        new Scanner(System.in).next();
        subscription1.unsubscribe();
        subscription2.unsubscribe();
        System.exit(0);
    }
}
