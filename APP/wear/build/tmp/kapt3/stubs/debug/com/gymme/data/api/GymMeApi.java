package com.gymme.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\'J \u0010\b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0018\u00010\u00032\b\b\u0001\u0010\u000b\u001a\u00020\u0006H\'J \u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\t\u0018\u00010\u00032\b\b\u0001\u0010\u000e\u001a\u00020\u0006H\'J$\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00032\b\b\u0001\u0010\u0011\u001a\u00020\u00122\b\b\u0001\u0010\u0013\u001a\u00020\u0012H\'J \u0010\u0014\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\t0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0016"}, d2 = {"Lcom/gymme/data/api/GymMeApi;", "", "getMetrics", "Lretrofit2/Call;", "Lcom/gymme/data/data/Base/MetricsEntity;", "worksheetId", "", "exerciseId", "getPractice", "", "Lcom/gymme/data/data/Base/PracticeEntity;", "userId", "getPracticeWorksheets", "Lcom/gymme/data/data/Base/WorksheetEntity;", "practiceId", "getUser", "Lcom/gymme/data/data/Base/UserEntity;", "login", "", "password", "getWorksheetExercises", "Lcom/gymme/data/data/Base/ExerciseEntity;", "wear_debug"})
public abstract interface GymMeApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "worksheetExercises/{worksheetId}/exercises")
    public abstract retrofit2.Call<java.util.List<com.gymme.data.data.Base.ExerciseEntity>> getWorksheetExercises(@retrofit2.http.Path(value = "worksheetId")
    int worksheetId);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "metrics/{worksheetId}/exercise/{exerciseId}")
    public abstract retrofit2.Call<com.gymme.data.data.Base.MetricsEntity> getMetrics(@retrofit2.http.Path(value = "worksheetId")
    int worksheetId, @retrofit2.http.Path(value = "exerciseId")
    int exerciseId);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "users/{login}/{password}")
    public abstract retrofit2.Call<com.gymme.data.data.Base.UserEntity> getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "login")
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "password")
    java.lang.String password);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "practice/{userId}")
    public abstract retrofit2.Call<java.util.List<com.gymme.data.data.Base.PracticeEntity>> getPractice(@retrofit2.http.Path(value = "userId")
    int userId);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "practiceWorksheets/{practiceId}/worksheets")
    public abstract retrofit2.Call<java.util.List<com.gymme.data.data.Base.WorksheetEntity>> getPracticeWorksheets(@retrofit2.http.Path(value = "practiceId")
    int practiceId);
}