
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

		<link rel="shortcut icon" href="assets/images/favicon_1.ico">

		<title>Ubold - Responsive Admin Dashboard Template</title>

	<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <link href="css/core.css" rel="stylesheet" type="text/css" />
        <link href="css/components.css" rel="stylesheet" type="text/css" />
        <link href="css/icons.css" rel="stylesheet" type="text/css" />
        <link href="css/pages.css" rel="stylesheet" type="text/css" />
        <link href="css/responsive.css" rel="stylesheet" type="text/css" />

        <!-- HTML5 Shiv and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
        <![endif]-->

        <script src="js/modernizr.min.js"></script>

	</head>
	<body>

		<div class="account-pages"></div>
		<div class="clearfix"></div>
		<div class="wrapper-page">
			<div class=" card-box">
				<div class="panel-heading">
					<h3 class="text-center"> Sign Up to <strong class="text-custom">UBold</strong> </h3>
				</div>

				<div class="panel-body">
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
					 <form:form action="userregistration.htm" method="post" class="form-horizontal m-t-20" commandName="RegistrationDetails" enctype="multipart/form-data"> 
                                                 <div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="text" name="Name" required="" placeholder="Name">
							</div>
						</div>
						<div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="email" name="Email" required="" placeholder="Email">
							</div>
						</div>

						<div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="text" name="Username" required="" placeholder="Username">
							</div>
						</div>
                                                 <div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="text" name="Phone" required="" placeholder="Phone">
							</div>
						</div>
                                                 <div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="text" name="ADDRESS" required="" placeholder="ADDRESS">
							</div>
						</div>
                                                 <div class="form-group ">
							<div class="col-xs-12">
								<input class="form-control" type="text" name="ADHAR" required="" placeholder="ADHAR">
							</div>
						</div>
                                                 

						<div class="form-group">
							<div class="col-xs-12">
								<input class="form-control" type="password" name="Password" required="" placeholder="Password">
							</div>
						</div>

						<div class="form-group">
                                                
                                                <div class="col-xs-12">
                                                    <form:input type="file"  path="filedata"  id="image" class="filestyle" data-buttonbefore="true"/>                                 
                                                </div>
                                            </div>

						<div class="form-group text-center m-t-40">
							<div class="col-xs-12">
								<button class="btn btn-pink btn-block text-uppercase waves-effect waves-light" type="submit">
									Register
								</button>
							</div>
						</div>

					</form:form>

				</div>
			</div>

			<div class="row">
				<div class="col-sm-12 text-center">
					<p>
						Already have account?<a href="page-login.html" class="text-primary m-l-5"><b>Sign In</b></a>
					</p>
				</div>
			</div>

		</div>

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

	</body>
</html>
