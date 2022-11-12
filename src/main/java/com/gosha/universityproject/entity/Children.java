package com.gosha.universityproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "plch_children")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Children {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private String naughty;

    @Column(updatable = false, name = "datecreated")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "datemodified")
    @UpdateTimestamp
    private LocalDateTime dateModified = null;

    @Column(name = "datefinished")
    private LocalDateTime dateFinished = null;
}
