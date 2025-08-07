package com.kongzue.dialogx.util;

import android.content.res.Resources;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.kongzue.dialogx.dialogs.BottomDialog;
import com.kongzue.dialogx.interfaces.ScrollController;

public class BottomDialogTouchEventInterceptor {
    /* access modifiers changed from: private */
    public float bkgOldY;
    /* access modifiers changed from: private */
    public float bkgTouchDownY;
    /* access modifiers changed from: private */
    public boolean isBkgTouched = false;
    private int oldMode;
    private boolean onlyRestrictingSlideTouchEventsToScrollLayoutAreas = false;
    /* access modifiers changed from: private */
    public float scrolledY;

    public BottomDialogTouchEventInterceptor(BottomDialog bottomDialog, BottomDialog.DialogImpl dialogImpl) {
        refresh(bottomDialog, dialogImpl);
    }

    public void refresh(final BottomDialog bottomDialog, final BottomDialog.DialogImpl dialogImpl) {
        if (bottomDialog != null && dialogImpl != null && dialogImpl.bkg != null && dialogImpl.scrollView != null) {
            final View view = dialogImpl.bkg;
            if (bottomDialog.isAllowInterceptTouch()) {
                if (isOnlyRestrictingSlideTouchEventsToScrollLayoutAreas()) {
                    dialogImpl.bkg.setOnTouchListener((View.OnTouchListener) null);
                    view = (View) dialogImpl.scrollView;
                }
                view.setOnTouchListener(new View.OnTouchListener() {
                    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0029, code lost:
                        if (r8 != 3) goto L_0x01da;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
                        /*
                            r7 = this;
                            com.kongzue.dialogx.dialogs.BottomDialog r0 = r4
                            com.kongzue.dialogx.interfaces.DialogLifecycleCallback r0 = r0.getDialogLifecycleCallback()
                            boolean r0 = r0 instanceof com.kongzue.dialogx.interfaces.BottomDialogSlideEventLifecycleCallback
                            r1 = 1
                            if (r0 == 0) goto L_0x001c
                            com.kongzue.dialogx.dialogs.BottomDialog r0 = r4
                            com.kongzue.dialogx.interfaces.DialogLifecycleCallback r0 = r0.getDialogLifecycleCallback()
                            com.kongzue.dialogx.interfaces.BottomDialogSlideEventLifecycleCallback r0 = (com.kongzue.dialogx.interfaces.BottomDialogSlideEventLifecycleCallback) r0
                            com.kongzue.dialogx.dialogs.BottomDialog r2 = r4
                            boolean r8 = r0.onSlideTouchEvent(r2, r8, r9)
                            if (r8 == 0) goto L_0x001c
                            return r1
                        L_0x001c:
                            int r8 = r9.getAction()
                            r0 = 0
                            if (r8 == 0) goto L_0x01bf
                            r2 = 2
                            if (r8 == r1) goto L_0x00e3
                            if (r8 == r2) goto L_0x002d
                            r9 = 3
                            if (r8 == r9) goto L_0x00e3
                            goto L_0x01da
                        L_0x002d:
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            boolean r8 = r8.isBkgTouched
                            if (r8 == 0) goto L_0x01da
                            com.kongzue.dialogx.dialogs.BottomDialog r8 = r4
                            boolean r8 = r8.isAllowInterceptTouch()
                            if (r8 == 0) goto L_0x01da
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            float r8 = r8.getY()
                            float r2 = r9.getY()
                            float r8 = r8 + r2
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r2 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r2 = r2.bkgTouchDownY
                            float r8 = r8 - r2
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r2 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r2 = r2.scrollView
                            boolean r2 = r2.isCanScroll()
                            if (r2 == 0) goto L_0x00b8
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r2 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            android.view.View r3 = r0
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r4 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r4 = r4.scrollView
                            boolean r2 = r2.touchInScrollView(r3, r4, r9)
                            if (r2 == 0) goto L_0x00b8
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r2 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r2 = r2.boxRoot
                            android.graphics.Rect r2 = r2.getUnsafePlace()
                            int r2 = r2.top
                            float r2 = (float) r2
                            int r2 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
                            if (r2 <= 0) goto L_0x009d
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r2 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r2 = r2.scrollView
                            int r2 = r2.getScrollDistance()
                            if (r2 != 0) goto L_0x0092
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r9 = r9.scrollView
                            r9.lockScroll(r1)
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            android.widget.RelativeLayout r9 = r9.boxBkg
                            r9.setY(r8)
                            goto L_0x01da
                        L_0x0092:
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r9 = r9.getY()
                            float unused = r8.bkgTouchDownY = r9
                            goto L_0x01da
                        L_0x009d:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            r8.lockScroll(r0)
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r9 = r9.boxRoot
                            android.graphics.Rect r9 = r9.getUnsafePlace()
                            int r9 = r9.top
                            float r9 = (float) r9
                            r8.setY(r9)
                            goto L_0x01da
                        L_0x00b8:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r9 = r9.boxRoot
                            android.graphics.Rect r9 = r9.getUnsafePlace()
                            int r9 = r9.top
                            float r9 = (float) r9
                            int r9 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                            if (r9 <= 0) goto L_0x00cf
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            android.widget.RelativeLayout r9 = r9.boxBkg
                            r9.setY(r8)
                            return r1
                        L_0x00cf:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r9 = r9.boxRoot
                            android.graphics.Rect r9 = r9.getUnsafePlace()
                            int r9 = r9.top
                            float r9 = (float) r9
                            r8.setY(r9)
                            goto L_0x01da
                        L_0x00e3:
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.interfaces.ScrollController r9 = r9.scrollView
                            int r9 = r9.getScrollDistance()
                            float r9 = (float) r9
                            float unused = r8.scrolledY = r9
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            boolean unused = r8.isBkgTouched = r0
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r8 = r8.bkgOldY
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r9 = r9.boxRoot
                            android.graphics.Rect r9 = r9.getUnsafePlace()
                            int r9 = r9.top
                            float r9 = (float) r9
                            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                            r3 = 300(0x12c, double:1.48E-321)
                            java.lang.String r9 = "y"
                            if (r8 != 0) goto L_0x0169
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r5 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r5 = r5.boxRoot
                            android.graphics.Rect r5 = r5.getUnsafePlace()
                            int r5 = r5.top
                            float r5 = (float) r5
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r6 = r5
                            float r6 = r6.bkgEnterAimY
                            float r5 = r5 + r6
                            int r6 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r6 = (float) r6
                            float r5 = r5 + r6
                            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                            if (r8 <= 0) goto L_0x0136
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            r8.preDismiss()
                            goto L_0x01da
                        L_0x0136:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r5 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r5 = r5.bkgOldY
                            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                            if (r8 == 0) goto L_0x01da
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r5 = r5
                            android.widget.RelativeLayout r5 = r5.boxBkg
                            float r5 = r5.getY()
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r6 = r5
                            float r6 = r6.bkgEnterAimY
                            float[] r2 = new float[r2]
                            r2[r0] = r5
                            r2[r1] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r2)
                            r8.setDuration(r3)
                            r8.start()
                            goto L_0x01da
                        L_0x0169:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r5 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r5 = r5.bkgOldY
                            int r6 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r6 = (float) r6
                            float r5 = r5 + r6
                            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                            if (r8 <= 0) goto L_0x0185
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            r8.preDismiss()
                            goto L_0x01da
                        L_0x0185:
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r5 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r5 = r5.bkgOldY
                            int r8 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                            if (r8 == 0) goto L_0x01da
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r8 = r5
                            android.widget.RelativeLayout r8 = r8.boxBkg
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r5 = r5
                            android.widget.RelativeLayout r5 = r5.boxBkg
                            float r5 = r5.getY()
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r6 = r5
                            com.kongzue.dialogx.util.views.DialogXBaseRelativeLayout r6 = r6.boxRoot
                            android.graphics.Rect r6 = r6.getUnsafePlace()
                            int r6 = r6.top
                            float r6 = (float) r6
                            float[] r2 = new float[r2]
                            r2[r0] = r5
                            r2[r1] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r2)
                            r8.setDuration(r3)
                            r8.start()
                            goto L_0x01da
                        L_0x01bf:
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            float r9 = r9.getY()
                            float unused = r8.bkgTouchDownY = r9
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            boolean unused = r8.isBkgTouched = r1
                            com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.this
                            com.kongzue.dialogx.dialogs.BottomDialog$DialogImpl r9 = r5
                            android.widget.RelativeLayout r9 = r9.boxBkg
                            float r9 = r9.getY()
                            float unused = r8.bkgOldY = r9
                        L_0x01da:
                            return r0
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.util.BottomDialogTouchEventInterceptor.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
                    }
                });
                return;
            }
            if (dialogImpl.scrollView instanceof ScrollController) {
                dialogImpl.scrollView.lockScroll(false);
            }
            view.setOnTouchListener((View.OnTouchListener) null);
        }
    }

    /* access modifiers changed from: private */
    public boolean touchInScrollView(View view, ScrollController scrollController, MotionEvent motionEvent) {
        View view2 = (View) scrollController;
        RectF rectF = new RectF();
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        view2.getLocationInWindow(iArr);
        view.getLocationInWindow(iArr2);
        rectF.left = (float) (iArr[0] - iArr2[0]);
        rectF.top = (float) (iArr[1] - iArr2[1]);
        rectF.right = rectF.left + ((float) view2.getWidth());
        rectF.bottom = rectF.top + ((float) view2.getHeight());
        if (motionEvent.getX() < rectF.left || motionEvent.getX() > rectF.right || motionEvent.getY() < rectF.top || motionEvent.getY() > rectF.bottom) {
            return false;
        }
        return true;
    }

    private int dip2px(float f) {
        return (int) ((f * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public boolean isOnlyRestrictingSlideTouchEventsToScrollLayoutAreas() {
        return this.onlyRestrictingSlideTouchEventsToScrollLayoutAreas;
    }

    public BottomDialogTouchEventInterceptor setOnlyRestrictingSlideTouchEventsToScrollLayoutAreas(boolean z) {
        this.onlyRestrictingSlideTouchEventsToScrollLayoutAreas = z;
        return this;
    }
}
