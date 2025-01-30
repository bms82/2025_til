package per.msb.til.lessons.jan.wk4.passwdencryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class RIPEMD160Hashing {

    public static String hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("RIPEMD160");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        String input = "password";
        String hash = hash(input);
        System.out.println("RIPEMD-160 Hash: " + hash);
    }
}
