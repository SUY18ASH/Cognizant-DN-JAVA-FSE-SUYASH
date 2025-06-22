package com.example.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

public class Logger implements Serializable {

    private static boolean instanceCreated = false;

    private Logger() {
        if (instanceCreated) {
            throw new IllegalStateException("Logger instance already created");
        }
        instanceCreated = true;
    }

    private static class Holder {
        private static final Logger INSTANCE = new Logger();
    }

    public static Logger getInstance() {
        return Holder.INSTANCE;
    }

    public void log(String message) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + message);
    }

    private Object readResolve() throws ObjectStreamException {
        return Holder.INSTANCE;
    }
}
