package com.microtech.aidexx.base;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBinding;
import com.microtech.aidexx.base.BaseViewModel;
import com.microtech.aidexx.base.PageActions;
import com.microtech.aidexx.utils.LogUtil;
import com.microtech.aidexx.utils.ThemeManager;
import com.microtech.aidexx.utils.Throttle;
import com.microtech.aidexx.utils.statusbar.StatusBarHelper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u00052\u00020\u0006B\u0005¢\u0006\u0002\u0010\u0007J\u0016\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bj\u0004\u0018\u0001`\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0016J\u0012\u0010$\u001a\u00020\u001c2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u001cH\u0016J\b\u0010(\u001a\u00020\u001cH\u0016J\b\u0010)\u001a\u00020\u001cH\u0016R\u001c\u0010\b\u001a\u00028\u0001X.¢\u0006\u0010\n\u0002\u0010\r\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u00028\u0000X.¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006*"}, d2 = {"Lcom/microtech/aidexx/base/BaseFragment;", "VM", "Lcom/microtech/aidexx/base/BaseViewModel;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/fragment/app/Fragment;", "Lcom/microtech/aidexx/base/PageActions;", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "throttle", "Lcom/microtech/aidexx/utils/Throttle;", "getThrottle", "()Lcom/microtech/aidexx/utils/Throttle;", "setThrottle", "(Lcom/microtech/aidexx/utils/Throttle;)V", "viewModel", "getViewModel", "()Lcom/microtech/aidexx/base/BaseViewModel;", "setViewModel", "(Lcom/microtech/aidexx/base/BaseViewModel;)V", "Lcom/microtech/aidexx/base/BaseViewModel;", "canLeave", "Lkotlin/Function0;", "", "Lcom/microtech/aidexx/base/AfterLeaveCallback;", "initViewModel", "isBindingInit", "", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<VM extends BaseViewModel, VB extends ViewBinding> extends Fragment implements PageActions {
    public VB binding;
    protected Throttle throttle;
    public VM viewModel;

    public Function0<Unit> canLeave() {
        return null;
    }

    public String getPageName() {
        return PageActions.DefaultImpls.getPageName(this);
    }

    public final VM getViewModel() {
        VM vm = this.viewModel;
        if (vm != null) {
            return vm;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        return null;
    }

    public final void setViewModel(VM vm) {
        Intrinsics.checkNotNullParameter(vm, "<set-?>");
        this.viewModel = vm;
    }

    public final VB getBinding() {
        VB vb = this.binding;
        if (vb != null) {
            return vb;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(VB vb) {
        Intrinsics.checkNotNullParameter(vb, "<set-?>");
        this.binding = vb;
    }

    /* access modifiers changed from: protected */
    public final Throttle getThrottle() {
        Throttle throttle2 = this.throttle;
        if (throttle2 != null) {
            return throttle2;
        }
        Intrinsics.throwUninitializedPropertyAccessException("throttle");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setThrottle(Throttle throttle2) {
        Intrinsics.checkNotNullParameter(throttle2, "<set-?>");
        this.throttle = throttle2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LogUtil.Companion.eAiDEX("onCreate --> " + getClass().getName());
        initViewModel();
        setThrottle(Throttle.Companion.instance());
    }

    public void onResume() {
        super.onResume();
        if (ThemeManager.INSTANCE.isLight()) {
            StatusBarHelper.setStatusBarLightMode(requireActivity());
        } else {
            StatusBarHelper.setStatusBarDarkMode(requireActivity());
        }
        LogUtil.Companion.eAiDEX("onResume --> " + getClass().getName());
    }

    public void onPause() {
        super.onPause();
        LogUtil.Companion.eAiDEX("onPause --> " + getClass().getName());
    }

    public void onDestroy() {
        super.onDestroy();
        LogUtil.Companion.eAiDEX("onDestroy --> " + getClass().getName());
    }

    public void onConfigurationChanged(Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(getResources().getConfiguration());
    }

    private final void initViewModel() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Intrinsics.checkNotNull(genericSuperclass, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type type = ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
        Intrinsics.checkNotNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.microtech.aidexx.base.BaseFragment>");
        setViewModel((BaseViewModel) new ViewModelProvider(this).get((Class) type));
    }

    public final boolean isBindingInit() {
        return this.binding != null;
    }
}
