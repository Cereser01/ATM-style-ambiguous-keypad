var mysql = require('mysql');

var con = mysql.createConnection({
  host: "10.197.73.74",
  user: "root",
  password: "",
  database: "ATMcode"
});

var nome = 'Eduardo_Morias';
var senha

con.connect(function(err) {
  if (err) throw err;
  var sql = "SELECT * FROM usuario WHERE nome = ? AND password = '1234'";
  con.query(sql, [nome, senha], function (err, result) {
    if (err) throw err;
    console.log(result);
  });
});