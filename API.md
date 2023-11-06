# Purpose of this document
This document describes what REST services this application provides. It contains all needed information so that client can be implemented. 

# REST resources (services)
1.	Get all items -> http://localhost:8080/rest/items/ 
2.	Get an item by id-> http://localhost:8080/rest/items/{id}     
3.	Get all categories -> http://localhost:8080/rest/categories/ 
4.	Get a category by id -> http://localhost:8080/rest/categories/{id} 
5.	Get all items in a category -> http://localhost:8080/rest/categories/{id}/items
6.	Get all manufactures -> http://localhost:8080/rest/manufactures/
7.	Get a manufacturer by id -> http://localhost:8080/rest/manufacturer/{id}


# REST requests and responses
### 1 Get all items
HTTP method: GET

API call: http://localhost:8080/rest/items/

Request body: - 

Response example below:

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

### 2 Get an item by id

# HTTP methods

