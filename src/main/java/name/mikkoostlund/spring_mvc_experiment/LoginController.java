package name.mikkoostlund.spring_mvc_experiment;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.WebRequest;

@Controller
@SessionAttributes("user")
public class LoginController {
	static Log log = LogFactory.getLog(LoginController.class.getName());
	@RequestMapping(value="/login" /*, method=RequestMethod.POST*/)
	public String showLoginResult(
						@ModelAttribute("user") User nisse,
						BindingResult          result,
						HttpServletRequest     httpServletRequest,
//						HttpServletResponse    httpServletResponse,
//						HttpSession            httpSession,
						WebRequest             webRequest,
//						NativeWebRequest       nativeWebRequest,
//						Locale                 locale,
//						//InputStream            is,
//						//Reader                 reader,
//						//OutputStream           os,
//						//Writer                 writer,
//						Principal              principal,
//						@PathVariable String   kallegurra,
//						@MatrixVariable String aktersnurra,
//						@RequestParam String   requestParam,
//						@RequestHeader String  requestHeader,
//						@RequestBody String    requestBody,
//						@RequestPart String    requestPart,
//						HttpEntity<String>     httpEntity,
//						Map<String, Object>    map,
//						Model                  model,
						ModelMap               modelMap
//						SessionStatus          sessionStatus,
//						UriComponentsBuilder   uriComponentsBuilder
						) throws IOException {

		System.out.println("### Hi from showLoginResult!");
		BufferedReader reader = httpServletRequest.getReader();
//		reader.reset();
		String line;
		while ((line = reader.readLine()) != null) {
			System.out.println("### read \""+ line +"\"");
		}

		System.out.println("### Global attributes...");
		String[] attributeNames = webRequest.getAttributeNames(RequestAttributes.SCOPE_GLOBAL_SESSION);
		for (String attrName: attributeNames) {
			System.out.println("### "+ attrName +"=\""+ webRequest.getAttribute(attrName, RequestAttributes.SCOPE_GLOBAL_SESSION) +"\"");
		}

		System.out.println("### Session attributes...");
		attributeNames = webRequest.getAttributeNames(RequestAttributes.SCOPE_SESSION);
		for (String attrName: attributeNames) {
			System.out.println("### "+ attrName +"=\""+ webRequest.getAttribute(attrName, RequestAttributes.SCOPE_SESSION) +"\"");
		}

		System.out.println("### Request attributes...");
		attributeNames = webRequest.getAttributeNames(RequestAttributes.SCOPE_REQUEST);
		for (String attrName: attributeNames) {
			System.out.println("### "+ attrName +"=\""+ webRequest.getAttribute(attrName, RequestAttributes.SCOPE_REQUEST) +"\"");
		}
		System.out.println("### ...End of attributes");

		Map<String, String[]> parameterMap = webRequest.getParameterMap();
		Set<Entry<String, String[]>> entrySet = parameterMap.entrySet();
		Iterator<Entry<String, String[]>> iterator = entrySet.iterator();
		while(iterator.hasNext()) {
			Entry<String, String[]> entry = iterator.next();
			System.out.println("### "+ entry.getKey() +"=\""+ entry.getValue() +"\"");
		}
		System.out.println("### ...End of parameters");

		System.out.println("### result.getAllErrors():");
		for (ObjectError oe: result.getAllErrors()) {
			log.error("### "+ oe.toString());
		}
		System.out.println("### ...[end of result.getAllErrors()]");
		Iterator<Entry<String, Object>> es = modelMap.entrySet().iterator();
		System.out.println("### ModelMap:");
		while(es.hasNext())
			System.out.println(es.next());
		System.out.println("### ...end of ModelMap");
		System.out.println("### ...nisse.name="+ nisse.getName());
		System.out.println("### ...nisse.password="+ nisse.getPassword());
		return "login";
	}
}