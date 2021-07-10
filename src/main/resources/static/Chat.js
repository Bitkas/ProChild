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

        const host = document.location.host;
        //heroku host
        //const host = "aqueous-waters-59160.herokuapp.com"
        ws = new WebSocket("ws://" + host +  "/chat/" + email);



        ws.onopen = () => {
            alert("You are connected!")
        }

        ws.onmessage = (message) => {
            displayMessage(JSON.parse(message.data));
        };

        ws.onclose = (close) => {
            console.log("close reason: ", close.reason);
            console.log("close code: ", close.code)
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

function displayMessage(message) {
    const id = setId(message);
    let messageDiv = document.getElementById("messages");
    const messageBox = "<div class=" + id +  ">" +
                        "<p class='message'>" + message.content + "</p>" +
                        "<p id='from'>" + message.from + "</p>" +
                        "</div>"
    messageDiv.innerHTML += messageBox;
    calcDimensions(message.content, document.getElementsByClassName("message")[document.getElementsByClassName("message").length - 1]);
}

function calcDimensions(message, messageContainer) {
    const heightContainer = (message.length * 15)/(380*0.8);
    messageContainer.style.height = heightContainer;
}

function setId(message) {
    let id;
    if(message.from == email) {
        id="sameOrigin";
    } else {
        id= "otherOrigin";
    }
    return id;
}