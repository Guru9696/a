var http = require('http');
var dt = require("./modules");

http.createServer(function(req,res){
    res.writeHead(200, {'Content-Type': 'text/html'});

    res.write("<h1 style='background-color:green'>Current Date And Time :</h1>"+dt.myDateAndTime());

    res.end();
}).listen(8002);
console.log('Node.js web server at port 8002 is running..')