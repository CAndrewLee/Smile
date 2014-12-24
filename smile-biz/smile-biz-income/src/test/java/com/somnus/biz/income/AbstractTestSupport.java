package com.somnus.biz.income;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * @author caobin
 * @version 1.0
 * @Description 后台单元测试基类
 * @date 2012-11-19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-basic.xml")
@ActiveProfiles("dev")
public abstract class AbstractTestSupport {
    protected transient Logger log = LoggerFactory.getLogger(this.getClass());

    @Rule
    public TestName name = new TestName();

    @Before
    public void setUp() {
        log.info("调用测试方法: {}", new Object[]{name.getMethodName()});
    }

    @After
    public void tearDown() {
    }
}
