package com.enoca.challenge.model.base;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDate;
import java.util.UUID;

@Data
@MappedSuperclass
@EntityListeners({AuditingEntityListener.class})
public abstract class BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;
    @CreatedDate
    @Column(name = "created_date")
    private LocalDate createdDate;
    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDate updatedDate;

}
