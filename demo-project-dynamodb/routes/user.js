const express = require("express");
const router = express.Router();
const docClient = require('./connection');
//
// const AWS = require("aws-sdk");
// const fs = require('fs');

// AWS.config.update({
//     region: "ap-southeast-1",
//     endpoint: "http://dynamodb.ap-southeast-1.amazonaws.com",
//     accessKeyId: "AKIASAFAA5NGREFJYEZE",
//     secretAccessKey: "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"
// });

// const docClient = new AWS.DynamoDB.DocumentClient();
//
//Read an user
//localhost:3000/user/getUserById/:userId
router.get('/getUserById/:phonenumber', async (req, res) => {
    var params = {
        TableName: "user",
        Key:{
            "phonenumber": req.params.phonenumber
        },
        "ProjectionExpression": "#user_name, phonenumber, avatarlink",
        // KeyConditionExpression: "#user_name = :n, phonenumber: pn, avatarlink: a",
        // ExpressionAttributeValues: {
        //     ":a": "No One You Know",
        //     ":t": "Call Me Today"
        // },
        ExpressionAttributeNames:{
            "#user_name": "name"
        },
    };

    docClient.get(params, function(err, data) {
        if (err) {
            res.json({message: err})
        } else {
            res.json(data.Item);
        }
    });
});

//Create an user
//localhost:3000/user/add
router.post('/add', async(req, res) =>{
    var params = {
        TableName: "user",
        Item:{
            "avatarlink": req.body.avatarlink,
            "email": req.body.email,
            "name": req.body.name,
            "password": req.body.password,
            "phonenumber": req.body.phonenumber
        }
    };
    
    docClient.put(params, function(err, data) {
        if (err) {
            // console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
            res.json({message: err})
        } else {
            // console.log("Added item:", JSON.stringify(data, null, 2));
            res.json("Add new success user " + params.Item.name);
        }
    });
})

//Update an user
//localhost:3000/user/update
router.patch('/update', async(req, res) => {
    var params = {
        TableName: "user",
        Key:{
            "phonenumber": req.body.phonenumber,
        },
        UpdateExpression: "set #user_name = :n, avatarlink = :a, password = :p, email = :e",
        ExpressionAttributeValues:{
            ":n": req.body.name,
            ":a": req.body.avatarlink,
            ":p": req.body.password,
            ":e": req.body.email,

        },
        ExpressionAttributeNames:{
            "#user_name": "name"
        },
        ReturnValues:"UPDATED_NEW"
    };

    docClient.update(params, function(err, data) {
        if (err) {
            res.json({message: err})
        } else {
            res.json(data.Attributes);
        }
    });
})

//Delete an user
//localhost:3000/user/delete/:userId
router.delete('/delete/:phonenumber', async (req, res) => {
    var params = {
        TableName: "user",
        Key:{
            "phonenumber": req.params.phonenumber
        }
        // ConditionExpression:"",
        // ExpressionAttributeValues: {
        //     "": 5.0
        // }
    };
    var user = {};

    docClient.get(params, function(err, data) {
        if (err) {
            res.json({message: err})
        } else {
            user = data.Item;
        }
    });

    docClient.delete(params, function(err, data) {
        if (err) {
            res.json({message: err})
        } else {
            // console.log("DeleteItem succeeded:", JSON.stringify(data, null, 2));
            res.json("Delete success user: " + user.name);
        }
    });
})

//Login
router.post('/login', async (req, res) => {
    var params = {
        TableName: "user",
        Key:{
            "phonenumber": req.body.phonenumber,
        },
        "ProjectionExpression": "#user_name, phonenumber, avatarlink, email",
        KeyConditionExpression: "password = :p",
        ExpressionAttributeValues: {
            ":p": req.body.password
        },
        ExpressionAttributeNames:{
            "#user_name": "name"
        },
    };

    docClient.get(params, function(err, data) {
        if (err) {
            res.json({message: err})
        } else {
            res.json(data.Item);
        }
    });
})

module.exports = router


