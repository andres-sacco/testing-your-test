# Testing your test - Heisenbug conference

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)


# Technologies

The microservices use some frameworks/libraries:
- **[spring-boot](https://spring.io/projects/spring-boot)** is a common framework to develop a Java application easily because most of the things have a simple configuration.
- **[springdoc-openapi](https://springdoc.org/)** is an implementation of the standard of Open API 3 to document the different endpoints of the microservices. Also, give you the chance to test each endpoint with some data of example.
- **[chaos-monkey](https://codecentric.github.io/chaos-monkey-spring-boot/)** is a library that simulate random problems in the microservices following the principles of **[Chaos Engineering](https://www.gremlin.com/community/tutorials/chaos-engineering-the-history-principles-and-practice/)** like latency, exceptions. The idea to use this tool is to help to the developers to simulate random problems in the different microservices in a simple way.
- **[orika](https://orika-mapper.github.io/orika-docs/)** is a library that helps to map the values from one object to another.
- **[snakeyaml](https://bitbucket.org/asomov/snakeyaml/src/master/)** is a library to use YML files as resources in the different microservices.

