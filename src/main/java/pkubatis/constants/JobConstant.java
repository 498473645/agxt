package pkubatis.constants;
/**
 * 状态
 * @author Administrator
 *
 */
public class JobConstant {
    /**
     * 未知状态
     */
    public final static String WEIZHISTATUS = "0000";
    /**
     * 已提请逮捕
     */
    public final static String TQDBSTATUS = "0200";
    /**
     * 已移送起诉
     */
    public final static String YSQSSTATUS = "0300";
    /**
     * 在办（非主办人）(就是接收案卷审核中)
     */
    public final static String JSAJSTATUS = "0110";
    /**
     * 已移交（非主办人）
     */
    public final static String YIYIJIAO_FEIZHUBANREN = "0115";
    /**
     * 审核完成已归还
     */
    public final static String GHAJSTATUS = "0120";

    /**
     * 在办（主办人）(就是普通状态)
     */
    public final static String PUTONGSTATUS = "0010";
    /**
     * 已归档
     */
    public final static String GUIDANGSTATUS = "9000";
    /**
     * 已作废
     */
    public final static String ZUOFEISTATUS = "9999";
    /**
     * 已移送审核
     */
    public final static String YIYISONGSHENHESTATUS = "0100";



    /**
     * 案件状态表
     */
    /**
     * 已建卷
     */
    public final static String YJJ = "1111";
    public final static String YJJMC = "已建卷";
    /**
     * 已电子化
     */
    public final static String YDZH = "2222";
    public final static String YDZHMC = "已电子化";
    /**
     * 已入柜
     */
    public final static String YRG = "3333";
    public final static String YRGMC = "已入柜";

    /**
     * 已建卷
     */
    public final static String YJJ_1 = "1";
    /**
     * 已电子化
     */
    public final static String YDZH_1 = "1";
    /**
     * 未入柜
     */
    public final static String wRG_0 = "0";
    /**
     * 已入柜
     */
    public final static String YRG_1 = "1";
    /**
     * 已删除
     */
    public final static String YSC_1 = "1";
    /**
     * 未删除
     */
    public final static String WSC_0 = "0";
    /**
     * 案件类型
     */
    /**
     * 刑事案卷
     */
    public final static String XINGSHI="0100";
    /**
     * 行政案卷
     */
    public final static String XINGZHENG="0200";
    /**
     * 行政复议案卷
     */
    public final static String XINGZHENGFUYI="0210";
    /**
     * 行政案件复议复核
     */
    public final static String XINGZHENGFUYIFUHE="0211";
    /**
     * 国家赔偿案卷
     */
    public final static String GUOJIAPEICHANG="0220";
    /**
     * 国家赔偿复议复核
     */
    public final static String GUOJIAPEICHANGFUYIFUHE="0221";
    /**
     * 行政诉讼案卷
     */
    public final static String XINGZHENGSS="0230";
    /**
     * 刑事复议案卷
     */
    public final static String XINGSHIFUYI="0240";
    /**
     * 刑事案件复议复核
     */
    public final static String XINGSHIFUYIFUHE="0241";
    /**
     * 其他案卷
     */
    public final static String QITA="9999";


    public static String changeType(String type){
		if(type.equals("0100")){
			return "刑事案件";
		}else if(type.equals("0200")){
			return "行政案件";
		}else if(type.equals("0210")){
			return "行政复议";
		}else if(type.equals("0220")){
			return "国家赔偿";
		}else if(type.equals("0230")){
			return "行政诉讼";
		}else if(type.equals("0211")){
			return "行政案件复议复核";
		}else if(type.equals("0221")){
			return "国家赔偿复议复核";
		}else if(type.equals("0241")){
			return "刑事案件复议复核";
		}else{
			return "其他";
		}
	}

    /**
     * 案卷权限表(FILE_AUTH.OperType)
     */
    /**
     * 办案者(主办人和协办人)
     */
    public final static String BANANZHE="0100";
    /**
     * 移交者(除主办人和协办人之外的)
     */
    public final static String YIJIAOZHE="0200";
    /**
     * 接收者(任何人)
     */
    public final static String JIESHOUZHE="0300";


    /**
     * 案卷页回收记录表
     */
    /**
     * 数据操作类型,作废且物理删除
     */
    public final static String ZUOFEISHANCHU="0010";



