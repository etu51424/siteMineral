package com.spring.henallux.firstSpringProject.dataAccess.dao;

import com.spring.henallux.firstSpringProject.dataAccess.entity.CategoryEntity;
import com.spring.henallux.firstSpringProject.dataAccess.entity.MineralEntity;
import com.spring.henallux.firstSpringProject.dataAccess.repository.MineralRepository;
import com.spring.henallux.firstSpringProject.dataAccess.util.ProviderConverter;
import com.spring.henallux.firstSpringProject.model.Category;
import com.spring.henallux.firstSpringProject.model.Mineral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class MineralDAO implements MineralDataAccess{
    private MineralRepository mineralRepository;
    private ProviderConverter providerConverter;
    @Autowired
    public MineralDAO(MineralRepository mineralRepository, ProviderConverter providerConverter){
        this.mineralRepository = mineralRepository;
        this.providerConverter = providerConverter;
    }

    @Override
    public ArrayList<Mineral> getAllByCategoryId(int categoryId) {
        ArrayList<Mineral> minerals = new ArrayList<>();

        try{
            List<MineralEntity> mineralEntities = mineralRepository.findAllByCategory(new CategoryEntity(categoryId));
            for (MineralEntity mineralEntity : mineralEntities){
                minerals.add(providerConverter.mineralEntityToMineralModel(mineralEntity));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return minerals;
    }
    public Mineral getMineralById(int mineralId){
        Mineral mineral = new Mineral();
        try{
            Optional<MineralEntity> optionalMineralEntity = mineralRepository.findById(mineralId);

            if (optionalMineralEntity.isPresent()){
                MineralEntity mineralEntity = optionalMineralEntity.get();
                mineral = providerConverter.mineralEntityToMineralModel(mineralEntity);
                System.out.println(mineral.getId());
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println(mineral.getId());
        return mineral;
    }
}
