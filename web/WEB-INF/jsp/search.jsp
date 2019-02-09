<%-- 
    Document   : search
    Created on : 11.06.2017, 23:06:01
    Author     : swa
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

</script>
    </head>
    <body>

        <jsp:include page="header.jsp"></jsp:include>

            <div class="container">
                <div class="row">
                <spring:url value="/recipe/search" var="formURL"/>     
                <form:form action="${formURL}" 
                           method="post"  cssClass="col-md-8 col-md-offset-2">

                           <table class="table table-hover">
                        <tbody>
                            <tr>
                                <th>Выбор</th><th>Значение</th>
                            </tr>
                            <c:forEach items="${ingredients}" var="ingr">
                                <tr>
                                    <td><input type="checkbox" value="${ingr.description}" name="check[]"></td>
                                    <td>${ingr.description}</td>              
                                </tr>            
                            </c:forEach>

                        </tbody>
                    </table>

                    <button type="submit" class="btn btn-default">Найти рецепты</button>
                </form:form>

            </div>
        </div>
    </body>
</html>
