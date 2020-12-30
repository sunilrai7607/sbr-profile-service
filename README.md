## SpringBoot Rest APIs build based on microService pattern; Command Query Responsibility Segregation(CQRS) and Event Sourcing with Kafka (Producer and Consumer), MongoDB and Redis - Profile Service

### Technical
1. Kafka
2. Redis
3. MongoDB
4. Docker-Compose
5. Docker
 
 
 ```commandline
% docker ps
CONTAINER ID   IMAGE     COMMAND                  CREATED         STATUS                             NAMES
cb3212239af3   redis     "docker-entrypoint.s…"   2 minutes ago   Up 2 minutes      docker-compose-server_redis-server_1

docker exec -it cb3212239af3 sh

# redis-cli
000.0.0.1:6379> ping
PONG

000.0.0.1:6379> KEYS *
```
 