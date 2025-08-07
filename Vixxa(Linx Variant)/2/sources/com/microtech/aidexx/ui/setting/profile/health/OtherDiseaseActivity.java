package com.microtech.aidexx.ui.setting.profile.health;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.databinding.ActivityOtherDiseaseBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.setting.profile.ProfileViewModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0013\u001a\u00020\u0003H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0015H\u0002J\b\u0010\u0017\u001a\u00020\u0015H\u0002J\u0012\u0010\u0018\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/health/OtherDiseaseActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityOtherDiseaseBinding;", "()V", "checkedData", "", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "otherDiseaseAdapter", "Lcom/microtech/aidexx/ui/setting/profile/health/MenuListAdapter;", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "uncheckedData", "userEntity", "Lcom/microtech/aidexx/db/entity/UserEntity;", "getViewBinding", "initData", "", "initEvent", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: OtherDiseaseActivity.kt */
public final class OtherDiseaseActivity extends BaseActivity<BaseViewModel, ActivityOtherDiseaseBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int USER_DIRECTORY_ID_LEN = 32;
    /* access modifiers changed from: private */
    public List<MenuEntity> checkedData = new ArrayList();
    /* access modifiers changed from: private */
    public final MenuListAdapter<MenuEntity> otherDiseaseAdapter;
    private final Lazy pVm$delegate;
    /* access modifiers changed from: private */
    public final List<MenuEntity> uncheckedData;
    /* access modifiers changed from: private */
    public UserEntity userEntity;

    public OtherDiseaseActivity() {
        ComponentActivity componentActivity = this;
        this.pVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new OtherDiseaseActivity$special$$inlined$viewModels$default$2(componentActivity), new OtherDiseaseActivity$special$$inlined$viewModels$default$1(componentActivity), new OtherDiseaseActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
        List<MenuEntity> arrayList = new ArrayList<>();
        this.uncheckedData = arrayList;
        this.otherDiseaseAdapter = new MenuListAdapter<>(arrayList);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/health/OtherDiseaseActivity$Companion;", "", "()V", "USER_DIRECTORY_ID_LEN", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: OtherDiseaseActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    public ActivityOtherDiseaseBinding getViewBinding() {
        ActivityOtherDiseaseBinding inflate = ActivityOtherDiseaseBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityOtherDiseaseBinding) getBinding()).getRoot());
        initEvent();
        initData();
    }

    private final void initEvent() {
        ActivityOtherDiseaseBinding activityOtherDiseaseBinding = (ActivityOtherDiseaseBinding) getBinding();
        activityOtherDiseaseBinding.tvSave.setOnClickListener(new OtherDiseaseActivity$$ExternalSyntheticLambda0(this));
        EditText editText = activityOtherDiseaseBinding.etDiseaseName;
        Intrinsics.checkNotNullExpressionValue(editText, "etDiseaseName");
        editText.addTextChangedListener(new OtherDiseaseActivity$initEvent$lambda$5$$inlined$addTextChangedListener$default$1(this));
        activityOtherDiseaseBinding.actionBar.getLeftIcon().setOnClickListener(new OtherDiseaseActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$5$lambda$1(OtherDiseaseActivity otherDiseaseActivity, View view) {
        Intrinsics.checkNotNullParameter(otherDiseaseActivity, "this$0");
        Collection arrayList = new ArrayList();
        for (Object next : otherDiseaseActivity.otherDiseaseAdapter.getData()) {
            MenuEntity menuEntity = (MenuEntity) next;
            if (menuEntity.getCheck() && menuEntity.getDictionaryId() == null) {
                arrayList.add(next);
            }
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(otherDiseaseActivity), (CoroutineContext) null, (CoroutineStart) null, new OtherDiseaseActivity$initEvent$1$1$1(otherDiseaseActivity, (List) arrayList, (Continuation<? super OtherDiseaseActivity$initEvent$1$1$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$5$lambda$4(OtherDiseaseActivity otherDiseaseActivity, View view) {
        Intrinsics.checkNotNullParameter(otherDiseaseActivity, "this$0");
        otherDiseaseActivity.finish();
    }

    private final void initData() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new OtherDiseaseActivity$initData$1(this, (Continuation<? super OtherDiseaseActivity$initData$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void initView() {
        ((ActivityOtherDiseaseBinding) getBinding()).rvDisease.setLayoutManager(new LinearLayoutManager(this));
        ((ActivityOtherDiseaseBinding) getBinding()).rvDisease.setAdapter(this.otherDiseaseAdapter);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new OtherDiseaseActivity$initView$1(this, (Continuation<? super OtherDiseaseActivity$initView$1>) null), 3, (Object) null);
        this.otherDiseaseAdapter.setOnCheckChange(new OtherDiseaseActivity$initView$2(this));
    }
}
