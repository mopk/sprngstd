package org.mopk.aspect.spring;

/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-05-25
 * Time: 17:57
 */
public class BeanWhoseMethodsAreSubjectsToBeLogged {


    /* ПОЛЯ */

    private String id = "default ID";


    /* МЕТОДЫ */

    // TODO 2015-06-01 18:56 :
    // To make a test showing Java-annotations of an aspect-object
    // method are lost if AOP-proxy used.
    public NonBeanWhoseMethodsAreSubjectsToBeLogged doSomething(
            String stringParameter,
            int intParameter
    ) {
        return null;
    }

    protected String doSomethingElse(
            NonBeanWhoseMethodsAreSubjectsToBeLogged nonBean,
            BeanWithoutToStringMethodDefined beanWithoutToString
    ) {
        return null;
    }

    protected void doSomethingVoid(

    ) {
        return;
    }

    private String doSomethingPrivate() {
        return null;
    }


    /* ТРИВИАЛЬНЫЕ методы */

    @Override
    public String toString() {

        //    For this call aspect will never be called due
        // 'toString()'-method also has aspect. See the pointcut
        // "execution(public * org.mopk.aspect.spring.*.*(..))"
        // at 'springLoggingAspectConfig.xml'.
        doSomething(
                "It's inside 'toString(..)'-method.",
                1
        );

        return "BeanWhoseMethodsAreSubjectsToBeLogged{" +
                "id='" + id + '\'' +
                '}';
    }

}