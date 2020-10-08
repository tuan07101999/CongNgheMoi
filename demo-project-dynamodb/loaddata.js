var AWS = require("aws-sdk");
var fs = require('fs');

AWS.config.update({
    region: "ap-southeast-1",
    endpoint: "http://dynamodb.ap-southeast-1.amazonaws.com",
    accessKeyId: "AKIASAFAA5NGREFJYEZE",
    secretAccessKey: "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"
});

var docClient = new AWS.DynamoDB.DocumentClient();

//Read an item
// var params = {
//     TableName: "User",
//     Key:{
//         "user_id": "123"
//         // "name": 
//     }
// };

// docClient.get(params, function(err, data) {
//     if (err) {
//         console.error("Unable to read item. Error JSON:", JSON.stringify(err, null, 2));
//     } else {
//         console.log("GetItem succeeded:", JSON.stringify(data, null, 2));
//     }
// });

//Create an item
// var params = {
//     TableName: "User",
//     Item:{
//         "user_id": "127",
//         "name": "douglas costa",
//         "avatarlink": null
//     }
// };

// console.log("Adding a new item...");
// docClient.put(params, function(err, data) {
//     if (err) {
//         console.error("Unable to add item. Error JSON:", JSON.stringify(err, null, 2));
//     } else {
//         console.log("Added item:", JSON.stringify(data, null, 2));
//     }
// });

//Update an item
// var params = {
//     TableName: "User",
//     Key:{
//         "user_id": "127",
//     },
//     UpdateExpression: "set avatarlink = :a",
//     ExpressionAttributeValues:{
//         ":a": "",
//     },
//     ReturnValues:"UPDATED_NEW"
// };

// console.log("Updating the item...");
// docClient.update(params, function(err, data) {
//     if (err) {
//         console.error("Unable to update item. Error JSON:", JSON.stringify(err, null, 2));
//     } else {
//         console.log("UpdateItem succeeded:", JSON.stringify(data, null, 2));
//     }
// });

//Delete an item
var params = {
    TableName: "User",
    Key:{
        "user_id": "125"
    }
    // ConditionExpression:"",
    // ExpressionAttributeValues: {
    //     "": 5.0
    // }
};

console.log("Attempting a conditional delete...");
docClient.delete(params, function(err, data) {
    if (err) {
        console.error("Unable to delete item. Error JSON:", JSON.stringify(err, null, 2));
    } else {
        console.log("DeleteItem succeeded:", JSON.stringify(data, null, 2));
    }
});
