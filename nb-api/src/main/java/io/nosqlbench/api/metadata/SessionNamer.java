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

package io.nosqlbench.api.metadata;

import java.util.Arrays;

public class SessionNamer {

    public static String format(String sessionName, long sessionTimeMillis) {
        String nameTemplate = sessionName;
        if (nameTemplate==null || nameTemplate.isEmpty()) {
            nameTemplate = "scenario_%tY%tm%td_%tH%tM%tS_%tL";
        }

        int splits = nameTemplate.split("%").length -1;
        Long[] times = new Long[splits];
        Arrays.fill(times, sessionTimeMillis);

        sessionName = String.format(nameTemplate, (Object[]) times);

        return sessionName;
    }

    public static String format(String sessionName) {
        return format(sessionName, System.currentTimeMillis());
    }
}
