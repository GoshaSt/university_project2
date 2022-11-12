package com.gosha.universityproject.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "dwarf")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Dwarf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;
}
