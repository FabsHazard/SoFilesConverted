package com.jeremyliao.liveeventbus.core;

public final class Console {
    private Console() {
    }

    public static String getInfo() {
        return LiveEventBusCore.get().console.getConsoleInfo();
    }
}
