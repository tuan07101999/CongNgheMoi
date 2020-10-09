const bodyParser = require('body-parser');
const express = require("express");
var app = express();
// const connection = require('./routes/connection');
const userRoute = require('./routes/user');

app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json());

app.use('/user', userRoute);

app.use(function (req, res, next) {
    res.status(404).send("Sorry, that route doesn't exist. Have a nice day")
});

app.listen(3000, function () {
    console.log('Example app listning on port 3000.');
});