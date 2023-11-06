package com.bassamkhafagy.hafez.atoms

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun headerStyle(color: Color = MaterialTheme.colors.onBackground) =
    MaterialTheme.typography.h6.copy(
        fontWeight = FontWeight.Bold,
        color = color,
        fontSize = 18.sp
    )

@Composable
fun sectionStyle() = MaterialTheme.typography.body1.copy(
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colors.onSurface,
    fontSize = 16.sp
)

@Composable
fun cardStyle() = MaterialTheme.typography.body1.copy(
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colors.onBackground,
    fontSize = 14.sp
)

@Composable
fun cardSubStyle(color: Color = MaterialTheme.colors.onSurface) =
    MaterialTheme.typography.body1.copy(
        fontWeight = FontWeight.Normal,
        color = color,
        fontSize = 14.sp
    )

@Composable
fun errorStyle() = MaterialTheme.typography.caption.copy(
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colors.error,
    fontSize = 10.sp
)

@Composable
fun buttonStyle() = MaterialTheme.typography.caption.copy(
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colors.onPrimary,
    fontSize = 14.sp
)

@Composable
fun buttonStyleNormal() = MaterialTheme.typography.caption.copy(
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colors.onPrimary,
    fontSize = 12.sp
)

@Composable
fun valueStyle() = MaterialTheme.typography.body1.copy(
    fontWeight = FontWeight.Normal,
    color = MaterialTheme.colors.primary,
    fontSize = 14.sp
)


@Composable
fun genericStyle(
    defaultStyle: TextStyle,
    fontWeight: FontWeight,
    color: Color,
    fontSize: TextUnit,
): TextStyle {
    return defaultStyle.copy(
        fontWeight = fontWeight,
        color = color,
        fontSize = fontSize
    )
}


@Composable
fun topBarTitleStyle() = MaterialTheme.typography.h6.copy(
    fontWeight = FontWeight.Bold,
    color = MaterialTheme.colors.onBackground,
    fontSize = 18.sp
)