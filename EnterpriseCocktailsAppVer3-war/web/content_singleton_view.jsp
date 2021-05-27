<%-- 
    Document   : content_singleton_view
    Created on : 27-Apr-2021, 02:09:04
    Author     : Jesus Larez
--%>

<%@page import="entities.FavouriteCocktailsRemote"%>
<%@page import="entities.FavouriteBarsRemote"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

        <title>Content Singleton</title>
    <div class="p-3 mb-2 bg-primary text-white"> <h1>Cocktail App</h1></div>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link" href="index.jsp">Home</a>
                    <a class="nav-link" href="favourite_list.jsp">Favourite Cocktails</a>
                    <a class="nav-link" href="favourite_bar_list.jsp">Favourite Bars</a>
                    <form action="FrontController">
                        <input type="hidden" name="command" value="CmdViewLog">
                        <input type="submit" value="Log View" class="nav-link">
                    </form>
                    <form action="FrontController">
                        <input type="hidden" name="command" value="CmdViewStats">
                        <input type="submit" value="Stats View" class="nav-link">
                    </form>
                    <a class="nav-link" href="timer.jsp">Timer</a>
                </div>
            </div>
        </div>
    </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <h1>This Singleton Contains links to All Stateful Beans created</h1>
    <%
        ArrayList<FavouriteBarsRemote> bars = (ArrayList<FavouriteBarsRemote>)session.getAttribute("FavBars");
        ArrayList<FavouriteCocktailsRemote> cocktails = (ArrayList<FavouriteCocktailsRemote>) session.getAttribute("FavCocktails");
    %>
    <footer class="bg-light text-center text-lg-start">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2021 Copyright: Cocktails App by Jesus Larez
        </div>
        <!-- Copyright -->
    </footer>
</body>
</html>