package com.eduardo.bossabox.DTOs;

import java.util.List;

public record ToolResponse(Long id, String title, String link, String description, List<String> tags) {
      
}
