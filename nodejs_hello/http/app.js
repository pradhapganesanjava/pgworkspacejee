/**
 * http://usejsdoc.org/
 */

var http = require("http");

function onRequest(req, res){
	console.log(" request "+ req.url);
	res.writeHead(200,{"Content-Type":"text/plan"});
	res.write("hello from http server");
	res.end();
}

http.createServer(onRequest).listen(5050);
console.log("Server is ON");