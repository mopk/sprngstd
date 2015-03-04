package org.mopk;

import java.math.BigInteger;
import java.util.Collection;

/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-03-04
 * Time: 12:59
 */
public class BeanClassWithPropertyOfCollectionTypeInjectedByList {


    // See this collection-field is injected by a list successfully.
    //
    // So the implicit type-conversion of collections
    // works fine for Spring injection.
    //
    private Collection<BigInteger> propertyWhichShouldBeInjectedByList;


    public void setPropertyWhichShouldBeInjectedByList(
            Collection<BigInteger> propertyWhichShouldBeInjectedByList
    ) {
        this.propertyWhichShouldBeInjectedByList =
                                    propertyWhichShouldBeInjectedByList;
    }

}