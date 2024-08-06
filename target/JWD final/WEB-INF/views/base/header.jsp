<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-lg navbar-light bg-light border-bottom">
      <div class="container-fluid">
          <button class="btn btn-success" id="sidebarToggle">Menu</button>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav ms-auto mt-2 mt-lg-0">
<!--                   <li class="nav-item"><a class="nav-link" href="#!">Link</a></li> -->
                  
<!--                   <li class="nav-item dropdown"> -->
<!--                       <a class="nav-link dropdown-toggle" id="navbarNew" href="#" role="button" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Tạo mới</a> -->
<!--                       <div class="dropdown-menu dropdown-menu-end" aria-labelledby="navbarDropdown"> -->
<!--                           <a class="dropdown-item" href="${pageContext.request.contextPath}/computer/create">Tạo mới máy</a> -->
<!--                           <a class="dropdown-item" href="${pageContext.request.contextPath}/customer/create">Tạo mới khách hàng</a> -->
<!--                           <a class="dropdown-item" href="${pageContext.request.contextPath}/service/create">Tạo mới dịch vụ</a> -->
<!--                       </div> -->
<!--                   </li> -->
            
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/home">Home</a></li>
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/create">Tạo mới</a></li>
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/update">Cập nhật</a></li>
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/register">Đăng ký</a></li>
                   <li class="nav-item active"><a class="nav-link" href="${pageContext.request.contextPath}/list">Danh sách</a></li>
              </ul>
          </div>
      </div>
  </nav>
               