package com.microtech.aidexx.ui.setting.alert;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivitySettingsAlertBinding;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.ui.setting.SettingsManager;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.utils.eventbus.EventBusKey;
import com.microtech.aidexx.utils.eventbus.EventBusManager;
import com.microtech.aidexx.views.SettingItemWidget;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.dialog.bottom.ThresholdSelectView;
import com.microtech.aidexx.views.ruler.RulerWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0014J\b\u0010\u001d\u001a\u00020\u0016H\u0014J6\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\"\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\tH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX.¢\u0006\u0004\n\u0002\u0010\fR\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX.¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/microtech/aidexx/ui/setting/alert/AlertSettingsActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivitySettingsAlertBinding;", "()V", "alertFrequency", "", "alertMethod", "isHypChanged", "", "listOfFrequency", "", "[Ljava/lang/Integer;", "listOfFrequencyString", "", "", "listOfMethod", "needInit", "urgentAlertFrequency", "urgentAlertMethod", "getViewBinding", "initData", "", "initEvent", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "setMethodOrFrequency", "settingItem", "Lcom/microtech/aidexx/views/SettingItemWidget;", "list", "selectPos", "type", "isUrgent", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertSettingsActivity.kt */
public final class AlertSettingsActivity extends BaseActivity<BaseViewModel, ActivitySettingsAlertBinding> {
    /* access modifiers changed from: private */
    public int alertFrequency = 30;
    /* access modifiers changed from: private */
    public int alertMethod = 3;
    /* access modifiers changed from: private */
    public boolean isHypChanged;
    /* access modifiers changed from: private */
    public Integer[] listOfFrequency;
    private List<String> listOfFrequencyString;
    /* access modifiers changed from: private */
    public List<String> listOfMethod;
    private boolean needInit = true;
    /* access modifiers changed from: private */
    public int urgentAlertFrequency = 5;
    /* access modifiers changed from: private */
    public int urgentAlertMethod = 3;

