package jee.project.Controllers;

import jee.project.Entity.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

public class AdministrationControllerTests {

    /**
     * URI of the Rest service.
     */
    private static final String REST_SERVICE_URI = "http://localhost:8080";

    /**
     * RestTemplate used to interact with Rest service.
     */
    private RestTemplate restTemplate;

    private UUID adminToken;

    @Before
    public void setup() {
        restTemplate = new RestTemplate();
        // An Admin User
        User admin = new User();
        admin.setEmail("admin@jee.com");
        admin.setPassword("Adm1nPassword");
        // Login
        ResponseEntity<UUID> responseAdminLogin = restTemplate.postForEntity(REST_SERVICE_URI + "/user/login",
                admin, UUID.class);
        adminToken = responseAdminLogin.getBody();
    }

    @After
    public void tearDown() {
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("token", adminToken.toString());
        restTemplate.postForLocation(REST_SERVICE_URI + "/user/logout", map);

        adminToken = null;
    }

    @Test
    public void listUsersMustContains2Users() {
        // Given an admin token
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("token", adminToken.toString());

        // When requesting for the list of users.
        ResponseEntity<List> response = restTemplate.postForEntity(REST_SERVICE_URI + "/admin/user", map, List.class);

        // Then
        // The answer must be OK.
        assert(response.getStatusCode().equals(HttpStatus.OK));
        // The number of users must be 2.
        assert(response.getBody().size() == 2);

    }

    @Test
    public void listUsersMustSendAForbiddenWhenNotLoggedAsAnAdmin() {
        // Given a random token
        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("token", UUID.randomUUID().toString());

        try {
            // When requesting for the list of users.
            restTemplate.postForEntity(REST_SERVICE_URI + "/admin/user", map, List.class);
            assert(false);
        } catch (HttpClientErrorException e) {
            // Then
            // The answer must be FORBIDDEN.
            assert(e.getStatusCode().equals(HttpStatus.FORBIDDEN));
        }
    }
}
