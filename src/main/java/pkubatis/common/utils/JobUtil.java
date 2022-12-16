package pkubatis.common.utils;

import com.pkusoft.agxt.model.*;
import com.pkusoft.agxt.req.FileInfoParam;
import com.pkusoft.lesp.model.KeAgAjztxx;
import com.pkusoft.lesp.model.KeAjjbxx;
import com.pkusoft.usercenter.po.SysDept;
import com.pkusoft.usercenter.po.SysRole;
import com.pkusoft.usercenter.po.SysUser;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;
import pkubatis.constants.JobConstant;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

public class JobUtil {
    public final static String IDDEFAULT="00000000-0000-0000-0000-000000000000";
	public static final String TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
public static Date getDate(){
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    try {
        Date date=sdf.parse("1970-1-1 00:00:00");
        return date;
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return new Date(0);
}
public static String getBase64(byte[] b){
	BASE64Encoder enc = new BASE64Encoder();
    return enc.encode(b);
}
public static boolean isInteger(String str) {
    Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
    return pattern.matcher(str).matches();
}
public static String stringisNull(Object data){
	if(data == null){
		return null;
	}
	return data+"";
}
/**
*
* 得到当前日期时间
* @return yyyy-MM-dd HH:mm:ss字符串
*/
public static String getDateTime() {
	SimpleDateFormat sdf = new SimpleDateFormat(TIME_PATTERN);
	return sdf.format(new Date());
}
//向文件追加数据
public static void method1(String str) {
	FileWriter fw = null;
	try {
		File f=new File("D:\\dd.txt");
		fw = new FileWriter(f, true);
	} catch (IOException e) {
		e.printStackTrace();
	}
	PrintWriter pw = new PrintWriter(fw);
	pw.println(getDateTime()+":"+str);
	pw.flush();
	try {
		fw.flush();
		pw.close();
		fw.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
}
//java 生成8位数字作为UID
public static String generateUID(){
    Random random = new Random();
    String result="";
    for(int i=0;i<8;i++){
        //首字母不能为0
        result += (random.nextInt(9)+1);
    }
    return result;
}
/**
 * 使用JobFileStore的信息创建案卷轨迹信息(每次要更换track.setOperType("0010");和track.setOperReson("新建案卷");的信息)
 * @param
 * @return
 */
public static FileTrack establishTrack(FileInfo jobFileInfo, UserInfo userInfo){
    FileTrack track=new FileTrack();
    track.setId(UUID.randomUUID().toString());
    track.setFileId(jobFileInfo.getId());
    track.setFileCode(jobFileInfo.getCode());
    track.setFileName(jobFileInfo.getName());
    track.setOperTime(new Date());
    track.setOperId(userInfo.getIdCard());
    track.setOperCode(userInfo.getPoliceCode());
    track.setOperName(userInfo.getName());
//    track.setOperType("0010");//0010
    track.setOperDetail("");//新建案卷
    track.setTagOrgCode("");
    track.setTagOrgName("");
    track.setTagUserCode("");
    track.setTagUserName("");
    track.setIsOpened(0);
    track.setStatus(jobFileInfo.getStatus());
//    track.setReserve1();
//    track.setReserve2();
//    track.setReserve3();
//    track.setMemo(store.getMemo());
    track.setRowStatus(3);
    track.setCreaterId(userInfo.getIdCard());
    track.setCreaterName(userInfo.getName());
    track.setCreateTime(new Date());
    track.setModerId(userInfo.getIdCard());
    track.setModerName(userInfo.getName());
    track.setModTime(new Date());
    track.setOrgC(jobFileInfo.getOrgC());
    track.setOrgS(jobFileInfo.getOrgS());
    track.setOrgT(jobFileInfo.getOrgT());
    track.setOrgCData(jobFileInfo.getOrgCData());
    track.setOrgSData(jobFileInfo.getOrgSData());
    track.setOrgTData(jobFileInfo.getOrgTData());
    track.setCurOrg(jobFileInfo.getCurOrg());
    track.setCurOrgData(jobFileInfo.getCurOrgData());
    track.setLoginType(userInfo.getLoginType());
    track.setOperdeptCode(userInfo.getDeptCode());
    track.setOperdeptName(userInfo.getDeptName());
    return track;
}
public static FileTrack establishTrackByMetal(FileMetal jobFileMetal){
    FileTrack track=new FileTrack();
    track.setId(UUID.randomUUID().toString());
    track.setFileId(jobFileMetal.getFileId());
    track.setFileCode(jobFileMetal.getFileCode());
    track.setFileName(jobFileMetal.getFileName());
    track.setOperTime(new Date());
//    track.setOperType("0010");//0010
    track.setOperDetail("");//新建案卷
    track.setTagOrgCode("");
    track.setTagOrgName("");
    track.setTagUserCode("");
    track.setTagUserName("");
    track.setIsOpened(0);
    track.setStatus(jobFileMetal.getStatus());
//    track.setReserve1();
//    track.setReserve2();
//    track.setReserve3();
//    track.setMemo(store.getMemo());
    track.setRowStatus(3);
    track.setCreateTime(new Date());
    track.setModTime(new Date());
    track.setOrgC(jobFileMetal.getOrgC());
    track.setOrgS(jobFileMetal.getOrgS());
    track.setOrgT(jobFileMetal.getOrgT());
    track.setOrgCData(jobFileMetal.getOrgCData());
    track.setOrgSData(jobFileMetal.getOrgSData());
    track.setOrgTData(jobFileMetal.getOrgTData());
    track.setCurOrg(jobFileMetal.getCurOrg());
    track.setCurOrgData(jobFileMetal.getCurOrgData());
//    track.setLoginType(userInfo.getLoginType());
    return track;
}
/*
 * JobFileInfo  不能有空的字段  否则解析不了
 */
public static FileInfo notNull(FileInfo fileinfo){
	if(fileinfo == null){
		return new FileInfo();
	}
		if (null == fileinfo.getId() || false == inspectId(fileinfo.getId()) ){
        fileinfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == fileinfo.getCode()){
        fileinfo.setCode("");
    }
    if(null == fileinfo.getName()){
        fileinfo.setName("");
    }
		if (null == fileinfo.getCaseId()  || false == inspectId(fileinfo.getCaseId()) ){
        fileinfo.setCaseId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == fileinfo.getCaseName()){
        fileinfo.setCaseName("");
    }
    if(null == fileinfo.getHosterId()){
        fileinfo.setHosterId("");
    }
    if(null == fileinfo.getHosterPcode()){
        fileinfo.setHosterPcode("");
    }
    if(null == fileinfo.getHosterName()){
        fileinfo.setHosterName("");
    }
    if(null == fileinfo.getType()){
        fileinfo.setType("");
    }
    if(null == fileinfo.getSn()){
        fileinfo.setSn(0.0);
    }
    if(null == fileinfo.getPlaceId() || false == inspectId(fileinfo.getPlaceId())){
        fileinfo.setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == fileinfo.getPlaceName()){
        fileinfo.setPlaceName("");
    }
    if(null == fileinfo.getAreaId() || false == inspectId(fileinfo.getAreaId())){
        fileinfo.setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == fileinfo.getAreaName()){
        fileinfo.setAreaName("");
    }
    if(null == fileinfo.getSpaceId() || false == inspectId(fileinfo.getSpaceId())){
        fileinfo.setSpaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == fileinfo.getSpaceName()){
        fileinfo.setSpaceName("");
    }
    if(null == fileinfo.getCellId()){
        fileinfo.setCellId("");
    }
    if(null == fileinfo.getCellName()){
        fileinfo.setCellName("");
    }
    if(null == fileinfo.getDiskPath()){
        fileinfo.setDiskPath("");
    }
    if(null == fileinfo.getIsScan()){
        fileinfo.setIsScan(0);
    }
    if(null == fileinfo.getPageCount()){
        fileinfo.setPageCount(0);
    }
    if(null == fileinfo.getPrintCode()){
        fileinfo.setPrintCode("");
    }
    if(null == fileinfo.getPrintCount()){
        fileinfo.setPrintCount(0);
    }
    if(null == fileinfo.getBurnCount()){
        fileinfo.setBurnCount(0);
    }
    if(null == fileinfo.getKeywords()){
        fileinfo.setKeywords("");
    }

    if(null == fileinfo.getStatus()){
        fileinfo.setStatus("");
    }
    if(null == fileinfo.getReserve1()){
        fileinfo.setReserve1("");
    }
    if(null == fileinfo.getReserve2()){
        fileinfo.setReserve2("");
    }
    if(null == fileinfo.getReserve3()){
        fileinfo.setReserve3("");
    }
    if(null == fileinfo.getMemo()){
        fileinfo.setMemo("");
    }
    if(null == fileinfo.getRowStatus()){
        fileinfo.setRowStatus(0);
    }
    if(null == fileinfo.getCreaterId()){
        fileinfo.setCreaterId("");
    }
    if(null == fileinfo.getCreaterName()){
        fileinfo.setCreaterName("");
    }
    if(null == fileinfo.getCreateTime()){
        fileinfo.setCreateTime(JobUtil.getDate());
    }
    if(null == fileinfo.getModerId()){
        fileinfo.setModerId("");
    }
    if(null == fileinfo.getModerName()){
        fileinfo.setModerName("");
    }
    if(null == fileinfo.getModTime()){
        fileinfo.setModTime(JobUtil.getDate());
    }
    if(null == fileinfo.getOrgC()){
        fileinfo.setOrgC("");
    }
    if(null == fileinfo.getOrgS()){
        fileinfo.setOrgS("");
    }
    if(null == fileinfo.getOrgT()){
        fileinfo.setOrgT("");
    }
    if(null == fileinfo.getOrgCData()){
        fileinfo.setOrgCData("");
    }
    if(null == fileinfo.getOrgSData()){
        fileinfo.setOrgSData("");
    }
    if(null == fileinfo.getOrgTData()){
        fileinfo.setOrgTData("");
    }
    if(null == fileinfo.getCurOrg()){
        fileinfo.setCurOrg("");
    }
    if(null == fileinfo.getCurOrgData()){
        fileinfo.setCurOrgData("");
    }
    if(null == fileinfo.getNameSpell()){
        fileinfo.setNameSpell("");
    }
    if(null == fileinfo.getHosterSpell()){
        fileinfo.setHosterSpell("");
    }
    if(null == fileinfo.getSuppleinvCount()){
        fileinfo.setSuppleinvCount(0);
    }
    if(null == fileinfo.getAcceptTime()){
        fileinfo.setAcceptTime(getDate());;
    }
    return fileinfo;
}
public static List<FileAuth> changeJobFileAuth(List<FileAuth> list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == inspectId(list.get(i).getId())){
            list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getCaseId() || false == inspectId(list.get(i).getCaseId())){
            list.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
            }
        if(null == list.get(i).getCaseCode()){
            list.get(i).setFileCode("");
        }
        if(null == list.get(i).getCaseName()){
            list.get(i).setFileName("");
        }
        if(null == list.get(i).getFileId() || false == inspectId(list.get(i).getFileId())){
            list.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getFileCode()){
            list.get(i).setFileCode("");
        }
        if(null == list.get(i).getFileName()){
            list.get(i).setFileName("");
        }
        if(null == list.get(i).getMetalId()){
            list.get(i).setMetalId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getMetalName()){
            list.get(i).setMetalName("");
        }
        if(null == list.get(i).getPageId()){
            list.get(i).setPageId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getPageName()){
            list.get(i).setPageName("");
        }
        if(null == list.get(i).getOperId()){
            list.get(i).setOperId("");
        }
        if(null == list.get(i).getOperName()){
            list.get(i).setOperName("");
        }
        if(null == list.get(i).getOperType()){
            list.get(i).setOperType("");
        }
        if(null == list.get(i).getAuthType()){
            list.get(i).setAuthType(1);
        }
        if(null == list.get(i).getOrgCode()){
            list.get(i).setOrgCode("");
        }
        if(null == list.get(i).getOrgName()){
            list.get(i).setOrgName("");
        }
        if(null == list.get(i).getMetalName()){
            list.get(i).setMetalName("");
        }
        if(null == list.get(i).getStatus()){
        list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
        list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
        list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
        list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
        list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
        list.get(i).setRowStatus(0);
        }
        if(null == list.get(i).getCreaterId()){
        list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
        list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
        list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
        list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
        list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
        list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOrgC()){
        list.get(i).setOrgC("");
        }
        if(null == list.get(i).getOrgS()){
        list.get(i).setOrgS("");
        }
        if(null == list.get(i).getOrgT()){
        list.get(i).setOrgT("");
        }
        if(null == list.get(i).getOrgCData()){
        list.get(i).setOrgCData("");
        }
        if(null == list.get(i).getOrgSData()){
        list.get(i).setOrgSData("");
        }
        if(null == list.get(i).getOrgTData()){
        list.get(i).setOrgTData("");
        }
        if(null == list.get(i).getCurOrg()){
        list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
        list.get(i).setCurOrgData("");
        }
    }
    return list;
}
    public static List<FileInfoParam> isNotNullJobFileInfoChange(List<FileInfoParam> list){
        for (int i = 0; i < list.size(); i++) {
            notNull(list.get(i));
        }
        return list;
    }
public static FileStore getJobFileStore(CabSpace jobCabSpace, UserInfo userInfo, CaseInfo caseInfo){
    FileStore jobFileStore=new FileStore();
    jobFileStore.setId(UUID.randomUUID().toString());
//    jobFileStore.setFileId(jobFileInfo.getId());
//    jobFileStore.setFileCode(jobFileInfo.getCode());
//    jobFileStore.setFileName(jobFileInfo.getName());
//    jobFileStore.setMetalId("00000000-0000-0000-0000-000000000000");
//  jobFileStore.setMetalName();
//    jobFileStore.setPageId(UUID.randomUUID().toString());
//  jobFileStore.setPageName();
    jobFileStore.setPlaceId(jobCabSpace.getPlaceId());
    jobFileStore.setPlaceName(jobCabSpace.getPlaceName());
    jobFileStore.setAreaId(jobCabSpace.getAreaId());
    jobFileStore.setAreaName(jobCabSpace.getAreaName());
    jobFileStore.setSpaceId(jobCabSpace.getId());
    jobFileStore.setSpaceName(jobCabSpace.getName());
    jobFileStore.setCellId(IDDEFAULT);
    jobFileStore.setCellName("<None>");
    jobFileStore.setEntryTime(new Date());
    jobFileStore.setOwnerId(caseInfo.getHosterId());
    jobFileStore.setOwnerCode(caseInfo.getHosterPcode());
    jobFileStore.setOwnerName(caseInfo.getHosterName());
    jobFileStore.setOrgCode(caseInfo.getHandleOrgCode());
    jobFileStore.setOrgName(caseInfo.getHandleOrgName());
    jobFileStore.setStatus(JobConstant.PUTONGSTATUS);
    jobFileStore.setMemo(jobCabSpace.getMemo());
    jobFileStore.setRowStatus(3);
    jobFileStore.setCreaterId(userInfo.getIdCard());
    jobFileStore.setCreaterName(userInfo.getName());
    jobFileStore.setCreateTime(new Date());
    jobFileStore.setModerId(userInfo.getIdCard());
    jobFileStore.setModerName(userInfo.getName());
    jobFileStore.setModTime(new Date());
    jobFileStore.setOrgC(caseInfo.getOrgC());
    jobFileStore.setOrgS(caseInfo.getOrgS());
    jobFileStore.setOrgT(caseInfo.getOrgT());
    jobFileStore.setOrgCData(caseInfo.getOrgCData());
    jobFileStore.setOrgSData(caseInfo.getOrgSData());
    jobFileStore.setOrgTData(caseInfo.getOrgTData());
    jobFileStore.setCurOrg(caseInfo.getCurOrg());
    jobFileStore.setCurOrgData(caseInfo.getCurOrgData());
    return jobFileStore;
}


////把LespkeAjjbxx类型转变成JobCaseInfo     /**参数dic修改成字典条目值（原为DicSysZdnr对象）*/
//public static CaseInfo switchJob(DzajCaseInfo dzajCaseInfo){
//    CaseInfo caseinfo=new CaseInfo();
//    caseinfo.setId(UUID.randomUUID().toString());
//    caseinfo.setCode(changeString(dzajCaseInfo.getCaseId()));
//    caseinfo.setName(changeString(dzajCaseInfo.getCaseName()));
//    if(null != dzajCaseInfo.getCaseType() && dzajCaseInfo.getCaseType() == 1){
//        caseinfo.setType(JobConstant.XINGSHI);
//    }else if(null != dzajCaseInfo.getCaseType() && dzajCaseInfo.getCaseType() == 2){
//        caseinfo.setType(JobConstant.XINGZHENG);
//    }else{
//        caseinfo.setType(JobConstant.QITA);
//    }
//    caseinfo.setTypeName(changeString(dzajCaseInfo.getCaseTypeDes()));
//    caseinfo.setSn(0.0);
////    caseinfo.setCause(changeString(dic.getCMc()));
//    caseinfo.setCause(dzajCaseInfo.getCasereason());
//    caseinfo.setSource(changeInteger(dzajCaseInfo.getCaseResource()).toString());//案件来源没翻译
//    caseinfo.setDetail(changeString(dzajCaseInfo.getCaseExplain()));
//    caseinfo.setCaseTimeU(dzajCaseInfo.getReportDate());
//    caseinfo.setHandleOrgCode(changeString(dzajCaseInfo.getTransactdeptId()));
//    caseinfo.setHandleOrgName(changeString(dzajCaseInfo.getTransactdeptName()));
//    caseinfo.setHosterId(changeString(dzajCaseInfo.getTransactor1Id()));//还没有,以后通过警号到人员表里查
//    caseinfo.setHosterPcode("");
//    caseinfo.setHosterName(changeString(dzajCaseInfo.getTransactor1Name()));
//    caseinfo.setCasePlace(changeString(dzajCaseInfo.getIncidenceArea()));
//    caseinfo.setReportTime(dzajCaseInfo.getReportDate());
//    caseinfo.setReporter(changeString(dzajCaseInfo.getReportName()));
//    caseinfo.setReporterAdd(changeString(dzajCaseInfo.getReportAdd()));
//    caseinfo.setReporterTel(changeString(dzajCaseInfo.getReportTel()));
//    caseinfo.setAlarmTime(dzajCaseInfo.getAlarmDate());
//    caseinfo.setAlarmName(changeString(dzajCaseInfo.getAlarmName()));
////    caseinfo.setAcceptTime(JobUtil.getDate());
//    caseinfo.setAcceptPcode("");
//    caseinfo.setAcceptName("");
//    caseinfo.setAcceptOrgCode("");
//    caseinfo.setAcceptOrgName("");
//    caseinfo.setAcceptLocale("");
//    caseinfo.setCurstepId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
//    caseinfo.setCurstepName("");
////    caseinfo.setRegTime(JobUtil.getDate());
////    caseinfo.setRecvTime(JobUtil.getDate());
//    caseinfo.setDataSource("");
//    caseinfo.setFilesCount(0);
//    caseinfo.setPrintCode("");
//    caseinfo.setPrintCount(0);
//    caseinfo.setBurnCount(0);
//    caseinfo.setKeywords("");
//    caseinfo.setStatus("");
//    caseinfo.setReserve1("");
//    caseinfo.setReserve2("");
//    caseinfo.setReserve3("");
//    caseinfo.setMemo("");
//    caseinfo.setRowStatus(3);
//    caseinfo.setCreaterId("");//dzajCaseInfo.getDjr()
//    caseinfo.setCreaterName("");
//    caseinfo.setCreateTime(dzajCaseInfo.getOptime());
//    caseinfo.setModerId("");//
//    caseinfo.setModerName("");
////    caseinfo.setModTime(getDate());
//    caseinfo.setOrgC(dzajCaseInfo.getCstationid());
//    caseinfo.setOrgS(dzajCaseInfo.getSstationid());
//    caseinfo.setOrgT(dzajCaseInfo.getTstationid());
//    caseinfo.setOrgCData(dzajCaseInfo.getCstationid());
//    caseinfo.setOrgSData(dzajCaseInfo.getSstationid());
//    caseinfo.setOrgTData(dzajCaseInfo.getTstationid());
////    caseinfo.setCaseTimeD(getDate());
//    caseinfo.setCurOrg(dzajCaseInfo.getTransactdeptId());
//    caseinfo.setCurOrgData(dzajCaseInfo.getTransactdeptId());
//    return caseinfo;
//}
//public static CaseInfo changeJobCaseInfo(KeAgAjztxx keAgAjztxx){
//    CaseInfo caseinfo=new CaseInfo();
//    caseinfo.setId(UUID.randomUUID().toString());
//    caseinfo.setCode(keAgAjztxx.getAjbh());
//    caseinfo.setName(keAgAjztxx.getAjmc());
//    if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("01")){
//        caseinfo.setType(JobConstant.XINGSHI);
//        caseinfo.setTypeName("刑事案件");
//    }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("02")){
//    	caseinfo.setType(JobConstant.XINGZHENG);
//        caseinfo.setTypeName("行政案件");
//    }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("03")){
//    	caseinfo.setType(JobConstant.XINGZHENGFUYI);
//        caseinfo.setTypeName("行政复议");
//    }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("04")){
//    	caseinfo.setType(JobConstant.XINGZHENGSS);
//        caseinfo.setTypeName("行政诉讼");
//    }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("05")){
//    	caseinfo.setType(JobConstant.GUOJIAPEICHANG);
//        caseinfo.setTypeName("国家赔偿");
//    }else{
//    	caseinfo.setType(JobConstant.QITA);
//        caseinfo.setTypeName("其他");
//    }
//
//    caseinfo.setSn(0.0);
////    caseinfo.setCause(changeString(dic.getCMc()));
////    caseinfo.setCause(keAgAjztxx.getZmMc());
//    caseinfo.setSource("");//案件来源没翻译
////    caseinfo.setDetail(keAgAjztxx.getJyaq());
////    caseinfo.setCaseTimeU();
//    caseinfo.setHandleOrgCode(keAgAjztxx.getBadwBm());
//    caseinfo.setHandleOrgName(keAgAjztxx.getBadwMc());
//    caseinfo.setHosterId(keAgAjztxx.getZbrSfzhm());//还没有,以后通过警号到人员表里查
//    caseinfo.setHosterPcode(keAgAjztxx.getZbrJh());
//    caseinfo.setHosterName(keAgAjztxx.getZbrXm());
//    caseinfo.setCasePlace("");
////    caseinfo.setReportTime(getDate());
//    caseinfo.setReporter("");
//    caseinfo.setReporterAdd("");
//    caseinfo.setReporterTel("");
////    caseinfo.setAlarmTime(getDate());
//    caseinfo.setAlarmName("");
//    caseinfo.setAcceptTime(keAgAjztxx.getSlsj());
//    caseinfo.setAcceptPcode("");
//    caseinfo.setAcceptName("");
//    caseinfo.setAcceptOrgCode("");
//    caseinfo.setAcceptOrgName("");
//    caseinfo.setAcceptLocale("");
//    caseinfo.setCurstepId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
//    caseinfo.setCurstepName("");
////    caseinfo.setRegTime(getDate());
////    caseinfo.setRecvTime(getDate());
//    caseinfo.setDataSource("");
////     caseinfo.setDataSource("0");
//    caseinfo.setFilesCount(0);
//    caseinfo.setPrintCode("");
//    caseinfo.setPrintCount(0);
//    caseinfo.setBurnCount(0);
//    caseinfo.setKeywords("");
//    caseinfo.setStatus("");
//    caseinfo.setReserve1("");
//    caseinfo.setReserve2("");
//    caseinfo.setReserve3("");
//    caseinfo.setMemo("");
//    caseinfo.setRowStatus(3);
//    caseinfo.setCreaterId("");//dzajCaseInfo.getDjr()
//    caseinfo.setCreaterName("");
////    caseinfo.setCreateTime(keAgAjztxx.getCqsj());
//    caseinfo.setModerId("");//
//    caseinfo.setModerName("");
////    caseinfo.setModTime(getDate());
//    caseinfo.setOrgC(keAgAjztxx.getCstationid());
//    caseinfo.setOrgS(keAgAjztxx.getSstationid());
//    caseinfo.setOrgT(keAgAjztxx.getTstationid());
//    caseinfo.setOrgCData(keAgAjztxx.getCstationid());
//    caseinfo.setOrgSData(keAgAjztxx.getSstationid());
//    caseinfo.setOrgTData(keAgAjztxx.getTstationid());
////    caseinfo.setCaseTimeD(getDate());
//    caseinfo.setCurOrg("");
//    caseinfo.setCurOrgData("");
//    if(keAgAjztxx.getAjmcPym() != null){
//        caseinfo.setNameSpell(keAgAjztxx.getAjmcPym());
//    }else{
//    	if(keAgAjztxx.getAjmc() != null && !keAgAjztxx.getAjmc().equals("")){
//    		String code=PinyinUtils.getHeadPinyin(keAgAjztxx.getAjmc());//案卷拼音码
//    		caseinfo.setNameSpell(code);
//    	}
//    }
//    if(keAgAjztxx.getZbrXmPym() == null && keAgAjztxx.getZbrXm()!=null){
//        String hosterName=PinyinUtils.getHeadPinyin(keAgAjztxx.getZbrXm());
//        caseinfo.setHosterSpell(hosterName);
//    }else{
//        caseinfo.setHosterSpell(keAgAjztxx.getZbrXmPym());
//    }
//    return caseinfo;
//}
//public static List<CaseInfo> changeJobCaseInfo(List<KeAgAjztxx> keAgAjztxx){
//    List<CaseInfo> jobcaseinfolist=new ArrayList<CaseInfo>();
//    for(int i=0;i<keAgAjztxx.size();i++){
//        //翻译字典
//        CaseInfo jobcaseinfo=JobUtil.changeJobCaseInfo(keAgAjztxx.get(i));
//        //查找所属市局分局派出所
//        jobcaseinfolist.add(JobUtil.caseInfoNotNull(jobcaseinfo));
//    }
//    return jobcaseinfolist;
//}
public static CaseInfo changeJobCaseInfo(CaseInfo jobCaseInfo,CaseInfo cas){
    jobCaseInfo.setCurstepId(cas.getCurstepId());
    jobCaseInfo.setCurstepName(cas.getCurstepName());
    jobCaseInfo.setRegTime(cas.getRegTime());
    jobCaseInfo.setRecvTime(cas.getRecvTime());
    jobCaseInfo.setDataSource(cas.getDataSource());
    jobCaseInfo.setFilesCount(cas.getFilesCount());
    jobCaseInfo.setPrintCode(cas.getPrintCode());
    jobCaseInfo.setPrintCount(cas.getPrintCount());
    jobCaseInfo.setBurnCount(cas.getBurnCount());
    jobCaseInfo.setKeywords(cas.getKeywords());
    jobCaseInfo.setStatus(cas.getStatus());
    jobCaseInfo.setReserve1(cas.getReserve1());
    jobCaseInfo.setReserve2(cas.getReserve2());
    jobCaseInfo.setReserve3(cas.getReserve3());
    jobCaseInfo.setMemo(cas.getMemo());
    jobCaseInfo.setRowStatus(3);
    jobCaseInfo.setCreaterId(cas.getCreaterId());
    jobCaseInfo.setCreaterName(cas.getCreaterName());
    jobCaseInfo.setCreateTime(cas.getCreateTime());
    jobCaseInfo.setModerId(jobCaseInfo.getModerId());
    jobCaseInfo.setModerName(jobCaseInfo.getModerName());
    jobCaseInfo.setModTime(new Date());
    jobCaseInfo.setOrgC(cas.getOrgC());
    jobCaseInfo.setOrgS(cas.getOrgS());
    jobCaseInfo.setOrgT(cas.getOrgT());
    jobCaseInfo.setOrgCData(cas.getOrgCData());
    jobCaseInfo.setOrgSData(cas.getOrgSData());
    jobCaseInfo.setOrgTData(cas.getOrgTData());
    return jobCaseInfo;
}
    public static CaseInfo changeJobCaseInfo(KeAgAjztxx keAgAjztxx){
        CaseInfo caseinfo=new CaseInfo();
        caseinfo.setId(UUID.randomUUID().toString());
        caseinfo.setCode(keAgAjztxx.getAjbh());
        caseinfo.setName(keAgAjztxx.getAjmc());
        if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("01")){
            caseinfo.setType(JobConstant.XINGSHI);
            caseinfo.setTypeName("刑事案件");
        }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("02")){
            caseinfo.setType(JobConstant.XINGZHENG);
            caseinfo.setTypeName("行政案件");
        }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("03")){
            caseinfo.setType(JobConstant.XINGZHENGFUYI);
            caseinfo.setTypeName("行政复议");
        }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("04")){
            caseinfo.setType(JobConstant.XINGZHENGSS);
            caseinfo.setTypeName("行政诉讼");
        }else if(null != keAgAjztxx.getAjlb() && keAgAjztxx.getAjlb().equals("05")){
            caseinfo.setType(JobConstant.GUOJIAPEICHANG);
            caseinfo.setTypeName("国家赔偿");
        }else{
            caseinfo.setType(JobConstant.QITA);
            caseinfo.setTypeName("其他");
        }

        caseinfo.setSn(0.0);
