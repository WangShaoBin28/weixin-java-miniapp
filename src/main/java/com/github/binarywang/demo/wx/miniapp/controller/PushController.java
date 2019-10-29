package com.github.binarywang.demo.wx.miniapp.controller;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.api.WxMaTemplateService;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateData;
import cn.binarywang.wx.miniapp.bean.WxMaTemplateMessage;
import com.github.binarywang.demo.wx.miniapp.config.WxMaConfiguration;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Package com.github.binarywang.demo.wx.miniapp.controller
 * @ClassName PushController
 * @Author shaobin.wang
 * @Date 2019/10/28 22:36
 * @Version 1.0
 * @Description:
 **/
@RestController
@Slf4j
public class PushController {

    @GetMapping("/push")
    public String push(@RequestParam String appid, @RequestParam String openid, @RequestParam String formid) {
        openid = "oNb_54uWVxTwekG7K5zxGuAA3lsU";
        appid = "wx629e696936701bbb";
        final WxMaService wxService = WxMaConfiguration.getMaService(appid);
        List<WxMaTemplateData> wxMaTemplateData = new ArrayList<>();
        WxMaTemplateData wxMaTemplateData1 = new WxMaTemplateData("keyword1", "TNT炸药制造");
        WxMaTemplateData wxMaTemplateData2 = new WxMaTemplateData("keyword2", "2019-08-19 08:00");
        WxMaTemplateData wxMaTemplateData3 = new WxMaTemplateData("keyword3", "物品物品");
        WxMaTemplateData wxMaTemplateData4 = new WxMaTemplateData("keyword4", "12312312321312");
        wxMaTemplateData.add(wxMaTemplateData1);
        wxMaTemplateData.add(wxMaTemplateData2);
        wxMaTemplateData.add(wxMaTemplateData3);
        wxMaTemplateData.add(wxMaTemplateData4);

        WxMaTemplateMessage build = WxMaTemplateMessage.builder()
            .toUser(openid) //要推送的用户openid
            .formId(formid)//收集到的formid
            .templateId("S7xUSECt8_uWExwEJYyCKRl7fUPokeUj80OjAFUVq_o")//推送模板的id
            .data(wxMaTemplateData)//模板消息
            .page("pages/index/index")//要跳转的页面
            .build();

        try {
            wxService.getMsgService().sendTemplateMsg(build);
        } catch (WxErrorException e) {
            log.info("推送消息失败");
            e.printStackTrace();
        }
        return "推送成功";
    }
}
