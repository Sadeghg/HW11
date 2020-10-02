package service.tag;

import data.tag.TagRepository;
import model.Tag;
import model.helper.TagInfo;
import template.service.BaseServiceImp;

public class TagServiceImp extends BaseServiceImp<Tag, Integer, TagRepository, TagInfo> implements TagService {
    public TagServiceImp(TagRepository repository) {
        super(repository);
    }

    public Tag findByTitle(String title) {
        return repository.findByTitle(title);
    }

    public void delete(Tag tag) {
        repository.delete(tag);
    }
}
