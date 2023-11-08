package edu.lemon.internetstore.service;

import edu.lemon.internetstore.model.dtos.ProductDto;
import edu.lemon.internetstore.model.entities.ProductEntity;
import edu.lemon.internetstore.repositories.ProductRepository;
import edu.lemon.internetstore.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

import static edu.lemon.internetstore.utils.MapperUtils.productDtoToEntity;

@Service
public class AdminServiceImplementation implements AdminService<ProductDto, UUID> {

    @Autowired
    private ProductRepository repository;

    @Override
    public void addData(ProductDto data) {
        ProductEntity productsEntity = productDtoToEntity(data);
        repository.save(productsEntity);
    }


    @Override
    public List<ProductDto> getAllData() {
        return repository.findAll().stream()
                .map(MapperUtils::productEntityToDto)
                .toList();
    }

    @Override
    public List<ProductDto> getDataByKey(UUID key) {
        return null;
    }

    @Override
    public void saveObject(ProductDto object) {

    }

    @Override
    public boolean updateByKey(ProductDto object, UUID key) {
        return false;
    }

    @Override
    public boolean deleteByKey(ProductDto object, UUID key) {
        return false;
    }
}
