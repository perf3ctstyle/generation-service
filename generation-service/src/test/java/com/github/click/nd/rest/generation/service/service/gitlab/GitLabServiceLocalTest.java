package com.github.click.nd.rest.generation.service.service.gitlab;

import com.github.click.nd.rest.generation.service.domain.DataType;
import com.github.click.nd.rest.generation.service.service.generation.ApiDefinitionService;
import com.github.click.nd.rest.generation.service.service.generation.BaseCodeGeneratorTest;
import com.github.click.nd.rest.generation.service.util.SecurityUtil;
import java.util.List;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Local test for gitlab service. To run this test you need to attach personal Gitlab token to the run
 * environment: <a href="https://docs.gitlab.com/ee/user/profile/personal_access_tokens.html">gitlab documentation about where to get it</a>.
 */
public class GitLabServiceLocalTest extends BaseCodeGeneratorTest {

    @Autowired
    private ApiDefinitionService apiDefinitionService;

    @Test
    @Disabled
    public void pushCodeLocally() {
        var apiDefinition = apiDefinition(
                "My awesome definition",
                List.of(rawResource("flower",
                        List.of(
                                resourceField("color", DataType.STRING),
                                resourceField("name", DataType.STRING)
                        )
                ))
        );

        try (var mockedStatic = Mockito.mockStatic(SecurityUtil.class)) {
            mockedStatic.when(SecurityUtil::getUserId).thenReturn("eugen");
            apiDefinitionService.generateCodeIfDefinitionNotPushed(apiDefinition);
        }
    }
}
