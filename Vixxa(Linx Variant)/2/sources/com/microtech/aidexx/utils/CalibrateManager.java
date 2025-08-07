package com.microtech.aidexx.utils;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0004\n\u0002\b\u0019¨\u0006\f"}, d2 = {"Lcom/microtech/aidexx/utils/CalibrateManager;", "", "()V", "calCalibrate", "", "sensorGlucose", "", "referenceGlucose", "getCalibrateHistorys", "", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CalibrateManager.kt */
public final class CalibrateManager {
    public static final CalibrateManager INSTANCE = new CalibrateManager();

    private CalibrateManager() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00d5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getCalibrateHistorys(kotlin.coroutines.Continuation<? super java.util.List<com.microtech.aidexx.db.entity.CalibrateEntity>> r10) {
        /*
            r9 = this;
            boolean r0 = r10 instanceof com.microtech.aidexx.utils.CalibrateManager$getCalibrateHistorys$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            com.microtech.aidexx.utils.CalibrateManager$getCalibrateHistorys$1 r0 = (com.microtech.aidexx.utils.CalibrateManager$getCalibrateHistorys$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.utils.CalibrateManager$getCalibrateHistorys$1 r0 = new com.microtech.aidexx.utils.CalibrateManager$getCalibrateHistorys$1
            r0.<init>(r9, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r0 = r0.L$0
            java.util.List r0 = (java.util.List) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00d7
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x003a:
            java.lang.Object r2 = r0.L$1
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r4 = r0.L$0
            java.util.List r4 = (java.util.List) r4
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x007a
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r10)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.ui.setting.share.ShareUserInfo r2 = r2.getShareUserInfo()
            if (r2 == 0) goto L_0x005e
            java.lang.String r2 = r2.getDataProviderId()
            if (r2 != 0) goto L_0x0068
        L_0x005e:
            com.microtech.aidexx.common.user.UserInfoManager$Companion r2 = com.microtech.aidexx.common.user.UserInfoManager.Companion
            com.microtech.aidexx.common.user.UserInfoManager r2 = r2.instance()
            java.lang.String r2 = r2.userId()
        L_0x0068:
            com.microtech.aidexx.db.repository.CgmCalibBgRepository r5 = com.microtech.aidexx.db.repository.CgmCalibBgRepository.INSTANCE
            r0.L$0 = r10
            r0.L$1 = r2
            r0.label = r4
            java.lang.Object r4 = r5.queryAllCgm(r2, r0)
            if (r4 != r1) goto L_0x0077
            return r1
        L_0x0077:
            r8 = r4
            r4 = r10
            r10 = r8
        L_0x007a:
            java.util.List r10 = (java.util.List) r10
            if (r10 != 0) goto L_0x0085
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
        L_0x0085:
            java.util.Iterator r10 = r10.iterator()
        L_0x0089:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00c6
            java.lang.Object r5 = r10.next()
            com.microtech.aidexx.db.entity.RealCgmHistoryEntity r5 = (com.microtech.aidexx.db.entity.RealCgmHistoryEntity) r5
            com.microtech.aidexx.db.entity.CalibrateEntity r6 = new com.microtech.aidexx.db.entity.CalibrateEntity
            r6.<init>()
            java.lang.String r7 = r5.getDeviceId()
            if (r7 != 0) goto L_0x00a2
            java.lang.String r7 = ""
        L_0x00a2:
            r6.setDeviceId(r7)
            java.util.Date r7 = r5.getDeviceTime()
            r6.setCalTime(r7)
            int r7 = r5.getSensorIndex()
            r6.setSensorIndex(r7)
            java.lang.Float r5 = r5.getGlucose()
            if (r5 == 0) goto L_0x00be
            float r5 = r5.floatValue()
            goto L_0x00bf
        L_0x00be:
            r5 = 0
        L_0x00bf:
            r6.setReferenceGlucose(r5)
            r4.add(r6)
            goto L_0x0089
        L_0x00c6:
            com.microtech.aidexx.db.dao.CalibrateDao r10 = com.microtech.aidexx.db.dao.CalibrateDao.INSTANCE
            r0.L$0 = r4
            r5 = 0
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r10 = r10.queryByUid(r2, r0)
            if (r10 != r1) goto L_0x00d6
            return r1
        L_0x00d6:
            r0 = r4
        L_0x00d7:
            java.util.List r10 = (java.util.List) r10
            if (r10 != 0) goto L_0x00e2
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            java.util.List r10 = (java.util.List) r10
        L_0x00e2:
            java.util.Collection r10 = (java.util.Collection) r10
            r0.addAll(r10)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.CalibrateManager.getCalibrateHistorys(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final float[] calCalibrate(float f, float f2) {
        float f3;
        float f4;
        float f5 = f;
        float f6 = f2;
        float f7 = f6 / f5;
        if (f7 > 1.0f) {
            double d = (double) 1;
            double d2 = (double) 2;
            double d3 = (1.2d - d) / d2;
            double d4 = d2 / d3;
            double d5 = 1.2d - d3;
            double d6 = (double) f7;
            if (d6 <= d5) {
                return new float[]{f7, 0.0f};
            }
            float exp = (float) ((((d2 * d3) / (d + Math.exp((d5 - d6) * d4))) + d5) - d3);
            f3 = (f6 / exp) - f5;
            f4 = exp;
        } else {
            double d7 = (double) 1;
            double d8 = (double) 2;
            double d9 = (d7 - 0.8d) / d8;
            double d10 = d8 / d9;
            double d11 = 0.8d + d9;
            double d12 = (double) f7;
            if (d12 >= d11) {
                return new float[]{f7, 0.0f};
            }
            f4 = (float) ((((d8 * d9) / (d7 + Math.exp((d11 - d12) * d10))) + d11) - d9);
            f3 = (f6 / f4) - f5;
        }
        LogUtils.Companion.data("calibrate calFactor:" + f4 + " ,offset:" + f3 + " ,sensorGlucose " + f5 + " ,sreferenceGlucose " + f6);
        return new float[]{f4, f3};
    }
}
