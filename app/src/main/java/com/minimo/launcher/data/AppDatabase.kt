package com.minimo.launcher.data

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.minimo.launcher.data.entities.AppInfoEntity
import com.minimo.launcher.data.entities.ShortcutInfoEntity

@Database(
    entities = [AppInfoEntity::class, ShortcutInfoEntity::class],
    version = 6,
    autoMigrations = [
        AutoMigration(from = 5, to = 6)
    ]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun appInfoDao(): AppInfoDao
    abstract fun shortcutInfoDao(): ShortcutInfoDao
}
