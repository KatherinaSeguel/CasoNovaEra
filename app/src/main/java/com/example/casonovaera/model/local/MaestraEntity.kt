package com.example.casonovaera.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "maestra_table")
data class MaestraEntity (
    @PrimaryKey  @NotNull val id: Int,
    val image: String,
    val name: String,
    val price: Int
     )

