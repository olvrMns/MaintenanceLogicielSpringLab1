# Laboratoire Maven: Migration et Mise à Jour

## Objectifs atteints

### Dépendances et Mises à Jour

Nous avons ajouté toutes les dépendances nécessaires, y compris Webflux pour des fonctionnalités réactives, et mis à jour toutes les versions des librairies pour qu’elles soient à jour avec :

- **Spring Framework 6**
- **Spring Boot 3.3.3**
- **Java 17**

### Débogage du Code

Nous avons corrigé toutes les erreurs de compilation pour que le projet fonctionne correctement. Nous avons aussi vérifié que les requêtes GET et POST fonctionnent sans problème après les corrections.

### Tests Unitaires

Nous avons ajouté des tests unitaires avec Mockito, atteignant une couverture de 73%.

## Instructions de Déploiement
```bash
mvn clean install
```
```bash
mvn test
```
```bash
mvn spring-boot:run
```

## Instruction pour voir la couverture
Pour voir la couverture, aller dans `target` --> `site` --> `jacoco` --> `index.html`
   
