package com.jlkg.jzg.jzg_android.contract.beans;

import java.util.List;

/**
 * Created by zcs on 2018/4/18.
 *
 * @describe:
 */

public class OrderDetailBean {

    /**
     * content : [{"id":85852,"workerName":"呵","mobile":"18720295614","idNumber":"445222199103280013","bankName":"平安银行","cardNumber":"6212264100011335373","salary":20,"teamId":null,"contractOrder":{"id":85850,"applyAmount":30,"contract":{"id":84847,"title":"@施工合同","status":{"id":"CONTRACT_STATUS_WAIT_PAY","text":"待付款","category":"CONTRACT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"projectApply":{"id":84846,"contractNumber":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"projectHire":{"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"},"status":{"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"applyDate":"2018-03-30 18:01:23","confirmDate":"2018-03-30 18:02:23","signDate":"2018-03-30 18:02:23","endDate":null,"projectId":null,"machineAskId":null},"createDate":"2018-03-30 18:02:23","reviewDate":null,"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"contractNo":"S2018033006022303384091","projectTitle":"@","projectAddress":null,"projectRange":"的","projectTeamRequire":"旅游","projectStandard":"合格","totalDays":3,"pay1":"哦哦","pay2":"咯","pay3":"恩","startDate":"2018-03-30","endDate":"2018-03-30","priceCny":"叁元整","price":3,"progressRating":null,"safeRating":null,"qualityRating":null,"creditRating":null,"review":null},"status":{"id":"ORDER_STATUS_SUBMITED","text":"已提交","category":"ORDER_STATUS","groupTitle":null,"system":true,"orderIndex":null},"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"applyDate":"2018-04-18 16:02:33","paidDate":null,"platformPaidDate":null,"teamComfirmDate":null,"auditNo":"S2018033006022303384091","remarks":null},"member":{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}},{"id":85851,"workerName":"刘某某","mobile":"18720295614","idNumber":"445222199103280011","bankName":"工商银行","cardNumber":"6212264100011335373","salary":10,"teamId":null,"contractOrder":{"id":85850,"applyAmount":30,"contract":{"id":84847,"title":"@施工合同","status":{"id":"CONTRACT_STATUS_WAIT_PAY","text":"待付款","category":"CONTRACT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"projectApply":{"id":84846,"contractNumber":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"projectHire":{"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"},"status":{"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"applyDate":"2018-03-30 18:01:23","confirmDate":"2018-03-30 18:02:23","signDate":"2018-03-30 18:02:23","endDate":null,"projectId":null,"machineAskId":null},"createDate":"2018-03-30 18:02:23","reviewDate":null,"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"contractNo":"S2018033006022303384091","projectTitle":"@","projectAddress":null,"projectRange":"的","projectTeamRequire":"旅游","projectStandard":"合格","totalDays":3,"pay1":"哦哦","pay2":"咯","pay3":"恩","startDate":"2018-03-30","endDate":"2018-03-30","priceCny":"叁元整","price":3,"progressRating":null,"safeRating":null,"qualityRating":null,"creditRating":null,"review":null},"status":{"id":"ORDER_STATUS_SUBMITED","text":"已提交","category":"ORDER_STATUS","groupTitle":null,"system":true,"orderIndex":null},"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"applyDate":"2018-04-18 16:02:33","paidDate":null,"platformPaidDate":null,"teamComfirmDate":null,"auditNo":"S2018033006022303384091","remarks":null},"member":{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}}]
     * last : true
     * totalPages : 1
     * totalElements : 2
     * first : true
     * sort : [{"direction":"DESC","property":"id","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 2
     * size : 10
     * number : 0
     */

