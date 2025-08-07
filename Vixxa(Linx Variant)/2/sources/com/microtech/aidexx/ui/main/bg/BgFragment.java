package com.microtech.aidexx.ui.main.bg;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.work.PeriodicWorkRequest;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ble.MessageDistributor;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.ExtendsKt$$ExternalSyntheticBackportWithForwarding0;
import com.microtech.aidexx.databinding.FragmentBgBinding;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.ui.main.bg.history.BloodGlucoseHistoryActivity;
import com.microtech.aidexx.utils.DigitFilter;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.UnitManager;
import com.microtech.aidexx.views.button.StateButton;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.microtech.aidexx.views.selector.time.TimePicker;
import io.objectbox.Box;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0015\u0018\u0000 :2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001:B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\b\u0010#\u001a\u00020$H\u0002J\u0017\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'H\u0002¢\u0006\u0002\u0010(J\u0012\u0010)\u001a\u00020!2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0012\u0010,\u001a\u00020!2\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J$\u0010/\u001a\u00020+2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u00104\u001a\u00020!H\u0016J\b\u00105\u001a\u00020!H\u0016J\b\u00106\u001a\u00020!H\u0016J\b\u00107\u001a\u00020!H\u0002J\b\u00108\u001a\u00020!H\u0002J\b\u00109\u001a\u00020!H\u0002R\u001a\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0004\n\u0002\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006;"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/BgFragment;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/FragmentBgBinding;", "Landroid/view/View$OnClickListener;", "()V", "POINTER", "", "getPOINTER", "()Ljava/lang/String;", "setPOINTER", "(Ljava/lang/String;)V", "appColorAccent", "", "buttonPressColor", "calibrationState", "Lcom/microtech/aidexx/ble/device/model/DeviceModel$CalibrationState;", "defaultMode", "Lcom/microtech/aidexx/ble/device/model/DeviceModel;", "inputHint", "mObserver", "com/microtech/aidexx/ui/main/bg/BgFragment$mObserver$1", "Lcom/microtech/aidexx/ui/main/bg/BgFragment$mObserver$1;", "maxGlucose", "", "minGlucose", "selectDate", "Ljava/util/Date;", "timeSlopAdapter", "Lcom/microtech/aidexx/ui/main/bg/TimeSlopAdapter;", "timeSlot", "Ljava/lang/Integer;", "initGlucoseValueEditor", "", "initView", "isBgExpired", "", "isBgFilled", "glucoseValue", "", "(Ljava/lang/Float;)Z", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "refreshBtnState", "refreshView", "updateLastRecord", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BgFragment.kt */
public final class BgFragment extends BaseFragment<BaseViewModel, FragmentBgBinding> implements View.OnClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public String POINTER;
    private int appColorAccent;
    private int buttonPressColor;
    /* access modifiers changed from: private */
    public DeviceModel.CalibrationState calibrationState;
    private DeviceModel defaultMode;
    private String inputHint = "";
    /* access modifiers changed from: private */
    public final BgFragment$mObserver$1 mObserver = new BgFragment$mObserver$1(this);
    /* access modifiers changed from: private */
    public double maxGlucose;
    private double minGlucose;
    /* access modifiers changed from: private */
    public Date selectDate;
    /* access modifiers changed from: private */
    public TimeSlopAdapter timeSlopAdapter;
    /* access modifiers changed from: private */
    public Integer timeSlot;

    @JvmStatic
    public static final BgFragment newInstance() {
        return Companion.newInstance();
    }

    public final String getPOINTER() {
        String str = this.POINTER;
        if (str != null) {
            return str;
        }
        Intrinsics.throwUninitializedPropertyAccessException("POINTER");
        return null;
    }

    public final void setPOINTER(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.POINTER = str;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.appColorAccent = ThemeManager.getTypeValue(requireContext(), R.attr.appColorAccent);
        this.buttonPressColor = ThemeManager.getTypeValue(requireContext(), R.attr.buttonPressColor);
    }

    public void onResume() {
        super.onResume();
        TimeSlopAdapter timeSlopAdapter2 = this.timeSlopAdapter;
        if (timeSlopAdapter2 != null) {
            timeSlopAdapter2.clearCheck();
        }
        initGlucoseValueEditor();
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        this.defaultMode = deviceModel;
        if (deviceModel != null) {
            deviceModel.setOnCalibrationPermitChange(new BgFragment$onResume$1(this));
        }
        DeviceModel deviceModel2 = this.defaultMode;
        this.calibrationState = deviceModel2 != null ? deviceModel2.getCalibrationState() : null;
        refreshView();
        getThrottle().emit(3000, 3, new BgFragment$onResume$2(this));
    }

    private final void refreshView() {
        refreshBtnState();
        ((FragmentBgBinding) getBinding()).tvTime.setText(ExtendsKt.formatToYMdHm(TimeUtils.INSTANCE.getCurrentDate()));
        this.selectDate = TimeUtils.INSTANCE.getCurrentDate();
        ((FragmentBgBinding) getBinding()).tvGlucoseUnit.setText(UnitManager.INSTANCE.getDisplayUnit());
    }

    /* access modifiers changed from: private */
    public final void refreshBtnState() {
        int i;
        int i2;
        int i3;
        Context context = getContext();
        if (context != null) {
            DeviceModel.CalibrationState calibrationState2 = this.calibrationState;
            boolean z = false;
            if (calibrationState2 != null && calibrationState2.isPaired() && !calibrationState2.isSensorExpired() && !calibrationState2.getWithIn6Hrs()) {
                z = true;
            }
            StateButton stateButton = ((FragmentBgBinding) getBinding()).buttonCalibration;
            if (z) {
                i = this.appColorAccent;
            } else {
                i = ExtendsKt.toColor(R.color.button_unclick_color, context);
            }
            stateButton.setNormalBackgroundColor(i);
            StateButton stateButton2 = ((FragmentBgBinding) getBinding()).buttonCalibration;
            if (z) {
                i2 = this.buttonPressColor;
            } else {
                i2 = ExtendsKt.toColor(R.color.button_unclick_color, context);
            }
            stateButton2.setPressedBackgroundColor(i2);
            StateButton stateButton3 = ((FragmentBgBinding) getBinding()).buttonCalibration;
            if (z) {
                i3 = ExtendsKt.toColor(R.color.white, context);
            } else {
                i3 = ExtendsKt.toColor(R.color.whiteAlpha30, context);
            }
            stateButton3.setTextColor(i3);
            ((FragmentBgBinding) getBinding()).buttonCalibration.setClickable(z);
        }
    }

    public void onPause() {
        super.onPause();
        MessageDistributor.Companion.instance().removeObserver(this.mObserver);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        FragmentBgBinding inflate = FragmentBgBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        ((FragmentBgBinding) getBinding()).layoutActionbar.setPadding(0, ExtendsKt.getStatusBarHeight() + ExtendsKt.dp2px((Number) 10), 0, 0);
        initView();
        LinearLayout root = ((FragmentBgBinding) getBinding()).getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    private final void initView() {
        StateButton stateButton = ((FragmentBgBinding) getBinding()).buttonCalibration;
        Intrinsics.checkNotNullExpressionValue(stateButton, "buttonCalibration");
        View.OnClickListener onClickListener = this;
        ExtendsKt.setDebounceClickListener$default(stateButton, 0, onClickListener, 1, (Object) null);
        StateButton stateButton2 = ((FragmentBgBinding) getBinding()).buttonRecord;
        Intrinsics.checkNotNullExpressionValue(stateButton2, "buttonRecord");
        ExtendsKt.setDebounceClickListener$default(stateButton2, 0, onClickListener, 1, (Object) null);
        FlexboxLayoutManager flexboxLayoutManager = new FlexboxLayoutManager(getContext());
        flexboxLayoutManager.setJustifyContent(0);
        flexboxLayoutManager.setAlignItems(2);
        ((FragmentBgBinding) getBinding()).rvTimeSlop.setLayoutManager(flexboxLayoutManager);
        Context context = getContext();
        TimeSlopAdapter timeSlopAdapter2 = context != null ? new TimeSlopAdapter(context) : null;
        this.timeSlopAdapter = timeSlopAdapter2;
        if (timeSlopAdapter2 != null) {
            timeSlopAdapter2.setOnSelect(new BgFragment$initView$2(this));
        }
        ((FragmentBgBinding) getBinding()).rvTimeSlop.setAdapter(this.timeSlopAdapter);
        TextView textView = ((FragmentBgBinding) getBinding()).tvTime;
        Intrinsics.checkNotNullExpressionValue(textView, "tvTime");
        ExtendsKt.setDebounceClickListener$default(textView, 0, new BgFragment$$ExternalSyntheticLambda0(this), 1, (Object) null);
        TextView textView2 = ((FragmentBgBinding) getBinding()).tvMoreHistory;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvMoreHistory");
        ExtendsKt.setDebounceClickListener$default(textView2, 0, new BgFragment$$ExternalSyntheticLambda1(this), 1, (Object) null);
        ((FragmentBgBinding) getBinding()).etGlucoseValue.setOnFocusChangeListener(new BgFragment$$ExternalSyntheticLambda2(this));
        ((FragmentBgBinding) getBinding()).etGlucoseValue.addTextChangedListener(new BgFragment$initView$6(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(BgFragment bgFragment, View view) {
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        Context requireContext = bgFragment.requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
        TimePicker.pick$default(new TimePicker(requireContext), (boolean[]) null, (String) null, (Calendar) null, new BgFragment$initView$3$1(bgFragment), 7, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$4(BgFragment bgFragment, View view) {
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        bgFragment.startActivity(new Intent(bgFragment.requireContext(), BloodGlucoseHistoryActivity.class));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$5(BgFragment bgFragment, View view, boolean z) {
        Intrinsics.checkNotNullParameter(bgFragment, "this$0");
        if (!z) {
            Object systemService = bgFragment.requireContext().getSystemService("input_method");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
            ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: private */
    public final void updateLastRecord() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new BgFragment$updateLastRecord$1(this, (Continuation<? super BgFragment$updateLastRecord$1>) null), 3, (Object) null);
    }

    private final void initGlucoseValueEditor() {
        setPOINTER(String.valueOf(DecimalFormatSymbols.getInstance(ExtendsKt.getLocale()).getDecimalSeparator()));
        if (UnitManager.INSTANCE.getGlucoseUnit() == UnitManager.GlucoseUnit.MMOL_PER_L) {
            this.minGlucose = 0.6d;
            this.maxGlucose = 33.3d;
        } else {
            this.minGlucose = 10.0d;
            this.maxGlucose = 600.0d;
        }
        DecimalFormat decimalFormatWithLocale = ExtendsKt.getDecimalFormatWithLocale();
        String format = decimalFormatWithLocale.format(ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.valueOf(this.minGlucose))));
        String format2 = decimalFormatWithLocale.format(ExtendsKt$$ExternalSyntheticBackportWithForwarding0.m(new BigDecimal(String.valueOf(this.maxGlucose))));
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        Locale locale = Locale.getDefault();
        String string = getString(R.string.glucose_item_valueHint);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String format3 = String.format(locale, string, Arrays.copyOf(new Object[]{format, format2}, 2));
        Intrinsics.checkNotNullExpressionValue(format3, "format(...)");
        this.inputHint = format3;
        ((FragmentBgBinding) getBinding()).etGlucoseValue.setHint(this.inputHint);
        AppCompatEditText appCompatEditText = ((FragmentBgBinding) getBinding()).etGlucoseValue;
        DigitFilter[] digitFilterArr = new DigitFilter[1];
        DigitFilter digitFilter = new DigitFilter(getPOINTER());
        digitFilter.setIntOnly(UnitManager.INSTANCE.getGlucoseUnit() != UnitManager.GlucoseUnit.MMOL_PER_L);
        digitFilter.setGlucoseValue(true);
        digitFilter.setMaxLength(4);
        digitFilter.setPointerLength(1);
        Unit unit = Unit.INSTANCE;
        digitFilterArr[0] = digitFilter;
        appCompatEditText.setFilters((InputFilter[]) digitFilterArr);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/ui/main/bg/BgFragment$Companion;", "", "()V", "newInstance", "Lcom/microtech/aidexx/ui/main/bg/BgFragment;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BgFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final BgFragment newInstance() {
            return new BgFragment();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: java.util.Date} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: java.util.Date} */
    /* JADX WARNING: type inference failed for: r6v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v7, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r6v18, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            androidx.viewbinding.ViewBinding r2 = r19.getBinding()
            com.microtech.aidexx.databinding.FragmentBgBinding r2 = (com.microtech.aidexx.databinding.FragmentBgBinding) r2
            androidx.appcompat.widget.AppCompatEditText r2 = r2.etGlucoseValue
            android.text.Editable r2 = r2.getText()
            java.lang.String r2 = java.lang.String.valueOf(r2)
            java.lang.String r2 = com.microtech.aidexx.common.ExtendsKt.processPoint(r2)
            java.lang.Float r2 = kotlin.text.StringsKt.toFloatOrNull(r2)
            java.lang.String r3 = "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity"
            if (r2 == 0) goto L_0x0181
            float r4 = r2.floatValue()
            double r4 = (double) r4
            double r6 = r0.maxGlucose
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 > 0) goto L_0x0181
            float r4 = r2.floatValue()
            double r4 = (double) r4
            double r6 = r0.minGlucose
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 >= 0) goto L_0x0038
            goto L_0x0181
        L_0x0038:
            androidx.viewbinding.ViewBinding r4 = r19.getBinding()
            com.microtech.aidexx.databinding.FragmentBgBinding r4 = (com.microtech.aidexx.databinding.FragmentBgBinding) r4
            com.microtech.aidexx.views.button.StateButton r4 = r4.buttonCalibration
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r4)
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0128
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r1 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r1 = r1.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r1 = r1.getDefault()
            if (r1 == 0) goto L_0x0180
            boolean r4 = r1.isPaired()
            if (r4 == 0) goto L_0x0180
            com.microtech.aidexx.ble.device.model.DeviceModel$CalibrationState r4 = r1.getCalibrationState()
            android.content.Context r7 = r19.requireContext()
            boolean r7 = com.microtech.aidexx.utils.BleUtil.isBleEnable(r7)
            if (r7 != 0) goto L_0x0070
            int r4 = com.microtech.aidexx.R.string.permission_ble_desc
            java.lang.String r6 = r0.getString(r4)
        L_0x006e:
            r10 = r6
            goto L_0x008a
        L_0x0070:
            boolean r7 = r4.getDeviceAllow()
            if (r7 != 0) goto L_0x007d
            int r4 = com.microtech.aidexx.R.string.glucose_calibrateHint_unable
            java.lang.String r6 = r0.getString(r4)
            goto L_0x006e
        L_0x007d:
            boolean r4 = r4.isConnected()
            if (r4 != 0) goto L_0x006e
            int r4 = com.microtech.aidexx.R.string.glucose_calibrateHint_disconnect
            java.lang.String r6 = r0.getString(r4)
            goto L_0x006e
        L_0x008a:
            if (r10 == 0) goto L_0x00a3
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            r8 = r1
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r14 = 58
            r15 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            com.microtech.aidexx.views.dialog.Dialogs.showMessage$default(r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        L_0x00a3:
            com.microtech.aidexx.utils.UnitManager r4 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            com.microtech.aidexx.utils.UnitManager$GlucoseUnit r4 = r4.getGlucoseUnit()
            com.microtech.aidexx.utils.UnitManager$GlucoseUnit r6 = com.microtech.aidexx.utils.UnitManager.GlucoseUnit.MMOL_PER_L
            if (r4 != r6) goto L_0x00b2
            java.lang.String r4 = r2.toString()
            goto L_0x00be
        L_0x00b2:
            float r4 = r2.floatValue()
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            java.lang.String r4 = java.lang.String.valueOf(r4)
        L_0x00be:
            boolean r6 = r19.isBgExpired()
            if (r6 != 0) goto L_0x0180
            boolean r6 = r0.isBgFilled(r2)
            if (r6 == 0) goto L_0x0180
            com.microtech.aidexx.views.dialog.Dialogs r7 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            androidx.fragment.app.FragmentActivity r6 = r19.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r3)
            r8 = r6
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            kotlin.jvm.internal.StringCompanionObject r3 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            int r3 = com.microtech.aidexx.R.string.glucose_calibrate
            java.lang.String r3 = r0.getString(r3)
            java.lang.String r6 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r6)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.StringBuilder r4 = r6.append(r4)
            r6 = 32
            java.lang.StringBuilder r4 = r4.append(r6)
            com.microtech.aidexx.utils.UnitManager r6 = com.microtech.aidexx.utils.UnitManager.INSTANCE
            java.lang.String r6 = r6.getDisplayUnit()
            java.lang.StringBuilder r4 = r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.Object[] r4 = new java.lang.Object[]{r4}
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r5)
            java.lang.String r10 = java.lang.String.format(r3, r4)
            java.lang.String r3 = "format(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r3)
            com.microtech.aidexx.ui.main.bg.BgFragment$onClick$2 r3 = new com.microtech.aidexx.ui.main.bg.BgFragment$onClick$2
            r3.<init>(r0, r2, r1)
            r11 = r3
            kotlin.jvm.functions.Function0 r11 = (kotlin.jvm.functions.Function0) r11
            r17 = 498(0x1f2, float:6.98E-43)
            r18 = 0
            r9 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            com.microtech.aidexx.views.dialog.Dialogs.showWhether$default(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            goto L_0x0180
        L_0x0128:
            androidx.viewbinding.ViewBinding r3 = r19.getBinding()
            com.microtech.aidexx.databinding.FragmentBgBinding r3 = (com.microtech.aidexx.databinding.FragmentBgBinding) r3
            com.microtech.aidexx.views.button.StateButton r3 = r3.buttonRecord
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0180
            float r1 = r2.floatValue()
            float r1 = com.microtech.aidexx.utils.GlucoseUtilKt.fromGlucoseValue(r1)
            com.microtech.aidexx.db.entity.BloodGlucoseEntity r2 = new com.microtech.aidexx.db.entity.BloodGlucoseEntity
            java.util.Date r3 = r0.selectDate
            if (r3 != 0) goto L_0x014a
            java.lang.String r3 = "selectDate"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r3)
            goto L_0x014b
        L_0x014a:
            r6 = r3
        L_0x014b:
            r2.<init>(r6, r1)
            java.lang.Integer r1 = r0.timeSlot
            if (r1 == 0) goto L_0x015b
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r2.setTestTag(r1)
        L_0x015b:
            r2.setUploadState(r5)
            com.microtech.aidexx.common.user.UserInfoManager$Companion r1 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r1 = r1.instance()
            java.lang.String r1 = r1.userId()
            r2.setUserId(r1)
            com.microtech.aidexx.db.ObjectBox r3 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            com.microtech.aidexx.ui.main.bg.BgFragment$$ExternalSyntheticLambda3 r4 = new com.microtech.aidexx.ui.main.bg.BgFragment$$ExternalSyntheticLambda3
            r4.<init>(r2)
            com.microtech.aidexx.ui.main.bg.BgFragment$onClick$5 r1 = new com.microtech.aidexx.ui.main.bg.BgFragment$onClick$5
            r1.<init>(r0, r2)
            r5 = r1
            kotlin.jvm.functions.Function0 r5 = (kotlin.jvm.functions.Function0) r5
            r7 = 4
            r8 = 0
            r6 = 0
            com.microtech.aidexx.db.ObjectBox.runAsync$default(r3, r4, r5, r6, r7, r8)
        L_0x0180:
            return
        L_0x0181:
            com.microtech.aidexx.views.dialog.Dialogs r9 = com.microtech.aidexx.views.dialog.Dialogs.INSTANCE
            androidx.fragment.app.FragmentActivity r1 = r19.getActivity()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r3)
            r10 = r1
            androidx.appcompat.app.AppCompatActivity r10 = (androidx.appcompat.app.AppCompatActivity) r10
            java.lang.String r11 = r0.inputHint
            r16 = 56
            r17 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            com.microtech.aidexx.views.dialog.Dialogs.showMessage$default(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.bg.BgFragment.onClick(android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final void onClick$lambda$9(BloodGlucoseEntity bloodGlucoseEntity) {
        Intrinsics.checkNotNullParameter(bloodGlucoseEntity, "$bgEntity");
        Box<BloodGlucoseEntity> bgHistoryBox = ObjectBox.INSTANCE.getBgHistoryBox();
        Intrinsics.checkNotNull(bgHistoryBox);
        bgHistoryBox.put(bloodGlucoseEntity);
    }

    private final boolean isBgExpired() {
        long currentTimeMillis = TimeUtils.INSTANCE.getCurrentTimeMillis();
        Date date = this.selectDate;
        if (date == null) {
            Intrinsics.throwUninitializedPropertyAccessException("selectDate");
            date = null;
        }
        if (currentTimeMillis - date.getTime() <= PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS) {
            return false;
        }
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showMessage$default(dialogs, (AppCompatActivity) activity, (String) null, getString(R.string.glucose_calibrateHint), (String) null, (String) null, (Function0) null, 58, (Object) null);
        return true;
    }

    private final boolean isBgFilled(Float f) {
        if (f != null) {
            return true;
        }
        Dialogs dialogs = Dialogs.INSTANCE;
        FragmentActivity activity = getActivity();
        Intrinsics.checkNotNull(activity, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        Dialogs.showMessage$default(dialogs, (AppCompatActivity) activity, (String) null, ((FragmentBgBinding) getBinding()).etGlucoseValue.getHint().toString(), (String) null, (String) null, (Function0) null, 58, (Object) null);
        return false;
    }
}
