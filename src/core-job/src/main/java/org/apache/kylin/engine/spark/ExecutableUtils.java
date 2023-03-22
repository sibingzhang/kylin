/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.kylin.engine.spark;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.kylin.common.KylinConfig;
import org.apache.kylin.common.persistence.ResourceStore;
import org.apache.kylin.job.execution.AbstractExecutable;
import org.apache.kylin.metadata.cube.model.NBatchConstants;

public class ExecutableUtils {

    private ExecutableUtils() {}

    public static ResourceStore getRemoteStore(KylinConfig config, AbstractExecutable buildTask) {
        String buildStepUrl = buildTask.getParam(NBatchConstants.P_OUTPUT_META_URL);

        KylinConfig buildConfig = KylinConfig.createKylinConfig(config);
        buildConfig.setMetadataUrl(buildStepUrl);
        return ResourceStore.getKylinMetaStore(buildConfig);
    }

    public static String getDataflowId(AbstractExecutable buildTask) {
        return buildTask.getParam(NBatchConstants.P_DATAFLOW_ID);
    }

    public static Set<String> getSegmentIds(AbstractExecutable buildTask) {
        return Stream.of(StringUtils.split(buildTask.getParam(NBatchConstants.P_SEGMENT_IDS), ","))
                .collect(Collectors.toSet());
    }

    public static Set<Long> getLayoutIds(AbstractExecutable buildTask) {
        return Stream.of(StringUtils.split(buildTask.getParam(NBatchConstants.P_LAYOUT_IDS), ",")).map(Long::parseLong)
                .collect(Collectors.toSet());

    }

    public static Set<Long> getPartitionIds(AbstractExecutable buildTask) {
        if (CollectionUtils.isEmpty(buildTask.getTargetPartitions())) {
            return new HashSet<>();
        }
        return buildTask.getTargetPartitions();
    }

}
