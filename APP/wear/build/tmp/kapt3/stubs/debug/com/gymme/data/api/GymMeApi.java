package com.gymme.data.api;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\'J\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00032\b\b\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bH\'J \u0010\r\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e0\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\'\u00a8\u0006\u0010"}, d2 = {"Lcom/gymme/data/api/GymMeApi;", "", "getMetrics", "Lretrofit2/Call;", "Lcom/gymme/data/data/Base/MetricsEntity;", "worksheetId", "", "exerciseId", "getUser", "Ldata/data/Base/UserEntity;", "login", "", "password", "getWorksheetExercises", "", "Lcom/gymme/data/data/Base/ExerciseEntity;", "wear_debug"})
public abstract interface GymMeApi {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "worksheetExercises/{worksheetId}/exercises")
    public abstract retrofit2.Call<java.util.List<com.gymme.data.data.Base.ExerciseEntity>> getWorksheetExercises(@retrofit2.http.Path(value = "worksheetId")
    int worksheetId);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "metrics/{worksheetId}/exercise/{exerciseId}")
    public abstract retrofit2.Call<com.gymme.data.data.Base.MetricsEntity> getMetrics(@retrofit2.http.Path(value = "worksheetId")
    int worksheetId, int exerciseId);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "users/{login}/{password}")
    public abstract retrofit2.Call<data.data.Base.UserEntity> getUser(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Path(value = "login")
    java.lang.String login, @org.jetbrains.annotations.NotNull()
    java.lang.String password);
}