// alert('hi');
//console.log("Hello");
var countries = ["India", "France", "USA", "Australia", "England"];
//display();
//console.log(countries);

function display()
{
    countries.forEach(element => {
        console.log(element);
    });
}

// function display(item)
// {
//     console.log(item);
// }
//countries.forEach(display);
addCountry("France");

function addCountry(val)
{
    countries.push(val);
}

//display();

function removeCountry(ind)
{
    countries.splice(ind,1);
}

//removeCountry(2);
//console.log("------after--------");
//display();

function updateCountry(from,to)
{
    ind = countries.indexOf(from);
   /* countries.splice(ind,1);
    countries.splice(ind,0,to); */
    countries[ind] = to;
}

display();
updateCountry("USA","Italy");
console.log("\n----------after update-----------\n")
display();