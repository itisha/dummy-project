package demo.web3j;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.TransactionEncoder;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.request.RawTransaction;
import org.web3j.protocol.core.methods.response.EthGetTransactionCount;
import org.web3j.protocol.core.methods.response.EthSendTransaction;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;
import org.web3j.utils.Numeric;
import rx.Subscription;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

/**
 * @author Tsikhan Kuprevich
 * @since 9/20/2017
 */
public class RealTimeTransactionsDemo {

    private static final String DATA_DIR = "\\geth\\datadir1\\keystore\\";

    private static final String A1 = "c35f6334f4064bf33f92f6859da8b66798560d00";
    private static final String A2 = "619b25972a3da326e2f80c3f60d16889c56e80cb";
    private static final String A3 = "c216d6c660020a4dbf4c3961ec7862c3193e14a3";

    private static final String A1_FILENAME = "UTC--2017-09-18T12-19-20.877523800Z--" + A1;
    private static final String A2_FILENAME = "UTC--2017-09-19T09-29-28.701203400Z--" + A2;
    private static final String A3_FILENAME = "UTC--2017-09-19T09-38-28.553431100Z--" + A3;

    private static Credentials credentials;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Web3j web3j = Web3j.build(new HttpService());  // defaults to http://localhost:8545/

        String web3ClientVersion = web3j.web3ClientVersion().sendAsync().get().getWeb3ClientVersion();
        if (web3ClientVersion != null) {
            System.out.println("Geth node connected: " + web3ClientVersion);
        }

        startMenu(web3j);
    }

    private static void startMenu(Web3j web3j) {
        List<Subscription> subscriptions = new LinkedList<>();
        int menu = Integer.MAX_VALUE;
        while (menu != 0) {
            menu = readMenu();
            switch (menu) {
                case 0:
                    System.out.println("Bye.");
                    System.exit(0);
                    break;
                case 1:
                    unsubscribeAll(subscriptions);
                    break;
                case 2:
                    etherTransfer(web3j);
                    break;
                case 3:
                    subscriptions.add(displayCurrentTransactions(web3j));
                    break;
                case 4:
                    createSignedTransaction(web3j);
                    break;
                default:
                    System.out.println("Incorrect value, try again.");
                    break;
            }
        }
    }

    private static void unsubscribeAll(List<Subscription> subscriptions) {
        Iterator<Subscription> iterator = subscriptions.iterator();
        while (iterator.hasNext()) {
            Subscription subscription = iterator.next();
            if (!subscription.isUnsubscribed())
                subscription.unsubscribe();
            iterator.remove();
        }
    }

    private static Subscription displayCurrentTransactions(Web3j web3j) {
        //To receive all new transactions as they are added to the blockchain:
        return web3j.transactionObservable().subscribe(tx -> {
            System.out.println("{" + "\n" +
                    "\t" + "blockHash: " + tx.getBlockHash() + ",\n" +
                    "\t" + "blockNumber: " + tx.getBlockNumber() + ",\n" +
                    "\t" + "from: " + tx.getFrom() + ",\n" +
                    "\t" + "gas: " + tx.getGas() + ",\n" +
                    "\t" + "gasPrice: " + tx.getGasPrice() + ",\n" +
                    "\t" + "hash: " + tx.getHash() + ",\n" +
                    "\t" + "input: " + tx.getInput() + ",\n" +
                    "\t" + "nonce: " + tx.getNonce() + ",\n" +
                    "\t" + "r: " + tx.getR() + ",\n" +
                    "\t" + "s: " + tx.getS() + ",\n" +
                    "\t" + "to: " + tx.getTo() + ",\n" +
                    "\t" + "transactionIndex: " + tx.getTransactionIndex() + ",\n" +
                    "\t" + "v: " + tx.getV() + ",\n" +
                    "\t" + "value: " + tx.getValue() + "\n" +
                    "}"
            );
        });
    }

    private static void etherTransfer(Web3j web3j) {
        try {
            System.out.println("Transfering " + BigDecimal.valueOf(1.0) + " of Ether from A2 = 0x" + A2 + " to A3 = 0x" + A3 + ":");
            if (credentials == null) {
                credentials = WalletUtils.loadCredentials("rootroot", WalletUtils.getDefaultKeyDirectory() + DATA_DIR + A2_FILENAME);
            }
            TransactionReceipt transactionReceipt = Transfer.sendFunds(web3j, credentials, "0x" + A3, BigDecimal.valueOf(1.0), Convert.Unit.ETHER);
            System.out.println("Transaction hash: " + transactionReceipt.getTransactionHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void createSignedTransaction(Web3j web3j) {
        try {
            if (credentials == null) {
                credentials = WalletUtils.loadCredentials("rootroot", WalletUtils.getDefaultKeyDirectory() + DATA_DIR + A2_FILENAME);
            }

            // get the next available nonce
            EthGetTransactionCount ethGetTransactionCount = web3j.ethGetTransactionCount("0x" + A2, DefaultBlockParameterName.LATEST).sendAsync().get();
            BigInteger nonce = ethGetTransactionCount.getTransactionCount();

            // create our transaction
            RawTransaction rawTransaction = RawTransaction.createEtherTransaction(
                    nonce,
                    BigInteger.valueOf(1L),
                    BigInteger.valueOf(3),
                    "0x" + A3,
                    BigInteger.valueOf(1));

            // sign & send our transaction
            byte[] signedMessage = TransactionEncoder.signMessage(rawTransaction, credentials);
            String hexValue = Numeric.toHexString(signedMessage);
            System.out.println("HEX value: " + hexValue);
            EthSendTransaction ethSendTansaction = web3j.ethSendRawTransaction(hexValue).sendAsync().get();
            System.out.println("Transaction hash: " + ethSendTansaction.getTransactionHash());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int readMenu() {
        System.out.println("Select operation:");
        System.out.println("1 - Unsubscribe all subscriptions");
        System.out.println("2 - Ether Transfer from A1 to A2");
        System.out.println("3 - Display Transactions in Real Time");
        System.out.println("4 - Create signed Transaction");
        System.out.println("0 - Quit");

        int selection;
        Scanner input = new Scanner(System.in);
        selection = input.nextInt();
        return selection;
    }
}
