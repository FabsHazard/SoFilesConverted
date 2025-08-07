package com.microtech.aidexx.ui.setting.share;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Base64;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.core.content.FileProvider;
import androidx.core.os.EnvironmentCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelLazy;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.R;
import com.microtech.aidexx.base.BaseActivity;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.databinding.ActivityShareAddUserByWechatBinding;
import com.microtech.aidexx.utils.LogUtil;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0013\u001a\u00020\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0019H\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareAddUserByWechatActivity;", "Lcom/microtech/aidexx/base/BaseActivity;", "Lcom/microtech/aidexx/base/BaseViewModel;", "Lcom/microtech/aidexx/databinding/ActivityShareAddUserByWechatBinding;", "()V", "base64ToBitmap", "Landroid/graphics/Bitmap;", "handler", "Landroid/os/Handler;", "getHandler", "()Landroid/os/Handler;", "imgFile", "Ljava/io/File;", "sfViewModel", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "getSfViewModel", "()Lcom/microtech/aidexx/ui/setting/share/ShareFollowViewModel;", "sfViewModel$delegate", "Lkotlin/Lazy;", "img", "", "bitmapToFile", "bitmap", "getViewBinding", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareAddUserByWechatActivity.kt */
public final class ShareAddUserByWechatActivity extends BaseActivity<BaseViewModel, ActivityShareAddUserByWechatBinding> {
    private Bitmap base64ToBitmap;
    private final Handler handler = new ShareAddUserByWechatActivity$handler$1(Looper.getMainLooper());
    private File imgFile;
    private final Lazy sfViewModel$delegate;

    public ShareAddUserByWechatActivity() {
        ComponentActivity componentActivity = this;
        this.sfViewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(ShareFollowViewModel.class), new ShareAddUserByWechatActivity$special$$inlined$viewModels$default$2(componentActivity), new ShareAddUserByWechatActivity$special$$inlined$viewModels$default$1(componentActivity), new ShareAddUserByWechatActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: private */
    public final ShareFollowViewModel getSfViewModel() {
        return (ShareFollowViewModel) this.sfViewModel$delegate.getValue();
    }

    public final Handler getHandler() {
        return this.handler;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((View) ((ActivityShareAddUserByWechatBinding) getBinding()).getRoot());
        initView();
    }

    public final Bitmap base64ToBitmap(String str) {
        Intrinsics.checkNotNullParameter(str, "img");
        try {
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            byte[] decode = Base64.decode(bytes, 2);
            return BitmapFactory.decodeByteArray(decode, 0, decode.length);
        } catch (Exception e) {
            LogUtil.Companion companion = LogUtil.Companion;
            e.printStackTrace();
            companion.eAiDEX(String.valueOf(Unit.INSTANCE));
            return null;
        }
    }

    private final File bitmapToFile(Bitmap bitmap) {
        StringBuilder sb = new StringBuilder();
        File externalFilesDir = AidexxApp.Companion.getInstance().getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        this.imgFile = new File(sb.append(externalFilesDir != null ? externalFilesDir.getAbsolutePath() : null).append(File.separator).append("qrcode.jpeg").toString());
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(this.imgFile));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
            return this.imgFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private final void initView() {
        ((ActivityShareAddUserByWechatBinding) getBinding()).myQrCodeActionBar.getLeftIcon().setOnClickListener(new ShareAddUserByWechatActivity$$ExternalSyntheticLambda0(this));
        Map hashMap = new HashMap();
        hashMap.put("deviceType", "Android");
        hashMap.put("systemVersion", EnvironmentCompat.MEDIA_UNKNOWN);
        hashMap.put("operationType", 3);
        WaitDialog.show((Activity) this, (CharSequence) getString(R.string.com_loading));
        this.handler.sendEmptyMessageDelayed(1, 20000);
        Job unused = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), (CoroutineContext) null, (CoroutineStart) null, new ShareAddUserByWechatActivity$initView$2(this, (Continuation<? super ShareAddUserByWechatActivity$initView$2>) null), 3, (Object) null);
        ((ActivityShareAddUserByWechatBinding) getBinding()).btnSendQrCode.setOnClickListener(new ShareAddUserByWechatActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$0(ShareAddUserByWechatActivity shareAddUserByWechatActivity, View view) {
        Intrinsics.checkNotNullParameter(shareAddUserByWechatActivity, "this$0");
        shareAddUserByWechatActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void initView$lambda$3(ShareAddUserByWechatActivity shareAddUserByWechatActivity, View view) {
        File bitmapToFile;
        Intrinsics.checkNotNullParameter(shareAddUserByWechatActivity, "this$0");
        Bitmap bitmap = shareAddUserByWechatActivity.base64ToBitmap;
        if (bitmap != null && (bitmapToFile = shareAddUserByWechatActivity.bitmapToFile(bitmap)) != null) {
            Uri uriForFile = FileProvider.getUriForFile(shareAddUserByWechatActivity, shareAddUserByWechatActivity.getPackageName() + ".FileProvider", bitmapToFile);
            Intrinsics.checkNotNullExpressionValue(uriForFile, "getUriForFile(...)");
            Intent intent = new Intent("android.intent.action.SEND");
            intent.addFlags(1);
            intent.setType("image/*");
            intent.putExtra("android.intent.extra.STREAM", uriForFile);
            shareAddUserByWechatActivity.startActivity(Intent.createChooser(intent, ""));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        File file = this.imgFile;
        if (file != null) {
            file.delete();
        }
    }

    public ActivityShareAddUserByWechatBinding getViewBinding() {
        ActivityShareAddUserByWechatBinding inflate = ActivityShareAddUserByWechatBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
