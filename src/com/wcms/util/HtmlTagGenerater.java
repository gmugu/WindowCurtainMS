package com.wcms.util;

import java.util.Map;

/**
 * Created by Administrator on 2017/1/23.
 */
public class HtmlTagGenerater {

    /**
     * 根据数据生成下拉标签
     *
     * @param data
     * @return
     */
    public static String genSelectTag(Map<String, String> data) {
        StringBuilder st = new StringBuilder("<select>");
        for (String key : data.keySet()) {
            st.append(String.format("<option value =\"%s\">%s</option>", key, data.get(key)));
        }
        st.append("</select>");
        return st.toString();
    }
}
