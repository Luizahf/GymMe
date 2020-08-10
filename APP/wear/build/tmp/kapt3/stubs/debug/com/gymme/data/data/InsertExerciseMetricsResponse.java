package com.gymme.data.data;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&\u00a8\u0006\f"}, d2 = {"Lcom/gymme/data/data/InsertExerciseMetricsResponse;", "", "failure", "", "statusCode", "", "message", "", "(Ljava/lang/Integer;Ljava/lang/String;)V", "success", "worksheetExerciseMetrics", "Lcom/gymme/domain/entities/WorksheetExerciseMetrics;", "wear_debug"})
public abstract interface InsertExerciseMetricsResponse {
    
    public abstract void failure(@org.jetbrains.annotations.Nullable()
    java.lang.Integer statusCode, @org.jetbrains.annotations.NotNull()
    java.lang.String message);
    
    public abstract void success(@org.jetbrains.annotations.NotNull()
    com.gymme.domain.entities.WorksheetExerciseMetrics worksheetExerciseMetrics);
}