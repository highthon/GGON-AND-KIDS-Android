package com.example.jjol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jjol.ui.theme.clock

private val roundedCornerShape: RoundedCornerShape = RoundedCornerShape(12.dp)

@Composable
fun JoinChallenge(navController: NavController) {
    val hourState = remember { mutableStateOf("00") }
    val minState = remember { mutableStateOf("00") }
    val secState = remember { mutableStateOf("11") }

    Column {
        Spacer(modifier = Modifier.height(250.dp))

        Spacer(modifier = Modifier.height(30.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
                .height(120.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = roundedCornerShape
                )
                .background(
                    color = Color.White,
                    shape = roundedCornerShape
                ),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Time(
                modifier = Modifier.padding(start = 30.dp, top = 30.dp, bottom = 30.dp),
                time = hourState
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = ":",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nunito_sans_extrabold)),
                    color = clock,
                    fontSize = with(LocalDensity.current) { (24 / fontScale).sp }
                )
            )
            Time(
                time = minState
            )
            Text(
                modifier = Modifier.padding(horizontal = 8.dp),
                text = ":",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.nunito_sans_extrabold)),
                    color = clock,
                    fontSize = with(LocalDensity.current) { (24 / fontScale).sp }
                )
            )
            Time(
                modifier = Modifier.padding(end = 30.dp),
                time = secState
            )
        }

        Spacer(modifier = Modifier.height(194.dp))

        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.padding(top = 70.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_fingerprint_24),
                contentDescription = null
            )
        }
    }
}