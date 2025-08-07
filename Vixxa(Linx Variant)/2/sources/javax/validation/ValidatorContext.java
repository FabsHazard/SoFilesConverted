package javax.validation;

public interface ValidatorContext {
    ValidatorContext constraintValidatorFactory(ConstraintValidatorFactory constraintValidatorFactory);

    Validator getValidator();

    ValidatorContext messageInterpolator(MessageInterpolator messageInterpolator);

    ValidatorContext parameterNameProvider(ParameterNameProvider parameterNameProvider);

    ValidatorContext traversableResolver(TraversableResolver traversableResolver);
}
