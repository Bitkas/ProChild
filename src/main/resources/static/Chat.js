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
        let ws = new WebSocket("wss://" + host +  "/chat/" + email + "/");

        ws.onopen = () => {
            console.log("ola");
        }

        ws.onmessage = (message) => displayMessage(message.data);
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
displayMessage(content);
}

function displayMessage(message) {
    let messageDiv = document.getElementById("messages");
    const messageBox = "<div>" +
                        "<p>" + message + "</p>" +
                        "</div>"
    messageDiv.innerHTML = messageBox;
}