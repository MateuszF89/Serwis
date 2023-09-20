<%--
  Created by IntelliJ IDEA.
  User: mateu
  Date: 19.09.2023
  Time: 20:46
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
                    <h2>Szczegóły protokołu</h2>
                </div>
            </div>
            <br />
            <div class="row">
                <div class="col-md-12">
                    <table class="table table-striped table-bordered table-hover">
                        <tbody>
                        <tr>
                            <th>Nazwa firmy</th>
                            <td id="company-name-td"> ${protocolToShow.serviceOrder.client.companyName}</td>
                        </tr>
                        <tr>
                            <th>NIP</th>
                            <td id="nip-td"> ${protocolToShow.serviceOrder.client.nip}</td>
                        </tr>
                        <tr>
                            <th>Miasto</th>
                            <td id="city-td"> ${protocolToShow.serviceOrder.client.city}</td>
                        </tr>
                        <tr>
                            <th>Kod pocztowy</th>
                            <td id="zipCode-td"> ${protocolToShow.serviceOrder.client.zipCode}</td>
                        </tr>
                        <tr>
                            <th>Ulica</th>
                            <td id="street-td"> ${protocolToShow.serviceOrder.client.street}</td>
                        </tr>
                        <tr>
                            <th>Data wykonania usługi</th>
                            <td id="executionDate-td"> ${protocolToShow.executionDate}</td>
                        </tr>
                        <tr>
                            <th>Rodzaj usługi</th>
                            <td id="serviceType-td">${protocolToShow.serviceOrder.typeOfService}</td>
                        </tr>

                        <tr>
                            <th>Imię i nazwisko pracownika wykonującego usługę</th>
                            <td id="nameAdnSurname-td">${protocolToShow.employee.firstName} ${protocolToShow.employee.lastName}</td>
                        </tr>
                        <tr>
                            <th>Opis wykonanych czynności</th>
                            <td id="descriptions-td">${protocolToShow.description}</td>
                        </tr>
                        <tr>
                            <th>Uwagi i zalecenia eksploatacyjne</th>
                            <td id="comments-td">${protocolToShow.comments}</td>
                        </tr>
                        <tr>
                            <th>Typ urządzenia</th>
                            <td id="type-td">${protocolToShow.device.type}</td>
                        </tr>
                        <tr>
                            <th>Numer seryjny urządzenia</th>
                            <td id="serialNumber">${protocolToShow.device.serialNumber}</td>
                        </tr>
                        <tr>
                            <th>Rok produkcji urządzenia</th>
                            <td id="yearOfManufacture">${protocolToShow.device.yearOfManufacture}</td>
                        </tr>
                        <tr>
                            <th>Lista wymienionych części</th>
                            <td>
                                <ul id="parts-list">
                                    <c:forEach items="${partsList}" var="part">
                                        <li data-name="${part.name}" data-type="${part.type}" data-index="${part.indexNumber}" data-quantity="${part.quantity}">
                                            Nazwa: ${part.name}, Typ: ${part.type}, Index: ${part.indexNumber}, Ilość: ${part.quantity}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12">
                    <form method="get" action="/serviceProtocol/listOfProtocols" style="display: inline-block;">
                        <button type="submit" class="btn btn-primary">Powrót</button>
                    </form>
                    <button id="generate-pdf-button" class="btn btn-success">Generuj PDF</button>
                </div>
            </div>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="/js/pdf.js"></script>
</body>
</html>
