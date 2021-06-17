package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.entity.ShortTrainData;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.service.TrainService;
import com.nyha.webfinal.model.service.impl.TrainServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShowAllTrainsCommand implements Command {
    static Logger logger = LogManager.getLogger();
    public static final String TRAINS_NOT_FOUND = "trainsNotFound";
    private TrainService service = new TrainServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        List<ShortTrainData> shortTrainsData;
        try {
            shortTrainsData = service.findAllTrains();
            router.setPage(PagePath.ALL_TRAINS);
            if (shortTrainsData.isEmpty()) {
                request.setAttribute(RequestAttribute.INCORRECT_DATA, TRAINS_NOT_FOUND);
                return router;
            }
            request.setAttribute(RequestAttribute.SHORT_TRAINS_DATA, shortTrainsData);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e.getMessage());
            logger.error("search error",e);
        }
        return router;
    }
}
