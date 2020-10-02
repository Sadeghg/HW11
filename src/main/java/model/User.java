package model;


import lombok.*;
import template.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "User", catalog = "hw11a", schema = "hw11a")
@NamedQueries({
        @NamedQuery(name = "User.findAll", query = "select u from User u"),
        @NamedQuery(name = "User.findByUsername", query = "select u from User u where u.userName =:username"),
        @NamedQuery(name = "User.login", query = "select u from User u where u.userName=:username and u.password=:password"),
})
public class User extends BaseEntity<Integer> {

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "national_code")
    private String nationalCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "birth_day")
    private Date birthDay;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private Role role;
}
