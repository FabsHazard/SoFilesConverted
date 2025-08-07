package com.microtech.aidexx.ui.main.trend;

import androidx.core.app.NotificationCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.huawei.hms.feature.dynamic.e.e;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.utils.StringUtils;
import com.microtech.aidexx.views.dialog.Dialogs;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/microtech/aidexx/ui/main/trend/TrendsFragment$genAgp$2", "Lokhttp3/Callback;", "onFailure", "", "call", "Lokhttp3/Call;", "e", "Ljava/io/IOException;", "onResponse", "response", "Lokhttp3/Response;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: TrendsFragment.kt */
public final class TrendsFragment$genAgp$2 implements Callback {
    final /* synthetic */ TrendsFragment this$0;

    TrendsFragment$genAgp$2(TrendsFragment trendsFragment) {
        this.this$0 = trendsFragment;
    }

    public void onFailure(Call call, IOException iOException) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(iOException, e.a);
        String message = iOException.getMessage();
        if (message != null) {
            ExtendsKt.toastShort(message);
        }
        Dialogs.INSTANCE.dismissWait();
    }

    public void onResponse(Call call, Response response) {
        Intrinsics.checkNotNullParameter(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkNotNullParameter(response, "response");
        if (response.code() == 200) {
            ResponseBody body = response.body();
            String string = body != null ? body.string() : null;
            if (string != null) {
                TrendsFragment trendsFragment = this.this$0;
                JSONObject jSONObject = new JSONObject(string);
                if (jSONObject.has("data")) {
                    String string2 = jSONObject.getString("data");
                    StringUtils stringUtils = StringUtils.INSTANCE;
                    Intrinsics.checkNotNull(string2);
                    if (!stringUtils.isURL(string2)) {
                        Dialogs.INSTANCE.dismissWait();
                        String string3 = trendsFragment.getString(R.string.trend_agp_generate_fail);
                        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
                        ExtendsKt.toastShort(string3);
                        return;
                    }
                    Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(trendsFragment), (CoroutineContext) null, (CoroutineStart) null, new TrendsFragment$genAgp$2$onResponse$1$1(trendsFragment, string2, (Continuation<? super TrendsFragment$genAgp$2$onResponse$1$1>) null), 3, (Object) null);
                    return;
                }
                Dialogs.INSTANCE.dismissWait();
                String string4 = trendsFragment.getString(R.string.trend_agp_generate_fail);
                Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
                ExtendsKt.toastShort(string4);
                return;
            }
            return;
        }
        Dialogs.INSTANCE.dismissWait();
        ExtendsKt.toastShort(response.message());
    }
}
