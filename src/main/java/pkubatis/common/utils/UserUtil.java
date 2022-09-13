package pkubatis.common.utils;

import com.pkusoft.usercenter.mapper.SysDeptMapper;
import com.pkusoft.usercenter.mapper.SysUserMapper;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysRole;
import com.pkusoft.usercenter.po.SysRoleUser;
import com.pkusoft.usercenter.po.SysUser;
import com.pkusoft.usercenter.service.SysRoleService;
import com.pkusoft.usercenter.service.SysRoleUserService;
import com.pkusoft.usercenter.service.SysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 公共的方法
 *
 * @author Administrator
 */
@Component
public class UserUtil {
    private static Logger logger = LoggerFactory.getLogger(UserUtil.class);

    public static boolean checkId(String id) {
        char[] ch = id.toCharArray();
        boolean flag1 = verForm(id);
        boolean flag2 = verify(ch);
        if (flag1 == true && flag2 == true) {
            return true;
        }
        return false;
    }

    /**
     * 身份证格式的正则校验。
     *
     * @param num
     */
    public static boolean verForm(String num) {
        String reg = "^\\d{15}$|^\\d{17}[0-9Xx]$";
        if (!num.matches(reg)) {
            return false;
        }
        return true;
    }

    /**
     * 身份证最后一位的校验算法。
     *
     * @param id
     */
    public static boolean verify(char[] id) {
        int sum = 0;
        int w[] = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
        char[] ch = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        for (int i = 0; i < id.length - 1; i++) {
            sum += (id[i] - '0') * w[i];
        }
        int c = sum % 11;
        char code = ch[c];
        char last = id[id.length - 1];
        last = last == 'x' ? 'X' : last;
        return last == code;
    }

}
