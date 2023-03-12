# trafficKafkaService
A Dockerised application which pulls traffic information from the Vic roads public API. The first 10 records
are then sent to a Kafka broker and a Node consumer logs the records. The producer polls the API every 10 minutes.


## To Do:
- UI to display information