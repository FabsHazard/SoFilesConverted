package javax.validation;

public interface ConstraintValidatorContext {

    public interface ConstraintViolationBuilder {

        public interface LeafNodeBuilderCustomizableContext {
            ConstraintValidatorContext addConstraintViolation();

            LeafNodeContextBuilder inIterable();
        }

        public interface LeafNodeBuilderDefinedContext {
            ConstraintValidatorContext addConstraintViolation();
        }

        public interface LeafNodeContextBuilder {
            ConstraintValidatorContext addConstraintViolation();

            LeafNodeBuilderDefinedContext atIndex(Integer num);

            LeafNodeBuilderDefinedContext atKey(Object obj);
        }

        public interface NodeBuilderCustomizableContext {
            LeafNodeBuilderCustomizableContext addBeanNode();

            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);

            NodeBuilderCustomizableContext addPropertyNode(String str);

            NodeContextBuilder inIterable();
        }

        public interface NodeBuilderDefinedContext {
            LeafNodeBuilderCustomizableContext addBeanNode();

            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);

            NodeBuilderCustomizableContext addPropertyNode(String str);
        }

        public interface NodeContextBuilder {
            LeafNodeBuilderCustomizableContext addBeanNode();

            ConstraintValidatorContext addConstraintViolation();

            NodeBuilderCustomizableContext addNode(String str);

            NodeBuilderCustomizableContext addPropertyNode(String str);

            NodeBuilderDefinedContext atIndex(Integer num);

            NodeBuilderDefinedContext atKey(Object obj);
        }

        LeafNodeBuilderCustomizableContext addBeanNode();

        ConstraintValidatorContext addConstraintViolation();

        NodeBuilderDefinedContext addNode(String str);

        NodeBuilderDefinedContext addParameterNode(int i);

        NodeBuilderCustomizableContext addPropertyNode(String str);
    }

    ConstraintViolationBuilder buildConstraintViolationWithTemplate(String str);

    void disableDefaultConstraintViolation();

    String getDefaultConstraintMessageTemplate();

    <T> T unwrap(Class<T> cls);
}
