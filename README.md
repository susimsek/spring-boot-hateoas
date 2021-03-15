# Spring Boot Hateoas Rest Api
> Spring Boot Hateoas Example
>
<img src="https://github.com/susimsek/spring-boot-hateoas/blob/main/images/spring-boot-hateoas.png" alt="Spring Boot Hateoas" width="100%" height="100%"/> 

## Prerequisites

* Java 11
* Maven 3.3+
* Docker 19.03+
* Docker Compose 1.25+

## Installation


```sh
./mvnw compile jib:dockerBuild
```


```sh
docker-compose up -d 
```

## Installation Using Vagrant

<img src="https://github.com/susimsek/spring-boot-hateoas/blob/main/images/vagrant-installation.png" alt="Spring Boot Vagrant Installation" width="100%" height="100%"/> 

### Prerequisites

* Vagrant 2.2+
* Virtualbox or Hyperv

```sh
vagrant up
```

```sh
vagrant ssh
```

```sh
cd vagrant/setup
```

```sh
sudo chmod u+x *.sh
```

```sh
./install-prereqs.sh
```

```sh
exit
```

```sh
vagrant ssh
```

```sh
./mvnw compile jib:dockerBuild
```


```sh
docker-compose up -d 
```

You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

You can access the Kibana from the following url.

http://localhost:5601

## Used Technologies

* Spring Boot 2.4.3
* Elasticsearch
* Kibana
* Spring Boot Web
* Content Negotiation Support(Xml,Json,Yaml Support)  
* Spring Boot Hateoas  
* Spring Boot Log4j2
* Problem Spring Web
* Spring Boot Actuator
* SpringDoc Openapi Web Mvc Core
* SpringDoc Openapi Web Ui
* Maven Jib Plugin
* Maven Clean Plugin
* Maven Enforcer Plugin
* Maven Compiler Plugin
* Lombok
* Mapstruct  
* Dev Tools
* Spring Boot Test

## SpringDoc OpenApi

> You can access the SpringDoc Openapi from the following url.

http://localhost:9090/api

<img src="https://github.com/susimsek/spring-boot-hateoas/blob/main/images/springdoc-openapi.png" alt="SpringDoc Openapi" width="100%" height="100%"/> 