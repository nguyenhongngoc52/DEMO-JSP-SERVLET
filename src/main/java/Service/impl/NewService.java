package Service.impl;

import DAO.INewDAO;
import Model.model.NewModel;
import Service.INewService;

import javax.inject.Inject;
import java.util.List;

public class NewService implements INewService {
    @Inject
    private INewDAO newDAO;
    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {
        return newDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewModel save(NewModel newModel) {
     Long newId = newDAO.save(newModel);
        return newDAO.findone(newId);
    }

    @Override
    public NewModel Update(NewModel newModel) {
        return null;
    }

}
