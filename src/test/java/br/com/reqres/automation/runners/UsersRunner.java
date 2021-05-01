package br.com.reqres.automation.runners;

import br.com.reqres.automation.core.BaseTestCase;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;

@CucumberOptions(tags = {"@AllCenarios"},
        features = "src/test/java/br/com/reqres/automation/features/users.feature",
        glue = {"br.com.reqres.automation.steps.users"},
        snippets = SnippetType.CAMELCASE)
public class UsersRunner extends BaseTestCase {
}
