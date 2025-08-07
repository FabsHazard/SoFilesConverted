package com.microtech.aidexx.views.chart;

import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.views.chart.GlucoseChart;
import com.microtech.aidexx.views.chart.dataset.ChartEntry;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "xCalByChart", "", "invoke", "(Ljava/lang/Float;)V"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: GlucoseChart.kt */
final class GlucoseChart$initView$2 extends Lambda implements Function1<Float, Unit> {
    final /* synthetic */ GlucoseChart this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlucoseChart$initView$2(GlucoseChart glucoseChart) {
        super(1);
        this.this$0 = glucoseChart;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Float) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(Float f) {
        String str;
        Float f2;
        boolean z;
        ImageView goToHistory;
        boolean z2 = true;
        View view = null;
        if (f == null || ((CombinedData) this.this$0.getData()).getScatterData() == null) {
            str = "";
        } else {
            if (f.floatValue() >= this.this$0.getXAxis().mAxisMaximum) {
                float f3 = this.this$0.getXAxis().mAxisMaximum;
                GlucoseChart.ExtraParams extraParams = this.this$0.getExtraParams();
                f2 = Float.valueOf(f3 - (extraParams != null ? extraParams.xMargin() : 0.0f));
            } else {
                f2 = f;
            }
            List arrayList = new ArrayList();
            for (IScatterDataSet entriesForXRange : ((CombinedData) this.this$0.getData()).getScatterData().getDataSets()) {
                List entriesForXRange2 = entriesForXRange.getEntriesForXRange(f2.floatValue() - 0.5f, f2.floatValue() + 0.5f);
                Intrinsics.checkNotNullExpressionValue(entriesForXRange2, "getEntriesForXRange(...)");
                arrayList.addAll(entriesForXRange2);
            }
            GlucoseChart.ExtraParams extraParams2 = this.this$0.getExtraParams();
            ImageView goToHistory2 = extraParams2 != null ? extraParams2.getGoToHistory() : null;
            if (goToHistory2 != null) {
                View view2 = goToHistory2;
                if (arrayList.size() > 5) {
                    GlucoseChart.ExtraParams extraParams3 = this.this$0.getExtraParams();
                    if (!(extraParams3 == null || (goToHistory = extraParams3.getGoToHistory()) == null)) {
                        goToHistory.setOnClickListener(new GlucoseChart$initView$2$$ExternalSyntheticLambda0(this.this$0, arrayList));
                    }
                    z = true;
                } else {
                    z = false;
                }
                view2.setVisibility(z ? 0 : 8);
            }
            GlucoseChart glucoseChart = this.this$0;
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            int i = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                int i2 = i + 1;
                Entry entry = (Entry) it.next();
                if (!(entry.getData() instanceof RealCgmHistoryEntity) && !(entry.getData() instanceof ChartEntry)) {
                    Object data = entry.getData();
                    Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.microtech.aidexx.db.entity.BaseEventEntity");
                    BaseEventEntity baseEventEntity = (BaseEventEntity) data;
                    if (i > 4) {
                        sb.append("\n ...");
                        break;
                    }
                    boolean z3 = sb.length() > 0;
                    String displayTime$default = BaseEventEntity.getDisplayTime$default(baseEventEntity, (String) null, false, 3, (Object) null);
                    Resources resources = glucoseChart.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
                    String eventDescription = baseEventEntity.getEventDescription(resources);
                    Resources resources2 = glucoseChart.getResources();
                    Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
                    String valueDescription = baseEventEntity.getValueDescription(resources2);
                    StringBuilder sb2 = new StringBuilder();
                    if (z3) {
                        sb2.append("\n");
                    }
                    if (!LanguageResourceManager.INSTANCE.isAlabo() || (!(baseEventEntity instanceof ExerciseEntity) && !(baseEventEntity instanceof OthersEntity))) {
                        sb2.append(displayTime$default);
                        sb2.append(" ");
                    }
                    sb2.append(eventDescription);
                    sb2.append(" ");
                    sb2.append(valueDescription);
                    String sb3 = sb2.toString();
                    Intrinsics.checkNotNullExpressionValue(sb3, "toString(...)");
                    String obj = StringsKt.trimEnd((CharSequence) sb3).toString();
                    Charset forName = Charset.forName("utf-8");
                    Intrinsics.checkNotNullExpressionValue(forName, "forName(...)");
                    byte[] bytes = obj.getBytes(forName);
                    Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                    if (LanguageResourceManager.INSTANCE.isAlabo() && ((baseEventEntity instanceof ExerciseEntity) || (baseEventEntity instanceof OthersEntity))) {
                        if (bytes.length > 30) {
                            obj = glucoseChart.getSubstring(obj, 30) + "...";
                        }
                        obj = obj + ' ' + displayTime$default;
                    } else if (bytes.length > 40) {
                        obj = glucoseChart.getSubstring(obj, 40) + "...";
                    }
                    sb.append(obj);
                }
                i = i2;
            }
            str = sb.toString();
            Intrinsics.checkNotNullExpressionValue(str, "toString(...)");
        }
        GlucoseChart.ExtraParams extraParams4 = this.this$0.getExtraParams();
        TextView outerDescriptionU = extraParams4 != null ? extraParams4.getOuterDescriptionU() : null;
        if (outerDescriptionU != null) {
            outerDescriptionU.setText(str);
        }
        GlucoseChart.ExtraParams extraParams5 = this.this$0.getExtraParams();
        RelativeLayout rlDescription = extraParams5 != null ? extraParams5.getRlDescription() : null;
        if (rlDescription != null) {
            rlDescription.setVisibility(str.length() > 0 ? 0 : 8);
        }
        GlucoseChart.ExtraParams extraParams6 = this.this$0.getExtraParams();
        if (extraParams6 != null) {
            view = extraParams6.getOuterDescriptionView();
        }
        if (view != null) {
            if (str.length() != 0 || !this.this$0.isValueNull) {
                z2 = false;
            }
            view.setVisibility(z2 ? 8 : 0);
        }
    }

    /* access modifiers changed from: private */
    public static final void invoke$lambda$0(GlucoseChart glucoseChart, List list, View view) {
        Function1<BaseEventEntity, Unit> onGoToHistory;
        Intrinsics.checkNotNullParameter(glucoseChart, "this$0");
        Intrinsics.checkNotNullParameter(list, "$list");
        GlucoseChart.ExtraParams extraParams = glucoseChart.getExtraParams();
        if (extraParams != null && (onGoToHistory = extraParams.getOnGoToHistory()) != null) {
            Object data = ((Entry) CollectionsKt.last(list)).getData();
            Intrinsics.checkNotNull(data, "null cannot be cast to non-null type com.microtech.aidexx.db.entity.BaseEventEntity");
            onGoToHistory.invoke((BaseEventEntity) data);
        }
    }
}
