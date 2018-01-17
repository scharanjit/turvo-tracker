package com.turvo.demo.tracks.rest;

import com.turvo.demo.tracks.track.Position;
import com.turvo.demo.tracks.track.Track;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;
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

    private static final String DRIVER = "driver.name";

    private static final String VEHICLETYPE = "vehicleType";

    private static final String VEHICLETYPEDETAILS = "vehicleDetails.vehicleType";

    private static final String VEHICLEIDDETAILS = "vehicleDetails.vehicleID";

    private static final String DATE = "data.date";

    @Autowired
    @Qualifier("tracksTemplate")
    private MongoOperations mongoOps;


    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public List<Track> getAll() throws Exception {
        return mongoOps.findAll(Track.class);
    }

    /**
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/foruser", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForUser() throws Exception {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Criteria criteria = Criteria.where(USER).is(principal.getUsername());
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }

    /**
     *
     * @param driver
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/fordriver/{driver}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForDriver(@PathVariable("driver") String driver) throws Exception {
        Criteria criteria = Criteria.where(DRIVER).is(driver);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }

    /**
     *
     * @param driver
     * @param vehicleType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forDriverWithVehicleType/{driver}/{vehicleType}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForDriverWithVehicleType(@PathVariable("driver") String driver, @PathVariable("vehicleType") String vehicleType) throws Exception {
        Criteria criteria = Criteria.where(DRIVER).is(driver).and(VEHICLETYPEDETAILS).is(vehicleType);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }


    /**
     *
     * @param driver
     * @param vehicleID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forDriverWithVehicleID/{driver}/{vehicleID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForDriverWithVehicleID(@PathVariable("driver") String driver, @PathVariable("vehicleID") String vehicleID) throws Exception {
        Criteria criteria = Criteria.where(DRIVER).is(driver).and(VEHICLEIDDETAILS).is(vehicleID);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }

    /**
     *
     * @param vehicleType
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forVehicleType/{vehicleType}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForVehicleType(@PathVariable("vehicleType") String vehicleType) throws Exception {
        Criteria criteria = Criteria.where(VEHICLETYPEDETAILS).is(vehicleType);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }

    /**
     *
     * @param vehicleID
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forVehicleID/{vehicleID}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForVehicleID(@PathVariable("vehicleID") String vehicleID) throws Exception {
        Criteria criteria = Criteria.where(VEHICLEIDDETAILS).is(vehicleID);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }


    /**
     *
     * @param driver
     * @param vehicleType
     * @param date
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/forDriverWithVehicleTypeAndDate/{driver}/{vehicleType}/{date}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<Track> tracksForDriverWithVehicleTypeAndDate(@PathVariable("driver") String driver, @PathVariable("vehicleType") String vehicleType, @PathVariable("date") String date) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSz");
        Date dateObj = sdf.parse(date);
        Criteria criteria = Criteria.where(DRIVER).is(driver).and(VEHICLETYPEDETAILS).is(vehicleType).and(DATE).is(dateObj);
        List<Track> tracks = mongoOps.find(new Query(criteria),
                Track.class);
        return tracks;
    }

    /**
     *
     * @param multipartFile
     * @throws Exception
     */
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void upload(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        User principal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ObjectMapper mapper = new ObjectMapper();
        Track track = mapper.readValue(multipartFile.getBytes(), Track.class);
        track.setUser(principal.getUsername());
        mongoOps.insert(track);
    }

    /**
     *
     * @return
     */
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
