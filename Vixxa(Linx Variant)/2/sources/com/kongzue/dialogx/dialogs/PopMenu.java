package com.kongzue.dialogx.dialogs;

import android.animation.ValueAnimator;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.lifecycle.Lifecycle;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.R;
import com.kongzue.dialogx.interfaces.BaseDialog;
import com.kongzue.dialogx.interfaces.BlurViewType;
import com.kongzue.dialogx.interfaces.DialogConvertViewInterface;
import com.kongzue.dialogx.interfaces.DialogLifecycleCallback;
import com.kongzue.dialogx.interfaces.DialogXAnimInterface;
import com.kongzue.dialogx.interfaces.DialogXStyle;
import com.kongzue.dialogx.interfaces.MenuItemLayoutRefreshCallback;
import com.kongzue.dialogx.interfaces.OnBackPressedListener;
import com.kongzue.dialogx.interfaces.OnBackgroundMaskClickListener;
import com.kongzue.dialogx.interfaces.OnBindView;
import com.kongzue.dialogx.interfaces.OnIconChangeCallBack;
import com.kongzue.dialogx.interfaces.OnMenuItemClickListener;
import com.kongzue.dialogx.util.DialogXViewLoc;
import com.kongzue.dialogx.util.PopMenuArrayAdapter;
import com.kongzue.dialogx.util.TextInfo;
import com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout;
import com.kongzue.dialogx.util.views.MaxRelativeLayout;
import com.kongzue.dialogx.util.views.PopMenuListView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class PopMenu extends BaseDialog {
    public static long overrideEnterDuration = -1;
    public static long overrideExitDuration = -1;
    protected int alignGravity = -1;
    protected float backgroundRadius = -1.0f;
    /* access modifiers changed from: private */
    public ViewTreeObserver.OnDrawListener baseViewDrawListener;
    protected DialogXViewLoc baseViewLoc = new DialogXViewLoc();
    protected WeakReference<View> baseViewWeakReference;
    protected boolean bkgInterceptTouch = true;
    /* access modifiers changed from: private */
    public boolean closing;
    protected DialogImpl dialogImpl;
    protected DialogLifecycleCallback<PopMenu> dialogLifecycleCallback;
    protected DialogXAnimInterface<PopMenu> dialogXAnimImpl;
    protected int height = -1;
    protected boolean hideWithExitAnim;
    protected boolean isEnterAnimRunning;
    private boolean isHide;
    protected PopMenu me = this;
    protected List<CharSequence> menuList;
    protected PopMenuArrayAdapter menuListAdapter;
    protected MenuItemLayoutRefreshCallback<PopMenu> menuMenuItemLayoutRefreshCallback;
    protected TextInfo menuTextInfo;
    protected boolean offScreen = false;
    protected OnBackPressedListener<PopMenu> onBackPressedListener;
    protected OnBackgroundMaskClickListener<PopMenu> onBackgroundMaskClickListener;
    protected OnBindView<PopMenu> onBindView;
    protected OnIconChangeCallBack<PopMenu> onIconChangeCallBack;
    protected OnMenuItemClickListener<PopMenu> onMenuItemClickListener;
    protected boolean overlayBaseView = true;
    protected int pressedIndex = -1;
    /* access modifiers changed from: private */
    public int selectIndex;
    protected int selectItemYDeviation;
    /* access modifiers changed from: private */
    public ViewTreeObserver viewTreeObserver;
    protected int width = -1;

    public boolean isCancelable() {
        return true;
    }

    public void onDismiss(PopMenu popMenu) {
    }

    public void onShow(PopMenu popMenu) {
    }

    /* access modifiers changed from: protected */
    public void shutdown() {
    }

    public PopMenu() {
    }

    public PopMenu(View view, List<CharSequence> list) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(list);
        baseView(view);
    }

    public PopMenu(View view, CharSequence[] charSequenceArr) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(charSequenceArr));
        baseView(view);
    }

    public PopMenu(List<CharSequence> list) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(list);
    }

    public PopMenu(CharSequence[] charSequenceArr) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(charSequenceArr));
    }

    public PopMenu(OnBindView<PopMenu> onBindView2) {
        this.onBindView = onBindView2;
    }

    public PopMenu(View view, OnBindView<PopMenu> onBindView2) {
        baseView(view);
        this.onBindView = onBindView2;
    }

    public PopMenu(View view, List<CharSequence> list, OnBindView<PopMenu> onBindView2) {
        baseView(view);
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(list);
        this.onBindView = onBindView2;
    }

    public PopMenu(View view, CharSequence[] charSequenceArr, OnBindView<PopMenu> onBindView2) {
        baseView(view);
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(charSequenceArr));
        this.onBindView = onBindView2;
    }

    public PopMenu(List<CharSequence> list, OnBindView<PopMenu> onBindView2) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(list);
        this.onBindView = onBindView2;
    }

    public PopMenu(CharSequence[] charSequenceArr, OnBindView<PopMenu> onBindView2) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(charSequenceArr));
        this.onBindView = onBindView2;
    }

    public static PopMenu build() {
        return new PopMenu();
    }

    public static PopMenu build(DialogXStyle dialogXStyle) {
        return new PopMenu().setStyle(dialogXStyle);
    }

    public static PopMenu show(CharSequence[] charSequenceArr) {
        PopMenu popMenu = new PopMenu(charSequenceArr);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(List<CharSequence> list) {
        PopMenu popMenu = new PopMenu(list);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(View view, CharSequence[] charSequenceArr) {
        PopMenu popMenu = new PopMenu(view, charSequenceArr);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(View view, List<CharSequence> list) {
        PopMenu popMenu = new PopMenu(view, list);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(View view, CharSequence[] charSequenceArr, OnBindView<PopMenu> onBindView2) {
        PopMenu popMenu = new PopMenu(view, charSequenceArr, onBindView2);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(View view, List<CharSequence> list, OnBindView<PopMenu> onBindView2) {
        PopMenu popMenu = new PopMenu(view, list, onBindView2);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(CharSequence[] charSequenceArr, OnBindView<PopMenu> onBindView2) {
        PopMenu popMenu = new PopMenu(charSequenceArr, onBindView2);
        popMenu.show();
        return popMenu;
    }

    public static PopMenu show(List<CharSequence> list, OnBindView<PopMenu> onBindView2) {
        PopMenu popMenu = new PopMenu(list, onBindView2);
        popMenu.show();
        return popMenu;
    }

    public PopMenu show() {
        if (!this.isHide || getDialogView() == null || !this.isShow) {
            super.beforeShow();
            if (getDialogView() == null) {
                int i = isLightTheme() ? R.layout.layout_dialogx_popmenu_material : R.layout.layout_dialogx_popmenu_material_dark;
                if (!(getStyle().popMenuSettings() == null || getStyle().popMenuSettings().layout(isLightTheme()) == 0)) {
                    i = getStyle().popMenuSettings().layout(isLightTheme());
                }
                View createView = createView(i);
                this.dialogImpl = new DialogImpl(createView);
                if (createView != null) {
                    createView.setTag(this.me);
                }
                show(createView);
            } else {
                show(getDialogView());
            }
            if (baseView() != null) {
                ViewTreeObserver viewTreeObserver2 = baseView().getViewTreeObserver();
                this.viewTreeObserver = viewTreeObserver2;
                AnonymousClass1 r1 = new ViewTreeObserver.OnDrawListener() {
                    public void onDraw() {
                        int[] iArr = new int[2];
                        if (PopMenu.this.baseView() != null) {
                            PopMenu.this.baseView().getLocationInWindow(iArr);
                            if (PopMenu.this.getDialogImpl() != null && !PopMenu.this.baseViewLoc.isSameLoc(iArr)) {
                                PopMenu.this.baseViewLoc.set(iArr);
                                PopMenu.this.refreshMenuLoc();
                            }
                        } else if (PopMenu.this.viewTreeObserver != null) {
                            PopMenu popMenu = PopMenu.this;
                            popMenu.removeDrawListener(popMenu.viewTreeObserver, this);
                            ViewTreeObserver unused = PopMenu.this.viewTreeObserver = null;
                            ViewTreeObserver.OnDrawListener unused2 = PopMenu.this.baseViewDrawListener = null;
                        }
                    }
                };
                this.baseViewDrawListener = r1;
                viewTreeObserver2.addOnDrawListener(r1);
            }
            return this;
        }
        if (!this.hideWithExitAnim || getDialogImpl() == null) {
            getDialogView().setVisibility(0);
        } else {
            getDialogImpl().boxBody.clearAnimation();
            getDialogView().setVisibility(0);
            getDialogImpl().boxRoot.animate().alpha(1.0f);
            getDialogImpl().getDialogXAnimImpl().doShowAnim(this.me, getDialogImpl().boxBody);
        }
        return this;
    }

    /* access modifiers changed from: private */
    public void refreshMenuLoc() {
        if (getDialogImpl() != null && getDialogImpl().boxRoot != null) {
            getDialogImpl().boxBody.setTag((Object) null);
            DialogXViewLoc menuLoc = getMenuLoc();
            getDialogImpl().boxBody.setTag(menuLoc);
            if (!this.isEnterAnimRunning) {
                if (menuLoc.getX() != getDialogImpl().boxBody.getX()) {
                    getDialogImpl().boxBody.setX(menuLoc.getX());
                }
                if (menuLoc.getY() != getDialogImpl().boxBody.getY()) {
                    getDialogImpl().boxBody.setY(menuLoc.getY());
                }
            }
            if (((float) getDialogImpl().boxBody.getWidth()) != menuLoc.getW()) {
                getDialogImpl().boxBody.setLayoutParams(new RelativeLayout.LayoutParams((int) menuLoc.getW(), -2));
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0234  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.kongzue.dialogx.util.DialogXViewLoc getMenuLoc() {
        /*
            r14 = this;
            com.kongzue.dialogx.dialogs.PopMenu$DialogImpl r0 = r14.getDialogImpl()
            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.boxBody
            java.lang.Object r0 = r0.getTag()
            boolean r0 = r0 instanceof com.kongzue.dialogx.util.DialogXViewLoc
            if (r0 == 0) goto L_0x001b
            com.kongzue.dialogx.dialogs.PopMenu$DialogImpl r0 = r14.getDialogImpl()
            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.boxBody
            java.lang.Object r0 = r0.getTag()
            com.kongzue.dialogx.util.DialogXViewLoc r0 = (com.kongzue.dialogx.util.DialogXViewLoc) r0
            return r0
        L_0x001b:
            com.kongzue.dialogx.util.DialogXViewLoc r0 = new com.kongzue.dialogx.util.DialogXViewLoc
            r0.<init>()
            com.kongzue.dialogx.dialogs.PopMenu$DialogImpl r1 = r14.getDialogImpl()
            com.kongzue.dialogx.util.views.MaxRelativeLayout r1 = r1.boxBody
            com.kongzue.dialogx.dialogs.PopMenu$DialogImpl r2 = r14.getDialogImpl()
            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r2 = r2.boxRoot
            com.kongzue.dialogx.util.DialogXViewLoc r3 = r14.baseViewLoc
            float r3 = r3.getX()
            int r3 = (int) r3
            com.kongzue.dialogx.util.DialogXViewLoc r4 = r14.baseViewLoc
            float r4 = r4.getY()
            int r4 = (int) r4
            int r5 = r14.alignGravity
            r6 = -1
            r7 = 0
            if (r5 == r6) goto L_0x0271
            r5 = 16
            boolean r5 = r14.isAlignGravity(r5)
            if (r5 == 0) goto L_0x005f
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r8 = r1.getHeight()
            int r8 = r8 / 2
            int r5 = r5 - r8
            int r5 = java.lang.Math.max(r7, r5)
            goto L_0x0060
        L_0x005f:
            r5 = r7
        L_0x0060:
            r8 = 1
            boolean r8 = r14.isAlignGravity(r8)
            if (r8 == 0) goto L_0x0086
            int r8 = r14.getWidth()
            if (r8 <= 0) goto L_0x007f
            android.view.View r8 = r14.baseView()
            int r8 = r8.getMeasuredWidth()
            int r8 = r8 / 2
            int r9 = r14.getWidth()
            int r9 = r9 / 2
            int r8 = r8 - r9
            goto L_0x0080
        L_0x007f:
            r8 = r7
        L_0x0080:
            int r8 = r8 + r3
            int r8 = java.lang.Math.max(r7, r8)
            goto L_0x0087
        L_0x0086:
            r8 = r7
        L_0x0087:
            r9 = 17
            boolean r9 = r14.isAlignGravity(r9)
            if (r9 == 0) goto L_0x00c3
            int r5 = r14.getWidth()
            if (r5 <= 0) goto L_0x00a7
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 / 2
            int r8 = r14.getWidth()
            int r8 = r8 / 2
            int r5 = r5 - r8
            goto L_0x00a8
        L_0x00a7:
            r5 = r7
        L_0x00a8:
            int r5 = r5 + r3
            int r8 = java.lang.Math.max(r7, r5)
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r9 = r1.getHeight()
            int r9 = r9 / 2
            int r5 = r5 - r9
            int r5 = java.lang.Math.max(r7, r5)
        L_0x00c3:
            boolean r9 = r14.overlayBaseView
            r10 = 80
            r11 = 5
            r12 = 3
            r13 = 48
            if (r9 == 0) goto L_0x0178
            boolean r9 = r14.isAlignGravity(r13)
            if (r9 == 0) goto L_0x0101
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 + r4
            int r9 = r1.getHeight()
            int r5 = r5 - r9
            if (r8 != 0) goto L_0x0101
            int r8 = r14.getWidth()
            if (r8 <= 0) goto L_0x00fb
            android.view.View r8 = r14.baseView()
            int r8 = r8.getMeasuredWidth()
            int r8 = r8 / 2
            int r9 = r14.getWidth()
            int r9 = r9 / 2
            int r8 = r8 - r9
            goto L_0x00fc
        L_0x00fb:
            r8 = r7
        L_0x00fc:
            int r8 = r8 + r3
            int r8 = java.lang.Math.max(r7, r8)
        L_0x0101:
            boolean r9 = r14.isAlignGravity(r12)
            if (r9 == 0) goto L_0x0131
            android.view.View r8 = r14.baseView()
            int r8 = r8.getMeasuredWidth()
            int r8 = r8 + r3
            int r9 = r1.getWidth()
            int r8 = r8 - r9
            int r8 = java.lang.Math.max(r7, r8)
            if (r5 != 0) goto L_0x0131
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r9 = r1.getHeight()
            int r9 = r9 / 2
            int r5 = r5 - r9
            int r5 = java.lang.Math.max(r7, r5)
        L_0x0131:
            boolean r9 = r14.isAlignGravity(r11)
            if (r9 == 0) goto L_0x0150
            if (r5 != 0) goto L_0x014f
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r8 = r1.getHeight()
            int r8 = r8 / 2
            int r5 = r5 - r8
            int r5 = java.lang.Math.max(r7, r5)
        L_0x014f:
            r8 = r3
        L_0x0150:
            boolean r9 = r14.isAlignGravity(r10)
            if (r9 == 0) goto L_0x022f
            if (r8 != 0) goto L_0x0230
            int r5 = r14.getWidth()
            if (r5 <= 0) goto L_0x0170
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 / 2
            int r8 = r14.getWidth()
            int r8 = r8 / 2
            int r5 = r5 - r8
            goto L_0x0171
        L_0x0170:
            r5 = r7
        L_0x0171:
            int r3 = r3 + r5
            int r8 = java.lang.Math.max(r7, r3)
            goto L_0x0230
        L_0x0178:
            boolean r9 = r14.isAlignGravity(r13)
            if (r9 == 0) goto L_0x01a8
            int r5 = r1.getHeight()
            int r5 = r4 - r5
            int r5 = java.lang.Math.max(r7, r5)
            if (r8 != 0) goto L_0x01a8
            int r8 = r14.getWidth()
            if (r8 <= 0) goto L_0x01a2
            android.view.View r8 = r14.baseView()
            int r8 = r8.getMeasuredWidth()
            int r8 = r8 / 2
            int r9 = r14.getWidth()
            int r9 = r9 / 2
            int r8 = r8 - r9
            goto L_0x01a3
        L_0x01a2:
            r8 = r7
        L_0x01a3:
            int r8 = r8 + r3
            int r8 = java.lang.Math.max(r7, r8)
        L_0x01a8:
            boolean r9 = r14.isAlignGravity(r12)
            if (r9 == 0) goto L_0x01d0
            int r8 = r1.getWidth()
            int r8 = r3 - r8
            int r8 = java.lang.Math.max(r7, r8)
            if (r5 != 0) goto L_0x01d0
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r9 = r1.getHeight()
            int r9 = r9 / 2
            int r5 = r5 - r9
            int r5 = java.lang.Math.max(r7, r5)
        L_0x01d0:
            boolean r9 = r14.isAlignGravity(r11)
            if (r9 == 0) goto L_0x01fb
            android.view.View r8 = r14.baseView()
            int r8 = r8.getWidth()
            int r8 = r8 + r3
            int r8 = java.lang.Math.max(r7, r8)
            if (r5 != 0) goto L_0x01fb
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredHeight()
            int r5 = r5 / 2
            int r5 = r5 + r4
            int r9 = r1.getHeight()
            int r9 = r9 / 2
            int r5 = r5 - r9
            int r5 = java.lang.Math.max(r7, r5)
        L_0x01fb:
            boolean r9 = r14.isAlignGravity(r10)
            if (r9 == 0) goto L_0x022f
            android.view.View r5 = r14.baseView()
            int r5 = r5.getHeight()
            int r4 = r4 + r5
            int r4 = java.lang.Math.max(r7, r4)
            if (r8 != 0) goto L_0x0230
            int r5 = r14.getWidth()
            if (r5 <= 0) goto L_0x0228
            android.view.View r5 = r14.baseView()
            int r5 = r5.getMeasuredWidth()
            int r5 = r5 / 2
            int r8 = r14.getWidth()
            int r8 = r8 / 2
            int r5 = r5 - r8
            goto L_0x0229
        L_0x0228:
            r5 = r7
        L_0x0229:
            int r3 = r3 + r5
            int r8 = java.lang.Math.max(r7, r3)
            goto L_0x0230
        L_0x022f:
            r4 = r5
        L_0x0230:
            boolean r3 = r14.offScreen
            if (r3 != 0) goto L_0x0267
            if (r8 >= 0) goto L_0x0237
            r8 = r7
        L_0x0237:
            int r3 = r1.getWidth()
            int r3 = r3 + r8
            int r5 = r2.getUseAreaWidth()
            if (r3 <= r5) goto L_0x024c
            int r3 = r2.getUseAreaWidth()
            int r5 = r1.getWidth()
            int r3 = r3 - r5
            r8 = r3
        L_0x024c:
            if (r4 >= 0) goto L_0x024f
            goto L_0x0250
        L_0x024f:
            r7 = r4
        L_0x0250:
            int r3 = r1.getHeight()
            int r3 = r3 + r7
            int r4 = r2.getUseAreaHeight()
            if (r3 <= r4) goto L_0x0266
            int r2 = r2.getUseAreaHeight()
            int r1 = r1.getHeight()
            int r4 = r2 - r1
            goto L_0x0267
        L_0x0266:
            r4 = r7
        L_0x0267:
            float r1 = (float) r8
            com.kongzue.dialogx.util.DialogXViewLoc r1 = r0.setX(r1)
            float r2 = (float) r4
            r1.setY(r2)
            goto L_0x02d5
        L_0x0271:
            int r3 = r14.height
            if (r3 != r6) goto L_0x027d
            android.view.View r3 = r14.baseView()
            int r3 = r3.getHeight()
        L_0x027d:
            com.kongzue.dialogx.util.DialogXViewLoc r4 = r14.baseViewLoc
            float r4 = r4.getX()
            int r4 = (int) r4
            com.kongzue.dialogx.util.DialogXViewLoc r5 = r14.baseViewLoc
            float r5 = r5.getY()
            boolean r8 = r14.overlayBaseView
            if (r8 == 0) goto L_0x028f
            r3 = r7
        L_0x028f:
            float r3 = (float) r3
            float r5 = r5 + r3
            int r3 = r14.selectItemYDeviation
            float r3 = (float) r3
            float r5 = r5 + r3
            int r3 = (int) r5
            boolean r5 = r14.offScreen
            if (r5 != 0) goto L_0x02cc
            if (r4 >= 0) goto L_0x029d
            r4 = r7
        L_0x029d:
            int r5 = r1.getWidth()
            int r5 = r5 + r4
            int r8 = r2.getUseAreaWidth()
            if (r5 <= r8) goto L_0x02b1
            int r4 = r2.getUseAreaWidth()
            int r5 = r1.getWidth()
            int r4 = r4 - r5
        L_0x02b1:
            if (r3 >= 0) goto L_0x02b4
            goto L_0x02b5
        L_0x02b4:
            r7 = r3
        L_0x02b5:
            int r3 = r1.getHeight()
            int r3 = r3 + r7
            int r5 = r2.getUseAreaHeight()
            if (r3 <= r5) goto L_0x02cb
            int r2 = r2.getUseAreaHeight()
            int r1 = r1.getHeight()
            int r3 = r2 - r1
            goto L_0x02cc
        L_0x02cb:
            r3 = r7
        L_0x02cc:
            float r1 = (float) r4
            com.kongzue.dialogx.util.DialogXViewLoc r1 = r0.setX(r1)
            float r2 = (float) r3
            r1.setY(r2)
        L_0x02d5:
            int r1 = r14.width
            if (r1 != r6) goto L_0x02e1
            android.view.View r1 = r14.baseView()
            int r1 = r1.getWidth()
        L_0x02e1:
            int r2 = r14.height
            if (r2 != r6) goto L_0x02ed
            android.view.View r2 = r14.baseView()
            int r2 = r2.getHeight()
        L_0x02ed:
            float r1 = (float) r1
            com.kongzue.dialogx.util.DialogXViewLoc r1 = r0.setW(r1)
            float r2 = (float) r2
            r1.setH(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.dialogs.PopMenu.getMenuLoc():com.kongzue.dialogx.util.DialogXViewLoc");
    }

    public class DialogImpl implements DialogConvertViewInterface {
        /* access modifiers changed from: private */
        public List<View> blurViews;
        public MaxRelativeLayout boxBody;
        public RelativeLayout boxCustom;
        public DialogXBaseRelativeLayout boxRoot;
        public PopMenuListView listMenu;

        public DialogImpl(View view) {
            if (view != null) {
                PopMenu.this.setDialogView(view);
                this.boxRoot = (DialogXBaseRelativeLayout) view.findViewById(R.id.box_root);
                this.boxBody = (MaxRelativeLayout) view.findViewById(R.id.box_body);
                this.boxCustom = (RelativeLayout) view.findViewById(R.id.box_custom);
                this.listMenu = (PopMenuListView) view.findViewById(R.id.listMenu);
                this.boxBody.setVisibility(4);
                this.blurViews = PopMenu.this.findAllBlurView(view);
                this.boxBody.setX(-1.0f);
                this.boxBody.setY(-1.0f);
                init();
            }
        }

        public void init() {
            int i;
            int i2;
            boolean unused = PopMenu.this.closing = false;
            if (PopMenu.this.menuListAdapter == null) {
                PopMenu.this.menuListAdapter = new PopMenuArrayAdapter(PopMenu.this.me, PopMenu.this.getOwnActivity(), PopMenu.this.menuList);
            }
            this.boxRoot.setParentDialog(PopMenu.this.me);
            this.boxRoot.setOnLifecycleCallBack(new DialogXBaseRelativeLayout.OnLifecycleCallBack() {
                public void onShow() {
                    boolean unused = PopMenu.this.isShow = true;
                    boolean unused2 = PopMenu.this.preShow = false;
                    PopMenu.this.setLifecycleState(Lifecycle.State.CREATED);
                    PopMenu.this.onDialogShow();
                    PopMenu.this.getDialogLifecycleCallback().onShow(PopMenu.this.me);
                    PopMenu.this.onShow(PopMenu.this.me);
                    PopMenu.this.refreshUI();
                }

                public void onDismiss() {
                    boolean unused = PopMenu.this.isShow = false;
                    PopMenu.this.getDialogLifecycleCallback().onDismiss(PopMenu.this.me);
                    PopMenu.this.onDismiss(PopMenu.this.me);
                    PopMenu.this.menuListAdapter = null;
                    PopMenu.this.dialogImpl = null;
                    PopMenu.this.baseView((View) null);
                    PopMenu.this.dialogLifecycleCallback = null;
                    PopMenu.this.setLifecycleState(Lifecycle.State.DESTROYED);
                    System.gc();
                }
            });
            this.boxRoot.setOnBackPressedListener(new DialogXBaseRelativeLayout.PrivateBackPressedListener() {
                public boolean onBackPressed() {
                    if (PopMenu.this.onBackPressedListener != null) {
                        if (!PopMenu.this.onBackPressedListener.onBackPressed(PopMenu.this.me)) {
                            return true;
                        }
                        PopMenu.this.dismiss();
                        return true;
                    } else if (!PopMenu.this.isCancelable()) {
                        return true;
                    } else {
                        PopMenu.this.dismiss();
                        return true;
                    }
                }
            });
            this.listMenu.setMaxHeight((float) (PopMenu.this.getRootFrameLayout() == null ? PopMenu.this.dip2px(500.0f) : PopMenu.this.getRootFrameLayout().getMeasuredHeight() - PopMenu.this.dip2px(150.0f)));
            this.boxBody.setVisibility(4);
            this.boxBody.post(new Runnable() {
                public void run() {
                    Float f;
                    Integer num;
                    DialogImpl.this.getDialogXAnimImpl().doShowAnim(PopMenu.this.me, DialogImpl.this.boxBody);
                    PopMenu.this.setLifecycleState(Lifecycle.State.RESUMED);
                    if (PopMenu.this.style.popMenuSettings() == null || PopMenu.this.style.popMenuSettings().blurBackgroundSettings() == null) {
                        num = null;
                        f = null;
                    } else {
                        num = PopMenu.this.getColorNullable(PopMenu.this.getIntStyleAttr(Integer.valueOf(PopMenu.this.style.popMenuSettings().blurBackgroundSettings().blurForwardColorRes(PopMenu.this.isLightTheme()))));
                        f = PopMenu.this.getFloatStyleAttr(Float.valueOf((float) PopMenu.this.style.popMenuSettings().blurBackgroundSettings().blurBackgroundRoundRadiusPx()));
                    }
                    if (DialogImpl.this.blurViews != null) {
                        for (View view : DialogImpl.this.blurViews) {
                            BlurViewType blurViewType = (BlurViewType) view;
                            blurViewType.setOverlayColor(PopMenu.this.backgroundColor == null ? num : PopMenu.this.backgroundColor);
                            blurViewType.setRadiusPx(f);
                        }
                    }
                }
            });
            if (PopMenu.this.style.popMenuSettings() != null) {
                i2 = PopMenu.this.style.popMenuSettings().overrideMenuDividerDrawableRes(PopMenu.this.isLightTheme());
                i = PopMenu.this.style.popMenuSettings().overrideMenuDividerHeight(PopMenu.this.isLightTheme());
            } else {
                i2 = 0;
                i = 0;
            }
            if (i2 == 0) {
                i2 = PopMenu.this.isLightTheme() ? R.drawable.rect_dialogx_material_menu_split_divider : R.drawable.rect_dialogx_material_menu_split_divider_night;
            }
            this.listMenu.setOverScrollMode(2);
            this.listMenu.setVerticalScrollBarEnabled(false);
            this.listMenu.setDivider(PopMenu.this.getResources().getDrawable(i2));
            this.listMenu.setDividerHeight(i);
            this.listMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    int unused = PopMenu.this.selectIndex = i;
                    if (!PopMenu.this.closing && !PopMenu.this.getOnMenuItemClickListener().onClick(PopMenu.this.me, PopMenu.this.menuList.get(i), i)) {
                        PopMenu.this.dismiss();
                    }
                }
            });
            PopMenu.this.onDialogInit();
        }

        public void refreshView() {
            if (this.boxRoot != null && PopMenu.this.getOwnActivity() != null) {
                this.boxRoot.setRootPadding(PopMenu.this.screenPaddings[0], PopMenu.this.screenPaddings[1], PopMenu.this.screenPaddings[2], PopMenu.this.screenPaddings[3]);
                if (this.listMenu.getAdapter() == null) {
                    this.listMenu.setAdapter(PopMenu.this.menuListAdapter);
                } else if (PopMenu.this.menuListAdapter.getMenuList() != PopMenu.this.menuList) {
                    PopMenu.this.menuListAdapter = new PopMenuArrayAdapter(PopMenu.this.me, PopMenu.this.getOwnActivity(), PopMenu.this.menuList);
                    this.listMenu.setAdapter(PopMenu.this.menuListAdapter);
                } else {
                    PopMenu.this.menuListAdapter.notifyDataSetChanged();
                }
                if (!PopMenu.this.bkgInterceptTouch) {
                    this.boxRoot.setClickable(false);
                } else if (PopMenu.this.isCancelable()) {
                    this.boxRoot.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            if (PopMenu.this.onBackgroundMaskClickListener == null || !PopMenu.this.onBackgroundMaskClickListener.onClick(PopMenu.this.me, view)) {
                                DialogImpl.this.doDismiss(view);
                            }
                        }
                    });
                } else {
                    this.boxRoot.setOnClickListener((View.OnClickListener) null);
                }
                if (PopMenu.this.backgroundRadius > -1.0f) {
                    GradientDrawable gradientDrawable = (GradientDrawable) this.boxBody.getBackground();
                    if (gradientDrawable != null) {
                        gradientDrawable.setCornerRadius(PopMenu.this.backgroundRadius);
                    }
                    this.boxBody.setOutlineProvider(new ViewOutlineProvider() {
                        public void getOutline(View view, Outline outline) {
                            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), PopMenu.this.backgroundRadius);
                        }
                    });
                    this.boxBody.setClipToOutline(true);
                    List<View> list = this.blurViews;
                    if (list != null) {
                        Iterator<View> it = list.iterator();
                        while (it.hasNext()) {
                            ((BlurViewType) it.next()).setRadiusPx(Float.valueOf(PopMenu.this.backgroundRadius));
                        }
                    }
                }
                if (PopMenu.this.onBindView == null || PopMenu.this.onBindView.getCustomView() == null) {
                    this.boxCustom.setVisibility(8);
                } else {
                    PopMenu.this.onBindView.bindParent(this.boxCustom, PopMenu.this.me);
                    this.boxCustom.setVisibility(0);
                }
                if (PopMenu.this.width != -1) {
                    this.boxBody.setMaxWidth(PopMenu.this.width);
                    this.boxBody.setMinimumWidth(PopMenu.this.width);
                }
                if (PopMenu.this.height != -1) {
                    this.boxBody.setMaxHeight(PopMenu.this.height);
                    this.boxBody.setMinimumHeight(PopMenu.this.height);
                }
                if (PopMenu.this.backgroundColor != null) {
                    PopMenu popMenu = PopMenu.this;
                    popMenu.tintColor(this.boxBody, popMenu.backgroundColor.intValue());
                    List<View> list2 = this.blurViews;
                    if (list2 != null) {
                        Iterator<View> it2 = list2.iterator();
                        while (it2.hasNext()) {
                            ((BlurViewType) it2.next()).setOverlayColor(PopMenu.this.backgroundColor);
                        }
                    }
                }
                PopMenu.this.onDialogRefreshUI();
            }
        }

        public void doDismiss(View view) {
            if (view != null) {
                view.setEnabled(false);
            }
            if (!PopMenu.this.dismissAnimFlag && this.boxRoot != null) {
                boolean unused = PopMenu.this.dismissAnimFlag = true;
                this.boxRoot.post(new Runnable() {
                    public void run() {
                        DialogImpl.this.getDialogXAnimImpl().doExitAnim(PopMenu.this.me, DialogImpl.this.boxBody);
                        PopMenu.runOnMainDelay(new Runnable() {
                            public void run() {
                                if (PopMenu.this.baseViewDrawListener != null) {
                                    if (PopMenu.this.viewTreeObserver != null) {
                                        PopMenu.this.removeDrawListener(PopMenu.this.viewTreeObserver, PopMenu.this.baseViewDrawListener);
                                    } else if (PopMenu.this.baseView() != null) {
                                        PopMenu.this.removeDrawListener(PopMenu.this.baseView().getViewTreeObserver(), PopMenu.this.baseViewDrawListener);
                                    }
                                    ViewTreeObserver.OnDrawListener unused = PopMenu.this.baseViewDrawListener = null;
                                    ViewTreeObserver unused2 = PopMenu.this.viewTreeObserver = null;
                                }
                                PopMenu.dismiss(PopMenu.this.getDialogView());
                            }
                        }, DialogImpl.this.getExitAnimationDuration((Animation) null));
                    }
                });
            }
        }

        /* access modifiers changed from: protected */
        public DialogXAnimInterface<PopMenu> getDialogXAnimImpl() {
            if (PopMenu.this.dialogXAnimImpl == null) {
                PopMenu.this.dialogXAnimImpl = new DialogXAnimInterface<PopMenu>() {
                    int selectMenuIndex = -1;

                    public void doShowAnim(PopMenu popMenu, ViewGroup viewGroup) {
                        long enterAnimationDuration = DialogImpl.this.getEnterAnimationDuration((Animation) null);
                        int i = -1;
                        if (PopMenu.this.baseView() != null) {
                            final int access$4100 = PopMenu.this.getBodyRealHeight();
                            DialogImpl.this.boxBody.getLayoutParams().height = 1;
                            if (PopMenu.this.overlayBaseView && !DialogImpl.this.listMenu.isCanScroll()) {
                                if (PopMenu.this.baseView() instanceof TextView) {
                                    String obj = ((TextView) PopMenu.this.baseView()).getText().toString();
                                    Iterator<CharSequence> it = PopMenu.this.menuList.iterator();
                                    while (true) {
                                        if (!it.hasNext()) {
                                            break;
                                        }
                                        CharSequence next = it.next();
                                        if (TextUtils.equals(next.toString(), obj)) {
                                            this.selectMenuIndex = PopMenu.this.menuList.indexOf(next);
                                            break;
                                        }
                                    }
                                }
                                if (this.selectMenuIndex != -1) {
                                    int[] iArr = new int[2];
                                    if (DialogImpl.this.listMenu.getChildAt(this.selectMenuIndex) != null) {
                                        int measuredHeight = DialogImpl.this.listMenu.getChildAt(this.selectMenuIndex).getMeasuredHeight();
                                        DialogImpl.this.listMenu.getChildAt(this.selectMenuIndex).getLocationInWindow(iArr);
                                        PopMenu.this.selectItemYDeviation = (int) (((((float) PopMenu.this.baseView().getMeasuredHeight()) / 2.0f) - (((float) iArr[1]) - DialogImpl.this.boxBody.getY())) - (((float) measuredHeight) / 2.0f));
                                    }
                                }
                            }
                            PopMenu.this.refreshMenuLoc();
                            PopMenu.this.selectItemYDeviation = (int) (PopMenu.this.getMenuLoc().getY() - PopMenu.this.baseViewLoc.getY());
                            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                            ofFloat.setInterpolator(new DecelerateInterpolator());
                            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                    int i;
                                    if (PopMenu.this.isShow && PopMenu.this.getDialogImpl() != null && PopMenu.this.getDialogImpl().boxBody != null) {
                                        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                        int i2 = (floatValue > 1.0f ? 1 : (floatValue == 1.0f ? 0 : -1));
                                        PopMenu.this.isEnterAnimRunning = i2 != 0;
                                        DialogXViewLoc menuLoc = PopMenu.this.getMenuLoc();
                                        if (i2 == 0) {
                                            i = -2;
                                        } else {
                                            i = (int) (((float) access$4100) * floatValue);
                                        }
                                        DialogImpl.this.boxBody.getLayoutParams().height = i;
                                        DialogImpl.this.boxBody.getLayoutParams().width = PopMenu.this.getWidth() == -1 ? PopMenu.this.baseView().getWidth() : PopMenu.this.getWidth();
                                        float f = (float) i;
                                        if (DialogImpl.this.boxBody.getY() + f > DialogImpl.this.boxRoot.getSafeHeight()) {
                                            DialogImpl.this.boxBody.setY(DialogImpl.this.boxRoot.getSafeHeight() - f);
                                        }
                                        if (menuLoc.getX() == -1.0f) {
                                            menuLoc = PopMenu.this.baseViewLoc;
                                        }
                                        float x = menuLoc.getX();
                                        float y = PopMenu.this.baseViewLoc.getY() + (((float) PopMenu.this.selectItemYDeviation) * floatValue);
                                        if (!PopMenu.this.offScreen) {
                                            if (x < 0.0f) {
                                                x = 0.0f;
                                            }
                                            if (y < 0.0f) {
                                                y = 0.0f;
                                            }
                                            if (((float) DialogImpl.this.boxBody.getWidth()) + x > ((float) DialogImpl.this.boxRoot.getUseAreaWidth())) {
                                                x = (float) (DialogImpl.this.boxRoot.getUseAreaWidth() - DialogImpl.this.boxBody.getWidth());
                                            }
                                            if (((float) DialogImpl.this.boxBody.getHeight()) + y > ((float) DialogImpl.this.boxRoot.getUseAreaHeight())) {
                                                y = (float) (DialogImpl.this.boxRoot.getUseAreaHeight() - DialogImpl.this.boxBody.getHeight());
                                            }
                                        }
                                        DialogImpl.this.boxBody.setX(x);
                                        DialogImpl.this.boxBody.setY(y);
                                        DialogImpl.this.boxBody.requestLayout();
                                        if (DialogImpl.this.boxBody.getVisibility() != 0) {
                                            DialogImpl.this.boxBody.setVisibility(0);
                                        }
                                        if (DialogImpl.this.isUseBlurBackground()) {
                                            DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                        }
                                    }
                                }
                            });
                            ofFloat.setInterpolator(new DecelerateInterpolator(2.0f));
                            ofFloat.setDuration(enterAnimationDuration);
                            ofFloat.start();
                            return;
                        }
                        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) DialogImpl.this.boxBody.getLayoutParams();
                        layoutParams.addRule(13);
                        if (PopMenu.this.getWidth() != -1) {
                            i = PopMenu.this.getWidth();
                        }
                        layoutParams.width = i;
                        layoutParams.leftMargin = PopMenu.this.dip2px(50.0f);
                        layoutParams.rightMargin = PopMenu.this.dip2px(50.0f);
                        DialogImpl.this.boxBody.setLayoutParams(layoutParams);
                        DialogImpl.this.boxBody.setAlpha(0.0f);
                        if (!DialogImpl.this.isUseBlurBackground()) {
                            DialogImpl.this.boxBody.setElevation((float) PopMenu.this.dip2px(20.0f));
                        }
                        DialogImpl.this.boxBody.setVisibility(0);
                        DialogImpl.this.boxBody.animate().alpha(1.0f).setDuration(enterAnimationDuration);
                        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
                        ofFloat2.setDuration(enterAnimationDuration);
                        ofFloat2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            }
                        });
                        ofFloat2.start();
                    }

                    public void doExitAnim(PopMenu popMenu, ViewGroup viewGroup) {
                        Animation loadAnimation = AnimationUtils.loadAnimation(PopMenu.this.getOwnActivity() == null ? DialogImpl.this.boxRoot.getContext() : PopMenu.this.getOwnActivity(), R.anim.anim_dialogx_default_exit);
                        long exitAnimationDuration = DialogImpl.this.getExitAnimationDuration(loadAnimation);
                        loadAnimation.setDuration(exitAnimationDuration);
                        DialogImpl.this.boxBody.startAnimation(loadAnimation);
                        DialogImpl.this.boxRoot.animate().alpha(0.0f).setInterpolator(new AccelerateInterpolator()).setDuration(exitAnimationDuration);
                        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
                        ofFloat.setDuration(exitAnimationDuration);
                        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                if (DialogImpl.this.boxRoot != null && PopMenu.this.baseView() == null) {
                                    DialogImpl.this.boxRoot.setBkgAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                                }
                            }
                        });
                        ofFloat.start();
                    }
                };
            }
            return PopMenu.this.dialogXAnimImpl;
        }

        /* access modifiers changed from: private */
        public boolean isUseBlurBackground() {
            return (PopMenu.this.style.popMenuSettings() == null || PopMenu.this.style.popMenuSettings().blurBackgroundSettings() == null || !PopMenu.this.style.popMenuSettings().blurBackgroundSettings().blurBackground()) ? false : true;
        }

        public long getExitAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 150 : animation.getDuration();
            if (PopMenu.overrideExitDuration >= 0) {
                duration = PopMenu.overrideExitDuration;
            }
            return PopMenu.this.exitAnimDuration != -1 ? PopMenu.this.exitAnimDuration : duration;
        }

        public long getEnterAnimationDuration(Animation animation) {
            if (animation == null && this.boxBody.getAnimation() != null) {
                animation = this.boxBody.getAnimation();
            }
            long duration = (animation == null || animation.getDuration() == 0) ? 150 : animation.getDuration();
            if (PopMenu.overrideEnterDuration >= 0) {
                duration = PopMenu.overrideEnterDuration;
            }
            return PopMenu.this.enterAnimDuration >= 0 ? PopMenu.this.enterAnimDuration : duration;
        }
    }

    /* access modifiers changed from: private */
    public void removeDrawListener(ViewTreeObserver viewTreeObserver2, ViewTreeObserver.OnDrawListener onDrawListener) {
        if (viewTreeObserver2 != null && onDrawListener != null && viewTreeObserver2.isAlive()) {
            try {
                viewTreeObserver2.removeOnDrawListener(onDrawListener);
            } catch (Exception unused) {
            }
        }
    }

    /* access modifiers changed from: private */
    public int getBodyRealHeight() {
        if (getDialogImpl() == null) {
            return 0;
        }
        getDialogImpl().boxBody.measure(View.MeasureSpec.makeMeasureSpec(((View) getDialogImpl().boxBody.getParent()).getWidth(), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(((View) getDialogImpl().boxBody.getParent()).getHeight(), Integer.MIN_VALUE));
        return getDialogImpl().boxBody.getMeasuredHeight();
    }

    public void dismiss() {
        this.closing = true;
        runOnMain(new Runnable() {
            public void run() {
                if (PopMenu.this.dialogImpl != null) {
                    PopMenu.this.dialogImpl.doDismiss((View) null);
                }
            }
        });
    }

    public void restartDialog() {
        if (getDialogView() != null) {
            ViewTreeObserver.OnDrawListener onDrawListener = this.baseViewDrawListener;
            if (onDrawListener != null) {
                ViewTreeObserver viewTreeObserver2 = this.viewTreeObserver;
                if (viewTreeObserver2 != null) {
                    removeDrawListener(viewTreeObserver2, onDrawListener);
                } else if (baseView() != null) {
                    removeDrawListener(baseView().getViewTreeObserver(), this.baseViewDrawListener);
                }
                this.baseViewDrawListener = null;
            }
            dismiss(getDialogView());
            this.isShow = false;
        }
        if (getDialogImpl().boxCustom != null) {
            getDialogImpl().boxCustom.removeAllViews();
        }
        show();
    }

    public List<CharSequence> getMenuList() {
        return this.menuList;
    }

    public PopMenu setMenuList(List<CharSequence> list) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(list);
        refreshUI();
        return this;
    }

    public PopMenu setMenuList(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(strArr));
        refreshUI();
        return this;
    }

    public PopMenu setMenuList(CharSequence[] charSequenceArr) {
        ArrayList arrayList = new ArrayList();
        this.menuList = arrayList;
        arrayList.addAll(Arrays.asList(charSequenceArr));
        refreshUI();
        return this;
    }

    public void refreshUI() {
        if (getDialogImpl() != null) {
            runOnMain(new Runnable() {
                public void run() {
                    if (PopMenu.this.dialogImpl != null) {
                        PopMenu.this.dialogImpl.refreshView();
                    }
                }
            });
        }
    }

    public DialogImpl getDialogImpl() {
        return this.dialogImpl;
    }

    public String dialogKey() {
        return getClass().getSimpleName() + "(" + Integer.toHexString(hashCode()) + ")";
    }

    public DialogLifecycleCallback<PopMenu> getDialogLifecycleCallback() {
        DialogLifecycleCallback<PopMenu> dialogLifecycleCallback2 = this.dialogLifecycleCallback;
        return dialogLifecycleCallback2 == null ? new DialogLifecycleCallback<PopMenu>() {
        } : dialogLifecycleCallback2;
    }

    public PopMenu setDialogLifecycleCallback(DialogLifecycleCallback<PopMenu> dialogLifecycleCallback2) {
        this.dialogLifecycleCallback = dialogLifecycleCallback2;
        if (this.isShow) {
            dialogLifecycleCallback2.onShow(this.me);
        }
        return this;
    }

    public boolean isOverlayBaseView() {
        return this.overlayBaseView;
    }

    public PopMenu setOverlayBaseView(boolean z) {
        this.overlayBaseView = z;
        refreshUI();
        return this;
    }

    public OnMenuItemClickListener<PopMenu> getOnMenuItemClickListener() {
        OnMenuItemClickListener<PopMenu> onMenuItemClickListener2 = this.onMenuItemClickListener;
        return onMenuItemClickListener2 == null ? new OnMenuItemClickListener<PopMenu>() {
            public boolean onClick(PopMenu popMenu, CharSequence charSequence, int i) {
                return false;
            }
        } : onMenuItemClickListener2;
    }

    public PopMenu setOnMenuItemClickListener(OnMenuItemClickListener<PopMenu> onMenuItemClickListener2) {
        this.onMenuItemClickListener = onMenuItemClickListener2;
        return this;
    }

    public OnIconChangeCallBack<PopMenu> getOnIconChangeCallBack() {
        return this.onIconChangeCallBack;
    }

    public PopMenu setOnIconChangeCallBack(OnIconChangeCallBack<PopMenu> onIconChangeCallBack2) {
        this.onIconChangeCallBack = onIconChangeCallBack2;
        return this;
    }

    public PopMenu setCustomView(OnBindView<PopMenu> onBindView2) {
        this.onBindView = onBindView2;
        refreshUI();
        return this;
    }

    public View getCustomView() {
        OnBindView<PopMenu> onBindView2 = this.onBindView;
        if (onBindView2 == null) {
            return null;
        }
        return onBindView2.getCustomView();
    }

    public PopMenu removeCustomView() {
        this.onBindView.clean();
        refreshUI();
        return this;
    }

    public int getWidth() {
        return this.width;
    }

    public PopMenu setWidth(int i) {
        this.width = i;
        refreshUI();
        return this;
    }

    public int getHeight() {
        return this.height;
    }

    public PopMenu setHeight(int i) {
        this.height = i;
        refreshUI();
        return this;
    }

    public int getAlignGravity() {
        return this.alignGravity;
    }

    public boolean isAlignGravity(int i) {
        return (this.alignGravity & i) == i;
    }

    public PopMenu setAlignGravity(int i) {
        this.alignGravity = i;
        refreshMenuLoc();
        return this;
    }

    public PopMenu setDialogImplMode(DialogX.IMPL_MODE impl_mode) {
        this.dialogImplMode = impl_mode;
        return this;
    }

    public TextInfo getMenuTextInfo() {
        TextInfo textInfo = this.menuTextInfo;
        return textInfo == null ? DialogX.menuTextInfo : textInfo;
    }

    public PopMenu setMenuTextInfo(TextInfo textInfo) {
        this.menuTextInfo = textInfo;
        return this;
    }

    public boolean isOffScreen() {
        return this.offScreen;
    }

    public PopMenu setOffScreen(boolean z) {
        this.offScreen = z;
        return this;
    }

    public boolean isBkgInterceptTouch() {
        return this.bkgInterceptTouch;
    }

    public PopMenu setBkgInterceptTouch(boolean z) {
        this.bkgInterceptTouch = z;
        return this;
    }

    public OnBackgroundMaskClickListener<PopMenu> getOnBackgroundMaskClickListener() {
        return this.onBackgroundMaskClickListener;
    }

    public PopMenu setOnBackgroundMaskClickListener(OnBackgroundMaskClickListener<PopMenu> onBackgroundMaskClickListener2) {
        this.onBackgroundMaskClickListener = onBackgroundMaskClickListener2;
        refreshUI();
        return this;
    }

    public PopMenu setStyle(DialogXStyle dialogXStyle) {
        this.style = dialogXStyle;
        return this;
    }

    public PopMenu setTheme(DialogX.THEME theme) {
        this.theme = theme;
        return this;
    }

    public PopMenu setRadius(float f) {
        this.backgroundRadius = f;
        refreshUI();
        return this;
    }

    public float getRadius() {
        return this.backgroundRadius;
    }

    public void hide() {
        this.isHide = true;
        this.hideWithExitAnim = false;
        if (getDialogView() != null) {
            getDialogView().setVisibility(8);
        }
    }

    public void hideWithExitAnim() {
        this.hideWithExitAnim = true;
        this.isHide = true;
        if (getDialogImpl() != null) {
            getDialogImpl().getDialogXAnimImpl().doExitAnim(this.me, getDialogImpl().boxBody);
            runOnMainDelay(new Runnable() {
                public void run() {
                    if (PopMenu.this.getDialogView() != null) {
                        PopMenu.this.getDialogView().setVisibility(8);
                    }
                }
            }, getDialogImpl().getExitAnimationDuration((Animation) null));
        }
    }

    public DialogXAnimInterface<PopMenu> getDialogXAnimImpl() {
        return this.dialogXAnimImpl;
    }

    public PopMenu setDialogXAnimImpl(DialogXAnimInterface<PopMenu> dialogXAnimInterface) {
        this.dialogXAnimImpl = dialogXAnimInterface;
        return this;
    }

    public OnBackPressedListener<PopMenu> getOnBackPressedListener() {
        return this.onBackPressedListener;
    }

    public PopMenu setOnBackPressedListener(OnBackPressedListener<PopMenu> onBackPressedListener2) {
        this.onBackPressedListener = onBackPressedListener2;
        return this;
    }

    public View getBaseView() {
        return baseView();
    }

    public PopMenu setBaseView(View view) {
        baseView(view);
        refreshUI();
        return this;
    }

    public PopMenu setRootPadding(int i) {
        this.screenPaddings = new int[]{i, i, i, i};
        refreshUI();
        return this;
    }

    public PopMenu setRootPadding(int i, int i2, int i3, int i4) {
        this.screenPaddings = new int[]{i, i2, i3, i4};
        refreshUI();
        return this;
    }

    public int getPressedIndex() {
        return this.pressedIndex;
    }

    public PopMenu setPressedIndex(int i) {
        this.pressedIndex = i;
        refreshUI();
        return this;
    }

    public int getSelectIndex() {
        return this.selectIndex;
    }

    public CharSequence getSelectMenuText() {
        List<CharSequence> list = this.menuList;
        if (list == null) {
            return "";
        }
        return list.get(this.selectIndex);
    }

    public MenuItemLayoutRefreshCallback<PopMenu> getMenuMenuItemLayoutRefreshCallback() {
        return this.menuMenuItemLayoutRefreshCallback;
    }

    public PopMenu setMenuMenuItemLayoutRefreshCallback(MenuItemLayoutRefreshCallback<PopMenu> menuItemLayoutRefreshCallback) {
        this.menuMenuItemLayoutRefreshCallback = menuItemLayoutRefreshCallback;
        return this;
    }

    /* access modifiers changed from: protected */
    public PopMenu baseView(View view) {
        WeakReference<View> weakReference;
        if (view != null || (weakReference = this.baseViewWeakReference) == null) {
            this.baseViewWeakReference = new WeakReference<>(view);
        } else {
            weakReference.clear();
            this.baseViewWeakReference = null;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public View baseView() {
        WeakReference<View> weakReference = this.baseViewWeakReference;
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }
}
