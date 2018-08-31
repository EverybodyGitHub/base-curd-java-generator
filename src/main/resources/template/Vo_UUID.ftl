package ${packageStr};
import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
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
public class ${className} extends UuidIdentityEntityWithOperator {

${propertiesStr}
${methodStr}

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}