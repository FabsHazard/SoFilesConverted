package com.microtech.aidexx.ui.setting.profile.health;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.flyco.roundview.RoundLinearLayout;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.databinding.ActivityDiabetesInfoConfigBinding;
import com.microtech.aidexx.ui.setting.profile.DiabetesEnum;
import com.microtech.aidexx.ui.setting.profile.ProfileViewModel;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.selector.time.TimePicker;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\u0012\u0010\u001a\u001a\u00020\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0018H\u0002J\u0017\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ui/setting/profile/health/DiabetesInfoConfigActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityDiabetesInfoConfigBinding;", "()V", "complications", "", "complicationsDisplayName", "diabetesTypeByDId", "diabetesTypeDisplayName", "diabetesTypeValue", "", "Ljava/lang/Integer;", "diagnosisDate", "pVm", "Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "getPVm", "()Lcom/microtech/aidexx/ui/setting/profile/ProfileViewModel;", "pVm$delegate", "Lkotlin/Lazy;", "treatment", "treatmentDisplayName", "getViewBinding", "initData", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setDiagnosisDate", "setInfoUiVisible", "type", "(Ljava/lang/Integer;)V", "setProfileUi", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DiabetesInfoConfigActivity.kt */
public final class DiabetesInfoConfigActivity extends BaseActivity<BaseViewModel, ActivityDiabetesInfoConfigBinding> {
    /* access modifiers changed from: private */
    public String complications;
    /* access modifiers changed from: private */
    public String complicationsDisplayName;
    /* access modifiers changed from: private */
    public String diabetesTypeByDId;
    /* access modifiers changed from: private */
    public String diabetesTypeDisplayName;
    /* access modifiers changed from: private */
    public Integer diabetesTypeValue;
    /* access modifiers changed from: private */
    public String diagnosisDate;
    private final Lazy pVm$delegate;
    /* access modifiers changed from: private */
    public String treatment;
    /* access modifiers changed from: private */
    public String treatmentDisplayName;

    public DiabetesInfoConfigActivity() {
        ComponentActivity componentActivity = this;
        this.pVm$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ProfileViewModel.class), new DiabetesInfoConfigActivity$special$$inlined$viewModels$default$2(componentActivity), new DiabetesInfoConfigActivity$special$$inlined$viewModels$default$1(componentActivity), new DiabetesInfoConfigActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ProfileViewModel getPVm() {
        return (ProfileViewModel) this.pVm$delegate.getValue();
    }

