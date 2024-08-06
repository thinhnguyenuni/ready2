package fa.training.service;

import java.util.List;

import fa.training.models.LoaiKhachHang;

//Định nghĩa một interface KhachHangService để quản lý các thao tác liên quan đến đối tượng KhachHang
public interface LoaiKhachHangService {
	
	// Phương thức để lưu hoặc cập nhật thông tin của một khách hàng
	void saveOrUpdate(LoaiKhachHang khachHang);

	// Phương thức để lấy danh sách tất cả các khách hàng từ cơ sở dữ liệu
	List<LoaiKhachHang> findAll();

	// Phương thức để tìm một khách hàng dựa trên id
	LoaiKhachHang findByID(Long id);
	
	// Phương thức để kiểm tra xem có tồn tại một đối tượng KhuDoThi trong cơ sở dữ liệu dựa trên id hay không
		boolean existByID(Long id);
}

