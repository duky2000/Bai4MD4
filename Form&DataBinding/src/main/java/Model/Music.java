package Model;

import java.util.List;

public class Music {
    private String name;
    private String singerName;
    private Category category;
    private String file;

    public Music() {
    }

    public Music(String name, String singerName, Category category, String file) {
        this.name = name;
        this.singerName = singerName;
        this.category = category;
        this.file = file;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingerName() {
        return singerName;
    }

    public void setSingerName(String singerName) {
        this.singerName = singerName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
