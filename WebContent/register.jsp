<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<head>
 <link rel="stylesheet" href="bootstrap.min.css">
  <script type="text/javascript" src="jquerys.js"></script>
  <script type="text/javascript" src="jquery.validate.min.js"></script>
  <script type="text/javascript" src="bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="row">
<div class="col-sm-8 col-sm-offset-2">
<div class="panel panel-default">
<div class="panel-heading">
<h3 class="panel-title">Fill up the Form</h3>
</div>
<div class="panel-body">
<form action="doRegister" modelAttribute="userBean" id="signupForm1" method="post" class="form-horizontal">
<div class="register">
<div class="form-group">
<label class="col-sm-4 control-label">User name</label>
<div class="col-sm-5">
<input type="text" class="form-control" id="username" name="username" placeholder="User name" />
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Phone no.</label>
<div class="col-sm-5">
<input type="text" class="form-control" id="phone" name="phone" placeholder="phone number" />
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Email</label>
<div class="col-sm-5">
<input type="text" class="form-control" id="email" name="email" placeholder="Email" />
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Address</label>
<div class="col-sm-5">
<input type="text" class="form-control" id="address" name="address" placeholder="Address" />
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Password</label>
<div class="col-sm-5">
<input type="password" class="form-control" id="password" name="password" placeholder="Password" />
</div>
</div>
<div class="form-group">
<label class="col-sm-4 control-label">Confirm password</label>
<div class="col-sm-5">
<input type="password" class="form-control" id="confirm_password" name="confirm_password" placeholder="Confirm password" />
</div>
</div>
<div class="form-group">
<div class="col-sm-5 col-sm-offset-4">
<div class="checkbox">
<label>
<input type="checkbox" id="agree" name="agree" value="agree" />Please agree to our policy
</label>
</div>
</div>
</div>
<div class="form-group">
<div class="col-sm-9 col-sm-offset-4">
<input type="submit" class="btn btn-primary" id="signup1" name="signup1"/>
</div>
</div>
</div>
</form>
</div>
</div>
</div>
</div>
</div>
<script type="text/javascript">
	
		$( document ).ready( function () {
			$( "#signupForm1" ).validate( {
				rules: {
					username: "required",
					phone: "required",
					address: "required",
					username: {
						required: true,
						minlength: 2
					},
					address: {
						required: true,
						minlength: 5
					},
					password: {
						required: true,
						minlength: 5
					},
					confirm_password: {
						required: true,
						minlength: 5,
						equalTo: "#password"
					},
					email: {
						required: true,
						email: true
					},
					agree: "required"
				},
				messages: {
					username: "Please enter your username",
					phone: "Please enter your phone no",
					address: "Please enter address",
					username: {
						required: "Please enter a username",
						minlength: "Your username must consist of at least 2 characters"
					},
					password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long"
					},
					confirm_password: {
						required: "Please provide a password",
						minlength: "Your password must be at least 5 characters long",
						equalTo: "Please enter the same password as above"
					},
					address: {
						required: "Please provide a address",
						minlength: "Your address must be at least 5 characters long"
					},
					email: "Please enter a valid email address",
					agree: "Please accept our policy"
				},
				errorElement: "em",
				errorPlacement: function ( error, element ) {
					// Add the `help-block` class to the error element
					error.addClass( "help-block" );

					// Add `has-feedback` class to the parent div.form-group
					// in order to add icons to inputs
					element.parents( ".col-sm-5" ).addClass( "has-feedback" );

					if ( element.prop( "type" ) === "checkbox" ) {
						error.insertAfter( element.parent( "label" ) );
					} else {
						error.insertAfter( element );
					}

					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !element.next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-remove form-control-feedback'></span>" ).insertAfter( element );
					}
				},
				success: function ( label, element ) {
					// Add the span element, if doesn't exists, and apply the icon classes to it.
					if ( !$( element ).next( "span" )[ 0 ] ) {
						$( "<span class='glyphicon glyphicon-ok form-control-feedback'></span>" ).insertAfter( $( element ) );
					}
				},
				highlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-error" ).removeClass( "has-success" );
					$( element ).next( "span" ).addClass( "glyphicon-remove" ).removeClass( "glyphicon-ok" );
				},
				unhighlight: function ( element, errorClass, validClass ) {
					$( element ).parents( ".col-sm-5" ).addClass( "has-success" ).removeClass( "has-error" );
					$( element ).next( "span" ).addClass( "glyphicon-ok" ).removeClass( "glyphicon-remove" );
				}
			} );
		} );
	</script>
</body>
</html>
