# Spring Boot Client & Server OAuth2 InMemory Authentication Example
Client Side Spring Boot UI Application and integration with Authorization+Resource Server Spring Boot using OAuth2


#### 1) spring-security-oauth-client - Client Project which has the UI
#### 2) spring-security-oauth-server - Has the Authorization Server and Resource Server

http://localhost:8080/ui - REST end point for Client Side UI, after logging into the auth server http://localhost:8081/auth/login The UI side application will take you to the secure URI http://localhost:8080/secure 

After getting access_token futher you can requst from client side UI to Resource Server Secure REST end point
http://localhost:8081/auth/rest/resource/hello
