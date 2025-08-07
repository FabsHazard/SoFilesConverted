package com.microtech.aidexx.ui.welcome.guide.fragment;

import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.base.BaseFragment;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.ui.welcome.guide.OnNextClickListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/ui/welcome/guide/fragment/GuideBaseFragment;", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/microtech/aidexx/base/BaseFragment;", "Lcom/microtech/aidexx/ui/welcome/guide/OnNextClickListener;", "()V", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: GuideBaseFragment.kt */
public abstract class GuideBaseFragment<VM extends BaseViewModel, VB extends ViewBinding> extends BaseFragment<VM, VB> implements OnNextClickListener {
    public void onNextClick() {
        OnNextClickListener.DefaultImpls.onNextClick(this);
    }
}
