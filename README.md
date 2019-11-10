# Flight API

## Project is 
> Fight-API is developed for responding to the flight schdule details to with required filterations. API is supports with
- Arrival flight fiteration for selected Destination
- Arrival flight fiteration for selected Destination and selected Time
- Departing flight fiteration for selected Destination
- Departing fiteration for selected Destination and selected Time

## Technologies used
- Java 11
- Spring boot
- Spring templates
- ehChache

## Configuration
- Clone the project from GIT Project
```sh
git clone https://github.com/millesinghe/FlightAPI.git
```
- Config the application properties of server hosting Port, Ssrver host Password by using application.properties

##### Application.Properties

| Service Endpoint | Properties File Attribute | Default Value |
| ------ | ------ | ------ |
| Port | server.port | 9090
| Password |spring.security.user.password | root
| Cache Configuration | spring.cache.jcache.config | classpath:ehcache.xml

- Start the server by executing the method in 

#### Configure the Application Server Hosting Port
> Change the 'server.port' value in the "application.properties"

#### Configure the Username and Password of hosting erver.
> Change the 'spring.security.user.password' value in the "application.properties" to change the Password.

#### Configure the Caching configuration.
- To change the caching timeout period in, "ehcache.xml".
 > <expiry>
            <ttl unit="seconds">60</ttl>
 </expiry>
 
- To change the caching resource count, in "ehcache.xml".
> <heap unit="entries">2000</heap>

- To change the caching memory size, in "ehcache.xml".
>  <offheap unit="MB">100</offheap>