    private boolean last;
    private int totalPages;
    private int totalElements;
    private boolean first;
    private int numberOfElements;
    private int size;
    private int number;
    private List<ContentBean> content;
    private List<SortBean> sort;

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(int totalElements) {
        this.totalElements = totalElements;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public void setNumberOfElements(int numberOfElements) {
        this.numberOfElements = numberOfElements;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<ContentBean> getContent() {
        return content;
    }

    public void setContent(List<ContentBean> content) {
        this.content = content;
    }

    public List<SortBean> getSort() {
        return sort;
    }

    public void setSort(List<SortBean> sort) {
        this.sort = sort;
    }

    public static class ContentBean {
        /**
         * id : 85852
         * workerName : 呵
         * mobile : 18720295614
         * idNumber : 445222199103280013
         * bankName : 平安银行
         * cardNumber : 6212264100011335373
         * salary : 20
         * teamId : null
         * contractOrder : {"id":85850,"applyAmount":30,"contract":{"id":84847,"title":"@施工合同","status":{"id":"CONTRACT_STATUS_WAIT_PAY","text":"待付款","category":"CONTRACT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"projectApply":{"id":84846,"contractNumber":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"projectHire":{"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"},"status":{"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"applyDate":"2018-03-30 18:01:23","confirmDate":"2018-03-30 18:02:23","signDate":"2018-03-30 18:02:23","endDate":null,"projectId":null,"machineAskId":null},"createDate":"2018-03-30 18:02:23","reviewDate":null,"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"contractNo":"S2018033006022303384091","projectTitle":"@","projectAddress":null,"projectRange":"的","projectTeamRequire":"旅游","projectStandard":"合格","totalDays":3,"pay1":"哦哦","pay2":"咯","pay3":"恩","startDate":"2018-03-30","endDate":"2018-03-30","priceCny":"叁元整","price":3,"progressRating":null,"safeRating":null,"qualityRating":null,"creditRating":null,"review":null},"status":{"id":"ORDER_STATUS_SUBMITED","text":"已提交","category":"ORDER_STATUS","groupTitle":null,"system":true,"orderIndex":null},"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"applyDate":"2018-04-18 16:02:33","paidDate":null,"platformPaidDate":null,"teamComfirmDate":null,"auditNo":"S2018033006022303384091","remarks":null}
         * member : {"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}
         */

        private int id;
        private String workerName;
        private String mobile;
        private String idNumber;
        private String bankName;
        private String cardNumber;
        private int salary;
        private Object teamId;
        private ContractOrderBean contractOrder;
        private MemberBean member;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getWorkerName() {
            return workerName;
        }

        public void setWorkerName(String workerName) {
            this.workerName = workerName;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIdNumber() {
            return idNumber;
        }

        public void setIdNumber(String idNumber) {
            this.idNumber = idNumber;
        }

        public String getBankName() {
            return bankName;
        }

        public void setBankName(String bankName) {
            this.bankName = bankName;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public int getSalary() {
            return salary;
        }

        public void setSalary(int salary) {
            this.salary = salary;
        }

        public Object getTeamId() {
            return teamId;
        }

        public void setTeamId(Object teamId) {
            this.teamId = teamId;
        }

        public ContractOrderBean getContractOrder() {
            return contractOrder;
        }

        public void setContractOrder(ContractOrderBean contractOrder) {
            this.contractOrder = contractOrder;
        }

        public MemberBean getMember() {
            return member;
        }

        public void setMember(MemberBean member) {
            this.member = member;
        }

        public static class ContractOrderBean {
            /**
             * id : 85850
             * applyAmount : 30
             * contract : {"id":84847,"title":"@施工合同","status":{"id":"CONTRACT_STATUS_WAIT_PAY","text":"待付款","category":"CONTRACT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"projectApply":{"id":84846,"contractNumber":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"projectHire":{"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"},"status":{"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"applyDate":"2018-03-30 18:01:23","confirmDate":"2018-03-30 18:02:23","signDate":"2018-03-30 18:02:23","endDate":null,"projectId":null,"machineAskId":null},"createDate":"2018-03-30 18:02:23","reviewDate":null,"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"contractNo":"S2018033006022303384091","projectTitle":"@","projectAddress":null,"projectRange":"的","projectTeamRequire":"旅游","projectStandard":"合格","totalDays":3,"pay1":"哦哦","pay2":"咯","pay3":"恩","startDate":"2018-03-30","endDate":"2018-03-30","priceCny":"叁元整","price":3,"progressRating":null,"safeRating":null,"qualityRating":null,"creditRating":null,"review":null}
             * status : {"id":"ORDER_STATUS_SUBMITED","text":"已提交","category":"ORDER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
             * team : {"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null}
             * applyDate : 2018-04-18 16:02:33
             * paidDate : null
             * platformPaidDate : null
             * teamComfirmDate : null
             * auditNo : S2018033006022303384091
             * remarks : null
             */

            private int id;
            private int applyAmount;
            private ContractBean contract;
            private StatusBeanXXXXXXXXXXXXXX status;
            private TeamBeanXX team;
            private String applyDate;
            private Object paidDate;
            private Object platformPaidDate;
            private Object teamComfirmDate;
            private String auditNo;
            private Object remarks;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getApplyAmount() {
                return applyAmount;
            }

            public void setApplyAmount(int applyAmount) {
                this.applyAmount = applyAmount;
            }

            public ContractBean getContract() {
                return contract;
            }

            public void setContract(ContractBean contract) {
                this.contract = contract;
            }

            public StatusBeanXXXXXXXXXXXXXX getStatus() {
                return status;
            }

            public void setStatus(StatusBeanXXXXXXXXXXXXXX status) {
                this.status = status;
            }

            public TeamBeanXX getTeam() {
                return team;
            }

            public void setTeam(TeamBeanXX team) {
                this.team = team;
            }

            public String getApplyDate() {
                return applyDate;
            }

            public void setApplyDate(String applyDate) {
                this.applyDate = applyDate;
            }

            public Object getPaidDate() {
                return paidDate;
            }

            public void setPaidDate(Object paidDate) {
                this.paidDate = paidDate;
            }

            public Object getPlatformPaidDate() {
                return platformPaidDate;
            }

            public void setPlatformPaidDate(Object platformPaidDate) {
                this.platformPaidDate = platformPaidDate;
            }

            public Object getTeamComfirmDate() {
                return teamComfirmDate;
            }

            public void setTeamComfirmDate(Object teamComfirmDate) {
                this.teamComfirmDate = teamComfirmDate;
            }

            public String getAuditNo() {
                return auditNo;
            }

            public void setAuditNo(String auditNo) {
                this.auditNo = auditNo;
            }

            public Object getRemarks() {
                return remarks;
            }

            public void setRemarks(Object remarks) {
                this.remarks = remarks;
            }

            public static class ContractBean {
                /**
                 * id : 84847
                 * title : @施工合同
                 * status : {"id":"CONTRACT_STATUS_WAIT_PAY","text":"待付款","category":"CONTRACT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                 * projectApply : {"id":84846,"contractNumber":null,"team":{"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"applyCompany":null,"projectHire":{"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"},"status":{"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"applyDate":"2018-03-30 18:01:23","confirmDate":"2018-03-30 18:02:23","signDate":"2018-03-30 18:02:23","endDate":null,"projectId":null,"machineAskId":null}
                 * createDate : 2018-03-30 18:02:23
                 * reviewDate : null
                 * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
                 * applyCompany : null
                 * team : {"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null}
                 * project : {"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"}
                 * contractNo : S2018033006022303384091
                 * projectTitle : @
                 * projectAddress : null
                 * projectRange : 的
                 * projectTeamRequire : 旅游
                 * projectStandard : 合格
                 * totalDays : 3
                 * pay1 : 哦哦
                 * pay2 : 咯
                 * pay3 : 恩
                 * startDate : 2018-03-30
                 * endDate : 2018-03-30
                 * priceCny : 叁元整
                 * price : 3
                 * progressRating : null
                 * safeRating : null
                 * qualityRating : null
                 * creditRating : null
                 * review : null
                 */

                private int id;
                private String title;
                private StatusBean status;
                private ProjectApplyBean projectApply;
                private String createDate;
                private Object reviewDate;
                private CompanyBeanXXX company;
                private Object applyCompany;
                private TeamBeanX team;
                private ProjectBeanX project;
                private String contractNo;
                private String projectTitle;
                private Object projectAddress;
                private String projectRange;
                private String projectTeamRequire;
                private String projectStandard;
                private int totalDays;
                private String pay1;
                private String pay2;
                private String pay3;
                private String startDate;
                private String endDate;
                private String priceCny;
                private int price;
                private Object progressRating;
                private Object safeRating;
                private Object qualityRating;
                private Object creditRating;
                private Object review;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public StatusBean getStatus() {
                    return status;
                }

                public void setStatus(StatusBean status) {
                    this.status = status;
                }

                public ProjectApplyBean getProjectApply() {
                    return projectApply;
                }

                public void setProjectApply(ProjectApplyBean projectApply) {
                    this.projectApply = projectApply;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public Object getReviewDate() {
                    return reviewDate;
                }

                public void setReviewDate(Object reviewDate) {
                    this.reviewDate = reviewDate;
                }

                public CompanyBeanXXX getCompany() {
                    return company;
                }

                public void setCompany(CompanyBeanXXX company) {
                    this.company = company;
                }

                public Object getApplyCompany() {
                    return applyCompany;
                }

                public void setApplyCompany(Object applyCompany) {
                    this.applyCompany = applyCompany;
                }

                public TeamBeanX getTeam() {
                    return team;
                }

                public void setTeam(TeamBeanX team) {
                    this.team = team;
                }

                public ProjectBeanX getProject() {
                    return project;
                }

                public void setProject(ProjectBeanX project) {
                    this.project = project;
                }

                public String getContractNo() {
                    return contractNo;
                }

                public void setContractNo(String contractNo) {
                    this.contractNo = contractNo;
                }

                public String getProjectTitle() {
                    return projectTitle;
                }

                public void setProjectTitle(String projectTitle) {
                    this.projectTitle = projectTitle;
                }

                public Object getProjectAddress() {
                    return projectAddress;
                }

                public void setProjectAddress(Object projectAddress) {
                    this.projectAddress = projectAddress;
                }

                public String getProjectRange() {
                    return projectRange;
                }

                public void setProjectRange(String projectRange) {
                    this.projectRange = projectRange;
                }

                public String getProjectTeamRequire() {
                    return projectTeamRequire;
                }

                public void setProjectTeamRequire(String projectTeamRequire) {
                    this.projectTeamRequire = projectTeamRequire;
                }

                public String getProjectStandard() {
                    return projectStandard;
                }

                public void setProjectStandard(String projectStandard) {
                    this.projectStandard = projectStandard;
                }

                public int getTotalDays() {
                    return totalDays;
                }

                public void setTotalDays(int totalDays) {
                    this.totalDays = totalDays;
                }

                public String getPay1() {
                    return pay1;
                }

                public void setPay1(String pay1) {
                    this.pay1 = pay1;
                }

                public String getPay2() {
                    return pay2;
                }

                public void setPay2(String pay2) {
                    this.pay2 = pay2;
                }

                public String getPay3() {
                    return pay3;
                }

                public void setPay3(String pay3) {
                    this.pay3 = pay3;
                }

                public String getStartDate() {
                    return startDate;
                }

                public void setStartDate(String startDate) {
                    this.startDate = startDate;
                }

                public String getEndDate() {
                    return endDate;
                }

                public void setEndDate(String endDate) {
                    this.endDate = endDate;
                }

                public String getPriceCny() {
                    return priceCny;
                }

                public void setPriceCny(String priceCny) {
                    this.priceCny = priceCny;
                }

                public int getPrice() {
                    return price;
                }

                public void setPrice(int price) {
                    this.price = price;
                }

                public Object getProgressRating() {
                    return progressRating;
                }

                public void setProgressRating(Object progressRating) {
                    this.progressRating = progressRating;
                }

                public Object getSafeRating() {
                    return safeRating;
                }

                public void setSafeRating(Object safeRating) {
                    this.safeRating = safeRating;
                }

                public Object getQualityRating() {
                    return qualityRating;
                }

                public void setQualityRating(Object qualityRating) {
                    this.qualityRating = qualityRating;
                }

                public Object getCreditRating() {
                    return creditRating;
                }

                public void setCreditRating(Object creditRating) {
                    this.creditRating = creditRating;
                }

                public Object getReview() {
                    return review;
                }

                public void setReview(Object review) {
                    this.review = review;
                }

                public static class StatusBean {
                    /**
                     * id : CONTRACT_STATUS_WAIT_PAY
                     * text : 待付款
                     * category : CONTRACT_STATUS
                     * groupTitle : null
                     * system : true
                     * orderIndex : null
                     */

                    private String id;
                    private String text;
                    private String category;
                    private Object groupTitle;
                    private boolean system;
                    private Object orderIndex;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public Object getGroupTitle() {
                        return groupTitle;
                    }

                    public void setGroupTitle(Object groupTitle) {
                        this.groupTitle = groupTitle;
                    }

                    public boolean isSystem() {
                        return system;
                    }

                    public void setSystem(boolean system) {
                        this.system = system;
                    }

                    public Object getOrderIndex() {
                        return orderIndex;
                    }

                    public void setOrderIndex(Object orderIndex) {
                        this.orderIndex = orderIndex;
                    }
                }

                public static class ProjectApplyBean {
                    /**
                     * id : 84846
                     * contractNumber : null
                     * team : {"id":84091,"teamType":{"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"userName":"13071010127","photo":{"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"},"title":"熊大 ","idNumber":"412825198905112011","idFront":{"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"},"skill":null,"phone":"13071010127","address":"深圳福田","bankInfo":null,"bankCardNo":null,"notes":"asdasd","nativePlace":null,"nation":null,"sinceTime":null,"gender":"男","skillCertificate":null,"education":null,"birthday":null,"position":null,"certificate":null,"safe":false,"companyName":null,"capital":null,"legalPerson":null,"companyAddress":null,"xinyongCode":null,"cardFront":{"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"},"startTime":null,"emergencyContacts":null,"emergencyPhone":null,"members":[{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}],"projects":[],"starsLevel":null,"status":{"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null},"district":null,"streetAddress":"sadasd","createTime":"2018-03-20 15:06:31","bankAccount":null,"accountType":"TEAM","displayAddress":"","membersCount":3,"viewPoint":null,"suid":null}
                     * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
                     * applyCompany : null
                     * projectHire : {"id":84844,"publishedTime":"2018-03-30 17:58:56","title":null,"closeTime":null,"teamRequire":null,"memo":"测试","price":"10000","hireEnded":true,"project":{"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"},"type":{"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null},"salary":null,"userDeleted":true,"phone":"13426599742","status":{"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null},"company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"source":"注册公司","hireId":null,"smsNum":0,"teamNeeds":[{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}],"contacts":"测试","provinceId":1,"cityId":1001,"districtId":1199,"teamNeedStr":"G20265Z"}
                     * status : {"id":"CONFIRMED","text":"已确认","category":"PROJECT_APPLY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     * applyDate : 2018-03-30 18:01:23
                     * confirmDate : 2018-03-30 18:02:23
                     * signDate : 2018-03-30 18:02:23
                     * endDate : null
                     * projectId : null
                     * machineAskId : null
                     */

                    private int id;
                    private Object contractNumber;
                    private TeamBean team;
                    private CompanyBean company;
                    private Object applyCompany;
                    private ProjectHireBean projectHire;
                    private StatusBeanXXXXXXXX status;
                    private String applyDate;
                    private String confirmDate;
                    private String signDate;
                    private Object endDate;
                    private Object projectId;
                    private Object machineAskId;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public Object getContractNumber() {
                        return contractNumber;
                    }

                    public void setContractNumber(Object contractNumber) {
                        this.contractNumber = contractNumber;
                    }

                    public TeamBean getTeam() {
                        return team;
                    }

                    public void setTeam(TeamBean team) {
                        this.team = team;
                    }

                    public CompanyBean getCompany() {
                        return company;
                    }

                    public void setCompany(CompanyBean company) {
                        this.company = company;
                    }

                    public Object getApplyCompany() {
                        return applyCompany;
                    }

                    public void setApplyCompany(Object applyCompany) {
                        this.applyCompany = applyCompany;
                    }

                    public ProjectHireBean getProjectHire() {
                        return projectHire;
                    }

                    public void setProjectHire(ProjectHireBean projectHire) {
                        this.projectHire = projectHire;
                    }

                    public StatusBeanXXXXXXXX getStatus() {
                        return status;
                    }

                    public void setStatus(StatusBeanXXXXXXXX status) {
                        this.status = status;
                    }

                    public String getApplyDate() {
                        return applyDate;
                    }

                    public void setApplyDate(String applyDate) {
                        this.applyDate = applyDate;
                    }

                    public String getConfirmDate() {
                        return confirmDate;
                    }

                    public void setConfirmDate(String confirmDate) {
                        this.confirmDate = confirmDate;
                    }

                    public String getSignDate() {
                        return signDate;
                    }

                    public void setSignDate(String signDate) {
                        this.signDate = signDate;
                    }

                    public Object getEndDate() {
                        return endDate;
                    }

                    public void setEndDate(Object endDate) {
                        this.endDate = endDate;
                    }

                    public Object getProjectId() {
                        return projectId;
                    }

                    public void setProjectId(Object projectId) {
                        this.projectId = projectId;
                    }

                    public Object getMachineAskId() {
                        return machineAskId;
                    }

                    public void setMachineAskId(Object machineAskId) {
                        this.machineAskId = machineAskId;
                    }

                    public static class TeamBean {
                        /**
                         * id : 84091
                         * teamType : {"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
                         * userName : 13071010127
                         * photo : {"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"}
                         * title : 熊大
                         * idNumber : 412825198905112011
                         * idFront : {"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"}
                         * skill : null
                         * phone : 13071010127
                         * address : 深圳福田
                         * bankInfo : null
                         * bankCardNo : null
                         * notes : asdasd
                         * nativePlace : null
                         * nation : null
                         * sinceTime : null
                         * gender : 男
                         * skillCertificate : null
                         * education : null
                         * birthday : null
                         * position : null
                         * certificate : null
                         * safe : false
                         * companyName : null
                         * capital : null
                         * legalPerson : null
                         * companyAddress : null
                         * xinyongCode : null
                         * cardFront : {"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"}
                         * startTime : null
                         * emergencyContacts : null
                         * emergencyPhone : null
                         * members : [{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}]
                         * projects : []
                         * starsLevel : null
                         * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                         * district : null
                         * streetAddress : sadasd
                         * createTime : 2018-03-20 15:06:31
                         * bankAccount : null
                         * accountType : TEAM
                         * displayAddress :
                         * membersCount : 3
                         * viewPoint : null
                         * suid : null
                         */

                        private int id;
                        private TeamTypeBean teamType;
                        private String userName;
                        private PhotoBean photo;
                        private String title;
                        private String idNumber;
                        private IdFrontBean idFront;
                        private Object skill;
                        private String phone;
                        private String address;
                        private Object bankInfo;
                        private Object bankCardNo;
                        private String notes;
                        private Object nativePlace;
                        private Object nation;
                        private Object sinceTime;
                        private String gender;
                        private Object skillCertificate;
                        private Object education;
                        private Object birthday;
                        private Object position;
                        private Object certificate;
                        private boolean safe;
                        private Object companyName;
                        private Object capital;
                        private Object legalPerson;
                        private Object companyAddress;
                        private Object xinyongCode;
                        private CardFrontBean cardFront;
                        private Object startTime;
                        private Object emergencyContacts;
                        private Object emergencyPhone;
                        private Object starsLevel;
                        private StatusBeanX status;
                        private Object district;
                        private String streetAddress;
                        private String createTime;
                        private Object bankAccount;
                        private String accountType;
                        private String displayAddress;
                        private int membersCount;
                        private Object viewPoint;
                        private Object suid;
                        private List<MembersBean> members;
                        private List<?> projects;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public TeamTypeBean getTeamType() {
                            return teamType;
                        }

                        public void setTeamType(TeamTypeBean teamType) {
                            this.teamType = teamType;
                        }

                        public String getUserName() {
                            return userName;
                        }

                        public void setUserName(String userName) {
                            this.userName = userName;
                        }

                        public PhotoBean getPhoto() {
                            return photo;
                        }

                        public void setPhoto(PhotoBean photo) {
                            this.photo = photo;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getIdNumber() {
                            return idNumber;
                        }

                        public void setIdNumber(String idNumber) {
                            this.idNumber = idNumber;
                        }

                        public IdFrontBean getIdFront() {
                            return idFront;
                        }

                        public void setIdFront(IdFrontBean idFront) {
                            this.idFront = idFront;
                        }

                        public Object getSkill() {
                            return skill;
                        }

                        public void setSkill(Object skill) {
                            this.skill = skill;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public String getAddress() {
                            return address;
                        }

                        public void setAddress(String address) {
                            this.address = address;
                        }

                        public Object getBankInfo() {
                            return bankInfo;
                        }

                        public void setBankInfo(Object bankInfo) {
                            this.bankInfo = bankInfo;
                        }

                        public Object getBankCardNo() {
                            return bankCardNo;
                        }

                        public void setBankCardNo(Object bankCardNo) {
                            this.bankCardNo = bankCardNo;
                        }

                        public String getNotes() {
                            return notes;
                        }

                        public void setNotes(String notes) {
                            this.notes = notes;
                        }

                        public Object getNativePlace() {
                            return nativePlace;
                        }

                        public void setNativePlace(Object nativePlace) {
                            this.nativePlace = nativePlace;
                        }

                        public Object getNation() {
                            return nation;
                        }

                        public void setNation(Object nation) {
                            this.nation = nation;
                        }

                        public Object getSinceTime() {
                            return sinceTime;
                        }

                        public void setSinceTime(Object sinceTime) {
                            this.sinceTime = sinceTime;
                        }

                        public String getGender() {
                            return gender;
                        }

                        public void setGender(String gender) {
                            this.gender = gender;
                        }

                        public Object getSkillCertificate() {
                            return skillCertificate;
                        }

                        public void setSkillCertificate(Object skillCertificate) {
                            this.skillCertificate = skillCertificate;
                        }

                        public Object getEducation() {
                            return education;
                        }

                        public void setEducation(Object education) {
                            this.education = education;
                        }

                        public Object getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(Object birthday) {
                            this.birthday = birthday;
                        }

                        public Object getPosition() {
                            return position;
                        }

                        public void setPosition(Object position) {
                            this.position = position;
                        }

                        public Object getCertificate() {
                            return certificate;
                        }

                        public void setCertificate(Object certificate) {
                            this.certificate = certificate;
                        }

                        public boolean isSafe() {
                            return safe;
                        }

                        public void setSafe(boolean safe) {
                            this.safe = safe;
                        }

                        public Object getCompanyName() {
                            return companyName;
                        }

                        public void setCompanyName(Object companyName) {
                            this.companyName = companyName;
                        }

                        public Object getCapital() {
                            return capital;
                        }

                        public void setCapital(Object capital) {
                            this.capital = capital;
                        }

                        public Object getLegalPerson() {
                            return legalPerson;
                        }

                        public void setLegalPerson(Object legalPerson) {
                            this.legalPerson = legalPerson;
                        }

                        public Object getCompanyAddress() {
                            return companyAddress;
                        }

                        public void setCompanyAddress(Object companyAddress) {
                            this.companyAddress = companyAddress;
                        }

                        public Object getXinyongCode() {
                            return xinyongCode;
                        }

                        public void setXinyongCode(Object xinyongCode) {
                            this.xinyongCode = xinyongCode;
                        }

                        public CardFrontBean getCardFront() {
                            return cardFront;
                        }

                        public void setCardFront(CardFrontBean cardFront) {
                            this.cardFront = cardFront;
                        }

                        public Object getStartTime() {
                            return startTime;
                        }

                        public void setStartTime(Object startTime) {
                            this.startTime = startTime;
                        }

                        public Object getEmergencyContacts() {
                            return emergencyContacts;
                        }

                        public void setEmergencyContacts(Object emergencyContacts) {
                            this.emergencyContacts = emergencyContacts;
                        }

                        public Object getEmergencyPhone() {
                            return emergencyPhone;
                        }

                        public void setEmergencyPhone(Object emergencyPhone) {
                            this.emergencyPhone = emergencyPhone;
                        }

                        public Object getStarsLevel() {
                            return starsLevel;
                        }

                        public void setStarsLevel(Object starsLevel) {
                            this.starsLevel = starsLevel;
                        }

                        public StatusBeanX getStatus() {
                            return status;
                        }

                        public void setStatus(StatusBeanX status) {
                            this.status = status;
                        }

                        public Object getDistrict() {
                            return district;
                        }

                        public void setDistrict(Object district) {
                            this.district = district;
                        }

                        public String getStreetAddress() {
                            return streetAddress;
                        }

                        public void setStreetAddress(String streetAddress) {
                            this.streetAddress = streetAddress;
                        }

                        public String getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(String createTime) {
                            this.createTime = createTime;
                        }

                        public Object getBankAccount() {
                            return bankAccount;
                        }

                        public void setBankAccount(Object bankAccount) {
                            this.bankAccount = bankAccount;
                        }

                        public String getAccountType() {
                            return accountType;
                        }

                        public void setAccountType(String accountType) {
                            this.accountType = accountType;
                        }

                        public String getDisplayAddress() {
                            return displayAddress;
                        }

                        public void setDisplayAddress(String displayAddress) {
                            this.displayAddress = displayAddress;
                        }

                        public int getMembersCount() {
                            return membersCount;
                        }

                        public void setMembersCount(int membersCount) {
                            this.membersCount = membersCount;
                        }

                        public Object getViewPoint() {
                            return viewPoint;
                        }

                        public void setViewPoint(Object viewPoint) {
                            this.viewPoint = viewPoint;
                        }

                        public Object getSuid() {
                            return suid;
                        }

                        public void setSuid(Object suid) {
                            this.suid = suid;
                        }

                        public List<MembersBean> getMembers() {
                            return members;
                        }

                        public void setMembers(List<MembersBean> members) {
                            this.members = members;
                        }

                        public List<?> getProjects() {
                            return projects;
                        }

                        public void setProjects(List<?> projects) {
                            this.projects = projects;
                        }

                        public static class TeamTypeBean {
                            /**
                             * id : 20696
                             * title : 造价员
                             * regulation : null
                             * crafts : null
                             * quality : null
                             * category : {"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1}
                             * szTypeId : null
                             * msgIndex : 0
                             * libraryCount : 0
                             * status : 1
                             */

                            private int id;
                            private String title;
                            private Object regulation;
                            private Object crafts;
                            private Object quality;
                            private CategoryBean category;
                            private Object szTypeId;
                            private int msgIndex;
                            private int libraryCount;
                            private int status;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getTitle() {
                                return title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }

                            public Object getRegulation() {
                                return regulation;
                            }

                            public void setRegulation(Object regulation) {
                                this.regulation = regulation;
                            }

                            public Object getCrafts() {
                                return crafts;
                            }

                            public void setCrafts(Object crafts) {
                                this.crafts = crafts;
                            }

                            public Object getQuality() {
                                return quality;
                            }

                            public void setQuality(Object quality) {
                                this.quality = quality;
                            }

                            public CategoryBean getCategory() {
                                return category;
                            }

                            public void setCategory(CategoryBean category) {
                                this.category = category;
                            }

                            public Object getSzTypeId() {
                                return szTypeId;
                            }

                            public void setSzTypeId(Object szTypeId) {
                                this.szTypeId = szTypeId;
                            }

                            public int getMsgIndex() {
                                return msgIndex;
                            }

                            public void setMsgIndex(int msgIndex) {
                                this.msgIndex = msgIndex;
                            }

                            public int getLibraryCount() {
                                return libraryCount;
                            }

                            public void setLibraryCount(int libraryCount) {
                                this.libraryCount = libraryCount;
                            }

                            public int getStatus() {
                                return status;
                            }

                            public void setStatus(int status) {
                                this.status = status;
                            }

                            public static class CategoryBean {
                                /**
                                 * id : GUANLI
                                 * text : 管理
                                 * category : TEAM_CATEGORY
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : 1
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private int orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public int getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(int orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }
                        }

                        public static class PhotoBean {
                            /**
                             * id : 85766
                             * host : http://jianzhugang.xzgapp.com
                             * name : 3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                             * url : http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class IdFrontBean {
                            /**
                             * id : 84095
                             * host : http://jianzhugang.xzgapp.com
                             * name : 1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                             * url : http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class CardFrontBean {
                            /**
                             * id : 84096
                             * host : http://jianzhugang.xzgapp.com
                             * name : 5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                             * url : http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class StatusBeanX {
                            /**
                             * id : TEAM_STATUS_NORMAL
                             * text : 正常
                             * category : TEAM_STATUS
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }

                        public static class MembersBean {
                            /**
                             * id : 85479
                             * phone : 13071010127
                             * bankName : 工商银行
                             * cardNumber : 6222021702044210557
                             * title : hah
                             * gender : null
                             * nation : null
                             * birthday : 1989-05-11
                             * nativePlace : null
                             * idNumber : 412825198905112011
                             * position : null
                             * teamType : null
                             * certificate : null
                             * safe : false
                             * xueli : null
                             * gangqianPX : false
                             * idCardInfo : null
                             * shiduan : null
                             * peopleType : null
                             * workType : null
                             * haveContract : false
                             * idAgency : null
                             * idValiddate : null
                             * idphotoScan : null
                             * idPhoto : null
                             * facephoto : null
                             * idFront : null
                             * cardFront : null
                             * updateTime : 2018-04-18 17:49:35
                             * createTime : null
                             * status : {"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                             */

                            private int id;
                            private String phone;
                            private String bankName;
                            private String cardNumber;
                            private String title;
                            private Object gender;
                            private Object nation;
                            private String birthday;
                            private Object nativePlace;
                            private String idNumber;
                            private Object position;
                            private Object teamType;
                            private Object certificate;
                            private boolean safe;
                            private Object xueli;
                            private boolean gangqianPX;
                            private Object idCardInfo;
                            private Object shiduan;
                            private Object peopleType;
                            private Object workType;
                            private boolean haveContract;
                            private Object idAgency;
                            private Object idValiddate;
                            private Object idphotoScan;
                            private Object idPhoto;
                            private Object facephoto;
                            private Object idFront;
                            private Object cardFront;
                            private String updateTime;
                            private Object createTime;
                            private StatusBeanXX status;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getPhone() {
                                return phone;
                            }

                            public void setPhone(String phone) {
                                this.phone = phone;
                            }

                            public String getBankName() {
                                return bankName;
                            }

                            public void setBankName(String bankName) {
                                this.bankName = bankName;
                            }

                            public String getCardNumber() {
                                return cardNumber;
                            }

                            public void setCardNumber(String cardNumber) {
                                this.cardNumber = cardNumber;
                            }

                            public String getTitle() {
                                return title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }

                            public Object getGender() {
                                return gender;
                            }

                            public void setGender(Object gender) {
                                this.gender = gender;
                            }

                            public Object getNation() {
                                return nation;
                            }

                            public void setNation(Object nation) {
                                this.nation = nation;
                            }

                            public String getBirthday() {
                                return birthday;
                            }

                            public void setBirthday(String birthday) {
                                this.birthday = birthday;
                            }

                            public Object getNativePlace() {
                                return nativePlace;
                            }

                            public void setNativePlace(Object nativePlace) {
                                this.nativePlace = nativePlace;
                            }

                            public String getIdNumber() {
                                return idNumber;
                            }

                            public void setIdNumber(String idNumber) {
                                this.idNumber = idNumber;
                            }

                            public Object getPosition() {
                                return position;
                            }

                            public void setPosition(Object position) {
                                this.position = position;
                            }

                            public Object getTeamType() {
                                return teamType;
                            }

                            public void setTeamType(Object teamType) {
                                this.teamType = teamType;
                            }

                            public Object getCertificate() {
                                return certificate;
                            }

                            public void setCertificate(Object certificate) {
                                this.certificate = certificate;
                            }

                            public boolean isSafe() {
                                return safe;
                            }

                            public void setSafe(boolean safe) {
                                this.safe = safe;
                            }

                            public Object getXueli() {
                                return xueli;
                            }

                            public void setXueli(Object xueli) {
                                this.xueli = xueli;
                            }

                            public boolean isGangqianPX() {
                                return gangqianPX;
                            }

                            public void setGangqianPX(boolean gangqianPX) {
                                this.gangqianPX = gangqianPX;
                            }

                            public Object getIdCardInfo() {
                                return idCardInfo;
                            }

                            public void setIdCardInfo(Object idCardInfo) {
                                this.idCardInfo = idCardInfo;
                            }

                            public Object getShiduan() {
                                return shiduan;
                            }

                            public void setShiduan(Object shiduan) {
                                this.shiduan = shiduan;
                            }

                            public Object getPeopleType() {
                                return peopleType;
                            }

                            public void setPeopleType(Object peopleType) {
                                this.peopleType = peopleType;
                            }

                            public Object getWorkType() {
                                return workType;
                            }

                            public void setWorkType(Object workType) {
                                this.workType = workType;
                            }

                            public boolean isHaveContract() {
                                return haveContract;
                            }

                            public void setHaveContract(boolean haveContract) {
                                this.haveContract = haveContract;
                            }

                            public Object getIdAgency() {
                                return idAgency;
                            }

                            public void setIdAgency(Object idAgency) {
                                this.idAgency = idAgency;
                            }

                            public Object getIdValiddate() {
                                return idValiddate;
                            }

                            public void setIdValiddate(Object idValiddate) {
                                this.idValiddate = idValiddate;
                            }

                            public Object getIdphotoScan() {
                                return idphotoScan;
                            }

                            public void setIdphotoScan(Object idphotoScan) {
                                this.idphotoScan = idphotoScan;
                            }

                            public Object getIdPhoto() {
                                return idPhoto;
                            }

                            public void setIdPhoto(Object idPhoto) {
                                this.idPhoto = idPhoto;
                            }

                            public Object getFacephoto() {
                                return facephoto;
                            }

                            public void setFacephoto(Object facephoto) {
                                this.facephoto = facephoto;
                            }

                            public Object getIdFront() {
                                return idFront;
                            }

                            public void setIdFront(Object idFront) {
                                this.idFront = idFront;
                            }

                            public Object getCardFront() {
                                return cardFront;
                            }

                            public void setCardFront(Object cardFront) {
                                this.cardFront = cardFront;
                            }

                            public String getUpdateTime() {
                                return updateTime;
                            }

                            public void setUpdateTime(String updateTime) {
                                this.updateTime = updateTime;
                            }

                            public Object getCreateTime() {
                                return createTime;
                            }

                            public void setCreateTime(Object createTime) {
                                this.createTime = createTime;
                            }

                            public StatusBeanXX getStatus() {
                                return status;
                            }

                            public void setStatus(StatusBeanXX status) {
                                this.status = status;
                            }

                            public static class StatusBeanXX {
                                /**
                                 * id : MEMBER_HIDDEN
                                 * text : 已移除
                                 * category : MEMBER_STATUS
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : null
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private Object orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }
                        }
                    }

                    public static class CompanyBean {
                        /**
                         * id : 3120
                         * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                         * userName : 13426599742
                         * title : 凌峰
                         * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
                         * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
                         * organizationCode : 791202564
                         * contacts : 吕佳伟
                         * phone : 13426599742
                         * fax : null
                         * email : null
                         * website : null
                         * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                         * createTime : null
                         * accountType : COMPANY
                         * parentCompany : null
                         * superviseCompany : null
                         * topCompany : false
                         * adminCompany : true
                         * notes : null
                         * bankAccount : null
                         * streetAddress : null
                         */

                        private int id;
                        private CompanyTypeBean companyType;
                        private String userName;
                        private String title;
                        private LogoBean logo;
                        private TouxiangBean touxiang;
                        private String organizationCode;
                        private String contacts;
                        private String phone;
                        private Object fax;
                        private Object email;
                        private Object website;
                        private StatusBeanXXX status;
                        private Object createTime;
                        private String accountType;
                        private Object parentCompany;
                        private Object superviseCompany;
                        private boolean topCompany;
                        private boolean adminCompany;
                        private String notes;
                        private Object bankAccount;
                        private Object streetAddress;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public CompanyTypeBean getCompanyType() {
                            return companyType;
                        }

                        public void setCompanyType(CompanyTypeBean companyType) {
                            this.companyType = companyType;
                        }

                        public String getUserName() {
                            return userName;
                        }

                        public void setUserName(String userName) {
                            this.userName = userName;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public LogoBean getLogo() {
                            return logo;
                        }

                        public void setLogo(LogoBean logo) {
                            this.logo = logo;
                        }

                        public TouxiangBean getTouxiang() {
                            return touxiang;
                        }

                        public void setTouxiang(TouxiangBean touxiang) {
                            this.touxiang = touxiang;
                        }

                        public String getOrganizationCode() {
                            return organizationCode;
                        }

                        public void setOrganizationCode(String organizationCode) {
                            this.organizationCode = organizationCode;
                        }

                        public String getContacts() {
                            return contacts;
                        }

                        public void setContacts(String contacts) {
                            this.contacts = contacts;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public Object getFax() {
                            return fax;
                        }

                        public void setFax(Object fax) {
                            this.fax = fax;
                        }

                        public Object getEmail() {
                            return email;
                        }

                        public void setEmail(Object email) {
                            this.email = email;
                        }

                        public Object getWebsite() {
                            return website;
                        }

                        public void setWebsite(Object website) {
                            this.website = website;
                        }

                        public StatusBeanXXX getStatus() {
                            return status;
                        }

                        public void setStatus(StatusBeanXXX status) {
                            this.status = status;
                        }

                        public Object getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(Object createTime) {
                            this.createTime = createTime;
                        }

                        public String getAccountType() {
                            return accountType;
                        }

                        public void setAccountType(String accountType) {
                            this.accountType = accountType;
                        }

                        public Object getParentCompany() {
                            return parentCompany;
                        }

                        public void setParentCompany(Object parentCompany) {
                            this.parentCompany = parentCompany;
                        }

                        public Object getSuperviseCompany() {
                            return superviseCompany;
                        }

                        public void setSuperviseCompany(Object superviseCompany) {
                            this.superviseCompany = superviseCompany;
                        }

                        public boolean isTopCompany() {
                            return topCompany;
                        }

                        public void setTopCompany(boolean topCompany) {
                            this.topCompany = topCompany;
                        }

                        public boolean isAdminCompany() {
                            return adminCompany;
                        }

                        public void setAdminCompany(boolean adminCompany) {
                            this.adminCompany = adminCompany;
                        }

                        public String getNotes() {
                            return notes;
                        }

                        public void setNotes(String notes) {
                            this.notes = notes;
                        }

                        public Object getBankAccount() {
                            return bankAccount;
                        }

                        public void setBankAccount(Object bankAccount) {
                            this.bankAccount = bankAccount;
                        }

                        public Object getStreetAddress() {
                            return streetAddress;
                        }

                        public void setStreetAddress(Object streetAddress) {
                            this.streetAddress = streetAddress;
                        }

                        public static class CompanyTypeBean {
                            /**
                             * id : COMPANY_TYPE_1
                             * text : 建筑公司
                             * category : COMPANY_TYPE
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }

                        public static class LogoBean {
                            /**
                             * id : 84364
                             * host : http://jianzhugang.xzgapp.com
                             * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                             * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class TouxiangBean {
                            /**
                             * id : 84436
                             * host : http://jianzhugang.xzgapp.com
                             * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                             * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class StatusBeanXXX {
                            /**
                             * id : COMPANY_STATUS_NORMAL
                             * text : 正常
                             * category : COMPANY_STATUS
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }
                    }

                    public static class ProjectHireBean {
                        /**
                         * id : 84844
                         * publishedTime : 2018-03-30 17:58:56
                         * title : null
                         * closeTime : null
                         * teamRequire : null
                         * memo : 测试
                         * price : 10000
                         * hireEnded : true
                         * project : {"id":84741,"status":{"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null},"buildingStatus":{"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null},"startTime":"2018-04-01 00:00:00","endTime":"2018-10-01 00:00:00","updateTime":"2018-04-12 15:02:11","createTime":null,"name":"呃呃","company":{"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null},"description":"123456789","memo":null,"dcenterDesc":null,"district":{"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null},"shortProjectName":null,"longitude":null,"latitude":null,"jianSheDW":null,"gongchengMC":null,"gongchengDZ":null,"shigongXKZ":null,"shigongDW":null,"jianliDW":null,"shejiDW":null,"contacts":"ghh","contactsPosition":null,"contactsPhone":"1562648507","contactsEmail":null,"videoUrl":null,"yztProjectId":null,"displayAddress":"","streetAddress":"嘀嘀嘀"}
                         * type : {"id":"PROJECT_TYPE_WORKER","text":"班组","category":"PROJECT_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                         * salary : null
                         * userDeleted : true
                         * phone : 13426599742
                         * status : {"id":"HIRE_TYPE_CLOSE","text":"招聘已结束","category":"PROJECT_HIRE_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                         * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
                         * source : 注册公司
                         * hireId : null
                         * smsNum : 0
                         * teamNeeds : [{"id":84845,"teamType":{"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1},"peopleNumber":100,"memo":null}]
                         * contacts : 测试
                         * provinceId : 1
                         * cityId : 1001
                         * districtId : 1199
                         * teamNeedStr : G20265Z
                         */

                        private int id;
                        private String publishedTime;
                        private Object title;
                        private Object closeTime;
                        private Object teamRequire;
                        private String memo;
                        private String price;
                        private boolean hireEnded;
                        private ProjectBean project;
                        private TypeBean type;
                        private Object salary;
                        private boolean userDeleted;
                        private String phone;
                        private StatusBeanXXXXXX status;
                        private CompanyBeanXX company;
                        private String source;
                        private Object hireId;
                        private int smsNum;
                        private String contacts;
                        private int provinceId;
                        private int cityId;
                        private int districtId;
                        private String teamNeedStr;
                        private List<TeamNeedsBean> teamNeeds;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getPublishedTime() {
                            return publishedTime;
                        }

                        public void setPublishedTime(String publishedTime) {
                            this.publishedTime = publishedTime;
                        }

                        public Object getTitle() {
                            return title;
                        }

                        public void setTitle(Object title) {
                            this.title = title;
                        }

                        public Object getCloseTime() {
                            return closeTime;
                        }

                        public void setCloseTime(Object closeTime) {
                            this.closeTime = closeTime;
                        }

                        public Object getTeamRequire() {
                            return teamRequire;
                        }

                        public void setTeamRequire(Object teamRequire) {
                            this.teamRequire = teamRequire;
                        }

                        public String getMemo() {
                            return memo;
                        }

                        public void setMemo(String memo) {
                            this.memo = memo;
                        }

                        public String getPrice() {
                            return price;
                        }

                        public void setPrice(String price) {
                            this.price = price;
                        }

                        public boolean isHireEnded() {
                            return hireEnded;
                        }

                        public void setHireEnded(boolean hireEnded) {
                            this.hireEnded = hireEnded;
                        }

                        public ProjectBean getProject() {
                            return project;
                        }

                        public void setProject(ProjectBean project) {
                            this.project = project;
                        }

                        public TypeBean getType() {
                            return type;
                        }

                        public void setType(TypeBean type) {
                            this.type = type;
                        }

                        public Object getSalary() {
                            return salary;
                        }

                        public void setSalary(Object salary) {
                            this.salary = salary;
                        }

                        public boolean isUserDeleted() {
                            return userDeleted;
                        }

                        public void setUserDeleted(boolean userDeleted) {
                            this.userDeleted = userDeleted;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public StatusBeanXXXXXX getStatus() {
                            return status;
                        }

                        public void setStatus(StatusBeanXXXXXX status) {
                            this.status = status;
                        }

                        public CompanyBeanXX getCompany() {
                            return company;
                        }

                        public void setCompany(CompanyBeanXX company) {
                            this.company = company;
                        }

                        public String getSource() {
                            return source;
                        }

                        public void setSource(String source) {
                            this.source = source;
                        }

                        public Object getHireId() {
                            return hireId;
                        }

                        public void setHireId(Object hireId) {
                            this.hireId = hireId;
                        }

                        public int getSmsNum() {
                            return smsNum;
                        }

                        public void setSmsNum(int smsNum) {
                            this.smsNum = smsNum;
                        }

                        public String getContacts() {
                            return contacts;
                        }

                        public void setContacts(String contacts) {
                            this.contacts = contacts;
                        }

                        public int getProvinceId() {
                            return provinceId;
                        }

                        public void setProvinceId(int provinceId) {
                            this.provinceId = provinceId;
                        }

                        public int getCityId() {
                            return cityId;
                        }

                        public void setCityId(int cityId) {
                            this.cityId = cityId;
                        }

                        public int getDistrictId() {
                            return districtId;
                        }

                        public void setDistrictId(int districtId) {
                            this.districtId = districtId;
                        }

                        public String getTeamNeedStr() {
                            return teamNeedStr;
                        }

                        public void setTeamNeedStr(String teamNeedStr) {
                            this.teamNeedStr = teamNeedStr;
                        }

                        public List<TeamNeedsBean> getTeamNeeds() {
                            return teamNeeds;
                        }

                        public void setTeamNeeds(List<TeamNeedsBean> teamNeeds) {
                            this.teamNeeds = teamNeeds;
                        }

                        public static class ProjectBean {
                            /**
                             * id : 84741
                             * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                             * buildingStatus : {"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                             * startTime : 2018-04-01 00:00:00
                             * endTime : 2018-10-01 00:00:00
                             * updateTime : 2018-04-12 15:02:11
                             * createTime : null
                             * name : 呃呃
                             * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
                             * description : 123456789
                             * memo : null
                             * dcenterDesc : null
                             * district : {"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
                             * shortProjectName : null
                             * longitude : null
                             * latitude : null
                             * jianSheDW : null
                             * gongchengMC : null
                             * gongchengDZ : null
                             * shigongXKZ : null
                             * shigongDW : null
                             * jianliDW : null
                             * shejiDW : null
                             * contacts : ghh
                             * contactsPosition : null
                             * contactsPhone : 1562648507
                             * contactsEmail : null
                             * videoUrl : null
                             * yztProjectId : null
                             * displayAddress :
                             * streetAddress : 嘀嘀嘀
                             */

                            private int id;
                            private StatusBeanXXXX status;
                            private BuildingStatusBean buildingStatus;
                            private String startTime;
                            private String endTime;
                            private String updateTime;
                            private Object createTime;
                            private String name;
                            private CompanyBeanX company;
                            private String description;
                            private Object memo;
                            private Object dcenterDesc;
                            private DistrictBean district;
                            private Object shortProjectName;
                            private Object longitude;
                            private Object latitude;
                            private Object jianSheDW;
                            private Object gongchengMC;
                            private Object gongchengDZ;
                            private Object shigongXKZ;
                            private Object shigongDW;
                            private Object jianliDW;
                            private Object shejiDW;
                            private String contacts;
                            private Object contactsPosition;
                            private String contactsPhone;
                            private Object contactsEmail;
                            private Object videoUrl;
                            private Object yztProjectId;
                            private String displayAddress;
                            private String streetAddress;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public StatusBeanXXXX getStatus() {
                                return status;
                            }

                            public void setStatus(StatusBeanXXXX status) {
                                this.status = status;
                            }

                            public BuildingStatusBean getBuildingStatus() {
                                return buildingStatus;
                            }

                            public void setBuildingStatus(BuildingStatusBean buildingStatus) {
                                this.buildingStatus = buildingStatus;
                            }

                            public String getStartTime() {
                                return startTime;
                            }

                            public void setStartTime(String startTime) {
                                this.startTime = startTime;
                            }

                            public String getEndTime() {
                                return endTime;
                            }

                            public void setEndTime(String endTime) {
                                this.endTime = endTime;
                            }

                            public String getUpdateTime() {
                                return updateTime;
                            }

                            public void setUpdateTime(String updateTime) {
                                this.updateTime = updateTime;
                            }

                            public Object getCreateTime() {
                                return createTime;
                            }

                            public void setCreateTime(Object createTime) {
                                this.createTime = createTime;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public CompanyBeanX getCompany() {
                                return company;
                            }

                            public void setCompany(CompanyBeanX company) {
                                this.company = company;
                            }

                            public String getDescription() {
                                return description;
                            }

                            public void setDescription(String description) {
                                this.description = description;
                            }

                            public Object getMemo() {
                                return memo;
                            }

                            public void setMemo(Object memo) {
                                this.memo = memo;
                            }

                            public Object getDcenterDesc() {
                                return dcenterDesc;
                            }

                            public void setDcenterDesc(Object dcenterDesc) {
                                this.dcenterDesc = dcenterDesc;
                            }

                            public DistrictBean getDistrict() {
                                return district;
                            }

                            public void setDistrict(DistrictBean district) {
                                this.district = district;
                            }

                            public Object getShortProjectName() {
                                return shortProjectName;
                            }

                            public void setShortProjectName(Object shortProjectName) {
                                this.shortProjectName = shortProjectName;
                            }

                            public Object getLongitude() {
                                return longitude;
                            }

                            public void setLongitude(Object longitude) {
                                this.longitude = longitude;
                            }

                            public Object getLatitude() {
                                return latitude;
                            }

                            public void setLatitude(Object latitude) {
                                this.latitude = latitude;
                            }

                            public Object getJianSheDW() {
                                return jianSheDW;
                            }

                            public void setJianSheDW(Object jianSheDW) {
                                this.jianSheDW = jianSheDW;
                            }

                            public Object getGongchengMC() {
                                return gongchengMC;
                            }

                            public void setGongchengMC(Object gongchengMC) {
                                this.gongchengMC = gongchengMC;
                            }

                            public Object getGongchengDZ() {
                                return gongchengDZ;
                            }

                            public void setGongchengDZ(Object gongchengDZ) {
                                this.gongchengDZ = gongchengDZ;
                            }

                            public Object getShigongXKZ() {
                                return shigongXKZ;
                            }

                            public void setShigongXKZ(Object shigongXKZ) {
                                this.shigongXKZ = shigongXKZ;
                            }

                            public Object getShigongDW() {
                                return shigongDW;
                            }

                            public void setShigongDW(Object shigongDW) {
                                this.shigongDW = shigongDW;
                            }

                            public Object getJianliDW() {
                                return jianliDW;
                            }

                            public void setJianliDW(Object jianliDW) {
                                this.jianliDW = jianliDW;
                            }

                            public Object getShejiDW() {
                                return shejiDW;
                            }

                            public void setShejiDW(Object shejiDW) {
                                this.shejiDW = shejiDW;
                            }

                            public String getContacts() {
                                return contacts;
                            }

                            public void setContacts(String contacts) {
                                this.contacts = contacts;
                            }

                            public Object getContactsPosition() {
                                return contactsPosition;
                            }

                            public void setContactsPosition(Object contactsPosition) {
                                this.contactsPosition = contactsPosition;
                            }

                            public String getContactsPhone() {
                                return contactsPhone;
                            }

                            public void setContactsPhone(String contactsPhone) {
                                this.contactsPhone = contactsPhone;
                            }

                            public Object getContactsEmail() {
                                return contactsEmail;
                            }

                            public void setContactsEmail(Object contactsEmail) {
                                this.contactsEmail = contactsEmail;
                            }

                            public Object getVideoUrl() {
                                return videoUrl;
                            }

                            public void setVideoUrl(Object videoUrl) {
                                this.videoUrl = videoUrl;
                            }

                            public Object getYztProjectId() {
                                return yztProjectId;
                            }

                            public void setYztProjectId(Object yztProjectId) {
                                this.yztProjectId = yztProjectId;
                            }

                            public String getDisplayAddress() {
                                return displayAddress;
                            }

                            public void setDisplayAddress(String displayAddress) {
                                this.displayAddress = displayAddress;
                            }

                            public String getStreetAddress() {
                                return streetAddress;
                            }

                            public void setStreetAddress(String streetAddress) {
                                this.streetAddress = streetAddress;
                            }

                            public static class StatusBeanXXXX {
                                /**
                                 * id : AUDITED
                                 * text : 已审核
                                 * category : PROJECT_STATUS
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : null
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private Object orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }

                            public static class BuildingStatusBean {
                                /**
                                 * id : PROJECT_BUILDING
                                 * text : 建设中
                                 * category : PROJECT_BUILDING_STATUS
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : null
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private Object orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }

                            public static class CompanyBeanX {
                                /**
                                 * id : 3120
                                 * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                                 * userName : 13426599742
                                 * title : 凌峰
                                 * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
                                 * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
                                 * organizationCode : 791202564
                                 * contacts : 吕佳伟
                                 * phone : 13426599742
                                 * fax : null
                                 * email : null
                                 * website : null
                                 * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                                 * createTime : null
                                 * accountType : COMPANY
                                 * parentCompany : null
                                 * superviseCompany : null
                                 * topCompany : false
                                 * adminCompany : true
                                 * notes : null
                                 * bankAccount : null
                                 * streetAddress : null
                                 */

                                private int id;
                                private CompanyTypeBeanX companyType;
                                private String userName;
                                private String title;
                                private LogoBeanX logo;
                                private TouxiangBeanX touxiang;
                                private String organizationCode;
                                private String contacts;
                                private String phone;
                                private Object fax;
                                private Object email;
                                private Object website;
                                private StatusBeanXXXXX status;
                                private Object createTime;
                                private String accountType;
                                private Object parentCompany;
                                private Object superviseCompany;
                                private boolean topCompany;
                                private boolean adminCompany;
                                private String notes;
                                private Object bankAccount;
                                private Object streetAddress;

                                public int getId() {
                                    return id;
                                }

                                public void setId(int id) {
                                    this.id = id;
                                }

                                public CompanyTypeBeanX getCompanyType() {
                                    return companyType;
                                }

                                public void setCompanyType(CompanyTypeBeanX companyType) {
                                    this.companyType = companyType;
                                }

                                public String getUserName() {
                                    return userName;
                                }

                                public void setUserName(String userName) {
                                    this.userName = userName;
                                }

                                public String getTitle() {
                                    return title;
                                }

                                public void setTitle(String title) {
                                    this.title = title;
                                }

                                public LogoBeanX getLogo() {
                                    return logo;
                                }

                                public void setLogo(LogoBeanX logo) {
                                    this.logo = logo;
                                }

                                public TouxiangBeanX getTouxiang() {
                                    return touxiang;
                                }

                                public void setTouxiang(TouxiangBeanX touxiang) {
                                    this.touxiang = touxiang;
                                }

                                public String getOrganizationCode() {
                                    return organizationCode;
                                }

                                public void setOrganizationCode(String organizationCode) {
                                    this.organizationCode = organizationCode;
                                }

                                public String getContacts() {
                                    return contacts;
                                }

                                public void setContacts(String contacts) {
                                    this.contacts = contacts;
                                }

                                public String getPhone() {
                                    return phone;
                                }

                                public void setPhone(String phone) {
                                    this.phone = phone;
                                }

                                public Object getFax() {
                                    return fax;
                                }

                                public void setFax(Object fax) {
                                    this.fax = fax;
                                }

                                public Object getEmail() {
                                    return email;
                                }

                                public void setEmail(Object email) {
                                    this.email = email;
                                }

                                public Object getWebsite() {
                                    return website;
                                }

                                public void setWebsite(Object website) {
                                    this.website = website;
                                }

                                public StatusBeanXXXXX getStatus() {
                                    return status;
                                }

                                public void setStatus(StatusBeanXXXXX status) {
                                    this.status = status;
                                }

                                public Object getCreateTime() {
                                    return createTime;
                                }

                                public void setCreateTime(Object createTime) {
                                    this.createTime = createTime;
                                }

                                public String getAccountType() {
                                    return accountType;
                                }

                                public void setAccountType(String accountType) {
                                    this.accountType = accountType;
                                }

                                public Object getParentCompany() {
                                    return parentCompany;
                                }

                                public void setParentCompany(Object parentCompany) {
                                    this.parentCompany = parentCompany;
                                }

                                public Object getSuperviseCompany() {
                                    return superviseCompany;
                                }

                                public void setSuperviseCompany(Object superviseCompany) {
                                    this.superviseCompany = superviseCompany;
                                }

                                public boolean isTopCompany() {
                                    return topCompany;
                                }

                                public void setTopCompany(boolean topCompany) {
                                    this.topCompany = topCompany;
                                }

                                public boolean isAdminCompany() {
                                    return adminCompany;
                                }

                                public void setAdminCompany(boolean adminCompany) {
                                    this.adminCompany = adminCompany;
                                }

                                public String getNotes() {
                                    return notes;
                                }

                                public void setNotes(String notes) {
                                    this.notes = notes;
                                }

                                public Object getBankAccount() {
                                    return bankAccount;
                                }

                                public void setBankAccount(Object bankAccount) {
                                    this.bankAccount = bankAccount;
                                }

                                public Object getStreetAddress() {
                                    return streetAddress;
                                }

                                public void setStreetAddress(Object streetAddress) {
                                    this.streetAddress = streetAddress;
                                }

                                public static class CompanyTypeBeanX {
                                    /**
                                     * id : COMPANY_TYPE_1
                                     * text : 建筑公司
                                     * category : COMPANY_TYPE
                                     * groupTitle : null
                                     * system : true
                                     * orderIndex : null
                                     */

                                    private String id;
                                    private String text;
                                    private String category;
                                    private Object groupTitle;
                                    private boolean system;
                                    private Object orderIndex;

                                    public String getId() {
                                        return id;
                                    }

                                    public void setId(String id) {
                                        this.id = id;
                                    }

                                    public String getText() {
                                        return text;
                                    }

                                    public void setText(String text) {
                                        this.text = text;
                                    }

                                    public String getCategory() {
                                        return category;
                                    }

                                    public void setCategory(String category) {
                                        this.category = category;
                                    }

                                    public Object getGroupTitle() {
                                        return groupTitle;
                                    }

                                    public void setGroupTitle(Object groupTitle) {
                                        this.groupTitle = groupTitle;
                                    }

                                    public boolean isSystem() {
                                        return system;
                                    }

                                    public void setSystem(boolean system) {
                                        this.system = system;
                                    }

                                    public Object getOrderIndex() {
                                        return orderIndex;
                                    }

                                    public void setOrderIndex(Object orderIndex) {
                                        this.orderIndex = orderIndex;
                                    }
                                }

                                public static class LogoBeanX {
                                    /**
                                     * id : 84364
                                     * host : http://jianzhugang.xzgapp.com
                                     * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                                     * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                                     */

                                    private int id;
                                    private String host;
                                    private String name;
                                    private String url;

                                    public int getId() {
                                        return id;
                                    }

                                    public void setId(int id) {
                                        this.id = id;
                                    }

                                    public String getHost() {
                                        return host;
                                    }

                                    public void setHost(String host) {
                                        this.host = host;
                                    }

                                    public String getName() {
                                        return name;
                                    }

                                    public void setName(String name) {
                                        this.name = name;
                                    }

                                    public String getUrl() {
                                        return url;
                                    }

                                    public void setUrl(String url) {
                                        this.url = url;
                                    }
                                }

                                public static class TouxiangBeanX {
                                    /**
                                     * id : 84436
                                     * host : http://jianzhugang.xzgapp.com
                                     * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                                     * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                                     */

                                    private int id;
                                    private String host;
                                    private String name;
                                    private String url;

                                    public int getId() {
                                        return id;
                                    }

                                    public void setId(int id) {
                                        this.id = id;
                                    }

                                    public String getHost() {
                                        return host;
                                    }

                                    public void setHost(String host) {
                                        this.host = host;
                                    }

                                    public String getName() {
                                        return name;
                                    }

                                    public void setName(String name) {
                                        this.name = name;
                                    }

                                    public String getUrl() {
                                        return url;
                                    }

                                    public void setUrl(String url) {
                                        this.url = url;
                                    }
                                }

                                public static class StatusBeanXXXXX {
                                    /**
                                     * id : COMPANY_STATUS_NORMAL
                                     * text : 正常
                                     * category : COMPANY_STATUS
                                     * groupTitle : null
                                     * system : true
                                     * orderIndex : null
                                     */

                                    private String id;
                                    private String text;
                                    private String category;
                                    private Object groupTitle;
                                    private boolean system;
                                    private Object orderIndex;

                                    public String getId() {
                                        return id;
                                    }

                                    public void setId(String id) {
                                        this.id = id;
                                    }

                                    public String getText() {
                                        return text;
                                    }

                                    public void setText(String text) {
                                        this.text = text;
                                    }

                                    public String getCategory() {
                                        return category;
                                    }

                                    public void setCategory(String category) {
                                        this.category = category;
                                    }

                                    public Object getGroupTitle() {
                                        return groupTitle;
                                    }

                                    public void setGroupTitle(Object groupTitle) {
                                        this.groupTitle = groupTitle;
                                    }

                                    public boolean isSystem() {
                                        return system;
                                    }

                                    public void setSystem(boolean system) {
                                        this.system = system;
                                    }

                                    public Object getOrderIndex() {
                                        return orderIndex;
                                    }

                                    public void setOrderIndex(Object orderIndex) {
                                        this.orderIndex = orderIndex;
                                    }
                                }
                            }

                            public static class DistrictBean {
                                /**
                                 * id : 1001
                                 * title : 北京市
                                 * type : CITY
                                 * parent : {"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
                                 * hotCity : null
                                 * orderIndex : null
                                 */

                                private int id;
                                private String title;
                                private String type;
                                private ParentBean parent;
                                private Object hotCity;
                                private Object orderIndex;

                                public int getId() {
                                    return id;
                                }

                                public void setId(int id) {
                                    this.id = id;
                                }

                                public String getTitle() {
                                    return title;
                                }

                                public void setTitle(String title) {
                                    this.title = title;
                                }

                                public String getType() {
                                    return type;
                                }

                                public void setType(String type) {
                                    this.type = type;
                                }

                                public ParentBean getParent() {
                                    return parent;
                                }

                                public void setParent(ParentBean parent) {
                                    this.parent = parent;
                                }

                                public Object getHotCity() {
                                    return hotCity;
                                }

                                public void setHotCity(Object hotCity) {
                                    this.hotCity = hotCity;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }

                                public static class ParentBean {
                                    /**
                                     * id : 1
                                     * title : 北京市
                                     * type : PROVINCE
                                     * parent : null
                                     * hotCity : null
                                     * orderIndex : null
                                     */

                                    private int id;
                                    private String title;
                                    private String type;
                                    private Object parent;
                                    private Object hotCity;
                                    private Object orderIndex;

                                    public int getId() {
                                        return id;
                                    }

                                    public void setId(int id) {
                                        this.id = id;
                                    }

                                    public String getTitle() {
                                        return title;
                                    }

                                    public void setTitle(String title) {
                                        this.title = title;
                                    }

                                    public String getType() {
                                        return type;
                                    }

                                    public void setType(String type) {
                                        this.type = type;
                                    }

                                    public Object getParent() {
                                        return parent;
                                    }

                                    public void setParent(Object parent) {
                                        this.parent = parent;
                                    }

                                    public Object getHotCity() {
                                        return hotCity;
                                    }

                                    public void setHotCity(Object hotCity) {
                                        this.hotCity = hotCity;
                                    }

                                    public Object getOrderIndex() {
                                        return orderIndex;
                                    }

                                    public void setOrderIndex(Object orderIndex) {
                                        this.orderIndex = orderIndex;
                                    }
                                }
                            }
                        }

                        public static class TypeBean {
                            /**
                             * id : PROJECT_TYPE_WORKER
                             * text : 班组
                             * category : PROJECT_TYPE
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }

                        public static class StatusBeanXXXXXX {
                            /**
                             * id : HIRE_TYPE_CLOSE
                             * text : 招聘已结束
                             * category : PROJECT_HIRE_STATUS
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }

                        public static class CompanyBeanXX {
                            /**
                             * id : 3120
                             * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                             * userName : 13426599742
                             * title : 凌峰
                             * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
                             * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
                             * organizationCode : 791202564
                             * contacts : 吕佳伟
                             * phone : 13426599742
                             * fax : null
                             * email : null
                             * website : null
                             * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                             * createTime : null
                             * accountType : COMPANY
                             * parentCompany : null
                             * superviseCompany : null
                             * topCompany : false
                             * adminCompany : true
                             * notes : null
                             * bankAccount : null
                             * streetAddress : null
                             */

                            private int id;
                            private CompanyTypeBeanXX companyType;
                            private String userName;
                            private String title;
                            private LogoBeanXX logo;
                            private TouxiangBeanXX touxiang;
                            private String organizationCode;
                            private String contacts;
                            private String phone;
                            private Object fax;
                            private Object email;
                            private Object website;
                            private StatusBeanXXXXXXX status;
                            private Object createTime;
                            private String accountType;
                            private Object parentCompany;
                            private Object superviseCompany;
                            private boolean topCompany;
                            private boolean adminCompany;
                            private String notes;
                            private Object bankAccount;
                            private Object streetAddress;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public CompanyTypeBeanXX getCompanyType() {
                                return companyType;
                            }

                            public void setCompanyType(CompanyTypeBeanXX companyType) {
                                this.companyType = companyType;
                            }

                            public String getUserName() {
                                return userName;
                            }

                            public void setUserName(String userName) {
                                this.userName = userName;
                            }

                            public String getTitle() {
                                return title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }

                            public LogoBeanXX getLogo() {
                                return logo;
                            }

                            public void setLogo(LogoBeanXX logo) {
                                this.logo = logo;
                            }

                            public TouxiangBeanXX getTouxiang() {
                                return touxiang;
                            }

                            public void setTouxiang(TouxiangBeanXX touxiang) {
                                this.touxiang = touxiang;
                            }

                            public String getOrganizationCode() {
                                return organizationCode;
                            }

                            public void setOrganizationCode(String organizationCode) {
                                this.organizationCode = organizationCode;
                            }

                            public String getContacts() {
                                return contacts;
                            }

                            public void setContacts(String contacts) {
                                this.contacts = contacts;
                            }

                            public String getPhone() {
                                return phone;
                            }

                            public void setPhone(String phone) {
                                this.phone = phone;
                            }

                            public Object getFax() {
                                return fax;
                            }

                            public void setFax(Object fax) {
                                this.fax = fax;
                            }

                            public Object getEmail() {
                                return email;
                            }

                            public void setEmail(Object email) {
                                this.email = email;
                            }

                            public Object getWebsite() {
                                return website;
                            }

                            public void setWebsite(Object website) {
                                this.website = website;
                            }

                            public StatusBeanXXXXXXX getStatus() {
                                return status;
                            }

                            public void setStatus(StatusBeanXXXXXXX status) {
                                this.status = status;
                            }

                            public Object getCreateTime() {
                                return createTime;
                            }

                            public void setCreateTime(Object createTime) {
                                this.createTime = createTime;
                            }

                            public String getAccountType() {
                                return accountType;
                            }

                            public void setAccountType(String accountType) {
                                this.accountType = accountType;
                            }

                            public Object getParentCompany() {
                                return parentCompany;
                            }

                            public void setParentCompany(Object parentCompany) {
                                this.parentCompany = parentCompany;
                            }

                            public Object getSuperviseCompany() {
                                return superviseCompany;
                            }

                            public void setSuperviseCompany(Object superviseCompany) {
                                this.superviseCompany = superviseCompany;
                            }

                            public boolean isTopCompany() {
                                return topCompany;
                            }

                            public void setTopCompany(boolean topCompany) {
                                this.topCompany = topCompany;
                            }

                            public boolean isAdminCompany() {
                                return adminCompany;
                            }

                            public void setAdminCompany(boolean adminCompany) {
                                this.adminCompany = adminCompany;
                            }

                            public String getNotes() {
                                return notes;
                            }

                            public void setNotes(String notes) {
                                this.notes = notes;
                            }

                            public Object getBankAccount() {
                                return bankAccount;
                            }

                            public void setBankAccount(Object bankAccount) {
                                this.bankAccount = bankAccount;
                            }

                            public Object getStreetAddress() {
                                return streetAddress;
                            }

                            public void setStreetAddress(Object streetAddress) {
                                this.streetAddress = streetAddress;
                            }

                            public static class CompanyTypeBeanXX {
                                /**
                                 * id : COMPANY_TYPE_1
                                 * text : 建筑公司
                                 * category : COMPANY_TYPE
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : null
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private Object orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }

                            public static class LogoBeanXX {
                                /**
                                 * id : 84364
                                 * host : http://jianzhugang.xzgapp.com
                                 * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                                 * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                                 */

                                private int id;
                                private String host;
                                private String name;
                                private String url;

                                public int getId() {
                                    return id;
                                }

                                public void setId(int id) {
                                    this.id = id;
                                }

                                public String getHost() {
                                    return host;
                                }

                                public void setHost(String host) {
                                    this.host = host;
                                }

                                public String getName() {
                                    return name;
                                }

                                public void setName(String name) {
                                    this.name = name;
                                }

                                public String getUrl() {
                                    return url;
                                }

                                public void setUrl(String url) {
                                    this.url = url;
                                }
                            }

                            public static class TouxiangBeanXX {
                                /**
                                 * id : 84436
                                 * host : http://jianzhugang.xzgapp.com
                                 * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                                 * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                                 */

                                private int id;
                                private String host;
                                private String name;
                                private String url;

                                public int getId() {
                                    return id;
                                }

                                public void setId(int id) {
                                    this.id = id;
                                }

                                public String getHost() {
                                    return host;
                                }

                                public void setHost(String host) {
                                    this.host = host;
                                }

                                public String getName() {
                                    return name;
                                }

                                public void setName(String name) {
                                    this.name = name;
                                }

                                public String getUrl() {
                                    return url;
                                }

                                public void setUrl(String url) {
                                    this.url = url;
                                }
                            }

                            public static class StatusBeanXXXXXXX {
                                /**
                                 * id : COMPANY_STATUS_NORMAL
                                 * text : 正常
                                 * category : COMPANY_STATUS
                                 * groupTitle : null
                                 * system : true
                                 * orderIndex : null
                                 */

                                private String id;
                                private String text;
                                private String category;
                                private Object groupTitle;
                                private boolean system;
                                private Object orderIndex;

                                public String getId() {
                                    return id;
                                }

                                public void setId(String id) {
                                    this.id = id;
                                }

                                public String getText() {
                                    return text;
                                }

                                public void setText(String text) {
                                    this.text = text;
                                }

                                public String getCategory() {
                                    return category;
                                }

                                public void setCategory(String category) {
                                    this.category = category;
                                }

                                public Object getGroupTitle() {
                                    return groupTitle;
                                }

                                public void setGroupTitle(Object groupTitle) {
                                    this.groupTitle = groupTitle;
                                }

                                public boolean isSystem() {
                                    return system;
                                }

                                public void setSystem(boolean system) {
                                    this.system = system;
                                }

                                public Object getOrderIndex() {
                                    return orderIndex;
                                }

                                public void setOrderIndex(Object orderIndex) {
                                    this.orderIndex = orderIndex;
                                }
                            }
                        }

                        public static class TeamNeedsBean {
                            /**
                             * id : 84845
                             * teamType : {"id":20265,"title":"测量员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
                             * peopleNumber : 100
                             * memo : null
                             */

                            private int id;
                            private TeamTypeBeanX teamType;
                            private int peopleNumber;
                            private Object memo;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public TeamTypeBeanX getTeamType() {
                                return teamType;
                            }

                            public void setTeamType(TeamTypeBeanX teamType) {
                                this.teamType = teamType;
                            }

                            public int getPeopleNumber() {
                                return peopleNumber;
                            }

                            public void setPeopleNumber(int peopleNumber) {
                                this.peopleNumber = peopleNumber;
                            }

                            public Object getMemo() {
                                return memo;
                            }

                            public void setMemo(Object memo) {
                                this.memo = memo;
                            }

                            public static class TeamTypeBeanX {
                                /**
                                 * id : 20265
                                 * title : 测量员
                                 * regulation : null
                                 * crafts : null
                                 * quality : null
                                 * category : {"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1}
                                 * szTypeId : null
                                 * msgIndex : 0
                                 * libraryCount : 0
                                 * status : 1
                                 */

                                private int id;
                                private String title;
                                private Object regulation;
                                private Object crafts;
                                private Object quality;
                                private CategoryBeanX category;
                                private Object szTypeId;
                                private int msgIndex;
                                private int libraryCount;
                                private int status;

                                public int getId() {
                                    return id;
                                }

                                public void setId(int id) {
                                    this.id = id;
                                }

                                public String getTitle() {
                                    return title;
                                }

                                public void setTitle(String title) {
                                    this.title = title;
                                }

                                public Object getRegulation() {
                                    return regulation;
                                }

                                public void setRegulation(Object regulation) {
                                    this.regulation = regulation;
                                }

                                public Object getCrafts() {
                                    return crafts;
                                }

                                public void setCrafts(Object crafts) {
                                    this.crafts = crafts;
                                }

                                public Object getQuality() {
                                    return quality;
                                }

                                public void setQuality(Object quality) {
                                    this.quality = quality;
                                }

                                public CategoryBeanX getCategory() {
                                    return category;
                                }

                                public void setCategory(CategoryBeanX category) {
                                    this.category = category;
                                }

                                public Object getSzTypeId() {
                                    return szTypeId;
                                }

                                public void setSzTypeId(Object szTypeId) {
                                    this.szTypeId = szTypeId;
                                }

                                public int getMsgIndex() {
                                    return msgIndex;
                                }

                                public void setMsgIndex(int msgIndex) {
                                    this.msgIndex = msgIndex;
                                }

                                public int getLibraryCount() {
                                    return libraryCount;
                                }

                                public void setLibraryCount(int libraryCount) {
                                    this.libraryCount = libraryCount;
                                }

                                public int getStatus() {
                                    return status;
                                }

                                public void setStatus(int status) {
                                    this.status = status;
                                }

                                public static class CategoryBeanX {
                                    /**
                                     * id : GUANLI
                                     * text : 管理
                                     * category : TEAM_CATEGORY
                                     * groupTitle : null
                                     * system : true
                                     * orderIndex : 1
                                     */

                                    private String id;
                                    private String text;
                                    private String category;
                                    private Object groupTitle;
                                    private boolean system;
                                    private int orderIndex;

                                    public String getId() {
                                        return id;
                                    }

                                    public void setId(String id) {
                                        this.id = id;
                                    }

                                    public String getText() {
                                        return text;
                                    }

                                    public void setText(String text) {
                                        this.text = text;
                                    }

                                    public String getCategory() {
                                        return category;
                                    }

                                    public void setCategory(String category) {
                                        this.category = category;
                                    }

                                    public Object getGroupTitle() {
                                        return groupTitle;
                                    }

                                    public void setGroupTitle(Object groupTitle) {
                                        this.groupTitle = groupTitle;
                                    }

                                    public boolean isSystem() {
                                        return system;
                                    }

                                    public void setSystem(boolean system) {
                                        this.system = system;
                                    }

                                    public int getOrderIndex() {
                                        return orderIndex;
                                    }

                                    public void setOrderIndex(int orderIndex) {
                                        this.orderIndex = orderIndex;
                                    }
                                }
                            }
                        }
                    }

                    public static class StatusBeanXXXXXXXX {
                        /**
                         * id : CONFIRMED
                         * text : 已确认
                         * category : PROJECT_APPLY_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }
                }

                public static class CompanyBeanXXX {
                    /**
                     * id : 3120
                     * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                     * userName : 13426599742
                     * title : 凌峰
                     * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
                     * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
                     * organizationCode : 791202564
                     * contacts : 吕佳伟
                     * phone : 13426599742
                     * fax : null
                     * email : null
                     * website : null
                     * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     * createTime : null
                     * accountType : COMPANY
                     * parentCompany : null
                     * superviseCompany : null
                     * topCompany : false
                     * adminCompany : true
                     * notes : null
                     * bankAccount : null
                     * streetAddress : null
                     */

                    private int id;
                    private CompanyTypeBeanXXX companyType;
                    private String userName;
                    private String title;
                    private LogoBeanXXX logo;
                    private TouxiangBeanXXX touxiang;
                    private String organizationCode;
                    private String contacts;
                    private String phone;
                    private Object fax;
                    private Object email;
                    private Object website;
                    private StatusBeanXXXXXXXXX status;
                    private Object createTime;
                    private String accountType;
                    private Object parentCompany;
                    private Object superviseCompany;
                    private boolean topCompany;
                    private boolean adminCompany;
                    private String notes;
                    private Object bankAccount;
                    private Object streetAddress;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public CompanyTypeBeanXXX getCompanyType() {
                        return companyType;
                    }

                    public void setCompanyType(CompanyTypeBeanXXX companyType) {
                        this.companyType = companyType;
                    }

                    public String getUserName() {
                        return userName;
                    }

                    public void setUserName(String userName) {
                        this.userName = userName;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public LogoBeanXXX getLogo() {
                        return logo;
                    }

                    public void setLogo(LogoBeanXXX logo) {
                        this.logo = logo;
                    }

                    public TouxiangBeanXXX getTouxiang() {
                        return touxiang;
                    }

                    public void setTouxiang(TouxiangBeanXXX touxiang) {
                        this.touxiang = touxiang;
                    }

                    public String getOrganizationCode() {
                        return organizationCode;
                    }

                    public void setOrganizationCode(String organizationCode) {
                        this.organizationCode = organizationCode;
                    }

                    public String getContacts() {
                        return contacts;
                    }

                    public void setContacts(String contacts) {
                        this.contacts = contacts;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public Object getFax() {
                        return fax;
                    }

                    public void setFax(Object fax) {
                        this.fax = fax;
                    }

                    public Object getEmail() {
                        return email;
                    }

                    public void setEmail(Object email) {
                        this.email = email;
                    }

                    public Object getWebsite() {
                        return website;
                    }

                    public void setWebsite(Object website) {
                        this.website = website;
                    }

                    public StatusBeanXXXXXXXXX getStatus() {
                        return status;
                    }

                    public void setStatus(StatusBeanXXXXXXXXX status) {
                        this.status = status;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public String getAccountType() {
                        return accountType;
                    }

                    public void setAccountType(String accountType) {
                        this.accountType = accountType;
                    }

                    public Object getParentCompany() {
                        return parentCompany;
                    }

                    public void setParentCompany(Object parentCompany) {
                        this.parentCompany = parentCompany;
                    }

                    public Object getSuperviseCompany() {
                        return superviseCompany;
                    }

                    public void setSuperviseCompany(Object superviseCompany) {
                        this.superviseCompany = superviseCompany;
                    }

                    public boolean isTopCompany() {
                        return topCompany;
                    }

                    public void setTopCompany(boolean topCompany) {
                        this.topCompany = topCompany;
                    }

                    public boolean isAdminCompany() {
                        return adminCompany;
                    }

                    public void setAdminCompany(boolean adminCompany) {
                        this.adminCompany = adminCompany;
                    }

                    public String getNotes() {
                        return notes;
                    }

                    public void setNotes(String notes) {
                        this.notes = notes;
                    }

                    public Object getBankAccount() {
                        return bankAccount;
                    }

                    public void setBankAccount(Object bankAccount) {
                        this.bankAccount = bankAccount;
                    }

                    public Object getStreetAddress() {
                        return streetAddress;
                    }

                    public void setStreetAddress(Object streetAddress) {
                        this.streetAddress = streetAddress;
                    }

                    public static class CompanyTypeBeanXXX {
                        /**
                         * id : COMPANY_TYPE_1
                         * text : 建筑公司
                         * category : COMPANY_TYPE
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }

                    public static class LogoBeanXXX {
                        /**
                         * id : 84364
                         * host : http://jianzhugang.xzgapp.com
                         * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                         * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                         */

                        private int id;
                        private String host;
                        private String name;
                        private String url;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getHost() {
                            return host;
                        }

                        public void setHost(String host) {
                            this.host = host;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class TouxiangBeanXXX {
                        /**
                         * id : 84436
                         * host : http://jianzhugang.xzgapp.com
                         * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                         * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                         */

                        private int id;
                        private String host;
                        private String name;
                        private String url;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getHost() {
                            return host;
                        }

                        public void setHost(String host) {
                            this.host = host;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class StatusBeanXXXXXXXXX {
                        /**
                         * id : COMPANY_STATUS_NORMAL
                         * text : 正常
                         * category : COMPANY_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }
                }

                public static class TeamBeanX {
                    /**
                     * id : 84091
                     * teamType : {"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
                     * userName : 13071010127
                     * photo : {"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"}
                     * title : 熊大
                     * idNumber : 412825198905112011
                     * idFront : {"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"}
                     * skill : null
                     * phone : 13071010127
                     * address : 深圳福田
                     * bankInfo : null
                     * bankCardNo : null
                     * notes : asdasd
                     * nativePlace : null
                     * nation : null
                     * sinceTime : null
                     * gender : 男
                     * skillCertificate : null
                     * education : null
                     * birthday : null
                     * position : null
                     * certificate : null
                     * safe : false
                     * companyName : null
                     * capital : null
                     * legalPerson : null
                     * companyAddress : null
                     * xinyongCode : null
                     * cardFront : {"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"}
                     * startTime : null
                     * emergencyContacts : null
                     * emergencyPhone : null
                     * members : [{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}]
                     * projects : []
                     * starsLevel : null
                     * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     * district : null
                     * streetAddress : sadasd
                     * createTime : 2018-03-20 15:06:31
                     * bankAccount : null
                     * accountType : TEAM
                     * displayAddress :
                     * membersCount : 3
                     * viewPoint : null
                     * suid : null
                     */

                    private int id;
                    private TeamTypeBeanXX teamType;
                    private String userName;
                    private PhotoBeanX photo;
                    private String title;
                    private String idNumber;
                    private IdFrontBeanX idFront;
                    private Object skill;
                    private String phone;
                    private String address;
                    private Object bankInfo;
                    private Object bankCardNo;
                    private String notes;
                    private Object nativePlace;
                    private Object nation;
                    private Object sinceTime;
                    private String gender;
                    private Object skillCertificate;
                    private Object education;
                    private Object birthday;
                    private Object position;
                    private Object certificate;
                    private boolean safe;
                    private Object companyName;
                    private Object capital;
                    private Object legalPerson;
                    private Object companyAddress;
                    private Object xinyongCode;
                    private CardFrontBeanX cardFront;
                    private Object startTime;
                    private Object emergencyContacts;
                    private Object emergencyPhone;
                    private Object starsLevel;
                    private StatusBeanXXXXXXXXXX status;
                    private Object district;
                    private String streetAddress;
                    private String createTime;
                    private Object bankAccount;
                    private String accountType;
                    private String displayAddress;
                    private int membersCount;
                    private Object viewPoint;
                    private Object suid;
                    private List<MembersBeanX> members;
                    private List<?> projects;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public TeamTypeBeanXX getTeamType() {
                        return teamType;
                    }

                    public void setTeamType(TeamTypeBeanXX teamType) {
                        this.teamType = teamType;
                    }

                    public String getUserName() {
                        return userName;
                    }

                    public void setUserName(String userName) {
                        this.userName = userName;
                    }

                    public PhotoBeanX getPhoto() {
                        return photo;
                    }

                    public void setPhoto(PhotoBeanX photo) {
                        this.photo = photo;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public String getIdNumber() {
                        return idNumber;
                    }

                    public void setIdNumber(String idNumber) {
                        this.idNumber = idNumber;
                    }

                    public IdFrontBeanX getIdFront() {
                        return idFront;
                    }

                    public void setIdFront(IdFrontBeanX idFront) {
                        this.idFront = idFront;
                    }

                    public Object getSkill() {
                        return skill;
                    }

                    public void setSkill(Object skill) {
                        this.skill = skill;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }

                    public Object getBankInfo() {
                        return bankInfo;
                    }

                    public void setBankInfo(Object bankInfo) {
                        this.bankInfo = bankInfo;
                    }

                    public Object getBankCardNo() {
                        return bankCardNo;
                    }

                    public void setBankCardNo(Object bankCardNo) {
                        this.bankCardNo = bankCardNo;
                    }

                    public String getNotes() {
                        return notes;
                    }

                    public void setNotes(String notes) {
                        this.notes = notes;
                    }

                    public Object getNativePlace() {
                        return nativePlace;
                    }

                    public void setNativePlace(Object nativePlace) {
                        this.nativePlace = nativePlace;
                    }

                    public Object getNation() {
                        return nation;
                    }

                    public void setNation(Object nation) {
                        this.nation = nation;
                    }

                    public Object getSinceTime() {
                        return sinceTime;
                    }

                    public void setSinceTime(Object sinceTime) {
                        this.sinceTime = sinceTime;
                    }

                    public String getGender() {
                        return gender;
                    }

                    public void setGender(String gender) {
                        this.gender = gender;
                    }

                    public Object getSkillCertificate() {
                        return skillCertificate;
                    }

                    public void setSkillCertificate(Object skillCertificate) {
                        this.skillCertificate = skillCertificate;
                    }

                    public Object getEducation() {
                        return education;
                    }

                    public void setEducation(Object education) {
                        this.education = education;
                    }

                    public Object getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(Object birthday) {
                        this.birthday = birthday;
                    }

                    public Object getPosition() {
                        return position;
                    }

                    public void setPosition(Object position) {
                        this.position = position;
                    }

                    public Object getCertificate() {
                        return certificate;
                    }

                    public void setCertificate(Object certificate) {
                        this.certificate = certificate;
                    }

                    public boolean isSafe() {
                        return safe;
                    }

                    public void setSafe(boolean safe) {
                        this.safe = safe;
                    }

                    public Object getCompanyName() {
                        return companyName;
                    }

                    public void setCompanyName(Object companyName) {
                        this.companyName = companyName;
                    }

                    public Object getCapital() {
                        return capital;
                    }

                    public void setCapital(Object capital) {
                        this.capital = capital;
                    }

                    public Object getLegalPerson() {
                        return legalPerson;
                    }

                    public void setLegalPerson(Object legalPerson) {
                        this.legalPerson = legalPerson;
                    }

                    public Object getCompanyAddress() {
                        return companyAddress;
                    }

                    public void setCompanyAddress(Object companyAddress) {
                        this.companyAddress = companyAddress;
                    }

                    public Object getXinyongCode() {
                        return xinyongCode;
                    }

                    public void setXinyongCode(Object xinyongCode) {
                        this.xinyongCode = xinyongCode;
                    }

                    public CardFrontBeanX getCardFront() {
                        return cardFront;
                    }

                    public void setCardFront(CardFrontBeanX cardFront) {
                        this.cardFront = cardFront;
                    }

                    public Object getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(Object startTime) {
                        this.startTime = startTime;
                    }

                    public Object getEmergencyContacts() {
                        return emergencyContacts;
                    }

                    public void setEmergencyContacts(Object emergencyContacts) {
                        this.emergencyContacts = emergencyContacts;
                    }

                    public Object getEmergencyPhone() {
                        return emergencyPhone;
                    }

                    public void setEmergencyPhone(Object emergencyPhone) {
                        this.emergencyPhone = emergencyPhone;
                    }

                    public Object getStarsLevel() {
                        return starsLevel;
                    }

                    public void setStarsLevel(Object starsLevel) {
                        this.starsLevel = starsLevel;
                    }

                    public StatusBeanXXXXXXXXXX getStatus() {
                        return status;
                    }

                    public void setStatus(StatusBeanXXXXXXXXXX status) {
                        this.status = status;
                    }

                    public Object getDistrict() {
                        return district;
                    }

                    public void setDistrict(Object district) {
                        this.district = district;
                    }

                    public String getStreetAddress() {
                        return streetAddress;
                    }

                    public void setStreetAddress(String streetAddress) {
                        this.streetAddress = streetAddress;
                    }

                    public String getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(String createTime) {
                        this.createTime = createTime;
                    }

                    public Object getBankAccount() {
                        return bankAccount;
                    }

                    public void setBankAccount(Object bankAccount) {
                        this.bankAccount = bankAccount;
                    }

                    public String getAccountType() {
                        return accountType;
                    }

                    public void setAccountType(String accountType) {
                        this.accountType = accountType;
                    }

                    public String getDisplayAddress() {
                        return displayAddress;
                    }

                    public void setDisplayAddress(String displayAddress) {
                        this.displayAddress = displayAddress;
                    }

                    public int getMembersCount() {
                        return membersCount;
                    }

                    public void setMembersCount(int membersCount) {
                        this.membersCount = membersCount;
                    }

                    public Object getViewPoint() {
                        return viewPoint;
                    }

                    public void setViewPoint(Object viewPoint) {
                        this.viewPoint = viewPoint;
                    }

                    public Object getSuid() {
                        return suid;
                    }

                    public void setSuid(Object suid) {
                        this.suid = suid;
                    }

                    public List<MembersBeanX> getMembers() {
                        return members;
                    }

                    public void setMembers(List<MembersBeanX> members) {
                        this.members = members;
                    }

                    public List<?> getProjects() {
                        return projects;
                    }

                    public void setProjects(List<?> projects) {
                        this.projects = projects;
                    }

                    public static class TeamTypeBeanXX {
                        /**
                         * id : 20696
                         * title : 造价员
                         * regulation : null
                         * crafts : null
                         * quality : null
                         * category : {"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1}
                         * szTypeId : null
                         * msgIndex : 0
                         * libraryCount : 0
                         * status : 1
                         */

                        private int id;
                        private String title;
                        private Object regulation;
                        private Object crafts;
                        private Object quality;
                        private CategoryBeanXX category;
                        private Object szTypeId;
                        private int msgIndex;
                        private int libraryCount;
                        private int status;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public Object getRegulation() {
                            return regulation;
                        }

                        public void setRegulation(Object regulation) {
                            this.regulation = regulation;
                        }

                        public Object getCrafts() {
                            return crafts;
                        }

                        public void setCrafts(Object crafts) {
                            this.crafts = crafts;
                        }

                        public Object getQuality() {
                            return quality;
                        }

                        public void setQuality(Object quality) {
                            this.quality = quality;
                        }

                        public CategoryBeanXX getCategory() {
                            return category;
                        }

                        public void setCategory(CategoryBeanXX category) {
                            this.category = category;
                        }

                        public Object getSzTypeId() {
                            return szTypeId;
                        }

                        public void setSzTypeId(Object szTypeId) {
                            this.szTypeId = szTypeId;
                        }

                        public int getMsgIndex() {
                            return msgIndex;
                        }

                        public void setMsgIndex(int msgIndex) {
                            this.msgIndex = msgIndex;
                        }

                        public int getLibraryCount() {
                            return libraryCount;
                        }

                        public void setLibraryCount(int libraryCount) {
                            this.libraryCount = libraryCount;
                        }

                        public int getStatus() {
                            return status;
                        }

                        public void setStatus(int status) {
                            this.status = status;
                        }

                        public static class CategoryBeanXX {
                            /**
                             * id : GUANLI
                             * text : 管理
                             * category : TEAM_CATEGORY
                             * groupTitle : null
                             * system : true
                             * orderIndex : 1
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private int orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public int getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(int orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }
                    }

                    public static class PhotoBeanX {
                        /**
                         * id : 85766
                         * host : http://jianzhugang.xzgapp.com
                         * name : 3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                         * url : http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                         */

                        private int id;
                        private String host;
                        private String name;
                        private String url;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getHost() {
                            return host;
                        }

                        public void setHost(String host) {
                            this.host = host;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class IdFrontBeanX {
                        /**
                         * id : 84095
                         * host : http://jianzhugang.xzgapp.com
                         * name : 1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                         * url : http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                         */

                        private int id;
                        private String host;
                        private String name;
                        private String url;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getHost() {
                            return host;
                        }

                        public void setHost(String host) {
                            this.host = host;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class CardFrontBeanX {
                        /**
                         * id : 84096
                         * host : http://jianzhugang.xzgapp.com
                         * name : 5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                         * url : http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                         */

                        private int id;
                        private String host;
                        private String name;
                        private String url;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getHost() {
                            return host;
                        }

                        public void setHost(String host) {
                            this.host = host;
                        }

                        public String getName() {
                            return name;
                        }

                        public void setName(String name) {
                            this.name = name;
                        }

                        public String getUrl() {
                            return url;
                        }

                        public void setUrl(String url) {
                            this.url = url;
                        }
                    }

                    public static class StatusBeanXXXXXXXXXX {
                        /**
                         * id : TEAM_STATUS_NORMAL
                         * text : 正常
                         * category : TEAM_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }

                    public static class MembersBeanX {
                        /**
                         * id : 85479
                         * phone : 13071010127
                         * bankName : 工商银行
                         * cardNumber : 6222021702044210557
                         * title : hah
                         * gender : null
                         * nation : null
                         * birthday : 1989-05-11
                         * nativePlace : null
                         * idNumber : 412825198905112011
                         * position : null
                         * teamType : null
                         * certificate : null
                         * safe : false
                         * xueli : null
                         * gangqianPX : false
                         * idCardInfo : null
                         * shiduan : null
                         * peopleType : null
                         * workType : null
                         * haveContract : false
                         * idAgency : null
                         * idValiddate : null
                         * idphotoScan : null
                         * idPhoto : null
                         * facephoto : null
                         * idFront : null
                         * cardFront : null
                         * updateTime : 2018-04-18 17:49:35
                         * createTime : null
                         * status : {"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                         */

                        private int id;
                        private String phone;
                        private String bankName;
                        private String cardNumber;
                        private String title;
                        private Object gender;
                        private Object nation;
                        private String birthday;
                        private Object nativePlace;
                        private String idNumber;
                        private Object position;
                        private Object teamType;
                        private Object certificate;
                        private boolean safe;
                        private Object xueli;
                        private boolean gangqianPX;
                        private Object idCardInfo;
                        private Object shiduan;
                        private Object peopleType;
                        private Object workType;
                        private boolean haveContract;
                        private Object idAgency;
                        private Object idValiddate;
                        private Object idphotoScan;
                        private Object idPhoto;
                        private Object facephoto;
                        private Object idFront;
                        private Object cardFront;
                        private String updateTime;
                        private Object createTime;
                        private StatusBeanXXXXXXXXXXX status;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public String getBankName() {
                            return bankName;
                        }

                        public void setBankName(String bankName) {
                            this.bankName = bankName;
                        }

                        public String getCardNumber() {
                            return cardNumber;
                        }

                        public void setCardNumber(String cardNumber) {
                            this.cardNumber = cardNumber;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public Object getGender() {
                            return gender;
                        }

                        public void setGender(Object gender) {
                            this.gender = gender;
                        }

                        public Object getNation() {
                            return nation;
                        }

                        public void setNation(Object nation) {
                            this.nation = nation;
                        }

                        public String getBirthday() {
                            return birthday;
                        }

                        public void setBirthday(String birthday) {
                            this.birthday = birthday;
                        }

                        public Object getNativePlace() {
                            return nativePlace;
                        }

                        public void setNativePlace(Object nativePlace) {
                            this.nativePlace = nativePlace;
                        }

                        public String getIdNumber() {
                            return idNumber;
                        }

                        public void setIdNumber(String idNumber) {
                            this.idNumber = idNumber;
                        }

                        public Object getPosition() {
                            return position;
                        }

                        public void setPosition(Object position) {
                            this.position = position;
                        }

                        public Object getTeamType() {
                            return teamType;
                        }

                        public void setTeamType(Object teamType) {
                            this.teamType = teamType;
                        }

                        public Object getCertificate() {
                            return certificate;
                        }

                        public void setCertificate(Object certificate) {
                            this.certificate = certificate;
                        }

                        public boolean isSafe() {
                            return safe;
                        }

                        public void setSafe(boolean safe) {
                            this.safe = safe;
                        }

                        public Object getXueli() {
                            return xueli;
                        }

                        public void setXueli(Object xueli) {
                            this.xueli = xueli;
                        }

                        public boolean isGangqianPX() {
                            return gangqianPX;
                        }

                        public void setGangqianPX(boolean gangqianPX) {
                            this.gangqianPX = gangqianPX;
                        }

                        public Object getIdCardInfo() {
                            return idCardInfo;
                        }

                        public void setIdCardInfo(Object idCardInfo) {
                            this.idCardInfo = idCardInfo;
                        }

                        public Object getShiduan() {
                            return shiduan;
                        }

                        public void setShiduan(Object shiduan) {
                            this.shiduan = shiduan;
                        }

                        public Object getPeopleType() {
                            return peopleType;
                        }

                        public void setPeopleType(Object peopleType) {
                            this.peopleType = peopleType;
                        }

                        public Object getWorkType() {
                            return workType;
                        }

                        public void setWorkType(Object workType) {
                            this.workType = workType;
                        }

                        public boolean isHaveContract() {
                            return haveContract;
                        }

                        public void setHaveContract(boolean haveContract) {
                            this.haveContract = haveContract;
                        }

                        public Object getIdAgency() {
                            return idAgency;
                        }

                        public void setIdAgency(Object idAgency) {
                            this.idAgency = idAgency;
                        }

                        public Object getIdValiddate() {
                            return idValiddate;
                        }

                        public void setIdValiddate(Object idValiddate) {
                            this.idValiddate = idValiddate;
                        }

                        public Object getIdphotoScan() {
                            return idphotoScan;
                        }

                        public void setIdphotoScan(Object idphotoScan) {
                            this.idphotoScan = idphotoScan;
                        }

                        public Object getIdPhoto() {
                            return idPhoto;
                        }

                        public void setIdPhoto(Object idPhoto) {
                            this.idPhoto = idPhoto;
                        }

                        public Object getFacephoto() {
                            return facephoto;
                        }

                        public void setFacephoto(Object facephoto) {
                            this.facephoto = facephoto;
                        }

                        public Object getIdFront() {
                            return idFront;
                        }

                        public void setIdFront(Object idFront) {
                            this.idFront = idFront;
                        }

                        public Object getCardFront() {
                            return cardFront;
                        }

                        public void setCardFront(Object cardFront) {
                            this.cardFront = cardFront;
                        }

                        public String getUpdateTime() {
                            return updateTime;
                        }

                        public void setUpdateTime(String updateTime) {
                            this.updateTime = updateTime;
                        }

                        public Object getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(Object createTime) {
                            this.createTime = createTime;
                        }

                        public StatusBeanXXXXXXXXXXX getStatus() {
                            return status;
                        }

                        public void setStatus(StatusBeanXXXXXXXXXXX status) {
                            this.status = status;
                        }

                        public static class StatusBeanXXXXXXXXXXX {
                            /**
                             * id : MEMBER_HIDDEN
                             * text : 已移除
                             * category : MEMBER_STATUS
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }
                    }
                }

                public static class ProjectBeanX {
                    /**
                     * id : 84741
                     * status : {"id":"AUDITED","text":"已审核","category":"PROJECT_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     * buildingStatus : {"id":"PROJECT_BUILDING","text":"建设中","category":"PROJECT_BUILDING_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     * startTime : 2018-04-01 00:00:00
                     * endTime : 2018-10-01 00:00:00
                     * updateTime : 2018-04-12 15:02:11
                     * createTime : null
                     * name : 呃呃
                     * company : {"id":3120,"companyType":{"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null},"userName":"13426599742","title":"凌峰","logo":{"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"},"touxiang":{"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"},"organizationCode":"791202564","contacts":"吕佳伟","phone":"13426599742","fax":null,"email":null,"website":null,"status":{"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null},"createTime":null,"accountType":"COMPANY","parentCompany":null,"superviseCompany":null,"topCompany":false,"adminCompany":true,"notes":"null","bankAccount":null,"streetAddress":null}
                     * description : 123456789
                     * memo : null
                     * dcenterDesc : null
                     * district : {"id":1001,"title":"北京市","type":"CITY","parent":{"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null},"hotCity":null,"orderIndex":null}
                     * shortProjectName : null
                     * longitude : null
                     * latitude : null
                     * jianSheDW : null
                     * gongchengMC : null
                     * gongchengDZ : null
                     * shigongXKZ : null
                     * shigongDW : null
                     * jianliDW : null
                     * shejiDW : null
                     * contacts : ghh
                     * contactsPosition : null
                     * contactsPhone : 1562648507
                     * contactsEmail : null
                     * videoUrl : null
                     * yztProjectId : null
                     * displayAddress :
                     * streetAddress : 嘀嘀嘀
                     */

                    private int id;
                    private StatusBeanXXXXXXXXXXXX status;
                    private BuildingStatusBeanX buildingStatus;
                    private String startTime;
                    private String endTime;
                    private String updateTime;
                    private Object createTime;
                    private String name;
                    private CompanyBeanXXXX company;
                    private String description;
                    private Object memo;
                    private Object dcenterDesc;
                    private DistrictBeanX district;
                    private Object shortProjectName;
                    private Object longitude;
                    private Object latitude;
                    private Object jianSheDW;
                    private Object gongchengMC;
                    private Object gongchengDZ;
                    private Object shigongXKZ;
                    private Object shigongDW;
                    private Object jianliDW;
                    private Object shejiDW;
                    private String contacts;
                    private Object contactsPosition;
                    private String contactsPhone;
                    private Object contactsEmail;
                    private Object videoUrl;
                    private Object yztProjectId;
                    private String displayAddress;
                    private String streetAddress;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public StatusBeanXXXXXXXXXXXX getStatus() {
                        return status;
                    }

                    public void setStatus(StatusBeanXXXXXXXXXXXX status) {
                        this.status = status;
                    }

                    public BuildingStatusBeanX getBuildingStatus() {
                        return buildingStatus;
                    }

                    public void setBuildingStatus(BuildingStatusBeanX buildingStatus) {
                        this.buildingStatus = buildingStatus;
                    }

                    public String getStartTime() {
                        return startTime;
                    }

                    public void setStartTime(String startTime) {
                        this.startTime = startTime;
                    }

                    public String getEndTime() {
                        return endTime;
                    }

                    public void setEndTime(String endTime) {
                        this.endTime = endTime;
                    }

                    public String getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(String updateTime) {
                        this.updateTime = updateTime;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public CompanyBeanXXXX getCompany() {
                        return company;
                    }

                    public void setCompany(CompanyBeanXXXX company) {
                        this.company = company;
                    }

                    public String getDescription() {
                        return description;
                    }

                    public void setDescription(String description) {
                        this.description = description;
                    }

                    public Object getMemo() {
                        return memo;
                    }

                    public void setMemo(Object memo) {
                        this.memo = memo;
                    }

                    public Object getDcenterDesc() {
                        return dcenterDesc;
                    }

                    public void setDcenterDesc(Object dcenterDesc) {
                        this.dcenterDesc = dcenterDesc;
                    }

                    public DistrictBeanX getDistrict() {
                        return district;
                    }

                    public void setDistrict(DistrictBeanX district) {
                        this.district = district;
                    }

                    public Object getShortProjectName() {
                        return shortProjectName;
                    }

                    public void setShortProjectName(Object shortProjectName) {
                        this.shortProjectName = shortProjectName;
                    }

                    public Object getLongitude() {
                        return longitude;
                    }

                    public void setLongitude(Object longitude) {
                        this.longitude = longitude;
                    }

                    public Object getLatitude() {
                        return latitude;
                    }

                    public void setLatitude(Object latitude) {
                        this.latitude = latitude;
                    }

                    public Object getJianSheDW() {
                        return jianSheDW;
                    }

                    public void setJianSheDW(Object jianSheDW) {
                        this.jianSheDW = jianSheDW;
                    }

                    public Object getGongchengMC() {
                        return gongchengMC;
                    }

                    public void setGongchengMC(Object gongchengMC) {
                        this.gongchengMC = gongchengMC;
                    }

                    public Object getGongchengDZ() {
                        return gongchengDZ;
                    }

                    public void setGongchengDZ(Object gongchengDZ) {
                        this.gongchengDZ = gongchengDZ;
                    }

                    public Object getShigongXKZ() {
                        return shigongXKZ;
                    }

                    public void setShigongXKZ(Object shigongXKZ) {
                        this.shigongXKZ = shigongXKZ;
                    }

                    public Object getShigongDW() {
                        return shigongDW;
                    }

                    public void setShigongDW(Object shigongDW) {
                        this.shigongDW = shigongDW;
                    }

                    public Object getJianliDW() {
                        return jianliDW;
                    }

                    public void setJianliDW(Object jianliDW) {
                        this.jianliDW = jianliDW;
                    }

                    public Object getShejiDW() {
                        return shejiDW;
                    }

                    public void setShejiDW(Object shejiDW) {
                        this.shejiDW = shejiDW;
                    }

                    public String getContacts() {
                        return contacts;
                    }

                    public void setContacts(String contacts) {
                        this.contacts = contacts;
                    }

                    public Object getContactsPosition() {
                        return contactsPosition;
                    }

                    public void setContactsPosition(Object contactsPosition) {
                        this.contactsPosition = contactsPosition;
                    }

                    public String getContactsPhone() {
                        return contactsPhone;
                    }

                    public void setContactsPhone(String contactsPhone) {
                        this.contactsPhone = contactsPhone;
                    }

                    public Object getContactsEmail() {
                        return contactsEmail;
                    }

                    public void setContactsEmail(Object contactsEmail) {
                        this.contactsEmail = contactsEmail;
                    }

                    public Object getVideoUrl() {
                        return videoUrl;
                    }

                    public void setVideoUrl(Object videoUrl) {
                        this.videoUrl = videoUrl;
                    }

                    public Object getYztProjectId() {
                        return yztProjectId;
                    }

                    public void setYztProjectId(Object yztProjectId) {
                        this.yztProjectId = yztProjectId;
                    }

                    public String getDisplayAddress() {
                        return displayAddress;
                    }

                    public void setDisplayAddress(String displayAddress) {
                        this.displayAddress = displayAddress;
                    }

                    public String getStreetAddress() {
                        return streetAddress;
                    }

                    public void setStreetAddress(String streetAddress) {
                        this.streetAddress = streetAddress;
                    }

                    public static class StatusBeanXXXXXXXXXXXX {
                        /**
                         * id : AUDITED
                         * text : 已审核
                         * category : PROJECT_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }

                    public static class BuildingStatusBeanX {
                        /**
                         * id : PROJECT_BUILDING
                         * text : 建设中
                         * category : PROJECT_BUILDING_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }

                    public static class CompanyBeanXXXX {
                        /**
                         * id : 3120
                         * companyType : {"id":"COMPANY_TYPE_1","text":"建筑公司","category":"COMPANY_TYPE","groupTitle":null,"system":true,"orderIndex":null}
                         * userName : 13426599742
                         * title : 凌峰
                         * logo : {"id":84364,"host":"http://jianzhugang.xzgapp.com","name":"c11df485-8638-4c31-bc27-10f3aab3d39a.jpg","url":"http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg"}
                         * touxiang : {"id":84436,"host":"http://jianzhugang.xzgapp.com","name":"57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg","url":"http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg"}
                         * organizationCode : 791202564
                         * contacts : 吕佳伟
                         * phone : 13426599742
                         * fax : null
                         * email : null
                         * website : null
                         * status : {"id":"COMPANY_STATUS_NORMAL","text":"正常","category":"COMPANY_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                         * createTime : null
                         * accountType : COMPANY
                         * parentCompany : null
                         * superviseCompany : null
                         * topCompany : false
                         * adminCompany : true
                         * notes : null
                         * bankAccount : null
                         * streetAddress : null
                         */

                        private int id;
                        private CompanyTypeBeanXXXX companyType;
                        private String userName;
                        private String title;
                        private LogoBeanXXXX logo;
                        private TouxiangBeanXXXX touxiang;
                        private String organizationCode;
                        private String contacts;
                        private String phone;
                        private Object fax;
                        private Object email;
                        private Object website;
                        private StatusBeanXXXXXXXXXXXXX status;
                        private Object createTime;
                        private String accountType;
                        private Object parentCompany;
                        private Object superviseCompany;
                        private boolean topCompany;
                        private boolean adminCompany;
                        private String notes;
                        private Object bankAccount;
                        private Object streetAddress;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public CompanyTypeBeanXXXX getCompanyType() {
                            return companyType;
                        }

                        public void setCompanyType(CompanyTypeBeanXXXX companyType) {
                            this.companyType = companyType;
                        }

                        public String getUserName() {
                            return userName;
                        }

                        public void setUserName(String userName) {
                            this.userName = userName;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public LogoBeanXXXX getLogo() {
                            return logo;
                        }

                        public void setLogo(LogoBeanXXXX logo) {
                            this.logo = logo;
                        }

                        public TouxiangBeanXXXX getTouxiang() {
                            return touxiang;
                        }

                        public void setTouxiang(TouxiangBeanXXXX touxiang) {
                            this.touxiang = touxiang;
                        }

                        public String getOrganizationCode() {
                            return organizationCode;
                        }

                        public void setOrganizationCode(String organizationCode) {
                            this.organizationCode = organizationCode;
                        }

                        public String getContacts() {
                            return contacts;
                        }

                        public void setContacts(String contacts) {
                            this.contacts = contacts;
                        }

                        public String getPhone() {
                            return phone;
                        }

                        public void setPhone(String phone) {
                            this.phone = phone;
                        }

                        public Object getFax() {
                            return fax;
                        }

                        public void setFax(Object fax) {
                            this.fax = fax;
                        }

                        public Object getEmail() {
                            return email;
                        }

                        public void setEmail(Object email) {
                            this.email = email;
                        }

                        public Object getWebsite() {
                            return website;
                        }

                        public void setWebsite(Object website) {
                            this.website = website;
                        }

                        public StatusBeanXXXXXXXXXXXXX getStatus() {
                            return status;
                        }

                        public void setStatus(StatusBeanXXXXXXXXXXXXX status) {
                            this.status = status;
                        }

                        public Object getCreateTime() {
                            return createTime;
                        }

                        public void setCreateTime(Object createTime) {
                            this.createTime = createTime;
                        }

                        public String getAccountType() {
                            return accountType;
                        }

                        public void setAccountType(String accountType) {
                            this.accountType = accountType;
                        }

                        public Object getParentCompany() {
                            return parentCompany;
                        }

                        public void setParentCompany(Object parentCompany) {
                            this.parentCompany = parentCompany;
                        }

                        public Object getSuperviseCompany() {
                            return superviseCompany;
                        }

                        public void setSuperviseCompany(Object superviseCompany) {
                            this.superviseCompany = superviseCompany;
                        }

                        public boolean isTopCompany() {
                            return topCompany;
                        }

                        public void setTopCompany(boolean topCompany) {
                            this.topCompany = topCompany;
                        }

                        public boolean isAdminCompany() {
                            return adminCompany;
                        }

                        public void setAdminCompany(boolean adminCompany) {
                            this.adminCompany = adminCompany;
                        }

                        public String getNotes() {
                            return notes;
                        }

                        public void setNotes(String notes) {
                            this.notes = notes;
                        }

                        public Object getBankAccount() {
                            return bankAccount;
                        }

                        public void setBankAccount(Object bankAccount) {
                            this.bankAccount = bankAccount;
                        }

                        public Object getStreetAddress() {
                            return streetAddress;
                        }

                        public void setStreetAddress(Object streetAddress) {
                            this.streetAddress = streetAddress;
                        }

                        public static class CompanyTypeBeanXXXX {
                            /**
                             * id : COMPANY_TYPE_1
                             * text : 建筑公司
                             * category : COMPANY_TYPE
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }

                        public static class LogoBeanXXXX {
                            /**
                             * id : 84364
                             * host : http://jianzhugang.xzgapp.com
                             * name : c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                             * url : http://jianzhugang.xzgapp.com/c11df485-8638-4c31-bc27-10f3aab3d39a.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class TouxiangBeanXXXX {
                            /**
                             * id : 84436
                             * host : http://jianzhugang.xzgapp.com
                             * name : 57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                             * url : http://jianzhugang.xzgapp.com/57c6f5e0-f2e1-49ca-bce3-4eae44ca9216.jpg
                             */

                            private int id;
                            private String host;
                            private String name;
                            private String url;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getHost() {
                                return host;
                            }

                            public void setHost(String host) {
                                this.host = host;
                            }

                            public String getName() {
                                return name;
                            }

                            public void setName(String name) {
                                this.name = name;
                            }

                            public String getUrl() {
                                return url;
                            }

                            public void setUrl(String url) {
                                this.url = url;
                            }
                        }

                        public static class StatusBeanXXXXXXXXXXXXX {
                            /**
                             * id : COMPANY_STATUS_NORMAL
                             * text : 正常
                             * category : COMPANY_STATUS
                             * groupTitle : null
                             * system : true
                             * orderIndex : null
                             */

                            private String id;
                            private String text;
                            private String category;
                            private Object groupTitle;
                            private boolean system;
                            private Object orderIndex;

                            public String getId() {
                                return id;
                            }

                            public void setId(String id) {
                                this.id = id;
                            }

                            public String getText() {
                                return text;
                            }

                            public void setText(String text) {
                                this.text = text;
                            }

                            public String getCategory() {
                                return category;
                            }

                            public void setCategory(String category) {
                                this.category = category;
                            }

                            public Object getGroupTitle() {
                                return groupTitle;
                            }

                            public void setGroupTitle(Object groupTitle) {
                                this.groupTitle = groupTitle;
                            }

                            public boolean isSystem() {
                                return system;
                            }

                            public void setSystem(boolean system) {
                                this.system = system;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }
                    }

                    public static class DistrictBeanX {
                        /**
                         * id : 1001
                         * title : 北京市
                         * type : CITY
                         * parent : {"id":1,"title":"北京市","type":"PROVINCE","parent":null,"hotCity":null,"orderIndex":null}
                         * hotCity : null
                         * orderIndex : null
                         */

                        private int id;
                        private String title;
                        private String type;
                        private ParentBeanX parent;
                        private Object hotCity;
                        private Object orderIndex;

                        public int getId() {
                            return id;
                        }

                        public void setId(int id) {
                            this.id = id;
                        }

                        public String getTitle() {
                            return title;
                        }

                        public void setTitle(String title) {
                            this.title = title;
                        }

                        public String getType() {
                            return type;
                        }

                        public void setType(String type) {
                            this.type = type;
                        }

                        public ParentBeanX getParent() {
                            return parent;
                        }

                        public void setParent(ParentBeanX parent) {
                            this.parent = parent;
                        }

                        public Object getHotCity() {
                            return hotCity;
                        }

                        public void setHotCity(Object hotCity) {
                            this.hotCity = hotCity;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }

                        public static class ParentBeanX {
                            /**
                             * id : 1
                             * title : 北京市
                             * type : PROVINCE
                             * parent : null
                             * hotCity : null
                             * orderIndex : null
                             */

                            private int id;
                            private String title;
                            private String type;
                            private Object parent;
                            private Object hotCity;
                            private Object orderIndex;

                            public int getId() {
                                return id;
                            }

                            public void setId(int id) {
                                this.id = id;
                            }

                            public String getTitle() {
                                return title;
                            }

                            public void setTitle(String title) {
                                this.title = title;
                            }

                            public String getType() {
                                return type;
                            }

                            public void setType(String type) {
                                this.type = type;
                            }

                            public Object getParent() {
                                return parent;
                            }

                            public void setParent(Object parent) {
                                this.parent = parent;
                            }

                            public Object getHotCity() {
                                return hotCity;
                            }

                            public void setHotCity(Object hotCity) {
                                this.hotCity = hotCity;
                            }

                            public Object getOrderIndex() {
                                return orderIndex;
                            }

                            public void setOrderIndex(Object orderIndex) {
                                this.orderIndex = orderIndex;
                            }
                        }
                    }
                }
            }

            public static class StatusBeanXXXXXXXXXXXXXX {
                /**
                 * id : ORDER_STATUS_SUBMITED
                 * text : 已提交
                 * category : ORDER_STATUS
                 * groupTitle : null
                 * system : true
                 * orderIndex : null
                 */

                private String id;
                private String text;
                private String category;
                private Object groupTitle;
                private boolean system;
                private Object orderIndex;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public Object getGroupTitle() {
                    return groupTitle;
                }

                public void setGroupTitle(Object groupTitle) {
                    this.groupTitle = groupTitle;
                }

                public boolean isSystem() {
                    return system;
                }

                public void setSystem(boolean system) {
                    this.system = system;
                }

                public Object getOrderIndex() {
                    return orderIndex;
                }

                public void setOrderIndex(Object orderIndex) {
                    this.orderIndex = orderIndex;
                }
            }

            public static class TeamBeanXX {
                /**
                 * id : 84091
                 * teamType : {"id":20696,"title":"造价员","regulation":null,"crafts":null,"quality":null,"category":{"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1},"szTypeId":null,"msgIndex":0,"libraryCount":0,"status":1}
                 * userName : 13071010127
                 * photo : {"id":85766,"host":"http://jianzhugang.xzgapp.com","name":"3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg","url":"http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg"}
                 * title : 熊大
                 * idNumber : 412825198905112011
                 * idFront : {"id":84095,"host":"http://jianzhugang.xzgapp.com","name":"1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg","url":"http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg"}
                 * skill : null
                 * phone : 13071010127
                 * address : 深圳福田
                 * bankInfo : null
                 * bankCardNo : null
                 * notes : asdasd
                 * nativePlace : null
                 * nation : null
                 * sinceTime : null
                 * gender : 男
                 * skillCertificate : null
                 * education : null
                 * birthday : null
                 * position : null
                 * certificate : null
                 * safe : false
                 * companyName : null
                 * capital : null
                 * legalPerson : null
                 * companyAddress : null
                 * xinyongCode : null
                 * cardFront : {"id":84096,"host":"http://jianzhugang.xzgapp.com","name":"5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg","url":"http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg"}
                 * startTime : null
                 * emergencyContacts : null
                 * emergencyPhone : null
                 * members : [{"id":85479,"phone":"13071010127","bankName":"工商银行","cardNumber":"6222021702044210557","title":"hah","gender":null,"nation":null,"birthday":"1989-05-11","nativePlace":null,"idNumber":"412825198905112011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:35","createTime":null,"status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85503,"phone":"13927258029","bankName":"工商银行","cardNumber":"6217907000022253692","title":"刘俊威","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280014","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:45","createTime":"2018-04-13 19:29:36","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85504,"phone":"18720295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1997-03-15","nativePlace":null,"idNumber":"362203199703151224","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:37","createTime":"2018-04-13 19:31:32","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85784,"phone":"18720295614","bankName":"工商银行","cardNumber":"6212264100011335373","title":"刘某某","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280011","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-17 17:46:33","createTime":"2018-04-17 17:46:33","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85785,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280013","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:38","createTime":"2018-04-17 17:53:44","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85786,"phone":"18720295614","bankName":"平安银行","cardNumber":"6212264100011335373","title":"溜溜","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280019","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:48:56","createTime":"2018-04-17 17:56:46","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85787,"phone":"13927258029","bankName":"工商银行","cardNumber":"6212264100011335373","title":"呵呵","gender":null,"nation":null,"birthday":"1991-03-28","nativePlace":null,"idNumber":"445222199103280015","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:49:39","createTime":"2018-04-17 18:03:48","status":{"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}},{"id":85861,"phone":"18750295614","bankName":"建设银行","cardNumber":"6212264100011335373","title":"熊","gender":null,"nation":null,"birthday":"1997-03-19","nativePlace":null,"idNumber":"362203199703191223","position":null,"teamType":null,"certificate":null,"safe":false,"xueli":null,"gangqianPX":false,"idCardInfo":null,"shiduan":null,"peopleType":null,"workType":null,"haveContract":false,"idAgency":null,"idValiddate":null,"idphotoScan":null,"idPhoto":null,"facephoto":null,"idFront":null,"cardFront":null,"updateTime":"2018-04-18 17:50:50","createTime":"2018-04-18 17:50:50","status":{"id":"MEMBER_SHOW","text":"已添加","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}}]
                 * projects : []
                 * starsLevel : null
                 * status : {"id":"TEAM_STATUS_NORMAL","text":"正常","category":"TEAM_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                 * district : null
                 * streetAddress : sadasd
                 * createTime : 2018-03-20 15:06:31
                 * bankAccount : null
                 * accountType : TEAM
                 * displayAddress :
                 * membersCount : 3
                 * viewPoint : null
                 * suid : null
                 */

                private int id;
                private TeamTypeBeanXXX teamType;
                private String userName;
                private PhotoBeanXX photo;
                private String title;
                private String idNumber;
                private IdFrontBeanXX idFront;
                private Object skill;
                private String phone;
                private String address;
                private Object bankInfo;
                private Object bankCardNo;
                private String notes;
                private Object nativePlace;
                private Object nation;
                private Object sinceTime;
                private String gender;
                private Object skillCertificate;
                private Object education;
                private Object birthday;
                private Object position;
                private Object certificate;
                private boolean safe;
                private Object companyName;
                private Object capital;
                private Object legalPerson;
                private Object companyAddress;
                private Object xinyongCode;
                private CardFrontBeanXX cardFront;
                private Object startTime;
                private Object emergencyContacts;
                private Object emergencyPhone;
                private Object starsLevel;
                private StatusBeanXXXXXXXXXXXXXXX status;
                private Object district;
                private String streetAddress;
                private String createTime;
                private Object bankAccount;
                private String accountType;
                private String displayAddress;
                private int membersCount;
                private Object viewPoint;
                private Object suid;
                private List<MembersBeanXX> members;
                private List<?> projects;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public TeamTypeBeanXXX getTeamType() {
                    return teamType;
                }

                public void setTeamType(TeamTypeBeanXXX teamType) {
                    this.teamType = teamType;
                }

                public String getUserName() {
                    return userName;
                }

                public void setUserName(String userName) {
                    this.userName = userName;
                }

                public PhotoBeanXX getPhoto() {
                    return photo;
                }

                public void setPhoto(PhotoBeanXX photo) {
                    this.photo = photo;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getIdNumber() {
                    return idNumber;
                }

                public void setIdNumber(String idNumber) {
                    this.idNumber = idNumber;
                }

                public IdFrontBeanXX getIdFront() {
                    return idFront;
                }

                public void setIdFront(IdFrontBeanXX idFront) {
                    this.idFront = idFront;
                }

                public Object getSkill() {
                    return skill;
                }

                public void setSkill(Object skill) {
                    this.skill = skill;
                }

                public String getPhone() {
                    return phone;
                }

                public void setPhone(String phone) {
                    this.phone = phone;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public Object getBankInfo() {
                    return bankInfo;
                }

                public void setBankInfo(Object bankInfo) {
                    this.bankInfo = bankInfo;
                }

                public Object getBankCardNo() {
                    return bankCardNo;
                }

                public void setBankCardNo(Object bankCardNo) {
                    this.bankCardNo = bankCardNo;
                }

                public String getNotes() {
                    return notes;
                }

                public void setNotes(String notes) {
                    this.notes = notes;
                }

                public Object getNativePlace() {
                    return nativePlace;
                }

                public void setNativePlace(Object nativePlace) {
                    this.nativePlace = nativePlace;
                }

                public Object getNation() {
                    return nation;
                }

                public void setNation(Object nation) {
                    this.nation = nation;
                }

                public Object getSinceTime() {
                    return sinceTime;
                }

                public void setSinceTime(Object sinceTime) {
                    this.sinceTime = sinceTime;
                }

                public String getGender() {
                    return gender;
                }

                public void setGender(String gender) {
                    this.gender = gender;
                }

                public Object getSkillCertificate() {
                    return skillCertificate;
                }

                public void setSkillCertificate(Object skillCertificate) {
                    this.skillCertificate = skillCertificate;
                }

                public Object getEducation() {
                    return education;
                }

                public void setEducation(Object education) {
                    this.education = education;
                }

                public Object getBirthday() {
                    return birthday;
                }

                public void setBirthday(Object birthday) {
                    this.birthday = birthday;
                }

                public Object getPosition() {
                    return position;
                }

                public void setPosition(Object position) {
                    this.position = position;
                }

                public Object getCertificate() {
                    return certificate;
                }

                public void setCertificate(Object certificate) {
                    this.certificate = certificate;
                }

                public boolean isSafe() {
                    return safe;
                }

                public void setSafe(boolean safe) {
                    this.safe = safe;
                }

                public Object getCompanyName() {
                    return companyName;
                }

                public void setCompanyName(Object companyName) {
                    this.companyName = companyName;
                }

                public Object getCapital() {
                    return capital;
                }

                public void setCapital(Object capital) {
                    this.capital = capital;
                }

                public Object getLegalPerson() {
                    return legalPerson;
                }

                public void setLegalPerson(Object legalPerson) {
                    this.legalPerson = legalPerson;
                }

                public Object getCompanyAddress() {
                    return companyAddress;
                }

                public void setCompanyAddress(Object companyAddress) {
                    this.companyAddress = companyAddress;
                }

                public Object getXinyongCode() {
                    return xinyongCode;
                }

                public void setXinyongCode(Object xinyongCode) {
                    this.xinyongCode = xinyongCode;
                }

                public CardFrontBeanXX getCardFront() {
                    return cardFront;
                }

                public void setCardFront(CardFrontBeanXX cardFront) {
                    this.cardFront = cardFront;
                }

                public Object getStartTime() {
                    return startTime;
                }

                public void setStartTime(Object startTime) {
                    this.startTime = startTime;
                }

                public Object getEmergencyContacts() {
                    return emergencyContacts;
                }

                public void setEmergencyContacts(Object emergencyContacts) {
                    this.emergencyContacts = emergencyContacts;
                }

                public Object getEmergencyPhone() {
                    return emergencyPhone;
                }

                public void setEmergencyPhone(Object emergencyPhone) {
                    this.emergencyPhone = emergencyPhone;
                }

                public Object getStarsLevel() {
                    return starsLevel;
                }

                public void setStarsLevel(Object starsLevel) {
                    this.starsLevel = starsLevel;
                }

                public StatusBeanXXXXXXXXXXXXXXX getStatus() {
                    return status;
                }

                public void setStatus(StatusBeanXXXXXXXXXXXXXXX status) {
                    this.status = status;
                }

                public Object getDistrict() {
                    return district;
                }

                public void setDistrict(Object district) {
                    this.district = district;
                }

                public String getStreetAddress() {
                    return streetAddress;
                }

                public void setStreetAddress(String streetAddress) {
                    this.streetAddress = streetAddress;
                }

                public String getCreateTime() {
                    return createTime;
                }

                public void setCreateTime(String createTime) {
                    this.createTime = createTime;
                }

                public Object getBankAccount() {
                    return bankAccount;
                }

                public void setBankAccount(Object bankAccount) {
                    this.bankAccount = bankAccount;
                }

                public String getAccountType() {
                    return accountType;
                }

                public void setAccountType(String accountType) {
                    this.accountType = accountType;
                }

                public String getDisplayAddress() {
                    return displayAddress;
                }

                public void setDisplayAddress(String displayAddress) {
                    this.displayAddress = displayAddress;
                }

                public int getMembersCount() {
                    return membersCount;
                }

                public void setMembersCount(int membersCount) {
                    this.membersCount = membersCount;
                }

                public Object getViewPoint() {
                    return viewPoint;
                }

                public void setViewPoint(Object viewPoint) {
                    this.viewPoint = viewPoint;
                }

                public Object getSuid() {
                    return suid;
                }

                public void setSuid(Object suid) {
                    this.suid = suid;
                }

                public List<MembersBeanXX> getMembers() {
                    return members;
                }

                public void setMembers(List<MembersBeanXX> members) {
                    this.members = members;
                }

                public List<?> getProjects() {
                    return projects;
                }

                public void setProjects(List<?> projects) {
                    this.projects = projects;
                }

                public static class TeamTypeBeanXXX {
                    /**
                     * id : 20696
                     * title : 造价员
                     * regulation : null
                     * crafts : null
                     * quality : null
                     * category : {"id":"GUANLI","text":"管理","category":"TEAM_CATEGORY","groupTitle":null,"system":true,"orderIndex":1}
                     * szTypeId : null
                     * msgIndex : 0
                     * libraryCount : 0
                     * status : 1
                     */

                    private int id;
                    private String title;
                    private Object regulation;
                    private Object crafts;
                    private Object quality;
                    private CategoryBeanXXX category;
                    private Object szTypeId;
                    private int msgIndex;
                    private int libraryCount;
                    private int status;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Object getRegulation() {
                        return regulation;
                    }

                    public void setRegulation(Object regulation) {
                        this.regulation = regulation;
                    }

                    public Object getCrafts() {
                        return crafts;
                    }

                    public void setCrafts(Object crafts) {
                        this.crafts = crafts;
                    }

                    public Object getQuality() {
                        return quality;
                    }

                    public void setQuality(Object quality) {
                        this.quality = quality;
                    }

                    public CategoryBeanXXX getCategory() {
                        return category;
                    }

                    public void setCategory(CategoryBeanXXX category) {
                        this.category = category;
                    }

                    public Object getSzTypeId() {
                        return szTypeId;
                    }

                    public void setSzTypeId(Object szTypeId) {
                        this.szTypeId = szTypeId;
                    }

                    public int getMsgIndex() {
                        return msgIndex;
                    }

                    public void setMsgIndex(int msgIndex) {
                        this.msgIndex = msgIndex;
                    }

                    public int getLibraryCount() {
                        return libraryCount;
                    }

                    public void setLibraryCount(int libraryCount) {
                        this.libraryCount = libraryCount;
                    }

                    public int getStatus() {
                        return status;
                    }

                    public void setStatus(int status) {
                        this.status = status;
                    }

                    public static class CategoryBeanXXX {
                        /**
                         * id : GUANLI
                         * text : 管理
                         * category : TEAM_CATEGORY
                         * groupTitle : null
                         * system : true
                         * orderIndex : 1
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private int orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public int getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(int orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }
                }

                public static class PhotoBeanXX {
                    /**
                     * id : 85766
                     * host : http://jianzhugang.xzgapp.com
                     * name : 3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                     * url : http://jianzhugang.xzgapp.com/3356d2e4-cdf7-4bf5-9bd8-d22714371b9c.jpg
                     */

                    private int id;
                    private String host;
                    private String name;
                    private String url;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getHost() {
                        return host;
                    }

                    public void setHost(String host) {
                        this.host = host;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class IdFrontBeanXX {
                    /**
                     * id : 84095
                     * host : http://jianzhugang.xzgapp.com
                     * name : 1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                     * url : http://jianzhugang.xzgapp.com/1afbfe1e-0f24-44d3-ae43-6e91cdafec40.jpg
                     */

                    private int id;
                    private String host;
                    private String name;
                    private String url;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getHost() {
                        return host;
                    }

                    public void setHost(String host) {
                        this.host = host;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class CardFrontBeanXX {
                    /**
                     * id : 84096
                     * host : http://jianzhugang.xzgapp.com
                     * name : 5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                     * url : http://jianzhugang.xzgapp.com/5fe5507e-5cae-4ea7-a771-fe6dd4f7b058.jpg
                     */

                    private int id;
                    private String host;
                    private String name;
                    private String url;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getHost() {
                        return host;
                    }

                    public void setHost(String host) {
                        this.host = host;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }
                }

                public static class StatusBeanXXXXXXXXXXXXXXX {
                    /**
                     * id : TEAM_STATUS_NORMAL
                     * text : 正常
                     * category : TEAM_STATUS
                     * groupTitle : null
                     * system : true
                     * orderIndex : null
                     */

                    private String id;
                    private String text;
                    private String category;
                    private Object groupTitle;
                    private boolean system;
                    private Object orderIndex;

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getText() {
                        return text;
                    }

                    public void setText(String text) {
                        this.text = text;
                    }

                    public String getCategory() {
                        return category;
                    }

                    public void setCategory(String category) {
                        this.category = category;
                    }

                    public Object getGroupTitle() {
                        return groupTitle;
                    }

                    public void setGroupTitle(Object groupTitle) {
                        this.groupTitle = groupTitle;
                    }

                    public boolean isSystem() {
                        return system;
                    }

                    public void setSystem(boolean system) {
                        this.system = system;
                    }

                    public Object getOrderIndex() {
                        return orderIndex;
                    }

                    public void setOrderIndex(Object orderIndex) {
                        this.orderIndex = orderIndex;
                    }
                }

                public static class MembersBeanXX {
                    /**
                     * id : 85479
                     * phone : 13071010127
                     * bankName : 工商银行
                     * cardNumber : 6222021702044210557
                     * title : hah
                     * gender : null
                     * nation : null
                     * birthday : 1989-05-11
                     * nativePlace : null
                     * idNumber : 412825198905112011
                     * position : null
                     * teamType : null
                     * certificate : null
                     * safe : false
                     * xueli : null
                     * gangqianPX : false
                     * idCardInfo : null
                     * shiduan : null
                     * peopleType : null
                     * workType : null
                     * haveContract : false
                     * idAgency : null
                     * idValiddate : null
                     * idphotoScan : null
                     * idPhoto : null
                     * facephoto : null
                     * idFront : null
                     * cardFront : null
                     * updateTime : 2018-04-18 17:49:35
                     * createTime : null
                     * status : {"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
                     */

                    private int id;
                    private String phone;
                    private String bankName;
                    private String cardNumber;
                    private String title;
                    private Object gender;
                    private Object nation;
                    private String birthday;
                    private Object nativePlace;
                    private String idNumber;
                    private Object position;
                    private Object teamType;
                    private Object certificate;
                    private boolean safe;
                    private Object xueli;
                    private boolean gangqianPX;
                    private Object idCardInfo;
                    private Object shiduan;
                    private Object peopleType;
                    private Object workType;
                    private boolean haveContract;
                    private Object idAgency;
                    private Object idValiddate;
                    private Object idphotoScan;
                    private Object idPhoto;
                    private Object facephoto;
                    private Object idFront;
                    private Object cardFront;
                    private String updateTime;
                    private Object createTime;
                    private StatusBeanXXXXXXXXXXXXXXXX status;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getPhone() {
                        return phone;
                    }

                    public void setPhone(String phone) {
                        this.phone = phone;
                    }

                    public String getBankName() {
                        return bankName;
                    }

                    public void setBankName(String bankName) {
                        this.bankName = bankName;
                    }

                    public String getCardNumber() {
                        return cardNumber;
                    }

                    public void setCardNumber(String cardNumber) {
                        this.cardNumber = cardNumber;
                    }

                    public String getTitle() {
                        return title;
                    }

                    public void setTitle(String title) {
                        this.title = title;
                    }

                    public Object getGender() {
                        return gender;
                    }

                    public void setGender(Object gender) {
                        this.gender = gender;
                    }

                    public Object getNation() {
                        return nation;
                    }

                    public void setNation(Object nation) {
                        this.nation = nation;
                    }

                    public String getBirthday() {
                        return birthday;
                    }

                    public void setBirthday(String birthday) {
                        this.birthday = birthday;
                    }

                    public Object getNativePlace() {
                        return nativePlace;
                    }

                    public void setNativePlace(Object nativePlace) {
                        this.nativePlace = nativePlace;
                    }

                    public String getIdNumber() {
                        return idNumber;
                    }

                    public void setIdNumber(String idNumber) {
                        this.idNumber = idNumber;
                    }

                    public Object getPosition() {
                        return position;
                    }

                    public void setPosition(Object position) {
                        this.position = position;
                    }

                    public Object getTeamType() {
                        return teamType;
                    }

                    public void setTeamType(Object teamType) {
                        this.teamType = teamType;
                    }

                    public Object getCertificate() {
                        return certificate;
                    }

                    public void setCertificate(Object certificate) {
                        this.certificate = certificate;
                    }

                    public boolean isSafe() {
                        return safe;
                    }

                    public void setSafe(boolean safe) {
                        this.safe = safe;
                    }

                    public Object getXueli() {
                        return xueli;
                    }

                    public void setXueli(Object xueli) {
                        this.xueli = xueli;
                    }

                    public boolean isGangqianPX() {
                        return gangqianPX;
                    }

                    public void setGangqianPX(boolean gangqianPX) {
                        this.gangqianPX = gangqianPX;
                    }

                    public Object getIdCardInfo() {
                        return idCardInfo;
                    }

                    public void setIdCardInfo(Object idCardInfo) {
                        this.idCardInfo = idCardInfo;
                    }

                    public Object getShiduan() {
                        return shiduan;
                    }

                    public void setShiduan(Object shiduan) {
                        this.shiduan = shiduan;
                    }

                    public Object getPeopleType() {
                        return peopleType;
                    }

                    public void setPeopleType(Object peopleType) {
                        this.peopleType = peopleType;
                    }

                    public Object getWorkType() {
                        return workType;
                    }

                    public void setWorkType(Object workType) {
                        this.workType = workType;
                    }

                    public boolean isHaveContract() {
                        return haveContract;
                    }

                    public void setHaveContract(boolean haveContract) {
                        this.haveContract = haveContract;
                    }

                    public Object getIdAgency() {
                        return idAgency;
                    }

                    public void setIdAgency(Object idAgency) {
                        this.idAgency = idAgency;
                    }

                    public Object getIdValiddate() {
                        return idValiddate;
                    }

                    public void setIdValiddate(Object idValiddate) {
                        this.idValiddate = idValiddate;
                    }

                    public Object getIdphotoScan() {
                        return idphotoScan;
                    }

                    public void setIdphotoScan(Object idphotoScan) {
                        this.idphotoScan = idphotoScan;
                    }

                    public Object getIdPhoto() {
                        return idPhoto;
                    }

                    public void setIdPhoto(Object idPhoto) {
                        this.idPhoto = idPhoto;
                    }

                    public Object getFacephoto() {
                        return facephoto;
                    }

                    public void setFacephoto(Object facephoto) {
                        this.facephoto = facephoto;
                    }

                    public Object getIdFront() {
                        return idFront;
                    }

                    public void setIdFront(Object idFront) {
                        this.idFront = idFront;
                    }

                    public Object getCardFront() {
                        return cardFront;
                    }

                    public void setCardFront(Object cardFront) {
                        this.cardFront = cardFront;
                    }

                    public String getUpdateTime() {
                        return updateTime;
                    }

                    public void setUpdateTime(String updateTime) {
                        this.updateTime = updateTime;
                    }

                    public Object getCreateTime() {
                        return createTime;
                    }

                    public void setCreateTime(Object createTime) {
                        this.createTime = createTime;
                    }

                    public StatusBeanXXXXXXXXXXXXXXXX getStatus() {
                        return status;
                    }

                    public void setStatus(StatusBeanXXXXXXXXXXXXXXXX status) {
                        this.status = status;
                    }

                    public static class StatusBeanXXXXXXXXXXXXXXXX {
                        /**
                         * id : MEMBER_HIDDEN
                         * text : 已移除
                         * category : MEMBER_STATUS
                         * groupTitle : null
                         * system : true
                         * orderIndex : null
                         */

                        private String id;
                        private String text;
                        private String category;
                        private Object groupTitle;
                        private boolean system;
                        private Object orderIndex;

                        public String getId() {
                            return id;
                        }

                        public void setId(String id) {
                            this.id = id;
                        }

                        public String getText() {
                            return text;
                        }

                        public void setText(String text) {
                            this.text = text;
                        }

                        public String getCategory() {
                            return category;
                        }

                        public void setCategory(String category) {
                            this.category = category;
                        }

                        public Object getGroupTitle() {
                            return groupTitle;
                        }

                        public void setGroupTitle(Object groupTitle) {
                            this.groupTitle = groupTitle;
                        }

                        public boolean isSystem() {
                            return system;
                        }

                        public void setSystem(boolean system) {
                            this.system = system;
                        }

                        public Object getOrderIndex() {
                            return orderIndex;
                        }

                        public void setOrderIndex(Object orderIndex) {
                            this.orderIndex = orderIndex;
                        }
                    }
                }
            }
        }

        public static class MemberBean {
            /**
             * id : 85785
             * phone : 18720295614
             * bankName : 平安银行
             * cardNumber : 6212264100011335373
             * title : 呵
             * gender : null
             * nation : null
             * birthday : 1991-03-28
             * nativePlace : null
             * idNumber : 445222199103280013
             * position : null
             * teamType : null
             * certificate : null
             * safe : false
             * xueli : null
             * gangqianPX : false
             * idCardInfo : null
             * shiduan : null
             * peopleType : null
             * workType : null
             * haveContract : false
             * idAgency : null
             * idValiddate : null
             * idphotoScan : null
             * idPhoto : null
             * facephoto : null
             * idFront : null
             * cardFront : null
             * updateTime : 2018-04-18 17:49:38
             * createTime : 2018-04-17 17:53:44
             * status : {"id":"MEMBER_HIDDEN","text":"已移除","category":"MEMBER_STATUS","groupTitle":null,"system":true,"orderIndex":null}
             */

            private int id;
            private String phone;
            private String bankName;
            private String cardNumber;
            private String title;
            private Object gender;
            private Object nation;
            private String birthday;
            private Object nativePlace;
            private String idNumber;
            private Object position;
            private Object teamType;
            private Object certificate;
            private boolean safe;
            private Object xueli;
            private boolean gangqianPX;
            private Object idCardInfo;
            private Object shiduan;
            private Object peopleType;
            private Object workType;
            private boolean haveContract;
            private Object idAgency;
            private Object idValiddate;
            private Object idphotoScan;
            private Object idPhoto;
            private Object facephoto;
            private Object idFront;
            private Object cardFront;
            private String updateTime;
            private String createTime;
            private StatusBeanXXXXXXXXXXXXXXXXX status;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public String getBankName() {
                return bankName;
            }

            public void setBankName(String bankName) {
                this.bankName = bankName;
            }

            public String getCardNumber() {
                return cardNumber;
            }

            public void setCardNumber(String cardNumber) {
                this.cardNumber = cardNumber;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public Object getGender() {
                return gender;
            }

            public void setGender(Object gender) {
                this.gender = gender;
            }

            public Object getNation() {
                return nation;
            }

            public void setNation(Object nation) {
                this.nation = nation;
            }

            public String getBirthday() {
                return birthday;
            }

            public void setBirthday(String birthday) {
                this.birthday = birthday;
            }

            public Object getNativePlace() {
                return nativePlace;
            }

            public void setNativePlace(Object nativePlace) {
                this.nativePlace = nativePlace;
            }

            public String getIdNumber() {
                return idNumber;
            }

            public void setIdNumber(String idNumber) {
                this.idNumber = idNumber;
            }

            public Object getPosition() {
                return position;
            }

            public void setPosition(Object position) {
                this.position = position;
            }

            public Object getTeamType() {
                return teamType;
            }

            public void setTeamType(Object teamType) {
                this.teamType = teamType;
            }

            public Object getCertificate() {
                return certificate;
            }

            public void setCertificate(Object certificate) {
                this.certificate = certificate;
            }

            public boolean isSafe() {
                return safe;
            }

            public void setSafe(boolean safe) {
                this.safe = safe;
            }

            public Object getXueli() {
                return xueli;
            }

            public void setXueli(Object xueli) {
                this.xueli = xueli;
            }

            public boolean isGangqianPX() {
                return gangqianPX;
            }

            public void setGangqianPX(boolean gangqianPX) {
                this.gangqianPX = gangqianPX;
            }

            public Object getIdCardInfo() {
                return idCardInfo;
            }

            public void setIdCardInfo(Object idCardInfo) {
                this.idCardInfo = idCardInfo;
            }

            public Object getShiduan() {
                return shiduan;
            }

            public void setShiduan(Object shiduan) {
                this.shiduan = shiduan;
            }

            public Object getPeopleType() {
                return peopleType;
            }

            public void setPeopleType(Object peopleType) {
                this.peopleType = peopleType;
            }

            public Object getWorkType() {
                return workType;
            }

            public void setWorkType(Object workType) {
                this.workType = workType;
            }

            public boolean isHaveContract() {
                return haveContract;
            }

            public void setHaveContract(boolean haveContract) {
                this.haveContract = haveContract;
            }

            public Object getIdAgency() {
                return idAgency;
            }

            public void setIdAgency(Object idAgency) {
                this.idAgency = idAgency;
            }

            public Object getIdValiddate() {
                return idValiddate;
            }

            public void setIdValiddate(Object idValiddate) {
                this.idValiddate = idValiddate;
            }

            public Object getIdphotoScan() {
                return idphotoScan;
            }

            public void setIdphotoScan(Object idphotoScan) {
                this.idphotoScan = idphotoScan;
            }

            public Object getIdPhoto() {
                return idPhoto;
            }

            public void setIdPhoto(Object idPhoto) {
                this.idPhoto = idPhoto;
            }

            public Object getFacephoto() {
                return facephoto;
            }

            public void setFacephoto(Object facephoto) {
                this.facephoto = facephoto;
            }

            public Object getIdFront() {
                return idFront;
            }

            public void setIdFront(Object idFront) {
                this.idFront = idFront;
            }

            public Object getCardFront() {
                return cardFront;
            }

            public void setCardFront(Object cardFront) {
                this.cardFront = cardFront;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public StatusBeanXXXXXXXXXXXXXXXXX getStatus() {
                return status;
            }

            public void setStatus(StatusBeanXXXXXXXXXXXXXXXXX status) {
                this.status = status;
            }

            public static class StatusBeanXXXXXXXXXXXXXXXXX {
                /**
                 * id : MEMBER_HIDDEN
                 * text : 已移除
                 * category : MEMBER_STATUS
                 * groupTitle : null
                 * system : true
                 * orderIndex : null
                 */

                private String id;
                private String text;
                private String category;
                private Object groupTitle;
                private boolean system;
                private Object orderIndex;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getCategory() {
                    return category;
                }

                public void setCategory(String category) {
                    this.category = category;
                }

                public Object getGroupTitle() {
                    return groupTitle;
                }

                public void setGroupTitle(Object groupTitle) {
                    this.groupTitle = groupTitle;
                }

                public boolean isSystem() {
                    return system;
                }

                public void setSystem(boolean system) {
                    this.system = system;
                }

                public Object getOrderIndex() {
                    return orderIndex;
                }

                public void setOrderIndex(Object orderIndex) {
                    this.orderIndex = orderIndex;
                }
            }
        }
    }

    public static class SortBean {
        /**
         * direction : DESC
         * property : id
         * ignoreCase : false
         * nullHandling : NATIVE
         * ascending : false
         */

        private String direction;
        private String property;
        private boolean ignoreCase;
        private String nullHandling;
        private boolean ascending;

        public String getDirection() {
            return direction;
        }

        public void setDirection(String direction) {
            this.direction = direction;
        }

        public String getProperty() {
            return property;
        }

        public void setProperty(String property) {
            this.property = property;
        }

        public boolean isIgnoreCase() {
            return ignoreCase;
        }

        public void setIgnoreCase(boolean ignoreCase) {
            this.ignoreCase = ignoreCase;
        }

        public String getNullHandling() {
            return nullHandling;
        }

        public void setNullHandling(String nullHandling) {
            this.nullHandling = nullHandling;
        }

        public boolean isAscending() {
            return ascending;
        }

        public void setAscending(boolean ascending) {
            this.ascending = ascending;
        }
    }
}
