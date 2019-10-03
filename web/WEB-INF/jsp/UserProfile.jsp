
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
        <link type="text/css" href="plugins/x-editable/dist/bootstrap3-editable/css/bootstrap-editable.css" rel="stylesheet">
        <title>Ubold - Responsive Admin Dashboard Template</title>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/core.css" rel="stylesheet" type="text/css" />
        <link href="css/components.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/pages.css" rel="stylesheet" type="text/css" />
        <link href="css/LinkStyle.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />
        <link href="plugins/bootstrap-table/dist/bootstrap-table.min.css" rel="stylesheet" type="text/css" />
        <link href="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.css" rel="stylesheet" />
        <link href="plugins/custombox/dist/custombox.min.css" rel="stylesheet">
        <link href="plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet" />
        <link href="plugins/switchery/dist/switchery.min.css" rel="stylesheet" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.11.0/themes/smoothness/jquery-ui.css">
        <script src="//code.jquery.com/jquery-1.10.2.js"></script>
        <script src="//code.jquery.com/ui/1.11.0/jquery-ui.js"></script>
        <link href="plugins/bootstrap-select/dist/css/bootstrap-select.min.css" rel="stylesheet" />
        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="js/modernizr.min.js"></script>   
        <style>
            .overlay {
                position: absolute;
                display: none;
                /*                width: 100%;
                                height: 100%;*/
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
            .chip {
                display: inline-block;
                padding: 0 25px;
                height: 50px;
                font-size: 16px;
                line-height: 50px;
                border-radius: 25px;
                background-color: #f1f1f1;
                margin-left:11px;
            }

            .chip img {
                float: left;
                margin: 0 10px 0 -25px;
                height: 50px;
                width: 50px;
                border-radius: 50%;
            }
            .form-row { display: flex; margin-bottom: 29px; }
            .form-row:last-child { margin-bottom: 0px; }
            .margin-top-10 { margin-top: 10px; }
            .float-left { float: left; }
            .float-right { float: right; }
            .display-inline { display: inline; }
            .display-inline-block { display: inline-block; }
            .width-200 { width: 200px; }
            .clear-both { clear: both; }
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
                    <div class="container">

                        <div class="row">
                            <div class="card-box">
                                <div class="row">
                                    <div class="col-md-3">
                                        <div class="containforprofile"> 
                                            <img src="/MsJwellery/WorkerImage.htm?id=${worker.worker_Id}" alt="Paris" class="profilepic" >
                                            <a href="#"><div class="profilepicmiddle">
                                                    <div class="popup">Update Photo</div>
                                                </div></a>
                                            <p class="profilename"><b>${worker.name}</b></p>
                                        </div>
                                    </div>

                                </div>
                                <hr>
                                <div class="row">
                                    <div class="col-lg-12"> 
                                        <ul class="nav nav-tabs tabs tabs-top">
                                            <li class="active tab">
                                                <a href="#home-21" data-toggle="tab" aria-expanded="false"> 
                                                    <span class="visible-xs"><i class="fa fa-home"></i></span> 
                                                    <span class="hidden-xs">Home</span> 
                                                </a> 
                                            </li> 
                                            <li class="tab"> 
                                                <a href="#profile-21" data-toggle="tab" aria-expanded="false"> 
                                                    <span class="visible-xs"><i class="fa fa-user"></i></span> 
                                                    <span class="hidden-xs">Profile</span> 
                                                </a> 
                                            </li> 
                                            <li class="tab"> 
                                                <a href="#messages-21" data-toggle="tab" aria-expanded="true"> 
                                                    <span class="visible-xs"><i class="fa fa-envelope-o"></i></span> 
                                                    <span class="hidden-xs">Messages</span> 
                                                </a> 
                                            </li> 
                                            <li class="tab"> 
                                                <a href="#settings-21" data-toggle="tab" aria-expanded="false"> 
                                                    <span class="visible-xs"><i class="fa fa-cog"></i></span> 
                                                    <span class="hidden-xs">Settings</span> 
                                                </a> 
                                            </li> 
                                        </ul> 
                                        <div class="tab-content"> 
                                            <div class="tab-pane active" id="home-21"> 
                                                <div class="tabs-vertical-env"> 
                                                    <div class="tab-content"> 
                                                        <div class="tab-pane active" id="v2-home"> 
                                                            <form:form  method="post" id="updatedetails">
                                                                <div class="form-group">
                                                                    <label for="Name">Name</label>
                                                                    <input type="text" class="form-control" id="NameUpdate"  name="Name" value="${worker.name}"/>
                                                                </div>
                                                                <div id="overlay1" class="overlay"></div>
                                                                <div class="form-group">
                                                                    <label for="name">Mobile no</label>
                                                                    <input type="text" id="PhoneUpdate" name="Phone" class="form-control" required="true" value="${worker.phone}" />
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="name">Email</label>
                                                                    <input type="email" id="EmailUpdate"  name="Email" class="form-control" required="true" value="${worker.email}"/>
                                                                </div>
                                                                <input type="hidden" id="WorkerId" value="${worker.worker_Id}">
                                                                <div class="form-group">
                                                                    <label for="name">Enter Your password to Update</label>
                                                                    <input type="password" class="form-control" id="PasswordForUpdate"  name="uPassword" required="true" placeholder="Enter your Password"/>
                                                                </div>
                                                                <div id="msgd"></div>

                                                                <button type="submit" class="btn btn-default waves-effect waves-light">Save</button>
                                                                <button type="button" onclick="Custombox.close();" class="btn btn-danger waves-effect waves-light m-l-10">Cancel</button>
                                                            </form:form>
                                                        </div> 
                                                        <div class="tab-pane" id="v2-profile"> 
                                                            <form:form method="post" id="Password">
                                                                <div class="form-group">
                                                                    <label for="name">Your Old Password</label>
                                                                    <input type="password" class="form-control" id="password"  name="oldpassword" required="true" placeholder="Enter your Password"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="name">New Password</label>
                                                                    <input type="password" id="pass2" name="newpassword" class="form-control" required placeholder="Password" />
                                                                </div>
                                                                <div id="overlay2" class="overlay"></div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputEmail1">Confirm New </label>
                                                                    <input type="password" id="cnfpass" class="form-control" name="confirmpassword" required data-parsley-equalto="#pass2" placeholder="Re-Type Password" />
                                                                </div>
                                                                <input type="hidden" id="adhar" name="id" value="${worker.worker_Id}">
                                                                <div id="msg"></div>
                                                                <button type="submit" class="btn btn-default waves-effect waves-light">Update</button>
                                                                <button type="button" onclick="Custombox.close();" class="btn btn-danger waves-effect waves-light m-l-10">Cancel</button>
                                                            </form:form> 
                                                        </div> 
                                                        <div class="tab-pane" id="v2-messages"> 
                                                            <ul class="nav nav-tabs tabs ">
                                                                <li class="active tab">
                                                                    <a href="#home-211" data-toggle="tab" aria-expanded="true"> 
                                                                        <span class="visible-xs"><i class="fa fa-home"></i></span> 
                                                                        <span class="hidden-xs">Credit</span> 
                                                                    </a> 
                                                                </li> 
                                                                <li class="tab"> 
                                                                    <a href="#profile-211" data-toggle="tab" aria-expanded="false"> 
                                                                        <span class="visible-xs"><i class="fa fa-user"></i></span> 
                                                                        <span class="hidden-xs">Debit</span> 
                                                                    </a> 
                                                                </li> 

                                                            </ul> 
                                                            <div class="tab-content"> 
                                                                <div class="tab-pane active" id="home-211"> 
                                                                    <form:form method="post" id="GoldCredit">
                                                                        <div class="form-group">
                                                                            <label for="name">Gold</label>
                                                                            <div class="input-group m-t-10">

                                                                                <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
                                                                                <input type="text"  id="Gold" name="Gold" class="form-control">
                                                                                <span class="input-group-addon">gm</span>
                                                                            </div>
                                                                        </div>  
                                                                        <div id="overlayForGold" class="overlay"></div>
                                                                        <div class="form-group">
                                                                            <label for="name">Rupees</label>
                                                                            <div class="input-group m-t-10">

                                                                                <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
                                                                                <input type="text"  id="Rupees" name="Rupees" class="form-control" >
                                                                                <span class="input-group-addon">Rs</span>
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="name">Password</label>
                                                                            <input type="password" class="form-control" id="PassForCreditGold"  name="PassForCreditGold" required="true" placeholder="Enter your Password"/>
                                                                        </div>


                                                                        <input type="hidden" id="adharForCredit" name="id" value="${worker.worker_Id}">

                                                                        <div id="msgForGoldCredit"></div>

                                                                        <button type="submit" class="btn btn-default waves-effect waves-light">Update</button>
                                                                        <button type="button" onclick="Custombox.close();" class="btn btn-danger waves-effect waves-light m-l-10">Cancel</button>
                                                                    </form:form> </div> 
                                                                <div class="tab-pane" id="profile-211">
                                                                    <form:form method="post" id="GoldDebit">
                                                                        <div class="form-group">
                                                                            <label for="name">Gold</label>
                                                                            <div class="input-group m-t-10">

                                                                                <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
                                                                                <input type="text"  id="GoldDebit" name="GoldDebit" class="form-control">
                                                                                <span class="input-group-addon">gm</span>
                                                                            </div>
                                                                        </div>  
                                                                        <div id="overlayForGold" class="overlay"></div>
                                                                        <div class="form-group">
                                                                            <label for="name">Rupees</label>
                                                                            <div class="input-group m-t-10">

                                                                                <span class="input-group-addon"><i class="fa fa-dollar"></i></span>
                                                                                <input type="text"  id="RupeesDebit" name="RupeesDebit" class="form-control" >
                                                                                <span class="input-group-addon">Rs</span>
                                                                            </div>
                                                                        </div>
                                                                        <div class="form-group">
                                                                            <label for="name">Password</label>
                                                                            <input type="password" class="form-control" id="PassForDebirtGold"  name="PassForCreditGold" required="true" placeholder="Enter your Password"/>
                                                                        </div>


                                                                        <input type="hidden" id="adharForDebit" name="id" value="${worker.worker_Id}">

                                                                        <div id="msgForGoldDebit"></div>

                                                                        <button type="submit" class="btn btn-default waves-effect waves-light">Update</button>
                                                                        <button type="button" onclick="Custombox.close();" class="btn btn-danger waves-effect waves-light m-l-10">Cancel</button>
                                                                    </form:form>   
                                                                </div> 


                                                            </div> 
                                                        </div>    
                                                    </div> 
                                                    <ul class="nav tabs-vertical"> 

                                                        <li class="active">
                                                            <a href="#v2-home" data-toggle="tab">Profile</a>
                                                        </li> 
                                                        <li>
                                                            <a href="#v2-profile" data-toggle="tab">Password</a>
                                                        </li> 
                                                        <li>
                                                            <a href="#v2-messages" data-toggle="tab">Gold</a>
                                                        </li> 

                                                    </ul> 
                                                </div> 

                                            </div> 
                                            <div class="tab-pane" id="profile-21">
                                                <div class="col-md-12">
                                                    <div class="margin-top-10">
                                                        <div class="float-left">
                                                            <button id="refresh" class="btn btn-primary waves-effect waves-light" style="width:100%" data-toggle="modal" data-target="#" value="abc" ><i class="glyphicon glyphicon-refresh"></i></button> 

                                                        </div>
                                                        <div class="float-right">
                                                            <button id="btnAdd" class="btn btn-primary waves-effect waves-light" style="width:100%" data-toggle="modal" data-target="#custom-width-modal" value="abc" >Add Loss</button> 

                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="">
                                                    <table class="table table-striped" id="Loss_table">
                                                        <thead>
                                                            <tr>
                                                                <th>Work Type</th>
                                                                <th>Work Phase</th>
                                                                <th>Loss</th>
                                                                <th>Last Assinged By</th>
                                                                <th>Last Updated</th>
                                                                <th>Action</th>
                                                            </tr>
                                                        </thead>
                                                        <div id="overlayfortable" class="overlay"></div>
                                                        <tbody>
                                                            <tr class="gradeX">
                                                                <td>GUNYAMALA</td>
                                                                <td>Making</td>
                                                                <td>2.3%</td>
                                                                <td class="actions">
                                                                    <button id="edit" onclick="edit(9)" data-toggle="modal" data-target="#custom-width-modal" value="abc" ><i class="fa fa-pencil"></i></button> 
                                                                    <button id="btnAdd"  data-toggle="modal" data-target="#custom-width-modal" value="abc" ><i class="fa fa-trash-o"></i></button> 

                                                                </td>
                                                            </tr>

                                                        </tbody>
                                                    </table>
                                                </div>




                                            </div> 
                                            <div class="tab-pane" id="messages-21">

                                            </div> 
                                            <div class="tab-pane" id="settings-21">
                                                <p>Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt.Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim.</p>  
                                                <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim.</p> 
                                            </div> 
                                        </div> 
                                    </div> 
                                </div>
                            </div>
                        </div>
                    </div> <!-- container -->
                </div>
            </div> <!-- container -->          
        </div> <!-- content -->
        <footer class="footer">
            2018 © MsJwellery.
        </footer>

        <div id="custom-width-modal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog" style="width:55%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
                        <p align="center" style="color:mediumseagreen" class="modal-title" id="ans"></p> 
                    </div> 

                    <div id="overlayforaddloss" class="overlay"></div>

                    <form:form method="post" id="AddLoss">

                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Select Type Of Work</label> </div>

                            <select id="worktype"  class="selectpicker" name="WorkType"  data-live-search="true" data-style="btn-white">
                            </select>
                        </div>   
                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Select Type of Working</label> </div>

                            <select id="workingtype"  class="selectpicker" name="workingtype"  data-live-search="true" data-style="btn-white">
                            </select>
                        </div> 
                        <div id="overlay2nd" class="overlay"></div>
                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Select Maker</label> </div>

                            <input data-parsley-type="number" id="l_percentage" type="text" class="form-control"  placeholder="Enter only numbers" />
                        </div> 

                        <div class="form-group">
                            <label for="name">Password</label>
                            <input type="password" class="form-control" id="PassForAddLoss"  name="PassForAddLoss" required="true" placeholder="Enter your Password"/>
                        </div>
                        <div id="msgforaddloss" aling="center"></div>
                        <input type="hidden" id="worker_id" name="worker_id" value="${worker.worker_Id}">
                        <div align="center"> 
                            <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button> 
                            <button type="submit" class="btn btn-info waves-effect waves-light">Save changes</button> 
                        </div> 
                    </form:form>
                </div>
            </div> 

        </div>
        <div id="editLoss" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="custom-width-modalLabel" aria-hidden="true" style="display: none;">
            <div class="modal-dialog" style="width:55%;">
                <div class="modal-content">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button> 
                        <p align="center" style="color:mediumseagreen" class="modal-title" id="ans"></p> 
                    </div> 

                    <div id="overlayforaddloss" class="overlay"></div>

                    <form:form method="post" id="editLoss">

                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Type Of Work</label> </div>

                            <select id="editworktype"  class="selectpicker" name="WorkType"  data-live-search="true" data-style="btn-white">
                            </select>
                        </div>   
                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Type of Working</label> </div>

                            <select id="editworkingtype"  class="selectpicker" name="workingtype"  data-live-search="true" data-style="btn-white">
                            </select>
                        </div> 
                        <div id="overlayforeditloss" class="overlay"></div>
                        <div class="form-group"> 
                            <div align="center" >
                                <label for="field-3" class="control-label" >Loss</label> </div>

                            <input data-parsley-type="number" id="edit_l_percentage" type="text" class="form-control"  placeholder="Enter only numbers" />
                        </div> 

                        <div class="form-group">
                            <label for="name">Password</label>
                            <input type="password" class="form-control" id="PassForeditLoss"  name="PassForeditLoss" required="true" placeholder="Enter your Password"/>
                        </div>
                        <div id="msgforeditloss" aling="center"></div>
                        <input type="hidden" id="worker_id_foredit" name="worker_id_foredit" value="${worker.worker_Id}">
                        <div align="center"> 
                            <button type="button" class="btn btn-default waves-effect" data-dismiss="modal">Close</button> 
                            <button type="submit" class="btn btn-info waves-effect waves-light">Save changes</button> 
                        </div> 
                    </form:form>
                </div>
            </div> 

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
        <script src="plugins/bootstrap-touchspin/dist/jquery.bootstrap-touchspin.min.js" type="text/javascript"></script>
        <script src="pages/jquery.bs-table.js"></script>
        <script src="plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js"></script>
        <script src="plugins/select2/select2.min.js" type="text/javascript"></script>
        <script src="plugins/bootstrap-select/dist/js/bootstrap-select.min.js" type="text/javascript"></script>
        <script type="text/javascript" src="plugins/multiselect/js/jquery.multi-select.js"></script>   
        <script type="text/javascript" src="pages/AjaxforProfile.js"></script>



        <script type="text/javascript">
            $(document).ready(function () {

                //            $('form').parsley();
                var Gold_price = 20000;
                var dis1 = document.getElementById("Rupees");
                var dis2 = document.getElementById("Gold");
                dis1.onchange = function () {

                    if (this.value != "" || this.value.length > 0) {
                        document.getElementById("Gold").value = document.getElementById("Rupees").value / Gold_price;
                        document.getElementById("Gold").disabled = true;
                    } else {
                        document.getElementById("Gold").disabled = false;
                    }
                }
                dis2.onchange = function () {
                    if (this.value != "" || this.value.length > 0) {
                        document.getElementById("Rupees").value = Gold_price * document.getElementById("Gold").value;
                        document.getElementById("Rupees").disabled = true;
                    } else {
                        document.getElementById("Rupees").disabled = false;
                    }
                }
            });
        </script>

    </body>
</html>