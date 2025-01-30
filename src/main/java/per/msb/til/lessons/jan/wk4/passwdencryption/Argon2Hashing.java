package per.msb.til.lessons.jan.wk4.passwdencryption;

import org.bouncycastle.crypto.generators.Argon2BytesGenerator;
import org.bouncycastle.crypto.params.Argon2Parameters;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Argon2Hashing {

    public static String hash(String password) {
        Argon2BytesGenerator generator = new Argon2BytesGenerator();
        byte[] passwordBytes = password.getBytes(StandardCharsets.UTF_8);
        byte[] salt = new byte[16]; // 16 bytes salt
        byte[] hash = new byte[32]; // 32 bytes hash

        // Configure Argon2 parameters
        Argon2Parameters.Builder builder = new Argon2Parameters.Builder();
        builder.withIterations(3).withMemoryAsKB(16 * 1024).withParallelism(4).withSalt(salt);
        Argon2Parameters parameters = builder.build();

        generator.init(parameters);
        generator.generateBytes(passwordBytes, hash);

        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    public static void main(String[] args) {
        String password = "password";
        String hash = hash(password);
        System.out.println("Argon2 Hash: " + hash);
    }
}
