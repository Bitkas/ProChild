function PerfilUpdate() {
    fetch('http://aqueous-waters-59160.herokuapp.com/User/{email}/')
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
    PerfilUpdate();
});