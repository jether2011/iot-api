# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.6.4/maven-plugin/reference/html/#build-image)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/5.3.16/spring-framework-reference/languages.html#coroutines)
* [Spring Data Reactive MongoDB](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-mongodb)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#using-boot-devtools)
* [Validation](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#boot-features-validation)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/2.6.4/reference/htmlsingle/#production-ready)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)

### Create measure event
The following cURL command create a measure data event on telemetry database:

```shell
curl --location --request POST 'http://localhost:9090/telemetry/api/v1/measures' \
--header 'Content-Type: application/json' \
--data-raw '{
    "device": {
        "deviceId": "123456STRE",
        "latitude": 43.123456,
        "longitude": 23.123456
    },
    "measures": [
        {
            "sensor": "TEMPERATURE",
            "measure": 13.54
        },
        {
            "sensor": "HUMIDITY",
            "measure": 58.54
        }
    ],
    "createdAt": "2022-07-21 22:17:35.999"
}'
```

To retrieve stream of measures data: 

```shell
curl --location --request GET 'http://localhost:9090/telemetry/api/v1/measures'

curl --location --request GET 'http://localhost:9090/telemetry/api/v1/measures/:device_id/device'
```
