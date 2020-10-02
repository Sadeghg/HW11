package model;

import lombok.*;
import template.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Article", catalog = "hw11b", schema = "hw11b")
@NamedQueries({
        @NamedQuery(name = "Article.findAll", query = "select a from Article a"),
        @NamedQuery(name = "Article.published", query = "select a from Article a where a.state=:true"),
        @NamedQuery(name = "Article.findByUser", query = "select a from Article a where a.user.id=:id"),
        @NamedQuery(name = "Article.findAllPublished", query = "select a from Article a where a.state = true"),
        @NamedQuery(name = "Article.findByTitle", query = "select a from Article a where a.title =:title"),
        @NamedQuery(name = "Article.findByCategory", query = "select a from Article a where a.category.id =:id")

})
public class Article extends BaseEntity<Integer> {

    @Column(name = "article_title")
    private String title;

    @Column(name = "brief")
    private String brief;

    @Column(name = "content")
    private String content;

    @Temporal(TemporalType.DATE)
    @Column(name = "create_date")
    private Date createDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "last_update_date")
    private Date lastUpdateDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "publish_date")
    private Date publishedDate;

    @Column(name = "publish_states")
    private Boolean state;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Category category;

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "article_tags", joinColumns = {@JoinColumn(name = "article_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")})
    private Set<Tag> tags;


}
