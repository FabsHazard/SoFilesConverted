package javax.validation.metadata;

import java.util.List;
import java.util.Set;
import javax.validation.metadata.ElementDescriptor;

public interface ExecutableDescriptor extends ElementDescriptor {
    ElementDescriptor.ConstraintFinder findConstraints();

    Set<ConstraintDescriptor<?>> getConstraintDescriptors();

    CrossParameterDescriptor getCrossParameterDescriptor();

    String getName();

    List<ParameterDescriptor> getParameterDescriptors();

    ReturnValueDescriptor getReturnValueDescriptor();

    boolean hasConstrainedParameters();

    boolean hasConstrainedReturnValue();

    boolean hasConstraints();
}
