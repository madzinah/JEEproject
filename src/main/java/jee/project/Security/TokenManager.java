package jee.project.Security;

import jee.project.Entity.User;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TokenManager {

    private final static int TOKEN_EXPIRATION_TIME_IN_DAYS = 60;

    private static Map<UUID, User> tokenMap = new HashMap<>();

    private static Map<UUID, LocalDate> tokenExpirationMap = new HashMap<>();

    /**
     * Get the User linked to the UUID Token,
     *  if the token is expired, we clean the map.
     *  @param token Token to authenticate an user.
     * @return The user linked to the UUID Token, if not found, return null.
     */
    public static User getUserFromUUID(UUID token) {
        if (tokenExpirationMap.containsKey(token)) {

            if (tokenExpirationMap.get(token).isAfter(LocalDate.now())) {
                return tokenMap.get(token);
            }
            tokenMap.remove(token);
            tokenExpirationMap.remove(token);
        }
        return null;
    }

    /**
     * Create a Token to authenticate the User user.
     * @param user User needing a token.
     * @return the token
     */
    public static UUID getTokenForUser(User user) {
        UUID token = UUID.randomUUID();

        while (tokenMap.containsKey(token)) {
            token = UUID.randomUUID();
        }

        tokenMap.put(token, user);
        tokenExpirationMap.put(token, LocalDate.now().plusDays(TOKEN_EXPIRATION_TIME_IN_DAYS));

        return token;
    }

    public static void removeToken(UUID token) {
        tokenMap.remove(token);
        tokenExpirationMap.remove(token);
    }

}
