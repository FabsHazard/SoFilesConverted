package com.kongzue.dialogx.interfaces;

import android.app.Activity;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.util.views.ExtendChildLayoutParamsFrameLayout;
import java.security.SecureRandom;

public abstract class OnBindView<D> {
    private final int PARENT_FLAG = -109;
    View customView;
    private int dialogHash;
    /* access modifiers changed from: private */
    public Fragment fragment;
    private int fragmentParentId = -1;
    int layoutResId;
    private int parentViewHash;
    /* access modifiers changed from: private */
    public android.app.Fragment supportFragment;
    /* access modifiers changed from: private */
    public Runnable waitBindRunnable;

    public abstract void onBind(D d, View view);

    public void onFragmentBind(D d, View view, android.app.Fragment fragment2, FragmentManager fragmentManager) {
    }

    public void onFragmentBind(D d, View view, Fragment fragment2, androidx.fragment.app.FragmentManager fragmentManager) {
    }

    public void setEvent(D d, View view) {
    }

    public OnBindView(int i) {
        if (BaseDialog.getTopActivity() == null) {
            DialogX.error(DialogX.ERROR_INIT_TIPS);
            return;
        }
        this.layoutResId = i;
        this.customView = LayoutInflater.from(BaseDialog.getTopActivity()).inflate(i, new RelativeLayout(BaseDialog.getTopActivity()), false);
    }

    public OnBindView(final int i, boolean z) {
        if (BaseDialog.getTopActivity() == null) {
            DialogX.error(DialogX.ERROR_INIT_TIPS);
            return;
        }
        this.layoutResId = i;
        if (z) {
            new Thread() {
                public void run() {
                    super.run();
                    synchronized (OnBindView.this) {
                        OnBindView.this.customView = LayoutInflater.from(BaseDialog.getTopActivity()).inflate(i, new RelativeLayout(BaseDialog.getTopActivity()), false);
                        if (OnBindView.this.waitBindRunnable != null) {
                            OnBindView.this.waitBindRunnable.run();
                            Runnable unused = OnBindView.this.waitBindRunnable = null;
                        }
                    }
                }
            }.start();
        } else {
            this.customView = LayoutInflater.from(BaseDialog.getTopActivity()).inflate(i, new RelativeLayout(BaseDialog.getTopActivity()), false);
        }
    }

    public OnBindView(View view) {
        this.customView = view;
    }

    /* access modifiers changed from: private */
    public int getFragmentParentId() {
        if (this.fragmentParentId == -1) {
            this.fragmentParentId = createFragmentParentId();
        }
        return this.fragmentParentId;
    }

    private int createFragmentParentId() {
        this.fragmentParentId = new SecureRandom().nextInt();
        if (BaseDialog.getTopActivity().findViewById(this.fragmentParentId) != null) {
            return createFragmentParentId();
        }
        return this.fragmentParentId;
    }

    public OnBindView(Fragment fragment2) {
        if (BaseDialog.getTopActivity() != null) {
            ExtendChildLayoutParamsFrameLayout extendChildLayoutParamsFrameLayout = new ExtendChildLayoutParamsFrameLayout(BaseDialog.getTopActivity());
            this.customView = extendChildLayoutParamsFrameLayout;
            extendChildLayoutParamsFrameLayout.setId(getFragmentParentId());
            this.fragment = fragment2;
            this.supportFragment = null;
        }
    }

    public OnBindView(android.app.Fragment fragment2) {
        if (BaseDialog.getTopActivity() != null) {
            ExtendChildLayoutParamsFrameLayout extendChildLayoutParamsFrameLayout = new ExtendChildLayoutParamsFrameLayout(BaseDialog.getTopActivity());
            this.customView = extendChildLayoutParamsFrameLayout;
            extendChildLayoutParamsFrameLayout.setId(getFragmentParentId());
            this.supportFragment = fragment2;
            this.fragment = null;
        }
    }

    public int getLayoutResId() {
        return this.layoutResId;
    }

    public OnBindView<D> setLayoutResId(int i) {
        this.layoutResId = i;
        return this;
    }

    public View getCustomView() {
        if (this.customView == null) {
            this.customView = LayoutInflater.from(BaseDialog.getTopActivity()).inflate(this.layoutResId, new RelativeLayout(BaseDialog.getTopActivity()), false);
        }
        return this.customView;
    }

