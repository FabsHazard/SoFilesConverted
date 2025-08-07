package com.microtech.aidexx.ui.main.bg.history;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityBloodGlucoseHistoryBinding;
import com.microtech.aidexx.views.calendar.CalendarDialog;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.util.Calendar;
import java.util.Date;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\u001c\u0010\u0019\u001a\u00020\u00132\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityBloodGlucoseHistoryBinding;", "()V", "historyAdapter", "Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryAdapter;", "getHistoryAdapter", "()Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryAdapter;", "setHistoryAdapter", "(Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryAdapter;)V", "root", "Landroid/view/View;", "getRoot", "()Landroid/view/View;", "setRoot", "(Landroid/view/View;)V", "getViewBinding", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openCalendar", "updateBgHistory", "startDate", "Ljava/util/Date;", "endDate", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BloodGlucoseHistoryActivity.kt */
public final class BloodGlucoseHistoryActivity extends BaseActivity<BaseViewModel, ActivityBloodGlucoseHistoryBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "BloodGlucoseHistoryActivity";
    public BloodGlucoseHistoryAdapter historyAdapter;
    public View root;

    public final BloodGlucoseHistoryAdapter getHistoryAdapter() {
        BloodGlucoseHistoryAdapter bloodGlucoseHistoryAdapter = this.historyAdapter;
        if (bloodGlucoseHistoryAdapter != null) {
            return bloodGlucoseHistoryAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("historyAdapter");
        return null;
    }

    public final void setHistoryAdapter(BloodGlucoseHistoryAdapter bloodGlucoseHistoryAdapter) {
        Intrinsics.checkNotNullParameter(bloodGlucoseHistoryAdapter, "<set-?>");
        this.historyAdapter = bloodGlucoseHistoryAdapter;
    }

    public final View getRoot() {
        View view = this.root;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("root");
        return null;
    }

    public final void setRoot(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.root = view;
    }

    public ActivityBloodGlucoseHistoryBinding getViewBinding() {
        ActivityBloodGlucoseHistoryBinding inflate = ActivityBloodGlucoseHistoryBinding.inflate(LayoutInflater.from(this));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityBloodGlucoseHistoryBinding) getBinding()).getRoot());
        initView();
        initData();
    }

    private final void initView() {
        ActivityBloodGlucoseHistoryBinding activityBloodGlucoseHistoryBinding = (ActivityBloodGlucoseHistoryBinding) getBinding();
        activityBloodGlucoseHistoryBinding.rlDateSpace.setOnClickListener(new BloodGlucoseHistoryActivity$$ExternalSyntheticLambda0(this));
        activityBloodGlucoseHistoryBinding.ivBack.setOnClickListener(new BloodGlucoseHistoryActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(BloodGlucoseHistoryActivity bloodGlucoseHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(bloodGlucoseHistoryActivity, "this$0");
        bloodGlucoseHistoryActivity.openCalendar();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(BloodGlucoseHistoryActivity bloodGlucoseHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(bloodGlucoseHistoryActivity, "this$0");
        bloodGlucoseHistoryActivity.finish();
    }

    private final void initData() {
        setHistoryAdapter(new BloodGlucoseHistoryAdapter());
        RecyclerView recyclerView = ((ActivityBloodGlucoseHistoryBinding) getBinding()).rvGlucoseHistory;
        recyclerView.setAdapter(getHistoryAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        updateBgHistory(Dialogs.DateInfo.INSTANCE.getDateLastWeek(), Dialogs.DateInfo.INSTANCE.getDateToday());
    }

    private final void openCalendar() {
        new CalendarDialog(this, false, new BloodGlucoseHistoryActivity$openCalendar$1(this), new BloodGlucoseHistoryActivity$openCalendar$2(this)).show();
    }

    /* access modifiers changed from: private */
    public final void updateBgHistory(Date date, Date date2) {
        if (date != null && date2 != null) {
            ((ActivityBloodGlucoseHistoryBinding) getBinding()).timeBegin.setText(ExtendsKt.formatToYMd(date));
            Calendar instance = Calendar.getInstance();
            instance.setTime(date2);
            instance.add(5, -1);
            TextView textView = ((ActivityBloodGlucoseHistoryBinding) getBinding()).timeEnd;
            Date time = instance.getTime();
            Intrinsics.checkNotNullExpressionValue(time, "getTime(...)");
            textView.setText(ExtendsKt.formatToYMd(time));
            Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BloodGlucoseHistoryActivity$updateBgHistory$1(this, date, date2, (Continuation<? super BloodGlucoseHistoryActivity$updateBgHistory$1>) null), 3, (Object) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/history/BloodGlucoseHistoryActivity$Companion;", "", "()V", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BloodGlucoseHistoryActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
