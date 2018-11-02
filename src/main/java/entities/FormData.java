package entities;

import java.util.List;

public class FormData {
    public List<Integer> summary;

    public List<String> elements;

    public String color;

    public String metals;

    public List<String> vegetables;

    public void setSummary(List<Integer> summary) {
        this.summary = summary;
    }

    public void setElements(List<String> elements) {
        this.elements = elements;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setMetals(String metals) {
        this.metals = metals;
    }

    public void setVegetables(List<String> vegetables) {
        this.vegetables = vegetables;
    }
}
