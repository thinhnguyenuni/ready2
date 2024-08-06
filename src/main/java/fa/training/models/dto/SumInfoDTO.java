package fa.training.models.dto;

import java.time.LocalDate;

public class SumInfoDTO {
	

	private Long maOrder;
	private Long maLoaiKH;
	private String tenKH;
	private String phone;
	private String tenSanPham;
	private Integer soLuong;
	private Double donGia;
	private Double tienThanhToan;
	private LocalDate ngayOrder;
	private LocalDate ngayGiaoDuKien;
	
	
	public SumInfoDTO() {
	}


	public SumInfoDTO(Long maOrder, Long maLoaiKH, String tenKH, String phone, String tenSanPham, Integer soLuong,
			Double donGia, Double tienThanhToan, LocalDate ngayOrder, LocalDate ngayGiaoDuKien) {
		this.maOrder = maOrder;
		this.maLoaiKH = maLoaiKH;
		this.tenKH = tenKH;
		this.phone = phone;
		this.tenSanPham = tenSanPham;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.tienThanhToan = tienThanhToan;
		this.ngayOrder = ngayOrder;
		this.ngayGiaoDuKien = ngayGiaoDuKien;
	}


	public Long getMaOrder() {
		return maOrder;
	}


	public void setMaOrder(Long maOrder) {
		this.maOrder = maOrder;
	}


	public Long getMaLoaiKH() {
		return maLoaiKH;
	}


	public void setMaLoaiKH(Long maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
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


	public void setNgayGiaoDuKien(LocalDate ngayGiaoDuKien) {
		this.ngayGiaoDuKien = ngayGiaoDuKien;
	}


	
	
}
