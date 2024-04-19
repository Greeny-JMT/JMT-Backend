package grenny.jmt.app.meeting.application.controller;

import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import grenny.jmt.app.meeting.application.service.MeetingService;

@RestController
@RequiredArgsConstructor
public class MeetingController {
    private final MeetingService meetingService;
}
