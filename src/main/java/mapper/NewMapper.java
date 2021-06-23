package mapper;

import Model.model.NewModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewMapper implements  RowMapper<NewModel>{

    @Override
    public NewModel mapRow(ResultSet resultSet) {
        NewModel newModel =new NewModel();
        try {
            newModel.setCategoryId(resultSet.getLong("categoryid"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {
            newModel.setTitle(resultSet.getString("title"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return newModel;
    }
}
