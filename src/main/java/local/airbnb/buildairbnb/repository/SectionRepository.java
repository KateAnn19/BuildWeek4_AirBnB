package local.airbnb.buildairbnb.repository;


import local.airbnb.buildairbnb.models.Section;
import org.springframework.data.repository.CrudRepository;

public interface SectionRepository
        extends CrudRepository<Section, Long>
{
}
