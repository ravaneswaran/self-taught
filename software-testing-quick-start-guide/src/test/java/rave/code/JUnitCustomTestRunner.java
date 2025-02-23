package rave.code;

import org.junit.Test;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;

import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JUnitCustomTestRunner extends Runner {

    private Class testClass;

    private Logger logger;

    public JUnitCustomTestRunner(Class testClass) {
        super();
        this.testClass = testClass;
        this.logger = Logger.getLogger(JUnitCustomTestRunner.class.getName());
    }

    @Override
    public Description getDescription() {
        return Description
                .createTestDescription(this.testClass, "JUnitCustomTestRunner in action....");
    }

    @Override
    public void run(RunNotifier runNotifier) {
        this.logger.log(Level.INFO, "running the tests from "+this.testClass.getName());
        try {
            Object testObject = this.testClass.newInstance();
            for (Method method : this.testClass.getMethods()) {
                if (method.isAnnotationPresent(Test.class)) {
                    runNotifier.fireTestStarted(Description
                            .createTestDescription(testClass, method.getName()));
                    method.invoke(testObject);
                    runNotifier.fireTestFinished(Description
                            .createTestDescription(testClass, method.getName()));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
