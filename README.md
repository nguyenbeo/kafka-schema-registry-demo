# kafka-schema-registry-demo
A simple demo to use Jenkins to publish Kafka schema registry and show in a UI

## Technologies
* Groovy Script
* Apache Avro
* Docker / Docker Compose
* Jenkins

## How to run locally
* Run **docker-compose up -d** to start up all docker containers.
* Run **groovy RegisterSchema** to send avsc files to Schema Registry.
* Open a web browser and visit http://localhost:8000.
* Verify that you can see the schema you have just posted.
