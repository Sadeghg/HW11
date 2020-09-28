package model;

import lombok.*;
import template.model.BaseEntity;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Role", catalog = "hw11a",schema = "hw11a")
@NamedQueries({
        @NamedQuery(name = "Role.findAll", query = "select r from Role r"),
        @NamedQuery(name = "Role.findByTitle", query = "select r from Role r where r.title =:title")
})
public class Role extends BaseEntity<Integer> {

    @Column(name = "role_title")
    private String title;


}
