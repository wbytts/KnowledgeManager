package com.by.km.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author bingyi
 */
@Entity
public class Demo {
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private String text;

    public Demo() {
    }

    public Demo(Long id, String text) {
        this.id = id;
        this.text = text;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Demo{" +
                "id=" + id +
                ", text='" + text + '\'' +
                '}';
    }
}
