# Testing your test

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

The project contain all the logic to have a real scenario about an application which have acceptable coverage of testing on Sonar.


## Table of contents

The following are the most important topics in this file:
- [Requirements](#Requirements)
- [Structure](#Structure)
- [Technologies](#pipeline-steps)
- [Run the CI](#run-the-ci)
- [Considerations](#Considerations)
- [Further readings](#further-readings)


# Requirements

To use these tools you need to have in your machine the following things:
- [Git](https://git-scm.com/)
- [Docker](https://www.docker.com/)

If you don't have some of these tools in your machine installed, please follow the instructions in the official documentation of each tool.


# Structure

The CI use [Jenkins](https://www.jenkins.io/) which is one of the most used tools. Also, during the execution of the pipeline Jenkins calls to [Sonarqube](https://www.sonarqube.org/) which contain all the information about the quality of each microservice. 

To reduce the complexity in the configuration most of these tools are preconfigured with the microservices that are connected with **TWA**. The only thing that you need to do is build and run the dockerfiles and open a browser.


# Technologies

The microservices use some frameworks/libraries:
- **[spring-boot](https://spring.io/projects/spring-boot)** is a common framework to develop a Java application easily because most of the things have a simple configuration.
- **[springdoc-openapi](https://springdoc.org/)** is an implementation of the standard of Open API 3 to document the different endpoints of the microservices. Also, give you the chance to test each endpoint with some data of example.
- **[chaos-monkey](https://codecentric.github.io/chaos-monkey-spring-boot/)** is a library that simulate random problems in the microservices following the principles of **[Chaos Engineering](https://www.gremlin.com/community/tutorials/chaos-engineering-the-history-principles-and-practice/)** like latency, exceptions. The idea to use this tool is to help to the developers to simulate random problems in the different microservices in a simple way.
- **[orika](https://orika-mapper.github.io/orika-docs/)** is a library that helps to map the values from one object to another.
- **[snakeyaml](https://bitbucket.org/asomov/snakeyaml/src/master/)** is a library to use YML files as resources in the different microservices.


# Run the CI

To run the CI, please follow these steps:
1. Clone the repository using this command **git clone git@github.com:behind-code-lines/twa-ci.git**
2. Open a terminal in the root directory and run **docker-compose build** this command builds some images that exist in the repository. After doing that, run **docker-compose up** to run all the tools.
3. If everything works fine, open a web browser in the URL which appears in the documentation section.
- [Jenkins](http://localhost:18080/)
- [Sonar](http://localhost:19000/projects)


# Considerations

There are some considerations in the use of these tools:

1. Some tools of this CI could have some problems with the limit of virtual memory. When you run the dockerfiles, check if some errors appear in the console related to "Max virtual memory areas vm.max_map_count [65530] is too low, increase to at least..". The solution for this kind of problem in Linux/Mac OS run the following command in the console:
   **sysctl -w vm.max_map_count=262144** 
   
2. This repository contains all the configurations to run the pipeline and check the quality of the code without the need to change something.
3. Jenkins does not have any password so you can write the URL in the browser and you will see the general view of the tool. In the case of SonarQube, the password is **asa123**
4. The definition of the steps in each pipeline exists on the directory of the **API**. If you want to change the location of the repository where Jenkins obtains the information of the pipeline, open each file in the folder **jenkins/jobs** and change the URL of the repository.


# Further readings

It is not the idea of this repository bring all the information about the pros/cons or more information about the tools that appear here, for that reason the following links could help you to clarify any doubt that you have:

- [Jenkins configuration](https://www.vogella.com/tutorials/Jenkins/article.html)
- [Sonarqube configuration](https://blog.setapp.pl/sonarqube_introduction)
