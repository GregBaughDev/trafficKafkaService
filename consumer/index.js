import express from 'express'
import { Kafka } from 'kafkajs'
const app = express()

const kafka = new Kafka({
  clientId: 'traffic_info',
  brokers: ['kafka:9092']
})

const consumer = kafka.consumer({ groupId: 'traffic_info' })

const data = []

const kafkaRun = async () => {
  await consumer.connect()
  await consumer.subscribe({ topic: 'traffic_info', fromBeginning: true })
  // TO DO: The array needs to be reset
  // TO DO: Use a ORM to map the responses?
  data.splice(0)
  await consumer.run({
    eachMessage: async ({ _, __, message }) => {
      console.log({
        value: message.value.toString(),
      })
      data.push(message.value.toString())
    }
  })
}

app.get('/info', (_, res) => {
  res.status(200).json(data)
})

app.listen(8282, () => {
  kafkaRun()
  console.log('Serving on port 8282')
})

