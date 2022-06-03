package io.nosqlbench.activitytype.cql.statements.rsoperators;

/*
 * Copyright (c) 2022 nosqlbench
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */


import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Statement;
import io.nosqlbench.activitytype.cql.api.ResultSetCycleOperator;
import io.nosqlbench.virtdata.library.basics.core.threadstate.SharedState;

import java.util.HashMap;

public class PopVars implements ResultSetCycleOperator {

    @Override
    public int apply(ResultSet resultSet, Statement statement, long cycle) {
        HashMap<String, Object> stringObjectHashMap = SharedState.tl_ObjectMap.get();
        Object o = SharedState.tl_ObjectStack.get().pollLast();
        if (o != null && o instanceof HashMap) {
            SharedState.tl_ObjectMap.set((HashMap) o);
            return 0;
        } else {
            throw new RuntimeException("Tried to pop thread local data from stack, but there was none.");
        }
    }
}