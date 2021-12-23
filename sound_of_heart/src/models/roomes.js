const mongoose = require('mongoose');

const Schema = require('Schema');

const Room = new Schema({
    total: {
        type: Number,
        required: true,
        default: 2,
    },
    members: {
        type: Schema.Types.Array(),
        ref: mongoose.model('User'),
    },
});
module.exports = mongoose.model('Room', Room);