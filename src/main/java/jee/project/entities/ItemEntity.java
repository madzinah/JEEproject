package jee.project.entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "title", unique = true)
    private String title;

    @Column(name = "releaseDate")
    private Date releaseDate;

    @Column(name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null) return;
        this.title = title;
    }


    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        if (description == null) return;
        this.description = description;
    }
}
