package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
import com.nyha.webfinal.controller.SessionAttribute;
import com.nyha.webfinal.controller.command.Command;
import com.nyha.webfinal.controller.command.PagePath;
import com.nyha.webfinal.controller.command.Router;
import com.nyha.webfinal.exception.ServiceException;
import com.nyha.webfinal.model.entity.ShortTrainData;
import com.nyha.webfinal.model.entity.Train;
import com.nyha.webfinal.model.service.TrainService;
import com.nyha.webfinal.model.service.impl.TrainServiceImpl;
import com.nyha.webfinal.validator.RouteValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class FindTrainsByStationsCommand  implements Command {
    public static final String INCORRECT_STATION_NAME = "incorrectStationName";
    public static final String TRAINS_NOT_FOUND = "trainsNotFound";
    private TrainService service = new TrainServiceImpl();

    @Override
    public Router execute(HttpServletRequest request) {
        Router router = new Router();
        router.setPage(PagePath.TRAINS);
        String departureStation = request.getParameter(RequestParameter.DEPARTURE_STATION);
        String arrivalStation = request.getParameter(RequestParameter.ARRIVAL_STATION);
        if (!RouteValidator.isValidStation(departureStation) || !RouteValidator.isValidStation(departureStation)) {
            request.setAttribute(RequestAttribute.INCORRECT_DATA, INCORRECT_STATION_NAME);
            return router;
        }
        List<ShortTrainData> shortTrainsData;
        try {
            shortTrainsData = service.findTrainByStations(departureStation, arrivalStation);
            if (shortTrainsData.isEmpty()) {
                request.setAttribute(RequestAttribute.INCORRECT_DATA, TRAINS_NOT_FOUND);
                return router;
            }
            HttpSession session = request.getSession(true);
            session.setAttribute(SessionAttribute.SHORT_TRAINS_DATA, shortTrainsData);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e.getMessage());
            logger.error("search error",e);
        }
        return router;
    }
}