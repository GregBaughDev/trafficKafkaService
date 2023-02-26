const { Kafka } = require('kafkajs')

const kafka = new Kafka({
  clientId: 'traffic_info',
  brokers: ['localhost:9092']
})

const consumer = kafka.consumer({ groupId: 'traffic_info' })


const run = async () => {
  await consumer.connect()
  await consumer.subscribe({ topic: 'traffic_info', fromBeginning: true })

  await consumer.run({
    eachMessage: async ({ _, __, message }) => {
      console.log({
        value: message.value.toString(),
      })
    }
  })
}

run()
