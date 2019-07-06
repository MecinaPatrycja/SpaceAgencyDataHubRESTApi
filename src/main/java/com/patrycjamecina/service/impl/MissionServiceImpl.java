package com.patrycjamecina.service.impl;
import com.patrycjamecina.model.Mission;
import com.patrycjamecina.repository.MissionRepository;
import com.patrycjamecina.service.MissionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class MissionServiceImpl implements MissionService {
    private final MissionRepository missionRepository;

    @Override
    public Mission addMission(final Mission mission) {
        return missionRepository.saveAndFlush(mission);
    }

    @Override
    public void removeMission(final String missionName) {
        missionRepository.deleteById(missionName);
    }

    @Override
    public ResponseEntity<Object> editMission(final Mission mission, final String name) {
        Optional<Mission> studentOptional = missionRepository.findById(name);
        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();
        mission.setMissionName(name);
        missionRepository.save(mission);
        return ResponseEntity.noContent().build();
    }
}
