// Create a token without the client
const jwt = require('jsonwebtoken');
const axios = require('axios');

//npm install jsonwebtoken --save
//npm install axios --save


// Admin API key goes here
const key = '620588f7e2776d0001fd8e5d:12304adeea820197cf919658b57e2840783f2a0a9d1ef478f9e2d5394b44cac2';

// Split the key into ID and SECRET
const [id, secret] = key.split(':');

// Create the token (including decoding secret)
const token = jwt.sign({}, Buffer.from(secret, 'hex'), {
    keyid: id,
    algorithm: 'HS256',
    expiresIn: '30d',
    audience: `/v4/admin/`
});

// Make an authenticated request to create a post
const url = 'http://ghostcms-b07b69-dev.apps.silver.devops.gov.bc.ca/ghost/api/v4/admin/posts';
const headers = { Authorization: `Ghost ${token}` };
//const payload = { posts: [{ title: 'Hello World' }] };

console.log(headers)

// axios.get(url,  { headers })
//     .then(response => console.log(response))
//     .catch(error => console.error(error));