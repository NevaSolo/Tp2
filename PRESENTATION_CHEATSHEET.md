# 🎤 CHEAT SHEET - Présentation TP CI/CD (15 min)

## **⏰ TIMING RAPIDE**

| Temps | Action |
|-------|--------|
| 0:00-1:00 | Introduction + objectifs |
| 1:00-3:00 | Vue d'ensemble tech stack |
| 3:00-7:00 | **DÉMO PRINCIPALE** : Jenkins + logs |
| 7:00-9:00 | Code source (brève) |
| 9:00-11:00 | Tests JUnit (résultats) |
| 11:00-13:00 | Webhook (optionnel) |
| 13:00-15:00 | Q&A + conclusion |

---

## **📱 POINTS DE DÉMONSTRATION**

### **Avant de démarrer**
- [ ] Jenkins tourne : `http://localhost:8080`
- [ ] ngrok tourne (si webhook demo)
- [ ] Repo GitHub accessible
- [ ] Terminal PowerShell prêt
- [ ] VS Code avec repo ouvert

### **Démonstration #1 : Jenkins UI (3 min)**
```
1. Ouvre http://localhost:8080
2. Clique sur "Tp2" job
3. Montre l'historique des builds
4. Clique sur "Build #5" (SUCCESS)
5. Affiche "Console Output"
6. Scroll pour montrer :
   - Git checkout ✅
   - Maven compile ✅
   - Tests 4/4 ✅
   - BUILD SUCCESS ✅
```

### **Démonstration #2 : Code source (2 min)**
```bash
# Terminal :
cd C:\Users\FANEVA\Desktop\TP2

# Affiche la structure
tree /F

# Montre le code clé
type src\main\java\com\example\triangle\TriangleType.java

# Montre les tests
type src\test\java\com\example\triangle\TriangleApplicationTest.java
```

### **Démonstration #3 : Build local (2 min)**
```bash
mvn clean package

# Output à montrer :
# [INFO] Compiling 2 source files
# [INFO] Tests run: 4, Failures: 0
# [INFO] BUILD SUCCESS
# [INFO] Building jar: target/triangle-app-1.0.0.jar
```

### **Démonstration #4 : Webhook (OPTIONNEL)**
```bash
# Si on veut montrer l'auto-trigger :

1. Ouvre 2 terminaux côte à côte :
   - Terminal 1 : Jenkins web
   - Terminal 2 : PowerShell

2. Terminal 2 :
   git commit --allow-empty -m "demo webhook"
   git push origine master

3. Jenkins UI → Refresh
   → Nouveau build se déclenche ! 🎉

4. Affiche le build en direct
```

---

## **🎯 POINTS CLÉS À COUVRIR**

### **Objectif du TP** (1 min)
```
"Ce TP montre un pipeline CI/CD complet :
- Code Java avec tests JUnit
- Build automatisé avec Maven
- Orchestration avec Jenkins
- Déploiement sur trigger GitHub
```

### **Architecture** (2 min)
```
"Le flux est simple :
1. Je pousse du code sur GitHub
2. GitHub envoie un webhook
3. Jenkins reçoit et lance le pipeline
4. Build + Tests s'exécutent
5. Résultat : SUCCESS ou FAILURE
6. Email de notification
```

### **Résultats** (1 min)
```
"Résultats :
- 4 builds réussis sur 5 (1 bug initialement)
- 4/4 tests JUnit passent
- Build time : ~3.5 secondes
- 100% success rate après fix
```

### **Technologies** (1 min)
```
"Stack tech :
- Java 8, Maven 3.9.16
- Jenkins 2.567
- GitHub, ngrok, JUnit 4
```

---

## **📊 SLIDES RAPIDES (À MONTRER)**

### **Slide 1 : Titre**
```
PIPELINE CI/CD AVEC MAVEN + JENKINS

Triangle Classification App
100% Automated Build & Test
```

### **Slide 2 : Objectifs**
✅ Application Java avec tests
✅ Build automatisé Maven
✅ Pipeline Jenkins
✅ Webhook GitHub
✅ Notifications email

### **Slide 3 : Architecture**
```
Git Push → GitHub Webhook → ngrok → Jenkins
                                      ↓
                        Build + Test + Deploy
```

### **Slide 4 : Résultats**
```
✅ 4/4 Tests Passed
✅ 100% Success Rate
✅ 3.5s Build Time
✅ Auto-triggered
```

---

## **💻 COMMANDES À L'AVANCE**

