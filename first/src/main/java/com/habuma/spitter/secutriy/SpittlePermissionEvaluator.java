package com.habuma.spitter.secutriy;

import com.habuma.spitter.domain.Spitter;
import com.habuma.spitter.domain.Spittle;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

import java.io.Serializable;

public class SpittlePermissionEvaluator implements PermissionEvaluator {

    public boolean hasPermission(Authentication authentication, Object target, Object permission) {
        if (target instanceof Spittle) {
            Spittle spittle = (Spittle) target;
            if ("delete".equals(permission)) {
                return spittle.getSpitter().getUsername().equals(
                        authentication.getName()) || hasProfanity(spittle);
            }
        }
        throw new UnsupportedOperationException("hasPermission not supported for object <"
                + target + "> and permission <" + permission + ">");
    }

    public boolean hasPermission(Authentication authentication,
                                 Serializable targetId,
                                 String targetType,
                                 Object permission) {
        throw new UnsupportedOperationException();
    }

    private boolean hasProfanity(Spittle spittle) {
        return false;
    }
}
