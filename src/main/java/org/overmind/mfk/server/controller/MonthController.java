package org.overmind.mfk.server.controller;

import org.overmind.mfk.server.model.MonthOfMeetings;
import org.overmind.mfk.server.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.YearMonth;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 09.09.2017 0:50
 */
@RestController
@RequestMapping("month")
public class MonthController {

    private final MonthService monthService;

    @Autowired
    public MonthController(MonthService monthService) {
        this.monthService = monthService;
    }

    @GetMapping(path = "{month}")
    public MonthOfMeetings findOne(@PathVariable("month") YearMonth yearMonth) {
        return monthService.find(yearMonth);
    }
}
