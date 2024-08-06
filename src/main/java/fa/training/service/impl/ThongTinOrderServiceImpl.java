package fa.training.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import fa.training.models.ThongTinOrder;
import fa.training.repository.ThongTinOrderRepository;
import fa.training.service.ThongTinOrderService;

//Đánh dấu lớp này là một service trong ứng dụng Spring
@Service
public class ThongTinOrderServiceImpl implements ThongTinOrderService {
	// Tự động inject DatVeRepository để thực hiện các thao tác liên quan đến DatVe
	@Autowired
	private ThongTinOrderRepository repository;

	// Phương thức để lưu hoặc cập nhật thông tin của một mẫu đất
	@Override
	public void saveOrUpdate(ThongTinOrder datVe) {
		// Kiểm tra nếu mẫu đất là null thì in ra thông báo và trở về
		if (datVe == null) {
			System.out.println("Không khởi tạo được đối tượng");
			return;
		}
		// Lưu hoặc cập nhật thông tin của mẫu đất vào cơ sở dữ liệu
		repository.save(datVe);
	}

	// Phương thức để lấy danh sách tất cả các mẫu đất từ cơ sở dữ liệu
	@Override
	public List<ThongTinOrder> findAll() {
		// Lấy danh sách tất cả các mẫu đất từ repository
		List<ThongTinOrder> list = repository.findAll();
		// Kiểm tra nếu danh sách rỗng thì in ra thông báo và trả về null
		if (list.isEmpty()) {
			System.out.println("Danh sách trống");
			return null;
		}
		// Trả về danh sách mẫu đất
		return list;
	}

	// Phương thức để tìm một mẫu đất dựa trên id
	@Override
	public ThongTinOrder findByID(Long id) {
		// Tìm và trả về mẫu đất dựa trên id, hoặc trả về null nếu không tìm thấy
		return repository.findById(id).orElse(null);
	}

	// Phương thức để xóa một mẫu đất dựa trên id
	@Override
	public void deleteById(Long id) {
		// Xóa mẫu đất dựa trên id
		repository.deleteById(id);
	}

	// Phương thức để lấy danh sách các mẫu đất theo trang từ cơ sở dữ liệu
	@Override
	public Page<ThongTinOrder> findAll(Pageable pageable) {
		// Lấy danh sách các mẫu đất theo trang từ repository
		return repository.findAll(pageable);
	}

	// Phương thức để lấy danh sách các mẫu đất theo điều kiện tìm kiếm và phân trang
	// Phương thức tìm kiếm các giao dịch với điều kiện tìm kiếm và phân trang
	@Override
	public Page<ThongTinOrder> findAllWithSearchDatVe(String tenKH,  Pageable pageable) {
		return repository.findAllWithSearchDatVe(tenKH, pageable);
	}



	// Phương thức để kiểm tra xem một mẫu đất có tồn tại trong cơ sở dữ liệu hay không dựa trên id
	@Override
	public boolean existByID(Long id) {
		// Sử dụng phương thức existsById của repository để kiểm tra xem mẫu đất có tồn tại không
		return repository.existsById(id);
	}
}
