# Purpose of this document
This document describes what REST services this application provides. It contains all needed information so that client can be implemented. 

# REST resources (services)
1.	Get all items -> http://localhost:8080/rest/items/ 
2.	Get an item by id-> http://localhost:8080/rest/items/{id}     
3.	Get all categories -> http://localhost:8080/rest/categories/ 
4.	Get a category by id -> http://localhost:8080/rest/categories/{id} 
5.	Get all items in a category -> http://localhost:8080/rest/categories/{id}/items
6.	Get all manufacturers -> http://localhost:8080/rest/manufacturers
7.	Get a manufacturer by id -> http://localhost:8080/rest/manufacturers/{id}


# REST requests and responses
### 1 Get all items
HTTP method: GET

API call: http://localhost:8080/rest/items/

Request body: - 

Response example below:

```
[
    {
        "item_id": 1,
        "name": "Dog jacket",
        "color": "Blue",
        "size": "Medium",
        "price": 26.95
    },
    {
        "item_id": 2,
        "name": "Dog socks",
        "color": "Green",
        "size": "Extra-large",
        "price": 99.99
    }
]
```

### 2 Get an item by id
HTTP method: GET

API call: http://localhost:8080/rest/items/{id}

Request body: - 

Response example below:

```
{
  "id": 1,
  "name": "Dog jacket",
  "color": "Blue",
  "size": "Medium",
  "price": 26.95
}
```

### 3 Get all categories
HTTP method: GET

API call: http://localhost:8080/rest/categories/

Request body: - 

Response example below:

```
[
  {
    "id": 1,
    "name": "Clothing"
  },
  {
    "id": 2,
    "name": "Dogbeds"
  },
  {
    "id": 3,
    "name": "Dogtoys"
  }
]
```

### 4 Get a category by id
HTTP method: GET

API call: http://localhost:8080/rest/categories/{id} 

Request body: - 

Response example below:

```
{
  "id": 1,
  "name": "Clothing"
}
```

### 5 Get all items in a category
HTTP method: GET

API call: http://localhost:8080/rest/categories/{id}/items

Request body: - 

Response example below:

```
[
  {
    "id": 1,
    "name": "Dog jacket",
    "color": "Blue",
    "size": "Medium",
    "price": 26.95
  },
  {
    "id": 2,
    "name": "Dog socks",
    "color": "Green",
    "size": "Extra-large",
    "price": 99.99
  }
]
```

### 6 Get all manufacturers
HTTP method: GET

API call: http://localhost:8080/rest/manufacturers

Request body: - 

Response example below:

```
[
  {
    "id": 1,
    "name": "Hurtta"
  },
  {
    "id": 2,
    "name": "Rukka"
  },
  {
    "id": 3,
    "name": "Ruffwear"
  }
]
```

### 7 Get a manufacturer by id
HTTP method: GET

API call: http://localhost:8080/rest/manufacturers/{id}

Request body: - 

Response example below:

```
{
  "id": 1,
  "name": "Hurtta"
}
```

# HTTP methods

| **Http Method** | **Resource EndPoint**       | **Input**   | **Success Response**                      | **Error Response** | **Description**                    |
|-----------------|-----------------------------|-------------|-------------------------------------------|--------------------|------------------------------------|
| GET             | /rest/items                 | Body: empty | Status: 200 List of items                 | Status: 500        | Retrieves all items                |
| GET             | /rest/items/{id}            | Body: empty | Status: 200 Item data                     | Status: 500        | Retrieves an item by id            |
| GET             | /rest/categories            | Body: empty | Status: 200 List of categories            | Status: 500        | Retrieves all categories           |
| GET             | /rest/categories/{id}       | Body: empty | Status: 200 Category data                 | Status: 500        | Retrieves a category by id         |
| GET             | /rest/categories/{id}/items | Body: empty | Status: 200 List of items in a category | Status: 500        | Retrieves all items  in a category |
| GET             | /rest/manufacturers         | Body: empty | Status: 200 List of manufacturers         | Status: 500        | Retrieves all manufacturers        |
| GET             | /rest/manufacturers/{id}    | Body: empty | Status: 200 Manufacturer data             | Status: 500        | Retrieves a manufacturer by id     |
