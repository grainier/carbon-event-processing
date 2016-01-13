/*
 * Copyright (c) 2015, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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
package org.wso2.carbon.event.processor.core.internal.util;


public interface EventProcessorConstants {

    String EP_CONF_NS = "http://wso2.org/carbon/eventprocessor";

    String EP_PREFIX = "ep";
    String EP_ELE_ROOT_ELEMENT = "executionPlan";

    String EP_ELE_DESC = "description";
    String EP_ELE_SIDDHI_CONFIG = "siddhiConfiguration";
    String EP_ELE_IMP_STREAMS = "importedStreams";
    String EP_ELE_EXP_STREAMS = "exportedStreams";
    String EP_ELE_QUERIES = "queryExpressions";
    String EP_ELE_STREAM = "stream";
    String EP_ELE_PROPERTY = "property";
    String EP_ATTR_STATISTICS = "statistics";
    String EP_ATTR_TRACING = "trace";
    String EP_ENABLE = "enable";
    String EP_DISABLE = "disable";
    String EP_ATTR_PASSTHROUGH_FLOW = "passthroughFlow";


    // for inputs  - siddhi stream
    String EP_ATTR_AS = "as";
    // for outputs - siddhi stream
    String EP_ATTR_VALUEOF = "valueOf";

    String EP_ATTR_NAME = "name";
    String EP_ATTR_VERSION = "version";


    String STREAM_SEPARATOR = ":";
    String ATTRIBUTE_SEPARATOR = "_";

    String EVENT_TRACE_LOGGER = "EVENT_TRACE_LOGGER";

    String EP_ELE_DIRECTORY = "executionplans";
    String XML_EXTENSION = ".xml";
    String SIDDHIQL_EXTENSION = ".siddhiql";

    String EVENT_PROCESSOR = "Event Processor";
    String EVENT_STREAM = "Event Stream";

    String SIDDHI_DISTRIBUTED_PROCESSING = "siddhi.enable.distributed.processing";
    String SIDDHI_SNAPSHOT_INTERVAL = "siddhi.persistence.snapshot.time.interval.minutes";
    String EP_CONFIG_FILE_EXTENSION_WITH_DOT = ".siddhiql";

    String META = "meta";
    String CORRELATION = "correlation";
    String META_PREFIX = "meta_";
    String CORRELATION_PREFIX = "correlation_";

    String HAZELCAST_INSTANCE = "hazelcast.instance";

    String NO_DEPENDENCY_INFO_MSG = "No dependency information available for this event formatter";

    // for storm query plan builder
    String OPENING_BRACKETS = " ( ";
    String SPACE = " ";
    String COMMA = ", ";
    String CLOSING_BRACKETS = ");";
    String STORM_QUERY_PLAN = "storm-query-plan";
    String INPUT_STREAMS = "input-streams";
    String TABLE_DEFINITIONS = "table-definitions";
    String OUTPUT_STREAMS = "output-streams";
    String EVENT_PROCESSOR_TAG = "event-processor";
    String SIDDHI_BOLT = "SiddhiBolt";
    String QUERIES = "queries";
    String EVENT_RECEIVER = "event-receiver";
    String EVENT_RECEIVER_SPOUT = "EventReceiverSpout";
    String STREAMS = "streams";
    String STREAM = "stream";
    String DEFINE_STREAM = "define stream ";
    String EVENT_PUBLISHER = "event-publisher";
    String EVENT_PUBLISHER_BOLT = "EventPublisherBolt";
    String PARALLEL = "parallel";
    String RECEIVER_PARALLELISM = "receiverParallelism";
    String PUBLISHER_PARALLELISM = "publisherParallelism";
    String NAME = "name";
    String PARTITION = "partition";
    String DIST = "dist";
    String EXEC_GROUP = "execGroup";
    String ENFORCE_PARALLELISM = "enforceParallel";

    /*Annotations, Annotation Names and relevant tokens*/
    String ANNOTATION_PLAN = "Plan";
    String ANNOTATION_IMPORT = "Import";
    String ANNOTATION_EXPORT = "Export";

    String ANNOTATION_NAME_NAME = "name";
    String ANNOTATION_NAME_DESCRIPTION = "description";
    String ANNOTATION_NAME_TRACE = "trace";
    String ANNOTATION_NAME_STATISTICS = "statistics";

    String ANNOTATION_TOKEN_AT = "@";
    String ANNOTATION_TOKEN_COLON = ":";
    String ANNOTATION_TOKEN_OPENING_BRACKET = "(";
    String ANNOTATION_TOKEN_CLOSING_BRACKET = ")";

    String DATABRIDGE_STREAM_REGEX = "[a-zA-Z0-9_\\.]+";
    String STREAM_VER_REGEX = "([0-9]*)\\.([0-9]*)\\.([0-9]*)";

    //"Execution plan header" is the part above the Import/Export statements.

    //Following regex represents a line in an execution plan header
    String PLAN_HEADER_LINE_REGEX = "(^\\s*"+ ANNOTATION_TOKEN_AT + ANNOTATION_PLAN + ANNOTATION_TOKEN_COLON + ".*)|(^\\s*--.*)|(^\\s*\\/\\*.*\\*\\/\\s*)|(^\\s*)";

    String END_OF_PLAN_HEADER_COMMENT_REGEX = "^\\s*\\/\\* define streams and write query here ... \\*\\/\\s*";

    String SIDDHI_LINE_SEPARATER = "\n";
    String SIDDHI_SINGLE_QUOTE = "'";

    String METRICS_ROOT = "CEP";
    String METRICS_EXECUTION_PLANS = "ExecutionPlans";
}
