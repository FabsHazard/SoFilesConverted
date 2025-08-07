package com.huawei.hms.mlsdk.common;

import com.huawei.hms.mlsdk.common.internal.client.event.MonitorEvent;
import com.huawei.hms.mlsdk.common.internal.client.event.MonitorResult;

public interface AnalyzerMonitor {
    MonitorResult receive(MonitorEvent monitorEvent);
}
