<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Каталог рецептов</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
        <link rel="stylesheet" href="<spring:url value="/resources/css/bootstrap-select.min.css"/>" type="text/css"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
        <script src="<spring:url value="/resources/js/bootstrap-select.min.js"/>"></script>
        <script src="http://code.jquery.com/jquery-1.11.0.js"></script>
        <style>
            div.edit{
                display: none;
            }
        </style>
        <script type="text/javascript">

            function addField() {
                $("tbody.list").append('<tr><td><input type="text" name="ingr[]" value="Соль"></td><td><input type="number" name="quantity[]" value="1"></td><td><input type="string" name="unit[]" value="кг"></td></tr>');
            }
            function addFieldProcedure() {
                $("div.listProcedure").append('<input type="text" name="proc[]" value="Съесть"><br/>');
            }
            function chose() {
                $("div.edit").css("display", "block");
                $("div.info").css("display", "none")
            }
            function reverseChose() {
                $("div.edit").css("display", "none");
                $("div.info").css("display", "block")
            }

        </script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                    <div class="info">

                        <div class="form-group">
                            <label for="id">ID</label>
                            <span>${Recipe.id}</span>
                    </div>

                    <div class="form-group">
                        <label for="name">Название</label>
                        <span>${Recipe.name}</span>
                    </div>
                    <div class="form-group">
                        <label for="ingr">Ингридиенты</label>
                        <table class="table table-hover">
                            <tbody>
                                <tr>
                                    <th>Ингридиент</th><th>Количество</th><th>Единица измерения</th>
                                </tr>
                                <c:forEach items="${Recipe.ingridients}" var="ingr">
                                    <tr>
                                        <td>
                                            ${ingr.ingredient.description}
                                        </td>
                                        <td>${ingr.quantity}</td>    
                                        <td>${ingr.unit.unit}</td>
                                    </tr>            
                                </c:forEach>

                            </tbody>
                        </table>
                    </div>

                    <div class="form-group">
                        <label for="proc">Процедура приготовления</label>
                        <span><c:forEach items="${Recipe.procedure}" var="cooking">
                                ${cooking.procedure}<br/>
                            </c:forEach></span>

                    </div>
                </div>
                <spring:url value="/recipe/delete" var="delURL"/>     
                <form:form action="${delURL}" 
                           method="post"  cssClass="col-md-8 col-md-offset-2"
                           >
                    <div class="edit">
                        <div class="form-group">
                            <label for="name">Название</label>
                            <input type="text" name="name" value="${Recipe.name}"> 

                        </div>
                        <div class="form-group">
                            <label for="ingridients">Ингридиенты</label>

                            <table class="table table-hover">
                                <tbody class="list">
                                
                                    <tr>
                                        <th>Ингридиент</th><th>Количество</th><th>Единица измерения</th>
                                    </tr>

                                    <c:forEach items="${Recipe.ingridients}" var="ingr">
                                    
                                        <tr>
                                            <td>
                                                <input type="text" name="ingr[]" value="${ingr.ingredient.description}">  
                                            </td>
                                            <td><input type="number" name="quantity[]" value="${ingr.quantity}"></td>    
                                            <td><input type="string" name="unit[]" value="${ingr.unit.unit}"></td>

                                        </tr>  
                                    </c:forEach>
                               
                           
 </tbody>
                            </table>
<input type="button" value="Добавить ингредиент" onclick="addField()">
                        </div>
                        <div class="form-group">
                            <label for="proc">Процедура приготовления</label>
                            <div class="form-group">
                                <span>
                                    <div class="listProcedure">
                                        <c:forEach items="${Recipe.procedure}" var="cooking">
                                            <input type="text" name="proc[]" value="${cooking.procedure}"><br/>
                                        </c:forEach>
                                    </div>
                                </span>
                                <input type="button" value="Добавить поле" onclick="addFieldProcedure()">
                            </div>







                        </div>


                    </div>


                    <div class="form-group">
                        <input type="radio" name="act" value="no" checked onclick="reverseChose()"> Перейти на главную<br/>
                        <input type="radio" name="act" value="edit" onclick="chose()"> Изменить рецепт<br/>
                        <input type="radio" name="act" value="delete" onclick="reverseChose()"> Удалить рецепт<br/>
                        <input type="hidden" name="id" value="${Recipe.id}">
                    </div>

                    <button type="submit" class="btn btn-default">Подтвердить</button>

                </form:form>

            </div>
    </body></div>
</html>