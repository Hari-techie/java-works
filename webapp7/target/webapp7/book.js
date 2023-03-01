const uri = "http://localhost:9090/books";
let books = [];
let updateIndex = 0;
function getAllBooks() {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function () {
        if (this.readyState == 4 && this.status == 200) {
              _displayItems(JSON.parse(xhttp.responseText));
        }
    };
    xhttp.open("GET", uri, true);
    xhttp.send();
}
function _displayItems(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = "";
    // _displayCount(data.length);
    const button = document.createElement("button");
    data.forEach((item) => {
        let editButton = button.cloneNode(false);
        editButton.innerText = "Edit";
        editButton.setAttribute("onclick", `editItem(${item.id})`);
        let deleteButton = button.cloneNode(false);
        deleteButton.innerText = "Delete";
        deleteButton.setAttribute("onclick", `deleteItem(${item.id})`);
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
function saveORupdateItem() {
    //   document.getElementById("myBtn").innerHTML == "Save"
    //     ? addItem()
    //     : updateItem();
    if (document.getElementById("myBtn").innerHTML == "Save") {
      addItem();
    } else {
      updateItem();
    }
  }
  function addItem() {
    const addNameTextbox = document.getElementById("title");
    const item = { title: document.getElementById("title").value,
    author: document.getElementById("author").value,
    price: document.getElementById("price").value,
    qty: document.getElementById("qty").value,
};
    var xhttp = new XMLHttpRequest();
    xhttp.open("POST", uri, true);
    xhttp.setRequestHeader("Content-type", "application/json");
    xhttp.send(JSON.stringify(item));
  }