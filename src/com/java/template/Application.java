package com.java.template;

public abstract class Application {
    public final void start() {
        initialize();
        run();
        destroy();
    }

    protected abstract void initialize();

    protected abstract void run();

    protected abstract void destroy();
}
