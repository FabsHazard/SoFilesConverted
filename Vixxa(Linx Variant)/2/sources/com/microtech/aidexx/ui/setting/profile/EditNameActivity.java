package com.microtech.aidexx.ui.setting.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.databinding.ActivityEditNameBinding;
import com.microtech.aidexx.utils.ActivityUtil;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0014R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/EditNameActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityEditNameBinding;", "()V", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "getViewBinding", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EditNameActivity.kt */
public final class EditNameActivity extends BaseActivity<BaseViewModel, ActivityEditNameBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String EXTRA_NAME = "EXTRA_NAME";
    /* access modifiers changed from: private */
    public static final String TAG = "EditNameActivity";
    private static final int TYPE_FULL_NAME = 1;
    private static final int TYPE_NICK_NAME = 0;
    private final Lazy pVm$delegate;

    public EditNameActivity() {
        ComponentActivity componentActivity = this;
        this.pVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new EditNameActivity$special$$inlined$viewModels$default$2(componentActivity), new EditNameActivity$special$$inlined$viewModels$default$1(componentActivity), new EditNameActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/EditNameActivity$Companion;", "", "()V", "EXTRA_NAME", "", "TAG", "kotlin.jvm.PlatformType", "TYPE_FULL_NAME", "", "TYPE_NICK_NAME", "startEditFullName", "", "context", "Landroid/content/Context;", "name", "startEditNickName", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: EditNameActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void startEditNickName(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            ActivityUtil activityUtil = ActivityUtil.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putInt(EditNameActivity.TAG, 0);
            bundle.putString(EditNameActivity.EXTRA_NAME, str);
            Unit unit = Unit.INSTANCE;
            activityUtil.toActivity(context, bundle, (Class<?>) EditNameActivity.class);
        }

        public final void startEditFullName(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            ActivityUtil activityUtil = ActivityUtil.INSTANCE;
            Bundle bundle = new Bundle();
            bundle.putInt(EditNameActivity.TAG, 1);
            bundle.putString(EditNameActivity.EXTRA_NAME, str);
            Unit unit = Unit.INSTANCE;
            activityUtil.toActivity(context, bundle, (Class<?>) EditNameActivity.class);
        }
    }

    public ActivityEditNameBinding getViewBinding() {
        ActivityEditNameBinding inflate = ActivityEditNameBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityEditNameBinding) getBinding()).getRoot());
        initView();
    }

    private final void initView() {
        ActivityEditNameBinding activityEditNameBinding = (ActivityEditNameBinding) getBinding();
        int intExtra = getIntent().getIntExtra(TAG, 0);
        if (intExtra == 0) {
            activityEditNameBinding.actionBar.setTitle(getString(R.string.user_info_nickname));
            activityEditNameBinding.tvNotice.setText(getString(R.string.com_inputTitle, new Object[]{getString(R.string.user_info_nickname)}));
            activityEditNameBinding.etInput.setHint(getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_nickname)}));
        } else {
            activityEditNameBinding.actionBar.setTitle(getString(R.string.user_info_name));
            activityEditNameBinding.tvNotice.setText(getString(R.string.com_inputTitle, new Object[]{getString(R.string.user_info_name)}));
            activityEditNameBinding.etInput.setHint(getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_name)}));
        }
        activityEditNameBinding.etInput.setText(getIntent().getStringExtra(EXTRA_NAME));
        ExtendsKt.setDebounceClickListener$default(activityEditNameBinding.actionBar.getLeftIcon(), 0, new EditNameActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        TextView textView = activityEditNameBinding.tvSave;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSave");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new EditNameActivity$$ExternalSyntheticLambda1(activityEditNameBinding, this, intExtra), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$0(EditNameActivity editNameActivity, View view) {
        Intrinsics.checkNotNullParameter(editNameActivity, "this$0");
        editNameActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2$lambda$1(ActivityEditNameBinding activityEditNameBinding, EditNameActivity editNameActivity, int i, View view) {
        Intrinsics.checkNotNullParameter(activityEditNameBinding, "$this_apply");
        Intrinsics.checkNotNullParameter(editNameActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(editNameActivity), (CoroutineContext) null, (CoroutineStart) null, new EditNameActivity$initView$1$2$1(editNameActivity, i, activityEditNameBinding.etInput.getText().toString(), (Continuation<? super EditNameActivity$initView$1$2$1>) null), 3, (Object) null);
    }
}
