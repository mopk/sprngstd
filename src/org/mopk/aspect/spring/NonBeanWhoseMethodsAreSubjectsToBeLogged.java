package org.mopk.aspect.spring;

/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-05-27
 * Time: 17:29
 */
public class NonBeanWhoseMethodsAreSubjectsToBeLogged {

    public String doSomething(
            String stringParameter
    ) {
        return "End of method's call.";
    }

}
