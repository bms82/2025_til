package per.msb.til.lessons.jan.wk4.passwdencryption;
/**
 *
 *    1. Encryption & Hashing
 *    Argon2: Highly recommended for secure password hashing due to its adaptability and resistance to attacks.
 *     BCrypt: Well-regarded and widely used for its adaptive complexity.
 *     SCrypt: Suitable for high-security applications requiring memory-hard algorithms.
 *     SHA-256 and SHA-512: Part of the SHA-2 family, suitable for general-purpose cryptographic hashing but not ideal alone for password hashing.
 *     RIPEMD-160: Provides reasonable security but less commonly used.
 *     MD5: Deprecated for security purposes due to vulnerabilities.
 *     SHA-1: Deprecated for modern cryptographic use due to weaknesses.
 *     CRC32: Not suitable for security; used for error-checking.
 *
 *  For secure password hashing, Argon2, BCrypt, and SCrypt are the most recommended options.
 *
 * 2. Password Salting
 * Salting involves adding a unique, random value to each password before hashing. This ensures that identical passwords result in different hash values.
 *
 * Advantages of Salting:
 *
 *     Prevents Rainbow Table Attacks: Unique salts ensure that precomputed hash tables are ineffective.
 *     Increases Security: Makes identical passwords produce different hashes, enhancing security.
 *
 * Reference:
 * https://medium.com/@mbanaee61/password-encryption-hashing-and-salting-in-java-eaa2d46b06e5
 */