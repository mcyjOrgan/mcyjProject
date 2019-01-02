package common.validator;



import com.alibaba.dubbo.common.utils.CollectionUtils;
import common.validator.bean.ValidationResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;



/**
 * dto验证参数类
 * create by cc 2018/04/02
 */
public class ValidationUtils {

    private static final Logger logger = LoggerFactory.getLogger(ValidationUtils.class);

    private static Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();

    public static <T> ValidationResult validateEntity(T obj){
        ValidationResult result = new ValidationResult();
        Map<String,String> errorMsg=null;
        try {
            Set<ConstraintViolation<T>> set = validator.validate(obj,Default.class);
            if(CollectionUtils.isNotEmpty(set) ){
                result.setHasErrors(true);
                errorMsg=new HashMap<>();
                for(ConstraintViolation<T> cv : set){
                    errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
                }
                result.setErrorMsg(errorMsg);
            }
        }catch (Exception e){
            logger.error("unknown err",e);
            assert errorMsg != null;
            errorMsg.put("validation error",e.toString());
            result.setErrorMsg(errorMsg);
        }
        return result;
    }

    public static <T> ValidationResult validateProperty(T obj, String propertyName){
        ValidationResult result = new ValidationResult();
        Map<String,String> errorMsg=null;
        try {
            Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName,Default.class);
            if( CollectionUtils.isNotEmpty(set) ){
                result.setHasErrors(true);
                errorMsg = new HashMap<>();
                for(ConstraintViolation<T> cv : set){
                    errorMsg.put(propertyName, cv.getMessage());
                }
                result.setErrorMsg(errorMsg);
            }
        }catch (Exception e){
            logger.error("unknown err",e);
            assert errorMsg != null;
            errorMsg.put("validation error",e.toString());
            result.setErrorMsg(errorMsg);
        }
        return result;
    }
}
