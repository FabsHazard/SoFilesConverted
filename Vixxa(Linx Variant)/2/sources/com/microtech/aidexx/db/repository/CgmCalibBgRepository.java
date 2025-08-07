package com.microtech.aidexx.db.repository;

import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.dao.BloodGlucoseDao;
import com.microtech.aidexx.db.dao.CalibrateDao;
import com.microtech.aidexx.db.dao.CgmHistoryDao;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J%\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tJ!\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00110\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ!\u0010\u0012\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\rH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ#\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J3\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ3\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ3\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ3\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ3\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ3\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00142\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001bJ%\u0010\u001e\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010 J%\u0010!\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010 \u0002\u0004\n\u0002\b\u0019¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/db/repository/CgmCalibBgRepository;", "", "()V", "checkHasData", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "date", "Ljava/util/Date;", "userId", "", "(Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertBg", "", "list", "", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertCal", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "insertCgm", "queryAllCgm", "", "uid", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryBgByPage", "startDate", "endDate", "(Ljava/util/Date;Ljava/util/Date;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryCalByPage", "queryCgmByPage", "queryNextBgByTargetDate", "targetDate", "(Ljava/lang/String;Ljava/util/Date;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryNextByTargetDate", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CgmCalibBgRepository.kt */
public final class CgmCalibBgRepository {
    public static final CgmCalibBgRepository INSTANCE = new CgmCalibBgRepository();

    private CgmCalibBgRepository() {
    }

    public static /* synthetic */ Object checkHasData$default(CgmCalibBgRepository cgmCalibBgRepository, Date date, String str, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.checkHasData(date, str, continuation);
    }

    public final Object checkHasData(Date date, String str, Continuation<? super RealCgmHistoryEntity> continuation) {
        return CgmHistoryDao.INSTANCE.checkHasDataByAppTime(date, str, continuation);
    }

    public static /* synthetic */ Object queryAllCgm$default(CgmCalibBgRepository cgmCalibBgRepository, String str, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryAllCgm(str, continuation);
    }

    public final Object queryAllCgm(String str, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        return CgmHistoryDao.INSTANCE.queryByUid(str, continuation);
    }

    public static /* synthetic */ Object queryCgmByPage$default(CgmCalibBgRepository cgmCalibBgRepository, Date date, Date date2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryCgmByPage(date, date2, str, (Continuation<? super List<RealCgmHistoryEntity>>) continuation);
    }

    public final Object queryCgmByPage(Date date, Date date2, String str, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        return CgmHistoryDao.INSTANCE.query(date, date2, str, continuation);
    }

    public static /* synthetic */ Object queryCgmByPage$default(CgmCalibBgRepository cgmCalibBgRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryCgmByPage(str, str2, str3, (Continuation<? super List<RealCgmHistoryEntity>>) continuation);
    }

    public final Object queryCgmByPage(String str, String str2, String str3, Continuation<? super List<RealCgmHistoryEntity>> continuation) {
        return CgmHistoryDao.INSTANCE.query(str, str2, str3, continuation);
    }

    public static /* synthetic */ Object queryNextByTargetDate$default(CgmCalibBgRepository cgmCalibBgRepository, String str, Date date, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryNextByTargetDate(str, date, continuation);
    }

    public final Object queryNextByTargetDate(String str, Date date, Continuation<? super RealCgmHistoryEntity> continuation) {
        return CgmHistoryDao.INSTANCE.queryNextByTargetDate(str, date, continuation);
    }

    public final Object insertCgm(List<RealCgmHistoryEntity> list, Continuation<? super Unit> continuation) {
        return CgmHistoryDao.INSTANCE.insert(list, continuation);
    }

    public static /* synthetic */ Object queryBgByPage$default(CgmCalibBgRepository cgmCalibBgRepository, Date date, Date date2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryBgByPage(date, date2, str, (Continuation<? super List<BloodGlucoseEntity>>) continuation);
    }

    public final Object queryBgByPage(Date date, Date date2, String str, Continuation<? super List<BloodGlucoseEntity>> continuation) {
        return BloodGlucoseDao.INSTANCE.query(date, date2, str, continuation);
    }

    public static /* synthetic */ Object queryBgByPage$default(CgmCalibBgRepository cgmCalibBgRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryBgByPage(str, str2, str3, (Continuation<? super List<BloodGlucoseEntity>>) continuation);
    }

    public final Object queryBgByPage(String str, String str2, String str3, Continuation<? super List<BloodGlucoseEntity>> continuation) {
        return BloodGlucoseDao.INSTANCE.query(str, str2, str3, continuation);
    }

    public static /* synthetic */ Object queryNextBgByTargetDate$default(CgmCalibBgRepository cgmCalibBgRepository, String str, Date date, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryNextBgByTargetDate(str, date, continuation);
    }

    public final Object queryNextBgByTargetDate(String str, Date date, Continuation<? super BloodGlucoseEntity> continuation) {
        return BloodGlucoseDao.INSTANCE.queryNextByTargetDate(str, date, continuation);
    }

    public final Object insertBg(List<BloodGlucoseEntity> list, Continuation<? super Unit> continuation) {
        return BloodGlucoseDao.INSTANCE.insert(list, continuation);
    }

    public static /* synthetic */ Object queryCalByPage$default(CgmCalibBgRepository cgmCalibBgRepository, Date date, Date date2, String str, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryCalByPage(date, date2, str, (Continuation<? super List<CalibrateEntity>>) continuation);
    }

    public final Object queryCalByPage(Date date, Date date2, String str, Continuation<? super List<CalibrateEntity>> continuation) {
        return CalibrateDao.INSTANCE.query(date, date2, str, continuation);
    }

    public static /* synthetic */ Object queryCalByPage$default(CgmCalibBgRepository cgmCalibBgRepository, String str, String str2, String str3, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = UserInfoManager.Companion.instance().userId();
        }
        return cgmCalibBgRepository.queryCalByPage(str, str2, str3, (Continuation<? super List<CalibrateEntity>>) continuation);
    }

    public final Object queryCalByPage(String str, String str2, String str3, Continuation<? super List<CalibrateEntity>> continuation) {
        return CalibrateDao.INSTANCE.query(str, str2, str3, continuation);
    }

    public final Object insertCal(List<CalibrateEntity> list, Continuation<? super Unit> continuation) {
        return CalibrateDao.INSTANCE.insert(list, continuation);
    }
}
