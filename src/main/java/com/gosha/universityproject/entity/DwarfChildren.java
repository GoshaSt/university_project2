package com.gosha.universityproject.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "dwarf_children")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DwarfChildren {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "id_dwarf")
    @ManyToOne
    private Dwarf dwarf;

    @JoinColumn(name = "id_child")
    @ManyToOne
    private Children children;

    @JoinColumn(name = "id_gift")
    @ManyToOne
    private Gift gift;

    @Column(updatable = false, name = "datecreated")
    @CreationTimestamp
    private LocalDateTime dateCreated;

    @Column(name = "datefinished")
    private LocalDateTime dateFinished;

}
