package com.pkusoft.xcba.cf.service.impl;

import com.pkusoft.jjpt.po.SpJjxx;
import com.pkusoft.xcba.cf.service.XcbaService;
import com.pkusoft.zfsp.mapper.RsSypGlxxMapper;
import com.pkusoft.zfsp.model.RsSypGlxx;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import pkubatis.common.utils.WebServiceUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
@Transactional
public class XcbaServiceImpl implements XcbaService {

    @Override
    public String getJcjxxXml(SpJjxx spJjxx) {
        Document doc = DocumentHelper.createDocument();
        Element rBSPMessageEle = doc.addElement("RBSPMessage");

        //请求头部
        Element requesterIDEle = rBSPMessageEle.addElement("RequesterID");
        requesterIDEle.setText("C150400-AGZXJJXX-0001");
        //版本号
        Element methodEle = requesterIDEle.addElement("Method");
        Element nameEle = methodEle.addElement("Name");
        nameEle.setText("Report");
        Element securityEle = methodEle.addElement("Security");
        Element signatureEle = securityEle.addElement("Signature");
        Element encryptEle = securityEle.addElement("Encrypt");
        encryptEle.addAttribute("Algorithm", "");

        Element itemsEles = methodEle.addElement("Items");
        Element itemsEle = itemsEles.addElement("Item");
        Element itemsNameEle = itemsEle.addElement("Name");
        itemsNameEle.setText("SysAlias");
        Element itemsValueEle = itemsEle.addElement("Value ");
        itemsValueEle.addAttribute("Type", "string");
        Element itemsDataEle = itemsValueEle.addElement("Data");
        itemsDataEle.setText("DSjwzhxt");
        System.out.println(doc.asXML());
        return doc.asXML();
    }