    public ActivitySettingsAlertBinding getViewBinding() {
        ActivitySettingsAlertBinding inflate = ActivitySettingsAlertBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    private final void setMethodOrFrequency(SettingItemWidget settingItemWidget, List<String> list, int i, int i2, boolean z) {
        new Dialogs.Picker(this).singlePick(list, i, new AlertSettingsActivity$setMethodOrFrequency$1(i2, settingItemWidget, list, z, this));
    }

    private final void initData() {
        String string = getString(R.string.user_warning_mode_sound);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getString(R.string.user_warning_mode_vibrate);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = getString(R.string.user_warning_mode_soundAndVibrate);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        this.listOfMethod = CollectionsKt.listOf(string, string2, string3);
        String string4 = getString(R.string.user_warning_frequence_minutes5);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        String string5 = getString(R.string.user_warning_frequence_minutes15);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        String string6 = getString(R.string.user_warning_frequence_minutes30);
        Intrinsics.checkNotNullExpressionValue(string6, "getString(...)");
        String string7 = getString(R.string.user_warning_frequence_minutes45);
        Intrinsics.checkNotNullExpressionValue(string7, "getString(...)");
        String string8 = getString(R.string.user_warning_frequence_minutes60);
        Intrinsics.checkNotNullExpressionValue(string8, "getString(...)");
        this.listOfFrequencyString = CollectionsKt.listOf(string4, string5, string6, string7, string8);
        this.listOfFrequency = new Integer[]{5, 15, 30, 45, 60};
    }

    public final void initView() {
        int i;
        int i2;
        int i3;
        int i4;
        ((ActivitySettingsAlertBinding) getBinding()).actionBar.getLeftIcon().setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda0(this));
        SettingsEntity settingEntity = SettingsManager.INSTANCE.getSettingEntity();
        Intrinsics.checkNotNull(settingEntity);
        this.alertMethod = settingEntity.getAlertType() - 1;
        SettingItemWidget settingItemWidget = ((ActivitySettingsAlertBinding) getBinding()).noticeMethod;
        List<String> list = this.listOfMethod;
        Integer[] numArr = null;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list = null;
        }
        settingItemWidget.setValue(list.get(this.alertMethod));
        ((ActivitySettingsAlertBinding) getBinding()).noticeMethod.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda11(this));
        this.alertFrequency = settingEntity.getAlertRate();
        SettingItemWidget settingItemWidget2 = ((ActivitySettingsAlertBinding) getBinding()).noticeFrequency;
        int i5 = R.string.user_warning_frequence_tip;
        List<String> list2 = this.listOfFrequencyString;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list2 = null;
        }
        Integer[] numArr2 = this.listOfFrequency;
        if (numArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr2 = null;
        }
        int i6 = 0;
        if (ArraysKt.indexOf((T[]) numArr2, Integer.valueOf(this.alertFrequency)) == -1) {
            i = 0;
        } else {
            Integer[] numArr3 = this.listOfFrequency;
            if (numArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
                numArr3 = null;
            }
            i = ArraysKt.indexOf((T[]) numArr3, Integer.valueOf(this.alertFrequency));
        }
        settingItemWidget2.setValue(getString(i5, new Object[]{list2.get(i)}));
        ((ActivitySettingsAlertBinding) getBinding()).noticeFrequency.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda12(this));
        this.urgentAlertMethod = settingEntity.getUrgentAlertType() - 1;
        SettingItemWidget settingItemWidget3 = ((ActivitySettingsAlertBinding) getBinding()).noticeMethodUrgent;
        List<String> list3 = this.listOfMethod;
        if (list3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list3 = null;
        }
        int i7 = this.urgentAlertMethod;
        List<String> list4 = this.listOfMethod;
        if (list4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list4 = null;
        }
        if (i7 > list4.size() - 1) {
            List<String> list5 = this.listOfMethod;
            if (list5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
                list5 = null;
            }
            i2 = list5.size() - 1;
        } else {
            i2 = this.urgentAlertMethod;
        }
        settingItemWidget3.setValue(list3.get(i2));
        ((ActivitySettingsAlertBinding) getBinding()).noticeMethodUrgent.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda13(this));
        this.urgentAlertFrequency = settingEntity.getUrgentAlertRate();
        SettingItemWidget settingItemWidget4 = ((ActivitySettingsAlertBinding) getBinding()).noticeFrequencyUrgent;
        int i8 = R.string.user_warning_frequence_tip;
        List<String> list6 = this.listOfFrequencyString;
        if (list6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list6 = null;
        }
        Integer[] numArr4 = this.listOfFrequency;
        if (numArr4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr4 = null;
        }
        if (ArraysKt.indexOf((T[]) numArr4, Integer.valueOf(this.urgentAlertFrequency)) == -1) {
            i3 = 0;
        } else {
            Integer[] numArr5 = this.listOfFrequency;
            if (numArr5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
                numArr5 = null;
            }
            i3 = ArraysKt.indexOf((T[]) numArr5, Integer.valueOf(this.urgentAlertFrequency));
        }
        settingItemWidget4.setValue(getString(i8, new Object[]{list6.get(i3)}));
        ((ActivitySettingsAlertBinding) getBinding()).noticeFrequencyUrgent.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda14(this));
        ((ActivitySettingsAlertBinding) getBinding()).hypoAlertSwitch.getSwitch().setChecked(settingEntity.getLowAlertSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).hypoAlertSwitch.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda15());
        ((ActivitySettingsAlertBinding) getBinding()).hyperAlertSwitch.getSwitch().setChecked(settingEntity.getHighAlertSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).hyperAlertSwitch.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda1());
        ((ActivitySettingsAlertBinding) getBinding()).hyperThreshold.setValue(GlucoseUtilKt.toGlucoseStringWithUnit(ThresholdManager.INSTANCE.getHyper()));
        ((ActivitySettingsAlertBinding) getBinding()).hypoThreshold.setValue(GlucoseUtilKt.toGlucoseStringWithUnit(ThresholdManager.INSTANCE.getHypo()));
        ((ActivitySettingsAlertBinding) getBinding()).switchRaiseAlert.getSwitch().setChecked(settingEntity.getFastUpSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).switchRaiseAlert.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda2());
        ((ActivitySettingsAlertBinding) getBinding()).switchFallAlert.getSwitch().setChecked(settingEntity.getFastDownSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).switchFallAlert.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda3());
        ((ActivitySettingsAlertBinding) getBinding()).switchUrgentAlert.getSwitch().setChecked(settingEntity.getUrgentLowAlertSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).switchUrgentAlert.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda4(this));
        ((ActivitySettingsAlertBinding) getBinding()).lowUrgentValue.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda7(this));
        ((ActivitySettingsAlertBinding) getBinding()).lowUrgentValue.setValue(GlucoseUtilKt.toGlucoseStringWithUnit(54.0f));
        ((ActivitySettingsAlertBinding) getBinding()).switchSignalLoss.getSwitch().setChecked(settingEntity.getSignalMissingSwitch() == 0);
        ((ActivitySettingsAlertBinding) getBinding()).switchSignalLoss.getSwitch().setOnCheckedChangeListener(new AlertSettingsActivity$$ExternalSyntheticLambda8(AlertSettingsActivity$initView$function$1.INSTANCE));
        int signalMissingAlertType = settingEntity.getSignalMissingAlertType() - 1;
        SettingItemWidget settingItemWidget5 = ((ActivitySettingsAlertBinding) getBinding()).noticeMethodSignalLoss;
        List<String> list7 = this.listOfMethod;
        if (list7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list7 = null;
        }
        List<String> list8 = this.listOfMethod;
        if (list8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list8 = null;
        }
        if (signalMissingAlertType > list8.size() - 1) {
            List<String> list9 = this.listOfMethod;
            if (list9 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
                list9 = null;
            }
            signalMissingAlertType = list9.size() - 1;
        }
        settingItemWidget5.setValue(list7.get(signalMissingAlertType));
        ((ActivitySettingsAlertBinding) getBinding()).noticeMethodSignalLoss.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda9(settingEntity, this));
        int signalMissingAlertRate = settingEntity.getSignalMissingAlertRate();
        List<String> list10 = this.listOfFrequencyString;
        if (list10 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list10 = null;
        }
        List<String> list11 = this.listOfFrequencyString;
        if (list11 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list11 = null;
        }
        List<String> subList = list10.subList(1, list11.size());
        Integer[] numArr6 = this.listOfFrequency;
        if (numArr6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr6 = null;
        }
        if (ArraysKt.indexOf((T[]) numArr6, Integer.valueOf(signalMissingAlertRate)) == -1) {
            i4 = 0;
        } else {
            Integer[] numArr7 = this.listOfFrequency;
            if (numArr7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            } else {
                numArr = numArr7;
            }
            i4 = ArraysKt.indexOf((T[]) numArr, Integer.valueOf(signalMissingAlertRate)) - 1;
        }
        if (i4 >= 0 && i4 < subList.size()) {
            i6 = i4;
        }
        ((ActivitySettingsAlertBinding) getBinding()).noticeFrequencySignal.setValue(getString(R.string.user_warning_frequence_tip, new Object[]{subList.get(i6)}));
        ((ActivitySettingsAlertBinding) getBinding()).noticeFrequencySignal.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda10(this, subList, signalMissingAlertRate));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        alertSettingsActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$1(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        SettingItemWidget settingItemWidget = ((ActivitySettingsAlertBinding) alertSettingsActivity.getBinding()).noticeMethod;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "noticeMethod");
        List<String> list = alertSettingsActivity.listOfMethod;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list = null;
        }
        alertSettingsActivity.setMethodOrFrequency(settingItemWidget, list, alertSettingsActivity.alertMethod, 1, false);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$2(AlertSettingsActivity alertSettingsActivity, View view) {
        List<String> list;
        int indexOf;
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        SettingItemWidget settingItemWidget = ((ActivitySettingsAlertBinding) alertSettingsActivity.getBinding()).noticeFrequency;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "noticeFrequency");
        List<String> list2 = alertSettingsActivity.listOfFrequencyString;
        Integer[] numArr = null;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list = null;
        } else {
            list = list2;
        }
        Integer[] numArr2 = alertSettingsActivity.listOfFrequency;
        if (numArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr2 = null;
        }
        if (ArraysKt.indexOf((T[]) numArr2, Integer.valueOf(alertSettingsActivity.alertFrequency)) == -1) {
            indexOf = 0;
        } else {
            Integer[] numArr3 = alertSettingsActivity.listOfFrequency;
            if (numArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            } else {
                numArr = numArr3;
            }
            indexOf = ArraysKt.indexOf((T[]) numArr, Integer.valueOf(alertSettingsActivity.alertFrequency));
        }
        alertSettingsActivity.setMethodOrFrequency(settingItemWidget, list, indexOf, 2, false);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        SettingItemWidget settingItemWidget = ((ActivitySettingsAlertBinding) alertSettingsActivity.getBinding()).noticeMethodUrgent;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "noticeMethodUrgent");
        List<String> list = alertSettingsActivity.listOfMethod;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list = null;
        }
        alertSettingsActivity.setMethodOrFrequency(settingItemWidget, list, alertSettingsActivity.urgentAlertMethod, 1, true);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(AlertSettingsActivity alertSettingsActivity, View view) {
        List<String> list;
        int indexOf;
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        SettingItemWidget settingItemWidget = ((ActivitySettingsAlertBinding) alertSettingsActivity.getBinding()).noticeFrequencyUrgent;
        Intrinsics.checkNotNullExpressionValue(settingItemWidget, "noticeFrequencyUrgent");
        List<String> list2 = alertSettingsActivity.listOfFrequencyString;
        Integer[] numArr = null;
        if (list2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequencyString");
            list = null;
        } else {
            list = list2;
        }
        Integer[] numArr2 = alertSettingsActivity.listOfFrequency;
        if (numArr2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr2 = null;
        }
        if (ArraysKt.indexOf((T[]) numArr2, Integer.valueOf(alertSettingsActivity.urgentAlertFrequency)) == -1) {
            indexOf = 0;
        } else {
            Integer[] numArr3 = alertSettingsActivity.listOfFrequency;
            if (numArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            } else {
                numArr = numArr3;
            }
            indexOf = ArraysKt.indexOf((T[]) numArr, Integer.valueOf(alertSettingsActivity.urgentAlertFrequency));
        }
        alertSettingsActivity.setMethodOrFrequency(settingItemWidget, list, indexOf, 2, true);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(CompoundButton compoundButton, boolean z) {
        AlertUtil.INSTANCE.setHypoEnable(z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$6(CompoundButton compoundButton, boolean z) {
        AlertUtil.INSTANCE.setHyperEnable(z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$7(CompoundButton compoundButton, boolean z) {
        AlertUtil.INSTANCE.setFastUpEnable(z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$8(CompoundButton compoundButton, boolean z) {
        AlertUtil.INSTANCE.setFastDownEnable(z);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$9(AlertSettingsActivity alertSettingsActivity, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        if (!z) {
            Dialogs.showWhether$default(Dialogs.INSTANCE, alertSettingsActivity, (String) null, alertSettingsActivity.getString(R.string.user_warning_urgentLow_reconfirm, new Object[]{UnitManager.INSTANCE.getGlucoseUnit().getIndex() == 0 ? "3.0mmol/L" : "54mg/dL"}), AlertSettingsActivity$initView$10$1.INSTANCE, new AlertSettingsActivity$initView$10$2(alertSettingsActivity), (String) null, (String) null, (String) null, 0, 482, (Object) null);
        } else {
            AlertUtil.INSTANCE.setUrgentEnable(true);
        }
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$10(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        String displayUnit = UnitManager.INSTANCE.getDisplayUnit();
        Dialogs.showMessage$default(Dialogs.INSTANCE, alertSettingsActivity, alertSettingsActivity.getString(R.string.user_warning_urgentLow_value), alertSettingsActivity.getString(R.string.user_warning_urgentLow_info, new Object[]{GlucoseUtilKt.toGlucoseString(54.0f), displayUnit}), (String) null, (String) null, (Function0) null, 56, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$11(Function2 function2, CompoundButton compoundButton, boolean z) {
        Intrinsics.checkNotNullParameter(function2, "$tmp0");
        function2.invoke(compoundButton, Boolean.valueOf(z));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$12(SettingsEntity settingsEntity, AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(settingsEntity, "$alertSettings");
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        int signalMissingAlertType = settingsEntity.getSignalMissingAlertType() - 1;
        Dialogs.Picker picker = new Dialogs.Picker(alertSettingsActivity);
        List<String> list = alertSettingsActivity.listOfMethod;
        if (list == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfMethod");
            list = null;
        }
        picker.singlePick(list, signalMissingAlertType, new AlertSettingsActivity$initView$12$1(alertSettingsActivity));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$13(AlertSettingsActivity alertSettingsActivity, List list, int i, View view) {
        int i2;
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        Intrinsics.checkNotNullParameter(list, "$subList");
        Dialogs.Picker picker = new Dialogs.Picker(alertSettingsActivity);
        Integer[] numArr = alertSettingsActivity.listOfFrequency;
        Integer[] numArr2 = null;
        if (numArr == null) {
            Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            numArr = null;
        }
        if (ArraysKt.indexOf((T[]) numArr, Integer.valueOf(i)) == -1) {
            i2 = 0;
        } else {
            Integer[] numArr3 = alertSettingsActivity.listOfFrequency;
            if (numArr3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            } else {
                numArr2 = numArr3;
            }
            i2 = ArraysKt.indexOf((T[]) numArr2, Integer.valueOf(i)) - 1;
        }
        picker.singlePick(list, i2, new AlertSettingsActivity$initView$13$1(alertSettingsActivity, list));
    }

    private final void initEvent() {
        ((ActivitySettingsAlertBinding) getBinding()).hypoThreshold.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda5(this));
        ((ActivitySettingsAlertBinding) getBinding()).hyperThreshold.setOnClickListener(new AlertSettingsActivity$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$14(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        new ThresholdSelectView(alertSettingsActivity, RulerWidget.RulerType.HYPO, new AlertSettingsActivity$initEvent$1$hypoSelectView$1(alertSettingsActivity)).show();
    }

    /* access modifiers changed from: private */
    public static final void initEvent$lambda$15(AlertSettingsActivity alertSettingsActivity, View view) {
        Intrinsics.checkNotNullParameter(alertSettingsActivity, "this$0");
        new ThresholdSelectView(alertSettingsActivity, RulerWidget.RulerType.HYPER, new AlertSettingsActivity$initEvent$2$hyperSelectView$1(alertSettingsActivity)).show();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivitySettingsAlertBinding) getBinding()).getRoot());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.needInit) {
            initData();
            initView();
            initEvent();
            this.needInit = false;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (this.isHypChanged) {
            EventBusManager.INSTANCE.send(EventBusKey.EVENT_HYP_CHANGE, true);
        }
    }
}
