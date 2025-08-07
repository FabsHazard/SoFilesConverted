package com.microtech.aidexx.ui.setting.timezonehistory;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivityTimezoneHistoryBinding;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity_;
import com.microtech.aidexx.ui.pair.NoCrashLinerLayoutManager;
import com.microtech.aidexx.utils.DensityUtils;
import io.objectbox.Box;
import io.objectbox.query.QueryBuilder;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u000b\u001a\u00020\n2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0014R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/ui/setting/timezonehistory/TimezoneHistoryActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityTimezoneHistoryBinding;", "()V", "histories", "", "Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "getViewBinding", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TimezoneHistoryActivity.kt */
public final class TimezoneHistoryActivity extends BaseActivity<BaseViewModel, ActivityTimezoneHistoryBinding> {
    private List<TimezoneHistoryEntity> histories;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityTimezoneHistoryBinding) getBinding()).getRoot());
        initView();
    }

    public ActivityTimezoneHistoryBinding getViewBinding() {
        ActivityTimezoneHistoryBinding inflate = ActivityTimezoneHistoryBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    private final void initView() {
        String string = getString(R.string.timeZone_history_note_title);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.timeZone_history_note_desc);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        SpannableString spannableString = new SpannableString(string + 10 + string2);
        spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
        spannableString.setSpan(new ForegroundColorSpan(getColor(R.color.gray1)), 0, spannableString.length(), 33);
        ((ActivityTimezoneHistoryBinding) getBinding()).tvTimezoneHistoryNotice.setText(spannableString);
        ((ActivityTimezoneHistoryBinding) getBinding()).actionbarTimezoneHistory.getLeftIcon().setOnClickListener(new TimezoneHistoryActivity$$ExternalSyntheticLambda0(this));
        ((ActivityTimezoneHistoryBinding) getBinding()).rvTimezoneHistory.addItemDecoration(new SpacesItemDecoration(DensityUtils.dp2px(10.0f)));
        Context context = this;
        ((ActivityTimezoneHistoryBinding) getBinding()).rvTimezoneHistory.setLayoutManager(new NoCrashLinerLayoutManager(context));
        TimeZoneHistoryAdapter timeZoneHistoryAdapter = new TimeZoneHistoryAdapter(context);
        ((ActivityTimezoneHistoryBinding) getBinding()).rvTimezoneHistory.setAdapter(timeZoneHistoryAdapter);
        ObjectBox.INSTANCE.runAsync(new TimezoneHistoryActivity$$ExternalSyntheticLambda1(this, timeZoneHistoryAdapter), TimezoneHistoryActivity$initView$3.INSTANCE, TimezoneHistoryActivity$initView$4.INSTANCE);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(TimezoneHistoryActivity timezoneHistoryActivity, View view) {
        Intrinsics.checkNotNullParameter(timezoneHistoryActivity, "this$0");
        timezoneHistoryActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(TimezoneHistoryActivity timezoneHistoryActivity, TimeZoneHistoryAdapter timeZoneHistoryAdapter) {
        Intrinsics.checkNotNullParameter(timezoneHistoryActivity, "this$0");
        Intrinsics.checkNotNullParameter(timeZoneHistoryAdapter, "$adapter");
        Box<TimezoneHistoryEntity> timeZoneHistoryBox = ObjectBox.INSTANCE.getTimeZoneHistoryBox();
        Intrinsics.checkNotNull(timeZoneHistoryBox);
        List<TimezoneHistoryEntity> find = timeZoneHistoryBox.query().equal(TimezoneHistoryEntity_.userId, UserInfoManager.Companion.getCurShowUserId(), QueryBuilder.StringOrder.CASE_SENSITIVE).orderDesc(TimezoneHistoryEntity_.timestamp).build().find();
        timezoneHistoryActivity.histories = find;
        timeZoneHistoryAdapter.setData(find);
    }
}
