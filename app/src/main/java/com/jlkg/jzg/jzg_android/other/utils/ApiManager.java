package com.jlkg.jzg.jzg_android.other.utils;

import android.text.TextUtils;

import com.jlkg.jzg.jzg_android.base.MyApplication;
import com.jlkg.jzg.jzg_android.home.beans.CityBean1;
import com.jlkg.jzg.jzg_android.utils.HttpUtils;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zcs on 2018/3/5.
 *
 * @describe:
 */

public class ApiManager {
//    public static final String baseUrl = "http://120.77.52.85:8180/";
    //       public static final String baseUrl = "http://mall.jianzhugang.com:9998/";
  public static final String baseUrl = "https://api.jianzhugang.com/";
//    public static final String baseUrl = "http://test.jianzhugang.com:9998/";

    /**
     * 获取合约详情Url
     *
     * @param contractId
     * @return
     */
    public static String getContractDetailUrl(int contractId) {
        return baseUrl + "pages/contractHtml?contractId=" + contractId;
    }

    /**
     * 获取班组操作规范
     *
     * @param teamTypeId
     * @param back
     */
    public static void teamTypesDetail(String teamTypeId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "/teamTypes/get?id=" + teamTypeId, null, tag,back);
    }

    /**
     * 验证是否绑定
     *
     * @param wxId
     * @param back
     */
    public static void getPhoneByWxId(String wxId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/getPhoneByWxId?wxId=" + wxId, null,tag, back);
    }

    /**
     * 微信绑定手机号
     *
     * @param wxId
     * @param back
     */
    public static void wxBindPhone(String wxId, String phone,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/wxBindPhone?wxId=" + wxId + "&phone=" + phone, null, tag,back);
    }

    /**
     * 微信登录
     *
     * @param wxId
     * @param back
     */
    public static void weChartLogin(String wxId, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/weChatLogin?weChatId=" + wxId + "&loginType=" + (MyApplication.isCompany ? "2" : "1"), null, tag,back);
    }

    //登录
    public static void login(String username, String pwd, boolean isCompany,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/login?loginId=" + username +
                "&passWord=" + pwd + "&loginType=" + (isCompany ? 2 : 1), null,tag, back);
    }

    //注册
    public static void regist(String username, String code, String password, boolean isCompany, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/signUp?loginId=" + username + "&password=" + password +
                "&code=" + code /*+ "&loginType=" + (isCompany ? 2 : 1)*/, null,tag, back);
    }

    //重置密码
    public static void resetPwd(String username, String pwd, String code, boolean isCompany, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "accounts/resetPassword?userName=" + username + "&password=" + pwd +
                "&code=" + code/* + "&loginType=" + (isCompany ? 2 : 1)*/, null, tag,back);
    }

    //获取验证码
    public static void sendVerifyCode(String username,Object tag, HttpUtils.OnCallBack<Object> back) {
        HttpUtils.getInstance().post(baseUrl + "verifyCodes/sendVerifyCode?userName=" + username, null,tag, back);
    }

    //注册获取验证码
    public static void sendVerifyCodeForRest(String username,Object tag, HttpUtils.OnCallBack<Object> back) {
        HttpUtils.getInstance().post(baseUrl + "verifyCodes/sendVerifyCodeForRest?userName=" + username, null,tag, back);
    }

    //注册获取验证码
    public static void sendVerifyCodeAndCheckUserName(String username,Object tag, HttpUtils.OnCallBack<Object> back) {
        if (MyApplication.isCompany) {
            HttpUtils.getInstance().post(baseUrl + "verifyCodes/sendVerifyCodeAndCheckUserName?userName=" + username + "&flag=COMPANY", null,tag, back);
        } else {
            HttpUtils.getInstance().post(baseUrl + "verifyCodes/sendVerifyCodeAndCheckUserName?userName=" + username + "&flag=TEAM", null,tag, back);
        }
    }

    //仅检查验证码是否正确, 并不使验证码失效
    public static void validateVerifyCode(String userName, String code,Object tag, HttpUtils.OnCallBack<Object> back) {
        HttpUtils.getInstance().post(baseUrl + "verifyCodes/checkVerifyCode?userName=" + userName + "&code=" + code, null, tag,back);
    }

    //获取全部城市
    public static void getAllList(Object tag,HttpUtils.OnCallBack<List<CityBean1>> back) {
        HttpUtils.getInstance().post(baseUrl + "areas/getAllList", null,tag, back);
    }

    //商店列表查询
    public static void shopsQuery(String page, Object tag,HttpUtils.OnCallBack back) {
//        map.put("districtId", districtId);
        HttpUtils.getInstance().post(baseUrl + "shops/getSotreList?cateId=1467&page=" + page + "&size=100", null, tag,back);
    }

    //门店详情
    public static void storeDetails(String id, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "shops/getStoreDetail?storeId=" + id, null,tag, back);
    }

    //获取商店主要商品
    public static void getMainGoods(String storeId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "shops/getMainGoods?storeId=" + /*2869*/storeId, null, tag,back);
    }

    //获取商店常见商品
    public static void getCommonGoods(String storeId, int page,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "shops/getCommonGoods?storeId=" + storeId /*2405*/ + "&page=" + page + "&size=100", null, tag,back);
    }

    //公司账号登录
    public static void companySignln(String username, String pwd, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/signIn?userName=" + username + "&password=" + pwd, null,tag, back);
    }

    //公司账号注册
    public static void companySignUp(String code, String phone,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/signUp?userName=" + phone + "&phone=" + phone + "&code=" + code + "&password=123456", null,tag, back);
    }

    //保存公司信息

    /**
     * @param name          :公司名称
     * @param companyTypeId :公司类型Id
     * @param contacts      :联系人
     * @param phone         :联系电话
     * @param notes         :备注
     * @param companyId     :公司用户id
     * @param logoId        :公司营业执照图片id
     * @param streetAddress :公司地址
     * @param back          :请求结果回掉
     */
    public static void companyInfoSave(String name, String companyTypeId, String contacts, String phone,
                                       String notes, int companyId, int logoId, String streetAddress, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/update?name=" + name + "&companyTypeId=" + companyTypeId + "&contacts=" + contacts + "&phone=" + phone +
                "&notes=" + notes + "&logoId=" + logoId + "&id=" + companyId + "&streetAddress=" + streetAddress, null,tag, back);
    }

    //图片上传
    public static void imageUpload(File file, Object tag,HttpUtils.OnCallBack back) {
        Map<String, Object> map = new HashMap<>();
        map.put("file", file);
        HttpUtils.getInstance().post(baseUrl + "files/uploadImage", map, tag,back);
    }

    //图片上传
    public static void imageUpload2(File file, Object tag,HttpUtils.OnCallBack back) {
        Map<String, Object> map = new HashMap<>();
        map.put("file", file);
        HttpUtils.getInstance().post(baseUrl + "files/uploadFile", map,tag, back);
    }


