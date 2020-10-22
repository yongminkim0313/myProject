<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Coming Soon - Start Bootstrap Theme</title>
</head>
<body>
	<div class="masthead">
		<div class="masthead-bg"></div>
		<div class="container h-100">
			<div class="row h-100">
				<div class="col-12 my-auto">
					<div class="masthead-content text-white py-5 py-md-0">
						<h1 class="mb-3">Welcome Rich!!</h1>
						<p class="mb-5">
							We will help you manage your assets more efficiently. Let's be <strong>rich</strong> in 2020 with lots of wealth.
						</p>
						<form action="/logout" method="post" id="frm" name="frm">
							<input type="submit" value="LOGOUT!!" />
							<sec:csrfInput />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>