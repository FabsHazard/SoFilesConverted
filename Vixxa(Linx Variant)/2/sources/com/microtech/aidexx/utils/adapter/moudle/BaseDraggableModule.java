package com.microtech.aidexx.utils.adapter.moudle;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.microtech.aidexx.R;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import com.microtech.aidexx.utils.adapter.listener.DraggableListenerImp;
import com.microtech.aidexx.utils.adapter.listener.OnItemDragListener;
import com.microtech.aidexx.utils.adapter.listener.OnItemSwipeListener;
import com.microtech.aidexx.utils.adapter.swipe.DragAndSwipeCallback;
import java.util.Collections;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\b\u0016\u0018\u0000 [2\u00020\u0001:\u0001[B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0002\u0010\u0004J\u000e\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<J\u0010\u0010=\u001a\u0002042\u0006\u0010>\u001a\u00020?H\u0004J\b\u0010@\u001a\u00020\u0006H\u0016J\u0010\u0010A\u001a\u00020\u00062\u0006\u0010B\u001a\u000204H\u0002J\b\u0010C\u001a\u00020:H\u0002J\u0015\u0010D\u001a\u00020:2\u0006\u0010E\u001a\u00020FH\u0000¢\u0006\u0002\bGJ\u0010\u0010H\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0018\u0010I\u001a\u00020:2\u0006\u0010J\u001a\u00020?2\u0006\u0010K\u001a\u00020?H\u0016J\u0010\u0010L\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010M\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010N\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J\u0010\u0010O\u001a\u00020:2\u0006\u0010>\u001a\u00020?H\u0016J4\u0010P\u001a\u00020:2\b\u0010Q\u001a\u0004\u0018\u00010R2\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010S\u001a\u00020T2\u0006\u0010U\u001a\u00020T2\u0006\u0010V\u001a\u00020\u0006H\u0016J\u0012\u0010W\u001a\u00020:2\b\u0010X\u001a\u0004\u0018\u00010\u001cH\u0016J\u0012\u0010Y\u001a\u00020:2\b\u0010Z\u001a\u0004\u0018\u00010\"H\u0016R\u0016\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006@WX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0007\"\u0004\b\u000e\u0010\tR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010(X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010.X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u000204X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108¨\u0006\\"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/moudle/BaseDraggableModule;", "Lcom/microtech/aidexx/utils/adapter/listener/DraggableListenerImp;", "baseQuickAdapter", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "(Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;)V", "isDragEnabled", "", "()Z", "setDragEnabled", "(Z)V", "value", "isDragOnLongPressEnabled", "setDragOnLongPressEnabled", "isSwipeEnabled", "setSwipeEnabled", "itemTouchHelper", "Landroidx/recyclerview/widget/ItemTouchHelper;", "getItemTouchHelper", "()Landroidx/recyclerview/widget/ItemTouchHelper;", "setItemTouchHelper", "(Landroidx/recyclerview/widget/ItemTouchHelper;)V", "itemTouchHelperCallback", "Lcom/microtech/aidexx/utils/adapter/swipe/DragAndSwipeCallback;", "getItemTouchHelperCallback", "()Lcom/microtech/aidexx/utils/adapter/swipe/DragAndSwipeCallback;", "setItemTouchHelperCallback", "(Lcom/microtech/aidexx/utils/adapter/swipe/DragAndSwipeCallback;)V", "mOnItemDragListener", "Lcom/microtech/aidexx/utils/adapter/listener/OnItemDragListener;", "getMOnItemDragListener", "()Lcom/microtech/aidexx/utils/adapter/listener/OnItemDragListener;", "setMOnItemDragListener", "(Lcom/microtech/aidexx/utils/adapter/listener/OnItemDragListener;)V", "mOnItemSwipeListener", "Lcom/microtech/aidexx/utils/adapter/listener/OnItemSwipeListener;", "getMOnItemSwipeListener", "()Lcom/microtech/aidexx/utils/adapter/listener/OnItemSwipeListener;", "setMOnItemSwipeListener", "(Lcom/microtech/aidexx/utils/adapter/listener/OnItemSwipeListener;)V", "mOnToggleViewLongClickListener", "Landroid/view/View$OnLongClickListener;", "getMOnToggleViewLongClickListener", "()Landroid/view/View$OnLongClickListener;", "setMOnToggleViewLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "mOnToggleViewTouchListener", "Landroid/view/View$OnTouchListener;", "getMOnToggleViewTouchListener", "()Landroid/view/View$OnTouchListener;", "setMOnToggleViewTouchListener", "(Landroid/view/View$OnTouchListener;)V", "toggleViewId", "", "getToggleViewId", "()I", "setToggleViewId", "(I)V", "attachToRecyclerView", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getViewHolderPosition", "viewHolder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "hasToggleView", "inRange", "position", "initItemTouch", "initView", "holder", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "initView$app_gpGrxMmolRelease", "onItemDragEnd", "onItemDragMoving", "source", "target", "onItemDragStart", "onItemSwipeClear", "onItemSwipeStart", "onItemSwiped", "onItemSwiping", "canvas", "Landroid/graphics/Canvas;", "dX", "", "dY", "isCurrentlyActive", "setOnItemDragListener", "onItemDragListener", "setOnItemSwipeListener", "onItemSwipeListener", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: DraggableModule.kt */
public class BaseDraggableModule implements DraggableListenerImp {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int NO_TOGGLE_VIEW = 0;
    private final BaseQuickAdapter<?, ?> baseQuickAdapter;
    private boolean isDragEnabled;
    private boolean isDragOnLongPressEnabled = true;
    private boolean isSwipeEnabled;
    public ItemTouchHelper itemTouchHelper;
    public DragAndSwipeCallback itemTouchHelperCallback;
    private OnItemDragListener mOnItemDragListener;
    private OnItemSwipeListener mOnItemSwipeListener;
    private View.OnLongClickListener mOnToggleViewLongClickListener;
    private View.OnTouchListener mOnToggleViewTouchListener;
    private int toggleViewId;

    public BaseDraggableModule(BaseQuickAdapter<?, ?> baseQuickAdapter2) {
        Intrinsics.checkNotNullParameter(baseQuickAdapter2, "baseQuickAdapter");
        this.baseQuickAdapter = baseQuickAdapter2;
        initItemTouch();
    }

    public final boolean isDragEnabled() {
        return this.isDragEnabled;
    }

    public final void setDragEnabled(boolean z) {
        this.isDragEnabled = z;
    }

    public final boolean isSwipeEnabled() {
        return this.isSwipeEnabled;
    }

    public final void setSwipeEnabled(boolean z) {
        this.isSwipeEnabled = z;
    }

    public final int getToggleViewId() {
        return this.toggleViewId;
    }

    public final void setToggleViewId(int i) {
        this.toggleViewId = i;
    }

    public final ItemTouchHelper getItemTouchHelper() {
        ItemTouchHelper itemTouchHelper2 = this.itemTouchHelper;
        if (itemTouchHelper2 != null) {
            return itemTouchHelper2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelper");
        return null;
    }

    public final void setItemTouchHelper(ItemTouchHelper itemTouchHelper2) {
        Intrinsics.checkNotNullParameter(itemTouchHelper2, "<set-?>");
        this.itemTouchHelper = itemTouchHelper2;
    }

    public final DragAndSwipeCallback getItemTouchHelperCallback() {
        DragAndSwipeCallback dragAndSwipeCallback = this.itemTouchHelperCallback;
        if (dragAndSwipeCallback != null) {
            return dragAndSwipeCallback;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemTouchHelperCallback");
        return null;
    }

    public final void setItemTouchHelperCallback(DragAndSwipeCallback dragAndSwipeCallback) {
        Intrinsics.checkNotNullParameter(dragAndSwipeCallback, "<set-?>");
        this.itemTouchHelperCallback = dragAndSwipeCallback;
    }

    /* access modifiers changed from: protected */
    public final View.OnTouchListener getMOnToggleViewTouchListener() {
        return this.mOnToggleViewTouchListener;
    }

    /* access modifiers changed from: protected */
    public final void setMOnToggleViewTouchListener(View.OnTouchListener onTouchListener) {
        this.mOnToggleViewTouchListener = onTouchListener;
    }

    /* access modifiers changed from: protected */
    public final View.OnLongClickListener getMOnToggleViewLongClickListener() {
        return this.mOnToggleViewLongClickListener;
    }

    /* access modifiers changed from: protected */
    public final void setMOnToggleViewLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnToggleViewLongClickListener = onLongClickListener;
    }

    /* access modifiers changed from: protected */
    public final OnItemDragListener getMOnItemDragListener() {
        return this.mOnItemDragListener;
    }

    /* access modifiers changed from: protected */
    public final void setMOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    /* access modifiers changed from: protected */
    public final OnItemSwipeListener getMOnItemSwipeListener() {
        return this.mOnItemSwipeListener;
    }

    /* access modifiers changed from: protected */
    public final void setMOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    private final void initItemTouch() {
        setItemTouchHelperCallback(new DragAndSwipeCallback(this));
        setItemTouchHelper(new ItemTouchHelper(getItemTouchHelperCallback()));
    }

    public final void initView$app_gpGrxMmolRelease(BaseViewHolder baseViewHolder) {
        View findViewById;
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        if (this.isDragEnabled && hasToggleView() && (findViewById = baseViewHolder.itemView.findViewById(this.toggleViewId)) != null) {
            findViewById.setTag(R.id.BaseQuickAdapter_viewholder_support, baseViewHolder);
            if (isDragOnLongPressEnabled()) {
                findViewById.setOnLongClickListener(this.mOnToggleViewLongClickListener);
            } else {
                findViewById.setOnTouchListener(this.mOnToggleViewTouchListener);
            }
        }
    }

    public final void attachToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        getItemTouchHelper().attachToRecyclerView(recyclerView);
    }

    public boolean hasToggleView() {
        return this.toggleViewId != 0;
    }

    public boolean isDragOnLongPressEnabled() {
        return this.isDragOnLongPressEnabled;
    }

    public void setDragOnLongPressEnabled(boolean z) {
        this.isDragOnLongPressEnabled = z;
        if (z) {
            this.mOnToggleViewTouchListener = null;
            this.mOnToggleViewLongClickListener = new BaseDraggableModule$$ExternalSyntheticLambda0(this);
            return;
        }
        this.mOnToggleViewTouchListener = new BaseDraggableModule$$ExternalSyntheticLambda1(this);
        this.mOnToggleViewLongClickListener = null;
    }

    /* access modifiers changed from: private */
    public static final boolean _set_isDragOnLongPressEnabled_$lambda$0(BaseDraggableModule baseDraggableModule, View view) {
        Intrinsics.checkNotNullParameter(baseDraggableModule, "this$0");
        if (!baseDraggableModule.isDragEnabled) {
            return true;
        }
        ItemTouchHelper itemTouchHelper2 = baseDraggableModule.getItemTouchHelper();
        Object tag = view.getTag(R.id.BaseQuickAdapter_viewholder_support);
        Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
        itemTouchHelper2.startDrag((RecyclerView.ViewHolder) tag);
        return true;
    }

    /* access modifiers changed from: private */
    public static final boolean _set_isDragOnLongPressEnabled_$lambda$1(BaseDraggableModule baseDraggableModule, View view, MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(baseDraggableModule, "this$0");
        if (motionEvent.getAction() != 0 || baseDraggableModule.isDragOnLongPressEnabled()) {
            return false;
        }
        if (baseDraggableModule.isDragEnabled) {
            ItemTouchHelper itemTouchHelper2 = baseDraggableModule.getItemTouchHelper();
            Object tag = view.getTag(R.id.BaseQuickAdapter_viewholder_support);
            Intrinsics.checkNotNull(tag, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.ViewHolder");
            itemTouchHelper2.startDrag((RecyclerView.ViewHolder) tag);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public final int getViewHolderPosition(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        return viewHolder.getBindingAdapterPosition() - this.baseQuickAdapter.getHeaderLayoutCount();
    }

    public void onItemDragStart(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragStart(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemDragMoving(RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        Intrinsics.checkNotNullParameter(viewHolder, "source");
        Intrinsics.checkNotNullParameter(viewHolder2, TypedValues.AttributesType.S_TARGET);
        int viewHolderPosition = getViewHolderPosition(viewHolder);
        int viewHolderPosition2 = getViewHolderPosition(viewHolder2);
        if (inRange(viewHolderPosition) && inRange(viewHolderPosition2)) {
            if (viewHolderPosition < viewHolderPosition2) {
                int i = viewHolderPosition;
                while (i < viewHolderPosition2) {
                    int i2 = i + 1;
                    Collections.swap(this.baseQuickAdapter.getData(), i, i2);
                    i = i2;
                }
            } else {
                int i3 = viewHolderPosition2 + 1;
                if (i3 <= viewHolderPosition) {
                    int i4 = viewHolderPosition;
                    while (true) {
                        Collections.swap(this.baseQuickAdapter.getData(), i4, i4 - 1);
                        if (i4 == i3) {
                            break;
                        }
                        i4--;
                    }
                }
            }
            this.baseQuickAdapter.notifyItemMoved(viewHolder.getBindingAdapterPosition(), viewHolder2.getBindingAdapterPosition());
        }
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragMoving(viewHolder, viewHolderPosition, viewHolder2, viewHolderPosition2);
        }
    }

    public void onItemDragEnd(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        OnItemDragListener onItemDragListener = this.mOnItemDragListener;
        if (onItemDragListener != null) {
            onItemDragListener.onItemDragEnd(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.isSwipeEnabled && (onItemSwipeListener = this.mOnItemSwipeListener) != null) {
            onItemSwipeListener.onItemSwipeStart(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemSwipeClear(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        if (this.isSwipeEnabled && (onItemSwipeListener = this.mOnItemSwipeListener) != null) {
            onItemSwipeListener.clearView(viewHolder, getViewHolderPosition(viewHolder));
        }
    }

    public void onItemSwiped(RecyclerView.ViewHolder viewHolder) {
        OnItemSwipeListener onItemSwipeListener;
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        int viewHolderPosition = getViewHolderPosition(viewHolder);
        if (inRange(viewHolderPosition)) {
            this.baseQuickAdapter.getData().remove(viewHolderPosition);
            this.baseQuickAdapter.notifyItemRemoved(viewHolder.getBindingAdapterPosition());
            if (this.isSwipeEnabled && (onItemSwipeListener = this.mOnItemSwipeListener) != null) {
                onItemSwipeListener.onItemSwiped(viewHolder, viewHolderPosition);
            }
        }
    }

    public void onItemSwiping(Canvas canvas, RecyclerView.ViewHolder viewHolder, float f, float f2, boolean z) {
        OnItemSwipeListener onItemSwipeListener;
        if (this.isSwipeEnabled && (onItemSwipeListener = this.mOnItemSwipeListener) != null) {
            onItemSwipeListener.onItemSwipeMoving(canvas, viewHolder, f, f2, z);
        }
    }

    private final boolean inRange(int i) {
        return i >= 0 && i < this.baseQuickAdapter.getData().size();
    }

    public void setOnItemDragListener(OnItemDragListener onItemDragListener) {
        this.mOnItemDragListener = onItemDragListener;
    }

    public void setOnItemSwipeListener(OnItemSwipeListener onItemSwipeListener) {
        this.mOnItemSwipeListener = onItemSwipeListener;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/moudle/BaseDraggableModule$Companion;", "", "()V", "NO_TOGGLE_VIEW", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: DraggableModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
