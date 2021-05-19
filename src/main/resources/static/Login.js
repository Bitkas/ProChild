//mostrar password

let pswd = false;

function showPswd() {
    if (pswd) {
        document.getElementById("passInputEntrar").setAttribute("type", "password");
        pswd = false;
    } else {
        document.getElementById("passInputEntrar").setAttribute("type", "text");
        pswd = true;
    }
}

//login

let login = document.getElementById("EntrarContaBtn");
login.onclick = myLogin;

function myLogin() {
    let data = {};
    data.username = document.getElementById("emailInputEntrar").value;
    data.password = document.getElementById("passInputEntrar").value;
    console.log(data); //debugging para ver os dados que foram enviados
    //chamada fetch para envio dos dados para o servior via POST
    fetch('http://aqueous-waters-59160.herokuapp.com/login/', {
        headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
        method: 'POST',
        body: JSON.stringify(data)
    }).then(function(response) {
        if (!response.ok) {
            console.log(response.status); //=> 100-599
            console.log(response.statusText); //=> String
            console.log(response.headers); //=> Headers
            console.log(response.url); //=> String
            throw Error(response.statusText);
        } else {
            alert("Autenticação feita com sucesso!");
            window.location.href = "../static/EscolherArea.html";
        }
    }).then(function(result) {
        console.log(result);
    }).catch(function(err) {
        console.error(err);
    });
}