    public static void main(String[] args) {
        Document doc = DocumentHelper.createDocument();
        doc.setXMLEncoding("GB2312");
        Element rBSPMessageEle = doc.addElement("RBSPMessage");

        //请求头部
        Element requesterIDEle = rBSPMessageEle.addElement("RequesterID");
        requesterIDEle.setText("C150400-AGZXJJXX-0001");
        //版本号
        Element methodEle = rBSPMessageEle.addElement("Method");
        Element nameEle = methodEle.addElement("Name");
        nameEle.setText("Report");
        Element securityEle = methodEle.addElement("Security");
        Element signatureEle = securityEle.addElement("Signature");
        Element encryptEle = securityEle.addElement("Encrypt");
        encryptEle.addAttribute("Algorithm", "");
        //Items
        Element itemsEles = methodEle.addElement("Items");
        //Item
        Element itemsEle = itemsEles.addElement("Item");
        Element itemsNameEle = itemsEle.addElement("Name");
        itemsNameEle.setText("SysAlias");
        Element itemsValueEle = itemsEle.addElement("Value ");
        itemsValueEle.addAttribute("Type", "string");
        Element itemsDataEle = itemsValueEle.addElement("Data");
        itemsDataEle.setText("DSjwzhxt");

        //Item
        Element recordersItemsEle = itemsEles.addElement("Item");
        Element recordersNameItemsEle = recordersItemsEle.addElement("Name");
        recordersNameItemsEle.setText("Recorders");
        Element recordersItemsValueEle = recordersItemsEle.addElement("Value");
        recordersItemsValueEle.addAttribute("Type","arrayOfArrayOf_string");

        //接处警信息
        Element recordersRowEle = recordersItemsValueEle.addElement("Row");
        recordersRowEle.addAttribute("tablename","AGZX_TB_JCJXX");
        recordersRowEle.addAttribute("state","i");
        Element recordersDataEle = recordersRowEle.addElement("Data");
        recordersDataEle.addAttribute("JCJBH","S1504255100002022010000000000001");
        recordersDataEle.addAttribute("BJXS","14");
        recordersDataEle.addAttribute("GXD","150425510000");
        recordersDataEle.addAttribute("SFCFBJ","0");
        recordersDataEle.addAttribute("CJSJ","20211231163100");
        recordersDataEle.addAttribute("JJDW","150425510000");
        recordersDataEle.addAttribute("JJR","1504003435");
        recordersDataEle.addAttribute("JJSJ","20211231163000");
        recordersDataEle.addAttribute("BJNR","2021年12月31日16时许,江福龙来所报警称王艳茹在克旗经棚镇把他所驾驶的尼桑逍客汽车砸坏。");
        recordersDataEle.addAttribute("CJBS","2");
        recordersDataEle.addAttribute("CJLB","020000");
        recordersDataEle.addAttribute("DDXCSJ","20211231163600");
        recordersDataEle.addAttribute("XZQH","150425");
        recordersDataEle.addAttribute("XZ","经棚镇");
        recordersDataEle.addAttribute("CDJLS","2");
        recordersDataEle.addAttribute("CJXQ","2021年12月31日16时许，在克旗经棚镇江福龙与王艳茹在江福龙所驾驶的汽车上因经济纠纷发生口角后，王艳茹把江福龙所驾驶的尼桑逍客汽车玻璃砸碎。");
        recordersDataEle.addAttribute("CZHDW","150425510000");
        recordersDataEle.addAttribute("CZHR","1504003435,1504004406");
        recordersDataEle.addAttribute("CZTXSJ","20220101005759");
        recordersDataEle.addAttribute("CJJG","00");
        recordersDataEle.addAttribute("LDPSYJ","受理行政案件");
        recordersDataEle.addAttribute("ZBLD","1504002344");
        recordersDataEle.addAttribute("LDPSRQ","20220101010741");
        recordersDataEle.addAttribute("CZDW","150425510000");
        recordersDataEle.addAttribute("CZR","1504002344");
        recordersDataEle.addAttribute("CZSJ","20220101011901184");
        recordersDataEle.addAttribute("CZBS","2");
        recordersDataEle.addAttribute("CCSPSJ","20220101010741");
        recordersDataEle.addAttribute("WB_ZCBS","0");
        recordersDataEle.addAttribute("DJDW","150425510000");
        recordersDataEle.addAttribute("DJR","1504003435");
        recordersDataEle.addAttribute("DJRQ","20220101004925");


        //接报案信息
        Element recordersRowJbaxxEle = recordersItemsValueEle.addElement("Row");
        recordersRowJbaxxEle.addAttribute("tablename","AGZX_TB_JBAXX");
        recordersRowJbaxxEle.addAttribute("state","i");
        Element recordersJbaxxDataEle = recordersRowJbaxxEle.addElement("Data");
        recordersJbaxxDataEle.addAttribute("JBABH","J1504255100002022052201");
        recordersJbaxxDataEle.addAttribute("JCJBH","S1504255100002022052201000000001");
        recordersJbaxxDataEle.addAttribute("BAFS","01");
        recordersJbaxxDataEle.addAttribute("BASJ","20220522013000");
        recordersJbaxxDataEle.addAttribute("BARXM","张来");
        recordersJbaxxDataEle.addAttribute("BANR","2022年05月22日01时许,张来来所报警称王艳在克旗经棚镇把他所驾驶的尼桑逍客汽车砸坏。(测试数据)");
        recordersJbaxxDataEle.addAttribute("JBDW","150425510000");
        recordersJbaxxDataEle.addAttribute("JBMJ","1504003435");
        recordersJbaxxDataEle.addAttribute("JBSJ","20220522033000");
        recordersJbaxxDataEle.addAttribute("LYBS","2");
        recordersJbaxxDataEle.addAttribute("CZDW","150425510000");
        recordersJbaxxDataEle.addAttribute("CZR","1504002344");
        recordersJbaxxDataEle.addAttribute("CZSJ","20220522013000891");
        recordersJbaxxDataEle.addAttribute("CZBS","2");
        recordersJbaxxDataEle.addAttribute("RYDWBS","1");
        recordersJbaxxDataEle.addAttribute("CLBS","0");

        String data = doc.asXML();
        String url = "http://26.13.100.132:9086/tcwebservice/services/ServiceImpl?wsdl";
        String nameSpaceUri = "http://server.tcwebservice.tc.com";
        String methodName = "reportservice";
        String returnStr = WebServiceUtils.sendReturnStr(url, nameSpaceUri, methodName, data);
        System.out.println(returnStr);
    }
}
