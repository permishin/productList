

<h1 align="center">Список продуктов</h1>

Тестовое задание SkillBox.
Web сервис на Spring Boot с применением Postgres, RestApi, документацией Swagger. 

## Описание функционала

Управление БД происходит через API запрос двумя контроллерами: ListController и ProductController.<br>
ListController реализует Get и Put методы для получения списка листов, создания листа, получения листа по id, записи продукта в лист.<br>
ProductController реализует так же Get и Put методы для создания продукта и вывода списка всех продуктов.

Документация по работе с API доступна в Swagger по endpoint <a href="http://localhost:8080/swagger-ui.html">http://localhost:8080/swagger-ui.html</a> (работает после запуска сервера приложения).

## Установка

1) Отдельно требуется подключение бд PostgreSQL. Ссылка на <a href="https://hub.docker.com/_/postgres">docker файл Postgres.</a><br>
1.1) Настройки подключения в application.properties.

2) Для работы с API можно использовать приложение PostMan, например.
