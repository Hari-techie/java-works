const uri = "http://localhost:9090/books";
let books = [];
let updateIndex = 0;

function getItems() {
    fetch(uri)
        .then((response) => response.json())
        .then((data) => _displayItems(data))
        .catch((error) => console.error("Unable to get items.", error));
}

function addItem() {
    //const addNameTextbox = document.getElementById("customername");

    const item = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value,
        qty: document.getElementById("qty").value
    };

    fetch(uri, {
        method: "POST",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(item),
    })
        .then(() => {
            getItems();
            //addNameTextbox.value = "";
        });
}

function deleteItem(id) {
    const item = {
        id: id,
        title: null,
        author: null,
        price: 0.0,
        qty: 0
    };

    fetch(uri, {
        method: "DELETE",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(item),
    })
        .then(() => {
            getItems();
        });
}

function editItem(id) {
    document.getElementById("myBtn").innerHTML = "Update";
    const item = books.find((item) => item.id === id);
    document.getElementById("title").value = item.title;
    document.getElementById("author").value = item.author;
    document.getElementById("price").value = item.price;
    document.getElementById("qty").value = item.qty;
    updateIndex = id;
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

function updateItem() {
    const item = {
        title: document.getElementById("title").value,
        author: document.getElementById("author").value,
        price: document.getElementById("price").value,
        qty: document.getElementById("qty").value
    };

    fetch(uri, {
        method: "PUT",
        headers: {
            Accept: "application/json",
            "Content-Type": "application/json",
        },
        body: JSON.stringify(item),
    }).then(() => getItems());
    document.getElementById("myBtn").innerHTML = "Save";
    document.getElementById("title").value = "";
    document.getElementById("author").value = "";
    document.getElementById("price").value = "";
    document.getElementById("qty").value = "";
    updateIndex = 0;
}

function _displayItems(data) {
    const tBody = document.getElementById("books");
    tBody.innerHTML = "";
    // _displayCount(data.length);
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