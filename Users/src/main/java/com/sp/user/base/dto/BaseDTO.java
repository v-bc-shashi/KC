package com.sp.user.base.dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class BaseDTO {
    private String creationUserId;
    private String updateUserId;
    private Timestamp creationDate;
    private Timestamp lastUpdateDate;
}
