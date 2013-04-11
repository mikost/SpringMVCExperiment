package name.mikkoostlund.spring_mvc_experiment;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class.getName());

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String showLoginForm() {
		return "login";
	}

    @RequestMapping("/login_success")
    public String showLoginSuccess(ModelMap model) {
        return "login_success";
    }


	@RequestMapping(value="/login_failure", method=RequestMethod.GET)
	public String showLoginFailure(ModelMap model) {
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout() {
		return "redirect:/index";
	}
}