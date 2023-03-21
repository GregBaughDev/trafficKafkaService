import { Kafka } from 'kafkajs'
import { createClient } from 'redis'

const kafka = new Kafka({
  clientId: 'traffic_info',
  brokers: ['kafka:9092']
})

const redisClient = createClient({
  socket: {
    host: 'redis'
  }
})

redisClient.on('error', err => {
  console.error(`Redis client error: ${err}`)
})

await redisClient.connect()

const consumer = kafka.consumer({ groupId: 'traffic_info' })

const kafkaRun = async () => {
  await consumer.connect()
  await consumer.subscribe({ topic: 'traffic_info', fromBeginning: true })

  await consumer.run({
    eachMessage: async ({ message }) => {
      console.log({
        value: message.value.toString(),
      })
      // TO DO -> Add exppiry time
      await redisClient.LPUSH('traffic_info_data', message.value.toString())
    }
  })
}

kafkaRun()