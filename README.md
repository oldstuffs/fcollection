# fcollection

## Usage

### Requirements

- Java 11+
- MongoDB

### Build The Project

Have maven installed

`mvn clean package`

Haven't maven installed

`mvnw clean package`

### Api

#### MovieEntry As Body

```json
{
  "name": "name",
  "description": "description",
  "genre": "string",
  "mediaUrl": "media url",
  "performers": [
    {
      "name": "performer name",
      "lastName": "performer last name",
      "role": "performer role"
    }
  ],
  "released": "dateAsMillisecond",
  "supportedLanguages": [
    "tr_TR",
    "en_US"
  ]
}
```

#### Adding Movies

`POST http://localhost:8080/movies `

_with MovieEntry as body_

#### Changing Movie

`PUT http://localhost:8080/movies/{id}`

_with MovieEntry as body_

#### Deleting Movie

`DELETE http://localhost:8080/movies/{id}`

#### Getting Movies

`GET http://localhost:8080/movies`

_with requested parameters_
- genre
- name
- performer
- sortByDate

All parameters are optional.

Example usage for getting movies:

Getting movies by name:

`GET http://localhost:8080/movies?name=Movie 1`

Getting movies by name and genre

`GET http://localhost:8080/movies?name=Movie 1&genre=action`
