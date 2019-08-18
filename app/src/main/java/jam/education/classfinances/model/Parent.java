package jam.education.classfinances.model;

import java.util.ArrayList;
import java.util.List;

public class Parent {

    private int id;
    private String name;
    private List<String> donationsList = new ArrayList<>();

    public Parent(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDonationsList() {
        return donationsList;
    }

    public void setDonationsList(List<String> donationsList) {
        this.donationsList = donationsList;
    }
}
