package fa.training.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import fa.training.models.ThongTinOrder;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface DatVeService để quản lý các thao tác liên quan đến đối tượng DatVe
public interface ThongTinOrderService {

	// Phương thức để lưu hoặc cập nhật thông tin của một đối tượng DatVe
	void saveOrUpdate(ThongTinOrder detail);

	// Phương thức để lấy danh sách tất cả các đối tượng DatVe từ cơ sở dữ liệu
	List<ThongTinOrder> findAll();

	// Phương thức để tìm một đối tượng DatVe dựa trên id
	ThongTinOrder findByID(Long id);

	// Phương thức để xóa một đối tượng DatVe dựa trên id
	void deleteById(Long id);

	// Phương thức để lấy danh sách các đối tượng DatVe theo trang từ cơ sở dữ liệu
	Page<ThongTinOrder> findAll(Pageable pageable);

	// Phương thức để tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
//	Page<SumInfoDTO> findAllWithSearch(String tenKH, Long maLoaiKH, Pageable pageable);
	Page<ThongTinOrder> findAllWithSearchDatVe(String search,  Pageable pageable);

	// Phương thức để kiểm tra xem một đối tượng DatVe có tồn tại trong cơ sở dữ
	// liệu hay không dựa trên id
	boolean existByID(Long id);

}
