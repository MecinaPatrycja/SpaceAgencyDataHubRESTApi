package com.patrycjamecina.service;
import com.patrycjamecina.model.Mission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
public interface MissionService {
    Mission addMission(final Mission mission);
    void removeMission(final String missionName);
    ResponseEntity<Object> editMission(@RequestBody Mission mission, String name);
}
