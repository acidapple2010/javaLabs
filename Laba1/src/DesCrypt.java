import javax.crypto.*;
import javax.crypto.Cipher;
import java.io.*;
import java.security.*;

public class DesCrypt{
    Cipher ecipher;
    Cipher dcipher;

    /**
     * @param key секретный ключ алгоритма DES. Экземпляр класса SecretKey
     * @throws NoSuchAlgorithmException
     * @throws NoSuchPaddingException
     * @throws InvalidKeyException
     */
    public DesCrypt(SecretKey key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
        ecipher = Cipher.getInstance("DES");
        dcipher = Cipher.getInstance("DES");
        ecipher.init(Cipher.ENCRYPT_MODE, key);
        dcipher.init(Cipher.DECRYPT_MODE, key);
    }

    /**
     * @param str строка открытого текста
     * @return зашифрованная строка в формате Base64
     * @throws UnsupportedEncodingException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String encrypt2(String str) throws UnsupportedEncodingException, IllegalBlockSizeException, BadPaddingException {
        byte[] CP1251 = str.getBytes("CP1251");
        byte[] enc = ecipher.doFinal(CP1251);
        return new sun.misc.BASE64Encoder().encode(enc);
    }

    /**
     * Функция расшифрования
     * @param str зашифрованная строка в формате Base64
     * @return расшифрованная строка
     * @throws IOException
     * @throws IllegalBlockSizeException
     * @throws BadPaddingException
     */
    public String decrypt2(String str) throws IOException, IllegalBlockSizeException, BadPaddingException {
        byte[] dec = new sun.misc.BASE64Decoder().decodeBuffer(str);
        byte[] CP1251 = dcipher.doFinal(dec);
        return new String(CP1251, "CP1251");
    }
}


