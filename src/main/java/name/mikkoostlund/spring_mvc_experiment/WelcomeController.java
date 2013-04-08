package name.mikkoostlund.spring_mvc_experiment;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes({"user"})
public class WelcomeController {

    @RequestMapping({"/", "/index"})
    public String showHomePage(ModelMap model) {
        return "welcome";
    }

    @ModelAttribute("user")
    public User crUser() {
    	System.out.println("crUser");
    	User user = new User();
    	user.setName("Rutger");
    	return user;
    }
}
