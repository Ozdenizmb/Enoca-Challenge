package com.enoca.challenge.model;

import com.enoca.challenge.model.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer_data", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

}
