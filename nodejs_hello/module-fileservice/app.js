/**
 * file name
 * dir name
 * base name
 * ext
 */

var fs = require("fs");

//fs.writeFileSync("hello.txt","Helloooo fs !!!");
//console.log("saved")

console.log(fs.readFileSync("hello.txt").toString());

var path = require("path");

var currPath = __filename;
	
console.log("path dir "+path.dirname(currPath));
console.log("path base "+path.basename(currPath));
console.log("path ext "+path.extname(currPath));

console.log(__dirname);
console.log(__filename);