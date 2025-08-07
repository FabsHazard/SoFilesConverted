package com.huawei.hms.hmsscankit;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.huawei.hms.feature.dynamic.ObjectWrapper;
import com.huawei.hms.hmsscankit.api.IRemoteCreator;
import com.huawei.hms.hmsscankit.api.IRemoteHmsDecoderDelegate;
import com.huawei.hms.ml.scan.HmsScan;
import com.huawei.hms.ml.scan.HmsScanAnalyzerOptions;
import com.huawei.hms.ml.scan.HmsScanFrame;
import com.huawei.hms.mlsdk.common.MLFrame;
import com.huawei.hms.scankit.p.o4;
import com.huawei.hms.scankit.p.y3;
import java.nio.ByteBuffer;

/* compiled from: HmsRemoteDecoder */
class a {
    private static volatile IRemoteHmsDecoderDelegate a;

    static HmsScan[] a(Context context, MLFrame mLFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        DetailRect detailRect;
        HmsScan[] hmsScanArr;
        int i;
        o4.c("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr2 = new HmsScan[0];
        if (a == null) {
            IRemoteCreator c = f.c(context);
            if (c == null) {
                return hmsScanArr2;
            }
            try {
                a = c.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
        if (a != null) {
            try {
                if (mLFrame.acquireProperty() != null) {
                    detailRect = new DetailRect(mLFrame.acquireProperty().getWidth(), mLFrame.acquireProperty().getHeight());
                } else {
                    detailRect = new DetailRect();
                }
                Bundle bundle = new Bundle();
                if (!(hmsScanAnalyzerOptions == null || (i = hmsScanAnalyzerOptions.mode) == 0)) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, i);
                }
                bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putAll(y3.a(context));
                if (mLFrame.readBitmap() != null) {
                    o4.c("scankit mul", "end detectForHmsDector");
                    hmsScanArr = a.decodeInBitmap(detailRect, ObjectWrapper.wrap(mLFrame.readBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    hmsScanArr = a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(mLFrame.acquireGrayByteBuffer()), ObjectWrapper.wrap(bundle));
                }
                if (hmsScanArr != null) {
                    return hmsScanArr;
                }
            } catch (RemoteException unused2) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr2;
    }

    static HmsScan[] a(Context context, HmsScanFrame hmsScanFrame, HmsScanAnalyzerOptions hmsScanAnalyzerOptions) {
        HmsScan[] hmsScanArr;
        o4.c("scankit mul", "start detectForHmsDector");
        HmsScan[] hmsScanArr2 = new HmsScan[0];
        if (a == null) {
            IRemoteCreator c = f.c(context);
            if (c == null) {
                return hmsScanArr2;
            }
            try {
                a = c.newRemoteHmsDecoderDelegate();
            } catch (RemoteException unused) {
                o4.b("exception", "RemoteException");
            }
        }
        if (a != null) {
            try {
                DetailRect detailRect = new DetailRect(hmsScanFrame.getWidth(), hmsScanFrame.getHeight());
                Bundle bundle = new Bundle();
                if (hmsScanAnalyzerOptions != null) {
                    bundle.putInt(DetailRect.FORMAT_FLAG, hmsScanAnalyzerOptions.mode);
                    bundle.putBoolean(DetailRect.PARSE_RESULT, hmsScanAnalyzerOptions.parseResult);
                    bundle.putBoolean(DetailRect.PHOTO_MODE, hmsScanAnalyzerOptions.photoMode);
                }
                bundle.putInt(DetailRect.TYPE_TRANS, 3);
                bundle.putBoolean(DetailRect.NEW_VERSION, true);
                bundle.putString(DetailRect.CP_PACKAGE, y3.b(context));
                bundle.putAll(y3.a(context));
                if (hmsScanFrame.getBitmap() != null) {
                    o4.c("scankit mul", "end detectForHmsDector");
                    hmsScanArr = a.decodeInBitmap(detailRect, ObjectWrapper.wrap(hmsScanFrame.getBitmap()), ObjectWrapper.wrap(bundle));
                } else {
                    hmsScanArr = a.detectWithByteBuffer(detailRect, ObjectWrapper.wrap(ByteBuffer.wrap(hmsScanFrame.getYuvImage().getYuvData())), ObjectWrapper.wrap(bundle));
                }
                if (hmsScanArr != null) {
                    return hmsScanArr;
                }
            } catch (RemoteException unused2) {
                o4.b("exception", "RemoteException");
            }
        }
        return hmsScanArr2;
    }
}
