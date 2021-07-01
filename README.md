======================================================== <br/>
Tri Polymer Spring Boot JWT Frontend API <br/>
======================================================== <br/>

It will be a full stack, with Spring Boot for back-end and Angular 11 for front-end. 
The system secured by Spring Security with JWT Authentication & also with Swagger UI. <br/>

================================================================================================================ <br/>
Spring Boot Registration & Login with JWT Authentication Flow <br/>
The diagram shows flow of how we implement User Registration, User Login and Authorization process. <br/>
================================================================================================================ <br/>

https://bezkoder.com/wp-content/uploads/2020/11/spring-boot-jwt-authentication-postgresql-spring-security-flow.png

A legal JWT must be added to HTTP Authorization Header if Client accesses protected resources.
You will need to implement Refresh Token:

https://bezkoder.com/wp-content/uploads/2021/04/spring-boot-refresh-token-jwt-example-flow.png

================================================================================================================ <br/>
Spring Boot Server Architecture with Spring Security <br/>
You can have an overview of our Spring Boot Server with the diagram below: <br/>
================================================================================================================ <br/>

https://bezkoder.com/wp-content/uploads/2020/11/spring-boot-jwt-authentication-postgresql-spring-security-architecture.png

Now I will explain it briefly.

======================================================== <br/>
Spring Security <br/>
======================================================== <br/>

– WebSecurityConfigurerAdapter is the crux of our security implementation. It provides HttpSecurity configurations to configure cors, csrf, session management, rules for protected resources. We can also extend and customize the default configuration that contains the elements below. <br/>
– UserDetailsService interface has a method to load User by username and returns a UserDetails object that Spring Security can use for authentication and validation. <br/>
– UserDetails contains necessary information (such as: username, password, authorities) to build an Authentication object. <br/>
– UsernamePasswordAuthenticationToken gets {username, password} from login Request, AuthenticationManager will use it to authenticate a login account. <br/>
– AuthenticationManager has a DaoAuthenticationProvider (with help of UserDetailsService & PasswordEncoder) to validate UsernamePasswordAuthenticationToken object. If successful, AuthenticationManager returns a fully populated Authentication object (including granted authorities). <br/>
– OncePerRequestFilter makes a single execution for each request to our API. It provides a doFilterInternal() method that we will implement parsing & validating JWT, loading User details (using UserDetailsService), checking Authorizaion (using UsernamePasswordAuthenticationToken). <br/>
– AuthenticationEntryPoint will catch authentication error. <br/>

Repository contains UserRepository & RoleRepository to work with Database, will be imported into Controller.
Controller receives and handles request after it was filtered by OncePerRequestFilter.

– AuthController handles signup/login requests <br/>
– TestController has accessing protected resource methods with role based validations. <br/>

Understand the architecture deeply and grasp the overview more easier:
Spring Boot Architecture for JWT with Spring Security

======================================================== <br/>
Technology <br/>
======================================================== <br/>

Java 8 <br/>
Spring Boot 2.2.11 (with Spring Security, Spring Web, Spring Data JPA) <br/>
jjwt 0.9.1 <br/>
PostgreSQL <br/>
MySQL <br/>
InMemory <br/>
Maven 3.6.1 <br/>
