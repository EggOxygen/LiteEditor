var express = require('express');
var router = express.Router();
var { createInstance, getContentByID, updateContentByID } = require('../controller/InstanceController')


/* GET home page. */
router.get('/', function (req, res, next) {
  res.json({
    patch: "200"
  })
});

// Here is an example for new instance
const newResult = {
  'insCODE': 'CODE',
  'insID': 'ID',
  'content': ""
}

/* GET Create New Instance. (With Redis) */
router.get('/createInstance', createInstance)

/* GET Get Each Content By ID. (With Redis) */
router.post('/getContentByID', getContentByID)

/* POST Update Each Content By ID. (With Redis) */
router.post('/updateContentByID', updateContentByID)

module.exports = router;
