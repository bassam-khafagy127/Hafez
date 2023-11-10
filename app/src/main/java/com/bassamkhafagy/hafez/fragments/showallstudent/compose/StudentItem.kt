package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bassamkhafagy.hafez.atoms.DarkColorSurface
import com.bassamkhafagy.hafez.atoms.LightColorSurface

@Composable
fun StudentItem(studentName: String, shiehkName: String, ring: String) {
    Row(Modifier.fillMaxWidth()) {
        StudentItemBox(
            title = studentName,
            Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
        )
        StudentItemBox(
            title = shiehkName, Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
        )
        StudentItemBox(
            title = ring, Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
    }

}

@Composable
fun StudentItemBox(title: String, modifier: Modifier) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = DarkColorSurface, textAlign = TextAlign.Center
            )
        )
    }
}
