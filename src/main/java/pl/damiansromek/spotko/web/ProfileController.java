package pl.damiansromek.spotko.web;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
	@RequestMapping("/")
	String index(Model model, Principal principal) {
		model.addAttribute("principal", principal);
		
        return "profile/index";
    }
}
