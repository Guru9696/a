var http = require('http'); 

var server = http.createServer(function (req, res) {  

res.write("<h1 style='background-color:green'>create server successfully</h1>");
res.end();

});

server.listen(8002); 
console.log('Node.js web server at port 8002 is running..')
