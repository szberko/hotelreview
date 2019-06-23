# Hotel Review

A hotel review backend webapp.

Requirements to compile and run the app:
- Maven
- AdoptJDK 11

Run the following to build:
```
mvn clean install
```

Run the following to start the app:
```
java -jar ./target/<name_of_the_app>.jar
```

Build docker image:
```
mvn clean package docker:build
```

Run docker image:
```
docker run -p 8080:8080 hotel-review
```

To test the application, you can use Swagger at:
```
/swagger-ui.html
```

## Concept:
There should be two type of users: ADMIN and USER. Admins responsibility is to 
add, edit or delete hotels. Users can view the list of all hotels or take a 
look on a specific one. User cannot add, edit or delete hotels. Users can create
a review of hotels. A review should contain a score from 1-5 and a review description.
Users can LIKE or DISLIKE a review what has been wrote by other users. 
Users can collect list of favorite hotels also.