//    caseinfo.setCause(changeString(dic.getCMc()));
//    caseinfo.setCause(keAgAjztxx.getZmMc());
        caseinfo.setSource("");//案件来源没翻译
//    caseinfo.setDetail(keAgAjztxx.getJyaq());
//    caseinfo.setCaseTimeU();
        caseinfo.setHandleOrgCode(keAgAjztxx.getBadwBm());
        caseinfo.setHandleOrgName(keAgAjztxx.getBadwMc());
        caseinfo.setHosterId(keAgAjztxx.getZbrSfzhm());//还没有,以后通过警号到人员表里查
        caseinfo.setHosterPcode(keAgAjztxx.getZbrJh());
        caseinfo.setHosterName(keAgAjztxx.getZbrXm());
        caseinfo.setCasePlace("");
//    caseinfo.setReportTime(getDate());
        caseinfo.setReporter("");
        caseinfo.setReporterAdd("");
        caseinfo.setReporterTel("");
//    caseinfo.setAlarmTime(getDate());
        caseinfo.setAlarmName("");
        caseinfo.setAcceptTime(keAgAjztxx.getSlsj());
        caseinfo.setAcceptPcode("");
        caseinfo.setAcceptName("");
        caseinfo.setAcceptOrgCode("");
        caseinfo.setAcceptOrgName("");
        caseinfo.setAcceptLocale("");
        caseinfo.setCurstepId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        caseinfo.setCurstepName("");
//    caseinfo.setRegTime(getDate());
//    caseinfo.setRecvTime(getDate());
        caseinfo.setDataSource("");
//     caseinfo.setDataSource("0");
        caseinfo.setFilesCount(0);
        caseinfo.setPrintCode("");
        caseinfo.setPrintCount(0);
        caseinfo.setBurnCount(0);
        caseinfo.setKeywords("");
        caseinfo.setStatus("");
        caseinfo.setReserve1("");
        caseinfo.setReserve2("");
        caseinfo.setReserve3("");
        caseinfo.setMemo("");
        caseinfo.setRowStatus(3);
        caseinfo.setCreaterId("");//dzajCaseInfo.getDjr()
        caseinfo.setCreaterName("");
//    caseinfo.setCreateTime(keAgAjztxx.getCqsj());
        caseinfo.setModerId("");//
        caseinfo.setModerName("");
//    caseinfo.setModTime(getDate());
        caseinfo.setOrgC(keAgAjztxx.getCstationid());
        caseinfo.setOrgS(keAgAjztxx.getSstationid());
        caseinfo.setOrgT(keAgAjztxx.getTstationid());
        caseinfo.setOrgCData(keAgAjztxx.getCstationid());
        caseinfo.setOrgSData(keAgAjztxx.getSstationid());
        caseinfo.setOrgTData(keAgAjztxx.getTstationid());
//    caseinfo.setCaseTimeD(getDate());
        caseinfo.setCurOrg("");
        caseinfo.setCurOrgData("");
        if(keAgAjztxx.getAjmcPym() != null){
            caseinfo.setNameSpell(keAgAjztxx.getAjmcPym());
        }else{
            if(keAgAjztxx.getAjmc() != null && !keAgAjztxx.getAjmc().equals("")){
                String code=PinyinUtils.getPinyin(keAgAjztxx.getAjmc());//案卷拼音码
                caseinfo.setNameSpell(code);
            }
        }
        if(keAgAjztxx.getZbrXmPym() == null && keAgAjztxx.getZbrXm()!=null){
            String hosterName=PinyinUtils.getPinyin(keAgAjztxx.getZbrXm());
            caseinfo.setHosterSpell(hosterName);
        }else{
            caseinfo.setHosterSpell(keAgAjztxx.getZbrXmPym());
        }
        return caseinfo;
    }
