package com.nikitafrolov.stackoverflow.question

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Question(
    val id: String,
    val title: String,
    val body: String,
    val userName: String,
    val userAvatar: String
) : Parcelable