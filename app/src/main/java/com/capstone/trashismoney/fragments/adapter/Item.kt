package com.capstone.trashismoney.fragments.adapter

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Item (
    val name: String? = null,
    val price: Double? = null,
    val image: String? = null,
) : Parcelable