package id.ac.umn.uts_40037;

import java.io.Serializable;

public class Sfx implements Serializable {
    private String title;
    private String category;
    private int uri;

    public Sfx(String title, String category, int uri) {
        this.title = title;
        this.category = category;
        this.uri = uri;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public int getUri() {
        return uri;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setUri(int uri) {
        this.uri = uri;
    }
}
