let ws;
let email;
function connect() {

fetch("/LoggedInUser/", {
    headers : {
        'Content-Type' : 'application/json',
        'Accept' : 'application/json'
    }
}
                ).then((response) => {
                return response.json();
                })
                .then((result) => {
                console.log(result);
email = result;
console.log("From fetch: " + email);

let host = document.location.host;
let pathname = document.location.pathname;
try {
ws = new WebSocket("ws://localhost:8080/chat/" + email + "/");
} catch(err) {
    console.log(err.name);
    console.log(err.message);
}

}).catch((error) => {
console.log(error);
});



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