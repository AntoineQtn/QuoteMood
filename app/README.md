# QuoteMood 

Application Android native de citations motivantes, développée en **Kotlin** avec **Jetpack Compose**.

## Screenshots

![Screenshot 1](screenshots/screenshot1.jpg)
![Screenshot 2](screenshots/screenshot2.jpg)

## À propos du projet

**QuoteMood** est une application Android que j'ai développée en un weekend pour découvrir le développement mobile natif avec Kotlin et Jetpack Compose. Ce projet fait partie de ma candidature pour une alternance de développeur mobile chez Lunabee Studio.

## Fonctionnalités

- Affichage de citations motivantes, de sagesse et tech
- Changement aléatoire de citation avec animation fluide
- Interface Material Design 3
-  Catégorisation des citations (motivation, sagesse, tech)
- UI responsive et moderne

## Technologies utilisées

- **Langage** : Kotlin
- **UI Framework** : Jetpack Compose
- **Architecture** : MVVM simplifié (Repository pattern)
- **Design** : Material Design 3
- **Animations** : AnimatedContent avec transitions

## Structure du projet
```
com.antoinequintin.quotemood
├── MainActivity.kt          # Point d'entrée et UI
├── model/
│   └── Quote.kt            # Modèle de données
└── data/
    └── QuotesRepository.kt # Gestion des citations
```

## Apprentissage

- Les bases de **Kotlin** (data classes, object, lambdas)
- **Jetpack Compose** (Composables, State management, Layouts)
- L'architecture **MVVM** et le pattern Repository
- Les **animations** avec Compose
- Le cycle de vie d'une **Activity Android**
- Le déploiement sur device physique via ADB
