package com.bassamkhafagy.hafez.fragments.showallstudent.compose

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.atoms.DarkColorSurface
import com.bassamkhafagy.hafez.atoms.LightColorSurface

@Composable
fun StudentListHeader() {
    Row(Modifier.fillMaxWidth()) {
        BoxHeader(
            R.string.studentName,
            modifier = Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(horizontal = 4.dp, vertical = 4.dp)
        )
        BoxHeader(
            R.string.shiekh,
            modifier = Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(start = 4.dp, top = 4.dp, bottom = 4.dp)

        )

        BoxHeader(
            R.string.ring,
            modifier = Modifier
                .weight(1f)
                .background(LightColorSurface)
                .padding(horizontal = 4.dp, vertical = 4.dp)
        )

    }
}

@Composable
fun BoxHeader(
    id: Int, modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = stringResource(id = id),
            style = MaterialTheme.typography.body1.copy(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = DarkColorSurface
            )
        )
    }
}