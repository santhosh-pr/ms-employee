# ms-employee
 ## to read the property value from spring-cloud-config server
 
`add bootstrap.yml` . -- looks for application name in config server
**
spring:
 application:
    name: ms-employee   
   
 cloud:
    config:
      uri: http://localhost:7000
      
      
**      
`in applicatiuon.yml`

server:
  port: 8000
spring:
  profiles:
    active: dev
    

`add client dependency in pom.xml`
