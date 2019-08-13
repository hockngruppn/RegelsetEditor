package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.Regelset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegelsetRepo extends JpaRepository<Regelset, Long> {
    Regelset findRegelsetByName(String name);
    Regelset findRegelsetById(Long id);

}
