package com.nyha.webfinal.controller.command.impl;

import com.nyha.webfinal.controller.RequestAttribute;
import com.nyha.webfinal.controller.RequestParameter;
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
        List<ShortTrainData> shortTrainData;
        try {
            shortTrainData = service.findTrainByStations(departureStation, arrivalStation);
            if (shortTrainData.isEmpty()) {
                request.setAttribute(RequestAttribute.INCORRECT_DATA, TRAINS_NOT_FOUND);
                return router;
            }
            request.setAttribute(RequestAttribute.SHORT_TRAINS_DATA, shortTrainData);
        } catch (ServiceException e) {
            router.setPage(PagePath.ERROR_500);
            request.setAttribute(RequestAttribute.EXCEPTION, e.getMessage());
            logger.error("search error",e);
        }
        return router;
    }
}