package service.tag;

import model.Tag;
import model.helper.TagInfo;
import template.service.BaseService;

public interface TagService extends BaseService<Tag, Integer, TagInfo> {

    Tag findByTitle(String title);

    void delete(Tag tag);
}
