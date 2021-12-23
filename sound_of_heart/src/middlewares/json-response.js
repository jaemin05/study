const path = require('path')

// module.exports = (config) => function (req, res, next) {
//     res.json({
//         "status" : 200,
//         "jsonapi": {
//             "version" : "1.0" 
//         },
//         "data" : [
//             {
//                 "k" : 1,
//                 "v" : 2
//             }
//         ]
//     });
//     next();
// }

const option = [
    {},
    [
        {
            keyname: '',
            callback: function () {
            },
        },
    ],

]

module.exports = (option = [{}, []]) => {
    return function (req, res, next) {
        //error일경우, success일경우엔..
        const [conObj, varObj] = option;

        res.json_ = res.json;
        const datakey = res.status >= 400 ? 'errors' : "data";
        res.json = function (data) {
            // 
            return res.json_({
                status: res.status,
                jsonapi: {
                    version: process.env.API_VERSION,
                },
                ...conObj,
                ...Object.fromEntries(
                    varObj.map((item) => {
                        return {[item.keyname]: item.callback(req, res)};
                    })
                ),
                [datakey]: data,
            });
        };
        next();
    }
};


// app = {use: ()=>{}}
// app.use((req,res,next)=>{
//     next(createError(404));
// })
// app.use(function(err, req,res, next){
//     res.json({
//         "status" : 404,
//         "jsonapi": {
//             "version" : "1.0"
//         },
//         "error" : [{
//             "status" : 404,
//             "title" : "NotFoundError",
//             "detail":"Not Found"
//         }]
//     });
//     next();
// });
// app.get('/', function(req,res,next){

// })
