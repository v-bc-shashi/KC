package com.sp.user.base.entity;

import com.sp.user.shared.CommonConstants;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@MappedSuperclass
public class BaseEntity {

    @Column(name= CommonConstants.COLUMN_CREATION_USER_ID)
    private String creationUserId;
    @Column(name= CommonConstants.COLUMN_UPDATE_USER_ID)
    private String updateUserId;
    @Column(name=CommonConstants.COLUMN_CREATION_DATE)
    @CreationTimestamp
    private Timestamp creationDate;
    @Column(name=CommonConstants.COLUMN_LAST_UPDATE_DATE)
    @UpdateTimestamp
    private Timestamp lastUpdateDate;
}
