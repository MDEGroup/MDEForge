<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>

<div class="row-fluid form-horizontal" id="projectDetails" data-id="${project.getId()}">
	<div class="span12 detailsWrapper" id="details">
		<div class="ajax-loading hide">
			<i class="icon-spinner icon-spin icon-4x"></i>
		</div>
		<div class="innerAll" id="workspaceDetailsDiv" style="display: none;">
			<div class="title">
				<div class="row-fluid">
					<div class="span8" id="projectId">
						<h3 class="text-primary header-h main-title" id="projectName"></h3>
						<div class="separator bottom"></div>
						<p class="muted" id="artifactsNumber"></p>
						<h5 class="input-name">Owner</h5>
						<p id="projectDesc"></p>
					</div>
					<div class="span4 text-right">
						<h5 class="input-name">Visibility</h5>
						<div id="visibility">
							<span class="btn btn-success"><i class="icon-cloud"></i>
								Public</span>
						</div>
						<div class="separator bottom"></div>
						<h5 class="input-name">Owner</h5>
						<!-- // Profile Photo END -->
						<ul class="icons-ul">
							<li><span id="ownerUsername"></span> <span
								class="icon-user text-primary"><i></i></span></li>
							<li class="text-black" style="font-size: 14px" id="ownerName"></li>
							<li><a href="#" id="ownerEmail"></a> <span
								class="icon-envelope text-primary"><i></i></span></li>
						</ul>
						<div class="separator"></div>
					</div>
				</div>

			</div>
			<div class="body">
				<div class="row-fluid">
					<div class="span3">
						<h5 class="input-name">
							Ecore Metamodels <i
								class="pull-right icon-plus text-primary button-toggle"
								id="showEcoreList"></i>
						</h5>
						<div id="ecoreToAdd" style="display: none">
							<div class="separator bottom"></div>
							<input autocomplete="off" id="ecoreSelect" class="my-select"
								type="text" data-type="EcoreMetamodel"
								placeholder="Search EcoreMetamodels"> <span
								class="btn btn-block btn-primary" id="addEcore">Add</span>
						</div>
						<div class="separator bottom"></div>
						<table class="table table-striped" id="ecoreMMTable">
							<tbody>
								<tr>
									<td></td>
								</tr>
							</tbody>
						</table>
					</div>
					<div class="span3">
						<h5 class="input-name">
							ATL Transformations <i
								class="pull-right icon-plus text-primary button-toggle"
								id="showATLList"></i>
						</h5>

						<div id="ATLToAdd" style="display: none">
							<div class="separator bottom"></div>
							<input autocomplete="off" id="ATLSelect" class="my-select"
								type="text" data-type="ATLTransformation" data-project=""
								placeholder="Search ATLTransformations"> <span
								class="btn btn-block btn-primary" id="addATL">Add</span>
						</div>
						<div class="separator bottom"></div>
						<table class="table table-striped" id="atlTable">
							<tbody>
								<tr>
									<td></td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class="span3">
						<h5 class="input-name">
							Models <i class="pull-right icon-plus text-primary button-toggle"
								id="showModelList"></i>
						</h5>
						<div id="modelToAdd" style="display: none">
							<div class="separator bottom"></div>
							<input autocomplete="off" id="modelSelect" class="my-select"
								type="text" data-type="Model" placeholder="Search Models">
							<div>
								<span class="btn btn-block btn-primary" id="addModel">Add</span>
							</div>
						</div>
						<div class="separator bottom"></div>
						<table class="table table-striped" id="modelTable">
							<tbody>
								<tr>
									<td></td>
								</tr>
							</tbody>
						</table>

					</div>
					<div class="span3" id="userDiv" style="display: none;">
						<!-- Latest Orders/List Widget -->
						<h5 class="input-name">
							Shared Users <i
								class="pull-right icon-plus text-primary button-toggle"
								id="showUserList"></i>
						</h5>
						<div id="userList" class="row-fluid" style="display: none">
							<div class="separator bottom"></div>
							<select id="userSelect">
							</select> <span class="btn btn-block btn-primary" id="addUser">Add</span>

						</div>
						<div class="separator bottom"></div>
						<p class="text-primary" id="sharedNumber"></p>

						<div class="widget">

							<div class="widget-body list products">
								<ul class="team" id="users"></ul>
							</div>
						</div>



					</div>
				</div>

			</div>
			<hr class="separator">
			<span id="removeProject"></span> <span
				class="pull-right"></span>
		</div>
	</div>
</div>

<div class="separator "></div>
<div class="separator "></div>
<div class="separator "></div>

<div class="modal hide fade" id="alert-modal"></div>

<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/spinner/spin.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/plugins/forms/template/mustache.js"></script>
<script src="${pageContext.request.contextPath}/resources/theme/scripts/myscripts/projectDetails.js"></script>