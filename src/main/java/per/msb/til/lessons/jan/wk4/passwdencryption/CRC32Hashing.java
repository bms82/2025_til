package per.msb.til.lessons.jan.wk4.passwdencryption;

import java.util.zip.CRC32;

public class CRC32Hashing {

    public static String hash(String input) {
        CRC32 crc = new CRC32();
        crc.update(input.getBytes());
        long checksum = crc.getValue();
        return Long.toHexString(checksum);
    }

    public static void main(String[] args) {
        String input = "password";
        String hash = hash(input);
        System.out.println("CRC32 Hash: " + hash);
    }
}
