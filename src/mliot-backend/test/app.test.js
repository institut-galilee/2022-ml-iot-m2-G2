'use strict'

const {expect} = require('chai')
const app = require('../src/app')
const request = require('supertest')

const bunyan = require('bunyan')
const logger = bunyan.createLogger({name: 'MLIoT Examination API Server testing logger'})

describe('GET /questions', () => {
    it('Should test whether the server responds with response code 200 and the content type is application/json', done => {
        request(app).get('/questions')
            .set('Content-Type', 'application/json')
            .then(res => {
                expect('Content-Type', 'application/json')
                expect(res.statusCode).to.be.eq(200)
                expect(res.body).to.be.instanceof(Object)
                return done()
            })
            .catch(error => {
                logger.error(error)
                return done()
            })
    })
})
