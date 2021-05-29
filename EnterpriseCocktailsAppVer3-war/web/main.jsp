<%-- 
    Document   : index
    Created on : 17-Mar-2021, 14:22:38
    Author     : Jesus Larez
--%>

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

    <%
        /* Ingredients */
        Ingredient arehucas = new Alcohol("Ron Arehucas", AlcoholType.RUM);
        Ingredient smirnoff = new Alcohol("Vodka Smirnoff", AlcoholType.VODKA);
        Ingredient cuervo = new Alcohol("Tequila Jose Cuervo", AlcoholType.TEQUILA);
        Ingredient lemon = new Fruit("Limon");
        Ingredient pineapple = new Fruit("Pina");
        Ingredient orange = new Fruit("Naranja");
        Ingredient mint = new Fruit("Hierva Buena");
        Ingredient pineappleJuice = new SoftDrink("Jugo de Pina");
        Ingredient soda = new SoftDrink("Soda");
        Ingredient coconutJuice = new SoftDrink("Jugo de Coco");

        ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients.add(arehucas);
        ingredients.add(smirnoff);
        ingredients.add(cuervo);
        ingredients.add(lemon);
        ingredients.add(pineapple);
        ingredients.add(orange);
        ingredients.add(mint);
        ingredients.add(pineappleJuice);
        ingredients.add(soda);
        ingredients.add(coconutJuice);

        /* Cocktails */
        Catalog catalog = new Catalog();

        Cocktail mojito = new Cocktail("Mojito Cubano", new ArrayList<Ingredient>(Arrays.asList(arehucas, lemon, soda, mint)), "Es un mojito que es cubano");
        catalog.addCocktail(mojito);
        Cocktail pinaColada = new Cocktail("Pina Colada", new ArrayList<Ingredient>(Arrays.asList(arehucas, pineappleJuice, coconutJuice)), "if you like pina coladas");
        catalog.addCocktail(pinaColada);

        /*Recipes */
        mojito.setRecipe("2 cucharaditas de azúcar blanco. <br> 8 hojas de hierbabuena (2 ramitas de menta) <br> 30 ml de zumo de lima. <br> 60 ml. de ron cubano <br> 1/2 lima en rodajas o cuartos. <br> 120 ml. de Soda (Agua con gas con sifón) <br> Hielo picado");
        pinaColada.setRecipe("100 ml de ron blanco. También puedes omitir el alcohol. <br> 250 ml de zumo de piña. <br> 150 ml de leche de coco. <br> Cubitos de hielo, cantidad al gusto. <br> Unas rodajitas de piña natural para decorar.");

        /*Bares*/
        Bar theBar = new Bar("The Bar", "Calle 2, Numero 56. Las Palmas", null);
        BarMenu theBarMenu = new BarMenu(theBar);
        theBarMenu.addCocktail(mojito);
        theBar.setMenu(theBarMenu);

        Bar cocktailmania = new Bar("CocktailMania", "Calle 24, Numero 5. Las Palmas", null);
        BarMenu cocktailmaniaMenu = new BarMenu(cocktailmania);
        cocktailmaniaMenu.addCocktail(pinaColada);
        cocktailmania.setMenu(cocktailmaniaMenu);

        Bar purplebar = new Bar("Purple Bar", "Calle 13, Numero 9. Las Palmas", null);
        BarMenu purplebarMenu = new BarMenu(purplebar);
        purplebarMenu.addCocktail(pinaColada);
        purplebarMenu.addCocktail(mojito);
        purplebar.setMenu(purplebarMenu);

        ArrayList<Bar> barList = new ArrayList<Bar>();
        barList.add(theBar);
        barList.add(cocktailmania);
        barList.add(purplebar);
        /*Save in session*/
        session.setAttribute("catalog", catalog);
        session.setAttribute("barList", barList);
        session.setAttribute("ingredients", ingredients);

    %> 



    <h2>Search Cocktails</h2>
    <div class="container">
        <div class="row">
            <div class="col">
                <form action="FrontController">
                    <label for="ingredientsAlcohol">Choose an Alcohol:</label>
                    <select name="ingredient1" id="ingredients1" aria-label="Default select example" class="form-select">
                        <% %> <option name= any > Any </option> <%                            for (Ingredient ingredient : ingredients) {
                                if (ingredient.getClass() == Alcohol.class) {
                        %> <option name=<%= ingredient.getName()%> ><%= ingredient.getName()%></option> <%
                                }
                            }
                        %>
                    </select>
                    <label for="ingredientsSoftdrink">Choose a Soft Drink:</label>
                    <select name="ingredient2" id="ingredients2" aria-label="Default select example" class="form-select">

                        <%  %> <option name= any > Any </option> <%
                            for (Ingredient ingredient : ingredients) {
                                if (ingredient.getClass() == SoftDrink.class) {
                        %> <option name=<%= ingredient.getName()%> ><%= ingredient.getName()%></option> <%
                                }
                            }
                        %>
                    </select>
                    <label for="ingredientsFruit">Choose a fruit: </label>
                    <select name="ingredient3" id="ingredients3" aria-label="Default select example" class="form-select">
                        <% %> <option name= any > Any </option> <%
                            for (Ingredient ingredient : ingredients) {
                                if (ingredient.getClass() == Fruit.class) {
                        %> <option name=<%= ingredient.getName()%> ><%= ingredient.getName()%></option> <%
                                }
                            }
                        %>

                    </select> <br>
                    <input type="hidden" name="command" value="CmdSearchCocktail">
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
                            for (Bar bar : barList) {

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

    <footer class="bg-light text-center text-lg-start">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color: rgba(0, 0, 0, 0.2);">
            © 2021 Copyright: Cocktails App by Jesus Larez
        </div>
        <!-- Copyright -->
    </footer>

</body>

