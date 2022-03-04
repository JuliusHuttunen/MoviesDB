# MoviesDB
Spring Boot and Heroku PostgreSQL powered movie database app with Keycloak protection. Programmed for the Noroff Java Fullstack course.

## Table of Contents

- [Install](#install)
- [Usage](#usage)
- [API](#api)
- [Live](#live)
- [Keycloak](#keycloak)
- [Maintainers](#maintainers)
- [Contributing](#contributing)
- [License](#license)

## Install

Clone the repository into the directory of your choice.

```
git clone https://github.com/JuliusHuttunen/MoviesDB.git
```

## Usage

Run the project with a compatible IDE of your choice. There may be some work involved to get it running depending on your setup. IntelliJ should work the best. Alternatively you can run it as a docker container.

## API

Swagger/OpenAPI documentation and try-it-outs at endpoint ``/api/docs``. Use the query ``/api-docs`` on Swagger's search/explore bar.

Note: Swagger displays relational data as ``string``, which isn't true in the context of the program. When making 
POST or PUT requests it's better to just leave relational data ``null`` in your request body and update that data later, as relational data has dedicated endpoint mappings for updating.

### Relational data:
- Class ``movie``: ``characters``, ``franchise``
- Class ``movie-character``: ``movies``
- Class ``movie-franchise``: ``movies``

## Live

The app is deployed [here](https://moviedb-postgresql.herokuapp.com/api/docs).

## Keycloak

The app utilises an external instance of Keycloak service at Heroku to authorize API users. The service needs some time to boot up, and may return application error. Some 
patience and additional authorization requests may be required to navigate to the sign in page. In our testing, it worked 100% of times after the service had fully booted up. 

Client-id is ``my-spring-app``. Further Keycloak credentials will be provided here after the app is reviewed by Noroff to preserve database integrity.

## Maintainers

[@JuliusHuttunen](https://github.com/JuliusHuttunen)

[@Nico Behnen](https://github.com/azruim)

## Contributing

PRs accepted.

## License

MIT © 2022 Julius Huttunen &amp; Nico Behnen
