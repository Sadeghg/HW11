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
@Table(name = "Category", catalog = "hw11b" ,schema = "hw11b")
@NamedQueries({
        @NamedQuery(name = "Category.findAll", query = "select c from Category c"),
        @NamedQuery(name = "Category.findByTitle", query = "select c from Category c where c.title =:title")
})
public class Category extends BaseEntity<Integer> {

    @Column(name = "category_title")
    private String title;

    @Column(name = "category_description")
    private String description;
}
