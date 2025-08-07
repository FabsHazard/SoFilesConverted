package com.microtech.aidexx.ui.pair;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityPairedHistoryBinding;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0002J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\b\u0010\r\u001a\u00020\tH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ui/pair/PairedHistoryActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityPairedHistoryBinding;", "()V", "pairedHistoryAdapter", "Lcom/microtech/aidexx/ui/pair/PairedHistoryAdapter;", "getViewBinding", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: PairedHistoryActivity.kt */
public final class PairedHistoryActivity extends BaseActivity<BaseViewModel, ActivityPairedHistoryBinding> {
    /* access modifiers changed from: private */
    public PairedHistoryAdapter pairedHistoryAdapter;

    public ActivityPairedHistoryBinding getViewBinding() {
        ActivityPairedHistoryBinding inflate = ActivityPairedHistoryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityPairedHistoryBinding) getBinding()).getRoot());
        initView();
    }

    private final void initView() {
        ((ActivityPairedHistoryBinding) getBinding()).ivBack.setOnClickListener(new PairedHistoryActivity$$ExternalSyntheticLambda0(this));
        ((ActivityPairedHistoryBinding) getBinding()).rvPairedHistory.setLayoutManager(new LinearLayoutManager(this));
        this.pairedHistoryAdapter = new PairedHistoryAdapter();
        RecyclerView recyclerView = ((ActivityPairedHistoryBinding) getBinding()).rvPairedHistory;
        PairedHistoryAdapter pairedHistoryAdapter2 = this.pairedHistoryAdapter;
        if (pairedHistoryAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pairedHistoryAdapter");
            pairedHistoryAdapter2 = null;
        }
        recyclerView.setAdapter(pairedHistoryAdapter2);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(PairedHistoryActivity pairedHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(pairedHistoryActivity, "this$0");
        pairedHistoryActivity.finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new PairedHistoryActivity$onResume$1(this, (Continuation<? super PairedHistoryActivity$onResume$1>) null), 3, (Object) null);
    }
}
