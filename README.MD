## Register User

Endpoint : POST api/users

`Request Body`
```json
{   "name" : "suprianto sitompul",
    "username": "suprianto772",
    "password": "rahasia123",
}
```


`Response Body (Success) : 200`

```json
{
    "status" : "success"
}
```

 `Response Body (Failed) : 401`
 ```json
 {
    "error" : "Not Found",
    "message" : "Username cannot blank"
 }
```

 ## Login
 Endpoint: POST /api/auth

 `Request Body`

