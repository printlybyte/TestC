package com.lgd.conmoncore.net.builder;


import com.lgd.conmoncore.net.OkHttpUtils;
import com.lgd.conmoncore.net.request.OtherRequest;
import com.lgd.conmoncore.net.request.RequestCall;

/**
 * Created by zhy on 16/3/2.
 */
public class HeadBuilder extends GetBuilder
{
    @Override
    public RequestCall build()
    {
        return new OtherRequest(null, null, OkHttpUtils.METHOD.HEAD, url, tag, params, headers,id).build();
    }
}
