package jeeproject.jeeproject.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyFirstLittleController {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "hello";
    }
}
