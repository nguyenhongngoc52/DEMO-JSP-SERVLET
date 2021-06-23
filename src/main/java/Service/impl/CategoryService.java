package Service.impl;

import DAO.ICategoryDAO;
import DAO.impl.CategoryDAO;
import Model.model.CategoryModel;
import Service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    @Inject
    private ICategoryDAO iCategoryDAO;
//    public CategoryService (){
//        iCategoryDAO = new CategoryDAO();
//    }

    @Override
    public List<CategoryModel> findAll() {
        return iCategoryDAO.findAll();
    }
}
