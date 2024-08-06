<!--   Đây là một directive trong JSP được sử dụng để import thư viện JSTL Core vào trang JSP. -->

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%--  Sử dụng tag <c:set> của JSTL để gán giá trị cho một biến. --%>
<%-- var="path": Tên của biến được gán giá trị.
value="${pageContext.request.contextPath}": Giá trị của biến được lấy từ contextPath của request, nơi chứa đường dẫn gốc của ứng dụng. --%>
<c:set var="path" value="${pageContext.request.contextPath}" />
<head>
<meta charset="UTF-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title></title>
<!-- Favicon-->
<!--        Đường dẫn tới các tệp tin CSS và favicon, sử dụng biến path đã được 
khai báo ở trên để đảm bảo tính động và di động của đường dẫn. -->
<link rel="icon" type="image/x-icon"
	href="${path}/resources/assets/favicon.ico" />
<link href="${path}/resources/fontawesome/css/all.min.css"
	rel="stylesheet" />
<link href="${path}/resources/bootstrap/css/bootstrap.min.css"
	rel="stylesheet" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="${path}/resources/css/styles.css" rel="stylesheet" />
<link href="${path}/resources/css/select2.min.css" rel="stylesheet" />
<link href="${path}/resources/css/custom.css" rel="stylesheet" />

</head>