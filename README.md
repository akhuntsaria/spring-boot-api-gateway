
# Spring Boot API Gateway Demo
This project demonstrates API gateway using microservices architecture, separate authentication service and service discovery.

# Getting Started
* Run discovery-server and other services
* Run requests in request-examples.http

# Architecture
![image info](https://i.imgur.com/YW4DRSd.png)

# Services
* **api-gateway**: Zuul edge service for routing 
* **discover-server**: Eureka server for service discovery
* **auth-service**: JWT authentication service
* **protected-service**: service with sensitive data
