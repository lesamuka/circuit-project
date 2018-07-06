/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.annotations.exemplo1;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


public class Annotations {

    @Retention(RetentionPolicy.SOURCE)
    @interface RetentionSource {
        Class type();
        String method();
    }

    @Retention(RetentionPolicy.CLASS)
    @interface RetentionClass {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @interface RetentionRuntime {
    }

    public static void main(String[] args) {
        @RetentionSource(type=B.class, method="updateContact")
        class B {

 
        }
        assert B.class.getAnnotations().length == 0;

        @RetentionClass
        class C {
        }
        assert C.class.getAnnotations().length == 0;

        @RetentionRuntime
        class D {
        }
        assert D.class.getAnnotations().length == 1;
    }
}
