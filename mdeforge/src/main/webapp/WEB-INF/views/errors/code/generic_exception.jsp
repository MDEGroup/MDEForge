<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="hero-unit well">
		<h1 class="padding-none">
			
					<c:if test="${not empty errorModel.errCode}">
						${errorModel.errCode}! 
						<span> ${errorModel.errMsg}</span>
					</c:if>
					
					<c:if test="${empty errorModel.errCode}">
						<span>System Errors</span>
					</c:if>
				
					<c:if test="${not empty errorModel.errMsg}">
						<span> ${errorModel.errMsg}</span>
					</c:if>
			
		</h1>
		<hr class="separator" />
		<!-- Row -->
		<div class="row-fluid">
		
			<!-- Column -->
			<div class="span6">
				<div class="center">
					<p>It seems the page you are looking for is not here anymore. The page might have moved to another address or just removed by our staff.</p>
				</div>
			</div>
			<!-- // Column END -->
			
			<!-- Column -->
			<div class="span6">
				<div class="center">
					<p>Is this a serious error? <a href="#">Let us know</a></p>
					<div class="row-fluid">
						<div class="span6">
							<a href="#" onclick="goBack()" class="btn btn-icon-stacked btn-block btn-success glyphicons step_backward"><i></i><span>Go back to</span><span class="strong">Previus Page</span></a>
						</div>
						<div class="span6">
							<a href="${pageContext.request.contextPath}/" class="btn btn-icon-stacked btn-block btn-success glyphicons home"><i></i><span>Go to the </span><span class="strong">Index Page</span></a>
						</div>
					</div>
				</div>
			</div>
			<!-- // Column END -->
			
		</div>
		<!-- // Row END -->
		
	
</div>