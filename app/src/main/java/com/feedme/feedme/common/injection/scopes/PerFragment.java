package com.feedme.feedme.common.injection.scopes;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Athmos on 26/05/2017.
 */

@Scope
@Retention(RUNTIME)
public @interface PerFragment {
}
