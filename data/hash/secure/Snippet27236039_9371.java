import java.security.spec.InvalidKeySpecException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.ibm.broker.javacompute.Base64;

public class Security {
    private static final String AES_PASS = "43qyu3qwjaw8ga5azbro00ig"; // Hashed into an AES key later
    private SecretKeySpec keyObj;
    private Cipher cipher;
    private IvParameterSpec ivObj;

    public Security() throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        // A constant IV, since CBC requires an IV but we don't really need one
        byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        this.ivObj = new IvParameterSpec(iv);

        // Create an SHA-256 256-bit hash of the key
        byte[] key = AES_PASS.getBytes();
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        key = sha.digest(key);
        key = Arrays.copyOf(key, 32); // Use only first 256 bit
        this.keyObj = new SecretKeySpec(key, "AES");

        // Create a Cipher by specifying the following parameters
        //  a. Algorithm name - here it is AES 
        //  b. Mode - here it is CBC mode 
        //  c. Padding - e.g. PKCS7 or PKCS5
        this.cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public String encrypt(String strDataToEncrypt) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
        String strCipherText = new String();

        this.cipher.init(Cipher.ENCRYPT_MODE, this.keyObj, this.ivObj);

        // Encrypt the Data 
        //  a. Declare / Initialize the Data. Here the data is of type String 
        //  b. Convert the Input Text to Bytes 
        //  c. Encrypt the bytes using doFinal method
        byte[] byteDataToEncrypt = strDataToEncrypt.getBytes();

        byte[] byteCipherText = this.cipher.doFinal(byteDataToEncrypt);

        // b64 is done differently on Android
        strCipherText = Base64.encode(byteCipherText);

        return strCipherText;
    }

    public String decrypt(String strCipherText) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, NoSuchPaddingException {
        String strDecryptedText = new String();

        // Initialize the Cipher for Encryption
        this.cipher.init(Cipher.DECRYPT_MODE, this.keyObj, this.ivObj);

        // Decode the Base64 text
        byte[] cipherBytes = Base64.decode(strCipherText);

        // Decrypt the Data
        //  a. Initialize a new instance of Cipher for Decryption (normally don't reuse the same object)
        //     Be sure to obtain the same IV bytes for CBC mode.
        //  b. Decrypt the cipher bytes using doFinal method
        byte[] byteDecryptedText = this.cipher.doFinal(cipherBytes);
        strDecryptedText = new String(byteDecryptedText);

        return strDecryptedText;
    }
}
