package se.microcode.confluence.plugin.googleservices.xhtml.blogger;

import com.atlassian.cache.Cache;
import com.atlassian.confluence.content.render.xhtml.ConversionContext;
import com.atlassian.confluence.macro.Macro;
import com.atlassian.confluence.macro.MacroExecutionException;
import com.opensymphony.webwork.ServletActionContext;
import se.microcode.base.ArgumentParser;
import se.microcode.base.ArgumentResolver;
import se.microcode.confluence.plugin.googleservices.PluginHelper;
import se.microcode.confluence.plugin.googleservices.base.blogger.BloggerMacroArguments;
import se.microcode.google.blogger.PostFeed;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public class BloggerMacro implements Macro
{
    public BodyType getBodyType()
    {
        return BodyType.NONE;
    }

    public OutputType getOutputType()
    {
        return OutputType.BLOCK;
    }

    private BloggerHelper bloggerHelper;

    public BloggerMacro()
    {
        this.bloggerHelper = new BloggerHelper();
    }

    public String execute(Map<String,String> params, String body, ConversionContext conversionContext) throws MacroExecutionException
    {
        BloggerMacroArguments args = (BloggerMacroArguments) ArgumentParser.parse(new BloggerMacroArguments(), params, new ArgumentResolver()
            {
                @Override
                public String get(String s)
                {
                    HttpServletRequest request = ServletActionContext.getRequest();
                    return request != null ? request.getParameter(s) : null;
                }
            });


        if (args.id == null)
        {
            throw new MacroExecutionException("Blog id not specified");
        }

        Cache cache = PluginHelper.getCache("se.microcode.confluence.plugin.blogger");

        PostFeed blogFeed;
        try
        {
            blogFeed = bloggerHelper.getBlogPosts(args.id, args.labels, cache, args.timeout);
        }
        catch (IOException e)
        {
            throw new MacroExecutionException(e.toString());
        }

        StringBuilder builder = new StringBuilder();

        if(blogFeed != null && blogFeed.posts != null)
        {
            builder.append(bloggerHelper.renderPostFeed(blogFeed, args));
        }

        return builder.toString();
    }
}