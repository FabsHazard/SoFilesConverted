package com.microtech.aidexx.ui.setting.log;

import android.content.Context;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.feature.dynamic.e.e;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/microtech/aidexx/ui/setting/log/FeedbackUtil$upload$1", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: FeedbackUtil.kt */
public final class FeedbackUtil$upload$1 implements Callback {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $mute;
    final /* synthetic */ File $zipFile;

    FeedbackUtil$upload$1(boolean z, Context context, File file) {
        this.$mute = z;
        this.$context = context;
        this.$zipFile = file;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, e.a);
        LogUtil.Companion.eAiDEX("Feedback --> Log upload fail:" + iOException.getMessage());
        if (!this.$mute) {
            Dialogs.INSTANCE.dismissWait();
        }
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 200) {
            if (!this.$mute) {
                new Handler(Looper.getMainLooper()).post(new FeedbackUtil$upload$1$$ExternalSyntheticLambda0(this.$context, this.$zipFile));
            }
        } else if (!this.$mute) {
            new Handler(Looper.getMainLooper()).post(new FeedbackUtil$upload$1$$ExternalSyntheticLambda1(response));
        }
    }

    /* access modifiers changed from: private */
    public static final void onResponse$lambda$0(Context context, File file) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Dialogs dialogs = Dialogs.INSTANCE;
        Resources resources = context.getResources();
        String str = null;
        if (resources != null) {
            int i = R.string.com_actionState_success;
            Resources resources2 = context.getResources();
            if (resources2 != null) {
                str = resources2.getString(R.string.com_action_upload);
            }
            str = resources.getString(i, new Object[]{str});
        }
        dialogs.showSuccess(str);
        file.delete();
    }

    /* access modifiers changed from: private */
    public static final void onResponse$lambda$1(Response response) {
        Intrinsics.checkNotNullParameter(response, "$response");
        Dialogs.showError$default(Dialogs.INSTANCE, response.message(), 0, 2, (Object) null);
    }
}
