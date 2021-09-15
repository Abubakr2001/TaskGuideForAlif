package com.leonardo.guideapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "guides")
data class Guide(
    @PrimaryKey
    val url: String,
    val startDate: String,
    val endDate: String,
    val name: String,
    val icon: String
)
