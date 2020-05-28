package com.gymme.app.ui.ChoosePractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\u0014\u0010\u001f\u001a\u00020\u00192\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/gymme/app/ui/ChoosePractice/ChoosePracticeActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/view/View$OnClickListener;", "()V", "choosePracticeViewModel", "Lcom/gymme/app/ui/ChoosePractice/ChoosePracticeViewModel;", "getChoosePracticeViewModel", "()Lcom/gymme/app/ui/ChoosePractice/ChoosePracticeViewModel;", "choosePracticeViewModel$delegate", "Lkotlin/Lazy;", "practiceList", "", "Lcom/gymme/domain/entities/Practice;", "getPracticeList", "()Ljava/util/List;", "setPracticeList", "(Ljava/util/List;)V", "selectedPracticeId", "Landroidx/lifecycle/MutableLiveData;", "", "getSelectedPracticeId", "()Landroidx/lifecycle/MutableLiveData;", "setSelectedPracticeId", "(Landroidx/lifecycle/MutableLiveData;)V", "onClick", "", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setPracticeSpinner", "practices", "wear_debug"})
public final class ChoosePracticeActivity extends androidx.appcompat.app.AppCompatActivity implements android.view.View.OnClickListener {
    private final kotlin.Lazy choosePracticeViewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.gymme.domain.entities.Practice> practiceList;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> selectedPracticeId;
    private java.util.HashMap _$_findViewCache;
    
    private final com.gymme.app.ui.ChoosePractice.ChoosePracticeViewModel getChoosePracticeViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.gymme.domain.entities.Practice> getPracticeList() {
        return null;
    }
    
    public final void setPracticeList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gymme.domain.entities.Practice> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getSelectedPracticeId() {
        return null;
    }
    
    public final void setSelectedPracticeId(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    public final void setPracticeSpinner(@org.jetbrains.annotations.NotNull()
    java.util.List<com.gymme.domain.entities.Practice> practices) {
    }
    
    @java.lang.Override()
    public void onClick(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
    }
    
    public ChoosePracticeActivity() {
        super();
    }
}