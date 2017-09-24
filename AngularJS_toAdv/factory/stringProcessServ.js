
strProcessSrvMod.factory("countCapsStrProcessSrv",countCapsStrProcessSrv);

function countCapsStrProcessSrv(){
    return {
        countCapsSrv : function(strInput){
                console.log('service factory'+strInput);
                var count = 0;
                    if(!strInput) {  return; }
                    for(i =0; i< strInput.length;i++){
                        if(strInput[i]===strInput[i].toUpperCase()){
                            count++;
                        }
                    }
                return count;
            }
        }
}