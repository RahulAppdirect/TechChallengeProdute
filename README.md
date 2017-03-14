# TechChallengeProdute

AppDirect TechChallenge

Contributer : Produte Kumar Roy, Intern Engineer Email: produte.roy@appdirect.com

Date : March 14, 2017

Product's Name : ProduteDemoTest2

This project integrates AppDirect APIs with the web application "web13" running on local system and hosted on ngrok. The project has servlets which interacts with the end point urls for dealing with create and cancel subscription events.

The project has 6 packages:

1.com.produte.Controller : it contains the servlets CreateSubscription and CancelSubscription which interacts with the market place and the project. Depending upon the type of event Url received appropiate methods are called in Util and Service packages to deal with it. Appropiate responses are also forwarded from these servlets depending upon the results of the processing.

2.com.produte.Util: it contains utility classes (i)ExtractDomain.java to extract the useful fields from the JSON received which we need to store in the database. Value of these fields are set in an object and then used further for business logic and database operations.

(ii)MapJason.java to map the JSON received to the POJO class

(iii)Signing.java to perform the OAuth signature on the url received to request for the JSON from AppDirect.

3.com.produte.Domain: it contains domain classes for retrieving the useful data from the JSON. It has 6 java files : (i)AccountDomain.java (ii)CompanyDomain.java (iii)CreatorDomain.java (iv)OrderDomain.java (v)ReturnData.java (vi)TableData.java

4.com.produte.Service: it contains the classes which contains the actual business logic and call to methods in Dao package for various database operations. Java files here include: i)CancelSubsService.java ii)CheckAccountIdService.java ii)CreateTableService.java

5.com.produte.Bean: it contains the POJO class to map the JSON received to java object.

6.com.produte.dao: it contains the java files that deals with the database operations and contain the sql queries. Java files here include: i)CheckAccountIdDao.java ii)ConnectionFactoryImpl.java iii)CreateTable.java iv)DeleteData.java v)InsertData.java

It has 4 tables:

1.Creator: Which contains the details of the creator
2.Company: which contains the details of the company
3.Order1 : which contains the details of the order
4.Account: which contains the details of the account including AccountIdentifier

In all these 4 tables there is a common field "accountIdentifier" which is also the primary key in all these tables.

CreateSubscription contains the code to create the tables automatically in database on localhost. One can uncomment the code to enable the functionality.
