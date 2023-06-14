package com.example.superheroes


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SuperheroListItem(
    imageRes: Int,
    heroName: Int,
    heroDescription: Int,
    modifier: Modifier = Modifier
){
    Card (
        modifier = modifier,
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row ( 
            modifier = modifier
                .padding(16.dp)
                .fillMaxWidth()
                .sizeIn(minHeight = 72.dp)
        ) {
            Column (
                modifier = modifier.weight(1f)
            ){
                Text(
                    text = stringResource(id = heroName),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(id = heroDescription),
                    style = MaterialTheme.typography.bodyLarge
                )
            }

            Spacer(modifier = modifier.width(16.dp))

            Box(
                modifier = modifier
                    .size(72.dp)
                    .clip(RoundedCornerShape(8.dp))
                ,
            ) {
                Image(
                    painter = painterResource(id = imageRes) ,
                    alignment = Alignment.TopCenter,//not sure the use of this
                    contentDescription = null,
                    contentScale = ContentScale.FillWidth//and the use of this
                )
            }
        }
    }
}

@Preview(showBackground = false)
@Composable
fun SuperHeroTheme(){
    SuperheroListItem(
        heroName = R.string.hero2,
        heroDescription = R.string.description2,
        imageRes = R.drawable.android_superhero2

    )
}