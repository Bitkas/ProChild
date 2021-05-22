function Perfil() {
    fetch('/User/{email}/')
        .then(res => res.json())
        .then((out) => {
            $.each(out, function(index, value) {
                document.getElementById("parentName").innerHTML = value.name;
                document.getElementById("grauParentesco").innerHTML = value.kinship;
            });
        }).catch(err => console.error(err));
}

$(document).ready(function() {
    Perfil();
});