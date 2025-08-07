package com.microtech.aidexx.ui.main.history;

import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.res.ResourcesCompat;
import com.bumptech.glide.Glide;
import com.microtech.aidexx.R;
import com.microtech.aidexx.common.ExtendsKt;
import com.microtech.aidexx.data.resource.LanguageResourceManager;
import com.microtech.aidexx.db.entity.event.OthersEntity;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.adapter.BaseQuickAdapter;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import com.microtech.aidexx.views.SwipeDeleteMenuLayout;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B:\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0005\u0012#\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\u0002\u0010\fJ \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0002H\u0014J \u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010\u001c\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010\u001d\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010\u001e\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010\u001f\u001a\u00020\u0011*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010 \u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002J\u0014\u0010!\u001a\u00020\u000b*\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0002H\u0002R.\u0010\u0006\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\""}, d2 = {"Lcom/microtech/aidexx/ui/main/history/HistoryRecyclerViewAdapter;", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "Lcom/microtech/aidexx/ui/main/history/HistoryDetailModel;", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "data", "", "onDeleteClick", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "model", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "getOnDeleteClick", "()Lkotlin/jvm/functions/Function1;", "collapse", "tvDetail", "Landroid/widget/TextView;", "ivCollapse", "Landroid/widget/ImageView;", "entity", "convert", "holder", "item", "expand", "getContentLength", "", "historyDetailModel", "setCollapse", "setContent", "setDeleteUi", "setDetailUi", "setHistory", "setTimeLine", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: HistoryAdapter.kt */
public final class HistoryRecyclerViewAdapter extends BaseQuickAdapter<HistoryDetailModel, BaseViewHolder> {
    private final Function1<HistoryDetailModel, Unit> onDeleteClick;

    public final Function1<HistoryDetailModel, Unit> getOnDeleteClick() {
        return this.onDeleteClick;
    }

    public HistoryRecyclerViewAdapter(List<HistoryDetailModel> list, Function1<? super HistoryDetailModel, Unit> function1) {
        super(R.layout.item_event_history, list);
        this.onDeleteClick = function1;
    }

    /* access modifiers changed from: protected */
    public void convert(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "holder");
        Intrinsics.checkNotNullParameter(historyDetailModel, "item");
        setTimeLine(baseViewHolder, historyDetailModel);
        setHistory(baseViewHolder, historyDetailModel);
        setDetailUi(baseViewHolder, historyDetailModel);
        setContent(baseViewHolder, historyDetailModel);
        setDeleteUi(baseViewHolder, historyDetailModel);
        setCollapse(baseViewHolder, historyDetailModel);
    }

    private final TextView setDetailUi(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvDetail);
        textView.setText(historyDetailModel.getTitle());
        return textView;
    }

    private final void setHistory(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        Glide.with(getContext()).load(historyDetailModel.getResourceId()).into((ImageView) baseViewHolder.getView(R.id.ivHistory));
    }

    private final void setTimeLine(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvTimeLine);
        Long time = historyDetailModel.getTime();
        String str = null;
        if (time != null) {
            str = ExtendsKt.hourMinute$default(time.longValue(), (String) null, 1, (Object) null);
        }
        textView.setText(str);
    }

    private final void setContent(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvContent);
        Collection contentList = historyDetailModel.getContentList();
        if (contentList == null || contentList.isEmpty()) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(CollectionsKt.joinToString$default(historyDetailModel.getContentList(), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
    }

    private final void setDeleteUi(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        SwipeDeleteMenuLayout swipeDeleteMenuLayout = (SwipeDeleteMenuLayout) baseViewHolder.getView(R.id.sml_delete);
        swipeDeleteMenuLayout.setSwipeEnable(historyDetailModel.getDeletable());
        swipeDeleteMenuLayout.setLeftSwipe(!LanguageResourceManager.INSTANCE.isRTL());
        if (historyDetailModel.getDeletable()) {
            ExtendsKt.setDebounceClickListener$default((ConstraintLayout) baseViewHolder.getView(R.id.flHistoryDelete), 0, new HistoryRecyclerViewAdapter$$ExternalSyntheticLambda1(this, historyDetailModel), 1, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void setDeleteUi$lambda$1(HistoryRecyclerViewAdapter historyRecyclerViewAdapter, HistoryDetailModel historyDetailModel, View view) {
        Intrinsics.checkNotNullParameter(historyRecyclerViewAdapter, "this$0");
        Intrinsics.checkNotNullParameter(historyDetailModel, "$historyDetailModel");
        Function1<HistoryDetailModel, Unit> function1 = historyRecyclerViewAdapter.onDeleteClick;
        if (function1 != null) {
            function1.invoke(historyDetailModel);
        }
    }

    private final void setCollapse(BaseViewHolder baseViewHolder, HistoryDetailModel historyDetailModel) {
        TextView textView = (TextView) baseViewHolder.getView(R.id.tvDetail);
        ImageView imageView = (ImageView) baseViewHolder.getView(R.id.ivCollapse);
        FrameLayout frameLayout = (FrameLayout) baseViewHolder.getView(R.id.flCollapse);
        if (!Intrinsics.areEqual((Object) OthersEntity.class, (Object) historyDetailModel.getClazz()) || getContentLength(historyDetailModel) <= 55) {
            frameLayout.setVisibility(8);
            return;
        }
        frameLayout.setVisibility(0);
        collapse(textView, imageView, historyDetailModel);
        frameLayout.setOnClickListener(new HistoryRecyclerViewAdapter$$ExternalSyntheticLambda0(historyDetailModel, this, textView, imageView));
    }

    /* access modifiers changed from: private */
    public static final void setCollapse$lambda$2(HistoryDetailModel historyDetailModel, HistoryRecyclerViewAdapter historyRecyclerViewAdapter, TextView textView, ImageView imageView, View view) {
        Intrinsics.checkNotNullParameter(historyDetailModel, "$historyDetailModel");
        Intrinsics.checkNotNullParameter(historyRecyclerViewAdapter, "this$0");
        Intrinsics.checkNotNullParameter(textView, "$tvDetail");
        Intrinsics.checkNotNullParameter(imageView, "$ivCollapse");
        if (historyDetailModel.getExpand()) {
            LogUtil.Companion.d$default(LogUtil.Companion, "收缩", (String) null, 2, (Object) null);
            historyRecyclerViewAdapter.collapse(textView, imageView, historyDetailModel);
            return;
        }
        LogUtil.Companion.d$default(LogUtil.Companion, "展开", (String) null, 2, (Object) null);
        historyRecyclerViewAdapter.expand(textView, imageView, historyDetailModel);
    }

    private final int getContentLength(HistoryDetailModel historyDetailModel) {
        if (historyDetailModel.getTitle() == null) {
            return 0;
        }
        String title = historyDetailModel.getTitle();
        Intrinsics.checkNotNull(title);
        return title.length();
    }

    private final void collapse(TextView textView, ImageView imageView, HistoryDetailModel historyDetailModel) {
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(3);
        historyDetailModel.setExpand(false);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_expand, (Resources.Theme) null));
    }

    private final void expand(TextView textView, ImageView imageView, HistoryDetailModel historyDetailModel) {
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setMaxLines(500);
        historyDetailModel.setExpand(true);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_collapse, (Resources.Theme) null));
    }
}
