package contract.wrapped;

import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;

import java.math.BigInteger;

/**
 * @author Tsikhan Kuprevich
 * @since 9/21/2017
 */
public class WrappedContractDeployDemo {

    private static final String DATA_DIR = "\\geth\\datadir1\\keystore\\";

    private static final String A1 = "c35f6334f4064bf33f92f6859da8b66798560d00";
    private static final String A2 = "619b25972a3da326e2f80c3f60d16889c56e80cb";
    private static final String A3 = "c216d6c660020a4dbf4c3961ec7862c3193e14a3";

    private static final String A1_FILENAME = "UTC--2017-09-18T12-19-20.877523800Z--" + A1;
    private static final String A2_FILENAME = "UTC--2017-09-19T09-29-28.701203400Z--" + A2;
    private static final String A3_FILENAME = "UTC--2017-09-19T09-38-28.553431100Z--" + A3;

    public static void main(String[] args) throws Exception {
        Web3j web3 = Web3j.build(new HttpService());  // defaults to http://localhost:8545/
        Credentials credentials = WalletUtils.loadCredentials("rootroot", WalletUtils.getDefaultKeyDirectory() + DATA_DIR + A2_FILENAME);

        Helloworld contract = Helloworld.deploy(
                web3,
                credentials,
                BigInteger.valueOf(90),
                BigInteger.valueOf(900000L),
                BigInteger.valueOf(900000L))
                .get();
        System.out.println("ContractAddress : " + contract.getContractAddress());
    }


}
