package com.codespringboot.helloworld.repository;

import com.codespringboot.helloworld.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TutorialsRepository extends MongoRepository<Tutorial, String> {
//    List<Tutorial> findByTitleIsContaining(String title);
//    List<Tutorial> findByTitleLike(String title);
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
