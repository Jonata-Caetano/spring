## Using Kafka in the Docker

```
docker-compose up
```

## Tips

### Creating topic
-Into the Docker go to usr/bin

```
./kafka-topics --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic fct.dsr.commerce.delivery.merchant
```

### Listing topic
-Into the Docker go to usr/bin

```
./kafka-topics --list --bootstrap-server localhost:9092
```

### Describe topic
-Into the Docker go to usr/bin

```
./kafka-topics --bootstrap-server localhost:9092 --describe
```

### Deleting topic
-Into the Docker go to usr/bin

```
./kafka-topics --zookeeper localhost:2181 --delete --topic GREETINGS
```

### Creating consumer
-Into the Docker go to usr/bin

```
./kafka-console-consumer --bootstrap-server localhost:9092 --topic fct.dsr.commerce.delivery.merchant
```
