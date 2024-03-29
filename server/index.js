import express from 'express'
import cors from 'cors'
import { createClient } from 'redis'

const app = express()
const PORT = 8585

const redisClient = createClient({
  socket: {
    host: 'redis'
  }
})

redisClient.on('error', err => {
  console.error(`Redis client error: ${err}`)
})

await redisClient.connect()

app.get('/traffic-info', cors(), async (_, res) => {
  const result = await redisClient.LRANGE('traffic_info_data', 0, -1)
  res.json({ result }).end()
})

app.listen(PORT, () => {
  console.log(`Now listening on port ${PORT}`)
})