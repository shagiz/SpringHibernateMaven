Тестовое задание:
Реализовать Web приложение, которое должно иметь возможность загрузить на сервер
Excel файл, разобрать его и вставить записи из файла в БД, а также отобразить ранее загруженные
данные,где Excel файл содержит один лист с четырьмя колонками
 Код - целое число
 Наименование - строка
 Цена - число с плавающей запятой
 Дата - дата и время
Желательно придерживаться следующего технологического стека:
Spring, Hibernate, PostgreSQL, Tomcat/Jetty (стэндэлон или еще лучше в виде maven или gradle плагина)
Результирующими артефактами должны быть
 исходный код (архив или репозиторий на github), являющийся maven или gradle проектом
 пример Excel файла, который обрабатывает приложение
 краткая инструкция по установке, настройке (если есть параметры настройки) и запуску, в виде pdf файла
или README.md в репозитории

Используемые технологии:
* Maven
* JPA annotations
* PostgreSQL
* Tomcat
* Servlets
* Hibernate maven plugin
* Spring MVC
* Spring ORM

Возможности:
* JSTL загрузка страниц
* Spring MVC
* Загрузка файла
* Доступ к базе с помощью инжектов DAO

Установка и запуск:
Assuming you have setup your postgres database separately and have updated persistence.xml to point at it...

1. Настроить коннект к базе данных в src/main/resources/hibernate.cfg.xml
    hibernate.connection.url = адрес базы данных
    hibernate.connection.username = имя пользователя базы
    hibernate.connection.password = пароль пользователя
2. mvn clean install
3. mvn tomcat:run
4. Открыть http://localhost:8080/MyTestSpringHibernateTomcat/
5. Загрузить файл test1.xls или любой другой через меню страницы и проверить загруженные данные по ссылке File list