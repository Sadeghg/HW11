package data.tag;

import model.Tag;
import model.helper.TagInfo;
import template.data.BaseRepository;

public interface TagRepository extends BaseRepository<Tag, Integer, TagInfo> {

    Tag findByTitle(String title);

    void delete(Tag tag);
}
