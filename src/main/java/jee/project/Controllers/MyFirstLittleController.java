package jee.project.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MyFirstLittleController {

    @RequestMapping("/hello/{name}")
    public String helloWorld(@PathVariable String name, Map<String, Object> model) {
        model.put("message", "Coucou " + name + " !!!");
        return "hello";
    }
}
