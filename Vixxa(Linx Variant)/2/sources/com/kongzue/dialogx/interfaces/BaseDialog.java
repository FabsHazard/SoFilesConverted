package com.kongzue.dialogx.interfaces;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.dialogs.WaitDialog;
import com.kongzue.dialogx.impl.ActivityLifecycleImpl;
import com.kongzue.dialogx.impl.DialogFragmentImpl;
import com.kongzue.dialogx.util.ActivityRunnable;
import com.kongzue.dialogx.util.DialogListBuilder;
import com.kongzue.dialogx.util.DialogXFloatingWindowActivity;
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.WindowUtil;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BaseDialog implements LifecycleOwner {
    private static WeakReference<Activity> activityWeakReference;
    static WeakReference<Handler> mMainHandler;
    private static List<BaseDialog> runningDialogList;
    private static Thread uiThread;
    private static Map<String, ActivityRunnable> waitRunDialogX;
    protected static WindowInsets windowInsets;
    /* access modifiers changed from: protected */
    public boolean autoShowInputKeyboard;
    /* access modifiers changed from: protected */
    public Integer backgroundColor;
    protected boolean cancelable;
    protected DialogX.IMPL_MODE dialogImplMode;
    private WeakReference<DialogListBuilder> dialogListBuilder;
    private WeakReference<View> dialogView;
    /* access modifiers changed from: protected */
    public boolean dismissAnimFlag;
    /* access modifiers changed from: protected */
    public long enterAnimDuration;
    /* access modifiers changed from: protected */
    public long exitAnimDuration;
    protected WeakReference<DialogXFloatingWindowActivity> floatingWindowActivity;
    /* access modifiers changed from: protected */
    public boolean isShow;
    protected LifecycleRegistry lifecycle;
    protected int maxHeight;
    protected int maxWidth;
    protected int minHeight;
    protected int minWidth;
    protected WeakReference<Activity> ownActivity;
    protected WeakReference<DialogFragmentImpl> ownDialogFragmentImpl;
    /* access modifiers changed from: protected */
    public boolean preShow;
    private WeakReference<FrameLayout> rootFrameLayout;
    /* access modifiers changed from: protected */
    public int[] screenPaddings;
    /* access modifiers changed from: protected */
    public DialogXStyle style;
    protected DialogX.THEME theme;

    public enum BOOLEAN {
        TRUE,
        FALSE
    }

    public enum BUTTON_SELECT_RESULT {
        NONE,
        BUTTON_OK,
        BUTTON_CANCEL,
        BUTTON_OTHER
    }

    public abstract String dialogKey();

    public abstract boolean isCancelable();

    /* access modifiers changed from: protected */
    public void onDialogInit() {
    }

    /* access modifiers changed from: protected */
    public void onDialogRefreshUI() {
    }

    /* access modifiers changed from: protected */
    public void onDialogShow() {
    }

    public abstract void restartDialog();

    public abstract <D extends BaseDialog> D show();

    /* access modifiers changed from: protected */
    public abstract void shutdown();

    public static void init(Context context) {
        if (context == null) {
            context = ActivityLifecycleImpl.getTopActivity();
        }
        if (context instanceof Activity) {
            initActivityContext((Activity) context);
        }
        ActivityLifecycleImpl.init(context, new ActivityLifecycleImpl.onActivityResumeCallBack() {
            public void getActivity(Activity activity) {
                BaseDialog.initActivityContext(activity);
            }
        });
    }

    /* access modifiers changed from: private */
    public static void initActivityContext(Activity activity) {
        if (!ActivityLifecycleImpl.isExemptActivities(activity)) {
            try {
                uiThread = Looper.getMainLooper().getThread();
                activityWeakReference = new WeakReference<>(activity);
            } catch (Exception e) {
                e.printStackTrace();
                error("DialogX.init: 初始化异常，找不到Activity的根布局");
            }
        }
    }

    /* access modifiers changed from: protected */
    public static void log(Object obj) {
        if (DialogX.DEBUGMODE) {
            Log.i(">>>", obj.toString());
        }
    }

    protected static void error(Object obj) {
        if (DialogX.DEBUGMODE) {
            Log.e(">>>", obj.toString());
        }
    }

    public static void onActivityResume(Activity activity) {
        if (runningDialogList != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(runningDialogList);
            for (int size = copyOnWriteArrayList.size() - 1; size >= 0; size--) {
                BaseDialog baseDialog = (BaseDialog) copyOnWriteArrayList.get(size);
                if (baseDialog.getOwnActivity() == activity && baseDialog.isShow && baseDialog.getDialogView() != null) {
                    View findViewById = baseDialog.getDialogView().findViewById(R.id.box_root);
                    if (findViewById instanceof DialogXBaseRelativeLayout) {
                        DialogXBaseRelativeLayout dialogXBaseRelativeLayout = (DialogXBaseRelativeLayout) findViewById;
                        if (dialogXBaseRelativeLayout.isBaseFocusable()) {
                            dialogXBaseRelativeLayout.requestFocusOnResume();
                            return;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void requestDialogFocus() {
        if (runningDialogList != null) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(runningDialogList);
            for (int size = copyOnWriteArrayList.size() - 1; size >= 0; size--) {
                BaseDialog baseDialog = (BaseDialog) copyOnWriteArrayList.get(size);
                if (baseDialog.getOwnActivity() == getTopActivity() && baseDialog.isShow && baseDialog.getDialogView() != null) {
                    View findViewById = baseDialog.getDialogView().findViewById(R.id.box_root);
                    if ((findViewById instanceof DialogXBaseRelativeLayout) && ((DialogXBaseRelativeLayout) findViewById).isBaseFocusable()) {
                        findViewById.requestFocus();
                        return;
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r0 = (com.kongzue.dialogx.interfaces.BaseDialog) r5.getTag();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void show(final android.view.View r5) {
        /*
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.Object r0 = r5.getTag()
            com.kongzue.dialogx.interfaces.BaseDialog r0 = (com.kongzue.dialogx.interfaces.BaseDialog) r0
            if (r0 == 0) goto L_0x015a
            boolean r1 = r0.isShow
            r2 = 0
            if (r1 == 0) goto L_0x003f
            android.view.View r1 = r0.getDialogView()
            if (r1 == 0) goto L_0x001e
            android.view.View r5 = r0.getDialogView()
            r5.setVisibility(r2)
            return
        L_0x001e:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Object r5 = r5.getTag()
            com.kongzue.dialogx.interfaces.BaseDialog r5 = (com.kongzue.dialogx.interfaces.BaseDialog) r5
            java.lang.String r5 = r5.dialogKey()
            java.lang.StringBuilder r5 = r0.append(r5)
            java.lang.String r0 = "已处于显示状态，请勿重复执行 show() 指令。"
            java.lang.StringBuilder r5 = r5.append(r0)
            java.lang.String r5 = r5.toString()
            error(r5)
            return
        L_0x003f:
            java.lang.ref.WeakReference r1 = new java.lang.ref.WeakReference
            r1.<init>(r5)
            r0.dialogView = r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = r0.dialogKey()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r3 = ".show on "
            java.lang.StringBuilder r1 = r1.append(r3)
            android.app.Activity r3 = r0.getOwnActivity()
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.String r1 = r1.toString()
            log(r1)
            addDialogToRunningList(r0)
            int[] r1 = com.kongzue.dialogx.interfaces.BaseDialog.AnonymousClass8.$SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE
            com.kongzue.dialogx.DialogX$IMPL_MODE r3 = r0.dialogImplMode
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 1
            if (r1 == r3) goto L_0x0150
            r3 = 2
            if (r1 == r3) goto L_0x0136
            r3 = 3
            if (r1 == r3) goto L_0x008f
            android.widget.FrameLayout r1 = r0.getRootFrameLayout()
            if (r1 != 0) goto L_0x0085
            return
        L_0x0085:
            com.kongzue.dialogx.interfaces.BaseDialog$3 r1 = new com.kongzue.dialogx.interfaces.BaseDialog$3
            r1.<init>(r5, r0)
            runOnMain(r1)
            goto L_0x015a
        L_0x008f:
            java.util.Map<java.lang.String, com.kongzue.dialogx.util.ActivityRunnable> r1 = waitRunDialogX
            if (r1 != 0) goto L_0x009a
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            waitRunDialogX = r1
        L_0x009a:
            java.util.Map<java.lang.String, com.kongzue.dialogx.util.ActivityRunnable> r1 = waitRunDialogX
            java.lang.String r3 = r0.dialogKey()
            com.kongzue.dialogx.interfaces.BaseDialog$2 r4 = new com.kongzue.dialogx.interfaces.BaseDialog$2
            r4.<init>(r5)
            r1.put(r3, r4)
            com.kongzue.dialogx.util.DialogXFloatingWindowActivity r5 = com.kongzue.dialogx.util.DialogXFloatingWindowActivity.getDialogXFloatingWindowActivity()
            if (r5 == 0) goto L_0x00c4
            android.app.Activity r1 = r0.getOwnActivity()
            int r1 = r1.hashCode()
            boolean r1 = r5.isSameFrom(r1)
            if (r1 == 0) goto L_0x00c4
            java.lang.String r0 = r0.dialogKey()
            r5.showDialogX(r0)
            return
        L_0x00c4:
            android.content.Intent r5 = new android.content.Intent
            android.content.Context r1 = getPrivateContext()
            java.lang.Class<com.kongzue.dialogx.util.DialogXFloatingWindowActivity> r3 = com.kongzue.dialogx.util.DialogXFloatingWindowActivity.class
            r5.<init>(r1, r3)
            android.app.Activity r1 = r0.getOwnActivity()
            if (r1 != 0) goto L_0x00da
            r1 = 268435456(0x10000000, float:2.5243549E-29)
            r5.addFlags(r1)
        L_0x00da:
            java.lang.String r1 = "dialogXKey"
            java.lang.String r3 = r0.dialogKey()
            r5.putExtra(r1, r3)
            android.app.Activity r1 = r0.getOwnActivity()
            if (r1 != 0) goto L_0x00eb
        L_0x00e9:
            r1 = r2
            goto L_0x0102
        L_0x00eb:
            android.app.Activity r1 = r0.getOwnActivity()
            android.widget.FrameLayout r1 = getDecorView(r1)
            if (r1 != 0) goto L_0x00f6
            goto L_0x00e9
        L_0x00f6:
            android.app.Activity r1 = r0.getOwnActivity()
            android.widget.FrameLayout r1 = getDecorView(r1)
            int r1 = r1.getSystemUiVisibility()
        L_0x0102:
            java.lang.String r3 = "fromActivityUiStatus"
            r5.putExtra(r3, r1)
            android.content.Context r1 = getPrivateContext()
            int r1 = r1.hashCode()
            java.lang.String r3 = "from"
            r5.putExtra(r3, r1)
            android.content.Context r1 = getPrivateContext()
            r1.startActivity(r5)
            int r5 = android.os.Build.VERSION.SDK_INT
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            int r5 = r5.intValue()
            r1 = 5
            if (r5 <= r1) goto L_0x015a
            android.app.Activity r5 = r0.getOwnActivity()
            if (r5 == 0) goto L_0x015a
            android.app.Activity r5 = r0.getOwnActivity()
            r5.overridePendingTransition(r2, r2)
            goto L_0x015a
        L_0x0136:
            com.kongzue.dialogx.impl.DialogFragmentImpl r1 = new com.kongzue.dialogx.impl.DialogFragmentImpl
            r1.<init>(r0, r5)
            android.app.Activity r5 = r0.getOwnActivity()
            androidx.fragment.app.FragmentManager r5 = getSupportFragmentManager(r5)
            java.lang.String r2 = "DialogX"
            r1.show(r5, r2)
            java.lang.ref.WeakReference r5 = new java.lang.ref.WeakReference
            r5.<init>(r1)
            r0.ownDialogFragmentImpl = r5
            goto L_0x015a
        L_0x0150:
            android.app.Activity r1 = r0.getOwnActivity()
            boolean r0 = r0 instanceof com.kongzue.dialogx.interfaces.NoTouchInterface
            r0 = r0 ^ r3
            com.kongzue.dialogx.util.WindowUtil.show(r1, r5, r0)
        L_0x015a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.interfaces.BaseDialog.show(android.view.View):void");
    }

    /* renamed from: com.kongzue.dialogx.interfaces.BaseDialog$8  reason: invalid class name */
    static /* synthetic */ class AnonymousClass8 {
        static final /* synthetic */ int[] $SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.kongzue.dialogx.DialogX$IMPL_MODE[] r0 = com.kongzue.dialogx.DialogX.IMPL_MODE.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE = r0
                com.kongzue.dialogx.DialogX$IMPL_MODE r1 = com.kongzue.dialogx.DialogX.IMPL_MODE.WINDOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE     // Catch:{ NoSuchFieldError -> 0x001d }
                com.kongzue.dialogx.DialogX$IMPL_MODE r1 = com.kongzue.dialogx.DialogX.IMPL_MODE.DIALOG_FRAGMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.kongzue.dialogx.DialogX$IMPL_MODE r1 = com.kongzue.dialogx.DialogX.IMPL_MODE.FLOATING_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.interfaces.BaseDialog.AnonymousClass8.<clinit>():void");
        }
    }

    private static FragmentManager getSupportFragmentManager(Activity activity) {
        if (activity instanceof AppCompatActivity) {
            return ((AppCompatActivity) activity).getSupportFragmentManager();
        }
        return null;
    }

    public static ActivityRunnable getActivityRunnable(String str) {
        if (str == null) {
            return null;
        }
        return waitRunDialogX.get(str);
    }

    /* access modifiers changed from: protected */
    public static void show(Activity activity, final View view) {
        if (activity != null && view != null) {
            WeakReference<Activity> weakReference = activityWeakReference;
            if (weakReference == null || weakReference.get() == null || ActivityLifecycleImpl.getApplicationContext() == null) {
                init(activity.getApplicationContext());
            }
            final BaseDialog baseDialog = (BaseDialog) view.getTag();
            if (baseDialog != null) {
                baseDialog.setOwnActivity(activity);
                if (baseDialog.getDialogView() != null) {
                    baseDialog.getDialogView().setVisibility(0);
                }
                if (baseDialog.isShow) {
                    error(((BaseDialog) view.getTag()).dialogKey() + "已处于显示状态，请勿重复执行 show() 指令。");
                } else if (activity.isDestroyed()) {
                    error(((BaseDialog) view.getTag()).dialogKey() + ".show ERROR: activity is Destroyed.");
                } else {
                    baseDialog.dialogView = new WeakReference<>(view);
                    log(baseDialog + ".show on " + activity);
                    addDialogToRunningList(baseDialog);
                    int i = AnonymousClass8.$SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE[baseDialog.dialogImplMode.ordinal()];
                    if (i == 1) {
                        WindowUtil.show(activity, view, !(baseDialog instanceof NoTouchInterface));
                    } else if (i == 2) {
                        DialogFragmentImpl dialogFragmentImpl = new DialogFragmentImpl(baseDialog, view);
                        dialogFragmentImpl.show(getSupportFragmentManager(activity), "DialogX");
                        baseDialog.ownDialogFragmentImpl = new WeakReference<>(dialogFragmentImpl);
                    } else if (i != 3) {
                        final FrameLayout decorView = getDecorView(activity);
                        if (decorView != null) {
                            runOnMain(new Runnable() {
                                public void run() {
                                    if (view.getParent() == baseDialog.getRootFrameLayout()) {
                                        BaseDialog.error(((BaseDialog) view.getTag()).dialogKey() + "已处于显示状态，请勿重复执行 show() 指令。");
                                        return;
                                    }
                                    if (view.getParent() != null) {
                                        ((ViewGroup) view.getParent()).removeView(view);
                                    }
                                    decorView.addView(view);
                                }
                            });
                        }
                    } else {
                        if (waitRunDialogX == null) {
                            waitRunDialogX = new HashMap();
                        }
                        waitRunDialogX.put(baseDialog.dialogKey(), new ActivityRunnable() {
                            public void run(Activity activity) {
                                BaseDialog.this.floatingWindowActivity = new WeakReference<>((DialogXFloatingWindowActivity) activity);
                                ((DialogXFloatingWindowActivity) BaseDialog.this.floatingWindowActivity.get()).setFromActivity(BaseDialog.this.getOwnActivity());
                                final FrameLayout decorView = BaseDialog.getDecorView(activity);
                                if (decorView != null) {
                                    BaseDialog.runOnMain(new Runnable() {
                                        public void run() {
                                            if (view.getParent() == BaseDialog.this.getRootFrameLayout()) {
                                                BaseDialog.error(((BaseDialog) view.getTag()).dialogKey() + "已处于显示状态，请勿重复执行 show() 指令。");
                                                return;
                                            }
                                            if (view.getParent() != null) {
                                                ((ViewGroup) view.getParent()).removeView(view);
                                            }
                                            decorView.addView(view);
                                        }
                                    });
                                }
                            }
                        });
                        DialogXFloatingWindowActivity dialogXFloatingWindowActivity = DialogXFloatingWindowActivity.getDialogXFloatingWindowActivity();
                        if (dialogXFloatingWindowActivity == null || !dialogXFloatingWindowActivity.isSameFrom(activity.hashCode())) {
                            Intent intent = new Intent(activity, DialogXFloatingWindowActivity.class);
                            intent.putExtra("dialogXKey", baseDialog.dialogKey());
                            intent.putExtra(TypedValues.TransitionType.S_FROM, activity.hashCode());
                            intent.putExtra("fromActivityUiStatus", getDecorView(activity) == null ? 0 : getDecorView(activity).getSystemUiVisibility());
                            activity.startActivity(intent);
                            if (Integer.valueOf(Build.VERSION.SDK_INT).intValue() > 5) {
                                activity.overridePendingTransition(0, 0);
                                return;
                            }
                            return;
                        }
                        dialogXFloatingWindowActivity.showDialogX(baseDialog.dialogKey());
                    }
                }
            }
        }
    }

    private void setOwnActivity(Activity activity) {
        this.ownActivity = new WeakReference<>(activity);
    }

    /* access modifiers changed from: protected */
    public static void dismiss(final View view) {
        if (view != null) {
            final BaseDialog baseDialog = (BaseDialog) view.getTag();
            log(baseDialog.dialogKey() + ".dismiss");
            removeDialogToRunningList(baseDialog);
            WeakReference<View> weakReference = baseDialog.dialogView;
            if (weakReference != null) {
                weakReference.clear();
            }
            int i = AnonymousClass8.$SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE[baseDialog.dialogImplMode.ordinal()];
            if (i == 1) {
                WindowUtil.dismiss(view);
            } else if (i == 2) {
                WeakReference<DialogFragmentImpl> weakReference2 = baseDialog.ownDialogFragmentImpl;
                if (!(weakReference2 == null || weakReference2.get() == null)) {
                    ((DialogFragmentImpl) baseDialog.ownDialogFragmentImpl.get()).dismiss();
                }
            } else if (i != 3) {
                runOnMain(new Runnable() {
                    public void run() {
                        if (view.getParent() != null && (view.getParent() instanceof ViewGroup)) {
                            ((ViewGroup) view.getParent()).removeView(view);
                        } else if (baseDialog.getRootFrameLayout() != null) {
                            baseDialog.getRootFrameLayout().removeView(view);
                        } else {
                            return;
                        }
                        BaseDialog.requestDialogFocus();
                    }
                }, true);
            } else {
                WeakReference<DialogXFloatingWindowActivity> weakReference3 = baseDialog.floatingWindowActivity;
                if (!(weakReference3 == null || weakReference3.get() == null)) {
                    FrameLayout decorView = getDecorView((Activity) baseDialog.floatingWindowActivity.get());
                    if (decorView != null) {
                        decorView.removeView(view);
                    }
                    ((DialogXFloatingWindowActivity) baseDialog.floatingWindowActivity.get()).finish(baseDialog.dialogKey());
                    requestDialogFocus();
                }
            }
            if (baseDialog.getDialogListBuilder() != null && !baseDialog.getDialogListBuilder().isEmpty()) {
                baseDialog.getDialogListBuilder().showNext();
            }
        }
    }

    private static void addDialogToRunningList(BaseDialog baseDialog) {
        if (runningDialogList == null) {
            runningDialogList = new CopyOnWriteArrayList();
        }
        runningDialogList.add(baseDialog);
    }

    private static void removeDialogToRunningList(BaseDialog baseDialog) {
        List<BaseDialog> list = runningDialogList;
        if (list != null) {
            list.remove(baseDialog);
        }
    }

    public static Activity getTopActivity() {
        WeakReference<Activity> weakReference = activityWeakReference;
        if (weakReference != null && weakReference.get() != null) {
            return (Activity) activityWeakReference.get();
        }
        init((Context) null);
        WeakReference<Activity> weakReference2 = activityWeakReference;
        if (weakReference2 != null && weakReference2.get() != null) {
            return (Activity) activityWeakReference.get();
        }
        Activity topActivity = ActivityLifecycleImpl.getTopActivity();
        init(topActivity);
        return topActivity;
    }

    @Deprecated
    public static Context getContext() {
        return getPrivateContext();
    }

    private static Context getPrivateContext() {
        Activity topActivity = getTopActivity();
        if (topActivity != null) {
            return topActivity;
        }
        Context applicationContext = getApplicationContext();
        if (applicationContext != null) {
            return applicationContext;
        }
        error("DialogX 未初始化(E2)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return null;
    }

    public static Context getApplicationContext() {
        return ActivityLifecycleImpl.getApplicationContext();
    }

    public static void cleanContext() {
        WeakReference<Activity> weakReference = activityWeakReference;
        if (weakReference != null) {
            weakReference.clear();
        }
        activityWeakReference = null;
        System.gc();
    }

    public BaseDialog() {
        this.dialogImplMode = DialogX.implIMPLMode;
        this.lifecycle = new LifecycleRegistry(this);
        this.cancelable = true;
        this.backgroundColor = null;
        this.enterAnimDuration = -1;
        this.exitAnimDuration = -1;
        this.screenPaddings = new int[4];
        this.cancelable = DialogX.cancelable;
        this.style = DialogX.globalStyle;
        this.theme = DialogX.globalTheme;
        this.enterAnimDuration = DialogX.enterAnimDuration;
        this.exitAnimDuration = DialogX.exitAnimDuration;
        this.autoShowInputKeyboard = DialogX.autoShowInputKeyboard;
    }

    public View createView(int i) {
        if (getOwnActivity() != null) {
            return LayoutInflater.from(getOwnActivity()).inflate(i, (ViewGroup) null);
        }
        error("DialogX 未初始化(E3)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return null;
    }

    public boolean isShow() {
        return this.isShow;
    }

    public DialogXStyle getStyle() {
        return this.style;
    }

    public DialogX.THEME getTheme() {
        return this.theme;
    }

    public static void useTextInfo(TextView textView, TextInfo textInfo) {
        if (textInfo != null && textView != null) {
            if (textInfo.getFontSize() > 0) {
                textView.setTextSize(textInfo.getFontSizeComplexUnit(), (float) textInfo.getFontSize());
            }
            if (textInfo.getFontColor() != 1) {
                textView.setTextColor(textInfo.getFontColor());
            }
            if (textInfo.getGravity() != -1) {
                textView.setGravity(textInfo.getGravity());
            }
            if (textInfo.isShowEllipsis()) {
                textView.setEllipsize(TextUtils.TruncateAt.END);
            } else {
                textView.setEllipsize((TextUtils.TruncateAt) null);
            }
            if (textInfo.getMaxLines() != -1) {
                textView.setMaxLines(textInfo.getMaxLines());
            } else {
                textView.setMaxLines(Integer.MAX_VALUE);
            }
            textView.getPaint().setFakeBoldText(textInfo.isBold());
        }
    }

    /* access modifiers changed from: protected */
    public void showText(TextView textView, CharSequence charSequence) {
        if (textView != null) {
            if (isNull(charSequence)) {
                textView.setVisibility(8);
                textView.setText("");
                return;
            }
            textView.setVisibility(0);
            textView.setText(charSequence);
        }
    }

    public static boolean isNull(String str) {
        return str == null || str.trim().isEmpty() || "null".equals(str) || "(null)".equals(str);
    }

    public static boolean isNull(CharSequence charSequence) {
        String valueOf = String.valueOf(charSequence);
        return charSequence == null || valueOf.trim().isEmpty() || "null".equals(valueOf) || "(null)".equals(valueOf);
    }

    public Resources getResources() {
        if (getOwnActivity() != null) {
            return getOwnActivity().getResources();
        }
        if (getApplicationContext() == null) {
            return Resources.getSystem();
        }
        return getApplicationContext().getResources();
    }

    public int dip2px(float f) {
        return (int) ((f * getResources().getDisplayMetrics().density) + 0.5f);
    }

    public boolean isLightTheme() {
        if (this.theme == DialogX.THEME.AUTO) {
            if (getApplicationContext() == null) {
                if (this.theme == DialogX.THEME.LIGHT) {
                    return true;
                }
                return false;
            } else if ((getResources().getConfiguration().uiMode & 48) == 16) {
                return true;
            } else {
                return false;
            }
        } else if (this.theme == DialogX.THEME.LIGHT) {
            return true;
        } else {
            return false;
        }
    }

    public FrameLayout getRootFrameLayout() {
        Activity ownActivity2 = getOwnActivity();
        if (ownActivity2 == null) {
            ownActivity2 = getTopActivity();
            if (ownActivity2 == null) {
                error("DialogX 错误：在 getRootFrameLayout() 时无法获取绑定的 activity，请确认是否正确初始化：\nDialogX.init(context);\n\n或者使用 .show(activity) 启动对话框\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                return null;
            }
            setOwnActivity(ownActivity2);
        }
        FrameLayout decorView = getDecorView(ownActivity2);
        if (decorView == null) {
            error("DialogX 错误：在 getRootFrameLayout() 时无法获 activity(" + ownActivity2 + ") 的 decorView，请检查该 activity 是否正常显示且可以使 DialogX 基于其显示。\n若该 activity 不可用，可通过以下代码配置豁免 DialogX 对话框绑定至该 activity，例如：\nDialogX.unsupportedActivitiesPackageNames = new String[]{\n        \"com.bytedance.sdk.openadsdk.stub.activity\",\n        \"com.mobile.auth.gatewayauth\",\n        \"com.google.android.gms.ads\"\n};\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
            return null;
        }
        WeakReference<FrameLayout> weakReference = new WeakReference<>(decorView);
        this.rootFrameLayout = weakReference;
        return (FrameLayout) weakReference.get();
    }

    public void tintColor(View view, int i) {
        if (view != null) {
            view.setBackgroundTintList(ColorStateList.valueOf(i));
        }
    }

    /* access modifiers changed from: protected */
    public void beforeShow() {
        View currentFocus;
        this.preShow = true;
        this.dismissAnimFlag = false;
        setOwnActivity(getTopActivity());
        if (getOwnActivity() == null) {
            init((Context) null);
            if (getOwnActivity() == null) {
                error("DialogX 未初始化(E5)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
                return;
            }
        }
        if (this.dialogImplMode != DialogX.IMPL_MODE.VIEW && (getOwnActivity() instanceof LifecycleOwner)) {
            ((LifecycleOwner) getOwnActivity()).getLifecycle().addObserver(new LifecycleEventObserver() {
                public void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    if (event == Lifecycle.Event.ON_DESTROY) {
                        BaseDialog.recycleDialog(BaseDialog.this.getOwnActivity());
                    }
                }
            });
        }
        if (!(this instanceof NoTouchInterface) && (currentFocus = getOwnActivity().getCurrentFocus()) != null) {
            ((InputMethodManager) getOwnActivity().getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    /* access modifiers changed from: protected */
    public String getString(int i) {
        if (getApplicationContext() != null) {
            return getResources().getString(i);
        }
        error("DialogX 未初始化(E6)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return null;
    }

    /* access modifiers changed from: protected */
    public int getColor(int i) {
        if (getApplicationContext() != null) {
            return getResources().getColor(i);
        }
        error("DialogX 未初始化(E7)。\n请检查是否在启动对话框前进行初始化操作，使用以下代码进行初始化：\nDialogX.init(context);\n\n另外建议您前往查看 DialogX 的文档进行使用：https://github.com/kongzue/DialogX");
        return ViewCompat.MEASURED_STATE_MASK;
    }

    /* access modifiers changed from: protected */
    public Integer getColorNullable(Integer num) {
        if (num == null) {
            return null;
        }
        return Integer.valueOf(getColor(num.intValue()));
    }

    /* access modifiers changed from: protected */
    public Integer getColorNullable(Integer num, Integer num2) {
        return Integer.valueOf(getColor(num == null ? num2.intValue() : num.intValue()));
    }

    /* access modifiers changed from: protected */
    public static void runOnMain(Runnable runnable) {
        if (!DialogX.autoRunOnUIThread || (getUiThread() != null && Thread.currentThread() == getUiThread())) {
            runnable.run();
        } else {
            runOnMain(runnable, true);
        }
    }

    protected static Thread getUiThread() {
        if (uiThread == null) {
            uiThread = Looper.getMainLooper().getThread();
        }
        return uiThread;
    }

    protected static void runOnMain(Runnable runnable, boolean z) {
        getMainHandler().post(runnable);
    }

    /* access modifiers changed from: protected */
    public static void runOnMainDelay(Runnable runnable, long j) {
        if (j >= 0) {
            if (!DialogX.autoRunOnUIThread) {
                runnable.run();
            }
            getMainHandler().postDelayed(runnable, j);
        }
    }

    public View getDialogView() {
        WeakReference<View> weakReference = this.dialogView;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public Activity getOwnActivity() {
        WeakReference<Activity> weakReference = this.ownActivity;
        if (weakReference == null || weakReference.get() == null) {
            setOwnActivity(getTopActivity());
        }
        return (Activity) this.ownActivity.get();
    }

    /* access modifiers changed from: protected */
    public void cleanActivityContext() {
        WeakReference<Activity> weakReference = this.ownActivity;
        if (weakReference != null) {
            weakReference.clear();
        }
        this.dialogView = null;
        this.ownActivity = null;
    }

    public static void cleanAll() {
        if (runningDialogList != null) {
            Iterator it = new CopyOnWriteArrayList(runningDialogList).iterator();
            while (it.hasNext()) {
                BaseDialog baseDialog = (BaseDialog) it.next();
                if (baseDialog.isShow()) {
                    baseDialog.shutdown();
                }
                baseDialog.cleanActivityContext();
                runningDialogList.remove(baseDialog);
            }
        }
    }

    public static void recycleDialog(Activity activity) {
        WeakReference<View> weakReference;
        WeakReference<DialogFragmentImpl> weakReference2;
        int i = AnonymousClass8.$SwitchMap$com$kongzue$dialogx$DialogX$IMPL_MODE[DialogX.implIMPLMode.ordinal()];
        if (i != 1) {
            if (i != 2) {
                if (!(i == 3 || runningDialogList == null)) {
                    Iterator it = new CopyOnWriteArrayList(runningDialogList).iterator();
                    while (it.hasNext()) {
                        BaseDialog baseDialog = (BaseDialog) it.next();
                        if (baseDialog.getOwnActivity() == activity) {
                            baseDialog.cleanActivityContext();
                            runningDialogList.remove(baseDialog);
                            if (baseDialog instanceof WaitDialog) {
                                ((WaitDialog) baseDialog).cleanInstance();
                            }
                        }
                    }
                }
            } else if (runningDialogList != null) {
                Iterator it2 = new CopyOnWriteArrayList(runningDialogList).iterator();
                while (it2.hasNext()) {
                    BaseDialog baseDialog2 = (BaseDialog) it2.next();
                    if (!(baseDialog2.getOwnActivity() != activity || (weakReference2 = baseDialog2.ownDialogFragmentImpl) == null || weakReference2.get() == null)) {
                        ((DialogFragmentImpl) baseDialog2.ownDialogFragmentImpl.get()).dismiss();
                        if (baseDialog2 instanceof WaitDialog) {
                            ((WaitDialog) baseDialog2).cleanInstance();
                        }
                        runningDialogList.remove(baseDialog2);
                    }
                }
            }
        } else if (runningDialogList != null) {
            Iterator it3 = new CopyOnWriteArrayList(runningDialogList).iterator();
            while (it3.hasNext()) {
                BaseDialog baseDialog3 = (BaseDialog) it3.next();
                if (baseDialog3.getOwnActivity() == activity && (weakReference = baseDialog3.dialogView) != null) {
                    WindowUtil.dismiss((View) weakReference.get());
                    if (baseDialog3 instanceof WaitDialog) {
                        ((WaitDialog) baseDialog3).cleanInstance();
                    }
                    runningDialogList.remove(baseDialog3);
                }
            }
        }
        if (activity == getTopActivity()) {
            cleanContext();
        }
    }

    public static List<BaseDialog> getRunningDialogList() {
        if (runningDialogList == null) {
            return new ArrayList();
        }
        return new CopyOnWriteArrayList(runningDialogList);
    }

    /* access modifiers changed from: protected */
    public void imeShow(EditText editText, boolean z) {
        if (getOwnActivity() != null) {
            InputMethodManager inputMethodManager = (InputMethodManager) getOwnActivity().getSystemService("input_method");
            if (z) {
                inputMethodManager.showSoftInput(editText, 0);
            } else {
                inputMethodManager.hideSoftInputFromWindow(editText.getWindowToken(), 0);
            }
        }
    }

    public DialogX.IMPL_MODE getDialogImplMode() {
        return this.dialogImplMode;
    }

    public static WindowInsets publicWindowInsets() {
        return windowInsets;
    }

    /* access modifiers changed from: protected */
    public void bindFloatingActivity(DialogXFloatingWindowActivity dialogXFloatingWindowActivity) {
        this.floatingWindowActivity = new WeakReference<>(dialogXFloatingWindowActivity);
    }

    private static Handler getMainHandler() {
        WeakReference<Handler> weakReference = mMainHandler;
        if (weakReference != null && weakReference.get() != null) {
            return (Handler) mMainHandler.get();
        }
        WeakReference<Handler> weakReference2 = new WeakReference<>(new Handler(Looper.getMainLooper()));
        mMainHandler = weakReference2;
        return (Handler) weakReference2.get();
    }

    public DialogListBuilder getDialogListBuilder() {
        WeakReference<DialogListBuilder> weakReference = this.dialogListBuilder;
        if (weakReference == null) {
            return null;
        }
        return (DialogListBuilder) weakReference.get();
    }

    public void setDialogListBuilder(DialogListBuilder dialogListBuilder2) {
        this.dialogListBuilder = new WeakReference<>(dialogListBuilder2);
    }

    public void cleanDialogList() {
        this.dialogListBuilder = null;
    }

    public boolean isPreShow() {
        return this.preShow;
    }

    public Lifecycle getLifecycle() {
        return this.lifecycle;
    }

    public int getMaxWidth() {
        int i = this.maxWidth;
        return i == 0 ? DialogX.dialogMaxWidth : i;
    }

    public int getMaxHeight() {
        int i = this.maxHeight;
        return i == 0 ? DialogX.dialogMaxHeight : i;
    }

    public int getMinWidth() {
        int i = this.minWidth;
        return i == 0 ? DialogX.dialogMinWidth : i;
    }

    public int getMinHeight() {
        int i = this.minHeight;
        return i == 0 ? DialogX.dialogMinHeight : i;
    }

    /* access modifiers changed from: protected */
    public void setLifecycleState(Lifecycle.State state) {
        LifecycleRegistry lifecycleRegistry = this.lifecycle;
        if (lifecycleRegistry != null && state != null) {
            try {
                lifecycleRegistry.setCurrentState(state);
            } catch (Exception unused) {
            }
        }
    }

    protected static FrameLayout getDecorView(Activity activity) {
        if (activity == null || activity.getWindow() == null || !(activity.getWindow().getDecorView() instanceof FrameLayout)) {
            return null;
        }
        return (FrameLayout) activity.getWindow().getDecorView();
    }

    /* access modifiers changed from: protected */
    public List<View> findAllBlurView(View view) {
        ArrayList arrayList = new ArrayList();
        if (view instanceof BlurViewType) {
            arrayList.add(view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                List<View> findAllBlurView = findAllBlurView(viewGroup.getChildAt(i));
                if (findAllBlurView != null) {
                    arrayList.addAll(findAllBlurView);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public Integer getIntStyleAttr(Integer num) {
        if (num.intValue() <= 0) {
            return null;
        }
        return num;
    }

    /* access modifiers changed from: protected */
    public Integer getIntStyleAttr(Integer num, Integer num2) {
        return num.intValue() <= 0 ? num2 : num;
    }

    /* access modifiers changed from: protected */
    public Float getFloatStyleAttr(Float f) {
        if (f.floatValue() <= 0.0f) {
            return null;
        }
        return f;
    }

    /* access modifiers changed from: protected */
    public Float getFloatStyleAttr(Float f, Float f2) {
        if (f.floatValue() <= 0.0f) {
            log("styleValue=" + f + "<=0 ");
            log("return defaultValue=" + f2);
            return f2;
        }
        log("return styleValue=" + f);
        return f;
    }

    /* access modifiers changed from: protected */
    public void setDialogView(View view) {
        this.dialogView = new WeakReference<>(view);
    }
}
