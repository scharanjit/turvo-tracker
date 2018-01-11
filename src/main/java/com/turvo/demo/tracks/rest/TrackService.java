package com.turvo.demo.tracks.rest;

import com.turvo.demo.tracks.track.Position;
import com.turvo.demo.tracks.track.Track;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.geo.Box;
import org.springframework.data.mongodb.core.geo.Point;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
@RequestMapping("/track")
public class TrackService {

    public static final Double KILOMETER = 111.0d;

    /**
     * The Attribute that is used for the search for the start position
     */
    public static final String START = "start";
    /**
     * The Attribute that is used for the search for the user
     */
    private static final String USER = "user";

    @Autowired
    @Qualifier("tracksTemplate")
    private MongoOperations mongoOps;
    

    @RequestMapping(value = "/getPosition", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Position getPosition() {
        Position position = new Position();
        position.setLat(1d);
        position.setLon(2d);
        position.setEle(3d);
        return position;
    }


//    @RequestMapping(value = "/upload", method = RequestMethod.POST)
//    @ResponseStatus(HttpStatus.OK)
//    @ResponseBody
//    public Position upload() {
//        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ObjectMapper mapper = new ObjectMapper();
//        Track track = mapper.readValue(multipartFile.getBytes(), Track.class);
//        track.setUser(principal.getUsername());
//        mongoOps.insert(track);
//    }

}
