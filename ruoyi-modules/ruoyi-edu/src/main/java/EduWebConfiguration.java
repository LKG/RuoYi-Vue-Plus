import org.dromara.common.doc.config.SpringDocConfig;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * edu 模块的 web 组件的 Configuration
 *
 * @author 芋道源码
 */
@Configuration(proxyBeanMethods = false)
public class EduWebConfiguration {
    private static final String GROUP_NAME = "edu";
    /**
     * erp 模块的 API 分组
     */
    @Bean
    public GroupedOpenApi erpGroupedOpenApi() {
        return SpringDocConfig.buildGroupedOpenApi(GROUP_NAME);
    }
}
