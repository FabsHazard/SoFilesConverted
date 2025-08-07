package com.microtech.aidexx.utils.adapter;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ListUpdateCallback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.microtech.aidexx.utils.adapter.BaseViewHolder;
import com.microtech.aidexx.utils.adapter.anim.AlphaInAnimation;
import com.microtech.aidexx.utils.adapter.anim.BaseAnimation;
import com.microtech.aidexx.utils.adapter.anim.ScaleInAnimation;
import com.microtech.aidexx.utils.adapter.anim.SlideInBottomAnimation;
import com.microtech.aidexx.utils.adapter.anim.SlideInLeftAnimation;
import com.microtech.aidexx.utils.adapter.anim.SlideInRightAnimation;
import com.microtech.aidexx.utils.adapter.diff.BrvahAsyncDiffer;
import com.microtech.aidexx.utils.adapter.diff.BrvahListUpdateCallback;
import com.microtech.aidexx.utils.adapter.listener.GridSpanSizeLookup;
import com.microtech.aidexx.utils.adapter.listener.OnItemChildClickListener;
import com.microtech.aidexx.utils.adapter.listener.OnItemChildLongClickListener;
import com.microtech.aidexx.utils.adapter.moudle.BaseDraggableModule;
import com.microtech.aidexx.utils.adapter.moudle.DraggableModule;
import com.microtech.aidexx.utils.adapter.util.AdapterUtilsKt;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 ï\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u0004:\u0004î\u0001ï\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0002J\u0014\u0010r\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\u0006J\u0014\u0010u\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\u0006J\u0017\u0010v\u001a\u00020o2\b\b\u0001\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u001f\u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ \u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u00062\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J\u0018\u0010v\u001a\u00020o2\u000e\b\u0001\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J%\u0010|\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u001a\u00020\u00062\t\b\u0002\u0010\u0001\u001a\u00020\u0006H\u0007J&\u0010\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u001a\u00020\u00062\t\b\u0002\u0010\u0001\u001a\u00020\u0006H\u0007J!\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00028\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0001J\t\u0010\u0001\u001a\u00020oH\u0002J\u0012\u0010\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00020\u0006H\u0004J \u0010\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u0001\u001a\u00028\u0000H$¢\u0006\u0003\u0010\u0001J1\u0010\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u0001\u001a\u00028\u00002\u000f\u0010\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010\u0001H\u0014¢\u0006\u0003\u0010\u0001J'\u0010\u0001\u001a\u0004\u0018\u00018\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u00012\u0006\u0010}\u001a\u00020~H\u0002¢\u0006\u0003\u0010\u0001J\u0017\u0010\u0001\u001a\u00028\u00012\u0006\u0010}\u001a\u00020~H\u0014¢\u0006\u0003\u0010\u0001J#\u0010\u0001\u001a\u00028\u00012\b\u0010\u0001\u001a\u00030\u00012\b\b\u0001\u0010\u0005\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0001J\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018J\t\u0010\u0001\u001a\u00020\u0006H\u0014J\u0011\u0010\u0001\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u0006H\u0014J\u000f\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000OH\u0007J\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000OJ\u001e\u0010\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u00012\f\u0010\u0001\u001a\u0007\u0012\u0002\b\u00030\u0001H\u0002J\u0019\u0010 \u0001\u001a\u00028\u00002\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¡\u0001J\t\u0010¢\u0001\u001a\u00020\u0006H\u0016J\u0012\u0010£\u0001\u001a\u00030¤\u00012\u0006\u0010x\u001a\u00020\u0006H\u0016J\u001b\u0010¥\u0001\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010¡\u0001J\u001a\u0010¦\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0003\u0010§\u0001J\u0011\u0010¨\u0001\u001a\u00020\u00062\u0006\u0010x\u001a\u00020\u0006H\u0016J\t\u0010©\u0001\u001a\u0004\u0018\u00010ZJ\t\u0010ª\u0001\u001a\u0004\u0018\u00010\\J\t\u0010«\u0001\u001a\u0004\u0018\u00010^J\t\u0010¬\u0001\u001a\u0004\u0018\u00010`J\u001c\u0010­\u0001\u001a\u0004\u0018\u00010~2\u0006\u0010x\u001a\u00020\u00062\t\b\u0001\u0010®\u0001\u001a\u00020\u0006J\u0007\u0010¯\u0001\u001a\u00020\u0012J\u0007\u0010°\u0001\u001a\u00020\u0012J\u0007\u0010±\u0001\u001a\u00020\u0012J\u0012\u0010²\u0001\u001a\u00020\u00122\u0007\u0010³\u0001\u001a\u00020\u0006H\u0014J\u0011\u0010´\u0001\u001a\u00020o2\u0006\u0010e\u001a\u00020fH\u0016J\u001f\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010\u0001J/\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\u00062\u000e\u0010\u0001\u001a\t\u0012\u0005\u0012\u00030\u00010\bH\u0016¢\u0006\u0003\u0010¶\u0001J\"\u0010·\u0001\u001a\u00028\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0001J\"\u0010¸\u0001\u001a\u00028\u00012\b\u0010\u0001\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0016¢\u0006\u0003\u0010\u0001J\u0011\u0010¹\u0001\u001a\u00020o2\u0006\u0010e\u001a\u00020fH\u0016J!\u0010º\u0001\u001a\u00020o2\u0007\u0010\u0001\u001a\u00028\u00012\u0007\u0010\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0003\u0010\u0001J\u0017\u0010»\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u0001H\u0016¢\u0006\u0003\u0010¼\u0001J\u0016\u0010½\u0001\u001a\u00020o2\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u0013\u0010½\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u0006H\u0017J\u0007\u0010¾\u0001\u001a\u00020oJ\u0007\u0010¿\u0001\u001a\u00020oJ\u0013\u0010À\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\u0006H\u0016J\u0007\u0010Á\u0001\u001a\u00020oJ\u0010\u0010Â\u0001\u001a\u00020o2\u0007\u0010Ã\u0001\u001a\u00020~J\u0010\u0010Ä\u0001\u001a\u00020o2\u0007\u0010Å\u0001\u001a\u00020~J\u0017\u0010Æ\u0001\u001a\u00020o2\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0017J\u0011\u0010Ç\u0001\u001a\u00020o2\b\u0010È\u0001\u001a\u00030É\u0001J \u0010Ê\u0001\u001a\u00020o2\b\b\u0001\u0010\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ\u0017\u0010Ë\u0001\u001a\u00020o2\u000e\u0010Ì\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Í\u0001J\u0017\u0010Î\u0001\u001a\u00020o2\u000e\u0010Ï\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ð\u0001J$\u0010Ñ\u0001\u001a\u00020o2\n\b\u0001\u0010Ò\u0001\u001a\u00030Ó\u00012\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\bH\u0016J(\u0010Ñ\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\b2\f\b\u0002\u0010Õ\u0001\u001a\u0005\u0018\u00010Ö\u0001H\u0017J\u0010\u0010×\u0001\u001a\u00020o2\u0007\u0010Ø\u0001\u001a\u00020~J\u000f\u0010×\u0001\u001a\u00020o2\u0006\u0010\u0005\u001a\u00020\u0006J&\u0010Ù\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u001a\u00020\u00062\t\b\u0002\u0010\u0001\u001a\u00020\u0006H\u0007J\u0011\u0010Ú\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0014J\u0012\u0010Û\u0001\u001a\u00020o2\t\u0010Ü\u0001\u001a\u0004\u0018\u00010bJ&\u0010Ý\u0001\u001a\u00020\u00062\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u001a\u00020\u00062\t\b\u0002\u0010\u0001\u001a\u00020\u0006H\u0007J\u001a\u0010Þ\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010{H\u0016J\u0019\u0010ß\u0001\u001a\u00020o2\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0017J\u001a\u0010à\u0001\u001a\u00020o2\u000f\u0010Ô\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\bH\u0016J\u001a\u0010á\u0001\u001a\u00020o2\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010ã\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010ZJ\u001a\u0010å\u0001\u001a\u00020\u00122\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010æ\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010\\J\u001a\u0010ç\u0001\u001a\u00020o2\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010è\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010^J\u001a\u0010é\u0001\u001a\u00020\u00122\u0007\u0010â\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\u0006H\u0014J\u0012\u0010ê\u0001\u001a\u00020o2\t\u0010ä\u0001\u001a\u0004\u0018\u00010`J\u001b\u0010ë\u0001\u001a\u00020o2\b\u0010ì\u0001\u001a\u00030í\u00012\u0006\u0010\u001a\u00020\u0006H\u0014R(\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00060\u0018X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR0\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00028\u00000\b@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020$8F¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0013\u0010'\u001a\u0004\u0018\u00010(8F¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b-\u0010.R\u0011\u0010/\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b0\u00101R\u001a\u00102\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0014\"\u0004\b4\u0010\u0016R\u0011\u00105\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b6\u00101R\u001a\u00107\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0014\"\u0004\b9\u0010\u0016R\u0013\u0010:\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\b;\u0010.R\u0011\u0010<\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b=\u00101R\u001a\u0010>\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u0014\"\u0004\b@\u0010\u0016R\u0011\u0010A\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\bB\u00101R\u001a\u0010C\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0014\"\u0004\bE\u0010\u0016R\u001a\u0010F\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0014\"\u0004\bG\u0010\u0016R\u001a\u0010H\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0014\"\u0004\bI\u0010\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010J\u001a\u00020K8F¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0016\u0010N\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010OX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020,X.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010U\u001a\u0004\u0018\u00010KX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010M\"\u0004\bW\u0010XR\u0010\u0010Y\u001a\u0004\u0018\u00010ZX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u0004\u0018\u00010\\X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u0004\u0018\u00010^X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u0004\u0018\u00010`X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u0004\u0018\u00010bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010dX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010e\u001a\u00020f8F¢\u0006\u0006\u001a\u0004\bg\u0010hR\"\u0010i\u001a\u0004\u0018\u00010f2\b\u0010\u001e\u001a\u0004\u0018\u00010f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\bj\u0010hR\u0011\u0010k\u001a\u00020d8F¢\u0006\u0006\u001a\u0004\bl\u0010m¨\u0006ð\u0001"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter;", "T", "VH", "Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "layoutResId", "", "data", "", "(ILjava/util/List;)V", "value", "Lcom/microtech/aidexx/utils/adapter/anim/BaseAnimation;", "adapterAnimation", "getAdapterAnimation", "()Lcom/microtech/aidexx/utils/adapter/anim/BaseAnimation;", "setAdapterAnimation", "(Lcom/microtech/aidexx/utils/adapter/anim/BaseAnimation;)V", "animationEnable", "", "getAnimationEnable", "()Z", "setAnimationEnable", "(Z)V", "childClickViewIds", "Ljava/util/LinkedHashSet;", "childLongClickViewIds", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "<set-?>", "getData", "()Ljava/util/List;", "setData$app_gpGrxMmolRelease", "(Ljava/util/List;)V", "draggableModule", "Lcom/microtech/aidexx/utils/adapter/moudle/BaseDraggableModule;", "getDraggableModule", "()Lcom/microtech/aidexx/utils/adapter/moudle/BaseDraggableModule;", "emptyLayout", "Landroid/widget/FrameLayout;", "getEmptyLayout", "()Landroid/widget/FrameLayout;", "footerLayout", "Landroid/widget/LinearLayout;", "getFooterLayout", "()Landroid/widget/LinearLayout;", "footerLayoutCount", "getFooterLayoutCount", "()I", "footerViewAsFlow", "getFooterViewAsFlow", "setFooterViewAsFlow", "footerViewPosition", "getFooterViewPosition", "footerWithEmptyEnable", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "headerLayout", "getHeaderLayout", "headerLayoutCount", "getHeaderLayoutCount", "headerViewAsFlow", "getHeaderViewAsFlow", "setHeaderViewAsFlow", "headerViewPosition", "getHeaderViewPosition", "headerWithEmptyEnable", "getHeaderWithEmptyEnable", "setHeaderWithEmptyEnable", "isAnimationFirstOnly", "setAnimationFirstOnly", "isUseEmpty", "setUseEmpty", "loadMoreModule", "Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreModule;", "getLoadMoreModule", "()Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreModule;", "mDiffHelper", "Lcom/microtech/aidexx/utils/adapter/diff/BrvahAsyncDiffer;", "mDraggableModule", "mEmptyLayout", "mFooterLayout", "mHeaderLayout", "mLastPosition", "mLoadMoreModule", "getMLoadMoreModule$app_gpGrxMmolRelease", "setMLoadMoreModule$app_gpGrxMmolRelease", "(Lcom/microtech/aidexx/utils/adapter/BaseLoadMoreModule;)V", "mOnItemChildClickListener", "Lcom/microtech/aidexx/utils/adapter/listener/OnItemChildClickListener;", "mOnItemChildLongClickListener", "Lcom/microtech/aidexx/utils/adapter/listener/OnItemChildLongClickListener;", "mOnItemClickListener", "Lcom/microtech/aidexx/utils/adapter/OnItemClickListener;", "mOnItemLongClickListener", "Lcom/microtech/aidexx/utils/adapter/OnItemLongClickListener;", "mSpanSizeLookup", "Lcom/microtech/aidexx/utils/adapter/listener/GridSpanSizeLookup;", "mUpFetchModule", "Lcom/microtech/aidexx/utils/adapter/BaseUpFetchModule;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "recyclerViewOrNull", "getRecyclerViewOrNull", "upFetchModule", "getUpFetchModule", "()Lcom/microtech/aidexx/utils/adapter/BaseUpFetchModule;", "addAnimation", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addChildClickViewIds", "viewIds", "", "addChildLongClickViewIds", "addData", "(Ljava/lang/Object;)V", "position", "(ILjava/lang/Object;)V", "newData", "", "addFooterView", "view", "Landroid/view/View;", "index", "orientation", "addHeaderView", "bindViewClickListener", "viewHolder", "viewType", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;I)V", "checkModule", "compatibilityDataSizeChanged", "size", "convert", "item", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "createBaseGenericKInstance", "z", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroid/view/View;)Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "createBaseViewHolder", "(Landroid/view/View;)Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;I)Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;", "getChildClickViewIds", "getChildLongClickViewIds", "getDefItemCount", "getDefItemViewType", "getDiffHelper", "getDiffer", "getInstancedGenericKClass", "getItem", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "getItemOrNull", "getItemPosition", "(Ljava/lang/Object;)I", "getItemViewType", "getOnItemChildClickListener", "getOnItemChildLongClickListener", "getOnItemClickListener", "getOnItemLongClickListener", "getViewByPosition", "viewId", "hasEmptyView", "hasFooterLayout", "hasHeaderLayout", "isFixedViewType", "type", "onAttachedToRecyclerView", "onBindViewHolder", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;ILjava/util/List;)V", "onCreateDefViewHolder", "onCreateViewHolder", "onDetachedFromRecyclerView", "onItemViewHolderCreated", "onViewAttachedToWindow", "(Lcom/microtech/aidexx/utils/adapter/BaseViewHolder;)V", "remove", "removeAllFooterView", "removeAllHeaderView", "removeAt", "removeEmptyView", "removeFooterView", "footer", "removeHeaderView", "header", "replaceData", "setAnimationWithDefault", "animationType", "Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter$AnimationType;", "setData", "setDiffCallback", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffConfig", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "setDiffNewData", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "list", "commitCallback", "Ljava/lang/Runnable;", "setEmptyView", "emptyView", "setFooterView", "setFullSpan", "setGridSpanSizeLookup", "spanSizeLookup", "setHeaderView", "setList", "setNewData", "setNewInstance", "setOnItemChildClick", "v", "setOnItemChildClickListener", "listener", "setOnItemChildLongClick", "setOnItemChildLongClickListener", "setOnItemClick", "setOnItemClickListener", "setOnItemLongClick", "setOnItemLongClickListener", "startAnim", "anim", "Landroid/animation/Animator;", "AnimationType", "Companion", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: BaseQuickAdapter.kt */
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter<VH> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int EMPTY_VIEW = 268436821;
    public static final int FOOTER_VIEW = 268436275;
    public static final int HEADER_VIEW = 268435729;
    public static final int LOAD_MORE_VIEW = 268436002;
    private BaseAnimation adapterAnimation;
    private boolean animationEnable;
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> childLongClickViewIds;
    private List<T> data;
    private boolean footerViewAsFlow;
    private boolean footerWithEmptyEnable;
    private boolean headerViewAsFlow;
    private boolean headerWithEmptyEnable;
    private boolean isAnimationFirstOnly;
    private boolean isUseEmpty;
    private final int layoutResId;
    private BrvahAsyncDiffer<T> mDiffHelper;
    private BaseDraggableModule mDraggableModule;
    private FrameLayout mEmptyLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mHeaderLayout;
    private int mLastPosition;
    private BaseLoadMoreModule mLoadMoreModule;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    /* access modifiers changed from: private */
    public GridSpanSizeLookup mSpanSizeLookup;
    private BaseUpFetchModule mUpFetchModule;
    private RecyclerView recyclerViewOrNull;

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseQuickAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType[] r0 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType r1 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.AlphaIn     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType r1 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.ScaleIn     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType r1 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.SlideInBottom     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType r1 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.SlideInLeft     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.microtech.aidexx.utils.adapter.BaseQuickAdapter$AnimationType r1 = com.microtech.aidexx.utils.adapter.BaseQuickAdapter.AnimationType.SlideInRight     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.microtech.aidexx.utils.adapter.BaseQuickAdapter.WhenMappings.<clinit>():void");
        }
    }

    public BaseQuickAdapter(int i) {
        this(i, (List) null, 2, (DefaultConstructorMarker) null);
    }

    public final int addFooterView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return addFooterView$default(this, view, 0, 0, 6, (Object) null);
    }

    public final int addFooterView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return addFooterView$default(this, view, i, 0, 4, (Object) null);
    }

    public final int addHeaderView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return addHeaderView$default(this, view, 0, 0, 6, (Object) null);
    }

    public final int addHeaderView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return addHeaderView$default(this, view, i, 0, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract void convert(VH vh, T t);

    /* access modifiers changed from: protected */
    public void convert(VH vh, T t, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
    }

    public long getItemId(int i) {
        return (long) i;
    }

    /* access modifiers changed from: protected */
    public boolean isFixedViewType(int i) {
        return i == 268436821 || i == 268435729 || i == 268436275 || i == 268436002;
    }

    /* access modifiers changed from: protected */
    public void onItemViewHolderCreated(VH vh, int i) {
        Intrinsics.checkNotNullParameter(vh, "viewHolder");
    }

    public final void setDiffNewData(List<T> list) {
        setDiffNewData$default(this, list, (Runnable) null, 2, (Object) null);
    }

    public final int setFooterView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setFooterView$default(this, view, 0, 0, 6, (Object) null);
    }

    public final int setFooterView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setFooterView$default(this, view, i, 0, 4, (Object) null);
    }

    public final int setHeaderView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setHeaderView$default(this, view, 0, 0, 6, (Object) null);
    }

    public final int setHeaderView(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        return setHeaderView$default(this, view, i, 0, 4, (Object) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BaseQuickAdapter(int i, List list, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : list);
    }

    public BaseQuickAdapter(int i, List<T> list) {
        this.layoutResId = i;
        this.data = list == null ? new ArrayList<>() : list;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        checkModule();
        this.childClickViewIds = new LinkedHashSet<>();
        this.childLongClickViewIds = new LinkedHashSet<>();
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter$Companion;", "", "()V", "EMPTY_VIEW", "", "FOOTER_VIEW", "HEADER_VIEW", "LOAD_MORE_VIEW", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseQuickAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final List<T> getData() {
        return this.data;
    }

    public final void setData$app_gpGrxMmolRelease(List<T> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final boolean getHeaderWithEmptyEnable() {
        return this.headerWithEmptyEnable;
    }

    public final void setHeaderWithEmptyEnable(boolean z) {
        this.headerWithEmptyEnable = z;
    }

    public final boolean getFooterWithEmptyEnable() {
        return this.footerWithEmptyEnable;
    }

    public final void setFooterWithEmptyEnable(boolean z) {
        this.footerWithEmptyEnable = z;
    }

    public final boolean isUseEmpty() {
        return this.isUseEmpty;
    }

    public final void setUseEmpty(boolean z) {
        this.isUseEmpty = z;
    }

    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public final void setHeaderViewAsFlow(boolean z) {
        this.headerViewAsFlow = z;
    }

    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final void setFooterViewAsFlow(boolean z) {
        this.footerViewAsFlow = z;
    }

    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    public final void setAnimationEnable(boolean z) {
        this.animationEnable = z;
    }

    public final boolean isAnimationFirstOnly() {
        return this.isAnimationFirstOnly;
    }

    public final void setAnimationFirstOnly(boolean z) {
        this.isAnimationFirstOnly = z;
    }

    public final BaseAnimation getAdapterAnimation() {
        return this.adapterAnimation;
    }

    public final void setAdapterAnimation(BaseAnimation baseAnimation) {
        this.animationEnable = true;
        this.adapterAnimation = baseAnimation;
    }

    public final BaseLoadMoreModule getLoadMoreModule() {
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            Intrinsics.checkNotNull(baseLoadMoreModule);
            return baseLoadMoreModule;
        }
        throw new IllegalStateException("Please first implements LoadMoreModule".toString());
    }

    public final BaseUpFetchModule getUpFetchModule() {
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule != null) {
            Intrinsics.checkNotNull(baseUpFetchModule);
            return baseUpFetchModule;
        }
        throw new IllegalStateException("Please first implements UpFetchModule".toString());
    }

    public final BaseDraggableModule getDraggableModule() {
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            Intrinsics.checkNotNull(baseDraggableModule);
            return baseDraggableModule;
        }
        throw new IllegalStateException("Please first implements DraggableModule".toString());
    }

    public final BaseLoadMoreModule getMLoadMoreModule$app_gpGrxMmolRelease() {
        return this.mLoadMoreModule;
    }

    public final void setMLoadMoreModule$app_gpGrxMmolRelease(BaseLoadMoreModule baseLoadMoreModule) {
        this.mLoadMoreModule = baseLoadMoreModule;
    }

    public final RecyclerView getRecyclerViewOrNull() {
        return this.recyclerViewOrNull;
    }

    public final RecyclerView getRecyclerView() {
        RecyclerView recyclerView = this.recyclerViewOrNull;
        if (recyclerView != null) {
            Intrinsics.checkNotNull(recyclerView);
            return recyclerView;
        }
        throw new IllegalStateException("Please get it after onAttachedToRecyclerView()".toString());
    }

    public final Context getContext() {
        Context context = getRecyclerView().getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return context;
    }

    private final void checkModule() {
        if (this instanceof LoadMoreModule) {
            this.mLoadMoreModule = ((LoadMoreModule) this).addLoadMoreModule(this);
        }
        if (this instanceof UpFetchModule) {
            this.mUpFetchModule = ((UpFetchModule) this).addUpFetchModule(this);
        }
        if (this instanceof DraggableModule) {
            this.mDraggableModule = ((DraggableModule) this).addDraggableModule(this);
        }
    }

    public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        ViewParent viewParent = null;
        switch (i) {
            case HEADER_VIEW /*268435729*/:
                LinearLayout linearLayout = this.mHeaderLayout;
                if (linearLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                    linearLayout = null;
                }
                ViewParent parent = linearLayout.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup2 = (ViewGroup) parent;
                    LinearLayout linearLayout2 = this.mHeaderLayout;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                        linearLayout2 = null;
                    }
                    viewGroup2.removeView(linearLayout2);
                }
                ViewParent viewParent2 = this.mHeaderLayout;
                if (viewParent2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                } else {
                    viewParent = viewParent2;
                }
                return createBaseViewHolder((View) viewParent);
            case LOAD_MORE_VIEW /*268436002*/:
                BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
                Intrinsics.checkNotNull(baseLoadMoreModule);
                VH createBaseViewHolder = createBaseViewHolder(baseLoadMoreModule.getLoadMoreView().getRootView(viewGroup));
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                Intrinsics.checkNotNull(baseLoadMoreModule2);
                baseLoadMoreModule2.setupViewHolder$app_gpGrxMmolRelease(createBaseViewHolder);
                return createBaseViewHolder;
            case FOOTER_VIEW /*268436275*/:
                LinearLayout linearLayout3 = this.mFooterLayout;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                    linearLayout3 = null;
                }
                ViewParent parent2 = linearLayout3.getParent();
                if (parent2 instanceof ViewGroup) {
                    ViewGroup viewGroup3 = (ViewGroup) parent2;
                    LinearLayout linearLayout4 = this.mFooterLayout;
                    if (linearLayout4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                        linearLayout4 = null;
                    }
                    viewGroup3.removeView(linearLayout4);
                }
                ViewParent viewParent3 = this.mFooterLayout;
                if (viewParent3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                } else {
                    viewParent = viewParent3;
                }
                return createBaseViewHolder((View) viewParent);
            case EMPTY_VIEW /*268436821*/:
                FrameLayout frameLayout = this.mEmptyLayout;
                if (frameLayout == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout = null;
                }
                ViewParent parent3 = frameLayout.getParent();
                if (parent3 instanceof ViewGroup) {
                    ViewGroup viewGroup4 = (ViewGroup) parent3;
                    FrameLayout frameLayout2 = this.mEmptyLayout;
                    if (frameLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                        frameLayout2 = null;
                    }
                    viewGroup4.removeView(frameLayout2);
                }
                ViewParent viewParent4 = this.mEmptyLayout;
                if (viewParent4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                } else {
                    viewParent = viewParent4;
                }
                return createBaseViewHolder((View) viewParent);
            default:
                VH onCreateDefViewHolder = onCreateDefViewHolder(viewGroup, i);
                bindViewClickListener(onCreateDefViewHolder, i);
                BaseDraggableModule baseDraggableModule = this.mDraggableModule;
                if (baseDraggableModule != null) {
                    baseDraggableModule.initView$app_gpGrxMmolRelease(onCreateDefViewHolder);
                }
                onItemViewHolderCreated(onCreateDefViewHolder, i);
                return onCreateDefViewHolder;
        }
    }

    public int getItemCount() {
        int i = 1;
        if (hasEmptyView()) {
            if (this.headerWithEmptyEnable && hasHeaderLayout()) {
                i = 2;
            }
            return (!this.footerWithEmptyEnable || !hasFooterLayout()) ? i : i + 1;
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule == null || !baseLoadMoreModule.hasLoadMoreView()) {
            i = 0;
        }
        return getHeaderLayoutCount() + getDefItemCount() + getFooterLayoutCount() + i;
    }

    public int getItemViewType(int i) {
        if (hasEmptyView()) {
            boolean z = this.headerWithEmptyEnable && hasHeaderLayout();
            if (i != 0) {
                if (i != 1) {
                }
                return FOOTER_VIEW;
            } else if (z) {
                return HEADER_VIEW;
            }
            return EMPTY_VIEW;
        }
        boolean hasHeaderLayout = hasHeaderLayout();
        if (hasHeaderLayout && i == 0) {
            return HEADER_VIEW;
        }
        if (hasHeaderLayout) {
            i--;
        }
        int size = this.data.size();
        if (i < size) {
            return getDefItemViewType(i);
        }
        if (i - size < hasFooterLayout()) {
            return FOOTER_VIEW;
        }
        return LOAD_MORE_VIEW;
    }

    public void onBindViewHolder(VH vh, int i) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.autoUpFetch$app_gpGrxMmolRelease(i);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.autoLoadMore$app_gpGrxMmolRelease(i);
        }
        switch (vh.getItemViewType()) {
            case HEADER_VIEW /*268435729*/:
            case FOOTER_VIEW /*268436275*/:
            case EMPTY_VIEW /*268436821*/:
                return;
            case LOAD_MORE_VIEW /*268436002*/:
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.getLoadMoreView().convert(vh, i, baseLoadMoreModule2.getLoadMoreStatus());
                    return;
                }
                return;
            default:
                convert(vh, getItem(i - getHeaderLayoutCount()));
                return;
        }
    }

    public void onBindViewHolder(VH vh, int i, List<Object> list) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (list.isEmpty()) {
            onBindViewHolder(vh, i);
            return;
        }
        BaseUpFetchModule baseUpFetchModule = this.mUpFetchModule;
        if (baseUpFetchModule != null) {
            baseUpFetchModule.autoUpFetch$app_gpGrxMmolRelease(i);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.autoLoadMore$app_gpGrxMmolRelease(i);
        }
        switch (vh.getItemViewType()) {
            case HEADER_VIEW /*268435729*/:
            case FOOTER_VIEW /*268436275*/:
            case EMPTY_VIEW /*268436821*/:
                return;
            case LOAD_MORE_VIEW /*268436002*/:
                BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
                if (baseLoadMoreModule2 != null) {
                    baseLoadMoreModule2.getLoadMoreView().convert(vh, i, baseLoadMoreModule2.getLoadMoreStatus());
                    return;
                }
                return;
            default:
                convert(vh, getItem(i - getHeaderLayoutCount()), list);
                return;
        }
    }

    public void onViewAttachedToWindow(VH vh) {
        Intrinsics.checkNotNullParameter(vh, "holder");
        RecyclerView.ViewHolder viewHolder = (RecyclerView.ViewHolder) vh;
        super.onViewAttachedToWindow(viewHolder);
        if (isFixedViewType(vh.getItemViewType())) {
            setFullSpan(viewHolder);
        } else {
            addAnimation(viewHolder);
        }
    }

    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onAttachedToRecyclerView(recyclerView);
        this.recyclerViewOrNull = recyclerView;
        BaseDraggableModule baseDraggableModule = this.mDraggableModule;
        if (baseDraggableModule != null) {
            baseDraggableModule.attachToRecyclerView(recyclerView);
        }
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            gridLayoutManager.setSpanSizeLookup(new BaseQuickAdapter$onAttachedToRecyclerView$1(this, layoutManager, gridLayoutManager.getSpanSizeLookup()));
        }
    }

    public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        super.onDetachedFromRecyclerView(recyclerView);
        this.recyclerViewOrNull = null;
    }

    public T getItem(int i) {
        return this.data.get(i);
    }

    public T getItemOrNull(int i) {
        return CollectionsKt.getOrNull(this.data, i);
    }

    public int getItemPosition(T t) {
        if (t == null || this.data.isEmpty()) {
            return -1;
        }
        return this.data.indexOf(t);
    }

    public final LinkedHashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    public final void addChildClickViewIds(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "viewIds");
        for (int valueOf : iArr) {
            this.childClickViewIds.add(Integer.valueOf(valueOf));
        }
    }

    public final LinkedHashSet<Integer> getChildLongClickViewIds() {
        return this.childLongClickViewIds;
    }

    public final void addChildLongClickViewIds(int... iArr) {
        Intrinsics.checkNotNullParameter(iArr, "viewIds");
        for (int valueOf : iArr) {
            this.childLongClickViewIds.add(Integer.valueOf(valueOf));
        }
    }

    /* access modifiers changed from: protected */
    public void bindViewClickListener(VH vh, int i) {
        Intrinsics.checkNotNullParameter(vh, "viewHolder");
        if (this.mOnItemClickListener != null) {
            vh.itemView.setOnClickListener(new BaseQuickAdapter$$ExternalSyntheticLambda0(vh, this));
        }
        if (this.mOnItemLongClickListener != null) {
            vh.itemView.setOnLongClickListener(new BaseQuickAdapter$$ExternalSyntheticLambda1(vh, this));
        }
        if (this.mOnItemChildClickListener != null) {
            Iterator it = getChildClickViewIds().iterator();
            while (it.hasNext()) {
                Integer num = (Integer) it.next();
                View view = vh.itemView;
                Intrinsics.checkNotNull(num);
                View findViewById = view.findViewById(num.intValue());
                if (findViewById != null) {
                    Intrinsics.checkNotNull(findViewById);
                    if (!findViewById.isClickable()) {
                        findViewById.setClickable(true);
                    }
                    findViewById.setOnClickListener(new BaseQuickAdapter$$ExternalSyntheticLambda2(vh, this));
                }
            }
        }
        if (this.mOnItemChildLongClickListener != null) {
            Iterator it2 = getChildLongClickViewIds().iterator();
            while (it2.hasNext()) {
                Integer num2 = (Integer) it2.next();
                View view2 = vh.itemView;
                Intrinsics.checkNotNull(num2);
                View findViewById2 = view2.findViewById(num2.intValue());
                if (findViewById2 != null) {
                    Intrinsics.checkNotNull(findViewById2);
                    if (!findViewById2.isLongClickable()) {
                        findViewById2.setLongClickable(true);
                    }
                    findViewById2.setOnLongClickListener(new BaseQuickAdapter$$ExternalSyntheticLambda3(vh, this));
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void bindViewClickListener$lambda$7$lambda$6(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            Intrinsics.checkNotNull(view);
            baseQuickAdapter.setOnItemClick(view, bindingAdapterPosition - baseQuickAdapter.getHeaderLayoutCount());
        }
    }

    /* access modifiers changed from: private */
    public static final boolean bindViewClickListener$lambda$9$lambda$8(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        Intrinsics.checkNotNull(view);
        return baseQuickAdapter.setOnItemLongClick(view, bindingAdapterPosition - baseQuickAdapter.getHeaderLayoutCount());
    }

    /* access modifiers changed from: private */
    public static final void bindViewClickListener$lambda$12$lambda$11$lambda$10(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition != -1) {
            Intrinsics.checkNotNull(view);
            baseQuickAdapter.setOnItemChildClick(view, bindingAdapterPosition - baseQuickAdapter.getHeaderLayoutCount());
        }
    }

    /* access modifiers changed from: private */
    public static final boolean bindViewClickListener$lambda$15$lambda$14$lambda$13(BaseViewHolder baseViewHolder, BaseQuickAdapter baseQuickAdapter, View view) {
        Intrinsics.checkNotNullParameter(baseViewHolder, "$viewHolder");
        Intrinsics.checkNotNullParameter(baseQuickAdapter, "this$0");
        int bindingAdapterPosition = baseViewHolder.getBindingAdapterPosition();
        if (bindingAdapterPosition == -1) {
            return false;
        }
        Intrinsics.checkNotNull(view);
        return baseQuickAdapter.setOnItemChildLongClick(view, bindingAdapterPosition - baseQuickAdapter.getHeaderLayoutCount());
    }

    /* access modifiers changed from: protected */
    public void setOnItemClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "v");
        OnItemClickListener onItemClickListener = this.mOnItemClickListener;
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(this, view, i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean setOnItemLongClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "v");
        OnItemLongClickListener onItemLongClickListener = this.mOnItemLongClickListener;
        if (onItemLongClickListener != null) {
            return onItemLongClickListener.onItemLongClick(this, view, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setOnItemChildClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "v");
        OnItemChildClickListener onItemChildClickListener = this.mOnItemChildClickListener;
        if (onItemChildClickListener != null) {
            onItemChildClickListener.onItemChildClick(this, view, i);
        }
    }

    /* access modifiers changed from: protected */
    public boolean setOnItemChildLongClick(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "v");
        OnItemChildLongClickListener onItemChildLongClickListener = this.mOnItemChildLongClickListener;
        if (onItemChildLongClickListener != null) {
            return onItemChildLongClickListener.onItemChildLongClick(this, view, i);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public int getDefItemCount() {
        return this.data.size();
    }

    /* access modifiers changed from: protected */
    public int getDefItemViewType(int i) {
        return super.getItemViewType(i);
    }

    /* access modifiers changed from: protected */
    public VH onCreateDefViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return createBaseViewHolder(viewGroup, this.layoutResId);
    }

    /* access modifiers changed from: protected */
    public VH createBaseViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return createBaseViewHolder(AdapterUtilsKt.getItemView(viewGroup, i));
    }

    /* access modifiers changed from: protected */
    public VH createBaseViewHolder(View view) {
        VH vh;
        Intrinsics.checkNotNullParameter(view, "view");
        Class cls = getClass();
        Class<?> cls2 = null;
        while (cls2 == null && cls != null) {
            cls2 = getInstancedGenericKClass(cls);
            cls = cls.getSuperclass();
        }
        if (cls2 == null) {
            vh = new BaseViewHolder(view);
        } else {
            vh = createBaseGenericKInstance(cls2, view);
        }
        return vh == null ? new BaseViewHolder(view) : vh;
    }

    private final Class<?> getInstancedGenericKClass(Class<?> cls) {
        try {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                return null;
            }
            Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
            Intrinsics.checkNotNull(actualTypeArguments);
            for (Type type : actualTypeArguments) {
                if (type instanceof Class) {
                    if (BaseViewHolder.class.isAssignableFrom((Class) type)) {
                        return (Class) type;
                    }
                } else if (type instanceof ParameterizedType) {
                    Type rawType = ((ParameterizedType) type).getRawType();
                    if ((rawType instanceof Class) && BaseViewHolder.class.isAssignableFrom((Class) rawType)) {
                        return (Class) rawType;
                    }
                } else {
                    continue;
                }
            }
            return null;
        } catch (GenericSignatureFormatError e) {
            e.printStackTrace();
            return null;
        } catch (TypeNotPresentException e2) {
            e2.printStackTrace();
            return null;
        } catch (MalformedParameterizedTypeException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    private final VH createBaseGenericKInstance(Class<?> cls, View view) {
        try {
            if (cls.isMemberClass()) {
                if (!Modifier.isStatic(cls.getModifiers())) {
                    Constructor<?> declaredConstructor = cls.getDeclaredConstructor(new Class[]{getClass(), View.class});
                    Intrinsics.checkNotNullExpressionValue(declaredConstructor, "getDeclaredConstructor(...)");
                    declaredConstructor.setAccessible(true);
                    VH newInstance = declaredConstructor.newInstance(new Object[]{this, view});
                    Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type VH of com.microtech.aidexx.utils.adapter.BaseQuickAdapter");
                    return (BaseViewHolder) newInstance;
                }
            }
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(new Class[]{View.class});
            Intrinsics.checkNotNullExpressionValue(declaredConstructor2, "getDeclaredConstructor(...)");
            declaredConstructor2.setAccessible(true);
            VH newInstance2 = declaredConstructor2.newInstance(new Object[]{view});
            Intrinsics.checkNotNull(newInstance2, "null cannot be cast to non-null type VH of com.microtech.aidexx.utils.adapter.BaseQuickAdapter");
            return (BaseViewHolder) newInstance2;
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return null;
        } catch (InstantiationException e3) {
            e3.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void setFullSpan(RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        ViewGroup.LayoutParams layoutParams = viewHolder.itemView.getLayoutParams();
        if (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams) {
            ((StaggeredGridLayoutManager.LayoutParams) layoutParams).setFullSpan(true);
        }
    }

    public final View getViewByPosition(int i, int i2) {
        BaseViewHolder baseViewHolder;
        RecyclerView recyclerView = this.recyclerViewOrNull;
        if (recyclerView == null || (baseViewHolder = (BaseViewHolder) recyclerView.findViewHolderForLayoutPosition(i)) == null) {
            return null;
        }
        return baseViewHolder.getViewOrNull(i2);
    }

    public static /* synthetic */ int addHeaderView$default(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return baseQuickAdapter.addHeaderView(view, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
    }

    public final int addHeaderView(View view, int i, int i2) {
        int headerViewPosition;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = null;
        if (this.mHeaderLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.mHeaderLayout = linearLayout2;
            linearLayout2.setOrientation(i2);
            LinearLayout linearLayout3 = this.mHeaderLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                linearLayout3 = null;
            }
            if (i2 == 1) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout3.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout4 = this.mHeaderLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        LinearLayout linearLayout5 = this.mHeaderLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i);
        LinearLayout linearLayout6 = this.mHeaderLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (headerViewPosition = getHeaderViewPosition()) != -1) {
            notifyItemInserted(headerViewPosition);
        }
        return i;
    }

    public static /* synthetic */ int setHeaderView$default(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return baseQuickAdapter.setHeaderView(view, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
    }

    public final int setHeaderView(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i) {
                LinearLayout linearLayout3 = this.mHeaderLayout;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i);
                LinearLayout linearLayout4 = this.mHeaderLayout;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i);
                return i;
            }
        }
        return addHeaderView(view, i, i2);
    }

    public final boolean hasHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final void removeHeaderView(View view) {
        int headerViewPosition;
        Intrinsics.checkNotNullParameter(view, "header");
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeView(view);
            LinearLayout linearLayout3 = this.mHeaderLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() == 0 && (headerViewPosition = getHeaderViewPosition()) != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public final void removeAllHeaderView() {
        if (hasHeaderLayout()) {
            LinearLayout linearLayout = this.mHeaderLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int headerViewPosition = getHeaderViewPosition();
            if (headerViewPosition != -1) {
                notifyItemRemoved(headerViewPosition);
            }
        }
    }

    public final int getHeaderViewPosition() {
        if (!hasEmptyView() || this.headerWithEmptyEnable) {
            return 0;
        }
        return -1;
    }

    public final int getHeaderLayoutCount() {
        return hasHeaderLayout() ? 1 : 0;
    }

    public final LinearLayout getHeaderLayout() {
        LinearLayout linearLayout = this.mHeaderLayout;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeaderLayout");
        }
        return null;
    }

    public static /* synthetic */ int addFooterView$default(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = -1;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return baseQuickAdapter.addFooterView(view, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
    }

    public final int addFooterView(View view, int i, int i2) {
        int footerViewPosition;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = null;
        if (this.mFooterLayout == null) {
            LinearLayout linearLayout2 = new LinearLayout(view.getContext());
            this.mFooterLayout = linearLayout2;
            linearLayout2.setOrientation(i2);
            LinearLayout linearLayout3 = this.mFooterLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout3 = null;
            }
            if (i2 == 1) {
                layoutParams = new RecyclerView.LayoutParams(-1, -2);
            } else {
                layoutParams = new RecyclerView.LayoutParams(-2, -1);
            }
            linearLayout3.setLayoutParams(layoutParams);
        }
        LinearLayout linearLayout4 = this.mFooterLayout;
        if (linearLayout4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout4 = null;
        }
        int childCount = linearLayout4.getChildCount();
        if (i < 0 || i > childCount) {
            i = childCount;
        }
        LinearLayout linearLayout5 = this.mFooterLayout;
        if (linearLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout5 = null;
        }
        linearLayout5.addView(view, i);
        LinearLayout linearLayout6 = this.mFooterLayout;
        if (linearLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
        } else {
            linearLayout = linearLayout6;
        }
        if (linearLayout.getChildCount() == 1 && (footerViewPosition = getFooterViewPosition()) != -1) {
            notifyItemInserted(footerViewPosition);
        }
        return i;
    }

    public static /* synthetic */ int setFooterView$default(BaseQuickAdapter baseQuickAdapter, View view, int i, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = 1;
            }
            return baseQuickAdapter.setFooterView(view, i, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
    }

    public final int setFooterView(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout = null;
            }
            if (linearLayout.getChildCount() > i) {
                LinearLayout linearLayout3 = this.mFooterLayout;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                    linearLayout3 = null;
                }
                linearLayout3.removeViewAt(i);
                LinearLayout linearLayout4 = this.mFooterLayout;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                } else {
                    linearLayout2 = linearLayout4;
                }
                linearLayout2.addView(view, i);
                return i;
            }
        }
        return addFooterView(view, i, i2);
    }

    public final void removeFooterView(View view) {
        int footerViewPosition;
        Intrinsics.checkNotNullParameter(view, "footer");
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            LinearLayout linearLayout2 = null;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeView(view);
            LinearLayout linearLayout3 = this.mFooterLayout;
            if (linearLayout3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            } else {
                linearLayout2 = linearLayout3;
            }
            if (linearLayout2.getChildCount() == 0 && (footerViewPosition = getFooterViewPosition()) != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public final void removeAllFooterView() {
        if (hasFooterLayout()) {
            LinearLayout linearLayout = this.mFooterLayout;
            if (linearLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
                linearLayout = null;
            }
            linearLayout.removeAllViews();
            int footerViewPosition = getFooterViewPosition();
            if (footerViewPosition != -1) {
                notifyItemRemoved(footerViewPosition);
            }
        }
    }

    public final boolean hasFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout == null) {
            return false;
        }
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
            linearLayout = null;
        }
        return linearLayout.getChildCount() > 0;
    }

    public final int getFooterViewPosition() {
        if (!hasEmptyView()) {
            return getHeaderLayoutCount() + this.data.size();
        }
        int i = (!this.headerWithEmptyEnable || !hasHeaderLayout()) ? 1 : 2;
        if (this.footerWithEmptyEnable) {
            return i;
        }
        return -1;
    }

    public final int getFooterLayoutCount() {
        return hasFooterLayout() ? 1 : 0;
    }

    public final LinearLayout getFooterLayout() {
        LinearLayout linearLayout = this.mFooterLayout;
        if (linearLayout != null) {
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mFooterLayout");
        }
        return null;
    }

    public final void setEmptyView(View view) {
        boolean z;
        ViewGroup.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(view, "emptyView");
        int itemCount = getItemCount();
        int i = 1;
        FrameLayout frameLayout = null;
        if (this.mEmptyLayout == null) {
            FrameLayout frameLayout2 = new FrameLayout(view.getContext());
            this.mEmptyLayout = frameLayout2;
            ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams = new ViewGroup.LayoutParams(layoutParams2.width, layoutParams2.height);
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            frameLayout2.setLayoutParams(layoutParams);
            z = true;
        } else {
            ViewGroup.LayoutParams layoutParams3 = view.getLayoutParams();
            if (layoutParams3 != null) {
                FrameLayout frameLayout3 = this.mEmptyLayout;
                if (frameLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout3 = null;
                }
                ViewGroup.LayoutParams layoutParams4 = frameLayout3.getLayoutParams();
                layoutParams4.width = layoutParams3.width;
                layoutParams4.height = layoutParams3.height;
                FrameLayout frameLayout4 = this.mEmptyLayout;
                if (frameLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                    frameLayout4 = null;
                }
                frameLayout4.setLayoutParams(layoutParams4);
            }
            z = false;
        }
        FrameLayout frameLayout5 = this.mEmptyLayout;
        if (frameLayout5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
            frameLayout5 = null;
        }
        frameLayout5.removeAllViews();
        FrameLayout frameLayout6 = this.mEmptyLayout;
        if (frameLayout6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        } else {
            frameLayout = frameLayout6;
        }
        frameLayout.addView(view);
        this.isUseEmpty = true;
        if (z && hasEmptyView()) {
            if (!this.headerWithEmptyEnable || !hasHeaderLayout()) {
                i = 0;
            }
            if (getItemCount() > itemCount) {
                notifyItemInserted(i);
            } else {
                notifyDataSetChanged();
            }
        }
    }

    public final void setEmptyView(int i) {
        RecyclerView recyclerView = this.recyclerViewOrNull;
        if (recyclerView != null) {
            View inflate = LayoutInflater.from(recyclerView.getContext()).inflate(i, recyclerView, false);
            Intrinsics.checkNotNull(inflate);
            setEmptyView(inflate);
        }
    }

    public final void removeEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                frameLayout = null;
            }
            frameLayout.removeAllViews();
        }
    }

    public final boolean hasEmptyView() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
                frameLayout = null;
            }
            if (frameLayout.getChildCount() != 0 && this.isUseEmpty) {
                return this.data.isEmpty();
            }
            return false;
        }
        return false;
    }

    public final FrameLayout getEmptyLayout() {
        FrameLayout frameLayout = this.mEmptyLayout;
        if (frameLayout != null) {
            if (frameLayout != null) {
                return frameLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mEmptyLayout");
        }
        return null;
    }

    private final void addAnimation(RecyclerView.ViewHolder viewHolder) {
        if (!this.animationEnable) {
            return;
        }
        if (!this.isAnimationFirstOnly || viewHolder.getLayoutPosition() > this.mLastPosition) {
            BaseAnimation baseAnimation = this.adapterAnimation;
            if (baseAnimation == null) {
                baseAnimation = new AlphaInAnimation(0.0f, 1, (DefaultConstructorMarker) null);
            }
            View view = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            for (Animator startAnim : baseAnimation.animators(view)) {
                startAnim(startAnim, viewHolder.getLayoutPosition());
            }
            this.mLastPosition = viewHolder.getLayoutPosition();
        }
    }

    /* access modifiers changed from: protected */
    public void startAnim(Animator animator, int i) {
        Intrinsics.checkNotNullParameter(animator, "anim");
        animator.start();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/microtech/aidexx/utils/adapter/BaseQuickAdapter$AnimationType;", "", "(Ljava/lang/String;I)V", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "app_gpGrxMmolRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* compiled from: BaseQuickAdapter.kt */
    public enum AnimationType {
        AlphaIn,
        ScaleIn,
        SlideInBottom,
        SlideInLeft,
        SlideInRight;

        public static EnumEntries<AnimationType> getEntries() {
            return $ENTRIES;
        }

        static {
            AnimationType[] $values;
            $ENTRIES = EnumEntriesKt.enumEntries((E[]) (Enum[]) $values);
        }
    }

    public final void setAnimationWithDefault(AnimationType animationType) {
        BaseAnimation baseAnimation;
        Intrinsics.checkNotNullParameter(animationType, "animationType");
        int i = WhenMappings.$EnumSwitchMapping$0[animationType.ordinal()];
        if (i == 1) {
            baseAnimation = new AlphaInAnimation(0.0f, 1, (DefaultConstructorMarker) null);
        } else if (i == 2) {
            baseAnimation = new ScaleInAnimation(0.0f, 1, (DefaultConstructorMarker) null);
        } else if (i == 3) {
            baseAnimation = new SlideInBottomAnimation();
        } else if (i == 4) {
            baseAnimation = new SlideInLeftAnimation();
        } else if (i == 5) {
            baseAnimation = new SlideInRightAnimation();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        setAdapterAnimation(baseAnimation);
    }

    @Deprecated(message = "Please use setNewInstance(), This method will be removed in the next version", replaceWith = @ReplaceWith(expression = "setNewInstance(data)", imports = {}))
    public void setNewData(List<T> list) {
        setNewInstance(list);
    }

    public void setNewInstance(List<T> list) {
        if (list != this.data) {
            if (list == null) {
                list = new ArrayList<>();
            }
            this.data = list;
            BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
            if (baseLoadMoreModule != null) {
                baseLoadMoreModule.reset$app_gpGrxMmolRelease();
            }
            this.mLastPosition = -1;
            notifyDataSetChanged();
            BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
            if (baseLoadMoreModule2 != null) {
                baseLoadMoreModule2.checkDisableLoadMoreIfNotFullPage();
            }
        }
    }

    @Deprecated(message = "Please use setData()", replaceWith = @ReplaceWith(expression = "setList(newData)", imports = {}))
    public void replaceData(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "newData");
        setList(collection);
    }

    public void setList(Collection<? extends T> collection) {
        List<T> list = this.data;
        if (collection != list) {
            list.clear();
            if (collection != null && !collection.isEmpty()) {
                this.data.addAll(collection);
            }
        } else if (collection == null || collection.isEmpty()) {
            this.data.clear();
        } else {
            ArrayList arrayList = new ArrayList(collection);
            this.data.clear();
            this.data.addAll(arrayList);
        }
        BaseLoadMoreModule baseLoadMoreModule = this.mLoadMoreModule;
        if (baseLoadMoreModule != null) {
            baseLoadMoreModule.reset$app_gpGrxMmolRelease();
        }
        this.mLastPosition = -1;
        notifyDataSetChanged();
        BaseLoadMoreModule baseLoadMoreModule2 = this.mLoadMoreModule;
        if (baseLoadMoreModule2 != null) {
            baseLoadMoreModule2.checkDisableLoadMoreIfNotFullPage();
        }
    }

    public void setData(int i, T t) {
        if (i < this.data.size()) {
            this.data.set(i, t);
            notifyItemChanged(i + getHeaderLayoutCount());
        }
    }

    public void addData(int i, T t) {
        this.data.add(i, t);
        notifyItemInserted(i + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(T t) {
        this.data.add(t);
        notifyItemInserted(this.data.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void addData(int i, Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "newData");
        this.data.addAll(i, collection);
        notifyItemRangeInserted(i + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    public void addData(Collection<? extends T> collection) {
        Intrinsics.checkNotNullParameter(collection, "newData");
        this.data.addAll(collection);
        notifyItemRangeInserted((this.data.size() - collection.size()) + getHeaderLayoutCount(), collection.size());
        compatibilityDataSizeChanged(collection.size());
    }

    @Deprecated(message = "Please use removeAt()", replaceWith = @ReplaceWith(expression = "removeAt(position)", imports = {}))
    public void remove(int i) {
        removeAt(i);
    }

    public void removeAt(int i) {
        if (i < this.data.size()) {
            this.data.remove(i);
            int headerLayoutCount = i + getHeaderLayoutCount();
            notifyItemRemoved(headerLayoutCount);
            compatibilityDataSizeChanged(0);
            notifyItemRangeChanged(headerLayoutCount, this.data.size() - headerLayoutCount);
        }
    }

    public void remove(T t) {
        int indexOf = this.data.indexOf(t);
        if (indexOf != -1) {
            removeAt(indexOf);
        }
    }

    /* access modifiers changed from: protected */
    public final void compatibilityDataSizeChanged(int i) {
        if (this.data.size() == i) {
            notifyDataSetChanged();
        }
    }

    public final void setDiffCallback(DiffUtil.ItemCallback<T> itemCallback) {
        Intrinsics.checkNotNullParameter(itemCallback, "diffCallback");
        setDiffConfig(new BrvahAsyncDifferConfig.Builder(itemCallback).build());
    }

    public final void setDiffConfig(BrvahAsyncDifferConfig<T> brvahAsyncDifferConfig) {
        Intrinsics.checkNotNullParameter(brvahAsyncDifferConfig, "config");
        this.mDiffHelper = new BrvahAsyncDiffer<>(this, brvahAsyncDifferConfig);
    }

    @Deprecated(message = "User getDiffer()", replaceWith = @ReplaceWith(expression = "getDiffer()", imports = {}))
    public final BrvahAsyncDiffer<T> getDiffHelper() {
        return getDiffer();
    }

    public final BrvahAsyncDiffer<T> getDiffer() {
        BrvahAsyncDiffer<T> brvahAsyncDiffer = this.mDiffHelper;
        if (brvahAsyncDiffer != null) {
            Intrinsics.checkNotNull(brvahAsyncDiffer);
            return brvahAsyncDiffer;
        }
        throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!".toString());
    }

    public static /* synthetic */ void setDiffNewData$default(BaseQuickAdapter baseQuickAdapter, List list, Runnable runnable, int i, Object obj) {
        if (obj == null) {
            if ((i & 2) != 0) {
                runnable = null;
            }
            baseQuickAdapter.setDiffNewData(list, runnable);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDiffNewData");
    }

    public void setDiffNewData(List<T> list, Runnable runnable) {
        if (hasEmptyView()) {
            setNewInstance(list);
            if (runnable != null) {
                runnable.run();
                return;
            }
            return;
        }
        BrvahAsyncDiffer<T> brvahAsyncDiffer = this.mDiffHelper;
        if (brvahAsyncDiffer != null) {
            brvahAsyncDiffer.submitList(list, runnable);
        }
    }

    public void setDiffNewData(DiffUtil.DiffResult diffResult, List<T> list) {
        Intrinsics.checkNotNullParameter(diffResult, "diffResult");
        Intrinsics.checkNotNullParameter(list, "list");
        if (hasEmptyView()) {
            setNewInstance(list);
            return;
        }
        diffResult.dispatchUpdatesTo((ListUpdateCallback) new BrvahListUpdateCallback(this));
        this.data = list;
    }

    public final void setGridSpanSizeLookup(GridSpanSizeLookup gridSpanSizeLookup) {
        this.mSpanSizeLookup = gridSpanSizeLookup;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }

    public final void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.mOnItemLongClickListener = onItemLongClickListener;
    }

    public final void setOnItemChildClickListener(OnItemChildClickListener onItemChildClickListener) {
        this.mOnItemChildClickListener = onItemChildClickListener;
    }

    public final void setOnItemChildLongClickListener(OnItemChildLongClickListener onItemChildLongClickListener) {
        this.mOnItemChildLongClickListener = onItemChildLongClickListener;
    }

    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }
}
