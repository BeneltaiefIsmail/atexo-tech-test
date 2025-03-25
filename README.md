# Test Technique Atexo
# Description du besoin
Une société cherche une solution pour numéroter ses inscrits d'une façon unique:
Cette numérotation sera construite par concaténation des 4 critères suivants :

- le nom de l'inscrit
- le prénom de l'inscrit
- sa date de naissance
- un compteur incrémenté de 1 à chaque nouvel inscrit, avec une valeur initiale configurée.

Ces critères peuvent avoir un ordre différent.
Ces critères peuvent avoir des configurations différentes :

- le nom de l'inscrit : une longueur définie avec un potentiel préfixe / suffixe.
- le prénom de l'inscrit : une longueur définie avec un potentiel préfixe / suffixe.
- la date de naissance : format de date (YYYY) avec un potentiel préfixe / suffixe.
- le compteur formaté
## Fonctionnalités
********************
### Backend (Spring Boot)
  * Gestion des Inscrits : Enregistrement d'un nouvel inscrit avec génération d'un identifiant unique basé sur les critères configurés.
chaque nouvel inscrit est defini par (NOM , PRENOM , DATE_DE_NAISSANCE , IDENTIFIANT_UNIQUE). (l'Idientiant sera généré automatiquement
a partir d'un ALGORITHME de générationIdentifiantUnique (qui ce base sur des critères configurés)


  * Gestion des configurations des critères : l'algorithme de géneration se base sur 4 critères (FIRTNAME , LASTNAME , DATEOFBIRTH , COUNTER).
chacun des critères posséde sa propore configuration (Longueur , suffixe , preffixe , format , valeur de debut) 
=> les critères doivent etre traiter par un ordre.


* Base de données : Utilisation de Spring Data JPA pour la gestion des données des inscrits et les régles de configurations dans une base de données (PostgreSQL).
=> la configuration est disponible dans le fichier application.proprities.

### Frontend (Angular)
- Interface HOME : qui contient 2 boutons avec un liens vers le formulaire d'inscription et la page de config
- Interface utilisateur : Formulaire pour l'inscription des utilisateurs.

## Technologie 

- Backend : Spring Boot V3.4.4 with Java 17
- Frontend : Angular 19
- Outils de développement : Maven, Node.js, NPM
- Base de données : PostgreSQL
- POSTMAN : test API
 ## Prérequis
  Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre machine :
* Java (version 17 ou supérieure recommandée)
* Node.js
* Angular CLI (npm install -g @angular/cli)
* Maven (pour le backend)
* IDE (IntelliJ, Eclipse, VS Code, etc.)

## Installation
1. Git Clone ==> git clone "https://github.com/BeneltaiefIsmail/atexo-tech-test".
2. Importer le projet sur votre IDE.
3. Dans le projet ATEXO-TEST-BACKEND modifiez de la configuration dans le fichier (application.propreties) => base de données.
4. START APPLICATION => mvn spring-boot:run
5. Accéder dans le projet ATEXO-TEST-FRONTEND => npm install => ng serve
6. Le frontend Angular sera accessible sur http://localhost:4200

## Exemple API 
1- API inscription => POST :  /api/v1/registrations
2- API ConfiguraitonRule => POST : /api/v1/configuration-rules

=> la document est disponible http://localhost:8080/swagger-ui/index.html

## Capture d'écran de l'application
### 1.Page d'acceuil
![Home](images/Home.png)
### 2.Pages configuration des régles de gestion
![config](images/ConfigRule.png)
![config1](images/ConfigNom.png)
![config2](images/ConfigPrenom.png)
![config3](images/ConfigDate.png)
![config4](images/ConfigCompteur.png)
### 3.Page d'inscription 
![inscription](images/inscription.png)
