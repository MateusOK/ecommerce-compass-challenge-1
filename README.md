# E-commerce | Compass 1st Challenge

## How to Prepare the Environment?

### IDE

First things first, you need to have an IDE (Integrated Development Environment) installed. To install IntelliJ IDEA, follow this [link](https://www.jetbrains.com/idea/download/).

If you encounter errors or difficulties while trying to install your IDE, here's a YouTube tutorial on how to do it:

[![Video](https://i.ytimg.com/vi/viNG3VVnzFE/hq720.jpg)](https://www.youtube.com/watch?v=viNG3VVnzFE)

---

### Attention!

After installing your IDE, make sure to install the Java JDK (Java Development Kit) as well. When creating a new project on IntelliJ IDEA, it already gives you the option of installing the JDK.

Also, make sure to install version 17 or newer.

![image](https://github.com/MateusOK/ecommerce-compass-challenge-1/assets/84550655/e18ad64e-d7d8-4d14-b4dd-d2edc7506c67)

---

### Database

After installing your IDE, you need to install the MySQL Database. To install it, just follow this [link](https://dev.mysql.com/downloads/installer/).

If needed, you can refer to this YouTube tutorial:

[![Video](https://i.ytimg.com/vi/VK4nTHqbcMg/hq720.jpg)](https://www.youtube.com/watch?v=VK4nTHqbcMg)

---

### Set User and Password for Database Connection

You're almost done! The last thing you need to do is declare your URL, USER, and PASSWORD for the database connection.

### How to do it?

To do it, you just have to go to the "Connector" class and change the constants with your credentials:

```java

public class Connector {
    private static Connection connection;

    private static final String PASSWORD = ""; //set your database password
    private static final String USER = ""; //set your database user
    private static final String URL = ""; //usually: "jdbc:mysql://localhost:3306/"
    
```


## All set!

Now you're good to go and test my application. To do so, you just need to run the "Main" class. I hope you like it, enjoy!

---

# Important notes

- Use MySQL version 8.0.33 and the provided dependency for its connection to avoid compatibility problems.
- If you're using another version of MySQL, you can find the JAR dependency <a href="https://downloads.mysql.com/archives/c-j/">here</a>. 

---

## Technologies

In this project, the following techlogies were used:

- Java
- MySQL

---

## Thanks!

I'd like to thank @Compass.UOL for the opportunity and for putting my knowledge to the test. Thanks for this challenge and those yet to come.


## Author

Developed by <a href="https://www.linkedin.com/in/mateus-ribeiro-1779491a7/">Mateus Ribeiro</a>.
