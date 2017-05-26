package com.feedme.feedme.common.injection.scopes;

/**
 * Created by Athmos on 26/05/2017.
 */

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Scope
@Retention(RUNTIME)
public @interface PerActivity {
}

