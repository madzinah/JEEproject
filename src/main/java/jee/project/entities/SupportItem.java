package jee.project.entities;

public abstract class SupportItem {
    private String supportName;

    public String getSupportName() {
        return supportName;
    }

    public void setSupportName(String supportName) {
        if (supportName == null) return;
        this.supportName = supportName;
    }
}
