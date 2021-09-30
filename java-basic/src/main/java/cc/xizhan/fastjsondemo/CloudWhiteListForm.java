package cc.xizhan.fastjsondemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p> Description: 贴现自动化审批单对应的实体类</p>
 * <p>
 * 若干主表单字段；一个明细字段。
 */
public class CloudWhiteListForm {
    // 基础信息：流程设计时强制使用的主表单字段
    private String title;   // 审批单标题
    private String serial;  // 审批单序列号
    private String applyName;   // 流程发起人的姓名
    private String deptName;    // 流程发起人所属部门
    private Date applyDate;   // 申请日期

    // 自定义主表单：根据流程需要，客户手动设置的表单字段
    private String reason;      // 事由
    private BusinessTypeEnum businessType;// 业务类型

    enum BusinessTypeEnum {
        WHITE, WHITE_AMOUNT, AMOUNT, AMOUNT_CHANGE;

        public static BusinessTypeEnum fromDesc(String desc) {
            switch (desc) {
                case "贴现白名单申请":
                    return WHITE;
                case "贴现白名单+贴现额度申请":
                    return WHITE_AMOUNT;
                case "贴现额度申请":
                    return AMOUNT;
                case "贴现额度调整":
                    return AMOUNT_CHANGE;
            }
            return null;
        }
    }

    // 明细表单
    List<Customer> detail;

    static class Customer {
        // 明细表单字段，需要进行校验的部分
        private String code;
        private String name;
        private Date startDate;
        private Date endDate;
        private String amount;
        private String amountBeforeChange;
        // 明细表单字段，系统自动填充的部分
        private String checkStatus; // 是否校验通过
        private String description; // 如果不通过，说明原因

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public String getAmount() {
            return amount;
        }

        public void setAmount(String amount) {
            this.amount = amount;
        }

        public String getAmountBeforeChange() {
            return amountBeforeChange;
        }

        public void setAmountBeforeChange(String amountBeforeChange) {
            this.amountBeforeChange = amountBeforeChange;
        }

        public String getCheckStatus() {
            return checkStatus;
        }

