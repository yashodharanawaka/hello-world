package com.codespringboot.helloworld.service;

import com.codespringboot.helloworld.model.Tutorial;
import com.codespringboot.helloworld.repository.TutorialsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TutorialsService {

    @Autowired
    TutorialsRepository tutorialsRepository;

    public List<Tutorial> getAllTutorials(){
        List<Tutorial> tutorials = tutorialsRepository.findAll();
        return tutorials;
    }

    public String createTutorial(Tutorial tutorial) {
        tutorialsRepository.insert(tutorial);
        return tutorial+"was added!";
    }

    public ResponseEntity<Tutorial> getTutorialById(String id){
        return new ResponseEntity(tutorialsRepository.findById(id), HttpStatus.OK);
    }

    public ResponseEntity<Tutorial> updatePublicationStatus(boolean bool, String id) {
        Optional<Tutorial> tutorialData=tutorialsRepository.findById(id);
        if(tutorialData.isPresent()){
            Tutorial _tutorial=tutorialData.get();
            _tutorial.setPublished(bool);
            return new ResponseEntity<>(tutorialsRepository.save(_tutorial), HttpStatus.OK);
        }       else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<Tutorial> updateTutorial(Tutorial tutorial, String id) {
        Optional<Tutorial> oldTutorialData=tutorialsRepository.findById(id);
        if(oldTutorialData.isPresent()){
            Tutorial _tutorial=oldTutorialData.get();
            _tutorial.setTitle(tutorial.getTitle());
            _tutorial.setDescription(tutorial.getDescription());
            _tutorial.setPublished(tutorial.isPublished());
            return new ResponseEntity<>(tutorialsRepository.save(_tutorial), HttpStatus.OK);
        }       else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<Tutorial>> searchTutorialByTitle(String keyword){
        return new ResponseEntity(tutorialsRepository.findByTitleContainingIgnoreCase(keyword), HttpStatus.OK);
    }

    public ResponseEntity<List<Tutorial>> getAllPublishedTutorials(){
        return new ResponseEntity(tutorialsRepository.findByPublished(true), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteTutorialById(String id){
        tutorialsRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<List<Tutorial>> getAllUnpublishedTutorials(){
        return new ResponseEntity(tutorialsRepository.findByPublished(false), HttpStatus.OK);
    }
}

