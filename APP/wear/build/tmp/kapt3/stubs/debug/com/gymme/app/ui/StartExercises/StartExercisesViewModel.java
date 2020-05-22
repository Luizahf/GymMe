package com.gymme.app.ui.StartExercises;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0013"}, d2 = {"Lcom/gymme/app/ui/StartExercises/StartExercisesViewModel;", "Lcom/gymme/app/ViewModelBase;", "application", "Landroid/app/Application;", "worksheetExercisesHandler", "Lcom/gymme/domain/handlers/WorksheetExercisesHandler;", "(Landroid/app/Application;Lcom/gymme/domain/handlers/WorksheetExercisesHandler;)V", "worksheetExercisesList", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/gymme/domain/entities/Exercise;", "getWorksheetExercisesList", "()Landroidx/lifecycle/MutableLiveData;", "setWorksheetExercisesList", "(Landroidx/lifecycle/MutableLiveData;)V", "getWorksheetExercises", "", "worksheetId", "", "wear_debug"})
public final class StartExercisesViewModel extends com.gymme.app.ViewModelBase {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Exercise>> worksheetExercisesList;
    private final com.gymme.domain.handlers.WorksheetExercisesHandler worksheetExercisesHandler = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Exercise>> getWorksheetExercisesList() {
        return null;
    }
    
    public final void setWorksheetExercisesList(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Exercise>> p0) {
    }
    
    public final void getWorksheetExercises(int worksheetId) {
    }
    
    public StartExercisesViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.gymme.domain.handlers.WorksheetExercisesHandler worksheetExercisesHandler) {
        super(null);
    }
}