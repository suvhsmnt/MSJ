
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
        <link rel="shortcut icon" href="images/favicon_1.ico">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link type="text/css" href="plugins/x-editable/dist/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet">
        <title>Ubold - Responsive Admin Dashboard Template</title>
        <link href="plugins/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/core.css" rel="stylesheet" type="text/css" />
        <link href="css/components.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/pages.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="plugins/custombox/dist/custombox.min.css" rel="stylesheet">
        <link href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="js/modernizr.min.js"></script>   
        <style>
            .overlay {
                position: fixed;
                display: none;
                width: 100%;
                height: 100%;
                top: 0;
                left: 0;
                right: 0;
                bottom: 0;
                background-color: rgba(0,0,255,0.3);
                z-index: 2; 
                cursor: pointer;
                margin: 0 auto;
                background: rgba( 0, 0, 0, 0 ) 
                    url('images/loading.gif') 
                    50% 50% 
                    no-repeat;
            }
        </style> 
    </head>

    <body class="fixed-left" >    
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
            <!-- Left Sidebar End --> 
            <!-- ============================================================== -->
            <!-- Start right Content here -->
            <!-- ============================================================== -->                      
            <div class="content-page">
                <!-- Start content -->
                <div class="content">
                    <div class="wraper container-fluid">
                        <div class="row">


                            <div class="col-sm-12">
                                <div class="card-box m-t-20">  




                                    <table data-toggle="table"
                                           data-search="true"
                                           data-sort-name="id"
                                           class="table-bordered ">
                                        <thead>
                                            <tr>

                                                <th data-field="id" data-sortable="true" align="center">Product ID</th>
                                                <th  data-sortable="true" align="center">Order Progress</th>
                                                <th  data-sortable="true" align="center">Order Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>

                                            <c:forEach items="${All}" var="Log" varStatus="counter"> 
                                                <tr>

                                                    <td> hellow </td>
                                                    <td > hi </td>
                                                    <td> <button id="test" class="btn btn-primary waves-effect waves-light" style="width:100%" data-toggle="modal" data-target="#custom-width-modal" value="${Log.prodId}" >${Log.prodId}</button> </td>
                                                </tr>
                                            </c:forEach> 

                                        </tbody>
                                    </table><br>

                                </div>


                            </div>

                            <!-- Personal-Information -->
                            <!-- Personal-Information -->																															
                        </div>                                                                                      
                    </div>                    
                </div> <!-- container -->                              
            </div><!-- content -->
            <footer class="footer">
                2018 © MsJwellery.
            </footer>
        </div>


        <!-- ============================================================== -->
        <!-- End Right content here -->
        <!-- ============================================================== -->
        <!-- Right Sidebar -->           
        <!-- /Right-bar -->
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
        <script src="plugins/custombox/dist/custombox.min.js"></script>
        <script src="plugins/custombox/dist/legacy.min.js"></script>
        <script src="plugins/moment/moment.js"></script>
        <script type="text/javascript" src="plugins/x-editable/dist/bootstrap3-editable/js/bootstrap-editable.min.js"></script>
        <script type="text/javascript" src="pages/jquery.xeditable.js"></script>
        <script src="plugins/bootstrap-table/dist/bootstrap-table.min.js"></script>
        <script src="pages/jquery.bs-table.js"></script>
        <script src="plugins\datatables\jquery.dataTables.min.js"></script>      
        <script src="plugins/select2/select2.min.js" type="text/javascript"></script>
        <script src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="plugins/multiselect/js/jquery.multi-select.js"></script>
        <script type="text/javascript" src="pages/Ajax.js"></script>

        <div id="custom-width-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog" style="width:55%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
                        <p align="center" style="color:mediumseagreen" class="modal-title" id="ans"></p> 
                    </div> 
                    <div class="col-md-8"> 
                        <div id="overlay1" class="overlay"></div>
                        <div id="MAKING_ASSIGN">
                            <div    class="modal-body"> 
                                <form:form method="post" id="MAKING">
                                    <p align="center" style="color:mediumseagreen" class="modal-title" id="status"></p> 
                                    <div class="form-group"> 
                                        <div align="center" >
                                            <label for="field-3" class="control-label" >Select Maker</label> </div>

                                        <select id="sel"  class="selectpicker" name="CUSTOMER_ID"  data-live-search="true" data-style="btn-white">
                                        </select>
                                    </div>                                  
                                    <div class="row"> 
                                        <div class="col-md-5"> 
                                            <div class="form-group"> 
                                                <input id="remember-1" type="checkbox">
                                                <label for="remember-1">Set Loss Percentage </label>
                                            </div> 
                                        </div> 
                                        <div class="col-md-7"> 
                                            <div class="form-group"> 

                                                <input data-parsley-type="number" id="l_percentage" type="text" class="form-control"  placeholder="Enter only numbers" />
                                            </div> 
                                        </div> 
                                    </div> 
                                    <input type="hidden" name="Product" id="pid">
                                    <div id="msg"></div>
                                    <div align="center"> 
                                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button> 
                                        <button type="submit" class="btn btn-info waves-effect waves-light">Save changes</button> 
                                    </div> 
                                </form:form>  
                            </div>
                        </div>
                        <div id="MAKING_RECEIVE">
                            <div    class="modal-body"> 



                                <form:form method="post" class="form-horizontal" id="MAKINGRECEIVE">
                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="state-success">Return &nbsp Gold</label>
                                        <div class="col-md-8">
                                            <input type="text" id="R_GOLD" name="state-success" required class="form-control" >
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label class="col-md-3 control-label" for="state-success">Return Stone</label>
                                        <div class="col-md-8">
                                            <input type="text" id="R_STONE" name="state-success" required class="form-control" >
                                        </div>
                                    </div>
                                    <input type="hidden" name="Product" id="pid_r">
                                    <div id="msg"></div>

                                    <div align="center"> 
                                        <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button> 
                                        <button type="submit" class="btn btn-info waves-effect waves-light">Save changes</button> 
                                    </div> 
                                </form:form>  
                            </div>
                        </div>
                        <div id="img_product">
                            <form:form id="fileForm" enctype="multipart/form-data" >
                                <input  id="idLogoFile" type="file" name="idLogoFile" />
                                <button id="btnUpload" type="button">Upload file</button>
                                <button id="btnClear" type="button">Clear</button>
                            </form:form>
                            <div id="idImagePlaceHolder"></div>
                        </div>


                    </div>
                    <div class="col-sm-4">
                        <div style="margin-left:20px;margin-top: 12px;">
                            <img src="images/blank.gif" alt="image" class="img-responsive img-thumbnail" width="200" />

                            <p class="m-t-15 m-b-0">
                                <code>.img-thumbnail</code>
                            </p>
                        </div>

                    </div>

                    <div id="overlay" class="overlay"></div>
                    <div id="NotAssign2" >

                        <div class="row"> 

                            <table 
                                   id="details"
                                   class="table">
                                <thead>
                                    <tr>

                                        <th >Name</th>
                                        <th >Worker</th>
                                        <th >Assigned By</th>
                                        <th >Loss Percentage</th>
                                        <th>GIVEN GOLD</th>
                                        <th >Return GOLD</th>
                                        <th >Given_Stone</th>
                                        <th >Return Stone</th>
                                        <th >Date</th>

                                    </tr>
                                </thead>
                                <tbody id="tbody">
                                   
                                </tbody>
                            </table>

                        </div> 
                    </div>
                </div>
            </div> 

        </div>

    </body>
</html>