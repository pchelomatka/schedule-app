package main.entities;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "auth")
@Data
public class Auth {

    @Id
    private Integer id;

    @Column(name = "login")
    private Integer login;

    @Column(name = "password")
    private String password;

    @Column(name = "authorized")
    private Boolean authFlag;
}
