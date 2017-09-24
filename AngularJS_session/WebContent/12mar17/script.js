// Code goes here

/*try{
  sayHello();
} catch(e) {
  console.log("An issue: " + e.message);
}

function divide() {
  var numerator = Number(prompt("Enter the numer..."));
  
  var denominator = Number(prompt("Enter the denom..."));
  
  try{
  
    if(denominator == 0) {
      throw {
        error: "Divide by ZERO",
        message: "Denominator cannot be 0..."
      }
    }
    else {
      console.log("Output ==> " + (numerator / denominator));
    }
  } catch(e) {
    console.error(e.error + "===" + e.message);
  }
}

divide()
*/

$(document).ready(function() {
  $.ajax({
    url: "https://api.github.com/users"
  }).then(function(data) {
		var arr = new Array();
		var temp = "";
		$.each(data, function(index) {
			$.ajax({
				url:data[index].followers_url
			}).then(function(info) {
				$("#users").append("<tr class=warning>" +
						"<td>" + data[index].login + "</td>" +
						"<td><img src='" + data[index].avatar_url + "' width=40 height=40/></td>" +
						"<td>" + data[index].site_admin + "</td>" +
						"<td>" + info.length + "</td></tr>");
			});	
		})
  })
})














