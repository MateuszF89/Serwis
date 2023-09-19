<%--
  Created by IntelliJ IDEA.
  User: mateu
  Date: 18.09.2023
  Time: 08:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Free Bootstrap Admin Template : Two Page</title>
    <!-- BOOTSTRAP STYLES-->
    <link href="/css/bootstrap.css" rel="stylesheet" />
    <!-- FONTAWESOME STYLES-->
    <link href="/css/font-awesome.css" rel="stylesheet" />
    <!-- CUSTOM STYLES-->
    <link href="/css/custom.css" rel="stylesheet" />
    <!-- GOOGLE FONTS-->
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
</head>
<body>
<div id="wrapper">
    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="adjust-nav">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" ></i> SERWIS </a>
            </div>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">O aplikacji</a></li>
                    <li><a href="#">Kontakt</a></li>
                </ul>
            </div>
        </div>
    </div>
    <!-- /. NAV TOP  -->
    <nav class="navbar-default navbar-side" role="navigation">
        <div class="sidebar-collapse">
            <ul class="nav" id="main-menu">
                <li class="text-center user-image-back" style="background-color: white">
                    <img src="/img/find_user.png" class="img-responsive" />
                </li>
                <li>
                    <a href="index.html"><i class="fa fa-desktop "></i>Pulpit</a>
                </li>
                <li>
                    <a href="#"><i class="fa fa-edit "></i>Magazyn<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/warehouse/stockLevel">Stan Magazynowy</a>
                        </li>
                        <li>
                            <a href="/warehouse/history">Historia</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#"><i class="fa fa-table "></i>Serwis<span class="fa arrow"></span></a>
                    <ul class="nav nav-second-level">
                        <li>
                            <a href="/serviceOrder/listOfOrders">Zamówienia</a>
                        </li>
                        <li>
                            <a href="/servicePlan/listOfPlans">Planowanie</a>
                        </li>
                        <li>
                            <a href="/serviceProtocol/listOfProtocols">Protokoły</a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="/employee/listOfEmployees"><i class="fa fa-edit "></i>Pracownicy</a>
                </li>
                <li>
                    <a href="/client/listOfClients"><i class="fa fa-qrcode "></i>Klienci</a>
                </li>
            </ul>
        </div>
    </nav>
    <!-- /. NAV SIDE  -->
    <div id="page-wrapper">
        <div id="page-inner">
            <div class="row">
                <div class="col-md-12">
                    <h2>Dodaj klienta</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
            <form:form action="/client/addClient" method="post" modelAttribute="client">

                <div class="form-group">
                    <label for="companyName">Nazwa firmy:</label>
                    <form:input type="text" path="companyName" id="companyName" class="form-control" style="width: 200px;" />
                    <form:errors path="companyName" element="div" class="error-message" />
                </div>

                <div class="form-group">
                    <label for="nip">NIP:</label>
                    <form:input type="text" path="nip" id="nip" class="form-control" style="width: 200px;" />
                    <form:errors path="nip" element="div" class="error-message" />
                </div>

                <div class="form-group">
                    <label for="city">Miasto:</label>
                    <form:input type="text" path="city" id="city" class="form-control" style="width: 200px;" />
                    <form:errors path="city" element="div" class="error-message" />
                </div>

                <div class="form-group">
                    <label for="zipCode">Kod pocztowy:</label>
                    <form:input type="text" path="zipCode" id="zipCode" class="form-control" style="width: 200px;" />
                    <form:errors path="zipCode" element="div" class="error-message" />
                </div>

                <div class="form-group">
                    <label for="street">Ulica:</label>
                    <form:input type="text" path="street" id="street" class="form-control" style="width: 200px;" />
                    <form:errors path="street" element="div" class="error-message" />
                </div>

                <button type="submit" class="btn btn-success">Zapisz</button>
            </form:form>
        </div>
        <!-- /. PAGE INNER  -->
    </div>
    <!-- /. PAGE WRAPPER  -->
</div>
<!-- /. WRAPPER  -->
<!-- SCRIPTS - AT THE BOTTOM TO REDUCE THE LOAD TIME-->
<!-- JQUERY SCRIPTS -->
<script src="/js/jquery-1.10.2.js"></script>
<!-- BOOTSTRAP SCRIPTS -->
<script src="/js/bootstrap.min.js"></script>
<!-- METISMENU SCRIPTS -->
<script src="/js/jquery.metisMenu.js"></script>
<!-- CUSTOM SCRIPTS -->
<script src="/js/custom.js"></script>
</body>
</html>
