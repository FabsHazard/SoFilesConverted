package com.lihang;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;

class GlideRoundUtils {
    GlideRoundUtils() {
    }

    public static void setRoundCorner(final View view, final Drawable drawable, final float f, final String str) {
        if (f == 0.0f) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    ((RequestBuilder) ((RequestBuilder) Glide.with(view).asDrawable().load(drawable).transform((Transformation<Bitmap>) new CenterCrop())).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                            if (((String) view.getTag(R.id.action_container)).equals(str)) {
                                view.setBackground(drawable);
                            }
                        }
                    });
                }
            });
            if (view.getMeasuredWidth() != 0 || view.getMeasuredHeight() != 0) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(view).asDrawable().load(drawable).transform((Transformation<Bitmap>) new CenterCrop())).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        view.setBackground(drawable);
                    }
                });
                return;
            }
            return;
        }
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                ((RequestBuilder) ((RequestBuilder) Glide.with(view).load(drawable).transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) f)})).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        if (((String) view.getTag(R.id.action_container)).equals(str)) {
                            view.setBackground(drawable);
                        }
                    }
                });
            }
        });
        if (view.getMeasuredWidth() != 0 || view.getMeasuredHeight() != 0) {
            ((RequestBuilder) ((RequestBuilder) Glide.with(view).load(drawable).transform((Transformation<Bitmap>[]) new Transformation[]{new CenterCrop(), new RoundedCorners((int) f)})).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    view.setBackground(drawable);
                }
            });
        }
    }

    public static void setCorners(final View view, final Drawable drawable, float f, float f2, float f3, float f4, final String str) {
        if (f == 0.0f && f2 == 0.0f && f3 == 0.0f && f4 == 0.0f) {
            view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                    view.removeOnLayoutChangeListener(this);
                    ((RequestBuilder) Glide.with(view).load(drawable).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                        public void onLoadCleared(Drawable drawable) {
                        }

                        public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                            if (((String) view.getTag(R.id.action_container)).equals(str)) {
                                view.setBackground(drawable);
                            }
                        }
                    });
                }
            });
            if (view.getMeasuredWidth() != 0 || view.getMeasuredHeight() != 0) {
                ((RequestBuilder) Glide.with(view).load(drawable).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        view.setBackground(drawable);
                    }
                });
                return;
            }
            return;
        }
        final GlideRoundTransform glideRoundTransform = new GlideRoundTransform(view.getContext(), f, f2, f3, f4);
        view.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                view.removeOnLayoutChangeListener(this);
                ((RequestBuilder) ((RequestBuilder) Glide.with(view).load(drawable).transform((Transformation<Bitmap>) glideRoundTransform)).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                    public void onLoadCleared(Drawable drawable) {
                    }

                    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                        if (((String) view.getTag(R.id.action_container)).equals(str)) {
                            view.setBackground(drawable);
                        }
                    }
                });
            }
        });
        if (view.getMeasuredWidth() != 0 || view.getMeasuredHeight() != 0) {
            ((RequestBuilder) ((RequestBuilder) Glide.with(view).load(drawable).transform((Transformation<Bitmap>) glideRoundTransform)).override(view.getMeasuredWidth(), view.getMeasuredHeight())).into(new CustomTarget<Drawable>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    if (((String) view.getTag(R.id.action_container)).equals(str)) {
                        view.setBackground(drawable);
                    }
                }
            });
        }
    }
}
