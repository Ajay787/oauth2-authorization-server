# OAuth

#####Generate token(POST)#######

URL: http://localhost:8080/oauth/token

Authorization : Basic

UserName  client

Password  password

Body:formdata

username admin

password secret

grant_type password

Responnse
{
    "access_token": "c267520a-e897-4e28-8f8c-ac16ef3d1972",
    "token_type": "bearer",
    "expires_in": 4499,
    "scope": "read write"
}

--------------------------------

########Validate token#######

URL: http://localhost:8080/oauth/check_token

Authorization : Basic

UserName  client

Password  password

Body:formdata

token c267520a-e897-4e28-8f8c-ac16ef3d1972

Responnse
{
    "active": true,
    "exp": 1591815415,
    "user_name": "admin",
    "authorities": [
        "ROLE_ADMIN"
    ],
    "client_id": "client",
    "scope": [
        "read",
        "write"
    ]
}

-----------------------

#Logout Get

http://localhost:8080/oauth/revoke-token?token=b4fcc618-337b-4bc2-8c79-d96dcbf55501




