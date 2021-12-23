const mongoose = require('mongoose');
module.exports = (cb) => {
    console.log(process.env.MONGO_URL)
    mongoose.connect(process.env.MONGO_URL, {
        useNewUrlParser: true,
        useUnifiedTopology: true,
    }, cb);
};