    /**
     *以下为操作类型(请不要把状态写到下面)
     */
    /**
     * 新建案卷
     */
    public final static String XJAJ = "0010";
    /**
     * 扫描采集
     */
    public final static String SMCJ = "0020";

    /**
     * 删除案卷页
     */
    public final static String SCAJY = "0520";
    /**
    /**
     * 案卷阅览
     */
    public final static String AJYL = "0100";
    /**
     * 制作条码
     */
    public final static String ZZTM = "0200";
    /**
     * 案卷归档
     */
    public final static String AJGD = "0300";
    /**
     * 归档阅卷
     */
    public final static String AJGD_DC_YJ = "0310";
    /**
     * 案卷撤销归档
     */
    public final static String AJGD_DC = "0320";
    /**
     * 案卷刻录
     */
    public final static String AJKL = "0400";
    /**
     * 案卷打印
     */
    public final static String  PRINT = "0500";
    /**
     * 移送审核
     */
    public final static String YSSH = "1010";
    /**
     * 移交案卷
     */
    public final static String YJAJUAN = "1020";
    /**
     * 移交案件
     */
    public final static String YJAJIAN = "1030";

    /**
     * 归还案卷
     */
    public final static String GHAJ = "2000";
    /**
     * 接收案卷
     */
    public final static String JSAJ = "3000";
    /**
     * 接收案卷（移交）
     */
    public final static String JSAJYJ = "3010";
    /**
     * 接收案卷（归还）
     */
    public final static String JSAJGH = "3020";
    /**
     * 接收案卷（移交案卷）
     */
    public final static String JSYJAJU = "3030";
    /**
     * 接收案卷（移交案件）
     */
    public final static String JSYJAJI = "3040";
    /**
     * 案卷存取
     */
    public final static String AJCQ = "3050";
    /**
     * 提请逮捕
     */
    public final static String TQDB = "4010";
    /**
     * 移送起诉
     */
    public final static String YSQS = "4020";
    /**
     * 补充侦查
     */
    public final static String BCZC= "5000";
    /**
     * 案卷借阅
     */
    public final static String AJJY="6001";
    /**
     * 笔录智查
     */
    public final static String BLZC="8000";
    /**
     * 开柜
     */
    public final static String KG = "9000";
    /**
     * 变更存放位置
     */
    public final static String BIANGENGCUNFANGWEIZHI = "9010";
    /**
     * 物品存入
     */
    public final static String WPCR = "0601";
    /**
     * 物品取出
     */
    public final static String WPQC = "0602";
    /**
     * 案卷入柜
     */
    public final static String AJRG = "9020";

    /**
     * 案卷柜配置
     */
    public final static String DELETE_SPACE = "9030";
    /// <summary>
    /// 操作类型/业务类型：案卷作废
    /// </summary>
    public final static String AJZF_9999 = "9999";
    /// <summary>
    /// 操作类型/业务类型：作废恢复
    /// </summary>
    public final static String ZFHF_9998 = "9998";
    /**
     * 是否采集(已采集,在扫描采集里有使用)
     */
    public final static Integer ISSCAN=1;
    /**
     * 主办人
     */
    public final static String ZBR="0100";
    /**
     * 协办人check
     */
    public final static String XBR="0200";

    /**
     * 更改材料(web端案卷采集功能中用到)
     */
    public final static String CHANGE_METAL="0510";
    /**
     * 增加材料目录(web端案卷采集功能中用到)
     */
    public final static String ADD_METAL="0610";
    /**
     * 变更案卷类型(web变更案卷类型功能中用到)
     */
    public final static String CHANGE_PROPERTY="6000";

    /**
     * 案卷柜空间
     */
    /**
     * 公共
     */
    public final static String GONGGONG="0010";
    /**
     * 私有
     */
    public final static String SIYOU="0100";
    /**
     * 其他
     */
    public final static String ANJUANGUI_QITA="9999";
    /**
     * 空，关
     */
    public final static String KONG_GUAN="0000";
    /**
     * 空，开
     */
    public final static String KONG_KAI="0010";
    /**
     * 空，关，加密
     */
    public final static String KONG_GUAN_JIAMI="0020";
    /**
     * 空，开，加密
     */
    public final static String KONG_KAI_JIAMI="0030";
    /**
     * 已存放，关
     */
    public final static String YICUNFANG_GUAN="0100";


