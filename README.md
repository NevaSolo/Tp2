# Triangle Classification Application - CI/CD Pipeline TP

Un projet de démonstration complet : **Java application + Maven + Git + Jenkins + Docker + CI/CD**

---

## 📋 Table des matières

- [Vue d'ensemble](#vue-densemble)
- [Architecture du pipeline](#architecture-du-pipeline)
- [Installation et prérequis](#installation-et-prérequis)
- [Lancer l'application](#lancer-lapplication)
- [Tests unitaires](#tests-unitaires)
- [Pipeline CI/CD](#pipeline-cicd)
- [Résultats et logs](#résultats-et-logs)
- [Ressources](#ressources)

---

## 🎯 Vue d'ensemble

Cette application classifie un triangle selon ses trois côtés :
- **Équilatéral** : tous les côtés égaux
- **Isocèle** : deux côtés égaux
- **Scalène** : tous les côtés différents
- **Invalide** : ne respecte pas l'inégalité triangulaire

**Technologies** :
- Java 8 (OpenJDK)
- Maven 3.9.16
- JUnit 4 pour les tests
- Jenkins pour CI/CD
- Docker pour la conteneurisation
- GitHub pour le versioning

---

## 🏗️ Architecture du pipeline

```
GitHub Push
    ↓
Jenkins Webhook (déclenche automatiquement)
    ↓
[Pipeline Stages]
    ├─ Git Checkout
    ├─ Maven Clean Package
    ├─ Maven Test (JUnit 4 tests)
    └─ ✅ BUILD SUCCESS
    ↓
Artifacts stockés dans Jenkins Workspace
```

### **Fichiers clés du projet**

| Fichier | Description |
|---------|------------|
| `pom.xml` | Configuration Maven, dépendances, compilation Java 8 |
| `src/main/java/com/example/triangle/TriangleApplication.java` | Entry point CLI |
| `src/main/java/com/example/triangle/TriangleType.java` | Logique de classification |
| `src/test/java/com/example/triangle/TriangleApplicationTest.java` | 4 tests JUnit |
| `Jenkinsfile` | Pipeline déclaratif Jenkins |
| `Dockerfile` | Image Docker (optionnel) |

---

## 🔧 Installation et prérequis

### **Sur ta machine**

1. **Java 8+** (testé avec OpenJDK 21)
   ```bash
   java -version
   # openjdk version "21.0.3" 2024-04-16 LTS
   ```

2. **Maven 3.9.16**
   ```bash
   mvn -version
   # Apache Maven 3.9.16
   ```

3. **Git**
   ```bash
   git --version
   ```

4. **Jenkins** (optionnel pour local CI/CD)
   - Télécharger depuis : https://www.jenkins.io/download/
   - Plugins requis : Pipeline, Git, Maven Integration, Credentials Binding

5. **Docker Desktop** (optionnel pour containerisation)
   - Télécharger depuis : https://www.docker.com/products/docker-desktop

---

## ✨ Lancer l'application

### **Compilation et exécution locale**

```bash
# Cloner le repo
git clone https://github.com/NevaSolo/Tp2.git
cd Tp2

# Compiler et packager
mvn clean package
# Génère: target/triangle-app-1.0.0.jar

# Lancer l'application
java -jar target/triangle-app-1.0.0.jar 3 4 5

# Résultat: Triangle Classification: Scalene
```

### **Exemples**

```bash
# Équilatéral (3 côtés égaux)
java -jar target/triangle-app-1.0.0.jar 5 5 5
# Output: Equilateral

# Isocèle (2 côtés égaux)
java -jar target/triangle-app-1.0.0.jar 5 5 7
# Output: Isosceles

# Scalène (tous différents)
java -jar target/triangle-app-1.0.0.jar 3 4 5
# Output: Scalene

# Invalide (viole l'inégalité triangulaire)
java -jar target/triangle-app-1.0.0.jar 1 2 5
# Output: Invalid triangle
```

---

## 🧪 Tests unitaires

### **Lancer les tests localement**

```bash
mvn test
```

**Résultat attendu** :
```
Tests run: 4, Failures: 0, Errors: 0, Skipped: 0
```

### **Test Coverage**

| Cas de test | Input | Expected | Status |
|------------|-------|----------|--------|
| Equilateral | 5, 5, 5 | Equilateral | ✅ PASS |
| Isosceles | 5, 5, 7 | Isosceles | ✅ PASS |
| Scalene | 3, 4, 5 | Scalene | ✅ PASS |
| Invalid | 1, 2, 5 | Invalid | ✅ PASS |

---

## 🔄 Pipeline CI/CD

### **Stages Jenkins**

1. **Git Checkout**
   - Récupère le dernier code depuis GitHub
   - Authentification avec `git_credentials`

2. **Build**
   - `mvn clean package`
   - Compile et crée le JAR

3. **Unit Test Execution**
   - `mvn test`
   - Exécute 4 tests JUnit
   - Si un test échoue → BUILD FAILED

### **Déclenchement automatique**

Un webhook GitHub déclenche Jenkins automatiquement à chaque push sur `master`.

**Flux** :
```
git push → GitHub webhook → Jenkins trigger → Pipeline execution
```

### **Configuration Jenkins**

**Job Name** : `Tp2` (ou `pipeline-triangle`)  
**Type** : Pipeline  
**Pipeline source** : GitHub repository URL  
**Repository** : https://github.com/NevaSolo/Tp2.git  
**Credentials** : `git_credentials` (GitHub Personal Access Token)

---

## 📊 Résultats et logs

### **Dernière exécution réussie**

Build #5 - Status: **SUCCESS** ✅

```
[Pipeline] Start of Pipeline
[Pipeline] node
Running on Jenkins in C:\ProgramData\Jenkins\.jenkins\workspace\pipeline-triangle

[Pipeline] stage (Git checkout)
[Pipeline] checkout - ✅ SUCCESS

[Pipeline] stage (Build)
[Pipeline] bat 'mvn clean package'
[INFO] BUILD SUCCESS
[INFO] Total time: 2.861 s ✅

[Pipeline] stage (Unit Test Execution)
[Pipeline] bat 'mvn test'
[INFO] Tests run: 4, Failures: 0, Errors: 0 ✅
[INFO] Total time: 1.696 s

[Pipeline] End of Pipeline
BUILD SUCCESS
```

### **Accessing Jenkins Console**

1. Ouvre `http://localhost:8080`
2. Clique sur le job `Tp2`
3. Clique sur un build # pour voir les logs complets
4. Accède à l'onglet "Console Output"

---

## 🐳 Docker (Optionnel)

Pour contenueuriser l'application :

```bash
# Construire l'image
docker build -t neva250/nevasolo:1.0 .

# Lancer le conteneur
docker run neva250/nevasolo:1.0 3 4 5
# Output: Triangle Classification: Scalene

# Pousser vers Docker Hub
docker login
docker push neva250/nevasolo:1.0
```

**Dockerfile** basé sur `openjdk:8-jdk-alpine` (léger et optimisé).

---

## 📈 Apprentissages clés

✅ **CI/CD Pipeline** : Automatiser le build, test, et déploiement  
✅ **Maven** : Gestion des dépendances et lifecycle build  
✅ **Jenkins** : Orchestration des builds et pipelines déclaratifs  
✅ **Git + GitHub** : Versioning et webhooks  
✅ **Docker** : Conteneurisation et déploiement  
✅ **Testing** : JUnit tests intégrés au pipeline  
✅ **Windows Compatibility** : Utiliser `bat` au lieu de `sh` dans Jenkins sur Windows

---

## 🔗 Ressources

- [Maven Official](https://maven.apache.org/)
- [Jenkins Documentation](https://www.jenkins.io/doc/)
- [Docker Official](https://www.docker.com/)
- [GitHub Webhooks](https://docs.github.com/en/developers/webhooks-and-events/webhooks)
- [JUnit 4 Guide](https://junit.org/junit4/)

---

## 👤 Auteur

**Faneva Solomampionona**  
Projet TP - CI/CD Pipeline avec Maven + Jenkins + Docker  
Date : Juin 2026

---

## 📝 Changlog

| Version | Date | Changes |
|---------|------|---------|
| 1.0.0 | 2026-06-10 | Initial release - Maven build + JUnit tests + Jenkins pipeline |
| 1.1.0 | 2026-06-10 | Added GitHub webhook + Docker support (optional) |
