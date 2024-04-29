package org.frank.cucumber.test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

/**
 * calculator.feature 文件和 CalculatorSteps.java 类之间的关系是：calculator.feature 定义了需要测试的具体行为场景，而 CalculatorSteps.java 则包含了这些行为的实现步骤，
 * 即步骤定义。这两者共同构成了BDD测试的基础。
 *
 * calculator.feature 的作用：
 * 定义行为：calculator.feature 文件使用Gherkin语言描述了一系列的用户故事或场景，这些场景用自然语言以 Given-When-Then 的格式来表达软件应该如何响应特定的操作或条件。
 * 沟通工具：它作为开发人员、测试人员和业务参与者之间沟通的桥梁，确保每个人都对软件的预期行为有共同的理解。
 * 测试基础：特性文件提供了自动化测试的基础，Cucumber等工具将读取这些文件，解释其中的场景，然后在自动化测试运行时查找对应的步骤定义来执行。
 * 
 * CalculatorSteps.java 的作用：
 * 实现步骤：CalculatorSteps.java 中的Java方法直接对应于 calculator.feature 文件中定义的每个步骤（如 "Given the calculator is run"）。这些Java方法中包含了实际执行测试的代码。
 * 桥接代码和行为：步骤定义类将自然语言转换为可执行的代码，它桥接了行为描述和实际的代码逻辑。
 * 执行测试逻辑：当Cucumber运行特性文件中的场景时，它会匹配并执行 CalculatorSteps.java 中对应的方法来验证定义的行为是否正确。
 * 综上，calculator.feature 定义了应该如何测试，而 CalculatorSteps.java 实现了测试的具体操作。在Cucumber框架中，
 * 特性文件是测试的出发点，它驱动测试的编写和执行；步骤定义是将这些描述转化为实际测试动作的关键。
 * 
 * */
public class CalculatorSteps {
    private Calculator calculator;
    private int result;

    @Given("the calculator is run")
    public void the_calculator_is_run() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(int num1, int num2) {
        result = calculator.add(num1, num2);
    }

    @Then("the result should be {int}")
    public void the_result_should_be(int expected) {
        assertEquals(expected, result);
    }
}

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }
}
