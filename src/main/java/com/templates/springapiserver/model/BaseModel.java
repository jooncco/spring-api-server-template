package com.templates.springapiserver.model;

import static com.templates.springapiserver.constant.CommonConstants.DEFAULT_SERVER_ZONE_OFFSET;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BaseModel {
    private LocalDateTime createdDateTime;
    private Integer createdBy;
    private LocalDateTime updatedDateTime;
    private Integer updatedBy;

    protected void initModel(int createdBy) {
        this.createdBy = createdBy;
        this.updatedBy = createdBy;
        createdDateTime = updatedDateTime = LocalDateTime.now(DEFAULT_SERVER_ZONE_OFFSET);
    }

    protected void updateModel(int updatedBy) {
        this.updatedBy = updatedBy;
        updatedDateTime = LocalDateTime.now(DEFAULT_SERVER_ZONE_OFFSET);
    }
}
