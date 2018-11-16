package configurer;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import dataTableRows.UserTableRow;
import io.cucumber.datatable.DataTableType;

import java.util.Locale;

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return null;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(UserTableRow.class, UserTableRow::createRow));
    }
}
