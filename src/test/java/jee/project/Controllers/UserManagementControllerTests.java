package jee.project.Controllers;

import jee.project.Entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

public class UserManagementControllerTests {

    /**
     * URI of the Rest service.
     */
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    /**
     * RestTemplate used to interact with Rest service.
     */
    private RestTemplate restTemplate;

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void usingAnInvalidEmailWhenRegisteringCreateAnError() {

        // Given
        // A user
        User user = new User();
        // With a wrong Email
        user.setEmail("wrongEmail");
        // And a valid password
        user.setPassword("Val1dPassword");


        try {
            // When trying to register it
            restTemplate.postForEntity(REST_SERVICE_URI + "/user/register",
                    user, String.class);
            assert(false);
        } catch (HttpClientErrorException e) {
            // Then should return a 400.
            assert (e.getLocalizedMessage().equals("400 null"));
        }
    }

    @Test
    public void usingAnInvalidPasswordWhenRegisteringCreateAnError() {

        // Given
        // A user
        User user = new User();
        // With a correct Email
        user.setEmail("correct@email.com");
        // And an invalid password
        user.setPassword("InvalidPassword");

        try {
            // When trying to register it
            restTemplate.postForEntity(REST_SERVICE_URI + "/user/register",
                    user, String.class);
            assert(false);
        } catch (HttpClientErrorException e) {
            // Then should return a 400.
            assert (e.getLocalizedMessage().equals("400 null"));
        }
    }

    @Test
    public void registeringAnAlreadyRegisteredUser() {

        // Given
        // A user already registered
        User user = new User();
        // With a correct Email
        user.setEmail("correct@email.com");
        // And a valid password
        user.setPassword("Val1dPassword");

        // When trying to register it
        ResponseEntity<String> response = restTemplate.postForEntity(REST_SERVICE_URI + "/user/register",
                    user, String.class);
        // Then the response must be a 200.
        assert(response.getStatusCode().equals(HttpStatus.OK));
        // And the body must be "Already registered !"
        assert(response.getBody().equals("Already registered !"));
    }


    @Test
    public void registerAnUser() {

        // You'll need an admin in base (here's mine)

        // Given
        // An Admin User
        User admin = new User();
        admin.setEmail("admin@jee.com");
        admin.setPassword("Adm1nPassword");

        // A User
        User user = new User();
        // With a correct Email
        user.setEmail("correctNeverRegistered@email.com");
        // And a valid password
        user.setPassword("Val1dPassword");

        // When trying to register it
        ResponseEntity<String> response = restTemplate.postForEntity(REST_SERVICE_URI + "/user/register",
                user, String.class);

        // Then the response must be a 200.
        assert(response.getStatusCode().equals(HttpStatus.OK));
        // And the body must be "Registered !"
        assert(response.getBody().equals("Registered !"));


        // Clean up (by removing the user)
        // Login
        ResponseEntity<UUID> responseAdminLogin = restTemplate.postForEntity(REST_SERVICE_URI + "/user/login",
                admin, UUID.class);
        UUID adminToken = responseAdminLogin.getBody();
        if (adminToken != null) {
            MultiValueMap<String, Object> map = new LinkedMultiValueMap();
            map.add("token", adminToken.toString());
            map.add("email", user.getEmail());
            // Delete
            restTemplate.postForEntity(REST_SERVICE_URI + "/admin/user/delete",
                    map, String.class);
            // Logout
            restTemplate.postForLocation(REST_SERVICE_URI + "/user/logout", adminToken);
        }
    }
}
