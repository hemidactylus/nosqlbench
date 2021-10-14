package io.nosqlbench.engine.shutdown;

import com.codahale.metrics.MetricRegistry;
import org.apache.logging.log4j.Logger;

import javax.script.ScriptContext;
import java.util.function.Function;

public class ShutdownHookPlugin {
    private final Logger logger;
    private final MetricRegistry metricRegistry;
    private final ScriptContext scriptContext;

    public ShutdownHookPlugin(Logger logger, MetricRegistry metricRegistry, ScriptContext scriptContext) {

        this.logger = logger;
        this.metricRegistry = metricRegistry;
        this.scriptContext = scriptContext;
    }

    public void addShutdownHook(String name, Object f) {
        if (!(f instanceof Function)) {
            throw new RuntimeException("The object provided to the shutdown hook plugin was not recognized as a function.");
        }
        String shutdownName = "shutdown-function-" + name;
        Thread runnable = new ShutdownRunnableFunction(logger, name, (Function<?,?>)f);
        runnable.setName(shutdownName);
        Runtime.getRuntime().addShutdownHook(runnable);
        logger.info("Registered shutdown hook to run under name '" + shutdownName + "'");

    }
}