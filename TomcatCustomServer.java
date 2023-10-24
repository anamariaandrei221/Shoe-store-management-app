package Proiect_ISI;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class TomcatCustomServer
{

    private final Tomcat tomcat;

    public TomcatCustomServer()
    {
        tomcat = new Tomcat();
        tomcat.setBaseDir("build/basedir");
        Context context = tomcat.addWebapp("", new File("src/main/resources/webapp/").getAbsolutePath());
        File additionWebInfClasses = new File("build/classes");
        WebResourceRoot resources = new StandardRoot(context);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes",
                additionWebInfClasses.getAbsolutePath(), "/"));
        context.setResources(resources);
        servletTest();
    }

    private void servletTest()
    {
        File contextPath = new File("build/context");
        contextPath.mkdir();
        Context context = tomcat.addContext("/servlet", contextPath.getAbsolutePath());
        Tomcat.addServlet(context, "hello", new HttpServlet()
        {
            @Override
            protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws IOException
            {
                System.out.println("REQUESTW AS MADE");
                resp.setStatus(HttpServletResponse.SC_OK);
                resp.getWriter().write("Hello world!");
                resp.getWriter().flush();
                resp.getWriter().close();
            }
        });
        context.addServletMappingDecoded("/", "hello");
    }

    public void start()
    {
        try
        {
            tomcat.start();
            await();
        }
        catch (LifecycleException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void await()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                tomcat.getServer().await();
            }
        }).start();
    }

    public void stop()
    {
        try
        {
            tomcat.stop();
        }
        catch (LifecycleException e)
        {
            throw new RuntimeException(e);
        }
    }
}
