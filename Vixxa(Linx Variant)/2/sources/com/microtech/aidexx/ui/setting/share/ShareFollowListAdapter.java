package com.microtech.aidexx.ui.setting.share;

import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.microtech.aidexx.R;
import com.microtech.aidexx.databinding.ItemShareFollowListBinding;
import com.microtech.aidexx.db.entity.UserEntity;
import com.microtech.aidexx.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0017H\u0016J\u0018\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0017H\u0016R4\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u0011\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006 "}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/microtech/aidexx/ui/setting/share/ShareFollowListAdapter$ViewHolder;", "()V", "value", "", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "data", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "onItemClickListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: ShareFollowListAdapter.kt */
public final class ShareFollowListAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<ShareUserInfo> data;
    private Function1<? super ShareUserInfo, Unit> onItemClickListener;

    public final List<ShareUserInfo> getData() {
        return this.data;
    }

    public final void setData(List<ShareUserInfo> list) {
        if (list != null) {
            if (this.data == null) {
                this.data = new ArrayList();
            }
            List<ShareUserInfo> list2 = this.data;
            Intrinsics.checkNotNull(list2);
            list2.clear();
            List<ShareUserInfo> list3 = this.data;
            Intrinsics.checkNotNull(list3);
            list3.addAll(list);
            LogUtil.Companion.d$default(LogUtil.Companion, String.valueOf(this.data), (String) null, 2, (Object) null);
        }
    }

    public final Function1<ShareUserInfo, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public final void setOnItemClickListener(Function1<? super ShareUserInfo, Unit> function1) {
        this.onItemClickListener = function1;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/microtech/aidexx/ui/setting/share/ShareFollowListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "vb", "Lcom/microtech/aidexx/databinding/ItemShareFollowListBinding;", "(Lcom/microtech/aidexx/databinding/ItemShareFollowListBinding;)V", "bind", "", "item", "Lcom/microtech/aidexx/ui/setting/share/ShareUserInfo;", "position", "", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: ShareFollowListAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final ItemShareFollowListBinding vb;

        /* access modifiers changed from: private */
        public static final void bind$lambda$1$lambda$0(View view) {
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(ItemShareFollowListBinding itemShareFollowListBinding) {
            super(itemShareFollowListBinding.getRoot());
            Intrinsics.checkNotNullParameter(itemShareFollowListBinding, "vb");
            this.vb = itemShareFollowListBinding;
        }

        public final void bind(ShareUserInfo shareUserInfo, int i) {
            Intrinsics.checkNotNullParameter(shareUserInfo, "item");
            ItemShareFollowListBinding itemShareFollowListBinding = this.vb;
            View view = itemShareFollowListBinding.dividerTop;
            Intrinsics.checkNotNullExpressionValue(view, "dividerTop");
            int i2 = 0;
            if (!(i != 0)) {
                i2 = 8;
            }
            view.setVisibility(i2);
            ImageView imageView = itemShareFollowListBinding.ivShareWechat;
            Intrinsics.checkNotNullExpressionValue(imageView, "ivShareWechat");
            imageView.setVisibility(8);
            RequestManager with = Glide.with(itemShareFollowListBinding.getRoot().getContext());
            UserEntity information = shareUserInfo.getInformation();
            ((RequestBuilder) ((RequestBuilder) with.load(information != null ? information.getAvatar() : null).error(R.drawable.ic_default_avatar)).transform((Transformation<Bitmap>) new CircleCrop())).into(itemShareFollowListBinding.ivAvatar);
            itemShareFollowListBinding.txtName.setText(shareUserInfo.getDisplayName());
            itemShareFollowListBinding.getRoot().setOnClickListener(new ShareFollowListAdapter$ViewHolder$$ExternalSyntheticLambda0());
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ItemShareFollowListBinding inflate = ItemShareFollowListBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return new ViewHolder(inflate);
    }

    public int getItemCount() {
        List<ShareUserInfo> list = this.data;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        List<ShareUserInfo> list = this.data;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            viewHolder.bind(list.get(i), i);
            Function1<? super ShareUserInfo, Unit> function1 = this.onItemClickListener;
            if (function1 != null) {
                viewHolder.itemView.setOnClickListener(new ShareFollowListAdapter$$ExternalSyntheticLambda0(function1, this, i));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$3$lambda$2$lambda$1(Function1 function1, ShareFollowListAdapter shareFollowListAdapter, int i, View view) {
        Intrinsics.checkNotNullParameter(function1, "$itemClick");
        Intrinsics.checkNotNullParameter(shareFollowListAdapter, "this$0");
        List<ShareUserInfo> list = shareFollowListAdapter.data;
        Intrinsics.checkNotNull(list);
        function1.invoke(list.get(i));
    }
}
