package ${packageStr};

import ${ServicePackageStr}.${entityName}Service;
import ${baseEntityVOPackageStr}.${entityName}VO;
import ${baseEnvelopPackageStr}.Envelop;
import ${baseEnvelopPackageStr}.ListEnvelop;
import ${baseEnvelopPackageStr}.ObjEnvelop;
import ${baseEnvelopPackageStr}.PageEnvelop;
import ${baseEnvelopPackageStr}.endpoint.EnvelopRestEndpoint;
import com.yihu.jw.rm.base.BaseRequestMapping;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.List;

${importStr}

/**
*
* ${entityDesc}Dao
*
* @version
* <pre>
 * Author	Version		Date		Changes
 * ${author} 	1.0  		${time} 	Created
 *
 * </pre>
* @since 1.
*/
@RestController
@RequestMapping(value = ${baseRequestMappingName}.${entityName}.PREFIX)
@Api(value = "${entityDesc}管理", description = "${entityDesc}管理服务接口", tags = {"wlyy基础服务 - ${entityDesc}管理服务接口"})
public class ${ClassName} extends EnvelopRestEndpoint {

@Autowired
private ${entityName}Service ${entityVarName}Service;

@PostMapping(value = ${baseRequestMappingName}.${entityName}.CREATE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
@ApiOperation(value = "创建")
public ObjEnvelop<${entityName}VO> create (
    @ApiParam(name = "json_data", value = "Json数据", required = true)
    @RequestBody String jsonData) throws Exception {
    ${entityName}DO ${entityVarName} = toEntity(jsonData, ${entityName}DO.class);
    ${entityVarName} = ${entityVarName}Service.save(${entityVarName});
    return success(${entityVarName}, ${entityName}VO.class);
    }

    @PostMapping(value = ${BaseRequestMappingName}.${entityName}.DELETE)
    @ApiOperation(value = "删除")
    public Envelop delete(
    @ApiParam(name = "ids", value = "id串，中间用,分隔", required = true)
    @RequestParam(value = "ids") String ids) {
    ${entityVarName}Service.delete(ids.split(","));
    return success("删除成功");
    }

    @PostMapping(value = ${baseRequestMappingName}.${entityName}.UPDATE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiOperation(value = "更新")
    public ObjEnvelop<${entityName}VO> update (
        @ApiParam(name = "json_data", value = "Json数据", required = true)
        @RequestBody String jsonData) throws Exception {
        ${entityName}DO ${entityVarName} = toEntity(jsonData, ${entityName}DO.class);
        if (null == ${entityVarName}.getId()) {
        return failed("ID不能为空", ObjEnvelop.class);
        }
        ${entityVarName} = ${entityVarName}Service.save(${entityVarName});
        return success(${entityVarName}, ${entityName}VO.class);
        }

        @GetMapping(value = ${baseRequestMappingName}.${entityName}.PAGE)
        @ApiOperation(value = "获取分页")
        public PageEnvelop<${entityName}VO> page (
            @ApiParam(name = "fields", value = "返回的字段，为空返回全部字段")
            @RequestParam(value = "fields", required = false) String fields,
            @ApiParam(name = "filters", value = "过滤器，为空检索所有条件")
            @RequestParam(value = "filters", required = false) String filters,
            @ApiParam(name = "sorts", value = "排序，规则参见说明文档")
            @RequestParam(value = "sorts", required = false) String sorts,
            @ApiParam(name = "page", value = "分页大小", required = true, defaultValue = "1")
            @RequestParam(value = "page") int page,
            @ApiParam(name = "size", value = "页码", required = true, defaultValue = "15")
            @RequestParam(value = "size") int size) throws Exception {
            List<${entityName}DO> ${entityVarName}s = ${entityVarName}Service.search(fields, filters, sorts, page, size);
                int count = (int)${entityVarName}Service.getCount(filters);
                return success(${entityVarName}s, count, page, size, ${entityName}VO.class);
                }

         @GetMapping(value = ${baseRequestMappingName}.${entityName}.LIST)
         @ApiOperation(value = "获取列表")
         public ListEnvelop<${entityName}VO> list (
             @ApiParam(name = "fields", value = "返回的字段，为空返回全部字段")
             @RequestParam(value = "fields", required = false) String fields,
             @ApiParam(name = "filters", value = "过滤器，为空检索所有条件")
             @RequestParam(value = "filters", required = false) String filters,
             @ApiParam(name = "sorts", value = "排序，规则参见说明文档")
             @RequestParam(value = "sorts", required = false) String sorts) throws Exception {
             List<${entityName}DO> ${entityVarName}s = ${entityVarName}Service.search(fields, filters, sorts);
                  return success(${entityVarName}s, ${entityName}VO.class);
                  }

 }
