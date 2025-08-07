package com.microtech.aidexx.utils;

import androidx.core.app.NotificationCompat;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.views.dialog.Dialogs;
import com.tencent.mars.xlog.Log;
import java.io.File;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microtech/aidexx/utils/LogUtil;", "", "()V", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: LogUtil.kt */
public final class LogUtil {
    private static final String COMMON = "AiDEX-X";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String HTTP = "Request";

    @JvmStatic
    public static final void d(String str, String str2) {
        Companion.d(str, str2);
    }

    @JvmStatic
    public static final void e(String str, String str2) {
        Companion.e(str, str2);
    }

    @JvmStatic
    public static final void eAiDEX(String str) {
        Companion.eAiDEX(str);
    }

    @JvmStatic
    public static final void eHttp(String str) {
        Companion.eHttp(str);
    }

    @JvmStatic
    public static final void i(String str, String str2) {
        Companion.i(str, str2);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007J\u001a\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H\u0007J\u001a\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004H\u0007J\u001a\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u0018\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\t\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microtech/aidexx/utils/LogUtil$Companion;", "", "()V", "COMMON", "", "HTTP", "d", "", "msg", "tag", "e", "eAiDEX", "eHttp", "i", "uploadLog", "scope", "Lkotlinx/coroutines/CoroutineScope;", "mute", "", "xLogE", "xLogI", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: LogUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void eAiDEX(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.e(AidexxApp.Companion.getInstance().isForeground() ? "AiDEX-X【Foreground】" : "AiDEX-X【Background】", str);
        }

        public static /* synthetic */ void xLogI$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = LogUtil.COMMON;
            }
            companion.xLogI(str, str2);
        }

        public final void xLogI(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(str2, "tag");
            Log.i(str2 + (AidexxApp.Companion.getInstance().isForeground() ? "【Foreground】" : "【Background】"), str);
        }

        public static /* synthetic */ void xLogE$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = LogUtil.COMMON;
            }
            companion.xLogE(str, str2);
        }

        public final void xLogE(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(str2, "tag");
            Log.e(str2 + (AidexxApp.Companion.getInstance().isForeground() ? "【Foreground】" : "【Background】"), str);
        }

        @JvmStatic
        public final void eHttp(String str) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Log.e(LogUtil.HTTP, str);
        }

        public static /* synthetic */ void d$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = LogUtil.COMMON;
            }
            companion.d(str, str2);
        }

        @JvmStatic
        public final void d(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(str2, "tag");
            android.util.Log.d(str2, str);
        }

        public static /* synthetic */ void i$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = LogUtil.COMMON;
            }
            companion.i(str, str2);
        }

        @JvmStatic
        public final void i(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(str2, "tag");
            android.util.Log.i(str2, str);
        }

        public static /* synthetic */ void e$default(Companion companion, String str, String str2, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = LogUtil.COMMON;
            }
            companion.e(str, str2);
        }

        @JvmStatic
        public final void e(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, NotificationCompat.CATEGORY_MESSAGE);
            Intrinsics.checkNotNullParameter(str2, "tag");
            android.util.Log.e(str2, str);
        }

        public static /* synthetic */ void uploadLog$default(Companion companion, CoroutineScope coroutineScope, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                coroutineScope = GlobalScope.INSTANCE;
            }
            if ((i & 2) != 0) {
                z = false;
            }
            companion.uploadLog(coroutineScope, z);
        }

        public final void uploadLog(CoroutineScope coroutineScope, boolean z) {
            Intrinsics.checkNotNullParameter(coroutineScope, "scope");
            Log.appenderFlushSync(true);
            File externalFilesDir = ExtendsKt.getContext().getExternalFilesDir((String) null);
            String str = (externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null) + File.separator + "aidex";
            File file = new File(str + File.separator + "log");
            if (file.isDirectory()) {
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, Dispatchers.getIO(), (CoroutineStart) null, new LogUtil$Companion$uploadLog$1(file, str, z, (Continuation<? super LogUtil$Companion$uploadLog$1>) null), 2, (Object) null);
                return;
            }
            eAiDEX("log path is not a directory");
            if (!z) {
                Dialogs.INSTANCE.showSuccess(ExtendsKt.getContext().getString(R.string.com_state_success));
            }
        }
    }
}
