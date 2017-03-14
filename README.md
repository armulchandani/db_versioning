In my experience, I have observed that all applications, be it web based or non-web based deals with some kind of data storage mechanism may be RDBMS or NoSql. These applications may be simple or complex, it all depends upon the domain.


In this article we shall refer to RDBMS databases.

While interacting with RDMBS, an application developer uses JDBC API to perform all sort of common CRUD operations and while this seems to be a piece of cake, the real problem crops in when when we have a team of n developers with their own set of boxes, own DB instance and each is performing some DDL statements or some DML statements whenever there is a functionality change. And now these DDL changes need to be reflected on DB instance of remaining n-1 developers.


**Is it an easy task ? At first glance this seems to be, lets analyze the steps involved:**

1. The developer who does the change, commits the code involving this change in the version control system.
2. The developer notifies other members of this change and requests the team to execute the SQL statement(s).
3. Other members of the team update their local workspace with the latest code from the repository.
4. Execute step 2
 
 *All done, so simple and easy ?*
 
Now imagine if the respective developer forgets to notify team of step **2** and the team of n-1 developers performs step **3** and don't perform step **4** because step **2** never happened.
 
An application may fail to start on other developers respective boxes because of the change happened in step 2 , what happened suddenly ? 

A while ago it was running and after taking an update it has stopped working and there are no compilation errors also. So after some analysis, team comes to know that the application is now trying to access a new table which is not a part of local DB schema, so the **errors!!!**

In projects which follow agile methodology or in CI environment where there are lots of commits happening in a day, this is a common problem.

This article aims at eliminating step 2 & 4 by maintaining a DB version and automate the execution of SQl scripts by bootstrapping the database changes so that the database is migrated to a state before it's used by an application.

There are various ways to implement database versioning.


1. http://scriptella.org/

In past I have implemented the aforementioned library to manage database versions.


2. Flyway 

https://flywaydb.org/


The application 'DB Versioning' aims at providing a POC and consists of a simple use case to maintain database version.  

