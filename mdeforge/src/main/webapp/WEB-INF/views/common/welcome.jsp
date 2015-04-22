<%@taglib uri="http://www.springframework.org/security/tags" prefix="security"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="row">
	<div id="breadcrumb" class="col-md-12">
		<ol class="breadcrumb">
			<li><a href="#">Home</a></li>
			<li><a href="#">Dashboard</a></li>
		</ol>
	</div>
</div>

<div id="dashboard-header" class="row">
	<div class="col-xs-10 col-sm-2">
		<h3>
			<spring:message code="common.hello"/>, <security:authentication property="principal.username" />
		</h3>
	</div>
	<div class="col-xs-2 col-sm-1 col-sm-offset-1">
		<div id="social" class="row">
			<a href="#"><i class="fa fa-google-plus"></i></a>
			<a href="#"><i class="fa fa-facebook"></i></a>
			<a href="#"><i class="fa fa-twitter"></i></a>
			<a href="#"><i class="fa fa-linkedin"></i></a>
			<a href="#"><i class="fa fa-youtube"></i></a>
		</div>
	</div>
	<div class="clearfix visible-xs"></div>
	<div class="col-xs-12 col-sm-8 col-md-7 pull-right">
		<div class="row">
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-1"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>756.45M
					<span class="txt-primary">EBITDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-2"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>245.12M
					<span class="txt-info">OIBDA</span>
				</div>
			</div>
			<div class="col-xs-4">
				<div class="sparkline-dashboard" id="sparkline-3"><canvas width="70" height="40" style="display: inline-block; vertical-align: top; width: 70px; height: 40px;"></canvas></div>
				<div class="sparkline-dashboard-info">
					<i class="fa fa-usd"></i>107.83M
					<span>REVENUE</span>
				</div>
			</div>
		</div>
	</div>
</div>


