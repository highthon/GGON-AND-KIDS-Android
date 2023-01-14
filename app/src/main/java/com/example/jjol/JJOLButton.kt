package com.example.jjol

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.jjol.ui.theme.primary

enum class BtnSize(
    val paddingStart: Dp,
    val paddingEnd: Dp,
    val paddingTop: Dp,
    val paddingBottom: Dp
) {
    PREVIOUS_BTN(24.dp, 24.dp, 10.dp, 10.dp),
    GO_BTN(42.dp, 42.dp, 10.dp, 10.dp),
    START_AND_CREATE_BTN(27.dp, 27.dp, 13.dp, 13.dp),
    RESULT_BTN(50.dp, 50.dp, 14.dp, 14.dp),
    CHECK_BTN(27.dp, 27.dp, 8.dp, 8.dp)
}


@Composable
fun JJOLButton(
    modifier: Modifier = Modifier,
    text: String,
    btnSize: BtnSize,
    onClick: () -> Unit
) {
    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(60.dp))
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(60.dp),
        color = primary
    ) {
        Text(
            modifier = Modifier.padding(
                start = btnSize.paddingStart,
                top = btnSize.paddingTop,
                end = btnSize.paddingEnd,
                bottom = btnSize.paddingBottom
            ),
            text = text,
            fontStyle = FontStyle(R.font.notosans_kr_regular),
            color = Color.White,
            textAlign = TextAlign.Center
        )
    }
}