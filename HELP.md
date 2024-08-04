### work dir:
    cd infrastructure/docker-compose 

## Start Kafka's brokers
### Start Zookeeper
    docker-compose -f common.yml -f zookeeper.yml up
#### Test zookeeper
    echo ruok | nc localhost 2181
### Start kafka-cluster
    docker-compose -f common.yml -f kafka_cluster.yml up
### Init kafka. Make one time for create topics
    docker-compose -f common.yml -f init_kafka.yml up

## Start Postgres
    docker-compose -f storage.yml up
