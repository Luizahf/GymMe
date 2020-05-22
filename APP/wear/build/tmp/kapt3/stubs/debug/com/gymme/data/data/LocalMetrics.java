package com.gymme.data.data;

import java.lang.System;

@androidx.room.Entity(tableName = "metrics")
@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B5\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u001b\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJ\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010\rJH\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006H\u00c6\u0001\u00a2\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\b\u0010%\u001a\u00020\u0003H\u0007J\t\u0010&\u001a\u00020\u0006H\u00d6\u0001J\t\u0010\'\u001a\u00020(H\u00d6\u0001R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\t\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001e\u0010\b\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\u001e\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f\u00a8\u0006)"}, d2 = {"Lcom/gymme/data/data/LocalMetrics;", "", "metrics", "Lcom/gymme/domain/entities/Metrics;", "(Lcom/gymme/domain/entities/Metrics;)V", "Id", "", "Series", "Repetitions", "Load", "ExecutionTime", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getExecutionTime", "()Ljava/lang/Integer;", "setExecutionTime", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getId", "()I", "setId", "(I)V", "getLoad", "setLoad", "getRepetitions", "setRepetitions", "getSeries", "setSeries", "component1", "component2", "component3", "component4", "component5", "copy", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/gymme/data/data/LocalMetrics;", "equals", "", "other", "get", "hashCode", "toString", "", "wear_debug"})
public final class LocalMetrics {
    @androidx.room.PrimaryKey()
    private int Id;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Series;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Repetitions;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer Load;
    @org.jetbrains.annotations.Nullable()
    private java.lang.Integer ExecutionTime;
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Ignore()
    public final com.gymme.domain.entities.Metrics get() {
        return null;
    }
    
    public final int getId() {
        return 0;
    }
    
    public final void setId(int p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getSeries() {
        return null;
    }
    
    public final void setSeries(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getRepetitions() {
        return null;
    }
    
    public final void setRepetitions(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getLoad() {
        return null;
    }
    
    public final void setLoad(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getExecutionTime() {
        return null;
    }
    
    public final void setExecutionTime(@org.jetbrains.annotations.Nullable()
    java.lang.Integer p0) {
    }
    
    public LocalMetrics(int Id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Series, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Repetitions, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Load, @org.jetbrains.annotations.Nullable()
    java.lang.Integer ExecutionTime) {
        super();
    }
    
    @androidx.room.Ignore()
    public LocalMetrics(@org.jetbrains.annotations.NotNull()
    com.gymme.domain.entities.Metrics metrics) {
        super();
    }
    
    public final int component1() {
        return 0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.gymme.data.data.LocalMetrics copy(int Id, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Series, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Repetitions, @org.jetbrains.annotations.Nullable()
    java.lang.Integer Load, @org.jetbrains.annotations.Nullable()
    java.lang.Integer ExecutionTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public java.lang.String toString() {
        return null;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
        return false;
    }
}