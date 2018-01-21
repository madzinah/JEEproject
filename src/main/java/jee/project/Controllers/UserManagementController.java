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

    @RequestMapping(value="/user/register", method=RequestMethod.POST)
    public String register(@ModelAttribute("user") @Valid User user) {
        if (!userRepository.existsByEmail(user.getEmail())) {
            user.setSalt(AuthenticationUtils.generateSalt());
            user.setPassword(
                    AuthenticationUtils.generateHashedPassword(
                            user.getPassword(), user.getSalt()));
            userRepository.save(user);
            return "Registered !";
        }

        return "Already registered !";
    }

    @RequestMapping(value="/user/login", method=RequestMethod.POST)
    public UUID login(@RequestBody User user) {
        User storedUser = userRepository.findByEmail(user.getEmail());
        if (!userRepository.existsByEmail(user.getEmail())
                && !AuthenticationUtils.checkUserPassword(user, storedUser)) {
            return null;
        }
        return TokenManager.getTokenForUser(storedUser);
    }
}
