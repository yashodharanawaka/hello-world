package com.codespringboot.helloworld.controller;

import com.codespringboot.helloworld.model.Tutorial;
import com.codespringboot.helloworld.service.TutorialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/tutorials")
public class TutorialsController {

    @Autowired
    TutorialsService tutorialsService;

    @GetMapping("/all")
    private List<Tutorial> getAllTutorials(){
        return tutorialsService.getAllTutorials();
    }

    @PostMapping("/add")
    private String addTutorial(@RequestBody Tutorial t){
        return tutorialsService.createTutorial(t);
    }

    @GetMapping("/tutorial/{id}")
    private ResponseEntity<Tutorial> findTutorial(@PathVariable String id){
        return tutorialsService.getTutorialById(id);
    }

    @DeleteMapping("/tutorial/{id}")
    private ResponseEntity<?> deleteTutorial(@PathVariable String id){
        return tutorialsService.deleteTutorialById(id);
    }

    @PutMapping("/isPublished/{id}")
    private ResponseEntity<Tutorial> updatePublished(@RequestBody Boolean bool, @PathVariable String id){
        return tutorialsService.updatePublicationStatus(bool,id);
    }

    @PutMapping("/tutorial/{id}")
    private ResponseEntity<Tutorial> updateTutorial(@RequestBody Tutorial tutorial, @PathVariable String id){
        return tutorialsService.updateTutorial(tutorial, id);
    }

    @GetMapping("/tutorial/title")
    private ResponseEntity<List<Tutorial>> searchTutorial(@RequestParam(value="phrase") String phrase){
        return tutorialsService.searchTutorialByTitle(phrase);
    }

/*    @GetMapping("/tutorial/{phrase}")
    private ResponseEntity<List<Tutorial>> searchTutorial(@RequestParam(value="phrase") String phrase){
        return tutorialsService.searchTutorialByTitle(phrase);
    }*/

    @GetMapping("/published")
    public ResponseEntity<List<Tutorial>> findPublished() {
        return tutorialsService.getAllPublishedTutorials();
    }

    @GetMapping("/unpublished")
    public ResponseEntity<List<Tutorial>> findUnpublished() {
        return tutorialsService.getAllUnpublishedTutorials();
    }
}
