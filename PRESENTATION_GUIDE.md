# 📊 Guide de Présentation - Pipeline CI/CD Maven + Jenkins + Docker

---

## **📋 Structure de la présentation (15-20 minutes)**

### **1. Introduction (2 min)**
- **Titre** : Pipeline CI/CD avec Maven, Jenkins, GitHub et Docker
- **Objectifs** :
  - Automatiser le build et les tests
  - Déploiement continu via Jenkins
  - Intégration Git + GitHub
  - Containerisation optionnelle

### **2. Vue d'ensemble du projet (2 min)**
- **Application** : Triangle Classification
  - Prend 3 côtés en entrée
  - Classifie : Équilatéral, Isocèle, Scalène, Invalide
  - Validée par 4 tests JUnit

- **Technologie** :
  - Java 8 (OpenJDK 21)
  - Maven 3.9.16
  - Jenkins (CI/CD)
  - GitHub (Versioning)
  - Docker (Containerisation optionnelle)

### **3. Architecture du pipeline (3 min)**

**Diagramme à afficher** :
```
┌─────────────────┐
│  Push sur Git   │
└────────┬────────┘
         │
    GitHub Webhook
         │
    ┌────▼─────┐
    │  ngrok   │ (tunnel local → internet)
    └────┬─────┘
         │
    ┌────▼────────────┐
    │   Jenkins       │
    └────┬────────────┘
         │
    ┌────▼──────────────────────────────────┐
    │  Pipeline Stages                      │
    ├───────────────────────────────────────┤
    │ 1. Git Checkout                       │
    │ 2. Maven Build (mvn clean package)    │
    │ 3. Unit Tests (4 tests JUnit)         │
    │ 4. ✅ SUCCESS ou ❌ FAILURE           │
    └────┬──────────────────────────────────┘
         │
    ┌────▼──────────────────────────────────┐
    │  Notifications                        │
    ├───────────────────────────────────────┤
    │ ✉️  Email de succès/échec             │
    └───────────────────────────────────────┘
```

### **4. Démonstration en direct (8 min)**

#### **Partie A : Montrer le code source**
```bash
# Ouvre le repo dans VS Code
cd C:\Users\FANEVA\Desktop\TP2

# Montre la structure
tree /F
```

**Fichiers clés à montrer** :
- `pom.xml` - Configuration Maven
- `src/main/java/com/example/triangle/TriangleType.java` - Logique
- `src/test/java/com/example/triangle/TriangleApplicationTest.java` - Tests
- `Jenkinsfile` - Pipeline

#### **Partie B : Lancer un build local**
```bash
# Compiler et tester localement
mvn clean package

# Affiche les résultats :
# [INFO] BUILD SUCCESS
# Tests run: 4, Failures: 0
```

#### **Partie C : Montrer Jenkins en action**
1. **Ouvre** : `http://localhost:8080`
2. **Clique sur le job** `Tp2`
3. **Montre** :
   - L'historique des builds
   - Le dernier build réussi
   - Les étapes du pipeline (Git, Build, Tests)
   - Les logs de Maven

#### **Partie D : Trigger un build automatique (OPTIONNEL)**
1. **Fais un petit changement** et pousse :
   ```bash
   git commit --allow-empty -m "demo webhook trigger"
   git push origine master
   ```
2. **Refresh Jenkins** → Un nouveau build se lance ! 🚀
3. **Montre** que le webhook GitHub déclenche automatiquement

### **5. Tests et résultats (2 min)**

**Affiche les résultats** :

```
✅ Test 1 : Equilateral (5, 5, 5) → PASS
✅ Test 2 : Isosceles (5, 5, 7) → PASS
✅ Test 3 : Scalene (3, 4, 5) → PASS
✅ Test 4 : Invalid (1, 2, 5) → PASS

Total : 4/4 tests réussis ✅
```

### **6. Apprentissages clés (2 min)**

**Points importants** :
- ✅ **CI/CD** : Automatiser build & tests
- ✅ **Maven** : Gestion dépendances et lifecycle
- ✅ **Jenkins** : Orchestration des builds
- ✅ **Git Webhooks** : Auto-trigger au push
- ✅ **Windows Compatibility** : `bat` vs `sh`
- ✅ **ngrok** : Tunnel local → internet
- ✅ **Testing** : JUnit intégré au pipeline

