package com.microtech.aidexx.utils;

import android.os.Looper;
import android.os.Process;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.ui.pair.PairUtilKt;
import com.tencent.mars.xlog.Log;
import java.lang.Thread;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/microtech/aidexx/utils/CrashHandler;", "Ljava/lang/Thread$UncaughtExceptionHandler;", "()V", "isKilled", "", "mDefaultHandler", "handleException", "ex", "", "init", "", "uncaughtException", "thread", "Ljava/lang/Thread;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: CrashHandler.kt */
public final class CrashHandler implements Thread.UncaughtExceptionHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static CrashHandler instance;
    private volatile boolean isKilled;
    private Thread.UncaughtExceptionHandler mDefaultHandler;

    public final void init() {
        this.mDefaultHandler = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public void uncaughtException(Thread thread, Throwable th) {
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
        Intrinsics.checkNotNullParameter(thread, "thread");
        Intrinsics.checkNotNullParameter(th, "ex");
        if (handleException(th) || (uncaughtExceptionHandler = this.mDefaultHandler) == null) {
            this.isKilled = true;
            try {
                Thread.sleep(PairUtilKt.DELAY_A_WHILE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Process.killProcess(Process.myPid());
            System.exit(1);
            throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
        } else if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private final boolean handleException(Throwable th) {
        if (th != null && !this.isKilled) {
            LogUtil.Companion.eAiDEX("HandleException " + ExceptionsKt.stackTraceToString(th));
            Log.appenderFlushSync(true);
            new Thread(new CrashHandler$$ExternalSyntheticLambda0()).start();
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final void handleException$lambda$0() {
        Looper.prepare();
        ToastUtil toastUtil = ToastUtil.INSTANCE;
        String string = AidexxApp.Companion.getInstance().getString(R.string.app_crash);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        toastUtil.showShort(string);
        Looper.loop();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u00048FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/microtech/aidexx/utils/CrashHandler$Companion;", "", "()V", "instance", "Lcom/microtech/aidexx/utils/CrashHandler;", "getInstance", "()Lcom/microtech/aidexx/utils/CrashHandler;", "setInstance", "(Lcom/microtech/aidexx/utils/CrashHandler;)V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: CrashHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setInstance(CrashHandler crashHandler) {
            CrashHandler.instance = crashHandler;
        }

        public final CrashHandler getInstance() {
            if (CrashHandler.instance == null) {
                CrashHandler.instance = new CrashHandler();
            }
            return CrashHandler.instance;
        }
    }
}
