package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.Regeldef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRegeldefRepo extends JpaRepository<Regeldef, Long> {
    Regeldef findRegeldefByName(String name);
    Regeldef findRegeldefById(Long id);
}
