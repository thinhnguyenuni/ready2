<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <div class="border-end bg-white" id="sidebar-wrapper">
        <div class="list-group list-group-flush vh-100 bg-secondary">
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-secondary text-white" href="${pageContext.request.contextPath}/create">Tạo mới</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-secondary text-white" href="${pageContext.request.contextPath}/update">Cập nhật</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-secondary text-white" href="${pageContext.request.contextPath}/register">Đăng ký</a>
            <a class="list-group-item list-group-item-action list-group-item-light p-3 bg-secondary text-white" href="${pageContext.request.contextPath}/list">Danh sách</a>
        </div>
    </div>