//    //多图片上传
//    public static void imageUploadList(List<File> fileList,Object tag, HttpUtils.OnCallBack back) {
//
//        HttpUtils.getInstance().postFile(baseUrl + "files/uploadFile",fileList,tag, back);
//    }

    //班组账号登录
    public static void teamSignln(String username, String pwd,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/signIn?userName=" + username + "&password=" + pwd, null,tag, back);
    }

    //班组账号注册
    public static void teamSignUp(String code, String phone, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/signUp?userName=" + phone + "&phone=" + phone + "&code=" + code + "&password=123456", null, tag,back);
    }

    /**
     * 保存班组信息
     *
     * @param name          :真是姓名
     * @param ID_number     :身份证号码
     * @param idFrontId     :身份证正面照片ID
     * @param cardFrontId   :身份证反面照片ID
     * @param teamTypeId    :班组类型ID
     * @param address       :班组地址
     * @param streetAddress :班组详情地址
     * @param notes         :备注
     * @param teamId        :班组id
     * @param back
     */
    public static void teamInfoSave(String name, String ID_number, int idFrontId, int cardFrontId, int teamTypeId,
                                    String address, String streetAddress, String notes, int teamId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/update?name=" + name + "&ID_number=" + ID_number + "&idFrontId=" + idFrontId
                + "&cardFrontId=" + cardFrontId + "&teamTypeId=" + teamTypeId +
                "&address=" + address + "&streetAddress=" + streetAddress + "&notes=" + notes + "&id=" + teamId, null, tag,back);
    }

    //公司账号重置密码
    public static void companyResetPwd(String username, String pwd, String code,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/resetPassword?userName=" + username + "&password=" + pwd + "&code=" + code, null,tag, back);
    }

    //班组账号重置密码
    public static void teamResetPwd(String username, String pwd, String code,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/resetPassword?userName=" + username + "&password=" + pwd + "&code=" + code, null,tag, back);
    }

    //发布招工-选择班组-班组列表数据
    public static void teamTypesGetList(Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teamTypes/getAllList", null,tag, back);
    }

    //项目招工列表
    public static void projectHireList(String districtId, String teamType, int page,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/query?page=" + page + "&size=10&cityId=" + districtId + "&teamTypeId=" + teamType, null,tag, back);
    }


    //搜索项目招工
    public static void projectHireSearch(String queryWord, int page,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/query?size=10&queryWord=" + queryWord + "&page=" + page, null,tag, back);
    }

    //项目招工详情
    public static void projectHireDetail(int id,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/get?id=" + id, null,tag, back);
    }

    //项目招工详情获取申请状态
    public static void projectApplyStatus(int accountd, int projectHireId, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/query?accountId=" + accountd
                + "&projectHireID=" + projectHireId + "&isCompanyApp=" + (MyApplication.isCompany ? true : false), null, tag,back);
    }

    //项目招工更新申请状态
    public static void updateApplyStatus(int accountd, int projectHireId,Object tag, HttpUtils.OnCallBack back) {
        if (MyApplication.isCompany) {
            HttpUtils.getInstance().post(baseUrl + "projectApplys/applyByCompany?accountId=" + accountd + "&projectHireID=" + projectHireId, null,tag, back);
        } else {
            HttpUtils.getInstance().post(baseUrl + "projectApplys/applyByWorker?accountId=" + accountd + "&projectHireID=" + projectHireId, null,tag, back);
        }
    }

    //机械分类列表
    public static void getDictsCategory(Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "dicts/getDictsCategory", null,tag, back);
    }

    //机械租赁列表
    public static void machineAsksQuery(int page, String districtId, String cateId, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/getAppList?page=" + page + "&size=10&districtId=" + districtId + "&cateId=" + cateId, null,tag, back);
    }

    //机械租赁-地图
    public static void machineAsksQueryForMap(String districtId, String cateId, String starLevel,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/getAppList?page=0&size=200&districtId=" + districtId
                + "&cateId=" + cateId + "&starLevel=" + starLevel, null,tag, back);
    }

    //机械租赁详情
    public static void machineItem(int machineId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/getAppList?page=0&size=1&machineAskId=" + machineId, null,tag, back);
    }

    //申请机械:
    public static void applyMachineAsk(int id, int machineAskId, Object tag,HttpUtils.OnCallBack back) {
        if (MyApplication.isCompany) {
            HttpUtils.getInstance().post(baseUrl + "projectApplys/applyMachineAskByCompany?companyId=" + id + "&machineAskId=" + machineAskId, null, tag,back);
        } else {
            HttpUtils.getInstance().post(baseUrl + "projectApplys/applyMachineAskByWorker?teamId=" + id + "&machineAskId=" + machineAskId, null,tag, back);
        }


    }

    //机械负责人列表
    public static void machinePersonList(int page, String queryWord, String cateId, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/getAppList?page=" + page + "&size=10&queryWord=" + queryWord + "&cateId=" + cateId, null,tag, back);
    }

    //发布机械
    public static void machineAsksSave(int accountId, String title, String contacts, String mobile,
                                       String districtId, String streetAddress, String price,
                                       String shuoming, String typeId, String amount, String memo, int projectId, Object tag,HttpUtils.OnCallBack back) {
        StringBuilder builder = new StringBuilder();
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null) {
            builder.append("&companyId=");
            builder.append(MyApplication.sCompanyLoginBean.getId());
            if (projectId != 0) {
                builder.append("&projectId=");
                builder.append(projectId);
            }
        } else if (!MyApplication.isCompany && MyApplication.sTeamLoginBean != null) {
            builder.append("&teamId=");
            builder.append(MyApplication.sTeamLoginBean.getId());
        }
        builder.append("&status.id=ASK_LETING");//id=" + accountId + "&
        HttpUtils.getInstance().post(baseUrl + "machineAsks/save?title=" + title + "&contacts=" + contacts
                + "&mobile=" + mobile + "&district.id=" + districtId + "&streetAddress=" + streetAddress
                + "&price=" + price + "&shuoming=" + shuoming + "&type.id=" + typeId
                + "&amount=" + amount + builder.toString() + "&memo=" + memo, null,tag, back);
    }

    //发布招工
    public static void addProjectHire(String projectName, String contacts, String phone,
                                      String districtId, String provinceId, String projectAddress, String price,
                                      String needTypes, String needNumbers, String type, String memo, boolean hasProject,Object tag, HttpUtils.OnCallBack back) {
        if (MyApplication.isCompany && MyApplication.sCompanyLoginBean != null && hasProject) {
            HttpUtils.getInstance().post(baseUrl + "projectHires/addProjectHire?" +
                    "contacts=" + contacts + "&phone=" + phone +
                    "&salary=" + price + "&memo=" + memo + "&type.id="
                    + type + "&needTypes=" + needTypes + "&needNumbers=" + needNumbers, null,tag, back);
        } else {
            HttpUtils.getInstance().post(baseUrl + "projectHires/JZGaddProjectHire?projectName="
                    + projectName + "&contacts=" + contacts + "&phone=" + phone + "&cityId=" + districtId +/*"&provinceId="+provinceId+*/
                    "&salary=" + price + "&memo=" + memo + "&type.id="
                    + type + "&needTypes=" + needTypes + "&needNumbers=" + needNumbers + "&projectAddress=" + projectAddress, null, tag,back);
        }
    }

    //获取公司类型列表
    public static void getCompanyType(Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/getCompanyType", null,tag, back);
    }

    //获取公司列表
    public static void getCompanyList(int page, String typeKey, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/query?page=" + page + "&size=20&typeKey=" + typeKey, null,tag, back);
    }

    //查询公司项目
    public static void companyProjects(int companyId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/companyProjects?companyId=" + companyId/*5007*/, null, tag,back);
    }

    //通过关键字搜索公司列表
    public static void searchCompanyList(int page, String queryWord,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "companys/query?page=" + page + "&size=20&queryWord=" + queryWord, null, tag,back);
    }

    //根据班组类型id获取班组列表
    public static void getTeamListByTypeId(int page, String typeId, String queryWord,Object tag, HttpUtils.OnCallBack back) {
        if (TextUtils.isEmpty(queryWord))
            HttpUtils.getInstance().post(baseUrl + "teams/query?page=" + page + "&size=10&typeId=" + typeId, null, tag,back);
        else
            HttpUtils.getInstance().post(baseUrl + "teams/query?page=" + page + "&size=10&queryWord=" + queryWord, null,tag, back);
    }

    //获取班组列表-地图使用
    public static void getTeamListForMap(String districtId, String typeId, String starLevel,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/query?page=0&size=200" + "&cityId=" + districtId + "&typeId="
                + typeId + "&starLevel=" + starLevel, null, tag,back);
    }

    //根据班组id获取班组信息
    public static void getTeamDetailByTeamId(int id, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/get?id=" + id, null, tag,back);
    }

    //根据班组id获取班组成员
    public static void getTeamPerson(int id,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/queryMembers?teamId=" + id/*74988*/, null,tag, back);
    }

    //根据关键字搜索班组列表
    public static void searchTeamListByQueryWorld(int page, String queryWord,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/query?page=" + page + "&size=10&queryKey=" + queryWord, null, tag,back);
    }

    //班组详情-评价列表
    public static void teamRateReview(int id,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/teamRateReviewForApp?teamId=" + id/*3120*/, null,tag, back);
    }

    //通过班组id获取班组过往项目
    public static void queryProjectsByTeam(int teamId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "teams/queryProjects?teamId=" + teamId/*70271*/, null, tag,back);
    }

    //根据机械类型id获取机械列表
    public static void getJiXieListByTypeId(int page, String typeId, String queryWord,Object tag, HttpUtils.OnCallBack back) {
        if (TextUtils.isEmpty(queryWord))
            HttpUtils.getInstance().post(baseUrl + "machineAsks/query?page=" + page + "&size=10&typeId=" + typeId, null, tag,back);
        else
            HttpUtils.getInstance().post(baseUrl + "machineAsks/query?page=" + page + "&size=10&queryWord=" + queryWord, null, tag,back);
    }

    //我的待确认列表
    public static void myProjectApplyList(int accoundId, int page,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/query?accountId=" + accoundId + "&isCompanyApp="
                + MyApplication.isCompany + "&page=" + page + "&size=10", null, tag,back);
    }

    /**
     * 机械保存评价
     *
     * @param evaId          评价id，修改时使用
     * @param isCompany      评价公司/班组
     * @param id             公司id/班组id
     * @param projectId      项目id
     * @param machineAskId   机械id
     * @param contractId     合约id
     * @param resumeDesc     评价内容
     * @param qualityRating  质量
     * @param safeRating     安全
     * @param creditRating   诚信
     * @param progressRating 进度
     * @param back
     */
    public static void machineResumesSave(int evaId, boolean isCompany, int id, int projectId, int machineAskId, int contractId,
                                          String resumeDesc, int qualityRating, int safeRating,
                                          int creditRating, int progressRating,Object tag, HttpUtils.OnCallBack back) {
        StringBuilder builder = new StringBuilder();
        if (isCompany) builder.append("&company.id=").append(id);
        else builder.append("&team.id=").append(id);
        if (evaId != 0) {
            builder.append("&id=").append(evaId);
        }
        HttpUtils.getInstance().post(baseUrl + "machineResumes/save?project.id=" + projectId
                + "&machineAsk.id=" + machineAskId + "&contract.id=" + contractId + "&resumeDesc=" + resumeDesc
                + "&qualityRating=" + qualityRating + "&safeRating=" + safeRating + "&creditRating=" + creditRating
                + "&progressRating=" + progressRating + builder.toString(), null,tag, back);
    }

    /**
     * 合约id查询评价
     *
     * @param contractId
     * @param back
     */
    public static void machineResumesQuery(int contractId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "machineResumes/query?page=0&size=999&contractId=" + contractId, null,tag, back);
    }

    /**
     * 招工合约查询评价
     *
     * @param contractId
     * @param back
     */
    public static void workQuery(int contractId, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contracts/get?id=" + contractId, null,tag, back);
    }

    /**
     * 招工保存/修改评价
     *
     * @param contractId
     * @param review
     * @param qualityRating
     * @param safeRating
     * @param creditRating
     * @param progressRating
     * @param back
     */
    public static void workRateSave(int contractId, String review, int qualityRating, int safeRating,
                                    int creditRating, int progressRating,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contracts/updateRate?contractId=" + contractId
                + "&qualityRating=" + qualityRating + "&safeRating=" + safeRating
                + "&creditRating=" + creditRating + "&progressRating=" + progressRating
                + "&review=" + review, null, tag,back);
    }

    /**
     * 同意招租申请
     *
     * @param applyId
     * @param back
     */
    public static void applyMachineAskConfirm(int applyId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/applyMachineAskConfirm?applyId=" + applyId, null,tag, back);
    }

    /**
     * 拒绝招租申请
     *
     * @param applyId
     * @param back
     */
    public static void leaseDelete(int applyId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/delete?id=" + applyId, null, tag,back);
    }

    /**
     * 合约拒绝申请
     *
     * @param accoundId 用户Id
     * @param applyId   待确认合约Id
     * @param type      申请方类型
     * @param back      applyStatus: APPLY=已申请,CANCELED=已取消,CONFIRMED=已确认,DENYED=已拒绝
     */
    public static void updataApplyStatus(int accoundId, int applyId, String type, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/updateApplyStatus?accountId=" + accoundId + "&applyId="
                + applyId + "&applyStatus=DENYED&type=" + type, null, tag,back);
    }

    /**
     * 获取待确认详情
     *
     * @param applyId
     * @param back
     */
    public static void getApplyDetails(int applyId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/get?id=" + applyId, null, tag,back);
    }

    /**
     * @param applyId            申请Id
     * @param projectTitle       项目名称
     * @param projectAddress     项目地址
     * @param startDate          开工时间 时间戳
     * @param endDate            竣工时间 时间戳
     * @param totalDays          总天数
     * @param price              合同金额
     * @param projectStandard    工程质量标准
     * @param projectRange       工程承包范围及方式
     * @param pay1               工程预付款的支付时间和金额
     * @param pay2               工程进度款支付时间和金额
     * @param pay3               竣工结算程序和时限
     * @param projectTeamRequire 承接要求
     * @param back
     */
    public static void commitStartSign(int applyId, String projectTitle, String projectAddress, String startDate,
                                       String endDate, String totalDays, String price, String projectStandard,
                                       String projectRange, String pay1, String pay2, String pay3,
                                       String projectTeamRequire, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "projectApplys/commitStartSign?applyId=" + applyId + "&projectTitle=" + projectTitle +
                "&projectAddress=" + projectAddress + "&startDate=" + startDate + "&endDate=" + endDate + "&totalDays=" + totalDays +
                "&price=" + price + "&projectStandard=" + projectStandard + "&projectRange=" + projectRange + "&pay1=" + pay1 +
                "&pay2=" + pay2 + "&pay3=" + pay3 + "&projectTeamRequire=" + projectTeamRequire, null, tag,back);
    }

    //合约--根据不同状态获取列表
    public static void contactsList(int accountId, String status, int page,Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contracts/query?" + "accountId=" + accountId + "&status="
                + status + "&page=" + page + "&size=10&type=" + (MyApplication.isCompany ? "COMPANY" : ""), null,tag, onCallBack);
    }

    //合约详情
    public static void contactsDetail(int id,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contracts/get?id=" + id, null,tag, back);
    }

    /**
     * 确认付款申请
     *
     * @param id
     * @param back
     */
    public static void confirmApply(int id,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/companyComfirmRequest?id=" + id, null, tag,back);
    }

    //消息列表
    public static void msgList(int page, Object tag,HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "notice/list?page=" + page + "&size=10", null,tag, back);
    }

    /**
     * 申请付款
     *
     * @param teamId            班组ID
     * @param contractId        当前合约ID
     * @param auditNo           当前contractNo
     * @param applyAmount       订单总金额
     * @param detail_teamId     班组ID，多个ID用，号隔开
     * @param detail_workerId   班组成员ID，多个用，号隔开
     * @param detail_workerName 班组姓名，多个用，号隔开
     * @param detail_idNumber   班组身份证号码，多个用，号隔开
     * @param detail_mobile     班组电话号码，多个用，号隔开
     * @param detail_bankName   班组银行信息，多个用，号隔开
     * @param detail_cardNumber 班组卡号信息，多个用，号隔开
     * @param detail_salary     班组金额，多个用，号隔开
     * @param back
     */
    public static void addOrder(int teamId, int contractId, String auditNo, String applyAmount,
                                String detail_teamId, String detail_workerId, String detail_workerName,
                                String detail_idNumber, String detail_mobile, String detail_bankName,
                                String detail_cardNumber, String detail_salary,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/addOrder?teamId=" + teamId +
                "&contractId=" + contractId + "&auditNo=" + auditNo + "&applyAmount=" + applyAmount +
                "&detail_teamId=" + detail_teamId + "&detail_workerId=" + detail_workerId +
                "&detail_workerName=" + detail_workerName + "&detail_idNumber=" + detail_idNumber +
                "&detail_mobile=" + detail_mobile + "&detail_bankName=" + detail_bankName +
                "&detail_cardNumber=" + detail_cardNumber + "&detail_salary=" + detail_salary, null,tag, back);
    }

    /**
     * 获取订单信息
     *
     * @param contractId 合约Id
     * @param back
     */
    public static void getOrder(int contractId,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/query?contractId=" + contractId, null,tag, back);
    }

    /**
     * 获取工资明细
     *
     * @param orderId 订单id
     * @param page
     * @param back
     */
    public static void getOrderDetail(int orderId, int page,Object tag, HttpUtils.OnCallBack back) {
        HttpUtils.getInstance().post(baseUrl + "payDetails/getPageDetails?orderId=" + orderId + "&page=" + page + "&size=10", null,tag, back);
    }
