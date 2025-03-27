const http = require('http');
const fs = require("fs");
const PORT = 8000;

const server = http.createServer((req, res) => {
    console.log(req.url);
    if (req.method === 'GET') {

        if (req.url === '/torte') {
            fs.readFile(__dirname + '/dj.json', function (error, data) {
                if (error) {
                    res.writeHead(404);
                    res.write(error);
                    res.end();
                } else {
                    res.writeHead(200, {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Access-Control-Allow-Methods': 'GET, POST, PUT',
                        'Access-Control-Allow-Headers': 'Content-Type'
                    });
                    console.log(JSON.stringify(JSON.parse(data).torte));
                    res.write(JSON.stringify(JSON.parse(data).torte));
                    res.end();
                }
            });

        } else if (req.url === '/gelati') {
            fs.readFile(__dirname + '/dj.json', function (error, data) {
                if (error) {
                    res.writeHead(404);
                    res.write(error);
                    res.end();
                } else {
                    res.writeHead(200, {
                        'Content-Type': 'application/json',
                        'Access-Control-Allow-Origin': '*',
                        'Access-Control-Allow-Methods': 'GET, POST, PUT',
                        'Access-Control-Allow-Headers': 'Content-Type'
                    });
                    res.write(JSON.stringify(JSON.parse(data).gelati));
                    res.end();
                }
            });

        } else if (req.url.indexOf("immagini") !== -1) {
            let i = req.url.lastIndexOf("/");
            fs.readFile(__dirname + "\\immagini\\" + req.url.substring(i + 1), function (error, data) {
                if (error) {
                    if (error.code === "ENOENT") {
                       console.log("File non trovato");
                       return;
                    } else {
                        res.writeHead(404);
                        console.log(error);
                        res.write(error);
                        res.end();
                    }
                } else {
                    res.writeHead(200, { 'Content-Type': 'image/x-windows-bmp' });
                    res.write(data);
                    res.end();
                }
            });

        }
    }
});

server.listen(PORT, () => console.log(`Server running on port ${PORT}`));

module.exports = server;