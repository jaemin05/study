const mongoose = require('mongoose');
const validators = require('validators');
const bcrypt = require('bcrypt');

const Schema = mongoose.Schema;


const emailValidate = [{
    validator: (email) => {
        return validators.isEmail(email);
    },
    message: (props) => {
        return `${props.path} is not email style, got ${props.value}`;
    },
    validators: async (email) => {
        const model = mongoose.model("User");
        if (this.isNew) {
            const user = await model.findOne({email: email}).exec();
            return user.length < 1;
        }
        return true;
    },
},
];
const User = new Schema({
    email: {
        type: String,
        required: true,
        validate: emailValidate,
    },
    hashed_password: {
        type: String,
        required: true,
    },
    nickname: {
        type: String,

    },
    isStaff: {
        type: Boolean,
        default: false,
    },
    createAt: {
        type: Schema.Types.Date,
        default: Date.now,
    }
});

User.virtual('password').set((pwd) => {
    this._password = pwd;
    this.hashed_password = this.createHash(pwd);
}).get((pwd) => {

    this._password;
})
User.methods = {
    createHash: function (password) {
        if (!password) return ''
        return bcrypt.hashSync(password,
            process.env.SALT_ROUNDS || 10)
    }
}
User.static = {}

module.exports = mongoose.model("User", User);



