/**
 * http://usejsdoc.org/
 */

var prods = require("./products");
prods = products();
prods.totalProducts = 125;
console.log("Appliance has "+ prods.totalProducts);