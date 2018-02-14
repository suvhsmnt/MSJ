<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Edmin</title>
        <link type="text/css" href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
        <link type="text/css" href="bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
        <link type="text/css" href="css/theme.css" rel="stylesheet">
        <link type="text/css" href="images/icons/css/font-awesome.css" rel="stylesheet">
        <link type="text/css" href='http://fonts.googleapis.com/css?family=Open+Sans:400italic,600italic,400,600'
            rel='stylesheet'>
    </head>
    <body>
        <div class="navbar navbar-fixed-top">
            <div class="navbar-inner">
                <div class="container">
                    <a class="btn btn-navbar" data-toggle="collapse" data-target=".navbar-inverse-collapse">
                        <i class="icon-reorder shaded"></i></a><a class="brand" href="index.html">Edmin </a>
                    <div class="nav-collapse collapse navbar-inverse-collapse">
                        <ul class="nav nav-icons">
                            </ul>
                        <ul class="nav pull-right">
                          <li class="nav-user dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <img src="/MsJwellery/myImage.htm?id=${sessionScope.LoginDetails.phone}" class="nav-avatar"/>
                                <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">${sessionScope.LoginDetails.name}</a></li>
                                    <li><a href="#">Edit Profile</a></li>
                                    <li><a href="#">Account Settings</a></li>
                                    <li class="divider"></li>
                                    <li><a href="Logout.htm">Logout</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                    <!-- /.nav-collapse -->
                </div>
            </div>
            <!-- /navbar-inner -->
        </div>
        <!-- /navbar -->
        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span3">
                        <div class="sidebar">
                            <ul class="widget widget-menu unstyled">
                                <li class="active"><a href="index.html"><i class="menu-icon icon-dashboard"></i>Dashboard
                                </a></li>
                                <li><a href="Workerlist.htm"><i class="menu-icon icon-bullhorn"></i>News Feed </a>
                                </li>
                                <li><a href="message.html"><i class="menu-icon icon-inbox"></i>Inbox <b class="label green pull-right">
                                    11</b> </a></li>
                                <li><a href="task.html"><i class="menu-icon icon-tasks"></i>Tasks <b class="label orange pull-right">
                                    19</b> </a></li>
                            </ul>
                            <!--/.widget-nav-->
                            
                            
                            <ul class="widget widget-menu unstyled">
                                <li><a href="ui-button-icon.html"><i class="menu-icon icon-bold"></i> Buttons </a></li>
                                <li><a href="ui-typography.html"><i class="menu-icon icon-book"></i>Typography </a></li>
                                <li><a href="form.html"><i class="menu-icon icon-paste"></i>Forms </a></li>
                                <li><a href="table.html"><i class="menu-icon icon-table"></i>Tables </a></li>
                                <li><a href="charts.html"><i class="menu-icon icon-bar-chart"></i>Charts </a></li>
                            </ul>
                            <!--/.widget-nav-->
                            <ul class="widget widget-menu unstyled">
                                <li><a class="collapsed" data-toggle="collapse" href="#togglePages"><i class="menu-icon icon-cog">
                                </i><i class="icon-chevron-down pull-right"></i><i class="icon-chevron-up pull-right">
                                </i>More Pages </a>
                                    <ul id="togglePages" class="collapse unstyled">
                                        <li><a href="other-login.html"><i class="icon-inbox"></i>Login </a></li>
                                        <li><a href="other-user-profile.html"><i class="icon-inbox"></i>Profile </a></li>
                                        <li><a href="other-user-listing.html"><i class="icon-inbox"></i>All Users </a></li>
                                    </ul>
                                </li>
                                <li><a href="#"><i class="menu-icon icon-signout"></i>Logout </a></li>
                            </ul>
                        </div>
                        <!--/.sidebar-->
                    </div>
                    <!--/.span3-->
                    <div class="span9">
                        <div class="content">
						
						<div class="module">
							<div class="module-head">
								<h3>Forms</h3>
							</div>
							<div class="module-body">
		  					
							<form:form action="index.htm" class="form-horizontal row-fluid" method="post"id="contactform" commandName="RegistrationDetails" enctype="multipart/form-data">
										
										${success}
										<div class="control-group">
											<label class="control-label" for="basicinput">Enter Your Name</label>
											<div class="controls">
												<input type="text" id="basicinput" name="name" placeholder="Type something here..." class="span8"  max="20">
												<span class="help-inline">Minimum 5 Characters</span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Email</label>
											<div class="controls">
												<input type="email" id="basicinput" name="Email" placeholder="Type something here..." class="span8" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$">
												<span class="help-inline"><form:errors path="email" cssStyle="color:red"/></span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Phone Number</label>
											<div class="controls">
												<input type="text" id="basicinput" name="Phone" placeholder="Type something here..." class="span8">
												<span class="help-inline"><form:errors path="phone" cssStyle="color:red"/></span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Password</label>
											<div class="controls">
												<input type="Password" id="basicinput" name="Password" placeholder="Type something here..." class="span8">
												<span class="help-inline"><form:errors path="password" cssStyle="color:red"/></span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Confirm Password</label>
											<div class="controls">
												<input type="Password" id="basicinput" name="repassword" placeholder="Type something here..." class="span8">
                                                                                                <span class="help-inline"><form:errors path="repassword" cssStyle="color:red"/></span>
											</div>
										</div>
  										
                                        <div class="control-group">
											<label class="control-label" for="basicinput">Address</label>
											<div class="controls">
												<textarea class="span8" name="ADDRESS" rows="5"></textarea>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Adhar Card No.</label>
											<div class="controls">
												<input type="text" id="basicinput" name="ADHAR" placeholder="Type something here..." class="span8" pattern="[0-9]{12}">
                                                                                                <span class="help-inline"><p><form:errors path="ADHAR" cssStyle="color:red"/></p></span>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Gold </label>
											<div class="controls">
												<div class="input-append">
													<input type="text" placeholder="5.000" name="GOLD" class="span8"><span class="add-on">.gm</span>
												</div>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Salary</label>
											<div class="controls">
												<div class="input-append">
													<input type="text" placeholder="5.000" name="NETBAL" class="span8"><span class="add-on">.Rs</span>
												</div>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Stone </label>
											<div class="controls">
												<div class="input-append">
													<input type="text" placeholder="5.000" name="STONE" class="span8"><span class="add-on">.pcs</span>
												</div>
											</div>
										</div>
										<div class="control-group">
											<label class="control-label" for="basicinput">Choose Image</label>
											<div class="controls">
												<form:input path="filedata" id="image" type="file" class="span8"/>
												 <span class="help-inline">Minimum 5 Characters</span>
											</div>
										</div>
                                        <div class="control-group">
											<div class="controls">
												<button type="submit" class="btn btn-large btn-info">Submit Form</button>	
											</div>
										</div>
									</form:form>
							</div>
						</div>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
        <div class="footer">
            <div class="container">
                <b class="copyright">&copy; 2014 Edmin - EGrappler.com </b>All rights reserved.
            </div>
        </div>
        <script src="scripts/jquery-1.9.1.min.js" type="text/javascript"></script>
        <script src="scripts/jquery-ui-1.10.1.custom.min.js" type="text/javascript"></script>
        <script src="bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.js" type="text/javascript"></script>
        <script src="scripts/flot/jquery.flot.resize.js" type="text/javascript"></script>
        <script src="scripts/datatables/jquery.dataTables.js" type="text/javascript"></script>
        <script src="scripts/common.js" type="text/javascript"></script>
      
    </body>
