package entities;

import java.util.List;

// TODO Wrong class name, it should represented the core idea of the class
public class FormData {
    public List<String> summary;

    public List<String> elements;

    public String color;

    public String metals;

    public List<String> vegetables;

    public void setSummary(List<String> summary) {
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
