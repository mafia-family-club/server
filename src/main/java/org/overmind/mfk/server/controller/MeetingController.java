package org.overmind.mfk.server.controller;

import org.overmind.mfk.server.entry.Meeting;
import org.overmind.mfk.server.exception.MeetingNotFoundException;
import org.overmind.mfk.server.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author eugene.karanda
 * @version 1.0 Create: 26.08.2017 13:04
 */
@RestController
@RequestMapping("meeting")
public class MeetingController {

    private final MeetingService meetingService;

    @Autowired
    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping
    public List<Meeting> findAll() {
        return meetingService.findAll();
    }

    @GetMapping(path = "{id}")
    public Meeting findOne(@PathVariable("id") Long id) throws MeetingNotFoundException {
        return meetingService.findOne(id);
    }

    @PostMapping
    public Meeting save(@RequestBody Meeting meeting) {
        return meetingService.save(meeting);
    }

}
