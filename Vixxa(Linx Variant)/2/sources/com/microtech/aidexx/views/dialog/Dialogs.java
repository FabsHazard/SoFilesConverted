package com.microtech.aidexx.views.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.kongzue.dialogx.dialogs.TipDialog;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.views.dialog.standard.StandardDialog;
import com.microtech.aidexx.views.selector.option.OptionsPickerBuilder;
import com.microtech.aidexx.views.selector.option.OptionsPickerView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002()B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ:\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\u000e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014J.\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0017J\u001c\u0010\u001a\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u001b\u001a\u00020\u001cJN\u0010\u001d\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\n2\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0014J\u0012\u0010 \u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nJ\u0012\u0010!\u001a\u00020\f2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nJv\u0010\"\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000f2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\n2\u000e\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00142\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010\n2\b\b\u0003\u0010'\u001a\u00020\u0005R6\u0010\u0003\u001a*\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004j\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006`\bX\u000e¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0004j\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007`\bX\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/views/dialog/Dialogs;", "", "()V", "alertDialogMap", "Ljava/util/HashMap;", "", "", "Lcom/microtech/aidexx/views/dialog/standard/StandardDialog;", "Lkotlin/collections/HashMap;", "whetherDialogMap", "", "dismissWait", "", "showAlert", "context", "Landroidx/appcompat/app/AppCompatActivity;", "type", "title", "content", "callBack", "Lkotlin/Function0;", "showDialogWithView", "dialogView", "Landroid/view/View;", "confirmView", "cancelView", "showError", "duration", "", "showMessage", "note", "confirm", "showSuccess", "showWait", "showWhether", "cancel", "key", "confirmBtnText", "cancelBtnText", "btnOrientation", "DateInfo", "Picker", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: Dialogs.kt */
public final class Dialogs {
    public static final Dialogs INSTANCE = new Dialogs();
    /* access modifiers changed from: private */
    public static HashMap<Integer, List<StandardDialog>> alertDialogMap = new HashMap<>();
    private static HashMap<String, StandardDialog> whetherDialogMap = new HashMap<>();

