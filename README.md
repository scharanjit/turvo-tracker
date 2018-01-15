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


GET REQUEST
===========

1.) To track details of Vehicle based on ```Vehicle type```

```http://localhost:8080/turvo-tracker/services/track/forVehicleType/Bus```


2.) To track details of Vehicle based on ```Vehicle id```

```http://localhost:8080/turvo-tracker/services/track/forVehicleID/HR07L4123```


3.) To track details of position with ```driver name  with vehicle type```

``http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleType/TestDriver/Bus``

4.) To track details of position with```driver name with vehicle id```

``http://localhost:8080/turvo-tracker/services/track/forDriverWithVehicleID/TestDriver/HR07L4123``

5.) To track details ``with driver name``

``http://localhost:8080/turvo-tracker/services/track/fordriver/TestDriver``