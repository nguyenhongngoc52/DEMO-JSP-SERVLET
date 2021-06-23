package DAO;

import Model.model.NewModel;

import java.util.List;

public interface INewDAO extends GenericDAO<NewModel> {
    NewModel findone(Long id);
    List<NewModel> findByCategoryId(Long categoryId);
    Long save(NewModel newModel);
}
