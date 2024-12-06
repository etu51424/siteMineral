package com.spring.henallux.firstSpringProject.dataAccess.repository;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.MineralEntity;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

public interface MineralRepository extends JpaRepository<MineralEntity, Integer> {
    public List<MineralEntity> findAllByCategory(CategoryEntity category);
}
