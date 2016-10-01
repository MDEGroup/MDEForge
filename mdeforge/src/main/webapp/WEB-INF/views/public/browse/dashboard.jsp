<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!-- Breadcrumb START -->
<ul class="breadcrumb">
	<li><spring:message
			code="mdeforge.public.back.browse.breadcrumbs.you_are_here" /></li>
	<li><a href="#" class="glyphicons dashboard"><i></i> <spring:message
				code="mdeforge.public.back.browse.breadcrumbs.public_area" /></a></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse" /></li>
	<li class="divider"></li>
	<li><spring:message code="mdeforge.public.back.browse.dashboard" /></li>
</ul>
<!-- Breadcrumb END -->
<h3>
	<spring:message code="mdeforge.public.back.browse.dashboard" />
</h3>
<div class="innerLR">
	<div class="row-fluid">
		<div class="span9 tablet-column-reset">
			<div
				class="widget finances_summary widget-heading-simple widget-body-white">
				<div class="widget-body">
					<!-- Row -->
					<div class="row-fluid">
						<!-- Column -->
						<div class="span4">
							<div class="well">
								Metamodels <strong>${ecoreMetamodelsList.size()}</strong>
							</div>

							<div class="well">
								Users <strong>${users.size()}</strong>
							</div>
						</div>
						<!-- // Column END -->

						<!-- Column -->
						<div class="span8">
							<div id="chart_simple" style="height: 290px;"></div>
						</div>
						<!-- // Column END -->
					</div>
					<!-- // Row END -->
					<a href="" class="glyphicons list single"><i></i> View details</a>
				</div>
			</div>
		</div>
		<div class="span3">

			<div class="widget widget-heading-simple widget-body-gray">
				<div class="widget-body">
					<div
						class="glyphicons glyphicon-xlarge glyphicon-top circle_question_mark">
						<i></i>
						<h4>Have a Question?</h4>
<!-- 						<p class="margin-none"> -->
<!-- 							Lorem Ipsum is simply dummy text of the printing and typesetting -->
<!-- 							industry.<br /> <a href="" class="text-underline">Get your -->
<!-- 								answer</a> -->
<!-- 						</p> -->
					</div>
				</div>
			</div>
			<!-- Widget -->
			<div class="widget widget-heading-simple widget-body-gray">

				<!-- Widget Heading -->
				<div class="widget-head">
					<h4 class="heading glyphicons list">
						<i></i>Categories
					</h4>
				</div>
				<!-- // Widget Heading END -->
				<div class="widget-body list">
					<!-- List -->
					<ul>
						<li><a href="">Make Up</a> <span class="badge">35</span></li>
						<li><a href="">Fragrances</a> <span class="badge">30</span></li>
						<li><a href="">Nails</a> <span class="badge">19</span></li>
						<li><a href="">Hair Products</a> <span class="badge">33</span>
						</li>
						<li><a href="">Accessories</a> <span class="badge">17</span>
						</li>
					</ul>
					<!-- // List END -->

				</div>
			</div>
			<!-- // Widget END -->
		</div>
	</div>
</div>






