package com.example.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.superheroes.model.HeroRepository.heroes
import com.example.superheroes.ui.theme.SuperheroesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperheroesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    SuperheroApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperheroApp(modifier: Modifier = Modifier) {
    Scaffold( 
        topBar = {
            SuperHeroTopBar()
        }
    ) {
        it ->
        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
            ,
            contentPadding = it
        ){
            items( heroes ){
                    hero -> SuperheroListItem(
                imageRes = hero.image,
                heroName = hero.name,
                heroDescription = hero.description,
            )
                Spacer(modifier=modifier.padding(bottom = 10.dp))
            }
        }
    }
    
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopBar(modifier : Modifier = Modifier){
    CenterAlignedTopAppBar(//this centers the contents in the topbar
        title = {
           Row(
               modifier = modifier,
               verticalAlignment = Alignment.CenterVertically//this arranges the contents of the row into the center of the row
           ) {
               Text(
                   text = stringResource(id = R.string.app_name),
                   style = MaterialTheme.typography.displayLarge
               )
           }
        },
        modifier = modifier
    )
}

//@Preview
//@Composable
//fun TopbarPreview(){
//    SuperHeroTopBar()
//}

@Preview(showBackground = true)
@Composable
fun SuperheroPreview() {
    SuperheroesTheme(darkTheme = false) {
        SuperheroApp()
    }
}

@Preview(showBackground = true)
@Composable
fun SuperheroDarkPreview() {
    SuperheroesTheme(darkTheme = true) {
        SuperheroApp()
    }
}