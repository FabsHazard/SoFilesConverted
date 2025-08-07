package javax.validation;

import javax.validation.metadata.ConstraintDescriptor;

public interface ConstraintViolation<T> {
    ConstraintDescriptor<?> getConstraintDescriptor();

    Object[] getExecutableParameters();

    Object getExecutableReturnValue();

    Object getInvalidValue();

    Object getLeafBean();

    String getMessage();

    String getMessageTemplate();

    Path getPropertyPath();

    T getRootBean();

    Class<T> getRootBeanClass();

    <U> U unwrap(Class<U> cls);
}
