const bodyParser = require('body-parser');
var express = require('express');
var app = express();
const database = require('./database');
const postsRoute = require('./routes/posts');

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json());

app.get('/', function(req, res){
    res.send('<b>My</b> first express http server')
});

app.use('/posts', postsRoute);

// app.get('/ahihi', (req, res) => {
//     console.log(database.listDatabases());
//     res.send(database.listDatabases());
//     // console.log(req.body);
// });

// app.route('/aricle')
// .get(function(req, res){
//     console.log(database.listDatabases());
//     res.send(database.listDatabases());
// });
// .post(function(req, res){
//     res.send('Add an article');
//     console.log('Add an article');
// })
// .put(function(req, res){
//     res.send('Update the article');
//     console.log('Update an article');
// });

app.use(function (req, res, next) {
    res.status(404).send("Sorry, that route doesn't exist. Have a nice day")
});


//Listening to the server
app.listen(3000, function () {
    console.log('Example app listning on port 3000.');
});