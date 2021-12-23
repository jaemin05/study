const path = require('path');
const express = require('express');
const cookieParser = require('cookie-parser');
const session = require('express-session');
const morgan = require('morgan');
const helmet = require('helmet');
const nunjucks = require('nunjucks');
const createError = require('http-errors');
const jsonResponse = require("./middlewares/json-response");

const couter = require('./routers');
const router = require('./routers');


const app = express();

app.set('view engine', 'html'); // views file extension: html
nunjucks.configure(path.join(__dirname, 'views'), {
    watch: true,
    autoescape: true,
    express: app,
})
//Apply middlewares to express app

app.use(helmet());
app.use(morgan('dev'));
app.use(jsonResponse());

app.use(cookieParser());
app.use(session({
    resave: true,
    saveUninitialized: true,
    secret: process.env.SECRET || 'cat'
}));


//qs vs queryset
app.use(express.urlencoded({extended: true}))
app.use(express.json()) //body-parser

app.use(express.static(path.join(__dirname, '../public')))

app.use(function (req, res, next) {
    res.a = 'value';
    res.sum = function (a, b) {
        return a + b;
    }
    next();
});
// tweatershin@gmail.com
app.get('/index', function (req, res) {
    console.log(res.a)
    return res.send(`${res.sum(3, 6)}`);
});

app.get('/', function (req, res) {
    const array = [{
        name: 'shin',
        value: 10,
    },
        {
            name: 'ahn',
            value: 30,
        }];
    res.render("index")
});
app.get('/', (req, res) => {
    res.render('../views/layout/common_layout.html');
})

//Use routers
app.use('/', router);

app.use((req, res, next) => {
    next(createError(404));
})

//error handler
app.use(function (err, req, res, rext) {
    res.locals.message = err.message;
    res.locals.error = err;
    res.status(res.status || 500);
    res.json({
        status: err.status || 500,
        error: [{
            title: err.name,
            message: err.message
        }]
    });
});

module.exports = app;