package name.mikkoostlund.spring_mvc_experiment;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WelcomeController {

    @RequestMapping({"/", "/index"})
    public String showHomePage(Map<String, Object> model) {
        return "welcome";
    }
}
