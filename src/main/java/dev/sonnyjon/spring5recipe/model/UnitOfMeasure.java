package dev.sonnyjon.spring5recipe.model;

import javax.persistence.*;

/**
 * Created by Sonny on 5/31/2022.
 */
@Entity
public class UnitOfMeasure
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }
}
