package org.mopk.aspect.spring;

/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-06-08
 * Time: 18:25
 */
public class SeparateBeanToEnableAspectToAnyIntermediateCall {


    // This way aspect to 'closed'-method works.
    public String methodToWorkaroundAspectToOtherMethod(
            int intParameter,
            String stringParameter
    ) {
        String stringToBeReturned =
                "String returned by the method made "
                            +
                        "to work around 'closed'-method call.";
        return stringToBeReturned;
    }

}
