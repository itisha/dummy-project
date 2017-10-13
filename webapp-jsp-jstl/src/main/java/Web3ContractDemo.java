import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.CipherException;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.io.IOException;
import java.math.BigInteger;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author Tsikhan Kuprevich
 * @since 9/14/2017
 */
public class Web3ContractDemo {

    private static final String BASE_DIR = "c:\\Users\\tkuprevich\\AppData\\Roaming\\Ethereum\\geth\\youtube1-a\\keystore\\";
    private static final String WALLET = "UTC--2017-09-08T12-46-51.895823300Z--715b742cf0b1ef0d63b6d79303e7e6308edd9aba";
    private static final String ACC_FROM = "0x715b742cf0b1ef0d63b6d79303e7e6308edd9aba";
    private static final String ACC_TO = "0xd99903b7592767147cbaf60eb6636cf9e0f38355";

    public static void main(String[] args) throws IOException, CipherException, ExecutionException, InterruptedException {
        Web3j web3 = Web3j.build(new HttpService());

        Credentials credentials = WalletUtils.loadCredentials("rootroot", BASE_DIR + WALLET);

        Future<Greeter> future = Greeter
                .deploy(web3,
                        credentials,
                        BigInteger.valueOf(21000L),
                        BigInteger.valueOf(1800000L),
                        BigInteger.ZERO,
                        new Utf8String("Hello blockchain world!"));
        Greeter contract = future.get();

        Utf8String greeting = contract.greet().get();
        System.out.println(greeting.getTypeAsString());
    }
}
