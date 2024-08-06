package fa.training.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fa.training.models.ThongTinOrder;
import fa.training.models.dto.SumInfoDTO;

//Định nghĩa một interface DatVeRepository kế thừa từ JpaRepository,
//được sử dụng để thao tác với đối tượng DatVe trong cơ sở dữ liệu
public interface ThongTinOrderRepository extends JpaRepository<ThongTinOrder, Long> {

	// Định nghĩa một phương thức truy vấn tùy chỉnh sử dụng JPQL để lấy danh sách
	// các đối tượng DatVe dựa trên một chuỗi tìm kiếm
	@Query(value = "select md From ThongTinOrder md where md.tenKH LIKE %?1%  OR md.loaiKhachHang.maLoaiKH LIKE %?1% ")
//	@Query(value = "select c From Computer c where c.id LIKE %?1% OR c.location LIKE %?1% OR c.status LIKE %?1%")
	// Phương thức này nhận vào một chuỗi tìm kiếm và một đối tượng Pageable để phục vụ cho việc phân trang
	Page<ThongTinOrder> findAllWithSearchDatVe(String searchInput, Pageable pageable);
//	Page<ThongTinOrder> findAllWithSearchDatVe(@Param("tenKH") String tenKH, @Param("maLoaiKH") Long maLoaiKH, Pageable pageable);
	


}
