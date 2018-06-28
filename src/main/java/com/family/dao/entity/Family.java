package com.family.dao.entity;

import com.child.dao.entity.Child;
import com.father.dao.entity.Father;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Family {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "family")
    private Father father;

    public Family() {
    }

    @OneToMany(mappedBy = "family")
    private List<Child> children = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Father getFather() {
        return father;
    }

    public void setFather(Father father) {
        this.father = father;
    }

    public List<Child> getTodos() {
        return children;
    }

    public void setTodos(List<Child> children) {
        this.children = children;
    }
}
