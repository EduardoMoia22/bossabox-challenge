package com.eduardo.bossabox.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardo.bossabox.DTOs.ToolResponse;
import com.eduardo.bossabox.entities.Tool;
import com.eduardo.bossabox.repositories.ToolRepository;

@Service
public class ToolServices {
      private final ToolRepository toolRepository;

      public ToolServices(ToolRepository toolRepository) {
            this.toolRepository = toolRepository;
      }

      public List<ToolResponse> getAllTools() {
            List<Tool> toolsList = toolRepository.findAll();

            List<ToolResponse> toolResponses = new ArrayList<ToolResponse>();

            for (Tool tool : toolsList) {
                  ToolResponse toolResponse = new ToolResponse(
                              tool.getId(),
                              tool.getTitle(),
                              tool.getLink(),
                              tool.getDescription(),
                              tool.getTags());
                  toolResponses.add(toolResponse);
            }

            return toolResponses;
      }

      public List<ToolResponse> findToolsByTag(String tag) {
            List<Tool> toolsList = toolRepository.findByTag(tag);
            List<ToolResponse> toolResponses = new ArrayList<ToolResponse>();

            for (Tool tool : toolsList) {
                  ToolResponse toolResponse = new ToolResponse(
                              tool.getId(),
                              tool.getTitle(),
                              tool.getLink(),
                              tool.getDescription(),
                              tool.getTags());
                  toolResponses.add(toolResponse);
            }

            return toolResponses;
      }

      public ToolResponse saveTool(Tool toolData) {
            this.toolRepository.save(toolData);

            ToolResponse toolResponse = new ToolResponse(
                        toolData.getId(),
                        toolData.getTitle(),
                        toolData.getLink(),
                        toolData.getDescription(),
                        toolData.getTags());

            return toolResponse;
      }

      public void deleteById(Long id) {
            toolRepository.deleteById(id);
      }
}
