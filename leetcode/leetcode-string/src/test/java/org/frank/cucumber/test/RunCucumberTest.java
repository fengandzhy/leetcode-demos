package org.frank.cucumber.test;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
/**
 * features: 指定Cucumber特性文件的位置，这里是src/test/resources/features目录。
 * glue: 指定步骤定义代码的包名，这里是your_package，你需要将其替换为包含你的步骤定义类的实际包名。
 * plugin: 配置Cucumber报告的插件，比如这里使用的pretty使得控制台输出更易读，html插件生成HTML格式的报告，并保存在target/cucumber-reports目录。
 * monochrome: 设置为true以获得更清晰的控制台输出。
 * strict: 设置为true使得在有未实现的步骤时测试失败。
 * 
 * 
 * */
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
