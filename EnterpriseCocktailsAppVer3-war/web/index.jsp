<%-- 
    Document   : index
    Created on : 27-May-2021, 15:06:21
    Author     : Jesus Larez
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

        <title>Cocktail App Login Page</title>
    <div class="p-3 mb-2 bg-primary text-white"> <h1>Cocktail App</h1></div>
</head>
<body class="text-center">
    
    <form class="form-signin" action="FrontController">
        <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
        <label for="inputEmail" class="sr-only">User</label>
        <input type="text" id="inputEmail" class="form-control" name="nickname" placeholder="Nickname" autofocus="" value="admin">
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" value="admin">

        <input type="hidden" name="command" value="CmdLogin">

        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>

    </form>

</body>
</html>
