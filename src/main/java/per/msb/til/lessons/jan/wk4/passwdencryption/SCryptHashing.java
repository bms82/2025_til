package per.msb.til.lessons.jan.wk4.passwdencryption;

import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

public class SCryptHashing {

    public static String hash(String password) {
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder(1,1,1,1,1);
        return passwordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password = "password";
        String hash = hash(password);
        System.out.println("SCrypt Hash: " + hash);
    }
}
