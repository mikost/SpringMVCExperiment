<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<span style="width: 1000 px">
  <a href="<c:url value='/login'></c:url>">Log in</a><br/>
  <a href='<c:url value="/j_spring_security_logout" />' > Log out</a>
</span>
