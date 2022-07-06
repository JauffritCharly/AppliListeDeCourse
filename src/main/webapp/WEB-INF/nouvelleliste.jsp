<%@ page import="fr.cmfp.tpgestionlistecourse.bo.Listes" %>
<%@ page import="fr.cmfp.tpgestionlistecourse.bo.Articles" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Stagiaire
  Date: 05/07/2022
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles.css">
    <title>Nouvelle liste</title>
</head>
<body>
<header>
    <div class="title">
        <h1>Courses</h1>
    </div>
    <div class="soustittle">
        <h2>
            <%= request.getAttribute("nom") %>
        </h2>
    </div>
</header>
<main>
    <form action="Ajouterarticle" method="post">
        <input type="hidden" name="cache" value="<%= request.getAttribute("nom") %>">
        <label for="article">Article :</label>
        <input type="text" name="article" id="article">
        <input type="submit" name="saisie" class="icone">
    </form>
    <%
        ArrayList<Articles> afficherArticles = (ArrayList<Articles>) request.getAttribute("article");

    %>
    <%
        if (afficherArticles != null) {
            for (Articles articles : afficherArticles) {
    %>
    <p><%= articles.getNomArticles() %>
    </p>
    <%
        }
    %>
    <%
        }
    %>
</main>
<footer>
    <a href="Index2Servlet"><img src="media/img/fleche-droite-dans-un-cercle.png" alt="fleche vers le menu"
                                 class="icone"></a>

</footer>

</body>
</html>
