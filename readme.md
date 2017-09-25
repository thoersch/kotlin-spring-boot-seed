## Description

This is a seed and example project for building a REST api in Kotlin and spring boot

## Install Gradle if you don't already have it

```$xslt
brew install gradle
```

## Running the API

```$xslt
./gradlew bootRun
```

## Interacting

You can now interact with the API on port 8080

**GET Requests:**

```$xslt
GET 127.0.0.1:8080/users
GET 127.0.0.1:8080/users/1
GET 127.0.0.1:8080/books
GET 127.0.0.1:8080/books/1
GET 127.0.0.1:8080/users/1/books
```

**PUT Requests:**

```$xslt
PUT 127.0.0.1:8080/users/1/books
Content-Type: application/json
{ "id":1, "title":"IT", "author":"Stephen King", "isbn":"123456789123456789" }
```

**DELETE Requests**

```$xslt
DELETE 127.0.0.1:8080/users/1/books/1
```

Copyright © 2017 Tyler Hoersch

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
