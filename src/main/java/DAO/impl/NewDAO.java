package DAO.impl;

import DAO.INewDAO;
import Model.model.NewModel;
import mapper.NewMapper;

import java.util.List;


public class NewDAO extends AbstractDAO<NewModel> implements INewDAO {

    @Override
    public NewModel findone(Long id) {
        String sql = "SELECT*FROM news WHERE id = ?";//cau truy van

        List<NewModel> news = query(sql, new NewMapper(), id);
        return news.isEmpty() ? null : news.get(0);
    }

    @Override
    public List<NewModel> findByCategoryId(Long categoryId) {

        String sql = "SELECT*FROM news WHERE categoryid = ?";//cau truy van

        return query(sql, new NewMapper(), categoryId);
    }

    @Override
    public Long save(NewModel newModel) {
        String sql = "INSERT INTO news (title,content,categoryId)VALUE (?,?,?)";
        return insert(sql, newModel.getTitle(), newModel.getContent(), newModel.getCategoryId());
    }
}