    public ActivityDiabetesInfoConfigBinding getViewBinding() {
        ActivityDiabetesInfoConfigBinding inflate = ActivityDiabetesInfoConfigBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityDiabetesInfoConfigBinding) getBinding()).getRoot());
        initData();
        initView();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r2 = r0.getDiabetesType();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initData() {
        /*
            r8 = this;
            com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
            com.microtech.aidexx.db.entity.UserEntity r0 = r0.getUserEntity()
            r1 = 0
            if (r0 == 0) goto L_0x0018
            java.lang.Integer r2 = r0.getDiabetesType()
            if (r2 == 0) goto L_0x0018
            java.lang.String r2 = r2.toString()
            goto L_0x0019
        L_0x0018:
            r2 = r1
        L_0x0019:
            r8.diabetesTypeByDId = r2
            if (r0 == 0) goto L_0x0022
            java.lang.Integer r2 = r0.getDiabetesTypeValue()
            goto L_0x0023
        L_0x0022:
            r2 = r1
        L_0x0023:
            r8.diabetesTypeValue = r2
            if (r0 == 0) goto L_0x002c
            java.lang.String r2 = r0.getDiabetesTypeDisplayName()
            goto L_0x002d
        L_0x002c:
            r2 = r1
        L_0x002d:
            r8.diabetesTypeDisplayName = r2
            if (r0 == 0) goto L_0x0036
            java.lang.String r2 = r0.getDiagnosisDate()
            goto L_0x0037
        L_0x0036:
            r2 = r1
        L_0x0037:
            r8.diagnosisDate = r2
            if (r0 == 0) goto L_0x0040
            java.lang.String r2 = r0.getComplications()
            goto L_0x0041
        L_0x0040:
            r2 = r1
        L_0x0041:
            r8.complications = r2
            if (r0 == 0) goto L_0x004a
            java.lang.String r2 = r0.getComplicationsDisplayName()
            goto L_0x004b
        L_0x004a:
            r2 = r1
        L_0x004b:
            r8.complicationsDisplayName = r2
            if (r0 == 0) goto L_0x0054
            java.lang.String r2 = r0.getTreatment()
            goto L_0x0055
        L_0x0054:
            r2 = r1
        L_0x0055:
            r8.treatment = r2
            if (r0 == 0) goto L_0x005e
            java.lang.String r0 = r0.getTreatmentDisplayName()
            goto L_0x005f
        L_0x005e:
            r0 = r1
        L_0x005f:
            r8.treatmentDisplayName = r0
            r0 = r8
            androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0
            androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)
            r2 = r0
            kotlinx.coroutines.CoroutineScope r2 = (kotlinx.coroutines.CoroutineScope) r2
            com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1 r0 = new com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity$initData$1
            r0.<init>(r8, r1)
            r5 = r0
            kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
            r6 = 3
            r7 = 0
            r3 = 0
            r4 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.setting.profile.health.DiabetesInfoConfigActivity.initData():void");
    }

    private final void initView() {
        ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding = (ActivityDiabetesInfoConfigBinding) getBinding();
        TextView textView = activityDiabetesInfoConfigBinding.tvSave;
        Intrinsics.checkNotNullExpressionValue(textView, "tvSave");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda0(this), 1, (Object) null);
        RoundLinearLayout roundLinearLayout = activityDiabetesInfoConfigBinding.llType;
        Intrinsics.checkNotNullExpressionValue(roundLinearLayout, "llType");
        ExtendsKt.setDebounceClickListener$default(roundLinearLayout, 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda1(this, activityDiabetesInfoConfigBinding), 1, (Object) null);
        RoundLinearLayout roundLinearLayout2 = activityDiabetesInfoConfigBinding.llDiagnosisDate;
        Intrinsics.checkNotNullExpressionValue(roundLinearLayout2, "llDiagnosisDate");
        ExtendsKt.setDebounceClickListener$default(roundLinearLayout2, 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda2(this), 1, (Object) null);
        RoundLinearLayout roundLinearLayout3 = ((ActivityDiabetesInfoConfigBinding) getBinding()).llTreat;
        Intrinsics.checkNotNullExpressionValue(roundLinearLayout3, "llTreat");
        ExtendsKt.setDebounceClickListener$default(roundLinearLayout3, 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda3(this, activityDiabetesInfoConfigBinding), 1, (Object) null);
        RoundLinearLayout roundLinearLayout4 = ((ActivityDiabetesInfoConfigBinding) getBinding()).llComplications;
        Intrinsics.checkNotNullExpressionValue(roundLinearLayout4, "llComplications");
        ExtendsKt.setDebounceClickListener$default(roundLinearLayout4, 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda4(this, activityDiabetesInfoConfigBinding), 1, (Object) null);
        ExtendsKt.setDebounceClickListener$default(activityDiabetesInfoConfigBinding.actionBar.getLeftIcon(), 0, new DiabetesInfoConfigActivity$$ExternalSyntheticLambda5(this), 1, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$0(DiabetesInfoConfigActivity diabetesInfoConfigActivity, View view) {
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(diabetesInfoConfigActivity), (CoroutineContext) null, (CoroutineStart) null, new DiabetesInfoConfigActivity$initView$1$1$1(diabetesInfoConfigActivity, (Continuation<? super DiabetesInfoConfigActivity$initView$1$1$1>) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$4(DiabetesInfoConfigActivity diabetesInfoConfigActivity, ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding, View view) {
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityDiabetesInfoConfigBinding, "$this_apply");
        String string = diabetesInfoConfigActivity.getString(R.string.user_info_diabetesType);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MenuListDialog menuListDialog = new MenuListDialog(diabetesInfoConfigActivity, string, false, new DiabetesInfoConfigActivity$initView$1$2$1(activityDiabetesInfoConfigBinding, diabetesInfoConfigActivity));
        menuListDialog.show();
        DiabetesEnum diabetesEnum = DiabetesEnum.Companion.getDiabetesEnum();
        if (diabetesEnum != null) {
            List<MenuEntity> arrayList = new ArrayList<>();
            arrayList.addAll(diabetesEnum.getDiabetesType());
            for (MenuEntity menuEntity : arrayList) {
                menuEntity.setCheck(Intrinsics.areEqual((Object) menuEntity.getDictionaryId(), (Object) diabetesInfoConfigActivity.diabetesTypeByDId));
            }
            menuListDialog.setData(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$6(DiabetesInfoConfigActivity diabetesInfoConfigActivity, View view) {
        Date date;
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        Calendar instance = Calendar.getInstance();
        String str = diabetesInfoConfigActivity.diagnosisDate;
        if (str == null || (date = ExtendsKt.dateAndYM$default(str, (String) null, 1, (Object) null)) == null) {
            date = new Date();
        }
        instance.setTime(date);
        TimePicker timePicker = new TimePicker(diabetesInfoConfigActivity);
        boolean[] yearMonthType = TimePicker.Companion.getYearMonthType();
        Calendar instance2 = Calendar.getInstance();
        instance2.set(1, instance2.get(1) - 100);
        instance2.set(2, 1);
        Unit unit = Unit.INSTANCE;
        TimePicker.pick$default(timePicker, yearMonthType, (String) null, instance2, new DiabetesInfoConfigActivity$initView$1$3$2(diabetesInfoConfigActivity), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$11(DiabetesInfoConfigActivity diabetesInfoConfigActivity, ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding, View view) {
        List<String> list;
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityDiabetesInfoConfigBinding, "$this_apply");
        String string = diabetesInfoConfigActivity.getString(R.string.user_info_treatment);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MenuListDialog menuListDialog = new MenuListDialog(diabetesInfoConfigActivity, string, true, new DiabetesInfoConfigActivity$initView$1$4$1(diabetesInfoConfigActivity, activityDiabetesInfoConfigBinding));
        menuListDialog.show();
        DiabetesEnum diabetesEnum = DiabetesEnum.Companion.getDiabetesEnum();
        if (diabetesEnum != null) {
            List arrayList = new ArrayList();
            arrayList.addAll(diabetesEnum.getTreatmentsType());
            String str = diabetesInfoConfigActivity.treatment;
            if (str != null) {
                list = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            Iterable<MenuEntity> iterable = arrayList;
            for (MenuEntity menuEntity : iterable) {
                menuEntity.setCheck(false);
                if (list != null) {
                    for (String areEqual : list) {
                        if (Intrinsics.areEqual((Object) String.valueOf(menuEntity.getDictionaryId()), (Object) areEqual)) {
                            menuEntity.setCheck(true);
                        }
                    }
                }
            }
            LogUtil.Companion.d$default(LogUtil.Companion, "设置索引 " + CollectionsKt.joinToString$default(iterable, ";", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), (String) null, 2, (Object) null);
            menuListDialog.setData(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$16(DiabetesInfoConfigActivity diabetesInfoConfigActivity, ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding, View view) {
        List<String> list;
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        Intrinsics.checkNotNullParameter(activityDiabetesInfoConfigBinding, "$this_apply");
        String string = diabetesInfoConfigActivity.getString(R.string.user_info_complications);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        MenuListDialog menuListDialog = new MenuListDialog(diabetesInfoConfigActivity, string, true, new DiabetesInfoConfigActivity$initView$1$5$1(diabetesInfoConfigActivity, activityDiabetesInfoConfigBinding));
        menuListDialog.show();
        DiabetesEnum diabetesEnum = DiabetesEnum.Companion.getDiabetesEnum();
        if (diabetesEnum != null) {
            List<MenuEntity> arrayList = new ArrayList<>();
            arrayList.addAll(diabetesEnum.getCompsType());
            String str = diabetesInfoConfigActivity.complications;
            if (str != null) {
                list = StringsKt.split$default((CharSequence) str, new String[]{","}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            for (MenuEntity menuEntity : arrayList) {
                menuEntity.setCheck(false);
                if (list != null) {
                    for (String areEqual : list) {
                        if (Intrinsics.areEqual((Object) String.valueOf(menuEntity.getDictionaryId()), (Object) areEqual)) {
                            menuEntity.setCheck(true);
                        }
                    }
                }
            }
            menuListDialog.setData(arrayList);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$18$lambda$17(DiabetesInfoConfigActivity diabetesInfoConfigActivity, View view) {
        Intrinsics.checkNotNullParameter(diabetesInfoConfigActivity, "this$0");
        diabetesInfoConfigActivity.finish();
    }

    /* access modifiers changed from: private */
    public final void setInfoUiVisible(Integer num) {
        ActivityDiabetesInfoConfigBinding activityDiabetesInfoConfigBinding = (ActivityDiabetesInfoConfigBinding) getBinding();
        if (num == null || num.intValue() == 0 || -1 == num.intValue()) {
            activityDiabetesInfoConfigBinding.llComplications.setVisibility(8);
            activityDiabetesInfoConfigBinding.llTreat.setVisibility(8);
            activityDiabetesInfoConfigBinding.llDiagnosisDate.setVisibility(8);
            return;
        }
        activityDiabetesInfoConfigBinding.llComplications.setVisibility(0);
        activityDiabetesInfoConfigBinding.llTreat.setVisibility(0);
        activityDiabetesInfoConfigBinding.llDiagnosisDate.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void setProfileUi() {
        CharSequence charSequence;
        CharSequence charSequence2;
        Object obj;
        DiabetesEnum diabetesEnum = DiabetesEnum.Companion.getDiabetesEnum();
        String str = this.diabetesTypeByDId;
        Integer num = null;
        if (!(str == null || diabetesEnum == null)) {
            Iterator it = diabetesEnum.getDiabetesType().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((MenuEntity) obj).getDictionaryId(), (Object) str)) {
                    break;
                }
            }
            MenuEntity menuEntity = (MenuEntity) obj;
            if (menuEntity != null) {
                num = menuEntity.getValue();
            }
        }
        if (num == null) {
            num = this.diabetesTypeValue;
        }
        setInfoUiVisible(num);
        setDiagnosisDate();
        TextView textView = ((ActivityDiabetesInfoConfigBinding) getBinding()).tvDiagnosisType;
        String str2 = this.diabetesTypeDisplayName;
        if (str2 == null) {
            str2 = getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_diabetesType)});
        }
        textView.setText(str2);
        if (diabetesEnum != null) {
            for (MenuEntity menuEntity2 : diabetesEnum.getDiabetesType()) {
                if (Intrinsics.areEqual((Object) menuEntity2.getDictionaryId(), (Object) this.diabetesTypeByDId)) {
                    ((ActivityDiabetesInfoConfigBinding) getBinding()).tvDiagnosisType.setText(menuEntity2.getDisplayName());
                }
            }
            TextView textView2 = ((ActivityDiabetesInfoConfigBinding) getBinding()).tvTreatment;
            CharSequence charSequence3 = this.treatmentDisplayName;
            if (charSequence3 == null || charSequence3.length() == 0) {
                charSequence = getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_treatment)});
            } else {
                charSequence = this.treatmentDisplayName;
            }
            textView2.setText(charSequence);
            TextView textView3 = ((ActivityDiabetesInfoConfigBinding) getBinding()).tvComplications;
            CharSequence charSequence4 = this.complicationsDisplayName;
            if (charSequence4 == null || charSequence4.length() == 0) {
                charSequence2 = getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_complications)});
            } else {
                charSequence2 = this.complicationsDisplayName;
            }
            textView3.setText(charSequence2);
        }
    }

    /* access modifiers changed from: private */
    public final void setDiagnosisDate() {
        CharSequence charSequence;
        TextView textView = ((ActivityDiabetesInfoConfigBinding) getBinding()).tvDiagnosisDate;
        String calDiagnosisDate = getPVm().calDiagnosisDate(this.diagnosisDate);
        if (calDiagnosisDate != null) {
            charSequence = calDiagnosisDate;
        } else {
            charSequence = getString(R.string.com_inputHint, new Object[]{getString(R.string.user_info_diagnosisDate)});
        }
        textView.setText(charSequence);
    }
}
