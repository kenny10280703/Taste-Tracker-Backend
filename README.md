# Taste-Tracker-Backend
This is a university group project aimed at creating a website that displays restaurants within a one-mile radius of the user's location. The project focuses on the Newcastle area and currently includes a demo database with information for approximately 30 restaurants.

## Overview
- This repository includes backend source code only.
- For frontend part and demonstration, please visit my frontend repository: https://github.com/kenny10280703/Taste-Tracker-React
- The backend performs CRUD on SQL database, and return requested data to frontend through APIs.

## Components
1. Controller:
- Responsible for handling incoming HTTP requests from the frontend.
- Implements RESTful endpoints for retrieving restaurants within one mile and getting a restaurant by ID.
- Uses DTOs to parse and validate incoming request data.
- Utilises the DTO Mapper to convert entities to DTOs and vice versa.
- Interacts with the Service layer.

2. Service Layer:
- Contains the business logic of the application.
- Communicates with the Repository layer to perform database operations.
- Implements the logic to calculate the range of latitude and longitude within one mile of the user's location.

3. Repository Layer:
- Interfaces with the database using JPA (Java Persistence API).
- Contains methods to perform CRUD (Create, Read, Update, Delete) operations on the database.
- Executes JPA queries to retrieve restaurants within one mile of the user's location or to retrieve a restaurant by id.

4. Entity Classes:
- Represent the data model of the application and correspond to database tables.
- Annotate entity classes with JPA annotations (@Entity, @Table, etc.).
- Reflect the structure of the database and its relationships.

5. DTO (Data Transfer Object) Classes:
- Used to transfer data between the frontend and backend.
- Represent the structure of request and response data in a more meaningful way.
- Separate the data presentation from the data persistence.

6. DTO Mapper:
- Converts Entity objects to DTOs.
- Ensures that entities are not exposed directly to the frontend, promoting data encapsulation.
- Helps manage data mapping between different layers of the application.

## Request Flow
1. Frontend sends a POST request to the backend API endpoint /tastetracker/restaurants/ with the user's location in the request body.
2. The Controller layer receives the request and parses the request body into the LocationRequest DTO. The Controller invokes the Service layer method responsible for calculating the range of latitude and longitude within one mile of the user's location.
3. The Service layer interacts with the Repository layer to perform a JPA query and retrieve restaurants within the calculated range.
4. The Repository layer executes the JPA query on the database and returns a list of restaurant entities.
5. The Service layer converts the restaurant entities to a list of RestaurantDTO objects using the DTO Mapper.
6. The Controller sends the list of RestaurantDTO objects as the response to the frontend.
7. For the "Get Restaurant by ID" endpoint, the flow is similar, but instead of returning a list, the Controller will return a single RestaurantDTO object.

## API Documentation
### Overview
Two APIs were created: 
1. frontend send post request with user's location as request body, backend to respond with a list of restaurant within 1 mile of user.
2. front send get request to get restaurant by id.

### Authentication
No authentication is required to access the restaurant endpoints.

### Endpoints
**Get all restaurants withion one mile of user**
Endpoint: `POST /tastetracker/restaurants`
#### Request Body
{
  "latitude": double,
  "longitude": double
}

#### Response
Status: 200 OK
Content-Type: application/json
[
  {
    "id": long,
    "name": string,
    "address": string,
    "phoneNumber": string,
    "latitude": double,
    "longitude": double,
    "overallRating": double,
    "cuisine": string,
    "operatingHoursOfTheWeek": string[],
    "menuLink": string,
    "websiteLink": string,
    "averageCostOfADish": double,
    "distanceFromUser": double,
    "approximateWalkingTimeFromUser": double,
    "imagesLink": string[]
  }
]

**Get restaurant by id**
Endpoint: `GET /tastetracker/restaurants/{id}`
#### Response
Status: 200 OK
Content-Type: application/json
{
  "id": long,
  "name": string,
  "address": string,
  "phoneNumber": string,
  "latitude": double,
  "longitude": double,
  "overallRating": double,
  "cuisine": string,
  "operatingHoursOfTheWeek": string[],
  "menuLink": string,
  "websiteLink": string,
  "averageCostOfADish": double,
  "distanceFromUser": double,
  "approximateWalkingTimeFromUser": double,
  "imagesLink": string[]
  }
