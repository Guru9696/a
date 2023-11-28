var express = require('express');
var app = express();
var PORT = 8002;  
app.get('/', function(req, res){
  
    res.download('assi19.txt');

});
app.listen(PORT, function(err){
    if (err) console.log(err);
    console.log("Server listening on PORT", PORT);
});

// var http = require('http'); 

// var server = http.createServer(function (req, res) {  
// res.download('assi19.txt');

// res.end();

// });

// server.listen(8002); 

// console.log('Node.js web server at port 8002 is running..')