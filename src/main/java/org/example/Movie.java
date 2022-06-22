package org.example;

public class Movie {
    private int uniqueIdNumber;
    private String title;
    private String leadActor;


    public Movie(int uniqueIdNumber, String title, String leadActor)
    {
        this.uniqueIdNumber = uniqueIdNumber;
        this.title = title;
        this.leadActor = leadActor;
    }

    @Override
    public String toString() {
        return "ID: " + uniqueIdNumber + "\n" + "Title: " + title + "\n" +
                "Lead Actor: " + leadActor;
    }

    public int getUniqueIdNumber() {
        return uniqueIdNumber;
    }

    public String getLeadActor() {
        return leadActor;
    }

    public String getTitle() {
        return title;
    }
}
