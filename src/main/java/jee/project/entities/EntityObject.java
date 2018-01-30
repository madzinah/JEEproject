package jee.project.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Entity")
public abstract class EntityObject {
    // ATTRIBUTES
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    // METHOD
    public Long getId() { // sad to be here :)
        return this.id;
    }
}
