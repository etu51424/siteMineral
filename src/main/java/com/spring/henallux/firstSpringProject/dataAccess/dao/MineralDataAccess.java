package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.model.Mineral;

import java.util.ArrayList;

public interface MineralDataAccess {
    public ArrayList<Mineral> getAllByCategoryId(int categoryId);
}
