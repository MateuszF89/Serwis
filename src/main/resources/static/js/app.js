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
        var newRow = "<tr><td>" + name + "</td><td>" + type + "</td><td>" + indexNumber + "</td><td>" + quantity + "</td><td><button class='removePartButton'>Usuń część</button></td></tr>";

        // Dodajemy wiersz do tabeli
        var $newRow = $(newRow);
        $("#partsListTable tbody").append($newRow);

        // Czyszczenie pól formularza po dodaniu części
        $("input[name='name']").val("");
        $("input[name='type']").val("");
        $("input[name='indexNumber']").val("");
        $("input[name='quantity']").val("");

        // Dodajemy obsługę przycisku "Usuń część" tylko dla nowo dodanego wiersza
        $newRow.find(".removePartButton").click(function () {
            // Pobieramy dane części z wiersza
            var nameToRemove = $newRow.find("td:eq(0)").text(); // Pobierz nazwę części (pierwsza kolumna)

            // Szukamy i usuwamy część z listy na podstawie jej nazwy
            for (var i = 0; i < partsList.length; i++) {
                if (partsList[i].name === nameToRemove) {
                    partsList.splice(i, 1); // Usuwamy znalezioną część
                    break; // Przerywamy pętlę, gdy część zostanie znaleziona i usunięta
                }
            }

            // Aktualizacja pola "partsList" jako JSON
            partsListInput.val(JSON.stringify(partsList));

            // Usuwamy wiersz z tabeli
            $newRow.remove();
        });
    });
});