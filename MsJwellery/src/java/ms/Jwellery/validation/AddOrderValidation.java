/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ms.Jwellery.validation;

import ms.Jwellery.model.AddOrderBean;
import ms.Jwellery.model.OrderDivideBean;
import static ms.Jwellery.validation.UserRegistrationValidation.logger;
import ms.Jwellery.web.AddOrderController;
import ms.Jwellery.web.WokerRegistrationController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Suvh
 */
@Component
public class AddOrderValidation implements Validator {

    @Autowired
    static Logger logger = Logger.getLogger(AddOrderController.class);

    @Override
    public boolean supports(Class<?> c) {
        logger.info("inside support section:::::::::::::");
        return AddOrderBean.class.isAssignableFrom(c);
    }

    @Override
    public void validate(Object o, Errors errors) {
        logger.info("inside validate section:::::::::::::");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "CUSTOMER_ID", "field.CUSTOMER_ID.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "R_NAME", "field.R_NAME.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "TOTAL_QUANTITY", "field.TOTAL_QUANTITY.empty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "order", "field.order.empty");
        logger.info("after empty test");
        AddOrderBean aob = (AddOrderBean) o;
        int a = Integer.parseInt(aob.getTOTAL_QUANTITY());
        String b;
        int f = 0;
        logger.info("after empty test1");
        for (int i = 0; i < aob.getOrder().size(); i++) {
            OrderDivideBean data = aob.getOrder().get(i);
            b = data.getQUANTITY();
            f += Integer.parseInt(b);
            logger.info("after empty test3"+f+" "+a+aob.getCUSTOMER_ID()+aob.getR_NAME());
        }
        if (aob.getTOTAL_QUANTITY() != null) {

            if (a != f) {
                logger.info("after empty test2");
                errors.rejectValue("Quantity", "Quantity.error");
            }

        }
    }

}
