<%-- 
    Document   : recipe_add
    Created on : 08.06.2017, 6:50:35
    Author     : swa
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Каталог рецептов</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="<spring:url value="/resources/css/home.css"/>" type="text/css"/>
        <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
        <style>
            .form-group span label{
                display: inline;
                font-weight: normal;
                padding: 0px 10px;
            }
            div.hide{
                display: none;
            }
        </style>
        <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
        <script type="text/javascript">

            function addField() {
                $("div.list").append('<input type="text" name="ingr[]" value="Соль">&nbsp; <input type="number" name="quantity[]" value="1">&nbsp;<input type="string" name="unit[]" value="кг"><br/>');
            }
            function addFieldProcedure() {
                $("div.listProcedure").append('<input type="text" name="proc[]" value="Съесть"><br/>');
            }
            function chose() {
                $("div.hide").css("display", "inline");
            }
</script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                <spring:url value="/recipe/add" var="formURL"/>     
                <form:form action="${formURL}" 
                           method="post"  cssClass="col-md-8 col-md-offset-2"
                           modelAttribute="Recipe"
                           >

                    <div class="form-group">
                        <label for="name">Название</label>
                        <form:input id="book-title" 
                                    cssClass="form-control" 
                                    path="name"/>
                        <form:errors path="name"/>
                        
                    </div>
<div class="form-group">
    <label for="ingridients">Ингридиенты</label>
                    <input type="button" value="Добавить ингридиент" onclick="addField()">
                   <!--- или
                    <input type="button" value="Выбрать из списка" onclick="chose()">-->
                    
                        <div class="list">
<input type="text" name="ingr[]" value="Соль">&nbsp; <input type="number" name="quantity[]" value="1">&nbsp;<input type="string" name="unit[]" value="кг"><br/>
                        </div>
                        
                    </div>
                        <div class="form-group">
                            <label for="ingridients">Процедура приготовления</label>
                    <input type="button" value="Добавить поле" onclick="addFieldProcedure()">
                    
                        <div class="listProcedure">
<input type="text" name="proc[]" value="Съесть"><br/>
                        </div>
                    </div>

                    <button type="submit" class="btn btn-default">Добавить рецепт</button>
                </form:form>

            </div>
        </div>
    </body>
</html>