package com.example.jjol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jjol.ui.theme.gray

@Composable
fun MatchScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        JJOLButton(
            modifier = Modifier.padding(top = 60.dp, start = 40.dp),
            text = "뒤로",
            btnSize = BtnSize.PREVIOUS_BTN,
            onClick = { }
        )
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 150.dp, end = 150.dp, top = 40.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ic_touch),
            contentDescription = null,
            contentScale = ContentScale.None
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = "1대 1 대결",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.notosans_kr_regular, FontWeight.Medium)),
                color = Color.Black,
                fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
            ),
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            text = "랜덤 매칭",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.notosans_kr_regular, FontWeight.Medium)),
                color = gray,
                fontSize = with(LocalDensity.current) { (12 / fontScale).sp }
            ),
            textAlign = TextAlign.Center
        )
        Box(
            modifier = Modifier
                .padding(start = 54.dp, end = 54.dp, top = 20.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(30.dp),
                )
                .clip(RoundedCornerShape(30.dp))
                .background(color = Color.White, RoundedCornerShape(30.dp)),
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(30.dp),
                text = "랜덤으로 매칭된 플레이어 모두 한\n손가락을 터치한 상태로 누가 더 오래\n버티는지 가리는 게임",
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            contentAlignment = Alignment.Center
        ) {
            JJOLButton(
                text = "시작하기",
                btnSize = BtnSize.START_AND_CREATE_BTN,
                onClick = { }
            )
        }
    }
}