package ninjagold;

import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@RequestMapping("/")
	public String home() {
		return "index.jsp";
	}	@GetMapping("/")
	public String set(HttpSession session, Model model) {
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		return "index.jsp";
	}
	
	@PostMapping("/gold")
	public String gold(HttpSession session, @RequestParam(value="git") String git) {
		if(session.getAttribute("log") == null) {
			session.setAttribute("log","");
			
		}
		Random rrr = new Random();
		Date date = new Date();
		if(git.equalsIgnoreCase("farm")) {
			Integer gold = rrr.nextInt(20)+10;
		session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
			session.setAttribute("log","You Hit the Farm and made: " + gold + " Making your total now: " + session.getAttribute("gold") );

		}else if(git.equalsIgnoreCase("cave")) {
			Integer gold = rrr.nextInt(5)+2;			session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
		session.setAttribute("log","You mined the Cave and made: " + gold + " Making your total now: " + session.getAttribute("gold") );

	}else if(git.equalsIgnoreCase("house")) {
		Integer gold = rrr.nextInt(5)+3;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
			session.setAttribute("log","You cleaned the House and made: " + gold + " Making your total now: " + session.getAttribute("gold") );

		}else if(git.equalsIgnoreCase("casino")) {
			Integer gold = rrr.nextInt(100)-50;
			session.setAttribute("gold", (Integer) session.getAttribute("gold") + gold);
			session.setAttribute("log","You gabled at the Casino  leaving you: " + gold + " Making your total now: " + session.getAttribute("gold") );
		}
		return "redirect:/";
	}
}
