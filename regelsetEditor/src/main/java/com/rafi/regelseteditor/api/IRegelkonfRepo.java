package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.Regelkonf;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegelkonfRepo extends JpaRepository<Regelkonf, Long> {
    List<Regelkonf> findByRegelsetId(long regelsetId);
    List<Regelkonf> findByRegeldef(long regeldefId);
}
