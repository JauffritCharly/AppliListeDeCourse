<%@ page import="fr.cmfp.tpgestionlistecourse.bo.Articles" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="styles.css">
    <title>Ajouter</title>
</head>
<body>
<header>
    <div class="title">
        <h1>Courses</h1>
    </div>
    <div class="soustittle">
        <h2>Nouvelle liste </h2>
    </div>
</header>
<main>
    <form action="Ajouter" method="post">
        <label for="nom">Nom :</label>
        <input type="text" name="nom" id="nom" placeholder="Le nom de votre liste">
        <input type="submit" src="media/img/add.png" name="saisie" class="icone">
    </form>

</main>
<footer>
    <div class="btnBottom">
        <a href="index2.jsp"><img src="media/img/fleche-droite-dans-un-cercle.png" alt="bouton plus sur fond noir"
                                  class="icone"></a>
    </div>
</footer>

</body>
</html>
