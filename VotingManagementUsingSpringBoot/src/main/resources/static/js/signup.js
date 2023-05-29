const uri = "http://localhost:8080/voters";
let voters = [];
let updateIndex = 0;

function addItem() {
  const item = {
    name: document.getElementById("name").value,
    gender: document.querySelector('input[name="gender"]:checked').value,
    voter_id: document.getElementById("voter_id").value,
    age: document.getElementById("age").value,
    ward: document.getElementById("ward").value,
    email: document.getElementById("email").value,
    password: document.getElementById("password").value,
  };

  var xhttp = new XMLHttpRequest();
  xhttp.open("POST", uri, true);
  xhttp.setRequestHeader("Content-type", "application/json");
  xhttp.send(JSON.stringify(item));
  xhttp.onreadystatechange = function () {
    if (this.readyState == 4 && this.status == 200) {
      window.location.replace("http://localhost:8080/login");
    }
  };
}