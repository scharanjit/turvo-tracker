package com.turvo.demo.tracks.track;

import java.io.Serializable;

public class Driver implements Serializable {

    private String name;

    private String uniqueId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

}
