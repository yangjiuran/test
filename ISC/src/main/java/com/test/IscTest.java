package com.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aostarit.smcrypto.Sm2Utils;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author yangjiuran
 * @Date 2020/4/28
 */
@RequestMapping("/isc")
@RestController
public class IscTest {
    /**
     * 应用id
     */
    private final static  String APPID="a16d8176e11d4688b90e56474d74b74c";
    /**
     * 应用颁发的秘钥
     */
    private final static String KEY="048B208236EC844815B5C69C5ADFE881554F5B770B59313EDB0F5EB880A026CEC81C0D8CF509679B95FAB32AFF6A006D2CAE56CBF49DB78D6FD45AF70380B7CB18";
    /**
     * 接口地址
     */
    private final static String ISC_FRONTMV_SERV="http://10.138.11.12:17007/isc_frontmv_serv/";
    private static HttpClient client = new HttpClient();
/*    public static void main(String[] args) throws Exception {
        String token=getToken();//获取token
        appInfoApi(token, APPID);//调用接口

    }*/
    @RequestMapping("/getToken")
    public String getToke(){
        try {
            String token=getToken();//获取token
            appInfoApi(token, APPID);//调用接口
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping("/getAll")
    public String getAllApi(String url){
        try {
            String token=getToken();//获取token
            getAll(url,token);//调用接口
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    @RequestMapping("/userDomainOrg")
    public String userDomainOrgApi(){
        try {
            String token=getToken();//获取token
            userDomainOrg(token);//调用接口
            return token;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    private  String getAll(String url,String token)throws Exception{
        PostMethod post = new PostMethod(
                ISC_FRONTMV_SERV+url);
        post.addRequestHeader( new Header("appId",APPID));//应用id 放到header
        post.addRequestHeader( new Header("app_token",token));//和应用id配对的访问token 放到header
        client.executeMethod(post);
        System.out.println(post.getResponseBodyAsString());
        return post.getResponseBodyAsString();
    }

    private  String userDomainOrg(String token)throws Exception{
        PostMethod post = new PostMethod(
                ISC_FRONTMV_SERV+"/userDomainOrg/713D635D03811E39E053330B8A0AD1B3/1/1");
        post.addRequestHeader( new Header("appId",APPID));//应用id 放到header
        post.addRequestHeader( new Header("app_token",token));//和应用id配对的访问token 放到header
        client.executeMethod(post);
        System.out.println(post.getResponseBodyAsString());
        return post.getResponseBodyAsString();
    }
    private  void appInfoApi(String token,String appid)throws Exception{
        PostMethod post = new PostMethod(
                ISC_FRONTMV_SERV+"v1/api/microApp/"+appid);
        post.addRequestHeader( new Header("appId",APPID));//应用id 放到header
        post.addRequestHeader( new Header("app_token",token));//和应用id配对的访问token 放到header
        client.executeMethod(post);
        System.out.println(post.getResponseBodyAsString());
    }
    private  String getToken()throws Exception{
        Sm2Utils sm2Utils = new Sm2Utils();
        String token = sm2Utils.encryptToASN1(
                KEY,
                APPID+":" + System.currentTimeMillis());//使用国网sm2加密算法加密参数且服务器时间相差不能超过5分钟 如果超过5分钟将会返回请求超时

        PostMethod post = new PostMethod(
                ISC_FRONTMV_SERV+"domain/auth");

        post.addParameter( new NameValuePair("appId",APPID));
        post.addRequestHeader( new Header("app_token",token));//将生成的加密串放到header
        client.executeMethod(post);

        if(post.getStatusCode()== HttpStatus.SC_OK){
            String responseBodyAsString = post.getResponseBodyAsString();
            JSONObject jsonObject = JSON.parseObject(responseBodyAsString);
            return jsonObject.getString("access_token");
        }else{
            if(post.getStatusCode()==HttpStatus.SC_REQUEST_TIMEOUT){
                throw new RuntimeException("token超时!");
            }
            if(post.getStatusCode()==HttpStatus.SC_BAD_REQUEST){
                throw new RuntimeException("缺少参数!");
            }

        }
        return null;

    }
}
