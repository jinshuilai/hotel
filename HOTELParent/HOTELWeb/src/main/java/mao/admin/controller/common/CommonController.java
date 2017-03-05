package mao.admin.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/common")
public class CommonController {

	@RequestMapping("/login")
	public String login() {
		
		return "/common/login";
	}
	
	@RequestMapping("/resource_not_found")
	public String resourceNotFound() {
		
		return "/common/resource_not_found";
	}
	
	@RequestMapping("/error")
	public String error() {
		
		return "/common/error";
	}
}
