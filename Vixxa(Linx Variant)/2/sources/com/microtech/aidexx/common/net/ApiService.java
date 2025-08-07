package com.microtech.aidexx.common.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.LongSerializationPolicy;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.ble.device.entity.CloudDeviceInfo;
import com.microtech.aidexx.ble.device.entity.DeviceRegisterInfo;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.HttpsUtil;
import com.microtech.aidexx.common.net.cookie.CookieStore;
import com.microtech.aidexx.common.net.entity.AppInformation;
import com.microtech.aidexx.common.net.entity.BasePageList;
import com.microtech.aidexx.common.net.entity.BaseResponse;
import com.microtech.aidexx.common.net.entity.DeviceHeartBeat;
import com.microtech.aidexx.common.net.entity.MenuEntity;
import com.microtech.aidexx.common.net.entity.OtherDiseasesEntity;
import com.microtech.aidexx.common.net.entity.PolicyUpgradeInfo;
import com.microtech.aidexx.common.net.entity.ReqChangePWD;
import com.microtech.aidexx.common.net.entity.ReqChangePhone;
import com.microtech.aidexx.common.net.entity.ReqDeleteEventIds;
import com.microtech.aidexx.common.net.entity.ReqEmailRegister;
import com.microtech.aidexx.common.net.entity.ReqGetuiLogin;
import com.microtech.aidexx.common.net.entity.ReqGyLogin;
import com.microtech.aidexx.common.net.entity.ReqModifyShareUserInfo;
import com.microtech.aidexx.common.net.entity.ReqOtherDiseases;
import com.microtech.aidexx.common.net.entity.ReqPhoneCodeLogin;
import com.microtech.aidexx.common.net.entity.ReqPhoneVerCode;
import com.microtech.aidexx.common.net.entity.ReqPwdLogin;
import com.microtech.aidexx.common.net.entity.ReqSaveOrUpdateEventRecords;
import com.microtech.aidexx.common.net.entity.ReqSaveOtaInfoRecords;
import com.microtech.aidexx.common.net.entity.ReqScanWatchQr;
import com.microtech.aidexx.common.net.entity.ReqSetPWD;
import com.microtech.aidexx.common.net.entity.ReqShareUserInfo;
import com.microtech.aidexx.common.net.entity.ResEventPresetVersion;
import com.microtech.aidexx.common.net.entity.ResLogin;
import com.microtech.aidexx.common.net.entity.TrendInfo;
import com.microtech.aidexx.common.net.entity.UpgradeInfo;
import com.microtech.aidexx.common.net.entity.WelfareInfo;
import com.microtech.aidexx.common.net.interceptors.DataEncryptInterceptor;
import com.microtech.aidexx.common.net.interceptors.HeaderInterceptor;
import com.microtech.aidexx.db.entity.BaseEventEntity;
import com.microtech.aidexx.db.entity.BloodGlucoseEntity;
import com.microtech.aidexx.db.entity.CalibrateEntity;
import com.microtech.aidexx.db.entity.HistoryDeviceInfo;
import com.microtech.aidexx.db.entity.OtaResourceEntity;
import com.microtech.aidexx.db.entity.RealCgmHistoryEntity;
import com.microtech.aidexx.db.entity.SettingsEntity;
import com.microtech.aidexx.db.entity.TimezoneHistoryEntity;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.db.entity.event.DietEntity;
import com.microtech.aidexx.db.entity.event.ExerciseEntity;
import com.microtech.aidexx.db.entity.event.InsulinEntity;
import com.microtech.aidexx.db.entity.event.MedicationEntity;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.db.entity.event.preset.DietUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.InsulinUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.MedicineUsrPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportSysPresetEntity;
import com.microtech.aidexx.db.entity.event.preset.SportUsrPresetEntity;
import com.microtech.aidexx.ui.account.entity.UserPreferenceEntity;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;

