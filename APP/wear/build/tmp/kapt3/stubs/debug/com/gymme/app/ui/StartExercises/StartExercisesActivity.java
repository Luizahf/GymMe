package com.gymme.app.ui.StartExercises;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010!H\u0014J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0006\u0010#\u001a\u00020\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006$"}, d2 = {"Lcom/gymme/app/ui/StartExercises/StartExercisesActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "exercise", "", "exerciseList", "", "Lcom/gymme/domain/entities/CompleteExercise;", "getExerciseList", "()Ljava/util/List;", "setExerciseList", "(Ljava/util/List;)V", "startExercisesViewModel", "Lcom/gymme/app/ui/StartExercises/StartExercisesViewModel;", "getStartExercisesViewModel", "()Lcom/gymme/app/ui/StartExercises/StartExercisesViewModel;", "startExercisesViewModel$delegate", "Lkotlin/Lazy;", "worksheetId", "", "getWorksheetId", "()Ljava/lang/String;", "setWorksheetId", "(Ljava/lang/String;)V", "changedMetrics", "", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "saveNewMetrics", "setDisplay", "wear_debug"})
public final class StartExercisesActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private final kotlin.Lazy startExercisesViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.gymme.domain.entities.CompleteExercise> exerciseList;
    private int exercise;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String worksheetId;
    private java.util.HashMap _$_findViewCache;
    
    private final com.gymme.app.ui.StartExercises.StartExercisesViewModel getStartExercisesViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gymme.domain.entities.CompleteExercise> getExerciseList() {
        return null;
    }
    
    public final void setExerciseList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gymme.domain.entities.CompleteExercise> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getWorksheetId() {
        return null;
    }
    
    public final void setWorksheetId(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setDisplay() {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    private final boolean changedMetrics() {
        return false;
    }
    
    private final void saveNewMetrics() {
    }
    
    public StartExercisesActivity() {
        super();
    }
}