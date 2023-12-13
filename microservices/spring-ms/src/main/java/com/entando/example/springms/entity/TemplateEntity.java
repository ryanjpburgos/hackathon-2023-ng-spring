package com.entando.example.springms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "templates")
public class TemplateEntity
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String template;
    private String userid;

    @OneToMany(mappedBy="id")
    private Set<FormEntity> forms;

    public TemplateEntity(Long id, String template, String userid) {
        this.id = id;
        this.template = template;
        this.userid = userid;
    }

    public TemplateEntity() {  }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getTemplate() {
        return template;
    }

    public String getUserid() {
        return userid;
    }

    public Set<FormEntity> getForms() {
        return forms;
    }

    public void setForms(Set<FormEntity> forms) {
        this.forms = forms;
    }
}
