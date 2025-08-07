package com.microtech.aidexx.ui.setting;

import android.content.Intent;
import android.provider.MediaStore;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
/* compiled from: SettingActivity.kt */
final class SettingActivity$initView$1$3$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SettingActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$initView$1$3$1(SettingActivity settingActivity) {
        super(0);
        this.this$0 = settingActivity;
    }

    public final void invoke() {
        Intent intent = new Intent("android.intent.action.PICK", MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        SettingActivity settingActivity = this.this$0;
        settingActivity.startActivityForResult(intent, settingActivity.REQUEST_CODE_GALLERY);
    }
}
