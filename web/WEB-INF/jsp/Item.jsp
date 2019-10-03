
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="description" content="A fully featured admin theme which can be used to build CRM, CMS, etc.">
        <meta name="author" content="Coderthemes">
        <link rel="shortcut icon" href="images/favicon_1.ico">
        <title>Maa Santosi Jwellery</title>       
        <link href="plugins/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/bootstrapvalidator/src/css/bootstrapValidator.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="plugins/jquery.steps/demo/css/jquery.steps.css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/core.css" rel="stylesheet" type="text/css" />
        <link href="css/components.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/pages.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script src="js/modernizr.min.js"></script>       
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
                                    <li><a href="index.htm">Worker</a></li>
                                    <li><a href="CRegistration.htm">Customer</a></li>
                                    <li><a href="OrderList.htm">Orders</a></li>
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
                                <c:url value="Order.htm" var="Prod">           
                                    <c:param name="ID" value="ORD28"/>                               
                                </c:url>
                                <ul class="list-unstyled">
                                    <li><a href="Orderregister.htm">Add Order</a></li>
                                    <li><a href="">Delivered Order</a></li>
                                    <li><a href="${Prod}">Order History</a></li>
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
            <!-- Left Sidebar End --> 
            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->                      
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="container">
                        <!-- Page-Title -->                         
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="card-box">
                                    <h4 style="text-align: center" class="m-t-0 m-b-30 header-title"><b>Fields validation</b></h4>
                                    <div class="row">
                                        <c:choose>
                                            <c:when test="${Success != null}" > 
                                                <div class="alert alert-success">
                                                    <strong>${Success}</strong>
                                                </div>
                                            </c:when >
                                            <c:when test="${Failure != null}" >
                                                <div class="alert alert-success">
                                                    <strong>${Failure}</strong>
                                                </div>
                                            </c:when>
                                            <c:otherwise> 

                                            </c:otherwise>
                                        </c:choose>
                                        <form:form action="item.htm"  method="post" class="form-horizontal group-border-dashed" commandName="itm" >
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Item Type*</label>
                                                <div class="col-sm-6">
                                                    <select id="sel" class="selectpicker" name="Type"  data-live-search="true" data-style="btn-white">
                                                        <option  value="PRIMARY" >PRIMARY</option>
                                                        <c:forEach items="${item}" var="item"> 
                                                            <option  value="${item.name}">${item.name}</option>
                                                        </c:forEach> 
                                                    </select>
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Item Name  *</label>
                                                <div class="col-sm-6">
                                                    <input type="text"  name="Name" class="form-control" required placeholder="Type something" />
                                                </div>

                                            </div>



                                            <div class="form-group">
                                                <div class="col-sm-offset-3 col-sm-9 m-t-15">
                                                    <button type="submit" class="btn btn-primary">
                                                        Submit
                                                    </button>
                                                    <button type="reset" class="btn btn-default m-l-5">
                                                        Cancel
                                                    </button>
                                                </div>
                                            </div>
                                        
                                    </form:form>
                                    </div>
                                     <div class="card-box m-t-20">  
                                    <table data-toggle="table"
                                           data-search="true"
                                           data-sort-name="id"
                                           class="table-bordered ">
                                        <thead>
                                            <tr>

                                                <th data-field="id" data-sortable="true" align="center">Item ID</th>
                                                <th  data-sortable="true" align="center">Item Name</th>
                                                <th  data-sortable="true" align="center">Item Type</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach items="${All}" var="Log" varStatus="counter"> 
                                                <tr>

                                                    <td>${Log.item_Id}</td>
                                                    <td > ${Log.name} </td>
                                                    <td> ${Log.type} </td>
                                                </tr>
                                            </c:forEach> 

                                        </tbody>
                                    </table><br>

                                </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div> <!-- content -->
            <footer class="footer">
                2018 � MsJwellery.
            </footer>
        </div>
        <!-- ============================================================== -->
        <!-- End Right content here -->
        <!-- ============================================================== -->
        <!-- Right Sidebar -->           
        <!-- /Right-bar -->
    </div>
    <!-- END wrapper -->
    <script>
        var resizefunc = [];
    </script>
    <!-- jQuery  -->
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/detect.js"></script>
    <script src="js/fastclick.js"></script>
    <script src="js/jquery.slimscroll.js"></script>
    <script src="js/jquery.blockUI.js"></script>
    <script src="js/waves.js"></script>
    <script src="js/wow.min.js"></script>
    <script src="js/jquery.nicescroll.js"></script>
    <script src="js/jquery.scrollTo.min.js"></script>
    <script src="js/jquery.core.js"></script>
    <script src="js/jquery.app.js"></script>        
    <script type="text/javascript" src="plugins/parsleyjs/dist/parsley.min.js"></script> 
    <script src="plugins/bootstrapvalidator/dist/js/bootstrapValidator.js" type="text/javascript"></script>
    <script src="plugins/jquery.steps/build/jquery.steps.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="plugins/jquery-validation/dist/jquery.validate.min.js"></script>
    <script src="pages/jquery.wizard-init.js" type="text/javascript"></script>	
    <script src="plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
    <script src="plugins/switchery/dist/switchery.min.js"></script>
    <script type="text/javascript" src="plugins/multiselect/js/jquery.multi-select.js"></script>
    <script type="text/javascript" src="plugins/jquery-quicksearch/jquery.quicksearch.js"></script>
    <script src="plugins/select2/select2.min.js" type="text/javascript"></script>
    <script src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
    <script src="plugins/bootstrap-filestyle/src/bootstrap-filestyle.min.js" type="text/javascript"></script>
    <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
    <script src="plugins/bootstrap-maxlength/bootstrap-maxlength.min.js" type="text/javascript"></script>
    <script src="plugins/select2/select2.min.js" type="text/javascript"></script>
    <script src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="plugins/multiselect/js/jquery.multi-select.js"></script>    
    <script src="plugins/bootstrap-table/dist/bootstrap-table.min.js"></script>
        <script src="pages/jquery.bs-table.js"></script>
        <script src="plugins\datatables\jquery.dataTables.min.js"></script>  
</body>
</html>