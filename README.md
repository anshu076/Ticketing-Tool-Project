# Ticketing-Tool-Project
**# Built a ticketing tool application using springboot framework to register tickets and manage ticket queue**

The users can leverage this application to perform below taks:

1) Users can create a tiket by providing details like ticket id, tiket name and ticket date and they can further map this ticket to a specific project category.
2) Multipe project categories can be created to distribute the tickets and they can be accessed using project id.
3) Users can track and update their ticket queue by performing multiple operations like adding a ticket, updating ticket details or deleting a ticket from queue.
   

**Tech stack** - java, springboot, Rest Api, maven, MySql, Tomcat



**Project Architecture**


                          CONTROLLER ADVICE       
                                 |
                                 |
                                 |
CLIENT ----> CONTROLLER ----> SERVICE ----> DAO ----> DATABASE

                                

**Work process**

1) Basic Setup:
   
   a) Designed the project architecture using controller layer, service layer, DAO and then database layer.
   b) Added all the required dependencies like starter, jpa and devtools using maven.

2) Controller Layer:
   
   a) Developed several endpoints in the controller layer, separately for two entities - ticket and project.
   b) Users requests will reach a REST endpoint and will be processed further to a dedicated service layer.

3) Service Layer:

   a) Service layer will have driving logics to validate and process the inputs collected from user end.
   b) Once the processing is done at the service layer, the outcomes will be pushed forward to Dao layer.

4) Controller Advice Layer:

   a) While the inputs are getting validated in service layer, multiple exceptions may get thrown due to server issues or client inputs.
   b) The exceptions will be resolved using several exception handlers and the handlers will also help in sending a customized message to client stating the reason 
      of failure.

5) Dao Layer :
   
   a) Dao will have repository related logics to save, update and delete the entries.
   b) The outcomes will be finally stored in the backend database.

6) Output : Created jsp pages to display the API outcomes to the client.


Simple DEMO of the requests and the responses from application :

INPUT :
[Click here to see the user inputs](https://drive.google.com/file/d/1Dfm-qtmk4GbthCtAvMwWuqn3UkO13Yc9/view?usp=drivesdk) 










