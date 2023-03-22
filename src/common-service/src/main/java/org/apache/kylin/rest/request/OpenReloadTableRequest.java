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

package org.apache.kylin.rest.request;

import org.apache.kylin.job.dao.ExecutablePO;
import org.apache.kylin.metadata.insensitive.ProjectInsensitiveRequest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class OpenReloadTableRequest implements ProjectInsensitiveRequest {
    @JsonProperty("project")
    private String project;
    @JsonProperty("table")
    private String table;
    @JsonProperty("s3_table_ext_info")
    private S3TableExtInfo s3TableExtInfo;
    @JsonProperty("need_sampling")
    private Boolean needSampling;
    @JsonProperty("sampling_rows")
    private int samplingRows;
    @JsonProperty("need_building")
    private Boolean needBuilding = false;
    private int priority = ExecutablePO.DEFAULT_PRIORITY;
    @JsonProperty("yarn_queue")
    private String yarnQueue;
}
