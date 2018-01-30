package jee.project.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
/**
 * A genre is a "kind of" of the an entity.
 * For example: a cardGame is a genre of a BoardGame.
 */
public abstract class Genre extends EntityObject {
    // ATTRIBUTE
    /**
     * The name of the genre
     */
    @Column(nullable = false)
    private String name;

    /**
     * The join table between items and genres
     */
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "Item_Genre",
        joinColumns = {
            @JoinColumn(
                    name = "item_id",
                    referencedColumnName = "id"
            )
        },
        inverseJoinColumns = {
            @JoinColumn(
                    name = "genre_id",
                    referencedColumnName = "id"
            )
        }
    )
    private List<Item> items;

    // METHODS
    /**
     * Return the name of the actual genre
     * @return String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Set the name of the genre
     * @param name String
     */
    public void setName(String name) {
        if (name == null) throw new IllegalArgumentException();
        if (!name.equals("")) {
            this.name = name;
        } else {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Return the list of items
     * @return List
     */
    public List<Item> getItems() {
        if (this.items == null) this.items = new ArrayList<>();
        return this.items;
    }
}
