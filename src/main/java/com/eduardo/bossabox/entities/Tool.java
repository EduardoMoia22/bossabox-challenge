package com.eduardo.bossabox.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class Tool {
      public Tool(Long id, String title, String link, String description, List<String> tags){
            this.id = id;
            this.title = title;
            this.link = link;
            this.description = description;
            this.tags = tags;
      }
      
      public Tool(String title, String link, String description, List<String> tags){
            this.title = title;
            this.link = link;
            this.description = description;
            this.tags = tags;
      }

      public Tool(){}

      @Id
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      private Long id;
      private String title;
      private String link;
      private String description;
      private List<String> tags;
}
