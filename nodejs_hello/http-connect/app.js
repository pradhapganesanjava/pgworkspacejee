/**
 * http://usejsdoc.org/
 */

var http = require("http");
var connect = require("connect");


var app = connect();

app.use(one);

http.createServer(app).listen(5051);
console.log("Server started...");


function one(req, res, next){
	console.log("One exe");
	next();
}

function two(req, res, next){
	console.log("Two exe");
}