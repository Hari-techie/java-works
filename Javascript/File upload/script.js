function addDocument() {
    let documents = document.getElementById("documents");
    let documentTemplate = document.createElement("div");
    documentTemplate.classList.add("document");

    let typeSelector = document.createElement("select");
    typeSelector.classList.add("document-type");
    let panOption = document.createElement("option");
    panOption.value = "pan";
    panOption.text = "PAN Card";
    typeSelector.appendChild(panOption);
    let aadharOption = document.createElement("option");
    aadharOption.value = "aadhar";
    aadharOption.text = "Aadhar Card";
    typeSelector.appendChild(aadharOption);
    let voterOption = document.createElement("option");
    voterOption.value = "voterid";
    voterOption.text = "Voter ID Card";
    typeSelector.appendChild(voterOption);
    documentTemplate.appendChild(typeSelector);

    let fileInput = document.createElement("input");
    fileInput.type = "file";
    fileInput.classList.add("document-file");
    fileInput.name = "file";
    fileInput.required = true;
    documentTemplate.appendChild(fileInput);

    let removeButton = document.createElement("button");
    removeButton.type = "button";
    removeButton.classList.add("remove-document");
    removeButton.textContent = "Remove";
    removeButton.addEventListener("click", function () { removeDocument(this) });
    documentTemplate.appendChild(removeButton);

    documents.appendChild(documentTemplate);
}

function removeDocument(button) {
    let documentElement = button.parentElement;
    let fileInput = documentElement.querySelector(".document-file");
    fileInput.value = null;
    documentElement.remove();
}

function saveDocument() {
    console.log('save doc');
    let formData = new FormData();
    let nameInput = document.getElementById("name");
    let empIdInput = document.getElementById("empid");
    formData.append('name', nameInput.value);
    formData.append('empid', empIdInput.value);

    let fileInputs = document.querySelectorAll('.document-file');
    fileInputs.forEach(function (fileInput) {
        formData.append('files[]', fileInput.files[0]);
        let typeSelector = fileInput.previousSibling;
        formData.append('types[]', typeSelector.value);
    });

    const uri = "http://localhost:8080/save";// replace with the correct endpoint URL
    let xhr = new XMLHttpRequest();
    xhr.open('POST', uri);
    xhr.onload = function () {
        if (xhr.status === 200) {
            console.log(xhr.responseText);
            alert('Document saved successfully');
            location.reload();
        } else {
            alert('Error while saving document');
        }
    };
    xhr.send(formData);
}