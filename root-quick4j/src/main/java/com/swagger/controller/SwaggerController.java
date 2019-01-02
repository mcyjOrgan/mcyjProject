package com.swagger.controller;

import com.lrzjl.constant.MemberConst;
import com.lrzjl.constant.RetCodeConsts;
import com.root.Base.BaseApiServiceImpl;
import com.root.Bean.Result;
import com.root.constant.ApiResultEnum;
import com.root.dto.LrzjlResultItem;
import com.root.dto.LrzjlResultList;
import com.test.object.*;
import common.base.TokenClaim;
import common.util.TokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Api(value = "获取token测试接口")
@RequestMapping(value = "api")
@Controller
public class SwaggerController extends BaseApiServiceImpl{

//    @RequestMapping(value = "user/getToken", method = RequestMethod.POST)
//    @ResponseBody
//    @ApiOperation(value = "swagger测试接口")
//    public Result<TokenVo> hello(@RequestBody LoginVo loginVo, HttpServletRequest request) {
//        TokenVo tokenVo = new TokenVo();
//        TokenClaim tokenClaim = new TokenClaim(23L, (long) MemberConst.OP_TYPE_MEMBER.intValue());
//        try {
//            String token = TokenUtil.getToken(tokenClaim);
//            if (loginVo.getUsername() != null && loginVo.getPassword() != null) {
//                if (loginVo.getUsername().equals("admin")&&loginVo.getPassword().equals("1111111")){
//                    tokenVo.setToken(token);
//                }
//            }
//            request.getSession().setAttribute("userInfo", loginVo);
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        return new Result<>(ApiResultEnum.SUCCESS, tokenVo);
//    }

    @RequestMapping(value = "user/detail", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "swagger测试接口")
    public Result<UserVo> userInfo() {
        UserVo userVo=new UserVo();
        userVo.setName("Super Admin");
        userVo.setRoles("aadf");
        userVo.setRoles("admin");
        userVo.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        LrzjlResultItem<UserVo> lrzjlResultItem= new LrzjlResultItem<>();
        lrzjlResultItem.setItem(userVo);
        lrzjlResultItem.setCode(RetCodeConsts.RET_OK);
        lrzjlResultItem.setMessage(RetCodeConsts.RET_OK_MSG);
        return getResult(lrzjlResultItem);
    }

    @RequestMapping(value = "article/list", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "swagger测试接口")
    public Result<List<ArticleVo>> tokenTest(@RequestBody QueryInfo queryInfo) {
        LrzjlResultList<ArticleVo> lrzjlResultList=new LrzjlResultList<>();
        Integer page = queryInfo.getPage();
        Integer cnt = queryInfo.getLimit();
        List<ArticleVo> articleVos;
        Integer offset;
        if (null != page && null != cnt) {
            offset = page * cnt;
            queryInfo.setOffset(offset);
            articleVos= checkData(queryInfo);
            lrzjlResultList.setItemList(articleVos);
            lrzjlResultList.setCount(articleVos.size());
        }
        return getResult(lrzjlResultList);
    }

    private ArrayList<ArticleVo> checkData(QueryInfo queryInfo) {
        ArrayList<ArticleVo> userVos = new ArrayList<>();
        for (int i = 0; i < queryInfo.getLimit(); i++) {
            ArticleVo articleVo = new ArticleVo();
            articleVo.setAuthor("作者" + i);
            articleVo.setReviewer("审核人" + i);
            articleVo.setImportance("1");
            articleVo.setForecast((Integer.toString(i)));
            articleVo.setPageviews(Integer.toString(10 * i));
            articleVo.setTitle("标题" + i);
            articleVo.setTimestamp(new Date().toString());
            articleVo.setType("CN");
            articleVo.setId(Long.parseLong(Integer.toString((queryInfo.getPage() * queryInfo.getLimit()) + (i + 1))));//id = ((Convert.ToInt32(queryInfo.page)* Convert.ToInt32(queryInfo.limit))+(i + 1)).ToString();
            articleVo.setDisplay_time(new Date().toString());
            articleVo.setStatus("published");
            userVos.add(articleVo);
        }
        return userVos;
    }

}
