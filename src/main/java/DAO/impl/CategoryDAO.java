package DAO.impl;

import DAO.ICategoryDAO;
import Model.model.CategoryModel;
import mapper.CategoryMapper;

import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {


    @Override
    public List<CategoryModel> findAll() {
        String sql ="SELECT*FROM category";//cau truy van

        return query(sql, new CategoryMapper());
    }
}
