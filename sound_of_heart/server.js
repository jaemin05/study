const path = require('path')
const dotenv = require('dotenv');
const connectDB = require('./src/models');

dotenv.config({
    path: process.env.NODE_ENV === 'production' ? path.resolve(__dirname, '.env') : path.resolve(__dirname, '.development.env')
});
console.log(process.env);
console.log(process.env.MONGO_URL);

const app = require('./src/app');
const http = require('http');

const server = http.createServer(app);

connectDB(() => {
    server.listen(process.env.PORT || 3000, () => {
        console.log("Server on");
    });
});

