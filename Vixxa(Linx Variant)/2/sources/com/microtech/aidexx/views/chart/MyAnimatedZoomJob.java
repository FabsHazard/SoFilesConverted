package com.microtech.aidexx.views.chart;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.view.View;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.jobs.AnimatedZoomJob;
import com.github.mikephil.charting.utils.ObjectPool;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.ViewPortHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B}\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u000b\u0012\u0006\u0010\u0010\u001a\u00020\u000b\u0012\u0006\u0010\u0011\u001a\u00020\u000b\u0012\u0006\u0010\u0012\u001a\u00020\u000b\u0012\u0006\u0010\u0013\u001a\u00020\u000b\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0002\u0010\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0014J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010 \u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0000H\u0002J\b\u0010\"\u001a\u00020\u001cH\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/microtech/aidexx/views/chart/MyAnimatedZoomJob;", "Lcom/github/mikephil/charting/jobs/AnimatedZoomJob;", "viewPortHandler", "Lcom/github/mikephil/charting/utils/ViewPortHandler;", "v", "Landroid/view/View;", "trans", "Lcom/github/mikephil/charting/utils/Transformer;", "axis", "Lcom/github/mikephil/charting/components/YAxis;", "xAxisRange", "", "scaleX", "scaleY", "xOrigin", "yOrigin", "zoomCenterX", "zoomCenterY", "zoomOriginX", "zoomOriginY", "duration", "", "(Lcom/github/mikephil/charting/utils/ViewPortHandler;Landroid/view/View;Lcom/github/mikephil/charting/utils/Transformer;Lcom/github/mikephil/charting/components/YAxis;FFFFFFFFFJ)V", "inAnimation", "", "instantiate", "Lcom/github/mikephil/charting/utils/ObjectPool$Poolable;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "onAnimationStart", "recycleInstance", "instance", "recycleSelf", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: MyAnimatedZoomJob.kt */
public final class MyAnimatedZoomJob extends AnimatedZoomJob {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int animators;
    /* access modifiers changed from: private */
    public static ObjectPool<MyAnimatedZoomJob> pool;
    private boolean inAnimation;

    public MyAnimatedZoomJob(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
        super(viewPortHandler, view, transformer, yAxis, f, f2, f3, f4, f5, f6, f7, f8, f9, j);
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0001\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u001fR\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/views/chart/MyAnimatedZoomJob$Companion;", "", "()V", "<set-?>", "", "animators", "getAnimators", "()I", "pool", "Lcom/github/mikephil/charting/utils/ObjectPool;", "Lcom/microtech/aidexx/views/chart/MyAnimatedZoomJob;", "getInstance", "viewPortHandler", "Lcom/github/mikephil/charting/utils/ViewPortHandler;", "v", "Landroid/view/View;", "trans", "Lcom/github/mikephil/charting/utils/Transformer;", "axis", "Lcom/github/mikephil/charting/components/YAxis;", "xAxisRange", "", "scaleX", "scaleY", "xOrigin", "yOrigin", "zoomCenterX", "zoomCenterY", "zoomOriginX", "zoomOriginY", "duration", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: MyAnimatedZoomJob.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getAnimators() {
            return MyAnimatedZoomJob.animators;
        }

        public final MyAnimatedZoomJob getInstance(ViewPortHandler viewPortHandler, View view, Transformer transformer, YAxis yAxis, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, long j) {
            ObjectPool access$getPool$cp = MyAnimatedZoomJob.pool;
            ObjectAnimator objectAnimator = null;
            MyAnimatedZoomJob myAnimatedZoomJob = access$getPool$cp != null ? (MyAnimatedZoomJob) access$getPool$cp.get() : null;
            if (myAnimatedZoomJob != null) {
                ViewPortHandler viewPortHandler2 = viewPortHandler;
                myAnimatedZoomJob.mViewPortHandler = viewPortHandler;
            }
            if (myAnimatedZoomJob != null) {
                float f10 = f2;
                myAnimatedZoomJob.xValue = f2;
            }
            if (myAnimatedZoomJob != null) {
                float f11 = f3;
                myAnimatedZoomJob.yValue = f3;
            }
            if (myAnimatedZoomJob != null) {
                Transformer transformer2 = transformer;
                myAnimatedZoomJob.mTrans = transformer;
            }
            if (myAnimatedZoomJob != null) {
                View view2 = view;
                myAnimatedZoomJob.view = view;
            }
            if (myAnimatedZoomJob != null) {
                float f12 = f4;
                myAnimatedZoomJob.xOrigin = f4;
            }
            if (myAnimatedZoomJob != null) {
                float f13 = f5;
                myAnimatedZoomJob.yOrigin = f5;
            }
            if (myAnimatedZoomJob != null) {
                float f14 = f6;
                myAnimatedZoomJob.zoomCenterX = f6;
            }
            if (myAnimatedZoomJob != null) {
                float f15 = f7;
                myAnimatedZoomJob.zoomCenterY = f7;
            }
            if (myAnimatedZoomJob != null) {
                myAnimatedZoomJob.zoomOriginX = f8;
            }
            if (myAnimatedZoomJob != null) {
                myAnimatedZoomJob.zoomOriginY = f9;
            }
            if (myAnimatedZoomJob != null) {
                YAxis yAxis2 = yAxis;
                myAnimatedZoomJob.yAxis = yAxis;
            }
            if (myAnimatedZoomJob != null) {
                float f16 = f;
                myAnimatedZoomJob.xAxisRange = f;
            }
            if (myAnimatedZoomJob != null) {
                myAnimatedZoomJob.resetAnimator();
            }
            if (myAnimatedZoomJob != null) {
                objectAnimator = myAnimatedZoomJob.animator;
            }
            if (objectAnimator != null) {
                objectAnimator.setDuration(j);
            }
            return myAnimatedZoomJob;
        }
    }

    static {
        ObjectPool<MyAnimatedZoomJob> create = ObjectPool.create(8, new MyAnimatedZoomJob((ViewPortHandler) null, (View) null, (Transformer) null, (YAxis) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0));
        Intrinsics.checkNotNull(create, "null cannot be cast to non-null type com.github.mikephil.charting.utils.ObjectPool<com.microtech.aidexx.views.chart.MyAnimatedZoomJob>");
        pool = create;
    }

    public void onAnimationStart(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        if (!this.inAnimation) {
            this.inAnimation = true;
            animators++;
        }
        super.onAnimationStart(animator);
    }

    public void onAnimationEnd(Animator animator) {
        Intrinsics.checkNotNullParameter(animator, "animation");
        if (this.inAnimation) {
            this.inAnimation = false;
            animators--;
        }
        super.onAnimationEnd(animator);
    }

    private final void recycleInstance(MyAnimatedZoomJob myAnimatedZoomJob) {
        ObjectPool<MyAnimatedZoomJob> objectPool = pool;
        if (objectPool != null) {
            objectPool.recycle(myAnimatedZoomJob);
        }
    }

    public void recycleSelf() {
        recycleInstance(this);
        super.recycleSelf();
    }

    /* access modifiers changed from: protected */
    public ObjectPool.Poolable instantiate() {
        return new MyAnimatedZoomJob((ViewPortHandler) null, (View) null, (Transformer) null, (YAxis) null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0);
    }
}
