package com.example.jjol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.ExperimentalTextApi
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.jjol.navigation.JjolNavigation
import com.example.jjol.ui.theme.gray

@OptIn(ExperimentalTextApi::class)
@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.padding(top = 80.dp),
            painter = painterResource(id = R.mipmap.character2),
            contentDescription = null
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 52.dp, start = 40.dp),
            text = "게임 리스트",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.nunito_sans_extrabold, FontWeight.ExtraBold)),
                color = Color.Black,
                fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
            )
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 16.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(30.dp)
                )
                .background(shape = RoundedCornerShape(30.dp), color = Color.White)
                .clickable { navController.navigate(JjolNavigation.Match.route) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_match),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "1대 1 대결",
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_kr_regular,
                                FontWeight.Medium
                            )
                        ),
                        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    ),

                    )
                Text(
                    text = "랜덤 매칭",
                    style = TextStyle(
                        color = gray,
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_kr_regular,
                                FontWeight.Medium
                            )
                        ),
                        fontSize = with(LocalDensity.current) { (12 / fontScale).sp }
                    )
                )
            }
            Image(
                modifier = Modifier
                    .padding(top = 33.dp, bottom = 33.dp, end = 30.dp),
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.ic_baseline_arrow_forward_ios_24
                ),
                contentDescription = null
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 40.dp, end = 40.dp, top = 20.dp)
                .shadow(
                    elevation = 5.dp,
                    shape = RoundedCornerShape(30.dp)
                )
                .background(shape = RoundedCornerShape(30.dp), color = Color.White)
                .clickable { navController.navigate(JjolNavigation.Challenge.route) },
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 25.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_callenge),
                contentDescription = null
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(
                    text = "챌린지",
                    style = TextStyle(
                        color = Color.Black,
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_kr_regular,
                                FontWeight.Medium
                            )
                        ),
                        fontSize = with(LocalDensity.current) { (16 / fontScale).sp },
                        platformStyle = PlatformTextStyle(includeFontPadding = false)
                    ),

                    )
                Text(
                    text = "시간 맞추기",
                    style = TextStyle(
                        color = gray,
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_kr_regular,
                                FontWeight.Medium
                            )
                        ),
                        fontSize = with(LocalDensity.current) { (12 / fontScale).sp }
                    )
                )
            }
            Image(
                modifier = Modifier
                    .padding(top = 33.dp, bottom = 33.dp, end = 30.dp),
                imageVector = ImageVector.vectorResource(
                    id = R.drawable.ic_baseline_arrow_forward_ios_24
                ),
                contentDescription = null
            )
        }
    }
}