//-----------------------------------------------------------------------
    /**
     * 修改密码
     */
    public static void modifyPassword(boolean isIdentity, String oldPassword, String newPassword, Object tag, HttpUtils.OnCallBack back) {
        if (isIdentity) {
            //分公司角色
            // HttpUtils.getInstance().post(baseUrl + "companys/modifyPassword?" + "accountId=" + accountId + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword, null, tag, back);
            HttpUtils.getInstance().post(baseUrl + "accounts/modifyPassword?" + "accountId=" + MyApplication.sCompanyLoginBean.getId() + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword + "&accountType=" + (MyApplication.isCompany ? "COMPANY" : "TEAM")/*+"&loginType=2"*/, null, tag, back);

        } else {
            //HttpUtils.getInstance().post(baseUrl + "teams/modifyPassword?" + "accountId=" + accountId + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword, null, tag, back);
            HttpUtils.getInstance().post(baseUrl + "accounts/modifyPassword?" + "accountId=" + MyApplication.sTeamLoginBean.getId() + "&oldPassword=" + oldPassword + "&newPassword=" + newPassword + "&accountType=" + (MyApplication.isCompany ? "COMPANY" : "TEAM")/*+"&loginType=1"*/, null, tag, back);

        }
    }


    /**
     * 组织架构----我的项目
     */
    public static void myProjects(String accountId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "companys/myProjects?" + "accountId=" + accountId, null, tag, onCallBack);
    }

    /**
     * 组织架构----通过公司名字查找项目
     */
    public static void queryByName(String queryWord, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "projects/queryByName?" + "queryWord=" + queryWord + "&maxSize=10", null, tag, onCallBack);

    }

    /**
     * 组织架构----通过公司id查找项目
     */
    public static void querById(String companyId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "projects/getProjectByCompanyId?" + "companyId=" + companyId, null, tag, onCallBack);
    }

    /**
     * 组织架构----公司项目
     */
    public static void companyProjects(String companyId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "companys/companyProjects?" + "companyId=" + companyId, null, tag, onCallBack);
    }


    /**
     * 输入申请-----我的招工
     */
    public static void queryMyRecruit(String accountId, String status, String page, String pageSize, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/query?" + "accountId=" + accountId + "&status=" + status + "&page=" + page + "&size=" + pageSize, null, tag, onCallBack);
    }


    /**
     * 删除----我的招工
     */
    public static void doDelete(int id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/doDelete?" + "id=" + id, null, tag, onCallBack);
    }


    /**
     * 项目添加-----组织架构
     */
    public static void addProjects(HashMap<String, String> hashMapParam, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "projects/add?", hashMapParam, null, tag, onCallBack);
    }

    /**
     * 项目申请---查询合同
     */
    public static void contractsQuery(String accountId, String status, String page, String pageSize, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contracts/query?" + "accountId=" + accountId + "&status=" + status + "&page=" + page + "&size=" + pageSize + "&type=COMPANY", null, tag, onCallBack);
    }


    /**
     * 我的招工---确认完成
     */
    public static void myprojectConfirm(String projectId, String status, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "projectHires/updateStatusHire?" + "id=" + projectId + "&status=" + status, null, tag, onCallBack);
    }


    /**
     * 项目申请----修改合同状态
     *
     * @param contractId
     * @param status
     * @param tag
     * @param onCallBack
     */
    public static void contractsStatus(String contractId, String status, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contracts/save?" + "id=" + contractId + "&status.id=" + status, null, tag, onCallBack);
    }

    /**
     * 项目申请----取消合同
     */
    public static void cancelContract(String constractId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "/contracts/cancelContract?" + "id=" + constractId, null, tag, onCallBack);
    }

    /**
     * 项目申请---确认签约
     */
    public static void agreeContract(String constractId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contracts/agreeContract?" + "id=" + constractId, null, tag, onCallBack);

    }


    /**
     * 项目申请----完成合同
     */
    public static void completeContract(String contractId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contracts/completeContract?" + "id=" + contractId, null, tag, onCallBack);
    }

    /**
     * 获取劳务公司
     */
    public static void getCompanyByParentCompany(String companyId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "/companys/getCompanyTree?" + "companyId=" + companyId, null, tag, onCallBack);
    }


    /**
     * 组织架构----编辑项目
     */
    public static void uploadProjectsInfo(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "projects/save?", hashMap, null, tag, onCallBack);
    }

    /**
     * 组织架构----添加劳务公司
     */
    public static void addLabour(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "companys/addChildCompany?", hashMap, null, tag, onCallBack);
    }


    /**
     * 调度中心----人员
     */
    public static void centerPeoplesQuery(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "dcenter/peopleCountByComapnyId?", hashMap, null, tag, onCallBack);
    }

    /**
     * 班组、公司----我的招工
     */
    public static void queryHireByPhone(String phone, String status, Object tag, HttpUtils.OnCallBack onCallBack) {
        if (TextUtils.isEmpty(status)) {
            HttpUtils.getInstance().post(baseUrl + "projectHires/queryHireByPhone?" + "phone=" + phone, null, tag, onCallBack);
        } else {
            HttpUtils.getInstance().post(baseUrl + "projectHires/queryHireByPhone?" + "phone=" + phone + "&status=" + status, null, tag, onCallBack);
        }
    }

    /**
     * 公司---获取工资表
     */
    public static void getByProjectId(String projectId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/getByProjectId?" + "ProjectId=" + projectId, null, tag, onCallBack);
    }

    public static void getTeamList(String contractId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/query?" + "contractId=" + contractId + "&status=ORDER_STATUS_TEAM_RECEIVED", null, tag, onCallBack);
    }


    /**
     * 获取班组成员
     */
    public static void getTeamMember(String memberId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/queryMembers?" + "teamId=" + memberId, null, tag, onCallBack);
    }

    /**
     * 删除的过往成员
     */
    public static void getHisTeamMember(String teamId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/queryDelMembers?" + "teamId=" + teamId, null, tag, onCallBack);
    }

    /**
     * 添加成员
     */
    public static void addTeamMember(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "teams/addMember?", hashMap, null, tag, onCallBack);
    }

    /**
     * 删除成员
     */
    public static void deleteTeamMember(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "members/hiddenMember?" + "id=" + id + "&team.id=" + MyApplication.sTeamLoginBean.getId(), null, tag, onCallBack);
