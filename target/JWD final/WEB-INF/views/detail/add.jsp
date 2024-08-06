<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <div class="row w-100 d-flex justify-content-center">
 <div class ="col-sm-12 col-md-6 bg-custom p-3 rounded">
 <div class="col-12 text-uppercase h2 text-center text-success ">Tạo mới</div>
          <div class="p-4">
              <form:form action="${pageContext.request.contextPath}/create" method="post" modelAttribute="detail" id="inputForm">
                  <div class="form-group row">
                      <form:label path="id" for="inputID" class="col-sm-3 col-form-label">Mã</form:label>
                      <div class="col">
                          <form:input path="id" type="text" class="form-control" id="inputID" placeholder="Mã (KHxxxxx)" autocomplete="off"/>
                          <form:errors path="id" />
                       	  <div class="error text-danger" id="errorID"></div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
                  	<div class="col-6">
                      	<form:label path="name" for="inputName" class="col-sm-3 col-form-label">Tên</form:label>
                      	<div class="col">
                          <form:input path="name" type="text" class="form-control" id="inputName" placeholder="Tên" autocomplete="off"/>
                           <form:errors path="name" />
                           <div class="error text-danger" id="errorName"></div>
                           
                      	</div>
                      </div>
                      <div class="col-6">
                     	 <form:label path="name" for="inputDate" class="col-sm-3 col-form-label">Date</form:label>
                      	<div class="col">
                          <form:input path="name" type="date" class="form-control" id="inputName" placeholder="Ngày" autocomplete="off"/>
                           <form:errors path="name" />
                           <div class="error text-danger" id="errorDate"></div>
                           
                      	</div>
                      </div>
                  </div>
                  <div class="form-group row mt-3">
               		<form:label  path="type.id" for="inputType" class="col-sm-4 col-form-label">Loại</form:label>
               		<div class="col">
                     	<form:select class="form-control select2" path="type.id">
							<form:options items="${types}" itemValue="id" itemLabel="name"/>
						</form:select>
					</div>
                  </div>
                  <div class="form-group row mt-3">
                      <div class="col"></div>
                      <div class="col-sm-12 col-md-6 mr-2 d-flex justify-content-end">
                          <button type="reset" class="btn btn-success">Reset</button>
                           <button type="submit" class="btn btn-success mx-3">Add</button>
                           <a href ="${pageContext.request.contextPath}/home" class="btn btn-danger">Cancel</a>
                      </div>
                  </div>

              </form:form>
          </div>
          </div>
      </div>
       


  