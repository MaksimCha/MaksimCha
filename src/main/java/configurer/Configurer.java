package configurer;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;
import dataTableRows.UserTableRow;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

public class Configurer implements TypeRegistryConfigurer {

    @Override
    public Locale locale() {
        return null;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {

        registry.defineDataTableType(new DataTableType(UserTableRow.class, new TableEntryTransformer<UserTableRow>() {
            @Override
            public UserTableRow transform(Map<String, String> entry) {
                return UserTableRow.createRow(entry);
            }
        }));
    }
}
