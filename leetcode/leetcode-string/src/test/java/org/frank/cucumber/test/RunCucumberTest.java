package org.frank.cucumber.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// 配置Cucumber选项
@CucumberOptions(
        features = "src/test/resources/features", // 指定特性文件的位置
        glue = "org.frank.cucumber.test",                    // 指定步骤定义的包名
        plugin = {"pretty", "html:target/cucumber-reports"}, // 输出报告的格式和位置
        monochrome = true,                        // 控制台输出的可读性
        strict = true                             // 未定义步骤时测试是否会失败
)
public class RunCucumberTest {
    
}
