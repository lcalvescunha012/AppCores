package com.AppCores.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tema")
public class TemaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeTema;

    @Column(nullable = false)
    private String corPrimaria;

    @Column(nullable = false)
    private String corSecundaria;

    @Column(nullable = false)
    private String fontePrimaria;

    @Column(nullable = false)
    private String logoUrl;
}
