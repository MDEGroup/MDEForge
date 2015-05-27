<%@page import="java.util.Calendar"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div id="footer" class="hidden-print">
			
			<div class="container-960 innerTB">
				<div class="row-fluid">
					<div class="span2">
						<h4>Quick Links</h4>
						<ul>
							<li><a href="${pageContext.request.contextPath}/public/index.htm">Home</a></li>
							<li><a href="#">About</a></li>
							<li><a href="http://www.disim.univaq.it/didattica/content.php?pid=193&did=8">Departement</a></li>
							<li><a href="http://www.univaq.it/">University</a></li>
							<li><a href="${pageContext.request.contextPath}/public/contact.htm">Contact</a></li>
						</ul>
					</div>
					
					<div class="span3">
						<h4>Authors</h4>
						<ul>
							<li><a href="http://www.basciani.it">Francesco Basciani</a></li>
							<li><a href="https://scholar.google.it/citations?user=PNagLbIAAAAJ&hl=it">Juri Di Rocco</a></li>
							<li><a href="http://www.di.univaq.it/diruscio/">Davide Di Ruscio</a></li>
							<li><a href="http://www.amletodisalle.it/">Amleto Di Salle</a></li>
							<li><a href="http://www.di.univaq.it/home.php?users_username=ludovico.iovino">Ludovico Iovino</a></li>
							<li><a href="http://www.di.univaq.it/home.php?users_username=alfonso">Alfonso Pierantonio</a></li>
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
					<div class="span3">
						<h4>Contact</h4>
						<ul class="icons">
							<!-- <li class="glyphicons phone"><i></i>+39 0862 433183</li> -->
							<li class="glyphicons envelope"><i></i>mde@disim.univaq.it</li>
						</ul>
						
						<h4>Social</h4>
						<a href="https://github.com/MDEGroup/MDEForge" class="glyphicons standard primary github"><i></i></a>
						<a href="http://mdegroup.disim.univaq.it/" class="glyphicons standard link"><i></i></a>
						<a href="#" class="glyphicons standard twitter"><i></i></a>					
					</div>
				</div>
				
				<!--  Copyright Line -->
				<div class="copy">
					 &copy; <%=Calendar.getInstance().get(Calendar.YEAR)%> -- <spring:message code="common.footer"/>
					<span class="appbrand"><spring:message code="common.title"/></span>										
				</div>
				<!--  End Copyright Line -->
				
			</div>
	
		</div>