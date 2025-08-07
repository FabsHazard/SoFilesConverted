package com.microtech.aidexx.ui.main.home.chart;

import android.os.Looper;
import android.os.Message;
import android.util.ArrayMap;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.interfaces.datasets.IScatterDataSet;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.repository.CgmCalibBgRepository;
import com.microtech.aidexx.utils.GlucoseUtilKt;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThresholdManager;
import com.microtech.aidexx.utils.TimeUtils;
import com.microtech.aidexx.utils.eventbus.CgmDataState;
import com.microtech.aidexx.utils.eventbus.DataChangedType;
import com.microtech.aidexx.views.chart.ChartUtil;
import com.microtech.aidexx.views.chart.MyChart;
import com.microtech.aidexx.views.chart.dataset.BgDataSet;
import com.microtech.aidexx.views.chart.dataset.CalDataSet;
import com.microtech.aidexx.views.chart.dataset.ChartEntry;
import com.microtech.aidexx.views.chart.dataset.CurrentGlucoseDataSet;
import com.microtech.aidexx.views.chart.dataset.DstDataSet;
import com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt;
import com.microtech.aidexx.views.chart.dataset.IconDataSet;
import com.microtech.aidexx.views.chart.dataset.TimezoneDataSet;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;
import org.apache.commons.codec.language.Soundex;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001f*\u0001N\u0018\u0000 Ñ\u00012\u00020\u0001:\u0006Ï\u0001Ð\u0001Ñ\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010T\u001a\u00020U2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020?0W2\u0006\u0010X\u001a\u00020\u0005H\u0002J\u001e\u0010Y\u001a\u00020U2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020A0W2\u0006\u0010X\u001a\u00020\u0005H\u0002J2\u0010[\u001a\u00020U2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020C0W2\u0006\u0010X\u001a\u00020\u00052\b\u0010]\u001a\u0004\u0018\u00010\u00152\b\u0010^\u001a\u0004\u0018\u00010\u0015H\u0002J&\u0010_\u001a\u00020U2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0W2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010b\u001a\u00020cH\u0002J(\u0010d\u001a\u00020U\"\b\b\u0000\u0010e*\u00020E2\f\u0010f\u001a\b\u0012\u0004\u0012\u0002He0W2\u0006\u0010X\u001a\u00020\u0005H\u0002J&\u0010g\u001a\u00020U2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020a0W2\u0006\u0010X\u001a\u00020\u00052\u0006\u0010b\u001a\u00020cH\u0002J?\u0010h\u001a\u00020U2\u0006\u0010i\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150k2\u0006\u0010l\u001a\u00020\u00152\b\b\u0002\u0010m\u001a\u00020(H@ø\u0001\u0000¢\u0006\u0002\u0010nJ$\u0010o\u001a\u00020U2\u0006\u0010p\u001a\u00020\u00152\b\b\u0002\u0010X\u001a\u00020\u00052\b\b\u0002\u0010q\u001a\u00020(H\u0002J\u000e\u0010r\u001a\u00020(2\u0006\u0010s\u001a\u00020cJ\u0006\u0010t\u001a\u00020(J\u0010\u0010u\u001a\u00020(2\u0006\u0010v\u001a\u00020CH\u0002J\u001b\u0010w\u001a\u0004\u0018\u00010E2\u0006\u0010x\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010yJ\b\u0010z\u001a\u00020UH\u0002J\b\u0010{\u001a\u00020UH\u0002J\b\u0010|\u001a\u00020\u0005H\u0002J2\u0010}\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u0002He0W0~\"\b\b\u0000\u0010e*\u00020E2\f\u0010\u001a\b\u0012\u0004\u0012\u0002He0WH\u0002JN\u0010\u0001\u001a\u001c\u0012\u0004\u0012\u00020$\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150k\u0018\u00010k2\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150k2\t\u0010\u0001\u001a\u0004\u0018\u00010\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J \u0010\u0001\u001a\u00020(2\u0007\u0010\u0001\u001a\u00020a2\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u0001H\u0002J\u0013\u0010\u0001\u001a\u00020UH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J8\u0010\u0001\u001a\u0004\u0018\u0001He\"\t\b\u0000\u0010e*\u00030\u00012\u0010\u0010\u0001\u001a\u000b\u0012\u0006\b\u0001\u0012\u0002He0\u00012\b\b\u0002\u0010X\u001a\u00020\u0005H\u0002¢\u0006\u0003\u0010\u0001J+\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010 2\u0006\u0010]\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u001f\u0010\u0001\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020\u00052\t\b\u0002\u0010\u0001\u001a\u00020(H\u0002J\u0007\u0010\u0001\u001a\u00020$J\u001b\u0010\u0001\u001a\u00020\u00152\u0007\u0010\u0001\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010yJ\u000b\u0010\u0001\u001a\u0004\u0018\u00010\u0006H\u0002J\u001e\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150k2\u0007\u0010\u0001\u001a\u00020\u0015H\u0002J\t\u0010\u0001\u001a\u00020(H\u0002J\u0019\u0010\u0001\u001a\t\u0012\u0004\u0012\u00020\f0\u00012\t\b\u0002\u0010\u0001\u001a\u00020(J8\u0010\u0001\u001a\u00020(2\u0006\u0010]\u001a\u00020\u00152\u0006\u0010^\u001a\u00020\u00152\t\b\u0002\u0010\u0001\u001a\u00020(2\b\b\u0002\u0010X\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0012\u0010\u0001\u001a\u00020U2\u0007\u0010 \u0001\u001a\u00020\u0005H\u0002J+\u0010¡\u0001\u001a\u00020$2\u0007\u0010¢\u0001\u001a\u00020(2\u0007\u0010£\u0001\u001a\u0002012\u0007\u0010¤\u0001\u001a\u0002012\u0007\u0010¥\u0001\u001a\u000201J+\u0010¦\u0001\u001a\u00020U2\t\b\u0002\u0010§\u0001\u001a\u00020(2\u000b\b\u0002\u0010¨\u0001\u001a\u0004\u0018\u00010\u0015H@ø\u0001\u0000¢\u0006\u0003\u0010©\u0001J4\u0010ª\u0001\u001a\u00020U2\u001f\u0010«\u0001\u001a\u001a\u0012\u0005\u0012\u00030¬\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0W0kj\u0003`­\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010®\u0001J4\u0010¯\u0001\u001a\u00020U2\u001f\u0010«\u0001\u001a\u001a\u0012\u0005\u0012\u00030¬\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0W0kj\u0003`­\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010®\u0001J4\u0010°\u0001\u001a\u00020U2\u001f\u0010«\u0001\u001a\u001a\u0012\u0005\u0012\u00030¬\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0W0kj\u0003`­\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010®\u0001J/\u0010±\u0001\u001a\u00020U2\u001a\u0010«\u0001\u001a\u0015\u0012\u0005\u0012\u00030¬\u0001\u0012\u0005\u0012\u00030²\u00010kj\u0003`³\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010®\u0001J\u0007\u0010´\u0001\u001a\u00020UJ\t\u0010µ\u0001\u001a\u00020UH\u0014J4\u0010¶\u0001\u001a\u00020U2\u001f\u0010·\u0001\u001a\u001a\u0012\u0005\u0012\u00030¬\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020E0W0kj\u0003`­\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010®\u0001J\u001b\u0010¸\u0001\u001a\u00020U2\u0007\u0010\u0001\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010yJ\u0007\u0010¹\u0001\u001a\u00020UJ\u0007\u0010º\u0001\u001a\u00020UJ\u0007\u0010»\u0001\u001a\u00020UJ\u0007\u0010¼\u0001\u001a\u00020UJ\u0011\u0010½\u0001\u001a\u00020U2\u0006\u0010X\u001a\u00020\u0005H\u0002J\u0012\u0010¾\u0001\u001a\u00020U2\u0007\u0010¿\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010À\u0001\u001a\u00020UJ\u0012\u0010Á\u0001\u001a\u00020U2\u0007\u0010Â\u0001\u001a\u00020\u0005H\u0002J\t\u0010Ã\u0001\u001a\u00020UH\u0002J\t\u0010Ä\u0001\u001a\u00020UH\u0002J\u0012\u0010Å\u0001\u001a\u00020U2\t\b\u0001\u0010Æ\u0001\u001a\u00020$J\u001b\u0010Ç\u0001\u001a\u00020U2\u0007\u0010È\u0001\u001a\u00020\u00052\u0007\u0010É\u0001\u001a\u00020\u0005H\u0002J\u0007\u0010Ê\u0001\u001a\u000201J\u0007\u0010Ë\u0001\u001a\u000201J\u001b\u0010Ì\u0001\u001a\u00020U2\u0006\u0010p\u001a\u0002012\b\b\u0002\u0010X\u001a\u00020\u0005H\u0002J\u0007\u0010Í\u0001\u001a\u000201J\u0007\u0010Î\u0001\u001a\u000201R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$0#¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u000e\u0010'\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020(X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010*\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001a\u0010.\u001a\u00020(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010+\"\u0004\b/\u0010-R\u000e\u00100\u001a\u000201X\u000e¢\u0006\u0002\n\u0000R \u00103\u001a\u0002012\u0006\u00102\u001a\u0002018F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0019\u00106\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010807¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010;\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010$07X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020?0>X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010@\u001a\b\u0012\u0004\u0012\u00020A0>X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010B\u001a\b\u0012\u0004\u0012\u00020C0>X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010D\u001a\b\u0012\u0004\u0012\u00020E0>X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010F\u001a\b\u0012\u0004\u0012\u00020(07¢\u0006\b\n\u0000\u001a\u0004\bG\u0010:R\u0017\u0010H\u001a\b\u0012\u0004\u0012\u00020(07¢\u0006\b\n\u0000\u001a\u0004\bI\u0010:R\u0012\u0010J\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0004\n\u0002\u0010KR\u0012\u0010L\u001a\u0004\u0018\u000101X\u000e¢\u0006\u0004\n\u0002\u0010KR\u0010\u0010M\u001a\u00020NX\u0004¢\u0006\u0004\n\u0002\u0010OR\u000e\u0010P\u001a\u00020QX\u0004¢\u0006\u0002\n\u0000R \u0010R\u001a\u0002012\u0006\u00102\u001a\u0002018F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u00105\u0002\u0004\n\u0002\b\u0019¨\u0006Ò\u0001"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "areas", "Landroid/util/ArrayMap;", "", "Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$AreaInfo;", "bgSet", "Lcom/microtech/aidexx/views/chart/dataset/BgDataSet;", "calSet", "Lcom/microtech/aidexx/views/chart/dataset/CalDataSet;", "combinedData", "Lcom/github/mikephil/charting/data/CombinedData;", "getCombinedData", "()Lcom/github/mikephil/charting/data/CombinedData;", "setCombinedData", "(Lcom/github/mikephil/charting/data/CombinedData;)V", "curGlucoseStateSets", "Lcom/microtech/aidexx/views/chart/dataset/CurrentGlucoseDataSet;", "curLabel", "curPageMinDate", "Ljava/util/Date;", "dateFormat", "Ljava/text/SimpleDateFormat;", "defaultLabel", "dstSet", "Lcom/microtech/aidexx/views/chart/dataset/DstDataSet;", "eventSet", "Lcom/microtech/aidexx/views/chart/dataset/IconDataSet;", "globalEndDate", "globalStartDate", "glucoseSets", "", "Lcom/github/mikephil/charting/data/LineDataSet;", "granularityFlow", "Lkotlinx/coroutines/flow/StateFlow;", "", "getGranularityFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "hasEventRefreshChart", "", "isDataAdded", "isDataInit", "()Z", "setDataInit", "(Z)V", "isDataLoaded", "setDataLoaded", "loadedMinDate", "", "<set-?>", "lowerLimit", "getLowerLimit", "()F", "mDataChangedFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$ChartChangedInfo;", "getMDataChangedFlow", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "mGranularityFlow", "maxOffset", "nextPageBgData", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "nextPageCalData", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "nextPageCgmData", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "nextPageEventData", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "startApplyNextPageData", "getStartApplyNextPageData", "startLoadNextPage", "getStartLoadNextPage", "timeMax", "Ljava/lang/Float;", "timeMin", "timerHandler", "com/microtech/aidexx/ui/main/home/chart/ChartViewModel$timerHandler$1", "Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$timerHandler$1;", "timezoneSet", "Lcom/microtech/aidexx/views/chart/dataset/TimezoneDataSet;", "upperLimit", "getUpperLimit", "addBgData", "", "bgs", "", "areaLabel", "addCalData", "calEntityList", "addCgmData", "cgmHistories", "startDate", "endDate", "addDst", "orderList", "Lcom/github/mikephil/charting/data/Entry;", "sensorId", "", "addEvent", "T", "es", "addTimezone", "addTmpArea", "label", "datePair", "Lkotlin/Pair;", "targetDate", "directToJump", "(JLkotlin/Pair;Ljava/util/Date;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calDateMaxMin", "dateTime", "isCgmData", "canMergeData", "dataUserId", "canRefreshChartImmediately", "checkCgmHistory", "cgm", "checkClosestEvent", "maxTime", "(Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearEventSets", "clearGlucoseSets", "curXMinTimeMillis", "dataListGroupByLabel", "", "dataList", "dealUnion", "tmpAreaDate", "oldAreaInfo", "defAreaInfo", "deleteEntry", "entry", "clazz", "Ljava/lang/Class;", "eventToRefreshChart", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findOrAddChartSetByLabel", "Lcom/github/mikephil/charting/interfaces/datasets/IScatterDataSet;", "(Ljava/lang/Class;J)Lcom/github/mikephil/charting/interfaces/datasets/IScatterDataSet;", "getCgmPageData", "(Ljava/util/Date;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurPageStartDate", "curTime", "isFromInit", "getGranularity", "getJumpDate", "tarJumpToDate", "getTmpArea", "getTmpAreaDate", "date", "hasNextPageData", "initData", "Lkotlinx/coroutines/flow/Flow;", "needReloadData", "loadNextPageData", "needApply", "(Ljava/util/Date;Ljava/util/Date;ZJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "mergeTmpToDefArea", "tmpLabel", "needLoadNextPage", "isLtr", "visibleLeftX", "visibleRightX", "xAxisMin", "notifyToRefreshChart", "needScrollToLatest", "jumpToDate", "(ZLjava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onBgDataChanged", "data", "Lcom/microtech/aidexx/utils/eventbus/DataChangedType;", "Lcom/microtech/aidexx/utils/eventbus/EventDataChangedInfo;", "(Lkotlin/Pair;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCalDataChanged", "onCgmDataChanged", "onCgmDataStateChanged", "Lcom/microtech/aidexx/utils/eventbus/CgmDataState;", "Lcom/microtech/aidexx/utils/eventbus/CgmDataStateChangedInfo;", "onChartToEndRight", "onCleared", "onEventDataChanged", "changedInfo", "onJumpToDate", "onUnitChanged", "refreshMax", "refreshTimezone", "reload", "removeFromChartSet", "resetChartMinTime", "curAreaLabel", "resetData", "resetDataByNewAreaLabel", "newAreaLabel", "resetNextPageData", "resetTimerToRefreshChart", "updateGranularity", "granularity", "updateLabelOfChartSet", "oldLabel", "newLabel", "xMargin", "xMax", "xMaxMin", "xMin", "xRange", "AreaInfo", "ChartChangedInfo", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ChartViewModel.kt */
public final class ChartViewModel extends ViewModel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long INTERVAL_REFRESH_WHEN_NO_EVENT = 300000;
    private static final int MSG_TIME_TO_REFRESH_CHART = 1;
    private static final String TAG = "ChartViewModel";
    /* access modifiers changed from: private */
    public final ArrayMap<Long, AreaInfo> areas;
    /* access modifiers changed from: private */
    public final BgDataSet bgSet = new BgDataSet();
    /* access modifiers changed from: private */
    public final CalDataSet calSet = new CalDataSet();
    public CombinedData combinedData;
    /* access modifiers changed from: private */
    public final CurrentGlucoseDataSet curGlucoseStateSets = new CurrentGlucoseDataSet();
    /* access modifiers changed from: private */
    public long curLabel;
    /* access modifiers changed from: private */
    public Date curPageMinDate;
    /* access modifiers changed from: private */
    public final SimpleDateFormat dateFormat;
    /* access modifiers changed from: private */
    public final long defaultLabel;
    /* access modifiers changed from: private */
    public final DstDataSet dstSet = new DstDataSet();
    /* access modifiers changed from: private */
    public final IconDataSet eventSet = new IconDataSet();
    /* access modifiers changed from: private */
    public Date globalEndDate;
    /* access modifiers changed from: private */
    public Date globalStartDate;
    /* access modifiers changed from: private */
    public final List<LineDataSet> glucoseSets = new CopyOnWriteArrayList();
    private final StateFlow<Integer> granularityFlow;
    /* access modifiers changed from: private */
    public volatile boolean hasEventRefreshChart;
    /* access modifiers changed from: private */
    public volatile boolean isDataAdded;
    private volatile boolean isDataInit;
    private volatile boolean isDataLoaded;
    private float loadedMinDate;
    private float lowerLimit;
    private final MutableStateFlow<ChartChangedInfo> mDataChangedFlow;
    private final MutableStateFlow<Integer> mGranularityFlow;
    private long maxOffset = new Date().getTime();
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<BloodGlucoseEntity> nextPageBgData;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<CalibrateEntity> nextPageCalData;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<RealCgmHistoryEntity> nextPageCgmData;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<BaseEventEntity> nextPageEventData;
    private final MutableStateFlow<Boolean> startApplyNextPageData;
    private final MutableStateFlow<Boolean> startLoadNextPage;
    /* access modifiers changed from: private */
    public Float timeMax;
    /* access modifiers changed from: private */
    public Float timeMin;
    private final ChartViewModel$timerHandler$1 timerHandler;
    /* access modifiers changed from: private */
    public final TimezoneDataSet timezoneSet = new TimezoneDataSet();
    private float upperLimit;

    public ChartViewModel() {
        MutableStateFlow<Integer> MutableStateFlow = StateFlowKt.MutableStateFlow(null);
        this.mGranularityFlow = MutableStateFlow;
        this.granularityFlow = FlowKt.asStateFlow(MutableStateFlow);
        this.startLoadNextPage = StateFlowKt.MutableStateFlow(false);
        this.startApplyNextPageData = StateFlowKt.MutableStateFlow(false);
        this.mDataChangedFlow = StateFlowKt.MutableStateFlow(null);
        this.loadedMinDate = -3.4028235E38f;
        this.curPageMinDate = new Date();
        LogUtil.Companion.xLogE("ChartViewModel init", TAG);
        LogUtil.Companion.d("ChartViewModel init", TAG);
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
        this.dateFormat = new SimpleDateFormat(ExtendsKt.DATE_FORMAT_YMDHMS, Locale.ENGLISH);
        this.upperLimit = GlucoseUtilKt.toGlucoseValue(180.0f);
        this.lowerLimit = GlucoseUtilKt.toGlucoseValue(70.200005f);
        this.nextPageCgmData = new CopyOnWriteArrayList<>();
        this.nextPageBgData = new CopyOnWriteArrayList<>();
        this.nextPageCalData = new CopyOnWriteArrayList<>();
        this.nextPageEventData = new CopyOnWriteArrayList<>();
        this.timerHandler = new ChartViewModel$timerHandler$1(this, Looper.getMainLooper());
        this.areas = new ArrayMap<>();
        this.curLabel = this.defaultLabel;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$Companion;", "", "()V", "INTERVAL_REFRESH_WHEN_NO_EVENT", "", "MSG_TIME_TO_REFRESH_CHART", "", "TAG", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChartViewModel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final CombinedData getCombinedData() {
        CombinedData combinedData2 = this.combinedData;
        if (combinedData2 != null) {
            return combinedData2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("combinedData");
        return null;
    }

    public final void setCombinedData(CombinedData combinedData2) {
        Intrinsics.checkNotNullParameter(combinedData2, "<set-?>");
        this.combinedData = combinedData2;
    }

    public final boolean isDataLoaded() {
        return this.isDataLoaded;
    }

    public final void setDataLoaded(boolean z) {
        this.isDataLoaded = z;
    }

    public final boolean isDataInit() {
        return this.isDataInit;
    }

    public final void setDataInit(boolean z) {
        this.isDataInit = z;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nR\u001a\u0010\t\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000b\"\u0004\b\u0013\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000b\"\u0004\b\u0015\u0010\rR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0010\n\u0002\u0010\u001a\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001b"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$ChartChangedInfo;", "", "timeMin", "", "needScrollToLatest", "", "needRequireResume", "jumpToDate", "Ljava/util/Date;", "isInit", "(Ljava/lang/Float;ZZLjava/util/Date;Z)V", "()Z", "setInit", "(Z)V", "getJumpToDate", "()Ljava/util/Date;", "setJumpToDate", "(Ljava/util/Date;)V", "getNeedRequireResume", "setNeedRequireResume", "getNeedScrollToLatest", "setNeedScrollToLatest", "getTimeMin", "()Ljava/lang/Float;", "setTimeMin", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ChartViewModel.kt */
    public static final class ChartChangedInfo {
        private boolean isInit;
        private Date jumpToDate;
        private boolean needRequireResume;
        private boolean needScrollToLatest;
        private Float timeMin;

        public ChartChangedInfo(Float f, boolean z, boolean z2, Date date, boolean z3) {
            this.timeMin = f;
            this.needScrollToLatest = z;
            this.needRequireResume = z2;
            this.jumpToDate = date;
            this.isInit = z3;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ChartChangedInfo(Float f, boolean z, boolean z2, Date date, boolean z3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : date, (i & 16) != 0 ? false : z3);
        }

        public final Float getTimeMin() {
            return this.timeMin;
        }

        public final void setTimeMin(Float f) {
            this.timeMin = f;
        }

        public final boolean getNeedScrollToLatest() {
            return this.needScrollToLatest;
        }

        public final void setNeedScrollToLatest(boolean z) {
            this.needScrollToLatest = z;
        }

        public final boolean getNeedRequireResume() {
            return this.needRequireResume;
        }

        public final void setNeedRequireResume(boolean z) {
            this.needRequireResume = z;
        }

        public final Date getJumpToDate() {
            return this.jumpToDate;
        }

        public final void setJumpToDate(Date date) {
            this.jumpToDate = date;
        }

        public final boolean isInit() {
            return this.isInit;
        }

        public final void setInit(boolean z) {
            this.isInit = z;
        }
    }

    public final int getGranularity() {
        Integer value = this.mGranularityFlow.getValue();
        if (value != null) {
            return value.intValue();
        }
        return 1;
    }

    public final StateFlow<Integer> getGranularityFlow() {
        return this.granularityFlow;
    }

    public final MutableStateFlow<Boolean> getStartLoadNextPage() {
        return this.startLoadNextPage;
    }

    public final MutableStateFlow<Boolean> getStartApplyNextPageData() {
        return this.startApplyNextPageData;
    }

    public final MutableStateFlow<ChartChangedInfo> getMDataChangedFlow() {
        return this.mDataChangedFlow;
    }

    public final void updateGranularity(@MyChart.ChartGranularityPerScreen int i) {
        this.mGranularityFlow.setValue(Integer.valueOf(i));
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.ui.main.home.chart.ChartViewModel$1", f = "ChartViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.ui.main.home.chart.ChartViewModel$1  reason: invalid class name */
    /* compiled from: ChartViewModel.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ ChartViewModel this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, continuation);
            r0.L$0 = obj;
            return r0;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                final ChartViewModel chartViewModel = this.this$0;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new Function2<CoroutineScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    int label;

                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        return 

                        public static /* synthetic */ Flow initData$default(ChartViewModel chartViewModel, boolean z, int i, Object obj) {
                            if ((i & 1) != 0) {
                                z = false;
                            }
                            return chartViewModel.initData(z);
                        }

                        public final Flow<CombinedData> initData(boolean z) {
                            return FlowKt.flowOn(FlowKt.flow(new ChartViewModel$initData$1(this, z, (Continuation<? super ChartViewModel$initData$1>) null)), Dispatchers.getIO());
                        }

                        public final void reload() {
                            LogUtil.Companion.d("reload()", TAG);
                            if (this.isDataInit) {
                                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                if (this.startApplyNextPageData.getValue().booleanValue()) {
                                    Dialogs.INSTANCE.showWait(ExtendsKt.getContext().getString(R.string.com_loading));
                                    objectRef.element = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$reload$1(this, objectRef, (Continuation<? super ChartViewModel$reload$1>) null), 3, (Object) null);
                                    return;
                                }
                                reload$startReset(this);
                            }
                        }

                        /* access modifiers changed from: private */
                        public static final void reload$startReset(ChartViewModel chartViewModel) {
                            chartViewModel.resetData();
                            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(chartViewModel), (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$reload$startReset$1(chartViewModel, (Continuation<? super ChartViewModel$reload$startReset$1>) null), 3, (Object) null);
                        }

                        public final int needLoadNextPage(boolean z, float f, float f2, float f3) {
                            AreaInfo areaInfo;
                            float f4 = f2;
                            float f5 = f3;
                            int i = 0;
                            if (!this.isDataInit) {
                                return 0;
                            }
                            if (z) {
                                long j = this.curLabel;
                                if (j == this.defaultLabel || (areaInfo = this.areas.get(Long.valueOf(j))) == null || f4 - areaInfo.getMaxX() < 0.0f || areaInfo.isLoadingRightPage()) {
                                    return 0;
                                }
                                areaInfo.setLoadingRightPage(true);
                                LogUtil.Companion.d("触发右分页 visibleRightX=" + f4 + " area=" + areaInfo, TAG);
                                Date date = new Date();
                                date.setTime(areaInfo.getMaxTs() + 1);
                                Ref.ObjectRef objectRef = new Ref.ObjectRef();
                                T date2 = new Date();
                                date2.setTime(areaInfo.getMaxTs() + 172800000);
                                objectRef.element = date2;
                                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$needLoadNextPage$1$1(this, date, objectRef, areaInfo, (Continuation<? super ChartViewModel$needLoadNextPage$1$1>) null), 3, (Object) null);
                                return -1;
                            } else if (this.loadedMinDate == f5 && hasNextPageData()) {
                                return 0;
                            } else {
                                float f6 = f;
                                if (Math.abs(ChartUtil.INSTANCE.xToSecond(f) - ChartUtil.INSTANCE.xToSecond(f5)) <= 172800) {
                                    i = 1;
                                }
                                if (i != 0) {
                                    this.loadedMinDate = f5;
                                }
                                return i;
                            }
                        }

                        public final Object onCgmDataChanged(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, Continuation<? super Unit> continuation) {
                            return BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$onCgmDataChanged$2(pair, this, (Continuation<? super ChartViewModel$onCgmDataChanged$2>) null), continuation);
                        }

                        public final Object onCgmDataStateChanged(Pair<? extends DataChangedType, CgmDataState> pair, Continuation<? super Unit> continuation) {
                            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$onCgmDataStateChanged$2(pair, this, (Continuation<? super ChartViewModel$onCgmDataStateChanged$2>) null), continuation);
                            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                        }

                        public final Object onBgDataChanged(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, Continuation<? super Unit> continuation) {
                            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$onBgDataChanged$2(pair, this, (Continuation<? super ChartViewModel$onBgDataChanged$2>) null), continuation);
                            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                        }

                        public final Object onCalDataChanged(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, Continuation<? super Unit> continuation) {
                            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$onCalDataChanged$2(pair, this, (Continuation<? super ChartViewModel$onCalDataChanged$2>) null), continuation);
                            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                        }

                        public final Object onEventDataChanged(Pair<? extends DataChangedType, ? extends List<? extends BaseEventEntity>> pair, Continuation<? super Unit> continuation) {
                            Object withContext = BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$onEventDataChanged$2(pair, this, (Continuation<? super ChartViewModel$onEventDataChanged$2>) null), continuation);
                            return withContext == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? withContext : Unit.INSTANCE;
                        }

                        public final void onChartToEndRight() {
                            if (this.hasEventRefreshChart || hasNextPageData()) {
                                this.startApplyNextPageData.compareAndSet(false, true);
                            }
                        }

                        public final boolean canRefreshChartImmediately() {
                            resetTimerToRefreshChart();
                            if (!this.hasEventRefreshChart && !hasNextPageData()) {
                                return true;
                            }
                            LogUtil.Companion.xLogI("刷新图表时发现有下一页数据还在内存 合并后再刷新", TAG);
                            this.startApplyNextPageData.compareAndSet(false, true);
                            return false;
                        }

                        /* access modifiers changed from: private */
                        public final Object eventToRefreshChart(Continuation<? super Unit> continuation) {
                            if (this.startApplyNextPageData.getValue().booleanValue() || hasNextPageData()) {
                                this.hasEventRefreshChart = true;
                                LogUtil.Companion.xLogE("等一页数据处理完成再一起刷新", TAG);
                                return Unit.INSTANCE;
                            }
                            Object notifyToRefreshChart$default = notifyToRefreshChart$default(this, false, (Date) null, continuation, 3, (Object) null);
                            return notifyToRefreshChart$default == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? notifyToRefreshChart$default : Unit.INSTANCE;
                        }

                        /* access modifiers changed from: private */
                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
                        /* JADX WARNING: Removed duplicated region for block: B:18:0x0074  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object notifyToRefreshChart(boolean r13, java.util.Date r14, kotlin.coroutines.Continuation<? super kotlin.Unit> r15) {
                            /*
                                r12 = this;
                                boolean r0 = r15 instanceof com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r15
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$1 r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r15 = r0.label
                                int r15 = r15 - r2
                                r0.label = r15
                                goto L_0x0019
                            L_0x0014:
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$1 r0 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$1
                                r0.<init>(r12, r15)
                            L_0x0019:
                                java.lang.Object r15 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L_0x0036
                                if (r2 != r3) goto L_0x002e
                                java.lang.Object r13 = r0.L$0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r13 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r13
                                kotlin.ResultKt.throwOnFailure(r15)
                                goto L_0x0070
                            L_0x002e:
                                java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                                java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                                r13.<init>(r14)
                                throw r13
                            L_0x0036:
                                kotlin.ResultKt.throwOnFailure(r15)
                                com.microtech.aidexx.utils.LogUtil$Companion r15 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                java.lang.String r4 = "curLabel="
                                r2.<init>(r4)
                                long r4 = r12.curLabel
                                java.lang.StringBuilder r2 = r2.append(r4)
                                java.lang.String r2 = r2.toString()
                                java.lang.String r4 = "ChartViewModel"
                                r15.xLogI(r2, r4)
                                kotlinx.coroutines.flow.MutableStateFlow<com.microtech.aidexx.ui.main.home.chart.ChartViewModel$ChartChangedInfo> r15 = r12.mDataChangedFlow
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$ChartChangedInfo r2 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$ChartChangedInfo
                                java.lang.Float r5 = r12.timeMin
                                boolean r4 = r12.isDataAdded
                                r9 = r4 ^ 1
                                r10 = 4
                                r11 = 0
                                r7 = 0
                                r4 = r2
                                r6 = r13
                                r8 = r14
                                r4.<init>(r5, r6, r7, r8, r9, r10, r11)
                                r0.L$0 = r12
                                r0.label = r3
                                java.lang.Object r13 = r15.emit(r2, r0)
                                if (r13 != r1) goto L_0x006f
                                return r1
                            L_0x006f:
                                r13 = r12
                            L_0x0070:
                                boolean r14 = r13.isDataLoaded
                                if (r14 != 0) goto L_0x008b
                                r14 = r13
                                androidx.lifecycle.ViewModel r14 = (androidx.lifecycle.ViewModel) r14
                                kotlinx.coroutines.CoroutineScope r0 = androidx.lifecycle.ViewModelKt.getViewModelScope(r14)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$2 r14 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$notifyToRefreshChart$2
                                r15 = 0
                                r14.<init>(r13, r15)
                                r3 = r14
                                kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
                                r4 = 3
                                r5 = 0
                                r1 = 0
                                r2 = 0
                                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r0, r1, r2, r3, r4, r5)
                            L_0x008b:
                                kotlin.Unit r13 = kotlin.Unit.INSTANCE
                                return r13
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.notifyToRefreshChart(boolean, java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        static /* synthetic */ Object notifyToRefreshChart$default(ChartViewModel chartViewModel, boolean z, Date date, Continuation continuation, int i, Object obj) {
                            if ((i & 1) != 0) {
                                z = false;
                            }
                            if ((i & 2) != 0) {
                                date = null;
                            }
                            return chartViewModel.notifyToRefreshChart(z, date, continuation);
                        }

                        /* access modifiers changed from: private */
                        public final boolean hasNextPageData() {
                            return !this.nextPageCgmData.isEmpty() || !this.nextPageBgData.isEmpty() || !this.nextPageCalData.isEmpty() || !this.nextPageEventData.isEmpty();
                        }

                        private final void resetNextPageData() {
                            this.nextPageCgmData.clear();
                            this.nextPageBgData.clear();
                            this.nextPageCalData.clear();
                            this.nextPageEventData.clear();
                        }

                        /* access modifiers changed from: private */
                        public final Object checkClosestEvent(Date date, Continuation<? super BaseEventEntity> continuation) {
                            return BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$checkClosestEvent$2(date, (Continuation<? super ChartViewModel$checkClosestEvent$2>) null), continuation);
                        }

                        public final float xRange() {
                            return ((float) getGranularity()) * 6.0f;
                        }

                        public final float xMargin() {
                            int granularity = getGranularity();
                            if (granularity != 1) {
                                return granularity != 2 ? 2.2f : 1.0f;
                            }
                            return 0.5f;
                        }

                        public final float xMin() {
                            float xMax = xMax() - xRange();
                            Float f = this.timeMin;
                            if (f == null) {
                                return xMax;
                            }
                            Intrinsics.checkNotNull(f);
                            if (f.floatValue() > xMax) {
                                return xMax;
                            }
                            Float f2 = this.timeMin;
                            Intrinsics.checkNotNull(f2);
                            return f2.floatValue();
                        }

                        public final float xMax() {
                            float f;
                            float f2;
                            TimeZone timeZone = TimeZone.getDefault();
                            LogUtil.Companion.d("margin=" + xMargin(), "xMarginxMarginxMargin");
                            long j = (long) 1000;
                            float secondToX = ChartUtil.INSTANCE.secondToX((new Date().getTime() / j) + ((long) (timeZone.getDSTSavings() / 1000)));
                            float secondToX2 = ChartUtil.INSTANCE.secondToX(new Date().getTime() / j);
                            if (!this.isDataAdded || this.timeMax == null) {
                                return timeZone.inDaylightTime(new Date()) ? xMargin() + secondToX : xMargin() + secondToX2;
                            }
                            if (timeZone.inDaylightTime(new Date())) {
                                Float f3 = this.timeMax;
                                Intrinsics.checkNotNull(f3);
                                f2 = Math.max(f3.floatValue(), secondToX);
                                f = xMargin();
                            } else {
                                Float f4 = this.timeMax;
                                Intrinsics.checkNotNull(f4);
                                f2 = Math.max(f4.floatValue(), secondToX2);
                                f = xMargin();
                            }
                            return f2 + f;
                        }

                        public final float getUpperLimit() {
                            return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHyper());
                        }

                        public final float getLowerLimit() {
                            return GlucoseUtilKt.toGlucoseValue(ThresholdManager.INSTANCE.getCurUserHypo());
                        }

                        static /* synthetic */ Object loadNextPageData$default(ChartViewModel chartViewModel, Date date, Date date2, boolean z, long j, Continuation continuation, int i, Object obj) {
                            if ((i & 4) != 0) {
                                z = true;
                            }
                            boolean z2 = z;
                            if ((i & 8) != 0) {
                                j = chartViewModel.defaultLabel;
                            }
                            return chartViewModel.loadNextPageData(date, date2, z2, j, continuation);
                        }

                        /* access modifiers changed from: private */
                        public final Object loadNextPageData(Date date, Date date2, boolean z, long j, Continuation<? super Boolean> continuation) {
                            return BuildersKt.withContext(Dispatchers.getIO(), new ChartViewModel$loadNextPageData$2(j, date, date2, this, z, (Continuation<? super ChartViewModel$loadNextPageData$2>) null), continuation);
                        }

                        private final long curXMinTimeMillis() {
                            ChartUtil chartUtil = ChartUtil.INSTANCE;
                            Float f = this.timeMin;
                            return chartUtil.xToSecond(f != null ? f.floatValue() : 0.0f) * ((long) 1000);
                        }

                        /* access modifiers changed from: private */
                        public final Object getCgmPageData(Date date, Date date2, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
                            this.dateFormat.setTimeZone(TimeUtils.INSTANCE.getCDFTimezone());
                            LogUtil.Companion.d$default(LogUtil.Companion, "LoadNext ->  " + this.dateFormat.format(date) + " - " + this.dateFormat.format(date2), (String) null, 2, (Object) null);
                            CgmCalibBgRepository cgmCalibBgRepository = CgmCalibBgRepository.INSTANCE;
                            String format = this.dateFormat.format(date);
                            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                            String format2 = this.dateFormat.format(date2);
                            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
                            return cgmCalibBgRepository.queryCgmByPage(format, format2, UserInfoManager.Companion.getCurShowUserId(), continuation);
                        }

                        static /* synthetic */ Date getCurPageStartDate$default(ChartViewModel chartViewModel, long j, boolean z, int i, Object obj) {
                            if ((i & 1) != 0) {
                                j = System.currentTimeMillis();
                            }
                            if ((i & 2) != 0) {
                                z = false;
                            }
                            return chartViewModel.getCurPageStartDate(j, z);
                        }

                        /* access modifiers changed from: private */
                        public final Date getCurPageStartDate(long j, boolean z) {
                            return new Date(j - (((long) (z ? 19 : 4)) * TimeUtils.oneDayMillis));
                        }

                        private final void clearEventSets() {
                            this.bgSet.clear();
                            this.eventSet.clear();
                        }

                        private final void clearGlucoseSets() {
                            this.glucoseSets.clear();
                            this.calSet.clear();
                            this.timezoneSet.clear();
                            this.dstSet.clear();
                            this.curGlucoseStateSets.clear();
                            this.timeMin = null;
                            this.timeMax = null;
                        }

                        public final void resetData() {
                            LogUtil.Companion.d("reset data1", TAG);
                            clearEventSets();
                            clearGlucoseSets();
                            getCombinedData().getLineData().clearValues();
                            getCombinedData().getScatterData().clearValues();
                            getCombinedData().clearValues();
                            resetNextPageData();
                            this.startLoadNextPage.compareAndSet(true, false);
                            this.loadedMinDate = -3.4028235E38f;
                            this.curPageMinDate = new Date();
                            LogUtil.Companion.d("reset data2", TAG);
                        }

                        public final void onUnitChanged() {
                            Entry entry;
                            Float glucoseValueMg;
                            List entries = this.curGlucoseStateSets.getEntries();
                            if (entries != null) {
                                Collection collection = entries;
                                if (collection.isEmpty()) {
                                    collection = null;
                                }
                                List list = (List) collection;
                                if (!(list == null || (entry = (Entry) CollectionsKt.last(list)) == null)) {
                                    Intrinsics.checkNotNull(entry);
                                    CgmDataState cgmDataState = (CgmDataState) entry.getData();
                                    if (!(cgmDataState == null || (glucoseValueMg = cgmDataState.getGlucoseValueMg()) == null)) {
                                        glucoseValueMg.floatValue();
                                        float y = entry.getY();
                                        entry.setY(GlucoseUtilKt.toGlucoseValue(cgmDataState.getGlucoseValueMg().floatValue()));
                                        LogUtil.Companion.xLogI("onUnitChanged " + y + " -> " + entry.getY(), TAG);
                                    }
                                }
                            }
                            reload();
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.lang.String} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v40, resolved type: java.util.List} */
                        /* JADX WARNING: type inference failed for: r9v34, types: [kotlin.Unit] */
                        /* access modifiers changed from: private */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:118:0x0352  */
                        /* JADX WARNING: Removed duplicated region for block: B:129:0x03cc  */
                        /* JADX WARNING: Removed duplicated region for block: B:139:0x0435  */
                        /* JADX WARNING: Removed duplicated region for block: B:142:0x043d  */
                        /* JADX WARNING: Removed duplicated region for block: B:144:0x0440  */
                        /* JADX WARNING: Removed duplicated region for block: B:148:0x0457 A[LOOP:8: B:146:0x0451->B:148:0x0457, LOOP_END] */
                        /* JADX WARNING: Removed duplicated region for block: B:89:0x021a  */
                        /* JADX WARNING: Removed duplicated region for block: B:95:0x0238  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void addCgmData(java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity> r33, long r34, java.util.Date r36, java.util.Date r37) {
                            /*
                                r32 = this;
                                r0 = r32
                                r1 = r34
                                r3 = r36
                                r4 = r37
                                r5 = 1
                                if (r3 == 0) goto L_0x000e
                                r0.calDateMaxMin(r3, r1, r5)
                            L_0x000e:
                                if (r4 == 0) goto L_0x0013
                                r0.calDateMaxMin(r4, r1, r5)
                            L_0x0013:
                                boolean r3 = r33.isEmpty()
                                if (r3 == 0) goto L_0x001a
                                return
                            L_0x001a:
                                java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
                                r3.<init>()
                                java.util.Map r3 = (java.util.Map) r3
                                r4 = r33
                                java.lang.Iterable r4 = (java.lang.Iterable) r4
                                java.util.Iterator r4 = r4.iterator()
                            L_0x0029:
                                boolean r6 = r4.hasNext()
                                r7 = -1
                                r8 = 0
                                r9 = 0
                                if (r6 == 0) goto L_0x00a4
                                java.lang.Object r6 = r4.next()
                                com.microtech.aidexx.db.entity.RealCgmHistoryEntity r6 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r6
                                java.lang.String r10 = r6.getUserId()
                                java.lang.String r11 = "ChartViewModel"
                                if (r10 == 0) goto L_0x009a
                                boolean r10 = r0.canMergeData(r10)
                                if (r10 != 0) goto L_0x0051
                                com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.String r2 = "正在把cgm数据合并到chart 发现换人了"
                                r1.xLogE(r2, r11)
                                r32.resetData()
                                return
                            L_0x0051:
                                boolean r10 = r6.isGlucoseIsValid()
                                if (r10 == 0) goto L_0x0098
                                java.lang.Float r10 = r6.getGlucose()
                                if (r10 == 0) goto L_0x0098
                                int r10 = r6.getEventWarning()
                                if (r10 == r7) goto L_0x0098
                                r7 = r6
                                com.microtech.aidexx.db.entity.BaseEventEntity r7 = (com.microtech.aidexx.db.entity.BaseEventEntity) r7
                                com.microtech.aidexx.views.chart.dataset.ChartEntry r7 = com.microtech.aidexx.views.chart.dataset.EventEntryConverterKt.toChartEntry$default(r7, r9, r5, r9)
                                java.lang.String r9 = r6.getSensorId()
                                if (r9 == 0) goto L_0x0091
                                java.lang.String r6 = r6.genChartSetLabel()
                                boolean r9 = r3.containsKey(r6)
                                if (r9 == 0) goto L_0x0086
                                java.lang.Object r6 = r3.get(r6)
                                java.util.List r6 = (java.util.List) r6
                                if (r6 == 0) goto L_0x0091
                                r6.add(r7)
                                goto L_0x0091
                            L_0x0086:
                                com.github.mikephil.charting.data.Entry[] r9 = new com.github.mikephil.charting.data.Entry[r5]
                                r9[r8] = r7
                                java.util.List r8 = kotlin.collections.CollectionsKt.mutableListOf(r9)
                                r3.put(r6, r8)
                            L_0x0091:
                                float r6 = r7.getX()
                                r0.xMaxMin(r6, r1)
                            L_0x0098:
                                kotlin.Unit r9 = kotlin.Unit.INSTANCE
                            L_0x009a:
                                if (r9 != 0) goto L_0x0029
                                com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.String r7 = "cgm data userid null"
                                r6.d(r7, r11)
                                goto L_0x0029
                            L_0x00a4:
                                boolean r4 = r3.isEmpty()
                                if (r4 != 0) goto L_0x04a1
                                java.util.ArrayList r4 = new java.util.ArrayList
                                int r6 = r3.size()
                                r4.<init>(r6)
                                java.util.Collection r4 = (java.util.Collection) r4
                                java.util.Set r3 = r3.entrySet()
                                java.util.Iterator r3 = r3.iterator()
                            L_0x00bd:
                                boolean r6 = r3.hasNext()
                                if (r6 == 0) goto L_0x049b
                                java.lang.Object r6 = r3.next()
                                java.util.Map$Entry r6 = (java.util.Map.Entry) r6
                                java.lang.Object r10 = r6.getValue()
                                java.util.List r10 = (java.util.List) r10
                                java.lang.Object r6 = r6.getKey()
                                java.lang.String r6 = (java.lang.String) r6
                                com.github.mikephil.charting.data.CombinedData r11 = r32.getCombinedData()
                                com.github.mikephil.charting.data.LineData r11 = r11.getLineData()
                                r12 = 2
                                if (r11 != 0) goto L_0x00f4
                                com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.String r10 = "combinedData.lineData == null"
                                com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r10, r9, r12, r9)
                            L_0x00e7:
                                r20 = r3
                                r23 = r4
                                r6 = r8
                                r3 = r0
                                r30 = r1
                                r2 = r5
                                r4 = r30
                                goto L_0x0487
                            L_0x00f4:
                                com.github.mikephil.charting.data.CombinedData r11 = r32.getCombinedData()
                                com.github.mikephil.charting.data.LineData r11 = r11.getLineData()
                                if (r11 == 0) goto L_0x0103
                                java.util.List r11 = r11.getDataSets()
                                goto L_0x0104
                            L_0x0103:
                                r11 = r9
                            L_0x0104:
                                if (r11 != 0) goto L_0x010e
                                com.microtech.aidexx.utils.LogUtil$Companion r6 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.String r10 = "combinedData.lineData.dataSets == null"
                                com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r6, r10, r9, r12, r9)
                                goto L_0x00e7
                            L_0x010e:
                                java.lang.StringBuilder r11 = new java.lang.StringBuilder
                                r11.<init>()
                                java.lang.StringBuilder r11 = r11.append(r1)
                                r13 = 42
                                java.lang.StringBuilder r11 = r11.append(r13)
                                java.lang.StringBuilder r6 = r11.append(r6)
                                java.lang.String r6 = r6.toString()
                                com.github.mikephil.charting.data.CombinedData r11 = r32.getCombinedData()
                                com.github.mikephil.charting.data.LineData r11 = r11.getLineData()
                                if (r11 == 0) goto L_0x0162
                                java.util.List r11 = r11.getDataSets()
                                if (r11 == 0) goto L_0x0162
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r11)
                                java.lang.Iterable r11 = (java.lang.Iterable) r11
                                java.util.Iterator r11 = r11.iterator()
                            L_0x013e:
                                boolean r14 = r11.hasNext()
                                if (r14 == 0) goto L_0x015e
                                java.lang.Object r14 = r11.next()
                                r15 = r14
                                com.github.mikephil.charting.interfaces.datasets.ILineDataSet r15 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r15
                                boolean r9 = r15 instanceof com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
                                if (r9 == 0) goto L_0x015c
                                com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r15 = (com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine) r15
                                java.lang.String r9 = r15.getLabel()
                                boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r9, (java.lang.Object) r6)
                                if (r9 == 0) goto L_0x015c
                                goto L_0x015f
                            L_0x015c:
                                r9 = 0
                                goto L_0x013e
                            L_0x015e:
                                r14 = 0
                            L_0x015f:
                                com.github.mikephil.charting.interfaces.datasets.ILineDataSet r14 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r14
                                goto L_0x0163
                            L_0x0162:
                                r14 = 0
                            L_0x0163:
                                com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r14 = (com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine) r14
                                if (r14 != 0) goto L_0x0192
                                r9 = r0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r9 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r9
                                com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r14 = new com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
                                r14.<init>()
                                r14.setLabel(r6)
                                com.microtech.aidexx.views.chart.GlucoseChart$Companion r9 = com.microtech.aidexx.views.chart.GlucoseChart.Companion
                                java.util.List r11 = kotlin.collections.CollectionsKt.listOf(r14)
                                float r15 = r32.getLowerLimit()
                                float r13 = r32.getUpperLimit()
                                r9.formatGlucoseSetAfterInitData(r11, r15, r13)
                                com.github.mikephil.charting.data.CombinedData r9 = r32.getCombinedData()
                                com.github.mikephil.charting.data.LineData r9 = r9.getLineData()
                                java.util.List r9 = r9.getDataSets()
                                r9.add(r14)
                            L_0x0192:
                                int r9 = r10.size()
                                if (r9 != r5) goto L_0x0205
                                java.util.List r9 = r14.getEntries()
                                if (r9 == 0) goto L_0x0205
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                                java.util.Collection r9 = (java.util.Collection) r9
                                boolean r11 = r9.isEmpty()
                                if (r11 == 0) goto L_0x01aa
                                r9 = 0
                            L_0x01aa:
                                java.util.List r9 = (java.util.List) r9
                                if (r9 == 0) goto L_0x0205
                                com.github.mikephil.charting.data.Entry[] r11 = new com.github.mikephil.charting.data.Entry[r5]
                                java.lang.Object r13 = kotlin.collections.CollectionsKt.first(r10)
                                r11[r8] = r13
                                java.util.List r11 = kotlin.collections.CollectionsKt.mutableListOf(r11)
                                r13 = 30
                                java.util.List r9 = kotlin.collections.CollectionsKt.takeLast(r9, r13)
                                int r13 = kotlin.collections.CollectionsKt.getLastIndex(r9)
                            L_0x01c4:
                                if (r7 >= r13) goto L_0x01f4
                                java.lang.Object r15 = kotlin.collections.CollectionsKt.first(r11)
                                com.github.mikephil.charting.data.Entry r15 = (com.github.mikephil.charting.data.Entry) r15
                                float r15 = r15.getX()
                                java.lang.Object r16 = r9.get(r13)
                                com.github.mikephil.charting.data.Entry r16 = (com.github.mikephil.charting.data.Entry) r16
                                float r16 = r16.getX()
                                float r15 = r15 - r16
                                float r16 = r14.getBreakInterval()
                                int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
                                if (r15 > 0) goto L_0x01f4
                                java.lang.Object r15 = r9.get(r13)
                                java.lang.String r7 = "get(...)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r15, r7)
                                r11.add(r8, r15)
                                int r13 = r13 + -1
                                r7 = -1
                                goto L_0x01c4
                            L_0x01f4:
                                int r7 = r11.size()
                                r9 = 5
                                if (r7 < r9) goto L_0x0205
                                r10.clear()
                                java.util.Collection r11 = (java.util.Collection) r11
                                r10.addAll(r11)
                                r7 = r5
                                goto L_0x0206
                            L_0x0205:
                                r7 = r8
                            L_0x0206:
                                r9 = r10
                                java.lang.Iterable r9 = (java.lang.Iterable) r9
                                int r11 = r10.size()
                                float[] r13 = new float[r11]
                                java.util.Iterator r9 = r9.iterator()
                                r15 = r8
                            L_0x0214:
                                boolean r16 = r9.hasNext()
                                if (r16 == 0) goto L_0x0230
                                java.lang.Object r16 = r9.next()
                                int r17 = r15 + 1
                                if (r15 >= 0) goto L_0x0225
                                kotlin.collections.CollectionsKt.throwIndexOverflow()
                            L_0x0225:
                                com.github.mikephil.charting.data.Entry r16 = (com.github.mikephil.charting.data.Entry) r16
                                float r16 = r16.getY()
                                r13[r15] = r16
                                r15 = r17
                                goto L_0x0214
                            L_0x0230:
                                r9 = 31
                                float[] r9 = com.microtechmd.cgat.CGATools.smoothGauss(r13, r11, r9)
                                if (r7 == 0) goto L_0x0352
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                                int r7 = r9.length
                                r13 = r8
                                r15 = r13
                            L_0x023e:
                                if (r13 >= r7) goto L_0x034d
                                r12 = r9[r13]
                                int r17 = r15 + 1
                                java.lang.Object r18 = r10.get(r15)
                                r8 = r18
                                com.github.mikephil.charting.data.Entry r8 = (com.github.mikephil.charting.data.Entry) r8
                                int r11 = r9.length
                                int r11 = r11 - r5
                                java.lang.String r5 = "null cannot be cast to non-null type kotlin.Long"
                                r20 = r3
                                java.lang.String r3 = "null cannot be cast to non-null type kotlin.Pair<*, *>"
                                r21 = r7
                                java.lang.String r7 = "null cannot be cast to non-null type com.microtech.aidexx.db.entity.RealCgmHistoryEntity"
                                if (r15 != r11) goto L_0x02c3
                                java.lang.Object r11 = r8.getData()
                                boolean r15 = r11 instanceof com.microtech.aidexx.db.entity.RealCgmHistoryEntity
                                if (r15 == 0) goto L_0x0271
                                java.lang.Object r3 = r8.getData()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r7)
                                com.microtech.aidexx.db.entity.RealCgmHistoryEntity r3 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r3
                                long r22 = r3.convertToCurZoneTs()
                            L_0x026f:
                                r11 = r4
                                goto L_0x029c
                            L_0x0271:
                                boolean r7 = r11 instanceof kotlin.Pair
                                if (r7 == 0) goto L_0x028c
                                java.lang.Object r7 = r8.getData()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r3)
                                kotlin.Pair r7 = (kotlin.Pair) r7
                                java.lang.Object r3 = r7.getFirst()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
                                java.lang.Long r3 = (java.lang.Long) r3
                                long r22 = r3.longValue()
                                goto L_0x026f
                            L_0x028c:
                                com.microtech.aidexx.views.chart.ChartUtil r3 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                float r5 = r8.getX()
                                long r22 = r3.xToSecond(r5)
                                r11 = r4
                                r3 = 1000(0x3e8, float:1.401E-42)
                                long r4 = (long) r3
                                long r22 = r22 * r4
                            L_0x029c:
                                java.lang.Long r3 = java.lang.Long.valueOf(r22)
                                float r4 = r8.getY()
                                java.lang.Float r4 = java.lang.Float.valueOf(r4)
                                kotlin.Pair r3 = kotlin.TuplesKt.to(r3, r4)
                                r8.setData(r3)
                                r8.setY(r12)
                                r4 = 1
                                com.github.mikephil.charting.data.Entry[] r3 = new com.github.mikephil.charting.data.Entry[r4]
                                r5 = 0
                                r3[r5] = r8
                                java.util.List r3 = kotlin.collections.CollectionsKt.mutableListOf(r3)
                                r14.addEntries(r3)
                                r23 = r11
                                goto L_0x033a
                            L_0x02c3:
                                r11 = r4
                                java.util.List r4 = r14.getEntries()
                                java.util.List r22 = r14.getEntries()
                                int r22 = r22.size()
                                r19 = 1
                                int r22 = r22 + -1
                                r23 = r11
                                int r11 = r9.length
                                r16 = 2
                                int r11 = r11 + -2
                                int r11 = r11 - r15
                                int r11 = r22 - r11
                                java.lang.Object r4 = r4.get(r11)
                                com.github.mikephil.charting.data.Entry r4 = (com.github.mikephil.charting.data.Entry) r4
                                java.lang.Object r11 = r8.getData()
                                boolean r15 = r11 instanceof com.microtech.aidexx.db.entity.RealCgmHistoryEntity
                                if (r15 == 0) goto L_0x02fa
                                java.lang.Object r3 = r8.getData()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r7)
                                com.microtech.aidexx.db.entity.RealCgmHistoryEntity r3 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r3
                                long r24 = r3.convertToCurZoneTs()
                                goto L_0x0324
                            L_0x02fa:
                                boolean r7 = r11 instanceof kotlin.Pair
                                if (r7 == 0) goto L_0x0315
                                java.lang.Object r7 = r8.getData()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r3)
                                kotlin.Pair r7 = (kotlin.Pair) r7
                                java.lang.Object r3 = r7.getFirst()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
                                java.lang.Long r3 = (java.lang.Long) r3
                                long r24 = r3.longValue()
                                goto L_0x0324
                            L_0x0315:
                                com.microtech.aidexx.views.chart.ChartUtil r3 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                float r5 = r8.getX()
                                long r24 = r3.xToSecond(r5)
                                r3 = 1000(0x3e8, float:1.401E-42)
                                long r0 = (long) r3
                                long r24 = r24 * r0
                            L_0x0324:
                                java.lang.Long r0 = java.lang.Long.valueOf(r24)
                                float r1 = r8.getY()
                                java.lang.Float r1 = java.lang.Float.valueOf(r1)
                                kotlin.Pair r0 = kotlin.TuplesKt.to(r0, r1)
                                r4.setData(r0)
                                r4.setY(r12)
                            L_0x033a:
                                int r13 = r13 + 1
                                r0 = r32
                                r1 = r34
                                r15 = r17
                                r3 = r20
                                r7 = r21
                                r4 = r23
                                r5 = 1
                                r8 = 0
                                r12 = 2
                                goto L_0x023e
                            L_0x034d:
                                r20 = r3
                                r23 = r4
                                goto L_0x03a2
                            L_0x0352:
                                r20 = r3
                                r23 = r4
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
                                int r0 = r9.length
                                r1 = 0
                                r2 = 0
                            L_0x035c:
                                if (r1 >= r0) goto L_0x03a2
                                r3 = r9[r1]
                                int r4 = r2 + 1
                                java.lang.Object r2 = r10.get(r2)
                                com.github.mikephil.charting.data.Entry r2 = (com.github.mikephil.charting.data.Entry) r2
                                java.lang.Object r5 = r2.getData()
                                com.microtech.aidexx.db.entity.RealCgmHistoryEntity r5 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r5
                                if (r5 == 0) goto L_0x0377
                                long r7 = r5.convertToCurZoneTs()
                                r5 = 1000(0x3e8, float:1.401E-42)
                                goto L_0x0385
                            L_0x0377:
                                com.microtech.aidexx.views.chart.ChartUtil r5 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                float r7 = r2.getX()
                                long r7 = r5.xToSecond(r7)
                                r5 = 1000(0x3e8, float:1.401E-42)
                                long r11 = (long) r5
                                long r7 = r7 * r11
                            L_0x0385:
                                java.lang.Long r7 = java.lang.Long.valueOf(r7)
                                float r8 = r2.getY()
                                java.lang.Float r8 = java.lang.Float.valueOf(r8)
                                kotlin.Pair r7 = kotlin.TuplesKt.to(r7, r8)
                                r2.setData(r7)
                                r2.setY(r3)
                                r14.addEntryOrdered(r2)
                                int r1 = r1 + 1
                                r2 = r4
                                goto L_0x035c
                            L_0x03a2:
                                r24 = r6
                                java.lang.CharSequence r24 = (java.lang.CharSequence) r24
                                r0 = 1
                                java.lang.String[] r1 = new java.lang.String[r0]
                                java.lang.String r0 = "*"
                                r2 = 0
                                r1[r2] = r0
                                r28 = 6
                                r29 = 0
                                r26 = 0
                                r27 = 0
                                r25 = r1
                                java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r24, (java.lang.String[]) r25, (boolean) r26, (int) r27, (int) r28, (java.lang.Object) r29)
                                com.github.mikephil.charting.data.CombinedData r1 = r32.getCombinedData()
                                com.github.mikephil.charting.data.LineData r1 = r1.getLineData()
                                if (r1 == 0) goto L_0x0435
                                java.util.List r1 = r1.getDataSets()
                                if (r1 == 0) goto L_0x0435
                                java.lang.Iterable r1 = (java.lang.Iterable) r1
                                java.util.ArrayList r2 = new java.util.ArrayList
                                r2.<init>()
                                java.util.Collection r2 = (java.util.Collection) r2
                                java.util.Iterator r1 = r1.iterator()
                            L_0x03d9:
                                boolean r3 = r1.hasNext()
                                if (r3 == 0) goto L_0x0430
                                java.lang.Object r3 = r1.next()
                                r4 = r3
                                com.github.mikephil.charting.interfaces.datasets.ILineDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.ILineDataSet) r4
                                boolean r5 = r4 instanceof com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine
                                if (r5 == 0) goto L_0x042a
                                com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r4 = (com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine) r4
                                java.lang.String r4 = r4.getLabel()
                                java.lang.String r5 = "getLabel(...)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
                                java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                                java.lang.StringBuilder r5 = new java.lang.StringBuilder
                                r5.<init>()
                                r6 = 0
                                java.lang.Object r7 = r0.get(r6)
                                java.lang.String r7 = (java.lang.String) r7
                                java.lang.StringBuilder r5 = r5.append(r7)
                                r7 = 42
                                java.lang.StringBuilder r5 = r5.append(r7)
                                r8 = 1
                                java.lang.Object r9 = r0.get(r8)
                                java.lang.String r9 = (java.lang.String) r9
                                java.lang.StringBuilder r5 = r5.append(r9)
                                java.lang.String r5 = r5.toString()
                                java.lang.CharSequence r5 = (java.lang.CharSequence) r5
                                r8 = 2
                                r9 = 0
                                boolean r4 = kotlin.text.StringsKt.contains$default((java.lang.CharSequence) r4, (java.lang.CharSequence) r5, (boolean) r6, (int) r8, (java.lang.Object) r9)
                                if (r4 == 0) goto L_0x03d9
                                r2.add(r3)
                                goto L_0x03d9
                            L_0x042a:
                                r6 = 0
                                r7 = 42
                                r8 = 2
                                r9 = 0
                                goto L_0x03d9
                            L_0x0430:
                                r6 = 0
                                r9 = 0
                                java.util.List r2 = (java.util.List) r2
                                goto L_0x0438
                            L_0x0435:
                                r6 = 0
                                r9 = 0
                                r2 = r9
                            L_0x0438:
                                boolean r1 = r2 instanceof java.util.List
                                if (r1 == 0) goto L_0x043d
                                goto L_0x043e
                            L_0x043d:
                                r2 = r9
                            L_0x043e:
                                if (r2 != 0) goto L_0x0444
                                java.util.List r2 = kotlin.collections.CollectionsKt.emptyList()
                            L_0x0444:
                                java.util.ArrayList r1 = new java.util.ArrayList
                                r1.<init>()
                                java.util.List r1 = (java.util.List) r1
                                java.lang.Iterable r2 = (java.lang.Iterable) r2
                                java.util.Iterator r2 = r2.iterator()
                            L_0x0451:
                                boolean r3 = r2.hasNext()
                                if (r3 == 0) goto L_0x046c
                                java.lang.Object r3 = r2.next()
                                com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine r3 = (com.microtech.aidexx.views.chart.dataset.GlucoseDataSetLine) r3
                                java.util.List r3 = r3.getEntries()
                                java.lang.String r4 = "getEntries(...)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
                                java.util.Collection r3 = (java.util.Collection) r3
                                r1.addAll(r3)
                                goto L_0x0451
                            L_0x046c:
                                java.lang.Iterable r1 = (java.lang.Iterable) r1
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addCgmData$lambda$23$$inlined$sortedBy$1 r2 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addCgmData$lambda$23$$inlined$sortedBy$1
                                r2.<init>()
                                java.util.Comparator r2 = (java.util.Comparator) r2
                                java.util.List r1 = kotlin.collections.CollectionsKt.sortedWith(r1, r2)
                                r2 = 1
                                java.lang.Object r0 = r0.get(r2)
                                java.lang.String r0 = (java.lang.String) r0
                                r3 = r32
                                r4 = r34
                                r3.addTimezone(r1, r4, r0)
                            L_0x0487:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                r1 = r23
                                r1.add(r0)
                                r0 = r3
                                r8 = r6
                                r3 = r20
                                r7 = -1
                                r30 = r4
                                r4 = r1
                                r5 = r2
                                r1 = r30
                                goto L_0x00bd
                            L_0x049b:
                                r3 = r0
                                r1 = r4
                                r4 = r1
                                java.util.List r4 = (java.util.List) r4
                                goto L_0x04a2
                            L_0x04a1:
                                r3 = r0
                            L_0x04a2:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.addCgmData(java.util.List, long, java.util.Date, java.util.Date):void");
                        }

                        private final boolean checkCgmHistory(RealCgmHistoryEntity realCgmHistoryEntity) {
                            return (!realCgmHistoryEntity.isGlucoseIsValid() || realCgmHistoryEntity.getGlucose() == null || realCgmHistoryEntity.getEventWarning() == -1) ? false : true;
                        }

                        /* access modifiers changed from: private */
                        public final void addBgData(List<BloodGlucoseEntity> list, long j) {
                            BgDataSet bgDataSet;
                            Unit unit;
                            Collection collection = list;
                            if (collection.isEmpty()) {
                                collection = null;
                            }
                            if (((List) collection) != null && (bgDataSet = (BgDataSet) findOrAddChartSetByLabel(BgDataSet.class, j)) != null) {
                                for (BloodGlucoseEntity next : list) {
                                    String userId = next.getUserId();
                                    if (userId == null) {
                                        unit = null;
                                    } else if (!canMergeData(userId)) {
                                        LogUtil.Companion.xLogE("正在把bg数据合并到chart 发现换人了", TAG);
                                        resetData();
                                        return;
                                    } else {
                                        ChartEntry chartEntry$default = EventEntryConverterKt.toChartEntry$default(next, (Function0) null, 1, (Object) null);
                                        bgDataSet.addEntryOrdered(chartEntry$default);
                                        xMaxMin(chartEntry$default.getX(), j);
                                        calDateMaxMin$default(this, new Date(next.getTimestamp()), j, false, 4, (Object) null);
                                        unit = Unit.INSTANCE;
                                    }
                                    if (unit == null) {
                                        LogUtil.Companion.d("bg data userid null", TAG);
                                    }
                                }
                            }
                        }

                        /* access modifiers changed from: private */
                        public final void addCalData(List<CalibrateEntity> list, long j) {
                            CalDataSet calDataSet;
                            Unit unit;
                            Collection collection = list;
                            if (collection.isEmpty()) {
                                collection = null;
                            }
                            if (((List) collection) != null && (calDataSet = (CalDataSet) findOrAddChartSetByLabel(CalDataSet.class, j)) != null) {
                                for (CalibrateEntity calibrateEntity : list) {
                                    String userId = calibrateEntity.getUserId();
                                    if (userId == null) {
                                        unit = null;
                                    } else if (!canMergeData(userId)) {
                                        LogUtil.Companion.xLogE("正在把cal数据合并到chart 发现换人了", TAG);
                                        resetData();
                                        return;
                                    } else {
                                        ChartEntry chartEntry$default = EventEntryConverterKt.toChartEntry$default(calibrateEntity, (Function0) null, 1, (Object) null);
                                        calDataSet.addEntryOrdered(chartEntry$default);
                                        xMaxMin(chartEntry$default.getX(), j);
                                        calDateMaxMin$default(this, new Date(calibrateEntity.getTimestamp()), j, false, 4, (Object) null);
                                        unit = Unit.INSTANCE;
                                    }
                                    if (unit == null) {
                                        LogUtil.Companion.d("cal data userid null", TAG);
                                    }
                                }
                            }
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:7:0x001f, code lost:
                            if (kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0 != null ? r0.getDataProviderId() : null, (java.lang.Object) r2) == false) goto L_0x0021;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final boolean canMergeData(java.lang.String r2) {
                            /*
                                r1 = this;
                                java.lang.String r0 = "dataUserId"
                                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                                com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                                com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r0.getShareUserInfo()
                                if (r0 == 0) goto L_0x0021
                                com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                                com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r0.getShareUserInfo()
                                if (r0 == 0) goto L_0x001a
                                java.lang.String r0 = r0.getDataProviderId()
                                goto L_0x001b
                            L_0x001a:
                                r0 = 0
                            L_0x001b:
                                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
                                if (r0 != 0) goto L_0x0039
                            L_0x0021:
                                com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                                com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r0.getShareUserInfo()
                                if (r0 != 0) goto L_0x003b
                                com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                                com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
                                java.lang.String r0 = r0.userId()
                                boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r2)
                                if (r2 == 0) goto L_0x003b
                            L_0x0039:
                                r2 = 1
                                goto L_0x003c
                            L_0x003b:
                                r2 = 0
                            L_0x003c:
                                return r2
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.canMergeData(java.lang.String):boolean");
                        }

                        /* access modifiers changed from: private */
                        public final <T extends BaseEventEntity> void addEvent(List<? extends T> list, long j) {
                            IconDataSet iconDataSet;
                            Unit unit;
                            Collection collection = list;
                            if (collection.isEmpty()) {
                                collection = null;
                            }
                            if (((List) collection) != null && (iconDataSet = (IconDataSet) findOrAddChartSetByLabel(IconDataSet.class, j)) != null) {
                                Iterator<? extends T> it = list.iterator();
                                while (it.hasNext()) {
                                    BaseEventEntity baseEventEntity = (BaseEventEntity) it.next();
                                    String userId = baseEventEntity.getUserId();
                                    if (userId == null) {
                                        unit = null;
                                    } else if (!canMergeData(userId)) {
                                        LogUtil.Companion.xLogE("正在把event数据合并到chart 发现换人了", TAG);
                                        resetData();
                                        return;
                                    } else {
                                        iconDataSet.addEntryOrdered(EventEntryConverterKt.toChartEntry(baseEventEntity, ChartViewModel$addEvent$2$1$1$entry$1.INSTANCE));
                                        calDateMaxMin$default(this, new Date(baseEventEntity.getTimestamp()), j, false, 4, (Object) null);
                                        unit = Unit.INSTANCE;
                                    }
                                    if (unit == null) {
                                        LogUtil.Companion.d("event data " + baseEventEntity + " userid null", TAG);
                                    }
                                }
                            }
                        }

                        public final void refreshMax() {
                            LogUtil.Companion.xLogE("refreshTimezone", TAG);
                            if (this.isDataAdded) {
                                this.isDataAdded = false;
                                Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChartViewModel$refreshMax$1(this, (Continuation<? super ChartViewModel$refreshMax$1>) null), 3, (Object) null);
                            }
                        }

                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.github.mikephil.charting.interfaces.datasets.IScatterDataSet} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.github.mikephil.charting.interfaces.datasets.IScatterDataSet} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.github.mikephil.charting.interfaces.datasets.IScatterDataSet} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v10, resolved type: java.lang.Object} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.github.mikephil.charting.interfaces.datasets.IScatterDataSet} */
                        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.github.mikephil.charting.interfaces.datasets.IScatterDataSet} */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final void refreshTimezone() {
                            /*
                                r15 = this;
                                com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.String r1 = "refreshTimezone"
                                java.lang.String r2 = "ChartViewModel"
                                r0.xLogE(r1, r2)
                                boolean r0 = r15.isDataAdded
                                r1 = 0
                                if (r0 == 0) goto L_0x0027
                                r0 = 0
                                r15.isDataAdded = r0
                                r0 = r15
                                androidx.lifecycle.ViewModel r0 = (androidx.lifecycle.ViewModel) r0
                                kotlinx.coroutines.CoroutineScope r2 = androidx.lifecycle.ViewModelKt.getViewModelScope(r0)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$refreshTimezone$1 r0 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$refreshTimezone$1
                                r0.<init>(r15, r1)
                                r5 = r0
                                kotlin.jvm.functions.Function2 r5 = (kotlin.jvm.functions.Function2) r5
                                r6 = 3
                                r7 = 0
                                r3 = 0
                                r4 = 0
                                kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r2, r3, r4, r5, r6, r7)
                            L_0x0027:
                                com.github.mikephil.charting.data.CombinedData r0 = r15.combinedData
                                if (r0 == 0) goto L_0x015c
                                com.github.mikephil.charting.data.CombinedData r0 = r15.getCombinedData()
                                com.github.mikephil.charting.data.ScatterData r0 = r0.getScatterData()
                                if (r0 == 0) goto L_0x005f
                                java.util.List r0 = r0.getDataSets()
                                if (r0 == 0) goto L_0x005f
                                java.lang.Iterable r0 = (java.lang.Iterable) r0
                                java.util.Iterator r0 = r0.iterator()
                            L_0x0041:
                                boolean r2 = r0.hasNext()
                                if (r2 == 0) goto L_0x005b
                                java.lang.Object r2 = r0.next()
                                r3 = r2
                                com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r3 = (com.github.mikephil.charting.interfaces.datasets.IScatterDataSet) r3
                                java.lang.Class r3 = r3.getClass()
                                java.lang.Class<com.microtech.aidexx.views.chart.dataset.TimezoneDataSet> r4 = com.microtech.aidexx.views.chart.dataset.TimezoneDataSet.class
                                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r4)
                                if (r3 == 0) goto L_0x0041
                                goto L_0x005c
                            L_0x005b:
                                r2 = r1
                            L_0x005c:
                                com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r2 = (com.github.mikephil.charting.interfaces.datasets.IScatterDataSet) r2
                                goto L_0x0060
                            L_0x005f:
                                r2 = r1
                            L_0x0060:
                                com.microtech.aidexx.views.chart.dataset.TimezoneDataSet r2 = (com.microtech.aidexx.views.chart.dataset.TimezoneDataSet) r2
                                java.lang.String r0 = "getEntries(...)"
                                if (r2 == 0) goto L_0x00e0
                                java.util.ArrayList r3 = new java.util.ArrayList
                                r3.<init>()
                                java.util.List r3 = (java.util.List) r3
                                java.util.List r4 = r2.getEntries()
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r0)
                                java.lang.Iterable r4 = (java.lang.Iterable) r4
                                java.util.Iterator r4 = r4.iterator()
                            L_0x007a:
                                boolean r5 = r4.hasNext()
                                if (r5 == 0) goto L_0x00da
                                java.lang.Object r5 = r4.next()
                                com.github.mikephil.charting.data.Entry r5 = (com.github.mikephil.charting.data.Entry) r5
                                com.microtech.aidexx.views.chart.dataset.ChartEntry r6 = new com.microtech.aidexx.views.chart.dataset.ChartEntry
                                float r7 = r5.getX()
                                float r8 = r5.getY()
                                java.lang.Object r9 = r5.getData()
                                r6.<init>(r7, r8, r9)
                                com.microtech.aidexx.views.chart.dataset.TimezoneDataSet$Companion r7 = com.microtech.aidexx.views.chart.dataset.TimezoneDataSet.Companion
                                com.microtech.aidexx.utils.TimeUtils r8 = com.microtech.aidexx.utils.TimeUtils.INSTANCE
                                java.lang.Object r9 = r5.getData()
                                java.lang.String r14 = "null cannot be cast to non-null type com.github.mikephil.charting.data.Entry"
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r9, r14)
                                com.github.mikephil.charting.data.Entry r9 = (com.github.mikephil.charting.data.Entry) r9
                                java.lang.String r9 = r9.getTimeZone()
                                java.lang.String r10 = "getTimeZone(...)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)
                                r12 = 2
                                r13 = 0
                                r10 = 0
                                java.lang.String r8 = com.microtech.aidexx.utils.TimeUtils.getTimezoneOffset$default(r8, r9, r10, r12, r13)
                                java.lang.Object r5 = r5.getData()
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r14)
                                com.github.mikephil.charting.data.Entry r5 = (com.github.mikephil.charting.data.Entry) r5
                                java.lang.Boolean r5 = r5.getTextTop()
                                java.lang.String r9 = "getTextTop(...)"
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r9)
                                boolean r5 = r5.booleanValue()
                                android.graphics.drawable.BitmapDrawable r5 = r7.getTimezoneIcon(r8, r5)
                                android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
                                r6.setIcon(r5)
                                r3.add(r6)
                                goto L_0x007a
                            L_0x00da:
                                r2.clear()
                                r2.addEntries(r3)
                            L_0x00e0:
                                com.github.mikephil.charting.data.CombinedData r2 = r15.getCombinedData()
                                com.github.mikephil.charting.data.ScatterData r2 = r2.getScatterData()
                                if (r2 == 0) goto L_0x0112
                                java.util.List r2 = r2.getDataSets()
                                if (r2 == 0) goto L_0x0112
                                java.lang.Iterable r2 = (java.lang.Iterable) r2
                                java.util.Iterator r2 = r2.iterator()
                            L_0x00f6:
                                boolean r3 = r2.hasNext()
                                if (r3 == 0) goto L_0x0110
                                java.lang.Object r3 = r2.next()
                                r4 = r3
                                com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r4 = (com.github.mikephil.charting.interfaces.datasets.IScatterDataSet) r4
                                java.lang.Class r4 = r4.getClass()
                                java.lang.Class<com.microtech.aidexx.views.chart.dataset.DstDataSet> r5 = com.microtech.aidexx.views.chart.dataset.DstDataSet.class
                                boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r5)
                                if (r4 == 0) goto L_0x00f6
                                r1 = r3
                            L_0x0110:
                                com.github.mikephil.charting.interfaces.datasets.IScatterDataSet r1 = (com.github.mikephil.charting.interfaces.datasets.IScatterDataSet) r1
                            L_0x0112:
                                com.microtech.aidexx.views.chart.dataset.DstDataSet r1 = (com.microtech.aidexx.views.chart.dataset.DstDataSet) r1
                                if (r1 == 0) goto L_0x015c
                                java.util.ArrayList r2 = new java.util.ArrayList
                                r2.<init>()
                                java.util.List r2 = (java.util.List) r2
                                java.util.List r3 = r1.getEntries()
                                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r0)
                                java.lang.Iterable r3 = (java.lang.Iterable) r3
                                java.util.Iterator r0 = r3.iterator()
                            L_0x012a:
                                boolean r3 = r0.hasNext()
                                if (r3 == 0) goto L_0x0156
                                java.lang.Object r3 = r0.next()
                                com.github.mikephil.charting.data.Entry r3 = (com.github.mikephil.charting.data.Entry) r3
                                com.microtech.aidexx.views.chart.dataset.ChartEntry r4 = new com.microtech.aidexx.views.chart.dataset.ChartEntry
                                float r5 = r3.getX()
                                float r6 = r3.getY()
                                java.lang.Object r3 = r3.getData()
                                r4.<init>(r5, r6, r3)
                                com.microtech.aidexx.views.chart.dataset.DstDataSet$Companion r3 = com.microtech.aidexx.views.chart.dataset.DstDataSet.Companion
                                android.graphics.drawable.BitmapDrawable r3 = r3.getTimezoneIcon()
                                android.graphics.drawable.Drawable r3 = (android.graphics.drawable.Drawable) r3
                                r4.setIcon(r3)
                                r2.add(r4)
                                goto L_0x012a
                            L_0x0156:
                                r1.clear()
                                r1.addEntries(r2)
                            L_0x015c:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.refreshTimezone():void");
                        }

                        private final void addTimezone(List<? extends Entry> list, long j, String str) {
                            List<? extends Entry> list2 = list;
                            TimezoneDataSet timezoneDataSet = (TimezoneDataSet) findOrAddChartSetByLabel(TimezoneDataSet.class, j);
                            if (timezoneDataSet != null) {
                                LogUtil.Companion.eAiDEX("addTimezone -> start");
                                timezoneDataSet.getEntries().removeIf(new ChartViewModel$$ExternalSyntheticLambda1(new ChartViewModel$addTimezone$1$1(str)));
                                int i = 0;
                                for (Object next : list2) {
                                    int i2 = i + 1;
                                    if (i < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Entry entry = (Entry) next;
                                    if (i < list.size() - 1) {
                                        TimeUtils timeUtils = TimeUtils.INSTANCE;
                                        String timeZone = entry.getTimeZone();
                                        Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(...)");
                                        String timezoneOffset$default = TimeUtils.getTimezoneOffset$default(timeUtils, timeZone, 0, 2, (Object) null);
                                        TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                                        String timeZone2 = ((Entry) list2.get(i2)).getTimeZone();
                                        Intrinsics.checkNotNullExpressionValue(timeZone2, "getTimeZone(...)");
                                        if (!Intrinsics.areEqual((Object) timezoneOffset$default, (Object) TimeUtils.getTimezoneOffset$default(timeUtils2, timeZone2, 0, 2, (Object) null))) {
                                            LogUtil.Companion companion = LogUtil.Companion;
                                            StringBuilder sb = new StringBuilder("addTimezone -> ");
                                            TimeUtils timeUtils3 = TimeUtils.INSTANCE;
                                            String timeZone3 = entry.getTimeZone();
                                            Intrinsics.checkNotNullExpressionValue(timeZone3, "getTimeZone(...)");
                                            StringBuilder append = sb.append(TimeUtils.getTimezoneOffset$default(timeUtils3, timeZone3, 0, 2, (Object) null)).append(',').append(entry.getTimeOffset()).append(" - ");
                                            TimeUtils timeUtils4 = TimeUtils.INSTANCE;
                                            String timeZone4 = ((Entry) list2.get(i2)).getTimeZone();
                                            Intrinsics.checkNotNullExpressionValue(timeZone4, "getTimeZone(...)");
                                            companion.eAiDEX(append.append(TimeUtils.getTimezoneOffset$default(timeUtils4, timeZone4, 0, 2, (Object) null)).append(',').append(((Entry) list2.get(i2)).getTimeOffset()).toString());
                                            entry.setTextTop(true);
                                            ChartEntry chartEntry = new ChartEntry(entry.getX(), entry.getY(), entry);
                                            TimezoneDataSet.Companion companion2 = TimezoneDataSet.Companion;
                                            TimeUtils timeUtils5 = TimeUtils.INSTANCE;
                                            String timeZone5 = entry.getTimeZone();
                                            Intrinsics.checkNotNullExpressionValue(timeZone5, "getTimeZone(...)");
                                            chartEntry.setIcon(companion2.getTimezoneIcon(TimeUtils.getTimezoneOffset$default(timeUtils5, timeZone5, 0, 2, (Object) null), true));
                                            timezoneDataSet.addEntryOrdered(chartEntry);
                                            ((Entry) list2.get(i2)).setTextTop(false);
                                            ChartEntry chartEntry2 = new ChartEntry(((Entry) list2.get(i2)).getX(), ((Entry) list2.get(i2)).getY(), list2.get(i2));
                                            TimezoneDataSet.Companion companion3 = TimezoneDataSet.Companion;
                                            TimeUtils timeUtils6 = TimeUtils.INSTANCE;
                                            String timeZone6 = ((Entry) list2.get(i2)).getTimeZone();
                                            Intrinsics.checkNotNullExpressionValue(timeZone6, "getTimeZone(...)");
                                            chartEntry2.setIcon(companion3.getTimezoneIcon(TimeUtils.getTimezoneOffset$default(timeUtils6, timeZone6, 0, 2, (Object) null), false));
                                            timezoneDataSet.addEntryOrdered(chartEntry2);
                                            i = i2;
                                        }
                                    }
                                    i = i2;
                                }
                            } else {
                                String str2 = str;
                            }
                            addDst(list, j, str);
                        }

                        /* access modifiers changed from: private */
                        public static final boolean addTimezone$lambda$43$lambda$41(Function1 function1, Object obj) {
                            Intrinsics.checkNotNullParameter(function1, "$tmp0");
                            return ((Boolean) function1.invoke(obj)).booleanValue();
                        }

                        private final void addDst(List<? extends Entry> list, long j, String str) {
                            DstDataSet dstDataSet = (DstDataSet) findOrAddChartSetByLabel(DstDataSet.class, j);
                            if (dstDataSet != null) {
                                dstDataSet.getEntries().removeIf(new ChartViewModel$$ExternalSyntheticLambda0(new ChartViewModel$addDst$1$1(str)));
                                int i = 0;
                                for (Object next : list) {
                                    int i2 = i + 1;
                                    if (i < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    Entry entry = (Entry) next;
                                    if (i < list.size() - 1) {
                                        TimeUtils timeUtils = TimeUtils.INSTANCE;
                                        String timeZone = entry.getTimeZone();
                                        Intrinsics.checkNotNullExpressionValue(timeZone, "getTimeZone(...)");
                                        String timezoneOffset$default = TimeUtils.getTimezoneOffset$default(timeUtils, timeZone, 0, 2, (Object) null);
                                        TimeUtils timeUtils2 = TimeUtils.INSTANCE;
                                        String timeZone2 = ((Entry) list.get(i2)).getTimeZone();
                                        Intrinsics.checkNotNullExpressionValue(timeZone2, "getTimeZone(...)");
                                        if (Intrinsics.areEqual((Object) timezoneOffset$default, (Object) TimeUtils.getTimezoneOffset$default(timeUtils2, timeZone2, 0, 2, (Object) null)) && TimeZone.getTimeZone(entry.getTimeZone()).getRawOffset() == TimeZone.getTimeZone(((Entry) list.get(i2)).getTimeZone()).getRawOffset() && !Intrinsics.areEqual((Object) entry.getDstOffset(), (Object) ((Entry) list.get(i2)).getDstOffset())) {
                                            ChartEntry chartEntry = new ChartEntry(entry.getX(), entry.getY(), entry);
                                            chartEntry.setIcon(DstDataSet.Companion.getTimezoneIcon());
                                            dstDataSet.addEntryOrdered(chartEntry);
                                            ((Entry) list.get(i2)).setTextTop(false);
                                            ChartEntry chartEntry2 = new ChartEntry(((Entry) list.get(i2)).getX(), ((Entry) list.get(i2)).getY(), list.get(i2));
                                            chartEntry2.setIcon(DstDataSet.Companion.getTimezoneIcon());
                                            dstDataSet.addEntryOrdered(chartEntry2);
                                        }
                                    }
                                    i = i2;
                                }
                            }
                        }

                        /* access modifiers changed from: private */
                        public static final boolean addDst$lambda$46$lambda$44(Function1 function1, Object obj) {
                            Intrinsics.checkNotNullParameter(function1, "$tmp0");
                            return ((Boolean) function1.invoke(obj)).booleanValue();
                        }

                        static /* synthetic */ IScatterDataSet findOrAddChartSetByLabel$default(ChartViewModel chartViewModel, Class cls, long j, int i, Object obj) {
                            if ((i & 2) != 0) {
                                j = chartViewModel.defaultLabel;
                            }
                            return chartViewModel.findOrAddChartSetByLabel(cls, j);
                        }

                        private final <T extends IScatterDataSet> T findOrAddChartSetByLabel(Class<? extends T> cls, long j) {
                            T t;
                            T t2;
                            List dataSets;
                            T t3;
                            T t4 = null;
                            if (getCombinedData().getScatterData() == null) {
                                LogUtil.Companion.xLogE$default(LogUtil.Companion, "combinedData.scatterData == null", (String) null, 2, (Object) null);
                                return null;
                            }
                            ScatterData scatterData = getCombinedData().getScatterData();
                            if ((scatterData != null ? scatterData.getDataSets() : null) == null) {
                                LogUtil.Companion.xLogE$default(LogUtil.Companion, "combinedData.scatterData.dataSets == null", (String) null, 2, (Object) null);
                                return null;
                            }
                            String valueOf = String.valueOf(j);
                            ScatterData scatterData2 = getCombinedData().getScatterData();
                            if (scatterData2 == null || (dataSets = scatterData2.getDataSets()) == null) {
                                t = null;
                            } else {
                                Iterator it = dataSets.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        t3 = null;
                                        break;
                                    }
                                    t3 = it.next();
                                    IScatterDataSet iScatterDataSet = (IScatterDataSet) t3;
                                    if (Intrinsics.areEqual((Object) iScatterDataSet.getClass(), (Object) cls) && Intrinsics.areEqual((Object) iScatterDataSet.getLabel(), (Object) valueOf)) {
                                        break;
                                    }
                                }
                                t = (IScatterDataSet) t3;
                            }
                            if (t != null) {
                                return t;
                            }
                            ChartViewModel chartViewModel = this;
                            if (Intrinsics.areEqual((Object) cls, (Object) BgDataSet.class)) {
                                t2 = (ScatterDataSet) new BgDataSet();
                            } else if (Intrinsics.areEqual((Object) cls, (Object) CalDataSet.class)) {
                                t2 = (ScatterDataSet) new CalDataSet();
                            } else if (Intrinsics.areEqual((Object) cls, (Object) IconDataSet.class)) {
                                t2 = (ScatterDataSet) new IconDataSet();
                            } else if (Intrinsics.areEqual((Object) cls, (Object) TimezoneDataSet.class)) {
                                t2 = (ScatterDataSet) new TimezoneDataSet();
                            } else {
                                t2 = Intrinsics.areEqual((Object) cls, (Object) DstDataSet.class) ? (ScatterDataSet) new DstDataSet() : null;
                            }
                            if (t2 != null) {
                                t2.setLabel(valueOf);
                                getCombinedData().getScatterData().getDataSets().add(t2);
                                Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of com.microtech.aidexx.ui.main.home.chart.ChartViewModel.findOrAddChartSetByLabel$lambda$50$lambda$48");
                                t4 = (IScatterDataSet) t2;
                            } else {
                                LogUtil.Companion.xLogE$default(LogUtil.Companion, cls.getClass().getSimpleName() + " not support to add to chart", (String) null, 2, (Object) null);
                            }
                            return t4;
                        }

                        static /* synthetic */ void xMaxMin$default(ChartViewModel chartViewModel, float f, long j, int i, Object obj) {
                            if ((i & 2) != 0) {
                                j = chartViewModel.defaultLabel;
                            }
                            chartViewModel.xMaxMin(f, j);
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0031, code lost:
                            if (r3.floatValue() > r2) goto L_0x0033;
                         */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        private final void xMaxMin(float r2, long r3) {
                            /*
                                r1 = this;
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r0 = r1.areas
                                java.lang.Long r3 = java.lang.Long.valueOf(r3)
                                java.lang.Object r3 = r0.get(r3)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r3 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo) r3
                                if (r3 == 0) goto L_0x0024
                                float r4 = r3.getMinX()
                                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                                if (r4 <= 0) goto L_0x0019
                                r3.setMinX(r2)
                            L_0x0019:
                                float r4 = r3.getMaxX()
                                int r4 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
                                if (r4 >= 0) goto L_0x0024
                                r3.setMaxX(r2)
                            L_0x0024:
                                java.lang.Float r3 = r1.timeMin
                                if (r3 == 0) goto L_0x0033
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                                float r3 = r3.floatValue()
                                int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
                                if (r3 <= 0) goto L_0x0039
                            L_0x0033:
                                java.lang.Float r3 = java.lang.Float.valueOf(r2)
                                r1.timeMin = r3
                            L_0x0039:
                                java.lang.Float r3 = r1.timeMax
                                if (r3 == 0) goto L_0x0048
                                kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
                                float r3 = r3.floatValue()
                                int r3 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
                                if (r3 >= 0) goto L_0x004e
                            L_0x0048:
                                java.lang.Float r2 = java.lang.Float.valueOf(r2)
                                r1.timeMax = r2
                            L_0x004e:
                                return
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.xMaxMin(float, long):void");
                        }

                        static /* synthetic */ void calDateMaxMin$default(ChartViewModel chartViewModel, Date date, long j, boolean z, int i, Object obj) {
                            if ((i & 2) != 0) {
                                j = chartViewModel.defaultLabel;
                            }
                            if ((i & 4) != 0) {
                                z = false;
                            }
                            chartViewModel.calDateMaxMin(date, j, z);
                        }

                        private final void calDateMaxMin(Date date, long j, boolean z) {
                            Unit unit;
                            AreaInfo areaInfo = this.areas.get(Long.valueOf(j));
                            if (areaInfo != null) {
                                if (areaInfo.getMinTs() > date.getTime()) {
                                    areaInfo.setMinTs(date.getTime());
                                }
                                if (areaInfo.getMaxTs() < date.getTime()) {
                                    areaInfo.setMaxTs(date.getTime());
                                }
                                Pair<Date, Date> areaDatePair = areaInfo.getAreaDatePair();
                                if (areaDatePair != null) {
                                    long time = areaDatePair.getFirst().getTime();
                                    long time2 = areaDatePair.getSecond().getTime();
                                    long time3 = areaInfo.getTargetDate().getTime();
                                    if (time <= time3 && time3 <= time2 && date.getTime() > areaInfo.getTargetDate().getTime() && date.getTime() - areaInfo.getTargetDate().getTime() < TimeUtils.oneDayMillis && z) {
                                        Date jumpToDate = areaInfo.getJumpToDate();
                                        if (jumpToDate != null) {
                                            if (jumpToDate.getTime() - areaInfo.getTargetDate().getTime() > date.getTime() - areaInfo.getTargetDate().getTime()) {
                                                areaInfo.setJumpToDate(date);
                                            }
                                            unit = Unit.INSTANCE;
                                        } else {
                                            unit = null;
                                        }
                                        if (unit == null) {
                                            ChartViewModel chartViewModel = this;
                                            areaInfo.setJumpToDate(date);
                                        }
                                    }
                                }
                            }
                            if (this.curPageMinDate.getTime() > date.getTime()) {
                                this.curPageMinDate = date;
                                LogUtil.Companion.d("当前最小日期curPageMinDate=" + ExtendsKt.formatToYMdHm(this.curPageMinDate), TAG);
                            }
                        }

                        private final void resetTimerToRefreshChart() {
                            this.timerHandler.removeMessages(1);
                            ChartViewModel$timerHandler$1 chartViewModel$timerHandler$1 = this.timerHandler;
                            chartViewModel$timerHandler$1.sendMessageDelayed(Message.obtain(chartViewModel$timerHandler$1, 1), 300000);
                        }

                        /* access modifiers changed from: protected */
                        public void onCleared() {
                            super.onCleared();
                            this.timerHandler.removeMessages(1);
                            LogUtil.Companion.xLogE("HomeFragment chartvm onCleared " + this, TAG);
                            LogUtil.Companion.d("HomeFragment chartvm onCleared " + this, TAG);
                        }

                        @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b9\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0013¢\u0006\u0002\u0010\u0015J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u0013HÆ\u0003J\t\u0010>\u001a\u00020\u0013HÆ\u0003J\u0017\u0010?\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J\t\u0010@\u001a\u00020\u0007HÆ\u0003J\t\u0010A\u001a\u00020\tHÆ\u0003J\t\u0010B\u001a\u00020\u000bHÆ\u0003J\t\u0010C\u001a\u00020\u000bHÆ\u0003J\t\u0010D\u001a\u00020\u0007HÆ\u0003J\t\u0010E\u001a\u00020\u0007HÆ\u0003J\u000b\u0010F\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0001\u0010G\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\u000e\u001a\u00020\u00072\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0013HÆ\u0001J\u0013\u0010H\u001a\u00020\u00132\b\u0010I\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010J\u001a\u00020\tHÖ\u0001J\b\u0010K\u001a\u00020\u0010H\u0016R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0014\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\"\"\u0004\b&\u0010$R\u001a\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\r\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010(\"\u0004\b.\u0010*R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001a\"\u0004\b0\u0010\u001cR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001e\"\u0004\b2\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006L"}, d2 = {"Lcom/microtech/aidexx/ui/main/home/chart/ChartViewModel$AreaInfo;", "", "targetDate", "Ljava/util/Date;", "areaDatePair", "Lkotlin/Pair;", "label", "", "type", "", "minX", "", "maxX", "minTs", "maxTs", "timeZone", "", "jumpToDate", "needRemove", "", "isLoadingRightPage", "(Ljava/util/Date;Lkotlin/Pair;JIFFJJLjava/lang/String;Ljava/util/Date;ZZ)V", "getAreaDatePair", "()Lkotlin/Pair;", "setAreaDatePair", "(Lkotlin/Pair;)V", "()Z", "setLoadingRightPage", "(Z)V", "getJumpToDate", "()Ljava/util/Date;", "setJumpToDate", "(Ljava/util/Date;)V", "getLabel", "()J", "setLabel", "(J)V", "getMaxTs", "setMaxTs", "getMaxX", "()F", "setMaxX", "(F)V", "getMinTs", "setMinTs", "getMinX", "setMinX", "getNeedRemove", "setNeedRemove", "getTargetDate", "setTargetDate", "getTimeZone", "()Ljava/lang/String;", "setTimeZone", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
                        /* compiled from: ChartViewModel.kt */
                        public static final class AreaInfo {
                            private Pair<? extends Date, ? extends Date> areaDatePair;
                            private boolean isLoadingRightPage;
                            private Date jumpToDate;
                            private long label;
                            private long maxTs;
                            private float maxX;
                            private long minTs;
                            private float minX;
                            private boolean needRemove;
                            private Date targetDate;
                            private String timeZone;
                            private int type;

                            public static /* synthetic */ AreaInfo copy$default(AreaInfo areaInfo, Date date, Pair pair, long j, int i, float f, float f2, long j2, long j3, String str, Date date2, boolean z, boolean z2, int i2, Object obj) {
                                AreaInfo areaInfo2 = areaInfo;
                                int i3 = i2;
                                return areaInfo.copy((i3 & 1) != 0 ? areaInfo2.targetDate : date, (i3 & 2) != 0 ? areaInfo2.areaDatePair : pair, (i3 & 4) != 0 ? areaInfo2.label : j, (i3 & 8) != 0 ? areaInfo2.type : i, (i3 & 16) != 0 ? areaInfo2.minX : f, (i3 & 32) != 0 ? areaInfo2.maxX : f2, (i3 & 64) != 0 ? areaInfo2.minTs : j2, (i3 & 128) != 0 ? areaInfo2.maxTs : j3, (i3 & 256) != 0 ? areaInfo2.timeZone : str, (i3 & 512) != 0 ? areaInfo2.jumpToDate : date2, (i3 & 1024) != 0 ? areaInfo2.needRemove : z, (i3 & 2048) != 0 ? areaInfo2.isLoadingRightPage : z2);
                            }

                            public final Date component1() {
                                return this.targetDate;
                            }

                            public final Date component10() {
                                return this.jumpToDate;
                            }

                            public final boolean component11() {
                                return this.needRemove;
                            }

                            public final boolean component12() {
                                return this.isLoadingRightPage;
                            }

                            public final Pair<Date, Date> component2() {
                                return this.areaDatePair;
                            }

                            public final long component3() {
                                return this.label;
                            }

                            public final int component4() {
                                return this.type;
                            }

                            public final float component5() {
                                return this.minX;
                            }

                            public final float component6() {
                                return this.maxX;
                            }

                            public final long component7() {
                                return this.minTs;
                            }

                            public final long component8() {
                                return this.maxTs;
                            }

                            public final String component9() {
                                return this.timeZone;
                            }

                            public final AreaInfo copy(Date date, Pair<? extends Date, ? extends Date> pair, long j, int i, float f, float f2, long j2, long j3, String str, Date date2, boolean z, boolean z2) {
                                Date date3 = date;
                                Intrinsics.checkNotNullParameter(date3, "targetDate");
                                return new AreaInfo(date3, pair, j, i, f, f2, j2, j3, str, date2, z, z2);
                            }

                            public boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof AreaInfo)) {
                                    return false;
                                }
                                AreaInfo areaInfo = (AreaInfo) obj;
                                return Intrinsics.areEqual((Object) this.targetDate, (Object) areaInfo.targetDate) && Intrinsics.areEqual((Object) this.areaDatePair, (Object) areaInfo.areaDatePair) && this.label == areaInfo.label && this.type == areaInfo.type && Float.compare(this.minX, areaInfo.minX) == 0 && Float.compare(this.maxX, areaInfo.maxX) == 0 && this.minTs == areaInfo.minTs && this.maxTs == areaInfo.maxTs && Intrinsics.areEqual((Object) this.timeZone, (Object) areaInfo.timeZone) && Intrinsics.areEqual((Object) this.jumpToDate, (Object) areaInfo.jumpToDate) && this.needRemove == areaInfo.needRemove && this.isLoadingRightPage == areaInfo.isLoadingRightPage;
                            }

                            public int hashCode() {
                                int hashCode = this.targetDate.hashCode() * 31;
                                Pair<? extends Date, ? extends Date> pair = this.areaDatePair;
                                int i = 0;
                                int hashCode2 = (((((((((((((hashCode + (pair == null ? 0 : pair.hashCode())) * 31) + Long.hashCode(this.label)) * 31) + Integer.hashCode(this.type)) * 31) + Float.hashCode(this.minX)) * 31) + Float.hashCode(this.maxX)) * 31) + Long.hashCode(this.minTs)) * 31) + Long.hashCode(this.maxTs)) * 31;
                                String str = this.timeZone;
                                int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
                                Date date = this.jumpToDate;
                                if (date != null) {
                                    i = date.hashCode();
                                }
                                int i2 = (hashCode3 + i) * 31;
                                boolean z = this.needRemove;
                                boolean z2 = true;
                                if (z) {
                                    z = true;
                                }
                                int i3 = (i2 + (z ? 1 : 0)) * 31;
                                boolean z3 = this.isLoadingRightPage;
                                if (!z3) {
                                    z2 = z3;
                                }
                                return i3 + (z2 ? 1 : 0);
                            }

                            public AreaInfo(Date date, Pair<? extends Date, ? extends Date> pair, long j, int i, float f, float f2, long j2, long j3, String str, Date date2, boolean z, boolean z2) {
                                Intrinsics.checkNotNullParameter(date, "targetDate");
                                this.targetDate = date;
                                this.areaDatePair = pair;
                                this.label = j;
                                this.type = i;
                                this.minX = f;
                                this.maxX = f2;
                                this.minTs = j2;
                                this.maxTs = j3;
                                this.timeZone = str;
                                this.jumpToDate = date2;
                                this.needRemove = z;
                                this.isLoadingRightPage = z2;
                            }

                            /* JADX WARNING: Illegal instructions before constructor call */
                            /* Code decompiled incorrectly, please refer to instructions dump. */
                            public /* synthetic */ AreaInfo(java.util.Date r16, kotlin.Pair r17, long r18, int r20, float r21, float r22, long r23, long r25, java.lang.String r27, java.util.Date r28, boolean r29, boolean r30, int r31, kotlin.jvm.internal.DefaultConstructorMarker r32) {
                                /*
                                    r15 = this;
                                    r0 = r31
                                    r1 = r0 & 2
                                    r2 = 0
                                    if (r1 == 0) goto L_0x0009
                                    r1 = r2
                                    goto L_0x000b
                                L_0x0009:
                                    r1 = r17
                                L_0x000b:
                                    r3 = r0 & 4
                                    if (r3 == 0) goto L_0x0012
                                    r3 = 0
                                    goto L_0x0014
                                L_0x0012:
                                    r3 = r18
                                L_0x0014:
                                    r5 = r0 & 8
                                    r6 = 0
                                    if (r5 == 0) goto L_0x001b
                                    r5 = r6
                                    goto L_0x001d
                                L_0x001b:
                                    r5 = r20
                                L_0x001d:
                                    r7 = r0 & 16
                                    if (r7 == 0) goto L_0x0025
                                    r7 = 2139095039(0x7f7fffff, float:3.4028235E38)
                                    goto L_0x0027
                                L_0x0025:
                                    r7 = r21
                                L_0x0027:
                                    r8 = r0 & 32
                                    if (r8 == 0) goto L_0x002d
                                    r8 = 1
                                    goto L_0x002f
                                L_0x002d:
                                    r8 = r22
                                L_0x002f:
                                    r9 = r0 & 64
                                    if (r9 == 0) goto L_0x0039
                                    r9 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                                    goto L_0x003b
                                L_0x0039:
                                    r9 = r23
                                L_0x003b:
                                    r11 = r0 & 128(0x80, float:1.794E-43)
                                    if (r11 == 0) goto L_0x0042
                                    r11 = -9223372036854775808
                                    goto L_0x0044
                                L_0x0042:
                                    r11 = r25
                                L_0x0044:
                                    r13 = r0 & 256(0x100, float:3.59E-43)
                                    if (r13 == 0) goto L_0x004a
                                    r13 = r2
                                    goto L_0x004c
                                L_0x004a:
                                    r13 = r27
                                L_0x004c:
                                    r14 = r0 & 512(0x200, float:7.175E-43)
                                    if (r14 == 0) goto L_0x0051
                                    goto L_0x0053
                                L_0x0051:
                                    r2 = r28
                                L_0x0053:
                                    r14 = r0 & 1024(0x400, float:1.435E-42)
                                    if (r14 == 0) goto L_0x0059
                                    r14 = r6
                                    goto L_0x005b
                                L_0x0059:
                                    r14 = r29
                                L_0x005b:
                                    r0 = r0 & 2048(0x800, float:2.87E-42)
                                    if (r0 == 0) goto L_0x0060
                                    goto L_0x0062
                                L_0x0060:
                                    r6 = r30
                                L_0x0062:
                                    r17 = r15
                                    r18 = r16
                                    r19 = r1
                                    r20 = r3
                                    r22 = r5
                                    r23 = r7
                                    r24 = r8
                                    r25 = r9
                                    r27 = r11
                                    r29 = r13
                                    r30 = r2
                                    r31 = r14
                                    r32 = r6
                                    r17.<init>(r18, r19, r20, r22, r23, r24, r25, r27, r29, r30, r31, r32)
                                    return
                                */
                                throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo.<init>(java.util.Date, kotlin.Pair, long, int, float, float, long, long, java.lang.String, java.util.Date, boolean, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
                            }

                            public final Date getTargetDate() {
                                return this.targetDate;
                            }

                            public final void setTargetDate(Date date) {
                                Intrinsics.checkNotNullParameter(date, "<set-?>");
                                this.targetDate = date;
                            }

                            public final Pair<Date, Date> getAreaDatePair() {
                                return this.areaDatePair;
                            }

                            public final void setAreaDatePair(Pair<? extends Date, ? extends Date> pair) {
                                this.areaDatePair = pair;
                            }

                            public final long getLabel() {
                                return this.label;
                            }

                            public final void setLabel(long j) {
                                this.label = j;
                            }

                            public final int getType() {
                                return this.type;
                            }

                            public final void setType(int i) {
                                this.type = i;
                            }

                            public final float getMinX() {
                                return this.minX;
                            }

                            public final void setMinX(float f) {
                                this.minX = f;
                            }

                            public final float getMaxX() {
                                return this.maxX;
                            }

                            public final void setMaxX(float f) {
                                this.maxX = f;
                            }

                            public final long getMinTs() {
                                return this.minTs;
                            }

                            public final void setMinTs(long j) {
                                this.minTs = j;
                            }

                            public final long getMaxTs() {
                                return this.maxTs;
                            }

                            public final void setMaxTs(long j) {
                                this.maxTs = j;
                            }

                            public final String getTimeZone() {
                                return this.timeZone;
                            }

                            public final void setTimeZone(String str) {
                                this.timeZone = str;
                            }

                            public final Date getJumpToDate() {
                                return this.jumpToDate;
                            }

                            public final void setJumpToDate(Date date) {
                                this.jumpToDate = date;
                            }

                            public final boolean getNeedRemove() {
                                return this.needRemove;
                            }

                            public final void setNeedRemove(boolean z) {
                                this.needRemove = z;
                            }

                            public final boolean isLoadingRightPage() {
                                return this.isLoadingRightPage;
                            }

                            public final void setLoadingRightPage(boolean z) {
                                this.isLoadingRightPage = z;
                            }

                            public String toString() {
                                return "AreaInfo(targetDate=" + this.targetDate + ",label=" + this.label + ",type=" + this.type + ",minX=" + this.minX + ",maxX=" + this.maxX + ",minTs=" + this.minTs + ",maxTs=" + this.maxTs + ",jumpToDate=" + this.jumpToDate + ",needRemove=" + this.needRemove + ')';
                            }
                        }

                        /* JADX WARNING: Code restructure failed: missing block: B:41:0x0155, code lost:
                            r5 = true;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:42:0x0157, code lost:
                            r5 = false;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:43:0x0159, code lost:
                            r8 = r11.element;
                            r14.L$0 = r7;
                            r14.L$1 = r10;
                            r14.L$2 = r11;
                            r14.L$3 = r12;
                            r14.label = 1;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:44:0x0175, code lost:
                            if (addTmpArea(r8, r1.getSecond(), r10, r5, r14) != r15) goto L_0x0178;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:45:0x0177, code lost:
                            return r15;
                         */
                        /* JADX WARNING: Code restructure failed: missing block: B:46:0x0178, code lost:
                            r4 = r7;
                            r3 = r10;
                            r2 = r11;
                            r1 = r12;
                         */
                        /* JADX WARNING: Removed duplicated region for block: B:14:0x0050  */
                        /* JADX WARNING: Removed duplicated region for block: B:50:0x0188  */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x01a8  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object onJumpToDate(java.util.Date r18, kotlin.coroutines.Continuation<? super kotlin.Unit> r19) {
                            /*
                                r17 = this;
                                r7 = r17
                                r0 = r19
                                boolean r1 = r0 instanceof com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onJumpToDate$1
                                if (r1 == 0) goto L_0x0018
                                r1 = r0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onJumpToDate$1 r1 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onJumpToDate$1) r1
                                int r2 = r1.label
                                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                                r2 = r2 & r3
                                if (r2 == 0) goto L_0x0018
                                int r0 = r1.label
                                int r0 = r0 - r3
                                r1.label = r0
                                goto L_0x001d
                            L_0x0018:
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onJumpToDate$1 r1 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$onJumpToDate$1
                                r1.<init>(r7, r0)
                            L_0x001d:
                                r14 = r1
                                java.lang.Object r0 = r14.result
                                java.lang.Object r15 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r1 = r14.label
                                r8 = 2
                                r2 = 1
                                if (r1 == 0) goto L_0x0050
                                if (r1 == r2) goto L_0x003b
                                if (r1 != r8) goto L_0x0033
                                kotlin.ResultKt.throwOnFailure(r0)
                                goto L_0x01a5
                            L_0x0033:
                                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                                r0.<init>(r1)
                                throw r0
                            L_0x003b:
                                java.lang.Object r1 = r14.L$3
                                kotlin.Pair r1 = (kotlin.Pair) r1
                                java.lang.Object r2 = r14.L$2
                                kotlin.jvm.internal.Ref$LongRef r2 = (kotlin.jvm.internal.Ref.LongRef) r2
                                java.lang.Object r3 = r14.L$1
                                java.util.Date r3 = (java.util.Date) r3
                                java.lang.Object r4 = r14.L$0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r4 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r4
                                kotlin.ResultKt.throwOnFailure(r0)
                                goto L_0x017c
                            L_0x0050:
                                kotlin.ResultKt.throwOnFailure(r0)
                                java.util.Date r10 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r18)
                                kotlin.jvm.internal.Ref$LongRef r11 = new kotlin.jvm.internal.Ref$LongRef
                                r11.<init>()
                                long r0 = r10.getTime()
                                r11.element = r0
                                kotlin.Pair r12 = r7.getTmpAreaDate(r10)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r0 = r17.getTmpArea()
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r1 = r7.areas
                                long r3 = r7.defaultLabel
                                java.lang.Long r3 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r3)
                                java.lang.Object r1 = r1.get(r3)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r1 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo) r1
                                kotlin.Pair r1 = r7.dealUnion(r12, r0, r1)
                                com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                                java.lang.String r5 = "unionWithTmpArea="
                                r4.<init>(r5)
                                java.lang.StringBuilder r4 = r4.append(r1)
                                java.lang.String r4 = r4.toString()
                                java.lang.String r5 = "ChartViewModel"
                                r3.xLogI(r4, r5)
                                if (r1 == 0) goto L_0x0182
                                java.lang.Object r3 = r1.getFirst()
                                java.lang.Number r3 = (java.lang.Number) r3
                                int r3 = r3.intValue()
                                java.lang.String r4 = "remove oldTmpAreaInfo="
                                switch(r3) {
                                    case 0: goto L_0x0139;
                                    case 1: goto L_0x011c;
                                    case 2: goto L_0x010f;
                                    case 3: goto L_0x00f6;
                                    case 4: goto L_0x00ce;
                                    case 5: goto L_0x00a5;
                                    case 6: goto L_0x00ce;
                                    case 7: goto L_0x00f6;
                                    default: goto L_0x00a3;
                                }
                            L_0x00a3:
                                goto L_0x0157
                            L_0x00a5:
                                if (r0 == 0) goto L_0x00b0
                                long r3 = r0.getLabel()
                                r11.element = r3
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                goto L_0x00b1
                            L_0x00b0:
                                r0 = 0
                            L_0x00b1:
                                if (r0 != 0) goto L_0x0155
                                r0 = r7
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r0
                                com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                java.lang.String r4 = "union=5 oldTmpAreaInfo.label=null!!! areas="
                                r3.<init>(r4)
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r4 = r7.areas
                                java.lang.StringBuilder r3 = r3.append(r4)
                                java.lang.String r3 = r3.toString()
                                r0.xLogE(r3, r5)
                                goto L_0x0155
                            L_0x00ce:
                                if (r0 == 0) goto L_0x00d9
                                long r3 = r0.getLabel()
                                r11.element = r3
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                goto L_0x00da
                            L_0x00d9:
                                r0 = 0
                            L_0x00da:
                                if (r0 != 0) goto L_0x0157
                                r0 = r7
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r0
                                com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                                java.lang.String r4 = "union=4 oldTmpAreaInfo=null!!! areas="
                                r3.<init>(r4)
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r4 = r7.areas
                                java.lang.StringBuilder r3 = r3.append(r4)
                                java.lang.String r3 = r3.toString()
                                r0.xLogE(r3, r5)
                                goto L_0x0157
                            L_0x00f6:
                                if (r0 != 0) goto L_0x00f9
                                goto L_0x00fc
                            L_0x00f9:
                                r0.setNeedRemove(r2)
                            L_0x00fc:
                                com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>(r4)
                                java.lang.StringBuilder r0 = r6.append(r0)
                                java.lang.String r0 = r0.toString()
                                r3.d(r0, r5)
                                goto L_0x0157
                            L_0x010f:
                                if (r0 != 0) goto L_0x0112
                                goto L_0x0117
                            L_0x0112:
                                long r3 = r7.defaultLabel
                                r0.setLabel(r3)
                            L_0x0117:
                                long r3 = r7.defaultLabel
                                r11.element = r3
                                goto L_0x0157
                            L_0x011c:
                                if (r0 != 0) goto L_0x011f
                                goto L_0x0122
                            L_0x011f:
                                r0.setNeedRemove(r2)
                            L_0x0122:
                                long r8 = r7.defaultLabel
                                r11.element = r8
                                com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>(r4)
                                java.lang.StringBuilder r0 = r6.append(r0)
                                java.lang.String r0 = r0.toString()
                                r3.d(r0, r5)
                                goto L_0x0157
                            L_0x0139:
                                long r8 = r7.defaultLabel
                                r11.element = r8
                                if (r0 != 0) goto L_0x0140
                                goto L_0x0143
                            L_0x0140:
                                r0.setNeedRemove(r2)
                            L_0x0143:
                                com.microtech.aidexx.utils.LogUtil$Companion r3 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r6 = new java.lang.StringBuilder
                                r6.<init>(r4)
                                java.lang.StringBuilder r0 = r6.append(r0)
                                java.lang.String r0 = r0.toString()
                                r3.d(r0, r5)
                            L_0x0155:
                                r5 = r2
                                goto L_0x0159
                            L_0x0157:
                                r0 = 0
                                r5 = r0
                            L_0x0159:
                                java.lang.Object r0 = r1.getSecond()
                                r3 = r0
                                kotlin.Pair r3 = (kotlin.Pair) r3
                                long r8 = r11.element
                                r14.L$0 = r7
                                r14.L$1 = r10
                                r14.L$2 = r11
                                r14.L$3 = r12
                                r14.label = r2
                                r0 = r17
                                r1 = r8
                                r4 = r10
                                r6 = r14
                                java.lang.Object r0 = r0.addTmpArea(r1, r3, r4, r5, r6)
                                if (r0 != r15) goto L_0x0178
                                return r15
                            L_0x0178:
                                r4 = r7
                                r3 = r10
                                r2 = r11
                                r1 = r12
                            L_0x017c:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                r11 = r2
                                r12 = r3
                                r8 = r4
                                goto L_0x0186
                            L_0x0182:
                                r8 = r7
                                r1 = r12
                                r0 = 0
                                r12 = r10
                            L_0x0186:
                                if (r0 != 0) goto L_0x01a8
                                long r9 = r11.element
                                r0 = 0
                                r14.L$0 = r0
                                r14.L$1 = r0
                                r14.L$2 = r0
                                r14.L$3 = r0
                                r0 = 2
                                r14.label = r0
                                r13 = 0
                                r0 = 8
                                r16 = 0
                                r11 = r1
                                r1 = r15
                                r15 = r0
                                java.lang.Object r0 = addTmpArea$default(r8, r9, r11, r12, r13, r14, r15, r16)
                                if (r0 != r1) goto L_0x01a5
                                return r1
                            L_0x01a5:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            L_0x01a8:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.onJumpToDate(java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        /* JADX WARNING: type inference failed for: r0v28, types: [int] */
                        /* access modifiers changed from: private */
                        /* JADX WARNING: Multi-variable type inference failed */
                        /* JADX WARNING: Removed duplicated region for block: B:20:0x0083  */
                        /* JADX WARNING: Removed duplicated region for block: B:28:0x00c9 A[RETURN] */
                        /* JADX WARNING: Removed duplicated region for block: B:44:0x01fd  */
                        /* JADX WARNING: Removed duplicated region for block: B:52:0x0221  */
                        /* JADX WARNING: Removed duplicated region for block: B:55:0x023d A[RETURN] */
                        /* JADX WARNING: Removed duplicated region for block: B:58:0x0241  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0036  */
                        /* JADX WARNING: Unknown variable types count: 1 */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object addTmpArea(long r31, kotlin.Pair<? extends java.util.Date, ? extends java.util.Date> r33, java.util.Date r34, boolean r35, kotlin.coroutines.Continuation<? super kotlin.Unit> r36) {
                            /*
                                r30 = this;
                                r9 = r30
                                r7 = r31
                                r6 = r33
                                r0 = r34
                                r1 = r36
                                boolean r2 = r1 instanceof com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addTmpArea$1
                                if (r2 == 0) goto L_0x001e
                                r2 = r1
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addTmpArea$1 r2 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addTmpArea$1) r2
                                int r3 = r2.label
                                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                                r3 = r3 & r4
                                if (r3 == 0) goto L_0x001e
                                int r1 = r2.label
                                int r1 = r1 - r4
                                r2.label = r1
                                goto L_0x0023
                            L_0x001e:
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addTmpArea$1 r2 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$addTmpArea$1
                                r2.<init>(r9, r1)
                            L_0x0023:
                                r4 = r2
                                java.lang.Object r1 = r4.result
                                java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r4.label
                                java.lang.String r13 = "ChartViewModel"
                                r14 = 5
                                r12 = 4
                                r11 = 3
                                r10 = 2
                                r15 = 0
                                r3 = 1
                                if (r2 == 0) goto L_0x0083
                                if (r2 == r3) goto L_0x0079
                                if (r2 == r10) goto L_0x0075
                                if (r2 == r11) goto L_0x005d
                                if (r2 == r12) goto L_0x004d
                                if (r2 != r14) goto L_0x0045
                                kotlin.ResultKt.throwOnFailure(r1)
                                goto L_0x023e
                            L_0x0045:
                                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                                r0.<init>(r1)
                                throw r0
                            L_0x004d:
                                int r0 = r4.I$0
                                java.lang.Object r2 = r4.L$0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r2 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r2
                                kotlin.ResultKt.throwOnFailure(r1)
                                r3 = r0
                                r13 = r4
                                r11 = r5
                                r0 = r15
                                r12 = 0
                                goto L_0x021f
                            L_0x005d:
                                long r6 = r4.J$0
                                java.lang.Object r0 = r4.L$2
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo) r0
                                java.lang.Object r2 = r4.L$1
                                kotlin.Pair r2 = (kotlin.Pair) r2
                                java.lang.Object r8 = r4.L$0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r8 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r8
                                kotlin.ResultKt.throwOnFailure(r1)
                                r11 = r5
                                r29 = r13
                                r12 = 0
                                r13 = r4
                                goto L_0x01f5
                            L_0x0075:
                                kotlin.ResultKt.throwOnFailure(r1)
                                goto L_0x00ca
                            L_0x0079:
                                long r2 = r4.J$0
                                java.lang.Object r0 = r4.L$0
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel) r0
                                kotlin.ResultKt.throwOnFailure(r1)
                                goto L_0x00ab
                            L_0x0083:
                                kotlin.ResultKt.throwOnFailure(r1)
                                if (r35 == 0) goto L_0x00cd
                                com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                                java.lang.String r6 = "直接跳转 jumpToDate="
                                r2.<init>(r6)
                                java.lang.StringBuilder r2 = r2.append(r0)
                                java.lang.String r2 = r2.toString()
                                r1.xLogI(r2, r13)
                                r4.L$0 = r9
                                r4.J$0 = r7
                                r4.label = r3
                                java.lang.Object r1 = r9.getJumpDate(r0, r4)
                                if (r1 != r5) goto L_0x00a9
                                return r5
                            L_0x00a9:
                                r2 = r7
                                r0 = r9
                            L_0x00ab:
                                java.util.Date r1 = (java.util.Date) r1
                                r0.resetDataByNewAreaLabel(r2)
                                r4.L$0 = r15
                                r4.label = r10
                                r2 = 0
                                r3 = 1
                                r6 = 0
                                r31 = r0
                                r32 = r2
                                r33 = r1
                                r34 = r4
                                r35 = r3
                                r36 = r6
                                java.lang.Object r0 = notifyToRefreshChart$default(r31, r32, r33, r34, r35, r36)
                                if (r0 != r5) goto L_0x00ca
                                return r5
                            L_0x00ca:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            L_0x00cd:
                                long r1 = r9.defaultLabel
                                int r10 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                                if (r10 != 0) goto L_0x0161
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r10 = r9.areas
                                java.lang.Long r1 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r1)
                                java.lang.Object r1 = r10.get(r1)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r1 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel.AreaInfo) r1
                                if (r1 == 0) goto L_0x010e
                                r1.setTargetDate(r0)
                                r1.setAreaDatePair(r6)
                                java.lang.Object r0 = r33.getFirst()
                                java.util.Date r0 = (java.util.Date) r0
                                long r11 = r0.getTime()
                                r1.setMinTs(r11)
                                com.microtech.aidexx.views.chart.ChartUtil r0 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                java.lang.Object r10 = r33.getSecond()
                                java.util.Date r10 = (java.util.Date) r10
                                long r10 = r10.getTime()
                                float r0 = r0.millSecondToX(r10)
                                r1.setMinX(r0)
                                r10 = r1
                                r29 = r13
                                r1 = 4
                                r2 = 3
                                goto L_0x01b3
                            L_0x010e:
                                java.lang.Object r1 = r33.getFirst()
                                java.util.Date r1 = (java.util.Date) r1
                                long r18 = r1.getTime()
                                java.util.Date r1 = new java.util.Date
                                r1.<init>()
                                long r20 = r1.getTime()
                                com.microtech.aidexx.views.chart.ChartUtil r1 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                java.util.Date r10 = new java.util.Date
                                r10.<init>()
                                long r10 = r10.getTime()
                                float r17 = r1.millSecondToX(r10)
                                com.microtech.aidexx.views.chart.ChartUtil r1 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                java.lang.Object r10 = r33.getSecond()
                                java.util.Date r10 = (java.util.Date) r10
                                long r10 = r10.getTime()
                                float r16 = r1.millSecondToX(r10)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r1 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo
                                r10 = r1
                                r26 = 2816(0xb00, float:3.946E-42)
                                r27 = 0
                                r11 = 0
                                r12 = r15
                                r15 = r11
                                r22 = 0
                                r23 = 0
                                r24 = 0
                                r25 = 0
                                r2 = 3
                                r11 = r34
                                r0 = 4
                                r12 = r33
                                r29 = r13
                                r13 = r31
                                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
                                r1 = r0
                                goto L_0x01b3
                            L_0x0161:
                                r2 = r11
                                r1 = r12
                                r29 = r13
                                java.lang.Object r10 = r33.getFirst()
                                java.util.Date r10 = (java.util.Date) r10
                                long r18 = r10.getTime()
                                java.lang.Object r10 = r33.getSecond()
                                java.util.Date r10 = (java.util.Date) r10
                                long r20 = r10.getTime()
                                com.microtech.aidexx.views.chart.ChartUtil r10 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                java.lang.Object r11 = r33.getFirst()
                                java.util.Date r11 = (java.util.Date) r11
                                long r11 = r11.getTime()
                                float r17 = r10.millSecondToX(r11)
                                com.microtech.aidexx.views.chart.ChartUtil r10 = com.microtech.aidexx.views.chart.ChartUtil.INSTANCE
                                java.lang.Object r11 = r33.getSecond()
                                java.util.Date r11 = (java.util.Date) r11
                                long r11 = r11.getTime()
                                float r16 = r10.millSecondToX(r11)
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo r28 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo
                                r10 = r28
                                r26 = 2816(0xb00, float:3.946E-42)
                                r27 = 0
                                r15 = 1
                                r22 = 0
                                r23 = 0
                                r24 = 0
                                r25 = 0
                                r11 = r34
                                r12 = r33
                                r13 = r31
                                r10.<init>(r11, r12, r13, r15, r16, r17, r18, r20, r22, r23, r24, r25, r26, r27)
                            L_0x01b3:
                                java.lang.Long r0 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r31)
                                android.util.ArrayMap<java.lang.Long, com.microtech.aidexx.ui.main.home.chart.ChartViewModel$AreaInfo> r11 = r9.areas
                                java.util.Map r11 = (java.util.Map) r11
                                r11.put(r0, r10)
                                java.lang.Object r0 = r33.getFirst()
                                r11 = r0
                                java.util.Date r11 = (java.util.Date) r11
                                java.lang.Object r0 = r33.getSecond()
                                r12 = r0
                                java.util.Date r12 = (java.util.Date) r12
                                r4.L$0 = r9
                                r4.L$1 = r6
                                r4.L$2 = r10
                                r4.J$0 = r7
                                r4.label = r2
                                r13 = 0
                                r14 = 4
                                r15 = 0
                                r0 = r30
                                r2 = r1
                                r1 = r11
                                r11 = r2
                                r2 = r12
                                r12 = 0
                                r3 = r13
                                r13 = r4
                                r11 = r5
                                r4 = r31
                                r6 = r13
                                r7 = r14
                                r8 = r15
                                java.lang.Object r1 = loadNextPageData$default(r0, r1, r2, r3, r4, r6, r7, r8)
                                if (r1 != r11) goto L_0x01ef
                                return r11
                            L_0x01ef:
                                r6 = r31
                                r2 = r33
                                r8 = r9
                                r0 = r10
                            L_0x01f5:
                                java.lang.Boolean r1 = (java.lang.Boolean) r1
                                boolean r1 = r1.booleanValue()
                                if (r1 == 0) goto L_0x0241
                                r8.resetDataByNewAreaLabel(r6)
                                java.util.Date r1 = r0.getJumpToDate()
                                if (r1 != 0) goto L_0x020a
                                java.util.Date r1 = r0.getTargetDate()
                            L_0x020a:
                                r13.L$0 = r8
                                r0 = 0
                                r13.L$1 = r0
                                r13.L$2 = r0
                                r13.I$0 = r12
                                r2 = 4
                                r13.label = r2
                                java.lang.Object r1 = r8.getJumpDate(r1, r13)
                                if (r1 != r11) goto L_0x021d
                                return r11
                            L_0x021d:
                                r2 = r8
                                r3 = r12
                            L_0x021f:
                                if (r3 == 0) goto L_0x0222
                                r12 = 1
                            L_0x0222:
                                java.util.Date r1 = (java.util.Date) r1
                                r13.L$0 = r0
                                r0 = 5
                                r13.label = r0
                                r0 = 1
                                r3 = 0
                                r31 = r2
                                r32 = r12
                                r33 = r1
                                r34 = r13
                                r35 = r0
                                r36 = r3
                                java.lang.Object r0 = notifyToRefreshChart$default(r31, r32, r33, r34, r35, r36)
                                if (r0 != r11) goto L_0x023e
                                return r11
                            L_0x023e:
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            L_0x0241:
                                r1 = 1
                                r0.setNeedRemove(r1)
                                com.microtech.aidexx.utils.LogUtil$Companion r0 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                                java.lang.String r3 = "图表跳转制定日期失败 label="
                                r1.<init>(r3)
                                java.lang.StringBuilder r1 = r1.append(r6)
                                java.lang.String r3 = " startD="
                                java.lang.StringBuilder r1 = r1.append(r3)
                                java.lang.Object r3 = r2.getFirst()
                                java.util.Date r3 = (java.util.Date) r3
                                java.lang.String r3 = com.microtech.aidexx.common.ExtendsKt.formatToYMdHm(r3)
                                java.lang.StringBuilder r1 = r1.append(r3)
                                java.lang.String r3 = " endD="
                                java.lang.StringBuilder r1 = r1.append(r3)
                                java.lang.Object r2 = r2.getSecond()
                                java.util.Date r2 = (java.util.Date) r2
                                java.lang.String r2 = com.microtech.aidexx.common.ExtendsKt.formatToYMdHm(r2)
                                java.lang.StringBuilder r1 = r1.append(r2)
                                java.lang.String r1 = r1.toString()
                                r2 = r29
                                r0.xLogE(r1, r2)
                                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                                return r0
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.addTmpArea(long, kotlin.Pair, java.util.Date, boolean, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        static /* synthetic */ Object addTmpArea$default(ChartViewModel chartViewModel, long j, Pair pair, Date date, boolean z, Continuation continuation, int i, Object obj) {
                            if ((i & 8) != 0) {
                                z = false;
                            }
                            return chartViewModel.addTmpArea(j, pair, date, z, continuation);
                        }

                        /* access modifiers changed from: private */
                        /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
                        /* JADX WARNING: Removed duplicated region for block: B:18:0x0062  */
                        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
                        /* Code decompiled incorrectly, please refer to instructions dump. */
                        public final java.lang.Object getJumpDate(java.util.Date r8, kotlin.coroutines.Continuation<? super java.util.Date> r9) {
                            /*
                                r7 = this;
                                boolean r0 = r9 instanceof com.microtech.aidexx.ui.main.home.chart.ChartViewModel$getJumpDate$1
                                if (r0 == 0) goto L_0x0014
                                r0 = r9
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$getJumpDate$1 r0 = (com.microtech.aidexx.ui.main.home.chart.ChartViewModel$getJumpDate$1) r0
                                int r1 = r0.label
                                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                                r1 = r1 & r2
                                if (r1 == 0) goto L_0x0014
                                int r9 = r0.label
                                int r9 = r9 - r2
                                r0.label = r9
                                goto L_0x0019
                            L_0x0014:
                                com.microtech.aidexx.ui.main.home.chart.ChartViewModel$getJumpDate$1 r0 = new com.microtech.aidexx.ui.main.home.chart.ChartViewModel$getJumpDate$1
                                r0.<init>(r7, r9)
                            L_0x0019:
                                java.lang.Object r9 = r0.result
                                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                int r2 = r0.label
                                r3 = 1
                                if (r2 == 0) goto L_0x0036
                                if (r2 != r3) goto L_0x002e
                                java.lang.Object r8 = r0.L$0
                                kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
                                kotlin.ResultKt.throwOnFailure(r9)
                                goto L_0x005e
                            L_0x002e:
                                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                                r8.<init>(r9)
                                throw r8
                            L_0x0036:
                                kotlin.ResultKt.throwOnFailure(r9)
                                kotlin.jvm.internal.Ref$ObjectRef r9 = new kotlin.jvm.internal.Ref$ObjectRef
                                r9.<init>()
                                r9.element = r8
                                com.microtech.aidexx.db.repository.CgmCalibBgRepository r2 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE
                                java.util.Date r4 = com.microtech.aidexx.common.ExtendsKt.getStartOfTheDay(r8)
                                java.util.Date r8 = com.microtech.aidexx.common.ExtendsKt.getEndOfTheDay(r8)
                                com.microtech.aidexx.common.user.UserInfoManager$Companion r5 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                                java.lang.String r5 = r5.getCurShowUserId()
                                r0.L$0 = r9
                                r0.label = r3
                                java.lang.Object r8 = r2.queryCgmByPage((java.util.Date) r4, (java.util.Date) r8, (java.lang.String) r5, (kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.RealCgmHistoryEntity>>) r0)
                                if (r8 != r1) goto L_0x005b
                                return r1
                            L_0x005b:
                                r6 = r9
                                r9 = r8
                                r8 = r6
                            L_0x005e:
                                java.util.List r9 = (java.util.List) r9
                                if (r9 == 0) goto L_0x0084
                                java.util.Collection r9 = (java.util.Collection) r9
                                boolean r0 = r9.isEmpty()
                                if (r0 == 0) goto L_0x006b
                                r9 = 0
                            L_0x006b:
                                java.util.List r9 = (java.util.List) r9
                                if (r9 == 0) goto L_0x0084
                                java.util.Date r0 = new java.util.Date
                                r0.<init>()
                                r1 = 0
                                java.lang.Object r9 = r9.get(r1)
                                com.microtech.aidexx.db.entity.RealCgmHistoryEntity r9 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r9
                                long r1 = r9.getTimestamp()
                                r0.setTime(r1)
                                r8.element = r0
                            L_0x0084:
                                com.microtech.aidexx.utils.LogUtil$Companion r9 = com.microtech.aidexx.utils.LogUtil.Companion
                                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                                java.lang.String r1 = "getJumpDate date="
                                r0.<init>(r1)
                                T r1 = r8.element
                                java.lang.StringBuilder r0 = r0.append(r1)
                                java.lang.String r0 = r0.toString()
                                java.lang.String r1 = "ChartViewModel"
                                r9.xLogI(r0, r1)
                                T r8 = r8.element
                                return r8
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.ui.main.home.chart.ChartViewModel.getJumpDate(java.util.Date, kotlin.coroutines.Continuation):java.lang.Object");
                        }

                        private final void resetDataByNewAreaLabel(long j) {
                            Map linkedHashMap = new LinkedHashMap();
                            for (Map.Entry entry : this.areas.entrySet()) {
                                if (((AreaInfo) entry.getValue()).getNeedRemove()) {
                                    linkedHashMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                            for (Map.Entry entry2 : linkedHashMap.entrySet()) {
                                Object key = entry2.getKey();
                                Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                                removeFromChartSet(((Number) key).longValue());
                                this.areas.remove(entry2.getKey());
                            }
                            this.curLabel = j;
                            resetChartMinTime(j);
                            resetNextPageData();
                        }

                        private final void resetChartMinTime(long j) {
                            Iterator it;
                            Date date;
                            Date date2;
                            LogUtil.Companion.xLogI("resetChartMinTime1 timeMin=" + this.timeMin + " timeMax=" + this.timeMax + " cur=" + ExtendsKt.formatToYMdHm(this.curPageMinDate), TAG);
                            if (!this.areas.isEmpty()) {
                                this.timeMin = Float.valueOf(Float.MAX_VALUE);
                                this.curPageMinDate = new Date();
                            }
                            Collection<AreaInfo> values = this.areas.values();
                            Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
                            Iterator it2 = values.iterator();
                            while (it2.hasNext()) {
                                AreaInfo areaInfo = (AreaInfo) it2.next();
                                if (areaInfo.getLabel() != this.defaultLabel) {
                                    Pair<Date, Date> areaDatePair = areaInfo.getAreaDatePair();
                                    if (areaDatePair == null || (date = areaDatePair.getFirst()) == null) {
                                        date = areaInfo.getTargetDate();
                                    }
                                    long time = date.getTime();
                                    float millSecondToX = ChartUtil.INSTANCE.millSecondToX(areaInfo.getMinTs());
                                    Pair<Date, Date> areaDatePair2 = areaInfo.getAreaDatePair();
                                    if (areaDatePair2 == null || (date2 = areaDatePair2.getSecond()) == null) {
                                        date2 = ExtendsKt.getEndOfTheDay(areaInfo.getTargetDate());
                                    }
                                    long time2 = date2.getTime();
                                    it = it2;
                                    float millSecondToX2 = ChartUtil.INSTANCE.millSecondToX(areaInfo.getMaxTs());
                                    xMaxMin(millSecondToX, -1);
                                    xMaxMin(millSecondToX2, -1);
                                    Date date3 = new Date();
                                    date3.setTime(time);
                                    calDateMaxMin$default(this, date3, -1, false, 4, (Object) null);
                                    Date date4 = new Date();
                                    date4.setTime(time2);
                                    calDateMaxMin$default(this, date4, -1, false, 4, (Object) null);
                                } else {
                                    it = it2;
                                    xMaxMin(areaInfo.getMinX(), -1);
                                    xMaxMin(areaInfo.getMaxX(), -1);
                                    Date date5 = new Date();
                                    date5.setTime(areaInfo.getMinTs());
                                    calDateMaxMin$default(this, date5, -1, false, 4, (Object) null);
                                    Date date6 = new Date();
                                    date6.setTime(areaInfo.getMaxTs());
                                    calDateMaxMin$default(this, date6, -1, false, 4, (Object) null);
                                }
                                it2 = it;
                            }
                            LogUtil.Companion.xLogI("resetChartMinTime2 timeMin=" + this.timeMin + " timeMax=" + this.timeMax + " cur=" + ExtendsKt.formatToYMdHm(this.curPageMinDate), TAG);
                        }

                        private final void removeFromChartSet(long j) {
                            List dataSets;
                            List dataSets2;
                            ScatterData scatterData = getCombinedData().getScatterData();
                            if (!(scatterData == null || (dataSets2 = scatterData.getDataSets()) == null)) {
                                Collection arrayList = new ArrayList();
                                for (Object next : dataSets2) {
                                    if (Intrinsics.areEqual((Object) ((IScatterDataSet) next).getLabel(), (Object) String.valueOf(j))) {
                                        arrayList.add(next);
                                    }
                                }
                                for (IScatterDataSet iScatterDataSet : (List) arrayList) {
                                    dataSets2.remove(iScatterDataSet);
                                    LogUtil.Companion.xLogI("移除tmp " + iScatterDataSet.getClass().getSimpleName() + " label=" + j, TAG);
                                }
                            }
                            LineData lineData = getCombinedData().getLineData();
                            if (lineData != null && (dataSets = lineData.getDataSets()) != null) {
                                Collection arrayList2 = new ArrayList();
                                for (Object next2 : dataSets) {
                                    String label = ((ILineDataSet) next2).getLabel();
                                    Intrinsics.checkNotNullExpressionValue(label, "getLabel(...)");
                                    if (StringsKt.startsWith$default(label, new StringBuilder().append(j).append(Soundex.SILENT_MARKER).toString(), false, 2, (Object) null)) {
                                        arrayList2.add(next2);
                                    }
                                }
                                for (ILineDataSet iLineDataSet : (List) arrayList2) {
                                    dataSets.remove(iLineDataSet);
                                    LogUtil.Companion.xLogI("移除tmp " + iLineDataSet.getClass().getSimpleName() + " label=" + iLineDataSet.getLabel(), TAG);
                                }
                            }
                        }

                        private final void updateLabelOfChartSet(long j, long j2) {
                            List dataSets;
                            List dataSets2;
                            long j3 = j;
                            long j4 = j2;
                            ScatterData scatterData = getCombinedData().getScatterData();
                            if (!(scatterData == null || (dataSets2 = scatterData.getDataSets()) == null)) {
                                Collection arrayList = new ArrayList();
                                for (Object next : dataSets2) {
                                    if (Intrinsics.areEqual((Object) ((IScatterDataSet) next).getLabel(), (Object) String.valueOf(j))) {
                                        arrayList.add(next);
                                    }
                                }
                                for (IScatterDataSet iScatterDataSet : (List) arrayList) {
                                    iScatterDataSet.setLabel(String.valueOf(j2));
                                    LogUtil.Companion.xLogI("更新label " + iScatterDataSet.getClass().getSimpleName() + " oldLabel=" + j3 + " newLabel=" + j4, TAG);
                                }
                            }
                            LineData lineData = getCombinedData().getLineData();
                            if (lineData != null && (dataSets = lineData.getDataSets()) != null) {
                                Collection arrayList2 = new ArrayList();
                                for (Object next2 : dataSets) {
                                    String label = ((ILineDataSet) next2).getLabel();
                                    Intrinsics.checkNotNullExpressionValue(label, "getLabel(...)");
                                    if (StringsKt.startsWith$default(label, new StringBuilder().append(j3).append(Soundex.SILENT_MARKER).toString(), false, 2, (Object) null)) {
                                        arrayList2.add(next2);
                                    }
                                }
                                for (ILineDataSet iLineDataSet : (List) arrayList2) {
                                    String label2 = iLineDataSet.getLabel();
                                    Intrinsics.checkNotNullExpressionValue(label2, "getLabel(...)");
                                    iLineDataSet.setLabel(StringsKt.replace$default(label2, new StringBuilder().append(j3).append(Soundex.SILENT_MARKER).toString(), new StringBuilder().append(j4).append(Soundex.SILENT_MARKER).toString(), false, 4, (Object) null));
                                    LogUtil.Companion.xLogI("更新label " + iLineDataSet.getClass().getSimpleName() + " oldLabel=" + j3 + " newLabel=" + j4, TAG);
                                }
                            }
                        }

                        /* access modifiers changed from: private */
                        public final Pair<Integer, Pair<Date, Date>> dealUnion(Pair<? extends Date, ? extends Date> pair, AreaInfo areaInfo, AreaInfo areaInfo2) {
                            Pair<? extends Date, ? extends Date> pair2 = pair;
                            AreaInfo areaInfo3 = areaInfo;
                            AreaInfo areaInfo4 = areaInfo2;
                            long time = ((Date) pair.getFirst()).getTime();
                            long time2 = ((Date) pair.getSecond()).getTime();
                            long j = 0;
                            long minTs = areaInfo3 != null ? areaInfo.getMinTs() : 0;
                            long maxTs = areaInfo3 != null ? areaInfo.getMaxTs() : 0;
                            if (areaInfo4 != null) {
                                j = areaInfo2.getMinTs();
                            }
                            int i = (time > j ? 1 : (time == j ? 0 : -1));
                            if (i > 0) {
                                return TuplesKt.to(0, pair2);
                            }
                            if (i <= 0 && j <= time2 && time - maxTs > 1000) {
                                Object first = pair.getFirst();
                                Date date = new Date();
                                date.setTime(j - ((long) 1000));
                                Unit unit = Unit.INSTANCE;
                                return TuplesKt.to(1, TuplesKt.to(first, date));
                            } else if (i <= 0 && j <= time2 && time <= maxTs && maxTs <= time2) {
                                Date date2 = new Date();
                                long j2 = (long) 1000;
                                date2.setTime(maxTs + j2);
                                Date date3 = new Date();
                                date3.setTime(j - j2);
                                return TuplesKt.to(2, TuplesKt.to(date2, date3));
                            } else if (j - time2 > 1000 && time - maxTs > 1000) {
                                return TuplesKt.to(3, pair2);
                            } else {
                                int i2 = (time > minTs ? 1 : (time == minTs ? 0 : -1));
                                if (i2 >= 0 && time2 <= maxTs) {
                                    return TuplesKt.to(5, pair2);
                                }
                                if (time <= maxTs && maxTs <= time2) {
                                    Date date4 = new Date();
                                    date4.setTime(maxTs + ((long) 1000));
                                    return TuplesKt.to(4, TuplesKt.to(date4, pair.getSecond()));
                                } else if (i2 <= 0 && minTs <= time2) {
                                    Object first2 = pair.getFirst();
                                    Date date5 = new Date();
                                    date5.setTime(minTs - ((long) 1000));
                                    Unit unit2 = Unit.INSTANCE;
                                    return TuplesKt.to(6, TuplesKt.to(first2, date5));
                                } else if (minTs - time2 > 1000) {
                                    return TuplesKt.to(7, pair2);
                                } else {
                                    LogUtil.Companion.xLogE("未计算出临时区间位置 tmpAreaDate=" + pair2 + " tarAre=" + areaInfo3 + " def=" + areaInfo4, TAG);
                                    return null;
                                }
                            }
                        }

                        private final AreaInfo getTmpArea() {
                            LogUtil.Companion.xLogI("getTmpArea areas=" + this.areas, TAG);
                            Map linkedHashMap = new LinkedHashMap();
                            for (Map.Entry entry : this.areas.entrySet()) {
                                if (((AreaInfo) entry.getValue()).getType() == 1 && !((AreaInfo) entry.getValue()).getNeedRemove()) {
                                    linkedHashMap.put(entry.getKey(), entry.getValue());
                                }
                            }
                            if (!linkedHashMap.isEmpty()) {
                                return (AreaInfo) CollectionsKt.toMutableList(linkedHashMap.values()).get(0);
                            }
                            return null;
                        }

                        private final Pair<Date, Date> getTmpAreaDate(Date date) {
                            Date date2 = new Date();
                            date2.setTime(date.getTime() - TimeUtils.oneDayMillis);
                            Date date3 = new Date();
                            date3.setTime((date.getTime() + 172800000) - ((long) 1000));
                            return TuplesKt.to(date2, date3);
                        }

                        /* access modifiers changed from: private */
                        public final void mergeTmpToDefArea(long j) {
                            AreaInfo areaInfo;
                            AreaInfo areaInfo2 = this.areas.get(Long.valueOf(j));
                            if (areaInfo2 != null && (areaInfo = this.areas.get(Long.valueOf(this.defaultLabel))) != null) {
                                areaInfo.setMinTs(areaInfo2.getMinTs());
                                areaInfo.setMinX(areaInfo2.getMinX());
                                this.areas.remove(Long.valueOf(j));
                                updateLabelOfChartSet(j, this.defaultLabel);
                            }
                        }

                        /* access modifiers changed from: private */
                        public final <T extends BaseEventEntity> Map<Long, List<T>> dataListGroupByLabel(List<? extends T> list) {
                            Map linkedHashMap = new LinkedHashMap();
                            Iterator it = list.iterator();
                            while (true) {
                                long j = -1;
                                if (it.hasNext()) {
                                    Object next = it.next();
                                    BaseEventEntity baseEventEntity = (BaseEventEntity) next;
                                    if (!(baseEventEntity instanceof RealCgmHistoryEntity) || checkCgmHistory((RealCgmHistoryEntity) baseEventEntity)) {
                                        for (Map.Entry entry : this.areas.entrySet()) {
                                            Long l = (Long) entry.getKey();
                                            long j2 = this.defaultLabel;
                                            if (l == null || l.longValue() != j2) {
                                                Date date = this.globalStartDate;
                                                if (date == null || this.globalEndDate == null) {
                                                    Object key = entry.getKey();
                                                    Intrinsics.checkNotNullExpressionValue(key, "<get-key>(...)");
                                                    j = ((Number) key).longValue();
                                                } else {
                                                    Intrinsics.checkNotNull(date);
                                                    long time = date.getTime();
                                                    Date date2 = this.globalEndDate;
                                                    Intrinsics.checkNotNull(date2);
                                                    long time2 = date2.getTime();
                                                    long timestamp = baseEventEntity.getTimestamp();
                                                    if (time <= timestamp && timestamp <= time2) {
                                                        Object key2 = entry.getKey();
                                                        Intrinsics.checkNotNullExpressionValue(key2, "<get-key>(...)");
                                                        j = ((Number) key2).longValue();
                                                    }
                                                }
                                            } else if (this.globalStartDate != null) {
                                                long timestamp2 = baseEventEntity.getTimestamp();
                                                Date date3 = this.globalStartDate;
                                                Intrinsics.checkNotNull(date3);
                                                if (timestamp2 >= date3.getTime()) {
                                                    Object key3 = entry.getKey();
                                                    Intrinsics.checkNotNullExpressionValue(key3, "<get-key>(...)");
                                                    j = ((Number) key3).longValue();
                                                }
                                            } else {
                                                Object key4 = entry.getKey();
                                                Intrinsics.checkNotNullExpressionValue(key4, "<get-key>(...)");
                                                j = ((Number) key4).longValue();
                                            }
                                        }
                                    }
                                    Long valueOf = Long.valueOf(j);
                                    Object obj = linkedHashMap.get(valueOf);
                                    if (obj == null) {
                                        obj = new ArrayList();
                                        linkedHashMap.put(valueOf, obj);
                                    }
                                    ((List) obj).add(next);
                                } else {
                                    Map<Long, List<T>> mutableMap = MapsKt.toMutableMap(linkedHashMap);
                                    mutableMap.remove(-1L);
                                    return mutableMap;
                                }
                            }
                        }

                        /* access modifiers changed from: private */
                        public final boolean deleteEntry(Entry entry, Class<?> cls) {
                            ScatterData scatterData;
                            List dataSets;
                            boolean z = false;
                            for (Map.Entry entry2 : this.areas.entrySet()) {
                                float minX = ((AreaInfo) entry2.getValue()).getMinX();
                                float maxX = ((AreaInfo) entry2.getValue()).getMaxX() + 0.1f;
                                float x = entry.getX();
                                if (minX <= x && x <= maxX && (scatterData = getCombinedData().getScatterData()) != null && (dataSets = scatterData.getDataSets()) != null) {
                                    Intrinsics.checkNotNull(dataSets);
                                    Collection arrayList = new ArrayList();
                                    for (Object next : dataSets) {
                                        IScatterDataSet iScatterDataSet = (IScatterDataSet) next;
                                        if (Intrinsics.areEqual((Object) iScatterDataSet.getClass(), (Object) cls) && Intrinsics.areEqual((Object) iScatterDataSet.getLabel(), (Object) String.valueOf(entry2.getKey()))) {
                                            arrayList.add(next);
                                        }
                                    }
                                    for (IScatterDataSet iScatterDataSet2 : (List) arrayList) {
                                        if (iScatterDataSet2.removeEntry(entry)) {
                                            z = true;
                                        }
                                        LogUtil.Companion.xLogI("删除entry " + iScatterDataSet2.getClass().getSimpleName() + " entry=" + entry, TAG);
                                    }
                                }
                            }
                            return z;
                        }
                    }
