package com.gymme.domain.repositories;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0007J1\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u000f"}, d2 = {"Lcom/gymme/domain/repositories/IMetricsRepository;", "", "getMetrics", "Lcom/gymme/domain/entities/Metrics;", "worksheetId", "", "exerciseId", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertExerciseMetrics", "Lcom/gymme/domain/entities/WorksheetExerciseMetrics;", "insertExerciseMetricsResponse", "Lcom/gymme/data/data/InsertExerciseMetricsResponse;", "metrics", "Lcom/gymme/data/data/Base/MetricsEntity;", "(Lcom/gymme/data/data/InsertExerciseMetricsResponse;IILcom/gymme/data/data/Base/MetricsEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wear_debug"})
public abstract interface IMetricsRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getMetrics(int worksheetId, int exerciseId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gymme.domain.entities.Metrics> p2);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertExerciseMetrics(@org.jetbrains.annotations.NotNull()
    com.gymme.data.data.InsertExerciseMetricsResponse insertExerciseMetricsResponse, int exerciseId, int worksheetId, @org.jetbrains.annotations.NotNull()
    com.gymme.data.data.Base.MetricsEntity metrics, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.gymme.domain.entities.WorksheetExerciseMetrics> p4);
}