package org.mopk.aspect.spring;

/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-06-08
 * Time: 18:57
 */
public class SubclassBeanToTryToAspectIntermediateCall
        extends BeanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass {

    @Override
    public String methodToBeLoggedViaPublication(
            int intParameter,
            String stringParameter
    ) {
        System.out.println(
                "The super-method to be logged via publication have started."
        );
        return "String returned by the super-method.";
    }

}