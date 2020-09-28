package data.tag;

import model.Tag;
import template.data.BaseRepository;

public interface TagRepository extends BaseRepository<Tag, Integer> {

    Tag findByTitle(String title);

    void delete(Tag tag);
}
