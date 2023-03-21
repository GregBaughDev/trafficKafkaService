import express from 'express'
import { createClient } from 'redis'

const app = express()
const PORT = 8585

const redisClient = createClient()

redisClient.on('error', err => {
  console.error(`Redis client error: ${err}`)
})

await redisClient.connect()

app.get('/traffic-info', async (req, res) => {
  const result = await redisClient.LRANGE('TODO', 0, -1)
  res.json({ result }).end()
})

app.listen(PORT, () => {
  console.log(`Now listening on port ${PORT}`)
})