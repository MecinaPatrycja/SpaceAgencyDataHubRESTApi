package com.patrycjamecina.repository;
import com.patrycjamecina.model.Mission;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MissionRepository extends JpaRepository<Mission, String> {
}
