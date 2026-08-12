package com.minimo.launcher.ui.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.minimo.launcher.ui.theme.Dimens

@Composable
fun GoogleSearchSuggestionItem(
    modifier: Modifier = Modifier,
    query: String,
    onClick: () -> Unit,
    appsArrangement: Arrangement.Horizontal,
    textSize: TextUnit = 14.sp,
    verticalPadding: Dp = 8.dp,
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
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search $query in Google",
            tint = textColor.copy(alpha = 0.7f),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = "Search meaning in Google",
            color = textColor.copy(alpha = 0.7f),
            fontSize = textSize,
            fontStyle = FontStyle.Italic,
            lineHeight = lineHeight,
            maxLines = 1,
            style = LocalTextStyle.current.copy(shadow = shadow)
        )
    }
}