@Metadata(d1 = {"\u0000¼\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 Â\u00012\u00020\u0001:\u0002Â\u0001J3\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0014\b\u0001\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJO\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\b2\b\b\u0003\u0010\r\u001a\u00020\b2\b\b\u0003\u0010\u000e\u001a\u00020\b2\b\b\u0003\u0010\u000f\u001a\u00020\b2\b\b\u0003\u0010\u0010\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0011J#\u0010\u0012\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J-\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00130\u00040\u00032\b\b\u0001\u0010\f\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00040\u00032\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J)\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010 \u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010!\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010\"\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010#\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010\u001d\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ'\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010&\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010'\u001a\u00020\u001eH§@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ)\u0010(\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010'\u001a\u00020)H§@ø\u0001\u0000¢\u0006\u0002\u0010*JG\u0010+\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0\u00040\u00032(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010-j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/JC\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0-j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J!\u00101\u001a\b\u0012\u0004\u0012\u0002020\u00032\b\b\u0001\u00103\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J'\u00104\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002050\u00040\u00032\b\b\u0001\u00106\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J#\u00107\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002080\u00130\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J/\u00109\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020:0\u00130\u00040\u00032\n\b\u0001\u0010\u001b\u001a\u0004\u0018\u00010\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J3\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010?\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJC\u0010@\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032$\b\u0001\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0-j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J3\u0010A\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010B0\u00040\u00032\b\b\u0001\u0010C\u001a\u00020\b2\b\b\u0001\u0010D\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010EJ9\u0010F\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010H\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010J\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ\u001d\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020M0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020)0\u00040\u00032\b\b\u0001\u0010O\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J9\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010R\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020S0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010T\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010V\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010X\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ#\u0010Z\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020[0\u00130\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J9\u0010\\\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010^\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010`\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ9\u0010d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0\u00130\u00040\u00032\u0014\b\u0001\u0010=\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0>H§@ø\u0001\u0000¢\u0006\u0002\u0010\tJ/\u0010f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020g0\u00130\u00040\u00032\n\b\u0001\u0010h\u001a\u0004\u0018\u00010iH§@ø\u0001\u0000¢\u0006\u0002\u0010jJ-\u0010k\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0m0\u00040l2\b\b\u0001\u0010n\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u001d\u0010o\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020p0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J#\u0010q\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020s0r0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u001d\u0010t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020u0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J)\u0010v\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020wH§@ø\u0001\u0000¢\u0006\u0002\u0010xJ'\u0010y\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020{H§@ø\u0001\u0000¢\u0006\u0002\u0010|J'\u0010}\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00040\u00032\b\b\u0001\u0010%\u001a\u00020~H§@ø\u0001\u0000¢\u0006\u0002\u0010J*\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J \u0010\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u0003H§@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JV\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0\u00130\u00040\u000320\b\u0001\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0r0-j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020G0r`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J0\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u00130\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001JV\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0\u00130\u00040\u000320\b\u0001\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0r0-j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020I0r`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/JI\u0010\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010\u00040\u00032(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010-j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J*\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020z0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J*\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Q0r0\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020Q0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020U0\u00130\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020U0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020W0r0\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020W0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0r0\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020]0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020a0r0\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020a0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020c0\u00130\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020c0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J8\u0010\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u00010r0\u00040\u00032\u0010\b\u0001\u0010\u001d\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020e0r0\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020e0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J*\u0010\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020<0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010 \u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020Y0\u00130\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020Y0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J6\u0010¡\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020_0\u00130\u00040\u00032\u000f\b\u0001\u0010\u001d\u001a\t\u0012\u0004\u0012\u00020_0\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J*\u0010¢\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\t\b\u0001\u0010%\u001a\u00030£\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010¤\u0001J,\u0010¥\u0001\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00040\u00032\t\b\u0001\u0010'\u001a\u00030¦\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010§\u0001J*\u0010¨\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030©\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J*\u0010«\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\t\b\u0001\u0010%\u001a\u00030©\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J)\u0010¬\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010­\u0001\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J*\u0010®\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\t\b\u0001\u0010%\u001a\u00030©\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J*\u0010¯\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030©\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010ª\u0001J)\u0010°\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010­\u0001\u001a\u00020\bH§@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J*\u0010±\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030²\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010³\u0001J*\u0010´\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030µ\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010¶\u0001JV\u0010·\u0001\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0\u00130\u00040\u000320\b\u0001\u0010\u0006\u001a*\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0r0-j\u0014\u0012\u0004\u0012\u00020\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020K0r`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J*\u0010¸\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\t\b\u0001\u0010%\u001a\u00030¹\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010º\u0001JH\u0010»\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032(\b\u0001\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u00010-j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\u0001`.H§@ø\u0001\u0000¢\u0006\u0002\u0010/J*\u0010¼\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J*\u0010½\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\t\b\u0001\u0010%\u001a\u00030\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010\u0001J+\u0010¾\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00040\u00032\n\b\u0001\u0010¿\u0001\u001a\u00030À\u0001H§@ø\u0001\u0000¢\u0006\u0003\u0010Á\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006Ã\u0001"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiService;", "", "cancelAccount", "Lcom/microtech/aidexx/common/net/ApiResult;", "Lcom/microtech/aidexx/common/net/entity/BaseResponse;", "", "map", "", "", "(Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAppUpdate", "Lcom/microtech/aidexx/common/net/entity/UpgradeInfo;", "appId", "project", "os", "appVersion", "resourceVersion", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkOtaResource", "", "Lcom/microtech/aidexx/db/entity/OtaResourceEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkPrivacyUpdate", "Lcom/microtech/aidexx/common/net/entity/PolicyUpgradeInfo;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkSN", "", "type", "deleteByIdsExercise", "data", "Lcom/microtech/aidexx/common/net/entity/ReqDeleteEventIds;", "(Lcom/microtech/aidexx/common/net/entity/ReqDeleteEventIds;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByIdsFood", "deleteByIdsInsulin", "deleteByIdsMedication", "deleteByIdsOthers", "deleteByIdsShareFollow", "body", "deleteFingerBloodGlucose", "req", "deviceHeartBeat", "Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;", "(Lcom/microtech/aidexx/common/net/entity/DeviceHeartBeat;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceRegister", "Lcom/microtech/aidexx/ble/device/entity/DeviceRegisterInfo;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "(Ljava/util/HashMap;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deviceUnregister", "downloadFile", "Lokhttp3/ResponseBody;", "url", "downloadSetting", "Lcom/microtech/aidexx/db/entity/SettingsEntity;", "userId", "downloadTimezoneHistory", "Lcom/microtech/aidexx/db/entity/TimezoneHistoryEntity;", "findAllDictionaryList", "Lcom/microtech/aidexx/common/net/entity/MenuEntity;", "findAuthorizationInfoById", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "queryMap", "", "findUserAuthorizationList", "genAgp", "getAppInformation", "Lcom/microtech/aidexx/common/net/entity/AppInformation;", "version", "softwareModel", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBloodGlucoseRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/BloodGlucoseEntity;", "getCalibrationList", "Lcom/microtech/aidexx/db/entity/CalibrateEntity;", "getCgmRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/RealCgmHistoryEntity;", "getDevice", "Lcom/microtech/aidexx/ble/device/entity/CloudDeviceInfo;", "getDeviceHeartBeat", "sensorId", "getExerciseRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/ExerciseEntity;", "getExerciseSysPresetList", "Lcom/microtech/aidexx/db/entity/event/preset/SportSysPresetEntity;", "getExerciseUserPresetList", "Lcom/microtech/aidexx/db/entity/event/preset/SportUsrPresetEntity;", "getFoodRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/DietEntity;", "getFoodUserPresetList", "Lcom/microtech/aidexx/db/entity/event/preset/DietUsrPresetEntity;", "getHistoryDevice", "Lcom/microtech/aidexx/db/entity/HistoryDeviceInfo;", "getInsulinRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/InsulinEntity;", "getInsulinUserPresetList", "Lcom/microtech/aidexx/db/entity/event/preset/InsulinUsrPresetEntity;", "getMedicationRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/MedicationEntity;", "getMedicineUserPresetList", "Lcom/microtech/aidexx/db/entity/event/preset/MedicineUsrPresetEntity;", "getOthersRecordsByPageInfo", "Lcom/microtech/aidexx/db/entity/event/OthersEntity;", "getPresetVersion", "Lcom/microtech/aidexx/common/net/entity/ResEventPresetVersion;", "eventType", "", "(Ljava/lang/Integer;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRecentHistories", "Lretrofit2/Call;", "Lcom/microtech/aidexx/common/net/entity/BasePageList;", "params", "getUserInfo", "Lcom/microtech/aidexx/db/entity/UserEntity;", "getUserPreference", "", "Lcom/microtech/aidexx/ui/account/entity/UserPreferenceEntity;", "getWelfareActivity", "Lcom/microtech/aidexx/common/net/entity/WelfareInfo;", "getuiLogin", "Lcom/microtech/aidexx/common/net/entity/ReqGetuiLogin;", "(Lcom/microtech/aidexx/common/net/entity/ReqGetuiLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gyLogin", "Lcom/microtech/aidexx/common/net/entity/ResLogin;", "Lcom/microtech/aidexx/common/net/entity/ReqGyLogin;", "(Lcom/microtech/aidexx/common/net/entity/ReqGyLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginByPassword", "Lcom/microtech/aidexx/common/net/entity/ReqPwdLogin;", "(Lcom/microtech/aidexx/common/net/entity/ReqPwdLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loginOrRegisterByVerificationCodeWithPhone", "Lcom/microtech/aidexx/common/net/entity/ReqPhoneCodeLogin;", "(Lcom/microtech/aidexx/common/net/entity/ReqPhoneCodeLogin;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "postBgHistory", "postBriefHistory", "Lokhttp3/RequestBody;", "(Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "postCalHistory", "postGlucoseTrend", "Lcom/microtech/aidexx/common/net/entity/TrendInfo;", "registerByVerificationCodeWithEmail", "Lcom/microtech/aidexx/common/net/entity/ReqEmailRegister;", "(Lcom/microtech/aidexx/common/net/entity/ReqEmailRegister;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resetPasswordByVerificationCode", "Lcom/microtech/aidexx/common/net/entity/ReqChangePWD;", "(Lcom/microtech/aidexx/common/net/entity/ReqChangePWD;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateExerciseRecord", "Lcom/microtech/aidexx/common/net/entity/ReqSaveOrUpdateEventRecords;", "(Lcom/microtech/aidexx/common/net/entity/ReqSaveOrUpdateEventRecords;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateExerciseUserPreset", "saveOrUpdateFoodRecord", "saveOrUpdateInsulinRecord", "saveOrUpdateMedicationRecord", "saveOrUpdateMedicationUsrPreset", "saveOrUpdateOtherDiseasesUsrPreset", "Lcom/microtech/aidexx/common/net/entity/OtherDiseasesEntity;", "Lcom/microtech/aidexx/common/net/entity/ReqOtherDiseases;", "saveOrUpdateOtherRecord", "saveOrUpdateUserAuthorization", "Lcom/microtech/aidexx/common/net/entity/ReqShareUserInfo;", "(Lcom/microtech/aidexx/common/net/entity/ReqShareUserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveOrUpdateUserFoodPreset", "saveOrUpdateUserInsulinPreset", "saveOtaResultBatch", "Lcom/microtech/aidexx/common/net/entity/ReqSaveOtaInfoRecords;", "(Lcom/microtech/aidexx/common/net/entity/ReqSaveOtaInfoRecords;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scanWatchQr", "Lcom/microtech/aidexx/common/net/entity/ReqScanWatchQr;", "(Lcom/microtech/aidexx/common/net/entity/ReqScanWatchQr;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendChangePhoneVerificationCode", "Lcom/microtech/aidexx/common/net/entity/ReqPhoneVerCode;", "(Lcom/microtech/aidexx/common/net/entity/ReqPhoneVerCode;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendLoginPhoneVerificationCode", "sendRegisterEmailVerificationCode", "email", "sendRegisterPhoneVerificationCode", "sendResetPasswordPhoneVerificationCode", "sendUpdatePasswordEmailVerificationCode", "setPassword", "Lcom/microtech/aidexx/common/net/entity/ReqSetPWD;", "(Lcom/microtech/aidexx/common/net/entity/ReqSetPWD;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateAuthorizationInfo", "Lcom/microtech/aidexx/common/net/entity/ReqModifyShareUserInfo;", "(Lcom/microtech/aidexx/common/net/entity/ReqModifyShareUserInfo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateHistory", "updatePhoneOrEmail", "Lcom/microtech/aidexx/common/net/entity/ReqChangePhone;", "(Lcom/microtech/aidexx/common/net/entity/ReqChangePhone;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserInformation", "uploadSetting", "uploadTimezoneHistory", "userUploadAvatar", "part", "Lokhttp3/MultipartBody$Part;", "(Lokhttp3/MultipartBody$Part;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ApiService.kt */
public interface ApiService {
    public static final Companion Companion = Companion.$$INSTANCE;

    @POST("/backend/aidex-x/user/deleteAccount")
    Object cancelAccount(@Body Map<String, String> map, Continuation<? super ApiResult<BaseResponse>> continuation);

    @GET("/backend/aidex-x/appVersionControl/v2/passCheckToken/getAppVersionList")
    Object checkAppUpdate(@Query("appId") String str, @Query("project") String str2, @Query("os") String str3, @Query("appVersion") String str4, @Query("resourceVersion") String str5, Continuation<? super ApiResult<BaseResponse<UpgradeInfo>>> continuation);

    @GET("/backend/aidex-x/otaSetting/getLastVersionOtaSettingFile")
    Object checkOtaResource(Continuation<? super ApiResult<BaseResponse<List<OtaResourceEntity>>>> continuation);

    @GET("/backend/aidex-x/policy/passCheckToken/getPolicyList")
    Object checkPrivacyUpdate(@Query("appId") String str, Continuation<? super ApiResult<BaseResponse<List<PolicyUpgradeInfo>>>> continuation);

    @GET("/backend/aidex-x/cgmDevice/checkSnFromListBySnNumber")
    Object checkSN(@Query("sn") String str, Continuation<? super ApiResult<BaseResponse<Boolean>>> continuation);

    @POST("/backend/aidex-x/event/exerciseRecord/deleteByIds")
    Object deleteByIdsExercise(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/event/foodRecord/deleteByIds")
    Object deleteByIdsFood(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/event/insulinRecord/deleteByIds")
    Object deleteByIdsInsulin(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/event/medicationRecord/deleteByIds")
    Object deleteByIdsMedication(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/event/otherRecord/deleteByIds")
    Object deleteByIdsOthers(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/userAuthorization/deleteByIds")
    Object deleteByIdsShareFollow(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/bloodGlucoseRecord/deleteFingerBloodGlucose")
    Object deleteFingerBloodGlucose(@Body ReqDeleteEventIds reqDeleteEventIds, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/cgmDevice/deviceHeartBeat")
    Object deviceHeartBeat(@Body DeviceHeartBeat deviceHeartBeat, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/cgmDevice/userDeviceRegister")
    Object deviceRegister(@Body HashMap<String, Object> hashMap, Continuation<? super ApiResult<BaseResponse<DeviceRegisterInfo>>> continuation);

    @POST("/backend/aidex-x/cgmDevice/deviceUnRegister")
    Object deviceUnregister(@Body HashMap<String, String> hashMap, Continuation<? super ApiResult<BaseResponse>> continuation);

    @Streaming
    @GET
    Object downloadFile(@Url String str, Continuation<? super ApiResult<? extends ResponseBody>> continuation);

    @GET("/backend/aidex-x/userSetting/getUserSetting")
    Object downloadSetting(@Query("userId") String str, Continuation<? super ApiResult<BaseResponse<SettingsEntity>>> continuation);

    @GET("/backend/aidex-x/timeChange/getTimeChangeList")
    Object downloadTimezoneHistory(Continuation<? super ApiResult<BaseResponse<List<TimezoneHistoryEntity>>>> continuation);

    @GET("/backend/aidex-x/dictionary/findAllDictionaryList")
    Object findAllDictionaryList(@Query("type") String str, Continuation<? super ApiResult<BaseResponse<List<MenuEntity>>>> continuation);

    @GET("/backend/aidex-x/userAuthorization/findAuthorizationInfoById")
    Object findAuthorizationInfoById(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<ShareUserInfo>>> continuation);

    @GET("/backend/aidex-x/userAuthorization/findUserAuthorizationList")
    Object findUserAuthorizationList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<ShareUserInfo>>>> continuation);

    @POST("/backend/aidex-x/user/pdf")
    Object genAgp(@Body HashMap<String, String> hashMap, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @GET("/backend/aidex-x/appInformation/getAppInformation")
    Object getAppInformation(@Query("version") String str, @Query("softwareModel") String str2, Continuation<? super ApiResult<BaseResponse<AppInformation>>> continuation);

    @GET("/backend/aidex-x/bloodGlucoseRecord/getBloodGlucoseRecordsByPageInfo")
    Object getBloodGlucoseRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<BloodGlucoseEntity>>>> continuation);

    @GET("/backend/aidex-x/cgmCalibration/getCalibrationList")
    Object getCalibrationList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<CalibrateEntity>>>> continuation);

    @GET("/backend/aidex-x/cgmRecord/getCgmRecordsByPageInfo")
    Object getCgmRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<RealCgmHistoryEntity>>>> continuation);

    @GET("/backend/aidex-x/cgmDevice/getUserDeviceInfo")
    Object getDevice(Continuation<? super ApiResult<BaseResponse<CloudDeviceInfo>>> continuation);

    @GET("/backend/aidex-x/cgmDevice/getDeviceHeartBeat")
    Object getDeviceHeartBeat(@Query("sensorId") String str, Continuation<? super ApiResult<BaseResponse<DeviceHeartBeat>>> continuation);

    @GET("/backend/aidex-x/event/exerciseRecord/findExerciseRecordList")
    Object getExerciseRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<ExerciseEntity>>>> continuation);

    @GET("/backend/aidex-x/event/exerciseSysPreset/getExerciseSysPresetList")
    Object getExerciseSysPresetList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<SportSysPresetEntity>>>> continuation);

    @GET("/backend/aidex-x/event/exerciseUsrPreset/getExerciseUserPresetList")
    Object getExerciseUserPresetList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<SportUsrPresetEntity>>>> continuation);

    @GET("/backend/aidex-x/event/foodRecord/findFoodRecordList")
    Object getFoodRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<DietEntity>>>> continuation);

    @GET("/backend/aidex-x/event/foodUsrPreset/findFoodUserPresetList")
    Object getFoodUserPresetList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<DietUsrPresetEntity>>>> continuation);

    @GET("/backend/aidex-x/cgmDevice/getUserDeviceHistory")
    Object getHistoryDevice(Continuation<? super ApiResult<BaseResponse<List<HistoryDeviceInfo>>>> continuation);

    @GET("/backend/aidex-x/event/insulinRecord/findInsulinRecordList")
    Object getInsulinRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<InsulinEntity>>>> continuation);

    @GET("/backend/aidex-x/event/insulinUsrPreset/findInsulinUserPresetList")
    Object getInsulinUserPresetList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<InsulinUsrPresetEntity>>>> continuation);

    @GET("/backend/aidex-x/event/medicationRecord/findMedicationRecordList")
    Object getMedicationRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<MedicationEntity>>>> continuation);

    @GET("/backend/aidex-x/event/medicationUsrPreset/findMedicationUsrPresetList")
    Object getMedicineUserPresetList(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<MedicineUsrPresetEntity>>>> continuation);

    @GET("/backend/aidex-x/event/otherRecord/findOtherRecordList")
    Object getOthersRecordsByPageInfo(@QueryMap Map<String, String> map, Continuation<? super ApiResult<BaseResponse<List<OthersEntity>>>> continuation);

    @GET("/backend/aidex-x/event/getSysPresetVersion")
    Object getPresetVersion(@Query("eventType") Integer num, Continuation<? super ApiResult<BaseResponse<List<ResEventPresetVersion>>>> continuation);

    @GET("/backend/aidex-x/cgm-record/list-recent?{params}")
    Object getRecentHistories(@Path("params") String str, Continuation<? super Call<BaseResponse<BasePageList<RealCgmHistoryEntity>>>> continuation);

    @GET("/backend/aidex-x/user/getUserInfo")
    Object getUserInfo(Continuation<? super ApiResult<BaseResponse<UserEntity>>> continuation);

    @GET("/backend/aidex-x/user-preference")
    Object getUserPreference(Continuation<? super ApiResult<BaseResponse<List<UserPreferenceEntity>>>> continuation);

    @GET("/backend/aidex-x/activity/getActivityList")
    Object getWelfareActivity(Continuation<? super ApiResult<BaseResponse<WelfareInfo>>> continuation);

    @POST("/backend/aidex-x/user/getuiLogin")
    Object getuiLogin(@Body ReqGetuiLogin reqGetuiLogin, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/passCheckToken/gyLogin")
    Object gyLogin(@Body ReqGyLogin reqGyLogin, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation);

    @POST("/backend/aidex-x/user/loginByPassword")
    Object loginByPassword(@Body ReqPwdLogin reqPwdLogin, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation);

    @POST("/backend/aidex-x/user/loginOrRegisterByVerificationCodeWithPhone")
    Object loginOrRegisterByVerificationCodeWithPhone(@Body ReqPhoneCodeLogin reqPhoneCodeLogin, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation);

    @GET("/backend/aidex-x/user/logout")
    Object logout(Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/bloodGlucoseRecord/saveOrUpdateFingerBloodGlucose")
    Object postBgHistory(@Body HashMap<String, List<BloodGlucoseEntity>> hashMap, Continuation<? super ApiResult<BaseResponse<List<BloodGlucoseEntity>>>> continuation);

    @POST("/backend/aidex-x/cgmRecord/saveCgmRecord")
    Object postBriefHistory(@Body RequestBody requestBody, Continuation<? super ApiResult<BaseResponse<List<RealCgmHistoryEntity>>>> continuation);

    @POST("/backend/aidex-x/cgmCalibration/saveCalibration")
    Object postCalHistory(@Body HashMap<String, List<CalibrateEntity>> hashMap, Continuation<? super ApiResult<BaseResponse<List<CalibrateEntity>>>> continuation);

    @POST("/backend/aidex-x/userTrend/saveOrUpdateUserTrend")
    Object postGlucoseTrend(@Body HashMap<String, Object> hashMap, Continuation<? super ApiResult<BaseResponse<TrendInfo>>> continuation);

    @POST("/backend/aidex-x/user/passCheckToken/registerByVerificationCodeWithEmail")
    Object registerByVerificationCodeWithEmail(@Body ReqEmailRegister reqEmailRegister, Continuation<? super ApiResult<BaseResponse<ResLogin>>> continuation);

    @POST("/backend/aidex-x/user/passCheckToken/resetPasswordByVerificationCode")
    Object resetPasswordByVerificationCode(@Body ReqChangePWD reqChangePWD, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/event/exerciseRecord/saveOrUpdateExerciseRecord")
    Object saveOrUpdateExerciseRecord(@Body ReqSaveOrUpdateEventRecords<ExerciseEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<ExerciseEntity>>>> continuation);

    @POST("/backend/aidex-x/event/exerciseUsrPreset/saveOrUpdateExerciseUserPreset")
    Object saveOrUpdateExerciseUserPreset(@Body ReqSaveOrUpdateEventRecords<SportUsrPresetEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<SportUsrPresetEntity>>>> continuation);

    @POST("/backend/aidex-x/event/foodRecord/saveOrUpdateFoodRecord")
    Object saveOrUpdateFoodRecord(@Body ReqSaveOrUpdateEventRecords<DietEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<DietEntity>>>> continuation);

    @POST("/backend/aidex-x/event/insulinRecord/saveOrUpdateInsulinRecord")
    Object saveOrUpdateInsulinRecord(@Body ReqSaveOrUpdateEventRecords<InsulinEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<InsulinEntity>>>> continuation);

    @POST("/backend/aidex-x/event/medicationRecord/saveOrUpdateMedicationRecord")
    Object saveOrUpdateMedicationRecord(@Body ReqSaveOrUpdateEventRecords<MedicationEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<MedicationEntity>>>> continuation);

    @POST("/backend/aidex-x/event/medicationUsrPreset/saveOrUpdateMedicationUsrPreset")
    Object saveOrUpdateMedicationUsrPreset(@Body ReqSaveOrUpdateEventRecords<MedicineUsrPresetEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<MedicineUsrPresetEntity>>>> continuation);

    @POST("/backend/aidex-x/event/otherDiseasesUsrPreset/saveOrUpdateOtherDiseasesUsrPreset")
    Object saveOrUpdateOtherDiseasesUsrPreset(@Body ReqSaveOrUpdateEventRecords<ReqOtherDiseases> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<OtherDiseasesEntity>>>> continuation);

    @POST("/backend/aidex-x/event/otherRecord/saveOrUpdateOtherRecord")
    Object saveOrUpdateOtherRecord(@Body ReqSaveOrUpdateEventRecords<OthersEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<OthersEntity>>>> continuation);

    @POST("/backend/aidex-x/userAuthorization/saveOrUpdateUserAuthorization")
    Object saveOrUpdateUserAuthorization(@Body ReqShareUserInfo reqShareUserInfo, Continuation<? super ApiResult<BaseResponse<ShareUserInfo>>> continuation);

    @POST("/backend/aidex-x/event/foodUsrPreset/saveOrUpdateUserFoodPreset")
    Object saveOrUpdateUserFoodPreset(@Body ReqSaveOrUpdateEventRecords<DietUsrPresetEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<DietUsrPresetEntity>>>> continuation);

    @POST("/backend/aidex-x/event/insulinUsrPreset/saveOrUpdateUserInsulinPreset")
    Object saveOrUpdateUserInsulinPreset(@Body ReqSaveOrUpdateEventRecords<InsulinUsrPresetEntity> reqSaveOrUpdateEventRecords, Continuation<? super ApiResult<BaseResponse<List<InsulinUsrPresetEntity>>>> continuation);

    @POST("/backend/aidex-x/otaSetting/saveOtaResultBatch")
    Object saveOtaResultBatch(@Body ReqSaveOtaInfoRecords reqSaveOtaInfoRecords, Continuation<? super ApiResult<BaseResponse>> continuation);

    @POST("/backend/aidex-x/watch/scan")
    Object scanWatchQr(@Body ReqScanWatchQr reqScanWatchQr, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/sendChangePhoneVerificationCode")
    Object sendChangePhoneVerificationCode(@Body ReqPhoneVerCode reqPhoneVerCode, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/sendLoginPhoneVerificationCode")
    Object sendLoginPhoneVerificationCode(@Body ReqPhoneVerCode reqPhoneVerCode, Continuation<? super ApiResult<BaseResponse>> continuation);

    @GET("/backend/aidex-x/user/sendRegisterEmailVerificationCode")
    Object sendRegisterEmailVerificationCode(@Query("email") String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/sendRegisterPhoneVerificationCode")
    Object sendRegisterPhoneVerificationCode(@Body ReqPhoneVerCode reqPhoneVerCode, Continuation<? super ApiResult<BaseResponse>> continuation);

    @POST("/backend/aidex-x/user/sendResetPasswordPhoneVerificationCode")
    Object sendResetPasswordPhoneVerificationCode(@Body ReqPhoneVerCode reqPhoneVerCode, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @GET("/backend/aidex-x/user/sendUpdatePasswordEmailVerificationCode")
    Object sendUpdatePasswordEmailVerificationCode(@Query("email") String str, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/setPassword")
    Object setPassword(@Body ReqSetPWD reqSetPWD, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/userAuthorization/updateAuthorizationInfo")
    Object updateAuthorizationInfo(@Body ReqModifyShareUserInfo reqModifyShareUserInfo, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/cgmRecord/updateCgmRecord")
    Object updateHistory(@Body HashMap<String, List<RealCgmHistoryEntity>> hashMap, Continuation<? super ApiResult<BaseResponse<List<RealCgmHistoryEntity>>>> continuation);

    @POST("/backend/aidex-x/user/updatePhoneOrEmail")
    Object updatePhoneOrEmail(@Body ReqChangePhone reqChangePhone, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/user/updateUserInformation")
    Object updateUserInformation(@Body HashMap<String, Object> hashMap, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @POST("/backend/aidex-x/userSetting/updateUserSetting")
    Object uploadSetting(@Body RequestBody requestBody, Continuation<? super ApiResult<BaseResponse>> continuation);

    @POST("/backend/aidex-x/timeChange/save")
    Object uploadTimezoneHistory(@Body RequestBody requestBody, Continuation<? super ApiResult<BaseResponse>> continuation);

    @POST("/backend/aidex-x/user/userUploadAvatar")
    @Multipart
    Object userUploadAvatar(@Part MultipartBody.Part part, Continuation<? super ApiResult<BaseResponse<String>>> continuation);

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ApiService.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ Object checkAppUpdate$default(ApiService apiService, String str, String str2, String str3, String str4, String str5, Continuation continuation, int i, Object obj) {
            if (obj == null) {
                if ((i & 2) != 0) {
                    str2 = "aidex-x";
                }
                String str6 = str2;
                if ((i & 4) != 0) {
                    str3 = "android";
                }
                String str7 = str3;
                if ((i & 8) != 0) {
                    str4 = "1.7.1";
                }
                String str8 = str4;
                if ((i & 16) != 0) {
                    str5 = "";
                }
                return apiService.checkAppUpdate(str, str6, str7, str8, str5, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: checkAppUpdate");
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u0002J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0004H\u0002J\b\u0010\u001b\u001a\u00020\u000fH\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\b\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, d2 = {"Lcom/microtech/aidexx/common/net/ApiService$Companion;", "", "()V", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "instance", "Lcom/microtech/aidexx/common/net/ApiService;", "getInstance", "()Lcom/microtech/aidexx/common/net/ApiService;", "instance$delegate", "okClient", "Lokhttp3/OkHttpClient;", "getOkClient", "()Lokhttp3/OkHttpClient;", "okClient$delegate", "afterGsonConvert", "", "result", "checkBizCodeIsSuccess", "", "bodyStr", "", "createGson", "getOkHttpClient", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ApiService.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final Lazy<Gson> gson$delegate = LazyKt.lazy(ApiService$Companion$gson$2.INSTANCE);
        private static final Lazy<ApiService> instance$delegate = LazyKt.lazy(ApiService$Companion$instance$2.INSTANCE);
        private static final Lazy<OkHttpClient> okClient$delegate = LazyKt.lazy(ApiService$Companion$okClient$2.INSTANCE);

        /* access modifiers changed from: private */
        public static final boolean getOkHttpClient$lambda$5(String str, SSLSession sSLSession) {
            return true;
        }

        private Companion() {
        }

        public final OkHttpClient getOkClient() {
            return okClient$delegate.getValue();
        }

        public final Gson getGson() {
            return gson$delegate.getValue();
        }

        public final ApiService getInstance() {
            ApiService value = instance$delegate.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
            return value;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.microtech.aidexx.common.net.BizException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.microtech.aidexx.common.net.BizException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.CharSequence} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: com.microtech.aidexx.common.net.BizException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.microtech.aidexx.common.net.BizException} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: com.microtech.aidexx.common.net.BizException} */
        /* access modifiers changed from: private */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Throwable checkBizCodeIsSuccess(java.lang.String r7) {
            /*
                r6 = this;
                com.google.gson.Gson r0 = r6.getGson()
                java.lang.Class<com.microtech.aidexx.common.net.entity.BaseResponse> r1 = com.microtech.aidexx.common.net.entity.BaseResponse.class
                java.lang.Object r7 = r0.fromJson((java.lang.String) r7, r1)
                com.microtech.aidexx.common.net.entity.BaseResponse r7 = (com.microtech.aidexx.common.net.entity.BaseResponse) r7
                int r0 = r7.getCode()
                r1 = 200(0xc8, float:2.8E-43)
                r2 = 0
                if (r0 == r1) goto L_0x0073
                int r0 = r7.getCode()
                r1 = 800(0x320, float:1.121E-42)
                if (r1 > r0) goto L_0x0022
                r1 = 807(0x327, float:1.131E-42)
                if (r0 >= r1) goto L_0x0022
                goto L_0x0032
            L_0x0022:
                int r0 = r7.getCode()
                r1 = 501(0x1f5, float:7.02E-43)
                if (r0 == r1) goto L_0x0032
                int r0 = r7.getCode()
                r1 = 750(0x2ee, float:1.051E-42)
                if (r0 != r1) goto L_0x004f
            L_0x0032:
                com.microtech.aidexx.common.user.UserInfoManager$Companion r0 = com.microtech.aidexx.common.user.UserInfoManager.Companion
                com.microtech.aidexx.common.user.UserInfoManager r0 = r0.instance()
                r1 = 0
                r0.updateLoginFlag(r1)
                com.microtech.aidexx.utils.Throttle$Companion r0 = com.microtech.aidexx.utils.Throttle.Companion
                com.microtech.aidexx.utils.Throttle r0 = r0.instance()
                int r1 = r7.getCode()
                com.microtech.aidexx.common.net.ApiService$Companion$checkBizCodeIsSuccess$1$1 r3 = com.microtech.aidexx.common.net.ApiService$Companion$checkBizCodeIsSuccess$1$1.INSTANCE
                kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
                r4 = 5000(0x1388, double:2.4703E-320)
                r0.emit(r4, r1, r3)
            L_0x004f:
                int r0 = r7.getCode()
                java.lang.String r1 = r7.getMsg()
                java.lang.CharSequence r1 = (java.lang.CharSequence) r1
                boolean r3 = kotlin.text.StringsKt.isBlank(r1)
                if (r3 == 0) goto L_0x0060
                goto L_0x0061
            L_0x0060:
                r2 = r1
            L_0x0061:
                java.lang.String r2 = (java.lang.String) r2
                if (r2 != 0) goto L_0x006d
                int r7 = r7.getCode()
                java.lang.String r2 = java.lang.String.valueOf(r7)
            L_0x006d:
                com.microtech.aidexx.common.net.BizException r7 = new com.microtech.aidexx.common.net.BizException
                r7.<init>(r0, r2)
                r2 = r7
            L_0x0073:
                java.lang.Throwable r2 = (java.lang.Throwable) r2
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.net.ApiService.Companion.checkBizCodeIsSuccess(java.lang.String):java.lang.Throwable");
        }

        /* access modifiers changed from: private */
        public final void afterGsonConvert(Object obj) {
            Object data;
            if (obj != null && (obj instanceof BaseResponse) && (data = ((BaseResponse) obj).getData()) != null) {
                if (data instanceof BaseEventEntity) {
                    ((BaseEventEntity) data).calTimestamp();
                } else if (data instanceof List) {
                    for (Object next : (Iterable) data) {
                        if (next instanceof BaseEventEntity) {
                            ((BaseEventEntity) next).calTimestamp();
                            if (next instanceof RealCgmHistoryEntity) {
                                ((RealCgmHistoryEntity) next).setBriefUploadState(2);
                            }
                        } else {
                            return;
                        }
                    }
                }
            }
        }

        /* access modifiers changed from: private */
        public final OkHttpClient getOkHttpClient() {
            File file = new File(AidexxApp.Companion.getInstance().getExternalCacheDir(), "RxHttpCookie");
            HttpsUtil.SSLParams sslSocketFactory = HttpsUtil.getSslSocketFactory();
            OkHttpClient.Builder writeTimeout = new OkHttpClient.Builder().cookieJar(new CookieStore(file)).connectTimeout(30, TimeUnit.SECONDS).readTimeout(60, TimeUnit.SECONDS).writeTimeout(60, TimeUnit.SECONDS);
            Intrinsics.checkNotNull(sslSocketFactory);
            SSLSocketFactory sSLSocketFactory = sslSocketFactory.sSLSocketFactory;
            Intrinsics.checkNotNullExpressionValue(sSLSocketFactory, "sSLSocketFactory");
            X509TrustManager x509TrustManager = sslSocketFactory.trustManager;
            Intrinsics.checkNotNullExpressionValue(x509TrustManager, "trustManager");
            return writeTimeout.sslSocketFactory(sSLSocketFactory, x509TrustManager).hostnameVerifier(new ApiService$Companion$$ExternalSyntheticLambda0()).addInterceptor(new HeaderInterceptor()).addInterceptor(new DataEncryptInterceptor()).build();
        }

        /* access modifiers changed from: private */
        public final Gson createGson() {
            Gson create = new GsonBuilder().registerTypeAdapter(FloatCompanionObject.class, new ApiService$Companion$createGson$1()).setLongSerializationPolicy(LongSerializationPolicy.STRING).setDateFormat(ExtendsKt.DATE_FORMAT_YMDHMSZ).create();
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
    }
}
