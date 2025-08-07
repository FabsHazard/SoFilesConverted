package javax.validation.metadata;

import java.util.Set;

public interface CascadableDescriptor {
    Set<GroupConversionDescriptor> getGroupConversions();

    boolean isCascaded();
}
