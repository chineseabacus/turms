/*
 * Copyright (C) 2019 The Turms Project
 * https://github.com/turms-im/turms
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package im.turms.turms.constraint;

import im.turms.common.constant.MessageDeliveryStatus;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * @author James Chen
 */
@Target({ElementType.PARAMETER, ElementType.TYPE, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MessageDeliveryStatusConstraint.MessageDeliveryStatusValidator.class)
@Documented
public @interface MessageDeliveryStatusConstraint {

    String message() default "The message delivery status must not be UNRECOGNIZED";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    class MessageDeliveryStatusValidator implements ConstraintValidator<MessageDeliveryStatusConstraint, MessageDeliveryStatus> {

        @Override
        public void initialize(MessageDeliveryStatusConstraint constraintAnnotation) {
        }

        @Override
        public boolean isValid(MessageDeliveryStatus value, ConstraintValidatorContext context) {
            return value != MessageDeliveryStatus.UNRECOGNIZED;
        }

        public static void validate(MessageDeliveryStatus value) {
            if (value == MessageDeliveryStatus.UNRECOGNIZED) {
                throw new IllegalArgumentException("The message delivery status must not be UNRECOGNIZED");
            }
        }
    }
}