<div class="box-content">
<div id="dashboard-overview" class="row" style="visibility: visible; position: relative;">
			<div id="ow-marketplace" class="col-sm-12 col-md-6">
				<div id="ow-setting">
					<a href="#"><i class="fa fa-folder-open"></i></a>
					<a href="#"><i class="fa fa-credit-card"></i></a>
					<a href="#"><i class="fa fa-ticket"></i></a>
					<a href="#"><i class="fa fa-bookmark-o"></i></a>
					<a href="#"><i class="fa fa-globe"></i></a>
				</div>
				<h4 class="page-header">MARKETPLACE</h4>
				<table id="ticker-table" class="table m-table table-bordered table-hover table-heading">
					<thead>
						<tr>
							<th>Ticker</th>
							<th>Price</th>
							<th>Change</th>
							<th>Weekly Chart</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td class="m-ticker"><b>BRDM</b><span>Broadem Inc.</span></td>
							<td class="m-price">33.27</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 1.45 (27%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>ASWLL</b><span>Aswell Corp.</span></td>
							<td class="m-price">45.13</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 6.32 (12%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>MIXL</b><span>Mixal LTD.</span></td>
							<td class="m-price">71.13</td>
							<td class="m-change"><i class="fa fa-angle-down"></i> 7.2 (12%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>LMPRD</b><span>L.A. Prod.</span></td>
							<td class="m-price">30.24</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 5.3 (18%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>ALK</b><span>Allien K.</span></td>
							<td class="m-price">51.1</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 7.5 (3.5%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>LNISW</b><span>Lenstri Sweet</span></td>
							<td class="m-price">123.12</td>
							<td class="m-change"><i class="fa fa-angle-down"></i> 54.3 (15.3%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>RNLD</b><span>Ron LEED</span></td>
							<td class="m-price">64.14</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 12.33 (0.3%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>BCN</b><span>BeetCN Corp.</span></td>
							<td class="m-price">64.14</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 12.33 (0.3%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
						<tr>
							<td class="m-ticker"><b>AWS</b><span>Awesome Inc.</span></td>
							<td class="m-price">64.14</td>
							<td class="m-change"><i class="fa fa-angle-up"></i> 12.33 (0.3%)</td>
							<td class="td-graph"><canvas width="90" height="16" style="display: inline-block; vertical-align: top; width: 90px; height: 16px;"></canvas></td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-xs-12 col-md-6">
				<div id="ow-donut" class="row">
					<div class="col-xs-4">
						<div id="morris_donut_1" style="width:120px;height:120px;"><svg height="120" version="1.1" width="120" xmlns="http://www.w3.org/2000/svg" style="overflow: hidden; position: relative; left: -0.546875px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.2</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><path fill="none" stroke="#0b62a4" d="M60,93.33333333333334A33.333333333333336,33.333333333333336,0,1,0,32.19817522124464,41.610610393966496" stroke-width="2" opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path><path fill="#0b62a4" stroke="#ffffff" d="M60,96.33333333333334A36.333333333333336,36.333333333333336,0,1,0,29.696010991156662,39.955565329423486L18.297262831866966,32.41591559094975A50,50,0,1,1,60,110Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#3980b5" d="M32.19817522124464,41.610610393966496A33.333333333333336,33.333333333333336,0,0,0,29.537275679893565,73.53268406888697" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#3980b5" stroke="#ffffff" d="M29.696010991156662,39.955565329423486A36.333333333333336,36.333333333333336,0,0,0,26.795630491083983,74.75062563508678L18.87532216785631,78.2691234929974A45,45,0,0,1,22.467536548680272,35.17432403185478Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#679dc6" d="M29.537275679893565,73.53268406888697A33.333333333333336,33.333333333333336,0,0,0,45.96938136953659,90.2366144261821" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#679dc6" stroke="#ffffff" d="M26.795630491083983,74.75062563508678A36.333333333333336,36.333333333333336,0,0,0,44.70662569279489,92.9579097245385L41.0586648488744,100.81942947534583A45,45,0,0,1,18.87532216785631,78.2691234929974Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#95bbd7" d="M45.96938136953659,90.2366144261821A33.333333333333336,33.333333333333336,0,0,0,59.98952802466035,93.33333168839924" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#95bbd7" stroke="#ffffff" d="M44.70662569279489,92.9579097245385A36.333333333333336,36.333333333333336,0,0,0,59.98858554687978,96.33333154035518L59.98586283329148,104.99999777933897A45,45,0,0,1,41.0586648488744,100.81942947534583Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="60" y="50" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: 800; font-size: 15px; line-height: normal; font-family: Arial;" font-size="15px" font-weight="800" transform="matrix(0.9932,0,0,0.9932,0.4097,0.3987)" stroke-width="1.006875"><tspan dy="5.203125" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">pay</tspan></text><text x="60" y="70" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-size: 14px; line-height: normal; font-family: Arial;" font-size="14px" transform="matrix(0.7097,0,0,0.7097,17.4185,18.049)" stroke-width="1.4090624999999999"><tspan dy="4.859375" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">at least 70%</tspan></text></svg></div>
					</div>
					<div class="col-xs-4">
						<div id="morris_donut_2" style="width:120px;height:120px;"><svg height="120" version="1.1" width="120" xmlns="http://www.w3.org/2000/svg" style="overflow: hidden; position: relative; left: -0.78125px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.2</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><path fill="none" stroke="#0b62a4" d="M60,93.33333333333334A33.333333333333336,33.333333333333336,0,0,0,91.99600251464084,69.34702809422362" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#0b62a4" stroke="#ffffff" d="M60,96.33333333333334A36.333333333333336,36.333333333333336,0,0,0,94.87564274095851,70.18826062270375L103.19460339476512,72.61848792720188A45,45,0,0,1,60,105Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#3980b5" d="M91.99600251464084,69.34702809422362A33.333333333333336,33.333333333333336,0,0,0,50.660511045647205,28.001796031923444" stroke-width="2" opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path><path fill="#3980b5" stroke="#ffffff" d="M94.87564274095851,70.18826062270375A36.333333333333336,36.333333333333336,0,0,0,49.81995703975545,25.121957674796555L45.990766568470804,12.002694047885164A50,50,0,0,1,107.99400377196126,74.02054214133543Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#679dc6" d="M50.660511045647205,28.001796031923444A33.333333333333336,33.333333333333336,0,0,0,26.666667591942108,59.99214601843869" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#679dc6" stroke="#ffffff" d="M49.81995703975545,25.121957674796555A36.333333333333336,36.333333333333336,0,0,0,23.666667675216893,59.991439160098174L15.000001249121844,59.989397124892236A45,45,0,0,1,47.39168991162373,16.80242464309665Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#95bbd7" d="M26.666667591942108,59.99214601843869A33.333333333333336,33.333333333333336,0,0,0,59.989528024660295,93.33333168839924" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#95bbd7" stroke="#ffffff" d="M23.666667675216893,59.991439160098174A36.333333333333336,36.333333333333336,0,0,0,59.98858554687972,96.33333154035518L59.9858628332914,104.99999777933897A45,45,0,0,1,15.000001249121844,59.989397124892236Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="60" y="50" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: 800; font-size: 15px; line-height: normal; font-family: Arial;" font-size="15px" font-weight="800" transform="matrix(0.9932,0,0,0.9932,0.4097,0.3987)" stroke-width="1.006875"><tspan dy="5.203125" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">store</tspan></text><text x="60" y="70" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-size: 14px; line-height: normal; font-family: Arial;" font-size="14px" transform="matrix(0.7097,0,0,0.7097,17.4185,18.049)" stroke-width="1.4090624999999999"><tspan dy="4.859375" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">approx. 35%</tspan></text></svg></div>
					</div>
					<div class="col-xs-4">
						<div id="morris_donut_3" style="width:120px;height:120px;"><svg height="120" version="1.1" width="120" xmlns="http://www.w3.org/2000/svg" style="overflow: hidden; position: relative; left: -0.015625px;"><desc style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">Created with Raphaël 2.1.2</desc><defs style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></defs><path fill="none" stroke="#0b62a4" d="M60,93.33333333333334A33.333333333333336,33.333333333333336,0,0,0,89.70825732605701,75.11722718490029" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#0b62a4" stroke="#ffffff" d="M60,96.33333333333334A36.333333333333336,36.333333333333336,0,0,0,92.38200048540213,76.47777763154131L100.10614739017696,80.4082566996154A45,45,0,0,1,60,105Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#3980b5" d="M89.70825732605701,75.11722718490029A33.333333333333336,33.333333333333336,0,0,0,80.48924225716694,33.70737626560954" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#3980b5" stroke="#ffffff" d="M92.38200048540213,76.47777763154131A36.333333333333336,36.333333333333336,0,0,0,82.33327406031196,31.341040129514397L87.66047704717536,24.50495795857288A45,45,0,0,1,100.10614739017696,80.4082566996154Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#679dc6" d="M80.48924225716694,33.70737626560954A33.333333333333336,33.333333333333336,0,0,0,58.43726880253472,26.703318749227" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#679dc6" stroke="#ffffff" d="M82.33327406031196,31.341040129514397A36.333333333333336,36.333333333333336,0,0,0,58.29662299476284,23.70661743665743L57.89031288342187,15.049480311456456A45,45,0,0,1,87.66047704717536,24.50495795857288Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#95bbd7" d="M58.43726880253472,26.703318749227A33.333333333333336,33.333333333333336,0,0,0,26.675708587813965,60.77634591955714" stroke-width="2" opacity="1" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 1;"></path><path fill="#95bbd7" stroke="#ffffff" d="M58.29662299476284,23.70661743665743A36.333333333333336,36.333333333333336,0,0,0,23.67652236071722,60.84621705231728L10.01356288172095,61.1645188793357A50,50,0,0,1,57.655903203802076,10.054978123840513Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><path fill="none" stroke="#b0cce1" d="M26.675708587813965,60.77634591955714A33.333333333333336,33.333333333333336,0,0,0,59.989528024660295,93.33333168839924" stroke-width="2" opacity="0" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); opacity: 0;"></path><path fill="#b0cce1" stroke="#ffffff" d="M23.67652236071722,60.84621705231728A36.333333333333336,36.333333333333336,0,0,0,59.98858554687972,96.33333154035518L59.9858628332914,104.99999777933897A45,45,0,0,1,15.012206593548854,61.04806699140213Z" stroke-width="3" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);"></path><text x="60" y="50" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: 800; font-size: 15px; line-height: normal; font-family: Arial;" font-size="15px" font-weight="800" transform="matrix(0.9932,0,0,0.9932,0.4097,0.3987)" stroke-width="1.006875"><tspan dy="5.203125" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">period</tspan></text><text x="60" y="70" text-anchor="middle" font="10px &quot;Arial&quot;" stroke="none" fill="#000000" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0); text-anchor: middle; font-style: normal; font-variant: normal; font-weight: normal; font-size: 14px; line-height: normal; font-family: Arial;" font-size="14px" transform="matrix(0.7097,0,0,0.7097,17.4185,18.049)" stroke-width="1.4090624999999999"><tspan dy="4.859375" style="-webkit-tap-highlight-color: rgba(0, 0, 0, 0);">period</tspan></text></svg></div>
					</div>
				</div>
				<div id="ow-activity" class="row">
					<div class="col-xs-2 col-sm-1 col-md-2">
						<div class="v-txt">ACTIVITY</div>
					</div>
					<div class="col-xs-7 col-sm-5 col-md-6">
						<div class="row"><i class="fa fa-code"></i> Release published <span class="label label-default pull-right">01:17:34</span></div>
						<div class="row"><i class="fa fa-cloud-upload"></i> Backup created <span class="label label-default pull-right">03:23:34</span></div>
						<div class="row"><i class="fa fa-camera"></i> Snapshot created <span class="label label-default pull-right">04:22:11</span></div>
						<div class="row"><i class="fa fa fa-money"></i> Invoice pay <span class="label label-default pull-right">05:11:51</span></div>
						<div class="row"><i class="fa fa-briefcase"></i> Project edited <span class="label label-default pull-right">04:52:23</span></div>
						<div class="row"><i class="fa fa-floppy-o"></i> Project saved <span class="label label-default pull-right">07:11:01</span></div>
						<div class="row"><i class="fa fa-bug"></i> Bug fixed <span class="label label-default pull-right">09:10:31</span></div>
					</div>
					<div id="ow-stat" class="col-xs-3 col-sm-4 col-md-4 pull-right">
						<div class="row"><small><b>Ow Stat.:</b></small></div>
						<div class="row">%user <sup>20,43</sup></div>
						<div class="row">%nice <sup>1,01</sup></div>
						<div class="row">%system <sup>27,34</sup></div>
						<div class="row">%iowait <sup>2,02</sup></div>
						<div class="row">%steal <sup>1,22</sup></div>
						<div class="row">%idle <sup>47,98</sup></div>
						<div class="row">tps <sup>296546</sup></div>
					</div>
				</div>
				<div id="ow-summary" class="row">
					<div class="col-xs-12">
						<h4 class="page-header"> SUMMARY</h4>
						<div class="row">
							<div class="col-xs-12">
								<div class="row">
									<div class="col-xs-6">Total commits<b>1245634</b></div>
									<div class="col-xs-6">Release count<b>227</b></div>
								</div>
								<div class="row">
									<div class="col-xs-6">Tests passed<b>5222345</b></div>
									<div class="col-xs-6">Tickets solved<b>324322</b></div>
								</div>
								<div class="row">
									<div class="col-xs-6">Active clients<b>52145</b></div>
									<div class="col-xs-6">Support team<b>288</b></div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
</div>