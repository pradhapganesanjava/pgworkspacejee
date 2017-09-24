/**
 * http://usejsdoc.org/
 */

var http = require("http");
var connect = require("connect");


var app = connect();

app.use("//",index);
app.use("/profile",profile);
app.use("/forum",forum);

function index(req, res){
	console.log("index ...")
}

function profile(req, res){
	console.log("One exe");
}

function forum(req, res){
	console.log("Two exe");
}

http.createServer(app).listen(5050);
console.log("Server started...");