public static FileInfo establishJobFileInfo(FileStore store,CaseInfo caseinfo,UserInfo userInfo){
    FileInfo fileinfo=new FileInfo();
    fileinfo.setId(UUID.randomUUID().toString());
    fileinfo.setCode(caseinfo.getCode());
    fileinfo.setName(caseinfo.getName());
    fileinfo.setCaseId(caseinfo.getId());
    fileinfo.setCaseCode(caseinfo.getCode());
    fileinfo.setCaseName(caseinfo.getName());
    fileinfo.setHosterId(caseinfo.getHosterId());
    fileinfo.setHosterName(caseinfo.getHosterName());
    fileinfo.setHosterPcode(caseinfo.getHosterPcode());
    fileinfo.setType(caseinfo.getType());
    fileinfo.setSn(0.0);
    fileinfo.setPlaceId(store.getPlaceId());
    fileinfo.setPlaceName(store.getPlaceName());
    fileinfo.setAreaId(store.getAreaId());
    fileinfo.setAreaName(store.getAreaName());
    fileinfo.setSpaceId(store.getSpaceId());
    fileinfo.setSpaceName(store.getSpaceName());
    //fileinfo.setDiskPath("CaseFileManage/"+fileinfo.getCode());
    fileinfo.setIsScan(0);
    fileinfo.setPageCount(0);
    fileinfo.setPrintCode(fileinfo.getCode());
//    fileinfo.setPrintCount();
//    fileinfo.setBurnCount();
//    fileinfo.setKeywords();
    fileinfo.setStatus(JobConstant.PUTONGSTATUS);
//    fileinfo.setReserve1();
//    fileinfo.setReserve2();
//    fileinfo.setReserve3();
    fileinfo.setMemo(caseinfo.getMemo());
    fileinfo.setRowStatus(3);
    fileinfo.setCreaterId(userInfo.getIdCard());
    fileinfo.setCreaterName(userInfo.getName());
    fileinfo.setCreateTime(new Date());
    fileinfo.setModerId(userInfo.getIdCard());
    fileinfo.setModerName(userInfo.getName());
    fileinfo.setModTime(new Date());
    fileinfo.setOrgC(caseinfo.getOrgC());
    fileinfo.setOrgS(caseinfo.getOrgS());
    fileinfo.setOrgT(caseinfo.getOrgT());
    fileinfo.setOrgCData(caseinfo.getOrgCData());
    fileinfo.setOrgSData(caseinfo.getOrgSData());
    fileinfo.setOrgTData(caseinfo.getOrgTData());
    fileinfo.setCurOrg(caseinfo.getCurOrg());
    fileinfo.setCurOrgData(caseinfo.getCurOrgData());
    fileinfo.setAcceptTime(caseinfo.getAcceptTime());
    //fileinfo.setCaseTimeD();
    return fileinfo;
}
public static FileStore getjobFileStore(FilePage page,CabSpace space){
    FileStore jobFileStore=new FileStore();
    jobFileStore.setId(UUID.randomUUID().toString());
    jobFileStore.setFileId(page.getFileId());
    jobFileStore.setFileCode(page.getFileCode());
    jobFileStore.setFileName(page.getFileName());
    jobFileStore.setMetalId(page.getMetalId());
    jobFileStore.setMetalName(page.getMetalName());
    jobFileStore.setPageId(page.getId());
    jobFileStore.setPageName(page.getName());
    jobFileStore.setPlaceId(space.getPlaceId());
    jobFileStore.setPlaceName(space.getPlaceName());
    jobFileStore.setAreaId(space.getAreaId());
    jobFileStore.setAreaName(space.getAreaName());
    jobFileStore.setSpaceId(space.getId());
    jobFileStore.setSpaceName(space.getName());
    jobFileStore.setCellId(IDDEFAULT);
    jobFileStore.setCellName("<None>");
    jobFileStore.setEntryTime(new Date());
//    jobFileStore.setOwnerId(store.getOwnerId());
//    jobFileStore.setOwnerName(store.getOwnerName());
//    jobFileStore.setOrgCode(store.getOrgCode());
//    jobFileStore.setOrgName(store.getOrgName());
//    jobFileStore.setStatus(store.getStatus());
//    jobFileStore.setMemo(store.getMemo());
    jobFileStore.setRowStatus(3);
    jobFileStore.setCreaterId("");
    jobFileStore.setCreaterName("");
    jobFileStore.setCreateTime(new Date());
    jobFileStore.setModerId("");
    jobFileStore.setModerName("");
    jobFileStore.setModTime(new Date());
    jobFileStore.setOrgC(page.getOrgC());
    jobFileStore.setOrgS(page.getOrgS());
    jobFileStore.setOrgT(page.getOrgT());
    jobFileStore.setOrgCData(page.getOrgCData());
    jobFileStore.setOrgSData(page.getOrgSData());
    jobFileStore.setOrgTData(page.getOrgTData());
    jobFileStore.setCurOrg(page.getCurOrg());
    jobFileStore.setCurOrgData(page.getCurOrgData());
    return jobFileStore;
}
public static FileTrackDtl changeJobFileTrackDtl(FilePage page,FileStore store,UserInfo userInfo){
    FileTrackDtl trackdtl=new FileTrackDtl();
        trackdtl.setId(UUID.randomUUID().toString());
//        trackdtl.setTrackId();
        trackdtl.setFileId(page.getFileId());
        trackdtl.setFileCode(page.getFileCode());
        trackdtl.setFileName(page.getFileName());
        trackdtl.setMetalId(page.getMetalId());
        trackdtl.setMetalName(page.getMetalName());
        trackdtl.setPageId(page.getId());
        trackdtl.setPageName(page.getName());
        trackdtl.setOperTime(new Date());
        trackdtl.setOperId(userInfo.getIdCard());
        trackdtl.setOperCode(userInfo.getPoliceCode());
        trackdtl.setOperName(userInfo.getName());
//        trackdtl.setOperType();
        trackdtl.setPlaceId(store.getPlaceId());
        trackdtl.setPlaceName(store.getPlaceName());
        trackdtl.setAreaId(store.getAreaId());
        trackdtl.setAreaName(store.getAreaName());
        trackdtl.setSpaceId(store.getSpaceId());
        trackdtl.setSpaceName(store.getSpaceName());
        trackdtl.setCellId(IDDEFAULT);
        trackdtl.setCellName("<None>");
        trackdtl.setStatus(page.getStatus());
    //  trackdtl.setReserve1();
    //  trackdtl.setReserve2();
    //  trackdtl.setReserve3();
        trackdtl.setMemo(page.getMemo());
        trackdtl.setRowStatus(3);
        trackdtl.setCreaterId(userInfo.getIdCard());
        trackdtl.setCreaterName(userInfo.getName());
        trackdtl.setCreateTime(new Date());
        trackdtl.setModerId(userInfo.getIdCard());
        trackdtl.setModerName(userInfo.getName());
        trackdtl.setModTime(new Date());
        trackdtl.setOrgC(page.getOrgC());
        trackdtl.setOrgS(page.getOrgS());
        trackdtl.setOrgT(page.getOrgT());
        trackdtl.setOrgCData(page.getOrgCData());
        trackdtl.setOrgSData(page.getOrgSData());
        trackdtl.setOrgTData(page.getOrgTData());
        trackdtl.setCurOrg(page.getCurOrg());
        trackdtl.setCurOrgData(page.getCurOrgData());
        trackdtl.setOperdeptCode(userInfo.getDeptCode());
        trackdtl.setOperdeptName(userInfo.getDeptName());
        return trackdtl;
}
public static FileTrackDtl changeJobFileTrackDtlByJobFileInfo(FileInfo jobFileInfo,FileStore store,UserInfo userInfo){
    FileTrackDtl trackdtl=new  FileTrackDtl();
        trackdtl.setId(UUID.randomUUID().toString());
//        trackdtl.setTrackId();
        trackdtl.setFileId(jobFileInfo.getId());
        trackdtl.setFileCode(jobFileInfo.getCode());
        trackdtl.setFileName(jobFileInfo.getName());
        trackdtl.setMetalId(IDDEFAULT);
        trackdtl.setMetalName("");
        trackdtl.setPageId(IDDEFAULT);
        trackdtl.setPageName("");
        trackdtl.setOperTime(new Date());
//        trackdtl.setOperType();
        if(store != null){
            trackdtl.setPlaceId(store.getPlaceId());
            trackdtl.setPlaceName(store.getPlaceName());
            trackdtl.setAreaId(store.getAreaId());
            trackdtl.setAreaName(store.getAreaName());
            trackdtl.setSpaceId(store.getSpaceId());
            trackdtl.setSpaceName(store.getSpaceName());
        }

        trackdtl.setCellId(IDDEFAULT);
        trackdtl.setCellName("<None>");
        trackdtl.setStatus(jobFileInfo.getStatus());
    //  trackdtl.setReserve1();
    //  trackdtl.setReserve2();
    //  trackdtl.setReserve3();
        trackdtl.setMemo(jobFileInfo.getMemo());
        trackdtl.setRowStatus(3);
        if(userInfo != null){
            trackdtl.setOperId(userInfo.getIdCard());
            trackdtl.setOperCode(userInfo.getPoliceCode());
            trackdtl.setOperName(userInfo.getName());
            trackdtl.setCreaterId(userInfo.getIdCard());
            trackdtl.setCreaterName(userInfo.getName());
            trackdtl.setCreateTime(new Date());
            trackdtl.setModerId(userInfo.getIdCard());
            trackdtl.setModerName(userInfo.getName());
            trackdtl.setModTime(new Date());
            trackdtl.setOperdeptCode(userInfo.getDeptCode());
            trackdtl.setOperdeptName(userInfo.getDeptName());
        }
        trackdtl.setOrgC(jobFileInfo.getOrgC());
        trackdtl.setOrgS(jobFileInfo.getOrgS());
        trackdtl.setOrgT(jobFileInfo.getOrgT());
        trackdtl.setOrgCData(jobFileInfo.getOrgCData());
        trackdtl.setOrgSData(jobFileInfo.getOrgSData());
        trackdtl.setOrgTData(jobFileInfo.getOrgTData());
        trackdtl.setCurOrg(jobFileInfo.getCurOrg());
        trackdtl.setCurOrgData(jobFileInfo.getCurOrgData());
        return trackdtl;
}
public static FileTrackDtl notNullJobFileTrackDtl(FileTrackDtl jobFileTrackDtl){
        if(null == jobFileTrackDtl.getId() || false == inspectId(jobFileTrackDtl.getId())){
        jobFileTrackDtl.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getTrackId() || false == inspectId(jobFileTrackDtl.getTrackId())){
            jobFileTrackDtl.setTrackId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
            }
        if(null == jobFileTrackDtl.getFileId() || false == inspectId(jobFileTrackDtl.getFileId())){
        jobFileTrackDtl.setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getFileCode()){
        jobFileTrackDtl.setFileCode("");
        }
        if(null == jobFileTrackDtl.getFileName()){
        jobFileTrackDtl.setFileName("");
        }
        if(null == jobFileTrackDtl.getMetalId() || false == inspectId(jobFileTrackDtl.getMetalId())){
        jobFileTrackDtl.setMetalId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getMetalName()){
        jobFileTrackDtl.setMetalName("");
        }
        if(null == jobFileTrackDtl.getPageId() || false == inspectId(jobFileTrackDtl.getPageId())){
        jobFileTrackDtl.setPageId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getPageName()){
        jobFileTrackDtl.setPageName("");
        }
        if(null == jobFileTrackDtl.getOperTime()){
        jobFileTrackDtl.setOperTime(JobUtil.getDate());
        }
        if(null == jobFileTrackDtl.getOperId() ){
        jobFileTrackDtl.setOperId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getOperName()){
        jobFileTrackDtl.setOperName("");
        }
        if(null == jobFileTrackDtl.getOperType()){
        jobFileTrackDtl.setOperType("");
        }
        if(null == jobFileTrackDtl.getPlaceId() || false == inspectId(jobFileTrackDtl.getPlaceId())){
        jobFileTrackDtl.setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getPlaceName()){
        jobFileTrackDtl.setPlaceName("");
        }
        if(null == jobFileTrackDtl.getAreaId() || false == inspectId(jobFileTrackDtl.getAreaId())){
        jobFileTrackDtl.setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getAreaName()){
            jobFileTrackDtl.setAreaName("");
        }
        if(null == jobFileTrackDtl.getSpaceId() || false == inspectId(jobFileTrackDtl.getSpaceId())){
        jobFileTrackDtl.setSpaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getSpaceName()){
        jobFileTrackDtl.setSpaceName("");
        }
        if(null == jobFileTrackDtl.getCellId() || false == inspectId(jobFileTrackDtl.getCellId())){
        jobFileTrackDtl.setCellId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getCellName()){
        jobFileTrackDtl.setCellName("");
        }
        if(null == jobFileTrackDtl.getStatus()){
        jobFileTrackDtl.setStatus("");
        }
        if(null == jobFileTrackDtl.getReserve1()){
        jobFileTrackDtl.setReserve1("");
        }
        if(null == jobFileTrackDtl.getReserve2()){
        jobFileTrackDtl.setReserve2("");
        }
        if(null == jobFileTrackDtl.getReserve3()){
        jobFileTrackDtl.setReserve3("");
        }
        if(null == jobFileTrackDtl.getMemo()){
        jobFileTrackDtl.setMemo("");
        }
        if(null == jobFileTrackDtl.getRowStatus()){
        jobFileTrackDtl.setRowStatus(0);
        }
        if(null == jobFileTrackDtl.getCreaterId() ){
        jobFileTrackDtl.setCreaterId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getCreaterName()){
        jobFileTrackDtl.setCreaterName("");
        }
        if(null == jobFileTrackDtl.getCreateTime()){
        jobFileTrackDtl.setCreateTime(JobUtil.getDate());
        }
        if(null == jobFileTrackDtl.getModerId()){
        jobFileTrackDtl.setModerId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileTrackDtl.getModerName()){
        jobFileTrackDtl.setModerName("");
        }
        if(null == jobFileTrackDtl.getModTime()){
        jobFileTrackDtl.setModTime(JobUtil.getDate());
        }
        if(null == jobFileTrackDtl.getOrgC()){
        jobFileTrackDtl.setOrgC("");
        }
        if(null == jobFileTrackDtl.getOrgS()){
        jobFileTrackDtl.setOrgS("");
        }
        if(null == jobFileTrackDtl.getOrgT()){
        jobFileTrackDtl.setOrgT("");
        }
        if(null == jobFileTrackDtl.getOrgCData()){
        jobFileTrackDtl.setOrgCData("");
        }
        if(null == jobFileTrackDtl.getOrgSData()){
        jobFileTrackDtl.setOrgSData("");
        }
        if(null == jobFileTrackDtl.getOrgTData()){
        jobFileTrackDtl.setOrgTData("");
        }
        if(null == jobFileTrackDtl.getCurOrg()){
        jobFileTrackDtl.setCurOrg("");
        }
        if(null == jobFileTrackDtl.getCurOrgData()){
        jobFileTrackDtl.setCurOrgData("");
        }
        if(null == jobFileTrackDtl.getOperdeptCode()){
            jobFileTrackDtl.setOperdeptCode("");
        }
        if(null == jobFileTrackDtl.getOperdeptName()){
            jobFileTrackDtl.setOperdeptName("");
        }
        return jobFileTrackDtl;
}
public static List<FileTrackDtl> isNotNullJobFileTrackDtl(List<FileTrackDtl> list){
    for (int i = 0; i < list.size(); i++) {
        notNullJobFileTrackDtl(list.get(i));
    }
    return list;
}
public static FileMetal changeJobFileMetal(FileTemp temp, CaseInfo caseInfo,UserInfo userInfo){
    FileMetal jobfilemetal=new FileMetal();
    	String uuid=UUID.randomUUID().toString();
        jobfilemetal.setId(uuid);
        jobfilemetal.setCode(temp.getCode());
        jobfilemetal.setName(temp.getName());
        jobfilemetal.setCaseId(caseInfo.getId());
        jobfilemetal.setCaseCode(caseInfo.getCode());
        jobfilemetal.setCaseName(caseInfo.getName());
        jobfilemetal.setFileId("");
        jobfilemetal.setFileCode("");
        jobfilemetal.setFileName("");
        jobfilemetal.setParentId("");
        jobfilemetal.setType(temp.getMetalType());
        jobfilemetal.setSn(temp.getSn());
        jobfilemetal.setTreePath(temp.getTreePath()+"/"+uuid);
        jobfilemetal.setDiskPath(temp.getDiskPath()+"/"+uuid);
        jobfilemetal.setIcon(temp.getIcon());
        jobfilemetal.setIsScan(0);
        jobfilemetal.setPageCount(0);
        jobfilemetal.setPageStart(0);
        jobfilemetal.setPageEnd(0);
        jobfilemetal.setPrintCode("");
        jobfilemetal.setPrintCount(0);
        jobfilemetal.setBurnCount(0);
        jobfilemetal.setKeywords("");
        jobfilemetal.setStatus(JobConstant.PUTONGSTATUS);
        jobfilemetal.setReserve1(temp.getReserve1());
        jobfilemetal.setReserve2(temp.getReserve2());
        jobfilemetal.setReserve3(temp.getReserve3());
        jobfilemetal.setMemo(temp.getMemo());
        jobfilemetal.setRowStatus(3);
        jobfilemetal.setCreaterId(userInfo.getIdCard());
        jobfilemetal.setCreaterName(userInfo.getName());
        jobfilemetal.setCreateTime(new Date());
        jobfilemetal.setModerId(userInfo.getIdCard());
        jobfilemetal.setModerName(userInfo.getName());
        jobfilemetal.setModTime(new Date());
        jobfilemetal.setOrgC(caseInfo.getOrgC());
        jobfilemetal.setOrgS(caseInfo.getOrgS());
        jobfilemetal.setOrgT(caseInfo.getOrgT());
        jobfilemetal.setOrgCData(caseInfo.getOrgCData());
        jobfilemetal.setOrgSData(caseInfo.getOrgSData());
        jobfilemetal.setOrgTData(caseInfo.getOrgTData());
        jobfilemetal.setCurOrg(caseInfo.getCurOrg());
        jobfilemetal.setCurOrgData(caseInfo.getCurOrgData());
      //  jobfilemetal.setCaseTimeD(caseInfo.getCaseTimeD());
        return jobfilemetal;
}
public static FileTrack changeTrack(FileInfo fileInfo,UserInfo userInfo){
    FileTrack track=new FileTrack();
    track.setId(UUID.randomUUID().toString());
    track.setFileId(fileInfo.getId());
    track.setFileCode(fileInfo.getCode());
    track.setFileName(fileInfo.getName());
    track.setOperTime(new Date());
    track.setOperId(userInfo.getIdCard());
    track.setOperCode(userInfo.getPoliceCode());
    track.setOperName(userInfo.getName());
//    track.setOperType("0010");//0010
    track.setOperDetail("");//新建案卷
    track.setTagOrgCode("");
    track.setTagOrgName("");
    track.setTagUserCode("");
    track.setTagUserName("");
    track.setIsOpened(0);
//    track.setStatus(store.getStatus());
//    track.setReserve1();
//    track.setReserve2();
//    track.setReserve3();
    track.setMemo(fileInfo.getMemo());
    track.setRowStatus(3);
    track.setCreaterId(userInfo.getIdCard());
    track.setCreaterName(userInfo.getName());
    track.setCreateTime(new Date());
    track.setModerId(userInfo.getIdCard());
    track.setModerName(userInfo.getName());
    track.setModTime(new Date());
    track.setOrgC(fileInfo.getOrgC());
    track.setOrgS(fileInfo.getOrgS());
    track.setOrgT(fileInfo.getOrgT());
    track.setOrgCData(fileInfo.getOrgCData());
    track.setOrgSData(fileInfo.getOrgSData());
    track.setOrgTData(fileInfo.getOrgTData());
    track.setCurOrg(fileInfo.getCurOrg());
    track.setCurOrgData(fileInfo.getCurOrgData());
    track.setLoginType(userInfo.getLoginType());
    track.setOperdeptCode(userInfo.getDeptCode());
    track.setOperdeptName(userInfo.getDeptName());
    return track;
}
public static FileAuth changeJobFileAuth(FileInfo jobFileInfo,UserInfo userInfo){
    FileAuth auth=new FileAuth();
    auth.setId(UUID.randomUUID().toString());
    auth.setCaseId(jobFileInfo.getCaseId());
    auth.setCaseCode(jobFileInfo.getCaseCode());
    auth.setCaseName(jobFileInfo.getCaseName());
    auth.setFileId(jobFileInfo.getId());
    auth.setFileCode(jobFileInfo.getCode());
    auth.setFileName(jobFileInfo.getName());
//    auth.setMetalId(jobFileInfo.getMetalId());
//    auth.setMetalName(jobFileInfo.getMetalName());
//    auth.setPageId(jobFilePage.getId());
//    auth.setPageName(jobFilePage.getName());
//    auth.setOperId(userInfo.getId());
//    auth.setOperName(userInfo.getName());
//    auth.setOperType();
//    auth.setAuthType();
//    auth.setOrgCode(deptCode);
//    auth.setOrgName();
//    auth.setStatus();
//    auth.setReserve1();
//    auth.setReserve2();
//    auth.setReserve3();
//    auth.setMemo();
    auth.setRowStatus(3);
    auth.setCreaterId(userInfo.getIdCard());
    auth.setCreaterName(userInfo.getName());
    auth.setCreateTime(new Date());
    auth.setModerId(userInfo.getIdCard());
    auth.setModerName(userInfo.getName());
    auth.setModTime(new Date());
    auth.setOrgC(jobFileInfo.getOrgC());
    auth.setOrgS(jobFileInfo.getOrgS());
    auth.setOrgT(jobFileInfo.getOrgT());
    auth.setOrgCData(jobFileInfo.getOrgCData());
    auth.setOrgSData(jobFileInfo.getOrgSData());
    auth.setOrgTData(jobFileInfo.getOrgTData());
    auth.setCurOrg(jobFileInfo.getCurOrg());
    auth.setCurOrgData(jobFileInfo.getCurOrgData());
    return auth;
}
public static List<FileTrack> notNullFileTrack(List<FileTrack> list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == inspectId(list.get(i).getId())){
        list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getFileId() || false == inspectId(list.get(i).getFileId())){
        list.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getFileCode()){
        list.get(i).setFileCode("");
        }
        if(null == list.get(i).getFileName()){
        list.get(i).setFileName("");
        }
        if(null == list.get(i).getOperTime()){
        list.get(i).setOperTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOperId() || false == inspectId(list.get(i).getOperId())){
        list.get(i).setOperId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getOperName()){
        list.get(i).setOperName("");
        }
        if(null == list.get(i).getOperType()){
        list.get(i).setOperType("");
        }
        if(null == list.get(i).getOperDetail()){
        list.get(i).setOperDetail("");
        }
        if(null == list.get(i).getTagOrgCode()){
        list.get(i).setTagOrgCode("");
        }
        if(null == list.get(i).getTagOrgName()){
        list.get(i).setTagOrgName("");
        }
        if(null == list.get(i).getTagUserCode()){
            list.get(i).setTagUserCode("");
        }
        if(null == list.get(i).getTagUserName()){
        list.get(i).setTagUserName("");
        }
        if(null == list.get(i).getIsOpened()){
        list.get(i).setIsOpened(0);
        }
        if(null == list.get(i).getStatus()){
        list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
        list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
        list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
        list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
        list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
        list.get(i).setRowStatus(0);
        }
        if(null == list.get(i).getCreaterId()){
        list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
        list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
        list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
        list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
        list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
        list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOrgC()){
        list.get(i).setOrgC("");
        }
        if(null == list.get(i).getOrgS()){
        list.get(i).setOrgS("");
        }
        if(null == list.get(i).getOrgT()){
        list.get(i).setOrgT("");
        }
        if(null == list.get(i).getOrgCData()){
        list.get(i).setOrgCData("");
        }
        if(null == list.get(i).getOrgSData()){
        list.get(i).setOrgSData("");
        }
        if(null == list.get(i).getOrgTData()){
        list.get(i).setOrgTData("");
        }
        if(null == list.get(i).getCurOrg()){
        list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
        list.get(i).setCurOrgData("");
        }
        if(null == list.get(i).getLoginType()){
            list.get(i).setLoginType("");
        }
        if(null == list.get(i).getOperdeptCode()){
            list.get(i).setOperdeptCode("");
        }
        if(null == list.get(i).getOperdeptName()){
                list.get(i).setOperdeptName("");
        }
    }
    return list;
}
public static List<FilePage> filePageNotNull(List<FilePage> filePage){
    for(int i=0;i<filePage.size();i++){
        if(null == filePage.get(i).getId() || false == inspectId(filePage.get(i).getId())){
            filePage.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == filePage.get(i).getCode()){
            filePage.get(i).setCode("");
        }
        if(null == filePage.get(i).getName()){
            filePage.get(i).setName("");
        }
        if(null == filePage.get(i).getCaseId() || false == inspectId(filePage.get(i).getCaseId())){
            filePage.get(i).setCaseId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == filePage.get(i).getCaseCode()){
            filePage.get(i).setCaseCode("");
        }
        if(null == filePage.get(i).getCaseName()){
            filePage.get(i).setCaseName("");
        }
        if(null == filePage.get(i).getFileId() || false == inspectId(filePage.get(i).getFileId())){
            filePage.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == filePage.get(i).getFileCode()){
            filePage.get(i).setFileCode("");
        }
        if(null == filePage.get(i).getFileName()){
            filePage.get(i).setFileName("");
        }
        if(null == filePage.get(i).getMetalId()){
            filePage.get(i).setMetalId("");
        }
        if(null == filePage.get(i).getMetalName()){
            filePage.get(i).setMetalName("");
        }
        if(null == filePage.get(i).getType()){
            filePage.get(i).setType("");
        }
        if(null == filePage.get(i).getSn()){
            filePage.get(i).setSn(0.0);
        }
        if(null == filePage.get(i).getDiskPath()){
            filePage.get(i).setDiskPath("");
        }
        if(null == filePage.get(i).getDiskFilename()){
            filePage.get(i).setDiskFilename("");
        }
        if(null == filePage.get(i).getPrintCode()){
            filePage.get(i).setPrintCode("");
        }
        if(null == filePage.get(i).getPrintCount()){
            filePage.get(i).setPrintCount(0);
        }
        if(null == filePage.get(i).getBurnCount()){
            filePage.get(i).setBurnCount(0);
        }
        if(null == filePage.get(i).getKeywords()){
            filePage.get(i).setKeywords("");
        }
        if(null == filePage.get(i).getOwnerId()){
            filePage.get(i).setOwnerId("");
        }
        if(null == filePage.get(i).getOwnerCode()){
            filePage.get(i).setOwnerCode("");
        }
        if(null == filePage.get(i).getOwnerName()){
            filePage.get(i).setOwnerName("");
        }
        if(null == filePage.get(i).getStatus()){
            filePage.get(i).setStatus("");
        }
        if(null == filePage.get(i).getReserve1()){
            filePage.get(i).setReserve1("");
        }
        if(null == filePage.get(i).getReserve2()){
            filePage.get(i).setReserve2("");
        }
        if(null == filePage.get(i).getReserve3()){
            filePage.get(i).setReserve3("");
        }
        if(null == filePage.get(i).getMemo()){
            filePage.get(i).setMemo("");
        }
        if(null == filePage.get(i).getRowStatus()){
            filePage.get(i).setRowStatus(0);
        }
        if(null == filePage.get(i).getCreaterId()){
            filePage.get(i).setCreaterId("");
        }
        if(null == filePage.get(i).getCreaterName()){
            filePage.get(i).setCreaterName("");
        }
        if(null == filePage.get(i).getCreateTime()){
            filePage.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == filePage.get(i).getModerId()){
            filePage.get(i).setModerId("");
        }
        if(null == filePage.get(i).getModerName()){
            filePage.get(i).setModerName("");
        }
        if(null == filePage.get(i).getModTime()){
            filePage.get(i).setModTime(JobUtil.getDate());
        }
        if(null == filePage.get(i).getOrgC()){
            filePage.get(i).setOrgC("");
        }
        if(null == filePage.get(i).getOrgS()){
            filePage.get(i).setOrgS("");
        }
        if(null == filePage.get(i).getOrgT()){
            filePage.get(i).setOrgT("");
        }
        if(null == filePage.get(i).getOrgCData()){
            filePage.get(i).setOrgCData("");
        }
        if(null == filePage.get(i).getOrgSData()){
            filePage.get(i).setOrgSData("");
        }
        if(null == filePage.get(i).getOrgTData()){
            filePage.get(i).setOrgTData("");
        }
        if(null == filePage.get(i).getCurOrg()){
            filePage.get(i).setCurOrg("");
        }
        if(null == filePage.get(i).getTreePath()){
            filePage.get(i).setTreePath("");
        }
        if(null == filePage.get(i).getCurOrgData()){
            filePage.get(i).setCurOrgData("");
        }
        if(null == filePage.get(i).getEncryfileSize()){
            filePage.get(i).setEncryfileSize(0);
        }
        if(null == filePage.get(i).getDigitfileSize()){
            filePage.get(i).setDigitfileSize(0);
        }
    }
    return filePage;
}
public static CaseInfo caseInfoNotNull(CaseInfo caseInfo){
        if(null == caseInfo.getId() || false == inspectId(caseInfo.getId())){
            caseInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == caseInfo.getCode()){
            caseInfo.setCode("");
        }
        if(null == caseInfo.getName()){
            caseInfo.setName("");
        }
        if(null == caseInfo.getType()){
            caseInfo.setType("");
        }
        if(null == caseInfo.getTypeName()){
            caseInfo.setTypeName("");
        }
        if(null == caseInfo.getSn()){
            caseInfo.setSn(0.0);
        }
        if(null == caseInfo.getCause()){
            caseInfo.setCause("");
        }
        if(null == caseInfo.getSource()){
            caseInfo.setSource("");
        }
        if(null == caseInfo.getDetail()){
            caseInfo.setDetail("");
        }
//        if(null == caseInfo.getCaseTimeU()){
//            caseInfo.setCaseTimeU(JobUtil.getDate());
//        }
//        if(null == caseInfo.getCaseTimeD()){
//            caseInfo.setCaseTimeD(JobUtil.getDate());
//        }
        if(null == caseInfo.getHandleOrgCode()){
            caseInfo.setHandleOrgCode("");
        }
        if(null == caseInfo.getHandleOrgName()){
            caseInfo.setHandleOrgName("");
        }
        if(null == caseInfo.getHosterId()){
            caseInfo.setHosterId("");
        }
        if(null == caseInfo.getHosterPcode()){
            caseInfo.setHosterPcode("");
        }
        if(null == caseInfo.getHosterName()){
            caseInfo.setHosterName("");
        }
        if(null == caseInfo.getCasePlace()){
            caseInfo.setCasePlace("");
        }
//        if(null == caseInfo.getReportTime()){
//            caseInfo.setReportTime(getDate());
//        }
        if(null == caseInfo.getReporter()){
            caseInfo.setReporter("");
        }
        if(null == caseInfo.getReporterAdd()){
            caseInfo.setReporterAdd("");
        }
        if(null == caseInfo.getReporterTel()){
            caseInfo.setReporterTel("");
        }
        if(null == caseInfo.getAlarmName()){
            caseInfo.setAlarmName("");
        }
//        if(null == caseInfo.getAlarmTime()){
//            caseInfo.setAlarmTime(JobUtil.getDate());
//        }
//        if(null == caseInfo.getAcceptTime()){
//            caseInfo.setAcceptTime(JobUtil.getDate());
//        }
        if(null == caseInfo.getAcceptPcode()){
            caseInfo.setAcceptPcode("");
        }
        if(null == caseInfo.getAcceptName()){
            caseInfo.setAcceptName("");
        }
        if(null == caseInfo.getAcceptOrgCode()){
            caseInfo.setAcceptOrgCode("");
        }
        if(null == caseInfo.getAcceptOrgName()){
            caseInfo.setAcceptOrgName("");
        }
        if(null == caseInfo.getAcceptLocale()){
            caseInfo.setAcceptLocale("");
        }
        if(null == caseInfo.getCurstepId() || false == inspectId(caseInfo.getCurstepId())){
            caseInfo.setCurstepId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == caseInfo.getCurstepName()){
            caseInfo.setCurstepName("");
        }
//        if(null == caseInfo.getRegTime()){
//            caseInfo.setRegTime(getDate());
//        }
//        if(null == caseInfo.getRecvTime()){
//            caseInfo.setRecvTime(getDate());
//        }
        if(null == caseInfo.getDataSource()){
            caseInfo.setDataSource("");
        }
        if(null == caseInfo.getFilesCount()){
            caseInfo.setFilesCount(0);
        }
        if(null == caseInfo.getPrintCode()){
            caseInfo.setPrintCode("");
        }
        if(null == caseInfo.getPrintCount()){
            caseInfo.setPrintCount(0);
        }
        if(null == caseInfo.getBurnCount()){
            caseInfo.setBurnCount(0);
        }
        if(null == caseInfo.getKeywords()){
            caseInfo.setKeywords("");
        }
        if(null == caseInfo.getStatus()){
            caseInfo.setStatus("");
        }
        if(null == caseInfo.getReserve1()){
            caseInfo.setReserve1("");
        }
        if(null == caseInfo.getReserve2()){
            caseInfo.setReserve2("");
        }
        if(null == caseInfo.getReserve3()){
            caseInfo.setReserve3("");
        }
        if(null == caseInfo.getMemo()){
            caseInfo.setMemo("");
        }
        if(null == caseInfo.getRowStatus()){
            caseInfo.setRowStatus(0);
        }
        if(null == caseInfo.getCreaterId()){
            caseInfo.setCreaterId("");
        }
        if(null == caseInfo.getCreaterName()){
            caseInfo.setCreaterName("");
        }
//        if(null == caseInfo.getCreateTime()){
//            caseInfo.setCreateTime(JobUtil.getDate());
//        }
        if(null == caseInfo.getModerId()){
            caseInfo.setModerId("");
        }
        if(null == caseInfo.getModerName()){
            caseInfo.setModerName("");
        }
//        if(null == caseInfo.getModTime()){
//            caseInfo.setModTime(JobUtil.getDate());
//        }
        if(null == caseInfo.getOrgC()){
            caseInfo.setOrgC("");
        }
        if(null == caseInfo.getOrgS()){
            caseInfo.setOrgS("");
        }
        if(null == caseInfo.getOrgT()){
            caseInfo.setOrgT("");
        }
        if(null == caseInfo.getOrgCData()){
            caseInfo.setOrgCData("");
        }
        if(null == caseInfo.getOrgSData()){
            caseInfo.setOrgSData("");
        }
        if(null == caseInfo.getOrgTData()){
            caseInfo.setOrgTData("");
        }
        if(null == caseInfo.getCurOrg()){
            caseInfo.setCurOrg("");
        }
        if(null == caseInfo.getCurOrgData()){
            caseInfo.setCurOrgData("");
        }
        if(null == caseInfo.getNameSpell()){
            caseInfo.setNameSpell("");
        }
        if(null == caseInfo.getHosterSpell()){
            caseInfo.setHosterSpell("");
        }
    return caseInfo;
}
public static FileStore getjobFileStore(FilePage page,FileStore fileStore,UserInfo userInfo){
    FileStore jobFileStore=new FileStore();
    jobFileStore.setId(UUID.randomUUID().toString());
    jobFileStore.setFileId(page.getFileId());
    jobFileStore.setFileCode(page.getFileCode());
    jobFileStore.setFileName(page.getFileName());
    jobFileStore.setMetalId(page.getMetalId());
    jobFileStore.setMetalName(page.getMetalName());
    jobFileStore.setPageId(page.getId());
    jobFileStore.setPageName(page.getName());
    if(fileStore.getPlaceId() == null){
        fileStore.setPlaceId(IDDEFAULT);
    }
    jobFileStore.setPlaceId(fileStore.getPlaceId());
    jobFileStore.setPlaceName(fileStore.getPlaceName());
    if(fileStore.getAreaId() == null){
        fileStore.setAreaId(IDDEFAULT);
    }
    jobFileStore.setAreaId(fileStore.getAreaId());
    jobFileStore.setAreaName(fileStore.getAreaName());
    if(fileStore.getSpaceId() == null){
        fileStore.setSpaceId(IDDEFAULT);
    }
    jobFileStore.setSpaceId(fileStore.getSpaceId());
    jobFileStore.setSpaceName(fileStore.getSpaceName());
    jobFileStore.setEntryTime(new Date());
    jobFileStore.setOwnerId(fileStore.getOwnerId());
    jobFileStore.setOwnerCode(fileStore.getOwnerCode());
    jobFileStore.setOwnerName(fileStore.getOwnerName());
    jobFileStore.setOrgCode(fileStore.getOrgCode());
    jobFileStore.setOrgName(fileStore.getOrgName());
    jobFileStore.setStatus(fileStore.getStatus());
    jobFileStore.setMemo(fileStore.getMemo());
    jobFileStore.setRowStatus(3);
    jobFileStore.setCreaterId(userInfo.getIdCard());
    jobFileStore.setCreaterName(userInfo.getName());
    jobFileStore.setCreateTime(new Date());
    jobFileStore.setModerId(userInfo.getIdCard());
    jobFileStore.setModerName(userInfo.getName());
    jobFileStore.setModTime(new Date());
    jobFileStore.setOrgC(page.getOrgC());
    jobFileStore.setOrgS(page.getOrgS());
    jobFileStore.setOrgT(page.getOrgT());
    jobFileStore.setOrgCData(page.getOrgCData());
    jobFileStore.setOrgSData(page.getOrgSData());
    jobFileStore.setOrgTData(page.getOrgTData());
    jobFileStore.setCurOrg(page.getCurOrg());
    jobFileStore.setCurOrgData(page.getCurOrgData());
    return jobFileStore;
}
public static UserInfo changeJobUserInfo(SysUser sysUser){
    UserInfo userInfo= new UserInfo();
//    userInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    userInfo.setId(sysUser.getUserId()+"");
    userInfo.setCode(changeString(sysUser.getLoginName()));
    userInfo.setName(changeString(sysUser.getUserName()));
    userInfo.setType(changeString(sysUser.getUserType()));
    userInfo.setSn(0.0);
    userInfo.setPoliceCode(changeString(sysUser.getPoliceCode()));
    userInfo.setPassword(changeString(sysUser.getPassword()));
    userInfo.setPassSalt(changeString(sysUser.getSalt()));
    userInfo.setLev(Integer.parseInt(sysUser.getUserLevel()));
    userInfo.setDataLev(0);
    userInfo.setIdCard(changeString(sysUser.getIdcard()));
    userInfo.setTel(changeString(sysUser.getTel()));
    userInfo.setMobile(changeString(sysUser.getMobile()));
    userInfo.setEMail(changeString(sysUser.getEmail()));
    userInfo.setCertCode(changeString(sysUser.getCertificate()));
    userInfo.setStatus(changeString(sysUser.getStatus()));
    userInfo.setReserve1("");
    userInfo.setReserve2("");
    userInfo.setReserve3("");
    userInfo.setMemo(changeString(sysUser.getMemo()));
    userInfo.setRowStatus(3);
    userInfo.setCreaterId(sysUser.getIdcard());
    userInfo.setCreaterName(sysUser.getUserName());
    userInfo.setCreateTime(new Date());
    userInfo.setModerId(sysUser.getIdcard());
    userInfo.setModerName(sysUser.getUserName());
    userInfo.setModTime(new Date());
    userInfo.setOrgC(changeString(sysUser.getCunitid()));
    userInfo.setOrgS(changeString(sysUser.getSunitid()));
    userInfo.setOrgT(changeString(sysUser.getTunitid()));
    userInfo.setOrgCData(changeString(sysUser.getCunitid()));
    userInfo.setOrgSData(changeString(sysUser.getSunitid()));
    userInfo.setOrgTData(changeString(sysUser.getTunitid()));
    userInfo.setDeptCode(changeString(sysUser.getDeptId()));
    userInfo.setDeptName(changeString(sysUser.getReserve1()));
    userInfo.setHasFinger(changeInteger(sysUser.getHasFinger()));
    return userInfo;
}

