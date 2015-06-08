/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-06-08
 * Time: 16:59
 */
package org.mopk.aspect.spring;

import java.math.BigInteger;


/**
 *
 */
public class BeanWhosePublicMethodIsCalledByObjectsOfInnerAnonymousClass {


    /* FIELDS */

    private SeparateBeanToEnableAspectToAnyIntermediateCall
                            separateBeanToEnableAspectToIntermediateCall;


    /* METHODS are BELOW */

    public String methodToBeLogged(
            int intParameter,
            String stringParameter
    ) {
        return "String returned by the method.";
    }

    protected String methodToBeLoggedViaPublication(
            int intParameter,
            String stringParameter
    ) {
        return null;
    }

    public String methodToBeLoggedViaNestedCallToSeparateBean(
            int intParameter,
            String stringParameter
    ) {
        String resultToBeReturned =
                separateBeanToEnableAspectToIntermediateCall
                        .methodToWorkaroundAspectToOtherMethod(
                                intParameter,
                                stringParameter
                        );
        return resultToBeReturned;
    }


    public void
        methodInstantiatingAndCallingMethodOfObjectOfInnerAnonymousClass() {

        BigInteger objectOfInnerAnonymousClass =
            new BigInteger("1") {

                @Override
                public BigInteger add(BigInteger bigInteger) {

                    /**
                         See logging aspect for this call does not work.
                       It seems while debugger shows this call below is
                       directed to the same bean (to the same object at
                       JVM) as the call made from main entry point, but
                       such 'closed'-call by-passes CGLIB-proxy made by
                       Spring AOP.
                     */
                    methodToBeLogged(
                            2,
                            "stringParameterPassedToClosedMethodToBeLogged"
                    );

                    methodToBeLoggedViaNestedCallToSeparateBean(
                            2,
                            "stringParameterPassedToClosedMethodToBeLogged"
                    );

                    methodToBeLoggedViaPublication(
                            2,
                            "stringParameterPassedToClosedMethodToBeLogged"
                    );

                    return BigInteger.TEN;
                }
            };

        objectOfInnerAnonymousClass.add( new BigInteger("2") );
    }


    /* TRIVIAL METHODS are BELOW ONLY */

    public void setSeparateBeanToEnableAspectToIntermediateCall(
            SeparateBeanToEnableAspectToAnyIntermediateCall
                    separateBeanToEnableAspectToAnyIntermediateCall
    ) {
        this.separateBeanToEnableAspectToIntermediateCall =
                separateBeanToEnableAspectToAnyIntermediateCall;
    }

}