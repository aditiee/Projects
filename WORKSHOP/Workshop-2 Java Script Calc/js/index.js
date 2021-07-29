function clearOutput() {
    document.getElementById("output").innerHTML = "0";
}

function display(value)
{
    removeZero()
    document.getElementById("output").innerHTML+=value;
}
    


function removeZero() {
    var value = document.getElementById("output").innerHTML;
    if (value == "0") {
         value = " "
         document.getElementById("output").innerHTML = value;
    }
}



function solve() {
    removeZero()
    var equation = document.getElementById("output").innerHTML;
    var solved = eval(equation);
    document.getElementById('output').innerHTML = solved;
}




function square() {
    var value = document.getElementById("output").innerHTML;
    value = value * value;
    document.getElementById("output").innerHTML = value;
}
function cube() {
    var value = document.getElementById("output").innerHTML;
    value = value * value * value;
    document.getElementById("output").innerHTML = value;
}
function root() {
    var value = document.getElementById("output").innerHTML;
   
    document.getElementById("output").innerHTML = Math.sqrt(value);
}
