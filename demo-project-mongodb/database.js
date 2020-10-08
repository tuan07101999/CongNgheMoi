// const {MongoClient} = require('mongodb');
// const uri = "mongodb+srv://admin:admin@cluster0.xvcep.gcp.mongodb.net/sample_airbnb?retryWrites=true&w=majority";
// const client = new MongoClient(uri);

// async function main(){
//     /**
//      * Connection URI. Update <username>, <password>, and <your-cluster-url> to reflect your cluster.
//      * See https://docs.mongodb.com/ecosystem/drivers/node/ for more details
//      */
 
//     try {
//         // Connect to the MongoDB cluster
//         await client.connect();
 
//         // Make the appropriate DB calls
//         await  listDatabases(client);
 
//     } catch (e) {
//         console.error(e);
//     } finally {
//         await client.close();
//     }
// }

// main().catch(console.error);

// async function listDatabases(){
//     databasesList = await client.db().admin().listDatabases();
    
//     var s = "Databases:";
//     databasesList.databases.forEach(db => s += ` - ${db.name}`);
    
//     console.log("Databases:");
//     databasesList.databases.forEach(db => console.log(` - ${db.name}`));

//     return s;
// };
// exports.listDatabases = listDatabases;

const mongoose = require('mongoose')
require('dotenv/config')

mongoose.connect(process.env.DB_CONNECTION,
    {   useNewUrlParser: true,
        useUnifiedTopology: true},
    () => console.log("connected to DB!")
);