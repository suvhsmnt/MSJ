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
    <body class="fixed-left">    
        <!-- Begin page -->
        <div id="wrapper">
            <!-- Top Bar Start -->
            <div class="topbar">
                <!-- LOGO -->
                <div class="topbar-left">
                    <div class="text-center">
                        <a href="index.html" class="logo"><i class="icon-magnet icon-c-logo"></i><span>Ub<i class="md md-album"></i>ld</span></a>
                    </div>
                </div>
                <!-- Button mobile view to collapse sidebar menu -->
                <div class="navbar navbar-default" role="navigation">
                    <div class="container">
                        <div class="">
                            <div class="pull-left">
                                <button class="button-menu-mobile open-left">
                                    <i class="ion-navicon"></i>
                                </button>
                                <span class="clearfix"></span>
                            </div>
                            <ul class="nav navbar-nav navbar-right pull-right">  
                                <li class="hidden-xs">
                                    <a href="#" id="btn-fullscreen" class="waves-effect waves-light"><i class="icon-size-fullscreen"></i></a>
                                </li>
                                <li class="dropdown">
                                    <c:url value="Profile.htm" var="myURL">           
                                        <c:param name="Adhar" value="${sessionScope.LoginDetails.id}"/>                               
                                    </c:url>
                                    <a href="" class="dropdown-toggle profile" data-toggle="dropdown" aria-expanded="true"><img src="/MsJwellery/myImage.htm?id=${sessionScope.LoginDetails.id}" alt="user-img" class="img-circle"></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="${myURL}"><i class="ti-user m-r-5"></i> ${sessionScope.LoginDetails.name}</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-settings m-r-5"></i> Settings</a></li>
                                        <li><a href="javascript:void(0)"><i class="ti-lock m-r-5"></i> Lock screen</a></li>
                                        <li><a href="Logout.htm"><i class="ti-power-off m-r-5"></i> Logout</a></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!--/.nav-collapse -->
                    </div>
                </div>
            </div>
            <!-- Top Bar End -->
            <!-- ========== Left Sidebar Start ========== -->
            <div class="left side-menu">
                <div class="sidebar-inner slimscrollleft">
                    <!--- Divider -->
                    <div id="sidebar-menu">
                        <ul>
                            <li class="text-muted menu-title">Navigation</li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-home"></i> <span> Dashboard</span> </a>
                                <ul class="list-unstyled">
                                    <li><a href="index.html">Worker</a></li>
                                    <li><a href="CRegistration.htm">Customer</a></li>
                                    <li><a href="$my{url}">Orders</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-home"></i> <span> Worker</span> </a>
                                <ul class="list-unstyled">
                                    <li><a href="index.html">Add Worker</a></li>
                                    <li><a href="Workerlist.htm">Workers</a></li>
                                    <li><a href="javascript:void(0)">Profile</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-paint-bucket"></i> <span>Manage Order</span> </a>
                                <ul class="list-unstyled">
                                    <li><a href="Orderregister.htm">Add Order</a></li>
                                    <li><a href="">Delivered Order</a></li>
                                    <li><a href="">Order History</a></li>
                                    <li><a href="">Assign Order</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-pencil-alt"></i><span>Making</span></a>
                                <ul class="list-unstyled">
                                    <li><a href="">Orders</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-pencil-alt"></i><span>Setting</span></a>
                                <ul class="list-unstyled">
                                    <li><a href="">Orders</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-pencil-alt"></i><span>Chilai</span></a>
                                <ul class="list-unstyled">
                                    <li><a href="">Orders</a></li>
                                </ul>
                            </li>
                            <li class="has_sub">
                                <a href="#" class="waves-effect"><i class="ti-pencil-alt"></i><span>Polish</span></a>
                                <ul class="list-unstyled">
                                    <li><a href="">Orders</a></li>
                                </ul>
                            </li>                        
                        </ul>
                        <div class="clearfix"></div>
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <!--/.span3-->
            <div class="span9">
                <div class="content">

                    <div class="module">
                        <div class="module-head">
                            <h3>Forms</h3>
                        </div>
                        <div class="module-body">

                            <form:form action="customerregistration.htm" class="form-horizontal row-fluid" method="post"id="contactform" commandName="RegistrationDetails">

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
                                    <label class="control-label" for="basicinput">Address</label>
                                    <div class="controls">
                                        <textarea class="span8" name="ADDRESS" rows="5"></textarea>
                                    </div>
                                </div>
                                <div class="control-group">
                                    <label class="control-label" for="basicinput">Gst No.</label>
                                    <div class="controls">
                                        <input type="text" id="basicinput" name="GST" placeholder="Type something here..." class="span8" pattern="[0-9]{12}">
                                        <span class="help-inline"><p><form:errors path="GST" cssStyle="color:red"/></p></span>
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
