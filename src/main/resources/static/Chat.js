let ws;
let email;
function connect() {

fetch("/LoggedInUser/", {
    headers : {
        'Content-Type' : 'application/json',
        'Accept' : 'application/json'
    }
}
                ).then((result) => {
email = result.body;
console.log("From fetch: " + email);
}).catch((error) => {
console.log(error);
});

let host = document.location.host;
let pathname = document.location.pathname;

ws = new WebSocket("ws://" + host + "/" + "chat/" + email + "/");

ws.onmessage = function(event) {
console.log(event.data);
};
}

function send() {
let content = document.getElementById("msg").value;
let json = JSON.stringify({
"content": content,
"from" : email
});
console.log("From method send(): " + json);
ws.send(json);

}