//public static SysDicitem changeSysDicItem(SysDicItem sysDic){
//    SysDicitem jobSysDicitem = new SysDicitem();
//    jobSysDicitem.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
//    jobSysDicitem.setCode(changeString(sysDic.getItemCode()));
//    jobSysDicitem.setName(changeString(sysDic.getDicName()));
//    jobSysDicitem.setType("");
//    jobSysDicitem.setSn(0.0);
//    jobSysDicitem.setDicName(changeString(sysDic.getDicName()));
//    jobSysDicitem.setItemValue(changeString(sysDic.getItemValue()));
//    jobSysDicitem.setItemSpell(changeString(sysDic.getItemSpell()));
//    jobSysDicitem.setItemAspell(changeString(sysDic.getItemAspell()));
//    jobSysDicitem.setStatus("");
//    jobSysDicitem.setReserve1("");
//    jobSysDicitem.setReserve2("");
//    jobSysDicitem.setReserve3("");
//    jobSysDicitem.setMemo(sysDic.getMemo());
//    jobSysDicitem.setRowStatus(2);
//    jobSysDicitem.setCreaterId("");
//    jobSysDicitem.setCreaterName("");
//    jobSysDicitem.setCreateTime(getDate());
//    jobSysDicitem.setModerId("");
//    jobSysDicitem.setModerName("");
//    jobSysDicitem.setModTime(getDate());
//    return jobSysDicitem;
//}
public static List<FileMetal> isNotNullJobFileMetal(List<FileMetal> jobFileMetal){
    for(int i=0;i<jobFileMetal.size();i++){
        if(null == jobFileMetal.get(i).getId() || false == JobUtil.inspectId(jobFileMetal.get(i).getId())){
            jobFileMetal.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileMetal.get(i).getCode()){
            jobFileMetal.get(i).setCode("");
        }
        if(null == jobFileMetal.get(i).getName()){
            jobFileMetal.get(i).setName("");
        }
        if(null == jobFileMetal.get(i).getCaseId() || false == JobUtil.inspectId(jobFileMetal.get(i).getCaseId())){
            jobFileMetal.get(i).setCaseId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileMetal.get(i).getCaseName()){
            jobFileMetal.get(i).setCaseName("");
        }
        if(null == jobFileMetal.get(i).getFileId() || false == JobUtil.inspectId(jobFileMetal.get(i).getFileId())){
            jobFileMetal.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileMetal.get(i).getFileName()){
            jobFileMetal.get(i).setFileName("");
        }
        if(null == jobFileMetal.get(i).getParentId() || false == JobUtil.inspectId(jobFileMetal.get(i).getParentId())){
            jobFileMetal.get(i).setParentId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == jobFileMetal.get(i).getType()){
            jobFileMetal.get(i).setType("");
        }
        if(null == jobFileMetal.get(i).getSn()){
            jobFileMetal.get(i).setSn(0.0);
        }
        if(null == jobFileMetal.get(i).getTreePath()){
            jobFileMetal.get(i).setTreePath("");
        }
        if(null == jobFileMetal.get(i).getDiskPath()){
            jobFileMetal.get(i).setDiskPath("");
        }
        if(null == jobFileMetal.get(i).getIcon()){
            jobFileMetal.get(i).setIcon("");
        }
        if(null == jobFileMetal.get(i).getIsScan()){
            jobFileMetal.get(i).setIsScan(0);
        }
        if(null == jobFileMetal.get(i).getPageCount()){
            jobFileMetal.get(i).setPageCount(0);
        }
        if(null == jobFileMetal.get(i).getPageStart()){
            jobFileMetal.get(i).setPageStart(0);
        }
        if(null == jobFileMetal.get(i).getPageEnd()){
            jobFileMetal.get(i).setPageEnd(0);
        }

        if(null == jobFileMetal.get(i).getPrintCode()){
            jobFileMetal.get(i).setPrintCode("");
        }
        if(null == jobFileMetal.get(i).getPrintCount()){
            jobFileMetal.get(i).setPrintCount(0);
        }
        if(null == jobFileMetal.get(i).getBurnCount()){
            jobFileMetal.get(i).setBurnCount(0);
        }
        if(null == jobFileMetal.get(i).getKeywords()){
            jobFileMetal.get(i).setKeywords("");
        }

        if(null == jobFileMetal.get(i).getStatus()){
            jobFileMetal.get(i).setStatus("");
        }
        if(null == jobFileMetal.get(i).getReserve1()){
            jobFileMetal.get(i).setReserve1("");
        }
        if(null == jobFileMetal.get(i).getReserve2()){
            jobFileMetal.get(i).setReserve2("");
        }
        if(null == jobFileMetal.get(i).getReserve3()){
            jobFileMetal.get(i).setReserve3("");
        }
        if(null == jobFileMetal.get(i).getMemo()){
            jobFileMetal.get(i).setMemo("");
        }
        if(null == jobFileMetal.get(i).getRowStatus()){
            jobFileMetal.get(i).setRowStatus(0);
        }
        if(null == jobFileMetal.get(i).getCreaterId()){
            jobFileMetal.get(i).setCreaterId("");
        }
        if(null == jobFileMetal.get(i).getCreaterName()){
            jobFileMetal.get(i).setCreaterName("");
        }
        if(null == jobFileMetal.get(i).getCreateTime()){
            jobFileMetal.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == jobFileMetal.get(i).getModerId()){
            jobFileMetal.get(i).setModerId("");
        }
        if(null == jobFileMetal.get(i).getModerName()){
            jobFileMetal.get(i).setModerName("");
        }
        if(null == jobFileMetal.get(i).getModTime()){
            jobFileMetal.get(i).setModTime(JobUtil.getDate());
        }
        if(null == jobFileMetal.get(i).getOrgC()){
            jobFileMetal.get(i).setOrgC("");
        }
        if(null == jobFileMetal.get(i).getOrgS()){
            jobFileMetal.get(i).setOrgS("");
        }
        if(null == jobFileMetal.get(i).getOrgT()){
            jobFileMetal.get(i).setOrgT("");
        }
        if(null == jobFileMetal.get(i).getOrgCData()){
            jobFileMetal.get(i).setOrgCData("");
        }
        if(null == jobFileMetal.get(i).getOrgSData()){
            jobFileMetal.get(i).setOrgSData("");
        }
        if(null == jobFileMetal.get(i).getOrgTData()){
            jobFileMetal.get(i).setOrgTData("");
        }
        if(null == jobFileMetal.get(i).getCurOrg()){
            jobFileMetal.get(i).setCurOrg("");
        }
        if(null == jobFileMetal.get(i).getCurOrgData()){
            jobFileMetal.get(i).setCurOrgData("");
        }
    }
    return jobFileMetal;
  }
