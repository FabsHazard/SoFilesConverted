package com.microtech.aidexx.ui.setting;

import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.databinding.ActivitySettingBinding;
import com.microtech.aidexx.db.entity.LanguageConfEntity;
import com.microtech.aidexx.views.SettingItemWidget;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.microtech.aidexx.ui.setting.SettingActivity$initView$1$16", f = "SettingActivity.kt", i = {}, l = {221}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: SettingActivity.kt */
final class SettingActivity$initView$1$16 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ActivitySettingBinding $this_apply;
    Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SettingActivity$initView$1$16(ActivitySettingBinding activitySettingBinding, Continuation<? super SettingActivity$initView$1$16> continuation) {
        super(2, continuation);
        this.$this_apply = activitySettingBinding;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SettingActivity$initView$1$16(this.$this_apply, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SettingActivity$initView$1$16) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        SettingItemWidget settingItemWidget;
        String str;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            SettingItemWidget settingItemWidget2 = this.$this_apply.settingLanguage;
            this.L$0 = settingItemWidget2;
            this.label = 1;
            Object curLanguageConfEntity = LanguageResourceManager.INSTANCE.getCurLanguageConfEntity(this);
            if (curLanguageConfEntity == coroutine_suspended) {
                return coroutine_suspended;
            }
            settingItemWidget = settingItemWidget2;
            obj = curLanguageConfEntity;
        } else if (i == 1) {
            settingItemWidget = (SettingItemWidget) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        LanguageConfEntity languageConfEntity = (LanguageConfEntity) obj;
        if (languageConfEntity == null || (str = languageConfEntity.getName()) == null) {
            str = LanguageResourceManager.INSTANCE.getCurLanguageTag();
        }
        settingItemWidget.setValue(str);
        return Unit.INSTANCE;
    }
}
