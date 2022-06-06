#Covid 19 APP
##Covid 19 vaccination slot booking application for demo purposes

###Bundling application using maven
####Create jar file
`mvn clean install`

####run the application
`java -jar covid-19-app-1.0.0.jar`

###REST API Endpoints

1. List all the Vaccination slots 

`GET http://localhost:8080/api/v1/slots`

2. Book Vaccination Slot with following details

`POST http://localhost:8080/api/v1/slots/booking`

Input Body

``{
"slot_date":"2022-06-21",
"hospital_name":"Govind Ballabh Pant Hospital",
"person_name":"John Doe",
"aadhaar_card":"123412341234",
"mobile":"9874561230",
"age":"25"
}``

3. Cancel Vaccination Slot booking using aadhaar card used while booking the slot

`PUT http://localhost:8080/api/v1/slots/booking/cancel/{aadhaar-card-no}`

Note: This is just a simple application not for real use.