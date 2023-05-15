package com.templates.springapiserver.model;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
public class BaseModel {
    private LocalDateTime createdDateTime;
    // TODO: set default creator from request context
    private Integer createdBy;
    @Setter private LocalDateTime updatedDateTime;
    @Setter private Integer updatedBy;

    public BaseModel(Integer createdBy, Integer updatedBy) {
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
    }
}
