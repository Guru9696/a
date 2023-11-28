var http = require('http');

var prompt = require('prompt-sync')({sigint: true});
var fs = require('fs');

http.createServer(function(req,res) {

    var file1 = prompt("Enter 1st filename with extension : ");
    var file2 = prompt("Enter 2nd filename with extension : ");
    fs.readFile(file2,function(err,data) {
        if(err) {
            console.log("ERROR",err);
        }
        else {
            fs.appendFile(file1,data,function(err,data) {
                if (err) {
                    console.log("Error",err);
                }
                else {
                    console.log("\nFile Contents of "+file1+" after append:\n",
                    fs.readFileSync(file1, "utf8"));
                }
            });
            res.end();
        }
    });
}).listen(8002);
console.log('Node.js web server at port 8002 is running..')