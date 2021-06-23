package mapper;

import Model.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel>{
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        CategoryModel categoryModel =new CategoryModel();
        try {
            categoryModel.setId(resultSet.getLong("id"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            categoryModel.setName(resultSet.getString("name"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            categoryModel.setCode(resultSet.getString("code"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return categoryModel;
    }
}