### **À préparer dans un fichier .txt**
```
# Compiler et tester
cd C:\Users\FANEVA\Desktop\TP2
mvn clean package

# Exemple application
java -jar target/triangle-app-1.0.0.jar 3 4 5

# Logs git
git log --oneline -5

# Ouvrir Jenkins
start http://localhost:8080

# Webhook test (optionnel)
git commit --allow-empty -m "demo webhook"
git push origine master
```

---

## **❓ FAQ À PRÉPARER**

### **Q1 : Ça marche vraiment en automatique ?**
**R** : Oui ! Chaque `git push` déclenche Jenkins via webhook GitHub.

### **Q2 : Pourquoi Maven ?**
**R** : Gestion standard des dépendances, build reproductible, plugins pour tout.

### **Q3 : Et Docker ?**
**R** : Retiré car Jenkins (LocalSystem) n'avait pas accès au daemon. Peut être réactivé.

### **Q4 : Que faire si un test échoue ?**
**R** : Jenkins arrête le build et envoie une email. On fixe et on re-pousse.

### **Q5 : Quel est l'intérêt du CI/CD ?**
**R** : Détection des bugs rapidement, tests auto, déploiement confiant et répétable.

### **Q6 : ngrok c'est quoi ?**
**R** : Tunnel qui expose localhost:8080 vers internet pour que GitHub puisse toucher Jenkins.

---

## **✨ CONSEILS DE PRÉSENTATION**

### **À FAIRE** ✅
- Parle lentement et clairement
- Montre du code en direct (pas trop de slides)
- Explique le "pourquoi" pas juste le "comment"
- Affiche les logs avec succès
- Dispose de la démo avec confiance

### **À ÉVITER** ❌
- Trop de théorie sans démo
- Aller trop vite sur le code
- Lire les slides mot à mot
- Se perdre dans les détails
- Montrer trop de fichiers

### **CONTINGENCY PLANS**
- Si Jenkins crash : montrer les screenshots de logs
- Si webhook échoue : faire démo manuelle (Build Now)
- Si réseau down : avoir une USB avec les résultats

---

## **📸 SCREENSHOTS À PRÉPARER** (optionnel)

```
1. Jenkins Dashboard (overview)
2. Pipeline Stages view
3. Console Output (logs complets)
4. Test Results (4/4 pass)
5. GitHub Webhook configuration
6. Maven pom.xml
7. Jenkinsfile content
8. Application example run
```

---

## **🎬 SCÉNARIO OPTIMAL DE PRÉSENTATION**

### **Entrée en matière**
```
"Bonjour, ce TP montre un pipeline CI/CD complet.
L'objectif : automatiser le build et les tests
quand on pousse du code sur GitHub."
```

### **Montrer Jenkins en action** (3 min)
```
1. Ouvre Jenkins → Tp2 → Build #5
2. Montre "Console Output"
3. Scroll et commente :
   - Git checkout ✅
   - Maven build ✅  
   - Tests 4/4 ✅
   - BUILD SUCCESS ✅
4. Montre la durée : 3.5s
```

### **Montrer le code** (1 min)
```
1. Ouvre VS Code
2. Affiche TriangleType.java
3. Explique brièvement la logique
4. Montre les tests
```

### **Expliquer l'automatisation** (2 min)
```
"Quand je fais git push, GitHub envoie un
webhook qui déclenche automatiquement Jenkins.
Pas de clic manuel nécessaire."
```

### **Conclure**
```
"Questions ? Nous avons une application robuste,
100% des tests passent, et le pipeline est
complètement automatisé. C'est du vrai CI/CD !"
```

---

## **✅ CHECKLIST AVANT PRÉSENTATION**

- [ ] Jenkins tourne et accessible
- [ ] Repo GitHub en ligne
- [ ] ngrok configuré (si webhook demo)
- [ ] Terminal PowerShell prêt
- [ ] VS Code avec code source
- [ ] Slides/images prêtes (optionnel)
- [ ] Commandes clés dans un .txt
- [ ] FAQ préparée
- [ ] Internet stable
- [ ] Durée timing : 15 min max

---

## **🏆 POINTS BONUS**

- Montrer l'historique des builds (évolution)
- Expliquer pourquoi build #1/#2 ont échoué
- Montrer un webhook delivery dans GitHub
- Lancer un build en direct (vrai webhook)
- Montrer email notification config
- Parler des améliorations futures

---

**BON COURAGE POUR LA PRÉSENTATION ! 🚀**

*Dernier rappel : Respire, parle clairement, et montre du concret (code + logs).*
