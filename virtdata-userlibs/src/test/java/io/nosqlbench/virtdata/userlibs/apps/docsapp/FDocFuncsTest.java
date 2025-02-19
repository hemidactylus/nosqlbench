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

package io.nosqlbench.virtdata.userlibs.apps.docsapp;

import io.nosqlbench.virtdata.userlibs.apps.docsapp.fdocs.ExampleDocFunc1;
import io.nosqlbench.virtdata.userlibs.apps.docsapp.fdocs.ExampleDocFunc2;
import io.nosqlbench.virtdata.userlibs.apps.docsapp.fdocs.FDocFunc;
import io.nosqlbench.virtdata.userlibs.apps.docsapp.fdocs.FDocFuncs;
import org.junit.jupiter.api.Test;

public class FDocFuncsTest {

    @Test
    public void testMarkdownFormat() {
        ExampleDocFunc1 exampleDocData1 = new ExampleDocFunc1();
        ExampleDocFunc2 exampleDocData2 = new ExampleDocFunc2();
        FDocFuncs funcs = new FDocFuncs(exampleDocData1.getClassName());

        funcs.addFunctionDoc(new FDocFunc(exampleDocData1));
        funcs.addFunctionDoc(new FDocFunc(exampleDocData2));

        String out = funcs.asMarkdown();
        System.out.print(out);
    }

}
