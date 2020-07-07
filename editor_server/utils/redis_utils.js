
const redis = require("redis");
const client = redis.createClient({
    host: ''
});

/* Set Error Log */
client.on("error", function (error) {
    console.error(error);
});

/* Set Connect Log */
client.on("connect", (e) => {
    console.log("Redis Connect!");
})


module.exports = {
    redis, client
}

