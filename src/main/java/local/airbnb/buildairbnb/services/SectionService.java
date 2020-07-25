package local.airbnb.buildairbnb.services;

import local.airbnb.buildairbnb.models.Section;

import java.util.List;

public interface SectionService
{
    List<Section> findAll();

    Section findSectionById(long id);

    void delete(long id);

    Section save(Section role);

    Section update(Section role,
                   long id);

    void deleteAll();
}