package ${packageStr};

import com.yihu.jw.entity.UuidIdentityEntityWithOperator;
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
public class ${className} extends UuidIdentityEntityWithOperator {

${propertiesStr}
${methodStr}

}