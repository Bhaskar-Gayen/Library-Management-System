## Library Management System 

#### It a microservice base web application by using Spring Boot.
### microservices are:
  - Library-Manage-service - communicate with other microservice(run on port 8090)
  - Book-Manage-microservice - handel all add/remove book related request(run on port 8080)
  - User-Manage-microservice - handel all user login/register related request(run on port 8070)

### Type of Users and functionality
- Librarian - can add/remove a book
- User - can issue a book for reading or return a book 

### Tech stack:
  - Spring Boot
  - Spring Data Jpa
  - MySQL Database
  - Thymeleaf
  - Bootstrap5

### Requirements

For building and running the application you need:
- [JDK 17](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) or newer
- [Maven 3.8](https://maven.apache.org)


### Build & Run 

```
  Library-Manage-Service port 8090
  Book-Manage-Service port 8080
  User-Manage-Service port 8070
```
  
### Port
```
  http://localhost:8090
```

## Database Table
- User - store all register user
- Librarian - store only Librarian cradiantial
- Borrow - sore all chekcout and checkin data of all user
- Book - store all books data that are aviable in the Librarie
## API Reference

#### Get all books

```http
  GET localhost:8080/books
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `null` | `string` | return List of Book Aviable |

#### Get book

```http
  GET localhost:8080/books/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### Add a book

```http
  POST localhost:8080/books
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`Object` | `Book Class` | Add a new book in Database |

#### Remove a book

```http
  DELETE localhost:8080/books/{id}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`id`      | `Integer` | **Required**. Id of item to delete |

#### Enroll a new User

```http
  POST localhost:8070/enroll
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`Object` | `User Class` | create a new User in Database |

#### Authenticate a User cradential

```http
  POST localhost:8070/userlogin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`id` `password` | `Integer` `string` | Authenticate a Admin user |

#### Authenticate a Admin cradential

```http
  POST localhost:8070/admin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`id` `password` | `Integer` `string` | Authenticate a user |


#### User issue a book

```http
  POST localhost:8070/checkin
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`Object` | `Borrow Class` | Issue a book for a user |

#### Return a book & calculate fine

```http
  GET localhost:8070/checkout/{cardId}/{bookId}
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
|`cardId` `bookId` | `Integer` `Integer` | Return a book and calculate extra charge if it late return |



## Screenshots
![home](https://user-images.githubusercontent.com/84518595/173089348-bd06a221-61b9-435d-ab83-65b59851946b.png)
![admin](https://user-images.githubusercontent.com/84518595/173089548-3d760b2c-af23-4266-84ba-5d8edcd04f07.png)
![signup](https://user-images.githubusercontent.com/84518595/173089600-d6fec164-0f1d-43d5-8c3f-b99026a5f51c.png)
![adminDashboard](https://user-images.githubusercontent.com/84518595/173089631-aaf9829e-db4b-4b32-be52-34b5dcbc48db.png)
![userDashboard](https://user-images.githubusercontent.com/84518595/173089655-9dbd4f1d-a928-4c24-95e3-1d54fa751de6.png)


## Authors

- [@BhaskarGayen](https://github.com/Bhaskar-Gayen)

