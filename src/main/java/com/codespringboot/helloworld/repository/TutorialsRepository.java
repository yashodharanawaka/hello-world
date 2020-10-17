package com.codespringboot.helloworld.repository;

import com.codespringboot.helloworld.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorialsRepository extends MongoRepository<Tutorial, String> {
//    List<Tutorial> findByTitleIsContaining(String title);
//    List<Tutorial> findByTitleLike(String title);
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContainingIgnoreCase(String title);
}
