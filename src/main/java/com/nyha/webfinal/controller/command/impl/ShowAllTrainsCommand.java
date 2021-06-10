package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.Train;
import com.nyha.webfinal.model.service.TrainService;
import com.nyha.webfinal.model.service.impl.TrainServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//fixme мне это надо?
public class ShowAllTrainsCommand implements Command {
    static Logger logger = LogManager.getLogger();
    private TrainService service = new TrainServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.TRAINS);
        List<Train> trains;
        try {
            trains = service.findAllTrains();
            request.setAttribute(RequestAttribute.TRAINS, trains);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e.getMessage());
            logger.error("search error", e);
        }
        return router;
    }
}
