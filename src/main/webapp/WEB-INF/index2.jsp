<%@ page import="fr.cmfp.tpgestionlistecourse.bo.Listes" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
<title>Title</title>
</head>
<body>
<header>
    <div class="title">
        <h1>Courses</h1>
    </div>
    <div class="soustittle">
        <h2>Liste prédéfinies</h2>
    </div>
</header>
<main>

    <%
        ArrayList<Listes> tableauListe = (ArrayList<Listes>) request.getAttribute("liste");

    %>
    <%
        if (tableauListe != null) {
            for (Listes articles : tableauListe) {
    %>
    <div class="listedefinie">
        <div>
            <p><%= articles.getNomListe() %>
            </p>
        </div>
        <div class="iconelistedefinie">
            <a href=""><img src="media/img/achats.png" alt="image d'un caddie" class="icone"></a>
            <a href="Effacer?"><img src="media/img/signe-de-la-croix.png" alt="croix sur un fond noir"
                                    class="icone"></a>
        </div>
    </div>
    <%
        }
    %>
    <%
        }
    %>


</main>
<footer>
    <div class="btnBottom">
        <a href="Ajouter"><img src="media/img/add.png" alt="bouton plus sur fond noir" class="icone"></a>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
        crossorigin="anonymous"></script>
</body>
</body>
</html>
