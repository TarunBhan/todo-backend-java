package com.spider.spider.model;

import jakarta.persistence.*;

@Entity
@Table(name = "text_data")
public class TextEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String value;

    // Constructors
    public TextEntity() {}

    public TextEntity(String value) {
        this.value = value;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }
}
