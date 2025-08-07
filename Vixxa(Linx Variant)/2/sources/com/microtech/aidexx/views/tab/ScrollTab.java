package com.microtech.aidexx.views.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.DensityUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003:\u0001WB%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\tH\u0002J\u0010\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\tH\u0002J\u0010\u00107\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u001a\u00108\u001a\u0002032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u0010\u00109\u001a\u0002032\u0006\u00104\u001a\u00020\tH\u0002J\u0010\u0010:\u001a\u0002032\u0006\u0010;\u001a\u00020-H\u0016J\u0010\u0010<\u001a\u0002032\u0006\u0010=\u001a\u00020>H\u0014J\u0018\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\t2\u0006\u0010A\u001a\u00020\tH\u0014J\u0010\u0010B\u001a\u0002032\u0006\u0010C\u001a\u00020\tH\u0016J \u0010D\u001a\u0002032\u0006\u00104\u001a\u00020\t2\u0006\u0010E\u001a\u00020\u00152\u0006\u0010F\u001a\u00020\tH\u0016J\u0010\u0010G\u001a\u0002032\u0006\u00104\u001a\u00020\tH\u0016J\b\u0010H\u001a\u000203H\u0002J\u000e\u0010I\u001a\u0002032\u0006\u0010J\u001a\u00020\tJ\u001e\u0010K\u001a\u0002032\u0006\u00104\u001a\u00020\t2\u0006\u0010L\u001a\u00020+2\u0006\u0010M\u001a\u00020\tJ\u0010\u0010N\u001a\u0002032\b\u0010O\u001a\u0004\u0018\u00010\"J\u000e\u0010P\u001a\u0002032\u0006\u0010Q\u001a\u00020\u001bJ\u0018\u0010R\u001a\u0002032\u0010\u0010S\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010+\u0018\u00010TJ\u000e\u0010U\u001a\u0002032\u0006\u0010V\u001a\u000200R\u000e\u0010\u000b\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020\u001f\u0018\u0001` X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\"\u0010,\u001a\u0016\u0012\u0004\u0012\u00020-\u0018\u00010\u001ej\n\u0012\u0004\u0012\u00020-\u0018\u0001` X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u000100X\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006X"}, d2 = {"Lcom/microtech/aidexx/views/tab/ScrollTab;", "Landroid/widget/HorizontalScrollView;", "Landroid/view/View$OnClickListener;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TYPE_INDICATOR_NONE", "TYPE_INDICATOR_TRANSLATION", "TYPE_INDICATOR_TREND", "TYPE_VIEW", "TYPE_VIEW_GROUP", "mContext", "mCount", "mHeight", "mIndicatorColor", "mIndicatorPadding", "", "mIndicatorRadius", "mIndicatorType", "mIndicatorWeight", "mIndicatorWidth", "mIsAvag", "", "mIsFirst", "mItems", "Ljava/util/ArrayList;", "Lcom/microtech/aidexx/views/tab/TabItem;", "Lkotlin/collections/ArrayList;", "mListener", "Lcom/microtech/aidexx/views/tab/ScrollTab$OnTabListener;", "mPadding", "mPaint", "Landroid/graphics/Paint;", "mPosition", "mPositionOffset", "mRectF", "Landroid/graphics/RectF;", "mStrTitles", "", "mTabs", "Landroid/view/View;", "mType", "mViewPager", "Landroidx/viewpager/widget/ViewPager;", "mWidth", "adjustScrollY", "", "position", "getTabView", "i", "init", "initTypedArray", "onChange", "onClick", "v", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onPageScrollStateChanged", "state", "onPageScrolled", "positionOffset", "positionOffsetPixels", "onPageSelected", "resetTab", "setCurrentIndex", "index", "setNumber", "text", "visibility", "setOnTabListener", "l", "setPubStabAvag", "isAvag", "setTitles", "ts", "", "setViewPager", "viewPager", "OnTabListener", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ScrollTab.kt */
public final class ScrollTab extends HorizontalScrollView implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private final int TYPE_INDICATOR_NONE;
    private final int TYPE_INDICATOR_TRANSLATION;
    private final int TYPE_INDICATOR_TREND;
    private final int TYPE_VIEW;
    private final int TYPE_VIEW_GROUP;
    private Context mContext;
    private int mCount;
    private int mHeight;
    private int mIndicatorColor;
    private float mIndicatorPadding;
    private float mIndicatorRadius;
    private int mIndicatorType;
    private float mIndicatorWeight;
    private float mIndicatorWidth;
    private boolean mIsAvag;
    private boolean mIsFirst;
    private ArrayList<TabItem> mItems;
    private OnTabListener mListener;
    private float mPadding;
    private Paint mPaint;
    private int mPosition;
    private float mPositionOffset;
    private RectF mRectF;
    private String mStrTitles;
    private ArrayList<View> mTabs;
    private int mType;
    private ViewPager mViewPager;
    private int mWidth;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/views/tab/ScrollTab$OnTabListener;", "", "onChange", "", "position", "", "v", "Landroid/view/View;", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ScrollTab.kt */
    public interface OnTabListener {
        boolean onChange(int i, View view);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void onPageScrollStateChanged(int i) {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScrollTab(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollTab(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.TYPE_VIEW_GROUP = 1;
        this.TYPE_INDICATOR_TRANSLATION = 1;
        this.TYPE_INDICATOR_NONE = 2;
        this.mIsFirst = true;
        initTypedArray(context, attributeSet);
        init(context);
    }

    private final void initTypedArray(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.lib_pub_ScrollTab);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(...)");
        this.mType = obtainStyledAttributes.getInt(R.styleable.lib_pub_ScrollTab_lib_pub_stab_type, this.TYPE_VIEW);
        this.mIsAvag = obtainStyledAttributes.getBoolean(R.styleable.lib_pub_ScrollTab_lib_pub_stab_avag, false);
        this.mPadding = obtainStyledAttributes.getDimension(R.styleable.lib_pub_ScrollTab_lib_pub_stab_padding, (float) DensityUtils.dp2px(12.0f));
        this.mStrTitles = obtainStyledAttributes.getString(R.styleable.lib_pub_ScrollTab_lib_pub_stab_titles);
        this.mIndicatorType = obtainStyledAttributes.getInt(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorType, this.TYPE_INDICATOR_TREND);
        this.mIndicatorColor = obtainStyledAttributes.getColor(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorColor, ContextCompat.getColor(context, R.color.lib_pub_color_main));
        this.mIndicatorWidth = obtainStyledAttributes.getDimension(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorWidth, (float) DensityUtils.dp2px(30.0f));
        this.mIndicatorWeight = obtainStyledAttributes.getDimension(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorWeight, (float) DensityUtils.dp2px(1.0f));
        this.mIndicatorRadius = obtainStyledAttributes.getDimension(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorRadius, (float) DensityUtils.dp2px(0.5f));
        this.mIndicatorPadding = obtainStyledAttributes.getDimension(R.styleable.lib_pub_ScrollTab_lib_pub_stab_indicatorPadding, (float) DensityUtils.dp2px(5.0f));
        obtainStyledAttributes.recycle();
    }

    private final void init(Context context) {
        List list;
        this.mContext = context;
        setWillNotDraw(false);
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(2);
        setFillViewport(this.mIsAvag);
        this.mRectF = new RectF();
        Paint paint = new Paint(1);
        this.mPaint = paint;
        Intrinsics.checkNotNull(paint);
        paint.setColor(this.mIndicatorColor);
        this.mTabs = new ArrayList<>();
        this.mItems = new ArrayList<>();
        if (!TextUtils.isEmpty(this.mStrTitles)) {
            String str = this.mStrTitles;
            Intrinsics.checkNotNull(str);
            List<String> split = new Regex(";").split(str, 0);
            if (!split.isEmpty()) {
                ListIterator<String> listIterator = split.listIterator(split.size());
                while (true) {
                    if (listIterator.hasPrevious()) {
                        if (listIterator.previous().length() != 0) {
                            list = CollectionsKt.take(split, listIterator.nextIndex() + 1);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            list = CollectionsKt.emptyList();
            for (String tabItem : (String[]) list.toArray(new String[0])) {
                ArrayList<TabItem> arrayList = this.mItems;
                Intrinsics.checkNotNull(arrayList);
                arrayList.add(new TabItem(tabItem, ""));
            }
        }
    }

    public final void setTitles(List<String> list) {
        ArrayList<TabItem> arrayList = this.mItems;
        if (arrayList != null && list != null) {
            Intrinsics.checkNotNull(arrayList);
            arrayList.clear();
            for (String tabItem : list) {
                ArrayList<TabItem> arrayList2 = this.mItems;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.add(new TabItem(tabItem, ""));
            }
            resetTab();
            invalidate();
            requestLayout();
        }
    }

    private final void resetTab() {
        ArrayList<TabItem> arrayList = this.mItems;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (arrayList.size() > 0 && this.mWidth > 0) {
                this.mIsFirst = false;
                ArrayList<TabItem> arrayList2 = this.mItems;
                Intrinsics.checkNotNull(arrayList2);
                this.mCount = arrayList2.size();
                ArrayList<View> arrayList3 = this.mTabs;
                Intrinsics.checkNotNull(arrayList3);
                arrayList3.clear();
                removeAllViews();
                LinearLayout linearLayout = new LinearLayout(this.mContext);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.mIsAvag ? -1 : -2, -1);
                linearLayout.setOrientation(0);
                linearLayout.setLayoutParams(layoutParams);
                int i = this.mCount;
                for (int i2 = 0; i2 < i; i2++) {
                    View tabView = getTabView(i2);
                    linearLayout.addView(tabView);
                    ArrayList<View> arrayList4 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList4);
                    arrayList4.add(tabView);
                }
                addView(linearLayout);
            }
        }
    }

    private final View getTabView(int i) {
        View view;
        int i2;
        if (this.mType == this.TYPE_VIEW) {
            view = new TabTextView(this.mContext);
        } else {
            view = new TabViewGroup(this.mContext);
        }
        TabView tabView = (TabView) view;
        ArrayList<TabItem> arrayList = this.mItems;
        Intrinsics.checkNotNull(arrayList);
        tabView.setText(arrayList.get(i).title);
        ArrayList<TabItem> arrayList2 = this.mItems;
        Intrinsics.checkNotNull(arrayList2);
        String str = arrayList2.get(i).text;
        ArrayList<TabItem> arrayList3 = this.mItems;
        Intrinsics.checkNotNull(arrayList3);
        boolean z = false;
        tabView.setNumber(str, TextUtils.isEmpty(arrayList3.get(i).text) ? 8 : 0);
        if (!this.mIsAvag) {
            tabView.setPadding((int) this.mPadding);
        }
        int i3 = 1;
        if (i == this.mPosition) {
            z = true;
        }
        tabView.notifyData(z);
        if (this.mIsAvag) {
            int i4 = this.mWidth;
            int i5 = this.mCount;
            if (i5 > 0) {
                i3 = i5;
            }
            i2 = i4 / i3;
        } else {
            i2 = -2;
        }
        view.setLayoutParams(new LinearLayout.LayoutParams(i2, -1));
        view.setTag(Integer.valueOf(i));
        view.setOnClickListener(this);
        return view;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        int i2;
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.onDraw(canvas);
        if (!isInEditMode() && (i = this.mCount) > 0 && (i2 = this.mPosition) >= 0 && i2 <= i - 1) {
            int i3 = this.mIndicatorType;
            if (i3 == this.TYPE_INDICATOR_TREND) {
                ArrayList<View> arrayList = this.mTabs;
                Intrinsics.checkNotNull(arrayList);
                float left = ((float) arrayList.get(this.mPosition).getLeft()) + this.mIndicatorPadding;
                ArrayList<View> arrayList2 = this.mTabs;
                Intrinsics.checkNotNull(arrayList2);
                float right = ((float) arrayList2.get(this.mPosition).getRight()) - this.mIndicatorPadding;
                if (this.mPosition < this.mCount - 1) {
                    ArrayList<View> arrayList3 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList3);
                    float left2 = ((float) arrayList3.get(this.mPosition + 1).getLeft()) + this.mIndicatorPadding;
                    ArrayList<View> arrayList4 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList4);
                    float right2 = ((float) arrayList4.get(this.mPosition + 1).getRight()) - this.mIndicatorPadding;
                    float f = this.mPositionOffset;
                    if (((double) f) < 0.5d) {
                        right += (right2 - right) * f * ((float) 2);
                    } else {
                        left += (left2 - left) * (f - 0.5f) * ((float) 2);
                        right = right2;
                    }
                }
                RectF rectF = this.mRectF;
                Intrinsics.checkNotNull(rectF);
                int i4 = this.mHeight;
                rectF.set(left, ((float) i4) - this.mIndicatorWeight, right, (float) i4);
            } else if (i3 == this.TYPE_INDICATOR_TRANSLATION) {
                ArrayList<View> arrayList5 = this.mTabs;
                Intrinsics.checkNotNull(arrayList5);
                float left3 = (float) arrayList5.get(this.mPosition).getLeft();
                ArrayList<View> arrayList6 = this.mTabs;
                Intrinsics.checkNotNull(arrayList6);
                float f2 = (float) 2;
                float right3 = left3 + ((((float) arrayList6.get(this.mPosition).getRight()) - left3) / f2);
                if (this.mPosition < this.mCount - 1) {
                    ArrayList<View> arrayList7 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList7);
                    float left4 = (float) arrayList7.get(this.mPosition + 1).getLeft();
                    ArrayList<View> arrayList8 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList8);
                    right3 += ((left4 + ((((float) arrayList8.get(this.mPosition + 1).getRight()) - left4) / f2)) - right3) * this.mPositionOffset;
                }
                float f3 = this.mIndicatorWidth;
                float f4 = right3 - (f3 / f2);
                float f5 = right3 + (f3 / f2);
                RectF rectF2 = this.mRectF;
                Intrinsics.checkNotNull(rectF2);
                int i5 = this.mHeight;
                rectF2.set(f4, ((float) i5) - this.mIndicatorWeight, f5, (float) i5);
            } else {
                ArrayList<View> arrayList9 = this.mTabs;
                Intrinsics.checkNotNull(arrayList9);
                float left5 = (float) arrayList9.get(this.mPosition).getLeft();
                ArrayList<View> arrayList10 = this.mTabs;
                Intrinsics.checkNotNull(arrayList10);
                float f6 = (float) 2;
                float right4 = left5 + ((((float) arrayList10.get(this.mPosition).getRight()) - left5) / f6);
                float f7 = this.mIndicatorWidth;
                float f8 = right4 - (f7 / f6);
                float f9 = right4 + (f7 / f6);
                RectF rectF3 = this.mRectF;
                Intrinsics.checkNotNull(rectF3);
                int i6 = this.mHeight;
                rectF3.set(f8, ((float) i6) - this.mIndicatorWeight, f9, (float) i6);
            }
            RectF rectF4 = this.mRectF;
            Intrinsics.checkNotNull(rectF4);
            float f10 = this.mIndicatorRadius;
            Paint paint = this.mPaint;
            Intrinsics.checkNotNull(paint);
            canvas.drawRoundRect(rectF4, f10, f10, paint);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (this.mIsFirst) {
            resetTab();
        }
        super.onMeasure(i, i2);
    }

    public void onClick(View view) {
        Intrinsics.checkNotNullParameter(view, "v");
        Object tag = view.getTag();
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) tag).intValue();
        OnTabListener onTabListener = this.mListener;
        if (onTabListener != null) {
            Intrinsics.checkNotNull(onTabListener);
            if (!onTabListener.onChange(intValue, view)) {
                return;
            }
        }
        setCurrentIndex(intValue);
    }

    public final void setCurrentIndex(int i) {
        if (this.mViewPager == null) {
            this.mPosition = i;
            this.mPositionOffset = 0.0f;
            onChange(i);
            adjustScrollY(i);
            invalidate();
        }
    }

    private final void onChange(int i) {
        int i2 = this.mCount;
        int i3 = 0;
        while (i3 < i2) {
            ArrayList<View> arrayList = this.mTabs;
            Intrinsics.checkNotNull(arrayList);
            View view = arrayList.get(i3);
            Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.microtech.aidexx.views.tab.TabView");
            ((TabView) view).notifyData(i3 == i);
            i3++;
        }
    }

    public final void setViewPager(ViewPager viewPager) {
        Intrinsics.checkNotNullParameter(viewPager, "viewPager");
        this.mViewPager = viewPager;
        viewPager.addOnPageChangeListener(this);
    }

    public final void setNumber(int i, String str, int i2) {
        Intrinsics.checkNotNullParameter(str, "text");
        if (i >= 0) {
            ArrayList<TabItem> arrayList = this.mItems;
            Intrinsics.checkNotNull(arrayList);
            if (i <= arrayList.size() - 1) {
                ArrayList<TabItem> arrayList2 = this.mItems;
                Intrinsics.checkNotNull(arrayList2);
                arrayList2.get(i).text = str;
                if (i >= 0 && i <= this.mCount - 1) {
                    ArrayList<View> arrayList3 = this.mTabs;
                    Intrinsics.checkNotNull(arrayList3);
                    View view = arrayList3.get(i);
                    Intrinsics.checkNotNull(view, "null cannot be cast to non-null type com.microtech.aidexx.views.tab.TabView");
                    ((TabView) view).setNumber(str, i2);
                }
            }
        }
    }

    public void onPageScrolled(int i, float f, int i2) {
        if (this.mIndicatorType != this.TYPE_INDICATOR_NONE) {
            this.mPosition = i;
            this.mPositionOffset = f;
            invalidate();
        }
    }

    public void onPageSelected(int i) {
        onChange(i);
        adjustScrollY(i);
        if (this.mIndicatorType == this.TYPE_INDICATOR_NONE) {
            this.mPosition = i;
            invalidate();
        }
    }

    private final void adjustScrollY(int i) {
        Object obj;
        if (!this.mIsAvag) {
            ArrayList<View> arrayList = this.mTabs;
            Intrinsics.checkNotNull(arrayList);
            if (i == arrayList.size() - 1) {
                ArrayList arrayList2 = this.mTabs;
                Intrinsics.checkNotNull(arrayList2);
                obj = arrayList2.get(i);
            } else {
                ArrayList arrayList3 = this.mTabs;
                Intrinsics.checkNotNull(arrayList3);
                obj = arrayList3.get(i + 1);
            }
            View view = (View) obj;
            Intrinsics.checkNotNull(view);
            int right = view.getRight() - (this.mWidth + getScrollX());
            if (right >= 0) {
                smoothScrollBy(right, 0);
                return;
            }
            ArrayList<View> arrayList4 = this.mTabs;
            Intrinsics.checkNotNull(arrayList4);
            if (i != 0) {
                i--;
            }
            View view2 = arrayList4.get(i);
            Intrinsics.checkNotNull(view2);
            int scrollX = getScrollX() - view2.getLeft();
            if (scrollX > 0) {
                smoothScrollBy(-scrollX, 0);
            }
        }
    }

    public final void setOnTabListener(OnTabListener onTabListener) {
        this.mListener = onTabListener;
    }

    public final void setPubStabAvag(boolean z) {
        this.mIsAvag = z;
    }
}
