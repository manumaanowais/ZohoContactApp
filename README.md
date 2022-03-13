# ZohoContactApp

CONTACT MANAGER APP

I have completely created the application.
I used Java Swings for frontend, java and MYSQL for backend.
I created 4 java files listed as below.

1) ZohoSignUp.java : for a user to signup.

2) ZohoSignIn.java : for a signed up user to prompt him to the contacts page.

3)Form1.java : for a signed in user to allow him to add contacts based on his own secret key.

4)conn1.java : for connecting java to MYSQL

For this application to run we need two jar files.

1)mysql-connector-java-8.0.26 : used to connect java to MYSQL (JDBC)

2)rs2xml : used for display the contacts in a table format.

Fot this application I created two login tables in a database

Database Name : zohocontact

1)Table1 : login - to store login details of users.

2)Table2 : form - to store contact details submitted by users.

To start the application, first we need to run the ZohoSignIn.java or ZohoSignUp.java as javac ZohoSignIn.java(compiling) and java ZohoSignIn(Executing)

Now, a user can Sign In if he is an existing user or he can Sign Up and then he can Sign In to start storing the contacts, based on his own secret key.

For database you have to keep the username as root and password as numaan.
