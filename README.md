
COURIER TRACKING

Courier Tracking is a restful web application with Java, that mainly
takes streaming geolocations of couriers (time, courier, lat, lng) as input.

- The application logs courier and store when any courier enters radius of 100 meters from Migros
  stores. Reentries to the same store's circumference over 1 minute are not count
  as "entrance". Store locations are given as stores.json file.
- The application provides a way for querying total distances, over which any
  courier travels.


TECHOLOGY STACK 

• Java 8
• Spring Boot
• Swagger
• Apache Maven
• Spring Data JPA
• ModelMapper
• PostgreSQL
• IntelliJ IDEA


PROJECT STRUCTURE

Layered Architecture
![img.png](img.png)