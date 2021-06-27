let email
function connect() {

fetch("/LoggedInUser/", {
    headers : {
        'Content-Type' : 'application/json',
        'Accept' : 'application/json'
    }
}).then((response) => {
    return response.json();
    }).then((result) => {
        email = result;

        //const host = document.location.host;
        const host = "aqueous-waters-59160.herokuapp.com"
        let ws = new WebSocket("ws://" + host +  "/chat/" + email + "/");

        ws.onopen = () => {
            console.log("ola");
        }


    }).catch((error) => {
        console.log(error);
 });
}

function send() {
let content = document.getElementById("msg").value;
let json = JSON.stringify({
"content": content,
"from" : email
});
ws.send(json);

}