package org.mopk.aspect.spring;


import org.apache.log4j.BasicConfigurator;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;


/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-05-25
 * Time: 16:30
 */
public class MainSpringIOCStarterForLoggingOfBeanMethodsByAspects {


    public static void main(String[] args) {

        BasicConfigurator.configure();

        ApplicationContext applicationContext =

                // TODO Aleksandr.Ites at 2015-05-25 19:00 MSK :
                //    Move these comments & commented lines to
                // resource related test of Spring IoC. They have
                // nothing do here (at this test related to logging
                // aspects).

                //    Please see [http://docs.spring.io/spring/
                // /docs/3.0.x/spring-framework-reference/html/
                // /resources.html#resources-app-ctx] for how
                // such paths (see below) works.
                //
                //    See section 4.7.2 for wildcards at paths
                // (Ant-style patterns) especially.
                //

                // This way works.
/*
                new ClassPathXmlApplicationContext(
                        "org/mopk/aspect/spring/springLoggingAspectConfig.xml"
                );
*/

                // And these ways work too.
/*
                new FileSystemXmlApplicationContext(
                    "src/org/mopk/aspect/spring/springLoggingAspectConfig.xml"
                );
*/
                new ClassPathXmlApplicationContext(
                    new String[] { "springLoggingAspectConfig.xml" },
                    MainSpringIOCStarterForLoggingOfBeanMethodsByAspects.class
                );


        BeanWhoseMethodsAreSubjectsToBeLogged bean =
                ( BeanWhoseMethodsAreSubjectsToBeLogged )
                        applicationContext.getBean(
                            "beanWhoseMethodsAreSubjectsToBeLoggedViaAspects"
                        );

        System.out.println(bean);

        bean.doSomething(
                "It's inside 'main(..)'-method.",
                2
        );


        NonBeanWhoseMethodsAreSubjectsToBeLogged
                nonBean =
                    new NonBeanWhoseMethodsAreSubjectsToBeLogged();

        // This call will not be logged by an Spring-aspect
        // because this object is not Spring IoC bean.
        nonBean.doSomething(
                "It's inside 'main(..)'-method."
        );


        BeanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass
            beanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass =
                (BeanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass)
                    applicationContext.getBean(
//                            "beanWhosePublicMethodsAreCalledByObjectsOfInnerAnonymousClass"
                            "successorBeanWhosePublicMethodsAreCalledByObjectsOfInnerAnonymousClass"
                    );

        beanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass
            .methodInstantiatingAndCallingMethodOfObjectOfInnerAnonymousClass();
        beanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass
              .methodToBeLogged(
                    100500,
                    "The method has been called directly (w/o inner class)."
              );
        beanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass
              .methodToBeLoggedViaPublication(
                    100501,
                    "The method has been called directly (w/o inner class) also."
              );
    }

}