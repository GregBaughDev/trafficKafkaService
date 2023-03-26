# trafficKafkaService
A Dockerised application which pulls traffic information from the Vic roads public API. The first 10 records
are then sent to a Kafka broker and a Node consumer logs the records. The producer polls the API every 10 minutes.

[traffic drawio](https://user-images.githubusercontent.com/80447308/227761937-2545ddda-94cf-463a-b6b9-6e93bf2d64a4.png)
