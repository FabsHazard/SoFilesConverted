package com.microtech.aidexx.db.dao;

import androidx.exifinterface.media.ExifInterface;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity_;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity_;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity_;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.DietEntity_;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity_;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity_;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity_;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity_;
import com.microtech.aidexx.db.entity.event.UnitEntity;
import com.microtech.aidexx.db.entity.event.UnitEntity_;
import com.microtech.aidexx.db.entity.event.preset.BasePresetEntity;
import com.microtech.aidexx.db.entity.event.preset.BaseSysPreset;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity_;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity_;
import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.Query;
import io.objectbox.query.QueryBuilder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000ð\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010J\u001a\u0004\u0018\u00010K\"\n\b\u0000\u0010L\u0018\u0001*\u00020M2\u0006\u0010N\u001a\u00020OHHø\u0001\u0000¢\u0006\u0002\u0010PJ3\u0010J\u001a\u0004\u0018\u00010K\"\b\b\u0000\u0010L*\u00020M2\u0006\u0010N\u001a\u00020O2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0002\u0010SJ\u001f\u0010T\u001a\u0004\u0018\u00010K\"\n\b\u0000\u0010L\u0018\u0001*\u00020UHHø\u0001\u0000¢\u0006\u0002\u0010VJ\u001f\u0010W\u001a\u0004\u0018\u00010K\"\n\b\u0000\u0010L\u0018\u0001*\u00020MHHø\u0001\u0000¢\u0006\u0002\u0010VJ\u001f\u0010X\u001a\u0004\u0018\u00010K\"\n\b\u0000\u0010L\u0018\u0001*\u00020UHHø\u0001\u0000¢\u0006\u0002\u0010VJ\"\u0010Y\u001a\n\u0012\u0004\u0012\u0002HL\u0018\u00010Z\"\u0004\b\u0000\u0010L2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RJ!\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\\2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0019\u0010]\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\\H@ø\u0001\u0000¢\u0006\u0002\u0010VJ\u001c\u0010^\u001a\f\u0012\u0006\b\u0001\u0012\u00020M\u0018\u00010Z2\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030RJ!\u0010_\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\\2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0019\u0010`\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\\H@ø\u0001\u0000¢\u0006\u0002\u0010VJ$\u0010a\u001a\n\u0012\u0004\u0012\u0002HL\u0018\u00010Z\"\u0004\b\u0000\u0010L2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH\u0002J$\u0010b\u001a\n\u0012\u0004\u0012\u0002HL\u0018\u00010Z\"\u0004\b\u0000\u0010L2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH\u0002J!\u0010c\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\\2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0019\u0010d\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\\H@ø\u0001\u0000¢\u0006\u0002\u0010VJ!\u0010e\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010\\2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u0019\u0010f\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\\H@ø\u0001\u0000¢\u0006\u0002\u0010VJ!\u0010g\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\\2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ\u001c\u0010h\u001a\f\u0012\u0006\b\u0001\u0012\u00020U\u0018\u00010Z2\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030RJ\u001c\u0010i\u001a\f\u0012\u0006\b\u0001\u0012\u00020M\u0018\u00010Z2\n\u0010Q\u001a\u0006\u0012\u0002\b\u00030RJ\u001b\u0010j\u001a\u0004\u0018\u00010K2\u0006\u0010k\u001a\u00020MH@ø\u0001\u0000¢\u0006\u0002\u0010lJ!\u0010m\u001a\u0004\u0018\u00010n2\f\u0010o\u001a\b\u0012\u0004\u0012\u00020M0pH@ø\u0001\u0000¢\u0006\u0002\u0010qJ\u001f\u0010r\u001a\u00020n2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020U0pH@ø\u0001\u0000¢\u0006\u0002\u0010qJ\u001b\u0010t\u001a\u0004\u0018\u00010K2\u0006\u0010u\u001a\u00020UH@ø\u0001\u0000¢\u0006\u0002\u0010vJ\u001f\u0010t\u001a\u00020n2\f\u0010s\u001a\b\u0012\u0004\u0012\u00020w0pH@ø\u0001\u0000¢\u0006\u0002\u0010qJ!\u0010x\u001a\u0004\u0018\u00010n2\f\u0010y\u001a\b\u0012\u0004\u0012\u00020G0pH@ø\u0001\u0000¢\u0006\u0002\u0010qJ!\u0010z\u001a\n\u0012\u0004\u0012\u00020G\u0018\u00010\\2\u0006\u0010{\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ0\u0010|\u001a\b\u0012\u0004\u0012\u00020M0p2\u0006\u0010}\u001a\u00020~2\u0006\u0010\u001a\u00020~2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J0\u0010|\u001a\b\u0012\u0004\u0012\u00020M0p2\u0006\u0010}\u001a\u00020O2\u0006\u0010\u001a\u00020O2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J:\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020O\u0018\u00010p\"\b\b\u0000\u0010L*\u00020M2\u0006\u0010N\u001a\u00020O2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0002\u0010SJ5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010{\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J,\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010{\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J,\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J=\u0010\u0001\u001a\n\u0012\u0004\u0012\u0002HL\u0018\u00010\\\"\u0006\b\u0000\u0010L\u0018\u00012\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002HL0Z2\t\b\u0002\u0010\u0001\u001a\u00020KHHø\u0001\u0000¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010{\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J,\u0010\u0001\u001a\n\u0012\u0004\u0012\u000203\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J&\u0010\u0001\u001a\u0004\u0018\u00010M2\u0006\u0010N\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020~H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J5\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010{\u001a\u00020O2\u0007\u0010\u0001\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J,\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020C\u0018\u00010\\2\u0007\u0010\u0001\u001a\u00020O2\u0006\u0010N\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J\u0014\u0010\u0001\u001a\u0004\u0018\u00010nH@ø\u0001\u0000¢\u0006\u0002\u0010VJ5\u0010\u0001\u001a\u0004\u0018\u0001HL\"\b\b\u0000\u0010L*\u00020M2\u0007\u0010\u0001\u001a\u00020O2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0002\u0010SJ6\u0010\u0001\u001a\u0004\u0018\u0001HL\"\b\b\u0000\u0010L*\u00020M2\u0007\u0010\u0001\u001a\u00020K2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J*\u0010\u0001\u001a\u0004\u0018\u00010n\"\u0004\b\u0000\u0010L2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0003\u0010\u0001JE\u0010\u0001\u001a\u0004\u0018\u00010K\"\b\b\u0000\u0010L*\u00020w2\u0007\u0010\u0001\u001a\u00020O2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0R2\r\u0010 \u0001\u001a\b\u0012\u0004\u0012\u0002HL0ZH@ø\u0001\u0000¢\u0006\u0003\u0010¡\u0001J\u001d\u0010¢\u0001\u001a\u0004\u0018\u00010K2\u0007\u0010\u0001\u001a\u00020OH@ø\u0001\u0000¢\u0006\u0002\u0010PJ=\u0010£\u0001\u001a\u0005\u0018\u00010¤\u0001\"\b\b\u0000\u0010L*\u00020M2\r\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020O0p2\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002HL0RH@ø\u0001\u0000¢\u0006\u0003\u0010¦\u0001R!\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R!\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00048BX\u0002¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\f\u0010\u0007R!\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00048BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\t\u001a\u0004\b\u0010\u0010\u0007R!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u00048BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0014\u0010\u0007R!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u00048BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u0018\u0010\u0007R!\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u00048BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001c\u0010\u0007R!\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001f0\u00048BX\u0002¢\u0006\f\n\u0004\b!\u0010\t\u001a\u0004\b \u0010\u0007R!\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\u00048BX\u0002¢\u0006\f\n\u0004\b%\u0010\t\u001a\u0004\b$\u0010\u0007R!\u0010&\u001a\b\u0012\u0004\u0012\u00020'0\u00048BX\u0002¢\u0006\f\n\u0004\b)\u0010\t\u001a\u0004\b(\u0010\u0007R!\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u00048BX\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b,\u0010\u0007R!\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u00048BX\u0002¢\u0006\f\n\u0004\b1\u0010\t\u001a\u0004\b0\u0010\u0007R!\u00102\u001a\b\u0012\u0004\u0012\u0002030\u00048BX\u0002¢\u0006\f\n\u0004\b5\u0010\t\u001a\u0004\b4\u0010\u0007R!\u00106\u001a\b\u0012\u0004\u0012\u0002070\u00048BX\u0002¢\u0006\f\n\u0004\b9\u0010\t\u001a\u0004\b8\u0010\u0007R!\u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u00048BX\u0002¢\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b<\u0010\u0007R!\u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u00048BX\u0002¢\u0006\f\n\u0004\bA\u0010\t\u001a\u0004\b@\u0010\u0007R!\u0010B\u001a\b\u0012\u0004\u0012\u00020C0\u00048BX\u0002¢\u0006\f\n\u0004\bE\u0010\t\u001a\u0004\bD\u0010\u0007R!\u0010F\u001a\b\u0012\u0004\u0012\u00020G0\u00048BX\u0002¢\u0006\f\n\u0004\bI\u0010\t\u001a\u0004\bH\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u0006§\u0001"}, d2 = {"Lcom/microtech/aidexx/db/dao/EventDao;", "", "()V", "bgBox", "Lio/objectbox/Box;", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "getBgBox", "()Lio/objectbox/Box;", "bgBox$delegate", "Lkotlin/Lazy;", "calBox", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "getCalBox", "calBox$delegate", "cgmBox", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "getCgmBox", "cgmBox$delegate", "dietBox", "Lcom/microtech/aidexx/db/entity/event/DietEntity;", "getDietBox", "dietBox$delegate", "dietSysPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/DietSysPresetEntity;", "getDietSysPresetBox", "dietSysPresetBox$delegate", "dietUsrPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/DietUsrPresetEntity;", "getDietUsrPresetBox", "dietUsrPresetBox$delegate", "insulinBox", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "getInsulinBox", "insulinBox$delegate", "insulinSysPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinSysPresetEntity;", "getInsulinSysPresetBox", "insulinSysPresetBox$delegate", "insulinUsrPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinUsrPresetEntity;", "getInsulinUsrPresetBox", "insulinUsrPresetBox$delegate", "medicineBox", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "getMedicineBox", "medicineBox$delegate", "medicineSysPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/MedicineSysPresetEntity;", "getMedicineSysPresetBox", "medicineSysPresetBox$delegate", "medicineUsrPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/MedicineUsrPresetEntity;", "getMedicineUsrPresetBox", "medicineUsrPresetBox$delegate", "otherBox", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "getOtherBox", "otherBox$delegate", "sportBox", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "getSportBox", "sportBox$delegate", "sportSysPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/SportSysPresetEntity;", "getSportSysPresetBox", "sportSysPresetBox$delegate", "sportUsrPresetBox", "Lcom/microtech/aidexx/db/entity/event/preset/SportUsrPresetEntity;", "getSportUsrPresetBox", "sportUsrPresetBox$delegate", "unitBox", "Lcom/microtech/aidexx/db/entity/event/UnitEntity;", "getUnitBox", "unitBox$delegate", "findMaxEventId", "", "T", "Lcom/microtech/aidexx/db/entity/BaseEventEntity;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clazz", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findMaxPresetId", "Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findMinEventId", "findMinPresetId", "getDeleteStatusProperty", "Lio/objectbox/Property;", "getDietNeedUploadEvent", "", "getDietNeedUploadPreset", "getEventIdPropertyByClazz", "getExerciseNeedUploadEvent", "getExerciseNeedUploadPreset", "getFrontIdProperty", "getIdProperty", "getInsulinNeedUploadEvent", "getInsulinNeedUploadPreset", "getMedicineNeedUploadEvent", "getMedicineNeedUploadPreset", "getOthersNeedUploadEvent", "getPresetIdPropertyByClazz", "getUserIdPropertyByClazz", "insertEvent", "event", "(Lcom/microtech/aidexx/db/entity/BaseEventEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertEvents", "", "events", "", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertPresetData", "list", "insertSysPresetData", "entity", "(Lcom/microtech/aidexx/db/entity/event/preset/BasePresetEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lcom/microtech/aidexx/db/entity/event/preset/BaseSysPreset;", "insertUnit", "data", "loadUnit", "language", "query", "startDate", "Ljava/util/Date;", "endDate", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryDeletedData", "queryDietSysPresetByName", "name", "sysPresetVersion", "queryDietUsrPresetByName", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryInsulinSysPresetByName", "queryInsulinUsrPresetByName", "queryLatestHistory", "timestampProperty", "limit", "(Lio/objectbox/Property;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMedicineSysPresetByName", "queryMedicineUsrPresetByName", "queryNextByTargetDate", "targetDate", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "querySportSysPresetByName", "querySportUsrPresetByName", "removeAllUnit", "removeEventByFrontId", "frontId", "removeEventById", "id", "(JLjava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSysPresetData", "type", "(Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeSysPresetOfOtherVersion", "exceptVersion", "property", "(Ljava/lang/String;Ljava/lang/Class;Lio/objectbox/Property;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "removeUnitOfOtherVersion", "updateDeleteStatusByIds", "", "ids", "(Ljava/util/List;Ljava/lang/Class;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: EventDao.kt */
public final class EventDao {
    public static final EventDao INSTANCE = new EventDao();
    private static final Lazy bgBox$delegate = LazyKt.lazy(EventDao$bgBox$2.INSTANCE);
    private static final Lazy calBox$delegate = LazyKt.lazy(EventDao$calBox$2.INSTANCE);
    private static final Lazy cgmBox$delegate = LazyKt.lazy(EventDao$cgmBox$2.INSTANCE);
    private static final Lazy dietBox$delegate = LazyKt.lazy(EventDao$dietBox$2.INSTANCE);
    private static final Lazy dietSysPresetBox$delegate = LazyKt.lazy(EventDao$dietSysPresetBox$2.INSTANCE);
    private static final Lazy dietUsrPresetBox$delegate = LazyKt.lazy(EventDao$dietUsrPresetBox$2.INSTANCE);
    private static final Lazy insulinBox$delegate = LazyKt.lazy(EventDao$insulinBox$2.INSTANCE);
    private static final Lazy insulinSysPresetBox$delegate = LazyKt.lazy(EventDao$insulinSysPresetBox$2.INSTANCE);
    private static final Lazy insulinUsrPresetBox$delegate = LazyKt.lazy(EventDao$insulinUsrPresetBox$2.INSTANCE);
    private static final Lazy medicineBox$delegate = LazyKt.lazy(EventDao$medicineBox$2.INSTANCE);
    private static final Lazy medicineSysPresetBox$delegate = LazyKt.lazy(EventDao$medicineSysPresetBox$2.INSTANCE);
    private static final Lazy medicineUsrPresetBox$delegate = LazyKt.lazy(EventDao$medicineUsrPresetBox$2.INSTANCE);
    private static final Lazy otherBox$delegate = LazyKt.lazy(EventDao$otherBox$2.INSTANCE);
    private static final Lazy sportBox$delegate = LazyKt.lazy(EventDao$sportBox$2.INSTANCE);
    private static final Lazy sportSysPresetBox$delegate = LazyKt.lazy(EventDao$sportSysPresetBox$2.INSTANCE);
    private static final Lazy sportUsrPresetBox$delegate = LazyKt.lazy(EventDao$sportUsrPresetBox$2.INSTANCE);
    private static final Lazy unitBox$delegate = LazyKt.lazy(EventDao$unitBox$2.INSTANCE);

    private EventDao() {
    }

    private final Box<DietSysPresetEntity> getDietSysPresetBox() {
        return (Box) dietSysPresetBox$delegate.getValue();
    }

    private final Box<DietUsrPresetEntity> getDietUsrPresetBox() {
        return (Box) dietUsrPresetBox$delegate.getValue();
    }

    private final Box<SportSysPresetEntity> getSportSysPresetBox() {
        return (Box) sportSysPresetBox$delegate.getValue();
    }

    private final Box<SportUsrPresetEntity> getSportUsrPresetBox() {
        return (Box) sportUsrPresetBox$delegate.getValue();
    }

    private final Box<MedicineSysPresetEntity> getMedicineSysPresetBox() {
        return (Box) medicineSysPresetBox$delegate.getValue();
    }

    private final Box<MedicineUsrPresetEntity> getMedicineUsrPresetBox() {
        return (Box) medicineUsrPresetBox$delegate.getValue();
    }

    private final Box<InsulinSysPresetEntity> getInsulinSysPresetBox() {
        return (Box) insulinSysPresetBox$delegate.getValue();
    }

    private final Box<InsulinUsrPresetEntity> getInsulinUsrPresetBox() {
        return (Box) insulinUsrPresetBox$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Box<InsulinEntity> getInsulinBox() {
        return (Box) insulinBox$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Box<MedicationEntity> getMedicineBox() {
        return (Box) medicineBox$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Box<ExerciseEntity> getSportBox() {
        return (Box) sportBox$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Box<DietEntity> getDietBox() {
        return (Box) dietBox$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final Box<OthersEntity> getOtherBox() {
        return (Box) otherBox$delegate.getValue();
    }

    private final Box<RealCgmHistoryEntity> getCgmBox() {
        return (Box) cgmBox$delegate.getValue();
    }

    private final Box<BloodGlucoseEntity> getBgBox() {
        return (Box) bgBox$delegate.getValue();
    }

    private final Box<CalibrateEntity> getCalBox() {
        return (Box) calBox$delegate.getValue();
    }

    private final Box<UnitEntity> getUnitBox() {
        return (Box) unitBox$delegate.getValue();
    }

    public final Object query(Date date, Date date2, String str, Continuation<? super List<? extends BaseEventEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDao$query$2(date, date2, str, (Continuation<? super EventDao$query$2>) null), continuation);
    }

    public final Object query(String str, String str2, String str3, Continuation<? super List<? extends BaseEventEntity>> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDao$query$4(str, str2, str3, (Continuation<? super EventDao$query$4>) null), continuation);
    }

    public final Object queryNextByTargetDate(String str, Date date, Continuation<? super BaseEventEntity> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new EventDao$queryNextByTargetDate$2(str, date, (Continuation<? super EventDao$queryNextByTargetDate$2>) null), continuation);
    }

    public final Object insertPresetData(List<? extends BasePresetEntity> list, Continuation<? super Unit> continuation) {
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda7(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insertPresetData$lambda$0(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        ObjectBox.INSTANCE.getStore().boxFor(CollectionsKt.first(list).getClass()).put(list);
        return Unit.INSTANCE;
    }

    public final Object insertSysPresetData(List<? extends BaseSysPreset> list, Continuation<? super Unit> continuation) {
        if (list.isEmpty()) {
            return Unit.INSTANCE;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda12(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insertSysPresetData$lambda$1(List list) {
        Intrinsics.checkNotNullParameter(list, "$list");
        ObjectBox.INSTANCE.getStore().boxFor(CollectionsKt.first(list).getClass()).put(list);
        return Unit.INSTANCE;
    }

    public final Object insertSysPresetData(BasePresetEntity basePresetEntity, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda13(basePresetEntity), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long insertSysPresetData$lambda$2(BasePresetEntity basePresetEntity) {
        Intrinsics.checkNotNullParameter(basePresetEntity, "$entity");
        return Long.valueOf(ObjectBox.INSTANCE.getStore().boxFor(basePresetEntity.getClass()).put(basePresetEntity));
    }

    public final <T extends BaseSysPreset> Object removeSysPresetOfOtherVersion(String str, Class<T> cls, Property<T> property, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda10(cls, property, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long removeSysPresetOfOtherVersion$lambda$4(Class cls, Property property, String str) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Intrinsics.checkNotNullParameter(property, "$property");
        Intrinsics.checkNotNullParameter(str, "$exceptVersion");
        Box boxFor = ObjectBox.INSTANCE.getStore().boxFor(cls);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        QueryBuilder query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(property, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        Query build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return Long.valueOf(build.remove());
    }

    public final <T> Object removeSysPresetData(Class<T> cls, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda4(cls), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit removeSysPresetData$lambda$5(Class cls) {
        Intrinsics.checkNotNullParameter(cls, "$type");
        ObjectBox.INSTANCE.getStore().boxFor(cls).removeAll();
        return Unit.INSTANCE;
    }

    public final Property<? extends BasePresetEntity> getPresetIdPropertyByClazz(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (Intrinsics.areEqual((Object) cls, (Object) DietSysPresetEntity.class)) {
            return DietSysPresetEntity_.foodSysPresetId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) DietUsrPresetEntity.class)) {
            return DietUsrPresetEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) SportSysPresetEntity.class)) {
            return SportSysPresetEntity_.exerciseSysPresetId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) SportUsrPresetEntity.class)) {
            return SportUsrPresetEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicineSysPresetEntity.class)) {
            return MedicineSysPresetEntity_.medicationSysPresetId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicineUsrPresetEntity.class)) {
            return MedicineUsrPresetEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinSysPresetEntity.class)) {
            return InsulinSysPresetEntity_.insulinSysPresetId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinUsrPresetEntity.class)) {
            return InsulinUsrPresetEntity_.autoIncrementColumn;
        }
        return null;
    }

    public final /* synthetic */ <T extends BasePresetEntity> Object findMaxPresetId(Continuation<? super Long> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BasePresetEntity> cls = BasePresetEntity.class;
        Class cls2 = cls;
        Property<? extends BasePresetEntity> presetIdPropertyByClazz = getPresetIdPropertyByClazz(cls);
        if (presetIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$findMaxPresetId$3(presetIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao = this;
        return null;
    }

    public final /* synthetic */ <T extends BasePresetEntity> Object findMinPresetId(Continuation<? super Long> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BasePresetEntity> cls = BasePresetEntity.class;
        Class cls2 = cls;
        Property<? extends BasePresetEntity> presetIdPropertyByClazz = getPresetIdPropertyByClazz(cls);
        if (presetIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$findMinPresetId$3(presetIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao = this;
        return null;
    }

    public final Property<? extends BaseEventEntity> getEventIdPropertyByClazz(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (Intrinsics.areEqual((Object) cls, (Object) RealCgmHistoryEntity.class)) {
            return RealCgmHistoryEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            return BloodGlucoseEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) CalibrateEntity.class)) {
            return CalibrateEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            return DietEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            return MedicationEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            return InsulinEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            return ExerciseEntity_.autoIncrementColumn;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            return OthersEntity_.autoIncrementColumn;
        }
        return null;
    }

    public final Property<? extends BaseEventEntity> getUserIdPropertyByClazz(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (Intrinsics.areEqual((Object) cls, (Object) RealCgmHistoryEntity.class)) {
            return RealCgmHistoryEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            return BloodGlucoseEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) CalibrateEntity.class)) {
            return CalibrateEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            return DietEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            return MedicationEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            return InsulinEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            return ExerciseEntity_.userId;
        }
        if (Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            return OthersEntity_.userId;
        }
        return null;
    }

    public final /* synthetic */ <T extends BaseEventEntity> Object findMaxEventId(String str, Continuation<? super Long> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        Property<? extends BaseEventEntity> eventIdPropertyByClazz = getEventIdPropertyByClazz(cls);
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls3 = BaseEventEntity.class;
        Class cls4 = cls3;
        Property<? extends BaseEventEntity> userIdPropertyByClazz = getUserIdPropertyByClazz(cls3);
        if (eventIdPropertyByClazz == null || userIdPropertyByClazz == null) {
            return null;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        Intrinsics.needClassReification();
        BoxStore store = objectBox.getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$findMaxEventId$2(eventIdPropertyByClazz, userIdPropertyByClazz, str), continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final <T extends BaseEventEntity> Object findMaxEventId(String str, Class<T> cls, Continuation<? super Long> continuation) {
        Property<? extends BaseEventEntity> eventIdPropertyByClazz = getEventIdPropertyByClazz(cls);
        Property<? extends BaseEventEntity> userIdPropertyByClazz = getUserIdPropertyByClazz(cls);
        if (eventIdPropertyByClazz == null || userIdPropertyByClazz == null) {
            return null;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda23(cls, eventIdPropertyByClazz, userIdPropertyByClazz, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long findMaxEventId$lambda$9(Class cls, Property property, Property property2, String str) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Intrinsics.checkNotNullParameter(str, "$userId");
        Box boxFor = ObjectBox.INSTANCE.getStore().boxFor(cls);
        Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
        QueryBuilder query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        Intrinsics.checkNotNull(property2, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.findMaxEventId$lambda$9$lambda$8>");
        query.equal(property2, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.findMaxEventId$lambda$9>");
        return Long.valueOf(build.property(property).max());
    }

    public final /* synthetic */ <T extends BaseEventEntity> Object findMinEventId(Continuation<? super Long> continuation) {
        Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
        Class<BaseEventEntity> cls = BaseEventEntity.class;
        Class cls2 = cls;
        Property<? extends BaseEventEntity> eventIdPropertyByClazz = getEventIdPropertyByClazz(cls);
        if (eventIdPropertyByClazz != null) {
            ObjectBox objectBox = ObjectBox.INSTANCE;
            Intrinsics.needClassReification();
            BoxStore store = objectBox.getStore();
            InlineMarker.mark(0);
            Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$findMinEventId$3(eventIdPropertyByClazz), continuation);
            InlineMarker.mark(1);
            return awaitCallInTx;
        }
        EventDao eventDao = this;
        return null;
    }

    public final <T> Property<T> getDeleteStatusProperty(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            Property<BloodGlucoseEntity> property = BloodGlucoseEntity_.deleteStatus;
            Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property;
        } else if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            Property<DietEntity> property2 = DietEntity_.deleteStatus;
            Intrinsics.checkNotNull(property2, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property2;
        } else if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            Property<ExerciseEntity> property3 = ExerciseEntity_.deleteStatus;
            Intrinsics.checkNotNull(property3, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property3;
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            Property<MedicationEntity> property4 = MedicationEntity_.deleteStatus;
            Intrinsics.checkNotNull(property4, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property4;
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            Property<InsulinEntity> property5 = InsulinEntity_.deleteStatus;
            Intrinsics.checkNotNull(property5, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property5;
        } else if (!Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            return null;
        } else {
            Property<OthersEntity> property6 = OthersEntity_.deleteStatus;
            Intrinsics.checkNotNull(property6, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getDeleteStatusProperty>");
            return property6;
        }
    }

    public static /* synthetic */ Object queryLatestHistory$default(EventDao eventDao, Property property, long j, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 15;
        }
        ObjectBox objectBox = ObjectBox.INSTANCE;
        Intrinsics.needClassReification();
        BoxStore store = objectBox.getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$queryLatestHistory$2(j, property), continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final /* synthetic */ <T> Object queryLatestHistory(Property<T> property, long j, Continuation<? super List<T>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        Intrinsics.needClassReification();
        BoxStore store = objectBox.getStore();
        InlineMarker.mark(0);
        Object awaitCallInTx = BoxStoreKt.awaitCallInTx(store, new EventDao$queryLatestHistory$2(j, property), continuation);
        InlineMarker.mark(1);
        return awaitCallInTx;
    }

    public final Object queryDietSysPresetByName(String str, String str2, String str3, Continuation<? super List<DietSysPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda3(str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryDietSysPresetByName$lambda$12(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$language");
        Intrinsics.checkNotNullParameter(str3, "$sysPresetVersion");
        QueryBuilder<DietSysPresetEntity> query = INSTANCE.getDietSysPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(DietSysPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(DietSysPresetEntity_.deleteFlag, 0);
        query.equal(DietSysPresetEntity_.language, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(DietSysPresetEntity_.version, str3, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.order(DietSysPresetEntity_.name);
        Query<DietSysPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object queryDietUsrPresetByName(String str, String str2, Continuation<? super List<DietUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda24(str, str2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryDietUsrPresetByName$lambda$14(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$userId");
        QueryBuilder<DietUsrPresetEntity> query = INSTANCE.getDietUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(DietUsrPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(DietUsrPresetEntity_.userId, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(DietUsrPresetEntity_.deleteFlag, 0);
        query.order(DietUsrPresetEntity_.name);
        Query<DietUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object queryMedicineSysPresetByName(String str, String str2, String str3, Continuation<? super List<MedicineSysPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda11(str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryMedicineSysPresetByName$lambda$16(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$language");
        Intrinsics.checkNotNullParameter(str3, "$sysPresetVersion");
        QueryBuilder<MedicineSysPresetEntity> query = INSTANCE.getMedicineSysPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(MedicineSysPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(MedicineSysPresetEntity_.deleteFlag, 0);
        query.equal(MedicineSysPresetEntity_.language, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(MedicineSysPresetEntity_.version, str3, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.order(MedicineSysPresetEntity_.name);
        Query<MedicineSysPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object queryMedicineUsrPresetByName(String str, String str2, Continuation<? super List<MedicineUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda19(str, str2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryMedicineUsrPresetByName$lambda$18(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$userId");
        QueryBuilder<MedicineUsrPresetEntity> query = INSTANCE.getMedicineUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(MedicineUsrPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(MedicineUsrPresetEntity_.userId, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(MedicineUsrPresetEntity_.deleteFlag, 0);
        query.order(MedicineUsrPresetEntity_.name);
        Query<MedicineUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object queryInsulinSysPresetByName(String str, String str2, String str3, Continuation<? super List<InsulinSysPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda28(str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryInsulinSysPresetByName$lambda$20(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$language");
        Intrinsics.checkNotNullParameter(str3, "$sysPresetVersion");
        QueryBuilder<InsulinSysPresetEntity> query = INSTANCE.getInsulinSysPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(InsulinSysPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(InsulinSysPresetEntity_.deleteFlag, 0);
        query.equal(InsulinSysPresetEntity_.language, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(InsulinSysPresetEntity_.version, str3, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.order(InsulinSysPresetEntity_.name);
        Query<InsulinSysPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object queryInsulinUsrPresetByName(String str, String str2, Continuation<? super List<InsulinUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda29(str, str2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryInsulinUsrPresetByName$lambda$22(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$userId");
        QueryBuilder<InsulinUsrPresetEntity> query = INSTANCE.getInsulinUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(InsulinUsrPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(InsulinUsrPresetEntity_.userId, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(InsulinUsrPresetEntity_.deleteFlag, 0);
        query.order(InsulinUsrPresetEntity_.name);
        Query<InsulinUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object querySportSysPresetByName(String str, String str2, String str3, Continuation<? super List<SportSysPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda2(str, str2, str3), continuation);
    }

    /* access modifiers changed from: private */
    public static final List querySportSysPresetByName$lambda$24(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$language");
        Intrinsics.checkNotNullParameter(str3, "$sysPresetVersion");
        QueryBuilder<SportSysPresetEntity> query = INSTANCE.getSportSysPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(SportSysPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(SportSysPresetEntity_.deleteFlag, 0);
        query.equal(SportSysPresetEntity_.language, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(SportSysPresetEntity_.version, str3, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.order(SportSysPresetEntity_.name);
        Query<SportSysPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object querySportUsrPresetByName(String str, String str2, Continuation<? super List<SportUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda16(str, str2), continuation);
    }

    /* access modifiers changed from: private */
    public static final List querySportUsrPresetByName$lambda$26(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "$name");
        Intrinsics.checkNotNullParameter(str2, "$userId");
        QueryBuilder<SportUsrPresetEntity> query = INSTANCE.getSportUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.contains(SportUsrPresetEntity_.name, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(SportUsrPresetEntity_.userId, str2, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        query.equal(SportUsrPresetEntity_.deleteFlag, 0);
        query.order(SportUsrPresetEntity_.name);
        Query<SportUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object insertEvent(BaseEventEntity baseEventEntity, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda6(baseEventEntity), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long insertEvent$lambda$27(BaseEventEntity baseEventEntity) {
        Intrinsics.checkNotNullParameter(baseEventEntity, "$event");
        return Long.valueOf(ObjectBox.INSTANCE.getStore().boxFor(baseEventEntity.getClass()).put(baseEventEntity));
    }

    public final Object insertEvents(List<? extends BaseEventEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda18(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insertEvents$lambda$28(List list) {
        Intrinsics.checkNotNullParameter(list, "$events");
        ObjectBox.INSTANCE.getStore().boxFor(CollectionsKt.first(list).getClass()).put(list);
        return Unit.INSTANCE;
    }

    public final Object loadUnit(String str, Continuation<? super List<UnitEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda0(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List loadUnit$lambda$30(String str) {
        Intrinsics.checkNotNullParameter(str, "$language");
        QueryBuilder<UnitEntity> query = INSTANCE.getUnitBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        if (str.length() == 0) {
            query.isNull(UnitEntity_.language);
        } else {
            query.equal(UnitEntity_.language, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        }
        Query<UnitEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object insertUnit(List<UnitEntity> list, Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda32(list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit insertUnit$lambda$31(List list) {
        Intrinsics.checkNotNullParameter(list, "$data");
        INSTANCE.getUnitBox().put(list);
        return Unit.INSTANCE;
    }

    public final Object removeUnitOfOtherVersion(String str, Continuation<? super Long> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda5(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final Long removeUnitOfOtherVersion$lambda$33(String str) {
        Intrinsics.checkNotNullParameter(str, "$exceptVersion");
        QueryBuilder<UnitEntity> query = INSTANCE.getUnitBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(UnitEntity_.version, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query<UnitEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return Long.valueOf(build.remove());
    }

    public final Object removeAllUnit(Continuation<? super Unit> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda1(), continuation);
    }

    /* access modifiers changed from: private */
    public static final Unit removeAllUnit$lambda$34() {
        INSTANCE.getUnitBox().removeAll();
        return Unit.INSTANCE;
    }

    public final Object getDietNeedUploadEvent(String str, Continuation<? super List<DietEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda22(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getDietNeedUploadEvent$lambda$36(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<DietEntity> query = INSTANCE.getDietBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(DietEntity_.uploadState, 2);
        query.equal(DietEntity_.deleteStatus, 0);
        query.equal(DietEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.order(DietEntity_.idx);
        Query<DietEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getExerciseNeedUploadEvent(String str, Continuation<? super List<ExerciseEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda8(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getExerciseNeedUploadEvent$lambda$38(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<ExerciseEntity> query = INSTANCE.getSportBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(ExerciseEntity_.uploadState, 2);
        query.equal(ExerciseEntity_.deleteStatus, 0);
        query.equal(ExerciseEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.order(ExerciseEntity_.idx);
        Query<ExerciseEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getMedicineNeedUploadEvent(String str, Continuation<? super List<MedicationEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda27(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getMedicineNeedUploadEvent$lambda$40(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<MedicationEntity> query = INSTANCE.getMedicineBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(MedicationEntity_.uploadState, 2);
        query.equal(MedicationEntity_.deleteStatus, 0);
        query.equal(MedicationEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.order(MedicationEntity_.idx);
        Query<MedicationEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getInsulinNeedUploadEvent(String str, Continuation<? super List<InsulinEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda26(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getInsulinNeedUploadEvent$lambda$42(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<InsulinEntity> query = INSTANCE.getInsulinBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(InsulinEntity_.uploadState, 2);
        query.equal(InsulinEntity_.deleteStatus, 0);
        query.equal(InsulinEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.order(InsulinEntity_.idx);
        Query<InsulinEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getOthersNeedUploadEvent(String str, Continuation<? super List<OthersEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda30(str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getOthersNeedUploadEvent$lambda$44(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        QueryBuilder<OthersEntity> query = INSTANCE.getOtherBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.notEqual(OthersEntity_.uploadState, 2);
        query.equal(OthersEntity_.deleteStatus, 0);
        query.equal(OthersEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
        query.order(OthersEntity_.idx);
        Query<OthersEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getDietNeedUploadPreset(Continuation<? super List<DietUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda9(), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getDietNeedUploadPreset$lambda$46() {
        QueryBuilder<DietUsrPresetEntity> query = INSTANCE.getDietUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.isNull(DietUsrPresetEntity_.autoIncrementColumn);
        Query<DietUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getExerciseNeedUploadPreset(Continuation<? super List<SportUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda14(), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getExerciseNeedUploadPreset$lambda$48() {
        QueryBuilder<SportUsrPresetEntity> query = INSTANCE.getSportUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.isNull(SportUsrPresetEntity_.autoIncrementColumn);
        Query<SportUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getMedicineNeedUploadPreset(Continuation<? super List<MedicineUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda21(), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getMedicineNeedUploadPreset$lambda$50() {
        QueryBuilder<MedicineUsrPresetEntity> query = INSTANCE.getMedicineUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.isNull(MedicineUsrPresetEntity_.autoIncrementColumn);
        Query<MedicineUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    public final Object getInsulinNeedUploadPreset(Continuation<? super List<InsulinUsrPresetEntity>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda20(), continuation);
    }

    /* access modifiers changed from: private */
    public static final List getInsulinNeedUploadPreset$lambda$52() {
        QueryBuilder<InsulinUsrPresetEntity> query = INSTANCE.getInsulinUsrPresetBox().query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.isNull(InsulinUsrPresetEntity_.autoIncrementColumn);
        Query<InsulinUsrPresetEntity> build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build.find();
    }

    private final <T> Property<T> getIdProperty(Class<T> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) RealCgmHistoryEntity.class)) {
            Property<RealCgmHistoryEntity> property = RealCgmHistoryEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property;
        } else if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            Property<BloodGlucoseEntity> property2 = BloodGlucoseEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property2, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property2;
        } else if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            Property<DietEntity> property3 = DietEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property3, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property3;
        } else if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            Property<ExerciseEntity> property4 = ExerciseEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property4, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property4;
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            Property<MedicationEntity> property5 = MedicationEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property5, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property5;
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            Property<InsulinEntity> property6 = InsulinEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property6, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property6;
        } else if (!Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            return null;
        } else {
            Property<OthersEntity> property7 = OthersEntity_.__ID_PROPERTY;
            Intrinsics.checkNotNull(property7, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getIdProperty>");
            return property7;
        }
    }

    public final <T extends BaseEventEntity> Object removeEventById(long j, Class<T> cls, Continuation<? super T> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda15(cls, j), continuation);
    }

    /* access modifiers changed from: private */
    public static final BaseEventEntity removeEventById$lambda$56(Class cls, long j) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Box boxFor = ObjectBox.INSTANCE.getStore().boxFor(cls);
        Property idProperty = INSTANCE.getIdProperty(cls);
        if (idProperty == null) {
            return null;
        }
        Intrinsics.checkNotNull(boxFor);
        QueryBuilder query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(idProperty, j);
        Query build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        BaseEventEntity baseEventEntity = (BaseEventEntity) build.findFirst();
        if (baseEventEntity == null) {
            return null;
        }
        if (baseEventEntity.getDeleteStatus() == 0) {
            baseEventEntity.setDeleteStatus(1);
            boxFor.put(baseEventEntity);
        }
        return baseEventEntity;
    }

    public final <T extends BaseEventEntity> Object removeEventByFrontId(String str, Class<T> cls, Continuation<? super T> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda17(cls, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final BaseEventEntity removeEventByFrontId$lambda$60(Class cls, String str) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Intrinsics.checkNotNullParameter(str, "$frontId");
        Box boxFor = ObjectBox.INSTANCE.getStore().boxFor(cls);
        Property frontIdProperty = INSTANCE.getFrontIdProperty(cls);
        if (frontIdProperty == null) {
            return null;
        }
        Intrinsics.checkNotNull(boxFor);
        QueryBuilder query = boxFor.query();
        Intrinsics.checkNotNullExpressionValue(query, "builder");
        query.equal(frontIdProperty, str, QueryBuilder.StringOrder.CASE_INSENSITIVE);
        Query build = query.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        BaseEventEntity baseEventEntity = (BaseEventEntity) build.findFirst();
        if (baseEventEntity == null) {
            return null;
        }
        if (baseEventEntity.getDeleteStatus() == 0) {
            baseEventEntity.setDeleteStatus(1);
            boxFor.put(baseEventEntity);
        }
        return baseEventEntity;
    }

    public final <T extends BaseEventEntity> Object queryDeletedData(String str, Class<T> cls, Continuation<? super List<String>> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda25(cls, str), continuation);
    }

    /* access modifiers changed from: private */
    public static final List queryDeletedData$lambda$67(Class cls, String str) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Intrinsics.checkNotNullParameter(str, "$userId");
        if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            QueryBuilder<DietEntity> query = INSTANCE.getDietBox().query();
            Intrinsics.checkNotNullExpressionValue(query, "builder");
            query.equal(DietEntity_.deleteStatus, 1);
            query.equal(DietEntity_.uploadState, 2);
            query.equal(DietEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<DietEntity> build = query.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            String[] findStrings = build.property(DietEntity_.foodId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings);
        } else if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            QueryBuilder<ExerciseEntity> query2 = INSTANCE.getSportBox().query();
            Intrinsics.checkNotNullExpressionValue(query2, "builder");
            query2.equal(ExerciseEntity_.deleteStatus, 1);
            query2.equal(ExerciseEntity_.uploadState, 2);
            query2.equal(ExerciseEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<ExerciseEntity> build2 = query2.build();
            Intrinsics.checkNotNullExpressionValue(build2, "builder.build()");
            String[] findStrings2 = build2.property(ExerciseEntity_.exerciseId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings2, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings2);
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            QueryBuilder<MedicationEntity> query3 = INSTANCE.getMedicineBox().query();
            Intrinsics.checkNotNullExpressionValue(query3, "builder");
            query3.equal(MedicationEntity_.deleteStatus, 1);
            query3.equal(MedicationEntity_.uploadState, 2);
            query3.equal(MedicationEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<MedicationEntity> build3 = query3.build();
            Intrinsics.checkNotNullExpressionValue(build3, "builder.build()");
            String[] findStrings3 = build3.property(MedicationEntity_.medicationId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings3, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings3);
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            QueryBuilder<InsulinEntity> query4 = INSTANCE.getInsulinBox().query();
            Intrinsics.checkNotNullExpressionValue(query4, "builder");
            query4.equal(InsulinEntity_.deleteStatus, 1);
            query4.equal(InsulinEntity_.uploadState, 2);
            query4.equal(InsulinEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<InsulinEntity> build4 = query4.build();
            Intrinsics.checkNotNullExpressionValue(build4, "builder.build()");
            String[] findStrings4 = build4.property(InsulinEntity_.insulinId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings4, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings4);
        } else if (Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            QueryBuilder<OthersEntity> query5 = INSTANCE.getOtherBox().query();
            Intrinsics.checkNotNullExpressionValue(query5, "builder");
            query5.equal(OthersEntity_.deleteStatus, 1);
            query5.equal(OthersEntity_.uploadState, 2);
            query5.equal(OthersEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<OthersEntity> build5 = query5.build();
            Intrinsics.checkNotNullExpressionValue(build5, "builder.build()");
            String[] findStrings5 = build5.property(OthersEntity_.otherId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings5, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings5);
        } else if (!Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            return null;
        } else {
            QueryBuilder<BloodGlucoseEntity> query6 = INSTANCE.getBgBox().query();
            Intrinsics.checkNotNullExpressionValue(query6, "builder");
            query6.equal(BloodGlucoseEntity_.deleteStatus, 1);
            query6.equal(BloodGlucoseEntity_.uploadState, 2);
            query6.equal(BloodGlucoseEntity_.userId, str, QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query<BloodGlucoseEntity> build6 = query6.build();
            Intrinsics.checkNotNullExpressionValue(build6, "builder.build()");
            String[] findStrings6 = build6.property(BloodGlucoseEntity_.bloodGlucoseId).findStrings();
            Intrinsics.checkNotNullExpressionValue(findStrings6, "findStrings(...)");
            return ArraysKt.toList((T[]) (Object[]) findStrings6);
        }
    }

    private final <T> Property<T> getFrontIdProperty(Class<T> cls) {
        if (Intrinsics.areEqual((Object) cls, (Object) BloodGlucoseEntity.class)) {
            Property<BloodGlucoseEntity> property = BloodGlucoseEntity_.bloodGlucoseId;
            Intrinsics.checkNotNull(property, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property;
        } else if (Intrinsics.areEqual((Object) cls, (Object) DietEntity.class)) {
            Property<DietEntity> property2 = DietEntity_.foodId;
            Intrinsics.checkNotNull(property2, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property2;
        } else if (Intrinsics.areEqual((Object) cls, (Object) ExerciseEntity.class)) {
            Property<ExerciseEntity> property3 = ExerciseEntity_.exerciseId;
            Intrinsics.checkNotNull(property3, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property3;
        } else if (Intrinsics.areEqual((Object) cls, (Object) MedicationEntity.class)) {
            Property<MedicationEntity> property4 = MedicationEntity_.medicationId;
            Intrinsics.checkNotNull(property4, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property4;
        } else if (Intrinsics.areEqual((Object) cls, (Object) InsulinEntity.class)) {
            Property<InsulinEntity> property5 = InsulinEntity_.insulinId;
            Intrinsics.checkNotNull(property5, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property5;
        } else if (!Intrinsics.areEqual((Object) cls, (Object) OthersEntity.class)) {
            return null;
        } else {
            Property<OthersEntity> property6 = OthersEntity_.otherId;
            Intrinsics.checkNotNull(property6, "null cannot be cast to non-null type io.objectbox.Property<T of com.microtech.aidexx.db.dao.EventDao.getFrontIdProperty>");
            return property6;
        }
    }

    public final <T extends BaseEventEntity> Object updateDeleteStatusByIds(List<String> list, Class<T> cls, Continuation<? super Boolean> continuation) {
        ObjectBox objectBox = ObjectBox.INSTANCE;
        return BoxStoreKt.awaitCallInTx(objectBox.getStore(), new EventDao$$ExternalSyntheticLambda31(cls, list), continuation);
    }

    /* access modifiers changed from: private */
    public static final Boolean updateDeleteStatusByIds$lambda$73(Class cls, List list) {
        Intrinsics.checkNotNullParameter(cls, "$clazz");
        Intrinsics.checkNotNullParameter(list, "$ids");
        Property frontIdProperty = INSTANCE.getFrontIdProperty(cls);
        boolean z = false;
        if (frontIdProperty != null) {
            Box boxFor = ObjectBox.INSTANCE.getStore().boxFor(cls);
            Intrinsics.checkNotNullExpressionValue(boxFor, "boxFor(...)");
            QueryBuilder query = boxFor.query();
            Intrinsics.checkNotNullExpressionValue(query, "builder");
            query.in(frontIdProperty, (String[]) list.toArray(new String[0]), QueryBuilder.StringOrder.CASE_SENSITIVE);
            Query build = query.build();
            Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
            List find = build.find();
            Intrinsics.checkNotNullExpressionValue(find, "find(...)");
            Iterable<BaseEventEntity> iterable = find;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (BaseEventEntity baseEventEntity : iterable) {
                baseEventEntity.setDeleteStatus(2);
                arrayList.add(baseEventEntity);
            }
            Collection collection = (List) arrayList;
            if (collection.isEmpty()) {
                collection = null;
            }
            List list2 = (List) collection;
            if (list2 != null) {
                ObjectBox.INSTANCE.getStore().boxFor(cls).put(list2);
            }
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
