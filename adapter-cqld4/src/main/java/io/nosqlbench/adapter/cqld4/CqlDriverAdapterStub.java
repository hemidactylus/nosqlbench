package io.nosqlbench.adapter.cqld4;

import io.nosqlbench.engine.api.activityimpl.OpMapper;
import io.nosqlbench.engine.api.activityimpl.uniform.DriverAdapter;
import io.nosqlbench.engine.api.activityimpl.uniform.flowtypes.Op;
import io.nosqlbench.nb.annotations.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service(value = DriverAdapter.class, selector = "cql")
public class CqlDriverAdapterStub extends Cqld4DriverAdapter {
    private final static Logger logger = LogManager.getLogger(CqlDriverAdapterStub.class);

    public CqlDriverAdapterStub() {
        super();
    }

    @Override
    public OpMapper<Op> getOpMapper() {
        logger.warn("This version of NoSQLBench uses the DataStax Java Driver version 4 for all CQL workloads. In this preview version, advanced testing features present in the previous cql and cqld3 drivers are being back-ported. If you need those features, please use only the release artifacts. To suppress this message, use driver=cqld4. This warning will be removed in a future version when all features are completely back-ported.");
        return super.getOpMapper();
    }
}