public static UserInfo isNotNull(UserInfo jobUserInfo){
    if(null == jobUserInfo.getId()){
        jobUserInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobUserInfo.getCode()){
        jobUserInfo.setCode("");
    }
    if(null == jobUserInfo.getName()){
        jobUserInfo.setName("");
    }
    if(null == jobUserInfo.getType()){
        jobUserInfo.setType("");
    }
    if(null == jobUserInfo.getSn()){
        jobUserInfo.setSn(0.0);
    }
    if(null == jobUserInfo.getPoliceCode()){
        jobUserInfo.setPoliceCode("");
    }
    if(null == jobUserInfo.getPassSalt()){
        jobUserInfo.setPassSalt("");
    }
    if(null == jobUserInfo.getLev()){
        jobUserInfo.setLev(0);
    }
    if(null == jobUserInfo.getDataLev()){
        jobUserInfo.setDataLev(0);
    }
    if(null == jobUserInfo.getIdCard()){
        jobUserInfo.setIdCard("");
    }
    if(null == jobUserInfo.getTel()){
        jobUserInfo.setTel("");
    }
    if(null == jobUserInfo.getMobile()){
        jobUserInfo.setMobile("");
    }
    if(null == jobUserInfo.getEMail()){
        jobUserInfo.setEMail("");
    }
    if(null == jobUserInfo.getCertCode()){
        jobUserInfo.setCertCode("");
    }
    if(null == jobUserInfo.getStatus()){
        jobUserInfo.setStatus("");
    }
    if(null == jobUserInfo.getReserve1()){
        jobUserInfo.setReserve1("");
    }
    if(null == jobUserInfo.getReserve2()){
        jobUserInfo.setReserve2("");
    }
    if(null == jobUserInfo.getReserve3()){
        jobUserInfo.setReserve3("");
    }
    if(null == jobUserInfo.getMemo()){
        jobUserInfo.setMemo("");
    }
    if(null == jobUserInfo.getRowStatus()){
        jobUserInfo.setRowStatus(0);
    }
    if(null == jobUserInfo.getCreaterId()){
        jobUserInfo.setCreaterId("");
    }
    if(null == jobUserInfo.getCreaterName()){
        jobUserInfo.setCreaterName("");
    }
    if(null == jobUserInfo.getCreateTime()){
        jobUserInfo.setCreateTime(JobUtil.getDate());
    }
    if(null == jobUserInfo.getModerId()){
        jobUserInfo.setModerId("");
    }
    if(null == jobUserInfo.getModerName()){
        jobUserInfo.setModerName("");
    }
    if(null == jobUserInfo.getModTime()){
        jobUserInfo.setModTime(JobUtil.getDate());
    }
    if(null == jobUserInfo.getOrgC()){
        jobUserInfo.setOrgC("");
    }
    if(null == jobUserInfo.getOrgS()){
        jobUserInfo.setOrgS("");
    }
    if(null == jobUserInfo.getOrgT()){
        jobUserInfo.setOrgT("");
    }
    if(null == jobUserInfo.getOrgCData()){
        jobUserInfo.setOrgCData("");
    }
    if(null == jobUserInfo.getOrgSData()){
        jobUserInfo.setOrgSData("");
    }
    if(null == jobUserInfo.getOrgTData()){
        jobUserInfo.setOrgTData("");
    }
    if(null == jobUserInfo.getCurOrg()){
        jobUserInfo.setCurOrg("");
    }
    if(null == jobUserInfo.getCurOrgData()){
        jobUserInfo.setCurOrgData("");
    }
    if(null == jobUserInfo.getLoginType()){
        jobUserInfo.setLoginType("");
    }
    if(null == jobUserInfo.getIsOnline()){
        jobUserInfo.setIsOnline(0);
    }
    if(null == jobUserInfo.getLastIp()){
        jobUserInfo.setLastIp("");
    }
    if(null == jobUserInfo.getLastTime()){
        jobUserInfo.setLastTime(getDate());
    }
    if(null == jobUserInfo.getDeptCode()){
        jobUserInfo.setDeptCode("");
    }
    if(null == jobUserInfo.getDeptName()){
        jobUserInfo.setDeptName("");
    }
    if(null == jobUserInfo.getHasFinger()){
        jobUserInfo.setHasFinger(0);;
    }
    return jobUserInfo;
}
public static List<CabPlace> isNotNullJobCabPlace(List<CabPlace> list){
        for(int i=0;i<list.size();i++){
            if(null == list.get(i).getId() || false == JobUtil.inspectId(list.get(i).getId())){
                list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
            }
            if(null == list.get(i).getCode()){
                list.get(i).setCode("");
                        }
            if(null == list.get(i).getName()){
                list.get(i).setName("");
            }
            if(null == list.get(i).getType()){
                list.get(i).setType("");
            }
            if(null == list.get(i).getSn()){
                list.get(i).setSn(0.0);
            }
            if(null == list.get(i).getAreaCount()){
                list.get(i).setAreaCount(0);
            }
            if(null == list.get(i).getSpaceCount()){
                list.get(i).setSpaceCount(0);
            }
            if(null == list.get(i).getOrgCode()){
                list.get(i).setOrgCode("");
            }
            if(null == list.get(i).getOrgName()){
                list.get(i).setOrgName("");
            }
            if(null == list.get(i).getStatus()){
                list.get(i).setStatus("");
            }
            if(null == list.get(i).getReserve1()){
                list.get(i).setReserve1("");
            }
            if(null == list.get(i).getReserve2()){
                list.get(i).setReserve2("");
            }
            if(null == list.get(i).getReserve3()){
                list.get(i).setReserve3("");
            }
            if(null == list.get(i).getMemo()){
                list.get(i).setMemo("");
            }
            if(null == list.get(i).getRowStatus()){
                list.get(i).setRowStatus(0);
            }
            if(null == list.get(i).getCreaterId()){
                list.get(i).setCreaterId("");
            }
            if(null == list.get(i).getCreaterName()){
                list.get(i).setCreaterName("");
            }
            if(null == list.get(i).getCreateTime()){
                list.get(i).setCreateTime(JobUtil.getDate());
            }
            if(null == list.get(i).getModerId()){
                list.get(i).setModerId("");
            }
            if(null == list.get(i).getModerName()){
                list.get(i).setModerName("");
            }
            if(null == list.get(i).getModTime()){
                list.get(i).setModTime(JobUtil.getDate());
            }
            if(null == list.get(i).getOrgC()){
                list.get(i).setOrgC("");
            }
            if(null == list.get(i).getOrgS()){
                list.get(i).setOrgS("");
            }
            if(null == list.get(i).getOrgT()){
                list.get(i).setOrgT("");
            }
            if(null == list.get(i).getOrgCData()){
                list.get(i).setOrgCData("");
            }
            if(null == list.get(i).getOrgSData()){
                list.get(i).setOrgSData("");
            }
            if(null == list.get(i).getOrgTData()){
                list.get(i).setOrgTData("");
            }
            if(null == list.get(i).getCurOrg()){
                list.get(i).setCurOrg("");
            }
            if(null == list.get(i).getCurOrgData()){
                list.get(i).setCurOrgData("");
            }
        }
        return list;
    }
