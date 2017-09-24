
// <reference path="../lib_js/angular.js" />

customFilterMod.filter("stateZipFilter",stateZipFilter);

function stateZipFilter(){
    return function(state){
            var stZipMap =  getStZipMap();
            for(mapInd in stZipMap ){
                mapItem = stZipMap[mapInd];
                if(mapItem.code.toLowerCase() === state.toLowerCase()){
                    return mapItem.zip;
                }
            }
            return 'N/A';
        };
}

function getStZipMap(){
    var fl = new stZipMap("FL","33001 - 33600");
    var tx = new stZipMap("TX","56000 - 59000");
    var ca = new stZipMap("CA","90000 - 94000");
    var nj = new stZipMap("NJ","11000 - 19000");
    var ny = new stZipMap("NY","10000 - 10900");
    return [fl,tx,ca,nj,ny];
}
function stZipMap(code,zip){
    this.code = code;
    this.zip = zip;
}