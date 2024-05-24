package com.eduardo.bossabox.DTOs;

import java.util.List;

import com.eduardo.bossabox.entities.Tool;

public record ToolRequest(String title, String link, String description, List<String> tags) {
      public Tool toModel(){
            return new Tool(title, link, description, tags);
      }
}
