var countries = ['France',  'Germany', 'England', 'Spain', 'Belgium', 'Italy', 'Portugal', 'Irland', 'Luxembourg'];
var el = document.getElementById('countries');

function count(data)
{
  var el   = document.getElementById('counter');
  var name = 'country';

  if (data) {
    if (data > 1) {
      name = 'countries';
    }
    el.innerHTML = data + ' ' + name ;
  } else {
    el.innerHTML = 'No ' + name;
  }
}

function fetchAll()
{
    var data = '';

    if (countries.length > 0) {
      for (i = 0; i < countries.length; i++) {
        data += '<tr>';
        data += '<td>' + countries[i] + '</td>';
        data += '<td><button onclick="app.Edit(' + i + ')">Edit</button></td>';
        data += '<td><button onclick="app.Delete(' + i + ')">Delete</button></td>';
        data += '</tr>';
        data += '<br>';
      }
    }
   // document.write(data);
   Count(countries.length);
    return el.innerHTML = data;
}

