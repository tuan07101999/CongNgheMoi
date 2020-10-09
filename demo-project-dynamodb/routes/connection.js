const AWS = require("aws-sdk");
const fs = require('fs');

AWS.config.update({
    region: "ap-southeast-1",
    endpoint: "http://dynamodb.ap-southeast-1.amazonaws.com",
    accessKeyId: "AKIASAFAA5NGREFJYEZE",
    secretAccessKey: "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"
});

const docClient = new AWS.DynamoDB.DocumentClient();

module.exports = docClient;