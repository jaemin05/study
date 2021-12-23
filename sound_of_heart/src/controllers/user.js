const User = require('../models/user');

function createUser(req, res) {
    const {email, password, nickname} = req.body;
    console.log(email, password, nickname);
    const User = User.create({email, password, nickname}).exec();
    console.log(User)

    console.log(user);
    res.json(user);
}

module.exports = {
    createUser,

};