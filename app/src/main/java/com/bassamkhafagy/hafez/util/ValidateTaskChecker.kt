package com.bassamkhafagy.hafez.util

import com.bassamkhafagy.hafez.data.local.SoraComplete

fun checkReview(review: SoraComplete): RegisterValidation {

    if (review.studentCode!!.isEmpty()) {
        return RegisterValidation.Failed("Student code field cant be empty!!")
    }
    if (review.sheikhName!!.isEmpty()) {
        return RegisterValidation.Failed("Sheikh name field cant be empty!!")
    }

    if (review.ring!!.isEmpty()) {
        return RegisterValidation.Failed("Ring field cant be empty!!")
    }
    if (review.soraName!!.isEmpty()) {
        return RegisterValidation.Failed("Sora field cant be empty!!")
    }
    if (review.state!!.isEmpty()) {
        return RegisterValidation.Failed("Ring field cant be empty!!")
    }
    if (review.degree!!.toInt() > 100 || review.degree.toInt() < 0) {
        return RegisterValidation.Failed("Degree cant be more the 100 or less than 0!!")
    }
    return RegisterValidation.Success
}