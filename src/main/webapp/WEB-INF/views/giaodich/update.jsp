<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="row w-100 d-flex justify-content-center">
	<div class="col-sm-12 col-md-6 bg-custom p-3 rounded">
		<div class="col-12 text-uppercase h2 text-center text-success ">Cập
			nhật khách hàng</div>
		<div class="p-4">
			<form:form
				action="${pageContext.request.contextPath}/thongtin/update"
				method="post" modelAttribute="thongtinorder" id="inputForm_update">
				<!-- Dòng 1: Bắt đầu một form với các thuộc tính định danh -->
				<div class="form-group row">
					<form:label path="maOrder" for="input_tenKH"
						class="col-sm-3 col-form-label">Mã order</form:label>
					<div class="col">
						<form:input path="maOrder" type="text" class="form-control"
							id="input_tenKH" placeholder="" autocomplete="off" />
						<form:errors path="maOrder" />
						<div class="error text-danger" id="error_tenKH"></div>
					</div>
				</div>
				
				<div class="form-group row">
					<form:label path="tenKH" for="input_tenKH"
						class="col-sm-3 col-form-label">Tên khách hàng</form:label>
					<div class="col">
						<form:input path="tenKH" type="text" class="form-control"
							id="input_tenKH" placeholder="" autocomplete="off" />
						<form:errors path="tenKH" />
						<div class="error text-danger" id="error_tenKH"></div>
					</div>
				</div>
				<div class="form-group row mt-3">
					<form:label path="loaiKhachHang.maLoaiKH" for="input_cccd"
						class="col-sm-3 col-form-label">Mã loại khách hàng</form:label>
					<div class="col">
						<form:input path="loaiKhachHang.maLoaiKH" type="number"
							class="form-control" id="input_cccd" placeholder=""
							autocomplete="off" />
						<form:errors path="loaiKhachHang.maLoaiKH" />
						<div class="error text-danger" id="error_cccd"></div>

					</div>
				</div>

				<div class="form-group row mt-3">
					<form:label path="phone" for="input_phone"
						class="col-sm-3 col-form-label">Phone</form:label>
					<div class="col">
						<form:input path="phone" type="text" class="form-control"
							id="input_phone" placeholder="" autocomplete="off" />
						<form:errors path="phone" />
						<div class="error text-danger" id="error_phone"></div>

					</div>
				</div>

				<div class="form-group row mt-3">
					<form:label path="tenSanPham" for="input_tenSanPham"
						class="col-sm-3 col-form-label">Tên sản phẩm</form:label>
					<div class="col">
						<form:input path="tenSanPham" type="text" class="form-control"
							id="input_tenSanPham" placeholder="" autocomplete="off" />
						<form:errors path="tenSanPham" />
						<div class="error text-danger" id="error_tenSanPham"></div>
					</div>
				</div>

				<div class="form-group row mt-3">
					<form:label path="soLuong" for="input_soLuong"
						class="col-sm-3 col-form-label">Số lượng</form:label>
					<div class="col">
						<form:input path="soLuong" type="number"
							class="form-control" id="input_soLuong" placeholder=""
							autocomplete="off" />
						<form:errors path="soLuong" />
						<div class="error text-danger" id="error_soLuong"></div>

					</div>
				</div>
				
				<div class="form-group row mt-3">
					<form:label path="donGia" for="input_donGia"
						class="col-sm-3 col-form-label">Đơn giá</form:label>
					<div class="col">
						<form:input path="donGia" type="number"
							class="form-control" id="input_donGia" placeholder=""
							autocomplete="off" />
						<form:errors path="donGia" />
						<div class="error text-danger" id="error_donGia"></div>

					</div>
				</div>
				
				<div class="form-group row mt-3">
					<form:label path="tienThanhToan" for="input_tienThanhToan"
						class="col-sm-3 col-form-label">Tiền thanh toán</form:label>
					<div class="col">
						<form:input path="tienThanhToan" type="number"
							class="form-control" id="input_tienThanhToan" placeholder=""
							autocomplete="off" />
						<form:errors path="tienThanhToan" />
						<div class="error text-danger" id="error_tienThanhToan"></div>

					</div>
				</div>
				
				<div class="form-group row mt-3">
					<form:label path="ngayOrder" for="input_ngayOrder"
						class="col-sm-3 col-form-label">Ngày order</form:label>
					<div class="col">
						<form:input path="ngayOrder" type="date" class="form-control"
							id="input_ngayOrder" placeholder="" autocomplete="off" />
						<form:errors path="ngayOrder" />
						<div class="error text-danger" id="error_ngayOrder"></div>
					</div>
				</div>


			
				<div class="form-group row mt-3">
					<form:label path="ngayGiaoDuKien" for="input_ngayGiaoDuKien"
						class="col-sm-3 col-form-label">Ngày giao dự kiến</form:label>
					<div class="col">
						<form:input path="ngayGiaoDuKien" type="date" class="form-control"
							id="input_ngayGiaoDuKien" placeholder="" autocomplete="off" />
						<form:errors path="ngayGiaoDuKien" />
						<div class="error text-danger" id="error_ngayGiaoDuKien"></div>

					</div>
				</div>
				<div class="form-group row mt-3">
					<div class="col"></div>
					<div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
						<button type="reset" class="btn btn-success">Reset</button>
						<button type="submit" class="btn btn-success mx-3">Add</button>
						<a href="${pageContext.request.contextPath}/home"
							class="btn btn-danger">Cancel</a>
					</div>
				</div>
			</form:form>

		</div>
	</div>
</div>



