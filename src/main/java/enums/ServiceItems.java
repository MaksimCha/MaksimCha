package enums;

import java.util.ArrayList;
import java.util.List;

public enum ServiceItems {
    FIRST_SERVICE_BUTTON("Support"),
    SECOND_SERVICE_BUTTON("Dates"),
    THIRD_SERVICE_BUTTON("Complex Table"),
    FOURTH_SERVICE_BUTTON("Simple Table"),
    FIFTH_SERVICE_BUTTON("User Table"),
    SIXTH_SERVICE_BUTTON("Table with pages"),
    SEVENTH_SERVICE_BUTTON("Different elements"),
    EIGHTH_SERVICE_BUTTON("Performance");

    private String serviceItemTitle;

    public String getTitle() {
        return serviceItemTitle;
    }

    ServiceItems(String serviceItemTitle) {
        this.serviceItemTitle = serviceItemTitle.toUpperCase();
    }

    public static List<String> getServiceItemTitles() {
        List<String> serviceItemTitles = new ArrayList<>();
        for (ServiceItems item : ServiceItems.values()) {
            serviceItemTitles.add(item.getTitle());
        }
        return serviceItemTitles;
    }
}