    public OnBindView<D> setCustomView(View view) {
        this.customView = view;
        return this;
    }

    public void clean() {
        this.layoutResId = 0;
        this.customView = null;
    }

    @Deprecated
    public void bindParent(ViewGroup viewGroup) {
        if (getCustomView() == null) {
            waitBind(viewGroup, (BaseDialog) null);
            return;
        }
        if (getCustomView().getParent() != null) {
            if (getCustomView().getParent() != viewGroup) {
                ((ViewGroup) getCustomView().getParent()).removeView(getCustomView());
            } else {
                return;
            }
        }
        ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        }
        viewGroup.addView(getCustomView(), layoutParams);
    }

    public void bindParent(ViewGroup viewGroup, final BaseDialog baseDialog) {
        if (getCustomView() == null) {
            waitBind(viewGroup, (BaseDialog) null);
        } else if (getCustomView().getParent() != viewGroup && viewGroup.getTag(-109) != getCustomView().toString()) {
            if (getCustomView().getParent() != null) {
                ((ViewGroup) getCustomView().getParent()).removeView(getCustomView());
            }
            ViewGroup.LayoutParams layoutParams = getCustomView().getLayoutParams();
            if (layoutParams == null) {
                layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            }
            viewGroup.addView(getCustomView(), layoutParams);
            onBind(baseDialog, getCustomView());
            callSetEvent(baseDialog, getCustomView());
            if (this.fragment != null || this.supportFragment != null) {
                if (baseDialog.getDialogImplMode() != DialogX.IMPL_MODE.VIEW) {
                    BaseDialog.error(baseDialog.dialogKey() + "非 VIEW 实现模式不支持 fragment 作为子布局显示。\n其原因为 Window 中不存在 FragmentManager，无法对子布局中的 fragment 进行管理。");
                } else {
                    getCustomView().post(new Runnable() {
                        public void run() {
                            if (OnBindView.this.fragment != null && (OnBindView.this.getCustomView() instanceof FrameLayout) && (baseDialog.getOwnActivity() instanceof AppCompatActivity)) {
                                AppCompatActivity appCompatActivity = (AppCompatActivity) baseDialog.getOwnActivity();
                                FragmentTransaction beginTransaction = appCompatActivity.getSupportFragmentManager().beginTransaction();
                                beginTransaction.add(OnBindView.this.getFragmentParentId(), OnBindView.this.fragment);
                                beginTransaction.commit();
                                OnBindView onBindView = OnBindView.this;
                                onBindView.onFragmentBind(baseDialog, onBindView.getCustomView(), OnBindView.this.fragment, appCompatActivity.getSupportFragmentManager());
                            }
                            if (OnBindView.this.supportFragment != null && (OnBindView.this.getCustomView() instanceof FrameLayout) && (baseDialog.getOwnActivity() instanceof Activity)) {
                                Activity ownActivity = baseDialog.getOwnActivity();
                                android.app.FragmentTransaction beginTransaction2 = ownActivity.getFragmentManager().beginTransaction();
                                beginTransaction2.add(OnBindView.this.getFragmentParentId(), OnBindView.this.supportFragment);
                                beginTransaction2.commit();
                                OnBindView onBindView2 = OnBindView.this;
                                onBindView2.onFragmentBind(baseDialog, onBindView2.getCustomView(), OnBindView.this.supportFragment, ownActivity.getFragmentManager());
                            }
                        }
                    });
                }
            }
        }
    }

    private void callSetEvent(D d, View view) {
        if (d.hashCode() != this.dialogHash || view.hashCode() != this.parentViewHash) {
            this.dialogHash = d.hashCode();
            this.parentViewHash = view.hashCode();
            setEvent(d, getCustomView());
        }
    }

    private void waitBind(final ViewGroup viewGroup, final BaseDialog baseDialog) {
        this.waitBindRunnable = new Runnable() {
            public void run() {
                if (OnBindView.this.getCustomView() == null) {
                    BaseDialog baseDialog = baseDialog;
                    if (baseDialog == null) {
                        OnBindView.this.bindParent(viewGroup);
                    } else {
                        OnBindView.this.bindParent(viewGroup, baseDialog);
                    }
                }
            }
        };
    }
}