public static List<CabArea> isNotNull(List<CabArea> list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == JobUtil.inspectId(list.get(i).getId())){
            list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getCode()){
            list.get(i).setCode("");
                    }
        if(null == list.get(i).getName()){
            list.get(i).setName("");
        }
        if(null == list.get(i).getPlaceId() || false == JobUtil.inspectId(list.get(i).getPlaceId())){
            list.get(i).setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getPlaceName()){
            list.get(i).setPlaceName("");
        }
        if(null == list.get(i).getType()){
            list.get(i).setType("");
        }
        if(null == list.get(i).getSn()){
            list.get(i).setSn(0.0);
        }
        if(null == list.get(i).getSpaceCount()){
            list.get(i).setSpaceCount(0);
        }
        if(null == list.get(i).getOrgCode()){
            list.get(i).setOrgCode("");
        }
        if(null == list.get(i).getOrgName()){
            list.get(i).setOrgName("");
        }
        if(null == list.get(i).getStatus()){
            list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
            list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
            list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
            list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
            list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
            list.get(i).setRowStatus(0);
        }
        if(null == list.get(i).getCreaterId()){
            list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
            list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
            list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
            list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
            list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
            list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOrgC()){
            list.get(i).setOrgC("");
        }
        if(null == list.get(i).getOrgS()){
            list.get(i).setOrgS("");
        }
        if(null == list.get(i).getOrgT()){
            list.get(i).setOrgT("");
        }
        if(null == list.get(i).getOrgCData()){
            list.get(i).setOrgCData("");
        }
        if(null == list.get(i).getOrgSData()){
            list.get(i).setOrgSData("");
        }
        if(null == list.get(i).getOrgTData()){
            list.get(i).setOrgTData("");
        }
        if(null == list.get(i).getCurOrg()){
            list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
            list.get(i).setCurOrgData("");
        }
    }
    return list;
}
public static CabSpace notNullJobCabSpace(CabSpace jobCabSpace){
    if(null == jobCabSpace.getId() || false == JobUtil.inspectId(jobCabSpace.getId())){
        jobCabSpace.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobCabSpace.getCode()){
        jobCabSpace.setCode("");
                }
    if(null == jobCabSpace.getName()){
        jobCabSpace.setName("");
    }
    if(jobCabSpace.getIsPublic()==null){
        jobCabSpace.setIsPublic(0);
    }
    if(null == jobCabSpace.getPlaceId() || false == JobUtil.inspectId(jobCabSpace.getPlaceId())){
        jobCabSpace.setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobCabSpace.getPlaceName()){
        jobCabSpace.setPlaceName("");
    }
    if(null == jobCabSpace.getAreaId() || false == JobUtil.inspectId(jobCabSpace.getAreaId())){
        jobCabSpace.setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobCabSpace.getAreaName()){
        jobCabSpace.setAreaName("");
    }
    if(null == jobCabSpace.getType()){
        jobCabSpace.setType("");
    }
    if(null == jobCabSpace.getSn()){
        jobCabSpace.setSn(0.0);
    }
    if(null == jobCabSpace.getOwnerId()){
        jobCabSpace.setOwnerId("");
    }
    if(null == jobCabSpace.getOwnerName()){
        jobCabSpace.setOwnerName("");
    }
    if(null == jobCabSpace.getGroupCode()){
        jobCabSpace.setGroupCode("");
    }
    if(null == jobCabSpace.getCapacity()){
        jobCabSpace.setCapacity(0);
    }
    if(null == jobCabSpace.getUsedCap()){
        jobCabSpace.setUsedCap(0);
    }
    if(null == jobCabSpace.getIsFull()){
        jobCabSpace.setIsFull(0);
    }
    if(null == jobCabSpace.getOrgCode()){
        jobCabSpace.setOrgCode("");
    }
    if(null == jobCabSpace.getOrgName()){
        jobCabSpace.setOrgName("");
    }
    if(null == jobCabSpace.getStatus()){
        jobCabSpace.setStatus("");
    }
    if(null == jobCabSpace.getReserve1()){
        jobCabSpace.setReserve1("");
    }
    if(null == jobCabSpace.getReserve2()){
        jobCabSpace.setReserve2("");
    }
    if(null == jobCabSpace.getReserve3()){
        jobCabSpace.setReserve3("");
    }
    if(null == jobCabSpace.getMemo()){
        jobCabSpace.setMemo("");
    }
    if(null == jobCabSpace.getRowStatus()){
        jobCabSpace.setRowStatus(0);
    }
    if(null == jobCabSpace.getCreaterId()){
        jobCabSpace.setCreaterId("");
    }
    if(null == jobCabSpace.getCreaterName()){
        jobCabSpace.setCreaterName("");
    }
    if(null == jobCabSpace.getCreateTime()){
        jobCabSpace.setCreateTime(JobUtil.getDate());
    }
    if(null == jobCabSpace.getModerId()){
        jobCabSpace.setModerId("");
    }
    if(null == jobCabSpace.getModerName()){
        jobCabSpace.setModerName("");
    }
    if(null == jobCabSpace.getModTime()){
        jobCabSpace.setModTime(JobUtil.getDate());
    }
    if(null == jobCabSpace.getOrgC()){
        jobCabSpace.setOrgC("");
    }
    if(null == jobCabSpace.getOrgS()){
        jobCabSpace.setOrgS("");
    }
    if(null == jobCabSpace.getOrgT()){
        jobCabSpace.setOrgT("");
    }
    if(null == jobCabSpace.getOrgCData()){
        jobCabSpace.setOrgCData("");
    }
    if(null == jobCabSpace.getOrgSData()){
        jobCabSpace.setOrgSData("");
    }
    if(null == jobCabSpace.getOrgTData()){
        jobCabSpace.setOrgTData("");
    }
    if(null == jobCabSpace.getCurOrg()){
        jobCabSpace.setCurOrg("");
    }
    if(null == jobCabSpace.getCurOrgData()){
        jobCabSpace.setCurOrgData("");
    }
    if(null == jobCabSpace.getFileCount()){
        jobCabSpace.setFileCount(0);
    }
    if(null == jobCabSpace.getCurFileCount()){
        jobCabSpace.setCurFileCount(0);
    }
    return jobCabSpace;
}
public static List<CabTrack> notNullJobCabTrack(List<CabTrack> list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == JobUtil.inspectId(list.get(i).getId())){
            list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getPlaceId() || false == JobUtil.inspectId(list.get(i).getPlaceId())){
            list.get(i).setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getPlaceName()){
            list.get(i).setPlaceName("");
        }
        if(null == list.get(i).getAreaId() || false == JobUtil.inspectId(list.get(i).getAreaId())){
            list.get(i).setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getAreaName()){
            list.get(i).setAreaName("");
        }
        if(null == list.get(i).getSpaceId() || false == JobUtil.inspectId(list.get(i).getSpaceId())){
            list.get(i).setSpaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getSpaceName()){
            list.get(i).setSpaceName("");
        }
        if(null == list.get(i).getCellId() || false == JobUtil.inspectId(list.get(i).getCellId())){
            list.get(i).setCellId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getCellName()){
            list.get(i).setCellName("");
        }
        if(null == list.get(i).getOperTime()){
            list.get(i).setOperTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOperId()){
            list.get(i).setOperId("");
        }
        if(null == list.get(i).getOperName()){
            list.get(i).setOperName("");
        }
        if(null == list.get(i).getOperType()){
            list.get(i).setOperType("");
        }
        if(null == list.get(i).getOperReson()){
            list.get(i).setOperReson("");
        }
        if(null == list.get(i).getFileId() || false == JobUtil.inspectId(list.get(i).getFileId())){
            list.get(i).setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getFileCode()){
            list.get(i).setFileCode("");
        }
        if(null == list.get(i).getFileName()){
            list.get(i).setFileName("");
        }
        if(null == list.get(i).getMetalId() || false == JobUtil.inspectId(list.get(i).getMetalId())){
            list.get(i).setMetalId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getMetalName()){
            list.get(i).setMetalName("");
        }
        if(null == list.get(i).getPageId() || false == JobUtil.inspectId(list.get(i).getPageId())){
            list.get(i).setPageId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getPageName()){
            list.get(i).setPageName("");
        }
        if(null == list.get(i).getStatus()){
            list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
            list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
            list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
            list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
            list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
            list.get(i).setRowStatus(3);
        }
        if(null == list.get(i).getCreaterId()){
            list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
            list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
            list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
            list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
            list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
            list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOrgC()){
            list.get(i).setOrgC("");
        }
        if(null == list.get(i).getOrgS()){
            list.get(i).setOrgS("");
        }
        if(null == list.get(i).getOrgT()){
            list.get(i).setOrgT("");
        }
        if(null == list.get(i).getOrgCData()){
            list.get(i).setOrgCData("");
        }
        if(null == list.get(i).getOrgSData()){
            list.get(i).setOrgSData("");
        }
        if(null == list.get(i).getOrgTData()){
            list.get(i).setOrgTData("");
        }
        if(null == list.get(i).getCurOrg()){
            list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
            list.get(i).setCurOrgData("");
        }
    }
    return list;
}
public static List<FileTemp> isBotnull(List<FileTemp> list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == JobUtil.inspectId(list.get(i).getId())){
            list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getCode()){
            list.get(i).setCode("");
                    }
        if(null == list.get(i).getName()){
            list.get(i).setName("");
        }
        if(null == list.get(i).getParentId() || false == JobUtil.inspectId(list.get(i).getParentId())){
            list.get(i).setParentId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getType()){
            list.get(i).setType("");
        }
        if(null == list.get(i).getSn()){
            list.get(i).setSn(0.0);
        }
        if(null == list.get(i).getMetalType()){
            list.get(i).setMetalType("");
        }
        if(list.get(i).getIsPublic()==null){
            list.get(i).setIsPublic(1);
        }
        if(null == list.get(i).getLev()){
            list.get(i).setLev(0);
        }
        if(null == list.get(i).getDescrip()){
            list.get(i).setDescrip("");
        }
        if(null == list.get(i).getTreePath()){
            list.get(i).setTreePath("");
        }
        if(null == list.get(i).getDiskPath()){
            list.get(i).setDiskPath("");
        }
        if(null == list.get(i).getIcon()){
            list.get(i).setIcon("");
        }
        if(null == list.get(i).getStatus()){
            list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
            list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
            list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
            list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
            list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
            list.get(i).setRowStatus(0);
        }
        if(null == list.get(i).getCreaterId()){
            list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
            list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
            list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
            list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
            list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
            list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getOrgC()){
            list.get(i).setOrgC("");
        }
        if(null == list.get(i).getOrgS()){
            list.get(i).setOrgS("");
        }
        if(null == list.get(i).getOrgT()){
            list.get(i).setOrgT("");
        }
        if(null == list.get(i).getOrgCData()){
            list.get(i).setOrgCData("");
        }
        if(null == list.get(i).getOrgSData()){
            list.get(i).setOrgSData("");
        }
        if(null == list.get(i).getOrgTData()){
            list.get(i).setOrgTData("");
        }
        if(null == list.get(i).getCurOrg()){
            list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
            list.get(i).setCurOrgData("");
        }
    }
    return list;
}
//public static OrgInfo changeJobOrgInfo(SysDept dept){
//    OrgInfo jobOrgInfo=new OrgInfo();
//    jobOrgInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
//    jobOrgInfo.setCode(JobUtil.changeString(dept.getDeptId()));
//    jobOrgInfo.setName(JobUtil.changeString(dept.getDeptName()));
//    jobOrgInfo.setType("");
//    jobOrgInfo.setSn(0.0);
//    jobOrgInfo.setParentCode(JobUtil.changeString(dept.getParentDeptId()));
//    if(dept != null){
//        jobOrgInfo.setAdminLev(JobUtil.changeInteger(dept.getDeptLevel()));
//    }
//    jobOrgInfo.setManager(JobUtil.changeString(dept.getManager()));
//    jobOrgInfo.setTel(JobUtil.changeString(dept.getTel()));
//    jobOrgInfo.setFax(JobUtil.changeString(dept.getFax()));
//    jobOrgInfo.setStatus("");
//    jobOrgInfo.setReserve1("");
//    jobOrgInfo.setReserve2("");
//    jobOrgInfo.setReserve3("");
//    jobOrgInfo.setMemo(JobUtil.changeString(dept.getMemo()));
//    jobOrgInfo.setRowStatus(3);
//    jobOrgInfo.setCreaterId("");
//    jobOrgInfo.setCreaterName("");
//    jobOrgInfo.setCreateTime(JobUtil.getDate());
//    jobOrgInfo.setModerId("");
//    jobOrgInfo.setModerName("");
//    jobOrgInfo.setModTime(JobUtil.getDate());
//    jobOrgInfo.setOrgC(JobUtil.changeString(dept.getCunitid()));
//    jobOrgInfo.setOrgS(JobUtil.changeString(dept.getSunitid()));
//    jobOrgInfo.setOrgT(JobUtil.changeString(dept.getTunitid()));
//    jobOrgInfo.setOrgCData(JobUtil.changeString(dept.getDataCunitid()));
//    jobOrgInfo.setOrgSData(JobUtil.changeString(dept.getDataSunitid()));
//    jobOrgInfo.setOrgTData(JobUtil.changeString(dept.getDataTunitid()));
//    return jobOrgInfo;
//}
public static RoleInfo changeJobRoleInfo(SysRole sysRole){
    RoleInfo jobRoleInfo=new RoleInfo();
    jobRoleInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    jobRoleInfo.setCode(changeString(sysRole.getRoleId().toString()));
    jobRoleInfo.setName(changeString(sysRole.getRoleName()));
    jobRoleInfo.setType("");
    jobRoleInfo.setSn(0.0);
    if(null != sysRole.getRoleLevel()){
        jobRoleInfo.setDataLev(Integer.parseInt(sysRole.getRoleLevel()));
    }
    jobRoleInfo.setStatus("");
    jobRoleInfo.setReserve1("");
    jobRoleInfo.setReserve2("");
    jobRoleInfo.setReserve3("");
    jobRoleInfo.setMemo(changeString(sysRole.getRoleDerc()));
    jobRoleInfo.setRowStatus(0);
    jobRoleInfo.setCreaterId("");
    jobRoleInfo.setCreaterName("");
    jobRoleInfo.setCreateTime(getDate());
    jobRoleInfo.setModerId("");
    jobRoleInfo.setModerName("");
    jobRoleInfo.setModTime(getDate());
    jobRoleInfo.setOrgC("");
    jobRoleInfo.setOrgS("");
    jobRoleInfo.setOrgT("");
    jobRoleInfo.setOrgCData("");
    jobRoleInfo.setOrgSData("");
    jobRoleInfo.setOrgTData("");
    jobRoleInfo.setCurOrg("");
    jobRoleInfo.setCurOrgData("");
    return jobRoleInfo;
}
public static SmartInfo notJobSmartInfo(SmartInfo jobSmartInfo){
    if(null == jobSmartInfo.getId()){
        jobSmartInfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobSmartInfo.getCode()){
        jobSmartInfo.setCode("");
                }
    if(null == jobSmartInfo.getName()){
        jobSmartInfo.setName("");
    }
    if(null == jobSmartInfo.getType()){
        jobSmartInfo.setType("");
    }
    if(null == jobSmartInfo.getSn()){
        jobSmartInfo.setSn(0.0);
    }
    if(jobSmartInfo.getAppCode() ==null){
        jobSmartInfo.setAppCode("");
    }
    if(jobSmartInfo.getAppName() ==null){
        jobSmartInfo.setAppName("");
    }
    if(jobSmartInfo.getVersionCode() ==null){
        jobSmartInfo.setVersionCode("");
    }
    if(jobSmartInfo.getFileVersion() ==null){
        jobSmartInfo.setFileVersion("");
    }
    if(jobSmartInfo.getOrgCode() ==null){
        jobSmartInfo.setOrgCode("");
    }
    if(jobSmartInfo.getOrgName() ==null){
        jobSmartInfo.setOrgName("");
    }
    if(jobSmartInfo.getSvcStart() ==null){
        jobSmartInfo.setSvcStart(getDate());
    }
    if(jobSmartInfo.getSvcLimit() ==null){
        jobSmartInfo.setSvcLimit(0);
    }
    if(jobSmartInfo.getSvcUsers() ==null){
        jobSmartInfo.setSvcUsers(0);
    }
    if(jobSmartInfo.getSmartUid() ==null){
        jobSmartInfo.setSmartUid("");;
    }
    if(jobSmartInfo.getMac() ==null){
        jobSmartInfo.setMac("");
    }
    if(null == jobSmartInfo.getStatus()){
        jobSmartInfo.setStatus("");
    }
    if(null == jobSmartInfo.getReserve1()){
        jobSmartInfo.setReserve1("");
    }
    if(null == jobSmartInfo.getReserve2()){
        jobSmartInfo.setReserve2("");
    }
    if(null == jobSmartInfo.getReserve3()){
        jobSmartInfo.setReserve3("");
    }
    if(null == jobSmartInfo.getMemo()){
        jobSmartInfo.setMemo("");
    }
    if(null == jobSmartInfo.getRowStatus()){
        jobSmartInfo.setRowStatus(0);
    }
    if(null == jobSmartInfo.getCreaterId()){
        jobSmartInfo.setCreaterId("");
    }
    if(null == jobSmartInfo.getCreaterName()){
        jobSmartInfo.setCreaterName("");
    }
    if(null == jobSmartInfo.getCreateTime()){
        jobSmartInfo.setCreateTime(JobUtil.getDate());
    }
    if(null == jobSmartInfo.getModerId()){
        jobSmartInfo.setModerId("");
    }
    if(null == jobSmartInfo.getModerName()){
        jobSmartInfo.setModerName("");
    }
    if(null == jobSmartInfo.getModTime()){
        jobSmartInfo.setModTime(JobUtil.getDate());
    }
    if(null == jobSmartInfo.getOrgC()){
        jobSmartInfo.setOrgC("");
    }
    if(null == jobSmartInfo.getOrgS()){
        jobSmartInfo.setOrgS("");
    }
    if(null == jobSmartInfo.getOrgT()){
        jobSmartInfo.setOrgT("");
    }
    if(null == jobSmartInfo.getOrgCData()){
        jobSmartInfo.setOrgCData("");
    }
    if(null == jobSmartInfo.getOrgSData()){
        jobSmartInfo.setOrgSData("");
    }
    if(null == jobSmartInfo.getOrgTData()){
        jobSmartInfo.setOrgTData("");
    }
    if(null == jobSmartInfo.getCurOrg()){
        jobSmartInfo.setCurOrg("");
    }
    if(null == jobSmartInfo.getCurOrgData()){
        jobSmartInfo.setCurOrgData("");
    }
    if(null == jobSmartInfo.getIp()){
        jobSmartInfo.setIp("");
    }
    return jobSmartInfo;
}
public static List<SmartDev> changeJobSmartDev(List<SmartDev>   list){
    for(int i=0;i<list.size();i++){
        if(null == list.get(i).getId() || false == JobUtil.inspectId(list.get(i).getId())){
            list.get(i).setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == list.get(i).getCode()){
            list.get(i).setCode("");
                    }
        if(null == list.get(i).getName()){
            list.get(i).setName("");
        }
        if(null == list.get(i).getType()){
            list.get(i).setType("");
        }
        if(null == list.get(i).getSn()){
            list.get(i).setSn(0.0);
        }
        if(null == list.get(i).getSmartId()){
            list.get(i).setSmartId("");
        }
        if(null == list.get(i).getSmartName()){
            list.get(i).setSmartName("");
        }
        if(null == list.get(i).getIsDetect()){
            list.get(i).setIsDetect(1);
        }
        if(null == list.get(i).getDetectType()){
            list.get(i).setDetectType(0);
        }
        if(null == list.get(i).getFlagStr()){
            list.get(i).setFlagStr("");
        }
        if(null == list.get(i).getStatus()){
            list.get(i).setStatus("");
        }
        if(null == list.get(i).getReserve1()){
            list.get(i).setReserve1("");
        }
        if(null == list.get(i).getReserve2()){
            list.get(i).setReserve2("");
        }
        if(null == list.get(i).getReserve3()){
            list.get(i).setReserve3("");
        }
        if(null == list.get(i).getMemo()){
            list.get(i).setMemo("");
        }
        if(null == list.get(i).getRowStatus()){
            list.get(i).setRowStatus(0);
        }
        if(null == list.get(i).getCreaterId()){
            list.get(i).setCreaterId("");
        }
        if(null == list.get(i).getCreaterName()){
            list.get(i).setCreaterName("");
        }
        if(null == list.get(i).getCreateTime()){
            list.get(i).setCreateTime(JobUtil.getDate());
        }
        if(null == list.get(i).getModerId()){
            list.get(i).setModerId("");
        }
        if(null == list.get(i).getModerName()){
            list.get(i).setModerName("");
        }
        if(null == list.get(i).getModTime()){
            list.get(i).setModTime(JobUtil.getDate());
        }
        if(null == list.get(i).getCurOrg()){
            list.get(i).setCurOrg("");
        }
        if(null == list.get(i).getCurOrgData()){
            list.get(i).setCurOrgData("");
        }
    }
    return list;
}

