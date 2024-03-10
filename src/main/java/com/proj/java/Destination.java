package com.proj.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Destination {
    public final String name;
    private final List<Activity> activities;


    public Destination(String name) {
        this.name = name;
        this.activities = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public List<Activity> getActivities() {
        return activities;
    }


    public void addActivity(Activity activity) {
        activities.add(activity);
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Destination other = (Destination) obj;
        return Objects.equals(this.name, other.name);
    }

    public void setActivities(List<Activity> activities) {
        if (activities == null) {
            throw new NullPointerException("Activities cannot be null.");
        }
        this.activities.clear();
        this.activities.addAll(activities);
    }



}
