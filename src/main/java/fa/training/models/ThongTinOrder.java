package fa.training.models;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class ThongTinOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	private LoaiKhachHang loaiKhachHang;

	private String tenKH;

	@Pattern(regexp = "^(0\\d{9,10})$", message = "so dien thoai sai dinh dang")
	private String phone;

	private String tenSanPham;

	@Positive(message = "Số phải lớn hơn 0")
	private Integer soLuong;

	private Double donGia;
	private Double tienThanhToan;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayOrder;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate ngayGiaoDuKien;

	public ThongTinOrder() {
	}

	public ThongTinOrder(Long maOrder, LoaiKhachHang loaiKhachHang, String tenKH,
			@Pattern(regexp = "^(0\\d{9,10})$", message = "so dien thoai sai dinh dang") String phone,
			String tenSanPham, Integer soLuong, Double donGia, Double tienThanhToan, LocalDate ngayOrder,
			LocalDate ngayGiaoDuKien) {
		this.maOrder = maOrder;
		this.loaiKhachHang = loaiKhachHang;
		this.tenKH = tenKH;
		this.phone = phone;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tienThanhToan = tienThanhToan;
		this.ngayOrder = ngayOrder;
		if (ngayOrder != null) {
			this.ngayGiaoDuKien = ngayOrder.plusDays(15);
		} else {
			this.ngayGiaoDuKien = null;
		}
	}

	public Long getMaOrder() {
		return maOrder;
	}

	public void setMaOrder(Long maOrder) {
		this.maOrder = maOrder;
	}

	public LoaiKhachHang getLoaiKhachHang() {
		return loaiKhachHang;
	}

	public void setLoaiKhachHang(LoaiKhachHang loaiKhachHang) {
		this.loaiKhachHang = loaiKhachHang;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public Integer getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(Integer soLuong) {
		this.soLuong = soLuong;
	}

	public Double getDonGia() {
		return donGia;
	}

	public void setDonGia(Double donGia) {
		this.donGia = donGia;
	}

	public Double getTienThanhToan() {
		return tienThanhToan;
	}

	public void setTienThanhToan(Double tienThanhToan) {
		this.tienThanhToan = tienThanhToan;
	}

	public LocalDate getNgayOrder() {
		return ngayOrder;
	}

	public void setNgayOrder(LocalDate ngayOrder) {
		this.ngayOrder = ngayOrder;
	}

	public LocalDate getNgayGiaoDuKien() {
		return ngayGiaoDuKien;
	}

//	public void setNgayGiaoDuKien(LocalDate ngayGiaoDuKien) {
//		this.ngayGiaoDuKien = ngayGiaoDuKien;
//	}

}
