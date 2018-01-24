package jeeproject.jeeproject.Controllers;

import jeeproject.jeeproject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyFirstLittleController {

    @Autowired
    private UserRepository userRepository;



    @RequestMapping("/api/hello/{name}")
    public Hello helloApi(@PathVariable String name) {
        return new Hello(name);
    }

    @RequestMapping("/test35")
    public String test() {
        return "test";
    }

    public class Hello {
        public Hello(String name) {
            this.name = name;
        }
        private String name;

        public String getName() {
            return name;
        }
    }
}
