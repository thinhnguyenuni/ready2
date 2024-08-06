<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
            <div class="row d-flex justify-content-center">
                <div class="col-md-9">
                    <h2 class="col-12 text-center text-success text-uppercase mb-3">Danh sách</h2>
                    <div class="col-12 d-flex justify-content-center">
                    	<a href="${pageContext.request.contextPath}/create" class="btn btn-success">Tạo mới</a>
                    </div>
                    <div class="col-12">
                        <div class="row d-flex justify-content-end">
                           <form action="list" method="get" class="w-25">
                            <input type="hidden" name="pageSize" value="${pageSize}">
 							<div class="search input-group">
       							<input type="text" name = "search" class="form-control search-input border-success" placeholder="Search" autocomplete="off" value="${search}">
        						<button class="btn btn-outline-success search-btn" type="submit"><i class="fas fa-search"></i></button>
    						</div>
    						</form>
    						<i class="far fa-search"></i>
                         </div>

                        <table id="listTable"
                            class="table table-hover table-striped table-responsive table-content">
                            <thead>
                                <tr>
                                    <th>Mã</th>
                                    <th>Tên</th>
                                    <th>Ngày</th>
                                    <th>Loại</th>
                                    <th></th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="detail" items="${details}" varStatus="status">
                                    <tr>
                                        <td>${detail.id}</td>
                                        <td>${detail.name}</td>
                                        <td>${detail.date}</td>
                                        <td>${detail.type.name}</td>
                                        <td>
                                            <a href="update?id=${detail.id}"><i
                                                    class="fas fa-edit text-success mx-3"></i></a>
                                                <button type="button" class="btn" data-bs-toggle="modal"
                                                    data-bs-target="#detail${detail.id}">
                                                    <i class="fas fa-trash-alt text-danger"></i>
                                                </button>

                                                <!-- Modal -->
                                                <div class="modal fade" id="detail${detail.id}" tabindex="-1"
                                                    aria-labelledby="exampleModalLabel" aria-hidden="true">
                                                    <div class="modal-dialog">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="exampleModalLabel">Xóa</h5>
                                                                <button type="button" class="btn-close"
                                                                    data-bs-dismiss="modal" aria-label="Close"></button>
                                                            </div>
                                                            <div class="modal-body">
                                                                Bạn có muốn xóa <span
                                                                    class="text-danger">${detail.id}</span> này không
                                                                ?
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">Hủy
                                                                </button>
                                                                <a href="delete/${detail.id}"
                                                                    class="btn btn-danger">Có</a>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class=row>
                        <div class="col-5">
                            <div class="input-group mb-3">
                                <label for="pageSizeSelect">Show </label>
                                <select class="select mx-2 rounded px-1" id="pageSizeSelect">
                                    <c:forEach var="page" items="${pageSizes}">
                                    	<c:if test="${page == pageSize }">
                                    		 <option value="${page}" selected="selected">${page}</option>
                                    	</c:if>
                                    	<c:if test="${page != pageSize }">
                                    		  <option value="${page}">${page}</option>
                                    	</c:if>
                                       
                                    </c:forEach>
                                </select>
                                <label for="pageSizeSelect"> rows per page
                                </label>
                            </div>
                            <div class="fw-bold">Total: <span class="text-success"> ${totalRows} </span> rows </div>
                        </div>
                        <ul class="col-7 pagination d-flex justify-content-end">
                            <c:if test="${pageNumber > 1}">
                                <li class="page-item"><a class="page-link"
                                        href="list?pageNumber=${pageNumber-1}&pageSize=${pageSize}&search=${search}">Previous</a></li>

                            </c:if>
                            <c:forEach begin="1" end="${totalPages}" var="i">
                                <c:choose>
                                    <c:when test="${pageNumber eq i}">
                                        <li class="page-item"><a class="page-link active text-white"> ${i} </a></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="page-item"><a class="page-link" href="list?pageNumber=${i}&pageSize=${pageSize}&search=${search}">${i}</a></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                            <c:if test="${pageNumber lt totalPages}">
                                <li class="page-item"><a class="page-link" href="list?pageNumber=${pageNumber+1}&pageSize=${pageSize}&search=${search}">Next</a>
                                </li>
                            </c:if>
                        </ul>
                    </div>
                </div>
                </div>
            </div>