package com.cakeShop_be_admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cakeShop_be_admin.entites.Category;

@Repository
public interface CategoryRepository  extends JpaRepository<Category,Long>{

}
