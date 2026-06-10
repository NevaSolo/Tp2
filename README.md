# TP Jenkins + Docker + Maven

Ce projet est un exemple de pipeline CI/CD avec Jenkins, GitHub, Maven et Docker.

## Contenu

- `pom.xml` : projet Maven Java 8
- `src/main/java/...` : code source d'une application de classification de triangles
- `src/test/java/...` : tests unitaires JUnit
- `Dockerfile` : construction d'une image Docker
- `Jenkinsfile` : pipeline Jenkins pour checkout, build, test, docker build, push

## Commandes locales

1. Compiler et tester :
   ```bash
   mvn clean package
   ```

2. Construire l'image Docker :
   ```bash
   docker build -t toncompte/triangle-app:1.0.0 .
   ```

3. Lancer l'application :
   ```bash
   docker run --rm toncompte/triangle-app:1.0.0 3 4 5
   ```

## Configuration Jenkins

1. Installer les plugins : Pipeline, Git, Maven Integration, Credentials Binding, GitHub.
2. Configurer les outils globaux : Git, Maven, Java 8.
3. Ajouter les credentials GitHub et DockerHub.
4. Créer un pipeline Jenkins avec `Pipeline script from SCM`.
5. Activer le trigger GitHub webhook dans `Build Triggers`.
6. Pousser le code sur GitHub.

## Remarques

- Remplace `TON_UTILISATEUR/TON_REPO` dans le `Jenkinsfile`.
- Remplace `toncompte/triangle-app:1.0.0` par ton dépôt Docker Hub.
- Pour le trigger GitHub, utilise `https://<ngrok-domain>.ngrok.io/github-webhook/` si Jenkins est local.
