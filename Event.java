package model;
import java.sql.Date;

public class Event {
    private int id;
    private String name;
    private String location;
    private Date date;

    public Event(int id, String name, String location, Date date) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.date = date;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public Date getDate() { return date; }
}
