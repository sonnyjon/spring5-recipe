package dev.sonnyjon.spring5recipe.repos;

import dev.sonnyjon.spring5recipe.model.UnitOfMeasure;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Sonny on 5/31/2022.
 */
public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long>
{
}
