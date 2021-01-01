**_About the application_**

The application defines the below concepts
1. Company
2. Owner

**_Run the Application_**

To run the application, run the following command in a terminal window directory:

./mvnw spring-boot:run

**_Security**_ 

As the user ssn is sensitive information, all the API's are secured with spring security and with basic auth username and password.
Below  is the set of users with their respective role, defined in-memory.

1. username --> "guest" : password --> "guest1234" : Role "USER"
2. username -->"admin"  : password --> "admin1234" : Role "ADMIN"
Only the ADMIN role users can access the api with deals with user ssn. 
   The API Info section lists the api's which roles can access it.
   

**_Database_**

The application uses in-memory H2 database, the database UI can accessed via http://localhost:9092/h2-console
with a username as "sa" and password as "password".
All the operations performed to database will vanish if application stops or gets restarted.

**_API Info_**

Below is the list of API operations available with there respective cURL command

1. Create a single/multiple company(s) --> Accessible by users with Role as "USER"
   
   curl -X POST \
   http://localhost:9092/companies \
   -H 'Accept: */*' \
   -H 'Accept-Encoding: gzip, deflate' \
   -H 'Authorization: Basic Z3Vlc3Q6Z3Vlc3QxMjM0' \
   -H 'Cache-Control: no-cache' \
   -H 'Connection: keep-alive' \
   -H 'Content-Length: 248' \
   -H 'Content-Type: application/json' \
   -H 'Cookie: JSESSIONID=C1036D73CFD74BA5E741970103926E94' \
   -H 'Host: localhost:9092' \
   -H 'Postman-Token: b078ea8a-0084-493a-840b-483c70b50463,ee0276d7-bc9c-4458-bc8d-29b4a181e0c7' \
   -H 'User-Agent: PostmanRuntime/7.17.1' \
   -H 'cache-control: no-cache' \
   -d '{
   "companyList":[
   {
   "companyName":"ABC",
   "companyCountry":"IND",
   "companyPhone":"1234567"
   },
   {
   "companyName":"XYZ",
   "companyCountry":"IND",
   "companyPhone":"7654321"
   }
   ],
   "requestContext":{
   "requestId":"req-1234567"
   }
   }'
   

2. Get a list of all companies --> Accessible by users with Role as "USER"
   
   curl -X GET \
   http://localhost:9092/companies \
   -H 'Accept: */*' \
   -H 'Accept-Encoding: gzip, deflate' \
   -H 'Authorization: Basic Z3Vlc3Q6Z3Vlc3QxMjM0' \
   -H 'Cache-Control: no-cache' \
   -H 'Connection: keep-alive' \
   -H 'Content-Type: application/json' \
   -H 'Cookie: JSESSIONID=F7C8E94A7DA75E67C011B56F98AD6E16' \
   -H 'Host: localhost:9092' \
   -H 'Postman-Token: 5b04e1d7-e219-4ad0-bc0b-edd36f928ff9,2daf9cc0-646e-45a6-8ce6-9939a91a869b' \
   -H 'User-Agent: PostmanRuntime/7.17.1' \
   -H 'cache-control: no-cache'
   

3. Get details about a company --> Accessible by users with Role as "ADMIN"

curl -X GET \
'http://localhost:9092/company?name=ABC' \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Authorization: Basic YWRtaW46YWRtaW4xMjM0' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Type: application/json' \
-H 'Cookie: JSESSIONID=2EDBE43965FC452A80C2B2E9D95CC4A2' \
-H 'Host: localhost:9092' \
-H 'Postman-Token: 99c00f73-5e1e-43af-989e-4fff3e01e57f,14d58f8d-384c-49d1-80c3-2e52c565a7aa' \
-H 'User-Agent: PostmanRuntime/7.17.1' \
-H 'cache-control: no-cache'

4. Update a company --> Accessible by users with Role as "USER"

curl -X PUT \
http://localhost:9092/companies/ABC \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Authorization: Basic Z3Vlc3Q6Z3Vlc3QxMjM0' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Length: 87' \
-H 'Content-Type: application/json' \
-H 'Cookie: JSESSIONID=4C6544171857680CE140A26AD3792F89' \
-H 'Host: localhost:9092' \
-H 'Postman-Token: 6e349dc0-a468-4b12-aaa3-52c293572296,a5e57e1a-795a-4e08-bee1-25f74e2e0dd2' \
-H 'User-Agent: PostmanRuntime/7.17.1' \
-H 'cache-control: no-cache' \
-d '{
"companyName":"ABC",
"companyCountry":"UK",
"companyPhone":"7864434567"
}'

5. Add an owner of the company --> Accessible by users with Role as "ADMIN"

curl -X POST \
http://localhost:9092/owner \
-H 'Accept: */*' \
-H 'Accept-Encoding: gzip, deflate' \
-H 'Authorization: Basic YWRtaW46YWRtaW4xMjM0' \
-H 'Cache-Control: no-cache' \
-H 'Connection: keep-alive' \
-H 'Content-Length: 274' \
-H 'Content-Type: application/json' \
-H 'Cookie: JSESSIONID=D710AF4B83BD227E1A0C044456B6B0BF' \
-H 'Host: localhost:9092' \
-H 'Postman-Token: cc2b0768-eec7-4bb7-b441-c13f5ff10782,53ae3cb2-4af2-4ffd-af00-5bc406a31b50' \
-H 'User-Agent: PostmanRuntime/7.17.1' \
-H 'cache-control: no-cache' \
-d '{
"ownersList":[
{
"ownerName":"Owner1",
"ownerSsn":"ssn98765",
"company":
{
"companyId":1
}
},
{
"ownerName":"Owner2",
"ownerSsn":"ssn654328",
"company":
{
"companyId":2
}
}
],
"requestContext":{
"requestId":"req987654"
}
}'

6. Check of Social Security Number --> Accessible by users with Role as "ADMIN"
   
   curl -X GET \
   http://localhost:9092/owner \
   -H 'Accept: */*' \
   -H 'Accept-Encoding: gzip, deflate' \
   -H 'Authorization: Basic YWRtaW46YWRtaW4xMjM0' \
   -H 'Cache-Control: no-cache' \
   -H 'Connection: keep-alive' \
   -H 'Content-Length: 8' \
   -H 'Content-Type: application/json' \
   -H 'Cookie: JSESSIONID=D2329BC90DFFDDD67673634B5E59C03E' \
   -H 'Host: localhost:9092' \
   -H 'Postman-Token: 0b2ee3ae-d4d8-4a78-ad0f-fe4ece777513,1545cde0-af70-4550-b0cb-62bedb075e55' \
   -H 'User-Agent: PostmanRuntime/7.17.1' \
   -H 'cache-control: no-cache' \
   -d ssn98765
   

**_Containerize application_**

Creating docker build image, as we are using maven we can use the maven to create docker image, Please use the below command
 mvnw spring-boot:build-image

Once the image is ready run the below command to start the application 
 docker run --tty --publish 9092:9092 co-0.0.1-SNAPSHOT

When application is up and running you can use the above curl commands 


Future Aspects
1. Logging
2. Specific error messages fetched via properties file
3. Validating classes to be in place, that is before forwarding request to service impl the request parmas gets validated against the allowed set of values.
4. Integration test cases
5. Adding support for microservices
6. Replacing in memory database with actual database
7. Support for Oauth and token based security