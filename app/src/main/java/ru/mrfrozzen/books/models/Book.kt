package ru.mrfrozzen.books.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

//import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    @SerializedName("id")
    val id:String?,

    @SerializedName("title")
    val title:String?,

    @SerializedName("description")
    val description:String?,

    @SerializedName("author")
    val author:String?
) : Parcelable {
    constructor() : this("","", "","")
}
