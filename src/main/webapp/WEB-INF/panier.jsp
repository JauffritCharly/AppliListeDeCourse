<%@ page import="fr.cmfp.tpgestionlistecourse.bo.Articles" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Adrien
  Date: 05/07/2022
  Time: 08:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    <link rel="stylesheet" href="styles.css">
    <title>Document</title>
</head>
<body>
<header>
    <div class="title">
        <h1>Courses</h1>
    </div>
    <div class="soustittle">
        <h2>Votre panier</h2>

    </div>
</header>
<main>
    <fieldset class="champs">
        <legend>
            <%= request.getAttribute("nomListe") %>
        </legend>
        <%
            ArrayList<Articles> afficherArticles = (ArrayList<Articles>) request.getAttribute("article");

        %>
        <%
            if (afficherArticles != null) {
                for (Articles articles : afficherArticles) {
        %>
        <div class="listeArticle"><input type="checkbox" name="nom" id="nom">
            <label for="nom"><%= articles.getNomArticles() %>
            </label>
        </div>
        <%
            }
        %>
        <%
            }
        %>

    </fieldset>
</main>
<footer>
    <div class="button">
        <div>
            <a href="Index2Servlet"><img src="media/img/fleche%20gauche.png" alt="fleche retour" class="icone"></a>
        </div>
        <div>
            <a href="Ajouter?"><img src="media/img/rubber.png" alt="gomme pour effacer" class="icone"></a>
        </div>
    </div>
</footer>


</body>
</html>
