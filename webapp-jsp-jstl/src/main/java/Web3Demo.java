import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.DefaultBlockParameterName;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.exceptions.TransactionTimeoutException;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;

/**
 * @author Tsikhan Kuprevich
 * @since 9/14/2017
 */
public class Web3Demo {

    private static String BASE_DIR = "c:\\Users\\tkuprevich\\AppData\\Roaming\\Ethereum\\geth\\youtube1-a\\keystore\\";

    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException, CipherException, TransactionTimeoutException {
        Web3j web3 = Web3j.build(new HttpService());

        Web3ClientVersion clientVersion = web3.web3ClientVersion().sendAsync().get();

        if (!clientVersion.hasError()) {
            System.out.println("Client is running version: " + clientVersion.getWeb3ClientVersion());
        }


        final String WALLET = "UTC--2017-09-08T12-46-51.895823300Z--715b742cf0b1ef0d63b6d79303e7e6308edd9aba";
        final String ACC_FROM = "0x715b742cf0b1ef0d63b6d79303e7e6308edd9aba";
        final String ACC_TO = "0xd99903b7592767147cbaf60eb6636cf9e0f38355";

        Credentials credentials = WalletUtils.loadCredentials("rootroot", BASE_DIR + WALLET);

        BigInteger balanceBefore = web3.ethGetBalance(ACC_FROM, DefaultBlockParameterName.LATEST).sendAsync().get().getBalance();
        System.out.println("balanceBefore: " + balanceBefore);

        BigDecimal amountTransferred = new BigDecimal(2);
        TransactionReceipt transactionReceipt = Transfer
                .sendFundsAsync(web3,
                        credentials,
                        ACC_TO,
                        amountTransferred,
                        Convert.Unit.WEI)
                .get();

        System.out.println("Funds transfer completed, transaction hash: " + transactionReceipt.getTransactionHash() +
                ", Block number: " + transactionReceipt.getBlockNumber() +
                ". Gas used: " + transactionReceipt.getGasUsed());

        BigInteger balanceAfter = web3.ethGetBalance(ACC_FROM, DefaultBlockParameterName.LATEST).sendAsync().get().getBalance();
        System.out.println("balanceAfter: " + balanceAfter);

        System.out.println("amountTransferred = " + amountTransferred);
        System.out.println("balanceBefore - balanceAfter = " + balanceBefore.subtract(balanceAfter));
        System.out.println("amountReduced = " + balanceBefore.subtract(balanceAfter));
    }
}