public static FileStore changeJobFileStore(FileStore jobFileStore){
    if(null == jobFileStore.getId() || false == JobUtil.inspectId(jobFileStore.getId())){
        jobFileStore.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobFileStore.getFileId()){
        jobFileStore.setFileId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
                }
    if(null == jobFileStore.getFileCode()){
        jobFileStore.setFileCode("");
    }
    if(null == jobFileStore.getFileName()){
        jobFileStore.setFileName("");
    }
    if(null == jobFileStore.getMetalId()){
        jobFileStore.setMetalId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());;
    }
    if(null == jobFileStore.getMetalName()){
        jobFileStore.setMetalName("");
    }
    if(jobFileStore.getPageId()==null){
        jobFileStore.setPageId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());;
    }
    if(null == jobFileStore.getPageName()){
        jobFileStore.setPageName("");;
    }
    if(null == jobFileStore.getPlaceId()){
        jobFileStore.setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobFileStore.getPlaceName()){
        jobFileStore.setPlaceName("");
    }
    if(null == jobFileStore.getAreaId()){
        jobFileStore.setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobFileStore.getAreaName()){
        jobFileStore.setAreaName("");
    }

    if(null == jobFileStore.getSpaceId()){
        jobFileStore.setSpaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());;
    }
    if(null == jobFileStore.getSpaceName()){
        jobFileStore.setSpaceName("");
    }
    if(null == jobFileStore.getCellId()){
        jobFileStore.setCellId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
    }
    if(null == jobFileStore.getCellName()){
        jobFileStore.setCellName("");
    }
    if(null == jobFileStore.getEntryTime()){
        jobFileStore.setEntryTime(getDate());
    }

    if(null == jobFileStore.getOwnerId()){
        jobFileStore.setOwnerId("");;
    }
    if(null == jobFileStore.getOwnerCode()){
        jobFileStore.setOwnerCode("");
    }
    if(null == jobFileStore.getOwnerName()){
        jobFileStore.setOwnerName("");
    }
    if(null == jobFileStore.getOrgCode()){
        jobFileStore.setOrgCode("");
    }
    if(null == jobFileStore.getOrgName()){
        jobFileStore.setOrgName("");
    }

    if(null == jobFileStore.getStatus()){
        jobFileStore.setStatus("");
    }
    if(null == jobFileStore.getReserve1()){
        jobFileStore.setReserve1("");
    }
    if(null == jobFileStore.getReserve2()){
        jobFileStore.setReserve2("");
    }
    if(null == jobFileStore.getReserve3()){
        jobFileStore.setReserve3("");
    }
    if(null == jobFileStore.getMemo()){
        jobFileStore.setMemo("");
    }
    if(null == jobFileStore.getRowStatus()){
        jobFileStore.setRowStatus(0);
    }
    if(null == jobFileStore.getCreaterId()){
        jobFileStore.setCreaterId("");
    }
    if(null == jobFileStore.getCreaterName()){
        jobFileStore.setCreaterName("");
    }
    if(null == jobFileStore.getCreateTime()){
        jobFileStore.setCreateTime(JobUtil.getDate());
    }
    if(null == jobFileStore.getModerId()){
        jobFileStore.setModerId("");
    }
    if(null == jobFileStore.getModerName()){
        jobFileStore.setModerName("");
    }
    if(null == jobFileStore.getModTime()){
        jobFileStore.setModTime(JobUtil.getDate());
    }
    if(null == jobFileStore.getOrgC()){
        jobFileStore.setOrgC("");
    }
    if(null == jobFileStore.getOrgS()){
        jobFileStore.setOrgS("");
    }
    if(null == jobFileStore.getOrgT()){
        jobFileStore.setOrgT("");
    }
    if(null == jobFileStore.getOrgCData()){
        jobFileStore.setOrgCData("");
    }
    if(null == jobFileStore.getOrgSData()){
        jobFileStore.setOrgSData("");
    }
    if(null == jobFileStore.getOrgTData()){
        jobFileStore.setOrgTData("");
    }
    if(null == jobFileStore.getCurOrg()){
        jobFileStore.setCurOrg("");
    }
    if(null == jobFileStore.getCurOrgData()){
        jobFileStore.setCurOrgData("");
    }
    return jobFileStore;
}
public static List<SysRole> SysRoleIsNull(List<SysRole> sysRoleList){
    for (int i = 0; i < sysRoleList.size(); i++) {
        if(sysRoleList.get(i).getRoleId() == null){
            sysRoleList.get(i).setRoleId("");
        }
        if(sysRoleList.get(i).getRoleName() == null){
            sysRoleList.get(i).setRoleName("");
        }
        if(sysRoleList.get(i).getRoleLevel() == null){
            sysRoleList.get(i).setRoleLevel("");
        }
        if(sysRoleList.get(i).getRoleDerc() == null){
            sysRoleList.get(i).setRoleDerc("");
        }
        if(sysRoleList.get(i).getOrderFlag() == null){
            sysRoleList.get(i).setOrderFlag(Math.toIntExact(0L));
        }
        if(sysRoleList.get(i).getReserve1() == null){
            sysRoleList.get(i).setReserve1("");
        }
        if(sysRoleList.get(i).getReserve2() == null){
            sysRoleList.get(i).setReserve2("");
        }
        if(sysRoleList.get(i).getReserve3() == null){
            sysRoleList.get(i).setReserve3("");
        }
        if(sysRoleList.get(i).getReserve4() == null){
            sysRoleList.get(i).setReserve4("");
        }
        if(sysRoleList.get(i).getReserve5() == null){
            sysRoleList.get(i).setReserve5("");
        }
        if(sysRoleList.get(i).getAddUserId() == null){
            sysRoleList.get(i).setAddUserId("");
        }
        if(sysRoleList.get(i).getAddUserName() == null){
            sysRoleList.get(i).setAddUserName("");
        }
        if(sysRoleList.get(i).getAddTime() == null){
            sysRoleList.get(i).setAddTime(getDate());
        }
        if(sysRoleList.get(i).getModifyUserId() == null){
            sysRoleList.get(i).setModifyUserId("");
        }
        if(sysRoleList.get(i).getModifyUserName() == null){
            sysRoleList.get(i).setModifyUserName("");
        }
        if(sysRoleList.get(i).getModifyTime() == null){
            sysRoleList.get(i).setModifyTime(getDate());
        }
    }

    return sysRoleList;
}
public static FileTrack assignment(FilePage filepage,FileStore store,UserInfo userInfo,FileInfo jobFileInfo){
    FileTrack track=new FileTrack();
    track.setId(UUID.randomUUID().toString());
    track.setFileId(filepage.getFileId());
    track.setFileCode(filepage.getFileCode());
    track.setFileName(filepage.getFileName());
    track.setOperTime(new Date());
//    track.setOperType("提请逮捕");
    track.setOperId(userInfo.getIdCard());
    track.setOperCode(userInfo.getPoliceCode());
    track.setOperName(userInfo.getName());
//    track.setOperReson("提请逮捕");
//    track.setOrgCode(filepage.getOrgCode());
//    track.setOrgName(filepage.getOrgName());
    track.setIsOpened(0);
    track.setStatus(filepage.getStatus());
//    track.setReserve1();
//    track.setReserve2();
//    track.setReserve3();
    track.setMemo(filepage.getMemo());
    track.setRowStatus(3);
    track.setCreaterId(userInfo.getIdCard());
    track.setCreaterName(userInfo.getName());
    track.setCreateTime(new Date());
    track.setModerId(userInfo.getIdCard());
    track.setModerName(userInfo.getName());
    track.setModTime(new Date());
    track.setOrgC(jobFileInfo.getOrgC());
    track.setOrgS(jobFileInfo.getOrgS());
    track.setOrgT(jobFileInfo.getOrgT());
    track.setOrgCData(jobFileInfo.getOrgCData());
    track.setOrgSData(jobFileInfo.getOrgSData());
    track.setOrgTData(jobFileInfo.getOrgTData());
    track.setCurOrg(jobFileInfo.getCurOrg());
    track.setCurOrgData(jobFileInfo.getCurOrgData());
    track.setOperdeptCode(userInfo.getDeptCode());
    track.setOperdeptName(userInfo.getDeptName());
    return track;
}

public static String changeString(String str){
    if(null == str){
        return "";
    }
    return str;
}
public static Date changeDate(Date date){
    if(null == date ){
        return JobUtil.getDate();
    }
    return date;
}
public static Integer changeInteger(Integer inte){
    if(null == inte){
        return 0;
    }
    return inte;
}
public static String returnNull(String str){
    if(!StringUtils.hasText(str)){
        return "<Null>";
    }
    return str;
}
public static String returnNullByObject(Object str){
    if(str == null){
        return "<Null>";
    }
    return str.toString();
}
public static boolean inspectId(String str){
    String regex ="[0-9a-fA-F]{8}(-)?[0-9a-fA-F]{4}(-)?[0-9a-fA-F]{4}(-)?[0-9a-fA-F]{4}(-)?[0-9a-fA-F]{12}";
    return str.matches(regex);
}
public static final CaseStateInfo changeJobCaseStateInfo(KeAjjbxx keAjjbxx, UserInfo jobUserInfo, String stateBm, String stateMc){
	CaseStateInfo JobCaseStateInfo=new CaseStateInfo();
	JobCaseStateInfo.setId(UUID.randomUUID().toString());
	JobCaseStateInfo.setAjbh(keAjjbxx.getAjbh());
	JobCaseStateInfo.setAjmc(keAjjbxx.getAjmc());
	JobCaseStateInfo.setType(operationType(keAjjbxx.getAjlb(),1));
	JobCaseStateInfo.setTypeName(operationType(keAjjbxx.getAjlb(),2));
	JobCaseStateInfo.setBadwBm(keAjjbxx.getBadwBm());
	JobCaseStateInfo.setBadwMc(keAjjbxx.getBadwMc());
	JobCaseStateInfo.setZbrSfzhm(keAjjbxx.getZbrSfzhm());
	JobCaseStateInfo.setZbrJh(keAjjbxx.getZbrJh());
	JobCaseStateInfo.setZbrXm(keAjjbxx.getZbrXm());
	JobCaseStateInfo.setTstationid(keAjjbxx.getTstationid());
	JobCaseStateInfo.setSstationid(keAjjbxx.getSstationid());
	JobCaseStateInfo.setCstationid(keAjjbxx.getCstationid());
	JobCaseStateInfo.setSlsj(keAjjbxx.getSlsj());
	JobCaseStateInfo.setStateBm(stateBm);
	JobCaseStateInfo.setStateMc(stateMc);
	JobCaseStateInfo.setStateTime(new Date());
	JobCaseStateInfo.setCreaterDeptId(jobUserInfo.getDeptCode());
	JobCaseStateInfo.setCreaterDeptName(jobUserInfo.getDeptName());
	JobCaseStateInfo.setCreaterId(jobUserInfo.getIdCard());
	JobCaseStateInfo.setCreaterName(jobUserInfo.getName());
	JobCaseStateInfo.setCreateTime(new Date());
	return JobCaseStateInfo;
}
public static final CaseStateInfo changeJobCaseStateInfo(CaseInfo jobCaseInfo,UserInfo jobUserInfo,String stateBm,String stateMc){
	CaseStateInfo JobCaseStateInfo=new CaseStateInfo();
	JobCaseStateInfo.setId(UUID.randomUUID().toString());
	JobCaseStateInfo.setAjbh(jobCaseInfo.getCode());
	JobCaseStateInfo.setAjmc(jobCaseInfo.getName());
	JobCaseStateInfo.setType(jobCaseInfo.getType());
	JobCaseStateInfo.setTypeName(jobCaseInfo.getTypeName());
	JobCaseStateInfo.setBadwBm(jobCaseInfo.getHandleOrgCode());
	JobCaseStateInfo.setBadwMc(jobCaseInfo.getHandleOrgName());
	JobCaseStateInfo.setZbrSfzhm(jobCaseInfo.getHosterId());
	JobCaseStateInfo.setZbrJh(jobCaseInfo.getHosterPcode());
	JobCaseStateInfo.setZbrXm(jobCaseInfo.getHosterName());
	JobCaseStateInfo.setTstationid(jobCaseInfo.getOrgTData());
	JobCaseStateInfo.setSstationid(jobCaseInfo.getOrgSData());
	JobCaseStateInfo.setCstationid(jobCaseInfo.getOrgCData());
	JobCaseStateInfo.setSlsj(jobCaseInfo.getAcceptTime());
	JobCaseStateInfo.setStateBm(stateBm);
	JobCaseStateInfo.setStateMc(stateMc);
	JobCaseStateInfo.setStateTime(new Date());
	JobCaseStateInfo.setCreaterDeptId(jobUserInfo.getDeptCode());
	JobCaseStateInfo.setCreaterDeptName(jobUserInfo.getDeptName());
	JobCaseStateInfo.setCreaterId(jobUserInfo.getIdCard());
	JobCaseStateInfo.setCreaterName(jobUserInfo.getName());
	JobCaseStateInfo.setCreateTime(new Date());
	return JobCaseStateInfo;
}
/**
 * 用于处理以前数据
 */
//处理已有的数据，进行存入jobcaseStateInfo
public static final CaseStateInfo changeJobCaseStateInfoHave(Date date, KeAjjbxx keAjjbxx,UserInfo jobUserInfo,String stateBm,String stateMc){
	CaseStateInfo JobCaseStateInfo=new CaseStateInfo();
	JobCaseStateInfo.setId(UUID.randomUUID().toString());
	JobCaseStateInfo.setAjbh(keAjjbxx.getAjbh());
	JobCaseStateInfo.setAjmc(keAjjbxx.getAjmc());
	JobCaseStateInfo.setType(operationType(keAjjbxx.getAjlb(),1));
	JobCaseStateInfo.setTypeName(operationType(keAjjbxx.getAjlb(),2));
	JobCaseStateInfo.setBadwBm(keAjjbxx.getBadwBm());
	JobCaseStateInfo.setBadwMc(keAjjbxx.getBadwMc());
	JobCaseStateInfo.setZbrSfzhm(keAjjbxx.getZbrSfzhm());
	JobCaseStateInfo.setZbrJh(keAjjbxx.getZbrJh());
	JobCaseStateInfo.setZbrXm(keAjjbxx.getZbrXm());
	JobCaseStateInfo.setTstationid(keAjjbxx.getTstationid());
	JobCaseStateInfo.setSstationid(keAjjbxx.getSstationid());
	JobCaseStateInfo.setCstationid(keAjjbxx.getCstationid());
	JobCaseStateInfo.setSlsj(keAjjbxx.getSlsj());
	JobCaseStateInfo.setStateBm(stateBm);
	JobCaseStateInfo.setStateMc(stateMc);
	JobCaseStateInfo.setStateTime(date);
	JobCaseStateInfo.setCreaterDeptId(jobUserInfo.getDeptCode());
	JobCaseStateInfo.setCreaterDeptName(jobUserInfo.getDeptName());
	JobCaseStateInfo.setCreaterId(jobUserInfo.getIdCard());
	JobCaseStateInfo.setCreaterName(jobUserInfo.getName());
	JobCaseStateInfo.setCreateTime(date);
	return JobCaseStateInfo;
}
//传进来的案件类型如果为     1   就返回编号   ,2就返回名称
public static final String operationType(String ajlb,int lx){
	if(null != ajlb && ajlb.equals("01")){
		if(lx ==1){
			return JobConstant.XINGSHI;
		}else if(lx ==2){
			return "刑事案件";
		}
	}else if(null != ajlb && ajlb.equals("02")){
		if(lx ==1){
			return JobConstant.XINGZHENG;
		}else if(lx ==2){
			return "行政案件";
		}
	}else if(null != ajlb && ajlb.equals("03")){
		if(lx ==1){
			return JobConstant.XINGZHENGFUYI;
		}else if(lx ==2){
			return "行政复议";
		}
	}else if(null != ajlb && ajlb.equals("04")){
		if(lx ==1){
			return JobConstant.XINGZHENGSS;
		}else if(lx ==2){
			return "行政诉讼";
		}
	}else if(null != ajlb && ajlb.equals("05")){
		if(lx ==1){
			return JobConstant.GUOJIAPEICHANG;
		}else if(lx ==2){
			return "国家赔偿";
		}
	}else if(null != ajlb && ajlb.equals("06")){
		if(lx ==1){
			return JobConstant.QITA;
		}else if(lx ==2){
			return "其他案件";
		}
	}

	if(null != ajlb && ajlb.equals(JobConstant.XINGSHI)){
		if(lx ==1){
			return  "01";
		}else if(lx ==2){
			return "刑事案件";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.XINGSHIFUYI)){
		if(lx ==1){
//			return  "01";
		}else if(lx ==2){
			return "刑事复议";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.XINGZHENG)){
		if(lx ==1){
			return "02";
		}else if(lx ==2){
			return "行政案件";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.XINGZHENGFUYI)){
		if(lx ==1){
			return "03";
		}else if(lx ==2){
			return "行政复议";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.XINGZHENGSS)){
		if(lx ==1){
			return "04";
		}else if(lx ==2){
			return "行政诉讼";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.GUOJIAPEICHANG)){
		if(lx ==1){
			return "05";
		}else if(lx ==2){
			return "国家赔偿";
		}
	}else if(null != ajlb && ajlb.equals(JobConstant.QITA)){
		if(lx ==1){
			return "9999";
		}else if(lx ==2){
			return "其他案件";
		}
	}
	return "";
}

