package com.mariabonita.skincareroutine.domain.myuser;

//import com.mariabonita.skincareroutine.domain.products.Routine;
import com.mariabonita.skincareroutine.domain.Role;
import com.mariabonita.skincareroutine.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static jakarta.persistence.FetchType.EAGER;

@Table(name = "MyUser")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank String password;

    @NotBlank
    @Email
    private String email;

    @Enumerated(EnumType.STRING)
    private Age age;

    @Enumerated(EnumType.STRING)
    private SkinTypeClient skinTypeClient;

    @Enumerated(EnumType.STRING)
    private HowMuch howMuch;

    @Enumerated(EnumType.STRING)
    private PigmentedSkin pigmentedSkin;

    @Enumerated(EnumType.STRING)
    private SensitiveSkin sensitiveSkin;

    @ManyToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public MyUser(String name, String email, String password, Collection<Role> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

  //  @ManyToMany(cascade = CascadeType.ALL) //, orphanRemoval = true
    //private List<Routine> routines = new ArrayList<>();

    //public void addRoutine(Routine routine) {
      //  routines.add(routine);
        //routine.setMyUser(this);
    //}


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
