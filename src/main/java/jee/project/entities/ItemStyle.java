package jee.project.entities;

import java.util.Date;

public interface ItemStyle {
    public String   getTitle();
    public void     setTitle(String title);

    public Date     getReleaseDate();
    public void     setReleaseDate(Date date);

    public String   getDescription();
    public void     setDescription(String description);
}
