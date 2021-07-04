let email
let ws;
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
        //heroku host
        const host = "aqueous-waters-59160.herokuapp.com"
        ws = new WebSocket("ws://" + host +  "/chat/" + email);



        ws.onopen = () => {
            alert("You are connected!")
        }

        ws.onmessage = (message) => {
            displayMessage(message.data, "otherOrigin")

        };
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
displayMessage(json, "sameOrigin");
}

function displayMessage(message, wasSent) {
    const realMessage = JSON.parse(message);
    let messageDiv = document.getElementById("messages");
    const messageBox = "<div class=" + wasSent +  ">" +
                        "<p>" + realMessage.content + "</p>" +
                        "</div>"
    messageDiv.innerHTML += messageBox;
    calcDimensions(realMessage.content, document.getElementsByClassName(wasSent));
}

function calcDimensions(message, containerCollection) {
    const heightContainer = (message.length * 15)/380;
    containerCollection[containerCollection.length - 1].style.height = heightContainer;
}