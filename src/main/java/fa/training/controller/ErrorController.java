package fa.training.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ErrorController {
	
	// Xử lý ngoại lệ chung cho mọi loại ngoại lệ (Exception)
	@ExceptionHandler(Exception.class)
	public String showError(Exception e, Model model) {
	    // In ra thông báo lỗi ra console
	    System.out.println(e.getMessage());
	    // Thêm thông báo lỗi vào model, nếu e.getMessage() trả về null thì sẽ thay thế bằng chuỗi "Null"
	    model.addAttribute("errorMessage", e.getMessage() == null ? "Null" : e.getMessage());
	    // Thêm đường dẫn của trang lỗi vào model
	    model.addAttribute("urlPage", "/error/error");
	    // Trả về đường dẫn của trang cơ sở (base view) để hiển thị lỗi
	    return "/base/view";
	}

	// Xử lý ngoại lệ khi không tìm thấy trình xử lý (NoHandlerFoundException)
	@ExceptionHandler(NoHandlerFoundException.class)
	private String processNotFoundException(Exception e) {
	    // In ra thông báo "GlobalExceptionHandling" ra console
	    System.out.println("GlobalExceptionHandling");
	    // Trả về đường dẫn của trang lỗi 404
	    return "/error/404";
	}

}
