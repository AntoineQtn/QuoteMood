package com.antoinequintin.quotemood.model

// data class = classe spéciale Kotlin qui génère automatiquement :
// - toString() : pour afficher l'objet
// - equals() et hashCode() : pour comparer deux objets
// - copy() : pour créer une copie modifiée
data class Quote(
    // val = variable immuable (constante), on ne peut pas la modifier après création
    val text: String,        // Le texte de la citation
    val author: String,      // L'auteur de la citation

    // = "motivation" : valeur par défaut
    // Si on ne précise pas la catégorie, elle sera "motivation"
    val category: String = "motivation"
)
