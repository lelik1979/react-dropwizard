# POC how to use dropwizard and react

How to start the POC how to use dropwizard and react application
---

1. You need to install yarn
    `brew install yarn` 
1. Run `mvn clean install` to build your application
1. Start application with `java -Xbootclasspath/p:alpn-boot-8.1.13.v20181017.jar -jar dropwizard-react-server/target/dropwizard-react-server-1.0-SNAPSHOT.jar server dropwizard-react-server/config.yml`
1. To check that your application is running enter url `https://localhost:8080`

