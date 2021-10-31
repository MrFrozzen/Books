package ru.mrfrozzen.books.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class BookResponce(
    @SerializedName("results")
    val books : List<Book>
) :  Parcelable {
    constructor() : this (mutableListOf())
}