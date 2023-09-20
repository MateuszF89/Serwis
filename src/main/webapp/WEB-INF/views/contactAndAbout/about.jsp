<%--
  Created by IntelliJ IDEA.
  User: mateu
  Date: 20.09.2023
  Time: 09:16
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
                    <li><a href="/about/">O aplikacji</a></li>
                    <li><a href="/contact/">Kontakt</a></li>
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
                    <a href="/dashboard/"><i class="fa fa-desktop "></i>Pulpit</a>
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
                    <h2>O aplikacji</h2>
                </div>
            </div>
            <!-- /. ROW  -->
            <br />
            <!-- /. ROW  -->
            <div class="row">
                <div class="col-md-12">
                    <p>Aplikacja została wykonana jako projekt końcowy kursu Java Developer w szkole IT Coders Lab. Aplikacja może zostać wykorzystywana do wspomagania prowadzenia działalności serwisu sprężarek lub innego typu serwisu i została opracowana na podstawie realnych danych.</p>
                    <p>Aplikacja posiada następujące funkcjonalności:</p>
                    <ul>
                        <li>Możliwość dodawania, usuwania oraz edycji części w magazynie.</li>
                        <li>Monitoring dostępnych części w magazynie i generowanie powiadomień o niskim stanie magazynowym.</li>
                        <li>Historia wszystkich ruchów części w magazynie, w tym przyjęć i wydań.</li>
                        <li>Dodawanie i edycja pracowników.</li>
                        <li>Lista pracowników.</li>
                        <li>Planowanie pracy pracowników.</li>
                        <li>Lista pracowników.</li>
                        <li>Dodawanie i edycja klientów.</li>
                        <li>Lista klientów.</li>
                        <li>Możliwość dodania i edycji urządzeń posiadanych przez klienta.</li>
                        <li>Dodawanie i usuwanie listy zamówień serwisowych.</li>
                        <li>Lista zamówień serwisowych.</li>
                        <li>Planowanie usług serwisowych z wyznaczeniem pracownika.</li>
                        <li>Tworzenie protokołu z wykonanej usługi serwisowej.</li>
                        <li>Lista protokołów.</li>
                        <li>Szczegóły protokołu.</li>
                        <li>Generowanie protokołu w PDF za pomocą zewnętrznego API.</li>
                    </ul>
                </div>
            </div>
            <!-- /. ROW  -->
            <hr />
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