        public void setCheckStatus(String checkStatus) {
            this.checkStatus = checkStatus;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public String getApplyName() {
        return applyName;
    }

    public void setApplyName(String applyName) {
        this.applyName = applyName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Date getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Date applyDate) {
        this.applyDate = applyDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BusinessTypeEnum getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BusinessTypeEnum businessType) {
        this.businessType = businessType;
    }

    public List<Customer> getDetail() {
        return detail;
    }

    public void setDetail(List<Customer> detail) {
        this.detail = detail;
    }

    /**
     * 把审批流回调数据转换成实体类
     * <p>
     * 表单字段的 codeId 是随着表单配置的变动而变动的。
     *
     * @param json 存储了表单数据的 json 对象. 是回调数据的完整请求体。
     * @return 实体类。如果解析失败，返回 null
     */
    public static CloudWhiteListForm loadFromJSON(JSONObject json) {
        CloudWhiteListForm form = new CloudWhiteListForm();
        Object widgetMap = JSONPath.eval(json, "$.data.formInfo.widgetMap");
        if (widgetMap instanceof JSONObject) {
            form.loadWidgetMap((JSONObject) widgetMap);
        }
        Object detailMap = JSONPath.eval(json, "$.data.formInfo.detailMap");
        if (detailMap instanceof JSONObject) {
            if (((JSONObject) detailMap).size() > 0) {
                JSONObject detailMapWidget = (JSONObject) ((JSONObject) detailMap).values().toArray()[0];
                form.loadDetail(detailMapWidget);
            }
        }
        return form;
    }
    /**
     *
     * @return
     */
    public JSONObject toDetailJson(){
        JSONArray array = new JSONArray();
        for (int i = 0; i < detail.size(); i++) {
            Customer customer = detail.get(i);
            JSONObject obj = new JSONObject();
            obj.put("_id_", i+1);
            obj.put("明细||贴现额度调整前金额金额(元)", customer.getAmountBeforeChange());
            obj.put("明细||校验状态", customer.getCheckStatus());
            obj.put("明细||说明", customer.getDescription());
            array.add(obj);
        }
        JSONObject widgetValue = new JSONObject();
        widgetValue.put("widgetValue", array);

        JSONObject root = new JSONObject();
        root.put("明细", widgetValue);
        return root;
    }
    // 遍历主表单字段，提取感兴趣的控件的值
    private void loadWidgetMap(JSONObject widgetMap) {
        widgetMap.forEach((codeId, v) -> {
            if (!(v instanceof JSONObject)) {
                return;
            }
            JSONObject widegt = (JSONObject) v;
            String type = widegt.getString("type");
            String title = widegt.getString("title");
            String value = widegt.getString("value");
            // 视组件类型的不同，使用适当的方法提取组件的值
            if (title == null) {
                return;
            }
            switch (title) {
                case "流水号":
                    this.serial = value;
                    break;
                case "标题":
                    this.title = value;
                    break;
                case "提交人":
                    this.applyName = JSONPath.eval(widegt, "$.personInfo[0].name").toString();
                    break;
                case "所属部门":
                    this.deptName = JSONPath.eval(widegt, "$.deptInfo[0].name").toString();
                    break;
                case "申请日期":
                    this.applyDate = new Date(Long.valueOf(value));
                    break;
                case "事由":
                    this.reason = value;
                    break;
                case "业务类型": // 单选框组件
                    String businessTypeStr = getRadioWidgetValue(widegt);
                    this.businessType = BusinessTypeEnum.fromDesc(businessTypeStr);
                    break;
            }
        });
    }

    // 遍历明细表单字段，提取感兴趣的字段值
    private void loadDetail(JSONObject detailMap) {
        // 每个 codeId 对应的 title
        Map<String, String> map = new HashMap<>();
        {
            JSONObject widgetVo = detailMap.getJSONObject("widgetVos");
            widgetVo.forEach((k, v) -> {
                JSONObject def = (JSONObject) v;
                map.put(def.getString("codeId"), def.getString("title"));
            });
        }
        // System.out.println(JSONObject.toJSONString(map, true));

        // 载入明细行
        List<Object> array = detailMap.getJSONArray("widgetValue");
        List<Customer> detailList = array
                .stream()
                .map(o -> (JSONObject) o)
                .map(value -> loadFromDetail(value, map))
                .collect(Collectors.toList());
        this.detail = detailList;

    }

    // 审批单，明细行映射到实体类
    private Customer loadFromDetail(JSONObject value, Map<String, String> map) {

        Customer cust = new Customer();
        value.forEach((k, v) -> {
            String title = map.get(k);
            if (title == null) {
                return;
            }

            switch (title) {
                case "客户编码":
                    cust.setCode(v.toString());
                    break;
                case "客户名称":
                    cust.setName(v.toString());
                    break;
                case "开始日期":
                    cust.setStartDate(new Date((Long) v));
                    break;
                case "结束日期":
                    cust.setEndDate(new Date((Long) v));
                    break;
                case "贴现额度申请金额(元)":
                    cust.setAmount(v.toString());
                    break;
                case "贴现额度调整前金额金额(元)":
                    cust.setAmountBeforeChange(v.toString());
                    break;
                case "校验状态":
                    cust.setCheckStatus(v.toString());
                    break;
                case "说明":
                    cust.setDescription(v.toString());
                    break;
            }
        });
        return cust;

    }

    /**
     * 提取单选框组件的值
     *
     * @param json
     * @return
     */
    private String getRadioWidgetValue(JSONObject json) {
        JSONObject[] options = json.getJSONArray("options").toArray(new JSONObject[0]);
        String value = json.getString("value");
        if (value == null) return null;
        for (JSONObject option : options) {
            String key = option.getString("key");
            if (value.equals(key)) {
                return option.getString("value");
            }
        }
        return null;
    }
}
