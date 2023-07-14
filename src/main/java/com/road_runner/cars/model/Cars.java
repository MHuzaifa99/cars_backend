package com.road_runner.cars.model;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cars {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "TEXT")
    private String sDecs;
    @Column(columnDefinition = "TEXT")
    private String lDecs;
    private String name;
    private long price;
    private String imageUrl;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Cars( String sDecs, String lDecs, String name, long price, String imageUrl){
        this.sDecs = sDecs;
        this.lDecs = lDecs;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
    }
}
