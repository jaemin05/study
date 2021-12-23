const router = require('express').Router();
const apiRouter = require('./api');

router.use('/api', apiRouter);
router.get('/', function (req, res) {
    console.log(req)
})

module.exports = router;