package ${packageStr};

import com.yihu.jw.restmodel.UuidIdentityVOWithOperator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
${importStr}

/**
 * 
 * ${entityDesc}vo
 * 
 * @version 
 * <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  ${time} Created
 *
 * </pre>
 * @since 1.
 */
@ApiModel(value = "${className}", description = "${entityDesc}")
public class ${className} extends UuidIdentityVOWithOperator {

${propertiesStr}
${methodStr}

}