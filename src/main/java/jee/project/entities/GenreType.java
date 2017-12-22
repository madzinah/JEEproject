package jee.project.entities;

public abstract class GenreType {
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public void setGenreName(String genreName) {
        if (genreName == null) return;
        this.genreName = genreName;
    }
}
