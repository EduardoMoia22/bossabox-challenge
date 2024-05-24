package com.eduardo.bossabox.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.eduardo.bossabox.DTOs.ToolRequest;
import com.eduardo.bossabox.DTOs.ToolResponse;
import com.eduardo.bossabox.entities.Tool;
import com.eduardo.bossabox.services.ToolServices;

@RestController
@RequestMapping("/tools")
public class ToolController {
      @Autowired
      private ToolServices toolService;

      @GetMapping
      public ResponseEntity<List<ToolResponse>> getAllTools() {
            List<ToolResponse> toolsList = this.toolService.getAllTools();

            return ResponseEntity.ok().body(toolsList);
      }

      @GetMapping(":tag")
      public ResponseEntity<List<ToolResponse>> getToolsByTag(@RequestParam(value = "tag") String tag){
            List<ToolResponse> toolList = this.toolService.findToolsByTag(tag);

            return ResponseEntity.ok().body(toolList);
      }

      @PostMapping
      public ResponseEntity<ToolResponse> saveTool(@RequestBody ToolRequest toolRequest) {
            Tool tool = toolRequest.toModel();
            ToolResponse toolResponse = this.toolService.saveTool(tool);

            URI headerLocation = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(toolResponse.id())
                        .toUri();

            return ResponseEntity.created(headerLocation).body(toolResponse);
      }

      @DeleteMapping(":id")
      public void deleteTool(@RequestParam(value = "id") Long id) {
            this.toolService.deleteById(id);
      }
}
