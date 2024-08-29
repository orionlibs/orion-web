package io.github.orionlibs.orion_web.filter;

import io.github.orionlibs.orion_object.UUIDSecurityService;

public class JavaThreadIDGenerator
{
    static void generateThreadID()
    {
        Thread.currentThread()
                        .setName(UUIDSecurityService.generate2UUIDsWithoutHyphens() + "-" + Long.toString(System.nanoTime()));
    }
}