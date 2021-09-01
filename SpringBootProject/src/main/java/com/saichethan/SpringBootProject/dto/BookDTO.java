package com.saichethan.SpringBootProject.dto;

import lombok.Data;

@Data
public class BookDTO {
    private int id;
    private String name;
    private String authorName;
    private String description;
}


/**
 * public BookDTO() {
 *     }
 *
 *     public BookDTO(int id, String name, String authorName, String description) {
 *         this.id = id;
 *         this.name = name;
 *         this.authorName = authorName;
 *         this.description = description;
 *     }
 *
 *     public int getId() {
 *         return id;
 *     }
 *
 *     public void setId(int id) {
 *         this.id = id;
 *     }
 *
 *     public String getName() {
 *         return name;
 *     }
 *
 *     public void setName(String name) {
 *         this.name = name;
 *     }
 *
 *     public String getAuthorName() {
 *         return authorName;
 *     }
 *
 *     public void setAuthorName(String authorName) {
 *         this.authorName = authorName;
 *     }
 *
 *     public String getDescription() {
 *         return description;
 *     }
 *
 *     public void setDescription(String description) {
 *         this.description = description;
 *     }
 *
 *     @Override
 *     public String toString() {
 *         return "BookDTO{" +
 *                 "id=" + id +
 *                 ", name='" + name + '\'' +
 *                 ", authorName='" + authorName + '\'' +
 *                 ", description='" + description + '\'' +
 *                 '}';
 *     }
 */
