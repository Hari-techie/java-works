let books = [];
let updateIndex = 0;
const url="http://localhost:9090/books";
function getAllBooks(url, callback)
{
    var xhr =new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4 && xhr.status === 200) 
        { 
            callback(xhr.responseText);
        }
    };
    xhr.open("GET", url, true);
    xhr.send();
}
 function handleResponse(responseText) 
{ 
    _displayItems(JSON.parse(responseText));
    console.log("The response is: " + responseText); 
} 
getAllBooks("http://localhost:9090/books", handleResponse);
function saveORupdateItem() {
    document.getElementById("myBtn").innerHTML == "Save"? addItem(): updateItem();
}
function addItem() {
    console.log("add Item called");
    let newBook = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value,
        qty: document.getElementById("qty").value    }
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(newBook));
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getAllBooks("http://localhost:9090/books", handleResponse);
        }
    }
}
function edit(id) {
    document.getElementById("myBtn").innerHTML = "Update";
    const item = books.find((item) => item.id === id);
    document.getElementById("title").value = item.title;
    document.getElementById("author").value = item.author;
    document.getElementById("price").value = item.price;
    document.getElementById("qty").value = item.qty;
    updateIndex = id;
}
function updateItem() {
    const item = {
        id: updateIndex,
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value,
        qty: document.getElementById("qty").value    };
    var xhttp = new XMLHttpRequest();
    xhttp.open("PUT", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(item));
    document.getElementById("myBtn").innerHTML = "Save";
    document.getElementById("title").value = "";
    document.getElementById("author").value = "";
    document.getElementById("price").value = "";
    document.getElementById("qty").value = "";
    updateIndex = 0;
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getAllBooks("http://localhost:9090/books", handleResponse);
        }
    }
}
function del(id) {
    const item = {
        id: id,
        title: null,
        author: null,
        price: 0.0,
        qty: 1    };
    var xhttp = new XMLHttpRequest();
    xhttp.open("DELETE", url, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(item));
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
            getAllBooks("http://localhost:9090/books", handleResponse);
        }
    }
}
function _displayItems(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = ""; 
    const button = document.createElement("button");
    data.forEach((item) => {
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `edit(${item.id})`);
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `del(${item.id})`);
        let tr = tBody.insertRow();
        let td1 = tr.insertCell(0);
        let id = document.createTextNode(item.id);
        td1.appendChild(id);
        let td2 = tr.insertCell(1);
        let title = document.createTextNode(item.title);
        td2.appendChild(title);
        let td3 = tr.insertCell(2);
        let author = document.createTextNode(item.author);
        td3.appendChild(author);
        let td4 = tr.insertCell(3);
        let price = document.createTextNode(item.price);
        td4.appendChild(price);
        let td5 = tr.insertCell(4);
        let qty = document.createTextNode(item.qty);
        td5.appendChild(qty);
        let td6 = tr.insertCell(5);
        td6.appendChild(editButton);
        let td7 = tr.insertCell(6);
        td7.appendChild(deleteButton);
    });
    books = data;
}