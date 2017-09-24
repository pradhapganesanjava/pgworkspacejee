/**
 * http://usejsdoc.org/
 */

var UserRef = {
		name:"",
		age:30
}

UserRef.name = "User Ref";
console.log(UserRef.name+" age: "+UserRef.age);

function User(){
	
	this.name = "";
	this.endorsements = 10;
	this.endorseAll = function endorse(targetUser){
		targetUser.endorsements +=20;
		console.log(this.name+" endorse "+targetUser.name)
	}
}

var pradhap = new User();
var joe = new User();

pradhap.name = "Pradhap Ganesan";
joe.name = "Joe K";

pradhap.endorseAll(joe);

console.log(pradhap.name + " "+pradhap.endorsements);

User.prototype.endorseSpecific = function endorseFew(targetUser){
 	targetUser.endorsements +=5;
 	console.log(this.name + " endorse 5" + targetUser.name);
}

pradhap.endorseSpecific(joe);

console.log(pradhap.name+" "+pradhap.endorsements)
console.log(joe.name+" "+joe.endorsements)