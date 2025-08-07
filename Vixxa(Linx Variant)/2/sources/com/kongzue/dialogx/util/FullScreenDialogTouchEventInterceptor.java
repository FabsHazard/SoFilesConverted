package com.kongzue.dialogx.util;

import android.content.res.Resources;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.View;
import com.kongzue.dialogx.dialogs.FullScreenDialog;
import com.kongzue.dialogx.interfaces.ScrollController;

public class FullScreenDialogTouchEventInterceptor {
    /* access modifiers changed from: private */
    public float bkgOldY;
    /* access modifiers changed from: private */
    public float bkgTouchDownY;
    /* access modifiers changed from: private */
    public boolean isBkgTouched = false;

    public FullScreenDialogTouchEventInterceptor(FullScreenDialog fullScreenDialog, FullScreenDialog.DialogImpl dialogImpl) {
        refresh(fullScreenDialog, dialogImpl);
    }

    public void refresh(final FullScreenDialog fullScreenDialog, final FullScreenDialog.DialogImpl dialogImpl) {
        if (fullScreenDialog != null && dialogImpl != null && dialogImpl.bkg != null) {
            if (fullScreenDialog.isAllowInterceptTouch()) {
                View view = dialogImpl.boxCustom;
                if (dialogImpl.scrollView != null) {
                    view = dialogImpl.bkg;
                }
                view.setOnTouchListener(new View.OnTouchListener() {
                    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
                        if (r0 != 3) goto L_0x01f4;
                     */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public boolean onTouch(android.view.View r8, android.view.MotionEvent r9) {
                        /*
                            r7 = this;
                            int r0 = r9.getAction()
                            r1 = 0
                            r2 = 1
                            if (r0 == 0) goto L_0x01d9
                            r3 = 2
                            if (r0 == r2) goto L_0x00c8
                            if (r0 == r3) goto L_0x0012
                            r8 = 3
                            if (r0 == r8) goto L_0x00c8
                            goto L_0x01f4
                        L_0x0012:
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r0 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            boolean r0 = r0.isBkgTouched
                            if (r0 == 0) goto L_0x01f4
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.bkg
                            float r0 = r0.getY()
                            float r3 = r9.getY()
                            float r0 = r0 + r3
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r3 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r3 = r3.bkgTouchDownY
                            float r0 = r0 - r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r3 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r3 = r3.scrollView
                            if (r3 == 0) goto L_0x00a7
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r3 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r3 = r3.scrollView
                            boolean r3 = r3.isCanScroll()
                            if (r3 == 0) goto L_0x00a7
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r3 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r4 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r4 = r4.scrollView
                            boolean r8 = r3.touchInScrollView(r8, r4, r9)
                            if (r8 == 0) goto L_0x00a7
                            com.kongzue.dialogx.dialogs.FullScreenDialog r8 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r8.getDialogImpl()
                            float r8 = r8.getEnterY()
                            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                            if (r8 <= 0) goto L_0x0085
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            int r8 = r8.getScrollDistance()
                            if (r8 != 0) goto L_0x007a
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            boolean r8 = r8 instanceof com.kongzue.dialogx.interfaces.ScrollController
                            if (r8 == 0) goto L_0x0071
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            r8.lockScroll(r2)
                        L_0x0071:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            r8.setY(r0)
                            goto L_0x01f4
                        L_0x007a:
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r9 = r9.getY()
                            float unused = r8.bkgTouchDownY = r9
                            goto L_0x01f4
                        L_0x0085:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            boolean r8 = r8 instanceof com.kongzue.dialogx.interfaces.ScrollController
                            if (r8 == 0) goto L_0x0094
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.interfaces.ScrollController r8 = r8.scrollView
                            r8.lockScroll(r1)
                        L_0x0094:
                            com.kongzue.dialogx.dialogs.FullScreenDialog r8 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r8.getDialogImpl()
                            float r8 = r8.getEnterY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r9 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r9 = r9.bkg
                            r9.setY(r8)
                            goto L_0x01f4
                        L_0x00a7:
                            com.kongzue.dialogx.dialogs.FullScreenDialog r8 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r8.getDialogImpl()
                            float r8 = r8.getEnterY()
                            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
                            if (r8 >= 0) goto L_0x00bf
                            com.kongzue.dialogx.dialogs.FullScreenDialog r8 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r8.getDialogImpl()
                            float r0 = r8.getEnterY()
                        L_0x00bf:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            r8.setY(r0)
                            goto L_0x01f4
                        L_0x00c8:
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            boolean unused = r8.isBkgTouched = r1
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r8 = r8.bkgOldY
                            com.kongzue.dialogx.dialogs.FullScreenDialog r9 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r9 = r9.getDialogImpl()
                            float r9 = r9.getEnterY()
                            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
                            r4 = 300(0x12c, double:1.48E-321)
                            java.lang.String r9 = "y"
                            if (r8 != 0) goto L_0x015d
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            float r8 = r8.getY()
                            int r0 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r0 = (float) r0
                            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                            if (r8 >= 0) goto L_0x011c
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.bkg
                            float r0 = r0.getY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog r6 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r6 = r6.getDialogImpl()
                            float r6 = r6.getEnterY()
                            float[] r3 = new float[r3]
                            r3[r1] = r0
                            r3[r2] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r3)
                            r8.setDuration(r4)
                            r8.start()
                            goto L_0x01f4
                        L_0x011c:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            float r0 = r0.getEnterY()
                            int r6 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r6 = (float) r6
                            float r0 = r0 + r6
                            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                            if (r8 <= 0) goto L_0x0139
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            r8.preDismiss()
                            goto L_0x01f4
                        L_0x0139:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.bkg
                            float r0 = r0.getY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r6 = r4
                            float r6 = r6.getEnterY()
                            float[] r3 = new float[r3]
                            r3[r1] = r0
                            r3[r2] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r3)
                            r8.setDuration(r4)
                            r8.start()
                            goto L_0x01f4
                        L_0x015d:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r0 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r0 = r0.bkgOldY
                            int r6 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r6 = (float) r6
                            float r0 = r0 - r6
                            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                            if (r8 >= 0) goto L_0x019a
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.bkg
                            float r0 = r0.getY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog r6 = r3
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r6 = r6.getDialogImpl()
                            float r6 = r6.getEnterY()
                            float[] r3 = new float[r3]
                            r3[r1] = r0
                            r3[r2] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r3)
                            r8.setDuration(r4)
                            r8.start()
                            goto L_0x01f4
                        L_0x019a:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            float r8 = r8.getY()
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r0 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r0 = r0.bkgOldY
                            int r6 = com.kongzue.dialogx.DialogX.touchSlideTriggerThreshold
                            float r6 = (float) r6
                            float r0 = r0 + r6
                            int r8 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
                            if (r8 <= 0) goto L_0x01b6
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            r8.preDismiss()
                            goto L_0x01f4
                        L_0x01b6:
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r8 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r8 = r8.bkg
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r0 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r0 = r0.bkg
                            float r0 = r0.getY()
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r6 = r4
                            float r6 = r6.getEnterY()
                            float[] r3 = new float[r3]
                            r3[r1] = r0
                            r3[r2] = r6
                            android.animation.ObjectAnimator r8 = android.animation.ObjectAnimator.ofFloat(r8, r9, r3)
                            r8.setDuration(r4)
                            r8.start()
                            goto L_0x01f4
                        L_0x01d9:
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            float r9 = r9.getY()
                            float unused = r8.bkgTouchDownY = r9
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            boolean unused = r8.isBkgTouched = r2
                            com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor r8 = com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.this
                            com.kongzue.dialogx.dialogs.FullScreenDialog$DialogImpl r9 = r4
                            com.kongzue.dialogx.util.views.MaxRelativeLayout r9 = r9.bkg
                            float r9 = r9.getY()
                            float unused = r8.bkgOldY = r9
                        L_0x01f4:
                            return r1
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.kongzue.dialogx.util.FullScreenDialogTouchEventInterceptor.AnonymousClass1.onTouch(android.view.View, android.view.MotionEvent):boolean");
                    }
                });
                return;
            }
            View view2 = dialogImpl.boxCustom;
            if (dialogImpl.scrollView != null) {
                view2 = dialogImpl.bkg;
            }
            if (dialogImpl.scrollView instanceof ScrollController) {
                dialogImpl.scrollView.lockScroll(false);
            }
            view2.setOnTouchListener((View.OnTouchListener) null);
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
}
