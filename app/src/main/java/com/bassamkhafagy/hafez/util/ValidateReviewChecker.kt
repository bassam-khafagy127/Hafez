package com.bassamkhafagy.hafez.util

import android.content.Context
import com.bassamkhafagy.hafez.R
import com.bassamkhafagy.hafez.data.local.SoraReview

fun checkReview(review: SoraReview, context: Context): RegisterValidation {

    if (review.studentCode!!.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.studentWarning))
    }
    if (review.sheikhName!!.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.shikhWarning))
    }

    if (review.ring!!.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.ringWarning))
    }
    if (review.soraName!!.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.soraWarning))
    }
    if (review.state!!.isEmpty()) {
        return RegisterValidation.Failed(context.getString(R.string.stateWarning))
    }
    if (review.degree!!.toInt() > 100 || review.degree.toInt() < 0) {
        return RegisterValidation.Failed(context.getString(R.string.degreeWarning))
    }
    return RegisterValidation.Success
}