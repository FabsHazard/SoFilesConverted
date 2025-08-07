package com.microtech.aidexx.ui.setting.profile;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.databinding.ActivitySettingsProfileBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.ui.setting.profile.EditNameActivity;
import com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity;
import com.microtech.aidexx.ui.setting.profile.health.OtherDiseaseActivity;
import com.microtech.aidexx.utils.ActivityUtil;
import com.microtech.aidexx.views.SettingItemWidget;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.selector.time.TimePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 $2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0015\u001a\u00020\u0003H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0017H\u0014J\b\u0010\u001d\u001a\u00020\u0017H\u0002J\b\u0010\u001e\u001a\u00020\u0017H\u0002J\u0012\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010\"\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\u0012\u0010#\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX.¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/ProfileSettingsActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivitySettingsProfileBinding;", "()V", "defHeightIndex", "", "defWeightIndex", "genderList", "", "", "listHeight", "listHeightData", "listWeight", "listWeightData", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "getViewBinding", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "toDiabetesInfoConfigAct", "toOtherDiabetesInfoConfigAct", "updateAge", "userEntity", "Lcom/microtech/aidexx/db/entity/UserEntity;", "updateBmi", "updateDiabetesInfo", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ProfileSettingsActivity.kt */
public final class ProfileSettingsActivity extends BaseActivity<BaseViewModel, ActivitySettingsProfileBinding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String TAG = "ProfileSettingsActivity";
    private int defHeightIndex;
    private int defWeightIndex;
    /* access modifiers changed from: private */
    public List<String> genderList;
    /* access modifiers changed from: private */
    public final List<Integer> listHeight;
    private final List<String> listHeightData;
    /* access modifiers changed from: private */
    public List<Integer> listWeight;
    private final List<String> listWeightData;
    private final Lazy pVm$delegate;

    public ProfileSettingsActivity() {
        List<Integer> list = CollectionsKt.toList(new IntRange(51, 200));
        this.listHeight = list;
        Iterable<Number> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Number intValue : iterable) {
            arrayList.add(ExtendsKt.getContext().getString(R.string.user_info_heightUnit, new Object[]{String.valueOf(intValue.intValue())}));
        }
        this.listHeightData = (List) arrayList;
        this.defHeightIndex = 119;
        List<Integer> list2 = CollectionsKt.toList(new IntRange(21, 160));
        this.listWeight = list2;
        Iterable<Number> iterable2 = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Number intValue2 : iterable2) {
            arrayList2.add(ExtendsKt.getContext().getString(R.string.user_info_weightUnit, new Object[]{String.valueOf(intValue2.intValue())}));
        }
        this.listWeightData = (List) arrayList2;
        this.defWeightIndex = 39;
        ComponentActivity componentActivity = this;
        this.pVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new ProfileSettingsActivity$special$$inlined$viewModels$default$2(componentActivity), new ProfileSettingsActivity$special$$inlined$viewModels$default$1(componentActivity), new ProfileSettingsActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/ProfileSettingsActivity$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ProfileSettingsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public ActivitySettingsProfileBinding getViewBinding() {
        ActivitySettingsProfileBinding inflate = ActivitySettingsProfileBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivitySettingsProfileBinding) getBinding()).getRoot());
        String string = getString(R.string.user_info_gender_male);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.user_info_gender_female);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.user_info_gender_other);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.genderList = CollectionsKt.listOf(string, string2, string3);
        initView();
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ProfileSettingsActivity$onCreate$1(this, (Continuation<? super ProfileSettingsActivity$onCreate$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        initData();
    }

    private final void initView() {
        ActivitySettingsProfileBinding activitySettingsProfileBinding = (ActivitySettingsProfileBinding) getBinding();
        ExtendsKt.setDebounceClickListener$default(activitySettingsProfileBinding.actionBar.getLeftIcon(), 0, new ProfileSettingsActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        SettingItemWidget settingItemWidget = activitySettingsProfileBinding.siwNickName;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "siwNickName");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda1(this), 1, (Object) null);
        SettingItemWidget settingItemWidget2 = activitySettingsProfileBinding.siwHeight;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget2, "siwHeight");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget2, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda2(this, activitySettingsProfileBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget3 = activitySettingsProfileBinding.siwWeight;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget3, "siwWeight");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget3, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda3(this, activitySettingsProfileBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget4 = activitySettingsProfileBinding.siwFullName;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget4, "siwFullName");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget4, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda4(this), 1, (Object) null);
        if (ExtendsKt.isGp()) {
            activitySettingsProfileBinding.siwPhone.setTitle(getString(R.string.user_email));
        } else {
            SettingItemWidget settingItemWidget5 = activitySettingsProfileBinding.siwPhone;
            Intrinsics.checkNotNullExpressionValue(settingItemWidget5, "siwPhone");
            ExtendsKt.setDebounceClickListener$default(settingItemWidget5, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda5(this), 1, (Object) null);
        }
        SettingItemWidget settingItemWidget6 = activitySettingsProfileBinding.siwGender;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget6, "siwGender");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget6, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda6(this, activitySettingsProfileBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget7 = activitySettingsProfileBinding.siwBirth;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget7, "siwBirth");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget7, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda7(this, activitySettingsProfileBinding), 1, (Object) null);
        SettingItemWidget settingItemWidget8 = activitySettingsProfileBinding.siwDiabetes;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget8, "siwDiabetes");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget8, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda8(this), 1, (Object) null);
        SettingItemWidget settingItemWidget9 = activitySettingsProfileBinding.siwOtherDisease;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget9, "siwOtherDisease");
        ExtendsKt.setDebounceClickListener$default(settingItemWidget9, 0, new ProfileSettingsActivity$$ExternalSyntheticLambda9(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$2(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        profileSettingsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$3(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        EditNameActivity.Companion companion = EditNameActivity.Companion;
        Context context = profileSettingsActivity;
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        companion.startEditNickName(context, userEntity != null ? userEntity.getName() : null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$5(ProfileSettingsActivity profileSettingsActivity, ActivitySettingsProfileBinding activitySettingsProfileBinding, View view) {
        int i;
        Integer height;
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingsProfileBinding, "$this_apply");
        List<Integer> list = profileSettingsActivity.listHeight;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            int intValue = listIterator.previous().intValue();
            UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
            if (userEntity != null && (height = userEntity.getHeight()) != null && intValue == height.intValue()) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i < 0) {
            i = profileSettingsActivity.defHeightIndex;
        }
        new Dialogs.Picker(profileSettingsActivity).singlePick(profileSettingsActivity.listHeightData, i, new ProfileSettingsActivity$initView$1$3$1(profileSettingsActivity, activitySettingsProfileBinding));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$7(ProfileSettingsActivity profileSettingsActivity, ActivitySettingsProfileBinding activitySettingsProfileBinding, View view) {
        int i;
        Integer bodyWeight;
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingsProfileBinding, "$this_apply");
        List<Integer> list = profileSettingsActivity.listWeight;
        ListIterator<Integer> listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                i = -1;
                break;
            }
            int intValue = listIterator.previous().intValue();
            UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
            if (userEntity != null && (bodyWeight = userEntity.getBodyWeight()) != null && intValue == bodyWeight.intValue()) {
                i = listIterator.nextIndex();
                break;
            }
        }
        if (i < 0) {
            i = profileSettingsActivity.defWeightIndex;
        }
        new Dialogs.Picker(profileSettingsActivity).singlePick(profileSettingsActivity.listWeightData, i, new ProfileSettingsActivity$initView$1$4$1(profileSettingsActivity, activitySettingsProfileBinding));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$8(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        EditNameActivity.Companion companion = EditNameActivity.Companion;
        Context context = profileSettingsActivity;
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        companion.startEditFullName(context, userEntity != null ? userEntity.getFullName() : null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$9(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        ActivityUtil.INSTANCE.toActivity(profileSettingsActivity, ChangeAccountActivity.class);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$11(ProfileSettingsActivity profileSettingsActivity, ActivitySettingsProfileBinding activitySettingsProfileBinding, View view) {
        Integer gender;
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingsProfileBinding, "$this_apply");
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        int i = 1;
        if (!(userEntity == null || (gender = userEntity.getGender()) == null)) {
            int intValue = gender.intValue() - 1;
            if (intValue < 0) {
                intValue = 2;
            }
            i = intValue;
        }
        Dialogs.Picker picker = new Dialogs.Picker(profileSettingsActivity);
        List<String> list = profileSettingsActivity.genderList;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("genderList");
            list = null;
        }
        picker.singlePick(list, i, new ProfileSettingsActivity$initView$1$7$1(profileSettingsActivity, activitySettingsProfileBinding));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$14(ProfileSettingsActivity profileSettingsActivity, ActivitySettingsProfileBinding activitySettingsProfileBinding, View view) {
        Date date;
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(activitySettingsProfileBinding, "$this_apply");
        Calendar instance = Calendar.getInstance();
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        if (userEntity != null) {
            String birthDate = userEntity.getBirthDate();
            if (birthDate == null || (date = ExtendsKt.dateAndYM$default(birthDate, (String) null, 1, (Object) null)) == null) {
                date = new Date();
            }
            instance.setTime(date);
        }
        TimePicker timePicker = new TimePicker(profileSettingsActivity);
        boolean[] yearMonthType = TimePicker.Companion.getYearMonthType();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(1, instance2.get(1) - 100);
        instance2.set(2, 1);
        Unit unit = Unit.INSTANCE;
        TimePicker.pick$default(timePicker, yearMonthType, (String) null, instance2, new ProfileSettingsActivity$initView$1$8$3(profileSettingsActivity, activitySettingsProfileBinding), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$15(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        profileSettingsActivity.toDiabetesInfoConfigAct();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$17$lambda$16(ProfileSettingsActivity profileSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(profileSettingsActivity, "this$0");
        profileSettingsActivity.toOtherDiabetesInfoConfigAct();
    }

    private final void toDiabetesInfoConfigAct() {
        ActivityUtil.INSTANCE.toActivity(this, DiabetesInfoConfigActivity.class);
    }

    private final void toOtherDiabetesInfoConfigAct() {
        ActivityUtil.INSTANCE.toActivity(this, OtherDiseaseActivity.class);
    }

    private final void initData() {
        Integer gender;
        Integer bodyWeight;
        Integer height;
        ActivitySettingsProfileBinding activitySettingsProfileBinding = (ActivitySettingsProfileBinding) getBinding();
        UserEntity userEntity = UserInfoManager.Companion.instance().getUserEntity();
        String str = null;
        activitySettingsProfileBinding.siwNickName.setValue(userEntity != null ? userEntity.getName() : null);
        activitySettingsProfileBinding.siwHeight.setValue((userEntity == null || (height = userEntity.getHeight()) == null) ? null : getString(R.string.user_info_heightUnit, new Object[]{String.valueOf(height.intValue())}));
        activitySettingsProfileBinding.siwWeight.setValue((userEntity == null || (bodyWeight = userEntity.getBodyWeight()) == null) ? null : getString(R.string.user_info_weightUnit, new Object[]{String.valueOf(bodyWeight.intValue())}));
        updateBmi(userEntity);
        activitySettingsProfileBinding.siwFullName.setValue(userEntity != null ? userEntity.getFullName() : null);
        if (ExtendsKt.isGp()) {
            activitySettingsProfileBinding.siwPhone.setValue(userEntity != null ? userEntity.getMaskedEmail() : null);
        } else {
            activitySettingsProfileBinding.siwPhone.setValue(userEntity != null ? userEntity.getMaskedPhone() : null);
        }
        if (!(userEntity == null || (gender = userEntity.getGender()) == null)) {
            int intValue = gender.intValue() - 1;
            if (intValue < 0) {
                intValue = 2;
            }
            SettingItemWidget settingItemWidget = activitySettingsProfileBinding.siwGender;
            List<String> list = this.genderList;
            if (list == null) {
                Intrinsics.throwUninitializedPropertyAccessException("genderList");
                list = null;
            }
            settingItemWidget.setValue(list.get(intValue));
        }
        SettingItemWidget settingItemWidget2 = activitySettingsProfileBinding.siwBirth;
        if (userEntity != null) {
            str = userEntity.getBirthDate();
        }
        settingItemWidget2.setValue(str);
        updateAge(userEntity);
        updateDiabetesInfo(userEntity);
    }

    /* access modifiers changed from: private */
    public final void updateDiabetesInfo(UserEntity userEntity) {
        ActivitySettingsProfileBinding activitySettingsProfileBinding = (ActivitySettingsProfileBinding) getBinding();
        if (userEntity != null) {
            LinearLayout linearLayout = activitySettingsProfileBinding.llDiabetesDetail;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llDiabetesDetail");
            View view = linearLayout;
            Integer diabetesTypeValue = userEntity.getDiabetesTypeValue();
            int i = 0;
            if (!((diabetesTypeValue != null ? diabetesTypeValue.intValue() : 0) != 0)) {
                i = 8;
            }
            view.setVisibility(i);
            Integer diabetesTypeValue2 = userEntity.getDiabetesTypeValue();
            String str = "";
            if (diabetesTypeValue2 != null) {
                int intValue = diabetesTypeValue2.intValue();
                activitySettingsProfileBinding.siwDiabetes.setValue(userEntity.getDiabetesTypeDisplayName());
                if (intValue != 0) {
                    TextView textView = activitySettingsProfileBinding.tvDiagnosis;
                    String calDiagnosisDate = getPVm().calDiagnosisDate(userEntity.getDiagnosisDate());
                    textView.setText(calDiagnosisDate != null ? calDiagnosisDate : str);
                    activitySettingsProfileBinding.tvTreatment.setText(userEntity.getTreatmentDisplayName());
                    activitySettingsProfileBinding.tvComplications.setText(userEntity.getComplicationsDisplayName());
                }
            }
            SettingItemWidget settingItemWidget = activitySettingsProfileBinding.siwOtherDisease;
            String formatOtherDiabetesStr = getPVm().formatOtherDiabetesStr(userEntity.getOtherDiseasesDisplayName());
            if (formatOtherDiabetesStr != null) {
                str = formatOtherDiabetesStr;
            }
            settingItemWidget.setValue(str);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000d, code lost:
        r3 = r3.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001b, code lost:
        r12 = (r12 = r12.getBodyWeight()).intValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateBmi(com.microtech.aidexx.db.entity.UserEntity r12) {
        /*
            r11 = this;
            java.lang.String r0 = "flBmi"
            r1 = 0
            r2 = 0
            if (r12 == 0) goto L_0x0070
            java.lang.Integer r3 = r12.getHeight()
            r4 = 1
            if (r3 == 0) goto L_0x0043
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 <= 0) goto L_0x0043
            java.lang.Integer r12 = r12.getBodyWeight()
            if (r12 == 0) goto L_0x0043
            java.lang.Number r12 = (java.lang.Number) r12
            int r12 = r12.intValue()
            if (r12 <= 0) goto L_0x0043
            double r5 = (double) r12
            double r7 = (double) r3
            r12 = 100
            double r9 = (double) r12
            double r7 = r7 / r9
            r12 = 2
            double r9 = (double) r12
            double r7 = java.lang.Math.pow(r7, r9)
            double r5 = r5 / r7
            java.math.BigDecimal r12 = new java.math.BigDecimal
            r12.<init>(r5)
            r3 = 4
            java.math.BigDecimal r12 = r12.setScale(r4, r3)
            double r5 = r12.doubleValue()
            java.lang.String r12 = java.lang.String.valueOf(r5)
            goto L_0x0044
        L_0x0043:
            r12 = r2
        L_0x0044:
            if (r12 == 0) goto L_0x0070
            androidx.viewbinding.ViewBinding r2 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            com.microtech.aidexx.views.SettingItemWidget r2 = r2.siwWeight
            r2.setDividerState(r4)
            androidx.viewbinding.ViewBinding r2 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            com.google.android.flexbox.FlexboxLayout r2 = r2.flBmi
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r2.setVisibility(r1)
            androidx.viewbinding.ViewBinding r2 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            android.widget.TextView r2 = r2.tvBmi
            java.lang.CharSequence r12 = (java.lang.CharSequence) r12
            r2.setText(r12)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0070:
            if (r2 != 0) goto L_0x0092
            r12 = r11
            com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity r12 = (com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity) r12
            androidx.viewbinding.ViewBinding r12 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r12 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r12
            com.microtech.aidexx.views.SettingItemWidget r12 = r12.siwWeight
            r12.setDividerState(r1)
            androidx.viewbinding.ViewBinding r12 = r11.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r12 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r12
            com.google.android.flexbox.FlexboxLayout r12 = r12.flBmi
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            r0 = 8
            r12.setVisibility(r0)
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity.updateBmi(com.microtech.aidexx.db.entity.UserEntity):void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateAge(com.microtech.aidexx.db.entity.UserEntity r10) {
        /*
            r9 = this;
            java.lang.String r0 = "flAge"
            r1 = 0
            r2 = 0
            if (r10 == 0) goto L_0x009d
            java.lang.String r10 = r10.getBirthDate()
            r3 = 1
            if (r10 == 0) goto L_0x0070
            int r4 = com.microtech.aidexx.R.string.com_dateFormat_yyyyMM
            java.lang.String r4 = r9.getString(r4)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            java.util.Date r10 = com.microtech.aidexx.common.ExtendsKt.dateAndYM((java.lang.String) r10, (java.lang.String) r4)
            if (r10 == 0) goto L_0x0070
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            r4.setTime(r10)
            java.util.Calendar r10 = java.util.Calendar.getInstance()
            boolean r5 = r4.after(r10)
            if (r5 == 0) goto L_0x0036
            java.util.Date r5 = r10.getTime()
            r4.setTime(r5)
        L_0x0036:
            int r5 = r10.get(r3)
            int r6 = r4.get(r3)
            int r5 = r5 - r6
            r6 = 2
            int r7 = r10.get(r6)
            int r8 = r4.get(r6)
            if (r7 < r8) goto L_0x005f
            int r7 = r10.get(r6)
            int r6 = r4.get(r6)
            if (r7 != r6) goto L_0x0061
            r6 = 5
            int r10 = r10.get(r6)
            int r4 = r4.get(r6)
            if (r10 >= r4) goto L_0x0061
        L_0x005f:
            int r5 = r5 + -1
        L_0x0061:
            int r10 = com.microtech.aidexx.R.string.com_time_age_year
            java.lang.String r4 = java.lang.String.valueOf(r5)
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.String r10 = r9.getString(r10, r4)
            goto L_0x0071
        L_0x0070:
            r10 = r2
        L_0x0071:
            if (r10 == 0) goto L_0x009d
            androidx.viewbinding.ViewBinding r2 = r9.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            com.microtech.aidexx.views.SettingItemWidget r2 = r2.siwBirth
            r2.setDividerState(r3)
            androidx.viewbinding.ViewBinding r2 = r9.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            com.google.android.flexbox.FlexboxLayout r2 = r2.flAge
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r0)
            android.view.View r2 = (android.view.View) r2
            r2.setVisibility(r1)
            androidx.viewbinding.ViewBinding r2 = r9.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r2 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r2
            android.widget.TextView r2 = r2.tvAge
            java.lang.CharSequence r10 = (java.lang.CharSequence) r10
            r2.setText(r10)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x009d:
            if (r2 != 0) goto L_0x00bf
            r10 = r9
            com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity r10 = (com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity) r10
            androidx.viewbinding.ViewBinding r10 = r9.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r10 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r10
            com.microtech.aidexx.views.SettingItemWidget r10 = r10.siwBirth
            r10.setDividerState(r1)
            androidx.viewbinding.ViewBinding r10 = r9.getBinding()
            com.microtech.aidexx.databinding.ActivitySettingsProfileBinding r10 = (com.microtech.aidexx.databinding.ActivitySettingsProfileBinding) r10
            com.google.android.flexbox.FlexboxLayout r10 = r10.flAge
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r0)
            android.view.View r10 = (android.view.View) r10
            r0 = 8
            r10.setVisibility(r0)
        L_0x00bf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.ProfileSettingsActivity.updateAge(com.microtech.aidexx.db.entity.UserEntity):void");
    }
}
