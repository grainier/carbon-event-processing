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
package org.wso2.carbon.event.processor.core.internal.listener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.wso2.carbon.event.processor.core.ExecutionPlanConfiguration;
import org.wso2.carbon.event.processor.core.internal.ds.EventProcessorValueHolder;
import org.wso2.carbon.event.processor.core.internal.util.EventProcessorConstants;
import org.wso2.carbon.event.statistics.EventStatisticsMonitor;
import org.wso2.carbon.event.stream.core.SiddhiEventConsumer;
import org.wso2.carbon.metrics.manager.Counter;
import org.wso2.carbon.metrics.manager.Level;
import org.wso2.carbon.metrics.manager.MetricManager;
import org.wso2.siddhi.core.event.Event;

import java.util.Arrays;

/**
 * Abstract class for classes which feeds incoming events to Siddhi.
 */
public abstract class AbstractSiddhiInputEventDispatcher implements SiddhiEventConsumer {
    private Logger trace = Logger.getLogger(EventProcessorConstants.EVENT_TRACE_LOGGER);
    private static Log log = LogFactory.getLog(AbstractSiddhiInputEventDispatcher.class);

    protected final String streamId;
    protected String siddhiStreamId;
    protected Object owner;
    protected final int tenantId;
    private final boolean traceEnabled;
    private final boolean statisticsEnabled;
    private EventStatisticsMonitor statisticsMonitor;
    private Counter eventCounter;
    private String tracerPrefix = "";
    private final String metricId;

    public AbstractSiddhiInputEventDispatcher(String streamId, String siddhiStreamId, ExecutionPlanConfiguration executionPlanConfiguration, int tenantId) {
        this.streamId = streamId;
        this.siddhiStreamId = siddhiStreamId;
        this.owner = executionPlanConfiguration;
        this.tenantId = tenantId;
        this.traceEnabled = executionPlanConfiguration.isTracingEnabled();
        this.statisticsEnabled = executionPlanConfiguration.isStatisticsEnabled();
        this.metricId = EventProcessorConstants.METRICS_ROOT + "." + EventProcessorConstants.METRICS_EXECUTION_PLANS + "[+]." + executionPlanConfiguration.getName() + "[+]." + siddhiStreamId + ".in-events";
        if (statisticsEnabled) {
            statisticsMonitor = EventProcessorValueHolder.getEventStatisticsService().getEventStatisticMonitor(tenantId, EventProcessorConstants.EVENT_PROCESSOR, executionPlanConfiguration.getName(), streamId + " (" + siddhiStreamId + ")");
            eventCounter = MetricManager.counter(this.metricId, Level.INFO, Level.INFO, Level.INFO);
        }
        if (traceEnabled) {
            this.tracerPrefix = "TenantId : " + tenantId + ", " + EventProcessorConstants.EVENT_PROCESSOR + " : " + executionPlanConfiguration.getName() + ", " + EventProcessorConstants.EVENT_STREAM + " : " + streamId + " (" + siddhiStreamId + "), before processing " + System.getProperty("line.separator");
        }
    }

    @Override
    public String getStreamId() {
        return streamId;
    }

    @Override
    public void consumeEvents(Event[] events) {
        if (traceEnabled) {
            trace.info(tracerPrefix + Arrays.deepToString(events));
        }
        for (Event event : events) {
            try {
                if (statisticsEnabled) {
                    statisticsMonitor.incrementRequest();
                    eventCounter.inc();
                }
                sendEvent(event);
            } catch (InterruptedException e) {
                log.error("Error in dispatching events " + Arrays.deepToString(events) + " to Siddhi stream :" + siddhiStreamId);
            }
        }
    }

    @Override
    public void consumeEvent(Event event) {
        try {
            if (traceEnabled) {
                trace.info(tracerPrefix + event);
            }
            if (statisticsEnabled) {
                statisticsMonitor.incrementRequest();
                eventCounter.inc();
            }
            sendEvent(event);
        } catch (InterruptedException e) {
            log.error("Error in dispatching event " + event + " to Siddhi stream :" + siddhiStreamId);
        }
    }

    public String getExecutionPlanName() {
        return ((ExecutionPlanConfiguration) owner).getName();
    }

    /**
     * When an event is received this method will be called. Implement how the event must be dispatched to Siddhi
     *
     * @param event Event object
     * @throws InterruptedException
     */
    public abstract void sendEvent(Event event) throws InterruptedException;

    public void shutdown() {

    }
}
