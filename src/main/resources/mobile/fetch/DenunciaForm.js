window.onload = function() {
    function createForm() {
        let data = {};
        data.name = document.getElementById("formNomeInput").value;
        data.morada = document.getElementById("formMoradaInput").value;
        data.idade = document.getElementById("formIdadeInput").value;
        data.genero = document.getElementById("formGenInput").value;
        data.denuncia = document.getElementById("formDenunciaInput").value;
        console.log(data); //debugging para ver os dados que foram enviados
        //chamada fetch para envio dos dados para o servior via POST
        fetch('http://aqueous-waters-59160.herokuapp.com/Form', {
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
                alert("Denúncia submetida com sucesso!");
                window.location.href = "../static/DenunciaSucesso.html";
                return response.json();
            }
        }).then(function(result) {
            console.log(result);
        }).catch(function(err) {
            console.error(err);
        });
    }

    document.getElementById("criarDenunciaBtn").addEventListener("click", function() {
        createForm();
    });
};