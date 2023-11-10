package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bassamkhafagy.hafez.atoms.DarkColorSurface

@Composable
fun StudentItem(studentName: String, shiehkName: String, ring: String) {
    Row(Modifier.fillMaxWidth()) {
        StudentItemBox(title = studentName)
        StudentItemBox(title = shiehkName)
        StudentItemBox(title = ring)
    }

}

@Composable
fun StudentItemBox(title: String) {
    Box(
        modifier = Modifier
            .border(2.dp, DarkColorSurface)
            .padding(horizontal = 4.dp, vertical = 4.dp),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 12.sp,
                color = DarkColorSurface
            )
        )
    }
}
