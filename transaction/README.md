### spring多数据源事务

#### 不同数据源必须采用不同事务 ####
spring中的数据源1：
```xml
<!-- 数据源 -->
<bean id="dataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
  <property name="jndiName">
    <value>${test1}</value>
  </property>
</bean>

<bean id="dataSourceProxy" class="org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy">
  <property name="targetDataSource" ref="dataSource" />
</bean>

<bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
  <constructor-arg ref="dataSourceProxy" />
</bean>

<!-- 事务管理器配置 -->
<bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <property name="dataSource" ref="dataSourceProxy" />
</bean>

<!-- 开启事务注解方式注入 -->
<tx:annotation-driven transaction-manager="transactionManager" />
```
spring中的数据源2
```xml
<!-- 日志数据源开始 -->
<bean id="testDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
  <property name="jndiName">
    <value>${test2}</value>
  </property>
</bean>

<bean id="testDataSourceProxy" class="org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy">
  <property name="targetDataSource" ref="testDataSource" />
</bean>

<bean id="logJdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
  <constructor-arg ref="testDataSourceProxy" />
</bean>

<!-- 事务管理器配置 -->
<bean id="testTransactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
  <property name="dataSource" ref="testDataSourceProxy" />
</bean>

<tx:advice id="testTxAdvice" transaction-manager="testTransactionManager">
  <tx:attributes>
    <tx:method name="*" rollback-for="Exception" />
  </tx:attributes>
</tx:advice>

<!-- 事务在@testTransactional注解方法中起作用 -->
<aop:config>
  <aop:pointcut id="testTxOperation" expression="@annotation(com.ztesoft.zop.service.annotation.testTransactional)" />
  <aop:advisor advice-ref="testTxAdvice" pointcut-ref="testTxOperation" />
</aop:config>
```
