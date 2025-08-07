package com.microtech.aidexx.common.user;

import com.microtech.aidexx.AidexxApp;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.db.ObjectBox;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.db.entity.UserEntity_;
import com.microtech.aidexx.ui.setting.share.ShareUserInfo;
import com.microtech.aidexx.utils.mmkv.MmkvManager;
import io.objectbox.Box;
import io.objectbox.Property;
import io.objectbox.kotlin.BoxStoreKt;
import io.objectbox.query.QueryBuilder;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u0000 42\u00020\u0001:\u00014B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u0004\u0018\u00010\tJ\u0019\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\tH@ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0010J\u0019\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u0019\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0004H@ø\u0001\u0000¢\u0006\u0002\u0010\u0018J\u000e\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000eJ\u0002\u0010\u001c\u001a\u00020\u00102\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010%\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\t2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\n\b\u0002\u00101\u001a\u0004\u0018\u00010 2\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u00103J\u0006\u0010\u000b\u001a\u00020\tR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0002\u0004\n\u0002\b\u0019¨\u00065"}, d2 = {"Lcom/microtech/aidexx/common/user/UserInfoManager;", "", "()V", "<set-?>", "Lcom/microtech/aidexx/db/entity/UserEntity;", "userEntity", "getUserEntity", "()Lcom/microtech/aidexx/db/entity/UserEntity;", "getDisplayName", "", "getUserInfoById", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isLogin", "", "onTokenExpired", "", "onUserExit", "context", "Landroid/content/Context;", "(Landroid/content/Context;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onUserLogin", "", "content", "(Lcom/microtech/aidexx/db/entity/UserEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshUserInfo", "saveUserId", "updateLoginFlag", "updateProfile", "name", "fullName", "height", "", "bodyWeight", "gender", "birthDate", "avatar", "diabetesType", "diabetesTypeValue", "diabetesTypeDisplayName", "diagnosisDate", "complications", "complicationsDisplayName", "treatment", "treatmentDisplayName", "otherDiseases", "otherDiseasesDisplayName", "phone", "isGuide", "isUnitGuide", "isGuideStateChange", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Boolean;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: UserInfoManager.kt */
public final class UserInfoManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static UserInfoManager INSTANCE;
    /* access modifiers changed from: private */
    public static volatile ShareUserInfo shareUserInfo;
    /* access modifiers changed from: private */
    public UserEntity userEntity;

    public UserInfoManager() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(AidexxApp.Companion.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(this, (Continuation<? super AnonymousClass1>) null), 3, (Object) null);
    }

    public final UserEntity getUserEntity() {
        return this.userEntity;
    }

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.microtech.aidexx.common.user.UserInfoManager$1", f = "UserInfoManager.kt", i = {}, l = {42}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.microtech.aidexx.common.user.UserInfoManager$1  reason: invalid class name */
    /* compiled from: UserInfoManager.kt */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ UserInfoManager this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            UserInfoManager userInfoManager;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                UserInfoManager userInfoManager2 = this.this$0;
                this.L$0 = userInfoManager2;
                this.label = 1;
                Object awaitCallInTx = BoxStoreKt.awaitCallInTx(ObjectBox.INSTANCE.getStore(), new UserInfoManager$1$$ExternalSyntheticLambda0(), this);
                if (awaitCallInTx == coroutine_suspended) {
                    return coroutine_suspended;
                }
                userInfoManager = userInfoManager2;
                obj = awaitCallInTx;
            } else if (i == 1) {
                userInfoManager = (UserInfoManager) this.L$0;
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            userInfoManager.userEntity = (UserEntity) obj;
            return Unit.INSTANCE;
        }

        /* access modifiers changed from: private */
        public static final UserEntity invokeSuspend$lambda$0() {
            Box<UserEntity> userBox = ObjectBox.INSTANCE.getUserBox();
            Intrinsics.checkNotNull(userBox);
            return userBox.query().orderDesc(UserEntity_.idx).build().findFirst();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\r\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/microtech/aidexx/common/user/UserInfoManager$Companion;", "", "()V", "INSTANCE", "Lcom/microtech/aidexx/common/user/UserInfoManager;", "shareUserInfo", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "getShareUserInfo", "()Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "setShareUserInfo", "(Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;)V", "getCurShowUserId", "", "instance", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: UserInfoManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ShareUserInfo getShareUserInfo() {
            return UserInfoManager.shareUserInfo;
        }

        public final void setShareUserInfo(ShareUserInfo shareUserInfo) {
            UserInfoManager.shareUserInfo = shareUserInfo;
        }

        public final synchronized UserInfoManager instance() {
            UserInfoManager access$getINSTANCE$cp;
            if (UserInfoManager.INSTANCE == null) {
                UserInfoManager.INSTANCE = new UserInfoManager();
            }
            access$getINSTANCE$cp = UserInfoManager.INSTANCE;
            Intrinsics.checkNotNull(access$getINSTANCE$cp);
            return access$getINSTANCE$cp;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r0.getDataProviderId();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.String getCurShowUserId() {
            /*
                r1 = this;
                com.microtech.aidexx.ui.setting.share.ShareUserInfo r0 = r1.getShareUserInfo()
                if (r0 == 0) goto L_0x000c
                java.lang.String r0 = r0.getDataProviderId()
                if (r0 != 0) goto L_0x0014
            L_0x000c:
                com.microtech.aidexx.common.user.UserInfoManager r0 = r1.instance()
                java.lang.String r0 = r0.userId()
            L_0x0014:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager.Companion.getCurShowUserId():java.lang.String");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getUserId();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String userId() {
        /*
            r1 = this;
            com.microtech.aidexx.db.entity.UserEntity r0 = r1.userEntity
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getUserId()
            if (r0 != 0) goto L_0x0010
        L_0x000a:
            com.microtech.aidexx.utils.mmkv.MmkvManager r0 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            java.lang.String r0 = r0.getUserId()
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager.userId():java.lang.String");
    }

    public final boolean isLogin() {
        return MmkvManager.INSTANCE.isLogin();
    }

    public final void updateLoginFlag(boolean z) {
        MmkvManager.INSTANCE.setLogin(z);
    }

    public final void saveUserId(String str) {
        Intrinsics.checkNotNullParameter(str, "userId");
        MmkvManager.INSTANCE.saveUserId(str);
    }

    public static /* synthetic */ Object updateProfile$default(UserInfoManager userInfoManager, String str, String str2, Integer num, Integer num2, Integer num3, String str3, String str4, Integer num4, Integer num5, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Integer num6, Integer num7, Boolean bool, Continuation continuation, int i, Object obj) {
        int i2 = i;
        return userInfoManager.updateProfile((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : num, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : num3, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : num4, (i2 & 256) != 0 ? null : num5, (i2 & 512) != 0 ? null : str5, (i2 & 1024) != 0 ? null : str6, (i2 & 2048) != 0 ? null : str7, (i2 & 4096) != 0 ? null : str8, (i2 & 8192) != 0 ? null : str9, (i2 & 16384) != 0 ? null : str10, (32768 & i2) != 0 ? null : str11, (65536 & i2) != 0 ? null : str12, (131072 & i2) != 0 ? null : str13, (262144 & i2) != 0 ? null : num6, (524288 & i2) != 0 ? null : num7, (i2 & 1048576) != 0 ? null : bool, continuation);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0130, code lost:
        if (((java.lang.Long) r13) != null) goto L_0x0141;
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0046  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object updateProfile(java.lang.String r18, java.lang.String r19, java.lang.Integer r20, java.lang.Integer r21, java.lang.Integer r22, java.lang.String r23, java.lang.String r24, java.lang.Integer r25, java.lang.Integer r26, java.lang.String r27, java.lang.String r28, java.lang.String r29, java.lang.String r30, java.lang.String r31, java.lang.String r32, java.lang.String r33, java.lang.String r34, java.lang.String r35, java.lang.Integer r36, java.lang.Integer r37, java.lang.Boolean r38, kotlin.coroutines.Continuation<? super kotlin.Unit> r39) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r23
            r4 = r24
            r5 = r27
            r6 = r28
            r7 = r29
            r8 = r30
            r9 = r31
            r10 = r32
            r11 = r33
            r12 = r34
            r13 = r35
            r14 = r39
            boolean r15 = r14 instanceof com.microtech.aidexx.common.user.UserInfoManager$updateProfile$1
            if (r15 == 0) goto L_0x0034
            r15 = r14
            com.microtech.aidexx.common.user.UserInfoManager$updateProfile$1 r15 = (com.microtech.aidexx.common.user.UserInfoManager$updateProfile$1) r15
            int r13 = r15.label
            r16 = -2147483648(0xffffffff80000000, float:-0.0)
            r13 = r13 & r16
            if (r13 == 0) goto L_0x0034
            int r13 = r15.label
            int r13 = r13 - r16
            r15.label = r13
            goto L_0x0039
        L_0x0034:
            com.microtech.aidexx.common.user.UserInfoManager$updateProfile$1 r15 = new com.microtech.aidexx.common.user.UserInfoManager$updateProfile$1
            r15.<init>(r0, r14)
        L_0x0039:
            java.lang.Object r13 = r15.result
            java.lang.Object r14 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            r39 = r14
            int r14 = r15.label
            r12 = 1
            if (r14 == 0) goto L_0x0059
            if (r14 != r12) goto L_0x0051
            java.lang.Object r1 = r15.L$0
            com.microtech.aidexx.common.user.UserInfoManager r1 = (com.microtech.aidexx.common.user.UserInfoManager) r1
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x012e
        L_0x0051:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0059:
            kotlin.ResultKt.throwOnFailure(r13)
            com.microtech.aidexx.db.entity.UserEntity r13 = r0.userEntity
            if (r13 == 0) goto L_0x0133
            if (r2 == 0) goto L_0x0065
            r13.setFullName(r2)
        L_0x0065:
            if (r1 == 0) goto L_0x006a
            r13.setName(r1)
        L_0x006a:
            if (r20 == 0) goto L_0x007b
            r1 = r20
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setHeight(r1)
        L_0x007b:
            if (r21 == 0) goto L_0x008c
            r1 = r21
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setBodyWeight(r1)
        L_0x008c:
            if (r22 == 0) goto L_0x009d
            r1 = r22
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setGender(r1)
        L_0x009d:
            if (r3 == 0) goto L_0x00a2
            r13.setBirthDate(r3)
        L_0x00a2:
            if (r4 == 0) goto L_0x00a7
            r13.setAvatar(r4)
        L_0x00a7:
            if (r25 == 0) goto L_0x00b8
            r1 = r25
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setDiabetesType(r1)
        L_0x00b8:
            if (r26 == 0) goto L_0x00c9
            r1 = r26
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            r13.setDiabetesTypeValue(r1)
        L_0x00c9:
            if (r5 == 0) goto L_0x00ce
            r13.setDiabetesTypeDisplayName(r5)
        L_0x00ce:
            if (r6 == 0) goto L_0x00d3
            r13.setDiagnosisDate(r6)
        L_0x00d3:
            if (r7 == 0) goto L_0x00d8
            r13.setComplications(r7)
        L_0x00d8:
            if (r8 == 0) goto L_0x00dd
            r13.setComplicationsDisplayName(r8)
        L_0x00dd:
            if (r9 == 0) goto L_0x00e2
            r13.setTreatment(r9)
        L_0x00e2:
            if (r10 == 0) goto L_0x00e7
            r13.setTreatmentDisplayName(r10)
        L_0x00e7:
            if (r11 == 0) goto L_0x00ec
            r13.setOtherDiseases(r11)
        L_0x00ec:
            r1 = r34
            r2 = r12
            if (r1 == 0) goto L_0x00f4
            r13.setOtherDiseasesDisplayName(r1)
        L_0x00f4:
            r1 = r35
            if (r1 == 0) goto L_0x00fb
            r13.setPhone(r1)
        L_0x00fb:
            if (r36 == 0) goto L_0x0108
            r1 = r36
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r13.setGuide(r1)
        L_0x0108:
            if (r37 == 0) goto L_0x0115
            r1 = r37
            java.lang.Number r1 = (java.lang.Number) r1
            int r1 = r1.intValue()
            r13.setUnitGuide(r1)
        L_0x0115:
            if (r38 == 0) goto L_0x011e
            boolean r1 = r38.booleanValue()
            r13.setGuideStateChange(r1)
        L_0x011e:
            com.microtech.aidexx.db.repository.AccountDbRepository r1 = com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE
            r15.L$0 = r0
            r15.label = r2
            java.lang.Object r13 = r1.saveUser(r13, r15)
            r1 = r39
            if (r13 != r1) goto L_0x012d
            return r1
        L_0x012d:
            r1 = r0
        L_0x012e:
            java.lang.Long r13 = (java.lang.Long) r13
            if (r13 != 0) goto L_0x0141
            goto L_0x0134
        L_0x0133:
            r1 = r0
        L_0x0134:
            com.microtech.aidexx.common.user.UserInfoManager r1 = (com.microtech.aidexx.common.user.UserInfoManager) r1
            com.microtech.aidexx.utils.LogUtil$Companion r1 = com.microtech.aidexx.utils.LogUtil.Companion
            java.lang.String r2 = "updateProfile user null"
            r3 = 2
            r4 = 0
            com.microtech.aidexx.utils.LogUtil.Companion.xLogE$default(r1, r2, r4, r3, r4)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
        L_0x0141:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager.updateProfile(java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final String getDisplayName() {
        UserEntity userEntity2 = this.userEntity;
        if (userEntity2 != null) {
            return userEntity2.getDisplayName();
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object getUserInfoById(java.lang.String r5, kotlin.coroutines.Continuation<? super com.microtech.aidexx.db.entity.UserEntity> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof com.microtech.aidexx.common.user.UserInfoManager$getUserInfoById$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.microtech.aidexx.common.user.UserInfoManager$getUserInfoById$1 r0 = (com.microtech.aidexx.common.user.UserInfoManager$getUserInfoById$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.common.user.UserInfoManager$getUserInfoById$1 r0 = new com.microtech.aidexx.common.user.UserInfoManager$getUserInfoById$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0049
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r6)
            com.microtech.aidexx.db.ObjectBox r6 = com.microtech.aidexx.db.ObjectBox.INSTANCE
            io.objectbox.BoxStore r6 = r6.getStore()
            com.microtech.aidexx.common.user.UserInfoManager$$ExternalSyntheticLambda0 r2 = new com.microtech.aidexx.common.user.UserInfoManager$$ExternalSyntheticLambda0
            r2.<init>(r5)
            r0.label = r3
            java.lang.Object r6 = io.objectbox.kotlin.BoxStoreKt.awaitCallInTx(r6, r2, r0)
            if (r6 != r1) goto L_0x0049
            return r1
        L_0x0049:
            com.microtech.aidexx.db.entity.UserEntity r6 = (com.microtech.aidexx.db.entity.UserEntity) r6
            if (r6 != 0) goto L_0x0052
            com.microtech.aidexx.db.entity.UserEntity r6 = new com.microtech.aidexx.db.entity.UserEntity
            r6.<init>()
        L_0x0052:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager.getUserInfoById(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final UserEntity getUserInfoById$lambda$23(String str) {
        Intrinsics.checkNotNullParameter(str, "$userId");
        Box<UserEntity> userBox = ObjectBox.INSTANCE.getUserBox();
        Intrinsics.checkNotNull(userBox);
        QueryBuilder<UserEntity> query = userBox.query();
        Intrinsics.checkNotNullExpressionValue(query, "query(...)");
        Property<UserEntity> property = UserEntity_.userId;
        Intrinsics.checkNotNullExpressionValue(property, "userId");
        return (UserEntity) ExtendsKt.equal(query, property, str).orderDesc(UserEntity_.idx).build().findFirst();
    }

    public final void onTokenExpired() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ExtendsKt.getIoScope(AidexxApp.Companion.getInstance()), (CoroutineContext) null, (CoroutineStart) null, new UserInfoManager$onTokenExpired$1(this, (Continuation<? super UserInfoManager$onTokenExpired$1>) null), 3, (Object) null);
    }

    public final Object onUserLogin(UserEntity userEntity2, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInfoManager$onUserLogin$2(this, userEntity2, (Continuation<? super UserInfoManager$onUserLogin$2>) null), continuation);
    }

    public final Object refreshUserInfo(UserEntity userEntity2, Continuation<? super Long> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new UserInfoManager$refreshUserInfo$2(userEntity2, this, (Continuation<? super UserInfoManager$refreshUserInfo$2>) null), continuation);
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onUserExit(android.content.Context r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof com.microtech.aidexx.common.user.UserInfoManager$onUserExit$1
            if (r0 == 0) goto L_0x0014
            r0 = r8
            com.microtech.aidexx.common.user.UserInfoManager$onUserExit$1 r0 = (com.microtech.aidexx.common.user.UserInfoManager$onUserExit$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L_0x0019
        L_0x0014:
            com.microtech.aidexx.common.user.UserInfoManager$onUserExit$1 r0 = new com.microtech.aidexx.common.user.UserInfoManager$onUserExit$1
            r0.<init>(r6, r8)
        L_0x0019:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0047
            if (r2 == r4) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r7 = r0.L$0
            android.content.Context r7 = (android.content.Context) r7
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x00bc
        L_0x0033:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003b:
            java.lang.Object r7 = r0.L$1
            android.content.Context r7 = (android.content.Context) r7
            java.lang.Object r2 = r0.L$0
            com.microtech.aidexx.common.user.UserInfoManager r2 = (com.microtech.aidexx.common.user.UserInfoManager) r2
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0071
        L_0x0047:
            kotlin.ResultKt.throwOnFailure(r8)
            com.microtech.aidexx.service.LocalNotificationManager r8 = com.microtech.aidexx.service.LocalNotificationManager.INSTANCE
            r8.cancelAllNotification(r7)
            com.microtech.aidexx.utils.mmkv.MmkvManager r8 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r8.saveCustomerIconPosition(r5, r5, r5, r5)
            r6.updateLoginFlag(r5)
            java.lang.String r8 = ""
            r6.saveUserId(r8)
            com.microtech.aidexx.utils.mmkv.MmkvManager r2 = com.microtech.aidexx.utils.mmkv.MmkvManager.INSTANCE
            r2.saveToken(r8)
            com.microtech.aidexx.db.repository.AccountDbRepository r8 = com.microtech.aidexx.db.repository.AccountDbRepository.INSTANCE
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r4
            java.lang.Object r8 = r8.removeAll(r0)
            if (r8 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r2 = r6
        L_0x0071:
            r8 = 0
            r2.userEntity = r8
            shareUserInfo = r8
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r2 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r2 = r2.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r2 = r2.getDefault()
            if (r2 == 0) goto L_0x00a9
            boolean r2 = r2.isPaired()
            if (r2 == 0) goto L_0x00a9
            com.microtech.aidexx.ble.AidexBleAdapter$Companion r2 = com.microtech.aidexx.ble.AidexBleAdapter.Companion
            com.microtech.aidexx.ble.AidexBleAdapter r2 = r2.getInstance()
            boolean r2 = r2.isOnConnectState()
            if (r2 == 0) goto L_0x00a9
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r2 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r2 = r2.instance()
            com.microtech.aidexx.ble.device.model.DeviceModel r2 = r2.getDefault()
            if (r2 == 0) goto L_0x00a9
            com.microtechmd.blecomm.controller.BleController r2 = r2.getController()
            if (r2 == 0) goto L_0x00a9
            r2.disconnect()
        L_0x00a9:
            com.microtech.aidexx.ble.device.TransmitterManager$Companion r2 = com.microtech.aidexx.ble.device.TransmitterManager.Companion
            com.microtech.aidexx.ble.device.TransmitterManager r2 = r2.instance()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r3
            java.lang.Object r8 = r2.clear(r0)
            if (r8 != r1) goto L_0x00bc
            return r1
        L_0x00bc:
            com.microtech.aidexx.ui.widget.WidgetUpdateManager$Companion r8 = com.microtech.aidexx.ui.widget.WidgetUpdateManager.Companion
            com.microtech.aidexx.ui.widget.WidgetUpdateManager r8 = r8.instance()
            r8.update(r7)
            com.microtech.aidexx.utils.eventbus.EventBusManager r8 = com.microtech.aidexx.utils.eventbus.EventBusManager.INSTANCE
            java.lang.String r0 = "UPDATE_NOTIFICATION"
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            r8.send(r0, r1)
            com.microtech.aidexx.utils.ActivityUtil r8 = com.microtech.aidexx.utils.ActivityUtil.INSTANCE
            r8.finishAll()
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<com.microtech.aidexx.service.MainService> r0 = com.microtech.aidexx.service.MainService.class
            r8.<init>(r7, r0)
            r7.stopService(r8)
            android.content.Intent r8 = new android.content.Intent
            java.lang.Class<com.microtech.aidexx.ui.welcome.WelcomeActivity> r0 = com.microtech.aidexx.ui.welcome.WelcomeActivity.class
            r8.<init>(r7, r0)
            r7.startActivity(r8)
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.common.user.UserInfoManager.onUserExit(android.content.Context, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
