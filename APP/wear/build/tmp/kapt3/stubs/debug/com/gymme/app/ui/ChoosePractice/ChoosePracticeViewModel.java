package com.gymme.app.ui.ChoosePractice;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\tJ\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000b\"\u0004\b\u0012\u0010\r\u00a8\u0006\u0019"}, d2 = {"Lcom/gymme/app/ui/ChoosePractice/ChoosePracticeViewModel;", "Lcom/gymme/app/ViewModelBase;", "application", "Landroid/app/Application;", "practiceHandler", "Lcom/gymme/domain/handlers/PracticeHandler;", "(Landroid/app/Application;Lcom/gymme/domain/handlers/PracticeHandler;)V", "practiceId", "Landroidx/lifecycle/MutableLiveData;", "", "getPracticeId", "()Landroidx/lifecycle/MutableLiveData;", "setPracticeId", "(Landroidx/lifecycle/MutableLiveData;)V", "practiceList", "", "Lcom/gymme/domain/entities/Practice;", "getPracticeList", "setPracticeList", "getPractices", "", "userId", "selectPractice", "practice", "", "wear_debug"})
public final class ChoosePracticeViewModel extends com.gymme.app.ViewModelBase {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Practice>> practiceList;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> practiceId;
    private final com.gymme.domain.handlers.PracticeHandler practiceHandler = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Practice>> getPracticeList() {
        return null;
    }
    
    public final void setPracticeList(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.gymme.domain.entities.Practice>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getPracticeId() {
        return null;
    }
    
    public final void setPracticeId(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    public final void getPractices(int userId) {
    }
    
    public final void selectPractice(@org.jetbrains.annotations.NotNull()
    java.lang.String practice) {
    }
    
    public ChoosePracticeViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application, @org.jetbrains.annotations.NotNull()
    com.gymme.domain.handlers.PracticeHandler practiceHandler) {
        super(null);
    }
}