/**
 * 操作类型字典
 * @return
 */
public static final Map<String, String> operationType(){
	Map<String,String> map=new HashMap<String, String>();
	map.put(JobConstant.XJAJ, "新建案卷");
	map.put(JobConstant.SMCJ, "扫描采集");
	map.put(JobConstant.AJYL, "案卷阅览");
	map.put(JobConstant.ZZTM, "制作条码");
	map.put(JobConstant.AJGD, "案卷归档");
	map.put(JobConstant.AJKL, "案卷刻录");
	map.put(JobConstant.YSSH, "移送审核");
	map.put(JobConstant.YJAJUAN, "移交案卷");
	map.put(JobConstant.YJAJIAN, "移交案件");
	map.put(JobConstant.GHAJ, "归还案卷");
	map.put(JobConstant.JSAJ, "接收案卷");
	map.put(JobConstant.JSAJYJ, "接收案卷(移送审核)");
	map.put(JobConstant.JSAJGH, "接收案卷（归还）");
	map.put("3030", "接收案卷（移交案件）");
	map.put(JobConstant.TQDB, "提请逮捕");
	map.put(JobConstant.YSQS, "移送起诉");
	map.put(JobConstant.BCZC, "补充侦查");
	map.put(JobConstant.KG, "开柜");
	map.put(JobConstant.AJRG, "案卷入柜");
	map.put(JobConstant.SCAJY, "删除案卷页");
	map.put(JobConstant.AJZF_9999, "案卷作废");
	map.put(JobConstant.ZFHF_9998, "作废恢复");
	map.put(JobConstant.BIANGENGCUNFANGWEIZHI, "变更存放位置");
	map.put(JobConstant.AJCQ, "案卷存取");
	return map;
}
//public static List<GraphicSpace> getGraphicSpace(List<JobCabSpace> jobCabSpace){
//	List<GraphicSpace> graphicSpaceList=new ArrayList<GraphicSpace>();
//	for (int i = 0; i < jobCabSpace.size(); i++) {
//		GraphicSpace graphicSpace=new GraphicSpace();
//		graphicSpace.setSpaceId(jobCabSpace.get(i).getId());
//		graphicSpace.setSpace(jobCabSpace.get(i).getName());
//		if(jobCabSpace.get(i).getUsedCap() == null){
//			graphicSpace.setQuantity(0);
//		}else{
//			graphicSpace.setQuantity(jobCabSpace.get(i).getUsedCap());
//		}
//		graphicSpace.setCapacity(jobCabSpace.get(i).getCapacity());
//		graphicSpace.setIcon("");
//		graphicSpaceList.add(graphicSpace);
//	}
//	return graphicSpaceList;
//}
//public static SysPara sysParaisNull(SysPara sysPara){
//    if(sysPara == null){
//        return sysPara;
//    }
//    if(sysPara.getParaCode() == null){
//        sysPara.setParaCode("");
//    }
//    if(sysPara.getParaName() == null){
//        sysPara.setParaName("");
//    }
//    if(sysPara.getParaValue() == null){
//        sysPara.setParaValue("");
//    }
//    if(sysPara.getParaDesc() == null){
//        sysPara.setParaDesc("");
//    }
//    if(sysPara.getVisiable() == null){
//        sysPara.setVisiable("");
//    }
//    if(sysPara.getReserve1() == null){
//        sysPara.setReserve1("");
//    }
//    if(sysPara.getReserve2() == null){
//        sysPara.setReserve2("");
//    }
//    if(sysPara.getReserve3() == null){
//        sysPara.setReserve3("");
//    }
//    if(sysPara.getReserve4() == null){
//        sysPara.setReserve4("");
//    }
//    if(sysPara.getReserve5() == null){
//        sysPara.setReserve5("");
//    }
//    if(sysPara.getAddUserId() == null){
//        sysPara.setAddUserId("");
//    }
//    if(sysPara.getAddUserName() == null){
//        sysPara.setAddUserName("");
//    }
//    if(sysPara.getAddTime() == null){
//        sysPara.setAddTime(JobUtil.getDate());
//    }
//    if(sysPara.getModifyUserId() == null){
//        sysPara.setModifyUserId("");
//    }
//    if(sysPara.getModifyUserName() == null){
//        sysPara.setModifyUserName("");
//    }
//    if(sysPara.getModifyTime() == null){
//        sysPara.setModifyTime(JobUtil.getDate());
//    }
//    return sysPara;
//}
//    public static List<FileInfoParam> isNotNullJobFileInfoChange(List<FileInfoParam> list){
//        for (int i = 0; i < list.size(); i++) {
//            notNull(list.get(i));
//        }
//        return list;
//    }
//public static final Map<String, Object> getMapByStatisticalDataList(List<StatisticalData> list){
//	Map<String, Object> map=new HashMap<String, Object>();
//	for (int i = 0; i < list.size(); i++) {
//		if(list.get(i).getDwbh() == null){
//			list.get(i).setDwbh("未知");
//		}
//		if(list.size()>0 && list.get(i).getZajs() != null){
//			map.put(list.get(i).getDwbh(), list.get(i).getZajs());
//		}else if(list.size()>0 && list.get(i).getYdzhajs() != null){
//			map.put(list.get(i).getDwbh(), list.get(i).getYdzhajs());
//		}else if(list.size()>0 && list.get(i).getYrgs() != null){
//			map.put(list.get(i).getDwbh(), list.get(i).getYrgs());
//		}
//	}
//	return map;
//}
//    public static List<FileInfo> changeJobFileInfo(List<FileInfoChange> list){
//        List<FileInfo> jobFileInfoList = new ArrayList<FileInfo>();
//        if(list == null || list.size() == 0){
//            return jobFileInfoList;
//        }
//        for(JobFileInfoChange jobFileInfoChange : list){
//            FileInfo jobFileInfo = new FileInfo();
//            BeanUtils.copyProperties(jobFileInfoChange, jobFileInfo);
//            jobFileInfoList.add(notNull(jobFileInfo));
//        }
//        return jobFileInfoList;
//    }
public static Integer changeInteger(Object inte){
    if(null == inte){
        return 0;
    }
    return Integer.parseInt(String.valueOf(inte));
}
    public static List<FileInfo> changeJobFileInfo(List<FileInfoParam> list){
        List<FileInfo> jobFileInfoList = new ArrayList<>();
        if(list == null || list.size() == 0){
            return jobFileInfoList;
        }
        for(FileInfoParam jobFileInfoChange : list){
            FileInfo jobFileInfo = new FileInfo();
            BeanUtils.copyProperties(jobFileInfoChange, jobFileInfo);
            jobFileInfoList.add(notNull(jobFileInfo));
        }
        return jobFileInfoList;
    }

    public static FileInfoParam notNull(FileInfoParam fileinfo){
        if(fileinfo == null){
            return new FileInfoParam();
        }
        if (null == fileinfo.getId() || false == inspectId(fileinfo.getId()) ){
            fileinfo.setId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == fileinfo.getTot_cnt()){
            fileinfo.setTot_cnt("");
        }
        if(null == fileinfo.getOperId()){
            fileinfo.setOperId("");
        }
        if(null == fileinfo.getCode()){
            fileinfo.setCode("");
        }
        if(null == fileinfo.getName()){
            fileinfo.setName("");
        }
        if (null == fileinfo.getCaseId()  || false == inspectId(fileinfo.getCaseId()) ){
            fileinfo.setCaseId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == fileinfo.getCaseName()){
            fileinfo.setCaseName("");
        }
        if(null == fileinfo.getHosterId()){
            fileinfo.setHosterId("");
        }
        if(null == fileinfo.getHosterPcode()){
            fileinfo.setHosterPcode("");
        }
        if(null == fileinfo.getHosterName()){
            fileinfo.setHosterName("");
        }
        if(null == fileinfo.getType()){
            fileinfo.setType("");
        }
        if(null == fileinfo.getSn()){
            fileinfo.setSn(0.0);
        }
        if(null == fileinfo.getPlaceId() || false == inspectId(fileinfo.getPlaceId())){
            fileinfo.setPlaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == fileinfo.getPlaceName()){
            fileinfo.setPlaceName("");
        }
        if(null == fileinfo.getAreaId() || false == inspectId(fileinfo.getAreaId())){
            fileinfo.setAreaId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == fileinfo.getAreaName()){
            fileinfo.setAreaName("");
        }
        if(null == fileinfo.getSpaceId() || false == inspectId(fileinfo.getSpaceId())){
            fileinfo.setSpaceId(UUID.fromString("00000000-0000-0000-0000-000000000000").toString());
        }
        if(null == fileinfo.getSpaceName()){
            fileinfo.setSpaceName("");
        }

        if(null == fileinfo.getDiskPath()){
            fileinfo.setDiskPath("");
        }
        if(null == fileinfo.getIsScan()){
            fileinfo.setIsScan(0);
        }
        if(null == fileinfo.getPageCount()){
            fileinfo.setPageCount(0);
        }
        if(null == fileinfo.getPrintCode()){
            fileinfo.setPrintCode("");
        }
        if(null == fileinfo.getPrintCount()){
            fileinfo.setPrintCount(0);
        }
        if(null == fileinfo.getBurnCount()){
            fileinfo.setBurnCount(0);
        }
        if(null == fileinfo.getKeywords()){
            fileinfo.setKeywords("");
        }

        if(null == fileinfo.getStatus()){
            fileinfo.setStatus("");
        }
        if(null == fileinfo.getReserve1()){
            fileinfo.setReserve1("");
        }
        if(null == fileinfo.getReserve2()){
            fileinfo.setReserve2("");
        }
        if(null == fileinfo.getReserve3()){
            fileinfo.setReserve3("");
        }
        if(null == fileinfo.getMemo()){
            fileinfo.setMemo("");
        }
        if(null == fileinfo.getRowStatus()){
            fileinfo.setRowStatus(0);
        }
        if(null == fileinfo.getCreaterId()){
            fileinfo.setCreaterId("");
        }
        if(null == fileinfo.getCreaterName()){
            fileinfo.setCreaterName("");
        }
        if(null == fileinfo.getCreateTime()){
            fileinfo.setCreateTime(JobUtil.getDate());
        }
        if(null == fileinfo.getModerId()){
            fileinfo.setModerId("");
        }
        if(null == fileinfo.getModerName()){
            fileinfo.setModerName("");
        }
        if(null == fileinfo.getModTime()){
            fileinfo.setModTime(JobUtil.getDate());
        }
        if(null == fileinfo.getOrgC()){
            fileinfo.setOrgC("");
        }
        if(null == fileinfo.getOrgS()){
            fileinfo.setOrgS("");
        }
        if(null == fileinfo.getOrgT()){
            fileinfo.setOrgT("");
        }
        if(null == fileinfo.getOrgCData()){
            fileinfo.setOrgCData("");
        }
        if(null == fileinfo.getOrgSData()){
            fileinfo.setOrgSData("");
        }
        if(null == fileinfo.getOrgTData()){
            fileinfo.setOrgTData("");
        }
        if(null == fileinfo.getCurOrg()){
            fileinfo.setCurOrg("");
        }
        if(null == fileinfo.getCurOrgData()){
            fileinfo.setCurOrgData("");
        }
        if(null == fileinfo.getNameSpell()){
            fileinfo.setNameSpell("");
        }
        if(null == fileinfo.getHosterSpell()){
            fileinfo.setHosterSpell("");
        }
        if(null == fileinfo.getSuppleinvCount()){
            fileinfo.setSuppleinvCount(0);
        }
        if(null == fileinfo.getAcceptTime()){
            fileinfo.setAcceptTime(getDate());;
        }
        return fileinfo;
    }
public static <T> Object field(Object object){
	if(object == null){
		return null;
	}
	try {
    	if("java.util.ArrayList".equals(object.getClass().getName())){
    		List<T> list=(List<T>) object;
    		for(int i=0;i<list.size();i++){
    			java.lang.reflect.Field[] field = list.get(i).getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组
    			for (int j = 0; j < field.length; j++) { // 遍历所有属性
                    String name = field[j].getName(); // 获取属性的名字
                    name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    String type = field[j].getGenericType().toString(); // 获取属性的类型
                    if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                        Method m = list.get(i).getClass().getMethod("get" + name);
                        String value = (String) m.invoke(list.get(i)); // 调用getter方法获取属性值
                        if (value == null) {
                            m = list.get(i).getClass().getMethod("set"+name,String.class);
                            m.invoke(list.get(i), "");
                        }
                    }
                    if (type.equals("class java.lang.Integer")) {
                        Method m = list.get(i).getClass().getMethod("get" + name);
                        Integer value = (Integer) m.invoke(list.get(i));
                        if (value == null) {
                            m = list.get(i).getClass().getMethod("set"+name,Integer.class);
                            m.invoke(list.get(i), 0);
                        }
                    }
                    if (type.equals("class java.lang.Double")) {
                        Method m = list.get(i).getClass().getMethod("get" + name);
                        Double value = (Double) m.invoke(list.get(i));
                        if (value == null) {
                            m = list.get(i).getClass().getMethod("set"+name,Double.class);
                            m.invoke(list.get(i), 0.0);
                        }
                    }
                    if (type.equals("class java.lang.Boolean")) {
                        Method m = list.get(i).getClass().getMethod("get" + name);
                        Boolean value = (Boolean) m.invoke(list.get(i));
                        if (value == null) {
                            m = list.get(i).getClass().getMethod("set"+name,Boolean.class);
                            m.invoke(list.get(i), false);
                        }
                    }
    /*                if (type.equals("class java.util.Date")) {
                        Method m = list.get(i).getClass().getMethod("get" + name);
                        Date value = (Date) m.invoke(list.get(i));
                        if (value == null) {
                            m = list.get(i).getClass().getMethod("set"+name,Date.class);
                            m.invoke(list.get(i), new Date());
                        }
                    }*/
                }
    		}
    		return object;
    	}else{
    		//java.lang.reflect.Field[]
        	java.lang.reflect.Field[] field = object.getClass().getDeclaredFields(); // 获取实体类的所有属性，返回Field数组

                for (int j = 0; j < field.length; j++) { // 遍历所有属性
                    String name = field[j].getName(); // 获取属性的名字
                    name = name.substring(0, 1).toUpperCase() + name.substring(1); // 将属性的首字符大写，方便构造get，set方法
                    String aaaa = field[j].getType().toString(); // 获取属性的类型
                    String type = field[j].getGenericType().toString(); // 获取属性的类型
                    if (type.equals("class java.lang.String")) { // 如果type是类类型，则前面包含"class "，后面跟类名
                        Method m = object.getClass().getMethod("get" + name);
                        String value = (String) m.invoke(object); // 调用getter方法获取属性值
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,String.class);
                            m.invoke(object, "");
                        }
                    }
                    if (type.equals("class java.lang.Integer")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Integer value = (Integer) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Integer.class);
                            m.invoke(object, 0);
                        }
                    }
                    if (type.equals("class java.lang.Double")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Double value = (Double) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Double.class);
                            m.invoke(object, 0.0);
                        }
                    }
                    if (type.equals("class java.lang.Boolean")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Boolean value = (Boolean) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Boolean.class);
                            m.invoke(object, false);
                        }
                    }
    /*                if (type.equals("class java.util.Date")) {
                        Method m = object.getClass().getMethod("get" + name);
                        Date value = (Date) m.invoke(object);
                        if (value == null) {
                            m = object.getClass().getMethod("set"+name,Date.class);
                            m.invoke(object, new Date());
                        }
                    }*/
                }
                return object;
    	}

    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    } catch (SecurityException e) {
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        e.printStackTrace();
    }
    return object;
}
}
