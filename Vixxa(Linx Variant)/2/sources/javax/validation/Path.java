package javax.validation;

import java.util.List;

public interface Path extends Iterable<Node> {

    public interface BeanNode extends Node {
    }

    public interface ConstructorNode extends Node {
        List<Class<?>> getParameterTypes();
    }

    public interface CrossParameterNode extends Node {
    }

    public interface MethodNode extends Node {
        List<Class<?>> getParameterTypes();
    }

    public interface Node {
        <T extends Node> T as(Class<T> cls);

        Integer getIndex();

        Object getKey();

        ElementKind getKind();

        String getName();

        boolean isInIterable();
    }

    public interface ParameterNode extends Node {
        int getParameterIndex();
    }

    public interface PropertyNode extends Node {
    }

    public interface ReturnValueNode extends Node {
    }
}
