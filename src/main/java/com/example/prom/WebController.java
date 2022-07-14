/*
 * $
 *
 * Copyright (c) 2022  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
 */
package com.example.prom;


import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.reactivex.Flowable;

/**
 * @author vagrant
 * @version $ 7/14/22
 */
@Controller("/observemetric")
public class WebController {
    @Post
    public Flowable<HttpResponse> post(@Body ObjReq objReq) {
        return Flowable.fromCallable(() -> HttpResponse.ok(String.format("Hi %s", objReq.getName())));
    }

    public static class ObjReq {
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