    /**
     * 已存放，开
     */
    public final static String YICUNFANG_KAI="0110";
    /**
     * 已存放，关，加密
     */
    public final static String YICUNFANG_GUAN_JIAMI="0120";
    /**
     * 已存放，开，加密
     */
    public final static String YICUNFANG_KAI_JIAMI="0130";
    /**
     * 满，关
     */
    public final static String MAN_GUAN="0900";
    /**
     * 满，开
     */
    public final static String MAN_KAI="0910";
    /**
     * 满，关，加密
     */
    public final static String MAN_GUAN_JIAMI="0920";
    /**
     * 满，开，加密
     */
    public final static String MAN_KAI_JIAMI="0930";



    /**
     * 业务类型
     */
    /**
     * 开柜(业务)
     */
    public final static String KGYW="0100";


    /**
     * HdfsService_URL
     */
    public final static String HDFSURL="http://192.168.1.137:8081/hdfsService";


    /**
     * 用户登陆方式
     */
    /**
     * 用户名/密码
     */
    public final static String USERNAMELOGIN="0100";
    /**
     * 二代证
     */
    public final static String IDCARDLOGIN="0200";
    /**
     * 指纹
     */
    public final static String ZHIWENLOGIN="0300";
    /**
     * 人像
     */
    public final static String RENXIANGLOGIN="0400";
    /**
     * 其他
     */
    public final static String OTHERLOGIN="9999";




    /**
     * 结案归档
     */
    public final static String JAGD_GD="0010";
    /**
     * 撤案归档
     */
    public final static String CAGD_GD="0020";
    /**
     * 其他
     */
    public final static String QTGD_GD="9999";

    public static String getGdStatusByCode(String code){
        if(JAGD_GD.equals(code)){
            return "结案归档";
        }else if(CAGD_GD.equals(CAGD_GD)){
            return "撤案归档";
        }else{
            return "其他";
        }
    }
    public static String getStatusByCode(String code){
        if(TQDBSTATUS.equals(code)){
            return "已提请逮捕";
        }else if(YSQSSTATUS.equals(code)){
            return "已移送起诉";
        }if(JSAJSTATUS.equals(code)){
            return "在办(非主办人)";
        }else if(GHAJSTATUS.equals(code)){
            return "审核完成已归还";
        }if(PUTONGSTATUS.equals(code)){
            return "在办(主办人)";
        }else if(GUIDANGSTATUS.equals(code)){
            return "已归档";
        }if(ZUOFEISTATUS.equals(code)){
            return "已作废";
        }else if(YIYISONGSHENHESTATUS.equals(code)){
            return "已移送审核";
        }else if(YIYIJIAO_FEIZHUBANREN.equals(code)){
            return "已移交（非主办人）";
        }else{
            return "没有编号为 "+code+" 的状态";
        }
    }
    public static String getTypeByCode(String code){
        if(XJAJ.equals(code)){
            return "新建案卷";
        }else if(SMCJ.equals(code)){
            return "扫描采集";
        }if(AJYL.equals(code)){
            return "案卷阅览";
        }else if(ZZTM.equals(code)){
            return "制作条码";
        }if(AJGD.equals(code)){
            return "案卷归档";
        }else if(AJKL .equals(code)){
            return "案卷刻录";
        }if(YSSH.equals(code)){
            return "移送审核";
        }else if(YJAJUAN.equals(code)){
            return "移交案卷";
        }else if(YJAJIAN .equals(code)){
            return "移交案件";
        }else if(GHAJ .equals(code)){
            return "归还案卷";
        }if(JSAJ .equals(code)){
            return "接收案卷";
        }else if(JSAJYJ .equals(code)){
            return "接收案卷（移交）";
        }if(JSAJGH .equals(code)){
            return "接收案卷（归还）";
        }else if(TQDB .equals(code)){
            return "提请逮捕";
        }if(YSQS .equals(code)){
            return "移送起诉";
        }else if(BCZC.equals(code)){
            return "补充侦查";
        }else if(KG .equals(code)){
            return " 开柜";
        }else if(ISSCAN.equals(code)){
            return "是否采集";
        }else if(AJRG.equals(code)){
            return "案卷入柜";
        }else if(BIANGENGCUNFANGWEIZHI.equals(code)){
            return "变更存放位置";
        }else if(AJCQ.equals(code)){
            return "案卷存取";
        }else{
            return "没有编号为 "+code+" 的类型";
        }
    }
}
