# MS3 Contact API
 
### Problem:
MS3 is in need of a contact management API.  This API will take the following data model and will commit it to a database.  We need this to support the full CRUD operations but also full and incremental updates.  The DBA is out of town for the next week and we need this ASAP. Take liberty to design the database components that will support the API and data model.  We need this to follow API Best practices as this will be customer facing and high visibility.
 
One of our corporate goals is to not build pointed solutions.  Keep in mind that we want to be able to reuse components to support other development and API initiatives in the organization.
```sh
{
   "Identification":{
      "FirstName":"Bob",
      "LastName":"Frederick",
      "DOB":"06/21/1980",
      "Gender":"M",
      "Title":"Manager"
   },
   "Address":[
      {
         "type ":"home",
         "number":1234,
         "street":"blah blah St",
         "Unit":"1 a",
         "City":"Somewhere",
         "State":"WV",
         "zipcode":"12345"
      }
   ],
   "Communication":[
      {
         "type":"email",
         "value":"bfe@sample.com",
         "preferred":"true"
      },
      {
         "type":"cell",
         "value":"304-555-8282"
      }
   ]
}
```



### Minimum Requirements
  - Code should be submitted via email with a link to a Github or Bitbucket repository
  - You can utilize pure Java, Spring Boot, Mulesoft, Python or Go to accomplish this task
  - Provide instructions for running the application(s) should be listed in a README.md
  - API Must be a RESTful API that adheres to industry best practices
  - Provide SQL statement for table design
  - Provide diagram for table association
 
### “Nice to Have” Requirements:
  - UI/Web Application
  - Get creative with this portion of the project, how would you best utilize/demonstrate this API
  - What we’ve seen in the past
  - HTML should have form based input fields
  - HTML should have a submit button
  - HTML should have a table that represents the (R)ead response of data
  - HTML should show the response information of CUD operations
 
### Bonus Requirements
  - Provide Contact sorting in UI
  - Working Cloud deployment
  - AWS, Azure or Google Cloud
  - Dockerized Containers
  - CI/CD script
  - Unit Test cases

