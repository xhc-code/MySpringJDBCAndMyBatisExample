package org.example.config;

import org.springframework.data.jdbc.mybatis.NamespaceStrategy;
import org.springframework.util.ResourceUtils;

/**
 * 自定义mybatis策略
 */
public class MyBatisNamespaceStraegy implements NamespaceStrategy {

    @Override
    public String getNamespace(Class<?> domainType) {
        return "org.example.mapper.".concat(domainType.getSimpleName()).concat("Mapper");
    }
}
