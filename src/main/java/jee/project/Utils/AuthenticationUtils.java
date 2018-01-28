package jee.project.Utils;


import jee.project.Entity.User;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.crypto.keygen.KeyGenerators;


public class AuthenticationUtils {

    public enum Role {
        USER,
        ADMIN
    }

    public static byte[] generateSalt() {
        return KeyGenerators.secureRandom(64).generateKey();
    }

    public static String generateHashedPassword(String password, byte[] salt) {
        ShaPasswordEncoder encoder = new ShaPasswordEncoder(512);
        return encoder.encodePassword(password, salt);
    }

    public static boolean checkUserPassword(User userNowLogging, User storedUser) {
        assert(userNowLogging.getEmail().equals(storedUser.getEmail()));
        String encodedLoggingPassword = generateHashedPassword(userNowLogging.getPassword(), storedUser.getSalt());
        return encodedLoggingPassword.equals(storedUser.getHashedPassword());
    }

}