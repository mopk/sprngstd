package org.mopk.aspect.spring;


/**
 * Created by: Aleksandr.Ites (alit0714)
 * Date: 2015-05-28
 * Time: 17:36
 */
public enum LogMessages {


    ENTER(
            "Start method \"{}\" with arguments: {}"
    ),
    LEAVE(
            "End method \"{}\". Result is {}"
    ),
    HANDLE_OBJECT(
            "Handle Object {}({})"
    ),
    PARENT(
            "Get parent of {}({}). Result is {}({})"
    ),
    CHILDREN_OF(
            "Get children of {}({}) by type {}. Result is {}"
    ),
    OBJECT_CREATED(
            "New object was created: {}({})"
    ),
    OBJECT_UPDATED(
            "Object {}({}) was updated"
    ),
    OBJECT_DELETED(
            "Object {}({}) was deleted"
    );


    private final String pattern;


    /**
     * @param pattern pattern string.
     */
    LogMessages(final String pattern) {
        this.pattern = pattern;
    }

    public String get() {
        return pattern;
    }

}