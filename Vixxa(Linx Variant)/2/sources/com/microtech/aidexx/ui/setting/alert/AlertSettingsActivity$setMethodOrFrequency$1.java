package com.microtech.aidexx.ui.setting.alert;

import com.microtech.aidexx.R;
import com.microtech.aidexx.views.SettingItemWidget;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: AlertSettingsActivity.kt */
final class AlertSettingsActivity$setMethodOrFrequency$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ boolean $isUrgent;
    final /* synthetic */ List<String> $list;
    final /* synthetic */ SettingItemWidget $settingItem;
    final /* synthetic */ int $type;
    final /* synthetic */ AlertSettingsActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AlertSettingsActivity$setMethodOrFrequency$1(int i, SettingItemWidget settingItemWidget, List<String> list, boolean z, AlertSettingsActivity alertSettingsActivity) {
        super(1);
        this.$type = i;
        this.$settingItem = settingItemWidget;
        this.$list = list;
        this.$isUrgent = z;
        this.this$0 = alertSettingsActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i) {
        int i2 = this.$type;
        if (i2 == 1) {
            this.$settingItem.setValue(this.$list.get(i));
            if (this.$isUrgent) {
                int i3 = i + 1;
                AlertUtil.INSTANCE.setUrgentAlertMethod(i3);
                this.this$0.urgentAlertMethod = i3;
            } else {
                int i4 = i + 1;
                AlertUtil.INSTANCE.setAlertMethod(i4);
                this.this$0.alertMethod = i4;
            }
            AlertUtil.INSTANCE.alert(this.this$0, i, this.$isUrgent);
        } else if (i2 == 2) {
            this.$settingItem.setValue(this.this$0.getString(R.string.user_warning_frequence_tip, new Object[]{this.$list.get(i)}));
            Integer[] numArr = null;
            if (this.$isUrgent) {
                AlertUtil alertUtil = AlertUtil.INSTANCE;
                Integer[] access$getListOfFrequency$p = this.this$0.listOfFrequency;
                if (access$getListOfFrequency$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
                    access$getListOfFrequency$p = null;
                }
                alertUtil.setUrgentFrequency(access$getListOfFrequency$p[i].intValue());
                AlertSettingsActivity alertSettingsActivity = this.this$0;
                Integer[] access$getListOfFrequency$p2 = alertSettingsActivity.listOfFrequency;
                if (access$getListOfFrequency$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
                } else {
                    numArr = access$getListOfFrequency$p2;
                }
                alertSettingsActivity.urgentAlertFrequency = numArr[i].intValue();
                return;
            }
            AlertUtil alertUtil2 = AlertUtil.INSTANCE;
            Integer[] access$getListOfFrequency$p3 = this.this$0.listOfFrequency;
            if (access$getListOfFrequency$p3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
                access$getListOfFrequency$p3 = null;
            }
            alertUtil2.setAlertFrequency(access$getListOfFrequency$p3[i].intValue());
            AlertSettingsActivity alertSettingsActivity2 = this.this$0;
            Integer[] access$getListOfFrequency$p4 = alertSettingsActivity2.listOfFrequency;
            if (access$getListOfFrequency$p4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("listOfFrequency");
            } else {
                numArr = access$getListOfFrequency$p4;
            }
            alertSettingsActivity2.alertFrequency = numArr[i].intValue();
        }
    }
}
