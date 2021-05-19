//mostrar password

let pswd = false;

function showPswd() {
    if (pswd) {
        document.getElementById("passInput").setAttribute("type", "password");
        pswd = false;
    } else {
        document.getElementById("passInput").setAttribute("type", "text");
        pswd = true;
    }
}

//criar conta

window.onload = function() {
    function createacc() {
        let data = {};
        data.name = document.getElementById("nomeInput").value;
        data.grau = document.getElementById("GrauInput").value;
        data.email = document.getElementById("emailInput").value;
        data.password = document.getElementById("passInput").value;
        data.confirmpassword = document.getElementById("confPassInput").value;
        console.log(data); //debugging para ver os dados que foram enviados
        //chamada fetch para envio dos dados para o servior via POST
        if (data.password == document.getElementById("confPassInput").value) {
            fetch('http://aqueous-waters-59160.herokuapp.com/RegisterUser/', {
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

                alert("Conta Criada!");
                    createacc();
                    async function createacc() {
                        alert("Conta criada com sucesso!");
                        window.location.href = "../static/ContaCriada.html";
                        return response.json();
                    }

                }
            }).then(function(result) {
                console.log(result);
            }).catch(function(err) {
                console.error(err);
            });
        } else {
            alert("As passwords não coincidem!");
        }
    }

    document.getElementById("criarContaBtn").addEventListener("click", function() {
        createacc();
    });
};