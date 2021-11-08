package cn.iocoder.yudao.framework.activiti.config;

import lombok.AllArgsConstructor;
import org.activiti.api.runtime.shared.identity.UserGroupManager;
import org.activiti.image.ProcessDiagramGenerator;
import org.activiti.image.impl.DefaultProcessDiagramGenerator;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.ProcessEngineConfigurationConfigurer;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class YudaoActivitiConfiguration {


    /**
     * 流程中生成基于图表交换信息的 svg 的类。 提供绘制方法
     * @return ProcessDiagramGenerator
     */
    @Bean
    public ProcessDiagramGenerator processDiagramGenerator (){
        return new DefaultProcessDiagramGenerator();
    }

    /**
     * ProcessEngineConfigurationConfigurer 实现类，设置使用 MyBatis SqlSessionFactory
     */
    @Component
    @AllArgsConstructor
    public static class SqlSessionFactoryProcessEngineConfigurationConfigurer
            implements ProcessEngineConfigurationConfigurer {

        private final SqlSessionFactory sqlSessionFactory;

        @Override
        public void configure(SpringProcessEngineConfiguration springProcessEngineConfiguration) {
            springProcessEngineConfiguration.setSqlSessionFactory(sqlSessionFactory);
        }

    }


}