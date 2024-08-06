/**
 * 
 */
package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fa.training.models.LoaiKhachHang;
import fa.training.repository.LoaiKhachHangRepository;
import fa.training.service.LoaiKhachHangService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class LoaiKhachHangServiceImpl implements LoaiKhachHangService {
	// Tự động inject KhachHangRepository để thực hiện các thao tác liên quan đến KhachHang
	@Autowired
	LoaiKhachHangRepository repository;

	// Phương thức để lưu hoặc cập nhật thông tin của một khách hàng
	@Override
	public void saveOrUpdate(LoaiKhachHang khachHang) {
		// Kiểm tra nếu khách hàng là null thì in ra thông báo và trở về
		if (khachHang == null) {
			System.out.println("Không khởi tạo được đối tượng");
			return;
		}
		// Lưu hoặc cập nhật thông tin của khách hàng vào cơ sở dữ liệu
		repository.save(khachHang);
	}

	// Phương thức để lấy danh sách tất cả các khách hàng từ cơ sở dữ liệu
	@Override
	public List<LoaiKhachHang> findAll() {
		// Lấy danh sách tất cả các khách hàng từ repository
		List<LoaiKhachHang> list = repository.findAll();
		// Kiểm tra nếu danh sách rỗng thì in ra thông báo và trả về null
		if (list.isEmpty()) {
			System.out.println("Danh sách trống");
			return null;
		}
		// Trả về danh sách khách hàng
		return list;
	}

	// Phương thức để tìm một khách hàng dựa trên id
	@Override
	public LoaiKhachHang findByID(Long id) {
		// Tìm và trả về khách hàng dựa trên id, hoặc trả về null nếu không tìm thấy
		return repository.findById(id).orElse(null);
	}
	
	// Phương thức kiểm tra xem có tồn tại một đối tượng KhuDoThi trong cơ sở dữ liệu dựa trên id hay không
	@Override
	public boolean existByID(Long id) {
		// Sử dụng phương thức existsById của repository để kiểm tra xem đối tượng có tồn tại không
		return repository.existsById(id);
	}
}
