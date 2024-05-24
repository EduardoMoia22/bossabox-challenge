package com.eduardo.bossabox.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eduardo.bossabox.entities.Tool;

@Repository
public interface ToolRepository extends JpaRepository<Tool, Long> {

      @Query(value = "select * from tool where tags like %:tag%", nativeQuery = true)
      public List<Tool> findByTag(@Param("tag") String tag);

}
