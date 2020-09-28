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
@Table(name = "Tag", catalog = "hw11b",schema = "hw11b")
@NamedQueries({
        @NamedQuery(name = "Tag.findAll", query = "select t from Tag t"),
        @NamedQuery(name = "Tag.findByTitle", query = "select t from Tag t where t.title =:title")
})
public class Tag extends BaseEntity<Integer> {

    @Column(name = "tag_title")
    private String title;



}
