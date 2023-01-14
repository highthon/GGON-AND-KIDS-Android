package com.example.jjol

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.navigation.NavController
import com.example.jjol.ui.theme.clock
import com.example.jjol.ui.theme.gray
import com.example.jjol.ui.theme.primary

@Composable
fun MatchSuccessScreen(navController: NavController) {
    val hourState = remember {
        mutableStateOf("00")
    }
    val minState = remember {
        mutableStateOf("00")
    }
    val secState = remember {
        mutableStateOf("00")
    }
    val dialogState = remember {
        mutableStateOf(false)
    }
    if (dialogState.value) {
        CheckDialog(onDismissRequest = {})
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 45.dp, end = 40.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_profile_circle),
                contentDescription = null
            )
            Text(
                modifier = Modifier.padding(start = 6.dp),
                text = "1/2",
                style = TextStyle(
                    fontFamily = FontFamily(Font(R.font.notosans_kr_regular, FontWeight.Medium)),
                    color = Color.Black,
                    fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
                )
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 135.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_touch),
                contentDescription = null
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            text = "@ganada",
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
            text = "플레이 중",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.notosans_kr_regular, FontWeight.Medium)),
                color = gray,
                fontSize = with(LocalDensity.current) { (12 / fontScale).sp }
            ),
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            text = "VS",
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.notosans_kr_regular, FontWeight.Medium)),
                color = primary,
                fontSize = with(LocalDensity.current) { (20 / fontScale).sp }
            ),
            textAlign = TextAlign.Center
        )
        Timer(
            modifier = Modifier.padding(top = 20.dp, start = 40.dp, end = 40.dp),
            hourState = hourState,
            minState = minState,
            secState = secState
        )
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.padding(top = 100.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_baseline_fingerprint_24),
                contentDescription = null
            )
        }
    }
}

@Composable
fun Timer(
    modifier: Modifier = Modifier,
    hourState: MutableState<String>,
    minState: MutableState<String>,
    secState: MutableState<String>
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(color = Color.White),
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
}

@Composable
fun Time(
    modifier: Modifier = Modifier,
    time: MutableState<String>
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .shadow(
                elevation = 5.dp,
                shape = RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .background(color = primary),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = time.value,
            style = TextStyle(
                fontFamily = FontFamily(Font(R.font.notosans_kr_regular)),
                color = Color.White,
                fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
            )
        )
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun CheckDialog(
    properties: DialogProperties = DialogProperties(usePlatformDefaultWidth = false),
    onDismissRequest: () -> Unit
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = properties
    ) {
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp),
            color = Color.White,
            shape = RoundedCornerShape(30.dp)
        ) {
            Column {
                Image(
                    modifier = Modifier
                        .padding(top = 30.dp)
                        .align(Alignment.CenterHorizontally),
                    painter = painterResource(id = R.drawable.ic_warning),
                    contentDescription = null,
                    alignment = Alignment.Center
                )
                Text(
                    modifier = Modifier
                        .padding(top = 20.dp)
                        .align(Alignment.CenterHorizontally),
                    text = buildAnnotatedString {
                        withStyle(
                            style = TextStyle(
                                fontFamily = FontFamily(
                                    Font(
                                        R.font.notosans_kr_bold,
                                        FontWeight.Bold
                                    )
                                ),
                                color = primary,
                                fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
                            ).toSpanStyle()
                        ) {
                            append("확인 버튼")
                        }
                        append("을 눌러주세요!")
                    },
                    style = TextStyle(
                        fontFamily = FontFamily(
                            Font(
                                R.font.notosans_kr_bold,
                                FontWeight.Bold
                            )
                        ),
                        color = Color.Black,
                        fontSize = with(LocalDensity.current) { (16 / fontScale).sp }
                    )
                )
                Text(
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "5초 이내 눌러야 패배처리 되지 않습니다.",
                    style = TextStyle(
                        fontFamily = FontFamily(
                            Font(R.font.notosans_kr_regular),
                        ),
                        fontSize = with(LocalDensity.current) { (12 / fontScale).sp },
                        color = gray
                    )
                )
                JJOLButton(
                    modifier = Modifier
                        .padding(top = 20.dp, bottom = 30.dp)
                        .align(Alignment.CenterHorizontally),
                    text = "확인하기",
                    btnSize = BtnSize.CHECK_BTN,
                    onClick = {}
                )
            }
        }
    }
}