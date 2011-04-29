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

1. mvn clean install
2. mvn hibernate3:hbm2ddl
3. Use target/hibernate3/sql/schema.ddl to create your database schema
4. mvn -e exec:java -Dexec.mainClass=com.force.samples.util.DataLoadUtil  (adds some data to the database)
5. mvn tomcat:run
6. Point browser at [http://localhost:8080/webapp-springmvc-jpa-hibernate](http://localhost:8080/webapp-springmvc-jpa-hibernate)
