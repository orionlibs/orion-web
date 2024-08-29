package io.github.orionlibs.orion_web.service.socket;

import io.github.orionlibs.orion_task_runner.OrionJob;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketConnectionBO implements OrionJob
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter output;
    private BufferedReader input;
    private int port;


    private SimpleSocketConnectionBO(int port)
    {
        this.port = port;
    }


    public static SimpleSocketConnectionBO of(int port)
    {
        return new SimpleSocketConnectionBO(port);
    }


    public void listenToPort() throws SocketException
    {
        try
        {
            this.serverSocket = new ServerSocket(port);
            while(true)
            {
                this.clientSocket = serverSocket.accept();
                this.output = new PrintWriter(clientSocket.getOutputStream(), true);
                this.input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            }
        }
        catch(IOException e)
        {
            throw new SocketException(e, "Problem with the socket in port '{}'", port);
        }
    }


    @Override
    public void run()
    {
        listenToPort();
    }


    public void stopListeningToPort() throws SocketException
    {
        try
        {
            input.close();
            output.close();
            clientSocket.close();
            serverSocket.close();
        }
        catch(IOException e)
        {
            throw new SocketException(e, "Problem with the closing socket in port '{}'", port);
        }
    }


    public int getPort()
    {
        return this.port;
    }


    public PrintWriter getOutput()
    {
        return this.output;
    }


    public BufferedReader getInput()
    {
        return this.input;
    }
}