package com.huawei.hms.hmsscankit;

import com.huawei.hms.ml.scan.HmsScan;

public interface OnResultCallback {
    void onResult(HmsScan[] hmsScanArr);
}
