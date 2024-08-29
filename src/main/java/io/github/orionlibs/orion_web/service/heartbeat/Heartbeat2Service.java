package io.github.orionlibs.orion_web.service.heartbeat;

import io.github.orionlibs.orion_assert.Assert;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Heartbeat2Service
{
    public boolean isServerAlive() throws UnknownHostException, IOException
    {
        return isServerAlive("localhost");
    }


    public boolean isServerAlive(String hostName) throws UnknownHostException, IOException
    {
        Assert.notEmpty(hostName, "The hostName input cannot be null/empty.");
        InetAddress host = InetAddress.getByName(hostName);
        return host.isReachable(3000);
    }


    public boolean isServerAlive(byte[] IPAddress) throws UnknownHostException, IOException
    {
        Assert.hasLength(IPAddress, 4, "The IPAddress input has to have length 4.");
        InetAddress host = InetAddress.getByAddress(IPAddress);
        return host.isReachable(3000);
    }


    public boolean isServerAlive(String hostName, byte[] IPAddress) throws UnknownHostException, IOException
    {
        Assert.notEmpty(hostName, "The hostName input cannot be null/empty.");
        Assert.hasLength(IPAddress, 4, "The IPAddress input has to have length 4.");
        InetAddress host = InetAddress.getByAddress(hostName, IPAddress);
        return host.isReachable(3000);
    }
}