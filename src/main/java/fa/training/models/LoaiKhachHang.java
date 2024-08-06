package fa.training.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class LoaiKhachHang {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maLoaiKH;

	private String tenLoaiKH;

	private Double chietKhau;

	@OneToMany(mappedBy = "loaiKhachHang", cascade = CascadeType.ALL)
	private List<ThongTinOrder> list1 = new ArrayList<ThongTinOrder>();

	public LoaiKhachHang() {
	}

	public LoaiKhachHang(Long maLoaiKH, String tenLoaiKH, Double chietKhau, List<ThongTinOrder> list1) {
		super();
		this.maLoaiKH = maLoaiKH;
		this.tenLoaiKH = tenLoaiKH;
		this.chietKhau = chietKhau;
		this.list1 = list1;
	}

	public Long getMaLoaiKH() {
		return maLoaiKH;
	}

	public void setMaLoaiKH(Long maLoaiKH) {
		this.maLoaiKH = maLoaiKH;
	}

	public String getTenLoaiKH() {
		return tenLoaiKH;
	}

	public void setTenLoaiKH(String tenLoaiKH) {
		this.tenLoaiKH = tenLoaiKH;
	}

	public Double getChietKhau() {
		return chietKhau;
	}

	public void setChietKhau(Double chietKhau) {
		this.chietKhau = chietKhau;
	}

	public List<ThongTinOrder> getList1() {
		return list1;
	}

	public void setList1(List<ThongTinOrder> list1) {
		this.list1 = list1;
	}

}