### **7. Améliorations futures (1 min)**

**Possibilités** :
- 🐳 Intégrer Docker (build & push image)
- 📧 Notifications Slack/Email
- 🧪 Augmenter la couverture de tests
- 🔐 Deploy vers serveur distant
- 📊 Métriques de qualité (SonarQube)

---

## **🎬 Scénario de démonstration complète**

### **Cas 1 : Démonstration simple (sans changement)**

```
1. Ouvre Jenkins (http://localhost:8080)
2. Clique sur "Tp2"
3. Montre les builds précédents
4. Clique sur un build → Console Output
5. Explique les étapes :
   - Git Checkout ✅
   - Maven Build ✅
   - Maven Test (4 tests) ✅
   - SUCCESS ✅
```

### **Cas 2 : Démonstration complète (avec webhook)**

```
1. Ouvre deux terminaux :
   - Terminal 1 : VS Code (ton projet)
   - Terminal 2 : ngrok (doit tourner)

2. Fais un changement et pousse :
   git commit --allow-empty -m "demo cicd"
   git push origine master

3. Refresh Jenkins
   → Un nouveau build se déclenche automatiquement ! 🎉

4. Montre le build en direct :
   - Les étapes qui s'exécutent
   - Les logs Maven
   - Les résultats des tests

5. Attends la fin → SUCCESS ✅
```

---

## **📊 Slides / Points clés à présenter**

### **Slide 1 : Titre**
```
╔════════════════════════════════════════════════════╗
║  Pipeline CI/CD avec Maven, Jenkins et GitHub      ║
║  Triangle Classification Application               ║
║  Faneva Solomampionona                            ║
║  Juin 2026                                        ║
╚════════════════════════════════════════════════════╝
```

### **Slide 2 : Objectifs**
```
✅ Build automatisé via Maven
✅ Tests unitaires intégrés
✅ Déploiement continu avec Jenkins
✅ Versioning avec Git + GitHub
✅ Trigger automatique via webhook
✅ Notifications sur succès/échec
```

### **Slide 3 : Architecture**
```
GitHub Push
    ↓ (webhook)
Jenkins (via ngrok)
    ↓
Pipeline Stages
├─ Git Checkout
├─ Maven Build
├─ Tests JUnit
└─ SUCCESS/FAILURE
    ↓
Notifications Email
```

### **Slide 4 : Technologie**
```
🔹 Java 8
🔹 Maven 3.9.16
🔹 Jenkins 2.567
🔹 GitHub
🔹 ngrok (tunnel)
🔹 JUnit 4
```

### **Slide 5 : Résultats des tests**
```
✅ Equilateral Test → PASS
✅ Isosceles Test → PASS
✅ Scalene Test → PASS
✅ Invalid Test → PASS

Total : 4/4 PASS 🎉
```

### **Slide 6 : Pipeline Jenkins**
```
Build #1 : SUCCESS ✅
Build #2 : SUCCESS ✅
Build #3 : SUCCESS ✅
Build #4 : SUCCESS ✅
Build #5 : SUCCESS ✅

Last Build Duration: 3.5s
```

### **Slide 7 : Fichiers clés**
```
📁 Tp2/
├── pom.xml (configuration Maven)
├── src/main/java/... (code source)
├── src/test/java/... (tests JUnit)
├── Jenkinsfile (pipeline déclaratif)
├── Dockerfile (containerisation)
├── README.md (documentation)
└── .gitignore
```

### **Slide 8 : Flux CI/CD**
```
Developer Code
    ↓ (git push)
GitHub Repository
    ↓ (webhook trigger)
Jenkins Pipeline
    ↓
1. Checkout Code
2. Build Application
3. Run Tests
4. Report Results
    ↓
Automated Deployment Ready ✅
```

---

## **💻 Commandes à exécuter en direct**

```bash
# 1. Compiler et tester
cd C:\Users\FANEVA\Desktop\TP2
mvn clean package

# 2. Lancer l'application
java -jar target/triangle-app-1.0.0.jar 3 4 5
# Output: Triangle Classification: Scalene

# 3. Voir l'état du repo
git log --oneline -5

# 4. Ouvrir Jenkins
start http://localhost:8080
```

---

## **📸 Points à capturer (screenshots)**

