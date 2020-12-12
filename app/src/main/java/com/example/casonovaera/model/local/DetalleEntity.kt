package com.example.casonovaera.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import org.jetbrains.annotations.NotNull

@Entity(tableName = "maestra_table2")
data class DetalleEntity (
    @PrimaryKey @NotNull val id: Int,
    val credit: Boolean,
    val description: String,
    val image: String,
    val lastPrice: Int,
    val name: String,
    val price: Int
)