<%-- 
    Document   : recipes
    Created on : 08.06.2017, 3:57:35
    Author     : swa
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Каталог рецептов</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

  </head>
  <body>

    <jsp:include page="header.jsp"></jsp:include>			

        <div class="container">

          <h2>Все рецепты</h2>
          <table class="table table-hover">
            <tbody>
              <tr>
                  <th>Название</th><th>Ингредиенты</th><th>ID</th>
              </tr>
            <c:forEach items="${recipes}" var="recipe">
                <tr>
                  <td>
                    <a href="<spring:url value="/recipe/?id=${recipe.id}"/>">
                      ${recipe.name}
                    </a>
                  </td>
                  <td><c:forEach items="${recipe.ingridients}" var="ingr">
                      ${ingr.ingredient.description} &nbsp;    
            </c:forEach></td>
                  <td>${recipe.id}</td>        
                </tr>            
            </c:forEach>

          </tbody>
        </table>

    </div>
  </body>
</html>