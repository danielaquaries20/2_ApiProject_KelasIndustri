package com.example.a2apiproject_kelasindustri.data.user

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity
data class User(

    @PrimaryKey
    @Expose
    @SerializedName("id_room")
    val idRoom: Int,

    @Expose
    @SerializedName("id")
    val id: Int?,

    @Expose
    @SerializedName("name")
    val name: String?,

    @Expose
    @SerializedName("photo")
    val photo: String?,

    @Expose
    @SerializedName("school")
    val school: String?,

    @Expose
    @SerializedName("description")
    val description: String?,

    @Expose
    @SerializedName("likes")
    val likes: Int?


)