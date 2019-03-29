/*
 *  Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.scenario.test.database.util;

import org.ballerinalang.model.values.BError;
import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.model.values.BMap;
import org.ballerinalang.model.values.BValue;
import org.testng.Assert;

/**
 * Provides utility methods used for test assertion.
 */
public class AssertionUtil {

    public static void assertUpdateQueryReturnValue(BValue returnedVal, int expectedUpdatedRowCount) {
        Assert.assertTrue(returnedVal instanceof BMap, returnedVal instanceof BError ?
                getErrorReturnedAssertionMessage((BError) returnedVal) :
                "Return type invalid");
        Assert.assertEquals(((BInteger) ((BMap) returnedVal).get("updatedRowCount")).intValue(),
                expectedUpdatedRowCount);
    }

    public static String getIncorrectColumnValueMessage(String column) {
        return column + " column value isn't correct";
    }

    private static String getErrorReturnedAssertionMessage(BError error) {
        return "The returned value is of error type. Error message: " + error.getDetails().stringValue();
    }
}
