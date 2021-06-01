<%-- 
    Document   : index
    Created on : 17-Mar-2021, 14:22:38
    Author     : Jesus Larez
--%>

<%@page import="java.util.List"%>
<%@page import="entities.*"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <title>Cocktail App Home Page</title>
<div class="p-3 mb-2 bg-primary text-white"> <h1>Cocktail App</h1></div>
</head>
<body> 
    <%
        List<Cocktail> catalog = (List) session.getAttribute("catalog");
        List<Bar> bars = (List) session.getAttribute("bars");
        List<Ingredient> ingredients = (List) session.getAttribute("ingredients");
    %>
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#"></a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-link active" aria-current="page" href="#">Home</a>
                    <a class="nav-link" href="favourite_list.jsp">Favourite Cocktails</a>
                    <a class="nav-link" href="favourite_bar_list.jsp">Favourite Bars</a>
                    <a class="nav-link" href="index.jsp">Log Out</a>
                </div>
            </div>
        </div>
    </nav>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>

    <h2>Search Cocktails</h2>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="FrontController">
                    <label for="ingredientsAlcohol">Choose an Alcohol:</label>
                    <select name="ingredient1" id="ingredients1" aria-label="Default select example" class="form-select">
                        <% %> <option name= any > Any </option> <%
                            for (Ingredient ingredient : ingredients) {
                                if (ingredient.getAlchohol() != null) {

                        %> <option name=<%= ingredient.getName()%> ><%= ingredient.getName()%></option> <%
                                }
                            }
                        %>
                    </select>
                    <label for="ingredients">Choose an ingredient: </label>
                    <select name="ingredient2" id="ingredients2" aria-label="Default select example" class="form-select">
                        <% %> <option name= any > Any </option> <%
                            for (Ingredient ingredient : ingredients) {
                                if (ingredient.getAlchohol() == null) {
                        %> <option name=<%= ingredient.getName()%> ><%= ingredient.getName()%></option> <%
                                }
                            }
                        %>

                    </select> <br>
                    <input type="hidden" name="command" value="CmdSearchCocktail">
                    <input type="hidden" name="start" value="0"> 
                    <input type="submit" value="Search Cocktails" class="btn btn-primary">
                </form>
            </div>
            <div class="col">
            </div>
        </div>
    </div>

    <h2>Search Bars</h2>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="FrontController">
                    <select name="barName" id="barName" aria-label="Default select example" class="form-select">
                        <% %> <option name= any > Any </option> <%
                            for (Bar bar : bars) {
                        %> <option name=<%= bar.getName()%> ><%= bar.getName()%></option> <%

                            }
                        %>
                    </select> <br>
                    <input type="hidden" name="command" value="CmdViewBar">
                    <input type="submit" value="View Bar" class="btn btn-primary">
                </form>
            </div>
            <div class="col">

            </div>
        </div> <br>
    </div>
    <h2>Add New Cocktail</h2>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="FrontController">
                    <label for="name" class="sr-only">Name</label><br>
                    <input type="text" name="name" value=""><br>
                    <label for="description" class="sr-only">Description</label><br>
                    <input type="text" name="description" value=""><br>
                    <label for="recipe" class="sr-only">Recipe</label><br>
                    <input type="text" name="recipe" value=""><br>
                    <input type="hidden" name="command" value="CmdAddCocktail">
                    <input type="submit" value="Add Cocktail" class="btn btn-primary">
                </form>
            </div>
            <div class="col">

            </div>
        </div> <br>
    </div>

    <footer class="bg-light text-center text-lg-start">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2021 Copyright: Cocktails App by Jesus Larez
        </div>
        <!-- Copyright -->
    </footer>

</body>

