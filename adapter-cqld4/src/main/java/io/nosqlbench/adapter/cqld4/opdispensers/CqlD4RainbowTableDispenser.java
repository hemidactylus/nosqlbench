/*
 * Copyright (c) 2022 nosqlbench
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.nosqlbench.adapter.cqld4.opdispensers;

import com.datastax.oss.driver.api.core.CqlSession;
import io.nosqlbench.adapter.cqld4.optypes.Cqld4CqlOp;
import io.nosqlbench.engine.api.activityimpl.uniform.DriverAdapter;
import io.nosqlbench.engine.api.templating.ParsedOp;

import java.util.function.LongFunction;

public class CqlD4RainbowTableDispenser extends Cqld4BaseOpDispenser {

//    private final LongFunction<Statement> stmtFunc;
    private final LongFunction<String> targetFunction;

    public CqlD4RainbowTableDispenser(DriverAdapter adapter, LongFunction<CqlSession> sessionFunc, LongFunction<String> targetFunction, ParsedOp cmd) {
        super(adapter, sessionFunc,cmd);
        this.targetFunction=targetFunction;
//        this.tableFunc =createTableFunc(cmd);
    }

    @Override
    public Cqld4CqlOp apply(long cycle) {
        throw new RuntimeException("implement me");
//        return new Cqld4RainbowTableOp(
//            getSessionFunc().apply(value),
//            (RainbowTable) stmtFunc.apply(value),
//            getMaxPages(),
//            isRetryReplace()
//        );
    }

}
