'use strict'

/**
 * Port number the MLIoT Examination API Server
 */
const port = 8080

/**
 * We use Express JS as web app framework
 */
const express = require('express')
const app = express()
app.use(express.json())

/**
 * Import of File System and Rotating File System package to read and write files
 */
const fs = require('fs').promises
const rfs = require('rotating-file-stream')

/**
 * Bunyan will be used for logging across this API
 */
const bunyan = require('bunyan')
const log = bunyan.createLogger({name: 'MLIoT Examination API Server logger'})

/**
 * Debugging tool
 */
const morgan = require('morgan')
const path = require('path')
app.use(morgan('dev', {
    stream: rfs.createStream('access.log', {
        interval: '1d',
        path: path.join('./logs', 'access')
    })
}))

/**
 * The file path where the questionnaire is stored
 */
const questionnairePath = './res/questionnaire.json'

/**
 * End Point that returns the list of questions and answers as multiple options
 */
app.get('/questions', (req, res, next) => {
    fs.readFile(questionnairePath, {encoding: 'utf8', flag: 'r'})
        .then(JSON.parse)
        .then(content =>res.json(content))
        .catch(error => {
            log.error(error)
            res.status(500).send
        }
        )
})

module.exports = app.listen(port, () => {
    log.info(`MLIoT Examination API Server is running at http://localhost:${port}`)
})

module.exports = app
