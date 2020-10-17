package com.codespringboot.helloworld.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;


@Document(collection = "tutorials")
public class Tutorial implements Serializable {

    @Id
    private String id;

    @Indexed( unique = true)
    @NotBlank
    private String title;

    @NotBlank
    private String description;
    @NotBlank
    private boolean published;


    public String getId() {
        return id;
    }

/*    public void setId(String id) {
        this.id = id;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Tutorial() {
    }

    public Tutorial(String id, @NotBlank String title, @NotBlank String description, boolean published, Date createdAt, Date updatedAt) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    @Override
    public String toString() {
        return "Tutorial [id=" + id + ", title=" + title + ", desc=" + description + ", published=" + published + "]";
    }
}
