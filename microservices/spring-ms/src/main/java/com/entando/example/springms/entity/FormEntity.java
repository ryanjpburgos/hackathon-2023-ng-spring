package com.entando.example.springms.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "forms")
@Data
@NoArgsConstructor
public class FormEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "templateid", referencedColumnName = "id", columnDefinition = "bigint", nullable = false)
    private TemplateEntity templateid;

    @Column(columnDefinition="text")
    private String payload;

    private String userid;

}
