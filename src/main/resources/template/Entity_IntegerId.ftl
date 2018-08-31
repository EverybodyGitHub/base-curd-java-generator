package ${packageStr};
import java.io.Serializable;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
${importStr}

/**
 * ${entityDesc}实体
 * 
 * @author ${author} on  ${time}
 *
 */
@Entity
@Table(name = "${tableName}")
public class ${className} extends IntegerIdentityEntity {

${propertiesStr}
${methodStr}

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}