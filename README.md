# demo-servicebus-jms-timeout

This demo project is to reproduce this issue https://github.com/Azure/azure-sdk-for-java/issues/31966. 

To run this project locally, you need to configure the `application.properties` first:

```properties
spring.jms.servicebus.connection-string=<your-service-bus-connection-string>
spring.jms.servicebus.pricing-tier=<your-service-bus-pricing-tier>
spring.jms.servicebus.destination=<your-service-bus-queue-name>
```

