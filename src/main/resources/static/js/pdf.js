document.addEventListener('DOMContentLoaded', function () {
    // Znajdź przycisk "Generuj PDF" po jego id
    const generatePdfButton = document.getElementById('generate-pdf-button');

    // Dodaj nasłuchiwanie na kliknięcie przycisku "Generuj PDF"
    generatePdfButton.addEventListener('click', function () {
        // Pobierz dane z formularza HTML
        const companyName = document.getElementById("company-name-td").textContent;
        const nip = document.getElementById("nip-td").textContent;
        const city = document.getElementById("city-td").textContent;
        const zipCode = document.getElementById("zipCode-td").textContent;
        const street = document.getElementById("street-td").textContent;
        const executionDate = document.getElementById("executionDate-td").textContent;
        const serviceType = document.getElementById("serviceType-td").textContent;
        const nameAndSurname = document.getElementById("nameAdnSurname-td").textContent;
        const descriptions = document.getElementById("descriptions-td").textContent;
        const comments = document.getElementById("comments-td").textContent;
        const type = document.getElementById("type-td").textContent;
        const serialNumber = document.getElementById("serialNumber").textContent;
        const yearOfManufacture = document.getElementById("yearOfManufacture").textContent;

        // Pobierz dane dotyczące części z listy
        const partsList = Array.from(document.querySelectorAll("#parts-list li")).map(partElement => ({
            name: partElement.getAttribute("data-name"),
            type: partElement.getAttribute("data-type"),
            indexNumber: partElement.getAttribute("data-index"),
            quantity: parseInt(partElement.getAttribute("data-quantity")) || 0 // Upewnij się, że quantity jest liczbą całkowitą
        }));

        // Utwórz obiekt z danymi
        const requestData = {
            data: {
                companyName,
                nip,
                city,
                zipCode,
                street,
                executionDate,
                serviceType,
                nameAndSurname,
                descriptions,
                comments,
                type,
                serialNumber,
                yearOfManufacture,
                listOfParts: partsList,
            },
            template_id: "40877b238a7503c2",
            export_type: "json",
            expiration: 60,
            output_file: "output.pdf",
            is_cmyk: false,
            image_resample_res: 600,
            direct_download: 0,
            cloud_storage: 1
        };

        // Wykonaj żądanie AJAX do CraftMyPDF API
        const xhr = new XMLHttpRequest();
        xhr.open('POST', 'https://api.craftmypdf.com/v1/create', true);
        xhr.setRequestHeader('Content-Type', 'application/json');
        xhr.setRequestHeader('X-API-KEY', '1812NjUxNTo2NTM4OmZjb211WEJsWjhkUXkxRno');

        xhr.onreadystatechange = function () {
            if (xhr.readyState === 4) {
                if (xhr.status === 200) {
                    // Otrzymano odpowiedź od CraftMyPDF API
                    const response = JSON.parse(xhr.responseText);
                    const pdfUrl = response.file;

                    // Przekieruj użytkownika na wygenerowany plik PDF
                    window.open(pdfUrl, '_blank'); // Otwórz w nowym oknie/nowej karcie
                } else {
                    // Obsłuż błąd, jeśli wystąpił
                    console.error('Błąd podczas generowania PDF:', xhr.statusText);
                }
            }
        };

        // Wyślij żądanie z danymi do generowania PDF
        xhr.send(JSON.stringify(requestData));
    });
});
