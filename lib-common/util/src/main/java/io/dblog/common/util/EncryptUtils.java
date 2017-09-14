package io.dblog.common.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Pelin on 17/7/26.
 */
public class EncryptUtils {

    public static String SHA256(String str, String salt) throws NoSuchAlgorithmException {
        return SHA(str + salt, "SHA-256");
    }


    public static String SHA1(String str) throws NoSuchAlgorithmException {
        return SHA(str, "SHA-1");
    }

    private static String SHA(String str, String algorithm) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(algorithm);
        digest.update(str.getBytes());

        byte[] messageDigest = digest.digest();
        StringBuilder builder = new StringBuilder();
        for (byte aMessageDigest : messageDigest) {
            String shaHex = Integer.toHexString(aMessageDigest & 0xFF);
            if (shaHex.length() < 2) {
                builder.append(0);
            }
            builder.append(shaHex);
        }

        return builder.toString();
    }
}
