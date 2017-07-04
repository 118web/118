<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>Register</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="description" content="Expand, contract, animate forms with jQuery wihtout leaving the page" />
        <meta name="keywords" content="expand, form, css3, jquery, animate, width, height, adapt, unobtrusive javascript"/>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<link rel="shortcut icon" href="../favicon.ico" type="image/x-icon"/>
        <link rel="stylesheet" type="text/css" href="css/style1.css" />
		<link rel="stylesheet" href="css/style.css">

    </head>
    <body>
    
		<div class="wrapper">
			<div class="sky">
				<div class="clouds_one"></div>
				<div class="clouds_two"></div>
				<div class="clouds_three"></div>
			</div>
			<div class="content">
					<div class="form_wrapper">	
					<form class="register active" action="regist.action" method="post">
					
						<h3>Regist</h3>
						<s:actionerror/>
						<div>
							<label>Username:</label>
							<input type="text" name="user.username"/>
							<span class="error">This is an error</span>
						</div>
						<div>
							<label>Password: </label>
							<input type="password" name="user.password"  />
							<span class="error">This is an error</span>
						</div>
						<div>
							<label>Confirm Password: </label>
							<input name="password2" type="password" />
							<span class="error">This is an error</span>						
						</div>
						<div class="bottom">
						
							<input type="submit" value="Regist" ></input>
							<a href="regist.jsp" rel="regist" class="linkform">You don't have an account? Register in here</a>
						
							<div class="clear"></div>
						</div>
					</form>
				</div>	
		</div>
</div>
		<!-- The JavaScript -->
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript">
			$(function() {
					//the form wrapper (includes all forms)
				var $form_wrapper	= $('#form_wrapper'),
					//the current form is the one with class active
					$currentForm	= $form_wrapper.children('form.active'),
					//the change form links
					$linkform		= $form_wrapper.find('.linkform');
						
				//get width and height of each form and store them for later						
				$form_wrapper.children('form').each(function(i){
					var $theForm	= $(this<div id="form_wrapper" class="form_wrapper">);
					//solve the inline display none problem when using fadeIn fadeOut
					if(!$theForm.hasClass('active'))
						$theForm.hide();
					$theForm.data({
						width	: $theForm.width(),
						height	: $theForm.height()
					});
				});
				
				//set width and height of wrapper (same of current form)
				setWrapperWidth();
				
				/*
				clicking a link (change form event) in the form
				makes the current form hide.
				The wrapper animates its width and height to the 
				width and height of the new current form.
				After the animation, the new form is shown
				*/
				$linkform.bind('click',function(e){
					var $link	= $(this);
					var target	= $link.attr('rel');
					$currentForm.fadeOut(400,function(){
						//remove class active from current form
						$currentForm.removeClass('active');
						//new current form
						$currentForm= $form_wrapper.children('form.'+target);
						//animate the wrapper
						$form_wrapper.stop()
									 .animate({
										width	: $currentForm.data('width') + 'px',
										height	: $currentForm.data('height') + 'px'
									 },500,function(){
										//new form gets class active
										$currentForm.addClass('active');
										//show the new form
										$currentForm.fadeIn(400);
									 });
					});
					e.preventDefault();
				});
				
				function setWrapperWidth(){
					$form_wrapper.css({
						width	: $currentForm.data('width') + 'px',
						height	: $currentForm.data('height') + 'px'
					});
				}
				
				/*
				for the demo we disabled the submit buttons
				if you submit the form, you need to check the 
				which form was submited, and give the class active 
				to the form you want to show
				*/
				$form_wrapper.find('input[type="submit"]')
							 .click(function(e){
								e.preventDefault();
							 });	
			});
        </script>
    </body>
</html>