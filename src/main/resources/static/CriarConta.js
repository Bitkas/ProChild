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