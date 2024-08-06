package fa.training.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fa.training.models.ThongTinOrder;
import fa.training.models.dto.SumInfoDTO;
import fa.training.service.LoaiKhachHangService;
import fa.training.service.ThongTinOrderService;

//Đánh dấu lớp này là một Controller trong Spring Framework và xác định route chính cho các phương thức trong Controller này
@Controller
@RequestMapping(value = "/thongtin")
public class ThongTinOrderController {

	// Autowired để Spring tự động inject các instance của các service
	@Autowired
	private ThongTinOrderService thongTinOrderService;

	@Autowired
	private LoaiKhachHangService loaiKhachHangService;
	
	// Danh sách các kích thước trang cho phân trang
	List<Integer> pageSizes = new ArrayList<Integer>(Arrays.asList(3, 4, 5, 10));

	/**
	 * Xử lý request GET đến đường dẫn "/thongtin/create" THINHNV30 1993-03-03
	 */
	@GetMapping("/create")
	public String getDatVe(Model model) {
		// Thêm một đối tượng DatVe mới vào Model để hiển thị trên view
		model.addAttribute("thongtin", new ThongTinOrder());
		// Thêm các thông tin cần thiết vào Model
		model.addAttribute("urlPage", "/thongtin/add");
//		model.addAttribute("jqPage", "thongtin");
		// Trả về đường dẫn của view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/thongtin/create"
	@PostMapping("/create")
	public String createDatVe(@ModelAttribute("thongtin") @Validated ThongTinOrder thongTinOrder, BindingResult result,
			Model model) {
		// Kiểm tra xem mã khu đô thị có tồn tại không, nếu không tồn tại thì reject giá
		// trị và thông báo lỗi
		// result.rejectValue(...) là một phương thức để từ chối giá trị của một thuộc
		// tính cụ thể trong đối tượng dữ liệu, thông báo rằng giá trị đó không hợp lệ.
		// "khachHang.cccd" chỉ định thuộc tính trong đối tượng khách hàng đang bị từ
		// chối, cụ thể là CCCD.
		// "khachHang.idInvalid" là mã lỗi để định danh loại lỗi này, có thể được sử
		// dụng trong quá trình xử lý lỗi hoặc hiển thị thông báo lỗi.
		// "CCCD này không tồn tại" là thông báo lỗi cụ thể, giải thích rằng CCCD được
		// cung cấp không tồn tại trong hệ thống.

		if (!loaiKhachHangService.existByID(thongTinOrder.getLoaiKhachHang().getMaLoaiKH())) {
			result.rejectValue("loaiKhachHang.maLoaiKH", "loaiKhachHang.idInvalid", "Mã loại khách hàng này không tồn tại");
		}

		// Nếu có lỗi thì trả về view tạo mới mẫu đất
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/thongtin/add");
//			model.addAttribute("jqPage", "thongtin");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin mẫu đất và chuyển hướng về danh sách giao dịch
		thongTinOrderService.saveOrUpdate(thongTinOrder);
		return "redirect:/thongtin/list";
	}

	// Xử lý request GET đến đường dẫn "/thongtin/list"
	@GetMapping("/list")
	public String showAllDatVe(Model model,
			@RequestParam(name = "pageNumber", required = true, defaultValue = "1") int pageNumber,
			@RequestParam(name = "pageSize", required = true, defaultValue = "10") int pageSize,
			@RequestParam(name = "search", required = false, defaultValue = "") String search
//			@RequestParam(name = "maLoaiKH", required = false, defaultValue = "") Long maLoaiKH
			) {
		// Tạo Pageable object để phục vụ cho việc phân trang
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		// Gọi service để lấy danh sách giao dịch theo các tham số truyền vào
		Page<ThongTinOrder> sumInfos = thongTinOrderService.findAllWithSearchDatVe(search.trim(),  pageable);
		// Thêm các thông tin cần thiết vào Model để hiển thị trên view
		model.addAttribute("sumInfos", sumInfos.getContent());
		model.addAttribute("pageSizes", pageSizes);
		model.addAttribute("pageSize", pageSize);
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("totalRows", sumInfos.getTotalElements());
		model.addAttribute("totalPages", sumInfos.getTotalPages());
		model.addAttribute("search", search);
//		model.addAttribute("search", search);
		model.addAttribute("urlPage", "/giaodich/list");
//	    model.addAttribute("jqPage", "list");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request GET đến đường dẫn "/thongtin/update"
	@GetMapping("/update")
	public String getUpdateDatVe(@RequestParam(name = "id") Long id, Model model) {
		// Lấy thông tin giao dịch cần cập nhật và thêm vào Model
		model.addAttribute("thongtinorder", thongTinOrderService.findByID(id));
		model.addAttribute("urlPage", "/giaodich/update");
		// Trả về view cơ sở (base view)
		return "/base/view";
	}

	// Xử lý request POST đến đường dẫn "/thongtin/update"
	@PostMapping("/update")
	public String updateDatVe(@ModelAttribute("thongtinorder") @Validated ThongTinOrder thongtinorder, Long id,
			BindingResult result, Model model) {
		// Kiểm tra xem có trùng mã khách hàng hay không, nếu có thì reject giá trị và
		// thông báo lỗi
//		if (khachHangService.existByID(id)) {
//			System.out.println("trùng");
//			result.rejectValue("khachHang.id", "khachHang.idInvalid",
//					"Mã khách hàng đang chọn đã tồn tại. Vui lòng chọn lại");
//		}

		// Nếu có lỗi thì trả về view cập nhật
		if (result.hasErrors()) {
			model.addAttribute("urlPage", "/giaodich/update");
			return "/base/view";
		}

		// Lưu hoặc cập nhật thông tin giao dịch và chuyển hướng về danh sách giao dịch
		thongTinOrderService.saveOrUpdate(thongtinorder);
		return "redirect:/thongtin/list";
	}

	// Xử lý request GET đến đường dẫn "/thongtin/delete/{id}"
	@GetMapping("/delete/{id}")
	public String deleteDetail(@PathVariable(name = "id") Long id, Model model) {
		// Xóa thông tin mẫu đất với id được cung cấp và chuyển hướng về danh sách mẫu
		// đất
		thongTinOrderService.deleteById(id);
		return "redirect:/thongtin/list";
	}
}
