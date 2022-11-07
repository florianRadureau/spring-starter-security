
# Starter Spring Security
## Introduction

Ce starter vous servira à démarrer un projet Spring avec la sécurité déjà implémentée. Nous utilisons des tokens JWT de type Bearer.


## Routes

Plusieurs routes sont disponibles pour vous permettre de vous connecter et de rafraichir vos tokens :

**Sans authentification :**

POST /auth/signup

    {
        "email": "tonton@gmail.com",
        "password": "password",
        "role": ["admin", "user"]
    }
POST /auth/login

    {
        "email": "tonton@gmail.com",
        "password": "password"
    }

POST /auth/refreshtoken

    {
        "refreshToken": "le refreshToken fournit en retour de l'appel à login"
    }

**Avec authentification** disponible avec le ROLE_USER :

POST /products

    {
        "name": "Produit",
        "price": 5.50
    }

GET /products

**Avec authentification** disponible avec le ROLE_ADMIN :

GET /users
## Installation

Ceci est un projet gradle. Faites attention de bien charger le projet et d'installer les dépendances.
Pour faire fonctionner ce starter, vous devez avoir une base MySQL fonctionnelle. Vous pouvez lancer le docker compose situé à la racine du projet ou faire tourner MySQL en local. Vous appelez votre base comme vous le souhaitez, pour l'exemple ce sera 'starter'.

**Attention** il faut absolument ajouter 2 rôles en BDD dans la table roles : "ROLE_USER" et "ROLE_ADMIN".

Vous devrez créer un fichier application.properties dans les resources. Voici un exemple fonctionnel :

    spring.datasource.url=jdbc:mysql://localhost:3306/starter
    spring.datasource.username=user
    spring.datasource.password=password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.properties.hibernate.format_sql=true
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
    starter.app.jwtExpirationMs=28800000
    starter.app.jwtSecret=secret
    starter.app.jwtRefreshExpirationMs=604800000