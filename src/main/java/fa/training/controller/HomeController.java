package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//Đánh dấu lớp này là một Controller trong Spring Framework
@Controller
public class HomeController {
	
	// Xác định route và method cho request GET đến đường dẫn "/" hoặc "/home"
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model) {
		// Thêm attribute "urlPage" vào model với giá trị "/home/home"
		model.addAttribute("urlPage", "/home/home");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}
}

