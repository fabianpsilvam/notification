## Notification

Send notifications for email and tracking

### Install dependencies

* Install docker services

`docker-compose up -d`

### Run locally

* Run on server port 8082

`./mvnw spring-boot:run`

### Consumer kafka manager

`TOPIC=ms-notification`
`Message={"type":"tracking","user":"zebrands","params":"action-microservice"}`
