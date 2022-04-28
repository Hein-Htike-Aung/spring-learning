package com.hha.db.products.dao;


import com.hha.db.products.ds.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductDao extends CrudRepository<Product,Integer> {
}
