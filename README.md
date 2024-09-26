# Ktchat

## Introduction
Ceci est une application de tchat en temps réel en cours de développement pour me former à SpringBoot et Next.
N'hésitez pas à me contacter si vous avez des questions ou des conseils !

## Useful tips
<details>
<summary>Lancer l'application côté back</summary>
```sh
cd chat-app-backend
mvn spring-boot:run
```
</details>

<details>
<summary>Lancer l'application côté front</summary>
En mode développement:
```sh
cd chat-app-frontend
npm run dev
```
</details>

<details>
<summary>Refaire une installation propre</summary>
Installation simple:
```sh
mvn clean install
```

Si cela ne fonctionne pas, forcer à refaire l'installation en nettoyant les fichiers générés et en re-téléchargeant les dépendances:
```sh
mvn clean install -U
```

Si les erreurs sont causées par les tests uniquement, faire une installation qui passe les tests pour le moment:
```sh
mvn clean install -DskipTests
```
</details>

<details>
<summary>Lancer les tests côté back</summary>
```sh
cd chat-app-backend
mvn test
```
</details>

<details>
<summary>Lancer les tests côté front</summary>
```sh
cd chat-app-frontend
npm run test
```
</details>

## VS Code Config
<details>
<summary>Plugins utiles</summary>
- Language Support for Java (by Red Hat)
- Extension Pack for Java
- Maven for Java
- Spring boot Extension Pack
</details>

<details>
<summary>Si les imports auto ne fonctionnent pas (pour Lombok par exemple)</summary>
- ctrl + shift + p
- coller la ligne suivante et exécuter: "Java: Clean the Java language server workspace"
</details>