//    public static void deleteTeamMember(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
//        HttpUtils.getInstance().post(baseUrl + "/members/hidden?" + "id=" + id, null, tag, onCallBack);
    }

    /**
     * 过往项目
     */
    public static void teamOldProjects(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/teamOldProjects?" + "teamId=" + id, null, tag, onCallBack);
    }

    /**
     * 获取银行卡
     */
    public static void getBankName(Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "dicts/getBankName?", null, tag, onCallBack);
    }

    /**
     * 编辑个人资料--公司
     */
    public static void updeateCompany(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "companys/update?", hashMap, null, tag, onCallBack);
    }

    /**
     * 保存公司资料
     */
    public static void saveCompany(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "companys/save?", hashMap, null, tag, onCallBack);
    }

    /**
     * 绑定银行卡--班组
     */
    public static void bindCardInfo(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "teams/bindCardInfo?", hashMap, null, tag, onCallBack);
    }

    /**
     * 绑定银行卡---公司
     */
    public static void bindCardInfoCompany(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "companys/bindCardInfo?", hashMap, null, tag, onCallBack);
    }


    /**
     * 编辑个人资料---班组
     */
    public static void updateTeam(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "teams/update?", hashMap, null, tag, onCallBack);
    }

    /**
     * 机械招租
     */
    public static void getAppList(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
//        HttpUtils.getInstance().postParm(baseUrl + "machineAsks/getAppList", hashMap, null, tag, onCallBack);
//    public static void getAppList(HashMap<String,String> hashMap,Object tag, HttpUtils.OnCallBack onCallBack){
        HttpUtils.getInstance().postParm(baseUrl + "machineAsks/myMachineAsk?", hashMap, null, tag, onCallBack);
    }

    /**
     * 班组成员---恢复
     */
    public static void restore(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "members/restoreMember ?" + "id=" + id + "&team.id=" + MyApplication.sTeamLoginBean.getId(), null, tag, onCallBack);
    }


    /**
     * 更新信息
     */
    public static void updateList(Object tag, HttpUtils.OnCallBack onCallBack) {

        HttpUtils.getInstance().post(baseUrl + "appUpdates/list?" + "page=0&size=1", null, tag, onCallBack);

    }

    /**
     * 意见反馈
     */
    public static void saveFeedback(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "feedback/save?", hashMap, null, tag, onCallBack);
    }

    /**
     * 我的招租---更新状态
     */
    public static void machineStatus(String id, String status, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/updateStatus?" + "id=" + id + "&status=" + status, null, tag, onCallBack);
    }

    /**
     * 我的招租---删除
     */
    public static void delMachine(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "machineAsks/delMachine?" + "id=" + id, null, tag, onCallBack);
    }

    /**
     * 调度中心----机械
     */
    public static void getMachine(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "dcenter/machineCountByCompany?", hashMap, null, tag, onCallBack);
    }

    /**
     * 调度中心---人员详情
     */
    public static void centerPelples(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "centerPeoples/query?", hashMap, null, tag, onCallBack);
    }

    /**
     * 公司---获取个人信息
     */
    public static void getCompanyInfo(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "companys/get?" + "id=" + id, null, tag, onCallBack);
    }

    /**
     * 班组----获取个人信息
     */
    public static void getTeamInfo(String id, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/get?" + "id=" + id, null, tag, onCallBack);
    }

    /**
     * 获取交易记录
     */
    public static void getDealDeatils(String id, int page, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/getByTeamIdquerybyPage?" + "teamId=" + id + "&page=" + page + "&size=10", null, tag, onCallBack);
    }


    /**
     * 发工资   获取公司的
     */
    public static void getCompanyList(String companyId, int page, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "contractOrders/queryOrderByCompanyId?companyId=" + companyId + "&page=" + page + "&size=10&&status=ORDER_STATUS_TEAM_RECEIVED", null, tag, onCallBack);
    }


    /**
     * 发工资 详细
     */
    public static void getPageDetails(String orderId, int page, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "payDetails/getPageDetails?orderId=" + orderId + "&page=" + page + "&size=10", null, tag, onCallBack);
    }


    /**
     * 班组评分
     */
    public static void teamRateStar(String teamId, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().post(baseUrl + "teams/teamRateStar?teamId=" + teamId, null, tag, onCallBack);
    }


    /**
     * 过往项目添加
     */
    public static void beforeObjectSave(HashMap<String, String> hashMap, Object tag, HttpUtils.OnCallBack onCallBack) {
        HttpUtils.getInstance().postParm(baseUrl + "teamResumes/save?", hashMap, null, tag, onCallBack);
    }


}
