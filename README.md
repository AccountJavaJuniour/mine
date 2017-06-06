# mine
### Установка

## Необходимые программы

* MySQL 5.7
  * База данных с названием mine
  * Создать user:test pass:test
* Maven
  * прописать путь к бинарникам в PATH
* JDK
  * JAVA_HOME= каталог jdk
* Tomcat 8.5
  * Прописать путь к бинарникам в PATH
  
## Команды
git clone https://github.com/AccountJavaJuniour/mine.git

cd mine

mvn clean install -DskipTests=true

mvn tomcat7:run -Denv=dev

http://localhost:8080/Myproject/

id = 1