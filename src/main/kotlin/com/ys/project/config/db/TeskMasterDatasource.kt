package com.ys.project.config.db

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.orm.jpa.JpaTransactionManager
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter
import org.springframework.transaction.PlatformTransactionManager
import java.util.Map
import javax.sql.DataSource

@Configuration
@EnableJpaRepositories(
    basePackages = ["com.ys.project.repository.master"],
    entityManagerFactoryRef = TeskMasterDatasource.ENTITY_MANAGER_FACTORY,
    transactionManagerRef = TeskMasterDatasource.TRANSACTION_MANAGER
)
class TeskMasterDatasource {
    @Bean(ENTITY_MANAGER_FACTORY)
    @Primary
    fun entityManagerFactory(): LocalContainerEntityManagerFactoryBean {
        val em = LocalContainerEntityManagerFactoryBean()
        em.dataSource = datasource()
        em.setPackagesToScan("com.ys.project.entity")
        em.jpaVendorAdapter = HibernateJpaVendorAdapter()
        em.setJpaPropertyMap(
            Map.of(
                "hibernate.show_sql",
                "true",
                "hibernate.format_sql",
                "true",
                "hibernate.use_sql_comments",
                "true",
                "hibernate.physical_naming_strategy",
                "org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy",
                "hibernate.use_query_cache",
                "false",
                "hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect"
            )
        )
        return em
    }

    @Bean(DATA_SOURCE)
    @ConfigurationProperties(prefix = "spring.datasource.master")
    fun datasource(): DataSource {
        return DataSourceBuilder.create().build()
    }

    @Bean(TRANSACTION_MANAGER)
    fun transactionManager(): PlatformTransactionManager {
        val jpaTransactionManager = JpaTransactionManager()
        jpaTransactionManager.entityManagerFactory = entityManagerFactory().getObject()
        return jpaTransactionManager
    }

    companion object {
        const val DATA_SOURCE_NAME = "Master"
        const val DATA_SOURCE = DATA_SOURCE_NAME + "DataSource" // memberDataSource
        const val TRANSACTION_MANAGER = DATA_SOURCE_NAME + "TransactionManager" // memberTransactionManager
        const val ENTITY_MANAGER_FACTORY = DATA_SOURCE_NAME + "EntityManagerFactory" // memberEntityManagerFactory
    }
}