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

Run the project with a compatible IDE of your choice. May need some work to get it running depending on your setup. Alternatively you can run it as a docker container.

## API

Swagger/OpenAPI documentation and try-it-outs at endpoint ``/api/docs``. Use the query ``/api-docs`` on Swagger's search/explore bar.

Note: Swagger displays relational data as ``string``, which isn't true in the context of the program. When making 
POST or PUT requests it's better to just leave relational data ``null`` and update the data later, as relational data has dedicated endpoint mappings for updating.

## Live

The app is deployed [here](https://moviedb-postgresql.herokuapp.com/api/docs).

## Keycloak

Client-id is ``my-spring-app``. Further Keycloak credentials will be provided here after the app is reviewed by Noroff to preserve database integrity.

## Maintainers

[@JuliusHuttunen](https://github.com/JuliusHuttunen)

[@Nico Behnen](https://github.com/azruim)

## Contributing

PRs accepted.

## License

MIT © 2022 Julius Huttunen &amp; Nico Behnen
