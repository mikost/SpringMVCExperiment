package MY.TOP.PACKAGE;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MY_CONTROLLER {

    @RequestMapping({"/", "/index"})
    public String showHomePage(Map<String, Object> model) {
        return "myView";
    }
}
