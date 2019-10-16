package com.nostereal.universityschedule.data.local.pairs

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "pairs"
)
data class PairEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Long,
    @ColumnInfo(name = "subject_name")
    var subjectName: String,
    @ColumnInfo(name = "teacher_name")
    var teacherName: String,
    @ColumnInfo(name = "date_from")
    var dateFrom: String,
    @ColumnInfo(name = "date_to")
    var dateTo: String
)