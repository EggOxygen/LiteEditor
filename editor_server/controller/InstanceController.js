var { client } = require('../utils/redis_utils');
const uuid = require('uuid')

function createInstance(req, res) {
    let uuids = uuid.v4();
    client.hset("EDITOR", uuids, JSON.stringify({ content: '' }), (row) => { })
    res.json({
        patch: '202',
        data: {
            insID: uuids,
        }
    })
}

function updateContentByID(req, res) {
    client.hset("EDITOR", req.body.insID, JSON.stringify({ content: req.body.content }), (row) => { })
    res.json({
        patch: '202'
    })
}

function getContentByID(req, res) {
    console.log(req.body);
    client.hget("EDITOR", req.body.insID, (e, v) => {
        res.json({
            patch: '202',
            data: JSON.parse(v)
        })
    })
}

module.exports = {
    createInstance, getContentByID, updateContentByID
}