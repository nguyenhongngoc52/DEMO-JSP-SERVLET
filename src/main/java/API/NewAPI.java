package API;

import Model.model.NewModel;
import Service.impl.NewService;
import Util.HttpUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(urlPatterns = "/api-admin-new")
public class NewAPI extends HttpServlet {
    @Inject
    private NewService newService;
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("application/json");
        NewModel newModel =HttpUtil.of(req.getReader()).toModel(NewModel.class);
        newModel = newService.save(newModel);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(resp.getOutputStream(),newModel);
    }
}
