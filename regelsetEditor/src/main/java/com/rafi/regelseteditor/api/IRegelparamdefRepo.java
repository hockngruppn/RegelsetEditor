package com.rafi.regelseteditor.api;

import com.rafi.regelseteditor.model.Regelparamdef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRegelparamdefRepo extends JpaRepository<Regelparamdef, Long> {
    List<Regelparamdef> findByRegeldefId(Long regeldefId);
}