1. **Jenkins Dashboard** - Jobs et builds
2. **Pipeline Stages** - Étapes du pipeline
3. **Console Output** - Logs Maven complets
4. **Test Results** - 4/4 tests PASS
5. **GitHub Repository** - Code et commits
6. **Jenkinsfile** - Code du pipeline
7. **ngrok Tunnel** - Active forwarding

---

## **🎯 Questions prévues & réponses**

### **Q1 : Pourquoi Maven ?**
**R** : Gestion automatique des dépendances, build standardisé, plugins pour tests et packaging.

### **Q2 : Comment fonctionne le webhook ?**
**R** : GitHub envoie une requête HTTP à Jenkins quand on pousse du code. ngrok crée un tunnel local → internet.

### **Q3 : Pourquoi Jenkins ?**
**R** : Orchestration des builds, support des pipelines déclaratifs, large écosystème de plugins.

### **Q4 : Quel est l'avantage du CI/CD ?**
**R** : Détection rapide des bugs, tests automatisés, déploiement fiable et répétable.

### **Q5 : Docker ne marche pas. Pourquoi l'avez retiré ?**
**R** : Jenkins (LocalSystem account) n'avait pas accès au Docker daemon. On peut le remettre en changeant le compte de service Jenkins.

### **Q6 : Comment tester automatiquement ?**
**R** : `mvn test` lance automatiquement tous les tests JUnit avant le packaging.

### **Q7 : Quel est le temps de build ?**
**R** : ~3-5 secondes (compilation + tests + packaging).

---

## **📝 Livrables à préparer**

### **À remettre** :
1. ✅ **Code source** - Repo GitHub public
2. ✅ **README.md** - Documentation complète
3. ✅ **Jenkinsfile** - Pipeline déclaratif
4. ✅ **pom.xml** - Configuration Maven
5. ✅ **Tests JUnit** - 4 tests validés
6. ✅ **Dockerfile** - Image Docker (optionnel)
7. ✅ **Screenshots** - Jenkins, tests, logs
8. ✅ **Rapport** - Présentation écrite

---

## **⏱️ Timing de la présentation**

| Phase | Temps | Éléments |
|-------|-------|----------|
| Introduction | 2 min | Objectifs et contexte |
| Vue d'ensemble | 2 min | Application + technos |
| Architecture | 3 min | Diagramme pipeline |
| **Démonstration** | **8 min** | Jenkins + code + logs |
| Tests | 2 min | Résultats JUnit |
| Learnings | 2 min | Points clés |
| Q&A | 2 min | Questions |
| **Total** | **~21 min** | |

---

## **✨ Conseils pour réussir la présentation**

✅ **Avant la présentation** :
- Teste que Jenkins tourne
- Prépare ngrok (même s'il n'y a pas de webhook)
- Aie des exemples de code prêts
- Mémorise les points clés

✅ **Pendant la présentation** :
- Parle clairement et lentement
- Montre du code en direct (pas trop de slides)
- Explique le "pourquoi" pas juste le "comment"
- Réponds aux questions honnêtement

✅ **Après la présentation** :
- Renvoie les livrables (code + rapport)
- Inclus un README bien documenté
- Mets des screenshots dans le rapport
- Fournis des instructions pour relancer

---

## **🚀 Exemple de rapport final**

```
TP - Pipeline CI/CD avec Maven + Jenkins
Étudiant : Faneva Solomampionona
Date : Juin 2026

1. RÉSUMÉ EXÉCUTIF
   - Application de classification de triangles en Java
   - Pipeline CI/CD entièrement automatisé
   - 4 tests JUnit, 100% success rate

2. ARCHITECTURE
   [Diagramme du pipeline]

3. TECHNOLOGIES
   - Java 8, Maven 3.9.16, Jenkins 2.567, GitHub

4. RÉSULTATS
   ✅ Build local : SUCCESS
   ✅ Build Jenkins : SUCCESS
   ✅ Tests : 4/4 PASS
   ✅ Webhook : FONCTIONNEL

5. LEARNINGS
   - Automatisation du build
   - Testing continu
   - Git workflows

6. AMÉLIORATIONS FUTURES
   - Docker integration
   - SonarQube metrics
   - Slack notifications
```

---

**Prêt pour la présentation ? 🎤 Des questions ?**
