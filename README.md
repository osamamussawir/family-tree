# family-tree

Requirements:

* Maven
* Java 8+

Used Dependencies:
* Spring Boot
* H2 Database (in memory)
* Flyway (DB migration)
* Lombok

Command to starting the server:
* mvn spring-boot:run

Endpoint to access H2 DB:
* http://localhost:8080/h2-console
* spring.datasource.url=jdbc:h2:file:~/family_tree
* spring.datasource.username=sa
* spring.datasource.password=

Endpoints Exposed:
* GET http://localhost:8080/person/10006/parents -> List parents
* GET http://localhost:8080/person/10001/childrens -> List childrens of member by ID
* GET http://localhost:8080/person/10003/descendants -> List all descendants of member
* GET http://localhost:8080/person/10009/ancestors -> List all ancestors of member
* POST http://localhost:8080/person -> add the member
  ``{
  "id": 10009,
  "father" : {
  "id": 10007
  },
  "mother" : {
  "id": 10006
  },
  "name": "shery"
  }``

TODO (because of time shortage):
* Add automation test case
* Add proper exception handling
* Add proper logging