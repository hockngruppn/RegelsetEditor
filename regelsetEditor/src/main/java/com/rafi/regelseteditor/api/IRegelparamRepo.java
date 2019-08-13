package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.Regelparam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegelparamRepo extends JpaRepository<Regelparam, Long> {
    List<Regelparam> findRegelparamByRegelkonfId(Long regelkonfId);
}
