package com.microtech.aidexx.ui.setting.log;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.hms.mlsdk.common.MLApplicationSetting;
import com.microtech.aidexx.BuildConfig;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ble.device.TransmitterManager;
import com.microtech.aidexx.ble.device.model.DeviceModel;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.common.net.HttpsUtil;
import com.microtech.aidexx.common.user.UserInfoManager;
import com.microtech.aidexx.db.entity.TransmitterEntity;
import com.microtech.aidexx.utils.DeviceInfoHelper;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import io.objectbox.BoxStoreBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fJ&\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ \u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J(\u0010\u0015\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\n0\u0018H\u0002¨\u0006\u0019"}, d2 = {"Lcom/microtech/aidexx/ui/setting/log/FeedbackUtil;", "", "()V", "upload", "", "context", "Landroid/content/Context;", "zipFileName", "", "zipFile", "Ljava/io/File;", "mute", "", "zipAndUpload", "logFile", "logPath", "zipFiles", "folderString", "fileString", "zipOutputSteam", "Ljava/util/zip/ZipOutputStream;", "zipFolder", "pathZip", "files", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FeedbackUtil.kt */
public final class FeedbackUtil {
    public static final FeedbackUtil INSTANCE = new FeedbackUtil();

    /* access modifiers changed from: private */
    public static final boolean upload$lambda$2(String str, SSLSession sSLSession) {
        return true;
    }

    private FeedbackUtil() {
    }

    public final void zipAndUpload(Context context, File file, String str, boolean z) {
        String str2;
        TransmitterEntity entity;
        Context context2 = context;
        String str3 = str;
        boolean z2 = z;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(file, "logFile");
        Intrinsics.checkNotNullParameter(str3, "logPath");
        File[] listFiles = file.listFiles();
        if (listFiles == null || listFiles.length == 0) {
            Context context3 = context2;
            LogUtil.Companion.eAiDEX("Feedback --> log files is null or empty");
            if (!z2) {
                Dialogs dialogs = Dialogs.INSTANCE;
                Resources resources = context.getResources();
                String str4 = null;
                if (resources != null) {
                    int i = R.string.com_actionState_success;
                    Resources resources2 = context.getResources();
                    if (resources2 != null) {
                        str4 = resources2.getString(R.string.com_action_upload);
                    }
                    str4 = resources.getString(i, new Object[]{str4});
                }
                dialogs.showSuccess(str4);
                return;
            }
            return;
        }
        String userId = UserInfoManager.Companion.instance().userId();
        String deviceName = DeviceInfoHelper.deviceName();
        String installVersion = DeviceInfoHelper.installVersion(ExtendsKt.getContext());
        String osVersion = DeviceInfoHelper.osVersion();
        DeviceModel deviceModel = TransmitterManager.Companion.instance().getDefault();
        if (deviceModel == null || (entity = deviceModel.getEntity()) == null || (str2 = entity.getDeviceSn()) == null) {
            str2 = "";
        }
        Intrinsics.checkNotNull(listFiles);
        Collection arrayList = new ArrayList();
        int length = listFiles.length;
        int i2 = 0;
        while (i2 < length) {
            File file2 = listFiles[i2];
            String name = file2.getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            File[] fileArr = listFiles;
            if (StringsKt.endsWith(name, "xlog", true)) {
                arrayList.add(file2);
            }
            i2++;
            listFiles = fileArr;
        }
        List mutableList = CollectionsKt.toMutableList(CollectionsKt.sortedWith((List) arrayList, new FeedbackUtil$zipAndUpload$$inlined$sortedByDescending$1()));
        String str5 = "AiDEX-X" + installVersion + '_' + deviceName + '_' + osVersion + '_' + str2 + '_' + userId + '_' + ExtendsKt.dateTimeWithoutSpaceByEnglish(new Date()) + ".zip";
        if (mutableList.size() > 3) {
            upload(context2, str5, zipFolder(str3, str5, mutableList.subList(0, 3)), z2);
        } else {
            upload(context2, str5, zipFolder(str3, str5, mutableList), z2);
        }
        File file3 = new File(context.getFilesDir().getAbsolutePath() + File.separator + BoxStoreBuilder.DEFAULT_NAME + File.separator + BoxStoreBuilder.DEFAULT_NAME + File.separator + "data.mdb");
        File file4 = new File(context.getFilesDir().getAbsolutePath() + File.separator + BoxStoreBuilder.DEFAULT_NAME + File.separator + BoxStoreBuilder.DEFAULT_NAME + File.separator + "lock.mdb");
        File file5 = new File(context.getFilesDir().getAbsolutePath() + File.separator + "mmkv" + File.separator + "mmkv.default");
        File file6 = new File(context.getFilesDir().getAbsolutePath() + File.separator + "mmkv" + File.separator + "mmkv.default.crc");
        if (!file5.exists() || !file6.exists()) {
            LogUtil.Companion.eAiDEX("Feedback --> mmkv backup fail, files not exists");
        } else {
            mutableList.add(file5);
            mutableList.add(file6);
        }
        if (file3.exists() && file4.exists()) {
            mutableList.add(file3);
            mutableList.add(file4);
        }
        String str6 = "AiDEX-X" + installVersion + '_' + deviceName + '_' + osVersion + '_' + str2 + '_' + userId + '_' + ExtendsKt.dateTimeWithoutSpaceByEnglish(new Date()) + "-Full.zip";
        upload(context, str6, zipFolder(str3, str6, mutableList), true);
    }

    public final void upload(Context context, String str, File file, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "zipFileName");
        if (file == null || !file.exists()) {
            if (!z) {
                Dialogs.INSTANCE.dismissWait();
            }
            LogUtil.Companion.eAiDEX("Feedback --> Log file not exist");
            return;
        }
        LogUtil.Companion.eAiDEX("Feedback --> file size:" + file.length() + " bytes");
        FeedbackUtil$upload$fileRequestBody$1 feedbackUtil$upload$fileRequestBody$1 = new FeedbackUtil$upload$fileRequestBody$1(file);
        HttpsUtil.SSLParams sslSocketFactory = HttpsUtil.getSslSocketFactory();
        OkHttpClient.Builder hostnameVerifier = new OkHttpClient.Builder().callTimeout(5, TimeUnit.MINUTES).connectTimeout(1, TimeUnit.MINUTES).readTimeout(5, TimeUnit.MINUTES).writeTimeout(5, TimeUnit.MINUTES).hostnameVerifier(new FeedbackUtil$$ExternalSyntheticLambda0());
        Intrinsics.checkNotNull(sslSocketFactory);
        SSLSocketFactory sSLSocketFactory = sslSocketFactory.sSLSocketFactory;
        Intrinsics.checkNotNullExpressionValue(sSLSocketFactory, "sSLSocketFactory");
        X509TrustManager x509TrustManager = sslSocketFactory.trustManager;
        Intrinsics.checkNotNullExpressionValue(x509TrustManager, "trustManager");
        hostnameVerifier.sslSocketFactory(sSLSocketFactory, x509TrustManager).retryOnConnectionFailure(true).build().newCall(new Request.Builder().url(BuildConfig.logUploadUrl).post(new MultipartBody.Builder((String) null, 1, (DefaultConstructorMarker) null).addFormDataPart(MLApplicationSetting.BundleKeyConstants.AppInfo.APP_NAME, "cgms").addFormDataPart("file", str, feedbackUtil$upload$fileRequestBody$1).build()).build()).enqueue(new FeedbackUtil$upload$1(z, context, file));
    }

    private final File zipFolder(String str, String str2, List<File> list) {
        File file = null;
        try {
            File file2 = new File(str + '/' + str2);
            try {
                ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(file2));
                for (File next : list) {
                    String str3 = next.getParent() + File.separator;
                    String name = next.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    zipFiles(str3, name, zipOutputStream);
                }
                zipOutputStream.finish();
                zipOutputStream.close();
                return file2;
            } catch (Exception e) {
                e = e;
                file = file2;
                e.printStackTrace();
                LogUtil.Companion companion = LogUtil.Companion;
                StringBuilder sb = new StringBuilder("Feedback --> zipFolder not exist ");
                e.printStackTrace();
                companion.eAiDEX(sb.append(Unit.INSTANCE).toString());
                Dialogs.INSTANCE.dismissWait();
                return file;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            LogUtil.Companion companion2 = LogUtil.Companion;
            StringBuilder sb2 = new StringBuilder("Feedback --> zipFolder not exist ");
            e.printStackTrace();
            companion2.eAiDEX(sb2.append(Unit.INSTANCE).toString());
            Dialogs.INSTANCE.dismissWait();
            return file;
        }
    }

    private final void zipFiles(String str, String str2, ZipOutputStream zipOutputStream) {
        try {
            File file = new File(str + str2);
            if (file.isFile()) {
                ZipEntry zipEntry = new ZipEntry(str2);
                FileInputStream fileInputStream = new FileInputStream(file);
                zipOutputStream.putNextEntry(zipEntry);
                byte[] bArr = new byte[4096];
                for (int i = 0; i != -1; i = fileInputStream.read(bArr)) {
                    zipOutputStream.write(bArr, 0, i);
                }
                zipOutputStream.closeEntry();
                return;
            }
            String[] list = file.list();
            if (list == null) {
                return;
            }
            if (list.length == 0) {
                zipOutputStream.putNextEntry(new ZipEntry(str2 + File.separator));
                zipOutputStream.closeEntry();
                return;
            }
            for (String str3 : list) {
                Intrinsics.checkNotNull(str3);
                zipFiles(str + str2 + File.separator, str3, zipOutputStream);
            }
        } catch (Exception e) {
            e.printStackTrace();
            LogUtil.Companion companion = LogUtil.Companion;
            StringBuilder sb = new StringBuilder("Feedback --> zipFiles not exist ");
            e.printStackTrace();
            companion.eAiDEX(sb.append(Unit.INSTANCE).toString());
            Dialogs.INSTANCE.dismissWait();
        }
    }
}
