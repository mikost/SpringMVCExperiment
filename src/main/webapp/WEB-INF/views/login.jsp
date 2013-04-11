<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
.errorblock {
	color: #ff0000;
	background-color: #ffEEEE;
	border: 3px solid #ff0000;
	padding: 8px;
	margin: 16px;
}
</style>
  
<p>Welcome to my Spring MVC web app!<br/>
  Please log in!
  <c:if test="${not empty error}">
  		<div class="errorblock">
			Your login attempt was not successful, try again.<br />
			Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
  </c:if>
  </p>
  <form action="<c:url value='j_spring_security_check' />" method="post">
  username: <input type="text" name="j_username"/>
  <br />
  password: <input type="password" name="j_password"/>
  <br />
  <input type="submit" value="Submit"/>
  </form>
