package com.antoinequintin.quotemood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.antoinequintin.quotemood.data.QuotesRepository
import com.antoinequintin.quotemood.ui.theme.QuoteMoodTheme


// MainActivity point d'entrée android hérite de ComponentActivity (classe Android de base)
class MainActivity : ComponentActivity() {

    // onCreate = méthode appelée quand l'app démarre, point d'entrée" de l'app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // QuoteMoodTheme = applique le thème Material Design de l'app
            // (couleurs, typographie, formes)
            QuoteMoodTheme {
                // Surface = conteneur de base en Compose
                Surface(
                    // Modifier = chaîne de modifications visuelles
                    modifier = Modifier.fillMaxSize(),  // Prend toute la taille de l'écran
                    color = MaterialTheme.colorScheme.background  // Couleur de fond
                ) {
                    // Affiche l'écran principal
                    QuoteScreen()
                }
            }
        }
    }
}

// @Composable = annotation qui dit d''interface
@Composable
fun QuoteScreen() {

//gestion de l'état

    // var = variable mutable (modifiable)
    // by = délégation de propriété (syntaxe Kotlin)
    // mutableStateOf = crée un état observable

    // Quand currentQuote change, Compose redessine automatiquement l'UI
    var currentQuote by remember {
        mutableStateOf(QuotesRepository.getRandomQuote())
    }

    // Analogie : C'est comme useState en React
    // const [currentQuote, setCurrentQuote] = useState(...)

 //layout principal, vertical

    // Column = empile les éléments verticalement (comme flexbox column)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),         // Marges internes de 24dp

        // Alignement horizontal au centre
        horizontalAlignment = Alignment.CenterHorizontally,

        // Alignement vertical au centre
        verticalArrangement = Arrangement.Center
    ) {

      //Titre App

        Text(
            text = "QuoteMood",
            // Style prédéfini Material Design pour les gros titres
            style = MaterialTheme.typography.headlineLarge,
            // Couleur primaire du thème
            color = MaterialTheme.colorScheme.primary
        )

        // Spacer = espace vide (comme un <div> vide en HTML)
        Spacer(modifier = Modifier.height(48.dp))

//card avec la citation

        // Card = composant Material Design (rectangle avec ombre)
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),     // Marges externes

            // Élévation (ombre portée) de 4dp
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {

           //animation changement citation

            // AnimatedContent = anime automatiquement le changement de contenu
            AnimatedContent(
                // targetState = l'état à afficher
                // Quand currentQuote change, l'animation se déclenche
                targetState = currentQuote,

                // transitionSpec = définit l'animation
                transitionSpec = {
                    // fadeIn() = apparition en fondu
                    // fadeOut() = disparition en fondu
                    // togetherWith = les deux en même temps
                    fadeIn() togetherWith fadeOut()
                },

                // label = pour le debug
                label = "quote_animation"
            ) { quote ->
                // quote = la citation à afficher (passée automatiquement)

                // Nouvelle Column pour le contenu de la carte
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                   //Texte de la citation

                    Text(
                        text = "\"${quote.text}\"",  // Ajoute des guillemets
                        style = MaterialTheme.typography.headlineSmall,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSurface
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                //auteur
                    Text(
                        text = "— ${quote.author}",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

// Badge catégorie
                    // AssistChip = petit badge Material Design
                    AssistChip(
                        onClick = { },  // Vide pour l'instant (pas d'action)
                        label = { Text(quote.category) }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

       //boutoon nouvelle citation

        Button(
            // onClick = fonction appelée au clic
            onClick = {
                // Change la citation actuelle
                // Compose détecte le changement et redessine automatiquement
                currentQuote = QuotesRepository.getRandomQuote()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 32.dp)
        ) {
            // Contenu du bouton (icône + texte)

            // Icon = affiche une icône Material
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Nouvelle citation",  // Pour l'accessibilité
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(8.dp))  // Espace entre icône et texte

            Text("Nouvelle citation")
        }
    }
}