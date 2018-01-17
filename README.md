Getting Started
===============

This ```readme``` is under construction

This is a REST web service using spring+JPA+Mongodb which will be used to save GPS data.

How to Run
==========


1.) Clone the repo

2.) Install (https://docs.mongodb.com/v3.0/tutorial/install-mongodb-on-ubuntu/) & Run the mongo db

3.) cd to project folder & run thid command
    mvn org.mortbay.jetty:maven-jetty-plugin:run
    or just do
    mvn jetty:run
    
    

4.)


Test Rest Commands
==================


````curl -i -X GET  -d username=charan@charan.com  -d password=charan http://localhost:8080/turvo-tracker/services/track/getPosition````


Output would be

````
HTTP/1.1 200 OK
Content-Type: application/json;charset=UTF-8
Transfer-Encoding: chunked
Server: Jetty(6.1.26)

{"lon":2.0,"lat":1.0,"ele":3.0}

````

POST DATA
=========

In order to post GPS data to turvo tracker, follow below steps

````
1. Run the application mvn org.mortbay.jetty:maven-jetty-plugin:run
2. Go to http://localhost:8080/turvo-tracker/
3. username:- charan@charan.com password:- charan  & submit
4. Select Upload tracks & choose file
5. Sample data is available /src/test/resources/tracks/ folder
6. Upload any .js file
7. In order to test data, follow below GET request command

````

View Posted Data
================

In order to view uploaded tracks by a user, follow below steps

````
1. Run the application mvn org.mortbay.jetty:maven-jetty-plugin:run
2. Go to http://localhost:8080/turvo-tracker/
3. username:- charan@charan.com password:- charan  & submit
4. Select Your Tracks option :- http://localhost:8080/turvo-tracker/secure/index.html#view_user_tracks

It will display the tracks file uploaded

````


GET REQUEST
===========

1.) To track details of Vehicle based on ```Vehicle type```

````

http://localhost:8080/turvo-tracker/services/track/forVehicleType/{vehicleType}

http://localhost:8080/turvo-tracker/services/track/forVehicleType/Bus

````


2.) To track details of Vehicle based on ```Vehicle id```

````

http://localhost:8080/turvo-tracker/services/track/forVehicleID/{vehicleID}

http://localhost:8080/turvo-tracker/services/track/forVehicleID/HR07L4123

````


3.) To track details of position with ```driver name  with vehicle type```

````
http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleType/{driver}/{vehicleType}

http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleType/TestDriver/Bus

````

4.) To track details of position with```driver name with vehicle id```

````

http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleType/{driver}/{vehicleID}

http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleID/TestDriver/HR07L4123

````

5.) To track details ``with driver name``

````
http://localhost:8080/turvo-tracker/services/track/fordriver/{driver}

http://localhost:8080/turvo-tracker/services/track/fordriver/TestDriver

````

6.) To track details ``with driver name  & vehicle type & datetime``

````
http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleTypeAndDate/{driver}/{vehicleType}/datetime/

http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleTypeAndDate/TestDriver/Bus/2012-10-01T09:45:00.000UTC+00:00/

````