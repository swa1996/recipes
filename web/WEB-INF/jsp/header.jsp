<%-- 
    Document   : руфвук
    Created on : 08.06.2017, 2:19:16
    Author     : swa
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-default">
  <div class="container-fluid">

    <div class="navbar-header">
      <a class="navbar-brand" href="<spring:url value="/recipe/findall"/>">Каталог рецептов</a>
    </div>

    <ul class="nav navbar-nav">

      <li><a href="<spring:url value="/"/>">Главная</a></li>

      <li class="dropdown">

        <a href="#" class="dropdown-toggle" 
           data-toggle="dropdown" role="button" 
           aria-expanded="false">Рецепты<span class="caret"></span></a>

        <ul class="dropdown-menu" role="menu">
          <li><a href="<spring:url value="/recipe/add"/>">Добавить новый</a></li>
          <li><a href="<spring:url value="/recipe/findall"/>">Посмотреть все</a></li>
          <li><a href="<spring:url value="/recipe/search"/>">Поиск рецептов</a></li>
        </ul>

      </li>
      <li><a href="<spring:url value="/exit"/>">Выход</a></li>

    </ul>

  </div>
</nav>