package jee.project.Controllers;

import jee.project.Entity.User;
import jee.project.Repository.UserRepository;
import jee.project.Security.TokenManager;
import jee.project.Utils.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class AdministrationController {

    @Autowired
    private UserRepository userRepository;

    //
    // User CRUD
    //

    @RequestMapping(value="/admin/user", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<List<User>> listUsers(String token) {
        if (checkAdminPrivileges(token)) {
            List<User> users = new ArrayList<>();
            userRepository.findAll().forEach(user -> users.add(0, user));
            return new ResponseEntity(users, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value="/admin/user/add", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<String> addUser(String token, @Valid User user) {

        if (checkAdminPrivileges(token) && !userRepository.existsByEmail(user.getEmail())) {
            registerUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value="/admin/user/get", method= RequestMethod.GET, produces="application/json")
    public User searchUserByEmail(String token, String email) {

        if (checkAdminPrivileges(token) && userRepository.existsByEmail(email)) {
            return userRepository.findDistinctFirstByEmail(email);
        }
        return null;
    }

    @RequestMapping(value="/admin/user/update", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<String> updateUser(String token, @Valid User user) {

        if (checkAdminPrivileges(token) && userRepository.existsByEmail(user.getEmail())) {
            User oldUser = userRepository.findDistinctFirstByEmail(user.getEmail());
            user.setId(oldUser.getId());
            registerUser(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    @RequestMapping(value="/admin/user/delete", method= RequestMethod.POST, produces="application/json")
    public ResponseEntity<String> deleteUser(String token, String email) {

        if (checkAdminPrivileges(token) && userRepository.existsByEmail(email)) {
            User user = userRepository.findDistinctFirstByEmail(email);
            userRepository.delete(user);
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.FORBIDDEN);
    }

    //
    // CSV EXPORT
    //

    @RequestMapping(value="/admin/user/export/csv", method= RequestMethod.GET, produces="application/json")
    public void listUsersCSVExport(String token, HttpServletResponse response) throws IOException {
        if (checkAdminPrivileges(token)) {

            String csvFileName = "users.csv";

            response.setContentType("text/csv");

            String headerKey = "Content-Disposition";
            String headerValue = String.format("attachment; filename=\"%s\"",
                    csvFileName);
            response.setHeader(headerKey, headerValue);


            StringBuilder builder = new StringBuilder();
            String csvSeparator = ";";

            builder.append("Id").append(csvSeparator)
                    .append("Email").append(csvSeparator)
                    .append("Role").append(csvSeparator).append('\n');

            userRepository.findAll().forEach(user ->
                    builder.append(user.getId()).append(csvSeparator)
                            .append(user.getEmail()).append(csvSeparator)
                            .append(user.getRole()).append('\n')
            );

            response.getOutputStream().print(builder.toString());
        }
    }

    //
    //  TOOLS
    //

    public void registerUser(User user) {
        user.setSalt(AuthenticationUtils.generateSalt());
        user.setHashedPassword(
                AuthenticationUtils.generateHashedPassword(
                        user.getPassword(), user.getSalt()));
        userRepository.save(user);
    }

    public boolean checkAdminPrivileges(String token) {

        User user = TokenManager.getUserFromUUID(UUID.fromString(token));

        return  user != null // is the user connected ?
            && user.getRole() == AuthenticationUtils.Role.ADMIN; // is the user an Admin ?
    }

}
