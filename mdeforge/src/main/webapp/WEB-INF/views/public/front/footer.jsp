<%@page import="java.util.Calendar"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
 
<div id="footer" class="hidden-print">
			
			<div class="container-960 innerTB">
				<div class="row-fluid">
					<div class="span4">
						<h4>Quick Links</h4>
						<ul>
							<li><a href="http://www.mdeforge.org">Home</a></li>
							<li><a href="http://www.mdeforge.org/?page_id=2">About</a></li>
							<li><a href="http://www.disim.univaq.it/">Department</a></li>
							<li><a href="http://www.univaq.it/">University</a></li>
							
						</ul>
					</div>
					<div class="span4">
						<h4>Where We Work</h4>
						<div class="box-generic">
							Department of Information Engineering Computer Science and Mathematics (DISIM)<br/>
							University of L'Aquila<br/>
							Via Vetoio, Coppito, Blocco Zero - 67010 L'Aquila (Italy)
						</div>
					</div>
					<div class="span4">
						<h4>Contact</h4>
						<ul class="icons email-field">
							<!-- <li class="glyphicons phone"><i></i>+39 0862 433183</li> -->
							<li class="glyphicons envelope"><i></i>mde@disim.univaq.it</li>
						</ul>
						
						<h4>Social</h4>
						<a href="https://github.com/MDEGroup/MDEForge" class="glyphicons standard github"><i></i></a>
					</div>
				</div>
				
				
			</div>
		<!--  Copyright Line -->
				<div class="copy">
				<div class="container-960 innerB">
					 &copy; <%=Calendar.getInstance().get(Calendar.YEAR)%> -- <spring:message code="common.footer"/>
					<!-- <span class="appbrand"><spring:message code="common.title"/></span>	-->									
				</div>
				</div>
				<!--  End Copyright Line -->
		</div>