function showData() {
    fetch('/User/{email}/')
        .then(res => res.json())
        .then((out) => {
            $.each(out, function(index, value) {
                document.getElementById("emailOutput").innerHTML = value.email;
                document.getElementById("nomeOutput").innerHTML = value.name;
                document.getElementById("contactoOutput").innerHTML = value.cellphone;
                document.getElementById("cargoOutput").innerHTML = value.kinship;
            });
        }).catch(err => console.error(err));
}

$(document).ready(function() {
    showData();
});

window.onload = function() {
    function perfilUpdate() {
        let data = {};
        data.cellphone = document.getElementById("contactoOutput").value;
        console.log(data); //debugging para ver os dados que foram enviados
        //chamada fetch para envio dos dados para o servior via POST
        fetch('/RegisterUser/', { //Se apenas a rota nao funcionar voltar a por url completo
            headers: { Accept: 'application/json', 'Content-Type': 'application/json' },
            method: 'POST',
            body: JSON.stringify(data)
        }).then(function(response) {
            if (!response.ok) {
                console.log(response.status); //=> number 100â€“599
                console.log(response.statusText); //=> String
                console.log(response.headers); //=> Headers
                console.log(response.url); //=> String
                throw Error(response.statusText);
            } else {
                alert("Número alterado com sucesso");
                return response.json();
            }
        }).then(function(result) {
            console.log(result);
        }).catch(function(err) {
            console.error(err);
        });
    }

    document.getElementById("buttonConfirmar").addEventListener("click", function() {
        perfilUpdate();
    });
}