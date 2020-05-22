package com.gymme.data.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\fJ\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/gymme/data/repositories/WorksheetExercisesRepository;", "Lcom/gymme/domain/repositories/IWorksheetExercisesRepository;", "dao", "Lcom/gymme/data/dao/WorksheetExercisesDao;", "api", "Lcom/gymme/data/api/GymMeApi;", "(Lcom/gymme/data/dao/WorksheetExercisesDao;Lcom/gymme/data/api/GymMeApi;)V", "getWorksheetExercises", "", "Lcom/gymme/domain/entities/Exercise;", "worksheetId", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "", "worksheetLocalExercises", "Lcom/gymme/data/data/LocalExercise;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wear_debug"})
public final class WorksheetExercisesRepository implements com.gymme.domain.repositories.IWorksheetExercisesRepository {
    private final com.gymme.data.dao.WorksheetExercisesDao dao = null;
    private final com.gymme.data.api.GymMeApi api = null;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getWorksheetExercises(int worksheetId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.gymme.domain.entities.Exercise>> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gymme.data.data.LocalExercise> worksheetLocalExercises, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public WorksheetExercisesRepository(@org.jetbrains.annotations.NotNull()
    com.gymme.data.dao.WorksheetExercisesDao dao, @org.jetbrains.annotations.NotNull()
    com.gymme.data.api.GymMeApi api) {
        super();
    }
}