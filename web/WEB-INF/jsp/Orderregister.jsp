
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
        <title>Ubold - Responsive Admin Dashboard Template</title>       
        <link href="plugins/bootstrapvalidator/src/css/bootstrapValidator.css" rel="stylesheet" type="text/css" />
        <link rel="stylesheet" type="text/css" href="plugins/jquery.steps/demo/css/jquery.steps.css" />
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/core.css" rel="stylesheet" type="text/css" />
        <link href="css/components.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/pages.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
        <link href="plugins/custombox/dist/custombox.min.css" rel="stylesheet">
        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->
        <script src="js/modernizr.min.js"></script> 

    </head>
    <script type="text/javascript">
        var row = 0;
        function add_fields() {
            if (row < 2)
            {
                row++;
                var tag = "div";
                tag = tag + row;
                var objTo = document.getElementById('room_fileds');
                var divtest = document.createElement(tag);
                divtest.innerHTML = '<div class="form-group"><label class="col-sm-3 control-label">Equal To</label><div class="col-sm-3"><select name="order[' + row + '].TYPE" class="form-control select2"><option>Select</option><optgroup label="Alaskan/Hawaiian Time Zone"><option value="AK">Alaska</option><option value="HI">Hawaii</option></optgroup></select></div></div><div class="form-group"><label class="col-sm-3 control-label">Equal To</label><div class="col-sm-3"><input type="text"  name="order[' + row + '].QUANTITY" class="form-control" required placeholder="Quantitity" /></div><div class="col-sm-3"><input type="text" class="form-control" name="order[' + row + '].AVG_WT" required  placeholder="Average wet" /></div></div>';

                objTo.appendChild(divtest)
            }
        }
        function remove_fields()
        {
            if (1 <= row)
            {

                var list = document.getElementById("room_fileds");
                list.removeChild(list.childNodes[row + 2]);
                row--;
            }


        }
    </script>
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
                                    <h4 class="m-t-0 m-b-30 header-title" style="text-align: center"><b>Fields validation</b></h4>
                                    <div class="row">

                                        <form:form action="Orderregister.htm" class="form-horizontal row-fluid" method="post" id="contactform" commandName="OrderDetails">

                                            <p style="text-align: center"class="text-muted font-13 m-b-30">
                                                <b>${Success}</b>
                                            </p>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Customer Id*</label>
                                                <div class="col-sm-6">
                                                    <select id="sel" class="selectpicker" name="CUSTOMER_ID"  data-live-search="true" data-style="btn-white">
                                                       
                                                        <c:forEach items="${CSMR}" var="csm"> 
                                                        <option  value="${csm.CID}" onclick="customername('${csm.name}')">${csm.CID}&nbsp&nbsp${csm.name}</option>
                                                         </c:forEach> 
                                                    </select>
                                                </div>
                                               </div>
                                            
                                             
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Receptionist Name</label>
                                                <div class="col-sm-6">
                                                    <input type="text" name="R_NAME" class="form-control" required parsley-type="email" placeholder="Enter a valid e-mail" />
                                                </div>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Total Quantity*</label>
                                                <div class="col-sm-6">
                                                    <input data-parsley-type="digits" name="TOTAL_QUANTITY" type="text" class="form-control" required placeholder="Enter only digits" />
                                                </div>
                                                <form:errors path="TOTAL_QUANTITY" cssStyle="color:red"/>
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-3 control-label">Details</label>													
                                                <div class="col-sm-3">
                                                    <a href="#" onclick="add_fields();" class="btn btn-default btn-md waves-effect waves-light m-b-30" data-animation="fadein" 
                                                       data-overlayColor="#36404a">Add Divide</a>
                                                </div>
                                                <div class="col-sm-3">
                                                    <a href="#" onclick="remove_fields();" class="btn btn-default btn-md waves-effect waves-light m-b-30" data-animation="fadein" 
                                                       data-overlayColor="#36404a">Remove Divide</a>
                                                </div>
                                            </div>
                                            <div id="room_fileds">
                                                <div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Equal To</label>
                                                        <div class="col-sm-3">
                                                            <select name="order[0].TYPE" class="form-control select2">
                                                                <option>Select</option>
                                                                <optgroup label="Alaskan/Hawaiian Time Zone">
                                                                    <option value="AK">Alaska</option>
                                                                    <option value="HI">Hawaii</option>
                                                                </optgroup>
                                                            </select>
                                                        </div>


                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-3 control-label">Details</label>													
                                                        <div class="col-sm-3">
                                                            <input type="text" id="pass2" name="order[0].QUANTITY"  class="form-control" required placeholder="Quantity" />
                                                        </div>
                                                        <div class="col-sm-3">
                                                            <input type="text" class="form-control" name="order[0].AVG_WT"  required  required placeholder="Average wet" />
                                                        </div>
                                                    </div>
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
                                </div>
                            </div>
                        </div>
                    </div> <!-- container -->          
                </div> <!-- content -->
                <footer class="footer">
                    2018 © MsJwellery.
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
        <script src="plugins/custombox/dist/custombox.min.js"></script>
        <script src="plugins/select2/select2.min.js" type="text/javascript"></script>
        <script src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="plugins/multiselect/js/jquery.multi-select.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('form').parsley();
                              
            });
        </script>
        <div id="Password-modal" class="modal-demo">
            <button type="button" class="close" onclick="Custombox.close();">
                <span>&times;</span><span class="sr-only">Close</span>
            </button>
            <h4 class="custom-modal-title">Customer </h4>
            <div class="custom-modal-text text-left">

            </div>
        </div>
    </body>
</html>