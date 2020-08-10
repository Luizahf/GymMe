package com.gymme.domain.handlers;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ1\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0012"}, d2 = {"Lcom/gymme/domain/handlers/MetricsHandler;", "", "repository", "Lcom/gymme/domain/repositories/IMetricsRepository;", "(Lcom/gymme/domain/repositories/IMetricsRepository;)V", "execute", "Lcom/gymme/domain/entities/Metrics;", "worksheetId", "", "exerciseId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeInsertExerciseMetrics", "Lcom/gymme/domain/entities/WorksheetExerciseMetrics;", "insertExerciseMetricsResponse", "Lcom/gymme/data/data/InsertExerciseMetricsResponse;", "metrics", "Lcom/gymme/data/data/Base/MetricsEntity;", "(Lcom/gymme/data/data/InsertExerciseMetricsResponse;IILcom/gymme/data/data/Base/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wear_debug"})
public final class MetricsHandler {
    private final com.gymme.domain.repositories.IMetricsRepository repository = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object execute(int worksheetId, int exerciseId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gymme.domain.entities.Metrics> p2) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object executeInsertExerciseMetrics(@org.jetbrains.annotations.NotNull()
    com.gymme.data.data.InsertExerciseMetricsResponse insertExerciseMetricsResponse, int exerciseId, int worksheetId, @org.jetbrains.annotations.NotNull()
    com.gymme.data.data.Base.MetricsEntity metrics, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gymme.domain.entities.WorksheetExerciseMetrics> p4) {
        return null;
    }
    
    public MetricsHandler(@org.jetbrains.annotations.NotNull()
    com.gymme.domain.repositories.IMetricsRepository repository) {
        super();
    }
}