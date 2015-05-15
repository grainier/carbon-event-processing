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
package org.wso2.carbon.event.execution.manager.admin.dto.domain;

/**
 * DTO class of TemplateDomain for ExecutionManagerAdminService
 */
public class TemplateDomainDTO {

    String name;
    String description;
    TemplateDTO[] templateDTOs;
    String[] streams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TemplateDTO[] getTemplateDTOs() {
        return templateDTOs;
    }

    public void setTemplateDTOs(TemplateDTO[] templateDTOs) {
        this.templateDTOs = templateDTOs;
    }

    public String[] getStreams() {
        return streams;
    }

    public void setStreams(String[] streams) {
        this.streams = streams;
    }
}
