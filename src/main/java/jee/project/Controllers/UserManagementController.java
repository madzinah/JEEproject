package jee.project.Controllers;

import jee.project.Entity.User;
import jee.project.Repository.UserRepository;
import jee.project.Security.TokenManager;
import jee.project.Utils.AuthenticationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.UUID;

@Controller
public class UserManagementController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/user/register", method=RequestMethod.POST, produces="application/json")
    public String register(@ModelAttribute("user") @Valid User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            // When being registered the normal way, the user has always by default the User role.
            user.setRole(AuthenticationUtils.Role.USER);
            registerUser(user);
            return "Registered !";
        }

        return "Already registered !";
    }

    @RequestMapping(value="/user/login", method=RequestMethod.POST, produces="application/json")
    public UUID login(@RequestBody User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());
        if (!userRepository.existsByEmail(user.getEmail())
                && !AuthenticationUtils.checkUserPassword(user, storedUser)) {
            return null;
        }
        return TokenManager.getTokenForUser(storedUser);
    }

    public void registerUser(User user) {
        user.setSalt(AuthenticationUtils.generateSalt());
        user.setPassword(
                AuthenticationUtils.generateHashedPassword(
                        user.getPassword(), user.getSalt()));
        userRepository.save(user);
    }


}
