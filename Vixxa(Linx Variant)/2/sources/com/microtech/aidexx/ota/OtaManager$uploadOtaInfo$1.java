package com.microtech.aidexx.ota;

import androidx.exifinterface.media.ExifInterface;
import com.google.gson.Gson;
import com.microtech.aidexx.common.net.ApiResult;
import com.microtech.aidexx.common.net.entity.OtaInfo;
import com.microtech.aidexx.common.net.repository.ApiRepository;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ota.OtaManager$uploadOtaInfo$1", f = "OtaManager.kt", i = {0}, l = {595}, m = "invokeSuspend", n = {"it"}, s = {"L$0"})
/* compiled from: OtaManager.kt */
final class OtaManager$uploadOtaInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;

    OtaManager$uploadOtaInfo$1(Continuation<? super OtaManager$uploadOtaInfo$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new OtaManager$uploadOtaInfo$1(continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((OtaManager$uploadOtaInfo$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        String str;
        String str2;
        CharSequence appNewVersion;
        CharSequence bootNewVersion;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence otaInfo = MmkvManager.INSTANCE.getOtaInfo();
            if (otaInfo.length() == 0) {
                otaInfo = null;
            }
            String str3 = (String) otaInfo;
            if (str3 != null) {
                OtaInfo otaInfo2 = (OtaInfo) new Gson().fromJson(str3, OtaInfo.class);
                if (Intrinsics.areEqual((Object) otaInfo2.getNeedOta(), (Object) Boxing.boxBoolean(false)) && Intrinsics.areEqual((Object) otaInfo2.getNeedDpu(), (Object) Boxing.boxBoolean(false))) {
                    String tag = OtaManager.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(tag, "<get-TAG>(...)");
                    LogUtil.Companion.xLogE("not need upload " + str3, tag);
                    return Unit.INSTANCE;
                } else if (Intrinsics.areEqual((Object) otaInfo2.getNeedOta(), (Object) Boxing.boxBoolean(true)) && ((appNewVersion = otaInfo2.getAppNewVersion()) == null || appNewVersion.length() == 0 || (bootNewVersion = otaInfo2.getBootNewVersion()) == null || bootNewVersion.length() == 0)) {
                    String tag2 = OtaManager.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(tag2, "<get-TAG>(...)");
                    LogUtil.Companion.xLogE("not need upload " + str3, tag2);
                    return Unit.INSTANCE;
                } else if (!Intrinsics.areEqual((Object) otaInfo2.getCanUpload(), (Object) Boxing.boxBoolean(true))) {
                    String tag3 = OtaManager.Companion.getTAG();
                    Intrinsics.checkNotNullExpressionValue(tag3, "<get-TAG>(...)");
                    LogUtil.Companion.xLogE("otaInfo canUpload = false " + str3, tag3);
                    return Unit.INSTANCE;
                } else {
                    String str4 = "F";
                    if (Intrinsics.areEqual((Object) otaInfo2.getNeedOta(), (Object) Boxing.boxBoolean(true))) {
                        str2 = (!Intrinsics.areEqual((Object) otaInfo2.getAppNewVersion(), (Object) otaInfo2.getAppOldVersion()) || !Intrinsics.areEqual((Object) otaInfo2.getBootNewVersion(), (Object) otaInfo2.getBootOldVersion())) ? ExifInterface.LATITUDE_SOUTH : str4;
                    } else {
                        str2 = "NA";
                    }
                    if (!Intrinsics.areEqual((Object) otaInfo2.getNeedDpu(), (Object) Boxing.boxBoolean(true))) {
                        str4 = "NA";
                    } else if (!Intrinsics.areEqual((Object) otaInfo2.getDpNewVersion(), (Object) otaInfo2.getDpOldVersion())) {
                        str4 = ExifInterface.LATITUDE_SOUTH;
                    }
                    otaInfo2.setResult("OTA:" + str2 + ",SETTING:" + str4);
                    StringBuilder sb = new StringBuilder();
                    sb.append("APP:" + otaInfo2.getAppNewVersion() + ',');
                    sb.append("BOOT:" + otaInfo2.getBootNewVersion() + ',');
                    sb.append("SETTING:" + otaInfo2.getDpNewVersion());
                    String sb2 = sb.toString();
                    Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
                    otaInfo2.setNewVersion(sb2);
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("APP:" + otaInfo2.getAppOldVersion() + ',');
                    sb3.append("BOOT:" + otaInfo2.getBootOldVersion() + ',');
                    sb3.append("SETTING:" + otaInfo2.getDpOldVersion());
                    String sb4 = sb3.toString();
                    Intrinsics.checkNotNullExpressionValue(sb4, "toString(...)");
                    otaInfo2.setOldVersion(sb4);
                    ApiRepository apiRepository = ApiRepository.INSTANCE;
                    List listOf = CollectionsKt.listOf(otaInfo2.getUpdateInfo());
                    this.L$0 = str3;
                    this.label = 1;
                    Object saveOtaResultBatch = apiRepository.saveOtaResultBatch(listOf, this);
                    if (saveOtaResultBatch == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    str = str3;
                    obj = saveOtaResultBatch;
                }
            }
            return Unit.INSTANCE;
        } else if (i == 1) {
            str = (String) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ApiResult apiResult = (ApiResult) obj;
        if (apiResult instanceof ApiResult.Success) {
            MmkvManager.INSTANCE.setOtaInfo("");
        } else if (apiResult instanceof ApiResult.Failure) {
            ApiResult.Failure failure = (ApiResult.Failure) apiResult;
            LogUtil.Companion.xLogE$default(LogUtil.Companion, "ota 升级信息=" + str + " 上传失败 c=" + failure.getCode() + " msg=" + failure.getMsg(), (String) null, 2, (Object) null);
        }
        return Unit.INSTANCE;
    }
}
