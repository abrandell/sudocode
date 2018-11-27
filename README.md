# sudoCode

A web-app for Github devs to find and share ideas for side projects. 

[Live Preview on Heroku](https://www.sudocode.org)
---
[Angular Front End](https://github.com/abrandell/sudocode-client)

To run the site in it's current state on a local server, you'll need to create an OAuth2 Github app
(or use an existing OAuth Github client id/secret) as well as remove the Github OAuth login link (in the [frontend](https://github.com/abrandell/sudocode-client)) 
and replace it with `<your-home-page-url>/oauth2/authorization/github`

You'll also either need to use the docker-compose.yml file included:
 ```yaml
version: '3.1'

services:

  mysql-dev:
    image: mysql:5.7
    ports:
      - 3308:3306
    environment:
      MYSQL_ROOT_PASSWORD: root
      MYSQL_DATABASE: sudodev
      MYSQL_USER: developer
      MYSQL_PASSWORD: password
```
 and run MySQL in a container (or locally installed).
 
 Or just use an in-memory DB like H2.

## Technologies Used (so far)

* [Spring Boot 2.1.0](https://spring.io/)
* [Angular 7](https://angular.io/) 
* [MySQL](https://www.mysql.com/)
* [Cloudflare](https://www.cloudflare.com)
* [Heroku](https://www.heroku.com/)
