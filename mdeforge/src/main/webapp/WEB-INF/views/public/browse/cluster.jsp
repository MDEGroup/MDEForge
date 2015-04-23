<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>

<!-- Breadcrumb START -->
<ul class="breadcrumb">
		<li>You are here</li>
		<li><a href="index.html?lang=en&amp;layout_type=fluid&amp;menu_position=menu-left&amp;style=style-default&amp;sidebar-sticky=false&amp;top_style=full&amp;sidebar_style=full" class="glyphicons dashboard"><i></i> Private area</a></li>
		<li class="divider"></li>
		<li>Services</li>
		<li class="divider"></li>
		<li>Transformation Chain</li>
</ul>
<!-- Breadcrumb END -->


<h3><spring:message code="mdeforge.public.back.browse.menu.cluster_metamodel"/></h3>


<div class="innerLR">

	<!-- Tabs -->
	<div class="relativeWrap">
		<div class="box-generic">
		
			<!-- Tabs Heading -->
			<div class="tabsbar">
				<ul>					
					<li class="glyphicons folder_open active"><a href="#tab1-1" data-toggle="tab"><i></i> <spring:message code="mdeforge.public.back.browse.table"/> <strong>(3)</strong></a></li>
					<li class="glyphicons vector_path_polygon tab-stacked"><a href="#tab1-2" data-toggle="tab"><i></i> <span><spring:message code="mdeforge.public.back.browse.graph"/></span></a></li>					
				</ul>
			</div>
			<!-- // Tabs Heading END -->
			
			<div class="tab-content">
					
				<!-- Tab content -->
				<div class="tab-pane active" id="tab1-1">
					<h4><spring:message code="mdeforge.public.back.browse.table"/></h4>
					<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
				</div>
				<!-- // Tab content END -->
				
				<!-- Tab content -->
				<div class="tab-pane" id="tab1-2">
					<h4><spring:message code="mdeforge.public.back.browse.graph"/></h4>
					<p>Anim pariatur cliche reprehenderit, enim eiusmod high life accusamus terry richardson ad squid. 3 wolf moon officia aute, non cupidatat skateboard dolor brunch. Food truck quinoa nesciunt laborum eiusmod. Brunch 3 wolf moon tempor, sunt aliqua put a bird on it squid single-origin coffee nulla assumenda shoreditch et. Nihil anim keffiyeh helvetica, craft beer labore wes anderson cred nesciunt sapiente ea proident.</p>
				</div>
				<!-- // Tab content END -->
								
				
			</div>
		</div>
	</div>
	<!-- // Tabs END -->
	
</div>	
	