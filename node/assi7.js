var http = require('http'); 

var server = http.createServer(function (req, res) {  

res.writeHead(200, {'Content-Type': 'text/html'});
res.write("<h1 style='background-color:green'>Upload your file</h1>");
res.write('<form action="fileupload" method="post" enctype="multipart/form-data">');
res.write("<input type='file' name='fileupload'/>");

res.write("<input type='submit' value='Submit'");
res.write("</form>");
res.end();

});

server.listen(8002); 

console.log('Node.js web server at port 8002 is running..')