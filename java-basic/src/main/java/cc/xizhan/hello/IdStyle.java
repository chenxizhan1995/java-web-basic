package cc.xizhan.hello;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p> Description: 标识符风格切换</p>
 *
 * @author chenxizhan(2021 - 05 - 17 9 : 14)
 */
public class IdStyle {
    private final String regexCamelToHyphen = "(?<!^)([A-Z])(?=[a-z])";
        // Pattern 类是多线程安全的, Matcher 类则不是多线程安全的
        private final Pattern patternCamelToHyphen = Pattern.compile(regexCamelToHyphen);

        private final String regexHyphenToCamel = "(_[A-Za-z])";
        private final Pattern patternHyphenToCamel = Pattern.compile(regexHyphenToCamel);
        /**
         * 把驼峰风格的标识符转换为下划线风格的标识符，如 userName -> user_name
         *
         * @param identifier 要进行转换的标识符
         * @return 转换之后的标识符
         */
        public String camelToHyphen(String identifier) {
            Matcher matcher = patternCamelToHyphen.matcher(identifier);
            return matcher.replaceAll("_$1").toLowerCase();
        }

        /** 把下划线风格的标识符转换为驼峰风格，例如 cus_name -> cusName
         *
         * @param identifier    标识符
         * @return  转换后的标识符
         */
        public String hyphenToCamel(String identifier){
            Matcher matcher = patternHyphenToCamel.matcher(identifier);
            StringBuffer sb = new StringBuffer();
            while (matcher.find()) {
                matcher.appendReplacement(sb, matcher.group().substring(1).toUpperCase());
            }
            matcher.appendTail(sb);
            return sb.toString();
        }
}
