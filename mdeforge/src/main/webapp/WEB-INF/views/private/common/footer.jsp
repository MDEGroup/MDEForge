<%@page import="java.util.Calendar"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div id="footer" class="hidden-print">
			
	<!--  Copyright Line -->
	<div class="copy">
		&copy; <%=Calendar.getInstance().get(Calendar.YEAR)%> -- <spring:message code="common.footer"/>
	</div>
	<!--  End Copyright Line -->
	
</div>