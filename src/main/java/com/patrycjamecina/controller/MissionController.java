package com.patrycjamecina.controller;
import com.patrycjamecina.model.Mission;
import com.patrycjamecina.service.impl.MissionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequiredArgsConstructor
@RequestMapping("/mission")
public class MissionController {
    private final MissionServiceImpl missionService;

    @PostMapping("/add")
    public Mission saveMission(@RequestBody final Mission mission) {
        return missionService.addMission(mission);
    }

    @DeleteMapping("/remove")
    public void remove(final String name) {
        missionService.removeMission(name);
    }

    @PutMapping("/edit")
    public ResponseEntity<Object> updateMission(@RequestBody Mission mission, String name) {
        return missionService.editMission(mission, name);
    }
}
