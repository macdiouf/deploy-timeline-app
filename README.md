# Procedure de déploiement d'une application backend avec docker dans un VPS / Debian
# Installation de docker dans le serveur
Se rendre à cette adresse (https://docs.docker.com/install/linux/docker-ce/debian/)
1. sudo apt-get update
2. sudo apt-get install docker-ce
# Creer un conteneur docker pour MySQL
docker run -p 2015:3306 --name timeline-docker-container -e MYSQL_ROOT_PASSWORD=passer -e MYSQL_DATABASE=timeline -e MYSQL_USER=simplon -e MYSQL_PASSWORD=passer -d mysql:5.5

# Installation et configuration de Java8
1. sudo apt-get install oracle-java8-installer
2. sudo update-alternatives --config java
3. sudo nano /etc/environment
Créer une variable d'environnent JAVA_HOME et lui affecter comme valeur ce path "/usr/lib/jvm/java-8-oracle"
```
JAVA_HOME="/usr/lib/jvm/java-8-oracle"
```
4. source /etc/environment

# Installation et configuration de Maven 
1. cd /usr/local/src
2. wget http://www-us.apache.org/dist/maven/maven-3/3.5.4/binaries/apache-maven-3.5.4-bin.tar.gz
3. tar -xf apache-maven-3.5.4-bin.tar.gz
4. mv apache-maven-3.5.4/ apache-maven/
5. sudo nano /etc/environment
```
export M2_HOME=/usr/local/src/apache-maven
export MAVEN_HOME=/usr/local/src/apache-maven
export PATH=${M2_HOME}/bin:${PATH}
```
6. source /etc/environment

# Créer un conteneur docker pour l'application

1. Editer le fichier pom.xml
```
	<plugin>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-maven-plugin</artifactId>
		<configuration>
				<finalName>timeline</finalName>
		</configuration>
	</plugin>
```
2. Créer le fichier Dockerfile dans le dossier parent du projet

```
FROM openjdk:8
ADD target/timeline.jar timeline.jar
EXPOSE 8086
ENTRYPOINT ["java", "-jar", "timeline.jar"]
```

3. Editer le fichier application.properties

server.port=8089
spring.jpa.hibernate.ddl-auto=create
spring.datasource.url=jdbc:mysql://92.222.217.188:2015/timeline?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
spring.datasource.username=simplon
spring.datasource.password=passer
spring.jpa.hibernate.naming-strategy = org.hibernate.cfg.ImprovedNamingStrategy
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.MySQL5Dialect

4. Installer les dépendances avec MAVEN
* mvn clean
* mvn install

5. Créer l'image Docker de l'application
* docker build . -t timeline

6. Démarrer l'image de l'appli et faire le lien avec le conteneur de la base de données MYSQL
* docker run -h *:* -p 8090:8090 --name timeline --link timeline-docker-container:mysql -d timeline