    private Dialogs() {
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J?\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b2\u0006\u0010\f\u001a\u00020\r2!\u0010\u000e\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\t0\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X.¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microtech/aidexx/views/dialog/Dialogs$Picker;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "pickBuilder", "Lcom/microtech/aidexx/views/selector/option/OptionsPickerView;", "", "singlePick", "", "list", "", "selectPos", "", "callBack", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pos", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Dialogs.kt */
    public static final class Picker {
        private final Context context;
        private OptionsPickerView<String> pickBuilder;

        public Picker(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
        }

        public final void singlePick(List<String> list, int i, Function1<? super Integer, Unit> function1) {
            Intrinsics.checkNotNullParameter(list, "list");
            Intrinsics.checkNotNullParameter(function1, "callBack");
            OptionsPickerView<String> build = new OptionsPickerBuilder(this.context, new Dialogs$Picker$$ExternalSyntheticLambda2(function1)).setLayoutRes(R.layout.layout_option_pick, new Dialogs$Picker$$ExternalSyntheticLambda3(this)).setTextColorCenter(this.context.getColor(R.color.green_65)).setDividerColor(this.context.getColor(R.color.green_65)).isDialog(false).setOutSideCancelable(true).setSelectOptions(0, i, 0).setBgColor(ThemeManager.getTypeValue(this.context, R.attr.bgMainTab)).build();
            Intrinsics.checkNotNullExpressionValue(build, "build(...)");
            this.pickBuilder = build;
            OptionsPickerView<String> optionsPickerView = null;
            if (build == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickBuilder");
                build = null;
            }
            build.setNPicker(CollectionsKt.emptyList(), list, CollectionsKt.emptyList());
            OptionsPickerView<String> optionsPickerView2 = this.pickBuilder;
            if (optionsPickerView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickBuilder");
            } else {
                optionsPickerView = optionsPickerView2;
            }
            optionsPickerView.show();
        }

        /* access modifiers changed from: private */
        public static final void singlePick$lambda$0(Function1 function1, int i, int i2, int i3, View view) {
            Intrinsics.checkNotNullParameter(function1, "$callBack");
            function1.invoke(Integer.valueOf(i2));
        }

        /* access modifiers changed from: private */
        public static final void singlePick$lambda$3(Picker picker, View view) {
            Intrinsics.checkNotNullParameter(picker, "this$0");
            View findViewById = view.findViewById(R.id.tv_option_confirm);
            Intrinsics.checkNotNull(findViewById, "null cannot be cast to non-null type android.widget.TextView");
            View findViewById2 = view.findViewById(R.id.tv_option_cancel);
            Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.TextView");
            ((TextView) findViewById).setOnClickListener(new Dialogs$Picker$$ExternalSyntheticLambda0(picker));
            ((TextView) findViewById2).setOnClickListener(new Dialogs$Picker$$ExternalSyntheticLambda1(picker));
        }

        /* access modifiers changed from: private */
        public static final void singlePick$lambda$3$lambda$1(Picker picker, View view) {
            Intrinsics.checkNotNullParameter(picker, "this$0");
            OptionsPickerView<String> optionsPickerView = picker.pickBuilder;
            OptionsPickerView<String> optionsPickerView2 = null;
            if (optionsPickerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickBuilder");
                optionsPickerView = null;
            }
            optionsPickerView.returnData();
            OptionsPickerView<String> optionsPickerView3 = picker.pickBuilder;
            if (optionsPickerView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickBuilder");
            } else {
                optionsPickerView2 = optionsPickerView3;
            }
            optionsPickerView2.dismiss();
        }

        /* access modifiers changed from: private */
        public static final void singlePick$lambda$3$lambda$2(Picker picker, View view) {
            Intrinsics.checkNotNullParameter(picker, "this$0");
            OptionsPickerView<String> optionsPickerView = picker.pickBuilder;
            if (optionsPickerView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pickBuilder");
                optionsPickerView = null;
            }
            optionsPickerView.dismiss();
        }
    }

    public static /* synthetic */ void showDialogWithView$default(Dialogs dialogs, AppCompatActivity appCompatActivity, View view, View view2, View view3, int i, Object obj) {
        if ((i & 4) != 0) {
            view2 = null;
        }
        if ((i & 8) != 0) {
            view3 = null;
        }
        dialogs.showDialogWithView(appCompatActivity, view, view2, view3);
    }

    public final void showDialogWithView(AppCompatActivity appCompatActivity, View view, View view2, View view3) {
        View view4 = view;
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        Intrinsics.checkNotNullParameter(view, "dialogView");
        StandardDialog create = new StandardDialog.Setter(appCompatActivity).create(view);
        if (view2 != null) {
            ExtendsKt.setDebounceClickListener$default(view2, 0, new Dialogs$$ExternalSyntheticLambda4(create), 1, (Object) null);
        }
        if (view3 != null) {
            ExtendsKt.setDebounceClickListener$default(view3, 0, new Dialogs$$ExternalSyntheticLambda5(create), 1, (Object) null);
        }
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showDialogWithView$lambda$0(StandardDialog standardDialog, View view) {
        standardDialog.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void showDialogWithView$lambda$1(StandardDialog standardDialog, View view) {
        standardDialog.dismiss();
    }

    public final void showAlert(AppCompatActivity appCompatActivity, int i, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        if (!appCompatActivity.isFinishing()) {
            List<StandardDialog> list = alertDialogMap.get(Integer.valueOf(i));
            if (list != null && (!list.isEmpty())) {
                for (StandardDialog dismiss : list) {
                    dismiss.dismiss();
                }
                list.clear();
            }
            StandardDialog create = new StandardDialog.Setter(appCompatActivity).content(str2).title(str).setPositive(new Dialogs$$ExternalSyntheticLambda3(function0, i)).create();
            if (list == null) {
                Integer valueOf = Integer.valueOf(i);
                Intrinsics.checkNotNull(create);
                alertDialogMap.put(valueOf, CollectionsKt.mutableListOf(create));
            } else {
                Intrinsics.checkNotNull(create);
                list.add(create);
                alertDialogMap.put(Integer.valueOf(i), list);
            }
            appCompatActivity.getLifecycle().addObserver(new Dialogs$showAlert$2(create));
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void showAlert$lambda$3(Function0 function0, int i, DialogInterface dialogInterface, int i2) {
        dialogInterface.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
        alertDialogMap.put(Integer.valueOf(i), new ArrayList());
    }

    public static /* synthetic */ void showMessage$default(Dialogs dialogs, AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, Function0 function0, int i, Object obj) {
        dialogs.showMessage(appCompatActivity, (i & 2) != 0 ? null : str, str2, (i & 8) != 0 ? null : str3, (i & 16) != 0 ? null : str4, (i & 32) != 0 ? null : function0);
    }

    public final void showMessage(AppCompatActivity appCompatActivity, String str, String str2, String str3, String str4, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        StandardDialog create = new StandardDialog.Setter(appCompatActivity).content(str2).note(str3).title(str).confirmBtnText(str4).setPositive(new Dialogs$$ExternalSyntheticLambda0(function0)).create();
        appCompatActivity.getLifecycle().addObserver(new Dialogs$showMessage$1(create));
        create.show();
    }

    /* access modifiers changed from: private */
    public static final void showMessage$lambda$4(Function0 function0, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
    }

    public static /* synthetic */ StandardDialog showWhether$default(Dialogs dialogs, AppCompatActivity appCompatActivity, String str, String str2, Function0 function0, Function0 function02, String str3, String str4, String str5, int i, int i2, Object obj) {
        int i3 = i2;
        return dialogs.showWhether(appCompatActivity, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, function0, (i3 & 16) != 0 ? null : function02, (i3 & 32) != 0 ? null : str3, (i3 & 64) != 0 ? null : str4, (i3 & 128) != 0 ? null : str5, (i3 & 256) != 0 ? 0 : i);
    }

    public final StandardDialog showWhether(AppCompatActivity appCompatActivity, String str, String str2, Function0<Unit> function0, Function0<Unit> function02, String str3, String str4, String str5, @DialogBtnOrientation int i) {
        StandardDialog standardDialog;
        Intrinsics.checkNotNullParameter(appCompatActivity, "context");
        if (!(str3 == null || (standardDialog = whetherDialogMap.get(str3)) == null)) {
            standardDialog.dismiss();
        }
        StandardDialog create = new StandardDialog.Setter(appCompatActivity).content(str2).title(str).setPositive(str4, new Dialogs$$ExternalSyntheticLambda1(function0, str3)).setCancel(str5, new Dialogs$$ExternalSyntheticLambda2(function02, str3)).create(i);
        if (str3 != null) {
            Intrinsics.checkNotNull(create);
            whetherDialogMap.put(str3, create);
        }
        appCompatActivity.getLifecycle().addObserver(new Dialogs$showWhether$3(create));
        create.show();
        Intrinsics.checkNotNull(create);
        return create;
    }

    /* access modifiers changed from: private */
    public static final void showWhether$lambda$6(Function0 function0, String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
        TypeIntrinsics.asMutableMap(whetherDialogMap).remove(str);
    }

    /* access modifiers changed from: private */
    public static final void showWhether$lambda$7(Function0 function0, String str, DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
        if (function0 != null) {
            function0.invoke();
        }
        TypeIntrinsics.asMutableMap(whetherDialogMap).remove(str);
    }

    public static /* synthetic */ void showWait$default(Dialogs dialogs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dialogs.showWait(str);
    }

    public final void showWait(String str) {
        WaitDialog.show((CharSequence) str);
    }

    public static /* synthetic */ void showSuccess$default(Dialogs dialogs, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        dialogs.showSuccess(str);
    }

    public final void showSuccess(String str) {
        TipDialog.show((CharSequence) str, WaitDialog.TYPE.SUCCESS);
    }

    public static /* synthetic */ void showError$default(Dialogs dialogs, String str, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            j = 1500;
        }
        dialogs.showError(str, j);
    }

    public final void showError(String str, long j) {
        TipDialog.show((CharSequence) str, WaitDialog.TYPE.ERROR, j);
    }

    public final void dismissWait() {
        if (WaitDialog.getType() != 1 && WaitDialog.getType() != 3) {
            WaitDialog.dismiss();
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001e\u0010\f\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/microtech/aidexx/views/dialog/Dialogs$DateInfo;", "", "()V", "dateLast14days", "Ljava/util/Date;", "getDateLast14days", "()Ljava/util/Date;", "setDateLast14days", "(Ljava/util/Date;)V", "dateLastMonth", "getDateLastMonth", "setDateLastMonth", "dateLastWeek", "getDateLastWeek", "setDateLastWeek", "dateToday", "getDateToday", "setDateToday", "timeNextZero", "", "initDateInfo", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: Dialogs.kt */
    public static final class DateInfo {
        public static final DateInfo INSTANCE = new DateInfo();
        private static Date dateLast14days;
        private static Date dateLastMonth;
        private static Date dateLastWeek;
        private static Date dateToday;
        private static long timeNextZero;

        private DateInfo() {
        }

        public final void setDateLastWeek(Date date) {
            dateLastWeek = date;
        }

        public final Date getDateLastWeek() {
            initDateInfo();
            Date date = new Date((timeNextZero - 604800000) + ((long) TimeZone.getDefault().getDSTSavings()));
            dateLastWeek = date;
            return date;
        }

        public final void setDateLast14days(Date date) {
            dateLast14days = date;
        }

        public final Date getDateLast14days() {
            initDateInfo();
            Date date = new Date((timeNextZero - 1209600000) + ((long) TimeZone.getDefault().getDSTSavings()));
            dateLast14days = date;
            return date;
        }

        public final void setDateLastMonth(Date date) {
            dateLastMonth = date;
        }

        public final Date getDateLastMonth() {
            initDateInfo();
            Date date = new Date((timeNextZero - 2592000000L) + ((long) TimeZone.getDefault().getDSTSavings()));
            dateLastMonth = date;
            return date;
        }

        public final void setDateToday(Date date) {
            dateToday = date;
        }

        public final Date getDateToday() {
            initDateInfo();
            Date date = new Date(timeNextZero);
            dateToday = date;
            return date;
        }

        private final void initDateInfo() {
            Calendar instance = Calendar.getInstance();
            instance.add(5, 1);
            instance.set(11, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance.set(14, 0);
            timeNextZero = instance.getTimeInMillis();
        }
    }
}
