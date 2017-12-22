package jee.project.Controllers;

import jeeproject.jeeproject.Entity.User;
import jeeproject.jeeproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class MyFirstLittleController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name, Map<String, Object> model) {

        User n = new User();
        n.setPassword(name);
        n.setEmail(name);
        userRepository.save(n);
        model.put("message", "Coucou " + name + " !!!");
        return "hello";
    }

    @RequestMapping("/session/add")
    public String addSession(Map<String, Object> model, HttpSession httpSession) {
        Integer o = (Integer)httpSession.getAttribute("testSession");
        httpSession.setAttribute("testSession", o == null ? 0 : ++o);
        model.put("testSession", httpSession.getAttribute("testSession"));
        return "testSession";
    }

    @RequestMapping("/session/get")
    public String getSession(Map<String, Object> model, HttpSession httpSession) {
        model.put("testSession", httpSession.getAttribute("testSession"));
        return "testSession";
    }
}
