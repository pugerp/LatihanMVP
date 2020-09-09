package com.example.latihanmvp.di.annotation;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;
import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.CLASS;

@Scope
@Retention(CLASS)
public @interface PerActivity {
}
