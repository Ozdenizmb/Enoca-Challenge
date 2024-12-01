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
@Table(name = "product_data", schema = "util_sch")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Product extends BaseEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "stock")
    private int stock;
    @Column(name = "category")
    private String category;
    @Column(name = "brand")
    private String brand;

}
