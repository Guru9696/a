// var http = require('http');
// var url = require('url');
// var fs = require('fs');

// var server = http.createServer(function (req, res) {
//     var url_parts = url.parse(req.url, true); 
//     var user = url_parts.query.user;
//     var pass = url_parts.query.pass;

//     if(user && pass){
//         console.log('username: ' + user);
//         console.log('password: ' + pass);
//         res.writeHead(200, {'Content-Type': 'text/plain'});
//         res.end(JSON.stringify({message: 'Hello' + user + ' !'}));
//     } else {
//         console.log('No user !');
//         res.writeHead(200, {'Content-Type': 'text/plain'});
//         fs.readFile("./lab_pro/User_login/index.html", function (err,data)
//         {
//             res.end(data);
//         });
//     }
   
// }).listen(8002, '127.0.0.1');

// console.log('Server running at http://127.0.0.1:8002/');

// var http = require('http');
// var url = require('url');
// var fs = require('fs');

// http.createServer(function (req, res) {
//   var q = url.parse(req.url, true);
//     var user = q.query.txt;
//     var email = q.query.email;
//     var pass = q.query.pswd;
//     console.log(user);
//     console.log(email);
//     console.log(pass);

//   var filename = "./User_login" + q.pathname;

//   fs.readFile(filename, function(err, data) {
  
//     if (err) {
//       res.writeHead(404, {'Content-Type': 'text/html'});
//       return res.end("404 Not Found");
//     } 
//     res.writeHead(200, {'Content-Type': 'text/html'});

//     res.write(data);

//     return res.end();
//   });
// }).listen(8002);
// console.log('Server running at http://127.0.0.1:8002/index.html');

var http = require('http');
var url = require('url');
var fs = require('fs');
var mysql = require('mysql');

const path = require('path');

const PORT = 8000;

const MIME_TYPES = {
  default: "application/octet-stream",
  html: "text/html; charset=UTF-8",
  js: "application/javascript",
  css: "text/css",
  png: "image/png",
  jpg: "image/jpg",
  gif: "image/gif",
  ico: "image/x-icon",
  svg: "image/svg+xml",
};

const STATIC_PATH = path.join(process.cwd(), "./User_login");

const toBool = [() => true, () => false];

const prepareFile = async (url , req,res) => {
  const paths = [STATIC_PATH, url];
  if (url.endsWith("/")) paths.push("index.html");
  const filePath = path.join(...paths);
  const pathTraversal = !filePath.startsWith(STATIC_PATH);
  const exists = await fs.promises.access(filePath).then(...toBool);
  const found = !pathTraversal && exists;
  const streamPath = found ? filePath : STATIC_PATH + "/404.html";
  const ext = path.extname(streamPath).substring(1).toLowerCase();
  const stream = fs.createReadStream(streamPath);
  return { found, ext, stream };
};




http.createServer(async (req, res) => {







var con = mysql.createConnection({
    host: "localhost",

    user: "root",
  
    //password: "", /*pc xampp database or localhost*/
   //password: "Gaurav@123", /* pc commond line mysql or localhost*/
   password: "raj@123", /* mobile xampp or local host*/

});

// use the  query to connect a localhost
con.connect(function(err) {
  if (err) throw err;
  console.log("Connected to localhost!");
 
  });


 // use the query to create a Database.
  let databaseName = "lab_pro";
  
  let createQuery = `CREATE DATABASE ${databaseName}`;

 
  con.query(createQuery, (err) => {
      if(err==1) throw  "Couldn't create";

      console.log(databaseName+" Database Created Successfully !");
  // use the query to Use a Database.
      let useQuery = `USE ${databaseName}`;
      con.query(useQuery, (error) => {
          if(error) throw error;

          console.log("Using Database"+databaseName);
        })
  // Create a new Table
    let TableName = "User_logins";
    let table_query = `CREATE TABLE ${TableName} (username VARCHAR(255), emails VARCHAR(255),password VARCHAR(255))`;
  
    con.query(table_query, (err) => {
      if(err==1) throw "Couldn't create";
      console.log(TableName+" Table created");
    });

//Insert Data in Table

  let Insert_query = `INSERT INTO ${TableName} (username, emails, password) VALUES ?;`;
  
// multiple Values to be inserted
    let values = [
        [email],
      
    ];
  
  // Executing the query show row are inserted in the table
    // con.query(Insert_query, [values], (err) => {
    
    //     if (err==1) throw "Couldn't create";
    //     console.log("All Rows Inserted");
    // });
  //   var c_q = `SELECT * FROM ${TableName} where emails = ?`;
  //   con.query(c_q,[values], (err,result,fields) => {
    
  //     if (err) throw err;
  //     console.log('dbemail'+fields);
  // });


  //   var dbpass = `SELECT 'password' FROM ${TableName} WHERE email = ?`;
  //   con.query(dbpass, [values], (err,result) => {
    
  //     if (err==1) throw "Couldn't create";
  //     console.log('passdb '+result);
  // });
//select query to show table data
    let show_student = `SELECT * FROM ${TableName} where username = 'raj'`
    con.query(show_student, function (err, result, fields) {

        if (err) throw err;
    
        console.log(result);
    
      });


  });


//

// try{
  
//   if (c_q) {

//       let submittedPass = pass; 
//       // let storedPass = foundUser.password; 

//       const passwordMatch = await bcrypt.compare(submittedPass, storedPass);
//       if (passwordMatch) {
//           let usrname = foundUser.username;
//           res.send(`<div align ='center'><h2>login successful</h2></div><br><br><br><div align ='center'><h3>Hello ${usrname}</h3></div><br><br><div align='center'><a href='./login.html'>logout</a></div>`);
//       } else {
//           res.send("<div align ='center'><h2>Invalid email or password</h2></div><br><br><div align ='center'><a href='./login.html'>login again</a></div>");
//       }
//   }
//   else {

//       let fakePass = `$2b$$10$ifgfgfgfgfgfgfggfgfgfggggfgfgfga`;
//       await bcrypt.compare(req.body.password, fakePass);

//       res.send("<div align ='center'><h2>Invalid email or password</h2></div><br><br><div align='center'><a href='./login.html'>login again<a><div>");
//   }
// } catch{
//   res.send("Internal server error");
// }


//
var q = url.parse(req.url, true);
    var user = q.query.txt;
    var email = q.query.email;
    var pass = q.query.pswd;
    var lemail = q.query.email;
    var lpass = q.query.pswd;
    console.log(user);
    console.log(email);
    console.log(pass);

    console.log(lemail);
    console.log(lpass);


    const file = await prepareFile(req.url);
    const statusCode = file.found ? 200 : 404;
    const mimeType = MIME_TYPES[file.ext] || MIME_TYPES.default;
    res.writeHead(statusCode, { "Content-Type": mimeType });
   file.stream.pipe(res);
    console.log(`${req.method} ${req.url} ${statusCode}`);
    
  })
  .listen(PORT);

console.log(`Server running at http://127.0.0.1:${PORT}/`);