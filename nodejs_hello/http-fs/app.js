/**
 * http://usejsdoc.org/
 */

var http = require("http");
var fs = require("fs");


function onRequest(request, response){
	if(request.method="GET" && request.url=="/"){
		response.writeHead(200,{"Content-Type":"text/html"});
		fs.createReadStream("./index.html").pipe(response);
	}else{
		sendRes404(response);
	}
	
}

function sendRes404(response){
	response.writeHead(200,{"Content-Type":"text/plain"});
	response.write("error");
	response.end();
}

http.createServer(onRequest).listen(5050);
console.log("server is on");