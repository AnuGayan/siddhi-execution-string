/*
 * Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * WSO2 Inc. licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License.
 * you may obtain a copy of the License at
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
package io.siddhi.extension.execution.string.substrexecutors;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Type4Executor returns the input subsequence captured by the
 * given group during the match operation executed according to
 * given regex.
 *
 * str:substr([string sourceText] , [string regex], [int groupNumber]).
 */
public class Type4Executor extends SubstrExecutor<String, Integer> {

    public Type4Executor() {
        super();
    }

    public Type4Executor(Pattern pattern) {
        super(pattern);
    }

    @Override
    public boolean canIgnoreArg2() {
        return false;
    }

    @Override
    public String execute(String source, String regex, Integer groupNo) {
        Pattern pattern = (hasPattern()) ? super.pattern : Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);
        return (matcher.find()) ? matcher.group(groupNo) : "";
    }
}
