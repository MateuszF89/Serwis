<%--
  Created by IntelliJ IDEA.
  User: mateu
  Date: 18.09.2023
  Time: 19:49
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
                    <h2>Stwórz protokół</h2>
                </div>
            </div>
            <hr />
            <form:form action="/serviceProtocol/addProtocol" method="post" modelAttribute="protocolToCreate">
                <div class="form-group">
                    <label for="executionDate">Data wykonania usługi:</label>
                    <form:input type="date" path="executionDate" id="executionDate" class="form-control" style="width: 200px;" required="required"/>
                    <form:errors path="executionDate" element="div" class="error-message" />
                </div>
                <div class="form-group">
                    <label for="description">Opis wykonanych czynności:</label>
                    <form:textarea path="description" id="description" class="form-control" rows="3" required="required"/>
                    <form:errors path="description" element="div" class="error-message" />
                </div>
                <div class="form-group">
                    <label for="comments">Uwagi i zalecenia eksploatacyjne:</label>
                    <form:textarea path="comments" id="comments" class="form-control" rows="3"/>
                    <form:errors path="comments" element="div" class="error-message" />
                </div>
                <div class="form-group">
                    <label for="device">Urządzenie:</label>
                    <form:select path="device.id" id="device" class="form-control" style="width: 200px;" required="required">
                        <form:option value="" label="Wybierz urządzenie" />
                        <form:options items="${deviceList}" itemValue="id" itemLabel="type" />
                    </form:select>
                    <form:errors path="device.id" element="div" class="error-message" />
                </div>
                <div class="form-group">
                    <label for="partsRow">Lista części:</label>
                    <table id="partsListTable" class="table table-bordered table-hover">
                        <thead>
                        <tr>
                            <th>Nazwa</th>
                            <th>Typ</th>
                            <th>Numer indeksu</th>
                            <th>Ilość</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr id="partsRow">
                            <td><input type="text" class="form-control" name="name" /></td>
                            <td><input type="text" class="form-control" name="type" /></td>
                            <td><input type="text" class="form-control" name="indexNumber" /></td>
                            <td><input type="number" class="form-control" name="quantity" /></td>
                        </tr>
                        </tbody>
                    </table>
                    <button type="button" id="addPartsButton" class="btn btn-primary">Dodaj część</button>
                </div>
                <input type="hidden" name="partsList" id="partsList" />
                <input type="hidden" name="protocolId" value="${protocolToCreate.id}" />
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
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        // Przechwycenie przycisku "Dodaj część"
        $("#addPartsButton").click(function () {
            // Pobieramy dane wprowadzone przez użytkownika
            var name = $("input[name='name']").val();
            var type = $("input[name='type']").val();
            var indexNumber = $("input[name='indexNumber']").val();
            var quantity = $("input[name='quantity']").val();

            // Tworzymy obiekt z danymi części
            var newPart = {
                name: name,
                type: type,
                indexNumber: indexNumber,
                quantity: quantity
            };

            // Pobieramy zawartość pola "partsList"
            var partsListInput = $("#partsList");
            var partsList = [];

            if (partsListInput.val()) {
                // Jeśli pole "partsList" nie jest puste, parsujemy je jako JSON
                partsList = JSON.parse(partsListInput.val());
            }

            // Dodajemy nową część do listy
            partsList.push(newPart);

            // Aktualizacja pola "partsList" jako JSON
            partsListInput.val(JSON.stringify(partsList));

            // Tworzymy nowy wiersz w tabeli z danymi części
            var newRow = "<tr><td>" + name + "</td><td>" + type + "</td><td>" + indexNumber + "</td><td>" + quantity + "</td></tr>";

            // Dodajemy wiersz do tabeli
            $("#partsListTable tbody").append(newRow);

            // Czyszczenie pól formularza po dodaniu części
            $("input[name='name']").val("");
            $("input[name='type']").val("");
            $("input[name='indexNumber']").val("");
            $("input[name='quantity']").val("");
        });
    });
</script>
</body>
</html>
