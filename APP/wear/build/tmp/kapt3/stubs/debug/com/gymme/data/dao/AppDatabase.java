package com.gymme.data.dao;

import java.lang.System;

@androidx.room.Database(entities = {com.gymme.data.data.LocalExercise.class, com.gymme.data.data.LocalUser.class, com.gymme.data.data.LocalMetrics.class}, version = 1, exportSchema = false)
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\bH&\u00a8\u0006\t"}, d2 = {"Lcom/gymme/data/dao/AppDatabase;", "Landroidx/room/RoomDatabase;", "()V", "metricsDao", "Lcom/gymme/data/dao/MetricsDao;", "userDao", "Lcom/gymme/data/dao/UserDao;", "worksheetExercisesDao", "Lcom/gymme/data/dao/WorksheetExercisesDao;", "wear_debug"})
public abstract class AppDatabase extends androidx.room.RoomDatabase {
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gymme.data.dao.WorksheetExercisesDao worksheetExercisesDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gymme.data.dao.UserDao userDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.gymme.data.dao.MetricsDao metricsDao();
    
    public AppDatabase() {
        super();
    }
}