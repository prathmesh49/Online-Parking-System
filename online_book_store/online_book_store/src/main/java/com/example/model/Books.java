package com.example.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String title ;
    private String author;
    private String description;
    private double price;
    private LocalDate published_date;
    private String genre;
    private String image_url;

    @ManyToMany(mappedBy = "books")
    private List<Orders> orders = new ArrayList<>();

}
