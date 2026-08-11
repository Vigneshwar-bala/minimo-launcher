package com.minimo.launcher.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minimo.launcher.ui.theme.Dimens

@Composable
fun CalculatorResultItem(
    modifier: Modifier = Modifier,
    result: String,
    onClick: () -> Unit,
    appsArrangement: Arrangement.Horizontal,
    textSize: TextUnit = 20.sp,
    verticalPadding: Dp = 16.dp,
    textColor: Color = MaterialTheme.colorScheme.onSurface,
    shadow: Shadow? = null
) {
    val lineHeight by remember { derivedStateOf { textSize * 1.2 } }

    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(horizontal = Dimens.APP_HORIZONTAL_SPACING, vertical = verticalPadding),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = appsArrangement
    ) {
        Text(
            text = result,
            color = textColor,
            fontSize = textSize,
            lineHeight = lineHeight,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = LocalTextStyle.current.copy(shadow = shadow)
        )
    }
}
