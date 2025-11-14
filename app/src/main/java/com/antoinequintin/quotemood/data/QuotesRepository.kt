package com.antoinequintin.quotemood.data

import com.antoinequintin.quotemood.model.Quote

// object = singleton en Kotlin
// Il n'existe qu'UNE SEULE instance de QuotesRepository dans toute l'app
// Pas besoin de faire "new QuotesRepository()" : il existe déjà
object QuotesRepository {

    // private = accessible uniquement dans cette classe
    // val = immuable : la liste ne peut pas être remplacée
    // listOf() = crée une liste immuable (on ne peut pas ajouter/supprimer d'éléments)
    private val quotes = listOf(
        // Création d'objets Quote avec nos data class
        Quote(
            text = "Le succès, c'est tomber sept fois et se relever huit.",
            author = "Proverbe japonais",
            category = "motivation"
        ),
        Quote(
            text = "La vie est ce qui arrive quand on est occupé à faire d'autres plans.",
            author = "John Lennon",
            category = "sagesse"
        ),
        Quote(
            text = "Le code, c'est comme l'humour. Quand on doit l'expliquer, c'est mauvais.",
            author = "Cory House",
            category = "tech"
        ),
        Quote(
            text = "N'abandonne jamais un rêve juste à cause du temps qu'il faudra pour l'accomplir.",
            author = "Earl Nightingale",
            category = "motivation"
        ),
        Quote(
            text = "La seule façon de faire du bon travail est d'aimer ce que vous faites.",
            author = "Steve Jobs",
            category = "motivation"
        ),
        Quote(
            text = "L'échec est le fondement de la réussite.",
            author = "Lao Tseu",
            category = "sagesse"
        ),
        Quote(
            text = "Tout bug non documenté est une fonctionnalité.",
            author = "Anonyme",
            category = "tech"
        ),
        Quote(
            text = "Ce n'est pas parce que les choses sont difficiles que nous n'osons pas, c'est parce que nous n'osons pas qu'elles sont difficiles.",
            author = "Sénèque",
            category = "motivation"
        )
    )

    // Fonction publique : accessible de partout dans l'app
    // fun = déclaration d'une fonction
    // : Quote = type de retour (renvoie un objet Quote)
    fun getRandomQuote(): Quote {
        // random() = fonction d'extension Kotlin sur les listes
        // Renvoie un élément aléatoire de la liste
        return quotes.random()
    }
}
