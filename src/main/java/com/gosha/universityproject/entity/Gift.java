package com.gosha.universityproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "plch_gifts")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String gift;

    @Column
    private int price;
}
